package traffic;

import message.OutgoingMessage;
import message.SetCyclistRouteStateMessage;

public class CyclistRoute extends Route {

    private LightState state;

    public CyclistRoute(int routeId) {
        super(routeId, 9, 20);
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
        return new SetCyclistRouteStateMessage(routeId, state);
    }
}
