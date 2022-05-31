package message;

import traffic.PhysicalState;

/**
 * Acknowledge barriers state message. The simulator uses this message to send the current barrier state.
 */
public class AcknowledgeBarriersStateMessage extends Message implements IncomingMessage {

    private PhysicalState state;

    /**
     * Acknowledge barriers state message constructor
     *
     * @param state The barrier state
     */
    public AcknowledgeBarriersStateMessage(PhysicalState state) {
        this.state = state;
    }

    /**
     * Gets the current state of the barriers in the simulator.
     *
     * @return the state
     */
    public PhysicalState getState() {
        return state;
    }

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBarriersStateMessage(this);
    }
}
