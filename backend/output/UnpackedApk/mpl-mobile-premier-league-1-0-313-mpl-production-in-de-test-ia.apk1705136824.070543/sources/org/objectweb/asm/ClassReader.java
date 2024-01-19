package org.objectweb.asm;

import okio.Utf8;
import org.apache.fontbox.ttf.GlyfDescript;
import sfs2x.client.entities.invitation.InvitationReply;

public class ClassReader {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f6186a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f6187b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f6188c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6189d;
    public final int header;

    public ClassReader(byte[] bArr) {
        int length = bArr.length;
        this.f6187b = bArr;
        if (readShort(6) <= 52) {
            int readUnsignedShort = readUnsignedShort(8);
            this.f6186a = new int[readUnsignedShort];
            this.f6188c = new String[readUnsignedShort];
            int i = 0;
            int i2 = 10;
            int i3 = 1;
            while (i3 < readUnsignedShort) {
                int i4 = i2 + 1;
                this.f6186a[i3] = i4;
                byte b2 = bArr[i2];
                int i5 = 5;
                if (b2 == 1) {
                    i5 = readUnsignedShort(i4) + 3;
                    if (i5 > i) {
                        i = i5;
                    }
                } else if (b2 != 15) {
                    if (!(b2 == 18 || b2 == 3 || b2 == 4)) {
                        if (b2 != 5 && b2 != 6) {
                            switch (b2) {
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                    break;
                                default:
                                    i5 = 3;
                                    break;
                            }
                        } else {
                            i5 = 9;
                            i3++;
                        }
                    }
                } else {
                    i5 = 4;
                }
                i2 += i5;
                i3++;
            }
            this.f6189d = i;
            this.header = i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final int a(int i, boolean z, boolean z2, Context context) {
        int i2;
        int i3;
        int i4;
        char[] cArr = context.f6198c;
        Label[] labelArr = context.h;
        if (z) {
            int i5 = i + 1;
            i2 = this.f6187b[i] & 255;
            i3 = i5;
        } else {
            context.o = -1;
            i3 = i;
            i2 = InvitationReply.EXPIRED;
        }
        context.r = 0;
        if (i2 < 64) {
            context.p = 3;
            context.t = 0;
        } else if (i2 < 128) {
            i2 -= 64;
            i3 = a(context.u, 0, i3, cArr, labelArr);
            context.p = 4;
            context.t = 1;
        } else {
            int readUnsignedShort = readUnsignedShort(i3);
            int i6 = i3 + 2;
            if (i2 == 247) {
                i4 = a(context.u, 0, i6, cArr, labelArr);
                context.p = 4;
                context.t = 1;
            } else {
                if (i2 >= 248 && i2 < 251) {
                    context.p = 2;
                    int i7 = 251 - i2;
                    context.r = i7;
                    context.q -= i7;
                } else if (i2 == 251) {
                    context.p = 3;
                } else if (i2 < 255) {
                    int i8 = i2 - 251;
                    int i9 = z2 ? context.q : 0;
                    int i10 = i8;
                    while (i10 > 0) {
                        i6 = a(context.s, i9, i6, cArr, labelArr);
                        i10--;
                        i9++;
                    }
                    context.p = 1;
                    context.r = i8;
                    context.q += i8;
                } else {
                    context.p = 0;
                    int readUnsignedShort2 = readUnsignedShort(i6);
                    int i11 = i6 + 2;
                    context.r = readUnsignedShort2;
                    context.q = readUnsignedShort2;
                    int i12 = 0;
                    while (readUnsignedShort2 > 0) {
                        i11 = a(context.s, i12, i11, cArr, labelArr);
                        readUnsignedShort2--;
                        i12++;
                    }
                    int readUnsignedShort3 = readUnsignedShort(i11);
                    i4 = i11 + 2;
                    context.t = readUnsignedShort3;
                    int i13 = 0;
                    while (readUnsignedShort3 > 0) {
                        i4 = a(context.u, i13, i4, cArr, labelArr);
                        readUnsignedShort3--;
                        i13++;
                    }
                }
                context.t = 0;
            }
            i2 = readUnsignedShort;
        }
        int i14 = i2 + 1 + context.o;
        context.o = i14;
        readLabel(i14, labelArr);
        return i3;
    }

    public final int a(int i, char[] cArr, String str, AnnotationWriter annotationWriter) {
        Object obj;
        Object obj2;
        int i2 = 0;
        if (annotationWriter == null) {
            byte b2 = this.f6187b[i] & 255;
            if (b2 == 64) {
                return a(i + 3, cArr, true, (AnnotationWriter) null);
            }
            if (b2 != 91) {
                return b2 != 101 ? i + 3 : i + 5;
            }
            return a(i + 1, cArr, false, (AnnotationWriter) null);
        }
        int i3 = i + 1;
        byte b3 = this.f6187b[i] & 255;
        if (b3 != 64) {
            if (b3 != 70) {
                if (b3 != 83) {
                    if (b3 == 99) {
                        obj = Type.a(readUTF8(i3, cArr).toCharArray(), 0);
                    } else if (b3 == 101) {
                        String readUTF8 = readUTF8(i3, cArr);
                        String readUTF82 = readUTF8(i3 + 2, cArr);
                        annotationWriter.f6177b++;
                        if (annotationWriter.f6178c) {
                            annotationWriter.f6179d.putShort(annotationWriter.f6176a.newUTF8(str));
                        }
                        ByteVector byteVector = annotationWriter.f6179d;
                        byteVector.b(101, annotationWriter.f6176a.newUTF8(readUTF8));
                        byteVector.putShort(annotationWriter.f6176a.newUTF8(readUTF82));
                        i3 += 4;
                    } else if (b3 == 115) {
                        obj = readUTF8(i3, cArr);
                    } else if (!(b3 == 73 || b3 == 74)) {
                        if (b3 == 90) {
                            obj = readInt(this.f6186a[readUnsignedShort(i3)]) == 0 ? Boolean.FALSE : Boolean.TRUE;
                        } else if (b3 != 91) {
                            switch (b3) {
                                case 66:
                                    obj2 = new Byte((byte) readInt(this.f6186a[readUnsignedShort(i3)]));
                                    break;
                                case 67:
                                    obj2 = new Character((char) readInt(this.f6186a[readUnsignedShort(i3)]));
                                    break;
                                case 68:
                                    break;
                            }
                        } else {
                            int readUnsignedShort = readUnsignedShort(i3);
                            int i4 = i3 + 2;
                            if (readUnsignedShort == 0) {
                                return a(i4 - 2, cArr, false, annotationWriter.visitArray(str));
                            }
                            int i5 = i4 + 1;
                            byte b4 = this.f6187b[i4] & 255;
                            if (b4 == 70) {
                                float[] fArr = new float[readUnsignedShort];
                                while (i2 < readUnsignedShort) {
                                    fArr[i2] = Float.intBitsToFloat(readInt(this.f6186a[readUnsignedShort(i5)]));
                                    i5 += 3;
                                    i2++;
                                }
                                annotationWriter.visit(str, fArr);
                            } else if (b4 == 83) {
                                short[] sArr = new short[readUnsignedShort];
                                while (i2 < readUnsignedShort) {
                                    sArr[i2] = (short) readInt(this.f6186a[readUnsignedShort(i5)]);
                                    i5 += 3;
                                    i2++;
                                }
                                annotationWriter.visit(str, sArr);
                            } else if (b4 == 90) {
                                boolean[] zArr = new boolean[readUnsignedShort];
                                for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                                    zArr[i6] = readInt(this.f6186a[readUnsignedShort(i5)]) != 0;
                                    i5 += 3;
                                }
                                annotationWriter.visit(str, zArr);
                            } else if (b4 == 73) {
                                int[] iArr = new int[readUnsignedShort];
                                while (i2 < readUnsignedShort) {
                                    iArr[i2] = readInt(this.f6186a[readUnsignedShort(i5)]);
                                    i5 += 3;
                                    i2++;
                                }
                                annotationWriter.visit(str, iArr);
                            } else if (b4 != 74) {
                                switch (b4) {
                                    case 66:
                                        byte[] bArr = new byte[readUnsignedShort];
                                        while (i2 < readUnsignedShort) {
                                            bArr[i2] = (byte) readInt(this.f6186a[readUnsignedShort(i5)]);
                                            i5 += 3;
                                            i2++;
                                        }
                                        annotationWriter.visit(str, bArr);
                                        break;
                                    case 67:
                                        char[] cArr2 = new char[readUnsignedShort];
                                        while (i2 < readUnsignedShort) {
                                            cArr2[i2] = (char) readInt(this.f6186a[readUnsignedShort(i5)]);
                                            i5 += 3;
                                            i2++;
                                        }
                                        annotationWriter.visit(str, cArr2);
                                        break;
                                    case 68:
                                        double[] dArr = new double[readUnsignedShort];
                                        while (i2 < readUnsignedShort) {
                                            dArr[i2] = Double.longBitsToDouble(readLong(this.f6186a[readUnsignedShort(i5)]));
                                            i5 += 3;
                                            i2++;
                                        }
                                        annotationWriter.visit(str, dArr);
                                        break;
                                    default:
                                        i3 = a(i5 - 3, cArr, false, annotationWriter.visitArray(str));
                                        break;
                                }
                            } else {
                                long[] jArr = new long[readUnsignedShort];
                                while (i2 < readUnsignedShort) {
                                    jArr[i2] = readLong(this.f6186a[readUnsignedShort(i5)]);
                                    i5 += 3;
                                    i2++;
                                }
                                annotationWriter.visit(str, jArr);
                            }
                            i3 = i5 - 1;
                        }
                    }
                    annotationWriter.visit(str, obj);
                    i3 += 2;
                } else {
                    obj2 = new Short((short) readInt(this.f6186a[readUnsignedShort(i3)]));
                }
                annotationWriter.visit(str, obj2);
                i3 += 2;
            }
            obj = readConst(readUnsignedShort(i3), cArr);
            annotationWriter.visit(str, obj);
            i3 += 2;
        } else {
            int i7 = i3 + 2;
            String readUTF83 = readUTF8(i3, cArr);
            annotationWriter.f6177b++;
            if (annotationWriter.f6178c) {
                annotationWriter.f6179d.putShort(annotationWriter.f6176a.newUTF8(str));
            }
            ByteVector byteVector2 = annotationWriter.f6179d;
            byteVector2.b(64, annotationWriter.f6176a.newUTF8(readUTF83));
            byteVector2.putShort(0);
            ClassWriter classWriter = annotationWriter.f6176a;
            ByteVector byteVector3 = annotationWriter.f6179d;
            AnnotationWriter annotationWriter2 = new AnnotationWriter(classWriter, true, byteVector3, byteVector3, byteVector3.f6185b - 2);
            i3 = a(i7, cArr, true, annotationWriter2);
        }
        return i3;
    }

    public final int a(int i, char[] cArr, boolean z, AnnotationWriter annotationWriter) {
        int readUnsignedShort = readUnsignedShort(i);
        int i2 = i + 2;
        if (z) {
            while (readUnsignedShort > 0) {
                i2 = a(i2 + 2, cArr, readUTF8(i2, cArr), annotationWriter);
                readUnsignedShort--;
            }
        } else {
            while (readUnsignedShort > 0) {
                i2 = a(i2, cArr, (String) null, annotationWriter);
                readUnsignedShort--;
            }
        }
        if (annotationWriter != null) {
            annotationWriter.visitEnd();
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(org.objectweb.asm.Context r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.readInt(r10)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L_0x0076
            if (r1 == r2) goto L_0x0076
            r3 = 64
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r1 == r3) goto L_0x0030
            r3 = 65
            if (r1 == r3) goto L_0x0030
            switch(r1) {
                case 19: goto L_0x0022;
                case 20: goto L_0x0022;
                case 21: goto L_0x0022;
                case 22: goto L_0x0076;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r1) {
                case 71: goto L_0x0025;
                case 72: goto L_0x0025;
                case 73: goto L_0x0025;
                case 74: goto L_0x0025;
                case 75: goto L_0x0025;
                default: goto L_0x001b;
            }
        L_0x001b:
            r3 = 67
            if (r1 >= r3) goto L_0x002c
            r4 = -256(0xffffffffffffff00, float:NaN)
            goto L_0x002c
        L_0x0022:
            r0 = r0 & r4
            int r10 = r10 + r2
            goto L_0x007b
        L_0x0025:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r10 = r10 + 4
            goto L_0x007b
        L_0x002c:
            r0 = r0 & r4
            int r10 = r10 + 3
            goto L_0x007b
        L_0x0030:
            r0 = r0 & r4
            int r1 = r10 + 1
            int r1 = r8.readUnsignedShort(r1)
            org.objectweb.asm.Label[] r3 = new org.objectweb.asm.Label[r1]
            r9.l = r3
            org.objectweb.asm.Label[] r3 = new org.objectweb.asm.Label[r1]
            r9.m = r3
            int[] r3 = new int[r1]
            r9.n = r3
            int r10 = r10 + 3
            r3 = 0
        L_0x0046:
            if (r3 >= r1) goto L_0x007b
            int r4 = r8.readUnsignedShort(r10)
            int r5 = r10 + 2
            int r5 = r8.readUnsignedShort(r5)
            org.objectweb.asm.Label[] r6 = r9.l
            org.objectweb.asm.Label[] r7 = r9.h
            org.objectweb.asm.Label r7 = r8.readLabel(r4, r7)
            r6[r3] = r7
            org.objectweb.asm.Label[] r6 = r9.m
            int r4 = r4 + r5
            org.objectweb.asm.Label[] r5 = r9.h
            org.objectweb.asm.Label r4 = r8.readLabel(r4, r5)
            r6[r3] = r4
            int[] r4 = r9.n
            int r5 = r10 + 4
            int r5 = r8.readUnsignedShort(r5)
            r4[r3] = r5
            int r10 = r10 + 6
            int r3 = r3 + 1
            goto L_0x0046
        L_0x0076:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r10 = r10 + 2
        L_0x007b:
            int r1 = r8.readByte(r10)
            r9.i = r0
            if (r1 != 0) goto L_0x0085
            r0 = 0
            goto L_0x008c
        L_0x0085:
            org.objectweb.asm.TypePath r0 = new org.objectweb.asm.TypePath
            byte[] r3 = r8.f6187b
            r0.<init>(r3, r10)
        L_0x008c:
            r9.j = r0
            int r10 = r10 + r2
            int r1 = r1 * 2
            int r1 = r1 + r10
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.a(org.objectweb.asm.Context, int):int");
    }

    public final int a(Object[] objArr, int i, int i2, char[] cArr, Label[] labelArr) {
        int i3 = i2 + 1;
        switch (this.f6187b[i2] & 255) {
            case 0:
                objArr[i] = Opcodes.TOP;
                return i3;
            case 1:
                objArr[i] = Opcodes.INTEGER;
                return i3;
            case 2:
                objArr[i] = Opcodes.FLOAT;
                return i3;
            case 3:
                objArr[i] = Opcodes.DOUBLE;
                return i3;
            case 4:
                objArr[i] = Opcodes.LONG;
                return i3;
            case 5:
                objArr[i] = Opcodes.NULL;
                return i3;
            case 6:
                objArr[i] = Opcodes.UNINITIALIZED_THIS;
                return i3;
            case 7:
                objArr[i] = readClass(i3, cArr);
                break;
            default:
                objArr[i] = readLabel(readUnsignedShort(i3), labelArr);
                break;
        }
        return i3 + 2;
    }

    public final String a(int i, int i2, char[] cArr) {
        byte b2;
        int i3 = i2 + i;
        byte[] bArr = this.f6187b;
        int i4 = 0;
        char c2 = 0;
        char c3 = 0;
        while (i < i3) {
            int i5 = i + 1;
            byte b3 = bArr[i];
            if (c2 != 0) {
                if (c2 == 1) {
                    cArr[i4] = (char) ((b3 & Utf8.REPLACEMENT_BYTE) | (c3 << 6));
                    i4++;
                    c2 = 0;
                } else if (c2 == 2) {
                    b2 = (b3 & Utf8.REPLACEMENT_BYTE) | (c3 << 6);
                }
                i = i5;
            } else {
                byte b4 = b3 & 255;
                if (b4 < 128) {
                    cArr[i4] = (char) b4;
                    i4++;
                } else if (b4 >= 224 || b4 <= 191) {
                    c3 = (char) (b4 & 15);
                    c2 = 2;
                } else {
                    b2 = b4 & 31;
                }
                i = i5;
            }
            c3 = (char) b2;
            c2 = 1;
            i = i5;
        }
        return new String(cArr, 0, i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:253:0x07d0, code lost:
        if (r1.j == 0) goto L_0x07ef;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02fd A[LOOP:11: B:104:0x02fb->B:105:0x02fd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x07f4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accept(org.objectweb.asm.ClassVisitor r55, int r56) {
        /*
            r54 = this;
            r8 = r54
            r9 = r55
            r10 = r56
            r11 = 0
            org.objectweb.asm.Attribute[] r12 = new org.objectweb.asm.Attribute[r11]
            int r0 = r8.header
            int r1 = r8.f6189d
            char[] r13 = new char[r1]
            org.objectweb.asm.Context r14 = new org.objectweb.asm.Context
            r14.<init>()
            r14.f6196a = r12
            r14.f6197b = r10
            r14.f6198c = r13
            int r1 = r8.readUnsignedShort(r0)
            int r2 = r0 + 2
            java.lang.String r15 = r8.readClass(r2, r13)
            int r2 = r0 + 4
            java.lang.String r16 = r8.readClass(r2, r13)
            int r2 = r0 + 6
            int r7 = r8.readUnsignedShort(r2)
            java.lang.String[] r6 = new java.lang.String[r7]
            int r0 = r0 + 8
            r2 = 0
        L_0x0035:
            if (r2 >= r7) goto L_0x0042
            java.lang.String r3 = r8.readClass(r0, r13)
            r6[r2] = r3
            int r0 = r0 + 2
            int r2 = r2 + 1
            goto L_0x0035
        L_0x0042:
            int r0 = r8.header
            int r2 = r0 + 8
            int r0 = r0 + 6
            int r0 = r8.readUnsignedShort(r0)
            int r0 = r0 * 2
            int r0 = r0 + r2
            int r2 = r8.readUnsignedShort(r0)
        L_0x0053:
            if (r2 <= 0) goto L_0x006e
            int r3 = r0 + 8
            int r3 = r8.readUnsignedShort(r3)
        L_0x005b:
            if (r3 <= 0) goto L_0x0069
            int r4 = r0 + 12
            int r4 = r8.readInt(r4)
            int r4 = r4 + 6
            int r0 = r0 + r4
            int r3 = r3 + -1
            goto L_0x005b
        L_0x0069:
            int r0 = r0 + 8
            int r2 = r2 + -1
            goto L_0x0053
        L_0x006e:
            int r0 = r0 + 2
            int r2 = r8.readUnsignedShort(r0)
        L_0x0074:
            if (r2 <= 0) goto L_0x008f
            int r3 = r0 + 8
            int r3 = r8.readUnsignedShort(r3)
        L_0x007c:
            if (r3 <= 0) goto L_0x008a
            int r4 = r0 + 12
            int r4 = r8.readInt(r4)
            int r4 = r4 + 6
            int r0 = r0 + r4
            int r3 = r3 + -1
            goto L_0x007c
        L_0x008a:
            int r0 = r0 + 8
            int r2 = r2 + -1
            goto L_0x0074
        L_0x008f:
            int r0 = r0 + 2
            int r2 = r8.readUnsignedShort(r0)
            r17 = r0
            r19 = r1
            r18 = r2
            r27 = r7
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
        L_0x00b0:
            java.lang.String r7 = "RuntimeInvisibleTypeAnnotations"
            java.lang.String r11 = "RuntimeInvisibleAnnotations"
            java.lang.String r9 = "Synthetic"
            java.lang.String r10 = "Deprecated"
            r28 = r6
            java.lang.String r6 = "RuntimeVisibleTypeAnnotations"
            java.lang.String r5 = "RuntimeVisibleAnnotations"
            r30 = r4
            java.lang.String r4 = "Signature"
            r31 = 266240(0x41000, float:3.73082E-40)
            r32 = 131072(0x20000, float:1.83671E-40)
            r33 = r3
            if (r18 <= 0) goto L_0x01f4
            int r3 = r17 + 2
            java.lang.String r3 = r8.readUTF8(r3, r13)
            r34 = r0
            java.lang.String r0 = "SourceFile"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00e3
            int r0 = r17 + 8
            java.lang.String r0 = r8.readUTF8(r0, r13)
            r4 = r0
            goto L_0x0138
        L_0x00e3:
            java.lang.String r0 = "InnerClasses"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00f3
            int r0 = r17 + 8
            r26 = r0
        L_0x00ef:
            r0 = r34
            goto L_0x01b3
        L_0x00f3:
            java.lang.String r0 = "EnclosingMethod"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x011e
            int r0 = r17 + 8
            java.lang.String r0 = r8.readClass(r0, r13)
            int r3 = r17 + 10
            int r3 = r8.readUnsignedShort(r3)
            if (r3 == 0) goto L_0x011b
            int[] r1 = r8.f6186a
            r1 = r1[r3]
            java.lang.String r22 = r8.readUTF8(r1, r13)
            int[] r1 = r8.f6186a
            r1 = r1[r3]
            int r1 = r1 + 2
            java.lang.String r1 = r8.readUTF8(r1, r13)
        L_0x011b:
            r21 = r0
            goto L_0x00ef
        L_0x011e:
            boolean r0 = r4.equals(r3)
            if (r0 == 0) goto L_0x012d
            int r0 = r17 + 8
            java.lang.String r0 = r8.readUTF8(r0, r13)
            r20 = r0
            goto L_0x00ef
        L_0x012d:
            boolean r0 = r5.equals(r3)
            if (r0 == 0) goto L_0x013c
            int r0 = r17 + 8
            r2 = r0
            r4 = r30
        L_0x0138:
            r0 = r34
            goto L_0x01b5
        L_0x013c:
            boolean r0 = r6.equals(r3)
            if (r0 == 0) goto L_0x0147
            int r0 = r17 + 8
            r24 = r0
            goto L_0x00ef
        L_0x0147:
            boolean r0 = r10.equals(r3)
            if (r0 == 0) goto L_0x0150
            r0 = r19 | r32
            goto L_0x0158
        L_0x0150:
            boolean r0 = r9.equals(r3)
            if (r0 == 0) goto L_0x015b
            r0 = r19 | r31
        L_0x0158:
            r19 = r0
            goto L_0x00ef
        L_0x015b:
            java.lang.String r0 = "SourceDebugExtension"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0172
            int r0 = r17 + 4
            int r0 = r8.readInt(r0)
            int r3 = r17 + 8
            char[] r4 = new char[r0]
            java.lang.String r0 = r8.a(r3, r0, r4)
            goto L_0x01b3
        L_0x0172:
            boolean r0 = r11.equals(r3)
            if (r0 == 0) goto L_0x017e
            int r0 = r17 + 8
            r23 = r0
            goto L_0x00ef
        L_0x017e:
            boolean r0 = r7.equals(r3)
            if (r0 == 0) goto L_0x018a
            int r0 = r17 + 8
            r25 = r0
            goto L_0x00ef
        L_0x018a:
            java.lang.String r0 = "BootstrapMethods"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01b8
            int r0 = r17 + 8
            int r0 = r8.readUnsignedShort(r0)
            int[] r3 = new int[r0]
            int r4 = r17 + 10
            r5 = 0
        L_0x019d:
            if (r5 >= r0) goto L_0x01af
            r3[r5] = r4
            int r6 = r4 + 2
            int r6 = r8.readUnsignedShort(r6)
            int r6 = r6 + 2
            r7 = 1
            int r6 = r6 << r7
            int r4 = r4 + r6
            int r5 = r5 + 1
            goto L_0x019d
        L_0x01af:
            r14.f6199d = r3
            goto L_0x00ef
        L_0x01b3:
            r4 = r30
        L_0x01b5:
            r3 = r33
            goto L_0x01df
        L_0x01b8:
            int r4 = r17 + 8
            int r0 = r17 + 4
            int r5 = r8.readInt(r0)
            r6 = -1
            r7 = 0
            r9 = r34
            r0 = r54
            r10 = r1
            r1 = r12
            r11 = r2
            r2 = r3
            r35 = r33
            r3 = r4
            r36 = r30
            r4 = r5
            r5 = r13
            org.objectweb.asm.Attribute r0 = r0.a(r1, r2, r3, r4, r5, r6, r7)
            r3 = r35
            r0.f6182a = r3
            r3 = r0
            r0 = r9
            r1 = r10
            r2 = r11
            r4 = r36
        L_0x01df:
            int r5 = r17 + 4
            int r5 = r8.readInt(r5)
            int r5 = r5 + 6
            int r17 = r5 + r17
            int r18 = r18 + -1
            r9 = r55
            r10 = r56
            r6 = r28
            r11 = 0
            goto L_0x00b0
        L_0x01f4:
            r36 = r30
            r3 = r33
            int[] r12 = r8.f6186a
            r17 = 1
            r12 = r12[r17]
            int r12 = r12 + -7
            int r12 = r8.readInt(r12)
            r18 = r9
            r9 = r0
            r0 = r55
            r29 = r10
            r10 = r1
            r1 = r12
            r12 = r2
            r2 = r19
            r17 = r3
            r19 = r7
            r7 = 1
            r3 = r15
            r15 = r4
            r4 = r20
            r37 = r5
            r5 = r16
            r38 = r6
            r6 = r28
            r0.visit(r1, r2, r3, r4, r5, r6)
            r6 = r29
            r0 = r56 & 2
            if (r0 != 0) goto L_0x0250
            r4 = r36
            if (r4 != 0) goto L_0x0230
            if (r9 == 0) goto L_0x0250
        L_0x0230:
            r5 = r55
            r3 = r18
            r0 = r5
            org.objectweb.asm.ClassWriter r0 = (org.objectweb.asm.ClassWriter) r0
            if (r4 == 0) goto L_0x023f
            int r1 = r0.newUTF8(r4)
            r0.q = r1
        L_0x023f:
            if (r9 == 0) goto L_0x0254
            org.objectweb.asm.ByteVector r1 = new org.objectweb.asm.ByteVector
            r1.<init>()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r4 = 0
            r1.c(r9, r4, r2)
            r0.r = r1
            goto L_0x0254
        L_0x0250:
            r5 = r55
            r3 = r18
        L_0x0254:
            r0 = r21
            if (r0 == 0) goto L_0x026f
            r1 = r5
            org.objectweb.asm.ClassWriter r1 = (org.objectweb.asm.ClassWriter) r1
            org.objectweb.asm.Item r0 = r1.a(r0)
            int r0 = r0.f6226a
            r1.s = r0
            r0 = r22
            if (r0 == 0) goto L_0x026f
            if (r10 == 0) goto L_0x026f
            int r0 = r1.newNameType(r0, r10)
            r1.t = r0
        L_0x026f:
            if (r12 == 0) goto L_0x028a
            int r0 = r8.readUnsignedShort(r12)
            int r2 = r12 + 2
        L_0x0277:
            if (r0 <= 0) goto L_0x028a
            int r1 = r2 + 2
            java.lang.String r2 = r8.readUTF8(r2, r13)
            org.objectweb.asm.AnnotationWriter r2 = r5.visitAnnotation(r2, r7)
            int r2 = r8.a(r1, r13, r7, r2)
            int r0 = r0 + -1
            goto L_0x0277
        L_0x028a:
            r0 = r23
            if (r0 == 0) goto L_0x02aa
            int r1 = r8.readUnsignedShort(r0)
            int r23 = r0 + 2
            r0 = r23
        L_0x0296:
            if (r1 <= 0) goto L_0x02aa
            int r2 = r0 + 2
            java.lang.String r0 = r8.readUTF8(r0, r13)
            r4 = 0
            org.objectweb.asm.AnnotationWriter r0 = r5.visitAnnotation(r0, r4)
            int r0 = r8.a(r2, r13, r7, r0)
            int r1 = r1 + -1
            goto L_0x0296
        L_0x02aa:
            r0 = r24
            if (r0 == 0) goto L_0x02d1
            int r1 = r8.readUnsignedShort(r0)
            int r24 = r0 + 2
            r0 = r24
        L_0x02b6:
            if (r1 <= 0) goto L_0x02d1
            int r0 = r8.a(r14, r0)
            int r2 = r0 + 2
            int r4 = r14.i
            org.objectweb.asm.TypePath r9 = r14.j
            java.lang.String r0 = r8.readUTF8(r0, r13)
            org.objectweb.asm.AnnotationWriter r0 = r5.visitTypeAnnotation(r4, r9, r0, r7)
            int r0 = r8.a(r2, r13, r7, r0)
            int r1 = r1 + -1
            goto L_0x02b6
        L_0x02d1:
            r0 = r25
            if (r0 == 0) goto L_0x02f9
            int r1 = r8.readUnsignedShort(r0)
            int r25 = r0 + 2
            r0 = r25
        L_0x02dd:
            if (r1 <= 0) goto L_0x02f9
            int r0 = r8.a(r14, r0)
            int r2 = r0 + 2
            int r4 = r14.i
            org.objectweb.asm.TypePath r9 = r14.j
            java.lang.String r0 = r8.readUTF8(r0, r13)
            r10 = 0
            org.objectweb.asm.AnnotationWriter r0 = r5.visitTypeAnnotation(r4, r9, r0, r10)
            int r0 = r8.a(r2, r13, r7, r0)
            int r1 = r1 + -1
            goto L_0x02dd
        L_0x02f9:
            r0 = r17
        L_0x02fb:
            if (r0 == 0) goto L_0x030d
            org.objectweb.asm.Attribute r1 = r0.f6182a
            r9 = 0
            r0.f6182a = r9
            r2 = r5
            org.objectweb.asm.ClassWriter r2 = (org.objectweb.asm.ClassWriter) r2
            org.objectweb.asm.Attribute r4 = r2.w
            r0.f6182a = r4
            r2.w = r0
            r0 = r1
            goto L_0x02fb
        L_0x030d:
            r0 = r26
            r9 = 0
            if (r0 == 0) goto L_0x0388
            int r26 = r0 + 2
            int r0 = r8.readUnsignedShort(r0)
            r1 = r26
        L_0x031a:
            if (r0 <= 0) goto L_0x0388
            java.lang.String r2 = r8.readClass(r1, r13)
            int r4 = r1 + 2
            java.lang.String r4 = r8.readClass(r4, r13)
            int r10 = r1 + 4
            java.lang.String r10 = r8.readUTF8(r10, r13)
            int r12 = r1 + 6
            int r12 = r8.readUnsignedShort(r12)
            r9 = r5
            org.objectweb.asm.ClassWriter r9 = (org.objectweb.asm.ClassWriter) r9
            org.objectweb.asm.ByteVector r7 = r9.y
            if (r7 != 0) goto L_0x0340
            org.objectweb.asm.ByteVector r7 = new org.objectweb.asm.ByteVector
            r7.<init>()
            r9.y = r7
        L_0x0340:
            org.objectweb.asm.Item r2 = r9.a(r2)
            int r7 = r2.f6228c
            if (r7 != 0) goto L_0x037d
            int r7 = r9.x
            r16 = 1
            int r7 = r7 + 1
            r9.x = r7
            org.objectweb.asm.ByteVector r7 = r9.y
            int r5 = r2.f6226a
            r7.putShort(r5)
            org.objectweb.asm.ByteVector r5 = r9.y
            if (r4 != 0) goto L_0x035d
            r4 = 0
            goto L_0x0363
        L_0x035d:
            org.objectweb.asm.Item r4 = r9.a(r4)
            int r4 = r4.f6226a
        L_0x0363:
            r5.putShort(r4)
            org.objectweb.asm.ByteVector r4 = r9.y
            if (r10 != 0) goto L_0x036c
            r5 = 0
            goto L_0x0370
        L_0x036c:
            int r5 = r9.newUTF8(r10)
        L_0x0370:
            r4.putShort(r5)
            org.objectweb.asm.ByteVector r4 = r9.y
            r4.putShort(r12)
            int r4 = r9.x
            r2.f6228c = r4
            goto L_0x037f
        L_0x037d:
            r16 = 1
        L_0x037f:
            int r1 = r1 + 8
            int r0 = r0 + -1
            r5 = r55
            r7 = 1
            r9 = 0
            goto L_0x031a
        L_0x0388:
            r16 = 1
            int r0 = r8.header
            int r0 = r0 + 10
            int r7 = r27 * 2
            int r7 = r7 + r0
            int r0 = r7 + -2
            int r0 = r8.readUnsignedShort(r0)
            r9 = r0
        L_0x0398:
            if (r9 <= 0) goto L_0x058c
            char[] r10 = r14.f6198c
            int r0 = r8.readUnsignedShort(r7)
            int r1 = r7 + 2
            java.lang.String r23 = r8.readUTF8(r1, r10)
            int r1 = r7 + 4
            java.lang.String r24 = r8.readUTF8(r1, r10)
            int r7 = r7 + 6
            int r1 = r8.readUnsignedShort(r7)
            r22 = r0
            r12 = r1
            r17 = r7
            r2 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r13 = 0
            r25 = 0
            r26 = 0
        L_0x03c0:
            if (r12 <= 0) goto L_0x04c4
            int r0 = r17 + 2
            java.lang.String r1 = r8.readUTF8(r0, r10)
            java.lang.String r0 = "ConstantValue"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03e4
            int r0 = r17 + 8
            int r0 = r8.readUnsignedShort(r0)
            if (r0 != 0) goto L_0x03dd
            r0 = r37
            r26 = 0
            goto L_0x0412
        L_0x03dd:
            java.lang.Object r0 = r8.readConst(r0, r10)
            r26 = r0
            goto L_0x0405
        L_0x03e4:
            boolean r0 = r15.equals(r1)
            if (r0 == 0) goto L_0x03f1
            int r0 = r17 + 8
            java.lang.String r25 = r8.readUTF8(r0, r10)
            goto L_0x0405
        L_0x03f1:
            boolean r0 = r6.equals(r1)
            if (r0 == 0) goto L_0x03fa
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0403
        L_0x03fa:
            boolean r0 = r3.equals(r1)
            if (r0 == 0) goto L_0x0408
            r0 = 266240(0x41000, float:3.73082E-40)
        L_0x0403:
            r22 = r22 | r0
        L_0x0405:
            r0 = r37
            goto L_0x0412
        L_0x0408:
            r0 = r37
            boolean r18 = r0.equals(r1)
            if (r18 == 0) goto L_0x0417
            int r2 = r17 + 8
        L_0x0412:
            r56 = r7
            r7 = r38
            goto L_0x0432
        L_0x0417:
            r56 = r7
            r7 = r38
            boolean r18 = r7.equals(r1)
            if (r18 == 0) goto L_0x042a
            int r5 = r17 + 8
            r1 = r56
            r29 = r6
            r6 = r19
            goto L_0x0451
        L_0x042a:
            boolean r18 = r11.equals(r1)
            if (r18 == 0) goto L_0x0445
            int r4 = r17 + 8
        L_0x0432:
            r39 = r0
            r41 = r3
            r29 = r6
            r45 = r7
            r16 = r15
            r44 = r19
            r15 = 1
            r7 = r56
            r19 = r11
            goto L_0x04a6
        L_0x0445:
            r29 = r6
            r6 = r19
            boolean r18 = r6.equals(r1)
            if (r18 == 0) goto L_0x0460
            int r1 = r17 + 8
        L_0x0451:
            r39 = r0
            r41 = r3
            r44 = r6
            r45 = r7
            r19 = r11
            r16 = r15
            r15 = 1
            r7 = r1
            goto L_0x04a6
        L_0x0460:
            r18 = r1
            org.objectweb.asm.Attribute[] r1 = r14.f6196a
            int r19 = r17 + 8
            r37 = r0
            int r0 = r17 + 4
            int r20 = r8.readInt(r0)
            r21 = -1
            r27 = 0
            r39 = r37
            r0 = r54
            r40 = r2
            r2 = r18
            r41 = r3
            r3 = r19
            r42 = r4
            r4 = r20
            r43 = r5
            r5 = r10
            r18 = r6
            r19 = r11
            r11 = r29
            r6 = r21
            r45 = r7
            r16 = r15
            r44 = r18
            r15 = 1
            r11 = r56
            r7 = r27
            org.objectweb.asm.Attribute r0 = r0.a(r1, r2, r3, r4, r5, r6, r7)
            r0.f6182a = r13
            r13 = r0
            r7 = r11
            r2 = r40
            r4 = r42
            r5 = r43
        L_0x04a6:
            int r0 = r17 + 4
            int r0 = r8.readInt(r0)
            int r0 = r0 + 6
            int r17 = r0 + r17
            int r12 = r12 + -1
            r15 = r16
            r11 = r19
            r6 = r29
            r37 = r39
            r3 = r41
            r19 = r44
            r38 = r45
            r16 = 1
            goto L_0x03c0
        L_0x04c4:
            r40 = r2
            r41 = r3
            r42 = r4
            r43 = r5
            r29 = r6
            r16 = r15
            r44 = r19
            r39 = r37
            r45 = r38
            r15 = 1
            r19 = r11
            r11 = r7
            int r7 = r17 + 2
            r21 = r55
            org.objectweb.asm.ClassWriter r21 = (org.objectweb.asm.ClassWriter) r21
            org.objectweb.asm.FieldWriter r0 = new org.objectweb.asm.FieldWriter
            r20 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26)
            if (r2 == 0) goto L_0x0502
            int r1 = r8.readUnsignedShort(r2)
            int r2 = r2 + 2
        L_0x04ef:
            if (r1 <= 0) goto L_0x0502
            int r3 = r2 + 2
            java.lang.String r2 = r8.readUTF8(r2, r10)
            org.objectweb.asm.AnnotationWriter r2 = r0.visitAnnotation(r2, r15)
            int r2 = r8.a(r3, r10, r15, r2)
            int r1 = r1 + -1
            goto L_0x04ef
        L_0x0502:
            r4 = r42
            if (r4 == 0) goto L_0x0520
            int r1 = r8.readUnsignedShort(r4)
            int r4 = r4 + 2
        L_0x050c:
            if (r1 <= 0) goto L_0x0520
            int r2 = r4 + 2
            java.lang.String r3 = r8.readUTF8(r4, r10)
            r4 = 0
            org.objectweb.asm.AnnotationWriter r3 = r0.visitAnnotation(r3, r4)
            int r4 = r8.a(r2, r10, r15, r3)
            int r1 = r1 + -1
            goto L_0x050c
        L_0x0520:
            r5 = r43
            if (r5 == 0) goto L_0x0545
            int r1 = r8.readUnsignedShort(r5)
            int r5 = r5 + 2
        L_0x052a:
            if (r1 <= 0) goto L_0x0545
            int r2 = r8.a(r14, r5)
            int r3 = r2 + 2
            int r4 = r14.i
            org.objectweb.asm.TypePath r5 = r14.j
            java.lang.String r2 = r8.readUTF8(r2, r10)
            org.objectweb.asm.AnnotationWriter r2 = r0.visitTypeAnnotation(r4, r5, r2, r15)
            int r5 = r8.a(r3, r10, r15, r2)
            int r1 = r1 + -1
            goto L_0x052a
        L_0x0545:
            if (r11 == 0) goto L_0x0569
            int r1 = r8.readUnsignedShort(r11)
            int r2 = r11 + 2
        L_0x054d:
            if (r1 <= 0) goto L_0x0569
            int r2 = r8.a(r14, r2)
            int r3 = r2 + 2
            int r4 = r14.i
            org.objectweb.asm.TypePath r5 = r14.j
            java.lang.String r2 = r8.readUTF8(r2, r10)
            r6 = 0
            org.objectweb.asm.AnnotationWriter r2 = r0.visitTypeAnnotation(r4, r5, r2, r6)
            int r2 = r8.a(r3, r10, r15, r2)
            int r1 = r1 + -1
            goto L_0x054d
        L_0x0569:
            if (r13 == 0) goto L_0x0578
            org.objectweb.asm.Attribute r1 = r13.f6182a
            r2 = 0
            r13.f6182a = r2
            org.objectweb.asm.Attribute r2 = r0.j
            r13.f6182a = r2
            r0.j = r13
            r13 = r1
            goto L_0x0569
        L_0x0578:
            int r9 = r9 + -1
            r15 = r16
            r11 = r19
            r6 = r29
            r37 = r39
            r3 = r41
            r19 = r44
            r38 = r45
            r16 = 1
            goto L_0x0398
        L_0x058c:
            r41 = r3
            r29 = r6
            r16 = r15
            r44 = r19
            r39 = r37
            r45 = r38
            r15 = 1
            r19 = r11
            int r7 = r7 + 2
            int r0 = r7 + -2
            int r0 = r8.readUnsignedShort(r0)
            r9 = r0
        L_0x05a4:
            if (r9 <= 0) goto L_0x0926
            char[] r10 = r14.f6198c
            int r0 = r8.readUnsignedShort(r7)
            r14.f6200e = r0
            int r0 = r7 + 2
            java.lang.String r0 = r8.readUTF8(r0, r10)
            r14.f6201f = r0
            int r0 = r7 + 4
            java.lang.String r0 = r8.readUTF8(r0, r10)
            r14.g = r0
            int r11 = r7 + 6
            int r0 = r8.readUnsignedShort(r11)
            r12 = r0
            r20 = r11
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r13 = 0
            r17 = 0
            r18 = 0
            r46 = 0
            r47 = 0
        L_0x05d8:
            if (r12 <= 0) goto L_0x0790
            int r15 = r20 + 2
            java.lang.String r15 = r8.readUTF8(r15, r10)
            r56 = r0
            java.lang.String r0 = "Code"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0605
            int r0 = r14.f6197b
            r15 = 1
            r0 = r0 & r15
            if (r0 != 0) goto L_0x0602
            int r13 = r20 + 8
            r0 = r56
            r21 = r1
            r1 = r16
            r37 = r39
            r38 = r45
            r16 = r7
            r7 = r44
            goto L_0x0707
        L_0x0602:
            r21 = r1
            goto L_0x0629
        L_0x0605:
            java.lang.String r0 = "Exceptions"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0635
            int r0 = r20 + 8
            int r0 = r8.readUnsignedShort(r0)
            java.lang.String[] r4 = new java.lang.String[r0]
            int r15 = r20 + 10
            r21 = r1
            r1 = 0
        L_0x061a:
            if (r1 >= r0) goto L_0x0627
            java.lang.String r18 = r8.readClass(r15, r10)
            r4[r1] = r18
            int r15 = r15 + 2
            int r1 = r1 + 1
            goto L_0x061a
        L_0x0627:
            r18 = r15
        L_0x0629:
            r1 = r16
            r37 = r39
            r0 = r41
            r16 = r7
            r7 = r45
            goto L_0x06b4
        L_0x0635:
            r21 = r1
            r1 = r16
            boolean r0 = r1.equals(r15)
            if (r0 == 0) goto L_0x064c
            int r0 = r20 + 8
            java.lang.String r3 = r8.readUTF8(r0, r10)
            r16 = r7
            r0 = r29
            r7 = r39
            goto L_0x066f
        L_0x064c:
            r0 = r29
            boolean r16 = r0.equals(r15)
            if (r16 == 0) goto L_0x0663
            int r15 = r14.f6200e
            r29 = r0
            r16 = r7
            r37 = r39
            r0 = r41
            r7 = r45
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x06b0
        L_0x0663:
            r16 = r7
            r7 = r39
            boolean r22 = r7.equals(r15)
            if (r22 == 0) goto L_0x0678
            int r46 = r20 + 8
        L_0x066f:
            r29 = r0
            r37 = r7
            r0 = r21
            r7 = r45
            goto L_0x069b
        L_0x0678:
            r37 = r7
            r7 = r45
            boolean r22 = r7.equals(r15)
            if (r22 == 0) goto L_0x068f
            int r2 = r20 + 8
            r15 = r56
            r29 = r0
            r38 = r7
            r7 = r19
            r0 = r41
            goto L_0x06c7
        L_0x068f:
            r29 = r0
            java.lang.String r0 = "AnnotationDefault"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x06a3
            int r0 = r20 + 8
        L_0x069b:
            r21 = r0
            r38 = r7
            r7 = r44
            goto L_0x0705
        L_0x06a3:
            r0 = r41
            boolean r22 = r0.equals(r15)
            if (r22 == 0) goto L_0x06bb
            int r15 = r14.f6200e
            r22 = 266240(0x41000, float:3.73082E-40)
        L_0x06b0:
            r15 = r15 | r22
            r14.f6200e = r15
        L_0x06b4:
            r15 = r56
            r38 = r7
            r7 = r19
            goto L_0x06c7
        L_0x06bb:
            r38 = r7
            r7 = r19
            boolean r19 = r7.equals(r15)
            if (r19 == 0) goto L_0x06cc
            int r15 = r20 + 8
        L_0x06c7:
            r19 = r7
            r7 = r44
            goto L_0x06da
        L_0x06cc:
            r19 = r7
            r7 = r44
            boolean r22 = r7.equals(r15)
            if (r22 == 0) goto L_0x06de
            int r47 = r20 + 8
            r15 = r56
        L_0x06da:
            r41 = r0
            r0 = r15
            goto L_0x0707
        L_0x06de:
            r41 = r0
            java.lang.String r0 = "RuntimeVisibleParameterAnnotations"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x06ed
            int r0 = r20 + 8
            r16 = r0
            goto L_0x0705
        L_0x06ed:
            java.lang.String r0 = "RuntimeInvisibleParameterAnnotations"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x06f9
            int r0 = r20 + 8
            r6 = r0
            goto L_0x0705
        L_0x06f9:
            java.lang.String r0 = "MethodParameters"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x071f
            int r0 = r20 + 8
            r17 = r0
        L_0x0705:
            r0 = r56
        L_0x0707:
            r22 = r9
            r27 = r29
            r25 = r37
            r24 = r38
            r23 = r41
            r52 = r21
            r21 = r1
            r1 = r52
            r53 = r16
            r16 = r7
            r7 = r53
            goto L_0x0773
        L_0x071f:
            org.objectweb.asm.Attribute[] r0 = r14.f6196a
            int r22 = r20 + 8
            r23 = r0
            int r0 = r20 + 4
            int r24 = r8.readInt(r0)
            r25 = -1
            r26 = 0
            r48 = r56
            r28 = r23
            r27 = r29
            r23 = r41
            r0 = r54
            r49 = r21
            r21 = r1
            r1 = r28
            r50 = r2
            r2 = r15
            r15 = r3
            r3 = r22
            r56 = r4
            r4 = r24
            r51 = r5
            r5 = r10
            r22 = r9
            r9 = r6
            r6 = r25
            r28 = r13
            r13 = r16
            r25 = r37
            r24 = r38
            r16 = r7
            r7 = r26
            org.objectweb.asm.Attribute r0 = r0.a(r1, r2, r3, r4, r5, r6, r7)
            r6 = r51
            r0.f6182a = r6
            r4 = r56
            r5 = r0
            r6 = r9
            r7 = r13
            r3 = r15
            r13 = r28
            r0 = r48
            r1 = r49
            r2 = r50
        L_0x0773:
            int r9 = r20 + 4
            int r9 = r8.readInt(r9)
            int r9 = r9 + 6
            int r20 = r9 + r20
            int r12 = r12 + -1
            r44 = r16
            r16 = r21
            r9 = r22
            r41 = r23
            r45 = r24
            r39 = r25
            r29 = r27
            r15 = 1
            goto L_0x05d8
        L_0x0790:
            r48 = r0
            r49 = r1
            r50 = r2
            r15 = r3
            r56 = r4
            r22 = r9
            r28 = r13
            r21 = r16
            r27 = r29
            r25 = r39
            r23 = r41
            r16 = r44
            r24 = r45
            r9 = r6
            r13 = r7
            r6 = r5
            int r7 = r20 + 2
            int r1 = r14.f6200e
            java.lang.String r2 = r14.f6201f
            java.lang.String r3 = r14.g
            r0 = r55
            r4 = r15
            r5 = r56
            org.objectweb.asm.MethodVisitor r0 = r0.visitMethod(r1, r2, r3, r4, r5)
            r1 = r0
            org.objectweb.asm.MethodWriter r1 = (org.objectweb.asm.MethodWriter) r1
            org.objectweb.asm.ClassWriter r2 = r1.f6236b
            org.objectweb.asm.ClassReader r2 = r2.M
            if (r2 != r8) goto L_0x07ff
            java.lang.String r2 = r1.g
            if (r15 != r2) goto L_0x07ff
            r4 = r56
            if (r4 != 0) goto L_0x07d3
            int r2 = r1.j
            if (r2 != 0) goto L_0x07f1
            goto L_0x07ef
        L_0x07d3:
            int r2 = r4.length
            int r3 = r1.j
            if (r2 != r3) goto L_0x07f1
            int r2 = r4.length
            r3 = 1
            int r2 = r2 - r3
        L_0x07db:
            if (r2 < 0) goto L_0x07ef
            int r3 = r18 + -2
            int[] r4 = r1.k
            r4 = r4[r2]
            int r5 = r8.readUnsignedShort(r3)
            if (r4 == r5) goto L_0x07ea
            goto L_0x07f1
        L_0x07ea:
            int r2 = r2 + -1
            r18 = r3
            goto L_0x07db
        L_0x07ef:
            r2 = 1
            goto L_0x07f2
        L_0x07f1:
            r2 = 0
        L_0x07f2:
            if (r2 == 0) goto L_0x07ff
            r1.h = r11
            int r0 = r7 - r11
            r1.i = r0
            r2 = 0
            r4 = 0
            r5 = 1
            goto L_0x0915
        L_0x07ff:
            if (r17 == 0) goto L_0x083f
            byte[] r2 = r8.f6187b
            byte r2 = r2[r17]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r17 = r17 + 1
            r3 = r17
        L_0x080b:
            if (r2 <= 0) goto L_0x083f
            java.lang.String r4 = r8.readUTF8(r3, r10)
            int r5 = r3 + 2
            int r5 = r8.readUnsignedShort(r5)
            org.objectweb.asm.ByteVector r11 = r1.$
            if (r11 != 0) goto L_0x0822
            org.objectweb.asm.ByteVector r11 = new org.objectweb.asm.ByteVector
            r11.<init>()
            r1.$ = r11
        L_0x0822:
            int r11 = r1.Z
            r12 = 1
            int r11 = r11 + r12
            r1.Z = r11
            org.objectweb.asm.ByteVector r11 = r1.$
            if (r4 != 0) goto L_0x082e
            r4 = 0
            goto L_0x0834
        L_0x082e:
            org.objectweb.asm.ClassWriter r12 = r1.f6236b
            int r4 = r12.newUTF8(r4)
        L_0x0834:
            r11.putShort(r4)
            r11.putShort(r5)
            int r2 = r2 + -1
            int r3 = r3 + 4
            goto L_0x080b
        L_0x083f:
            r2 = r49
            if (r2 == 0) goto L_0x0864
            org.objectweb.asm.ByteVector r3 = new org.objectweb.asm.ByteVector
            r3.<init>()
            r1.l = r3
            org.objectweb.asm.AnnotationWriter r4 = new org.objectweb.asm.AnnotationWriter
            org.objectweb.asm.ClassWriter r5 = r1.f6236b
            r39 = 0
            r41 = 0
            r42 = 0
            r37 = r4
            r38 = r5
            r40 = r3
            r37.<init>(r38, r39, r40, r41, r42)
            r3 = 0
            r8.a(r2, r10, r3, r4)
            r4.visitEnd()
        L_0x0864:
            r2 = r46
            if (r2 == 0) goto L_0x0884
            int r3 = r8.readUnsignedShort(r2)
            int r46 = r2 + 2
            r2 = r46
        L_0x0870:
            if (r3 <= 0) goto L_0x0884
            int r4 = r2 + 2
            java.lang.String r2 = r8.readUTF8(r2, r10)
            r5 = 1
            org.objectweb.asm.AnnotationWriter r2 = r0.visitAnnotation(r2, r5)
            int r2 = r8.a(r4, r10, r5, r2)
            int r3 = r3 + -1
            goto L_0x0870
        L_0x0884:
            r2 = r48
            if (r2 == 0) goto L_0x08a3
            int r3 = r8.readUnsignedShort(r2)
            int r2 = r2 + 2
        L_0x088e:
            if (r3 <= 0) goto L_0x08a3
            int r4 = r2 + 2
            java.lang.String r2 = r8.readUTF8(r2, r10)
            r5 = 0
            org.objectweb.asm.AnnotationWriter r2 = r0.visitAnnotation(r2, r5)
            r5 = 1
            int r2 = r8.a(r4, r10, r5, r2)
            int r3 = r3 + -1
            goto L_0x088e
        L_0x08a3:
            r2 = r50
            if (r2 == 0) goto L_0x08c9
            int r3 = r8.readUnsignedShort(r2)
            int r2 = r2 + 2
        L_0x08ad:
            if (r3 <= 0) goto L_0x08c9
            int r2 = r8.a(r14, r2)
            int r4 = r2 + 2
            int r5 = r14.i
            org.objectweb.asm.TypePath r11 = r14.j
            java.lang.String r2 = r8.readUTF8(r2, r10)
            r12 = 1
            org.objectweb.asm.AnnotationWriter r2 = r0.visitTypeAnnotation(r5, r11, r2, r12)
            int r2 = r8.a(r4, r10, r12, r2)
            int r3 = r3 + -1
            goto L_0x08ad
        L_0x08c9:
            r2 = r47
            if (r2 == 0) goto L_0x08f2
            int r3 = r8.readUnsignedShort(r2)
            int r47 = r2 + 2
            r2 = r47
        L_0x08d5:
            if (r3 <= 0) goto L_0x08f2
            int r2 = r8.a(r14, r2)
            int r4 = r2 + 2
            int r5 = r14.i
            org.objectweb.asm.TypePath r11 = r14.j
            java.lang.String r2 = r8.readUTF8(r2, r10)
            r12 = 0
            org.objectweb.asm.AnnotationWriter r2 = r0.visitTypeAnnotation(r5, r11, r2, r12)
            r5 = 1
            int r2 = r8.a(r4, r10, r5, r2)
            int r3 = r3 + -1
            goto L_0x08d5
        L_0x08f2:
            r5 = 1
            if (r13 == 0) goto L_0x08f8
            r8.b(r0, r14, r13, r5)
        L_0x08f8:
            r2 = 0
            if (r9 == 0) goto L_0x08fe
            r8.b(r0, r14, r9, r2)
        L_0x08fe:
            if (r6 == 0) goto L_0x090d
            org.objectweb.asm.Attribute r3 = r6.f6182a
            r4 = 0
            r6.f6182a = r4
            org.objectweb.asm.Attribute r9 = r1.q
            r6.f6182a = r9
            r1.q = r6
            r6 = r3
            goto L_0x08fe
        L_0x090d:
            r4 = 0
            if (r28 == 0) goto L_0x0915
            r13 = r28
            r8.a(r0, r14, r13)
        L_0x0915:
            int r9 = r22 + -1
            r44 = r16
            r16 = r21
            r41 = r23
            r45 = r24
            r39 = r25
            r29 = r27
            r15 = 1
            goto L_0x05a4
        L_0x0926:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.accept(org.objectweb.asm.ClassVisitor, int):void");
    }

    public final void b(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int i2 = i + 1;
        byte b2 = this.f6187b[i] & 255;
        int length = Type.getArgumentTypes(context.g).length - b2;
        int i3 = 0;
        while (i3 < length) {
            methodVisitor.visitParameterAnnotation(i3, "Ljava/lang/Synthetic;", false).visitEnd();
            i3++;
        }
        char[] cArr = context.f6198c;
        while (i3 < b2 + length) {
            i2 += 2;
            for (int readUnsignedShort = readUnsignedShort(i2); readUnsignedShort > 0; readUnsignedShort--) {
                i2 = a(i2 + 2, cArr, true, methodVisitor.visitParameterAnnotation(i3, readUTF8(i2, cArr), z));
            }
            i3++;
        }
    }

    public int readByte(int i) {
        return this.f6187b[i] & 255;
    }

    public String readClass(int i, char[] cArr) {
        return readUTF8(this.f6186a[readUnsignedShort(i)], cArr);
    }

    public Object readConst(int i, char[] cArr) {
        int i2 = this.f6186a[i];
        byte b2 = this.f6187b[i2 - 1];
        if (b2 == 16) {
            return Type.a(readUTF8(i2, cArr).toCharArray(), 0);
        }
        switch (b2) {
            case 3:
                return new Integer(readInt(i2));
            case 4:
                return new Float(Float.intBitsToFloat(readInt(i2)));
            case 5:
                return new Long(readLong(i2));
            case 6:
                return new Double(Double.longBitsToDouble(readLong(i2)));
            case 7:
                char[] charArray = readUTF8(i2, cArr).toCharArray();
                return new Type(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
            case 8:
                return readUTF8(i2, cArr);
            default:
                int readByte = readByte(i2);
                int[] iArr = this.f6186a;
                int i3 = iArr[readUnsignedShort(i2 + 1)];
                String readClass = readClass(i3, cArr);
                int i4 = iArr[readUnsignedShort(i3 + 2)];
                return new Handle(readByte, readClass, readUTF8(i4, cArr), readUTF8(i4 + 2, cArr));
        }
    }

    public int readInt(int i) {
        byte[] bArr = this.f6187b;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << GlyfDescript.X_DUAL) | ((bArr[i + 2] & 255) << 8);
    }

    public Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    public long readLong(int i) {
        return (((long) readInt(i)) << 32) | (((long) readInt(i + 4)) & 4294967295L);
    }

    public short readShort(int i) {
        byte[] bArr = this.f6187b;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        if (i == 0 || readUnsignedShort == 0) {
            return null;
        }
        String[] strArr = this.f6188c;
        String str = strArr[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.f6186a[readUnsignedShort];
        String a2 = a(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[readUnsignedShort] = a2;
        return a2;
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.f6187b;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public final Attribute a(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        for (int i4 = 0; i4 < attributeArr.length; i4++) {
            if (attributeArr[i4].type.equals(str)) {
                return attributeArr[i4].read(this, i, i2);
            }
        }
        Attribute attribute = new Attribute(str);
        byte[] bArr = new byte[i2];
        attribute.f6183b = bArr;
        System.arraycopy(this.f6187b, i, bArr, 0, i2);
        return attribute;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ba, code lost:
        r1 = r1 + 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bd, code lost:
        r1 = r1 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0639, code lost:
        r41 = r7;
        r40 = r14;
        r11 = r24;
        r1 = r28;
        r10 = r31;
        r8 = r34;
        r31 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x06a4, code lost:
        r15 = r15 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x06a6, code lost:
        r41 = r7;
        r31 = r13;
        r40 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x087d, code lost:
        if (r11 == 185) goto L_0x087f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x087f, code lost:
        r15 = r15 + 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x08f4, code lost:
        r15 = r15 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x090c, code lost:
        r15 = r15 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0920, code lost:
        r15 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0957, code lost:
        r11 = r24;
        r1 = r28;
        r8 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x095d, code lost:
        if (r11 == null) goto L_0x09a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0960, code lost:
        if (r8 >= r11.length) goto L_0x09a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0962, code lost:
        r2 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0964, code lost:
        if (r1 > r2) goto L_0x09a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0966, code lost:
        if (r1 != r2) goto L_0x0983;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x0968, code lost:
        r12 = r47;
        r1 = a(r12, r11[r8]);
        a(r1 + 2, r10, true, r9.visitInsnAnnotation(r12.i, r12.j, readUTF8(r1, r10), true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0983, code lost:
        r12 = r47;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x0985, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0988, code lost:
        if (r8 >= r11.length) goto L_0x099f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0992, code lost:
        if (readByte(r11[r8]) >= 67) goto L_0x0995;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0995, code lost:
        r1 = readUnsignedShort(r11[r8] + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x099f, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x09a0, code lost:
        r41 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x09a3, code lost:
        r12 = r47;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x09a6, code lost:
        r12 = r47;
        r2 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x09aa, code lost:
        r13 = r25;
        r4 = r29;
        r3 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x09b0, code lost:
        if (r13 == null) goto L_0x09f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x09b3, code lost:
        if (r3 >= r13.length) goto L_0x09f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x09b5, code lost:
        if (r4 > r2) goto L_0x09f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x09b7, code lost:
        if (r4 != r2) goto L_0x09d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x09b9, code lost:
        r4 = a(r12, r13[r3]);
        a(r4 + 2, r10, true, r9.visitInsnAnnotation(r12.i, r12.j, readUTF8(r4, r10), false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x09d4, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x09d7, code lost:
        if (r3 >= r13.length) goto L_0x09ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x09e1, code lost:
        if (readByte(r13[r3]) >= 67) goto L_0x09e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x09e4, code lost:
        r4 = readUnsignedShort(r13[r3] + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x09ef, code lost:
        r4 = -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0799  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x079e  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x07de  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x07fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.objectweb.asm.MethodVisitor r46, org.objectweb.asm.Context r47, int r48) {
        /*
            r45 = this;
            r0 = r45
            r9 = r46
            r10 = r47
            r1 = r48
            byte[] r7 = r0.f6187b
            char[] r11 = r10.f6198c
            int r12 = r0.readUnsignedShort(r1)
            int r2 = r1 + 2
            int r13 = r0.readUnsignedShort(r2)
            int r2 = r1 + 4
            int r8 = r0.readInt(r2)
            r14 = 8
            int r15 = r1 + 8
            int r6 = r15 + r8
            int r1 = r8 + 2
            org.objectweb.asm.Label[] r5 = new org.objectweb.asm.Label[r1]
            r10.h = r5
            int r1 = r8 + 1
            r0.readLabel(r1, r5)
            r1 = r15
        L_0x002e:
            r4 = 132(0x84, float:1.85E-43)
            r3 = 1
            if (r1 >= r6) goto L_0x00cc
            int r2 = r1 - r15
            byte r14 = r7[r1]
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte[] r17 = org.objectweb.asm.ClassWriter.f6190a
            byte r14 = r17[r14]
            switch(r14) {
                case 0: goto L_0x00c3;
                case 1: goto L_0x00c0;
                case 2: goto L_0x00bd;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00c3;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00bd;
                case 7: goto L_0x00ba;
                case 8: goto L_0x00ba;
                case 9: goto L_0x00af;
                case 10: goto L_0x00a4;
                case 11: goto L_0x00c0;
                case 12: goto L_0x00bd;
                case 13: goto L_0x00bd;
                case 14: goto L_0x0075;
                case 15: goto L_0x004e;
                case 16: goto L_0x0040;
                case 17: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x00c6
        L_0x0042:
            int r2 = r1 + 1
            byte r2 = r7[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            if (r2 != r4) goto L_0x00c6
            int r1 = r1 + 6
            goto L_0x00c8
        L_0x004e:
            int r1 = r1 + 4
            r3 = r2 & 3
            int r1 = r1 - r3
            int r3 = r0.readInt(r1)
            int r3 = r3 + r2
            r0.readLabel(r3, r5)
            int r3 = r1 + 4
            int r3 = r0.readInt(r3)
        L_0x0061:
            if (r3 <= 0) goto L_0x0072
            int r4 = r1 + 12
            int r4 = r0.readInt(r4)
            int r4 = r4 + r2
            r0.readLabel(r4, r5)
            int r1 = r1 + 8
            int r3 = r3 + -1
            goto L_0x0061
        L_0x0072:
            int r1 = r1 + 8
            goto L_0x00c8
        L_0x0075:
            int r1 = r1 + 4
            r4 = r2 & 3
            int r1 = r1 - r4
            int r4 = r0.readInt(r1)
            int r4 = r4 + r2
            r0.readLabel(r4, r5)
            int r4 = r1 + 8
            int r4 = r0.readInt(r4)
            int r14 = r1 + 4
            int r14 = r0.readInt(r14)
            int r4 = r4 - r14
            int r4 = r4 + r3
        L_0x0090:
            if (r4 <= 0) goto L_0x00a1
            int r3 = r1 + 12
            int r3 = r0.readInt(r3)
            int r3 = r3 + r2
            r0.readLabel(r3, r5)
            int r1 = r1 + 4
            int r4 = r4 + -1
            goto L_0x0090
        L_0x00a1:
            int r1 = r1 + 12
            goto L_0x00c8
        L_0x00a4:
            int r3 = r1 + 1
            int r3 = r0.readInt(r3)
            int r3 = r3 + r2
            r0.readLabel(r3, r5)
            goto L_0x00ba
        L_0x00af:
            int r3 = r1 + 1
            short r3 = r0.readShort(r3)
            int r3 = r3 + r2
            r0.readLabel(r3, r5)
            goto L_0x00bd
        L_0x00ba:
            int r1 = r1 + 5
            goto L_0x00c8
        L_0x00bd:
            int r1 = r1 + 3
            goto L_0x00c8
        L_0x00c0:
            int r1 = r1 + 2
            goto L_0x00c8
        L_0x00c3:
            int r1 = r1 + 1
            goto L_0x00c8
        L_0x00c6:
            int r1 = r1 + 4
        L_0x00c8:
            r14 = 8
            goto L_0x002e
        L_0x00cc:
            int r2 = r0.readUnsignedShort(r1)
        L_0x00d0:
            if (r2 <= 0) goto L_0x0141
            int r4 = r1 + 2
            int r4 = r0.readUnsignedShort(r4)
            org.objectweb.asm.Label r4 = r0.readLabel(r4, r5)
            int r14 = r1 + 4
            int r14 = r0.readUnsignedShort(r14)
            org.objectweb.asm.Label r14 = r0.readLabel(r14, r5)
            int r3 = r1 + 6
            int r3 = r0.readUnsignedShort(r3)
            org.objectweb.asm.Label r3 = r0.readLabel(r3, r5)
            r19 = r6
            int[] r6 = r0.f6186a
            int r1 = r1 + 8
            int r20 = r0.readUnsignedShort(r1)
            r6 = r6[r20]
            java.lang.String r6 = r0.readUTF8(r6, r11)
            r20 = r1
            r1 = r9
            org.objectweb.asm.MethodWriter r1 = (org.objectweb.asm.MethodWriter) r1
            r21 = r15
            int r15 = r1.A
            r18 = 1
            int r15 = r15 + 1
            r1.A = r15
            org.objectweb.asm.Handler r15 = new org.objectweb.asm.Handler
            r15.<init>()
            r15.f6220a = r4
            r15.f6221b = r14
            r15.f6222c = r3
            r15.f6223d = r6
            if (r6 == 0) goto L_0x0127
            org.objectweb.asm.ClassWriter r3 = r1.f6236b
            org.objectweb.asm.Item r3 = r3.a(r6)
            int r14 = r3.f6226a
            goto L_0x0128
        L_0x0127:
            r14 = 0
        L_0x0128:
            r15.f6224e = r14
            org.objectweb.asm.Handler r3 = r1.C
            if (r3 != 0) goto L_0x0131
            r1.B = r15
            goto L_0x0133
        L_0x0131:
            r3.f6225f = r15
        L_0x0133:
            r1.C = r15
            int r2 = r2 + -1
            r6 = r19
            r1 = r20
            r15 = r21
            r3 = 1
            r4 = 132(0x84, float:1.85E-43)
            goto L_0x00d0
        L_0x0141:
            r19 = r6
            r21 = r15
            int r1 = r1 + 2
            int r2 = r10.f6197b
            r3 = 8
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0150
            r14 = 1
            goto L_0x0151
        L_0x0150:
            r14 = 0
        L_0x0151:
            int r2 = r0.readUnsignedShort(r1)
            r3 = 0
            r4 = 0
            r20 = 0
            r22 = 1
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = -1
            r29 = -1
        L_0x0169:
            if (r2 <= 0) goto L_0x0326
            int r6 = r1 + 2
            java.lang.String r6 = r0.readUTF8(r6, r11)
            java.lang.String r15 = "LocalVariableTable"
            boolean r15 = r15.equals(r6)
            if (r15 == 0) goto L_0x01e0
            int r6 = r10.f6197b
            r6 = r6 & 2
            if (r6 != 0) goto L_0x01d8
            int r6 = r1 + 8
            int r15 = r0.readUnsignedShort(r6)
            r26 = r1
        L_0x0187:
            if (r15 <= 0) goto L_0x01cc
            r30 = r6
            int r6 = r26 + 10
            r31 = r11
            int r11 = r0.readUnsignedShort(r6)
            r32 = r5[r11]
            if (r32 != 0) goto L_0x01a8
            r32 = r6
            org.objectweb.asm.Label r6 = r0.readLabel(r11, r5)
            r33 = r8
            int r8 = r6.f6230a
            r18 = 1
            r8 = r8 | 1
            r6.f6230a = r8
            goto L_0x01ac
        L_0x01a8:
            r32 = r6
            r33 = r8
        L_0x01ac:
            int r6 = r26 + 12
            int r6 = r0.readUnsignedShort(r6)
            int r6 = r6 + r11
            r8 = r5[r6]
            if (r8 != 0) goto L_0x01c1
            org.objectweb.asm.Label r6 = r0.readLabel(r6, r5)
            int r8 = r6.f6230a
            r11 = 1
            r8 = r8 | r11
            r6.f6230a = r8
        L_0x01c1:
            int r15 = r15 + -1
            r6 = r30
            r11 = r31
            r26 = r32
            r8 = r33
            goto L_0x0187
        L_0x01cc:
            r30 = r6
            r33 = r8
            r31 = r11
            r32 = r7
            r26 = r30
            goto L_0x0313
        L_0x01d8:
            r33 = r8
            r31 = r11
        L_0x01dc:
            r32 = r7
            goto L_0x0313
        L_0x01e0:
            r33 = r8
            r31 = r11
            java.lang.String r8 = "LocalVariableTypeTable"
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L_0x01ef
            int r27 = r1 + 8
            goto L_0x01dc
        L_0x01ef:
            java.lang.String r8 = "LineNumberTable"
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L_0x0244
            int r6 = r10.f6197b
            r6 = r6 & 2
            if (r6 != 0) goto L_0x01dc
            int r6 = r1 + 8
            int r6 = r0.readUnsignedShort(r6)
            r8 = r1
        L_0x0204:
            if (r6 <= 0) goto L_0x01dc
            int r11 = r8 + 10
            int r11 = r0.readUnsignedShort(r11)
            r15 = r5[r11]
            if (r15 != 0) goto L_0x021f
            org.objectweb.asm.Label r15 = r0.readLabel(r11, r5)
            r32 = r7
            int r7 = r15.f6230a
            r18 = 1
            r7 = r7 | 1
            r15.f6230a = r7
            goto L_0x0221
        L_0x021f:
            r32 = r7
        L_0x0221:
            r7 = r5[r11]
        L_0x0223:
            int r11 = r7.f6231b
            if (r11 <= 0) goto L_0x0235
            org.objectweb.asm.Label r11 = r7.k
            if (r11 != 0) goto L_0x0232
            org.objectweb.asm.Label r11 = new org.objectweb.asm.Label
            r11.<init>()
            r7.k = r11
        L_0x0232:
            org.objectweb.asm.Label r7 = r7.k
            goto L_0x0223
        L_0x0235:
            int r11 = r8 + 12
            int r11 = r0.readUnsignedShort(r11)
            r7.f6231b = r11
            int r8 = r8 + 4
            int r6 = r6 + -1
            r7 = r32
            goto L_0x0204
        L_0x0244:
            r32 = r7
            java.lang.String r7 = "RuntimeVisibleTypeAnnotations"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0274
            int r6 = r1 + 8
            r7 = 1
            int[] r6 = r0.a(r9, r10, r6, r7)
            int r8 = r6.length
            if (r8 == 0) goto L_0x026e
            r8 = 0
            r11 = r6[r8]
            int r11 = r0.readByte(r11)
            r15 = 67
            if (r11 >= r15) goto L_0x0264
            goto L_0x026e
        L_0x0264:
            r11 = r6[r8]
            int r11 = r11 + r7
            int r7 = r0.readUnsignedShort(r11)
            r28 = r7
            goto L_0x0270
        L_0x026e:
            r28 = -1
        L_0x0270:
            r24 = r6
            goto L_0x0313
        L_0x0274:
            java.lang.String r7 = "RuntimeInvisibleTypeAnnotations"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x02a2
            int r6 = r1 + 8
            r7 = 0
            int[] r6 = r0.a(r9, r10, r6, r7)
            int r8 = r6.length
            if (r8 == 0) goto L_0x029c
            r8 = r6[r7]
            int r8 = r0.readByte(r8)
            r11 = 67
            if (r8 >= r11) goto L_0x0291
            goto L_0x029c
        L_0x0291:
            r8 = r6[r7]
            r7 = 1
            int r8 = r8 + r7
            int r7 = r0.readUnsignedShort(r8)
            r29 = r7
            goto L_0x029e
        L_0x029c:
            r29 = -1
        L_0x029e:
            r25 = r6
            goto L_0x0313
        L_0x02a2:
            java.lang.String r7 = "StackMapTable"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x02c1
            int r6 = r10.f6197b
            r6 = r6 & 4
            if (r6 != 0) goto L_0x0313
            int r3 = r1 + 10
            int r4 = r1 + 4
            int r4 = r0.readInt(r4)
            int r6 = r1 + 8
            int r6 = r0.readUnsignedShort(r6)
            r20 = r6
            goto L_0x0313
        L_0x02c1:
            java.lang.String r7 = "StackMap"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x02e2
            int r6 = r10.f6197b
            r6 = r6 & 4
            if (r6 != 0) goto L_0x0313
            int r3 = r1 + 10
            int r4 = r1 + 4
            int r4 = r0.readInt(r4)
            int r6 = r1 + 8
            int r6 = r0.readUnsignedShort(r6)
            r20 = r6
            r22 = 0
            goto L_0x0313
        L_0x02e2:
            r8 = r23
            r7 = 0
        L_0x02e5:
            org.objectweb.asm.Attribute[] r11 = r10.f6196a
            int r15 = r11.length
            if (r7 >= r15) goto L_0x0311
            r11 = r11[r7]
            java.lang.String r11 = r11.type
            boolean r11 = r11.equals(r6)
            if (r11 == 0) goto L_0x030a
            org.objectweb.asm.Attribute[] r11 = r10.f6196a
            r11 = r11[r7]
            int r15 = r1 + 8
            r30 = r6
            int r6 = r1 + 4
            int r6 = r0.readInt(r6)
            org.objectweb.asm.Attribute r6 = r11.read(r0, r15, r6)
            r6.f6182a = r8
            r8 = r6
            goto L_0x030c
        L_0x030a:
            r30 = r6
        L_0x030c:
            int r7 = r7 + 1
            r6 = r30
            goto L_0x02e5
        L_0x0311:
            r23 = r8
        L_0x0313:
            int r6 = r1 + 4
            int r6 = r0.readInt(r6)
            int r6 = r6 + 6
            int r1 = r1 + r6
            int r2 = r2 + -1
            r11 = r31
            r7 = r32
            r8 = r33
            goto L_0x0169
        L_0x0326:
            r32 = r7
            r33 = r8
            r31 = r11
            if (r3 == 0) goto L_0x042f
            r1 = -1
            r10.o = r1
            r1 = 0
            r10.p = r1
            r10.q = r1
            r10.r = r1
            r10.t = r1
            java.lang.Object[] r1 = new java.lang.Object[r13]
            r10.s = r1
            java.lang.Object[] r2 = new java.lang.Object[r12]
            r10.u = r2
            if (r14 == 0) goto L_0x03fd
            java.lang.String r2 = r10.g
            int r6 = r10.f6200e
            r7 = 8
            r6 = r6 & r7
            if (r6 != 0) goto L_0x036c
            java.lang.String r6 = r10.f6201f
            java.lang.String r7 = "<init>"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x035d
            java.lang.Integer r6 = org.objectweb.asm.Opcodes.UNINITIALIZED_THIS
            r7 = 0
            r1[r7] = r6
            goto L_0x036a
        L_0x035d:
            r7 = 0
            int r6 = r0.header
            int r6 = r6 + 2
            char[] r8 = r10.f6198c
            java.lang.String r6 = r0.readClass(r6, r8)
            r1[r7] = r6
        L_0x036a:
            r6 = 1
            goto L_0x036d
        L_0x036c:
            r6 = 0
        L_0x036d:
            r7 = 1
        L_0x036e:
            int r8 = r7 + 1
            char r11 = r2.charAt(r7)
            r15 = 70
            if (r11 == r15) goto L_0x03f3
            r15 = 76
            if (r11 == r15) goto L_0x03d7
            r15 = 83
            if (r11 == r15) goto L_0x03cf
            r15 = 73
            if (r11 == r15) goto L_0x03cf
            r15 = 74
            if (r11 == r15) goto L_0x03c7
            r15 = 90
            if (r11 == r15) goto L_0x03cf
            r15 = 91
            if (r11 == r15) goto L_0x039e
            switch(r11) {
                case 66: goto L_0x03cf;
                case 67: goto L_0x03cf;
                case 68: goto L_0x0397;
                default: goto L_0x0393;
            }
        L_0x0393:
            r10.q = r6
            goto L_0x03fd
        L_0x0397:
            int r7 = r6 + 1
            java.lang.Integer r11 = org.objectweb.asm.Opcodes.DOUBLE
            r1[r6] = r11
            goto L_0x03f9
        L_0x039e:
            char r11 = r2.charAt(r8)
            if (r11 != r15) goto L_0x03a7
            int r8 = r8 + 1
            goto L_0x039e
        L_0x03a7:
            char r11 = r2.charAt(r8)
            r15 = 76
            if (r11 != r15) goto L_0x03ba
        L_0x03af:
            r11 = 1
            int r8 = r8 + r11
            char r15 = r2.charAt(r8)
            r11 = 59
            if (r15 == r11) goto L_0x03ba
            goto L_0x03af
        L_0x03ba:
            int r11 = r6 + 1
            r15 = 1
            int r8 = r8 + r15
            java.lang.String r7 = r2.substring(r7, r8)
            r1[r6] = r7
            r7 = r8
            r6 = r11
            goto L_0x036e
        L_0x03c7:
            r15 = 1
            int r7 = r6 + 1
            java.lang.Integer r11 = org.objectweb.asm.Opcodes.LONG
            r1[r6] = r11
            goto L_0x03f9
        L_0x03cf:
            r15 = 1
            int r7 = r6 + 1
            java.lang.Integer r11 = org.objectweb.asm.Opcodes.INTEGER
            r1[r6] = r11
            goto L_0x03f9
        L_0x03d7:
            r15 = 1
            r7 = r8
        L_0x03d9:
            char r11 = r2.charAt(r7)
            r15 = 59
            if (r11 == r15) goto L_0x03e5
            int r7 = r7 + 1
            r15 = 1
            goto L_0x03d9
        L_0x03e5:
            int r11 = r6 + 1
            int r15 = r7 + 1
            java.lang.String r7 = r2.substring(r8, r7)
            r1[r6] = r7
            r6 = r11
            r7 = r15
            goto L_0x036e
        L_0x03f3:
            int r7 = r6 + 1
            java.lang.Integer r11 = org.objectweb.asm.Opcodes.FLOAT
            r1[r6] = r11
        L_0x03f9:
            r6 = r7
            r7 = r8
            goto L_0x036e
        L_0x03fd:
            r1 = r3
        L_0x03fe:
            int r2 = r3 + r4
            int r2 = r2 + -2
            if (r1 >= r2) goto L_0x042b
            byte r2 = r32[r1]
            r6 = 8
            if (r2 != r6) goto L_0x0424
            int r2 = r1 + 1
            int r2 = r0.readUnsignedShort(r2)
            if (r2 < 0) goto L_0x0424
            r7 = r33
            if (r2 >= r7) goto L_0x0426
            int r15 = r21 + r2
            byte r6 = r32[r15]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r8 = 187(0xbb, float:2.62E-43)
            if (r6 != r8) goto L_0x0426
            r0.readLabel(r2, r5)
            goto L_0x0426
        L_0x0424:
            r7 = r33
        L_0x0426:
            int r1 = r1 + 1
            r33 = r7
            goto L_0x03fe
        L_0x042b:
            r7 = r33
            r1 = r10
            goto L_0x0432
        L_0x042f:
            r7 = r33
            r1 = 0
        L_0x0432:
            r15 = r21
            r8 = 0
            r11 = 0
        L_0x0436:
            r6 = r19
            if (r15 >= r6) goto L_0x0a14
            int r4 = r15 - r21
            r2 = r5[r4]
            r19 = r1
            if (r2 == 0) goto L_0x0469
            org.objectweb.asm.Label r1 = r2.k
            r33 = r1
            r1 = 0
            r2.k = r1
            r9.visitLabel(r2)
            int r1 = r10.f6197b
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0469
            int r1 = r2.f6231b
            if (r1 <= 0) goto L_0x0469
            r9.visitLineNumber(r1, r2)
            r1 = r33
        L_0x045b:
            if (r1 == 0) goto L_0x0469
            r33 = r3
            int r3 = r1.f6231b
            r9.visitLineNumber(r3, r2)
            org.objectweb.asm.Label r1 = r1.k
            r3 = r33
            goto L_0x045b
        L_0x0469:
            r33 = r3
            r3 = r19
            r2 = r33
        L_0x046f:
            if (r3 == 0) goto L_0x0508
            int r1 = r3.o
            r19 = r6
            r6 = -1
            if (r1 == r4) goto L_0x047a
            if (r1 != r6) goto L_0x050a
        L_0x047a:
            int r1 = r3.o
            if (r1 == r6) goto L_0x04d4
            r1 = r22
            if (r1 == 0) goto L_0x04b3
            if (r14 == 0) goto L_0x0485
            goto L_0x04b3
        L_0x0485:
            int r6 = r3.p
            r22 = r4
            int r4 = r3.r
            r33 = r5
            java.lang.Object[] r5 = r3.s
            r34 = r8
            int r8 = r3.t
            r35 = r11
            java.lang.Object[] r11 = r3.u
            r36 = r12
            r12 = r1
            r1 = r46
            r37 = r13
            r13 = r2
            r2 = r6
            r6 = r3
            r18 = r7
            r7 = 1
            r3 = r4
            r7 = r22
            r10 = 132(0x84, float:1.85E-43)
            r4 = r5
            r22 = r33
            r5 = r8
            r8 = r6
            r6 = r11
            r1.visitFrame(r2, r3, r4, r5, r6)
            goto L_0x04e7
        L_0x04b3:
            r22 = r5
            r18 = r7
            r34 = r8
            r35 = r11
            r36 = r12
            r37 = r13
            r10 = 132(0x84, float:1.85E-43)
            r12 = r1
            r13 = r2
            r8 = r3
            r7 = r4
            r2 = -1
            int r3 = r8.q
            java.lang.Object[] r4 = r8.s
            int r5 = r8.t
            java.lang.Object[] r6 = r8.u
            r1 = r46
            r1.visitFrame(r2, r3, r4, r5, r6)
            goto L_0x04e7
        L_0x04d4:
            r18 = r7
            r34 = r8
            r35 = r11
            r36 = r12
            r37 = r13
            r12 = r22
            r10 = 132(0x84, float:1.85E-43)
            r13 = r2
            r8 = r3
            r7 = r4
            r22 = r5
        L_0x04e7:
            if (r20 <= 0) goto L_0x04f1
            int r2 = r0.a(r13, r12, r14, r8)
            int r20 = r20 + -1
            r3 = r8
            goto L_0x04f3
        L_0x04f1:
            r2 = r13
            r3 = 0
        L_0x04f3:
            r10 = r47
            r4 = r7
            r7 = r18
            r6 = r19
            r5 = r22
            r8 = r34
            r11 = r35
            r13 = r37
            r22 = r12
            r12 = r36
            goto L_0x046f
        L_0x0508:
            r19 = r6
        L_0x050a:
            r18 = r7
            r34 = r8
            r35 = r11
            r36 = r12
            r37 = r13
            r12 = r22
            r10 = 132(0x84, float:1.85E-43)
            r13 = r2
            r8 = r3
            r7 = r4
            r22 = r5
            byte r1 = r32[r15]
            r11 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = org.objectweb.asm.ClassWriter.f6190a
            byte r1 = r1[r11]
            switch(r1) {
                case 0: goto L_0x090f;
                case 1: goto L_0x08f7;
                case 2: goto L_0x08dd;
                case 3: goto L_0x08c5;
                case 4: goto L_0x089b;
                case 5: goto L_0x0883;
                case 6: goto L_0x0832;
                case 7: goto L_0x0832;
                case 8: goto L_0x06ae;
                case 9: goto L_0x0690;
                case 10: goto L_0x0677;
                case 11: goto L_0x065f;
                case 12: goto L_0x0649;
                case 13: goto L_0x0624;
                case 14: goto L_0x05e9;
                case 15: goto L_0x0571;
                case 16: goto L_0x0528;
                case 17: goto L_0x0544;
                default: goto L_0x0528;
            }
        L_0x0528:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            int r1 = r15 + 1
            java.lang.String r1 = r0.readClass(r1, r10)
            int r2 = r15 + 3
            byte r2 = r32[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            goto L_0x0923
        L_0x0544:
            int r1 = r15 + 1
            byte r1 = r32[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            if (r1 != r10) goto L_0x055e
            int r1 = r15 + 2
            int r1 = r0.readUnsignedShort(r1)
            int r2 = r15 + 4
            short r2 = r0.readShort(r2)
            r9.visitIincInsn(r1, r2)
            int r15 = r15 + 6
            goto L_0x0569
        L_0x055e:
            int r2 = r15 + 2
            int r2 = r0.readUnsignedShort(r2)
            r9.visitVarInsn(r1, r2)
            int r15 = r15 + 4
        L_0x0569:
            r33 = r8
            r38 = r12
            r16 = 8
            goto L_0x0639
        L_0x0571:
            int r15 = r15 + 4
            r1 = r7 & 3
            int r15 = r15 - r1
            int r1 = r0.readInt(r15)
            int r1 = r1 + r7
            int r2 = r15 + 4
            int r2 = r0.readInt(r2)
            int[] r3 = new int[r2]
            org.objectweb.asm.Label[] r4 = new org.objectweb.asm.Label[r2]
            r16 = 8
            int r15 = r15 + 8
            r5 = 0
        L_0x058a:
            if (r5 >= r2) goto L_0x05a2
            int r6 = r0.readInt(r15)
            r3[r5] = r6
            int r6 = r15 + 4
            int r6 = r0.readInt(r6)
            int r6 = r6 + r7
            r6 = r22[r6]
            r4[r5] = r6
            int r15 = r15 + 8
            int r5 = r5 + 1
            goto L_0x058a
        L_0x05a2:
            r1 = r22[r1]
            r5 = r9
            org.objectweb.asm.MethodWriter r5 = (org.objectweb.asm.MethodWriter) r5
            org.objectweb.asm.ByteVector r6 = r5.r
            int r11 = r6.f6185b
            r5.Y = r11
            r10 = 171(0xab, float:2.4E-43)
            r6.putByte(r10)
            org.objectweb.asm.ByteVector r6 = r5.r
            int r10 = r6.f6185b
            int r10 = r10 % 4
            int r10 = 4 - r10
            int r10 = r10 % 4
            r33 = r8
            r38 = r12
            r8 = 0
            r12 = 0
            r6.putByteArray(r8, r12, r10)
            org.objectweb.asm.ByteVector r6 = r5.r
            r8 = 1
            r1.a(r6, r11, r8)
            org.objectweb.asm.ByteVector r6 = r5.r
            r6.putInt(r2)
            r6 = 0
        L_0x05d1:
            if (r6 >= r2) goto L_0x05e5
            org.objectweb.asm.ByteVector r10 = r5.r
            r12 = r3[r6]
            r10.putInt(r12)
            r10 = r4[r6]
            org.objectweb.asm.ByteVector r12 = r5.r
            r10.a(r12, r11, r8)
            int r6 = r6 + 1
            r8 = 1
            goto L_0x05d1
        L_0x05e5:
            r5.a(r1, r4)
            goto L_0x0639
        L_0x05e9:
            r33 = r8
            r38 = r12
            r16 = 8
            int r15 = r15 + 4
            r1 = r7 & 3
            int r15 = r15 - r1
            int r1 = r0.readInt(r15)
            int r1 = r1 + r7
            int r2 = r15 + 4
            int r2 = r0.readInt(r2)
            int r3 = r15 + 8
            int r3 = r0.readInt(r3)
            int r4 = r3 - r2
            r5 = 1
            int r4 = r4 + r5
            org.objectweb.asm.Label[] r5 = new org.objectweb.asm.Label[r4]
            int r15 = r15 + 12
            r6 = 0
        L_0x060e:
            if (r6 >= r4) goto L_0x061e
            int r8 = r0.readInt(r15)
            int r8 = r8 + r7
            r8 = r22[r8]
            r5[r6] = r8
            int r15 = r15 + 4
            int r6 = r6 + 1
            goto L_0x060e
        L_0x061e:
            r1 = r22[r1]
            r9.visitTableSwitchInsn(r2, r3, r1, r5)
            goto L_0x0639
        L_0x0624:
            r33 = r8
            r38 = r12
            r16 = 8
            int r1 = r15 + 1
            byte r1 = r32[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r2 = r15 + 2
            byte r2 = r32[r2]
            r9.visitIincInsn(r1, r2)
            int r15 = r15 + 3
        L_0x0639:
            r41 = r7
            r40 = r14
            r11 = r24
            r1 = r28
            r10 = r31
            r8 = r34
            r31 = r13
            goto L_0x095d
        L_0x0649:
            r33 = r8
            r38 = r12
            r16 = 8
            int r1 = r15 + 1
            int r1 = r0.readUnsignedShort(r1)
            r10 = r31
            java.lang.Object r1 = r0.readConst(r1, r10)
            r9.visitLdcInsn(r1)
            goto L_0x06a4
        L_0x065f:
            r33 = r8
            r38 = r12
            r10 = r31
            r16 = 8
            int r1 = r15 + 1
            byte r1 = r32[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            java.lang.Object r1 = r0.readConst(r1, r10)
            r9.visitLdcInsn(r1)
            int r15 = r15 + 2
            goto L_0x06a6
        L_0x0677:
            r33 = r8
            r38 = r12
            r10 = r31
            r16 = 8
            int r11 = r11 + -33
            int r1 = r15 + 1
            int r1 = r0.readInt(r1)
            int r1 = r1 + r7
            r1 = r22[r1]
            r9.visitJumpInsn(r11, r1)
            int r15 = r15 + 5
            goto L_0x06a6
        L_0x0690:
            r33 = r8
            r38 = r12
            r10 = r31
            r16 = 8
            int r1 = r15 + 1
            short r1 = r0.readShort(r1)
            int r1 = r1 + r7
            r1 = r22[r1]
            r9.visitJumpInsn(r11, r1)
        L_0x06a4:
            int r15 = r15 + 3
        L_0x06a6:
            r41 = r7
            r31 = r13
            r40 = r14
            goto L_0x0957
        L_0x06ae:
            r33 = r8
            r38 = r12
            r10 = r31
            r16 = 8
            int[] r1 = r0.f6186a
            int r2 = r15 + 1
            int r2 = r0.readUnsignedShort(r2)
            r1 = r1[r2]
            r12 = r47
            r8 = 132(0x84, float:1.85E-43)
            int[] r2 = r12.f6199d
            int r3 = r0.readUnsignedShort(r1)
            r2 = r2[r3]
            int r3 = r0.readUnsignedShort(r2)
            java.lang.Object r3 = r0.readConst(r3, r10)
            org.objectweb.asm.Handle r3 = (org.objectweb.asm.Handle) r3
            int r4 = r2 + 2
            int r4 = r0.readUnsignedShort(r4)
            java.lang.Object[] r5 = new java.lang.Object[r4]
            int r2 = r2 + 4
            r6 = 0
        L_0x06e1:
            if (r6 >= r4) goto L_0x06f2
            int r11 = r0.readUnsignedShort(r2)
            java.lang.Object r11 = r0.readConst(r11, r10)
            r5[r6] = r11
            int r2 = r2 + 2
            int r6 = r6 + 1
            goto L_0x06e1
        L_0x06f2:
            int[] r2 = r0.f6186a
            int r1 = r1 + 2
            int r1 = r0.readUnsignedShort(r1)
            r1 = r2[r1]
            java.lang.String r2 = r0.readUTF8(r1, r10)
            int r1 = r1 + 2
            java.lang.String r1 = r0.readUTF8(r1, r10)
            r6 = r9
            org.objectweb.asm.MethodWriter r6 = (org.objectweb.asm.MethodWriter) r6
            org.objectweb.asm.ByteVector r11 = r6.r
            int r11 = r11.f6185b
            r6.Y = r11
            org.objectweb.asm.ClassWriter r11 = r6.f6236b
            org.objectweb.asm.ByteVector r8 = r11.A
            if (r8 != 0) goto L_0x071c
            org.objectweb.asm.ByteVector r8 = new org.objectweb.asm.ByteVector
            r8.<init>()
            r11.A = r8
        L_0x071c:
            r31 = r13
            int r13 = r8.f6185b
            int r39 = r3.hashCode()
            r40 = r14
            int r14 = r3.f6216a
            java.lang.String r12 = r3.f6217b
            r41 = r7
            java.lang.String r7 = r3.f6218c
            java.lang.String r3 = r3.f6219d
            org.objectweb.asm.Item r3 = r11.a(r14, r12, r7, r3)
            int r3 = r3.f6226a
            r8.putShort(r3)
            r8.putShort(r4)
            r3 = 0
        L_0x073d:
            if (r3 >= r4) goto L_0x0753
            r7 = r5[r3]
            int r12 = r7.hashCode()
            r39 = r39 ^ r12
            org.objectweb.asm.Item r7 = r11.a(r7)
            int r7 = r7.f6226a
            r8.putShort(r7)
            int r3 = r3 + 1
            goto L_0x073d
        L_0x0753:
            byte[] r3 = r8.f6184a
            int r4 = r4 + 2
            r5 = 1
            int r4 = r4 << r5
            r5 = 2147483647(0x7fffffff, float:NaN)
            r7 = r39 & r5
            org.objectweb.asm.Item[] r12 = r11.f6194e
            int r14 = r12.length
            int r14 = r7 % r14
            r12 = r12[r14]
        L_0x0765:
            r14 = 33
            if (r12 == 0) goto L_0x0797
            int r5 = r12.f6227b
            if (r5 != r14) goto L_0x078d
            int r5 = r12.j
            if (r5 == r7) goto L_0x0772
            goto L_0x078d
        L_0x0772:
            int r5 = r12.f6228c
            r14 = 0
        L_0x0775:
            if (r14 >= r4) goto L_0x0797
            int r42 = r13 + r14
            r43 = r4
            byte r4 = r3[r42]
            int r42 = r5 + r14
            r44 = r5
            byte r5 = r3[r42]
            if (r4 == r5) goto L_0x0786
            goto L_0x078f
        L_0x0786:
            int r14 = r14 + 1
            r4 = r43
            r5 = r44
            goto L_0x0775
        L_0x078d:
            r43 = r4
        L_0x078f:
            org.objectweb.asm.Item r12 = r12.k
            r4 = r43
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0765
        L_0x0797:
            if (r12 == 0) goto L_0x079e
            int r3 = r12.f6226a
            r8.f6185b = r13
            goto L_0x07b4
        L_0x079e:
            int r3 = r11.z
            int r4 = r3 + 1
            r11.z = r4
            org.objectweb.asm.Item r4 = new org.objectweb.asm.Item
            r4.<init>(r3)
            r5 = 33
            r4.f6227b = r5
            r4.f6228c = r13
            r4.j = r7
            r11.b(r4)
        L_0x07b4:
            org.objectweb.asm.Item r4 = r11.i
            r5 = 18
            r4.f6227b = r5
            long r7 = (long) r3
            r4.f6229d = r7
            r4.g = r2
            r4.h = r1
            int r7 = r2.hashCode()
            int r7 = r7 * r3
            java.lang.String r8 = r4.h
            int r8 = r8.hashCode()
            int r8 = r8 * r7
            int r8 = r8 + r5
            r7 = 2147483647(0x7fffffff, float:NaN)
            r7 = r7 & r8
            r4.j = r7
            org.objectweb.asm.Item r4 = r11.i
            org.objectweb.asm.Item r4 = r11.a(r4)
            if (r4 != 0) goto L_0x07f5
            int r2 = r11.newNameType(r2, r1)
            r11.a(r5, r3, r2)
            org.objectweb.asm.Item r4 = new org.objectweb.asm.Item
            int r2 = r11.f6192c
            int r3 = r2 + 1
            r11.f6192c = r3
            org.objectweb.asm.Item r3 = r11.i
            r4.<init>(r2, r3)
            r11.b(r4)
        L_0x07f5:
            int r2 = r4.f6228c
            org.objectweb.asm.Label r3 = r6.P
            r5 = 186(0xba, float:2.6E-43)
            if (r3 == 0) goto L_0x0824
            int r7 = r6.M
            if (r7 != 0) goto L_0x080a
            org.objectweb.asm.Frame r1 = r3.h
            org.objectweb.asm.ClassWriter r2 = r6.f6236b
            r3 = 0
            r1.a(r5, r3, r2, r4)
            goto L_0x0824
        L_0x080a:
            if (r2 != 0) goto L_0x0812
            int r2 = org.objectweb.asm.Type.getArgumentsAndReturnSizes(r1)
            r4.f6228c = r2
        L_0x0812:
            int r1 = r6.Q
            int r3 = r2 >> 2
            int r1 = r1 - r3
            r2 = r2 & 3
            int r1 = r1 + r2
            r2 = 1
            int r1 = r1 + r2
            int r2 = r6.R
            if (r1 <= r2) goto L_0x0822
            r6.R = r1
        L_0x0822:
            r6.Q = r1
        L_0x0824:
            org.objectweb.asm.ByteVector r1 = r6.r
            int r2 = r4.f6226a
            r1.b(r5, r2)
            org.objectweb.asm.ByteVector r1 = r6.r
            r2 = 0
            r1.putShort(r2)
            goto L_0x087f
        L_0x0832:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            int[] r1 = r0.f6186a
            int r2 = r15 + 1
            int r2 = r0.readUnsignedShort(r2)
            r1 = r1[r2]
            int r2 = r1 + -1
            byte r2 = r32[r2]
            r3 = 11
            if (r2 != r3) goto L_0x0854
            r6 = 1
            goto L_0x0855
        L_0x0854:
            r6 = 0
        L_0x0855:
            java.lang.String r3 = r0.readClass(r1, r10)
            int[] r2 = r0.f6186a
            int r1 = r1 + 2
            int r1 = r0.readUnsignedShort(r1)
            r1 = r2[r1]
            java.lang.String r4 = r0.readUTF8(r1, r10)
            int r1 = r1 + 2
            java.lang.String r5 = r0.readUTF8(r1, r10)
            r1 = 182(0xb6, float:2.55E-43)
            if (r11 >= r1) goto L_0x0875
            r9.visitFieldInsn(r11, r3, r4, r5)
            goto L_0x087b
        L_0x0875:
            r1 = r46
            r2 = r11
            r1.visitMethodInsn(r2, r3, r4, r5, r6)
        L_0x087b:
            r1 = 185(0xb9, float:2.59E-43)
            if (r11 != r1) goto L_0x08f4
        L_0x087f:
            int r15 = r15 + 5
            goto L_0x0957
        L_0x0883:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            int r1 = r15 + 1
            java.lang.String r1 = r0.readClass(r1, r10)
            r9.visitTypeInsn(r11, r1)
            goto L_0x08f4
        L_0x089b:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            r1 = 54
            if (r11 <= r1) goto L_0x08b9
            int r11 = r11 + -59
            int r2 = r11 >> 2
            int r2 = r2 + r1
            r1 = r11 & 3
            r9.visitVarInsn(r2, r1)
            goto L_0x0920
        L_0x08b9:
            int r11 = r11 + -26
            int r1 = r11 >> 2
            int r1 = r1 + 21
            r2 = r11 & 3
            r9.visitVarInsn(r1, r2)
            goto L_0x0920
        L_0x08c5:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            int r1 = r15 + 1
            byte r1 = r32[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r9.visitVarInsn(r11, r1)
            goto L_0x090c
        L_0x08dd:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            int r1 = r15 + 1
            short r1 = r0.readShort(r1)
            r9.visitIntInsn(r11, r1)
        L_0x08f4:
            int r15 = r15 + 3
            goto L_0x0957
        L_0x08f7:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            int r1 = r15 + 1
            byte r1 = r32[r1]
            r9.visitIntInsn(r11, r1)
        L_0x090c:
            int r15 = r15 + 2
            goto L_0x0957
        L_0x090f:
            r41 = r7
            r33 = r8
            r38 = r12
            r40 = r14
            r10 = r31
            r16 = 8
            r31 = r13
            r9.visitInsn(r11)
        L_0x0920:
            int r15 = r15 + 1
            goto L_0x0957
        L_0x0923:
            r3 = r9
            org.objectweb.asm.MethodWriter r3 = (org.objectweb.asm.MethodWriter) r3
            org.objectweb.asm.ByteVector r4 = r3.r
            int r4 = r4.f6185b
            r3.Y = r4
            org.objectweb.asm.ClassWriter r4 = r3.f6236b
            org.objectweb.asm.Item r1 = r4.a(r1)
            org.objectweb.asm.Label r4 = r3.P
            r5 = 197(0xc5, float:2.76E-43)
            if (r4 == 0) goto L_0x094b
            int r6 = r3.M
            if (r6 != 0) goto L_0x0944
            org.objectweb.asm.Frame r4 = r4.h
            org.objectweb.asm.ClassWriter r6 = r3.f6236b
            r4.a(r5, r2, r6, r1)
            goto L_0x094b
        L_0x0944:
            int r4 = r3.Q
            int r6 = 1 - r2
            int r6 = r6 + r4
            r3.Q = r6
        L_0x094b:
            org.objectweb.asm.ByteVector r3 = r3.r
            int r1 = r1.f6226a
            r3.b(r5, r1)
            r3.putByte(r2)
            int r15 = r15 + 4
        L_0x0957:
            r11 = r24
            r1 = r28
            r8 = r34
        L_0x095d:
            if (r11 == 0) goto L_0x09a6
            int r2 = r11.length
            if (r8 >= r2) goto L_0x09a6
            r2 = r41
            if (r1 > r2) goto L_0x09a3
            if (r1 != r2) goto L_0x0983
            r1 = r11[r8]
            r12 = r47
            int r1 = r0.a(r12, r1)
            int r3 = r1 + 2
            int r4 = r12.i
            org.objectweb.asm.TypePath r5 = r12.j
            java.lang.String r1 = r0.readUTF8(r1, r10)
            r6 = 1
            org.objectweb.asm.AnnotationWriter r1 = r9.visitInsnAnnotation(r4, r5, r1, r6)
            r0.a(r3, r10, r6, r1)
            goto L_0x0985
        L_0x0983:
            r12 = r47
        L_0x0985:
            int r8 = r8 + 1
            int r1 = r11.length
            if (r8 >= r1) goto L_0x099f
            r1 = r11[r8]
            int r1 = r0.readByte(r1)
            r3 = 67
            if (r1 >= r3) goto L_0x0995
            goto L_0x099f
        L_0x0995:
            r1 = r11[r8]
            r3 = 1
            int r1 = r1 + r3
            int r6 = r0.readUnsignedShort(r1)
            r1 = r6
            goto L_0x09a0
        L_0x099f:
            r1 = -1
        L_0x09a0:
            r41 = r2
            goto L_0x095d
        L_0x09a3:
            r12 = r47
            goto L_0x09aa
        L_0x09a6:
            r12 = r47
            r2 = r41
        L_0x09aa:
            r13 = r25
            r4 = r29
            r3 = r35
        L_0x09b0:
            if (r13 == 0) goto L_0x09f2
            int r5 = r13.length
            if (r3 >= r5) goto L_0x09f2
            if (r4 > r2) goto L_0x09f2
            if (r4 != r2) goto L_0x09d3
            r4 = r13[r3]
            int r4 = r0.a(r12, r4)
            int r5 = r4 + 2
            int r6 = r12.i
            org.objectweb.asm.TypePath r7 = r12.j
            java.lang.String r4 = r0.readUTF8(r4, r10)
            r14 = 0
            org.objectweb.asm.AnnotationWriter r4 = r9.visitInsnAnnotation(r6, r7, r4, r14)
            r6 = 1
            r0.a(r5, r10, r6, r4)
            goto L_0x09d4
        L_0x09d3:
            r14 = 0
        L_0x09d4:
            int r3 = r3 + 1
            int r4 = r13.length
            if (r3 >= r4) goto L_0x09ed
            r4 = r13[r3]
            int r4 = r0.readByte(r4)
            r5 = 67
            if (r4 >= r5) goto L_0x09e4
            goto L_0x09ef
        L_0x09e4:
            r4 = r13[r3]
            r7 = 1
            int r4 = r4 + r7
            int r4 = r0.readUnsignedShort(r4)
            goto L_0x09b0
        L_0x09ed:
            r5 = 67
        L_0x09ef:
            r7 = 1
            r4 = -1
            goto L_0x09b0
        L_0x09f2:
            r5 = 67
            r7 = 1
            r14 = 0
            r28 = r1
            r29 = r4
            r24 = r11
            r25 = r13
            r7 = r18
            r5 = r22
            r1 = r33
            r13 = r37
            r22 = r38
            r14 = r40
            r11 = r3
            r3 = r31
            r31 = r10
            r10 = r12
            r12 = r36
            goto L_0x0436
        L_0x0a14:
            r22 = r5
            r18 = r7
            r36 = r12
            r37 = r13
            r11 = r24
            r13 = r25
            r7 = 1
            r14 = 0
            r12 = r10
            r10 = r31
            r1 = r22[r18]
            if (r1 == 0) goto L_0x0a2e
            r1 = r22[r18]
            r9.visitLabel(r1)
        L_0x0a2e:
            int r1 = r12.f6197b
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0ac7
            r1 = r26
            if (r1 == 0) goto L_0x0ac7
            r2 = r27
            if (r2 == 0) goto L_0x0a66
            int r27 = r2 + 2
            int r2 = r0.readUnsignedShort(r2)
            int r2 = r2 * 3
            int[] r3 = new int[r2]
            r4 = r27
        L_0x0a48:
            if (r2 <= 0) goto L_0x0a64
            int r2 = r2 + -1
            int r5 = r4 + 6
            r3[r2] = r5
            r5 = -1
            int r2 = r2 + r5
            int r6 = r4 + 8
            int r6 = r0.readUnsignedShort(r6)
            r3[r2] = r6
            int r2 = r2 + r5
            int r6 = r0.readUnsignedShort(r4)
            r3[r2] = r6
            int r4 = r4 + 10
            goto L_0x0a48
        L_0x0a64:
            r8 = r3
            goto L_0x0a67
        L_0x0a66:
            r8 = 0
        L_0x0a67:
            int r26 = r1 + 2
            int r1 = r0.readUnsignedShort(r1)
            r15 = r1
            r6 = r26
        L_0x0a70:
            if (r15 <= 0) goto L_0x0ac7
            int r1 = r0.readUnsignedShort(r6)
            int r2 = r6 + 2
            int r2 = r0.readUnsignedShort(r2)
            int r3 = r6 + 8
            int r5 = r0.readUnsignedShort(r3)
            if (r8 == 0) goto L_0x0a9f
            r3 = 0
        L_0x0a85:
            int r4 = r8.length
            if (r3 >= r4) goto L_0x0a9f
            r4 = r8[r3]
            if (r4 != r1) goto L_0x0a9c
            int r4 = r3 + 1
            r4 = r8[r4]
            if (r4 != r5) goto L_0x0a9c
            int r3 = r3 + 2
            r3 = r8[r3]
            java.lang.String r3 = r0.readUTF8(r3, r10)
            r4 = r3
            goto L_0x0aa0
        L_0x0a9c:
            int r3 = r3 + 3
            goto L_0x0a85
        L_0x0a9f:
            r4 = 0
        L_0x0aa0:
            int r3 = r6 + 4
            java.lang.String r3 = r0.readUTF8(r3, r10)
            int r7 = r6 + 6
            java.lang.String r7 = r0.readUTF8(r7, r10)
            r16 = r22[r1]
            int r1 = r1 + r2
            r17 = r22[r1]
            r1 = r46
            r2 = r3
            r3 = r7
            r7 = r5
            r5 = r16
            r26 = r6
            r6 = r17
            r14 = 1
            r1.visitLocalVariable(r2, r3, r4, r5, r6, r7)
            int r6 = r26 + 10
            int r15 = r15 + -1
            r7 = 1
            r14 = 0
            goto L_0x0a70
        L_0x0ac7:
            r14 = 1
            r15 = 32
            if (r11 == 0) goto L_0x0b09
            r8 = 0
        L_0x0acd:
            int r1 = r11.length
            if (r8 >= r1) goto L_0x0b09
            r1 = r11[r8]
            int r1 = r0.readByte(r1)
            int r1 = r1 >> r14
            if (r1 != r15) goto L_0x0b02
            r1 = r11[r8]
            int r1 = r0.a(r12, r1)
            int r7 = r1 + 2
            int r2 = r12.i
            org.objectweb.asm.TypePath r3 = r12.j
            org.objectweb.asm.Label[] r4 = r12.l
            org.objectweb.asm.Label[] r5 = r12.m
            int[] r6 = r12.n
            java.lang.String r16 = r0.readUTF8(r1, r10)
            r18 = 1
            r1 = r46
            r15 = r7
            r7 = r16
            r16 = r8
            r8 = r18
            org.objectweb.asm.AnnotationWriter r1 = r1.visitLocalVariableAnnotation(r2, r3, r4, r5, r6, r7, r8)
            r0.a(r15, r10, r14, r1)
            goto L_0x0b04
        L_0x0b02:
            r16 = r8
        L_0x0b04:
            int r8 = r16 + 1
            r15 = 32
            goto L_0x0acd
        L_0x0b09:
            if (r13 == 0) goto L_0x0b41
            r11 = 0
        L_0x0b0c:
            int r1 = r13.length
            if (r11 >= r1) goto L_0x0b41
            r1 = r13[r11]
            int r1 = r0.readByte(r1)
            int r1 = r1 >> r14
            r15 = 32
            if (r1 != r15) goto L_0x0b3e
            r1 = r13[r11]
            int r1 = r0.a(r12, r1)
            int r8 = r1 + 2
            int r2 = r12.i
            org.objectweb.asm.TypePath r3 = r12.j
            org.objectweb.asm.Label[] r4 = r12.l
            org.objectweb.asm.Label[] r5 = r12.m
            int[] r6 = r12.n
            java.lang.String r7 = r0.readUTF8(r1, r10)
            r16 = 0
            r1 = r46
            r15 = r8
            r8 = r16
            org.objectweb.asm.AnnotationWriter r1 = r1.visitLocalVariableAnnotation(r2, r3, r4, r5, r6, r7, r8)
            r0.a(r15, r10, r14, r1)
        L_0x0b3e:
            int r11 = r11 + 1
            goto L_0x0b0c
        L_0x0b41:
            r1 = r23
        L_0x0b43:
            if (r1 == 0) goto L_0x0b55
            org.objectweb.asm.Attribute r2 = r1.f6182a
            r3 = 0
            r1.f6182a = r3
            r4 = r9
            org.objectweb.asm.MethodWriter r4 = (org.objectweb.asm.MethodWriter) r4
            org.objectweb.asm.Attribute r5 = r4.q
            r1.f6182a = r5
            r4.q = r1
            r1 = r2
            goto L_0x0b43
        L_0x0b55:
            r1 = r36
            r2 = r37
            r9.visitMaxs(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.a(org.objectweb.asm.MethodVisitor, org.objectweb.asm.Context, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] a(org.objectweb.asm.MethodVisitor r21, org.objectweb.asm.Context r22, int r23, boolean r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r2 = r23
            char[] r3 = r1.f6198c
            int r4 = r0.readUnsignedShort(r2)
            int[] r5 = new int[r4]
            int r2 = r2 + 2
            r6 = 0
            r7 = 0
        L_0x0012:
            if (r7 >= r4) goto L_0x00cc
            r5[r7] = r2
            int r8 = r0.readInt(r2)
            int r9 = r8 >>> 24
            r10 = 1
            if (r9 == 0) goto L_0x005d
            if (r9 == r10) goto L_0x005d
            r11 = 64
            if (r9 == r11) goto L_0x0036
            r11 = 65
            if (r9 == r11) goto L_0x0036
            switch(r9) {
                case 19: goto L_0x0030;
                case 20: goto L_0x0030;
                case 21: goto L_0x0030;
                case 22: goto L_0x005d;
                default: goto L_0x002c;
            }
        L_0x002c:
            switch(r9) {
                case 71: goto L_0x0033;
                case 72: goto L_0x0033;
                case 73: goto L_0x0033;
                case 74: goto L_0x0033;
                case 75: goto L_0x0033;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x005a
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x005f
        L_0x0033:
            int r2 = r2 + 4
            goto L_0x005f
        L_0x0036:
            int r11 = r2 + 1
            int r11 = r0.readUnsignedShort(r11)
        L_0x003c:
            if (r11 <= 0) goto L_0x005a
            int r12 = r2 + 3
            int r12 = r0.readUnsignedShort(r12)
            int r13 = r2 + 5
            int r13 = r0.readUnsignedShort(r13)
            org.objectweb.asm.Label[] r14 = r1.h
            r0.readLabel(r12, r14)
            int r12 = r12 + r13
            org.objectweb.asm.Label[] r13 = r1.h
            r0.readLabel(r12, r13)
            int r2 = r2 + 6
            int r11 = r11 + -1
            goto L_0x003c
        L_0x005a:
            int r2 = r2 + 3
            goto L_0x005f
        L_0x005d:
            int r2 = r2 + 2
        L_0x005f:
            int r11 = r0.readByte(r2)
            r12 = 66
            r13 = 0
            if (r9 != r12) goto L_0x00bf
            if (r11 != 0) goto L_0x006c
            r9 = r13
            goto L_0x0073
        L_0x006c:
            org.objectweb.asm.TypePath r9 = new org.objectweb.asm.TypePath
            byte[] r12 = r0.f6187b
            r9.<init>(r12, r2)
        L_0x0073:
            r12 = 2
            int r2 = com.android.tools.r8.GeneratedOutlineSupport.outline7(r11, r12, r10, r2)
            int r11 = r2 + 2
            java.lang.String r2 = r0.readUTF8(r2, r3)
            r12 = r21
            org.objectweb.asm.MethodWriter r12 = (org.objectweb.asm.MethodWriter) r12
            if (r12 == 0) goto L_0x00be
            org.objectweb.asm.ByteVector r13 = new org.objectweb.asm.ByteVector
            r13.<init>()
            org.objectweb.asm.AnnotationWriter.a(r8, r9, r13)
            org.objectweb.asm.ClassWriter r8 = r12.f6236b
            int r2 = r8.newUTF8(r2)
            r13.putShort(r2)
            r13.putShort(r6)
            org.objectweb.asm.AnnotationWriter r2 = new org.objectweb.asm.AnnotationWriter
            org.objectweb.asm.ClassWriter r15 = r12.f6236b
            int r8 = r13.f6185b
            int r19 = r8 + -2
            r16 = 1
            r14 = r2
            r17 = r13
            r18 = r13
            r14.<init>(r15, r16, r17, r18, r19)
            if (r24 == 0) goto L_0x00b3
            org.objectweb.asm.AnnotationWriter r8 = r12.W
            r2.g = r8
            r12.W = r2
            goto L_0x00b9
        L_0x00b3:
            org.objectweb.asm.AnnotationWriter r8 = r12.X
            r2.g = r8
            r12.X = r2
        L_0x00b9:
            int r2 = r0.a(r11, r3, r10, r2)
            goto L_0x00c8
        L_0x00be:
            throw r13
        L_0x00bf:
            int r2 = r2 + 3
            int r11 = r11 * 2
            int r11 = r11 + r2
            int r2 = r0.a(r11, r3, r10, r13)
        L_0x00c8:
            int r7 = r7 + 1
            goto L_0x0012
        L_0x00cc:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.a(org.objectweb.asm.MethodVisitor, org.objectweb.asm.Context, int, boolean):int[]");
    }
}
