package com.crimzoncode.tqcontests.api.response;

import com.crimzoncode.tqcontests.util.HelperFns;
import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("code")
    public int code;
    @SerializedName("data")
    public Object data;
    @SerializedName("message")
    public String message;
    @SerializedName("name")
    public String name;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return HelperFns.getGson().toJson((Object) this);
    }
}
