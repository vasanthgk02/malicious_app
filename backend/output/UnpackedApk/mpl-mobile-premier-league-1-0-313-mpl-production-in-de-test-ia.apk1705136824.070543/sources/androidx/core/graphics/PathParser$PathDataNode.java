package androidx.core.graphics;

import a.a.a.a.d.b;
import android.graphics.Path;
import com.android.tools.r8.GeneratedOutlineSupport;

public class PathParser$PathDataNode {
    public float[] mParams;
    public char mType;

    public PathParser$PathDataNode(char c2, float[] fArr) {
        this.mType = c2;
        this.mParams = fArr;
    }

    public static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
        double d2;
        double d3;
        float f9 = f2;
        float f10 = f4;
        float f11 = f6;
        float f12 = f7;
        boolean z3 = z2;
        double radians = Math.toRadians((double) f8);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d4 = (double) f9;
        double d5 = (double) f3;
        double d6 = (double) f11;
        double d7 = ((d5 * sin) + (d4 * cos)) / d6;
        double d8 = (double) f12;
        double d9 = ((d5 * cos) + (((double) (-f9)) * sin)) / d8;
        double d10 = d6;
        double d11 = (double) f5;
        double d12 = d10;
        double d13 = d5;
        double d14 = d4;
        double outline0 = GeneratedOutlineSupport.outline0(d11, sin, ((double) f10) * cos, d10);
        double outline02 = GeneratedOutlineSupport.outline0(d11, cos, ((double) (-f10)) * sin, d8);
        double d15 = d7 - outline0;
        double d16 = d9 - outline02;
        double d17 = (d7 + outline0) / 2.0d;
        double d18 = (d9 + outline02) / 2.0d;
        double d19 = (d16 * d16) + (d15 * d15);
        if (d19 != 0.0d) {
            double d20 = (1.0d / d19) - 0.25d;
            if (d20 < 0.0d) {
                float sqrt = (float) (Math.sqrt(d19) / 1.99999d);
                drawArc(path, f2, f3, f4, f5, f11 * sqrt, f12 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d20);
            double d21 = d15 * sqrt2;
            double d22 = sqrt2 * d16;
            if (z == z3) {
                d3 = d17 - d22;
                d2 = d18 + d21;
            } else {
                d3 = d17 + d22;
                d2 = d18 - d21;
            }
            double atan2 = Math.atan2(d9 - d2, d7 - d3);
            double atan22 = Math.atan2(outline02 - d2, outline0 - d3) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z3 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d23 = d12;
            double d24 = d3 * d23;
            double d25 = d2 * d8;
            double d26 = (d24 * cos) - (d25 * sin);
            double d27 = (d25 * cos) + (d24 * sin);
            int ceil = (int) Math.ceil(Math.abs((4.0d * atan22) / 3.141592653589793d));
            double cos2 = Math.cos(radians);
            double sin2 = Math.sin(radians);
            double cos3 = Math.cos(atan2);
            double sin3 = Math.sin(atan2);
            double d28 = atan2;
            double d29 = -d23;
            double d30 = d29 * cos2;
            double d31 = d8 * sin2;
            double d32 = (d30 * sin3) - (d31 * cos3);
            double d33 = d29 * sin2;
            double d34 = d8 * cos2;
            double d35 = (cos3 * d34) + (sin3 * d33);
            double d36 = d23;
            double d37 = atan22 / ((double) ceil);
            double d38 = d28;
            int i2 = 0;
            while (i2 < ceil) {
                double d39 = d38 + d37;
                double sin4 = Math.sin(d39);
                double cos4 = Math.cos(d39);
                double d40 = d36;
                double d41 = cos4;
                double d42 = d37;
                double outline2 = GeneratedOutlineSupport.outline2(d40, cos2, d41, d26) - (d31 * sin4);
                double outline22 = GeneratedOutlineSupport.outline2(d40, sin2, d41, d27);
                double d43 = sin2;
                double d44 = (d34 * sin4) + outline22;
                double d45 = (d30 * sin4) - (d31 * cos4);
                double d46 = (cos4 * d34) + (sin4 * d33);
                double d47 = d39 - d38;
                double tan = Math.tan(d47 / 2.0d);
                double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d47)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d32 * sqrt3) + d14), (float) ((d35 * sqrt3) + d13), (float) (outline2 - (sqrt3 * d45)), (float) (d44 - (sqrt3 * d46)), (float) outline2, (float) d44);
                i2++;
                d33 = d33;
                d34 = d34;
                d26 = d26;
                d14 = outline2;
                d13 = d44;
                ceil = ceil;
                d38 = d39;
                cos2 = cos2;
                d35 = d46;
                d32 = d45;
                d37 = d42;
                sin2 = d43;
            }
        }
    }

    public static void nodesToPath(PathParser$PathDataNode[] pathParser$PathDataNodeArr, Path path) {
        int i;
        float f2;
        float f3;
        int i2;
        int i3;
        float[] fArr;
        char c2;
        int i4;
        float[] fArr2;
        char c3;
        int i5;
        float f4;
        float f5;
        float f6;
        float f7;
        int i6;
        float f8;
        float f9;
        int i7;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = pathParser$PathDataNodeArr;
        Path path2 = path;
        float[] fArr3 = new float[6];
        char c4 = 'm';
        char c5 = 0;
        char c6 = 'm';
        int i8 = 0;
        while (i8 < pathParser$PathDataNodeArr2.length) {
            char c7 = pathParser$PathDataNodeArr2[i8].mType;
            float[] fArr4 = pathParser$PathDataNodeArr2[i8].mParams;
            float f25 = fArr3[c5];
            float f26 = fArr3[1];
            float f27 = fArr3[2];
            float f28 = fArr3[3];
            float f29 = fArr3[4];
            float f30 = fArr3[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f29, f30);
                    f25 = f29;
                    f27 = f25;
                    f26 = f30;
                    f28 = f26;
                    break;
            }
            i = 2;
            float f31 = f29;
            float f32 = f30;
            float f33 = f25;
            float f34 = f26;
            int i9 = 0;
            while (i9 < fArr4.length) {
                if (c7 != 'A') {
                    if (c7 != 'C') {
                        if (c7 == 'H') {
                            i2 = i9;
                            fArr = fArr4;
                            c2 = c7;
                            i3 = i8;
                            int i10 = i2 + 0;
                            path2.lineTo(fArr[i10], f34);
                            f33 = fArr[i10];
                        } else if (c7 == 'Q') {
                            i6 = i9;
                            fArr = fArr4;
                            c2 = c7;
                            i3 = i8;
                            int i11 = i6 + 0;
                            int i12 = i6 + 1;
                            int i13 = i6 + 2;
                            int i14 = i6 + 3;
                            path2.quadTo(fArr[i11], fArr[i12], fArr[i13], fArr[i14]);
                            f7 = fArr[i11];
                            f6 = fArr[i12];
                            f33 = fArr[i13];
                            f34 = fArr[i14];
                        } else if (c7 == 'V') {
                            i2 = i9;
                            fArr = fArr4;
                            c2 = c7;
                            i3 = i8;
                            int i15 = i2 + 0;
                            path2.lineTo(f33, fArr[i15]);
                            f34 = fArr[i15];
                        } else if (c7 != 'a') {
                            if (c7 != 'c') {
                                if (c7 == 'h') {
                                    i2 = i9;
                                    float f35 = f34;
                                    int i16 = i2 + 0;
                                    path2.rLineTo(fArr4[i16], 0.0f);
                                    f33 += fArr4[i16];
                                } else if (c7 != 'q') {
                                    if (c7 == 'v') {
                                        i2 = i9;
                                        f15 = f34;
                                        float f36 = f33;
                                        int i17 = i2 + 0;
                                        path2.rLineTo(0.0f, fArr4[i17]);
                                        f16 = fArr4[i17];
                                    } else if (c7 != 'L') {
                                        if (c7 == 'M') {
                                            i2 = i9;
                                            int i18 = i2 + 0;
                                            float f37 = fArr4[i18];
                                            int i19 = i2 + 1;
                                            float f38 = fArr4[i19];
                                            if (i2 > 0) {
                                                path2.lineTo(fArr4[i18], fArr4[i19]);
                                                f33 = f37;
                                                f34 = f38;
                                            } else {
                                                path2.moveTo(fArr4[i18], fArr4[i19]);
                                                f31 = f37;
                                                f32 = f38;
                                            }
                                        } else if (c7 == 'S') {
                                            i7 = i9;
                                            float f39 = f34;
                                            float f40 = f33;
                                            if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                                f17 = (f39 * 2.0f) - f2;
                                                f18 = (f40 * 2.0f) - f3;
                                            } else {
                                                f18 = f40;
                                                f17 = f39;
                                            }
                                            int i20 = i7 + 0;
                                            int i21 = i7 + 1;
                                            int i22 = i7 + 2;
                                            int i23 = i7 + 3;
                                            path.cubicTo(f18, f17, fArr4[i20], fArr4[i21], fArr4[i22], fArr4[i23]);
                                            float f41 = fArr4[i20];
                                            float f42 = fArr4[i21];
                                            f9 = fArr4[i22];
                                            f8 = fArr4[i23];
                                            f3 = f41;
                                            f2 = f42;
                                            f33 = f9;
                                            f34 = f8;
                                        } else if (c7 == 'T') {
                                            i2 = i9;
                                            float f43 = f34;
                                            float f44 = f33;
                                            if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                                f19 = (f44 * 2.0f) - f3;
                                                f20 = (f43 * 2.0f) - f2;
                                            } else {
                                                f19 = f44;
                                                f20 = f43;
                                            }
                                            int i24 = i2 + 0;
                                            int i25 = i2 + 1;
                                            path2.quadTo(f19, f20, fArr4[i24], fArr4[i25]);
                                            f2 = f20;
                                            f3 = f19;
                                            fArr = fArr4;
                                            c2 = c7;
                                            i3 = i8;
                                            f33 = fArr4[i24];
                                            f34 = fArr4[i25];
                                        } else if (c7 == 'l') {
                                            i2 = i9;
                                            f15 = f34;
                                            int i26 = i2 + 0;
                                            int i27 = i2 + 1;
                                            path2.rLineTo(fArr4[i26], fArr4[i27]);
                                            f33 += fArr4[i26];
                                            f16 = fArr4[i27];
                                        } else if (c7 == c4) {
                                            i2 = i9;
                                            int i28 = i2 + 0;
                                            f33 += fArr4[i28];
                                            int i29 = i2 + 1;
                                            f34 += fArr4[i29];
                                            if (i2 > 0) {
                                                path2.rLineTo(fArr4[i28], fArr4[i29]);
                                            } else {
                                                path2.rMoveTo(fArr4[i28], fArr4[i29]);
                                                f32 = f34;
                                                f31 = f33;
                                            }
                                        } else if (c7 != 's') {
                                            if (c7 == 't') {
                                                if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                                    f23 = f33 - f3;
                                                    f24 = f34 - f2;
                                                } else {
                                                    f24 = 0.0f;
                                                    f23 = 0.0f;
                                                }
                                                int i30 = i9 + 0;
                                                int i31 = i9 + 1;
                                                path2.rQuadTo(f23, f24, fArr4[i30], fArr4[i31]);
                                                float f45 = f23 + f33;
                                                float f46 = f24 + f34;
                                                f33 += fArr4[i30];
                                                f34 += fArr4[i31];
                                                f2 = f46;
                                                f3 = f45;
                                            }
                                            i2 = i9;
                                        } else {
                                            if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                                f21 = f34 - f2;
                                                f22 = f33 - f3;
                                            } else {
                                                f22 = 0.0f;
                                                f21 = 0.0f;
                                            }
                                            int i32 = i9 + 0;
                                            int i33 = i9 + 1;
                                            int i34 = i9 + 2;
                                            int i35 = i9 + 3;
                                            i7 = i9;
                                            f10 = f34;
                                            float f47 = f33;
                                            path.rCubicTo(f22, f21, fArr4[i32], fArr4[i33], fArr4[i34], fArr4[i35]);
                                            f13 = fArr4[i32] + f47;
                                            f12 = fArr4[i33] + f10;
                                            f11 = f47 + fArr4[i34];
                                            f14 = fArr4[i35];
                                        }
                                        f33 = f31;
                                        f34 = f32;
                                    } else {
                                        i2 = i9;
                                        int i36 = i2 + 0;
                                        int i37 = i2 + 1;
                                        path2.lineTo(fArr4[i36], fArr4[i37]);
                                        f33 = fArr4[i36];
                                        f34 = fArr4[i37];
                                    }
                                    f34 = f15 + f16;
                                } else {
                                    i7 = i9;
                                    f10 = f34;
                                    float f48 = f33;
                                    int i38 = i7 + 0;
                                    int i39 = i7 + 1;
                                    int i40 = i7 + 2;
                                    int i41 = i7 + 3;
                                    path2.rQuadTo(fArr4[i38], fArr4[i39], fArr4[i40], fArr4[i41]);
                                    f13 = fArr4[i38] + f48;
                                    f12 = fArr4[i39] + f10;
                                    float f49 = f48 + fArr4[i40];
                                    float f50 = fArr4[i41];
                                    f11 = f49;
                                    f14 = f50;
                                }
                                fArr = fArr4;
                                c2 = c7;
                                i3 = i8;
                            } else {
                                i7 = i9;
                                f10 = f34;
                                float f51 = f33;
                                int i42 = i7 + 2;
                                int i43 = i7 + 3;
                                int i44 = i7 + 4;
                                int i45 = i7 + 5;
                                path.rCubicTo(fArr4[i7 + 0], fArr4[i7 + 1], fArr4[i42], fArr4[i43], fArr4[i44], fArr4[i45]);
                                f13 = fArr4[i42] + f51;
                                f12 = fArr4[i43] + f10;
                                f11 = f51 + fArr4[i44];
                                f14 = fArr4[i45];
                            }
                            f8 = f10 + f14;
                            f3 = f13;
                            f2 = f12;
                            f9 = f11;
                            f33 = f9;
                            f34 = f8;
                            fArr = fArr4;
                            c2 = c7;
                            i3 = i8;
                        } else {
                            i4 = i9;
                            float f52 = f34;
                            float f53 = f33;
                            int i46 = i4 + 5;
                            float f54 = fArr4[i46] + f53;
                            int i47 = i4 + 6;
                            float f55 = fArr4[i47] + f52;
                            float f56 = fArr4[i4 + 0];
                            float f57 = fArr4[i4 + 1];
                            float f58 = fArr4[i4 + 2];
                            boolean z = fArr4[i4 + 3] != 0.0f;
                            boolean z2 = fArr4[i4 + 4] != 0.0f;
                            fArr2 = fArr4;
                            float f59 = f58;
                            c3 = c7;
                            i5 = i8;
                            drawArc(path, f53, f52, f54, f55, f56, f57, f59, z, z2);
                            f4 = f53 + fArr2[i46];
                            f5 = f52 + fArr2[i47];
                        }
                        i9 = i2 + i;
                        c6 = c2;
                        c7 = c6;
                        fArr4 = fArr;
                        i8 = i3;
                        c4 = 'm';
                        PathParser$PathDataNode[] pathParser$PathDataNodeArr3 = pathParser$PathDataNodeArr;
                    } else {
                        i6 = i9;
                        fArr = fArr4;
                        c2 = c7;
                        i3 = i8;
                        int i48 = i6 + 2;
                        int i49 = i6 + 3;
                        int i50 = i6 + 4;
                        int i51 = i6 + 5;
                        path.cubicTo(fArr[i6 + 0], fArr[i6 + 1], fArr[i48], fArr[i49], fArr[i50], fArr[i51]);
                        float f60 = fArr[i50];
                        float f61 = fArr[i51];
                        f7 = fArr[i48];
                        f33 = f60;
                        f34 = f61;
                        f6 = fArr[i49];
                    }
                    f3 = f7;
                    f2 = f6;
                    i9 = i2 + i;
                    c6 = c2;
                    c7 = c6;
                    fArr4 = fArr;
                    i8 = i3;
                    c4 = 'm';
                    PathParser$PathDataNode[] pathParser$PathDataNodeArr32 = pathParser$PathDataNodeArr;
                } else {
                    i4 = i9;
                    fArr2 = fArr4;
                    c3 = c7;
                    i5 = i8;
                    int i52 = i4 + 5;
                    int i53 = i4 + 6;
                    drawArc(path, f33, f34, fArr2[i52], fArr2[i53], fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                    f4 = fArr2[i52];
                    f5 = fArr2[i53];
                }
                f2 = f34;
                f3 = f33;
                i9 = i2 + i;
                c6 = c2;
                c7 = c6;
                fArr4 = fArr;
                i8 = i3;
                c4 = 'm';
                PathParser$PathDataNode[] pathParser$PathDataNodeArr322 = pathParser$PathDataNodeArr;
            }
            int i54 = i8;
            fArr3[0] = f33;
            fArr3[1] = f34;
            fArr3[2] = f3;
            fArr3[3] = f2;
            fArr3[4] = f31;
            fArr3[5] = f32;
            i8 = i54 + 1;
            c6 = pathParser$PathDataNodeArr[i54].mType;
            c4 = 'm';
            c5 = 0;
            pathParser$PathDataNodeArr2 = pathParser$PathDataNodeArr;
        }
    }

    public PathParser$PathDataNode(PathParser$PathDataNode pathParser$PathDataNode) {
        this.mType = pathParser$PathDataNode.mType;
        float[] fArr = pathParser$PathDataNode.mParams;
        this.mParams = b.copyOfRange(fArr, 0, fArr.length);
    }
}
