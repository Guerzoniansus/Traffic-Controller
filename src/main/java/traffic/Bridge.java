package traffic;

/**
 * A bridge
 */
public class Bridge {
    private boolean open;
    private boolean isProcessing;

    /**
     * Bridge constructor. The bridge is closed by default.
     */
    public Bridge() {
        open = false;
        isProcessing = false;
    }

    /**
     * Checks if the bridge is open
     *
     * @return true is the bridge is open, false if the bridge is closed
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Is closed boolean
     *
     * @return true if the bridge is closed, false if the bridge is open
     */
    public boolean isClosed() {
        return !isOpen();
    }

    /**
     * Turns on a processing flag.
     * The "processing" state begins when preparing to open or close a bridge
     * (closing barriers, turning on warning lights, doing other checks)
     * and automatically ends when the bridge is fully open or closed.
     */
    public void startProcessing() {
        isProcessing = true;
    }

    /**
     * Checks if the bridge is currently processing.
     * This means that it's preparing to open or close but
     * other things, such was barriers and warning lights, are being being handled first.
     *
     * @return true if currently processing
     */
    public boolean isProcessing() {
        return isProcessing;
    }

    /**
     * Opens the bridge.
     * This only opens the bridge "object" here in the controller.
     * It does NOT send a message to the frontend to open the bridge.
     */
    public void open() {
        open = true;
        isProcessing = false;
    }

    /**
     * Closes the bridge.
     * This only opens the bridge "object" here in the controller.
     * It does NOT send a message to the frontend to open the bridge.
     */
    public void close() {
        open = false;
        isProcessing = false;
    }
}
