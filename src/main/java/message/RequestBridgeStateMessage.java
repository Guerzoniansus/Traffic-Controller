package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;
import traffic.PhysicalState;

public class RequestBridgeStateMessage extends Message implements OutgoingMessage {

    private PhysicalState state;

    public RequestBridgeStateMessage(PhysicalState state) {
        this.state = state;
    }

    public PhysicalState getState() {
        return state;
    }

    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BRIDGE_STATE, this);
    }
}
