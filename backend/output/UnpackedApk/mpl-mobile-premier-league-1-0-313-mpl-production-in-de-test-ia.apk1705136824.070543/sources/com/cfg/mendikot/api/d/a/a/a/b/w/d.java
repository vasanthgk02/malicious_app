package com.cfg.mendikot.api.d.a.a.a.b.w;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.api.d.a.a.a.b.v.a;
import java.io.Serializable;
import java.nio.CharBuffer;

public final class d implements CharSequence, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public char[] f2317a;

    /* renamed from: b  reason: collision with root package name */
    public int f2318b;

    public d(int i) {
        k.a(i, (String) "Buffer capacity");
        this.f2317a = new char[i];
    }

    public int a(int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = this.f2318b;
        if (i3 > i4) {
            i3 = i4;
        }
        if (i2 > i3) {
            return -1;
        }
        while (i2 < i3) {
            if (this.f2317a[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String a(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Negative beginIndex: ", i));
        } else if (i2 > this.f2318b) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("endIndex: ", i2, " > length: ");
            outline74.append(this.f2318b);
            throw new IndexOutOfBoundsException(outline74.toString());
        } else if (i <= i2) {
            return new String(this.f2317a, i, i2 - i);
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("beginIndex: ", i, " > endIndex: ", i2));
        }
    }

    public void a(char c2) {
        int i = this.f2318b + 1;
        if (i > this.f2317a.length) {
            c(i);
        }
        this.f2317a[this.f2318b] = c2;
        this.f2318b = i;
    }

    public void a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.f2318b + length;
        if (i > this.f2317a.length) {
            c(i);
        }
        str.getChars(0, length, this.f2317a, this.f2318b);
        this.f2318b = i;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i <= bArr.length && i2 >= 0) {
                int i3 = i + i2;
                if (i3 >= 0 && i3 <= bArr.length) {
                    if (i2 != 0) {
                        int i4 = this.f2318b;
                        int i5 = i2 + i4;
                        if (i5 > this.f2317a.length) {
                            c(i5);
                        }
                        while (i4 < i5) {
                            this.f2317a[i4] = (char) (bArr[i] & 255);
                            i++;
                            i4++;
                        }
                        this.f2318b = i5;
                        return;
                    }
                    return;
                }
            }
            StringBuilder outline75 = GeneratedOutlineSupport.outline75("off: ", i, " len: ", i2, " b.length: ");
            outline75.append(bArr.length);
            throw new IndexOutOfBoundsException(outline75.toString());
        }
    }

    public String b(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Negative beginIndex: ", i));
        } else if (i2 > this.f2318b) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("endIndex: ", i2, " > length: ");
            outline74.append(this.f2318b);
            throw new IndexOutOfBoundsException(outline74.toString());
        } else if (i <= i2) {
            while (i < i2 && a.a(this.f2317a[i])) {
                i++;
            }
            while (i2 > i && a.a(this.f2317a[i2 - 1])) {
                i2--;
            }
            return new String(this.f2317a, i, i2 - i);
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("beginIndex: ", i, " > endIndex: ", i2));
        }
    }

    public final void c(int i) {
        char[] cArr = new char[Math.max(this.f2317a.length << 1, i)];
        System.arraycopy(this.f2317a, 0, cArr, 0, this.f2318b);
        this.f2317a = cArr;
    }

    public char charAt(int i) {
        return this.f2317a[i];
    }

    public int length() {
        return this.f2318b;
    }

    public CharSequence subSequence(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Negative beginIndex: ", i));
        } else if (i2 > this.f2318b) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("endIndex: ", i2, " > length: ");
            outline74.append(this.f2318b);
            throw new IndexOutOfBoundsException(outline74.toString());
        } else if (i <= i2) {
            return CharBuffer.wrap(this.f2317a, i, i2);
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("beginIndex: ", i, " > endIndex: ", i2));
        }
    }

    public String toString() {
        return new String(this.f2317a, 0, this.f2318b);
    }
}
