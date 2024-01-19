package io.hansel.userjourney.prompts.d;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.segments.c;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f5503a;

    /* renamed from: b  reason: collision with root package name */
    public b f5504b;

    public a(Context context, CoreJSONObject coreJSONObject) {
        this.f5503a = new f(context);
        this.f5504b = new b(context, coreJSONObject.optJSONObject("prompt").optJSONObject("props").optString("btnContainerSpacing"), this.f5503a);
    }

    public void a() {
        this.f5504b.a();
    }

    public void a(boolean z) {
        this.f5504b.a(z);
    }

    public boolean a(View view, CoreJSONObject coreJSONObject, int i) {
        return this.f5503a.a(view, coreJSONObject, i);
    }

    public boolean a(View view, CoreJSONObject coreJSONObject, int i, c cVar, int i2, int i3, int i4, List<TextView> list, Set<String> set, HashMap<String, Object> hashMap) {
        return this.f5504b.a(view, coreJSONObject, i, cVar, i2, i3, i4, list, set, hashMap);
    }

    public int b() {
        return this.f5504b.c();
    }

    public int c() {
        return this.f5504b.b();
    }
}
