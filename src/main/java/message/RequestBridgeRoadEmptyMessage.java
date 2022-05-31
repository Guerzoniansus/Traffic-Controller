package message;

import socket.JsonUtils;
import traffic.EventType;

/**
 * Request bridge road empty message. Used to ask the simulator "is the bridge road empty?".
 */
public class RequestBridgeRoadEmptyMessage extends Message implements OutgoingMessage {
    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BRIDGE_ROAD_EMPTY);
    }
}
