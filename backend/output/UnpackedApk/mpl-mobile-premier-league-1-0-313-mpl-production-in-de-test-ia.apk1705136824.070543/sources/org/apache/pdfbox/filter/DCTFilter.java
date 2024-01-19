package org.apache.pdfbox.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.IOUtils;

public final class DCTFilter extends Filter {
    public static int clamp(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 255.0f) {
            f2 = 255.0f;
        }
        return (int) f2;
    }

    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        IOUtils.copy(inputStream, outputStream);
        return new DecodeResult(cOSDictionary);
    }

    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
    }
}
