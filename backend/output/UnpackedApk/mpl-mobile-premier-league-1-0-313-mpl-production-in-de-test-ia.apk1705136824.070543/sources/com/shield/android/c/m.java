package com.shield.android.c;

import android.content.Context;
import com.shield.android.d.f;
import com.shield.android.g.a;
import com.shield.android.internal.NativeUtils;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class m extends f {

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f1533b;

    /* renamed from: c  reason: collision with root package name */
    public final NativeUtils f1534c;

    /* renamed from: d  reason: collision with root package name */
    public final a f1535d;

    public m(Context context, NativeUtils nativeUtils) {
        this.f1534c = nativeUtils;
        this.f1535d = new a(nativeUtils);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (this.f1534c.a() ? this.f1534c.listenForFrida() : false) {
            if (fVar != null) {
                fVar.a();
            }
            this.f1533b.shutdownNow();
            this.f1533b = null;
        }
    }
}
