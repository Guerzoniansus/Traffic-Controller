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

            controller.getCurrentBoatRouteToBeGreen().removeEntity();
            controller.getCurrentBoatRouteToBeGreen().setNegative();
            controller.setCurrentBoatRouteToBeGreen(null);

            OutgoingMessage outgoingMessage = new RequestBridgeStateMessage(PhysicalState.DOWN);
            controller.sendMessage(outgoingMessage);
        }
    }
}
