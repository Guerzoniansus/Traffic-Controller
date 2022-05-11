package message;

import traffic.PhysicalState;

public class AcknowledgeBarriersStateMessage extends Message implements IncomingMessage {

    private PhysicalState state;

    public AcknowledgeBarriersStateMessage(PhysicalState state) {
        this.state = state;
    }

    public PhysicalState getState() {
        return state;
    }

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBarriersStateMessage(this);
    }
}
