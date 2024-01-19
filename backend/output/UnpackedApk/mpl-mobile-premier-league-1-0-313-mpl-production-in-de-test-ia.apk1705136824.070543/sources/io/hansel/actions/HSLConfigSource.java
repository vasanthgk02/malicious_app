package io.hansel.actions;

import android.content.Context;
import io.hansel.core.base.utils.HSLVersion;

public abstract class HSLConfigSource {
    public Context mContext;
    public HSLVersion mVersion;

    public HSLConfigSource(Context context, HSLVersion hSLVersion) {
        this.mContext = context;
        this.mVersion = hSLVersion;
    }

    public abstract void clear();

    public abstract Object getConfig(String str, HSLConfigDataType hSLConfigDataType);

    public Object getConfig(String str, HSLConfigDataType hSLConfigDataType, String str2) {
        return null;
    }

    public abstract HSLConfigSourceCode getConfigSourceCode();

    public abstract int getPriority();
}
