package traffic;

import message.OutgoingMessage;
import message.SetCyclistRouteStateMessage;

/**
 * Cyclist route
 */
public class CyclistRoute extends Route {

    /**
     * Cyclist route
     *
     * @param routeId route id
     */
    public CyclistRoute(int routeId) {
        super(routeId, 4, 20, LightState.RED);
    }

    public LightState getState() { return state; }

    public boolean isPositive() {
        return state == LightState.GREEN;
    }

    public boolean isNegative() {
        return state == LightState.RED;
    }

    public boolean isWarning() {
        return state == LightState.ORANGE;
    }

    public void setPositive() {
        state = LightState.GREEN;
        onRouteStateChange();
    }

    public void setNegative() {
        state = LightState.RED;
        onRouteStateChange();
    }

    public void setWarning() {
        state = LightState.ORANGE;
        onRouteStateChange();
    }

    public OutgoingMessage createSetRouteStateMessage() {
        return new SetCyclistRouteStateMessage(routeId, state);
    }
}
