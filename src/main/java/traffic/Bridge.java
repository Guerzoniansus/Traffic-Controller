package traffic;

public class Bridge {
    private boolean open;
    private boolean isProcessing;

    public Bridge() {
        open = false;
        isProcessing = false;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isClosed() {
        return !isOpen();
    }

    public void startProcessing() {
        isProcessing = true;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void open() {
        open = true;
        isProcessing = false;
    }

    public void close() {
        open = false;
        isProcessing = false;
    }
}
