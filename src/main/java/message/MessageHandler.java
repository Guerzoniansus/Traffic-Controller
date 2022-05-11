package message;

public interface MessageHandler {
    void handleIncomingMessage(IncomingMessage message);
    void handleOutgoingMessage(OutgoingMessage message);
    void handleSessionStartMessageMessage(SessionStartMessage message);
    void handleEntityEnteredZoneMessageMessage(EntityEnteredZoneMessage message);
    void handleEntityExitedZoneMessageMessage(EntityExitedZoneMessage message);
    void handleUnknownMessage(UnknownMessage message);
    void handleAcknowledgeBridgeStateMessage(AcknowledgeBridgeStateMessage message);
    void handleAcknowledgeBarriersStateMessage(AcknowledgeBarriersStateMessage message);
    void handleAcknowledgeBridgeRoadEmptyMessage(AcknowledgeBridgeRoadEmptyMessage message);
    void handleAcknowledgeBridgeWaterEmptyMessage(AcknowledgeBridgeWaterEmptyMessage message);
}
