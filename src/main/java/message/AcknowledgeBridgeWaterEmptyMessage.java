package message;

/**
 * Acknowledge bridge water empty message. The simulator sends this to let the controller know the bridge water is empty.
 */
public class AcknowledgeBridgeWaterEmptyMessage extends Message implements IncomingMessage {
    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeWaterEmptyMessage(this);
    }
}
