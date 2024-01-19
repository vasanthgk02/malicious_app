package com.google.zxing.datamatrix.encoder;

import com.google.android.material.resources.TextAppearanceConfig;

public final class X12Encoder extends C40Encoder {
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            encodeChar(currentChar, sb);
            if (sb.length() % 3 == 0) {
                C40Encoder.writeNextTriplet(encoderContext, sb);
                int lookAheadTest = TextAppearanceConfig.lookAheadTest(encoderContext.msg, encoderContext.pos, 3);
                if (lookAheadTest != 3) {
                    encoderContext.newEncoding = lookAheadTest;
                    break;
                }
            }
        }
        handleEOD(encoderContext, sb);
    }

    public int encodeChar(char c2, StringBuilder sb) {
        if (c2 == 13) {
            sb.append(0);
        } else if (c2 == '*') {
            sb.append(1);
        } else if (c2 == '>') {
            sb.append(2);
        } else if (c2 == ' ') {
            sb.append(3);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 < 'A' || c2 > 'Z') {
            TextAppearanceConfig.illegalCharacter(c2);
            throw null;
        } else {
            sb.append((char) ((c2 - 'A') + 14));
        }
        return 1;
    }

    public int getEncodingMode() {
        return 3;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.updateSymbolInfo();
        int codewordCount = encoderContext.symbolInfo.dataCapacity - encoderContext.getCodewordCount();
        encoderContext.pos -= sb.length();
        if (encoderContext.getRemainingCharacters() > 1 || codewordCount > 1 || encoderContext.getRemainingCharacters() != codewordCount) {
            encoderContext.codewords.append(254);
        }
        if (encoderContext.newEncoding < 0) {
            encoderContext.newEncoding = 0;
        }
    }
}
