package org.apache.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.common.PDMemoryStream;

public final class SampledImageReader {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[] getDecodeArray(org.apache.pdfbox.pdmodel.graphics.image.PDImage r9) throws java.io.IOException {
        /*
            org.apache.pdfbox.cos.COSArray r0 = r9.getDecode()
            if (r0 == 0) goto L_0x0089
            int r1 = r0.size()
            r2 = 16
            if (r1 == r2) goto L_0x0084
            boolean r9 = r9.isStencil()
            java.lang.String r1 = "decode array "
            if (r9 == 0) goto L_0x0070
            int r9 = r0.size()
            r2 = 2
            if (r9 < r2) goto L_0x0070
            r9 = 0
            org.apache.pdfbox.cos.COSBase r3 = r0.get(r9)
            boolean r3 = r3 instanceof org.apache.pdfbox.cos.COSNumber
            if (r3 == 0) goto L_0x0070
            r3 = 1
            org.apache.pdfbox.cos.COSBase r4 = r0.get(r3)
            boolean r4 = r4 instanceof org.apache.pdfbox.cos.COSNumber
            if (r4 == 0) goto L_0x0070
            org.apache.pdfbox.cos.COSBase r4 = r0.get(r9)
            org.apache.pdfbox.cos.COSNumber r4 = (org.apache.pdfbox.cos.COSNumber) r4
            float r4 = r4.floatValue()
            org.apache.pdfbox.cos.COSBase r5 = r0.get(r3)
            org.apache.pdfbox.cos.COSNumber r5 = (org.apache.pdfbox.cos.COSNumber) r5
            float r5 = r5.floatValue()
            r6 = 0
            int r7 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r7 < 0) goto L_0x0070
            r7 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 > 0) goto L_0x0070
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0070
            int r6 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x0070
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            r6.append(r0)
            java.lang.String r0 = " not compatible with color space, using the first two entries"
            r6.append(r0)
            r6.toString()
            float[] r0 = new float[r2]
            r0[r9] = r4
            r0[r3] = r5
            return r0
        L_0x0070:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = " not compatible with color space, using default"
            r9.append(r0)
            r9.toString()
            goto L_0x0089
        L_0x0084:
            float[] r9 = r0.toFloatArray()
            goto L_0x008a
        L_0x0089:
            r9 = 0
        L_0x008a:
            if (r9 != 0) goto L_0x0092
            r9 = 6
            float[] r9 = new float[r9]
            r9 = {0, 1065353216, 0, 1065353216, 0, 1065353216} // fill-array
        L_0x0092:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.graphics.image.SampledImageReader.getDecodeArray(org.apache.pdfbox.pdmodel.graphics.image.PDImage):float[]");
    }

    public static Bitmap getRGBImage(PDImage pDImage, COSArray cOSArray) throws IOException {
        if (pDImage.getStream() instanceof PDMemoryStream) {
            if (pDImage.getStream().getLength() == 0) {
                throw new IOException("Image stream is empty");
            }
        } else if (pDImage.getStream().getStream().getFilteredLength() == 0) {
            throw new IOException("Image stream is empty");
        }
        return BitmapFactory.decodeStream(pDImage.getStream().createInputStream());
    }
}
