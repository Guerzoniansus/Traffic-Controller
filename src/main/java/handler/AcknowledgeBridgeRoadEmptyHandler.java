package handler;

import controller.Controller;
import message.AcknowledgeBridgeRoadEmptyMessage;
import message.OutgoingMessage;
import message.RequestBarriersStateMessage;
import traffic.PhysicalState;

public class AcknowledgeBridgeRoadEmptyHandler {
    public void handle(AcknowledgeBridgeRoadEmptyMessage message) {
        OutgoingMessage outgoingMessage = new RequestBarriersStateMessage(PhysicalState.DOWN);
        Controller.getInstance().sendMessage(outgoingMessage);
    }
}
