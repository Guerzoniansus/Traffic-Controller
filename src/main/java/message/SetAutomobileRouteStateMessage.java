package message;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;

public class SetAutomobileRouteStateMessage extends Message implements OutgoingMessage {

    private int routeId;
    private LightState state;

    public SetAutomobileRouteStateMessage(int routeId, LightState state) {
        this.routeId = routeId;
        this.state = state;
    }

    public String toJson() {
        return JsonUtils.createJson(EventType.SET_AUTOMOBILE_ROUTE_STATE, this);
    }

    public int getRouteId() {
        return routeId;
    }

    public LightState getState() {
        return state;
    }
}
