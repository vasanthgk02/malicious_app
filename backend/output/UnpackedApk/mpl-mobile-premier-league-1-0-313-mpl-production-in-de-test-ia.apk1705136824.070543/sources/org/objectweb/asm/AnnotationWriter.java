package org.objectweb.asm;

public final class AnnotationWriter {

    /* renamed from: a  reason: collision with root package name */
    public final ClassWriter f6176a;

    /* renamed from: b  reason: collision with root package name */
    public int f6177b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6178c;

    /* renamed from: d  reason: collision with root package name */
    public final ByteVector f6179d;

    /* renamed from: e  reason: collision with root package name */
    public final ByteVector f6180e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6181f;
    public AnnotationWriter g;
    public AnnotationWriter h;

    public AnnotationWriter(ClassWriter classWriter, boolean z, ByteVector byteVector, ByteVector byteVector2, int i) {
        this.f6176a = classWriter;
        this.f6178c = z;
        this.f6179d = byteVector;
        this.f6180e = byteVector2;
        this.f6181f = i;
    }

    public static void a(int i, TypePath typePath, ByteVector byteVector) {
        int i2 = i >>> 24;
        if (!(i2 == 0 || i2 == 1)) {
            switch (i2) {
                case 19:
                case 20:
                case 21:
                    byteVector.putByte(i2);
                    break;
                case 22:
                    break;
                default:
                    switch (i2) {
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            byteVector.putInt(i);
                            break;
                        default:
                            byteVector.b(i2, (i & 16776960) >> 8);
                            break;
                    }
            }
        }
        byteVector.putShort(i >>> 16);
        if (typePath == null) {
            byteVector.putByte(0);
            return;
        }
        byte[] bArr = typePath.f6245a;
        int i3 = typePath.f6246b;
        byteVector.putByteArray(bArr, i3, (bArr[i3] * 2) + 1);
    }

    public static void a(AnnotationWriter[] annotationWriterArr, int i, ByteVector byteVector) {
        int length = ((annotationWriterArr.length - i) * 2) + 1;
        int i2 = i;
        while (true) {
            int i3 = 0;
            if (i2 >= annotationWriterArr.length) {
                break;
            }
            if (annotationWriterArr[i2] != null) {
                i3 = annotationWriterArr[i2].a();
            }
            length += i3;
            i2++;
        }
        byteVector.putInt(length);
        byteVector.putByte(annotationWriterArr.length - i);
        while (i < annotationWriterArr.length) {
            AnnotationWriter annotationWriter = null;
            int i4 = 0;
            for (AnnotationWriter annotationWriter2 = annotationWriterArr[i]; annotationWriter2 != null; annotationWriter2 = annotationWriter2.g) {
                i4++;
                annotationWriter2.visitEnd();
                annotationWriter2.h = annotationWriter;
                annotationWriter = annotationWriter2;
            }
            byteVector.putShort(i4);
            while (annotationWriter != null) {
                ByteVector byteVector2 = annotationWriter.f6179d;
                byteVector.putByteArray(byteVector2.f6184a, 0, byteVector2.f6185b);
                annotationWriter = annotationWriter.h;
            }
            i++;
        }
    }

    public int a() {
        int i = 0;
        for (AnnotationWriter annotationWriter = this; annotationWriter != null; annotationWriter = annotationWriter.g) {
            i += annotationWriter.f6179d.f6185b;
        }
        return i;
    }

    public void a(ByteVector byteVector) {
        int i = 2;
        int i2 = 0;
        AnnotationWriter annotationWriter = null;
        for (AnnotationWriter annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.g) {
            i2++;
            i += annotationWriter2.f6179d.f6185b;
            annotationWriter2.visitEnd();
            annotationWriter2.h = annotationWriter;
            annotationWriter = annotationWriter2;
        }
        byteVector.putInt(i);
        byteVector.putShort(i2);
        while (annotationWriter != null) {
            ByteVector byteVector2 = annotationWriter.f6179d;
            byteVector.putByteArray(byteVector2.f6184a, 0, byteVector2.f6185b);
            annotationWriter = annotationWriter.h;
        }
    }

