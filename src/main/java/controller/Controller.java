package controller;

import message.OutgoingMessage;
import socket.WebsocketClient;
import traffic.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private static Controller INSTANCE;

    private final static String BROKER_URI = "ws://keyslam.com:8080";
            // "ws://localhost:8080/chat/bob"; // "ws://keyslam.com:8080";

    private WebsocketClient websocketClient;

    private boolean running = false;

    private List<Route> routes;

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

    public void start() {
        setupRoutes();

        running = true;

        ArrayList<Integer> trafficLightsSetOne = new ArrayList<>(Arrays.asList(4, 5, 10, 11, 33, 34));

        long twelveSeconds = 1000 * 12;
        long tenSeconds = 1000 * 10;
        long fourSeconds = 1000 * 4;

        try {
            Thread.sleep(tenSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        routes.forEach(route -> {
            route.setPositive();
            notifyRouteStateChange(route);
        });

        try {
            Thread.sleep(tenSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        routes.forEach(route -> {
            route.setWarning();
            notifyRouteStateChange(route);
        });

        try {
            Thread.sleep(tenSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        routes.forEach(route -> {
            if (greens.contains(route.getRouteId())) {
                route.setPositive();
            }

            else route.setNegative();

            notifyRouteStateChange(route);
        });
    }

    private void notifyRouteStateChange(Route route) {
        websocketClient.send(route.createSetRouteStateMessage());
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
        for (int i = 41; i <= 42; i++) {
            Route route = new BoatRoute(i);
            routes.add(route);
        }

        routes.forEach(route -> route.addRouteListener(() -> notifyRouteStateChange(route)));
    }

    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();

        }
        return INSTANCE;
    }
}