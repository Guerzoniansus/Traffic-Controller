package handler;

import message.EntityEnteredZoneMessage;

public class EntityEnteredZoneHandler {

    public void handle(EntityEnteredZoneMessage message) {
        // TODO
        System.out.println("Entity entered zone at route id " + message.getRouteId() + " with sensor id " + message.getSensorId());
    }

}
