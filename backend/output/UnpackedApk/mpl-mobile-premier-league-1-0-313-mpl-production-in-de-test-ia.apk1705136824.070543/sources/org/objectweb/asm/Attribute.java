package org.objectweb.asm;

public class Attribute {

    /* renamed from: a  reason: collision with root package name */
    public Attribute f6182a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6183b;
    public final String type;

    public Attribute(String str) {
        this.type = str;
    }

    public final int a() {
        int i = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f6182a) {
            i++;
        }
        return i;
    }

    public final int a(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f6182a) {
            classWriter.newUTF8(attribute.type);
            i4 += attribute.f6183b.length + 6;
        }
        return i4;
    }

    public Attribute read(ClassReader classReader, int i, int i2) {
        Attribute attribute = new Attribute(this.type);
        byte[] bArr = new byte[i2];
        attribute.f6183b = bArr;
        System.arraycopy(classReader.f6187b, i, bArr, 0, i2);
        return attribute;
    }

    public final void a(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3, ByteVector byteVector) {
        for (Attribute attribute = this; attribute != null; attribute = attribute.f6182a) {
            byte[] bArr2 = attribute.f6183b;
            int length = bArr2.length;
            byteVector.putShort(classWriter.newUTF8(attribute.type));
            byteVector.putInt(length);
            byteVector.putByteArray(bArr2, 0, length);
        }
    }
}
