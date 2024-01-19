package org.objectweb.asm;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class ClassWriter extends ClassVisitor {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f6190a;
    public ByteVector A;
    public FieldWriter B;
    public FieldWriter C;
    public MethodWriter D;
    public MethodWriter E;
    public short G;
    public Item[] H;
    public String I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ClassReader M;
    public AnnotationWriter N;
    public AnnotationWriter O;

    /* renamed from: b  reason: collision with root package name */
    public int f6191b;

    /* renamed from: c  reason: collision with root package name */
    public int f6192c = 1;

    /* renamed from: d  reason: collision with root package name */
    public final ByteVector f6193d = new ByteVector();

    /* renamed from: e  reason: collision with root package name */
    public Item[] f6194e;

    /* renamed from: f  reason: collision with root package name */
    public int f6195f;
    public final Item g;
    public final Item h;
    public final Item i;
    public final Item j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int[] p;
    public int q;
    public ByteVector r;
    public int s;
    public int t;
    public AnnotationWriter u;
    public AnnotationWriter v;
    public Attribute w;
    public int x;
    public ByteVector y;
    public int z;

    static {
        byte[] bArr = new byte[FTPReply.SERVICE_READY];
        for (int i2 = 0; i2 < 220; i2++) {
            bArr[i2] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i2) - 'A');
        }
        f6190a = bArr;
    }

    public ClassWriter(int i2) {
        super(327680);
        boolean z2 = true;
        Item[] itemArr = new Item[256];
        this.f6194e = itemArr;
        this.f6195f = (int) (((double) itemArr.length) * 0.75d);
        this.g = new Item();
        this.h = new Item();
        this.i = new Item();
        this.j = new Item();
        this.K = (i2 & 1) != 0;
        this.J = (i2 & 2) == 0 ? false : z2;
    }

    public int a(String str, int i2) {
        Item item = this.g;
        item.f6227b = 31;
        item.f6228c = i2;
        item.g = str;
        item.j = (str.hashCode() + 31 + i2) & Integer.MAX_VALUE;
        Item a2 = a(this.g);
        if (a2 == null) {
            a2 = c();
        }
        return a2.f6226a;
    }

    public Item a(double d2) {
        Item item = this.g;
        item.f6227b = 6;
        item.f6229d = Double.doubleToRawLongBits(d2);
        item.j = Integer.MAX_VALUE & (item.f6227b + ((int) d2));
        Item a2 = a(this.g);
        if (a2 != null) {
            return a2;
        }
        ByteVector byteVector = this.f6193d;
        byteVector.putByte(6);
        byteVector.putLong(this.g.f6229d);
        Item item2 = new Item(this.f6192c, this.g);
        this.f6192c += 2;
        b(item2);
        return item2;
    }

    public Item a(String str) {
        this.h.a(7, str, null, null);
        Item a2 = a(this.h);
        if (a2 != null) {
            return a2;
        }
        this.f6193d.b(7, newUTF8(str));
        int i2 = this.f6192c;
        this.f6192c = i2 + 1;
        Item item = new Item(i2, this.h);
        b(item);
        return item;
    }

    public final void a(int i2, int i3, int i4) {
        ByteVector byteVector = this.f6193d;
        byteVector.b(i2, i3);
        byteVector.putShort(i4);
    }

    public final void b(Item item) {
        if (this.f6192c + this.G > this.f6195f) {
            int length = this.f6194e.length;
            int i2 = (length * 2) + 1;
            Item[] itemArr = new Item[i2];
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                Item item2 = this.f6194e[length];
                while (item2 != null) {
                    int i3 = item2.j % i2;
                    Item item3 = item2.k;
                    item2.k = itemArr[i3];
                    itemArr[i3] = item2;
                    item2 = item3;
                }
            }
            this.f6194e = itemArr;
            this.f6195f = (int) (((double) i2) * 0.75d);
        }
        int i4 = item.j;
        Item[] itemArr2 = this.f6194e;
        int length2 = i4 % itemArr2.length;
        item.k = itemArr2[length2];
        itemArr2[length2] = item;
    }

    public int c(String str) {
        this.g.a(30, str, null, null);
        Item a2 = a(this.g);
        if (a2 == null) {
            a2 = c();
        }
        return a2.f6226a;
    }

    public final Item c() {
        short s2 = (short) (this.G + 1);
        this.G = s2;
        Item item = new Item(s2, this.g);
        b(item);
        if (this.H == null) {
            this.H = new Item[16];
        }
        short s3 = this.G;
        Item[] itemArr = this.H;
        if (s3 == itemArr.length) {
            Item[] itemArr2 = new Item[(itemArr.length * 2)];
            System.arraycopy(itemArr, 0, itemArr2, 0, itemArr.length);
            this.H = itemArr2;
        }
        this.H[this.G] = item;
        return item;
    }

    public int newClass(String str) {
        return a(str).f6226a;
    }

    public int newNameType(String str, String str2) {
        this.h.a(12, str, str2, null);
        Item a2 = a(this.h);
        if (a2 == null) {
            a(12, newUTF8(str), newUTF8(str2));
            int i2 = this.f6192c;
            this.f6192c = i2 + 1;
            a2 = new Item(i2, this.h);
            b(a2);
        }
        return a2.f6226a;
    }

    public int newUTF8(String str) {
        this.g.a(1, str, null, null);
        Item a2 = a(this.g);
        if (a2 == null) {
            ByteVector byteVector = this.f6193d;
            byteVector.putByte(1);
            int length = str.length();
            if (length <= 65535) {
                int i2 = byteVector.f6185b;
                if (i2 + 2 + length > byteVector.f6184a.length) {
                    byteVector.a(length + 2);
                }
                byte[] bArr = byteVector.f6184a;
                int i3 = i2 + 1;
                bArr[i2] = (byte) (length >>> 8);
                int i4 = i3 + 1;
                bArr[i3] = (byte) length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        byteVector.f6185b = i4;
                        break;
                    }
                    char charAt = str.charAt(i5);
                    if (charAt < 1 || charAt > 127) {
                        byteVector.f6185b = i4;
                        byteVector.c(str, i5, 65535);
                    } else {
                        bArr[i4] = (byte) charAt;
                        i5++;
                        i4++;
                    }
                }
                int i6 = this.f6192c;
                this.f6192c = i6 + 1;
                a2 = new Item(i6, this.g);
                b(a2);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return a2.f6226a;
    }

    public byte[] toByteArray() {
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        String str6;
        int i4;
        int i5;
        ByteVector byteVector;
        String str7;
        int i6;
        String str8;
        int i7;
        int i8;
        int i9;
        ClassWriter classWriter = this;
        if (classWriter.f6192c <= 65535) {
            int i10 = (classWriter.o * 2) + 24;
            FieldWriter fieldWriter = classWriter.B;
            int i11 = 0;
            while (true) {
                str = "ConstantValue";
                if (fieldWriter == null) {
                    break;
                }
                i11++;
                if (fieldWriter.g != 0) {
                    fieldWriter.f6205b.newUTF8(str);
                    i9 = 16;
                } else {
                    i9 = 8;
                }
                int i12 = fieldWriter.f6206c;
                if ((i12 & 4096) != 0 && ((fieldWriter.f6205b.f6191b & 65535) < 49 || (i12 & 262144) != 0)) {
                    fieldWriter.f6205b.newUTF8("Synthetic");
                    i9 += 6;
                }
                if ((fieldWriter.f6206c & 131072) != 0) {
                    fieldWriter.f6205b.newUTF8("Deprecated");
                    i9 += 6;
                }
                if (fieldWriter.f6209f != 0) {
                    fieldWriter.f6205b.newUTF8("Signature");
                    i9 += 8;
                }
                if (fieldWriter.h != null) {
                    fieldWriter.f6205b.newUTF8("RuntimeVisibleAnnotations");
                    i9 = GeneratedOutlineSupport.outline12(fieldWriter.h, 8, i9);
                }
                if (fieldWriter.i != null) {
                    fieldWriter.f6205b.newUTF8("RuntimeInvisibleAnnotations");
                    i9 = GeneratedOutlineSupport.outline12(fieldWriter.i, 8, i9);
                }
                if (fieldWriter.k != null) {
                    fieldWriter.f6205b.newUTF8("RuntimeVisibleTypeAnnotations");
                    i9 = GeneratedOutlineSupport.outline12(fieldWriter.k, 8, i9);
                }
                if (fieldWriter.l != null) {
                    fieldWriter.f6205b.newUTF8("RuntimeInvisibleTypeAnnotations");
                    i9 = GeneratedOutlineSupport.outline12(fieldWriter.l, 8, i9);
                }
                Attribute attribute = fieldWriter.j;
                if (attribute != null) {
                    i9 += attribute.a(fieldWriter.f6205b, null, 0, -1, -1);
                }
                i10 += i9;
                fieldWriter = fieldWriter.fv;
            }
            MethodWriter methodWriter = classWriter.D;
            int i13 = 0;
            while (methodWriter != null) {
                int i14 = i13 + 1;
                if (methodWriter.h != 0) {
                    i8 = methodWriter.i + 6;
                    i7 = i14;
                    i6 = i11;
                    str8 = str;
                } else {
                    int i15 = methodWriter.r.f6185b;
                    if (i15 <= 0) {
                        i7 = i14;
                        i6 = i11;
                        str8 = str;
                        i8 = 8;
                    } else if (i15 <= 65536) {
                        methodWriter.f6236b.newUTF8(StandardStructureTypes.CODE);
                        i7 = i14;
                        i8 = GeneratedOutlineSupport.outline7(methodWriter.A, 8, methodWriter.r.f6185b + 18, 8);
                        if (methodWriter.E != null) {
                            methodWriter.f6236b.newUTF8("LocalVariableTable");
                            i8 += methodWriter.E.f6185b + 8;
                        }
                        if (methodWriter.G != null) {
                            methodWriter.f6236b.newUTF8("LocalVariableTypeTable");
                            i8 += methodWriter.G.f6185b + 8;
                        }
                        if (methodWriter.I != null) {
                            methodWriter.f6236b.newUTF8("LineNumberTable");
                            i8 += methodWriter.I.f6185b + 8;
                        }
                        if (methodWriter.v != null) {
                            methodWriter.f6236b.newUTF8((methodWriter.f6236b.f6191b & 65535) >= 50 ? "StackMapTable" : "StackMap");
                            i8 += methodWriter.v.f6185b + 8;
                        }
                        if (methodWriter.W != null) {
                            methodWriter.f6236b.newUTF8("RuntimeVisibleTypeAnnotations");
                            i8 = GeneratedOutlineSupport.outline12(methodWriter.W, 8, i8);
                        }
                        if (methodWriter.X != null) {
                            methodWriter.f6236b.newUTF8("RuntimeInvisibleTypeAnnotations");
                            i8 = GeneratedOutlineSupport.outline12(methodWriter.X, 8, i8);
                        }
                        Attribute attribute2 = methodWriter.J;
                        if (attribute2 != null) {
                            ClassWriter classWriter2 = methodWriter.f6236b;
                            ByteVector byteVector2 = methodWriter.r;
                            str8 = str;
                            i6 = i11;
                            i8 += attribute2.a(classWriter2, byteVector2.f6184a, byteVector2.f6185b, methodWriter.s, methodWriter.t);
                        } else {
                            i6 = i11;
                            str8 = str;
                        }
                    } else {
                        throw new RuntimeException("Method code too large!");
                    }
                    if (methodWriter.j > 0) {
                        methodWriter.f6236b.newUTF8("Exceptions");
                        i8 = GeneratedOutlineSupport.outline7(methodWriter.j, 2, 8, i8);
                    }
                    int i16 = methodWriter.f6237c;
                    if ((i16 & 4096) != 0 && ((methodWriter.f6236b.f6191b & 65535) < 49 || (i16 & 262144) != 0)) {
                        methodWriter.f6236b.newUTF8("Synthetic");
                        i8 += 6;
                    }
                    if ((methodWriter.f6237c & 131072) != 0) {
                        methodWriter.f6236b.newUTF8("Deprecated");
                        i8 += 6;
                    }
                    if (methodWriter.g != null) {
                        methodWriter.f6236b.newUTF8("Signature");
                        methodWriter.f6236b.newUTF8(methodWriter.g);
                        i8 += 8;
                    }
                    if (methodWriter.$ != null) {
                        methodWriter.f6236b.newUTF8("MethodParameters");
                        i8 += methodWriter.$.f6185b + 7;
                    }
                    if (methodWriter.l != null) {
                        methodWriter.f6236b.newUTF8("AnnotationDefault");
                        i8 += methodWriter.l.f6185b + 6;
                    }
                    if (methodWriter.m != null) {
                        methodWriter.f6236b.newUTF8("RuntimeVisibleAnnotations");
                        i8 = GeneratedOutlineSupport.outline12(methodWriter.m, 8, i8);
                    }
                    if (methodWriter.n != null) {
                        methodWriter.f6236b.newUTF8("RuntimeInvisibleAnnotations");
                        i8 = GeneratedOutlineSupport.outline12(methodWriter.n, 8, i8);
                    }
                    if (methodWriter.U != null) {
                        methodWriter.f6236b.newUTF8("RuntimeVisibleTypeAnnotations");
                        i8 = GeneratedOutlineSupport.outline12(methodWriter.U, 8, i8);
                    }
                    if (methodWriter.V != null) {
                        methodWriter.f6236b.newUTF8("RuntimeInvisibleTypeAnnotations");
                        i8 = GeneratedOutlineSupport.outline12(methodWriter.V, 8, i8);
                    }
                    if (methodWriter.o != null) {
                        methodWriter.f6236b.newUTF8("RuntimeVisibleParameterAnnotations");
                        AnnotationWriter[] annotationWriterArr = methodWriter.o;
                        int length = ((annotationWriterArr.length - methodWriter.S) * 2) + 7 + i8;
                        int length2 = annotationWriterArr.length;
                        while (true) {
                            length2--;
                            if (length2 < methodWriter.S) {
                                break;
                            }
                            AnnotationWriter[] annotationWriterArr2 = methodWriter.o;
                            length += annotationWriterArr2[length2] == null ? 0 : annotationWriterArr2[length2].a();
                        }
                        i8 = length;
                    }
                    if (methodWriter.p != null) {
                        methodWriter.f6236b.newUTF8("RuntimeInvisibleParameterAnnotations");
                        AnnotationWriter[] annotationWriterArr3 = methodWriter.p;
                        int length3 = ((annotationWriterArr3.length - methodWriter.S) * 2) + 7 + i8;
                        int length4 = annotationWriterArr3.length;
                        while (true) {
                            length4--;
                            if (length4 < methodWriter.S) {
                                break;
                            }
                            AnnotationWriter[] annotationWriterArr4 = methodWriter.p;
                            length3 += annotationWriterArr4[length4] == null ? 0 : annotationWriterArr4[length4].a();
                        }
                        i8 = length3;
                    }
                    Attribute attribute3 = methodWriter.q;
                    if (attribute3 != null) {
                        i8 += attribute3.a(methodWriter.f6236b, null, 0, -1, -1);
                    }
                }
                i10 += i8;
                methodWriter = (MethodWriter) methodWriter.mv;
                classWriter = this;
                i13 = i7;
                str = str8;
                i11 = i6;
            }
            int i17 = i11;
            String str9 = str;
            ByteVector byteVector3 = classWriter.A;
            String str10 = "BootstrapMethods";
            if (byteVector3 != null) {
                i10 += byteVector3.f6185b + 8;
                classWriter.newUTF8(str10);
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (classWriter.m != 0) {
                i2++;
                i10 += 8;
                classWriter.newUTF8("Signature");
            }
            if (classWriter.q != 0) {
                i2++;
                i10 += 8;
                classWriter.newUTF8("SourceFile");
            }
            ByteVector byteVector4 = classWriter.r;
            if (byteVector4 != null) {
                i2++;
                i10 += byteVector4.f6185b + 6;
                classWriter.newUTF8("SourceDebugExtension");
            }
            if (classWriter.s != 0) {
                i2++;
                i10 += 10;
                classWriter.newUTF8("EnclosingMethod");
            }
            if ((classWriter.k & 131072) != 0) {
                i2++;
                i10 += 6;
                classWriter.newUTF8("Deprecated");
            }
            int i18 = classWriter.k;
            String str11 = "EnclosingMethod";
            if ((i18 & 4096) != 0) {
                str2 = "SourceDebugExtension";
                if ((classWriter.f6191b & 65535) < 49 || (i18 & 262144) != 0) {
                    i2++;
                    i10 += 6;
                    classWriter.newUTF8("Synthetic");
                }
            } else {
                str2 = "SourceDebugExtension";
            }
            ByteVector byteVector5 = classWriter.y;
            if (byteVector5 != null) {
                i2++;
                i10 += byteVector5.f6185b + 8;
                classWriter.newUTF8("InnerClasses");
            }
            AnnotationWriter annotationWriter = classWriter.u;
            if (annotationWriter != null) {
                i2++;
                i10 += annotationWriter.a() + 8;
                classWriter.newUTF8("RuntimeVisibleAnnotations");
            }
            AnnotationWriter annotationWriter2 = classWriter.v;
            if (annotationWriter2 != null) {
                i2++;
                i10 += annotationWriter2.a() + 8;
                classWriter.newUTF8("RuntimeInvisibleAnnotations");
            }
            AnnotationWriter annotationWriter3 = classWriter.N;
            if (annotationWriter3 != null) {
                i2++;
                i10 += annotationWriter3.a() + 8;
                classWriter.newUTF8("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter annotationWriter4 = classWriter.O;
            if (annotationWriter4 != null) {
                i2++;
                i10 += annotationWriter4.a() + 8;
                classWriter.newUTF8("RuntimeInvisibleTypeAnnotations");
            }
            int i19 = i10;
            Attribute attribute4 = classWriter.w;
            if (attribute4 != null) {
                int a2 = attribute4.a() + i2;
                i3 = 49;
                str5 = str11;
                str3 = "InnerClasses";
                str4 = str2;
                str6 = "SourceFile";
                i4 = i13;
                i19 += classWriter.w.a(this, null, 0, -1, -1);
                i2 = a2;
            } else {
                str3 = "InnerClasses";
                str5 = str11;
                str4 = str2;
                str6 = "SourceFile";
                i4 = i13;
                i3 = 49;
            }
            ByteVector byteVector6 = new ByteVector(i19 + classWriter.f6193d.f6185b);
            byteVector6.putInt(-889275714);
            byteVector6.putInt(classWriter.f6191b);
            byteVector6.putShort(classWriter.f6192c);
            ByteVector byteVector7 = classWriter.f6193d;
            byteVector6.putByteArray(byteVector7.f6184a, 0, byteVector7.f6185b);
            int i20 = classWriter.k;
            int i21 = 393216;
            byteVector6.putShort(i20 & (~(((i20 & 262144) / 64) | 393216)));
            byteVector6.putShort(classWriter.l);
            byteVector6.putShort(classWriter.n);
            byteVector6.putShort(classWriter.o);
            for (int i22 = 0; i22 < classWriter.o; i22++) {
                byteVector6.putShort(classWriter.p[i22]);
            }
            byteVector6.putShort(i17);
            FieldWriter fieldWriter2 = classWriter.B;
            int i23 = i3;
            while (fieldWriter2 != null) {
                int i24 = fieldWriter2.f6206c;
                byteVector6.putShort((~(((i24 & 262144) / 64) | i21)) & i24);
                byteVector6.putShort(fieldWriter2.f6207d);
                byteVector6.putShort(fieldWriter2.f6208e);
                int i25 = fieldWriter2.g != 0 ? 1 : 0;
                int i26 = fieldWriter2.f6206c;
                String str12 = str10;
                if ((i26 & 4096) != 0 && ((fieldWriter2.f6205b.f6191b & 65535) < i23 || (i26 & 262144) != 0)) {
                    i25++;
                }
                if ((fieldWriter2.f6206c & 131072) != 0) {
                    i25++;
                }
                if (fieldWriter2.f6209f != 0) {
                    i25++;
                }
                if (fieldWriter2.h != null) {
                    i25++;
                }
                if (fieldWriter2.i != null) {
                    i25++;
                }
                if (fieldWriter2.k != null) {
                    i25++;
                }
                if (fieldWriter2.l != null) {
                    i25++;
                }
                Attribute attribute5 = fieldWriter2.j;
                if (attribute5 != null) {
                    i25 += attribute5.a();
                }
                byteVector6.putShort(i25);
                if (fieldWriter2.g != 0) {
                    str7 = str9;
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8(str7));
                    byteVector6.putInt(2);
                    byteVector6.putShort(fieldWriter2.g);
                } else {
                    str7 = str9;
                }
                int i27 = fieldWriter2.f6206c;
                if ((i27 & 4096) != 0 && ((fieldWriter2.f6205b.f6191b & 65535) < i23 || (i27 & 262144) != 0)) {
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8("Synthetic"));
                    byteVector6.putInt(0);
                }
                if ((fieldWriter2.f6206c & 131072) != 0) {
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8("Deprecated"));
                    byteVector6.putInt(0);
                }
                if (fieldWriter2.f6209f != 0) {
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8("Signature"));
                    byteVector6.putInt(2);
                    byteVector6.putShort(fieldWriter2.f6209f);
                }
                if (fieldWriter2.h != null) {
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8("RuntimeVisibleAnnotations"));
                    fieldWriter2.h.a(byteVector6);
                }
                if (fieldWriter2.i != null) {
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8("RuntimeInvisibleAnnotations"));
                    fieldWriter2.i.a(byteVector6);
                }
                if (fieldWriter2.k != null) {
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8("RuntimeVisibleTypeAnnotations"));
                    fieldWriter2.k.a(byteVector6);
                }
                if (fieldWriter2.l != null) {
                    byteVector6.putShort(fieldWriter2.f6205b.newUTF8("RuntimeInvisibleTypeAnnotations"));
                    fieldWriter2.l.a(byteVector6);
                }
                Attribute attribute6 = fieldWriter2.j;
                if (attribute6 != null) {
                    attribute6.a(fieldWriter2.f6205b, null, 0, -1, -1, byteVector6);
                }
                fieldWriter2 = fieldWriter2.fv;
                i21 = 393216;
                i23 = 49;
                str9 = str7;
                str10 = str12;
            }
            String str13 = str10;
            byteVector6.putShort(i4);
            for (MethodWriter methodWriter2 = classWriter.D; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.mv) {
                methodWriter2.a(byteVector6);
            }
            byteVector6.putShort(i2);
            if (classWriter.A != null) {
                byteVector6.putShort(classWriter.newUTF8(str13));
                byteVector6.putInt(classWriter.A.f6185b + 2);
                byteVector6.putShort(classWriter.z);
                ByteVector byteVector8 = classWriter.A;
                byteVector6.putByteArray(byteVector8.f6184a, 0, byteVector8.f6185b);
            }
            if (classWriter.m != 0) {
                byteVector6.putShort(classWriter.newUTF8("Signature"));
                i5 = 2;
                byteVector6.putInt(2);
                byteVector6.putShort(classWriter.m);
            } else {
                i5 = 2;
            }
            if (classWriter.q != 0) {
                byteVector6.putShort(classWriter.newUTF8(str6));
                byteVector6.putInt(i5);
                byteVector6.putShort(classWriter.q);
            }
            ByteVector byteVector9 = classWriter.r;
            if (byteVector9 != null) {
                int i28 = byteVector9.f6185b;
                byteVector6.putShort(classWriter.newUTF8(str4));
                byteVector6.putInt(i28);
                byteVector6.putByteArray(classWriter.r.f6184a, 0, i28);
            }
            if (classWriter.s != 0) {
                byteVector6.putShort(classWriter.newUTF8(str5));
                byteVector6.putInt(4);
                byteVector6.putShort(classWriter.s);
                byteVector6.putShort(classWriter.t);
            }
            if ((classWriter.k & 131072) != 0) {
                byteVector6.putShort(classWriter.newUTF8("Deprecated"));
                byteVector6.putInt(0);
            }
            int i29 = classWriter.k;
            if ((i29 & 4096) != 0 && ((classWriter.f6191b & 65535) < 49 || (i29 & 262144) != 0)) {
                byteVector6.putShort(classWriter.newUTF8("Synthetic"));
                byteVector6.putInt(0);
            }
            if (classWriter.y != null) {
                byteVector6.putShort(classWriter.newUTF8(str3));
                byteVector6.putInt(classWriter.y.f6185b + 2);
                byteVector6.putShort(classWriter.x);
                ByteVector byteVector10 = classWriter.y;
                byteVector6.putByteArray(byteVector10.f6184a, 0, byteVector10.f6185b);
            }
            if (classWriter.u != null) {
                byteVector6.putShort(classWriter.newUTF8("RuntimeVisibleAnnotations"));
                classWriter.u.a(byteVector6);
            }
            if (classWriter.v != null) {
                byteVector6.putShort(classWriter.newUTF8("RuntimeInvisibleAnnotations"));
                classWriter.v.a(byteVector6);
            }
            if (classWriter.N != null) {
                byteVector6.putShort(classWriter.newUTF8("RuntimeVisibleTypeAnnotations"));
                classWriter.N.a(byteVector6);
            }
            if (classWriter.O != null) {
                byteVector6.putShort(classWriter.newUTF8("RuntimeInvisibleTypeAnnotations"));
                classWriter.O.a(byteVector6);
            }
            Attribute attribute7 = classWriter.w;
            if (attribute7 != null) {
                byteVector = byteVector6;
                attribute7.a(this, null, 0, -1, -1, byteVector);
            } else {
                byteVector = byteVector6;
            }
            if (!classWriter.L) {
                return byteVector.f6184a;
            }
            classWriter.u = null;
            classWriter.v = null;
            classWriter.w = null;
            classWriter.x = 0;
            classWriter.y = null;
            classWriter.z = 0;
            classWriter.A = null;
            classWriter.B = null;
            classWriter.C = null;
            classWriter.D = null;
            classWriter.E = null;
            classWriter.K = false;
            classWriter.J = true;
            classWriter.L = false;
            new ClassReader(byteVector.f6184a).accept(classWriter, 4);
            return toByteArray();
        }
        throw new RuntimeException("Class file too large!");
    }

    public final void visit(int i2, int i3, String str, String str2, String str3, String[] strArr) {
        int i4;
        this.f6191b = i2;
        this.k = i3;
        this.l = a(str).f6226a;
        this.I = str;
        if (str2 != null) {
            this.m = newUTF8(str2);
        }
        if (str3 == null) {
            i4 = 0;
        } else {
            i4 = a(str3).f6226a;
        }
        this.n = i4;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.o = length;
            this.p = new int[length];
            for (int i5 = 0; i5 < this.o; i5++) {
                this.p[i5] = newClass(strArr[i5]);
            }
        }
    }

    public final AnnotationWriter visitAnnotation(String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, 2);
        if (z2) {
            annotationWriter.g = this.u;
            this.u = annotationWriter;
        } else {
            annotationWriter.g = this.v;
            this.v = annotationWriter;
        }
        return annotationWriter;
    }

    public final MethodVisitor visitMethod(int i2, String str, String str2, String str3, String[] strArr) {
        MethodWriter methodWriter = new MethodWriter(this, i2, str, str2, str3, strArr, this.K, this.J);
        return methodWriter;
    }

    public final AnnotationWriter visitTypeAnnotation(int i2, TypePath typePath, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(i2, typePath, byteVector);
        byteVector.putShort(newUTF8(str));
        byteVector.putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, byteVector.f6185b - 2);
        if (z2) {
            annotationWriter.g = this.N;
            this.N = annotationWriter;
        } else {
            annotationWriter.g = this.O;
            this.O = annotationWriter;
        }
        return annotationWriter;
    }

    public Item a(float f2) {
        Item item = this.g;
        item.f6227b = 4;
        item.f6228c = Float.floatToRawIntBits(f2);
        item.j = Integer.MAX_VALUE & (item.f6227b + ((int) f2));
        Item a2 = a(this.g);
        if (a2 != null) {
            return a2;
        }
        ByteVector byteVector = this.f6193d;
        byteVector.putByte(4);
        byteVector.putInt(this.g.f6228c);
        int i2 = this.f6192c;
        this.f6192c = i2 + 1;
        Item item2 = new Item(i2, this.g);
        b(item2);
        return item2;
    }

    public Item a(int i2) {
        Item item = this.g;
        item.f6227b = 3;
        item.f6228c = i2;
        item.j = (i2 + 3) & Integer.MAX_VALUE;
        Item a2 = a(item);
        if (a2 != null) {
            return a2;
        }
        ByteVector byteVector = this.f6193d;
        byteVector.putByte(3);
        byteVector.putInt(i2);
        int i3 = this.f6192c;
        this.f6192c = i3 + 1;
        Item item2 = new Item(i3, this.g);
        b(item2);
        return item2;
    }

    public Item a(int i2, String str, String str2, String str3) {
        int i3;
        this.j.a(i2 + 20, str, str2, str3);
        Item a2 = a(this.j);
        if (a2 != null) {
            return a2;
        }
        if (i2 <= 4) {
            i3 = a(str, str2, str3).f6226a;
        } else {
            i3 = a(str, str2, str3, i2 == 9).f6226a;
        }
        ByteVector byteVector = this.f6193d;
        byteVector.a(15, i2);
        byteVector.putShort(i3);
        int i4 = this.f6192c;
        this.f6192c = i4 + 1;
        Item item = new Item(i4, this.j);
        b(item);
        return item;
    }

    public Item a(long j2) {
        Item item = this.g;
        item.f6227b = 5;
        item.f6229d = j2;
        item.j = (((int) j2) + 5) & Integer.MAX_VALUE;
        Item a2 = a(item);
        if (a2 != null) {
            return a2;
        }
        ByteVector byteVector = this.f6193d;
        byteVector.putByte(5);
        byteVector.putLong(j2);
        Item item2 = new Item(this.f6192c, this.g);
        this.f6192c += 2;
        b(item2);
        return item2;
    }

    public Item a(Object obj) {
        if (obj instanceof Integer) {
            return a(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return a(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return a((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return a(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return a(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return a(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return a(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return a(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            this.h.a(8, str, null, null);
            Item a2 = a(this.h);
            if (a2 == null) {
                this.f6193d.b(8, newUTF8(str));
                int i2 = this.f6192c;
                this.f6192c = i2 + 1;
                a2 = new Item(i2, this.h);
                b(a2);
            }
            return a2;
        } else if (obj instanceof Type) {
            Type type = (Type) obj;
            int i3 = type.f6241a;
            if (i3 == 10) {
                return a(new String(type.f6242b, type.f6243c, type.f6244d));
            }
            String descriptor = type.getDescriptor();
            if (i3 != 11) {
                return a(descriptor);
            }
            this.h.a(16, descriptor, null, null);
            Item a3 = a(this.h);
            if (a3 == null) {
                this.f6193d.b(16, newUTF8(descriptor));
                int i4 = this.f6192c;
                this.f6192c = i4 + 1;
                a3 = new Item(i4, this.h);
                b(a3);
            }
            return a3;
        } else if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            return a(handle.f6216a, handle.f6217b, handle.f6218c, handle.f6219d);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("value ");
            stringBuffer.append(obj);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public Item a(String str, String str2, String str3) {
        this.i.a(9, str, str2, str3);
        Item a2 = a(this.i);
        if (a2 != null) {
            return a2;
        }
        a(9, a(str).f6226a, newNameType(str2, str3));
        int i2 = this.f6192c;
        this.f6192c = i2 + 1;
        Item item = new Item(i2, this.i);
        b(item);
        return item;
    }

    public Item a(String str, String str2, String str3, boolean z2) {
        int i2 = z2 ? 11 : 10;
        this.i.a(i2, str, str2, str3);
        Item a2 = a(this.i);
        if (a2 != null) {
            return a2;
        }
        a(i2, a(str).f6226a, newNameType(str2, str3));
        int i3 = this.f6192c;
        this.f6192c = i3 + 1;
        Item item = new Item(i3, this.i);
        b(item);
        return item;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r0.i.equals(r9.i) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r0.f6228c == r9.f6228c) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r0.f6229d != r9.f6229d) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r0.g.equals(r9.g) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0082, code lost:
        if (r0.h.equals(r9.h) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r0.h.equals(r9.h) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.objectweb.asm.Item a(org.objectweb.asm.Item r9) {
        /*
            r8 = this;
            org.objectweb.asm.Item[] r0 = r8.f6194e
            int r1 = r9.j
            int r2 = r0.length
            int r1 = r1 % r2
            r0 = r0[r1]
        L_0x0008:
            if (r0 == 0) goto L_0x00a8
            int r1 = r0.f6227b
            int r2 = r9.f6227b
            if (r1 != r2) goto L_0x00a4
            r1 = 1
            if (r2 == r1) goto L_0x009a
            r3 = 12
            r4 = 0
            if (r2 == r3) goto L_0x0085
            r3 = 16
            if (r2 == r3) goto L_0x009a
            r3 = 18
            if (r2 == r3) goto L_0x0068
            switch(r2) {
                case 3: goto L_0x0045;
                case 4: goto L_0x0045;
                case 5: goto L_0x004e;
                case 6: goto L_0x004e;
                case 7: goto L_0x009a;
                case 8: goto L_0x009a;
                default: goto L_0x0023;
            }
        L_0x0023:
            switch(r2) {
                case 30: goto L_0x009a;
                case 31: goto L_0x0057;
                case 32: goto L_0x004e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.String r2 = r0.g
            java.lang.String r3 = r9.g
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = r0.h
            java.lang.String r3 = r9.h
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = r0.i
            java.lang.String r3 = r9.i
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            goto L_0x00a2
        L_0x0045:
            int r2 = r0.f6228c
            int r3 = r9.f6228c
            if (r2 != r3) goto L_0x004c
            goto L_0x00a2
        L_0x004c:
            r1 = 0
            goto L_0x00a2
        L_0x004e:
            long r2 = r0.f6229d
            long r5 = r9.f6229d
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x004c
            goto L_0x00a2
        L_0x0057:
            int r2 = r0.f6228c
            int r3 = r9.f6228c
            if (r2 != r3) goto L_0x004c
            java.lang.String r2 = r0.g
            java.lang.String r3 = r9.g
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            goto L_0x00a2
        L_0x0068:
            long r2 = r0.f6229d
            long r5 = r9.f6229d
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x004c
            java.lang.String r2 = r0.g
            java.lang.String r3 = r9.g
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = r0.h
            java.lang.String r3 = r9.h
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            goto L_0x00a2
        L_0x0085:
            java.lang.String r2 = r0.g
            java.lang.String r3 = r9.g
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = r0.h
            java.lang.String r3 = r9.h
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004c
            goto L_0x00a2
        L_0x009a:
            java.lang.String r1 = r0.g
            java.lang.String r2 = r9.g
            boolean r1 = r1.equals(r2)
        L_0x00a2:
            if (r1 != 0) goto L_0x00a8
        L_0x00a4:
            org.objectweb.asm.Item r0 = r0.k
            goto L_0x0008
        L_0x00a8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassWriter.a(org.objectweb.asm.Item):org.objectweb.asm.Item");
    }
}
