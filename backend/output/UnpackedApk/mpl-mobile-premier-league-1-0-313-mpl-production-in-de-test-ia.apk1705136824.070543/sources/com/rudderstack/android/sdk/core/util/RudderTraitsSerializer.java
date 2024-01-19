package com.rudderstack.android.sdk.core.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.rudderstack.android.sdk.core.RudderTraits;
import java.lang.reflect.Type;
import java.util.Map.Entry;

public class RudderTraitsSerializer implements JsonSerializer<RudderTraits> {
    public JsonElement serialize(RudderTraits rudderTraits, Type type, JsonSerializationContext jsonSerializationContext) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = new JsonObject();
            for (Entry next : ((JsonObject) gson.toJsonTree(rudderTraits)).entrySet()) {
                if (((String) next.getKey()).equals("extras")) {
                    for (Entry next2 : ((JsonObject) gson.toJsonTree(next.getValue())).entrySet()) {
                        jsonObject.add((String) next2.getKey(), (JsonElement) next2.getValue());
                    }
                } else {
                    jsonObject.add((String) next.getKey(), (JsonElement) next.getValue());
                }
            }
            return jsonObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
