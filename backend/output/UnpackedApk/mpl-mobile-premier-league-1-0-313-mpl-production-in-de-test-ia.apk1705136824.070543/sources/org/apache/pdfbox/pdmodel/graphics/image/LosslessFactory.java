package org.apache.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.filter.FilterFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.util.awt.AWTColor;

public final class LosslessFactory {
    public static PDImageXObject createAlphaFromARGBImage(PDDocument pDDocument, Bitmap bitmap) throws IOException {
        if (!bitmap.hasAlpha()) {
            return null;
        }
        bitmap.extractAlpha().getPixels(null, 0, 0, 0, 0, bitmap.getWidth(), bitmap.getHeight());
        new ByteArrayOutputStream();
        throw null;
    }

    public static PDImageXObject createAlphaFromARGBImage2(PDDocument pDDocument, Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int height = bitmap.getHeight();
        for (int i = 0; i < height; i++) {
            int width = bitmap.getWidth();
            for (int i2 = 0; i2 < width; i2++) {
                byteArrayOutputStream.write(Color.alpha(bitmap.getPixel(i2, i)));
            }
        }
        return prepareImageXObject(pDDocument, byteArrayOutputStream.toByteArray(), bitmap.getWidth(), bitmap.getHeight(), 8, PDDeviceGray.INSTANCE);
    }

    public static PDImageXObject createFromImage(PDDocument pDDocument, Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        PDDeviceRGB pDDeviceRGB = PDDeviceRGB.INSTANCE;
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                AWTColor aWTColor = new AWTColor(bitmap.getPixel(i2, i));
                byteArrayOutputStream.write(aWTColor.getRed());
                byteArrayOutputStream.write(aWTColor.getGreen());
                byteArrayOutputStream.write(aWTColor.getBlue());
            }
        }
        PDImageXObject prepareImageXObject = prepareImageXObject(pDDocument, byteArrayOutputStream.toByteArray(), bitmap.getWidth(), bitmap.getHeight(), 8, pDDeviceRGB);
        PDImageXObject createAlphaFromARGBImage = createAlphaFromARGBImage(pDDocument, bitmap);
        if (createAlphaFromARGBImage != null) {
            prepareImageXObject.getCOSStream().setItem(COSName.SMASK, (COSObjectable) createAlphaFromARGBImage);
        }
        return prepareImageXObject;
    }

    public static PDImageXObject prepareImageXObject(PDDocument pDDocument, byte[] bArr, int i, int i2, int i3, PDColorSpace pDColorSpace) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = bArr;
        FilterFactory.INSTANCE.getFilter(COSName.FLATE_DECODE).encode(new ByteArrayInputStream(bArr), byteArrayOutputStream, new COSDictionary(), 0);
        PDImageXObject pDImageXObject = new PDImageXObject(pDDocument, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), COSName.FLATE_DECODE, i, i2, i3, pDColorSpace);
        return pDImageXObject;
    }
}
