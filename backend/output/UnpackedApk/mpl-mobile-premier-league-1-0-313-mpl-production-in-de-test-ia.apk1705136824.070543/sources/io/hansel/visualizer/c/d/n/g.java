package io.hansel.visualizer.c.d.n;

import android.view.View;
import android.view.ViewGroup;
import io.hansel.visualizer.c.d.a;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class g extends a<ViewGroup> {

    /* renamed from: b  reason: collision with root package name */
    public final Map<View, Object> f5840b = Collections.synchronizedMap(new WeakHashMap());

    private Object a(View view, Object obj) {
        return obj == this ? view : ((WeakReference) obj).get();
    }

    private Object a(ViewGroup viewGroup, View view) {
        Object obj = this.f5840b.get(view);
        if (obj != null) {
            Object a2 = a(view, obj);
            if (a2 != null && view.getParent() == viewGroup) {
                return a2;
            }
            this.f5840b.remove(view);
        }
        this.f5840b.put(view, this);
        return view;
    }

    /* renamed from: a */
    public void b(ViewGroup viewGroup, io.hansel.visualizer.b.a<Object> aVar) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            aVar.a(a(viewGroup, viewGroup.getChildAt(i)));
        }
    }
}
