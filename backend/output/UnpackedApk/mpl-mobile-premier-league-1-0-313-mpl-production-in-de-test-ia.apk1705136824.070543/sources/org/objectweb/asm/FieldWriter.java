package org.objectweb.asm;

public final class FieldWriter {

    /* renamed from: b  reason: collision with root package name */
    public final ClassWriter f6205b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6206c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6207d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6208e;

    /* renamed from: f  reason: collision with root package name */
    public int f6209f;
    public FieldWriter fv = null;
    public int g;
    public AnnotationWriter h;
    public AnnotationWriter i;
    public Attribute j;
    public AnnotationWriter k;
    public AnnotationWriter l;

    public FieldWriter(ClassWriter classWriter, int i2, String str, String str2, String str3, Object obj) {
        if (classWriter.B == null) {
            classWriter.B = this;
        } else {
            classWriter.C.fv = this;
        }
        classWriter.C = this;
        this.f6205b = classWriter;
        this.f6206c = i2;
        this.f6207d = classWriter.newUTF8(str);
        this.f6208e = classWriter.newUTF8(str2);
        if (str3 != null) {
            this.f6209f = classWriter.newUTF8(str3);
        }
        if (obj != null) {
            this.g = classWriter.a(obj).f6226a;
        }
    }

    public AnnotationWriter visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f6205b.newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6205b, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.g = this.h;
            this.h = annotationWriter;
        } else {
            annotationWriter.g = this.i;
            this.i = annotationWriter;
        }
        return annotationWriter;
    }

    public AnnotationWriter visitTypeAnnotation(int i2, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(i2, typePath, byteVector);
        byteVector.putShort(this.f6205b.newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6205b, true, byteVector, byteVector, byteVector.f6185b - 2);
        if (z) {
            annotationWriter.g = this.k;
            this.k = annotationWriter;
        } else {
            annotationWriter.g = this.l;
            this.l = annotationWriter;
        }
        return annotationWriter;
    }
}
