package co.hyperverge.hvcamera.magicfilter.camera;

import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Map;

public class CameraEngine {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2908a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2909b = false;

    /* renamed from: d  reason: collision with root package name */
    public static float f2910d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2911e;

    public static boolean getCaptureMode() {
        if (f2908a) {
            return b.f2918b;
        }
        return a.t;
    }

    public static boolean isFrontFacingCamera() {
        if (f2908a) {
            return b.f2921e;
        }
        return a.s();
    }

    public static void rotateNV21a(byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        int i4;
        int i5;
        if (i3 % 90 != 0 || i3 < 0 || i3 > 270) {
            throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
        }
        boolean z = i3 % RotationOptions.ROTATE_180 != 0;
        boolean z2 = i3 % 270 != 0;
        boolean z3 = i3 >= 180;
        int i6 = z ? i2 : i;
        int i7 = z ? i : i2;
        if (z) {
            i4 = (z2 ? i6 - 1 : 0) + (z3 ? (i7 - 1) * i6 : 0);
            i5 = (i7 * i6) + 1;
        } else {
            i4 = (z2 ? i6 - 1 : 0) + ((z3 ? i7 - 1 : 0) * i6);
            i5 = 0;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            if (z) {
                int i10 = 0;
                while (i10 < i) {
                    int i11 = i8 + 1;
                    bArr2[i4] = (byte) (bArr[i8] & 255);
                    i4 += z3 ? -i6 : i6;
                    i10++;
                    i8 = i11;
                }
                i4 += z3 ? i5 : -i5;
            } else {
                int i12 = 0;
                while (i12 < i) {
                    int i13 = i8 + 1;
                    bArr2[i4] = (byte) (bArr[i8] & 255);
                    i4 += z2 ? -1 : 1;
                    i12++;
                    i8 = i13;
                }
            }
        }
    }

    public static void setFeatureConfig(Map<String, Boolean> map) {
        if (map.containsKey("camera2")) {
            f2908a = map.get("camera2").booleanValue();
        }
    }
}
