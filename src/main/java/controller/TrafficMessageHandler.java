package controller;

import handler.*;
import message.*;

/**
 * Default message handler for the traffic simulation
 */
public class TrafficMessageHandler implements MessageHandler {


    SessionStartHandler sessionStartHandler;
    EntityEnteredZoneHandler entityEnteredZoneHandler;
    EntityExitedZoneHandler entityExitedZoneHandler;
    AcknowledgeBridgeStateHandler acknowledgeBridgeStateHandler;
    AcknowledgeBarriersStateHandler acknowledgeBarriersStateHandler;
    AcknowledgeBridgeRoadEmptyHandler acknowledgeBridgeRoadEmptyHandler;
    AcknowledgeBridgeWaterEmptyHandler acknowledgeBridgeWaterEmptyHandler;
    ErrorInvalidStateHandler errorInvalidStateHandler;

    /**
     * Traffic message handler constructor
     */
    public TrafficMessageHandler() {
        sessionStartHandler = new SessionStartHandler();
        entityEnteredZoneHandler = new EntityEnteredZoneHandler();
        entityExitedZoneHandler = new EntityExitedZoneHandler();
        acknowledgeBridgeStateHandler = new AcknowledgeBridgeStateHandler();
        acknowledgeBarriersStateHandler = new AcknowledgeBarriersStateHandler();
        acknowledgeBridgeRoadEmptyHandler = new AcknowledgeBridgeRoadEmptyHandler();
        acknowledgeBridgeWaterEmptyHandler = new AcknowledgeBridgeWaterEmptyHandler();
        errorInvalidStateHandler = new ErrorInvalidStateHandler();
    }

    public void handleIncomingMessage(IncomingMessage message) {
        message.acceptHandler(this);
    }

    public void handleOutgoingMessage(OutgoingMessage message) {
        // TODO
    }

    public void handleSessionStartMessage(SessionStartMessage message) {
        sessionStartHandler.handle(message);
    }

    public void handleEntityEnteredZoneMessage(EntityEnteredZoneMessage message) {
        entityEnteredZoneHandler.handle(message);
    }

    public void handleEntityExitedZoneMessage(EntityExitedZoneMessage message) {
        entityExitedZoneHandler.handle(message);
    }

    public void handleAcknowledgeBridgeStateMessage(AcknowledgeBridgeStateMessage message) {
        acknowledgeBridgeStateHandler.handle(message);
    }

    public void handleAcknowledgeBarriersStateMessage(AcknowledgeBarriersStateMessage message) {
        acknowledgeBarriersStateHandler.handle(message);
    }

    public void handleAcknowledgeBridgeRoadEmptyMessage(AcknowledgeBridgeRoadEmptyMessage message) {
        acknowledgeBridgeRoadEmptyHandler.handle(message);
    }

    public void handleAcknowledgeBridgeWaterEmptyMessage(AcknowledgeBridgeWaterEmptyMessage message) {
        acknowledgeBridgeWaterEmptyHandler.handle(message);
    }

    @Override
    public void handleErrorInvalidStateMessage(ErrorInvalidStateMessage message) {
        errorInvalidStateHandler.handle(message);
    }

    public void handleUnknownMessage(UnknownMessage message) {
        // TODO
    }
}
