package traffic;

/**
 * Route listener
 */
public interface RouteListener {
    /**
     * On route state change *
     *
     * @param route route
     */
    void onRouteStateChange(Route route);
}
