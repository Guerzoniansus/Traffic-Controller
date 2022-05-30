package message;

public interface MessageHandler {
    void handleIncomingMessage(IncomingMessage message);
    void handleOutgoingMessage(OutgoingMessage message);
    void handleSessionStartMessage(SessionStartMessage message);
    void handleEntityEnteredZoneMessage(EntityEnteredZoneMessage message);
    void handleEntityExitedZoneMessage(EntityExitedZoneMessage message);
    void handleUnknownMessage(UnknownMessage message);
    void handleAcknowledgeBridgeStateMessage(AcknowledgeBridgeStateMessage message);
    void handleAcknowledgeBarriersStateMessage(AcknowledgeBarriersStateMessage message);
    void handleAcknowledgeBridgeRoadEmptyMessage(AcknowledgeBridgeRoadEmptyMessage message);
    void handleAcknowledgeBridgeWaterEmptyMessage(AcknowledgeBridgeWaterEmptyMessage message);
    void handleErrorInvalidStateMessage(ErrorInvalidStateMessage message);
}
