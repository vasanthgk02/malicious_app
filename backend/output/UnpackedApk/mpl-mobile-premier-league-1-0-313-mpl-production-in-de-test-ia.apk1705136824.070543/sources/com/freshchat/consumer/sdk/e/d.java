package com.freshchat.consumer.sdk.e;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class d {
    public InputStream eC;
    public Map<String, List<String>> eE;
    public int statusCode;

    public void a(Map<String, List<String>> map) {
        this.eE = map;
    }

    public InputStream getInputStream() {
        return this.eC;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setInputStream(InputStream inputStream) {
        this.eC = inputStream;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }
}
