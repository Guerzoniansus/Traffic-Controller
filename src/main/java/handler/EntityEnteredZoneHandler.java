package handler;

import controller.Controller;
import message.*;
import traffic.BoatRoute;
import traffic.LightState;

/**
 * Entity entered zone handler
 */
public class EntityEnteredZoneHandler {

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
    public void handle(EntityEnteredZoneMessage message) {
        Controller controller = Controller.getInstance();

        int routeId = message.getRouteId();

        System.out.println("Entity entered zone at route id " + message.getRouteId() + " with sensor id " + message.getSensorId());
        controller.getRoute(routeId).addEntity();

        if (BoatRoute.BOAT_ROUTES.contains(routeId) &&
                controller.getBridge().isClosed() && controller.getBridge().isProcessing() == false) {
            controller.setCurrentBoatRouteToBeGreen((BoatRoute) controller.getRoute(routeId));
            controller.getBridge().startProcessing();

            OutgoingMessage warningLightStateMessage = new SetBridgeWarningLightStateMessage(LightState.ON);
            controller.sendMessage(warningLightStateMessage);

            OutgoingMessage requestBridgeSensorMessage = new RequestBridgeRoadEmptyMessage();
            controller.sendMessage(requestBridgeSensorMessage);
        }
    }

}
