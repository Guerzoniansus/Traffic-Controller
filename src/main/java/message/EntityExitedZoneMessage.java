package message;

public class EntityExitedZoneMessage extends Message implements IncomingMessage {

    private int routeId, sensorId;

    public EntityExitedZoneMessage(int routeId, int sensorId) {
        this.routeId = routeId;
        this.sensorId = sensorId;
    }

    public void acceptHandler(MessageHandler handler) {
        handler.handleEntityExitedZoneMessage(this);
    }

    public int getRouteId() {
        return routeId;
    }

    public int getSensorId() {
        return sensorId;
    }
}
