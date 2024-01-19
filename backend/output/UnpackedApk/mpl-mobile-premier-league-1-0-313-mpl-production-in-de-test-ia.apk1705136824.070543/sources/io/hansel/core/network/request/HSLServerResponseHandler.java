package io.hansel.core.network.request;

import java.io.InputStream;

public interface HSLServerResponseHandler {
    void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i);

    void parseResponse(HSLServerRequest hSLServerRequest, String str, int i);
}
