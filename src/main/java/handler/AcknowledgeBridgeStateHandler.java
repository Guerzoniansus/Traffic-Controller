package handler;

import controller.Controller;
import message.AcknowledgeBridgeStateMessage;
import message.OutgoingMessage;
import message.RequestBarriersStateMessage;
import message.RequestBridgeWaterEmptyMessage;
import traffic.Bridge;
import traffic.PhysicalState;

/**
 * Acknowledge bridge state handler
 */
public class AcknowledgeBridgeStateHandler {

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
    public void handle(AcknowledgeBridgeStateMessage message) {
        Controller controller = Controller.getInstance();
        Bridge bridge = controller.getBridge();

        if (message.getState() == PhysicalState.UP) {
            if (bridge.isClosed() && bridge.isProcessing()) {
                bridge.open();

                controller.getCurrentBoatRouteToBeGreen().setPositive();

                OutgoingMessage outgoingMessage = new RequestBridgeWaterEmptyMessage();
                controller.sendMessage(outgoingMessage);
            }
        }

        else if (message.getState() == PhysicalState.DOWN) {
            if (bridge.isOpen() && bridge.isProcessing()) {
                bridge.close();

                OutgoingMessage outgoingMessage = new RequestBarriersStateMessage(PhysicalState.UP);
                controller.sendMessage(outgoingMessage);
            }
        }
    }
}
