package com.yalantis.ucrop.util;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import sfs2x.client.entities.invitation.InvitationReply;

public class ImageHeaderParser {
    public static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    public static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public final Reader reader;

    public interface Reader {
    }

    public static class StreamReader implements Reader {
        public final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        public int getUInt16() throws IOException {
            return ((this.is.read() << 8) & 65280) | (this.is.read() & InvitationReply.EXPIRED);
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new StreamReader(inputStream);
    }

    public static void copyExif(ExifInterface exifInterface, int i, int i2, String str) {
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (int i3 = 0; i3 < 22; i3++) {
                String str2 = strArr[i3];
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute("ImageWidth", String.valueOf(i));
            exifInterface2.setAttribute("ImageLength", String.valueOf(i2));
            exifInterface2.setAttribute("Orientation", "0");
            exifInterface2.saveAttributes();
        } catch (IOException e2) {
            e2.getMessage();
        }
    }

    public int getOrientation() throws IOException {
        int i;
        ByteOrder byteOrder;
        int uInt16 = ((StreamReader) this.reader).getUInt16();
        short s = -1;
        if (!((uInt16 & 65496) == 65496 || uInt16 == 19789 || uInt16 == 18761)) {
            boolean isLoggable = Log.isLoggable("ImageHeaderParser", 3);
            return -1;
        }
        while (true) {
            if (((short) (((StreamReader) this.reader).is.read() & InvitationReply.EXPIRED)) == 255) {
                short read = (short) (((StreamReader) this.reader).is.read() & InvitationReply.EXPIRED);
                if (read != 218) {
                    if (read != 217) {
                        i = ((StreamReader) this.reader).getUInt16() - 2;
                        if (read == 225) {
                            break;
                        }
                        long j = (long) i;
                        StreamReader streamReader = (StreamReader) this.reader;
                        if (streamReader != null) {
                            long j2 = 0;
                            if (j >= 0) {
                                long j3 = j;
                                while (j3 > 0) {
                                    long skip = streamReader.is.skip(j3);
                                    if (skip <= 0) {
                                        if (streamReader.is.read() == -1) {
                                            break;
                                        }
                                        skip = 1;
                                    }
                                    j3 -= skip;
                                }
                                j2 = j - j3;
                            }
                            if (j2 != j) {
                                Log.isLoggable("ImageHeaderParser", 3);
                                break;
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        Log.isLoggable("ImageHeaderParser", 3);
                        break;
                    }
                } else {
                    break;
                }
            } else {
                Log.isLoggable("ImageHeaderParser", 3);
                break;
            }
        }
        i = -1;
        if (i == -1) {
            boolean isLoggable2 = Log.isLoggable("ImageHeaderParser", 3);
            return -1;
        }
        byte[] bArr = new byte[i];
        StreamReader streamReader2 = (StreamReader) this.reader;
        if (streamReader2 != null) {
            int i2 = i;
            while (i2 > 0) {
                int read2 = streamReader2.is.read(bArr, i - i2, i2);
                if (read2 == -1) {
                    break;
                }
                i2 -= read2;
            }
            if (i - i2 != i) {
                Log.isLoggable("ImageHeaderParser", 3);
            } else {
                boolean z = i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
                if (z) {
                    int i3 = 0;
                    while (true) {
                        byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                        if (i3 >= bArr2.length) {
                            break;
                        } else if (bArr[i3] != bArr2[i3]) {
                            z = false;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (z) {
                    ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
                    short s2 = byteBuffer.getShort(6);
                    if (s2 == 19789) {
                        byteOrder = ByteOrder.BIG_ENDIAN;
                    } else if (s2 == 18761) {
                        byteOrder = ByteOrder.LITTLE_ENDIAN;
                    } else {
                        Log.isLoggable("ImageHeaderParser", 3);
                        byteOrder = ByteOrder.BIG_ENDIAN;
                    }
                    byteBuffer.order(byteOrder);
                    int i4 = byteBuffer.getInt(10) + 6;
                    short s3 = byteBuffer.getShort(i4);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= s3) {
                            break;
                        }
                        int i6 = (i5 * 12) + i4 + 2;
                        if (byteBuffer.getShort(i6) == 274) {
                            short s4 = byteBuffer.getShort(i6 + 2);
                            if (s4 >= 1 && s4 <= 12) {
                                int i7 = byteBuffer.getInt(i6 + 4);
                                if (i7 >= 0) {
                                    Log.isLoggable("ImageHeaderParser", 3);
                                    int i8 = i7 + BYTES_PER_FORMAT[s4];
                                    if (i8 <= 4) {
                                        int i9 = i6 + 8;
                                        if (i9 >= 0 && i9 <= byteBuffer.remaining()) {
                                            if (i8 >= 0 && i8 + i9 <= byteBuffer.remaining()) {
                                                s = byteBuffer.getShort(i9);
                                                break;
                                            }
                                            Log.isLoggable("ImageHeaderParser", 3);
                                        } else {
                                            Log.isLoggable("ImageHeaderParser", 3);
                                        }
                                    } else {
                                        Log.isLoggable("ImageHeaderParser", 3);
                                    }
                                } else {
                                    Log.isLoggable("ImageHeaderParser", 3);
                                }
                            } else {
                                Log.isLoggable("ImageHeaderParser", 3);
                            }
                        }
                        i5++;
                    }
                } else {
                    Log.isLoggable("ImageHeaderParser", 3);
                }
            }
            return s;
        }
        throw null;
    }
}
