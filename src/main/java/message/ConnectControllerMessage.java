package message;

import socket.JsonUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import traffic.EventType;

public class ConnectControllerMessage extends Message implements OutgoingMessage {

    private final String sessionName = "raka";
    private final int sessionVersion = 1;
    private final boolean discardParseErrors = false;
    private final boolean discardEventTypeErrors = false;
    private final boolean discardMalformedDataErrors = false;
    private final boolean discardInvalidStateErrors = false;

    public String toJson() {
        return JsonUtils.createJson(EventType.CONNECT_CONTROLLER, this);
    }

}
