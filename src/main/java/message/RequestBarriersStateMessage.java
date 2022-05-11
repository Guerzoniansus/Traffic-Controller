package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.PhysicalState;

public class RequestBarriersStateMessage extends Message implements OutgoingMessage {

    private PhysicalState state;

    public RequestBarriersStateMessage(PhysicalState state) {
        this.state = state;
    }

    public PhysicalState getState() {
        return state;
    }

    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BARRIERS_STATE, this);
    }

}
