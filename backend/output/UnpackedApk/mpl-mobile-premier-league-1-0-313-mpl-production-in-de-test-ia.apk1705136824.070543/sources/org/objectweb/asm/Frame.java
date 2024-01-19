package org.objectweb.asm;

public final class Frame {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f6210a;

    /* renamed from: b  reason: collision with root package name */
    public Label f6211b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f6212c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f6213d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f6214e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f6215f;
    public int g;
    public int h;
    public int[] i;

    static {
        int[] iArr = new int[202];
        for (int i2 = 0; i2 < 202; i2++) {
            iArr[i2] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i2) - 'E';
        }
        f6210a = iArr;
    }

    public static int b(ClassWriter classWriter, String str) {
        int indexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        char charAt = str.charAt(indexOf);
        int i2 = 16777218;
        if (charAt == 'F') {
            return 16777218;
        }
        if (charAt == 'L') {
            return classWriter.c(str.substring(indexOf + 1, str.length() - 1)) | 24117248;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (!(charAt == 'Z' || charAt == 'I')) {
                if (charAt == 'J') {
                    return 16777220;
                }
                switch (charAt) {
                    case 'B':
                    case 'C':
                        break;
                    case 'D':
                        return 16777219;
                    default:
                        int i3 = indexOf + 1;
                        while (str.charAt(i3) == '[') {
                            i3++;
                        }
                        char charAt2 = str.charAt(i3);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'S') {
                                i2 = 16777228;
                            } else if (charAt2 == 'Z') {
                                i2 = 16777225;
                            } else if (charAt2 == 'I') {
                                i2 = 16777217;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i2 = 16777226;
                                        break;
                                    case 'C':
                                        i2 = 16777227;
                                        break;
                                    case 'D':
                                        i2 = 16777219;
                                        break;
                                    default:
                                        i2 = classWriter.c(str.substring(i3 + 1, str.length() - 1)) | 24117248;
                                        break;
                                }
                            } else {
                                i2 = 16777220;
                            }
                        }
                        return ((i3 - indexOf) << 28) | i2;
                }
            }
        }
        return 16777217;
    }

    public final int a() {
        int i2 = this.g;
        if (i2 > 0) {
            int[] iArr = this.f6215f;
            int i3 = i2 - 1;
            this.g = i3;
            return iArr[i3];
        }
        Label label = this.f6211b;
        int i4 = label.f6235f - 1;
        label.f6235f = i4;
        return 50331648 | (-i4);
    }

    public final int a(int i2) {
        int[] iArr = this.f6214e;
        if (iArr == null || i2 >= iArr.length) {
            return i2 | 33554432;
        }
        int i3 = iArr[i2];
        if (i3 == 0) {
            i3 = i2 | 33554432;
            iArr[i2] = i3;
        }
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A[LOOP:0: B:8:0x0022->B:19:0x004d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(org.objectweb.asm.ClassWriter r7, int r8) {
        /*
            r6 = this;
            r0 = 24117248(0x1700000, float:4.4081038E-38)
            r1 = 16777222(0x1000006, float:2.3509904E-38)
            if (r8 != r1) goto L_0x000f
            java.lang.String r1 = r7.I
        L_0x0009:
            int r7 = r7.c(r1)
            r7 = r7 | r0
            goto L_0x0021
        L_0x000f:
            r1 = -1048576(0xfffffffffff00000, float:NaN)
            r1 = r1 & r8
            r2 = 25165824(0x1800000, float:4.7019774E-38)
            if (r1 != r2) goto L_0x0050
            org.objectweb.asm.Item[] r1 = r7.H
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r8
            r1 = r1[r2]
            java.lang.String r1 = r1.g
            goto L_0x0009
        L_0x0021:
            r0 = 0
        L_0x0022:
            int r1 = r6.h
            if (r0 >= r1) goto L_0x0050
            int[] r1 = r6.i
            r1 = r1[r0]
            r2 = -268435456(0xfffffffff0000000, float:-1.5845633E29)
            r2 = r2 & r1
            r3 = 251658240(0xf000000, float:6.3108872E-30)
            r3 = r3 & r1
            r4 = 33554432(0x2000000, float:9.403955E-38)
            r5 = 8388607(0x7fffff, float:1.1754942E-38)
            if (r3 != r4) goto L_0x003e
            int[] r3 = r6.f6212c
            r1 = r1 & r5
            r1 = r3[r1]
        L_0x003c:
            int r1 = r1 + r2
            goto L_0x004a
        L_0x003e:
            r4 = 50331648(0x3000000, float:3.761582E-37)
            if (r3 != r4) goto L_0x004a
            int[] r3 = r6.f6213d
            int r4 = r3.length
            r1 = r1 & r5
            int r4 = r4 - r1
            r1 = r3[r4]
            goto L_0x003c
        L_0x004a:
            if (r8 != r1) goto L_0x004d
            return r7
        L_0x004d:
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0050:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.Frame.a(org.objectweb.asm.ClassWriter, int):int");
    }

    public final void a(int i2, int i3) {
        if (this.f6214e == null) {
            this.f6214e = new int[10];
        }
        int length = this.f6214e.length;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.f6214e, 0, iArr, 0, length);
            this.f6214e = iArr;
        }
        this.f6214e[i2] = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x023c, code lost:
        r1 = r3.c(r1) | 24117248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0245, code lost:
        b(16777219);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0249, code lost:
        b(16777218);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x024d, code lost:
        b(16777220);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0250, code lost:
        b(16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0254, code lost:
        b(16777217);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x025b, code lost:
        b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        a(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r1.charAt(0) == '[') goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010d, code lost:
        r1 = r4.i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0199, code lost:
        b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x019c, code lost:
        b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a8, code lost:
        b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ab, code lost:
        b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0202, code lost:
        a(r1, r2 | org.apache.pdfbox.pdmodel.interactive.form.PDTextField.FLAG_DO_NOT_SCROLL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0207, code lost:
        a(r1, 16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0216, code lost:
        c(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x021a, code lost:
        c(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x021e, code lost:
        c(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0222, code lost:
        c(2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r17, int r18, org.objectweb.asm.ClassWriter r19, org.objectweb.asm.Item r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = 198(0xc6, float:2.77E-43)
            r6 = 1
            if (r1 == r5) goto L_0x025f
            r5 = 199(0xc7, float:2.79E-43)
            if (r1 == r5) goto L_0x025f
            r5 = 24117248(0x1700000, float:4.4081038E-38)
            r7 = 16777218(0x1000002, float:2.3509893E-38)
            r8 = 16777219(0x1000003, float:2.3509895E-38)
            r9 = 16777217(0x1000001, float:2.350989E-38)
            r10 = 16777220(0x1000004, float:2.3509898E-38)
            r11 = 16777216(0x1000000, float:2.3509887E-38)
            switch(r1) {
                case 0: goto L_0x0262;
                case 1: goto L_0x0258;
                case 2: goto L_0x0254;
                case 3: goto L_0x0254;
                case 4: goto L_0x0254;
                case 5: goto L_0x0254;
                case 6: goto L_0x0254;
                case 7: goto L_0x0254;
                case 8: goto L_0x0254;
                case 9: goto L_0x024d;
                case 10: goto L_0x024d;
                case 11: goto L_0x0249;
                case 12: goto L_0x0249;
                case 13: goto L_0x0249;
                case 14: goto L_0x0245;
                case 15: goto L_0x0245;
                case 16: goto L_0x0254;
                case 17: goto L_0x0254;
                case 18: goto L_0x022b;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r1) {
                case 21: goto L_0x0254;
                case 22: goto L_0x024d;
                case 23: goto L_0x0249;
                case 24: goto L_0x0245;
                case 25: goto L_0x0226;
                default: goto L_0x0029;
            }
        L_0x0029:
            r12 = 8388608(0x800000, float:1.1754944E-38)
            r13 = 251658240(0xf000000, float:6.3108872E-30)
            r14 = 2
            switch(r1) {
                case 46: goto L_0x0222;
                case 47: goto L_0x021e;
                case 48: goto L_0x021a;
                case 49: goto L_0x0216;
                case 50: goto L_0x020b;
                case 51: goto L_0x0222;
                case 52: goto L_0x0222;
                case 53: goto L_0x0222;
                case 54: goto L_0x01ea;
                case 55: goto L_0x01c9;
                case 56: goto L_0x01ea;
                case 57: goto L_0x01c9;
                case 58: goto L_0x01ea;
                default: goto L_0x0031;
            }
        L_0x0031:
            r13 = 91
            r15 = 0
            r12 = 4
            switch(r1) {
                case 79: goto L_0x01c3;
                case 80: goto L_0x01be;
                case 81: goto L_0x01c3;
                case 82: goto L_0x01be;
                case 83: goto L_0x01c3;
                case 84: goto L_0x01c3;
                case 85: goto L_0x01c3;
                case 86: goto L_0x01c3;
                case 87: goto L_0x025f;
                case 88: goto L_0x01b9;
                case 89: goto L_0x01b0;
                case 90: goto L_0x01a0;
                case 91: goto L_0x018d;
                case 92: goto L_0x0181;
                case 93: goto L_0x0171;
                case 94: goto L_0x0157;
                case 95: goto L_0x0147;
                case 96: goto L_0x0222;
                case 97: goto L_0x0142;
                case 98: goto L_0x021a;
                case 99: goto L_0x013d;
                case 100: goto L_0x0222;
                case 101: goto L_0x0142;
                case 102: goto L_0x021a;
                case 103: goto L_0x013d;
                case 104: goto L_0x0222;
                case 105: goto L_0x0142;
                case 106: goto L_0x021a;
                case 107: goto L_0x013d;
                case 108: goto L_0x0222;
                case 109: goto L_0x0142;
                case 110: goto L_0x021a;
                case 111: goto L_0x013d;
                case 112: goto L_0x0222;
                case 113: goto L_0x0142;
                case 114: goto L_0x021a;
                case 115: goto L_0x013d;
                case 116: goto L_0x0262;
                case 117: goto L_0x0262;
                case 118: goto L_0x0262;
                case 119: goto L_0x0262;
                case 120: goto L_0x0222;
                case 121: goto L_0x0137;
                case 122: goto L_0x0222;
                case 123: goto L_0x0137;
                case 124: goto L_0x0222;
                case 125: goto L_0x0137;
                case 126: goto L_0x0222;
                case 127: goto L_0x0142;
                case 128: goto L_0x0222;
                case 129: goto L_0x0142;
                case 130: goto L_0x0222;
                case 131: goto L_0x0142;
                case 132: goto L_0x0132;
                case 133: goto L_0x012d;
                case 134: goto L_0x0128;
                case 135: goto L_0x0123;
                case 136: goto L_0x0222;
                case 137: goto L_0x021a;
                case 138: goto L_0x0216;
                case 139: goto L_0x011e;
                case 140: goto L_0x012d;
                case 141: goto L_0x0123;
                case 142: goto L_0x0222;
                case 143: goto L_0x021e;
                case 144: goto L_0x021a;
                case 145: goto L_0x0262;
                case 146: goto L_0x0262;
                case 147: goto L_0x0262;
                case 148: goto L_0x0119;
                case 149: goto L_0x0222;
                case 150: goto L_0x0222;
                case 151: goto L_0x0119;
                case 152: goto L_0x0119;
                case 153: goto L_0x025f;
                case 154: goto L_0x025f;
                case 155: goto L_0x025f;
                case 156: goto L_0x025f;
                case 157: goto L_0x025f;
                case 158: goto L_0x025f;
                case 159: goto L_0x01b9;
                case 160: goto L_0x01b9;
                case 161: goto L_0x01b9;
                case 162: goto L_0x01b9;
                case 163: goto L_0x01b9;
                case 164: goto L_0x01b9;
                case 165: goto L_0x01b9;
                case 166: goto L_0x01b9;
                case 167: goto L_0x0262;
                case 168: goto L_0x0111;
                case 169: goto L_0x0111;
                case 170: goto L_0x025f;
                case 171: goto L_0x025f;
                case 172: goto L_0x025f;
                case 173: goto L_0x01b9;
                case 174: goto L_0x025f;
                case 175: goto L_0x01b9;
                case 176: goto L_0x025f;
                case 177: goto L_0x0262;
                case 178: goto L_0x010d;
                case 179: goto L_0x0106;
                case 180: goto L_0x0102;
                case 181: goto L_0x00f8;
                case 182: goto L_0x00b3;
                case 183: goto L_0x00b3;
                case 184: goto L_0x00b3;
                case 185: goto L_0x00b3;
                case 186: goto L_0x00ab;
                case 187: goto L_0x00a0;
                case 188: goto L_0x0072;
                case 189: goto L_0x004e;
                case 190: goto L_0x011e;
                case 191: goto L_0x025f;
                case 192: goto L_0x0042;
                case 193: goto L_0x011e;
                case 194: goto L_0x025f;
                case 195: goto L_0x025f;
                default: goto L_0x0038;
            }
        L_0x0038:
            r0.c(r2)
            java.lang.String r1 = r4.g
        L_0x003d:
            r0.a(r3, r1)
            goto L_0x0262
        L_0x0042:
            java.lang.String r1 = r4.g
            r16.a()
            char r2 = r1.charAt(r15)
            if (r2 != r13) goto L_0x023c
            goto L_0x003d
        L_0x004e:
            java.lang.String r1 = r4.g
            r16.a()
            char r2 = r1.charAt(r15)
            if (r2 != r13) goto L_0x0069
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r2.append(r13)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x003d
        L_0x0069:
            r2 = 292552704(0x11700000, float:1.8932662E-28)
            int r1 = r3.c(r1)
            r1 = r1 | r2
            goto L_0x025b
        L_0x0072:
            r16.a()
            switch(r2) {
                case 4: goto L_0x009b;
                case 5: goto L_0x0096;
                case 6: goto L_0x0091;
                case 7: goto L_0x008c;
                case 8: goto L_0x0087;
                case 9: goto L_0x0082;
                case 10: goto L_0x007d;
                default: goto L_0x0078;
            }
        L_0x0078:
            r1 = 285212676(0x11000004, float:1.0097424E-28)
            goto L_0x025b
        L_0x007d:
            r1 = 285212673(0x11000001, float:1.0097421E-28)
            goto L_0x025b
        L_0x0082:
            r1 = 285212684(0x1100000c, float:1.0097434E-28)
            goto L_0x025b
        L_0x0087:
            r1 = 285212682(0x1100000a, float:1.0097432E-28)
            goto L_0x025b
        L_0x008c:
            r1 = 285212675(0x11000003, float:1.0097423E-28)
            goto L_0x025b
        L_0x0091:
            r1 = 285212674(0x11000002, float:1.0097422E-28)
            goto L_0x025b
        L_0x0096:
            r1 = 285212683(0x1100000b, float:1.0097433E-28)
            goto L_0x025b
        L_0x009b:
            r1 = 285212681(0x11000009, float:1.009743E-28)
            goto L_0x025b
        L_0x00a0:
            r1 = 25165824(0x1800000, float:4.7019774E-38)
            java.lang.String r4 = r4.g
            int r2 = r3.a(r4, r2)
            r1 = r1 | r2
            goto L_0x025b
        L_0x00ab:
            java.lang.String r1 = r4.h
            r0.a(r1)
            java.lang.String r1 = r4.h
            goto L_0x003d
        L_0x00b3:
            java.lang.String r2 = r4.i
            r0.a(r2)
            r2 = 184(0xb8, float:2.58E-43)
            if (r1 == r2) goto L_0x010d
            int r2 = r16.a()
            r5 = 183(0xb7, float:2.56E-43)
            if (r1 != r5) goto L_0x010d
            java.lang.String r1 = r4.h
            char r1 = r1.charAt(r15)
            r5 = 60
            if (r1 != r5) goto L_0x010d
            int[] r1 = r0.i
            if (r1 != 0) goto L_0x00d6
            int[] r1 = new int[r14]
            r0.i = r1
        L_0x00d6:
            int[] r1 = r0.i
            int r1 = r1.length
            int r5 = r0.h
            if (r5 < r1) goto L_0x00ed
            int r5 = r5 + r6
            int r6 = r1 * 2
            int r5 = java.lang.Math.max(r5, r6)
            int[] r5 = new int[r5]
            int[] r6 = r0.i
            java.lang.System.arraycopy(r6, r15, r5, r15, r1)
            r0.i = r5
        L_0x00ed:
            int[] r1 = r0.i
            int r5 = r0.h
            int r6 = r5 + 1
            r0.h = r6
            r1[r5] = r2
            goto L_0x010d
        L_0x00f8:
            java.lang.String r1 = r4.i
            r0.a(r1)
            r16.a()
            goto L_0x0262
        L_0x0102:
            r0.c(r6)
            goto L_0x010d
        L_0x0106:
            java.lang.String r1 = r4.i
            r0.a(r1)
            goto L_0x0262
        L_0x010d:
            java.lang.String r1 = r4.i
            goto L_0x003d
        L_0x0111:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "JSR/RET are not supported with computeFrames option"
            r1.<init>(r2)
            throw r1
        L_0x0119:
            r0.c(r12)
            goto L_0x0254
        L_0x011e:
            r0.c(r6)
            goto L_0x0254
        L_0x0123:
            r0.c(r6)
            goto L_0x0245
        L_0x0128:
            r0.c(r6)
            goto L_0x0249
        L_0x012d:
            r0.c(r6)
            goto L_0x024d
        L_0x0132:
            r0.a(r2, r9)
            goto L_0x0262
        L_0x0137:
            r1 = 3
            r0.c(r1)
            goto L_0x024d
        L_0x013d:
            r0.c(r12)
            goto L_0x0245
        L_0x0142:
            r0.c(r12)
            goto L_0x024d
        L_0x0147:
            int r1 = r16.a()
            int r2 = r16.a()
            r0.b(r1)
            r0.b(r2)
            goto L_0x0262
        L_0x0157:
            int r1 = r16.a()
            int r2 = r16.a()
            int r3 = r16.a()
            int r4 = r16.a()
            r0.b(r2)
            r0.b(r1)
            r0.b(r4)
            goto L_0x019c
        L_0x0171:
            int r1 = r16.a()
            int r2 = r16.a()
            int r3 = r16.a()
            r0.b(r2)
            goto L_0x0199
        L_0x0181:
            int r1 = r16.a()
            int r2 = r16.a()
            r0.b(r2)
            goto L_0x01a8
        L_0x018d:
            int r1 = r16.a()
            int r2 = r16.a()
            int r3 = r16.a()
        L_0x0199:
            r0.b(r1)
        L_0x019c:
            r0.b(r3)
            goto L_0x01ab
        L_0x01a0:
            int r1 = r16.a()
            int r2 = r16.a()
        L_0x01a8:
            r0.b(r1)
        L_0x01ab:
            r0.b(r2)
            goto L_0x025b
        L_0x01b0:
            int r1 = r16.a()
            r0.b(r1)
            goto L_0x025b
        L_0x01b9:
            r0.c(r14)
            goto L_0x0262
        L_0x01be:
            r0.c(r12)
            goto L_0x0262
        L_0x01c3:
            r1 = 3
            r0.c(r1)
            goto L_0x0262
        L_0x01c9:
            r0.c(r6)
            int r1 = r16.a()
            r0.a(r2, r1)
            int r1 = r2 + 1
            r0.a(r1, r11)
            if (r2 <= 0) goto L_0x0262
            int r1 = r2 + -1
            int r2 = r0.a(r1)
            if (r2 == r10) goto L_0x0207
            if (r2 != r8) goto L_0x01e5
            goto L_0x0207
        L_0x01e5:
            r3 = r2 & r13
            if (r3 == r11) goto L_0x0262
            goto L_0x0202
        L_0x01ea:
            int r1 = r16.a()
            r0.a(r2, r1)
            if (r2 <= 0) goto L_0x0262
            int r1 = r2 + -1
            int r2 = r0.a(r1)
            if (r2 == r10) goto L_0x0207
            if (r2 != r8) goto L_0x01fe
            goto L_0x0207
        L_0x01fe:
            r3 = r2 & r13
            if (r3 == r11) goto L_0x0262
        L_0x0202:
            r2 = r2 | r12
            r0.a(r1, r2)
            goto L_0x0262
        L_0x0207:
            r0.a(r1, r11)
            goto L_0x0262
        L_0x020b:
            r0.c(r6)
            int r1 = r16.a()
            r2 = -268435456(0xfffffffff0000000, float:-1.5845633E29)
            int r1 = r1 + r2
            goto L_0x025b
        L_0x0216:
            r0.c(r14)
            goto L_0x0245
        L_0x021a:
            r0.c(r14)
            goto L_0x0249
        L_0x021e:
            r0.c(r14)
            goto L_0x024d
        L_0x0222:
            r0.c(r14)
            goto L_0x0254
        L_0x0226:
            int r1 = r0.a(r2)
            goto L_0x025b
        L_0x022b:
            int r1 = r4.f6227b
            r2 = 16
            if (r1 == r2) goto L_0x0242
            switch(r1) {
                case 3: goto L_0x0254;
                case 4: goto L_0x0249;
                case 5: goto L_0x024d;
                case 6: goto L_0x0245;
                case 7: goto L_0x023a;
                case 8: goto L_0x0237;
                default: goto L_0x0234;
            }
        L_0x0234:
            java.lang.String r1 = "java/lang/invoke/MethodHandle"
            goto L_0x023c
        L_0x0237:
            java.lang.String r1 = "java/lang/String"
            goto L_0x023c
        L_0x023a:
            java.lang.String r1 = "java/lang/Class"
        L_0x023c:
            int r1 = r3.c(r1)
            r1 = r1 | r5
            goto L_0x025b
        L_0x0242:
            java.lang.String r1 = "java/lang/invoke/MethodType"
            goto L_0x023c
        L_0x0245:
            r0.b(r8)
            goto L_0x0250
        L_0x0249:
            r0.b(r7)
            goto L_0x0262
        L_0x024d:
            r0.b(r10)
        L_0x0250:
            r0.b(r11)
            goto L_0x0262
        L_0x0254:
            r0.b(r9)
            goto L_0x0262
        L_0x0258:
            r1 = 16777221(0x1000005, float:2.35099E-38)
        L_0x025b:
            r0.b(r1)
            goto L_0x0262
        L_0x025f:
            r0.c(r6)
        L_0x0262:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.Frame.a(int, int, org.objectweb.asm.ClassWriter, org.objectweb.asm.Item):void");
    }

    public final void a(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            c((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            c(2);
        } else {
            c(1);
        }
    }

    public final void a(ClassWriter classWriter, String str) {
        int b2 = b(classWriter, str);
        if (b2 != 0) {
            b(b2);
            if (b2 == 16777220 || b2 == 16777219) {
                b(16777216);
            }
        }
    }

    public final void b(int i2) {
        if (this.f6215f == null) {
            this.f6215f = new int[10];
        }
        int length = this.f6215f.length;
        int i3 = this.g;
        if (i3 >= length) {
            int[] iArr = new int[Math.max(i3 + 1, length * 2)];
            System.arraycopy(this.f6215f, 0, iArr, 0, length);
            this.f6215f = iArr;
        }
        int[] iArr2 = this.f6215f;
        int i4 = this.g;
        int i5 = i4 + 1;
        this.g = i5;
        iArr2[i4] = i2;
        Label label = this.f6211b;
        int i6 = label.f6235f + i5;
        if (i6 > label.g) {
            label.g = i6;
        }
    }

    public final void c(int i2) {
        int i3 = this.g;
        if (i3 >= i2) {
            this.g = i3 - i2;
            return;
        }
        this.f6211b.f6235f -= i2 - i3;
        this.g = 0;
    }

    public static boolean a(ClassWriter classWriter, int i2, int[] iArr, int i3) {
        int min;
        ClassWriter classWriter2 = classWriter;
        int i4 = i2;
        int i5 = iArr[i3];
        if (i5 == i4) {
            return false;
        }
        if ((268435455 & i4) == 16777221) {
            if (i5 == 16777221) {
                return false;
            }
            i4 = 16777221;
        }
        if (i5 == 0) {
            iArr[i3] = i4;
            return true;
        }
        int i6 = i5 & 267386880;
        int i7 = 16777216;
        int i8 = -268435456;
        if (i6 == 24117248 || (i5 & -268435456) != 0) {
            if (i4 == 16777221) {
                return false;
            }
            String str = "java/lang/Object";
            if ((i4 & -1048576) != (-1048576 & i5)) {
                int i9 = i4 & 267386880;
                if (i9 == 24117248 || (i4 & -268435456) != 0) {
                    int i10 = i4 & -268435456;
                    int i11 = ((i10 == 0 || i9 == 24117248) ? 0 : -268435456) + i10;
                    int i12 = i5 & -268435456;
                    if (i12 == 0 || i6 == 24117248) {
                        i8 = 0;
                    }
                    min = Math.min(i11, i8 + i12);
                }
            } else if (i6 == 24117248) {
                int i13 = (i4 & -268435456) | 24117248;
                int i14 = i4 & 1048575;
                int i15 = 1048575 & i5;
                Item item = classWriter2.h;
                item.f6227b = 32;
                item.f6229d = ((long) i14) | (((long) i15) << 32);
                item.j = (i14 + 32 + i15) & Integer.MAX_VALUE;
                Item a2 = classWriter.a(item);
                if (a2 == null) {
                    Item[] itemArr = classWriter2.H;
                    String str2 = itemArr[i14].g;
                    String str3 = itemArr[i15].g;
                    Item item2 = classWriter2.h;
                    ClassLoader classLoader = ClassWriter.class.getClassLoader();
                    try {
                        Class cls = Class.forName(str2.replace('/', '.'), false, classLoader);
                        Class<?> cls2 = Class.forName(str3.replace('/', '.'), false, classLoader);
                        if (cls.isAssignableFrom(cls2)) {
                            str = str2;
                        } else if (cls2.isAssignableFrom(cls)) {
                            str = str3;
                        } else if (!cls.isInterface() && !cls2.isInterface()) {
                            do {
                                cls = cls.getSuperclass();
                            } while (!cls.isAssignableFrom(cls2));
                            str = cls.getName().replace('.', '/');
                        }
                        item2.f6228c = classWriter.c(str);
                        a2 = new Item(0, classWriter2.h);
                        classWriter.b(a2);
                    } catch (Exception e2) {
                        throw new RuntimeException(e2.toString());
                    }
                }
                i7 = i13 | a2.f6228c;
            } else {
                min = (i5 & -268435456) - 268435456;
            }
            i7 = min | 24117248 | classWriter.c(str);
        } else if (i5 == 16777221) {
            if ((i4 & 267386880) != 24117248 && (i4 & -268435456) == 0) {
                i4 = 16777216;
            }
            i7 = i4;
        }
        if (i5 == i7) {
            return false;
        }
        iArr[i3] = i7;
        return true;
    }
}
