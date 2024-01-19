package org.objectweb.asm;

import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import org.apache.fontbox.ttf.GlyfDescript;
import sfs2x.client.entities.invitation.InvitationReply;

public class MethodWriter extends MethodVisitor {
    public ByteVector $;
    public int A;
    public Handler B;
    public Handler C;
    public int D;
    public ByteVector E;
    public int F;
    public ByteVector G;
    public int H;
    public ByteVector I;
    public Attribute J;
    public boolean K;
    public int L;
    public final int M;
    public Label N;
    public Label O;
    public Label P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public AnnotationWriter U;
    public AnnotationWriter V;
    public AnnotationWriter W;
    public AnnotationWriter X;
    public int Y;
    public int Z;

    /* renamed from: b  reason: collision with root package name */
    public final ClassWriter f6236b;

    /* renamed from: c  reason: collision with root package name */
    public int f6237c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6238d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6239e;

    /* renamed from: f  reason: collision with root package name */
    public final String f6240f;
    public String g;
    public int h;
    public int i;
    public int j;
    public int[] k;
    public ByteVector l;
    public AnnotationWriter m;
    public AnnotationWriter n;
    public AnnotationWriter[] o;
    public AnnotationWriter[] p;
    public Attribute q;
    public ByteVector r = new ByteVector();
    public int s;
    public int t;
    public int u;
    public ByteVector v;
    public int w;
    public int[] x;
    public int[] z;

