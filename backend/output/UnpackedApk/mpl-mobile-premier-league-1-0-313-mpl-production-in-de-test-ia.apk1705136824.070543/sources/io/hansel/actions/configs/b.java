package io.hansel.actions.configs;

import android.content.Context;
import io.hansel.actions.HSLConfigDataType;
import io.hansel.actions.HSLConfigPriority;
import io.hansel.actions.HSLConfigSource;
import io.hansel.actions.HSLConfigSourceCode;
import io.hansel.core.base.utils.HSLVersion;
import java.util.HashMap;

public class b extends HSLConfigSource {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f5055a = new HashMap<>();

    public b(Context context, HSLVersion hSLVersion) {
        super(context, hSLVersion);
    }

    public void clear() {
        this.f5055a.clear();
    }

    public Object getConfig(String str, HSLConfigDataType hSLConfigDataType) {
        if (!this.f5055a.containsKey(str)) {
            this.f5055a.put(str, c.a(str, true));
        }
        c cVar = this.f5055a.get(str);
        if (cVar != null) {
            return cVar.a(this.mContext, this.mVersion, hSLConfigDataType);
        }
        return null;
    }

    public HSLConfigSourceCode getConfigSourceCode() {
        return HSLConfigSourceCode.def;
    }

    public int getPriority() {
        return HSLConfigPriority.DEFAULT_CONFIG.getPriority();
    }
}
