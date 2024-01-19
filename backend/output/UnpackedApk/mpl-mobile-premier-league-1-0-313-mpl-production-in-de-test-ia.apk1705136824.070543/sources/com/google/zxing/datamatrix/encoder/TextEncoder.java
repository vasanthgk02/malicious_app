package com.google.zxing.datamatrix.encoder;

import com.google.android.material.resources.TextAppearanceConfig;

public final class TextEncoder extends C40Encoder {
    public int encodeChar(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append(3);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        } else if (c2 >= 'a' && c2 <= 'z') {
            sb.append((char) ((c2 - 'a') + 14));
            return 1;
        } else if (c2 >= 0 && c2 <= 31) {
            sb.append(0);
            sb.append(c2);
            return 2;
        } else if (c2 >= '!' && c2 <= '/') {
            sb.append(1);
            sb.append((char) (c2 - '!'));
            return 2;
        } else if (c2 >= ':' && c2 <= '@') {
            sb.append(1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        } else if (c2 >= '[' && c2 <= '_') {
            sb.append(1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        } else if (c2 == '`') {
            sb.append(2);
            sb.append((char) (c2 - '`'));
            return 2;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append(2);
            sb.append((char) ((c2 - 'A') + 1));
            return 2;
        } else if (c2 >= '{' && c2 <= 127) {
            sb.append(2);
            sb.append((char) ((c2 - '{') + 27));
            return 2;
        } else if (c2 >= 128) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c2 - 128), sb) + 2;
        } else {
            TextAppearanceConfig.illegalCharacter(c2);
            throw null;
        }
    }

    public int getEncodingMode() {
        return 2;
    }
}
