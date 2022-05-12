package message;

public class ErrorInvalidStateMessage extends Message implements IncomingMessage {

    String receivedMessage;
    String error;

    public ErrorInvalidStateMessage(String receivedMessage, String error) {
        this.receivedMessage = receivedMessage;
        this.error = error;
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }

    public String getError() {
        return error;
    }

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleErrorInvalidStateMessage(this);
    }
}
