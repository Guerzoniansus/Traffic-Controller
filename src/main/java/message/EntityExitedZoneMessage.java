package message;

/**
 * Entity exited zone message
 */
public class EntityExitedZoneMessage extends Message implements IncomingMessage {

    private int routeId, sensorId;

    /**
     * Entity exited zone message constructor
     *
     * @param routeId  route id of where the entity entered
     * @param sensorId sensor id of where the entity entered
     */
    public EntityExitedZoneMessage(int routeId, int sensorId) {
        this.routeId = routeId;
        this.sensorId = sensorId;
    }

    public void acceptHandler(MessageHandler handler) {
        handler.handleEntityExitedZoneMessage(this);
    }

    /**
     * Gets the route id
     *
     * @return the route id
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Gets the sensor id
     *
     * @return the sensor id
     */
    public int getSensorId() {
        return sensorId;
    }
}
