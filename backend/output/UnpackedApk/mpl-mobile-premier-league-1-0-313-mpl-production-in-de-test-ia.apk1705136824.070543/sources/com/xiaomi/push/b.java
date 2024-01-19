package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.InputStream;
import java.util.Vector;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f4473a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f331a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f332a;

    /* renamed from: b  reason: collision with root package name */
    public int f4474b;

    /* renamed from: c  reason: collision with root package name */
    public int f4475c;

    /* renamed from: d  reason: collision with root package name */
    public int f4476d;

    /* renamed from: e  reason: collision with root package name */
    public int f4477e;

    /* renamed from: f  reason: collision with root package name */
    public int f4478f;
    public int g;
    public int h;
    public int i;

    public b(InputStream inputStream) {
        this.f4478f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = PDChoice.FLAG_COMMIT_ON_SEL_CHANGE;
        this.f332a = new byte[4096];
        this.f4473a = 0;
        this.f4475c = 0;
        this.f331a = inputStream;
    }

    public b(byte[] bArr, int i2, int i3) {
        this.f4478f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = PDChoice.FLAG_COMMIT_ON_SEL_CHANGE;
        this.f332a = bArr;
        this.f4473a = i3 + i2;
        this.f4475c = i2;
        this.f331a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i2, int i3) {
        return new b(bArr, i2, i3);
    }

    private boolean a(boolean z) {
        int i2 = this.f4475c;
        int i3 = this.f4473a;
        if (i2 >= i3) {
            int i4 = this.f4477e;
            if (i4 + i3 != this.f4478f) {
                this.f4477e = i4 + i3;
                this.f4475c = 0;
                InputStream inputStream = this.f331a;
                int read = inputStream == null ? -1 : inputStream.read(this.f332a);
                this.f4473a = read;
                if (read == 0 || read < -1) {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("InputStream#read(byte[]) returned invalid result: "), this.f4473a, "\nThe InputStream implementation is buggy."));
                } else if (read == -1) {
                    this.f4473a = 0;
                    if (!z) {
                        return false;
                    }
                    throw d.a();
                } else {
                    b();
                    int i5 = this.f4477e + this.f4473a + this.f4474b;
                    if (i5 <= this.i && i5 >= 0) {
                        return true;
                    }
                    throw d.h();
                }
            } else if (!z) {
                return false;
            } else {
                throw d.a();
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    private void b() {
        int i2 = this.f4473a + this.f4474b;
        this.f4473a = i2;
        int i3 = this.f4477e + i2;
        int i4 = this.f4478f;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f4474b = i5;
            this.f4473a = i2 - i5;
            return;
        }
        this.f4474b = 0;
    }

    public byte a() {
        if (this.f4475c == this.f4473a) {
            a(true);
        }
        byte[] bArr = this.f332a;
        int i2 = this.f4475c;
        this.f4475c = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m490a() {
        if (b()) {
            this.f4476d = 0;
            return 0;
        }
        int d2 = d();
        this.f4476d = d2;
        if (d2 != 0) {
            return d2;
        }
        throw d.d();
    }

    public int a(int i2) {
        if (i2 >= 0) {
            int i3 = this.f4477e + this.f4475c + i2;
            int i4 = this.f4478f;
            if (i3 <= i4) {
                this.f4478f = i3;
                b();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m491a() {
        return b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m492a() {
        int d2 = d();
        int i2 = this.f4473a;
        int i3 = this.f4475c;
        if (d2 > i2 - i3 || d2 <= 0) {
            return a.a(a(d2));
        }
        a a2 = a.a(this.f332a, i3, d2);
        this.f4475c += d2;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m493a() {
        int d2 = d();
        if (d2 > this.f4473a - this.f4475c || d2 <= 0) {
            return new String(a(d2), "UTF-8");
        }
        String str = new String(this.f332a, this.f4475c, d2, "UTF-8");
        this.f4475c += d2;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m494a() {
        int a2;
        do {
            a2 = a();
            if (a2 == 0) {
                return;
            }
        } while (a(a2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m495a(int i2) {
        if (this.f4476d != i2) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d2 = d();
        if (this.g < this.h) {
            int a2 = a(d2);
            this.g++;
            eVar.a(this);
            a(0);
            this.g--;
            b(a2);
            return;
        }
        throw d.g();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m496a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m497a(int i2) {
        int a2 = f.a(i2);
        if (a2 == 0) {
            b();
            return true;
        } else if (a2 == 1) {
            c();
            return true;
        } else if (a2 == 2) {
            c(d());
            return true;
        } else if (a2 == 3) {
            a();
            a(f.a(f.b(i2), 4));
            return true;
        } else if (a2 == 4) {
            return false;
        } else {
            if (a2 == 5) {
                e();
                return true;
            }
            throw d.f();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m498a(int i2) {
        if (i2 >= 0) {
            int i3 = this.f4477e;
            int i4 = this.f4475c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f4478f;
            if (i5 <= i6) {
                int i7 = this.f4473a;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f332a, i4, bArr, 0, i2);
                    this.f4475c += i2;
                    return bArr;
                } else if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.f332a, i4, bArr2, 0, i8);
                    this.f4475c = this.f4473a;
                    while (true) {
                        a(true);
                        int i9 = i2 - i8;
                        int i10 = this.f4473a;
                        if (i9 > i10) {
                            System.arraycopy(this.f332a, 0, bArr2, i8, i10);
                            int i11 = this.f4473a;
                            i8 += i11;
                            this.f4475c = i11;
                        } else {
                            System.arraycopy(this.f332a, 0, bArr2, i8, i9);
                            this.f4475c = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.f4477e = i3 + i7;
                    this.f4475c = 0;
                    this.f4473a = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    Vector vector = new Vector();
                    while (i13 > 0) {
                        int min = Math.min(i13, 4096);
                        byte[] bArr3 = new byte[min];
                        int i14 = 0;
                        while (i14 < min) {
                            InputStream inputStream = this.f331a;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, min - i14);
                            if (read != -1) {
                                this.f4477e += read;
                                i14 += read;
                            } else {
                                throw d.a();
                            }
                        }
                        i13 -= min;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.f332a, i4, bArr4, 0, i12);
                    for (int i15 = 0; i15 < vector.size(); i15++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i15);
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                c((i6 - i3) - i4);
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m499b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m500b() {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte a2 = a();
            j |= ((long) (a2 & Byte.MAX_VALUE)) << i2;
            if ((a2 & 128) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public void b(int i2) {
        this.f4478f = i2;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m501b() {
        return this.f4475c == this.f4473a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m502c() {
        byte a2 = a();
        byte a3 = a();
        return ((((long) a3) & 255) << 8) | (((long) a2) & 255) | ((((long) a()) & 255) << 16) | ((((long) a()) & 255) << 24) | ((((long) a()) & 255) << 32) | ((((long) a()) & 255) << 40) | ((((long) a()) & 255) << 48) | ((((long) a()) & 255) << 56);
    }

    public void c(int i2) {
        if (i2 >= 0) {
            int i3 = this.f4477e;
            int i4 = this.f4475c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f4478f;
            if (i5 <= i6) {
                int i7 = this.f4473a;
                if (i2 <= i7 - i4) {
                    this.f4475c = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.f4477e = i3 + i7;
                this.f4475c = 0;
                this.f4473a = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.f331a;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip((long) (i2 - i8));
                    if (skip > 0) {
                        i8 += skip;
                        this.f4477e += skip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            c((i6 - i3) - i4);
            throw d.a();
        }
        throw d.b();
    }

    public int d() {
        byte b2;
        int i2;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        byte b3 = a2 & Byte.MAX_VALUE;
        byte a3 = a();
        if (a3 >= 0) {
            i2 = a3 << 7;
        } else {
            b3 |= (a3 & Byte.MAX_VALUE) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i2 = a4 << MqttWireMessage.MESSAGE_TYPE_DISCONNECT;
            } else {
                b3 |= (a4 & Byte.MAX_VALUE) << MqttWireMessage.MESSAGE_TYPE_DISCONNECT;
                byte a5 = a();
                if (a5 >= 0) {
                    i2 = a5 << 21;
                } else {
                    byte b4 = b3 | ((a5 & Byte.MAX_VALUE) << 21);
                    byte a6 = a();
                    b2 = b4 | (a6 << 28);
                    if (a6 < 0) {
                        for (int i3 = 0; i3 < 5; i3++) {
                            if (a() >= 0) {
                                return b2;
                            }
                        }
                        throw d.c();
                    }
                    return b2;
                }
            }
        }
        b2 = b3 | i2;
        return b2;
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << GlyfDescript.X_DUAL) | ((a() & 255) << 24);
    }
}
