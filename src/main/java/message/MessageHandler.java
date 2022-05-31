package message;

/**
 * Message handler interface
 */
public interface MessageHandler {

    /**
     * Handle incoming message
     *
     * @param message message to handle
     */
    void handleIncomingMessage(IncomingMessage message);

    /**
     * Handle outgoing message
     *
     * @param message message to handle
     */
    void handleOutgoingMessage(OutgoingMessage message);

    /**
     * Handle session start message
     *
     * @param message message to handle
     */
    void handleSessionStartMessage(SessionStartMessage message);

    /**
     * Handle entity entered zone message
     *
     * @param message message to handle
     */
    void handleEntityEnteredZoneMessage(EntityEnteredZoneMessage message);

    /**
     * Handle entity exited zone message
     *
     * @param message message to handle
     */
    void handleEntityExitedZoneMessage(EntityExitedZoneMessage message);

    /**
     * Handle unknown message
     *
     * @param message message to handle
     */
    void handleUnknownMessage(UnknownMessage message);

    /**
     * Handle acknowledge bridge state message
     *
     * @param message message to handle
     */
    void handleAcknowledgeBridgeStateMessage(AcknowledgeBridgeStateMessage message);

    /**
     * Handle acknowledge barriers state message
     *
     * @param message message to handle
     */
    void handleAcknowledgeBarriersStateMessage(AcknowledgeBarriersStateMessage message);

    /**
     * Handle acknowledge bridge road empty message
     *
     * @param message message to handle
     */
    void handleAcknowledgeBridgeRoadEmptyMessage(AcknowledgeBridgeRoadEmptyMessage message);

    /**
     * Handle acknowledge bridge water empty message
     *
     * @param message message to handle
     */
    void handleAcknowledgeBridgeWaterEmptyMessage(AcknowledgeBridgeWaterEmptyMessage message);

    /**
     * Handle error invalid state message
     *
     * @param message message to handle
     */
    void handleErrorInvalidStateMessage(ErrorInvalidStateMessage message);
}
