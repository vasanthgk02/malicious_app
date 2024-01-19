package co.hyperverge.hvcamera;

import android.hardware.Camera;
import android.hardware.Camera.Size;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f2842a = -1;

    /* renamed from: co.hyperverge.hvcamera.a$a  reason: collision with other inner class name */
    public class C0044a implements Comparator<Size> {
        public int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            return (size2.width * size2.height) - (size.width * size.height);
        }
    }

    public class b implements Comparator<Size> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2843a;

        public b(int i) {
            this.f2843a = i;
        }

        public int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            return Math.abs((size.width * size.height) - this.f2843a) - Math.abs((size2.width * size2.height) - this.f2843a);
        }
    }

    public static Size a(Camera camera, int i, int i2, float f2, boolean z) {
        List<Size> supportedPictureSizes = camera.getParameters().getSupportedPictureSizes();
        Collections.sort(supportedPictureSizes, new C0044a());
        if (z && !supportedPictureSizes.isEmpty()) {
            return supportedPictureSizes.get(0);
        }
        for (Size next : supportedPictureSizes) {
            int i3 = next.width;
            int i4 = i3 * i;
            int i5 = next.height;
            if (i4 == i5 * i2 && ((int) (1000000.0f * f2)) > i3 * i5) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
        if (r0.equals("" + r3) == false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r3, android.hardware.Camera r4, int r5) {
        /*
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
            android.hardware.Camera.getCameraInfo(r3, r0)
            int r5 = r5 + 45
            int r5 = r5 / 90
            int r5 = r5 * 90
            int r3 = r0.facing
            r1 = 1
            if (r3 != r1) goto L_0x001b
            int r3 = r0.orientation
            int r3 = r3 - r5
            int r3 = r3 + 360
            int r3 = r3 % 360
            goto L_0x0020
        L_0x001b:
            int r3 = r0.orientation
            int r3 = r3 + r5
            int r3 = r3 % 360
        L_0x0020:
            int r5 = f2842a
            if (r5 == r3) goto L_0x0053
            android.hardware.Camera$Parameters r5 = r4.getParameters()
            java.lang.String r0 = "rotation"
            java.lang.String r1 = r5.get(r0)
            if (r1 == 0) goto L_0x004b
            java.lang.String r0 = r5.get(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0051
        L_0x004b:
            r5.setRotation(r3)
            r4.setParameters(r5)
        L_0x0051:
            f2842a = r3
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hvcamera.a.a(int, android.hardware.Camera, int):void");
    }
}
