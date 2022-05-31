package socket;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import message.Message;
import traffic.EventType;

/**
 * JSON related utilities
 */
public class JsonUtils {

    /**
     * Object used for JSON related functions
     */
    public static final Gson GSON = new Gson();

    /**
     * Hide constructor
     */
    private JsonUtils() {}

    /**
     * Create a basic JSON object that only holds an EventType.
     * Useful for messages that carry no data
     *
     * @param eventType the event type of the message
     * @return the JSON as a String
     */
    public static final String createJson(EventType eventType) {
        JsonObject json = new JsonObject();
        json.add("eventType", GSON.toJsonTree(eventType.toString()));
        return json.toString();
    }

    /**
     * Create a JSON object based on a Message object that has data fields.
     *
     * @param eventType       the event type of the message
     * @param messageWithData The message class with the data that should be added to the JSON object
     * @return the JSON as a String
     */
    public static final String createJson(EventType eventType, Message messageWithData) {
        JsonObject json = new JsonObject();
        json.add("eventType", GSON.toJsonTree(eventType.toString()));

        JsonElement data = JsonUtils.GSON.toJsonTree(messageWithData);
        json.add("data", data);

        return json.toString();
    }
}
