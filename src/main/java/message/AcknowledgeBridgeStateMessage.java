package message;

import traffic.PhysicalState;

public class AcknowledgeBridgeStateMessage implements IncomingMessage {

    private PhysicalState state;

    public AcknowledgeBridgeStateMessage(PhysicalState state) {
        this.state = state;
    }

    public PhysicalState getState() {
        return state;
    }

    public void setState(PhysicalState state) {
        this.state = state;
    }

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeStateMessage(this);
    }
}
