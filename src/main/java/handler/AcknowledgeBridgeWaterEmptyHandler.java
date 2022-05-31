package handler;

import controller.Controller;
import message.AcknowledgeBridgeWaterEmptyMessage;
import message.OutgoingMessage;
import message.RequestBridgeStateMessage;
import message.RequestBridgeWaterEmptyMessage;
import traffic.PhysicalState;

/**
 * Acknowledge bridge water empty handler
 */
public class AcknowledgeBridgeWaterEmptyHandler {

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
    public void handle(AcknowledgeBridgeWaterEmptyMessage message) {
        Controller controller = Controller.getInstance();

        if (controller.getBridge().isOpen()) {

            int amountOfWaitingBoats = (int) controller.getBoatRoutes().stream()
                    .filter(route -> route.getAmountOfEntities() > 0)
                    .count();

            if (amountOfWaitingBoats > 0) {
                OutgoingMessage outgoingMessage = new RequestBridgeWaterEmptyMessage();
                controller.sendMessage(outgoingMessage);
            }

            else {
                controller.getBridge().startProcessing();

                controller.getBoatRoutes().forEach(route -> {
                    if (route.isNegative() == false) {
                        route.setNegative();
                    }
                });
                controller.setCurrentBoatRouteToBeGreen(null);

                OutgoingMessage outgoingMessage = new RequestBridgeStateMessage(PhysicalState.DOWN);
                controller.sendMessage(outgoingMessage);
            }
        }
    }
}
