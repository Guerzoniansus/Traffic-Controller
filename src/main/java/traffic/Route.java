package traffic;


import message.OutgoingMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class Route {
    protected int routeId;
    protected List<RouteListener> listeners;

    public Route(int routeId) {
        this.routeId = routeId;
        listeners = new ArrayList<>();
    }

    public int getRouteId() {
        return routeId;
    }

    public void addRouteListener(RouteListener listener) {
        listeners.add(listener);
    }

    protected void onRouteStateChange() {
        this.listeners.forEach(x -> x.onRouteStateChange());
    }

    public abstract LightState getState();

    public abstract boolean isPositive();
    public abstract boolean isNegative();
    public abstract boolean isWarning();

    public abstract void setPositive();
    public abstract void setNegative();
    public abstract void setWarning();

    public abstract OutgoingMessage createSetRouteStateMessage();
}
