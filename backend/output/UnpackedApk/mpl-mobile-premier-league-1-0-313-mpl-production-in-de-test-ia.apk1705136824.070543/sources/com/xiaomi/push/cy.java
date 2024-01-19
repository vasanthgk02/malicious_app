package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.C0097r.b;
import java.util.ArrayList;

public final class cy extends b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4597a;

    public cy(Context context) {
        this.f4597a = context;
    }

    public void b() {
        ArrayList arrayList;
        synchronized (cx.a()) {
            arrayList = new ArrayList(cx.a());
            cx.a().clear();
        }
        cx.b(this.f4597a, arrayList);
    }
}
