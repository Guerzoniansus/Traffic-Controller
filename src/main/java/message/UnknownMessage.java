package message;

/**
 * Unknown message. When an incoming message is not recognized, it gets turned into this class.
 */
public class UnknownMessage extends Message implements IncomingMessage {

    public void acceptHandler(MessageHandler handler) {
        handler.handleUnknownMessage(this);
    }
}
