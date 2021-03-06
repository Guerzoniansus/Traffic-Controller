package socket;

import message.ConnectControllerMessage;
import message.IncomingMessage;
import message.MessageHandler;
import message.OutgoingMessage;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

// Code from: https://stackoverflow.com/questions/26452903/javax-websocket-client-simple-example
// The code is slightly modified to suit this project

/**
 * Websocket client used to send and receive messages
 */
public class WebsocketClient extends WebSocketClient {

    private final static String SESSION_NAME = "groep5";

    private final static Logger LOGGER = Logger.getLogger(MessageDecoder.class.getName());

    private MessageHandler messageHandler;
    private MessageDecoder decoder;

    /**
     * Websocket client constructor
     *
     * @param uri            the URI to connect to
     * @param messageHandler the object that will handle the incoming message
     */
    public WebsocketClient(URI uri, MessageHandler messageHandler) {
        super(uri);
        this.messageHandler = messageHandler;
        this.decoder = new MessageDecoder();
    }

    @Override
    public void send(String message) {
        LOGGER.info(" Sending: " + message);
        super.send(message);
    }

    /**
     * Send an OutgoingMessage
     *
     * @param message the message to send
     */
    public void send(OutgoingMessage message) {
        send(message.toJson());
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        LOGGER.info("Opening websocket");
        send(new ConnectControllerMessage(SESSION_NAME).toJson());
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        LOGGER.info("Closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(String message) {
        LOGGER.info("Received message: " + message);

        IncomingMessage messageObject = (IncomingMessage) MessageDecoder.decodeMessage(message);
        messageHandler.handleIncomingMessage(messageObject);
    }

    @Override
    public void onMessage(ByteBuffer message) {
        System.out.println("received ByteBuffer");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("an error occurred:" + ex);
    }
}
