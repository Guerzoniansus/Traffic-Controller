package socket;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import message.*;
import traffic.EventType;

import java.util.logging.Logger;

import static socket.JsonUtils.GSON;

/**
 * This class decodes (JSON) Strings into Message objects.
 */
public class MessageDecoder {

    private final static Logger LOGGER = Logger.getLogger(MessageDecoder.class.getName());

    private static JsonParser parser = new JsonParser();

    /**
     * Decode a message
     *
     * @param message The (JSON) message to decode
     * @return A Message object of the decoded String with the data fields initialized
     */
    public static Message decodeMessage(String message) {
        JsonObject jsonObj = parser.parse(message).getAsJsonObject();

        JsonElement eventTypeJson = jsonObj.get("eventType");


        if (eventTypeJson == null) {
            printError(message, "Field eventType does not exist");
            return new UnknownMessage();
        }

        String eventTypeString = eventTypeJson.getAsString();

        try {
            EventType eventType = EventType.valueOf(eventTypeString);
            Message decodedMessage = null;

            switch (eventType) {
                case SESSION_START: {
                    decodedMessage = new SessionStartMessage();
                    break;
                }

                case ENTITY_ENTERED_ZONE: {
                    JsonObject data = jsonObj.get("data").getAsJsonObject();
                    decodedMessage = GSON.fromJson(data, EntityEnteredZoneMessage.class);
                    break;
                }

                case ENTITY_EXITED_ZONE: {
                    JsonObject data = jsonObj.get("data").getAsJsonObject();
                    decodedMessage = GSON.fromJson(data, EntityExitedZoneMessage.class);
                    break;
                }

                case ACKNOWLEDGE_BRIDGE_STATE: {
                    JsonObject data = jsonObj.get("data").getAsJsonObject();
                    decodedMessage = GSON.fromJson(data, AcknowledgeBridgeStateMessage.class);
                    break;
                }

                case ACKNOWLEDGE_BARRIERS_STATE: {
                    JsonObject data = jsonObj.get("data").getAsJsonObject();
                    decodedMessage = GSON.fromJson(data, AcknowledgeBarriersStateMessage.class);
                    break;
                }

                case ACKNOWLEDGE_BRIDGE_ROAD_EMPTY: {
                    decodedMessage = new AcknowledgeBridgeRoadEmptyMessage();
                    break;
                }

                case ACKNOWLEDGE_BRIDGE_WATER_EMPTY: {
                    decodedMessage = new AcknowledgeBridgeWaterEmptyMessage();
                    break;
                }

                case ERROR_INVALID_STATE: {
                    JsonObject data = jsonObj.get("data").getAsJsonObject();
                    decodedMessage = GSON.fromJson(data, ErrorInvalidStateMessage.class);
                    break;
                }
            }

            return decodedMessage;
        }

        catch (IllegalArgumentException e) {
            printError(message, "This event type does not exist.");
            return new UnknownMessage();
        }
    }

    private static void printError(String message, String cause) {
        LOGGER.warning("Could not decode message: \"" + message + "\".\nCause: " + cause);

    }

}
