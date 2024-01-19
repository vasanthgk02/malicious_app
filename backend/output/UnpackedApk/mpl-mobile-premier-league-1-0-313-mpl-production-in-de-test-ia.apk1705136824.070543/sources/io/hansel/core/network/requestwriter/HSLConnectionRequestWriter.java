package io.hansel.core.network.requestwriter;

import java.net.HttpURLConnection;

public interface HSLConnectionRequestWriter {
    String getUrl();

    HttpURLConnection write();
}