    public void visit(String str, Object obj) {
        int i;
        ByteVector byteVector;
        ClassWriter classWriter;
        String descriptor;
        int i2;
        this.f6177b++;
        if (this.f6178c) {
            this.f6179d.putShort(this.f6176a.newUTF8(str));
        }
        if (obj instanceof String) {
            byteVector = this.f6179d;
            i = 115;
            classWriter = this.f6176a;
            descriptor = (String) obj;
        } else {
            i = 66;
            if (obj instanceof Byte) {
                byteVector = this.f6179d;
                i2 = this.f6176a.a((int) ((Byte) obj).byteValue()).f6226a;
                byteVector.b(i, i2);
            } else if (obj instanceof Boolean) {
                this.f6179d.b(90, this.f6176a.a(((Boolean) obj).booleanValue() ? 1 : 0).f6226a);
                return;
            } else if (obj instanceof Character) {
                this.f6179d.b(67, this.f6176a.a((int) ((Character) obj).charValue()).f6226a);
                return;
            } else if (obj instanceof Short) {
                this.f6179d.b(83, this.f6176a.a((int) ((Short) obj).shortValue()).f6226a);
                return;
            } else if (obj instanceof Type) {
                byteVector = this.f6179d;
                i = 99;
                classWriter = this.f6176a;
                descriptor = ((Type) obj).getDescriptor();
            } else {
                int i3 = 0;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    this.f6179d.b(91, bArr.length);
                    while (i3 < bArr.length) {
                        this.f6179d.b(66, this.f6176a.a((int) bArr[i3]).f6226a);
                        i3++;
                    }
                    return;
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    this.f6179d.b(91, zArr.length);
                    while (i3 < zArr.length) {
                        this.f6179d.b(90, this.f6176a.a(zArr[i3] ? 1 : 0).f6226a);
                        i3++;
                    }
                    return;
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    this.f6179d.b(91, sArr.length);
                    while (i3 < sArr.length) {
                        this.f6179d.b(83, this.f6176a.a((int) sArr[i3]).f6226a);
                        i3++;
                    }
                    return;
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    this.f6179d.b(91, cArr.length);
                    while (i3 < cArr.length) {
                        this.f6179d.b(67, this.f6176a.a((int) cArr[i3]).f6226a);
                        i3++;
                    }
                    return;
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    this.f6179d.b(91, iArr.length);
                    while (i3 < iArr.length) {
                        this.f6179d.b(73, this.f6176a.a(iArr[i3]).f6226a);
                        i3++;
                    }
                    return;
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    this.f6179d.b(91, jArr.length);
                    while (i3 < jArr.length) {
                        this.f6179d.b(74, this.f6176a.a(jArr[i3]).f6226a);
                        i3++;
                    }
                    return;
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    this.f6179d.b(91, fArr.length);
                    while (i3 < fArr.length) {
                        this.f6179d.b(70, this.f6176a.a(fArr[i3]).f6226a);
                        i3++;
                    }
                    return;
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    this.f6179d.b(91, dArr.length);
                    while (i3 < dArr.length) {
                        this.f6179d.b(68, this.f6176a.a(dArr[i3]).f6226a);
                        i3++;
                    }
                    return;
                } else {
                    Item a2 = this.f6176a.a(obj);
                    this.f6179d.b(".s.IFJDCS".charAt(a2.f6227b), a2.f6226a);
                    return;
                }
            }
        }
        i2 = classWriter.newUTF8(descriptor);
        byteVector.b(i, i2);
    }

    public AnnotationWriter visitArray(String str) {
        this.f6177b++;
        if (this.f6178c) {
            this.f6179d.putShort(this.f6176a.newUTF8(str));
        }
        this.f6179d.b(91, 0);
        ClassWriter classWriter = this.f6176a;
        ByteVector byteVector = this.f6179d;
        AnnotationWriter annotationWriter = new AnnotationWriter(classWriter, false, byteVector, byteVector, byteVector.f6185b - 2);
        return annotationWriter;
    }

    public void visitEnd() {
        ByteVector byteVector = this.f6180e;
        if (byteVector != null) {
            byte[] bArr = byteVector.f6184a;
            int i = this.f6181f;
            int i2 = this.f6177b;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }
}
