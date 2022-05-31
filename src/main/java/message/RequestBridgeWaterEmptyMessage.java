package message;

import socket.JsonUtils;
import traffic.EventType;

/**
 * Request bridge water empty message. Used to ask the simulator "is the bridge water empty?".
 */
public class RequestBridgeWaterEmptyMessage extends Message implements OutgoingMessage {
    @Override
    public String toJson() {
        return JsonUtils.createJson(EventType.REQUEST_BRIDGE_WATER_EMPTY);
    }
}
