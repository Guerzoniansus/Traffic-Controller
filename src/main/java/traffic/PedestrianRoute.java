package traffic;

import message.OutgoingMessage;
import message.SetPedestrianRouteStateMessage;

public class PedestrianRoute extends Route {

    private LightState state;

    public PedestrianRoute(int routeId) {
        super(routeId);
        state = LightState.RED;
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
        return state == LightState.BLINKING;
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
        state = LightState.BLINKING;
        onRouteStateChange();
    }

    public OutgoingMessage createSetRouteStateMessage() {
        return new SetPedestrianRouteStateMessage(routeId, state);
    }
}
