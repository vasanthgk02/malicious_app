package com.appsflyer.internal;

import org.json.JSONException;

public interface bq<ResponseType> {
    ResponseType values(String str) throws JSONException;
}
