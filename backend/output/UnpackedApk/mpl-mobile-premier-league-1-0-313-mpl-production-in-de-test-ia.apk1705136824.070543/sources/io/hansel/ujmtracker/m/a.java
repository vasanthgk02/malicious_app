package io.hansel.ujmtracker.m;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;

public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f5344f = new a();

    /* renamed from: a  reason: collision with root package name */
    public g f5345a = new g();

    /* renamed from: b  reason: collision with root package name */
    public Context f5346b;

    /* renamed from: c  reason: collision with root package name */
    public c f5347c;

    /* renamed from: d  reason: collision with root package name */
    public HSLTaskHandler f5348d;

    /* renamed from: e  reason: collision with root package name */
    public HSLSDKIdentifiers f5349e;

    /* renamed from: io.hansel.ujmtracker.m.a$a  reason: collision with other inner class name */
    public enum C0081a {
        eventtrackerujm
    }

    private void a(d dVar, String str) {
        f a2 = this.f5345a.a(str);
        if (a2 != null) {
            a2.b(dVar);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("No data handler found for groupId ", str));
    }

    public static a c() {
        return f5344f;
    }

    public Context a() {
        return this.f5346b;
    }

    public void a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler) {
        this.f5346b = context;
        this.f5348d = hSLTaskHandler;
        this.f5349e = hSLSDKIdentifiers;
    }

    public void a(HSLServerRequest hSLServerRequest) {
        this.f5348d.schedule(hSLServerRequest);
    }

    public void a(h hVar) {
        this.f5345a.a(new f(hVar), hVar.b());
        try {
            c().b();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public void a(Object obj, String str, long j, String str2) {
        a(new d(obj, str, j), str2);
    }

    public void a(boolean z) {
        d().a().sendEmptyMessage(z ? -2 : 0);
    }

    public c b() {
        if (this.f5347c == null) {
            if (a() != null) {
                c cVar = new c(a());
                this.f5347c = cVar;
                cVar.a(this);
            } else {
                throw new Exception("initialize method not called");
            }
        }
        return this.f5347c;
    }

    public g d() {
        return this.f5345a;
    }

    public HSLSDKIdentifiers e() {
        return this.f5349e;
    }
}
