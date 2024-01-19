package io.hansel.hanselsdk;

import io.hansel.core.b;
import io.hansel.core.filters.HSLFiltersInternal;
import java.util.Map;

public class HanselUser {
    public void clear() {
        b.e().a();
    }

    public void clearAttribute(String str) {
        HSLFiltersInternal.getInstance().remove(str);
    }

    public void putAttribute(String str, double d2) {
        HSLFiltersInternal.getInstance().put(str, d2);
    }

    public void putAttribute(String str, String str2) {
        HSLFiltersInternal.getInstance().put(str, str2);
    }

    public void putAttribute(String str, boolean z) {
        HSLFiltersInternal.getInstance().put(str, z);
    }

    public void putAttributes(Map<String, ?> map) {
        HSLFiltersInternal.getInstance().put(map, false);
    }

    public void putPrivateAttribute(String str, double d2) {
        HSLFiltersInternal.getInstance().put(str, d2, true);
    }

    public void putPrivateAttribute(String str, String str2) {
        HSLFiltersInternal.getInstance().put(str, str2, true);
    }

    public void putPrivateAttribute(String str, boolean z) {
        HSLFiltersInternal.getInstance().put(str, z, true);
    }

    public void setUserId(String str) {
        b.e().c(str);
    }
}
