package message;

import traffic.PhysicalState;

/**
 * Acknowledge bridge state message. The simulator uses this message to send the current bridge state.
 */
public class AcknowledgeBridgeStateMessage extends Message implements IncomingMessage {

    private PhysicalState state;

    /**
     * Acknowledge bridge state message constructor
     *
     * @param state The bridge state
     */
    public AcknowledgeBridgeStateMessage(PhysicalState state) {
        this.state = state;
    }

    /**
     * Gets the current state
     *
     * @return the current bridge state
     */
    public PhysicalState getState() {
        return state;
    }

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeStateMessage(this);
    }
}
