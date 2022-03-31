package traffic;


import message.OutgoingMessage;

public abstract class Route {
    protected int routeId;

    public Route(int routeId) {
        this.routeId = routeId;
    }

    public int getRouteId() {
        return routeId;
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
