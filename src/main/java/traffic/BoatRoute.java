package traffic;

import message.OutgoingMessage;
import message.SetBoatRouteStateMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Boat route
 */
public class BoatRoute extends Route {

    /**
     * BOAT_ROUTES
     */
    public static final List<Integer> BOAT_ROUTES = Arrays.asList(41, 42);

    /**
     * Boat route
     *
     * @param routeId route id
     */
    public BoatRoute(int routeId) {
        super(routeId, 30, 40, LightState.RED);
    }

    public LightState getState() {
        return state;
    }

    public boolean isPositive() {
        return state == LightState.GREEN;
    }

    public boolean isNegative() {
        return state == LightState.RED;
    }

    public boolean isWarning() {
        return state == LightState.GREENRED;
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
        state = LightState.GREENRED;
        onRouteStateChange();
    }

    public OutgoingMessage createSetRouteStateMessage() {
return new SetBoatRouteStateMessage(routeId, state);
    }
}
