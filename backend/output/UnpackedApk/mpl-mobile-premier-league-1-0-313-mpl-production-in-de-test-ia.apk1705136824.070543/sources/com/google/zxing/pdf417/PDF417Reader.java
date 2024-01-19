package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public final class PDF417Reader {
    public static int getMaxWidth(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) Math.abs(resultPoint.x - resultPoint2.x);
    }

    public static int getMinWidth(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(resultPoint.x - resultPoint2.x);
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException, ChecksumException {
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        ArrayList arrayList = new ArrayList();
        if (binaryBitmap2.matrix == null) {
            binaryBitmap2.matrix = binaryBitmap2.binarizer.getBlackMatrix();
        }
        BitMatrix bitMatrix = binaryBitmap2.matrix;
        List<ResultPoint[]> detect = Detector.detect(false, bitMatrix);
        if (((ArrayList) detect).isEmpty()) {
            BitMatrix bitMatrix2 = new BitMatrix(bitMatrix.width, bitMatrix.height, bitMatrix.rowSize, (int[]) bitMatrix.bits.clone());
            int i = bitMatrix2.width;
            int i2 = bitMatrix2.height;
            BitArray bitArray = new BitArray(i);
            BitArray bitArray2 = new BitArray(i);
            for (int i3 = 0; i3 < (i2 + 1) / 2; i3++) {
                bitArray = bitMatrix2.getRow(i3, bitArray);
                int i4 = (i2 - 1) - i3;
                bitArray2 = bitMatrix2.getRow(i4, bitArray2);
                bitArray.reverse();
                bitArray2.reverse();
                int[] iArr = bitArray2.bits;
                int[] iArr2 = bitMatrix2.bits;
                int i5 = bitMatrix2.rowSize;
                System.arraycopy(iArr, 0, iArr2, i3 * i5, i5);
                int[] iArr3 = bitArray.bits;
                int[] iArr4 = bitMatrix2.bits;
                int i6 = bitMatrix2.rowSize;
                System.arraycopy(iArr3, 0, iArr4, i4 * i6, i6);
            }
            BitMatrix bitMatrix3 = bitMatrix2;
            detect = Detector.detect(false, bitMatrix2);
            bitMatrix = bitMatrix3;
        }
        for (ResultPoint[] next : detect) {
            DecoderResult decode = PDF417ScanningDecoder.decode(bitMatrix, next[4], next[5], next[6], next[7], Math.min(Math.min(getMinWidth(next[0], next[4]), (getMinWidth(next[6], next[2]) * 17) / 18), Math.min(getMinWidth(next[1], next[5]), (getMinWidth(next[7], next[3]) * 17) / 18)), Math.max(Math.max(getMaxWidth(next[0], next[4]), (getMaxWidth(next[6], next[2]) * 17) / 18), Math.max(getMaxWidth(next[1], next[5]), (getMaxWidth(next[7], next[3]) * 17) / 18)));
            Result result = new Result(decode.text, decode.rawBytes, next, BarcodeFormat.PDF_417);
            ResultMetadataType resultMetadataType = ResultMetadataType.ERROR_CORRECTION_LEVEL;
            String str = decode.ecLevel;
            if (result.resultMetadata == null) {
                result.resultMetadata = new EnumMap(ResultMetadataType.class);
            }
            result.resultMetadata.put(resultMetadataType, str);
            PDF417ResultMetadata pDF417ResultMetadata = (PDF417ResultMetadata) decode.other;
            if (pDF417ResultMetadata != null) {
                ResultMetadataType resultMetadataType2 = ResultMetadataType.PDF417_EXTRA_METADATA;
                if (result.resultMetadata == null) {
                    result.resultMetadata = new EnumMap(ResultMetadataType.class);
                }
                result.resultMetadata.put(resultMetadataType2, pDF417ResultMetadata);
            }
            arrayList.add(result);
        }
        Result[] resultArr = (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        if (resultArr != null && resultArr.length != 0 && resultArr[0] != null) {
            return resultArr[0];
        }
        throw NotFoundException.INSTANCE;
    }
}
