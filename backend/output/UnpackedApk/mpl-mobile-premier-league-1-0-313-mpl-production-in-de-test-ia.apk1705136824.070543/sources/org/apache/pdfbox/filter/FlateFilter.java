package org.apache.pdfbox.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public final class FlateFilter extends Filter {
    public static final int BUFFER_SIZE = 16348;

    public static void decompress(InputStream inputStream, OutputStream outputStream) throws IOException, DataFormatException {
        byte[] bArr = new byte[2048];
        int read = inputStream.read(bArr);
        if (read > 0) {
            Inflater inflater = new Inflater();
            inflater.setInput(bArr, 0, read);
            byte[] bArr2 = new byte[2048];
            while (true) {
                int inflate = inflater.inflate(bArr2);
                if (inflate == 0) {
                    if (inflater.finished() || inflater.needsDictionary() || inputStream.available() == 0) {
                        break;
                    }
                    inflater.setInput(bArr, 0, inputStream.read(bArr));
                } else {
                    outputStream.write(bArr2, 0, inflate);
                }
            }
        }
        outputStream.flush();
    }

    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        COSDictionary decodeParams = Filter.getDecodeParams(cOSDictionary, i);
        int i2 = decodeParams != null ? decodeParams.getInt(COSName.PREDICTOR) : -1;
        if (i2 > 1) {
            try {
                int min = Math.min(decodeParams.getInt(COSName.COLORS, 1), 32);
                int i3 = decodeParams.getInt(COSName.BITS_PER_COMPONENT, 8);
                int i4 = decodeParams.getInt(COSName.COLUMNS, 1);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decompress(inputStream, byteArrayOutputStream);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                Predictor.decodePredictor(i2, min, i3, i4, byteArrayInputStream, outputStream);
                outputStream.flush();
                byteArrayOutputStream.reset();
                byteArrayInputStream.reset();
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } else {
            decompress(inputStream, outputStream);
        }
        return new DecodeResult(cOSDictionary);
    }

    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream);
        int available = inputStream.available();
        if (available > 0) {
            byte[] bArr = new byte[Math.min(available, BUFFER_SIZE)];
            while (true) {
                int read = inputStream.read(bArr, 0, Math.min(available, BUFFER_SIZE));
                if (read == -1) {
                    break;
                }
                deflaterOutputStream.write(bArr, 0, read);
            }
        }
        deflaterOutputStream.close();
        outputStream.flush();
    }
}
