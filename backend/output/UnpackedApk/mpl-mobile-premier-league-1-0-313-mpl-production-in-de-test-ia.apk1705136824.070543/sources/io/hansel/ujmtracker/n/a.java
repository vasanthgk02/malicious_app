package io.hansel.ujmtracker.n;

import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import java.util.HashMap;
import sfs2x.client.requests.LoginRequest;

public class a extends CoreJSONObject {
    public a(String str, String str2, CoreJSONObject coreJSONObject) {
        try {
            put((String) LoginRequest.KEY_PRIVILEGE_ID, (Object) str);
            put((String) "ui", (Object) str2);
            coreJSONObject.put((String) "pd", (Object) new CoreJSONObject());
            put((String) "d", (Object) coreJSONObject);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public a(String str, String str2, String str3, String str4, HashMap<String, Object> hashMap, long j) {
        try {
            put((String) LoginRequest.KEY_PRIVILEGE_ID, (Object) str);
            put((String) "ui", (Object) str2);
            CoreJSONObject coreJSONObject = new CoreJSONObject();
            coreJSONObject.put((String) "t", j);
            coreJSONObject.put((String) "d", (Object) b.a(hashMap, str4).a());
            put(str3, (Object) coreJSONObject);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }
}
