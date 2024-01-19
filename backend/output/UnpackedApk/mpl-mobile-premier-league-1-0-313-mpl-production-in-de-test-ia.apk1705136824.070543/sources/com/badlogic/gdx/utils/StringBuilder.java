package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.internal.http2.Http2Connection;
import org.apache.pdfbox.filter.ASCII85InputStream;

public class StringBuilder implements Appendable, CharSequence {
    public static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public char[] chars;
    public int length;

    public StringBuilder() {
        this.chars = new char[16];
    }

    public final void append0(char[] cArr, int i, int i2) {
        if (i > cArr.length || i < 0) {
            throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Offset out of bounds: ", i));
        } else if (i2 < 0 || cArr.length - i < i2) {
            throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Length out of bounds: ", i2));
        } else {
            int i3 = this.length + i2;
            if (i3 > this.chars.length) {
                enlargeBuffer(i3);
            }
            System.arraycopy(cArr, i, this.chars, this.length, i2);
            this.length = i3;
        }
    }

    public final void appendNull() {
        int i = this.length + 4;
        if (i > this.chars.length) {
            enlargeBuffer(i);
        }
        char[] cArr = this.chars;
        int i2 = this.length;
        int i3 = i2 + 1;
        this.length = i3;
        cArr[i2] = 'n';
        int i4 = i3 + 1;
        this.length = i4;
        cArr[i3] = ASCII85InputStream.PADDING_U;
        int i5 = i4 + 1;
        this.length = i5;
        cArr[i4] = 'l';
        this.length = i5 + 1;
        cArr[i5] = 'l';
    }

