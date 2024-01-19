package io.hansel.core.d;

import android.content.Context;
import io.hansel.core.utils.HSLUtils;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5162a;

    public c(Context context) {
        this.f5162a = context;
    }

    public String a(String str) {
        if (!str.startsWith("hsl_td_auth_")) {
            return null;
        }
        String replace = str.replace("hsl_td_auth_", "");
        HSLUtils.clearClipboard(this.f5162a);
        return replace;
    }
}
