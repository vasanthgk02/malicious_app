package com.google.zxing.datamatrix.encoder;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;

public final class ASCIIEncoder implements Encoder {
    public void encode(EncoderContext encoderContext) {
        int i;
        String str = encoderContext.msg;
        int i2 = encoderContext.pos;
        int length = str.length();
        if (i2 < length) {
            char charAt = str.charAt(i2);
            i = 0;
            while (TextAppearanceConfig.isDigit(charAt) && i2 < length) {
                i++;
                i2++;
                if (i2 < length) {
                    charAt = str.charAt(i2);
                }
            }
        } else {
            i = 0;
        }
        if (i >= 2) {
            char charAt2 = encoderContext.msg.charAt(encoderContext.pos);
            char charAt3 = encoderContext.msg.charAt(encoderContext.pos + 1);
            if (!TextAppearanceConfig.isDigit(charAt2) || !TextAppearanceConfig.isDigit(charAt3)) {
                throw new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            }
            encoderContext.codewords.append((char) GeneratedOutlineSupport.outline6(charAt3, -48, (charAt2 - '0') * 10, 130));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int lookAheadTest = TextAppearanceConfig.lookAheadTest(encoderContext.msg, encoderContext.pos, 0);
        if (lookAheadTest != 0) {
            if (lookAheadTest == 1) {
                encoderContext.codewords.append(230);
                encoderContext.newEncoding = 1;
            } else if (lookAheadTest == 2) {
                encoderContext.codewords.append(239);
                encoderContext.newEncoding = 2;
            } else if (lookAheadTest == 3) {
                encoderContext.codewords.append(238);
                encoderContext.newEncoding = 3;
            } else if (lookAheadTest == 4) {
                encoderContext.codewords.append(240);
                encoderContext.newEncoding = 4;
            } else if (lookAheadTest == 5) {
                encoderContext.codewords.append(231);
                encoderContext.newEncoding = 5;
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline40("Illegal mode: ", lookAheadTest));
            }
        } else if (TextAppearanceConfig.isExtendedASCII(currentChar)) {
            encoderContext.codewords.append(235);
            encoderContext.codewords.append((char) ((currentChar - 128) + 1));
            encoderContext.pos++;
        } else {
            encoderContext.codewords.append((char) (currentChar + 1));
            encoderContext.pos++;
        }
    }
}
