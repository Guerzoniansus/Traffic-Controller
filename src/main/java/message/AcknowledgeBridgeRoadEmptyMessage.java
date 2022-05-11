package message;

public class AcknowledgeBridgeRoadEmptyMessage implements IncomingMessage {

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeRoadEmptyMessage(this);
    }
}
