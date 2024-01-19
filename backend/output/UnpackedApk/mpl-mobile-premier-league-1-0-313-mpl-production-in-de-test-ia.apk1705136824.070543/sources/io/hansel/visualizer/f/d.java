package io.hansel.visualizer.f;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public f f5924a;

    /* renamed from: b  reason: collision with root package name */
    public CoreJSONObject f5925b;

    public d() {
    }

    public d(f fVar) {
        this.f5924a = fVar;
    }

    public d(f fVar, CoreJSONObject coreJSONObject) {
        this.f5924a = fVar;
        this.f5925b = coreJSONObject;
    }

    public f a() {
        return this.f5924a;
    }

    public void a(f fVar) {
        this.f5924a = fVar;
    }

    public void a(String str) {
        HSLLogger.d(GeneratedOutlineSupport.outline50("Received SocketEvent message:  ", str), LogGroup.WS);
        if (str != null) {
            try {
                CoreJSONObject coreJSONObject = new CoreJSONObject(str);
                this.f5924a = f.valueOf(coreJSONObject.optString("message"));
                this.f5925b = coreJSONObject.optJSONObject("payload");
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public CoreJSONObject b() {
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        try {
            coreJSONObject.put((String) "message", (Object) this.f5924a.name());
            Object obj = this.f5925b;
            if (obj == null) {
                obj = CoreJSONObject.NULL;
            }
            coreJSONObject.put((String) "payload", obj);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
        return coreJSONObject;
    }
}
