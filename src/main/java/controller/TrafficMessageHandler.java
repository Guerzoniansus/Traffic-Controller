package controller;

import handler.EntityEnteredZoneHandler;
import handler.EntityExitedZoneHandler;
import handler.SessionStartHandler;
import message.*;

public class TrafficMessageHandler implements MessageHandler {

    public void handleIncomingMessage(IncomingMessage message) {
        message.acceptHandler(this);
    }

    public void handleOutgoingMessage(OutgoingMessage message) {
        // TODO
    }

    public void handleSessionStartMessageMessage(SessionStartMessage message) {
        new SessionStartHandler().handle(message);
    }

    public void handleEntityEnteredZoneMessageMessage(EntityEnteredZoneMessage message) {
        new EntityEnteredZoneHandler().handle(message);
    }

    @Override
    public void handleEntityExitedZoneMessageMessage(EntityExitedZoneMessage message) {
        new EntityExitedZoneHandler().handle(message);
    }

    public void handleUnknownMessage(UnknownMessage message) {
        // TODO
    }
}
