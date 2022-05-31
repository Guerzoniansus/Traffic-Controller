package message;

/**
 * Outgoing message interface
 */
public interface OutgoingMessage {

    /**
     * Convert this Message class to a JSON format
     *
     * @return a String object in JSON format
     */
    String toJson();
}
