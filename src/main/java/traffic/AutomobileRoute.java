package traffic;

import message.OutgoingMessage;
import message.SetAutomobileRouteStateMessage;

public class AutomobileRoute extends Route {

    private LightState state;

    public AutomobileRoute(int routeId) {
        super(routeId);
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
    }

    public void setNegative() {
        state = LightState.RED;
    }

    public void setWarning() {
        state = LightState.ORANGE;
    }

    public OutgoingMessage createSetRouteStateMessage() {
        return new SetAutomobileRouteStateMessage(routeId, state);
    }
}
