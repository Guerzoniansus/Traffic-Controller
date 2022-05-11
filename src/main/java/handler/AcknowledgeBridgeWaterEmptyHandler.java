package handler;

import controller.Controller;
import message.AcknowledgeBridgeWaterEmptyMessage;
import message.OutgoingMessage;
import message.RequestBridgeStateMessage;
import traffic.PhysicalState;

public class AcknowledgeBridgeWaterEmptyHandler {
    public void handle(AcknowledgeBridgeWaterEmptyMessage message) {
        Controller controller = Controller.getInstance();

        if (controller.getBridge().isOpen()) {
            controller.getBridge().startProcessing();

            controller.getBoatRoutes().forEach(route -> {
                route.removeEntity();
                route.setNegative();
            });

            OutgoingMessage outgoingMessage = new RequestBridgeStateMessage(PhysicalState.DOWN);
        }
    }
}
