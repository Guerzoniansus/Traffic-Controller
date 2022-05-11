package message;

public class AcknowledgeBridgeWaterEmptyMessage extends Message implements IncomingMessage {
    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeWaterEmptyMessage(this);
    }
}
