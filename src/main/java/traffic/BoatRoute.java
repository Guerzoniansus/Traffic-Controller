package traffic;

import message.OutgoingMessage;
import message.SetBoatRouteStateMessage;

public class BoatRoute extends Route {
    private LightState state;

    public BoatRoute(int routeId) {
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
        return state == LightState.GREENRED;
    }

    public void setPositive() {
        state = LightState.GREEN;
    }

    public void setNegative() {
        state = LightState.RED;
    }

    public void setWarning() {
        state = LightState.GREENRED;
    }

    public OutgoingMessage createSetRouteStateMessage() {
return new SetBoatRouteStateMessage(routeId, state);
    }
}
