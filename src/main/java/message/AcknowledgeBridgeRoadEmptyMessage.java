package message;

/**
 * Acknowledge bridge road empty message. The simulator sends this when the bridge road is empty.
 */
public class AcknowledgeBridgeRoadEmptyMessage extends Message implements IncomingMessage {

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeRoadEmptyMessage(this);
    }
}
