package message;

public class AcknowledgeBridgeRoadEmptyMessage extends Message implements IncomingMessage {

    @Override
    public void acceptHandler(MessageHandler handler) {
        handler.handleAcknowledgeBridgeRoadEmptyMessage(this);
    }
}
