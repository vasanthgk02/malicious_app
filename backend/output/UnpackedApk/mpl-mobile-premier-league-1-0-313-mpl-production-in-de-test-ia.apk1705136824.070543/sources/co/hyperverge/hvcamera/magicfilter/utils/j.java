package co.hyperverge.hvcamera.magicfilter.utils;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f2940a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f2941b = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f2942c = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f2943d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f2944e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2945a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
        static {
            /*
                co.hyperverge.hvcamera.magicfilter.utils.f[] r0 = co.hyperverge.hvcamera.magicfilter.utils.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2945a = r0
                co.hyperverge.hvcamera.magicfilter.utils.f r1 = co.hyperverge.hvcamera.magicfilter.utils.f.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f2945a     // Catch:{ NoSuchFieldError -> 0x0015 }
                co.hyperverge.hvcamera.magicfilter.utils.f r1 = co.hyperverge.hvcamera.magicfilter.utils.f.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = f2945a     // Catch:{ NoSuchFieldError -> 0x001c }
                co.hyperverge.hvcamera.magicfilter.utils.f r1 = co.hyperverge.hvcamera.magicfilter.utils.f.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x001c }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r0 = f2945a     // Catch:{ NoSuchFieldError -> 0x0024 }
                co.hyperverge.hvcamera.magicfilter.utils.f r1 = co.hyperverge.hvcamera.magicfilter.utils.f.NORMAL     // Catch:{ NoSuchFieldError -> 0x0024 }
                r1 = 0
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.magicfilter.utils.j.a.<clinit>():void");
        }
    }

    public static float a(float f2) {
        return f2 < 0.1f ? 1.0f : 0.0f;
    }

    public static float[] a(f fVar, boolean z, boolean z2) {
        float[] fArr;
        int i = a.f2945a[fVar.ordinal()];
        if (i == 1) {
            fArr = f2941b;
        } else if (i == 2) {
            fArr = f2942c;
        } else if (i != 3) {
            fArr = f2940a;
        } else {
            fArr = f2943d;
        }
        if (z) {
            fArr = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        if (!z2) {
            return fArr;
        }
        return new float[]{fArr[0], a(fArr[1]), fArr[2], a(fArr[3]), fArr[4], a(fArr[5]), fArr[6], a(fArr[7])};
    }
}
