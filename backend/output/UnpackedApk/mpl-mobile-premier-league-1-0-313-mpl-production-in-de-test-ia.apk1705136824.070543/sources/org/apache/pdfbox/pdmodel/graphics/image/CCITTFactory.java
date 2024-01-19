package org.apache.pdfbox.pdmodel.graphics.image;

import androidx.core.app.NotificationManagerCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccess;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;

public final class CCITTFactory {
    public static PDImageXObject createFromFile(PDDocument pDDocument, File file) throws IOException {
        return createFromRandomAccessImpl(pDDocument, new RandomAccessFile(file, "r"), 0);
    }

    @Deprecated
    public static PDImageXObject createFromRandomAccess(PDDocument pDDocument, RandomAccess randomAccess) throws IOException {
        return createFromRandomAccessImpl(pDDocument, randomAccess, 0);
    }

    public static PDImageXObject createFromRandomAccessImpl(PDDocument pDDocument, RandomAccess randomAccess, int i) throws IOException {
        COSDictionary cOSDictionary = new COSDictionary();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        extractFromTiff(randomAccess, byteArrayOutputStream, cOSDictionary, i);
        if (byteArrayOutputStream.size() == 0) {
            return null;
        }
        PDImageXObject pDImageXObject = new PDImageXObject(pDDocument, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), COSName.CCITTFAX_DECODE, cOSDictionary.getInt(COSName.COLUMNS), cOSDictionary.getInt(COSName.ROWS), 1, PDDeviceGray.INSTANCE);
        pDImageXObject.getCOSStream().setItem(COSName.DECODE_PARMS, (COSBase) cOSDictionary);
        return pDImageXObject;
    }

    public static void extractFromTiff(RandomAccess randomAccess, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        RandomAccess randomAccess2 = randomAccess;
        COSDictionary cOSDictionary2 = cOSDictionary;
        try {
            randomAccess2.seek(0);
            char read = (char) randomAccess.read();
            if (((char) randomAccess.read()) != read) {
                OutputStream outputStream2 = outputStream;
                throw new IOException("Not a valid tiff file");
            } else if (read != 'M' && read != 'I') {
                throw new IOException("Not a valid tiff file");
            } else if (readshort(read, randomAccess2) == 42) {
                int readlong = readlong(read, randomAccess2);
                randomAccess2.seek((long) readlong);
                int i2 = 0;
                while (i2 < i) {
                    int readshort = readshort(read, randomAccess2);
                    if (readshort <= 50) {
                        randomAccess2.seek((long) ((readshort * 12) + readlong + 2));
                        readlong = readlong(read, randomAccess2);
                        if (readlong == 0) {
                            outputStream.close();
                            return;
                        } else {
                            randomAccess2.seek((long) readlong);
                            i2++;
                        }
                    } else {
                        throw new IOException("Not a valid tiff file");
                    }
                }
                int readshort2 = readshort(read, randomAccess2);
                if (readshort2 <= 50) {
                    int i3 = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < readshort2; i6++) {
                        int readshort3 = readshort(read, randomAccess2);
                        int readshort4 = readshort(read, randomAccess2);
                        int readlong2 = readlong(read, randomAccess2);
                        int readlong3 = readlong(read, randomAccess2);
                        if (read == 'M') {
                            if (readshort4 == 1) {
                                readlong3 >>= 24;
                            } else if (readshort4 == 3) {
                                readlong3 >>= 16;
                            }
                        }
                        if (readshort3 == 256) {
                            cOSDictionary2.setInt(COSName.COLUMNS, readlong3);
                        } else if (readshort3 == 257) {
                            cOSDictionary2.setInt(COSName.ROWS, readlong3);
                        } else if (readshort3 == 259) {
                            if (readlong3 == 4) {
                                i3 = -1;
                            }
                            if (readlong3 == 3) {
                                i3 = 0;
                            }
                        } else if (readshort3 != 262) {
                            if (readshort3 != 273) {
                                if (readshort3 != 279) {
                                    if (readshort3 == 292) {
                                        if ((readlong3 & 1) != 0) {
                                            i3 = 50;
                                        }
                                        if ((readlong3 & 4) != 0) {
                                            throw new IOException("CCITT Group 3 'uncompressed mode' is not supported");
                                        } else if ((readlong3 & 2) != 0) {
                                            throw new IOException("CCITT Group 3 'fill bits before EOL' is not supported");
                                        }
                                    } else if (readshort3 != 324) {
                                        if (readshort3 == 325) {
                                            if (readlong2 == 1) {
                                            }
                                        }
                                    } else if (readlong2 == 1) {
                                    }
                                } else if (readlong2 != 1) {
                                }
                                i5 = readlong3;
                            } else if (readlong2 != 1) {
                            }
                            i4 = readlong3;
                        } else if (readlong3 == 1) {
                            cOSDictionary2.setBoolean(COSName.BLACK_IS_1, true);
                        }
                    }
                    if (i3 == -1000) {
                        OutputStream outputStream3 = outputStream;
                        throw new IOException("First image in tiff is not CCITT T4 or T6 compressed");
                    } else if (i4 != 0) {
                        cOSDictionary2.setInt(COSName.K, i3);
                        randomAccess2.seek((long) i4);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read2 = randomAccess2.read(bArr, 0, Math.min(8192, i5));
                            if (read2 > 0) {
                                i5 -= read2;
                                try {
                                    outputStream.write(bArr, 0, read2);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } else {
                                OutputStream outputStream4 = outputStream;
                                outputStream.close();
                                return;
                            }
                        }
                    } else {
                        OutputStream outputStream5 = outputStream;
                        throw new IOException("First image in tiff is not a single tile/strip");
                    }
                } else {
                    OutputStream outputStream6 = outputStream;
                    throw new IOException("Not a valid tiff file");
                }
            } else {
                OutputStream outputStream7 = outputStream;
                throw new IOException("Not a valid tiff file");
            }
        } catch (Throwable th2) {
            th = th2;
            OutputStream outputStream8 = outputStream;
            outputStream.close();
            throw th;
        }
    }

    public static int readlong(char c2, RandomAccess randomAccess) throws IOException {
        int read;
        int read2;
        if (c2 == 'I') {
            read = randomAccess.read() | (randomAccess.read() << 8) | (randomAccess.read() << 16);
            read2 = randomAccess.read() << 24;
        } else {
            read = (randomAccess.read() << 24) | (randomAccess.read() << 16) | (randomAccess.read() << 8);
            read2 = randomAccess.read();
        }
        return read | read2;
    }

    public static int readshort(char c2, RandomAccess randomAccess) throws IOException {
        int read;
        int read2;
        if (c2 == 'I') {
            read = randomAccess.read();
            read2 = randomAccess.read() << 8;
        } else {
            read = randomAccess.read() << 8;
            read2 = randomAccess.read();
        }
        return read | read2;
    }

    public static PDImageXObject createFromFile(PDDocument pDDocument, File file, int i) throws IOException {
        return createFromRandomAccessImpl(pDDocument, new RandomAccessFile(file, "r"), i);
    }

    @Deprecated
    public static PDImageXObject createFromRandomAccess(PDDocument pDDocument, RandomAccess randomAccess, int i) throws IOException {
        return createFromRandomAccessImpl(pDDocument, randomAccess, i);
    }
}
