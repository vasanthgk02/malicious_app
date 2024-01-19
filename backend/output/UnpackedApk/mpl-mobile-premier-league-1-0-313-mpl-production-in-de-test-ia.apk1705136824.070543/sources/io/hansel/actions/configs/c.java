package io.hansel.actions.configs;

import android.content.Context;
import io.hansel.actions.HSLConfigDataType;
import io.hansel.core.base.utils.HSLVersion;
import io.hansel.core.utils.HSLUtils;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public d f5056a;

    /* renamed from: b  reason: collision with root package name */
    public g f5057b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5058c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f5059d;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5060a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                io.hansel.actions.configs.f[] r0 = io.hansel.actions.configs.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5060a = r0
                r1 = 1
                io.hansel.actions.configs.f r2 = io.hansel.actions.configs.f.HC     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f5060a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.actions.configs.f r2 = io.hansel.actions.configs.f.USR     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.actions.configs.c.a.<clinit>():void");
        }
    }

    public static c a(d dVar, boolean z, String str) {
        c cVar = new c();
        cVar.f5058c = z;
        cVar.f5059d = str;
        cVar.f5056a = dVar;
        if (dVar != null) {
            cVar.f5057b = dVar.d();
        }
        return cVar;
    }

    public static c a(String str, boolean z) {
        return a(a.b().a(str), z, (String) null);
    }

    private Object a(Context context, HSLConfigDataType hSLConfigDataType) {
        Object obj = null;
        if (this.f5057b == null) {
            return null;
        }
        if (!HSLUtils.isSet(this.f5059d) && this.f5058c && this.f5056a.c() != null) {
            int i = a.f5060a[this.f5056a.c().ordinal()];
            if (i == 1) {
                obj = h.b().a(this.f5056a.b(), null, hSLConfigDataType);
            } else if (i == 2) {
                obj = j.a(context, null, this.f5056a.b(), null, hSLConfigDataType);
            }
        }
        return obj == null ? this.f5057b.a() : obj;
    }

    public Object a(Context context, HSLVersion hSLVersion, HSLConfigDataType hSLConfigDataType) {
        d dVar = this.f5056a;
        if (dVar == null) {
            return null;
        }
        if (dVar.a() == null || this.f5056a.a().isEmpty() || this.f5056a.a().contains(hSLVersion.versionName)) {
            return a(context, hSLConfigDataType);
        }
        return null;
    }
}
