package controller;

import handler.EntityEnteredZoneHandler;
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

    public void handleUnknownMessage(UnknownMessage message) {
        // TODO
    }
}
