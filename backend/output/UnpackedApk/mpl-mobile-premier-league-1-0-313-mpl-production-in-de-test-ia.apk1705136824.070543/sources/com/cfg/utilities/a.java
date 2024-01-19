package com.cfg.utilities;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.files.FileHandle;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Handle f2373a = Handle.INTERNAL;

    /* renamed from: com.cfg.utilities.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0037a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2374a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.cfg.utilities.Handle[] r0 = com.cfg.utilities.Handle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2374a = r0
                r1 = 1
                com.cfg.utilities.Handle r2 = com.cfg.utilities.Handle.LOCAL     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2374a     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.cfg.utilities.Handle r3 = com.cfg.utilities.Handle.INTERNAL     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f2374a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cfg.utilities.Handle r2 = com.cfg.utilities.Handle.EXTERNAL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cfg.utilities.a.C0037a.<clinit>():void");
        }
    }

    public a(Handle handle) {
        this.f2373a = handle;
    }

    public FileHandle a(String str) {
        int i = C0037a.f2374a[this.f2373a.ordinal()];
        if (i == 1) {
            return k.files.local(str);
        }
        if (i == 2) {
            return k.files.internal(str);
        }
        if (i != 3) {
            return null;
        }
        return k.files.external(str);
    }
}
