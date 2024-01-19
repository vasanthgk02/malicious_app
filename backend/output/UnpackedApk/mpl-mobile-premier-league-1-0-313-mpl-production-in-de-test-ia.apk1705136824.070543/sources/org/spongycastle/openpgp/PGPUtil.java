package org.spongycastle.openpgp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.bcpg.ArmoredInputStream;
import org.spongycastle.util.encoders.Base64;

public class PGPUtil {

    public static class BufferedInputStreamExt extends BufferedInputStream {
        public BufferedInputStreamExt(InputStream inputStream) {
            super(inputStream);
        }

        public synchronized int available() throws IOException {
            int available;
            available = super.available();
            if (available < 0) {
                available = Integer.MAX_VALUE;
            }
            return available;
        }
    }

    public static InputStream getDecoderStream(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStreamExt(inputStream);
        }
        inputStream.mark(60);
        int read = inputStream.read();
        if ((read & 128) != 0) {
            inputStream.reset();
            return inputStream;
        } else if (!isPossiblyBase64(read)) {
            inputStream.reset();
            return new ArmoredInputStream(inputStream, true);
        } else {
            byte[] bArr = new byte[60];
            bArr[0] = (byte) read;
            int i = 1;
            int i2 = 1;
            while (i != 60) {
                int read2 = inputStream.read();
                if (read2 < 0) {
                    break;
                } else if (!isPossiblyBase64(read2)) {
                    inputStream.reset();
                    return new ArmoredInputStream(inputStream, true);
                } else {
                    if (!(read2 == 10 || read2 == 13)) {
                        bArr[i2] = (byte) read2;
                        i2++;
                    }
                    i++;
                }
            }
            inputStream.reset();
            if (i < 4) {
                return new ArmoredInputStream(inputStream, true);
            }
            byte[] bArr2 = new byte[8];
            System.arraycopy(bArr, 0, bArr2, 0, 8);
            if ((Base64.decode(bArr2)[0] & 128) != 0) {
                return new ArmoredInputStream(inputStream, false);
            }
            return new ArmoredInputStream(inputStream, true);
        }
    }

    public static boolean isPossiblyBase64(int i) {
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122) || ((i >= 48 && i <= 57) || i == 43 || i == 47 || i == 13 || i == 10);
    }
}
