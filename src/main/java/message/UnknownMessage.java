package message;

public class UnknownMessage extends Message implements IncomingMessage {

    public void acceptHandler(MessageHandler handler) {
        handler.handleUnknownMessage(this);
    }
}
