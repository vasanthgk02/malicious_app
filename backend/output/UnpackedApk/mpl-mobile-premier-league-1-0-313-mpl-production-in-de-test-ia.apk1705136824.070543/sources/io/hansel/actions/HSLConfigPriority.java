package io.hansel.actions;

public enum HSLConfigPriority {
    JOURNEY,
    DEFAULT_CONFIG,
    SUPER_CONFIG,
    LOCALE_CONFIG;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5047a = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                io.hansel.actions.HSLConfigPriority[] r0 = io.hansel.actions.HSLConfigPriority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5047a = r0
                r1 = 1
                io.hansel.actions.HSLConfigPriority r2 = io.hansel.actions.HSLConfigPriority.JOURNEY     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f5047a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.actions.HSLConfigPriority r3 = io.hansel.actions.HSLConfigPriority.DEFAULT_CONFIG     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f5047a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.hansel.actions.HSLConfigPriority r3 = io.hansel.actions.HSLConfigPriority.SUPER_CONFIG     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5047a     // Catch:{ NoSuchFieldError -> 0x0024 }
                io.hansel.actions.HSLConfigPriority r2 = io.hansel.actions.HSLConfigPriority.LOCALE_CONFIG     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.actions.HSLConfigPriority.a.<clinit>():void");
        }
    }

    public int getPriority() {
        int i = a.f5047a[ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 5;
                    }
                }
            }
        }
        return i2;
    }
}
