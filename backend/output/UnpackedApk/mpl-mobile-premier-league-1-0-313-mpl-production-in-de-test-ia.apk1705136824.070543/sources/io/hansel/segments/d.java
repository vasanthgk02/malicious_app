package io.hansel.segments;

import android.content.Context;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.userjourney.prompts.h0;

public class d implements c {
    public String a(Context context, String str, String str2, String str3) {
        return h0.a(j.b(context, str, str2, str3));
    }

    public String a(String str) {
        return h0.a(HSLFiltersInternal.getInstance().getObject(str));
    }
}
