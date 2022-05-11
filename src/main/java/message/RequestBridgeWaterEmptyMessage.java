package message;

import socket.JsonUtils;
import traffic.EventType;

public class RequestBridgeWaterEmptyMessage extends Message implements OutgoingMessage {
    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BRIDGE_WATER_EMPTY);
    }
}