    public char charAt(int i) {
        if (i >= 0 && i < this.length) {
            return this.chars[i];
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    public final void enlargeBuffer(int i) {
        char[] cArr = this.chars;
        int length2 = (cArr.length >> 1) + cArr.length + 2;
        if (i <= length2) {
            i = length2;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(this.chars, 0, cArr2, 0, this.length);
        this.chars = cArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StringBuilder.class != obj.getClass()) {
            return false;
        }
        StringBuilder stringBuilder = (StringBuilder) obj;
        int i = this.length;
        if (i != stringBuilder.length) {
            return false;
        }
        char[] cArr = this.chars;
        char[] cArr2 = stringBuilder.chars;
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] != cArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.length + 31;
        for (int i2 = 0; i2 < this.length; i2++) {
            i = (i * 31) + this.chars[i2];
        }
        return i;
    }

    public int length() {
        return this.length;
    }

    public final void move(int i, int i2) {
        char[] cArr = this.chars;
        int length2 = cArr.length;
        int i3 = this.length;
        if (length2 - i3 >= i) {
            System.arraycopy(cArr, i2, cArr, i + i2, i3 - i2);
            return;
        }
        int i4 = i3 + i;
        int length3 = (cArr.length << 1) + 2;
        if (i4 <= length3) {
            i4 = length3;
        }
        char[] cArr2 = new char[i4];
        System.arraycopy(this.chars, 0, cArr2, 0, i2);
        System.arraycopy(this.chars, i2, cArr2, i + i2, this.length - i2);
        this.chars = cArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        throw new java.lang.StringIndexOutOfBoundsException(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.badlogic.gdx.utils.StringBuilder replace(char r10, java.lang.String r11) {
        /*
            r9 = this;
            int r0 = r11.length()
            r1 = 0
            r2 = 0
        L_0x0006:
            int r3 = r9.length
            if (r2 != r3) goto L_0x000b
            return r9
        L_0x000b:
            char[] r4 = r9.chars
            char r4 = r4[r2]
            if (r4 != r10) goto L_0x0069
            int r4 = r2 + 1
            if (r2 < 0) goto L_0x0063
            if (r4 <= r3) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r3 = r4
        L_0x0019:
            if (r3 <= r2) goto L_0x0040
            int r4 = r11.length()
            int r5 = r3 - r2
            int r5 = r5 - r4
            if (r5 <= 0) goto L_0x002f
            char[] r6 = r9.chars
            int r7 = r2 + r4
            int r8 = r9.length
            int r8 = r8 - r3
            java.lang.System.arraycopy(r6, r3, r6, r7, r8)
            goto L_0x0035
        L_0x002f:
            if (r5 >= 0) goto L_0x0035
            int r6 = -r5
            r9.move(r6, r3)
        L_0x0035:
            char[] r3 = r9.chars
            r11.getChars(r1, r4, r3, r2)
            int r3 = r9.length
            int r3 = r3 - r5
            r9.length = r3
            goto L_0x005b
        L_0x0040:
            if (r2 != r3) goto L_0x0063
            if (r2 < 0) goto L_0x005d
            int r3 = r9.length
            if (r2 > r3) goto L_0x005d
            int r3 = r11.length()
            if (r3 == 0) goto L_0x005b
            r9.move(r3, r2)
            char[] r4 = r9.chars
            r11.getChars(r1, r3, r4, r2)
            int r4 = r9.length
            int r4 = r4 + r3
            r9.length = r4
        L_0x005b:
            int r2 = r2 + r0
            goto L_0x0006
        L_0x005d:
            java.lang.StringIndexOutOfBoundsException r10 = new java.lang.StringIndexOutOfBoundsException
            r10.<init>(r2)
            throw r10
        L_0x0063:
            java.lang.StringIndexOutOfBoundsException r10 = new java.lang.StringIndexOutOfBoundsException
            r10.<init>()
            throw r10
        L_0x0069:
            int r2 = r2 + 1
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.StringBuilder.replace(char, java.lang.String):com.badlogic.gdx.utils.StringBuilder");
    }

    public void setLength(int i) {
        if (i >= 0) {
            char[] cArr = this.chars;
            if (i > cArr.length) {
                enlargeBuffer(i);
            } else {
                int i2 = this.length;
                if (i2 < i) {
                    Arrays.fill(cArr, i2, i, 0);
                }
            }
            this.length = i;
            return;
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    public CharSequence subSequence(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.length) {
            throw new StringIndexOutOfBoundsException();
        } else if (i == i2) {
            return "";
        } else {
            return new String(this.chars, i, i2 - i);
        }
    }

    public String toString() {
        if (this.length == 0) {
            return "";
        }
        return new String(this.chars, 0, this.length);
    }

    public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        if (charSequence == null) {
            charSequence = "null";
        }
        if (i < 0 || i2 < 0 || i > i2 || i2 > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        append0(charSequence.subSequence(i, i2).toString());
        return this;
    }

    public StringBuilder(int i) {
        if (i >= 0) {
            this.chars = new char[i];
            return;
        }
        throw new NegativeArraySizeException();
    }

    public Appendable append(char c2) throws IOException {
        append0(c2);
        return this;
    }

    public StringBuilder(String str) {
        int length2 = str.length();
        this.length = length2;
        char[] cArr = new char[(length2 + 16)];
        this.chars = cArr;
        str.getChars(0, length2, cArr, 0);
    }

    public StringBuilder append(int i) {
        if (i == Integer.MIN_VALUE) {
            append0((String) "-2147483648");
        } else {
            if (i < 0) {
                append0('-');
                i = -i;
            }
            if (i >= 10000) {
                if (i >= 1000000000) {
                    append0(digits[(int) ((((long) i) % 10000000000L) / 1000000000)]);
                }
                if (i >= 100000000) {
                    append0(digits[(i % Http2Connection.DEGRADED_PONG_TIMEOUT_NS) / NetworkingModule.CHUNK_TIMEOUT_NS]);
                }
                if (i >= 10000000) {
                    append0(digits[(i % NetworkingModule.CHUNK_TIMEOUT_NS) / 10000000]);
                }
                if (i >= 1000000) {
                    append0(digits[(i % 10000000) / 1000000]);
                }
                if (i >= 100000) {
                    append0(digits[(i % 1000000) / UpdaterConstant.APK_MIN_VERSION_CODE_ID]);
                }
                append0(digits[(i % UpdaterConstant.APK_MIN_VERSION_CODE_ID) / 10000]);
            }
            if (i >= 1000) {
                append0(digits[(i % 10000) / 1000]);
            }
            if (i >= 100) {
                append0(digits[(i % 1000) / 100]);
            }
            if (i >= 10) {
                append0(digits[(i % 100) / 10]);
            }
            append0(digits[i % 10]);
        }
        return this;
    }

    public final void append0(char c2) {
        int i = this.length;
        if (i == this.chars.length) {
            enlargeBuffer(i + 1);
        }
        char[] cArr = this.chars;
        int i2 = this.length;
        this.length = i2 + 1;
        cArr[i2] = c2;
    }

    public final void append0(String str) {
        if (str == null) {
            appendNull();
            return;
        }
        int length2 = str.length();
        int i = this.length + length2;
        if (i > this.chars.length) {
            enlargeBuffer(i);
        }
        str.getChars(0, length2, this.chars, this.length);
        this.length = i;
    }

    public StringBuilder append(Object obj) {
        if (obj == null) {
            appendNull();
        } else {
            append0(obj.toString());
        }
        return this;
    }

    public StringBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            appendNull();
        } else if (charSequence instanceof StringBuilder) {
            StringBuilder stringBuilder = (StringBuilder) charSequence;
            append0(stringBuilder.chars, 0, stringBuilder.length);
        } else {
            append0(charSequence.toString());
        }
        return this;
    }
}
