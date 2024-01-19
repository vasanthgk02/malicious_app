package org.objectweb.asm;

import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;

public class TypePath {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f6245a;

    /* renamed from: b  reason: collision with root package name */
    public int f6246b;

    public TypePath(byte[] bArr, int i) {
        this.f6245a = bArr;
        this.f6246b = i;
    }

    public String toString() {
        char c2;
        byte b2 = this.f6245a[this.f6246b];
        StringBuffer stringBuffer = new StringBuffer(b2 * 2);
        for (int i = 0; i < b2; i++) {
            byte[] bArr = this.f6245a;
            int i2 = this.f6246b;
            int i3 = i * 2;
            byte b3 = bArr[i3 + i2 + 1];
            if (b3 == 0) {
                c2 = '[';
            } else if (b3 == 1) {
                c2 = '.';
            } else if (b3 == 2) {
                c2 = '*';
            } else if (b3 != 3) {
                c2 = '_';
            } else {
                stringBuffer.append(bArr[i3 + i2 + 2]);
                c2 = DefaultObjectDumpFormatter.TOKEN_DIVIDER;
            }
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
