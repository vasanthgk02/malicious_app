package com.twitter.sdk.android.core.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class BindingValuesAdapter implements JsonSerializer<BindingValues>, JsonDeserializer<BindingValues> {
    public /* bridge */ /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return deserialize(jsonElement, jsonDeserializationContext);
    }

    public JsonElement serialize() {
        return null;
    }

    public /* bridge */ /* synthetic */ JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        BindingValues bindingValues = (BindingValues) obj;
        return serialize();
    }

    public BindingValues deserialize(JsonElement jsonElement, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            return new BindingValues();
        }
        Set<Entry<String, JsonElement>> entrySet = jsonElement.getAsJsonObject().entrySet();
        HashMap hashMap = new HashMap(32);
        for (Entry next : entrySet) {
            String str = (String) next.getKey();
            JsonObject asJsonObject = ((JsonElement) next.getValue()).getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("type");
            Object obj = null;
            if (jsonElement2 != null && jsonElement2.isJsonPrimitive()) {
                String asString = jsonElement2.getAsString();
                char c2 = 65535;
                switch (asString.hashCode()) {
                    case -1838656495:
                        if (asString.equals("STRING")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 2614219:
                        if (asString.equals("USER")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 69775675:
                        if (asString.equals("IMAGE")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 782694408:
                        if (asString.equals("BOOLEAN")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    obj = jsonDeserializationContext.deserialize(asJsonObject.get("string_value"), String.class);
                } else if (c2 == 1) {
                    obj = jsonDeserializationContext.deserialize(asJsonObject.get("image_value"), ImageValue.class);
                } else if (c2 == 2) {
                    obj = jsonDeserializationContext.deserialize(asJsonObject.get("user_value"), UserValue.class);
                } else if (c2 == 3) {
                    obj = jsonDeserializationContext.deserialize(asJsonObject.get("boolean_value"), Boolean.class);
                }
            }
            hashMap.put(str, obj);
        }
        return new BindingValues(hashMap);
    }
}
