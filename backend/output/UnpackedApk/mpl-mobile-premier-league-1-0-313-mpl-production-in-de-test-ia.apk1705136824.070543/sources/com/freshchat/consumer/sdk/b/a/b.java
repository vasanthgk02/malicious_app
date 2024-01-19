package com.freshchat.consumer.sdk.b.a;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(11)
public class b {
    public JsonReader dZ;
    public Object ea;

    public b(InputStream inputStream) {
        try {
            this.dZ = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
        }
    }

    private JSONArray a(JsonReader jsonReader) {
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jSONArray.put(b(jsonReader));
            }
            jsonReader.endArray();
        } catch (IOException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
        }
        return jSONArray;
    }

    private Object b(JsonReader jsonReader) {
        try {
            JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(peek)) {
                return a(jsonReader);
            }
            if (JsonToken.BEGIN_OBJECT.equals(peek)) {
                return c(jsonReader);
            }
            if (JsonToken.BOOLEAN.equals(peek)) {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            if (JsonToken.NUMBER.equals(peek)) {
                return Long.valueOf(jsonReader.nextLong());
            }
            if (JsonToken.STRING.equals(peek)) {
                return jsonReader.nextString();
            }
            if (JsonToken.NULL.equals(peek)) {
                jsonReader.nextNull();
                return null;
            }
            return null;
        } catch (IOException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
        }
    }

    private JSONObject c(JsonReader jsonReader) {
        JSONObject jSONObject = new JSONObject();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                jSONObject.put(jsonReader.nextName(), b(jsonReader));
            }
            jsonReader.endObject();
        } catch (IOException | JSONException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
        }
        return jSONObject;
    }

    public Object co() {
        if (this.ea == null) {
            JsonReader jsonReader = this.dZ;
            if (jsonReader != null) {
                this.ea = b(jsonReader);
                try {
                    this.dZ.close();
                } catch (IOException e2) {
                    q.a(e2);
                }
            }
        }
        return this.ea;
    }
}
