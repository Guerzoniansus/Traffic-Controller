package message;

public class EntityEnteredZoneMessage extends Message implements IncomingMessage {

    private int routeId, sensorId;

    public EntityEnteredZoneMessage(int routeId, int sensorId) {
        this.routeId = routeId;
        this.sensorId = sensorId;
    }

    public void acceptHandler(MessageHandler handler) {
        handler.handleEntityEnteredZoneMessage(this);
    }

    public int getRouteId() {
        return routeId;
    }

    public int getSensorId() {
        return sensorId;
    }
}
