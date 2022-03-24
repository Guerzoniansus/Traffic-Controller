package controller;

import message.OutgoingMessage;
import socket.WebsocketClient;

import java.net.URI;
import java.net.URISyntaxException;

public class Controller {

    private static Controller INSTANCE;

    private final static String BROKER_URI = "ws://localhost:8080/chat/bob"; // "ws://keyslam.com:8080";

    private WebsocketClient websocketClient;

    private boolean running = false;

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
        running = true;
    }

    public void sendMessage(OutgoingMessage message) {
        websocketClient.send(message.toJson());
    }

    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();

        }
        return INSTANCE;
    }
}
