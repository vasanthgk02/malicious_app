package io.hansel.ujmtracker;

import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import java.io.InputStream;

public class a implements HSLServerResponseHandler {
    public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, String str, int i) {
        HSLLogger.d("AddEventResponseHandler:  " + i);
        if (str != null) {
            try {
                if (new CoreJSONObject(str).optBoolean("is_error")) {
                    HSLLogger.w("Error: Unable to add event on hansel.", LogGroup.AI);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }
}
