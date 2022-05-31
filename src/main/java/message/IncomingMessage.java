package message;

/**
 * Incoming message interface
 */
public interface IncomingMessage {

    /**
     * Force this object to do tell the supplied handler what to do
     *
     * @param handler the handler to command
     */
    void acceptHandler(MessageHandler handler);
}
