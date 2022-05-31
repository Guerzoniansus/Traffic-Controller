package message;

/**
 * Error invalid state message
 */
public class ErrorInvalidStateMessage extends Message implements IncomingMessage {


    String receivedMessage;
    String error;

    /**
     * Error invalid state message constructor
     *
     * @param receivedMessage The message that was originally sent and rejected
     * @param error           The reason why the message was rejected
     */
    public ErrorInvalidStateMessage(String receivedMessage, String error) {
        this.receivedMessage = receivedMessage;
        this.error = error;
    }

    /**
     * Gets the message that was originally sent and rejected
     *
     * @return the  message
     */
    public String getReceivedMessage() {
        return receivedMessage;
    }

    /**
     * Gets the reason why the message was rejected
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleErrorInvalidStateMessage(this);
    }
}
