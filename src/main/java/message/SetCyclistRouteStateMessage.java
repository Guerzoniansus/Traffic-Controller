package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;

public class SetCyclistRouteStateMessage extends Message implements OutgoingMessage {
    private int routeId;
    private LightState state;

    public SetCyclistRouteStateMessage(int routeId, LightState state) {
        this.routeId = routeId;
        this.state = state;
    }

    public String toJson() {
        return JsonUtils.createJson(EventType.SET_CYCLIST_ROUTE_STATE, this);
    }

    public int getRouteId() {
        return routeId;
    }

    public LightState getState() {
        return state;
    }
}
