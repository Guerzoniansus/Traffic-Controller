package controller;

import message.OutgoingMessage;
import socket.WebsocketClient;
import traffic.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    private static Controller INSTANCE;

    private final static String BROKER_URI = "ws://keyslam.com:8080";
            // "ws://localhost:8080/chat/bob"; // "ws://keyslam.com:8080";

    protected final static long ORANGE_DURATION = 1000 * 3;
    protected final static long COOLDOWN_DURATION = 1000 * 3;
    protected final static long GREEN_AND_RED_DURATION = 1000*8;

    private final static ImpossibleRoutes IMPOSSIBLE_ROUTES = new ImpossibleRoutes();

    private WebsocketClient websocketClient;

    private boolean running = false;

    private List<Route> routes;
    private Bridge bridge;
    private BoatRoute currentBoatRouteToBeGreen;

    private Controller() {}

    public void setup() {
        try {
            websocketClient = new WebsocketClient(new URI(BROKER_URI), new TrafficMessageHandler());
            websocketClient.connect();
        } catch (URISyntaxException e) {
            System.err.println("URISyntaxException exception: " + e.getMessage());
            System.exit(1);
        }
    }

    void doTrafficLightCycle() {
        List<Route> routesToTurnGreen = new ArrayList<>();
        List<Integer> greenRouteIds = new ArrayList<>();


        // Turn stuff to orange while determining which ones should become green

        routes.stream().sorted(Comparator.comparing(Route::getPriority).reversed()).forEach(route -> {
            if (route instanceof BoatRoute) {
                if (bridge.isClosed()) {
                    return;
                }
                if (bridge.isOpen() && bridge.isProcessing()) {
                    return;
                }
            }

            boolean possibleRoute = Collections.disjoint(greenRouteIds, IMPOSSIBLE_ROUTES.getImpossibleRoutes(route.getRouteId()));

            if (possibleRoute && route.hasEntities()) {
                if (route.isNegative() || route.isPositive()) {
                    greenRouteIds.add(route.getRouteId());

                    if (route.isNegative()) {
                        routesToTurnGreen.add(route);
                    }
                }
            }

            else {
                if (route.isPositive()) {
                    route.setWarning();
                }

                if (route.isNegative() && route.hasEntities()) {
                    route.increasePriority();
                }
            }
        });

        try {
            Thread.sleep(ORANGE_DURATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Turn lights red

        routes.stream().filter(route -> route.isWarning()).forEach(route -> {
            route.setNegative();
            route.increasePriority();
        });

        try {
            Thread.sleep(COOLDOWN_DURATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Turn lights to green

        routesToTurnGreen.forEach(route -> {
            route.setPositive();
            route.resetPriority();
        });

    }

    public void start() {
        setupRoutes();
        bridge = new Bridge();
        currentBoatRouteToBeGreen = null;

        running = true;

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                doTrafficLightCycle();
            }
        }, 0, GREEN_AND_RED_DURATION + ORANGE_DURATION + COOLDOWN_DURATION);
    }

    public Route getRoute(int routeId) {
        return routes.stream().filter(route -> route.getRouteId() == routeId).findFirst().get();
    }

    public Bridge getBridge() {
        return bridge;
    }

    public List<Route> getBoatRoutes() {
        return routes.stream().filter(route -> route instanceof BoatRoute).collect(Collectors.toList());
    }

    public void setCurrentBoatRouteToBeGreen(BoatRoute boatRoute) {
        this.currentBoatRouteToBeGreen = boatRoute;
    }

    public BoatRoute getCurrentBoatRouteToBeGreen() {
        return currentBoatRouteToBeGreen;
    }

    private void notifyRouteStateChange(Route route) {
        sendMessage(route.createSetRouteStateMessage());
    }

    public void sendMessage(OutgoingMessage message) {
        websocketClient.send(message.toJson());
    }

    private void setupRoutes() {
        routes = new ArrayList<>();

        // Cars
        for (int i = 1; i <= 12; i++) {
            if (i == 6) continue; // This route does not exist

            Route route = new AutomobileRoute(i);
            routes.add(route);
        }

        {
            Route route = new AutomobileRoute(15);
            routes.add(route);
        }

        // Cyclists
        for (int i = 21; i <= 24; i++) {
            Route route = new CyclistRoute(i);
            routes.add(route);
        }

        // Pedestrians
        for (int i = 31; i <= 38; i++) {
            Route route = new PedestrianRoute(i);
            routes.add(route);
        }

        // Boat
        {
            routes.add(new BoatRoute(41));
            routes.add(new BoatRoute(42));
        }

        routes.forEach(route -> route.addRouteListener((x) -> notifyRouteStateChange(x)));
    }

    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();

        }
        return INSTANCE;
    }
}