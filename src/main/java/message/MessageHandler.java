package message;

public interface MessageHandler {
    void handleIncomingMessage(IncomingMessage message);
    void handleOutgoingMessage(OutgoingMessage message);
    void handleSessionStartMessageMessage(SessionStartMessage message);
    void handleEntityEnteredZoneMessageMessage(EntityEnteredZoneMessage message);
    void handleUnknownMessage(UnknownMessage message);
}
