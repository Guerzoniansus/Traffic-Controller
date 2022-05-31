package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;
import traffic.PhysicalState;

/**
 * Request bridge state message. Used to force the simulator to change the bridge state.
 */
public class RequestBridgeStateMessage extends Message implements OutgoingMessage {

    private PhysicalState state;

    /**
     * Request bridge state message constructor
     *
     * @param state the new state you want the bridge to be in on the simulator
     */
    public RequestBridgeStateMessage(PhysicalState state) {
        this.state = state;
    }

    /**
     * Gets the state that this message will tell to the simulator
     *
     * @return the state
     */
    public PhysicalState getState() {
        return state;
    }

    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BRIDGE_STATE, this);
    }
}
