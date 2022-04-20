package traffic;


import message.OutgoingMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class Route {
    protected final int STARTING_PRIORITY;
    protected final int MAXIMUM_PRIORITY;

    protected LightState state;
    protected int routeId;
    protected List<RouteListener> listeners;
    protected int priority;

    protected int entities;

    public Route(int routeId, int STARTING_PRIORITY, int MAXIMUM_PRIORITY, LightState state) {
        listeners = new ArrayList<>();
        entities = 0;

        this.STARTING_PRIORITY = STARTING_PRIORITY;
        this.MAXIMUM_PRIORITY = MAXIMUM_PRIORITY;

        this.routeId = routeId;
        this.priority = STARTING_PRIORITY;

        this.state = state;
    }

    public int getRouteId() {
        return routeId;
    }

    public void addRouteListener(RouteListener listener) {
        listeners.add(listener);
    }

    protected void onRouteStateChange() {
        this.listeners.forEach(x -> x.onRouteStateChange(this));
    }

    public void resetPriority() {
        this.priority =  STARTING_PRIORITY;
    }

    public void increasePriority() {
        System.out.println("route: " + getRouteId() + ", new priority: " + getPriority());
        if (this.priority < MAXIMUM_PRIORITY)
            this.priority++;
    }

    public void addEntity() {
        entities++;
    }

    public void removeEntity() {
        if (entities > 0) {
            entities--;
        }
    }

    public boolean hasEntities() {
        return entities > 0;
    }

    public int getPriority() {
        return priority;
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
