package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AuthTokenAdapter implements JsonSerializer<AuthToken>, JsonDeserializer<AuthToken> {
    public static final Map<String, Class<? extends AuthToken>> authTypeRegistry;
    public final Gson gson = new Gson();

    static {
        HashMap hashMap = new HashMap();
        authTypeRegistry = hashMap;
        hashMap.put("oauth1a", TwitterAuthToken.class);
        authTypeRegistry.put("oauth2", OAuth2Token.class);
        authTypeRegistry.put("guest", GuestAuthToken.class);
    }

    public /* bridge */ /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return deserialize(jsonElement);
    }

    public /* bridge */ /* synthetic */ JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return serialize((AuthToken) obj);
    }

    public AuthToken deserialize(JsonElement jsonElement) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String asString = asJsonObject.getAsJsonPrimitive("auth_type").getAsString();
        return (AuthToken) this.gson.fromJson(asJsonObject.get("auth_token"), authTypeRegistry.get(asString));
    }

    public JsonElement serialize(AuthToken authToken) {
        String str;
        JsonObject jsonObject = new JsonObject();
        Class<?> cls = authToken.getClass();
        Iterator<Entry<String, Class<? extends AuthToken>>> it = authTypeRegistry.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            Entry next = it.next();
            if (((Class) next.getValue()).equals(cls)) {
                str = (String) next.getKey();
                break;
            }
        }
        jsonObject.addProperty((String) "auth_type", str);
        jsonObject.add("auth_token", this.gson.toJsonTree(authToken));
        return jsonObject;
    }
}
