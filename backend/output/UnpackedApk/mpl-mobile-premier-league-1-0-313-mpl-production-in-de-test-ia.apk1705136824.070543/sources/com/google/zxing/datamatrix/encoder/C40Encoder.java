package com.google.zxing.datamatrix.encoder;

import com.google.android.material.resources.TextAppearanceConfig;

public class C40Encoder implements Encoder {
    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        char charAt = sb.charAt(0);
        int charAt2 = (sb.charAt(1) * '(') + (charAt * 1600) + sb.charAt(2) + 1;
        encoderContext.codewords.append(new String(new char[]{(char) (charAt2 / 256), (char) (charAt2 % 256)}));
        sb.delete(0, 3);
    }

    public final int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        encoderContext.pos--;
        int encodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.symbolInfo = null;
        return encodeChar;
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int i = encoderContext.symbolInfo.dataCapacity - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (i < 2 || i > 2)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
                while (sb.length() % 3 == 1 && ((encodeChar <= 3 && i != 1) || encodeChar > 3)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
            } else if (sb.length() % 3 == 0) {
                int lookAheadTest = TextAppearanceConfig.lookAheadTest(encoderContext.msg, encoderContext.pos, getEncodingMode());
                if (lookAheadTest != getEncodingMode()) {
                    encoderContext.newEncoding = lookAheadTest;
                    break;
                }
            }
        }
        handleEOD(encoderContext, sb);
    }

    public int encodeChar(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append(3);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
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
        } else if (c2 >= '`' && c2 <= 127) {
            sb.append(2);
            sb.append((char) (c2 - '`'));
            return 2;
        } else if (c2 >= 128) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c2 - 128), sb) + 2;
        } else {
            throw new IllegalArgumentException("Illegal character: " + c2);
        }
    }

    public int getEncodingMode() {
        return 1;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        int length = sb.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
        encoderContext.updateSymbolInfo(codewordCount);
        int i = encoderContext.symbolInfo.dataCapacity - codewordCount;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.codewords.append(254);
            }
        } else if (i == 1 && length == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.codewords.append(254);
            }
            encoderContext.pos--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (i > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.codewords.append(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.newEncoding = 0;
    }
}
