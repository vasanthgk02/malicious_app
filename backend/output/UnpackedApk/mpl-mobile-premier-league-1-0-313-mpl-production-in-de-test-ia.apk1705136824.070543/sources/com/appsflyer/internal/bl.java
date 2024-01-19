package com.appsflyer.internal;

import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

public final class bl<ResponseBody> {
    public final bq<ResponseBody> AFInAppEventParameterName;
    public final z AFInAppEventType;
    public final ExecutorService AFKeystoreWrapper;
    public final AtomicBoolean valueOf = new AtomicBoolean(false);
    public final bm values;

    public bl(z zVar, ExecutorService executorService, bm bmVar, bq<ResponseBody> bqVar) {
        this.AFInAppEventType = zVar;
        this.AFKeystoreWrapper = executorService;
        this.values = bmVar;
        this.AFInAppEventParameterName = bqVar;
    }

    public final br<ResponseBody> AFKeystoreWrapper() throws IOException {
        if (!this.valueOf.getAndSet(true)) {
            br<String> AFInAppEventType2 = this.values.AFInAppEventType(this.AFInAppEventType);
            try {
                br brVar = new br(this.AFInAppEventParameterName.values((String) AFInAppEventType2.valueOf), AFInAppEventType2.values, AFInAppEventType2.AFKeystoreWrapper, AFInAppEventType2.AFInAppEventParameterName, AFInAppEventType2.AFInAppEventType);
                return brVar;
            } catch (JSONException e2) {
                throw new ParsingException(e2.getMessage(), e2, AFInAppEventType2);
            }
        } else {
            throw new IllegalStateException("Http call is already executed");
        }
    }
}
