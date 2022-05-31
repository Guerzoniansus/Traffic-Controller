package handler;

import controller.Controller;
import message.EntityExitedZoneMessage;

/**
 * Entity exited zone handler
 */
public class EntityExitedZoneHandler {

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
    public void handle(EntityExitedZoneMessage message) {
        System.out.println("Entity exited zone at route id " + message.getRouteId() + " with sensor id " + message.getSensorId());
        Controller.getInstance().getRoute(message.getRouteId()).removeEntity();
    }
}
