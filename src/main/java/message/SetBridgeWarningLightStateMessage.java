package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;

public class SetBridgeWarningLightStateMessage extends Message implements OutgoingMessage {

    private LightState state;

    public SetBridgeWarningLightStateMessage(LightState state) {
        this.state = state;
    }

    public LightState getState() {
        return state;
    }

    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.SET_BRIDGE_WARNING_LIGHT_STATE, this);
    }
}
