package message;

import socket.JsonUtils;
import traffic.EventType;

public class RequestBridgeRoadEmptyMessage extends Message implements OutgoingMessage {
    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BRIDGE_ROAD_EMPTY);
    }
}
