package message;

import socket.JsonUtils;
import traffic.EventType;

public class ConnectControllerMessage extends Message implements OutgoingMessage {

    private final String sessionName;
    private final int sessionVersion = 1;
    private final boolean discardParseErrors = true;
    private final boolean discardEventTypeErrors = true;
    private final boolean discardMalformedDataErrors = true;
    private final boolean discardInvalidStateErrors = true;

    public ConnectControllerMessage(String sessionName) {
        this.sessionName = sessionName;
    }

    public String toJson() {
        return JsonUtils.createJson(EventType.CONNECT_CONTROLLER, this);
    }

}
