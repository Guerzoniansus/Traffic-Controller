package traffic;

import message.OutgoingMessage;
import message.SetAutomobileRouteStateMessage;

public class AutomobileRoute extends Route {

    private LightState state;

    public AutomobileRoute(int routeId) {
        super(routeId, 1, 10);
        state = LightState.RED;
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
        return new SetAutomobileRouteStateMessage(routeId, state);
    }
}
