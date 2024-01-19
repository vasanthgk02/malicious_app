package io.hansel.userjourney;

import android.content.Context;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionGETRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;

public class l extends HSLServerRequest {

    /* renamed from: a  reason: collision with root package name */
    public String f5436a;

    public l(Context context, String str, HSLServerResponseHandler hSLServerResponseHandler) {
        super(context, null, hSLServerResponseHandler, true);
        this.f5436a = str;
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        return new HSLConnectionGETRequestWriter(this.f5436a, null, false);
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        return this.requestParams;
    }
}
