package message;

/**
 * Session start message. Sent by the broker when a session has been started.
 */
public class SessionStartMessage extends Message implements IncomingMessage {

    public void acceptHandler(MessageHandler handler) {
        handler.handleSessionStartMessage(this);
    }
}
