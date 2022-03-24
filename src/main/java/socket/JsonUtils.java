package socket;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import message.Message;
import traffic.EventType;

public class JsonUtils {
    public static final Gson GSON = new Gson();

    public static final String createJson(EventType eventType) {
        JsonObject json = new JsonObject();
        json.add("eventType", GSON.toJsonTree(eventType.toString()));
        return json.toString();
    }

    public static final String createJson(EventType eventType, Message messageWithData) {
        JsonObject json = new JsonObject();
        json.add("eventType", GSON.toJsonTree(eventType.toString()));

        JsonElement data = JsonUtils.GSON.toJsonTree(messageWithData);
        json.add("data", data);

        return json.toString();
    }
}
