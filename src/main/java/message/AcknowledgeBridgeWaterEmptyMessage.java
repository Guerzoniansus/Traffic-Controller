package message;

public class AcknowledgeBridgeWaterEmptyMessage implements IncomingMessage {
    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeWaterEmptyMessage(this);
    }
}
