package co.hyperverge.hypersnapsdk.a;

import android.content.Context;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.model.LivenessResponse;
import co.hyperverge.hypersnapsdk.objects.HVDocConfig;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import java.util.Map;

/* compiled from: AnalyticsTracker */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f2951a = a.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    public b f2952b;

    public a(Context context) {
        try {
            Map<String, Boolean> j = n.m().j();
            if ((j == null || !j.containsKey("analytics")) ? true : j.get("analytics").booleanValue()) {
                if (co.hyperverge.hypersnapsdk.a.c.a.f2953b == null) {
                    co.hyperverge.hypersnapsdk.a.c.a.f2953b = new co.hyperverge.hypersnapsdk.a.c.a(context);
                }
                this.f2952b = co.hyperverge.hypersnapsdk.a.c.a.f2953b;
                return;
            }
            this.f2952b = null;
        } catch (Exception e2) {
            e = e2;
            this.f2952b = null;
            i.a(e);
        } catch (NoClassDefFoundError e3) {
            e = e3;
            this.f2952b = null;
            i.a(e);
        }
    }

    public void B() {
    }

    public void C() {
    }

    public void D() {
    }

    public final boolean E() {
        return this.f2952b != null;
    }

    public void a() {
    }

    public void a(long j) {
    }

    public void a(LivenessResponse livenessResponse, HVError hVError) {
    }

    public void a(LivenessResponse livenessResponse, HVFaceConfig hVFaceConfig, long j) {
    }

    public void a(LivenessResponse livenessResponse, String str, long j) {
    }

    public void a(HVDocConfig hVDocConfig, long j) {
    }

    public void a(HVDocConfig hVDocConfig, String str, long j) {
    }

    public void a(HVError hVError, long j) {
    }

    public void a(HVError hVError, LivenessResponse livenessResponse, HVFaceConfig hVFaceConfig) {
    }

    public void a(HVError hVError, HVDocConfig hVDocConfig, long j) {
    }

    public void a(HVError hVError, HVFaceConfig hVFaceConfig, long j) {
    }

    public void a(HVFaceConfig hVFaceConfig) {
        if (E()) {
            this.f2952b.a(hVFaceConfig);
        }
    }

    public void a(HVFaceConfig hVFaceConfig, String str, long j) {
    }

    public void a(HVResponse hVResponse, HVError hVError) {
    }

    public void a(HVResponse hVResponse, String str, long j) {
    }

    public void a(String str, int i) {
    }

    public void a(String str, long j, long j2) {
    }

    public void a(String str, String str2) {
    }

    public void b() {
    }

    public void b(long j) {
    }

    public void b(HVDocConfig hVDocConfig) {
    }

    public void b(HVDocConfig hVDocConfig, long j) {
    }

    public void b(HVError hVError) {
    }

    public void b(HVError hVError, long j) {
        if (E()) {
            this.f2952b.b(hVError, j);
        }
    }

    public void b(HVFaceConfig hVFaceConfig) {
    }

    public void b(HVFaceConfig hVFaceConfig, long j) {
    }

    public void b(String str, int i) {
    }

    public void b(String str, String str2) {
    }

    public void c(long j) {
    }

    public void c(HVDocConfig hVDocConfig) {
    }

    public void c(HVError hVError) {
        if (E()) {
            this.f2952b.c(hVError);
        }
    }

    public void c(HVFaceConfig hVFaceConfig) {
    }

    public void d() {
    }

    public void d(long j) {
    }

    public void d(HVDocConfig hVDocConfig, long j) {
        if (E()) {
            this.f2952b.d(hVDocConfig, j);
        }
    }

    public void d(HVError hVError) {
    }

    public void e() {
        if (E()) {
            this.f2952b.e();
        }
    }

    public void e(HVError hVError) {
    }

    public void f() {
    }

    public void f(long j) {
    }

    public void g(long j) {
    }

    public void g(HVError hVError) {
    }

    public void h() {
    }

    public void h(long j) {
    }

    public void h(HVError hVError) {
    }

    public void i() {
    }

    public void i(long j) {
    }

    public void i(HVError hVError) {
    }

    public void j() {
        if (E()) {
            this.f2952b.j();
        }
    }

    public void j(long j) {
    }

    public void j(HVError hVError) {
    }

    public void k() {
    }

    public void k(long j) {
    }

    public void l() {
    }

    public void l(long j) {
    }

    public void m() {
    }

    public void m(long j) {
    }

    public void n() {
    }

    public void n(long j) {
    }

    public void o() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }

    public void a(HVFaceConfig hVFaceConfig, long j) {
        if (E()) {
            this.f2952b.a(hVFaceConfig, j);
        }
    }

    public void c(HVDocConfig hVDocConfig, long j) {
        if (E()) {
            this.f2952b.c(hVDocConfig, j);
        }
    }

    public void e(long j) {
        if (E()) {
            this.f2952b.e(j);
        }
    }

    public void a(HVDocConfig hVDocConfig) {
        if (E()) {
            this.f2952b.a(hVDocConfig);
        }
    }

    public void a(HVDocConfig hVDocConfig, int i, long j) {
        if (E()) {
            this.f2952b.a(hVDocConfig, i, j);
        }
    }
}
