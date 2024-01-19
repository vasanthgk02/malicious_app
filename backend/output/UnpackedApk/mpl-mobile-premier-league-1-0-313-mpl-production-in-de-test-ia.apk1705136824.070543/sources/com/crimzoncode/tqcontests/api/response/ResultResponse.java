package com.crimzoncode.tqcontests.api.response;

import com.crimzoncode.tqcontests.data.model.BaseModel;
import com.crimzoncode.tqcontests.util.HelperFns;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResultResponse {
    public static final String TAG = "RESULT_MODEL";
    public static Gson gson;
    @SerializedName("data")
    public JsonObject data;
    @SerializedName("name")
    public String name;

    public ResultResponse() {
        gson = HelperFns.getGson();
    }

    public JsonObject getData() {
        return this.data;
    }

    public <T> T getDataAsArray(String str, String str2, Type type) {
        return gson.fromJson((JsonElement) this.data.getAsJsonObject(str).getAsJsonArray(str2), type);
    }

    public <T extends BaseModel> List<T> getDataAsList(String str, Class cls) {
        ArrayList arrayList = new ArrayList();
        if (this.data.has(str)) {
            JsonArray asJsonArray = this.data.get(str).getAsJsonArray();
            for (int i = 0; i < asJsonArray.size(); i++) {
                arrayList.add((BaseModel) gson.fromJson((JsonElement) asJsonArray.get(i).getAsJsonObject(), cls));
            }
        }
        return arrayList;
    }

    public <T extends BaseModel> T getDataAsObject(Class cls) {
        return (BaseModel) gson.fromJson((JsonElement) this.data, cls);
    }

    public ErrorResponse getErrorResponse() {
        Gson gson2 = new Gson();
        if (this.data.getAsJsonObject().get("error") != null) {
            return (ErrorResponse) gson2.fromJson(this.data.getAsJsonObject().get("error"), ErrorResponse.class);
        }
        return null;
    }

    public String getMessage() {
        return this.data.has("message") ? this.data.get("message").getAsString() : "";
    }

    public String getName() {
        return this.name;
    }

    public boolean isSuccessful() {
        if (this.data.has("is_successful")) {
            return this.data.get("is_successful").getAsBoolean();
        }
        return false;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return HelperFns.getGson().toJson((Object) this);
    }

    public <T extends BaseModel> T getDataAsObject(String str, Class cls) {
        return (BaseModel) gson.fromJson((JsonElement) this.data.get(str).getAsJsonObject(), cls);
    }

    public <T extends BaseModel> T getDataAsObject(String str, String str2, Class cls) {
        return (BaseModel) gson.fromJson((JsonElement) this.data.getAsJsonObject(str).getAsJsonObject(str2), cls);
    }

    public JsonArray getDataAsArray(String str) {
        return this.data.has(str) ? this.data.get(str).getAsJsonArray() : new JsonArray();
    }

    public <T> T getDataAsObject(String str, String str2, Type type) {
        return gson.fromJson((JsonElement) this.data.getAsJsonObject(str).getAsJsonObject(str2), type);
    }

    public <T> T getDataAsObject(Type type) {
        return gson.fromJson((JsonElement) this.data, type);
    }

    public <T> T getDataAsObject(String str, Type type) {
        return gson.fromJson((JsonElement) this.data.getAsJsonObject(str), type);
    }
}
