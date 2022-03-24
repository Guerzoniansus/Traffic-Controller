package message;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import socket.JsonUtils;
import traffic.EventType;
import traffic.ThreeColorLightState;

public class SetAutomobileRouteStateMessage extends Message implements OutgoingMessage {

    private int routeId;
    private ThreeColorLightState state;

    public SetAutomobileRouteStateMessage(int routeId, ThreeColorLightState state) {
        this.routeId = routeId;
        this.state = state;
    }

    public String toJson() {
        return JsonUtils.createJson(EventType.SET_AUTOMOBILE_ROUTE_STATE, this);
    }

    public int getRouteId() {
        return routeId;
    }

    public ThreeColorLightState getState() {
        return state;
    }
}
