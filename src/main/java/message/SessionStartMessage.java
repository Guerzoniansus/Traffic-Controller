package message;

public class SessionStartMessage extends Message implements IncomingMessage {

    public void acceptHandler(MessageHandler handler) {
        handler.handleSessionStartMessageMessage(this);
    }
}
