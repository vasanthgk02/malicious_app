package io.hansel.core.network.requestwriter;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import io.hansel.core.json.CoreJSONObject;
import java.util.HashMap;

public class HSLConnectionJSONPOSTRequestWriter extends a {
    public HashMap<String, String> headers;

    public HSLConnectionJSONPOSTRequestWriter(String str, String str2, CoreJSONObject coreJSONObject, HashMap<String, String> hashMap) {
        super(str, str2, convertJSONToBytes(coreJSONObject));
        this.headers = hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] convertJSONToBytes(io.hansel.core.json.CoreJSONObject r1) {
        /*
            if (r1 == 0) goto L_0x0011
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x000d }
            java.lang.String r0 = "UTF-8"
            byte[] r1 = r1.getBytes(r0)     // Catch:{ Exception -> 0x000d }
            goto L_0x0012
        L_0x000d:
            r1 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r1)
        L_0x0011:
            r1 = 0
        L_0x0012:
            if (r1 != 0) goto L_0x0017
            r1 = 0
            byte[] r1 = new byte[r1]
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter.convertJSONToBytes(io.hansel.core.json.CoreJSONObject):byte[]");
    }

    public String getContentType() {
        return DefaultSettingsSpiCall.ACCEPT_JSON_VALUE;
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }
}
