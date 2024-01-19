package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.ASCIIEncoder;
import com.google.zxing.datamatrix.encoder.Base256Encoder;
import com.google.zxing.datamatrix.encoder.C40Encoder;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.EdifactEncoder;
import com.google.zxing.datamatrix.encoder.Encoder;
import com.google.zxing.datamatrix.encoder.EncoderContext;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.TextEncoder;
import com.google.zxing.datamatrix.encoder.X12Encoder;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

public final class DataMatrixWriter implements Writer {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        int i3;
        int i4;
        String str2 = str;
        BarcodeFormat barcodeFormat2 = barcodeFormat;
        int i5 = i;
        int i6 = i2;
        Map<EncodeHintType, ?> map2 = map;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat2 != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat2);
        } else if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i5 + 'x' + i6);
        } else {
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            Dimension dimension2 = null;
            if (map2 != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map2.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                Dimension dimension3 = (Dimension) map2.get(EncodeHintType.MIN_SIZE);
                if (dimension3 == null) {
                    dimension3 = null;
                }
                Dimension dimension4 = (Dimension) map2.get(EncodeHintType.MAX_SIZE);
                if (dimension4 != null) {
                    dimension2 = dimension4;
                }
                Dimension dimension5 = dimension3;
                dimension = dimension2;
                dimension2 = dimension5;
            } else {
                dimension = null;
            }
            Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
            EncoderContext encoderContext = new EncoderContext(str2);
            encoderContext.shape = symbolShapeHint;
            encoderContext.minSize = dimension2;
            encoderContext.maxSize = dimension;
            if (str2.startsWith("[)>\u001e05\u001d") && str2.endsWith("\u001e\u0004")) {
                encoderContext.codewords.append(236);
                encoderContext.skipAtEnd = 2;
                encoderContext.pos += 7;
            } else if (str2.startsWith("[)>\u001e06\u001d") && str2.endsWith("\u001e\u0004")) {
                encoderContext.codewords.append(237);
                encoderContext.skipAtEnd = 2;
                encoderContext.pos += 7;
            }
            int i7 = 0;
            while (encoderContext.hasMoreCharacters()) {
                encoderArr[i7].encode(encoderContext);
                int i8 = encoderContext.newEncoding;
                if (i8 >= 0) {
                    encoderContext.newEncoding = -1;
                    i7 = i8;
                }
            }
            int codewordCount = encoderContext.getCodewordCount();
            encoderContext.updateSymbolInfo();
            int i9 = encoderContext.symbolInfo.dataCapacity;
            if (!(codewordCount >= i9 || i7 == 0 || i7 == 5)) {
                encoderContext.codewords.append(254);
            }
            StringBuilder sb = encoderContext.codewords;
            if (sb.length() < i9) {
                sb.append(129);
            }
            while (sb.length() < i9) {
                int length = (((sb.length() + 1) * 149) % 253) + 1 + 129;
                if (length > 254) {
                    length -= 254;
                }
                sb.append((char) length);
            }
            String sb2 = encoderContext.codewords.toString();
            SymbolInfo lookup = SymbolInfo.lookup(sb2.length(), symbolShapeHint, dimension2, dimension, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(sb2, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            int i10 = 4;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i10 == defaultPlacement.numrows && i11 == 0) {
                    defaultPlacement.module(r6 - 1, 0, i12, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 1, i12, 2);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 2, i12, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i12, 4);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i12, 5);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i12, 6);
                    defaultPlacement.module(2, defaultPlacement.numcols - 1, i12, 7);
                    defaultPlacement.module(3, defaultPlacement.numcols - 1, i12, 8);
                    i12++;
                }
                int i13 = defaultPlacement.numrows;
                if (i10 == i13 - 2 && i11 == 0 && defaultPlacement.numcols % 4 != 0) {
                    defaultPlacement.module(i13 - 3, 0, i12, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 2, 0, i12, 2);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 0, i12, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - 4, i12, 4);
                    defaultPlacement.module(0, defaultPlacement.numcols - 3, i12, 5);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i12, 6);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i12, 7);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i12, 8);
                    i12++;
                }
                int i14 = defaultPlacement.numrows;
                if (i10 == i14 - 2 && i11 == 0 && defaultPlacement.numcols % 8 == 4) {
                    defaultPlacement.module(i14 - 3, 0, i12, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 2, 0, i12, 2);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 0, i12, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i12, 4);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i12, 5);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i12, 6);
                    defaultPlacement.module(2, defaultPlacement.numcols - 1, i12, 7);
                    defaultPlacement.module(3, defaultPlacement.numcols - 1, i12, 8);
                    i12++;
                }
                if (i10 == defaultPlacement.numrows + 4 && i11 == 2 && defaultPlacement.numcols % 8 == 0) {
                    defaultPlacement.module(r6 - 1, 0, i12, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 1, defaultPlacement.numcols - 1, i12, 2);
                    defaultPlacement.module(0, defaultPlacement.numcols - 3, i12, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i12, 4);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i12, 5);
                    defaultPlacement.module(1, defaultPlacement.numcols - 3, i12, 6);
                    defaultPlacement.module(1, defaultPlacement.numcols - 2, i12, 7);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i12, 8);
                    i12++;
                }
                do {
                    if (i10 < defaultPlacement.numrows && i11 >= 0 && !defaultPlacement.hasBit(i11, i10)) {
                        defaultPlacement.utah(i10, i11, i12);
                        i12++;
                    }
                    i10 -= 2;
                    i11 += 2;
                    if (i10 < 0) {
                        break;
                    }
                } while (i11 < defaultPlacement.numcols);
                int i15 = i10 + 1;
                int i16 = i11 + 3;
                do {
                    if (i15 >= 0 && i16 < defaultPlacement.numcols && !defaultPlacement.hasBit(i16, i15)) {
                        defaultPlacement.utah(i15, i16, i12);
                        i12++;
                    }
                    i15 += 2;
                    i16 -= 2;
                    if (i15 >= defaultPlacement.numrows) {
                        break;
                    }
                } while (i16 >= 0);
                i10 = i15 + 3;
                i11 = i16 + 1;
                i3 = defaultPlacement.numrows;
                if (i10 >= i3) {
                    i4 = defaultPlacement.numcols;
                    if (i11 >= i4) {
                        break;
                    }
                }
            }
            if (!defaultPlacement.hasBit(i4 - 1, i3 - 1)) {
                defaultPlacement.setBit(defaultPlacement.numcols - 1, defaultPlacement.numrows - 1, true);
                defaultPlacement.setBit(defaultPlacement.numcols - 2, defaultPlacement.numrows - 2, true);
            }
            int symbolDataWidth = lookup.getSymbolDataWidth();
            int symbolDataHeight = lookup.getSymbolDataHeight();
            ByteMatrix byteMatrix = new ByteMatrix(lookup.getSymbolWidth(), lookup.getSymbolHeight());
            int i17 = 0;
            for (int i18 = 0; i18 < symbolDataHeight; i18++) {
                if (i18 % lookup.matrixHeight == 0) {
                    int i19 = 0;
                    for (int i20 = 0; i20 < lookup.getSymbolWidth(); i20++) {
                        byteMatrix.set(i19, i17, i20 % 2 == 0);
                        i19++;
                    }
                    i17++;
                }
                int i21 = 0;
                for (int i22 = 0; i22 < symbolDataWidth; i22++) {
                    if (i22 % lookup.matrixWidth == 0) {
                        byteMatrix.set(i21, i17, true);
                        i21++;
                    }
                    byteMatrix.set(i21, i17, defaultPlacement.bits[(defaultPlacement.numcols * i18) + i22] == 1);
                    i21++;
                    int i23 = lookup.matrixWidth;
                    if (i22 % i23 == i23 - 1) {
                        byteMatrix.set(i21, i17, i18 % 2 == 0);
                        i21++;
                    }
                }
                i17++;
                int i24 = lookup.matrixHeight;
                if (i18 % i24 == i24 - 1) {
                    int i25 = 0;
                    for (int i26 = 0; i26 < lookup.getSymbolWidth(); i26++) {
                        byteMatrix.set(i25, i17, true);
                        i25++;
                    }
                    i17++;
                }
            }
            int i27 = byteMatrix.width;
            int i28 = byteMatrix.height;
            BitMatrix bitMatrix = new BitMatrix(i27, i28);
            int length2 = bitMatrix.bits.length;
            for (int i29 = 0; i29 < length2; i29++) {
                bitMatrix.bits[i29] = 0;
            }
            for (int i30 = 0; i30 < i27; i30++) {
                for (int i31 = 0; i31 < i28; i31++) {
                    if (byteMatrix.get(i30, i31) == 1) {
                        bitMatrix.set(i30, i31);
                    }
                }
            }
            return bitMatrix;
        }
    }
}
