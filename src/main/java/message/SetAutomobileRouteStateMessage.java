package message;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;

/**
 * Set automobile route state message. Used to tell the simulator what state a traffic light should change to.
 */
public class SetAutomobileRouteStateMessage extends Message implements OutgoingMessage {

    private int routeId;
    private LightState state;

    /**
     * Set automobile route state message constructor
     *
     * @param routeId the route id this message applies to
     * @param state   the new state this route shuold change to
     */
    public SetAutomobileRouteStateMessage(int routeId, LightState state) {
        this.routeId = routeId;
        this.state = state;
    }

    public String toJson() {
        return JsonUtils.createJson(EventType.SET_AUTOMOBILE_ROUTE_STATE, this);
    }

    /**
     * Gets the route id this message applies to
     *
     * @return the route id
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Gets the new state this message will communicate
     *
     * @return the state
     */
    public LightState getState() {
        return state;
    }
}
