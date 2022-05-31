package message;

/**
 * Entity entered zone message
 */
public class EntityEnteredZoneMessage extends Message implements IncomingMessage {

    private int routeId, sensorId;

    /**
     * Entity entered zone message constructor
     *
     * @param routeId  route id of the route an entity entered
     * @param sensorId sensor id of the sensor an entity entered
     */
    public EntityEnteredZoneMessage(int routeId, int sensorId) {
        this.routeId = routeId;
        this.sensorId = sensorId;
    }

    public void acceptHandler(MessageHandler handler) {
        handler.handleEntityEnteredZoneMessage(this);
    }

    /**
     * Gets route id
     *
     * @return the route id
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Gets sensor id
     *
     * @return the sensor id
     */
    public int getSensorId() {
        return sensorId;
    }
}
