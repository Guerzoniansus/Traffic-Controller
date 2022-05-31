package handler;

import controller.Controller;
import message.AcknowledgeBarriersStateMessage;
import message.OutgoingMessage;
import message.RequestBridgeStateMessage;
import message.SetBridgeWarningLightStateMessage;
import traffic.BoatRoute;
import traffic.LightState;
import traffic.PhysicalState;
import traffic.Route;

/**
 * Acknowledge barriers state handler
 */
public class AcknowledgeBarriersStateHandler {

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
    public void handle(AcknowledgeBarriersStateMessage message) {
        Controller controller = Controller.getInstance();

        if (message.getState() == PhysicalState.DOWN) {
            if (controller.getBridge().isClosed() && controller.getBridge().isProcessing()) {
                controller.getCurrentBoatRouteToBeGreen().setWarning();

                OutgoingMessage outgoingMessage = new RequestBridgeStateMessage(PhysicalState.UP);
                controller.sendMessage(outgoingMessage);
            }
        }

        else if (message.getState() == PhysicalState.UP) {
            OutgoingMessage outgoingMessage = new SetBridgeWarningLightStateMessage(LightState.OFF);
            controller.sendMessage(outgoingMessage);
        }
    }
}
