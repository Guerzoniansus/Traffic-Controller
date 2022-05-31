package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;

/**
 * Set bridge warning light state message. Used to turn the warnings lights on or off.
 */
public class SetBridgeWarningLightStateMessage extends Message implements OutgoingMessage {

    private LightState state;

    /**
     * Set bridge warning light state message constructor
     *
     * @param state the new state of the warnings lights
     */
    public SetBridgeWarningLightStateMessage(LightState state) {
        this.state = state;
    }

    /**
     * Gets the new state
     *
     * @return the state
     */
    public LightState getState() {
        return state;
    }

    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.SET_BRIDGE_WARNING_LIGHT_STATE, this);
    }
}
