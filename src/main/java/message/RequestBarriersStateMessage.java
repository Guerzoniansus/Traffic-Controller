package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.PhysicalState;

/**
 * Request barriers state message. Used to force the simulator to change the barrier state.
 */
public class RequestBarriersStateMessage extends Message implements OutgoingMessage {

    private PhysicalState state;

    /**
     * Request barriers state message constructor
     *
     * @param state the new state we want the simulator to change the barriers to
     */
    public RequestBarriersStateMessage(PhysicalState state) {
        this.state = state;
    }

    /**
     * Gets the state of this message
     *
     * @return the state
     */
    public PhysicalState getState() {
        return state;
    }

    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BARRIERS_STATE, this);
    }

}
