package handler;

import controller.Controller;
import message.EntityExitedZoneMessage;

public class EntityExitedZoneHandler {
    public void handle(EntityExitedZoneMessage message) {
        System.out.println("Entity exited zone at route id " + message.getRouteId() + " with sensor id " + message.getSensorId());
        Controller.getInstance().getRoute(message.getRouteId()).removeEntity();
    }
}
