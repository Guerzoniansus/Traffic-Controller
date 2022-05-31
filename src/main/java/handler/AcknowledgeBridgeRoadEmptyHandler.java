package handler;

import controller.Controller;
import message.AcknowledgeBridgeRoadEmptyMessage;
import message.OutgoingMessage;
import message.RequestBarriersStateMessage;
import traffic.PhysicalState;

/**
 * Acknowledge bridge road empty handler
 */
public class AcknowledgeBridgeRoadEmptyHandler {

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
    public void handle(AcknowledgeBridgeRoadEmptyMessage message) {
        OutgoingMessage outgoingMessage = new RequestBarriersStateMessage(PhysicalState.DOWN);
        Controller.getInstance().sendMessage(outgoingMessage);
    }
}
