package traffic;


import message.OutgoingMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * A Route in the simulation.
 * A route is a piece of road that can have entities (such as cars),
 * sensors to detect entities (only on the frontend side),
 * and traffic lights (represented by one LightState).
 */
public abstract class Route {

    /**
     * Starting priority. Priorities are used to determine which traffic lights should go green next.
     * Should not be less than 1.
     */

    protected final int STARTING_PRIORITY;
    /**
     * Maximum priority. Priorities are used to determine which traffic lights should go green next.
     * Should not be less than 1.
     */
    protected final int MAXIMUM_PRIORITY;

    /**
     * The state of the traffic light(s) belonging to this route
     */
    protected LightState state;

    /**
     * The unique ID of this route
     */
    protected int routeId;

    /**
     * Event listeners for this route
     */
    protected List<RouteListener> listeners;

    /**
     * The current priority of this route
     */
    protected int priority;

    /**
     * The entities currently waiting at the traffic light of this route
     */
    protected int entities;

    /**
     * Route constructor
     *
     * @param routeId           the unique ID of this route
     * @param STARTING_PRIORITY starting priority. Priorities are used to determine which traffic lights should go green next.
     * @param MAXIMUM_PRIORITY  maximum priority
     * @param state             the starting light state of this route
     */
    public Route(int routeId, int STARTING_PRIORITY, int MAXIMUM_PRIORITY, LightState state) {
        listeners = new ArrayList<>();
        entities = 0;

        this.STARTING_PRIORITY = STARTING_PRIORITY;
        this.MAXIMUM_PRIORITY = MAXIMUM_PRIORITY;

        this.routeId = routeId;
        this.priority = STARTING_PRIORITY;

        this.state = state;
    }

    /**
     * Gets the unique ID of this route
     *
     * @return the route id
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Add a RouteListener object to this route
     *
     * @param listener listener
     */
    public void addRouteListener(RouteListener listener) {
        listeners.add(listener);
    }

    /**
     * This function will alert registered listeners that a route has been changed
     */
    protected void onRouteStateChange() {
        this.listeners.forEach(x -> x.onRouteStateChange(this));
    }

    /**
     * Resets the priority of this route back to 1
     */
    public void resetPriority() {
        this.priority =  STARTING_PRIORITY;
    }

    /**
     * Increase the priority of this route by 1
     */
    public void increasePriority() {
        System.out.println("route: " + getRouteId() + ", new priority: " + getPriority());
        if (this.priority < MAXIMUM_PRIORITY)
            this.priority++;
    }

    /**
     * Increases the entity count of this route by 1
     */
    public void addEntity() {
        entities++;
    }

    /**
     * Removes the entity count of this route by 1
     */
    public void removeEntity() {
        if (entities > 0) {
            entities--;
        }
    }

    /**
     * Gets the amount of entities on this route waiting for the traffic light
     *
     * @return the amount of entities
     */
    public int getAmountOfEntities() {
        return entities;
    }

    /**
     * Checks if there are currently entities in this route
     *
     * @return whether or not there are entities
     */
    public boolean hasEntities() {
        return entities > 0;
    }

    /**
     * Gets the current priority of this route
     *
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the current state of the traffic light of this route
     *
     * @return the state
     */
    public abstract LightState getState();

    /**
     * Checks if this route has a positive traffic light.
     * For example, it checks if the light is green if this route is a Automobile route.
     *
     * @return whether or not the light is positive
     */
    public abstract boolean isPositive();

    /**
     * Checks if this route has a negative traffic light.
     * For example, it checks if the light is red if this route is a Automobile route.
     *
     * @return whether or not the light is negative
     */
    public abstract boolean isNegative();

    /**
     * Checks if this route has a warning traffic light.
     * For example, it checks if the light is orange if this route is a Automobile route.
     *
     * @return whether or not the light is warning
     */
    public abstract boolean isWarning();

    /**
     * Sets the traffic light(s) of this route to positive.
     * For example, for an Automobile route, that means setting it to green.
     */
    public abstract void setPositive();

    /**
     * Sets the traffic light(s) of this route to negative.
     * For example, for an Automobile route, that means setting it to red.
     */
    public abstract void setNegative();

    /**
     * Sets the traffic light(s) of this route to warning.
     * For example, for an Automobile route, that means setting it to orange.
     */
    public abstract void setWarning();

    /**
     * Creates an OutgoingMessage that will set the state of this route in the simulator.
     *
     * @return an OutgoingMessage that corresponds to setting the state of this route.
     * For example, if this route is an Automobile route, this function will return a SetAutomobileRouteStateMessage.
     */
    public abstract OutgoingMessage createSetRouteStateMessage();
}
