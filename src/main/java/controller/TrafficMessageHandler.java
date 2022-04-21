package controller;

import handler.EntityEnteredZoneHandler;
import handler.EntityExitedZoneHandler;
import handler.SessionStartHandler;
import message.*;

import javax.swing.text.html.parser.Entity;

public class TrafficMessageHandler implements MessageHandler {

    SessionStartHandler sessionStartHandler;
    EntityEnteredZoneHandler entityEnteredZoneHandler;
    EntityExitedZoneHandler entityExitedZoneHandler;

    public TrafficMessageHandler() {
        sessionStartHandler = new SessionStartHandler();
        entityEnteredZoneHandler = new EntityEnteredZoneHandler();
        entityExitedZoneHandler = new EntityExitedZoneHandler();
    }

    public void handleIncomingMessage(IncomingMessage message) {
        message.acceptHandler(this);
    }

    public void handleOutgoingMessage(OutgoingMessage message) {
        // TODO
    }

    public void handleSessionStartMessageMessage(SessionStartMessage message) {
        sessionStartHandler.handle(message);
    }

    public void handleEntityEnteredZoneMessageMessage(EntityEnteredZoneMessage message) {
        entityEnteredZoneHandler.handle(message);
    }

    @Override
    public void handleEntityExitedZoneMessageMessage(EntityExitedZoneMessage message) {
        entityExitedZoneHandler.handle(message);
    }

    public void handleUnknownMessage(UnknownMessage message) {
        // TODO
    }
}
