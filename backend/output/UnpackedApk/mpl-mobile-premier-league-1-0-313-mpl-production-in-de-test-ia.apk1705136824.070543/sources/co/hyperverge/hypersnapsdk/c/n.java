package co.hyperverge.hypersnapsdk.c;

import android.content.Context;
import co.hyperverge.hypersnapsdk.b.c;
import co.hyperverge.hypersnapsdk.b.d;
import co.hyperverge.hypersnapsdk.b.e;
import co.hyperverge.hypersnapsdk.service.a.b;
import co.hyperverge.hypersnapsdk.service.d.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SDKInternalConfig */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static n f3127a;

    /* renamed from: b  reason: collision with root package name */
    public String f3128b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3129d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3130e = true;
    public String h;
    public b i;
    public co.hyperverge.hypersnapsdk.a.b j;
    public e k;
    public a l;
    public Map<String, Boolean> m;
    public boolean n = false;
    public boolean o;

    public static n m() {
        if (f3127a == null) {
            f3127a = new n();
        }
        return f3127a;
    }

    public co.hyperverge.hypersnapsdk.a.b a(Context context) {
        if (this.j == null) {
            this.j = new co.hyperverge.hypersnapsdk.a.a(context);
        }
        return this.j;
    }

    public b b(Context context) {
        if (this.i == null) {
            this.i = new co.hyperverge.hypersnapsdk.service.a.a(context);
        }
        return this.i;
    }

    public Map<String, Boolean> j() {
        if (this.m == null) {
            this.m = new HashMap();
        }
        return this.m;
    }

    public e p() {
        if (this.k == null) {
            this.k = new e();
        }
        return this.k;
    }

    public boolean t() {
        if (this.f3129d) {
            Map<String, Boolean> j2 = m().j();
            if (j2 != null && j2.containsKey("face-detection")) {
                this.f3129d = j2.get("face-detection").booleanValue();
            }
        }
        return this.f3129d;
    }

    public boolean w() {
        Map<String, Boolean> j2 = m().j();
        if (j2 != null && j2.containsKey("image-injection")) {
            this.f3130e = j2.get("image-injection").booleanValue();
        }
        return this.f3130e;
    }

    public void a() {
        e eVar = new e();
        c cVar = new c();
        cVar.f3019b = "a41ad40816ef4065f804046da95d5724";
        d dVar = new d();
        dVar.f3020a = true;
        dVar.f3021b = true;
        dVar.f3022c = true;
        dVar.f3023d = true;
        dVar.f3024e = true;
        dVar.f3025f = true;
        dVar.g = true;
        dVar.h = true;
        dVar.i = true;
        dVar.j = true;
        dVar.k = true;
        cVar.f3018a = dVar;
        eVar.f3027b = cVar;
        eVar.f3026a = true;
        this.k = eVar;
    }
}
