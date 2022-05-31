package message;

import socket.JsonUtils;
import traffic.EventType;
import traffic.LightState;

/**
 * Set pedestrian route state message
 */
public class SetPedestrianRouteStateMessage extends Message implements OutgoingMessage {

    private int routeId;
    private LightState state;

    /**
     * Set pedestrian route state message constructor
     *
     * @param routeId the route id this message applies to
     * @param state   the new state this route shuold change to
     */
    public SetPedestrianRouteStateMessage(int routeId, LightState state) {
        this.routeId = routeId;
        this.state = state;
    }

    public String toJson() {
        return JsonUtils.createJson(EventType.SET_PEDESTRIAN_ROUTE_STATE, this);
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
