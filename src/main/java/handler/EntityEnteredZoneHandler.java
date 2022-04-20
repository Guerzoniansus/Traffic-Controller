package handler;

import controller.Controller;
import message.EntityEnteredZoneMessage;

public class EntityEnteredZoneHandler {

    public void handle(EntityEnteredZoneMessage message) {
        System.out.println("Entity entered zone at route id " + message.getRouteId() + " with sensor id " + message.getSensorId());
        Controller.getInstance().getRoute(message.getRouteId()).addEntity();
    }

}