    public MethodWriter(ClassWriter classWriter, int i2, String str, String str2, String str3, String[] strArr, boolean z2, boolean z3) {
        super(327680);
        if (classWriter.D == null) {
            classWriter.D = this;
        } else {
            classWriter.E.mv = this;
        }
        classWriter.E = this;
        this.f6236b = classWriter;
        this.f6237c = i2;
        if ("<init>".equals(str)) {
            this.f6237c |= 524288;
        }
        this.f6238d = classWriter.newUTF8(str);
        this.f6239e = classWriter.newUTF8(str2);
        this.f6240f = str2;
        this.g = str3;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.j = length;
            this.k = new int[length];
            for (int i4 = 0; i4 < this.j; i4++) {
                this.k[i4] = classWriter.newClass(strArr[i4]);
            }
        }
        this.M = !z3 ? z2 ? 1 : 2 : i3;
        if (z2 || z3) {
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(this.f6240f) >> 2;
            argumentsAndReturnSizes = (i2 & 8) != 0 ? argumentsAndReturnSizes - 1 : argumentsAndReturnSizes;
            this.t = argumentsAndReturnSizes;
            this.T = argumentsAndReturnSizes;
            Label label = new Label();
            this.N = label;
            label.f6230a |= 8;
            visitLabel(label);
        }
    }

    public static int a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << GlyfDescript.X_DUAL) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static int a(int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = i3 - i2;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (i2 < iArr[i5] && iArr[i5] <= i3) {
                i4 += iArr2[i5];
            } else if (i3 < iArr[i5] && iArr[i5] <= i2) {
                i4 -= iArr2[i5];
            }
        }
        return i4;
    }

    public static void a(int[] iArr, int[] iArr2, Label label) {
        if ((label.f6230a & 4) == 0) {
            label.f6232c = a(iArr, iArr2, 0, label.f6232c);
            label.f6230a |= 4;
        }
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    public final int a(int i2, int i3, int i4) {
        int i5 = i3 + 3 + i4;
        int[] iArr = this.z;
        if (iArr == null || iArr.length < i5) {
            this.z = new int[i5];
        }
        int[] iArr2 = this.z;
        iArr2[0] = i2;
        iArr2[1] = i3;
        iArr2[2] = i4;
        return 3;
    }

    public final void a(int i2, int i3) {
        int i4;
        ByteVector byteVector;
        char c2;
        while (i2 < i3) {
            int i5 = this.z[i2];
            int i6 = -268435456 & i5;
            if (i6 == 0) {
                int i7 = i5 & 1048575;
                int i8 = i5 & 267386880;
                if (i8 == 24117248) {
                    byteVector = this.v;
                    byteVector.putByte(7);
                    ClassWriter classWriter = this.f6236b;
                    i4 = classWriter.newClass(classWriter.H[i7].g);
                } else if (i8 != 25165824) {
                    this.v.putByte(i7);
                    i2++;
                } else {
                    byteVector = this.v;
                    byteVector.putByte(8);
                    i4 = this.f6236b.H[i7].f6228c;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                int i9 = i6 >> 28;
                while (true) {
                    int i10 = i9 - 1;
                    if (i9 <= 0) {
                        break;
                    }
                    stringBuffer.append('[');
                    i9 = i10;
                }
                if ((i5 & 267386880) == 24117248) {
                    stringBuffer.append('L');
                    stringBuffer.append(this.f6236b.H[i5 & 1048575].g);
                    c2 = DefaultObjectDumpFormatter.TOKEN_DIVIDER;
                } else {
                    int i11 = i5 & 15;
                    if (i11 == 1) {
                        c2 = 'I';
                    } else if (i11 == 2) {
                        c2 = 'F';
                    } else if (i11 != 3) {
                        switch (i11) {
                            case 9:
                                c2 = 'Z';
                                break;
                            case 10:
                                c2 = 'B';
                                break;
                            case 11:
                                c2 = 'C';
                                break;
                            case 12:
                                c2 = 'S';
                                break;
                            default:
                                c2 = 'J';
                                break;
                        }
                    } else {
                        c2 = 'D';
                    }
                }
                stringBuffer.append(c2);
                byteVector = this.v;
                byteVector.putByte(7);
                i4 = this.f6236b.newClass(stringBuffer.toString());
            }
            byteVector.putShort(i4);
            i2++;
        }
    }

    public final void a(int i2, Label label) {
        Edge edge = new Edge();
        edge.f6202a = i2;
        edge.f6203b = label;
        Label label2 = this.P;
        edge.f6204c = label2.j;
        label2.j = edge;
    }

    public final void a(Object obj) {
        ByteVector byteVector;
        int i2;
        if (obj instanceof String) {
            byteVector = this.v;
            byteVector.putByte(7);
            i2 = this.f6236b.newClass((String) obj);
        } else if (obj instanceof Integer) {
            this.v.putByte(((Integer) obj).intValue());
            return;
        } else {
            byteVector = this.v;
            byteVector.putByte(8);
            i2 = ((Label) obj).f6232c;
        }
        byteVector.putShort(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x039d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.objectweb.asm.ByteVector r15) {
        /*
            r14 = this;
            int r0 = r14.f6237c
            r1 = 262144(0x40000, float:3.67342E-40)
            r2 = r0 & r1
            int r2 = r2 / 64
            r3 = 917504(0xe0000, float:1.285697E-39)
            r2 = r2 | r3
            int r2 = ~r2
            r0 = r0 & r2
            r15.putShort(r0)
            int r0 = r14.f6238d
            r15.putShort(r0)
            int r0 = r14.f6239e
            r15.putShort(r0)
            int r0 = r14.h
            if (r0 == 0) goto L_0x002a
            org.objectweb.asm.ClassWriter r1 = r14.f6236b
            org.objectweb.asm.ClassReader r1 = r1.M
            byte[] r1 = r1.f6187b
            int r2 = r14.i
            r15.putByteArray(r1, r0, r2)
            return
        L_0x002a:
            org.objectweb.asm.ByteVector r0 = r14.r
            int r0 = r0.f6185b
            r2 = 0
            if (r0 <= 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            int r3 = r14.j
            if (r3 <= 0) goto L_0x003a
            int r0 = r0 + 1
        L_0x003a:
            int r3 = r14.f6237c
            r4 = r3 & 4096(0x1000, float:5.74E-42)
            r5 = 49
            r6 = 65535(0xffff, float:9.1834E-41)
            if (r4 == 0) goto L_0x0051
            org.objectweb.asm.ClassWriter r4 = r14.f6236b
            int r4 = r4.f6191b
            r4 = r4 & r6
            if (r4 < r5) goto L_0x004f
            r3 = r3 & r1
            if (r3 == 0) goto L_0x0051
        L_0x004f:
            int r0 = r0 + 1
        L_0x0051:
            int r3 = r14.f6237c
            r4 = 131072(0x20000, float:1.83671E-40)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x005a
            int r0 = r0 + 1
        L_0x005a:
            java.lang.String r3 = r14.g
            if (r3 == 0) goto L_0x0060
            int r0 = r0 + 1
        L_0x0060:
            org.objectweb.asm.ByteVector r3 = r14.$
            if (r3 == 0) goto L_0x0066
            int r0 = r0 + 1
        L_0x0066:
            org.objectweb.asm.ByteVector r3 = r14.l
            if (r3 == 0) goto L_0x006c
            int r0 = r0 + 1
        L_0x006c:
            org.objectweb.asm.AnnotationWriter r3 = r14.m
            if (r3 == 0) goto L_0x0072
            int r0 = r0 + 1
        L_0x0072:
            org.objectweb.asm.AnnotationWriter r3 = r14.n
            if (r3 == 0) goto L_0x0078
            int r0 = r0 + 1
        L_0x0078:
            org.objectweb.asm.AnnotationWriter r3 = r14.U
            if (r3 == 0) goto L_0x007e
            int r0 = r0 + 1
        L_0x007e:
            org.objectweb.asm.AnnotationWriter r3 = r14.V
            if (r3 == 0) goto L_0x0084
            int r0 = r0 + 1
        L_0x0084:
            org.objectweb.asm.AnnotationWriter[] r3 = r14.o
            if (r3 == 0) goto L_0x008a
            int r0 = r0 + 1
        L_0x008a:
            org.objectweb.asm.AnnotationWriter[] r3 = r14.p
            if (r3 == 0) goto L_0x0090
            int r0 = r0 + 1
        L_0x0090:
            org.objectweb.asm.Attribute r3 = r14.q
            if (r3 == 0) goto L_0x0099
            int r3 = r3.a()
            int r0 = r0 + r3
        L_0x0099:
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.r
            int r0 = r0.f6185b
            java.lang.String r3 = "RuntimeInvisibleTypeAnnotations"
            java.lang.String r4 = "RuntimeVisibleTypeAnnotations"
            if (r0 <= 0) goto L_0x0260
            int r0 = r0 + 12
            int r7 = r14.A
            int r7 = r7 * 8
            int r7 = r7 + r0
            org.objectweb.asm.ByteVector r0 = r14.E
            if (r0 == 0) goto L_0x00b6
            int r0 = r0.f6185b
            int r0 = r0 + 8
            int r7 = r7 + r0
        L_0x00b6:
            org.objectweb.asm.ByteVector r0 = r14.G
            if (r0 == 0) goto L_0x00bf
            int r0 = r0.f6185b
            int r0 = r0 + 8
            int r7 = r7 + r0
        L_0x00bf:
            org.objectweb.asm.ByteVector r0 = r14.I
            if (r0 == 0) goto L_0x00c8
            int r0 = r0.f6185b
            int r0 = r0 + 8
            int r7 = r7 + r0
        L_0x00c8:
            org.objectweb.asm.ByteVector r0 = r14.v
            if (r0 == 0) goto L_0x00d1
            int r0 = r0.f6185b
            int r0 = r0 + 8
            int r7 = r7 + r0
        L_0x00d1:
            org.objectweb.asm.AnnotationWriter r0 = r14.W
            if (r0 == 0) goto L_0x00db
            r8 = 8
            int r7 = com.android.tools.r8.GeneratedOutlineSupport.outline12(r0, r8, r7)
        L_0x00db:
            org.objectweb.asm.AnnotationWriter r0 = r14.X
            if (r0 == 0) goto L_0x00e5
            r8 = 8
            int r7 = com.android.tools.r8.GeneratedOutlineSupport.outline12(r0, r8, r7)
        L_0x00e5:
            org.objectweb.asm.Attribute r8 = r14.J
            if (r8 == 0) goto L_0x00fa
            org.objectweb.asm.ClassWriter r9 = r14.f6236b
            org.objectweb.asm.ByteVector r0 = r14.r
            byte[] r10 = r0.f6184a
            int r11 = r0.f6185b
            int r12 = r14.s
            int r13 = r14.t
            int r0 = r8.a(r9, r10, r11, r12, r13)
            int r7 = r7 + r0
        L_0x00fa:
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r8 = "Code"
            int r0 = r0.newUTF8(r8)
            r15.putShort(r0)
            r15.putInt(r7)
            int r0 = r14.s
            r15.putShort(r0)
            int r0 = r14.t
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.r
            int r0 = r0.f6185b
            r15.putInt(r0)
            org.objectweb.asm.ByteVector r0 = r14.r
            byte[] r7 = r0.f6184a
            int r0 = r0.f6185b
            r15.putByteArray(r7, r2, r0)
            int r0 = r14.A
            r15.putShort(r0)
            int r0 = r14.A
            if (r0 <= 0) goto L_0x014c
            org.objectweb.asm.Handler r0 = r14.B
        L_0x012d:
            if (r0 == 0) goto L_0x014c
            org.objectweb.asm.Label r7 = r0.f6220a
            int r7 = r7.f6232c
            r15.putShort(r7)
            org.objectweb.asm.Label r7 = r0.f6221b
            int r7 = r7.f6232c
            r15.putShort(r7)
            org.objectweb.asm.Label r7 = r0.f6222c
            int r7 = r7.f6232c
            r15.putShort(r7)
            int r7 = r0.f6224e
            r15.putShort(r7)
            org.objectweb.asm.Handler r0 = r0.f6225f
            goto L_0x012d
        L_0x014c:
            org.objectweb.asm.ByteVector r0 = r14.E
            if (r0 == 0) goto L_0x0152
            r0 = 1
            goto L_0x0153
        L_0x0152:
            r0 = 0
        L_0x0153:
            org.objectweb.asm.ByteVector r7 = r14.G
            if (r7 == 0) goto L_0x0159
            int r0 = r0 + 1
        L_0x0159:
            org.objectweb.asm.ByteVector r7 = r14.I
            if (r7 == 0) goto L_0x015f
            int r0 = r0 + 1
        L_0x015f:
            org.objectweb.asm.ByteVector r7 = r14.v
            if (r7 == 0) goto L_0x0165
            int r0 = r0 + 1
        L_0x0165:
            org.objectweb.asm.AnnotationWriter r7 = r14.W
            if (r7 == 0) goto L_0x016b
            int r0 = r0 + 1
        L_0x016b:
            org.objectweb.asm.AnnotationWriter r7 = r14.X
            if (r7 == 0) goto L_0x0171
            int r0 = r0 + 1
        L_0x0171:
            org.objectweb.asm.Attribute r7 = r14.J
            if (r7 == 0) goto L_0x017a
            int r7 = r7.a()
            int r0 = r0 + r7
        L_0x017a:
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.E
            if (r0 == 0) goto L_0x01a3
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r7 = "LocalVariableTable"
            int r0 = r0.newUTF8(r7)
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.E
            int r0 = r0.f6185b
            int r0 = r0 + 2
            r15.putInt(r0)
            int r0 = r14.D
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.E
            byte[] r7 = r0.f6184a
            int r0 = r0.f6185b
            r15.putByteArray(r7, r2, r0)
        L_0x01a3:
            org.objectweb.asm.ByteVector r0 = r14.G
            if (r0 == 0) goto L_0x01c9
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r7 = "LocalVariableTypeTable"
            int r0 = r0.newUTF8(r7)
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.G
            int r0 = r0.f6185b
            int r0 = r0 + 2
            r15.putInt(r0)
            int r0 = r14.F
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.G
            byte[] r7 = r0.f6184a
            int r0 = r0.f6185b
            r15.putByteArray(r7, r2, r0)
        L_0x01c9:
            org.objectweb.asm.ByteVector r0 = r14.I
            if (r0 == 0) goto L_0x01ef
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r7 = "LineNumberTable"
            int r0 = r0.newUTF8(r7)
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.I
            int r0 = r0.f6185b
            int r0 = r0 + 2
            r15.putInt(r0)
            int r0 = r14.H
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.I
            byte[] r7 = r0.f6184a
            int r0 = r0.f6185b
            r15.putByteArray(r7, r2, r0)
        L_0x01ef:
            org.objectweb.asm.ByteVector r0 = r14.v
            if (r0 == 0) goto L_0x0226
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            int r0 = r0.f6191b
            r0 = r0 & r6
            r7 = 50
            if (r0 < r7) goto L_0x01fe
            r0 = 1
            goto L_0x01ff
        L_0x01fe:
            r0 = 0
        L_0x01ff:
            org.objectweb.asm.ClassWriter r7 = r14.f6236b
            if (r0 == 0) goto L_0x0206
            java.lang.String r0 = "StackMapTable"
            goto L_0x0208
        L_0x0206:
            java.lang.String r0 = "StackMap"
        L_0x0208:
            int r0 = r7.newUTF8(r0)
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.v
            int r0 = r0.f6185b
            int r0 = r0 + 2
            r15.putInt(r0)
            int r0 = r14.u
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.v
            byte[] r7 = r0.f6184a
            int r0 = r0.f6185b
            r15.putByteArray(r7, r2, r0)
        L_0x0226:
            org.objectweb.asm.AnnotationWriter r0 = r14.W
            if (r0 == 0) goto L_0x0238
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            int r0 = r0.newUTF8(r4)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter r0 = r14.W
            r0.a(r15)
        L_0x0238:
            org.objectweb.asm.AnnotationWriter r0 = r14.X
            if (r0 == 0) goto L_0x024a
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            int r0 = r0.newUTF8(r3)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter r0 = r14.X
            r0.a(r15)
        L_0x024a:
            org.objectweb.asm.Attribute r7 = r14.J
            if (r7 == 0) goto L_0x0260
            org.objectweb.asm.ClassWriter r8 = r14.f6236b
            org.objectweb.asm.ByteVector r0 = r14.r
            byte[] r9 = r0.f6184a
            int r10 = r0.f6185b
            int r11 = r14.t
            int r12 = r14.s
            r0 = 2
            r13 = r15
            r7.a(r8, r9, r10, r11, r12, r13)
            goto L_0x0261
        L_0x0260:
            r0 = 2
        L_0x0261:
            int r7 = r14.j
            if (r7 <= 0) goto L_0x028c
            org.objectweb.asm.ClassWriter r7 = r14.f6236b
            java.lang.String r8 = "Exceptions"
            int r7 = r7.newUTF8(r8)
            r15.putShort(r7)
            int r7 = r14.j
            int r7 = r7 * 2
            int r7 = r7 + r0
            r15.putInt(r7)
            int r7 = r14.j
            r15.putShort(r7)
            r7 = 0
        L_0x027e:
            int r8 = r14.j
            if (r7 >= r8) goto L_0x028c
            int[] r8 = r14.k
            r8 = r8[r7]
            r15.putShort(r8)
            int r7 = r7 + 1
            goto L_0x027e
        L_0x028c:
            int r7 = r14.f6237c
            r8 = r7 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x02aa
            org.objectweb.asm.ClassWriter r8 = r14.f6236b
            int r8 = r8.f6191b
            r6 = r6 & r8
            if (r6 < r5) goto L_0x029c
            r1 = r1 & r7
            if (r1 == 0) goto L_0x02aa
        L_0x029c:
            org.objectweb.asm.ClassWriter r1 = r14.f6236b
            java.lang.String r5 = "Synthetic"
            int r1 = r1.newUTF8(r5)
            r15.putShort(r1)
            r15.putInt(r2)
        L_0x02aa:
            int r1 = r14.f6237c
            r5 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r5
            if (r1 == 0) goto L_0x02bf
            org.objectweb.asm.ClassWriter r1 = r14.f6236b
            java.lang.String r5 = "Deprecated"
            int r1 = r1.newUTF8(r5)
            r15.putShort(r1)
            r15.putInt(r2)
        L_0x02bf:
            java.lang.String r1 = r14.g
            if (r1 == 0) goto L_0x02dc
            org.objectweb.asm.ClassWriter r1 = r14.f6236b
            java.lang.String r5 = "Signature"
            int r1 = r1.newUTF8(r5)
            r15.putShort(r1)
            r15.putInt(r0)
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r1 = r14.g
            int r0 = r0.newUTF8(r1)
            r15.putShort(r0)
        L_0x02dc:
            org.objectweb.asm.ByteVector r0 = r14.$
            if (r0 == 0) goto L_0x0302
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r1 = "MethodParameters"
            int r0 = r0.newUTF8(r1)
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.$
            int r0 = r0.f6185b
            int r0 = r0 + 1
            r15.putInt(r0)
            int r0 = r14.Z
            r15.putByte(r0)
            org.objectweb.asm.ByteVector r0 = r14.$
            byte[] r1 = r0.f6184a
            int r0 = r0.f6185b
            r15.putByteArray(r1, r2, r0)
        L_0x0302:
            org.objectweb.asm.ByteVector r0 = r14.l
            if (r0 == 0) goto L_0x0321
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r1 = "AnnotationDefault"
            int r0 = r0.newUTF8(r1)
            r15.putShort(r0)
            org.objectweb.asm.ByteVector r0 = r14.l
            int r0 = r0.f6185b
            r15.putInt(r0)
            org.objectweb.asm.ByteVector r0 = r14.l
            byte[] r1 = r0.f6184a
            int r0 = r0.f6185b
            r15.putByteArray(r1, r2, r0)
        L_0x0321:
            org.objectweb.asm.AnnotationWriter r0 = r14.m
            if (r0 == 0) goto L_0x0335
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r1 = "RuntimeVisibleAnnotations"
            int r0 = r0.newUTF8(r1)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter r0 = r14.m
            r0.a(r15)
        L_0x0335:
            org.objectweb.asm.AnnotationWriter r0 = r14.n
            if (r0 == 0) goto L_0x0349
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r1 = "RuntimeInvisibleAnnotations"
            int r0 = r0.newUTF8(r1)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter r0 = r14.n
            r0.a(r15)
        L_0x0349:
            org.objectweb.asm.AnnotationWriter r0 = r14.U
            if (r0 == 0) goto L_0x035b
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            int r0 = r0.newUTF8(r4)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter r0 = r14.U
            r0.a(r15)
        L_0x035b:
            org.objectweb.asm.AnnotationWriter r0 = r14.V
            if (r0 == 0) goto L_0x036d
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            int r0 = r0.newUTF8(r3)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter r0 = r14.V
            r0.a(r15)
        L_0x036d:
            org.objectweb.asm.AnnotationWriter[] r0 = r14.o
            if (r0 == 0) goto L_0x0383
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r1 = "RuntimeVisibleParameterAnnotations"
            int r0 = r0.newUTF8(r1)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter[] r0 = r14.o
            int r1 = r14.S
            org.objectweb.asm.AnnotationWriter.a(r0, r1, r15)
        L_0x0383:
            org.objectweb.asm.AnnotationWriter[] r0 = r14.p
            if (r0 == 0) goto L_0x0399
            org.objectweb.asm.ClassWriter r0 = r14.f6236b
            java.lang.String r1 = "RuntimeInvisibleParameterAnnotations"
            int r0 = r0.newUTF8(r1)
            r15.putShort(r0)
            org.objectweb.asm.AnnotationWriter[] r0 = r14.p
            int r1 = r14.S
            org.objectweb.asm.AnnotationWriter.a(r0, r1, r15)
        L_0x0399:
            org.objectweb.asm.Attribute r2 = r14.q
            if (r2 == 0) goto L_0x03a7
            org.objectweb.asm.ClassWriter r3 = r14.f6236b
            r4 = 0
            r5 = 0
            r6 = -1
            r7 = -1
            r8 = r15
            r2.a(r3, r4, r5, r6, r7, r8)
        L_0x03a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.a(org.objectweb.asm.ByteVector):void");
    }

    public final void a(Label label, Label[] labelArr) {
        Label label2 = this.P;
        if (label2 != null) {
            if (this.M == 0) {
                label2.h.a(171, 0, (ClassWriter) null, (Item) null);
                a(0, label);
                label.a().f6230a |= 16;
                for (int i2 = 0; i2 < labelArr.length; i2++) {
                    a(0, labelArr[i2]);
                    labelArr[i2].a().f6230a |= 16;
                }
            } else {
                int i3 = this.Q - 1;
                this.Q = i3;
                a(i3, label);
                for (Label a2 : labelArr) {
                    a(this.Q, a2);
                }
            }
            e();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r17 = this;
            r0 = r17
            int[] r1 = r0.x
            if (r1 == 0) goto L_0x0102
            org.objectweb.asm.ByteVector r1 = r0.v
            if (r1 != 0) goto L_0x0011
            org.objectweb.asm.ByteVector r1 = new org.objectweb.asm.ByteVector
            r1.<init>()
            r0.v = r1
        L_0x0011:
            int[] r1 = r0.z
            r2 = 1
            r3 = r1[r2]
            r4 = 2
            r4 = r1[r4]
            org.objectweb.asm.ClassWriter r5 = r0.f6236b
            int r5 = r5.f6191b
            r6 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r6
            r6 = 50
            r7 = 0
            r8 = 3
            if (r5 >= r6) goto L_0x0037
            org.objectweb.asm.ByteVector r5 = r0.v
            r1 = r1[r7]
            r5.putShort(r1)
            r5.putShort(r3)
            int r3 = r3 + r8
            r0.a(r8, r3)
            goto L_0x00b6
        L_0x0037:
            int[] r5 = r0.x
            r6 = r5[r2]
            int r9 = r0.u
            if (r9 != 0) goto L_0x0042
            r1 = r1[r7]
            goto L_0x0048
        L_0x0042:
            r1 = r1[r7]
            r5 = r5[r7]
            int r1 = r1 - r5
            int r1 = r1 - r2
        L_0x0048:
            r5 = 251(0xfb, float:3.52E-43)
            r9 = 64
            r10 = 247(0xf7, float:3.46E-43)
            r11 = 248(0xf8, float:3.48E-43)
            r12 = 252(0xfc, float:3.53E-43)
            r13 = 255(0xff, float:3.57E-43)
            if (r4 != 0) goto L_0x006d
            int r14 = r3 - r6
            switch(r14) {
                case -3: goto L_0x0068;
                case -2: goto L_0x0068;
                case -1: goto L_0x0068;
                case 0: goto L_0x0060;
                case 1: goto L_0x005c;
                case 2: goto L_0x005c;
                case 3: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x007d
        L_0x005c:
            r15 = r14
            r14 = 252(0xfc, float:3.53E-43)
            goto L_0x0080
        L_0x0060:
            r15 = r14
            if (r1 >= r9) goto L_0x0065
            r14 = 0
            goto L_0x0080
        L_0x0065:
            r14 = 251(0xfb, float:3.52E-43)
            goto L_0x0080
        L_0x0068:
            r6 = r3
            r15 = r14
            r14 = 248(0xf8, float:3.48E-43)
            goto L_0x0080
        L_0x006d:
            if (r3 != r6) goto L_0x007c
            if (r4 != r2) goto L_0x007c
            r14 = 63
            if (r1 >= r14) goto L_0x0078
            r14 = 64
            goto L_0x007a
        L_0x0078:
            r14 = 247(0xf7, float:3.46E-43)
        L_0x007a:
            r15 = 0
            goto L_0x0080
        L_0x007c:
            r14 = 0
        L_0x007d:
            r15 = r14
            r14 = 255(0xff, float:3.57E-43)
        L_0x0080:
            if (r14 == r13) goto L_0x009a
            r16 = 3
        L_0x0084:
            if (r7 >= r6) goto L_0x009a
            int[] r2 = r0.z
            r2 = r2[r16]
            int[] r8 = r0.x
            r8 = r8[r16]
            if (r2 == r8) goto L_0x0093
            r14 = 255(0xff, float:3.57E-43)
            goto L_0x009a
        L_0x0093:
            int r16 = r16 + 1
            int r7 = r7 + 1
            r2 = 1
            r8 = 3
            goto L_0x0084
        L_0x009a:
            if (r14 == 0) goto L_0x00f7
            if (r14 == r9) goto L_0x00e9
            if (r14 == r10) goto L_0x00e0
            if (r14 == r11) goto L_0x00d6
            if (r14 == r5) goto L_0x00d0
            if (r14 == r12) goto L_0x00c0
            org.objectweb.asm.ByteVector r2 = r0.v
            r2.putByte(r13)
            r2.putShort(r1)
            r2.putShort(r3)
            r2 = 3
            int r3 = r3 + r2
            r0.a(r2, r3)
        L_0x00b6:
            org.objectweb.asm.ByteVector r1 = r0.v
            r1.putShort(r4)
            int r4 = r4 + r3
            r0.a(r3, r4)
            goto L_0x00fc
        L_0x00c0:
            r2 = 3
            org.objectweb.asm.ByteVector r4 = r0.v
            int r15 = r15 + r5
            r4.putByte(r15)
            r4.putShort(r1)
            int r6 = r6 + r2
            int r3 = r3 + r2
            r0.a(r6, r3)
            goto L_0x00fc
        L_0x00d0:
            org.objectweb.asm.ByteVector r2 = r0.v
            r2.putByte(r5)
            goto L_0x00dc
        L_0x00d6:
            org.objectweb.asm.ByteVector r2 = r0.v
            int r15 = r15 + r5
            r2.putByte(r15)
        L_0x00dc:
            r2.putShort(r1)
            goto L_0x00fc
        L_0x00e0:
            org.objectweb.asm.ByteVector r2 = r0.v
            r2.putByte(r10)
            r2.putShort(r1)
            goto L_0x00ef
        L_0x00e9:
            org.objectweb.asm.ByteVector r2 = r0.v
            int r1 = r1 + r9
            r2.putByte(r1)
        L_0x00ef:
            int r1 = r3 + 3
            int r3 = r3 + 4
            r0.a(r1, r3)
            goto L_0x00fc
        L_0x00f7:
            org.objectweb.asm.ByteVector r2 = r0.v
            r2.putByte(r1)
        L_0x00fc:
            int r1 = r0.u
            r2 = 1
            int r1 = r1 + r2
            r0.u = r1
        L_0x0102:
            int[] r1 = r0.z
            r0.x = r1
            r1 = 0
            r0.z = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.b():void");
    }

    public final void b(Frame frame) {
        int[] iArr = frame.f6212c;
        int[] iArr2 = frame.f6213d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < iArr.length) {
            int i6 = iArr[i3];
            i5++;
            if (i6 != 16777216) {
                i4 += i5;
                i5 = 0;
            }
            if (i6 == 16777220 || i6 == 16777219) {
                i3++;
            }
            i3++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i8++;
            if (i9 == 16777220 || i9 == 16777219) {
                i7++;
            }
            i7++;
        }
        a(frame.f6211b.f6232c, i4, i8);
        int i10 = 3;
        int i11 = 0;
        while (i4 > 0) {
            int i12 = iArr[i11];
            int i13 = i10 + 1;
            this.z[i10] = i12;
            if (i12 == 16777220 || i12 == 16777219) {
                i11++;
            }
            i11++;
            i4--;
            i10 = i13;
        }
        while (i2 < iArr2.length) {
            int i14 = iArr2[i2];
            int i15 = i10 + 1;
            this.z[i10] = i14;
            if (i14 == 16777220 || i14 == 16777219) {
                i2++;
            }
            i2++;
            i10 = i15;
        }
        b();
    }

    public final void e() {
        if (this.M == 0) {
            Label label = new Label();
            Frame frame = new Frame();
            label.h = frame;
            frame.f6211b = label;
            ByteVector byteVector = this.r;
            label.a(byteVector.f6185b, byteVector.f6184a);
            this.O.i = label;
            this.O = label;
        } else {
            this.P.g = this.R;
        }
        this.P = null;
    }

    public AnnotationWriter visitAnnotation(String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f6236b.newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6236b, true, byteVector, byteVector, 2);
        if (z2) {
            annotationWriter.g = this.m;
            this.m = annotationWriter;
        } else {
            annotationWriter.g = this.n;
            this.n = annotationWriter;
        }
        return annotationWriter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r0 = r0 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        if (r0 <= r4.R) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        r4.R = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
        r4.Q = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitFieldInsn(int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            org.objectweb.asm.ByteVector r0 = r4.r
            int r0 = r0.f6185b
            r4.Y = r0
            org.objectweb.asm.ClassWriter r0 = r4.f6236b
            org.objectweb.asm.Item r6 = r0.a(r6, r7, r8)
            org.objectweb.asm.Label r7 = r4.P
            if (r7 == 0) goto L_0x0057
            int r0 = r4.M
            r1 = 0
            if (r0 != 0) goto L_0x001d
            org.objectweb.asm.Frame r7 = r7.h
            org.objectweb.asm.ClassWriter r8 = r4.f6236b
            r7.a(r5, r1, r8, r6)
            goto L_0x0057
        L_0x001d:
            char r7 = r8.charAt(r1)
            r8 = 1
            r0 = -2
            r2 = 74
            r3 = 68
            switch(r5) {
                case 178: goto L_0x0044;
                case 179: goto L_0x003a;
                case 180: goto L_0x0031;
                default: goto L_0x002a;
            }
        L_0x002a:
            int r8 = r4.Q
            if (r7 == r3) goto L_0x004d
            if (r7 != r2) goto L_0x0042
            goto L_0x004d
        L_0x0031:
            int r0 = r4.Q
            if (r7 == r3) goto L_0x0037
            if (r7 != r2) goto L_0x0038
        L_0x0037:
            r1 = 1
        L_0x0038:
            int r0 = r0 + r1
            goto L_0x004f
        L_0x003a:
            int r8 = r4.Q
            if (r7 == r3) goto L_0x0042
            if (r7 != r2) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r0 = -1
        L_0x0042:
            int r0 = r0 + r8
            goto L_0x004f
        L_0x0044:
            int r0 = r4.Q
            if (r7 == r3) goto L_0x004a
            if (r7 != r2) goto L_0x004b
        L_0x004a:
            r8 = 2
        L_0x004b:
            int r0 = r0 + r8
            goto L_0x004f
        L_0x004d:
            r0 = -3
            goto L_0x0042
        L_0x004f:
            int r7 = r4.R
            if (r0 <= r7) goto L_0x0055
            r4.R = r0
        L_0x0055:
            r4.Q = r0
        L_0x0057:
            org.objectweb.asm.ByteVector r7 = r4.r
            int r6 = r6.f6226a
            r7.b(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.visitFieldInsn(int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void visitFrame(int i2, int i3, Object[] objArr, int i4, Object[] objArr2) {
        int i5;
        ByteVector byteVector;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        if (this.M != 0) {
            int i14 = 3;
            int i15 = 0;
            if (i11 == -1) {
                if (this.x == null) {
                    a(0, this.f6240f.length() + 1, 0);
                    int i16 = this.f6237c;
                    if ((i16 & 8) == 0) {
                        if ((i16 & 524288) == 0) {
                            int[] iArr = this.z;
                            ClassWriter classWriter = this.f6236b;
                            iArr[3] = classWriter.c(classWriter.I) | 24117248;
                        } else {
                            this.z[3] = 6;
                        }
                        i8 = 4;
                    } else {
                        i8 = 3;
                    }
                    int i17 = 1;
                    while (true) {
                        int i18 = i17 + 1;
                        char charAt = this.f6240f.charAt(i17);
                        if (charAt == 'F') {
                            i9 = i8 + 1;
                            this.z[i8] = 2;
                        } else if (charAt != 'L') {
                            if (!(charAt == 'S' || charAt == 'I')) {
                                if (charAt == 'J') {
                                    i9 = i8 + 1;
                                    this.z[i8] = 4;
                                } else if (charAt != 'Z') {
                                    if (charAt != '[') {
                                        switch (charAt) {
                                            case 'B':
                                            case 'C':
                                                break;
                                            case 'D':
                                                i9 = i8 + 1;
                                                this.z[i8] = 3;
                                                break;
                                            default:
                                                this.z[1] = i8 - 3;
                                                b();
                                                break;
                                        }
                                    } else {
                                        while (this.f6240f.charAt(i18) == '[') {
                                            i18++;
                                        }
                                        if (this.f6240f.charAt(i18) == 'L') {
                                            do {
                                                i18++;
                                            } while (this.f6240f.charAt(i18) != ';');
                                        }
                                        int i19 = i18 + 1;
                                        this.z[i8] = this.f6236b.c(this.f6240f.substring(i17, i19)) | 24117248;
                                        i17 = i19;
                                        i10 = i8 + 1;
                                    }
                                }
                            }
                            i9 = i8 + 1;
                            this.z[i8] = 1;
                        } else {
                            int i20 = i18;
                            while (this.f6240f.charAt(i20) != ';') {
                                i20++;
                            }
                            this.z[i8] = this.f6236b.c(this.f6240f.substring(i18, i20)) | 24117248;
                            i10 = i8 + 1;
                            i17 = i20 + 1;
                        }
                        i10 = i9;
                        i17 = i18;
                    }
                }
                this.T = i12;
                a(this.r.f6185b, i12, i13);
                for (int i21 = 0; i21 < i12; i21++) {
                    if (objArr[i21] instanceof String) {
                        i7 = i14 + 1;
                        this.z[i14] = this.f6236b.c(objArr[i21]) | 24117248;
                    } else if (objArr[i21] instanceof Integer) {
                        i7 = i14 + 1;
                        this.z[i14] = objArr[i21].intValue();
                    } else {
                        this.z[i14] = this.f6236b.a("", objArr[i21].f6232c) | 25165824;
                        i14++;
                    }
                    i14 = i7;
                }
                while (i15 < i13) {
                    if (objArr2[i15] instanceof String) {
                        i6 = i14 + 1;
                        this.z[i14] = this.f6236b.c(objArr2[i15]) | 24117248;
                    } else if (objArr2[i15] instanceof Integer) {
                        i6 = i14 + 1;
                        this.z[i14] = objArr2[i15].intValue();
                    } else {
                        i6 = i14 + 1;
                        this.z[i14] = this.f6236b.a("", objArr2[i15].f6232c) | 25165824;
                    }
                    i14 = i6;
                    i15++;
                }
                b();
            } else {
                if (this.v == null) {
                    this.v = new ByteVector();
                    i5 = this.r.f6185b;
                } else {
                    i5 = (this.r.f6185b - this.w) - 1;
                    if (i5 < 0) {
                        if (i11 != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                if (i11 == 0) {
                    this.T = i12;
                    ByteVector byteVector2 = this.v;
                    byteVector2.putByte(InvitationReply.EXPIRED);
                    byteVector2.putShort(i5);
                    byteVector2.putShort(i12);
                    for (int i22 = 0; i22 < i12; i22++) {
                        a(objArr[i22]);
                    }
                    this.v.putShort(i13);
                    while (i15 < i13) {
                        a(objArr2[i15]);
                        i15++;
                    }
                } else if (i11 != 1) {
                    int i23 = 251;
                    if (i11 == 2) {
                        this.T -= i12;
                        byteVector = this.v;
                        i23 = 251 - i12;
                    } else if (i11 == 3) {
                        byteVector = this.v;
                        if (i5 < 64) {
                            byteVector.putByte(i5);
                        }
                    } else if (i11 == 4) {
                        ByteVector byteVector3 = this.v;
                        if (i5 < 64) {
                            byteVector3.putByte(i5 + 64);
                        } else {
                            byteVector3.putByte(247);
                            byteVector3.putShort(i5);
                        }
                        a(objArr2[0]);
                    }
                    byteVector.putByte(i23);
                    byteVector.putShort(i5);
                } else {
                    this.T += i12;
                    ByteVector byteVector4 = this.v;
                    byteVector4.putByte(i12 + 251);
                    byteVector4.putShort(i5);
                    while (i15 < i12) {
                        a(objArr[i15]);
                        i15++;
                    }
                }
                this.w = this.r.f6185b;
                this.u++;
            }
            this.s = Math.max(this.s, i13);
            this.t = Math.max(this.t, this.T);
        }
    }

    public void visitIincInsn(int i2, int i3) {
        this.Y = this.r.f6185b;
        Label label = this.P;
        if (label != null && this.M == 0) {
            label.h.a(132, i2, (ClassWriter) null, (Item) null);
        }
        if (this.M != 2) {
            int i4 = i2 + 1;
            if (i4 > this.t) {
                this.t = i4;
            }
        }
        if (i2 > 255 || i3 > 127 || i3 < -128) {
            ByteVector byteVector = this.r;
            byteVector.putByte(196);
            byteVector.b(132, i2);
            byteVector.putShort(i3);
            return;
        }
        ByteVector byteVector2 = this.r;
        byteVector2.putByte(132);
        byteVector2.a(i2, i3);
    }

    public void visitInsn(int i2) {
        ByteVector byteVector = this.r;
        this.Y = byteVector.f6185b;
        byteVector.putByte(i2);
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, 0, (ClassWriter) null, (Item) null);
            } else {
                int i3 = this.Q + Frame.f6210a[i2];
                if (i3 > this.R) {
                    this.R = i3;
                }
                this.Q = i3;
            }
            if ((i2 >= 172 && i2 <= 177) || i2 == 191) {
                e();
            }
        }
    }

    public AnnotationWriter visitInsnAnnotation(int i2, TypePath typePath, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a((i2 & -16776961) | (this.Y << 8), typePath, byteVector);
        byteVector.putShort(this.f6236b.newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6236b, true, byteVector, byteVector, byteVector.f6185b - 2);
        if (z2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitIntInsn(int i2, int i3) {
        this.Y = this.r.f6185b;
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, i3, (ClassWriter) null, (Item) null);
            } else if (i2 != 188) {
                int i4 = this.Q + 1;
                if (i4 > this.R) {
                    this.R = i4;
                }
                this.Q = i4;
            }
        }
        if (i2 == 17) {
            this.r.b(i2, i3);
        } else {
            this.r.a(i2, i3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitJumpInsn(int r9, org.objectweb.asm.Label r10) {
        /*
            r8 = this;
            org.objectweb.asm.ByteVector r0 = r8.r
            int r0 = r0.f6185b
            r8.Y = r0
            org.objectweb.asm.Label r0 = r8.P
            r1 = 168(0xa8, float:2.35E-43)
            r2 = 167(0xa7, float:2.34E-43)
            r3 = 0
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0060
            int r6 = r8.M
            if (r6 != 0) goto L_0x002f
            org.objectweb.asm.Frame r0 = r0.h
            r0.a(r9, r3, r4, r4)
            org.objectweb.asm.Label r0 = r10.a()
            int r6 = r0.f6230a
            r6 = r6 | 16
            r0.f6230a = r6
            r8.a(r3, r10)
            if (r9 == r2) goto L_0x0060
            org.objectweb.asm.Label r4 = new org.objectweb.asm.Label
            r4.<init>()
            goto L_0x0060
        L_0x002f:
            if (r9 != r1) goto L_0x0054
            int r0 = r10.f6230a
            r4 = r0 & 512(0x200, float:7.17E-43)
            if (r4 != 0) goto L_0x0040
            r0 = r0 | 512(0x200, float:7.17E-43)
            r10.f6230a = r0
            int r0 = r8.L
            int r0 = r0 + r5
            r8.L = r0
        L_0x0040:
            org.objectweb.asm.Label r0 = r8.P
            int r4 = r0.f6230a
            r4 = r4 | 128(0x80, float:1.8E-43)
            r0.f6230a = r4
            int r0 = r8.Q
            int r0 = r0 + r5
            r8.a(r0, r10)
            org.objectweb.asm.Label r4 = new org.objectweb.asm.Label
            r4.<init>()
            goto L_0x0060
        L_0x0054:
            int r0 = r8.Q
            int[] r6 = org.objectweb.asm.Frame.f6210a
            r6 = r6[r9]
            int r0 = r0 + r6
            r8.Q = r0
            r8.a(r0, r10)
        L_0x0060:
            int r0 = r10.f6230a
            r0 = r0 & 2
            if (r0 == 0) goto L_0x00ab
            int r0 = r10.f6232c
            org.objectweb.asm.ByteVector r6 = r8.r
            int r7 = r6.f6185b
            int r0 = r0 - r7
            r7 = -32768(0xffffffffffff8000, float:NaN)
            if (r0 >= r7) goto L_0x00ab
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 != r2) goto L_0x0079
        L_0x0075:
            r6.putByte(r0)
            goto L_0x00a2
        L_0x0079:
            if (r9 != r1) goto L_0x007e
            r0 = 201(0xc9, float:2.82E-43)
            goto L_0x0075
        L_0x007e:
            if (r4 == 0) goto L_0x0086
            int r1 = r4.f6230a
            r1 = r1 | 16
            r4.f6230a = r1
        L_0x0086:
            org.objectweb.asm.ByteVector r1 = r8.r
            r3 = 166(0xa6, float:2.33E-43)
            if (r9 > r3) goto L_0x0091
            int r3 = r9 + 1
            r3 = r3 ^ r5
            int r3 = r3 - r5
            goto L_0x0093
        L_0x0091:
            r3 = r9 ^ 1
        L_0x0093:
            r1.putByte(r3)
            org.objectweb.asm.ByteVector r1 = r8.r
            r3 = 8
            r1.putShort(r3)
            org.objectweb.asm.ByteVector r1 = r8.r
            r1.putByte(r0)
        L_0x00a2:
            org.objectweb.asm.ByteVector r0 = r8.r
            int r1 = r0.f6185b
            int r1 = r1 - r5
            r10.a(r0, r1, r5)
            goto L_0x00b8
        L_0x00ab:
            org.objectweb.asm.ByteVector r0 = r8.r
            r0.putByte(r9)
            org.objectweb.asm.ByteVector r0 = r8.r
            int r1 = r0.f6185b
            int r1 = r1 - r5
            r10.a(r0, r1, r3)
        L_0x00b8:
            org.objectweb.asm.Label r10 = r8.P
            if (r10 == 0) goto L_0x00c6
            if (r4 == 0) goto L_0x00c1
            r8.visitLabel(r4)
        L_0x00c1:
            if (r9 != r2) goto L_0x00c6
            r8.e()
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.visitJumpInsn(int, org.objectweb.asm.Label):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (r0 != null) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitLabel(org.objectweb.asm.Label r6) {
        /*
            r5 = this;
            boolean r0 = r5.K
            org.objectweb.asm.ByteVector r1 = r5.r
            int r2 = r1.f6185b
            byte[] r1 = r1.f6184a
            boolean r1 = r6.a(r2, r1)
            r0 = r0 | r1
            r5.K = r0
            int r0 = r6.f6230a
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int r1 = r5.M
            r2 = 0
            if (r1 != 0) goto L_0x005d
            org.objectweb.asm.Label r1 = r5.P
            if (r1 == 0) goto L_0x0034
            int r3 = r6.f6232c
            int r4 = r1.f6232c
            if (r3 != r4) goto L_0x0031
            int r2 = r1.f6230a
            r0 = r0 & 16
            r0 = r0 | r2
            r1.f6230a = r0
            org.objectweb.asm.Frame r0 = r1.h
            r6.h = r0
            return
        L_0x0031:
            r5.a(r2, r6)
        L_0x0034:
            r5.P = r6
            org.objectweb.asm.Frame r0 = r6.h
            if (r0 != 0) goto L_0x0043
            org.objectweb.asm.Frame r0 = new org.objectweb.asm.Frame
            r0.<init>()
            r6.h = r0
            r0.f6211b = r6
        L_0x0043:
            org.objectweb.asm.Label r0 = r5.O
            if (r0 == 0) goto L_0x0079
            int r1 = r6.f6232c
            int r2 = r0.f6232c
            if (r1 != r2) goto L_0x0077
            int r1 = r0.f6230a
            int r2 = r6.f6230a
            r2 = r2 & 16
            r1 = r1 | r2
            r0.f6230a = r1
            org.objectweb.asm.Frame r1 = r0.h
            r6.h = r1
            r5.P = r0
            return
        L_0x005d:
            r0 = 1
            if (r1 != r0) goto L_0x007b
            org.objectweb.asm.Label r0 = r5.P
            if (r0 == 0) goto L_0x006d
            int r1 = r5.R
            r0.g = r1
            int r0 = r5.Q
            r5.a(r0, r6)
        L_0x006d:
            r5.P = r6
            r5.Q = r2
            r5.R = r2
            org.objectweb.asm.Label r0 = r5.O
            if (r0 == 0) goto L_0x0079
        L_0x0077:
            r0.i = r6
        L_0x0079:
            r5.O = r6
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.visitLabel(org.objectweb.asm.Label):void");
    }

    public void visitLdcInsn(Object obj) {
        ByteVector byteVector;
        int i2;
        this.Y = this.r.f6185b;
        Item a2 = this.f6236b.a(obj);
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(18, 0, this.f6236b, a2);
            } else {
                int i3 = a2.f6227b;
                int i4 = (i3 == 5 || i3 == 6) ? this.Q + 2 : this.Q + 1;
                if (i4 > this.R) {
                    this.R = i4;
                }
                this.Q = i4;
            }
        }
        int i5 = a2.f6226a;
        int i6 = a2.f6227b;
        if (i6 == 5 || i6 == 6) {
            byteVector = this.r;
            i2 = 20;
        } else if (i5 >= 256) {
            byteVector = this.r;
            i2 = 19;
        } else {
            this.r.a(18, i5);
            return;
        }
        byteVector.b(i2, i5);
    }

    public void visitLineNumber(int i2, Label label) {
        if (this.I == null) {
            this.I = new ByteVector();
        }
        this.H++;
        this.I.putShort(label.f6232c);
        this.I.putShort(i2);
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i2) {
        int i3 = 1;
        if (str3 != null) {
            if (this.G == null) {
                this.G = new ByteVector();
            }
            this.F++;
            ByteVector byteVector = this.G;
            byteVector.putShort(label.f6232c);
            byteVector.putShort(label2.f6232c - label.f6232c);
            byteVector.putShort(this.f6236b.newUTF8(str));
            byteVector.putShort(this.f6236b.newUTF8(str3));
            byteVector.putShort(i2);
        }
        if (this.E == null) {
            this.E = new ByteVector();
        }
        this.D++;
        ByteVector byteVector2 = this.E;
        byteVector2.putShort(label.f6232c);
        byteVector2.putShort(label2.f6232c - label.f6232c);
        byteVector2.putShort(this.f6236b.newUTF8(str));
        byteVector2.putShort(this.f6236b.newUTF8(str2));
        byteVector2.putShort(i2);
        if (this.M != 2) {
            char charAt = str2.charAt(0);
            if (charAt == 'J' || charAt == 'D') {
                i3 = 2;
            }
            int i4 = i2 + i3;
            if (i4 > this.t) {
                this.t = i4;
            }
        }
    }

    public AnnotationWriter visitLocalVariableAnnotation(int i2, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putByte(i2 >>> 24);
        byteVector.putShort(labelArr.length);
        for (int i3 = 0; i3 < labelArr.length; i3++) {
            byteVector.putShort(labelArr[i3].f6232c);
            byteVector.putShort(labelArr2[i3].f6232c - labelArr[i3].f6232c);
            byteVector.putShort(iArr[i3]);
        }
        if (typePath == null) {
            byteVector.putByte(0);
        } else {
            byte[] bArr = typePath.f6245a;
            int i4 = typePath.f6246b;
            byteVector.putByteArray(bArr, i4, (bArr[i4] * 2) + 1);
        }
        byteVector.putShort(this.f6236b.newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6236b, true, byteVector, byteVector, byteVector.f6185b - 2);
        if (z2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    /* JADX WARNING: type inference failed for: r14v11, types: [int] */
    /* JADX WARNING: type inference failed for: r14v13 */
    /* JADX WARNING: type inference failed for: r14v14, types: [int] */
    /* JADX WARNING: type inference failed for: r14v15, types: [int] */
    /* JADX WARNING: type inference failed for: r14v38 */
    /* JADX WARNING: type inference failed for: r14v39 */
    /* JADX WARNING: type inference failed for: r14v40, types: [int] */
    /* JADX WARNING: type inference failed for: r14v41, types: [int] */
    /* JADX WARNING: type inference failed for: r14v44 */
    /* JADX WARNING: type inference failed for: r14v45 */
    /* JADX WARNING: type inference failed for: r14v46 */
    /* JADX WARNING: type inference failed for: r14v47 */
    /* JADX WARNING: type inference failed for: r14v48 */
    /* JADX WARNING: type inference failed for: r14v49 */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r14v13
      assigns: []
      uses: []
      mth insns count: 752
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    public void visitMaxs(int r23, int r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            boolean r2 = r0.K
            r4 = 8
            r5 = 3
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0343
            org.objectweb.asm.ByteVector r2 = r0.r
            byte[] r8 = r2.f6184a
            int[] r9 = new int[r6]
            int[] r10 = new int[r6]
            int r2 = r2.f6185b
            boolean[] r2 = new boolean[r2]
            r11 = 3
        L_0x001a:
            if (r11 != r5) goto L_0x001d
            r11 = 2
        L_0x001d:
            r13 = 0
        L_0x001e:
            int r14 = r8.length
            r15 = 201(0xc9, float:2.82E-43)
            r3 = 132(0x84, float:1.85E-43)
            r12 = 4
            if (r13 >= r14) goto L_0x0105
            byte r14 = r8[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte[] r18 = org.objectweb.asm.ClassWriter.f6190a
            byte r18 = r18[r14]
            switch(r18) {
                case 0: goto L_0x00e0;
                case 1: goto L_0x00dd;
                case 2: goto L_0x00da;
                case 3: goto L_0x00dd;
                case 4: goto L_0x00e0;
                case 5: goto L_0x00da;
                case 6: goto L_0x00da;
                case 7: goto L_0x00d7;
                case 8: goto L_0x00d7;
                case 9: goto L_0x008f;
                case 10: goto L_0x00d7;
                case 11: goto L_0x00dd;
                case 12: goto L_0x00da;
                case 13: goto L_0x00da;
                case 14: goto L_0x0063;
                case 15: goto L_0x003f;
                case 16: goto L_0x0031;
                case 17: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x00e3
        L_0x0033:
            int r12 = r13 + 1
            byte r12 = r8[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            if (r12 != r3) goto L_0x00e3
            int r13 = r13 + 6
            goto L_0x00e5
        L_0x003f:
            if (r11 != r7) goto L_0x0048
            int r3 = a(r9, r10, r6, r13)
            r3 = r3 & r5
            int r3 = -r3
            goto L_0x0052
        L_0x0048:
            boolean r3 = r2[r13]
            if (r3 != 0) goto L_0x0051
            r3 = r13 & 3
            r2[r13] = r7
            goto L_0x0052
        L_0x0051:
            r3 = 0
        L_0x0052:
            int r12 = r13 + 4
            r13 = r13 & 3
            int r12 = r12 - r13
            int r13 = r12 + 4
            int r13 = a(r8, r13)
            int r13 = r13 * 8
            int r13 = r13 + r4
            int r13 = r13 + r12
            goto L_0x00e6
        L_0x0063:
            if (r11 != r7) goto L_0x006c
            int r3 = a(r9, r10, r6, r13)
            r3 = r3 & r5
            int r3 = -r3
            goto L_0x0076
        L_0x006c:
            boolean r3 = r2[r13]
            if (r3 != 0) goto L_0x0075
            r3 = r13 & 3
            r2[r13] = r7
            goto L_0x0076
        L_0x0075:
            r3 = 0
        L_0x0076:
            int r14 = r13 + 4
            r13 = r13 & 3
            int r14 = r14 - r13
            int r13 = r14 + 8
            int r13 = a(r8, r13)
            int r15 = r14 + 4
            int r15 = a(r8, r15)
            int r13 = r13 - r15
            int r13 = r13 + r7
            int r13 = r13 * 4
            int r13 = r13 + 12
            int r13 = r13 + r14
            goto L_0x00e6
        L_0x008f:
            if (r14 <= r15) goto L_0x00a1
            r3 = 218(0xda, float:3.05E-43)
            if (r14 >= r3) goto L_0x0098
            int r14 = r14 + -49
            goto L_0x009a
        L_0x0098:
            int r14 = r14 + -20
        L_0x009a:
            int r3 = r13 + 1
            int r3 = c(r8, r3)
            goto L_0x00af
        L_0x00a1:
            int r3 = r13 + 1
            byte r12 = r8[r3]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r4
            int r3 = r3 + r7
            byte r3 = r8[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r3 | r12
            short r3 = (short) r3
        L_0x00af:
            int r3 = r3 + r13
            int r3 = a(r9, r10, r13, r3)
            r12 = -32768(0xffffffffffff8000, float:NaN)
            if (r3 < r12) goto L_0x00bc
            r12 = 32767(0x7fff, float:4.5916E-41)
            if (r3 <= r12) goto L_0x00d3
        L_0x00bc:
            boolean r3 = r2[r13]
            if (r3 != 0) goto L_0x00d3
            r3 = 167(0xa7, float:2.34E-43)
            if (r14 == r3) goto L_0x00cc
            r3 = 168(0xa8, float:2.35E-43)
            if (r14 != r3) goto L_0x00c9
            goto L_0x00cc
        L_0x00c9:
            r17 = 5
            goto L_0x00ce
        L_0x00cc:
            r17 = 2
        L_0x00ce:
            r2[r13] = r7
            r3 = r17
            goto L_0x00d4
        L_0x00d3:
            r3 = 0
        L_0x00d4:
            int r13 = r13 + 3
            goto L_0x00e6
        L_0x00d7:
            int r13 = r13 + 5
            goto L_0x00e5
        L_0x00da:
            int r13 = r13 + 3
            goto L_0x00e5
        L_0x00dd:
            int r13 = r13 + 2
            goto L_0x00e5
        L_0x00e0:
            int r13 = r13 + 1
            goto L_0x00e5
        L_0x00e3:
            int r13 = r13 + 4
        L_0x00e5:
            r3 = 0
        L_0x00e6:
            if (r3 == 0) goto L_0x001e
            int r12 = r9.length
            int r12 = r12 + r7
            int[] r12 = new int[r12]
            int r14 = r10.length
            int r14 = r14 + r7
            int[] r14 = new int[r14]
            int r15 = r9.length
            java.lang.System.arraycopy(r9, r6, r12, r6, r15)
            int r15 = r10.length
            java.lang.System.arraycopy(r10, r6, r14, r6, r15)
            int r9 = r9.length
            r12[r9] = r13
            int r9 = r10.length
            r14[r9] = r3
            r9 = r12
            r10 = r14
            if (r3 <= 0) goto L_0x001e
            r11 = 3
            goto L_0x001e
        L_0x0105:
            if (r11 >= r5) goto L_0x0109
            int r11 = r11 + -1
        L_0x0109:
            if (r11 != 0) goto L_0x001a
            org.objectweb.asm.ByteVector r11 = new org.objectweb.asm.ByteVector
            org.objectweb.asm.ByteVector r13 = r0.r
            int r13 = r13.f6185b
            r11.<init>(r13)
            r13 = 0
        L_0x0115:
            org.objectweb.asm.ByteVector r14 = r0.r
            int r14 = r14.f6185b
            if (r13 >= r14) goto L_0x0274
            byte r14 = r8[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte[] r18 = org.objectweb.asm.ClassWriter.f6190a
            byte r18 = r18[r14]
            switch(r18) {
                case 0: goto L_0x0268;
                case 1: goto L_0x0260;
                case 2: goto L_0x0259;
                case 3: goto L_0x0260;
                case 4: goto L_0x0268;
                case 5: goto L_0x0259;
                case 6: goto L_0x0259;
                case 7: goto L_0x0252;
                case 8: goto L_0x0252;
                case 9: goto L_0x01f0;
                case 10: goto L_0x01dc;
                case 11: goto L_0x0260;
                case 12: goto L_0x0259;
                case 13: goto L_0x0259;
                case 14: goto L_0x018d;
                case 15: goto L_0x0145;
                case 16: goto L_0x0126;
                case 17: goto L_0x012e;
                default: goto L_0x0126;
            }
        L_0x0126:
            r3 = 5
            r11.putByteArray(r8, r13, r12)
            int r13 = r13 + 4
            goto L_0x026e
        L_0x012e:
            int r14 = r13 + 1
            byte r14 = r8[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            if (r14 != r3) goto L_0x013e
            r14 = 6
            r11.putByteArray(r8, r13, r14)
            int r13 = r13 + 6
            goto L_0x0250
        L_0x013e:
            r11.putByteArray(r8, r13, r12)
            int r13 = r13 + 4
            goto L_0x0250
        L_0x0145:
            int r14 = r13 + 4
            r18 = r13 & 3
            int r14 = r14 - r18
            r3 = 171(0xab, float:2.4E-43)
            r11.putByte(r3)
            int r3 = r11.f6185b
            int r3 = r3 % r12
            int r3 = 4 - r3
            int r3 = r3 % r12
            r5 = 0
            r11.putByteArray(r5, r6, r3)
            int r3 = a(r8, r14)
            int r3 = r3 + r13
            int r14 = r14 + r12
            int r3 = a(r9, r10, r13, r3)
            r11.putInt(r3)
            int r3 = a(r8, r14)
            int r14 = r14 + r12
            r11.putInt(r3)
        L_0x016f:
            if (r3 <= 0) goto L_0x018a
            int r5 = a(r8, r14)
            r11.putInt(r5)
            int r14 = r14 + 4
            int r5 = a(r8, r14)
            int r5 = r5 + r13
            int r14 = r14 + r12
            int r5 = a(r9, r10, r13, r5)
            r11.putInt(r5)
            int r3 = r3 + -1
            goto L_0x016f
        L_0x018a:
            r13 = r14
            goto L_0x0250
        L_0x018d:
            int r3 = r13 + 4
            r5 = r13 & 3
            int r3 = r3 - r5
            r5 = 170(0xaa, float:2.38E-43)
            r11.putByte(r5)
            int r5 = r11.f6185b
            int r5 = r5 % r12
            int r5 = 4 - r5
            int r5 = r5 % r12
            r14 = 0
            r11.putByteArray(r14, r6, r5)
            int r5 = a(r8, r3)
            int r5 = r5 + r13
            int r3 = r3 + r12
            int r5 = a(r9, r10, r13, r5)
            r11.putInt(r5)
            int r5 = a(r8, r3)
            int r3 = r3 + r12
            r11.putInt(r5)
            int r14 = a(r8, r3)
            int r14 = r14 - r5
            int r14 = r14 + r7
            int r3 = r3 + r12
            int r5 = r3 + -4
            int r5 = a(r8, r5)
            r11.putInt(r5)
        L_0x01c6:
            if (r14 <= 0) goto L_0x01d9
            int r5 = a(r8, r3)
            int r5 = r5 + r13
            int r3 = r3 + 4
            int r5 = a(r9, r10, r13, r5)
            r11.putInt(r5)
            int r14 = r14 + -1
            goto L_0x01c6
        L_0x01d9:
            r13 = r3
            goto L_0x0250
        L_0x01dc:
            int r3 = r13 + 1
            int r3 = a(r8, r3)
            int r3 = r3 + r13
            int r3 = a(r9, r10, r13, r3)
            r11.putByte(r14)
            r11.putInt(r3)
            int r13 = r13 + 5
            goto L_0x0250
        L_0x01f0:
            r3 = 218(0xda, float:3.05E-43)
            if (r14 <= r15) goto L_0x0203
            if (r14 >= r3) goto L_0x01f9
            int r14 = r14 + -49
            goto L_0x01fb
        L_0x01f9:
            int r14 = r14 + -20
        L_0x01fb:
            int r5 = r13 + 1
            int r5 = c(r8, r5)
            int r5 = r5 + r13
            goto L_0x0213
        L_0x0203:
            int r5 = r13 + 1
            byte r3 = r8[r5]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r4
            int r5 = r5 + r7
            byte r5 = r8[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r3 = r3 | r5
            short r3 = (short) r3
            int r5 = r3 + r13
        L_0x0213:
            int r3 = a(r9, r10, r13, r5)
            boolean r5 = r2[r13]
            if (r5 == 0) goto L_0x0248
            r5 = 200(0xc8, float:2.8E-43)
            r6 = 167(0xa7, float:2.34E-43)
            if (r14 != r6) goto L_0x0225
            r11.putByte(r5)
            goto L_0x0244
        L_0x0225:
            r6 = 168(0xa8, float:2.35E-43)
            if (r14 != r6) goto L_0x022d
            r11.putByte(r15)
            goto L_0x0244
        L_0x022d:
            r6 = 166(0xa6, float:2.33E-43)
            if (r14 > r6) goto L_0x0237
            int r14 = r14 + 1
            r6 = r14 ^ 1
            int r6 = r6 - r7
            goto L_0x0239
        L_0x0237:
            r6 = r14 ^ 1
        L_0x0239:
            r11.putByte(r6)
            r11.putShort(r4)
            r11.putByte(r5)
            int r3 = r3 + -3
        L_0x0244:
            r11.putInt(r3)
            goto L_0x024e
        L_0x0248:
            r11.putByte(r14)
            r11.putShort(r3)
        L_0x024e:
            int r13 = r13 + 3
        L_0x0250:
            r3 = 5
            goto L_0x026e
        L_0x0252:
            r3 = 5
            r11.putByteArray(r8, r13, r3)
            int r13 = r13 + 5
            goto L_0x026e
        L_0x0259:
            r3 = 5
            r11.putByteArray(r8, r13, r5)
            int r13 = r13 + 3
            goto L_0x026e
        L_0x0260:
            r3 = 5
            r5 = 2
            r11.putByteArray(r8, r13, r5)
            int r13 = r13 + 2
            goto L_0x026e
        L_0x0268:
            r3 = 5
            r11.putByte(r14)
            int r13 = r13 + 1
        L_0x026e:
            r3 = 132(0x84, float:1.85E-43)
            r5 = 3
            r6 = 0
            goto L_0x0115
        L_0x0274:
            int r3 = r0.M
            if (r3 != 0) goto L_0x02b6
            org.objectweb.asm.Label r3 = r0.N
        L_0x027a:
            if (r3 == 0) goto L_0x0292
            int r5 = r3.f6232c
            r6 = 3
            int r5 = r5 - r6
            if (r5 < 0) goto L_0x028c
            boolean r5 = r2[r5]
            if (r5 == 0) goto L_0x028c
            int r5 = r3.f6230a
            r5 = r5 | 16
            r3.f6230a = r5
        L_0x028c:
            a(r9, r10, r3)
            org.objectweb.asm.Label r3 = r3.i
            goto L_0x027a
        L_0x0292:
            org.objectweb.asm.ClassWriter r2 = r0.f6236b
            org.objectweb.asm.Item[] r2 = r2.H
            if (r2 == 0) goto L_0x02be
            r2 = 0
        L_0x0299:
            org.objectweb.asm.ClassWriter r3 = r0.f6236b
            org.objectweb.asm.Item[] r3 = r3.H
            int r5 = r3.length
            if (r2 >= r5) goto L_0x02be
            r3 = r3[r2]
            if (r3 == 0) goto L_0x02b3
            int r5 = r3.f6227b
            r6 = 31
            if (r5 != r6) goto L_0x02b3
            int r5 = r3.f6228c
            r6 = 0
            int r5 = a(r9, r10, r6, r5)
            r3.f6228c = r5
        L_0x02b3:
            int r2 = r2 + 1
            goto L_0x0299
        L_0x02b6:
            int r2 = r0.u
            if (r2 <= 0) goto L_0x02be
            org.objectweb.asm.ClassWriter r2 = r0.f6236b
            r2.L = r7
        L_0x02be:
            org.objectweb.asm.Handler r2 = r0.B
        L_0x02c0:
            if (r2 == 0) goto L_0x02d4
            org.objectweb.asm.Label r3 = r2.f6220a
            a(r9, r10, r3)
            org.objectweb.asm.Label r3 = r2.f6221b
            a(r9, r10, r3)
            org.objectweb.asm.Label r3 = r2.f6222c
            a(r9, r10, r3)
            org.objectweb.asm.Handler r2 = r2.f6225f
            goto L_0x02c0
        L_0x02d4:
            r2 = 0
            r3 = 2
        L_0x02d6:
            if (r2 >= r3) goto L_0x0317
            if (r2 != 0) goto L_0x02dd
            org.objectweb.asm.ByteVector r5 = r0.E
            goto L_0x02df
        L_0x02dd:
            org.objectweb.asm.ByteVector r5 = r0.G
        L_0x02df:
            if (r5 == 0) goto L_0x0314
            byte[] r6 = r5.f6184a
            r8 = 0
        L_0x02e4:
            int r12 = r5.f6185b
            if (r8 >= r12) goto L_0x0314
            int r12 = c(r6, r8)
            r13 = 0
            int r14 = a(r9, r10, r13, r12)
            int r13 = r14 >>> 8
            byte r13 = (byte) r13
            r6[r8] = r13
            int r13 = r8 + 1
            byte r15 = (byte) r14
            r6[r13] = r15
            int r13 = r8 + 2
            int r15 = c(r6, r13)
            int r15 = r15 + r12
            r12 = 0
            int r15 = a(r9, r10, r12, r15)
            int r15 = r15 - r14
            int r12 = r15 >>> 8
            byte r12 = (byte) r12
            r6[r13] = r12
            int r13 = r13 + r7
            byte r12 = (byte) r15
            r6[r13] = r12
            int r8 = r8 + 10
            goto L_0x02e4
        L_0x0314:
            int r2 = r2 + 1
            goto L_0x02d6
        L_0x0317:
            org.objectweb.asm.ByteVector r2 = r0.I
            if (r2 == 0) goto L_0x033a
            byte[] r2 = r2.f6184a
            r3 = 0
        L_0x031e:
            org.objectweb.asm.ByteVector r5 = r0.I
            int r5 = r5.f6185b
            if (r3 >= r5) goto L_0x033a
            int r5 = c(r2, r3)
            r6 = 0
            int r5 = a(r9, r10, r6, r5)
            int r6 = r5 >>> 8
            byte r6 = (byte) r6
            r2[r3] = r6
            int r6 = r3 + 1
            byte r5 = (byte) r5
            r2[r6] = r5
            int r3 = r3 + 4
            goto L_0x031e
        L_0x033a:
            org.objectweb.asm.Attribute r2 = r0.J
        L_0x033c:
            if (r2 == 0) goto L_0x0341
            org.objectweb.asm.Attribute r2 = r2.f6182a
            goto L_0x033c
        L_0x0341:
            r0.r = r11
        L_0x0343:
            int r2 = r0.M
            if (r2 != 0) goto L_0x05f8
            org.objectweb.asm.Handler r1 = r0.B
        L_0x0349:
            r2 = 24117248(0x1700000, float:4.4081038E-38)
            if (r1 == 0) goto L_0x0389
            org.objectweb.asm.Label r4 = r1.f6220a
            org.objectweb.asm.Label r4 = r4.a()
            org.objectweb.asm.Label r5 = r1.f6222c
            org.objectweb.asm.Label r5 = r5.a()
            org.objectweb.asm.Label r6 = r1.f6221b
            org.objectweb.asm.Label r6 = r6.a()
            java.lang.String r8 = r1.f6223d
            if (r8 != 0) goto L_0x0365
            java.lang.String r8 = "java/lang/Throwable"
        L_0x0365:
            org.objectweb.asm.ClassWriter r9 = r0.f6236b
            int r8 = r9.c(r8)
            r2 = r2 | r8
            int r8 = r5.f6230a
            r8 = r8 | 16
            r5.f6230a = r8
        L_0x0372:
            if (r4 == r6) goto L_0x0386
            org.objectweb.asm.Edge r8 = new org.objectweb.asm.Edge
            r8.<init>()
            r8.f6202a = r2
            r8.f6203b = r5
            org.objectweb.asm.Edge r9 = r4.j
            r8.f6204c = r9
            r4.j = r8
            org.objectweb.asm.Label r4 = r4.i
            goto L_0x0372
        L_0x0386:
            org.objectweb.asm.Handler r1 = r1.f6225f
            goto L_0x0349
        L_0x0389:
            org.objectweb.asm.Label r1 = r0.N
            org.objectweb.asm.Frame r1 = r1.h
            java.lang.String r4 = r0.f6240f
            org.objectweb.asm.Type[] r4 = org.objectweb.asm.Type.getArgumentTypes(r4)
            org.objectweb.asm.ClassWriter r5 = r0.f6236b
            int r6 = r0.f6237c
            int r8 = r0.t
            if (r1 == 0) goto L_0x05f6
            int[] r9 = new int[r8]
            r1.f6212c = r9
            r10 = 0
            int[] r11 = new int[r10]
            r1.f6213d = r11
            r11 = r6 & 8
            if (r11 != 0) goto L_0x03bf
            r11 = 524288(0x80000, float:7.34684E-40)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x03b7
            java.lang.String r6 = r5.I
            int r6 = r5.c(r6)
            r6 = r6 | r2
            r9[r10] = r6
            goto L_0x03bc
        L_0x03b7:
            r6 = 16777222(0x1000006, float:2.3509904E-38)
            r9[r10] = r6
        L_0x03bc:
            r6 = 0
            r9 = 1
            goto L_0x03c1
        L_0x03bf:
            r6 = 0
            r9 = 0
        L_0x03c1:
            int r10 = r4.length
            r11 = 16777219(0x1000003, float:2.3509895E-38)
            r12 = 16777216(0x1000000, float:2.3509887E-38)
            if (r6 >= r10) goto L_0x03ed
            r10 = r4[r6]
            java.lang.String r10 = r10.getDescriptor()
            int r10 = org.objectweb.asm.Frame.b(r5, r10)
            int[] r13 = r1.f6212c
            int r14 = r9 + 1
            r13[r9] = r10
            r9 = 16777220(0x1000004, float:2.3509898E-38)
            if (r10 == r9) goto L_0x03e3
            if (r10 != r11) goto L_0x03e1
            goto L_0x03e3
        L_0x03e1:
            r9 = r14
            goto L_0x03ea
        L_0x03e3:
            int[] r9 = r1.f6212c
            int r10 = r14 + 1
            r9[r14] = r12
            r9 = r10
        L_0x03ea:
            int r6 = r6 + 1
            goto L_0x03c1
        L_0x03ed:
            if (r9 >= r8) goto L_0x03f7
            int[] r4 = r1.f6212c
            int r5 = r9 + 1
            r4[r9] = r12
            r9 = r5
            goto L_0x03ed
        L_0x03f7:
            r0.b(r1)
            org.objectweb.asm.Label r1 = r0.N
            r4 = 0
        L_0x03fd:
            if (r1 == 0) goto L_0x057b
            org.objectweb.asm.Label r5 = r1.k
            r6 = 0
            r1.k = r6
            org.objectweb.asm.Frame r6 = r1.h
            int r8 = r1.f6230a
            r9 = r8 & 16
            if (r9 == 0) goto L_0x0410
            r8 = r8 | 32
            r1.f6230a = r8
        L_0x0410:
            int r8 = r1.f6230a
            r8 = r8 | 64
            r1.f6230a = r8
            int[] r8 = r6.f6213d
            int r8 = r8.length
            int r9 = r1.g
            int r8 = r8 + r9
            if (r8 <= r4) goto L_0x041f
            r4 = r8
        L_0x041f:
            org.objectweb.asm.Edge r1 = r1.j
        L_0x0421:
            if (r1 == 0) goto L_0x0576
            org.objectweb.asm.Label r8 = r1.f6203b
            org.objectweb.asm.Label r8 = r8.a()
            org.objectweb.asm.ClassWriter r9 = r0.f6236b
            org.objectweb.asm.Frame r10 = r8.h
            int r13 = r1.f6202a
            int[] r14 = r6.f6212c
            int r14 = r14.length
            int[] r15 = r6.f6213d
            int r15 = r15.length
            int[] r2 = r10.f6212c
            if (r2 != 0) goto L_0x043f
            int[] r2 = new int[r14]
            r10.f6212c = r2
            r2 = 1
            goto L_0x0440
        L_0x043f:
            r2 = 0
        L_0x0440:
            r3 = 0
        L_0x0441:
            r16 = 8388608(0x800000, float:1.1754944E-38)
            r17 = 251658240(0xf000000, float:6.3108872E-30)
            r18 = -268435456(0xfffffffff0000000, float:-1.5845633E29)
            r19 = 8388607(0x7fffff, float:1.1754942E-38)
            if (r3 >= r14) goto L_0x04ad
            int[] r7 = r6.f6214e
            if (r7 == 0) goto L_0x048e
            int r11 = r7.length
            if (r3 >= r11) goto L_0x048e
            r7 = r7[r3]
            if (r7 != 0) goto L_0x045e
            int[] r7 = r6.f6212c
            r7 = r7[r3]
            r21 = r4
            goto L_0x0494
        L_0x045e:
            r11 = r7 & r18
            r21 = r4
            r4 = r7 & r17
            if (r4 != r12) goto L_0x0467
            goto L_0x0494
        L_0x0467:
            r12 = 33554432(0x2000000, float:9.403955E-38)
            if (r4 != r12) goto L_0x0472
            int[] r4 = r6.f6212c
            r12 = r7 & r19
            r4 = r4[r12]
            goto L_0x047a
        L_0x0472:
            int[] r4 = r6.f6213d
            r12 = r7 & r19
            int r12 = r15 - r12
            r4 = r4[r12]
        L_0x047a:
            int r11 = r11 + r4
            r4 = r7 & r16
            if (r4 == 0) goto L_0x048c
            r4 = 16777220(0x1000004, float:2.3509898E-38)
            if (r11 == r4) goto L_0x0489
            r4 = 16777219(0x1000003, float:2.3509895E-38)
            if (r11 != r4) goto L_0x048c
        L_0x0489:
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x0494
        L_0x048c:
            r7 = r11
            goto L_0x0494
        L_0x048e:
            r21 = r4
            int[] r4 = r6.f6212c
            r7 = r4[r3]
        L_0x0494:
            int[] r4 = r6.i
            if (r4 == 0) goto L_0x049c
            int r7 = r6.a(r9, r7)
        L_0x049c:
            int[] r4 = r10.f6212c
            boolean r4 = org.objectweb.asm.Frame.a(r9, r7, r4, r3)
            r2 = r2 | r4
            int r3 = r3 + 1
            r4 = r21
            r11 = 16777219(0x1000003, float:2.3509895E-38)
            r12 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x0441
        L_0x04ad:
            r21 = r4
            if (r13 <= 0) goto L_0x04d8
            r3 = 0
        L_0x04b2:
            if (r3 >= r14) goto L_0x04c2
            int[] r4 = r6.f6212c
            r4 = r4[r3]
            int[] r7 = r10.f6212c
            boolean r4 = org.objectweb.asm.Frame.a(r9, r4, r7, r3)
            r2 = r2 | r4
            int r3 = r3 + 1
            goto L_0x04b2
        L_0x04c2:
            int[] r3 = r10.f6213d
            if (r3 != 0) goto L_0x04cc
            r3 = 1
            int[] r2 = new int[r3]
            r10.f6213d = r2
            r2 = 1
        L_0x04cc:
            int[] r3 = r10.f6213d
            r4 = 0
            boolean r3 = org.objectweb.asm.Frame.a(r9, r13, r3, r4)
            r2 = r2 | r3
        L_0x04d4:
            r13 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x055f
        L_0x04d8:
            int[] r3 = r6.f6213d
            int r3 = r3.length
            org.objectweb.asm.Label r4 = r6.f6211b
            int r4 = r4.f6235f
            int r3 = r3 + r4
            int[] r4 = r10.f6213d
            if (r4 != 0) goto L_0x04ec
            int r2 = r6.g
            int r2 = r2 + r3
            int[] r2 = new int[r2]
            r10.f6213d = r2
            r2 = 1
        L_0x04ec:
            r4 = 0
        L_0x04ed:
            if (r4 >= r3) goto L_0x0505
            int[] r7 = r6.f6213d
            r7 = r7[r4]
            int[] r11 = r6.i
            if (r11 == 0) goto L_0x04fb
            int r7 = r6.a(r9, r7)
        L_0x04fb:
            int[] r11 = r10.f6213d
            boolean r7 = org.objectweb.asm.Frame.a(r9, r7, r11, r4)
            r2 = r2 | r7
            int r4 = r4 + 1
            goto L_0x04ed
        L_0x0505:
            r4 = 0
        L_0x0506:
            int r7 = r6.g
            if (r4 >= r7) goto L_0x04d4
            int[] r7 = r6.f6215f
            r7 = r7[r4]
            r11 = r7 & r18
            r12 = r7 & r17
            r13 = 16777216(0x1000000, float:2.3509887E-38)
            if (r12 != r13) goto L_0x0520
            r11 = r7
            r7 = 16777220(0x1000004, float:2.3509898E-38)
            r12 = 16777219(0x1000003, float:2.3509895E-38)
            r14 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x054b
        L_0x0520:
            r14 = 33554432(0x2000000, float:9.403955E-38)
            if (r12 != r14) goto L_0x052b
            int[] r12 = r6.f6212c
            r20 = r7 & r19
            r12 = r12[r20]
            goto L_0x0533
        L_0x052b:
            int[] r12 = r6.f6213d
            r20 = r7 & r19
            int r20 = r15 - r20
            r12 = r12[r20]
        L_0x0533:
            int r11 = r11 + r12
            r7 = r7 & r16
            if (r7 == 0) goto L_0x0545
            r7 = 16777220(0x1000004, float:2.3509898E-38)
            r12 = 16777219(0x1000003, float:2.3509895E-38)
            if (r11 == r7) goto L_0x0542
            if (r11 != r12) goto L_0x054b
        L_0x0542:
            r11 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x054b
        L_0x0545:
            r7 = 16777220(0x1000004, float:2.3509898E-38)
            r12 = 16777219(0x1000003, float:2.3509895E-38)
        L_0x054b:
            int[] r7 = r6.i
            if (r7 == 0) goto L_0x0553
            int r11 = r6.a(r9, r11)
        L_0x0553:
            int[] r7 = r10.f6213d
            int r12 = r3 + r4
            boolean r7 = org.objectweb.asm.Frame.a(r9, r11, r7, r12)
            r2 = r2 | r7
            int r4 = r4 + 1
            goto L_0x0506
        L_0x055f:
            if (r2 == 0) goto L_0x0568
            org.objectweb.asm.Label r2 = r8.k
            if (r2 != 0) goto L_0x0568
            r8.k = r5
            r5 = r8
        L_0x0568:
            org.objectweb.asm.Edge r1 = r1.f6204c
            r4 = r21
            r2 = 24117248(0x1700000, float:4.4081038E-38)
            r7 = 1
            r11 = 16777219(0x1000003, float:2.3509895E-38)
            r12 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x0421
        L_0x0576:
            r21 = r4
            r1 = r5
            goto L_0x03fd
        L_0x057b:
            org.objectweb.asm.Label r1 = r0.N
        L_0x057d:
            if (r1 == 0) goto L_0x05e2
            org.objectweb.asm.Frame r2 = r1.h
            int r3 = r1.f6230a
            r5 = 32
            r3 = r3 & r5
            if (r3 == 0) goto L_0x058b
            r0.b(r2)
        L_0x058b:
            int r2 = r1.f6230a
            r2 = r2 & 64
            if (r2 != 0) goto L_0x05dc
            org.objectweb.asm.Label r2 = r1.i
            int r3 = r1.f6232c
            if (r2 != 0) goto L_0x059c
            org.objectweb.asm.ByteVector r5 = r0.r
            int r5 = r5.f6185b
            goto L_0x059e
        L_0x059c:
            int r5 = r2.f6232c
        L_0x059e:
            r6 = 1
            int r5 = r5 - r6
            if (r5 < r3) goto L_0x05dc
            int r4 = java.lang.Math.max(r4, r6)
            r6 = r3
        L_0x05a7:
            if (r6 >= r5) goto L_0x05b3
            org.objectweb.asm.ByteVector r7 = r0.r
            byte[] r7 = r7.f6184a
            r8 = 0
            r7[r6] = r8
            int r6 = r6 + 1
            goto L_0x05a7
        L_0x05b3:
            r8 = 0
            org.objectweb.asm.ByteVector r6 = r0.r
            byte[] r6 = r6.f6184a
            r7 = -65
            r6[r5] = r7
            r5 = 1
            r0.a(r3, r8, r5)
            int[] r3 = r0.z
            org.objectweb.asm.ClassWriter r5 = r0.f6236b
            java.lang.String r6 = "java/lang/Throwable"
            int r5 = r5.c(r6)
            r6 = 24117248(0x1700000, float:4.4081038E-38)
            r5 = r5 | r6
            r7 = 3
            r3[r7] = r5
            r22.b()
            org.objectweb.asm.Handler r3 = r0.B
            org.objectweb.asm.Handler r2 = org.objectweb.asm.Handler.a(r3, r1, r2)
            r0.B = r2
            goto L_0x05df
        L_0x05dc:
            r6 = 24117248(0x1700000, float:4.4081038E-38)
            r7 = 3
        L_0x05df:
            org.objectweb.asm.Label r1 = r1.i
            goto L_0x057d
        L_0x05e2:
            org.objectweb.asm.Handler r1 = r0.B
            r6 = 0
            r0.A = r6
        L_0x05e7:
            if (r1 == 0) goto L_0x05f2
            int r2 = r0.A
            r3 = 1
            int r2 = r2 + r3
            r0.A = r2
            org.objectweb.asm.Handler r1 = r1.f6225f
            goto L_0x05e7
        L_0x05f2:
            r0.s = r4
            goto L_0x06df
        L_0x05f6:
            r1 = 0
            throw r1
        L_0x05f8:
            r3 = 1
            r6 = 0
            if (r2 != r3) goto L_0x06d9
            org.objectweb.asm.Handler r2 = r0.B
        L_0x05fe:
            if (r2 == 0) goto L_0x0633
            org.objectweb.asm.Label r5 = r2.f6220a
            org.objectweb.asm.Label r7 = r2.f6222c
            org.objectweb.asm.Label r8 = r2.f6221b
        L_0x0606:
            if (r5 == r8) goto L_0x0630
            org.objectweb.asm.Edge r9 = new org.objectweb.asm.Edge
            r9.<init>()
            r10 = 2147483647(0x7fffffff, float:NaN)
            r9.f6202a = r10
            r9.f6203b = r7
            int r10 = r5.f6230a
            r10 = r10 & 128(0x80, float:1.8E-43)
            if (r10 != 0) goto L_0x0621
            org.objectweb.asm.Edge r10 = r5.j
            r9.f6204c = r10
            r5.j = r9
            goto L_0x062d
        L_0x0621:
            org.objectweb.asm.Edge r10 = r5.j
            org.objectweb.asm.Edge r11 = r10.f6204c
            org.objectweb.asm.Edge r11 = r11.f6204c
            r9.f6204c = r11
            org.objectweb.asm.Edge r10 = r10.f6204c
            r10.f6204c = r9
        L_0x062d:
            org.objectweb.asm.Label r5 = r5.i
            goto L_0x0606
        L_0x0630:
            org.objectweb.asm.Handler r2 = r2.f6225f
            goto L_0x05fe
        L_0x0633:
            int r2 = r0.L
            if (r2 <= 0) goto L_0x0699
            org.objectweb.asm.Label r5 = r0.N
            r7 = 1
            r9 = 0
            r5.b(r9, r7, r2)
            org.objectweb.asm.Label r2 = r0.N
            r5 = 0
        L_0x0642:
            if (r2 == 0) goto L_0x0672
            int r7 = r2.f6230a
            r7 = r7 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L_0x066c
            org.objectweb.asm.Edge r7 = r2.j
            org.objectweb.asm.Edge r7 = r7.f6204c
            org.objectweb.asm.Label r7 = r7.f6203b
            int r8 = r7.f6230a
            r8 = r8 & 1024(0x400, float:1.435E-42)
            if (r8 != 0) goto L_0x066c
            int r5 = r5 + 1
            long r8 = (long) r5
            r10 = 32
            long r8 = r8 / r10
            r10 = 32
            long r8 = r8 << r10
            r11 = 1
            int r13 = r5 % 32
            long r11 = r11 << r13
            long r8 = r8 | r11
            int r11 = r0.L
            r12 = 0
            r7.b(r12, r8, r11)
            goto L_0x066f
        L_0x066c:
            r10 = 32
            r12 = 0
        L_0x066f:
            org.objectweb.asm.Label r2 = r2.i
            goto L_0x0642
        L_0x0672:
            org.objectweb.asm.Label r2 = r0.N
        L_0x0674:
            if (r2 == 0) goto L_0x0699
            int r5 = r2.f6230a
            r5 = r5 & 128(0x80, float:1.8E-43)
            if (r5 == 0) goto L_0x0696
            org.objectweb.asm.Label r5 = r0.N
        L_0x067e:
            if (r5 == 0) goto L_0x0689
            int r7 = r5.f6230a
            r7 = r7 & -2049(0xfffffffffffff7ff, float:NaN)
            r5.f6230a = r7
            org.objectweb.asm.Label r5 = r5.i
            goto L_0x067e
        L_0x0689:
            org.objectweb.asm.Edge r5 = r2.j
            org.objectweb.asm.Edge r5 = r5.f6204c
            org.objectweb.asm.Label r5 = r5.f6203b
            r7 = 0
            int r9 = r0.L
            r5.b(r2, r7, r9)
        L_0x0696:
            org.objectweb.asm.Label r2 = r2.i
            goto L_0x0674
        L_0x0699:
            org.objectweb.asm.Label r2 = r0.N
        L_0x069b:
            if (r2 == 0) goto L_0x06d2
            org.objectweb.asm.Label r5 = r2.k
            int r7 = r2.f6235f
            int r8 = r2.g
            int r8 = r8 + r7
            if (r8 <= r6) goto L_0x06a7
            r6 = r8
        L_0x06a7:
            org.objectweb.asm.Edge r8 = r2.j
            int r2 = r2.f6230a
            r2 = r2 & 128(0x80, float:1.8E-43)
            if (r2 == 0) goto L_0x06b1
            org.objectweb.asm.Edge r8 = r8.f6204c
        L_0x06b1:
            r2 = r5
        L_0x06b2:
            if (r8 == 0) goto L_0x069b
            org.objectweb.asm.Label r5 = r8.f6203b
            int r9 = r5.f6230a
            r9 = r9 & r4
            if (r9 != 0) goto L_0x06cf
            int r9 = r8.f6202a
            r10 = 2147483647(0x7fffffff, float:NaN)
            if (r9 != r10) goto L_0x06c4
            r9 = 1
            goto L_0x06c5
        L_0x06c4:
            int r9 = r9 + r7
        L_0x06c5:
            r5.f6235f = r9
            int r9 = r5.f6230a
            r9 = r9 | r4
            r5.f6230a = r9
            r5.k = r2
            r2 = r5
        L_0x06cf:
            org.objectweb.asm.Edge r8 = r8.f6204c
            goto L_0x06b2
        L_0x06d2:
            int r1 = java.lang.Math.max(r1, r6)
            r0.s = r1
            goto L_0x06df
        L_0x06d9:
            r0.s = r1
            r1 = r24
            r0.t = r1
        L_0x06df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.visitMaxs(int, int):void");
    }

    public void visitMethodInsn(int i2, String str, String str2, String str3, boolean z2) {
        this.Y = this.r.f6185b;
        Item a2 = this.f6236b.a(str, str2, str3, z2);
        int i3 = a2.f6228c;
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, 0, this.f6236b, a2);
            } else {
                if (i3 == 0) {
                    i3 = Type.getArgumentsAndReturnSizes(str3);
                    a2.f6228c = i3;
                }
                int i4 = i2 == 184 ? (this.Q - (i3 >> 2)) + (i3 & 3) + 1 : (this.Q - (i3 >> 2)) + (i3 & 3);
                if (i4 > this.R) {
                    this.R = i4;
                }
                this.Q = i4;
            }
        }
        if (i2 == 185) {
            if (i3 == 0) {
                i3 = Type.getArgumentsAndReturnSizes(str3);
                a2.f6228c = i3;
            }
            ByteVector byteVector = this.r;
            byteVector.b(185, a2.f6226a);
            byteVector.a(i3 >> 2, 0);
            return;
        }
        this.r.b(i2, a2.f6226a);
    }

    public AnnotationWriter visitParameterAnnotation(int i2, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.S = Math.max(this.S, i2 + 1);
            AnnotationWriter annotationWriter = new AnnotationWriter(this.f6236b, false, byteVector, null, 0);
            return annotationWriter;
        }
        byteVector.putShort(this.f6236b.newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter2 = new AnnotationWriter(this.f6236b, true, byteVector, byteVector, 2);
        if (z2) {
            if (this.o == null) {
                this.o = new AnnotationWriter[Type.getArgumentTypes(this.f6240f).length];
            }
            AnnotationWriter[] annotationWriterArr = this.o;
            annotationWriter2.g = annotationWriterArr[i2];
            annotationWriterArr[i2] = annotationWriter2;
        } else {
            if (this.p == null) {
                this.p = new AnnotationWriter[Type.getArgumentTypes(this.f6240f).length];
            }
            AnnotationWriter[] annotationWriterArr2 = this.p;
            annotationWriter2.g = annotationWriterArr2[i2];
            annotationWriterArr2[i2] = annotationWriter2;
        }
        return annotationWriter2;
    }

    public void visitTableSwitchInsn(int i2, int i3, Label label, Label... labelArr) {
        ByteVector byteVector = this.r;
        int i4 = byteVector.f6185b;
        this.Y = i4;
        byteVector.putByte(170);
        ByteVector byteVector2 = this.r;
        byteVector2.putByteArray(null, 0, (4 - (byteVector2.f6185b % 4)) % 4);
        label.a(this.r, i4, true);
        ByteVector byteVector3 = this.r;
        byteVector3.putInt(i2);
        byteVector3.putInt(i3);
        for (Label a2 : labelArr) {
            a2.a(this.r, i4, true);
        }
        a(label, labelArr);
    }

    public AnnotationWriter visitTypeAnnotation(int i2, TypePath typePath, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(i2, typePath, byteVector);
        byteVector.putShort(this.f6236b.newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6236b, true, byteVector, byteVector, byteVector.f6185b - 2);
        if (z2) {
            annotationWriter.g = this.U;
            this.U = annotationWriter;
        } else {
            annotationWriter.g = this.V;
            this.V = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitTypeInsn(int i2, String str) {
        this.Y = this.r.f6185b;
        Item a2 = this.f6236b.a(str);
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, this.r.f6185b, this.f6236b, a2);
            } else if (i2 == 187) {
                int i3 = this.Q + 1;
                if (i3 > this.R) {
                    this.R = i3;
                }
                this.Q = i3;
            }
        }
        this.r.b(i2, a2.f6226a);
    }

    public void visitVarInsn(int i2, int i3) {
        this.Y = this.r.f6185b;
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, i3, (ClassWriter) null, (Item) null);
            } else if (i2 == 169) {
                label.f6230a |= 256;
                label.f6235f = this.Q;
                e();
            } else {
                int i4 = this.Q + Frame.f6210a[i2];
                if (i4 > this.R) {
                    this.R = i4;
                }
                this.Q = i4;
            }
        }
        if (this.M != 2) {
            int i5 = (i2 == 22 || i2 == 24 || i2 == 55 || i2 == 57) ? i3 + 2 : i3 + 1;
            if (i5 > this.t) {
                this.t = i5;
            }
        }
        if (i3 >= 4 || i2 == 169) {
            ByteVector byteVector = this.r;
            if (i3 >= 256) {
                byteVector.putByte(196);
                byteVector.b(i2, i3);
            } else {
                byteVector.a(i2, i3);
            }
        } else {
            this.r.putByte((i2 < 54 ? ((i2 - 21) << 2) + 26 : ((i2 - 54) << 2) + 59) + i3);
        }
        if (i2 >= 54 && this.M == 0 && this.A > 0) {
            visitLabel(new Label());
        }
    }
}
