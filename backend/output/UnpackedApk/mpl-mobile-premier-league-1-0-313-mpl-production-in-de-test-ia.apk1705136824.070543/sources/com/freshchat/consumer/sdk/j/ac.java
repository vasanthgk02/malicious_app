package com.freshchat.consumer.sdk.j;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.jboss.netty.util.internal.jzlib.Deflate;
import sfs2x.client.requests.BaseRequest;

public class ac {
    public static SimpleDateFormat hL;
    public static final String[] hM = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    public static final int[] hN = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    public static final byte[] hO = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final c[] hP;
    public static final c[] hQ;
    public static final c[] hR = {new c((String) "GPSVersionID", 0, 1), new c((String) "GPSLatitudeRef", 1, 2), new c((String) "GPSLatitude", 2, 5), new c((String) "GPSLongitudeRef", 3, 2), new c((String) "GPSLongitude", 4, 5), new c((String) "GPSAltitudeRef", 5, 1), new c((String) "GPSAltitude", 6, 5), new c((String) "GPSTimeStamp", 7, 5), new c((String) "GPSSatellites", 8, 2), new c((String) "GPSStatus", 9, 2), new c((String) "GPSMeasureMode", 10, 2), new c((String) "GPSDOP", 11, 5), new c((String) "GPSSpeedRef", 12, 2), new c((String) "GPSSpeed", 13, 5), new c((String) "GPSTrackRef", 14, 2), new c((String) "GPSTrack", 15, 5), new c((String) "GPSImgDirectionRef", 16, 2), new c((String) "GPSImgDirection", 17, 5), new c((String) "GPSMapDatum", 18, 2), new c((String) "GPSDestLatitudeRef", 19, 2), new c((String) "GPSDestLatitude", 20, 5), new c((String) "GPSDestLongitudeRef", 21, 2), new c((String) "GPSDestLongitude", 22, 5), new c((String) "GPSDestBearingRef", 23, 2), new c((String) "GPSDestBearing", 24, 5), new c((String) "GPSDestDistanceRef", 25, 2), new c((String) "GPSDestDistance", 26, 5), new c((String) "GPSProcessingMethod", 27, 7), new c((String) "GPSAreaInformation", 28, 7), new c((String) "GPSDateStamp", 29, 2), new c((String) "GPSDifferential", 30, 3)};
    public static final c[] hS = {new c((String) "InteroperabilityIndex", 1, 2)};
    public static final c[] hT;
    public static final c[][] hU;
    public static final c[] hV = {new c((String) "ExifIFDPointer", 34665, 4), new c((String) "GPSInfoIFDPointer", (int) GL30.GL_DRAW_BUFFER0, 4), new c((String) "InteroperabilityIFDPointer", 40965, 4)};
    public static final int[] hW = {1, 2, 3};
    public static final c hX = new c((String) "JPEGInterchangeFormat", (int) GL20.GL_LESS, 4);
    public static final c hY = new c((String) "JPEGInterchangeFormatLength", (int) GL20.GL_EQUAL, 4);
    public static final HashMap[] hZ;
    public static final HashMap[] ia;
    public static final HashSet<String> ib = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    public static final Charset ic;
    public static final byte[] ie;
    public static final Pattern il = Pattern.compile(".*[1-9].*");
    public static final Pattern im = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");

    /* renamed from: if  reason: not valid java name */
    public final String f3if;
    public final HashMap[] ig = new HashMap[hU.length];
    public ByteOrder ih = ByteOrder.BIG_ENDIAN;
    public boolean ii;
    public int ij;
    public int ik;

    public static class a extends ByteArrayInputStream {
        public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: in  reason: collision with root package name */
        public ByteOrder f1714in = ByteOrder.BIG_ENDIAN;

        /* renamed from: io  reason: collision with root package name */
        public final long f1715io;
        public long ip;

        public a(byte[] bArr) {
            super(bArr);
            this.f1715io = (long) bArr.length;
            this.ip = 0;
        }

        public long eJ() {
            return this.ip;
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr) throws IOException {
            long length = this.ip + ((long) bArr.length);
            this.ip = length;
            if (length > this.f1715io) {
                throw new EOFException();
            } else if (super.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            long j = this.ip + 4;
            this.ip = j;
            if (j <= this.f1715io) {
                int read = super.read();
                int read2 = super.read();
                int read3 = super.read();
                int read4 = super.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f1714in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.f1714in);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long readLong() throws IOException {
            long j = this.ip + 8;
            this.ip = j;
            if (j <= this.f1715io) {
                int read = super.read();
                int read2 = super.read();
                int read3 = super.read();
                int read4 = super.read();
                int read5 = super.read();
                int read6 = super.read();
                int read7 = super.read();
                int read8 = super.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f1714in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.f1714in);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            long j = this.ip + 2;
            this.ip = j;
            if (j <= this.f1715io) {
                int read = super.read();
                int read2 = super.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f1714in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.f1714in);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            long j = this.ip + 2;
            this.ip = j;
            if (j <= this.f1715io) {
                int read = super.read();
                int read2 = super.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f1714in;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.f1714in);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public void seek(long j) throws IOException {
            this.ip = 0;
            reset();
            if (skip(j) != j) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.f1714in = byteOrder;
        }

        public long skip(long j) {
            long skip = super.skip(Math.min(j, this.f1715io - this.ip));
            this.ip += skip;
            return skip;
        }
    }

    public static class b {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        public b(int i, int i2, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytes = bArr;
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ac.hN[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b aD(String str) {
            byte[] bytes2 = (str + 0).getBytes(ac.ic);
            return new b(2, bytes2.length, bytes2);
        }

        /* access modifiers changed from: private */
        public Object b(ByteOrder byteOrder) {
            try {
                a aVar = new a(this.bytes);
                aVar.setByteOrder(byteOrder);
                boolean z = true;
                int i = 0;
                switch (this.format) {
                    case 1:
                    case 6:
                        if (this.bytes.length != 1 || this.bytes[0] < 0 || this.bytes[0] > 1) {
                            return new String(this.bytes, ac.ic);
                        }
                        return new String(new char[]{(char) (this.bytes[0] + BaseParser.ASCII_ZERO)});
                    case 2:
                    case 7:
                        if (this.numberOfComponents >= ac.hO.length) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < ac.hO.length) {
                                    if (this.bytes[i2] != ac.hO[i2]) {
                                        z = false;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            if (z) {
                                i = ac.hO.length;
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            if (i < this.numberOfComponents) {
                                byte b2 = this.bytes[i];
                                if (b2 != 0) {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    i++;
                                }
                            }
                        }
                        return sb.toString();
                    case 3:
                        int[] iArr = new int[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            iArr[i] = aVar.readUnsignedShort();
                            i++;
                        }
                        return iArr;
                    case 4:
                        long[] jArr = new long[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            jArr[i] = aVar.readUnsignedInt();
                            i++;
                        }
                        return jArr;
                    case 5:
                        d[] dVarArr = new d[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            d dVar = new d(aVar.readUnsignedInt(), aVar.readUnsignedInt());
                            dVarArr[i] = dVar;
                            i++;
                        }
                        return dVarArr;
                    case 8:
                        int[] iArr2 = new int[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            iArr2[i] = aVar.readShort();
                            i++;
                        }
                        return iArr2;
                    case 9:
                        int[] iArr3 = new int[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            iArr3[i] = aVar.readInt();
                            i++;
                        }
                        return iArr3;
                    case 10:
                        d[] dVarArr2 = new d[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            d dVar2 = new d((long) aVar.readInt(), (long) aVar.readInt());
                            dVarArr2[i] = dVar2;
                            i++;
                        }
                        return dVarArr2;
                    case 11:
                        double[] dArr = new double[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            dArr[i] = (double) aVar.readFloat();
                            i++;
                        }
                        return dArr;
                    case 12:
                        double[] dArr2 = new double[this.numberOfComponents];
                        while (i < this.numberOfComponents) {
                            dArr2[i] = aVar.readDouble();
                            i++;
                        }
                        return dArr2;
                    default:
                        return null;
                }
            } catch (IOException unused) {
                return null;
            }
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object b2 = b(byteOrder);
            if (b2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (b2 instanceof String) {
                return Double.parseDouble((String) b2);
            } else {
                if (b2 instanceof long[]) {
                    long[] jArr = (long[]) b2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b2 instanceof int[]) {
                    int[] iArr = (int[]) b2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b2 instanceof double[]) {
                    double[] dArr = (double[]) b2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b2 instanceof d[]) {
                    d[] dVarArr = (d[]) b2;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object b2 = b(byteOrder);
            if (b2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (b2 instanceof String) {
                return Integer.parseInt((String) b2);
            } else {
                if (b2 instanceof long[]) {
                    long[] jArr = (long[]) b2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (b2 instanceof int[]) {
                    int[] iArr = (int[]) b2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object b2 = b(byteOrder);
            if (b2 == null) {
                return null;
            }
            if (b2 instanceof String) {
                return (String) b2;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (b2 instanceof long[]) {
                long[] jArr = (long[]) b2;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (b2 instanceof int[]) {
                int[] iArr = (int[]) b2;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (b2 instanceof double[]) {
                double[] dArr = (double[]) b2;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(b2 instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) b2;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].numerator);
                    sb.append('/');
                    sb.append(dVarArr[i].denominator);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("(");
            outline73.append(ac.hM[this.format]);
            outline73.append(", data length:");
            return GeneratedOutlineSupport.outline57(outline73, this.bytes.length, ")");
        }
    }

    public static class c {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public c(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        public c(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }
    }

    public static class d {
        public final long denominator;
        public final long numerator;

        public d(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    static {
        c cVar = new c("ImageWidth", 256, 3, 4);
        c cVar2 = new c("ImageLength", FTPReply.PATHNAME_CREATED, 3, 4);
        c cVar3 = new c("StripOffsets", 273, 3, 4);
        c cVar4 = new c("RowsPerStrip", 278, 3, 4);
        c cVar5 = new c("StripByteCounts", 279, 3, 4);
        hP = new c[]{cVar, cVar2, new c((String) "BitsPerSample", 258, 3), new c((String) "Compression", 259, 3), new c((String) "PhotometricInterpretation", (int) Deflate.MIN_LOOKAHEAD, 3), new c((String) "ImageDescription", 270, 2), new c((String) "Make", 271, 2), new c((String) "Model", 272, 2), cVar3, new c((String) "Orientation", 274, 3), new c((String) "SamplesPerPixel", 277, 3), cVar4, cVar5, new c((String) "XResolution", 282, 5), new c((String) "YResolution", 283, 5), new c((String) "PlanarConfiguration", 284, 3), new c((String) "ResolutionUnit", 296, 3), new c((String) "TransferFunction", (int) BaseRequest.InvitationReply, 3), new c((String) "Software", 305, 2), new c((String) "DateTime", 306, 2), new c((String) "Artist", 315, 2), new c((String) "WhitePoint", 318, 5), new c((String) "PrimaryChromaticities", 319, 5), new c((String) "JPEGInterchangeFormat", (int) GL20.GL_LESS, 4), new c((String) "JPEGInterchangeFormatLength", (int) GL20.GL_EQUAL, 4), new c((String) "YCbCrCoefficients", 529, 5), new c((String) "YCbCrSubSampling", (int) FTPReply.NOT_LOGGED_IN, 3), new c((String) "YCbCrPositioning", 531, 3), new c((String) "ReferenceBlackWhite", (int) FTPReply.NEED_ACCOUNT_FOR_STORING_FILES, 5), new c((String) "Copyright", 33432, 2), new c((String) "ExifIFDPointer", 34665, 4), new c((String) "GPSInfoIFDPointer", (int) GL30.GL_DRAW_BUFFER0, 4)};
        c cVar6 = new c("PixelXDimension", 40962, 3, 4);
        c cVar7 = new c("PixelYDimension", 40963, 3, 4);
        hQ = new c[]{new c((String) "ExposureTime", 33434, 5), new c((String) "FNumber", 33437, 5), new c((String) "ExposureProgram", 34850, 3), new c((String) "SpectralSensitivity", (int) GL30.GL_MAX_DRAW_BUFFERS, 2), new c((String) "ISOSpeedRatings", (int) GL30.GL_DRAW_BUFFER2, 3), new c((String) "OECF", (int) GL30.GL_DRAW_BUFFER3, 7), new c((String) "ExifVersion", 36864, 2), new c((String) "DateTimeOriginal", 36867, 2), new c((String) "DateTimeDigitized", 36868, 2), new c((String) "ComponentsConfiguration", 37121, 7), new c((String) "CompressedBitsPerPixel", 37122, 5), new c((String) "ShutterSpeedValue", 37377, 10), new c((String) "ApertureValue", 37378, 5), new c((String) "BrightnessValue", 37379, 10), new c((String) "ExposureBiasValue", 37380, 10), new c((String) "MaxApertureValue", 37381, 5), new c((String) "SubjectDistance", 37382, 5), new c((String) "MeteringMode", 37383, 3), new c((String) "LightSource", 37384, 3), new c((String) "Flash", 37385, 3), new c((String) "FocalLength", 37386, 5), new c((String) "SubjectArea", 37396, 3), new c((String) "MakerNote", 37500, 7), new c((String) "UserComment", 37510, 7), new c((String) "SubSecTime", 37520, 2), new c((String) "SubSecTimeOriginal", 37521, 2), new c((String) "SubSecTimeDigitized", 37522, 2), new c((String) "FlashpixVersion", 40960, 7), new c((String) "ColorSpace", 40961, 3), cVar6, cVar7, new c((String) "RelatedSoundFile", 40964, 2), new c((String) "InteroperabilityIFDPointer", 40965, 4), new c((String) "FlashEnergy", 41483, 5), new c((String) "SpatialFrequencyResponse", 41484, 7), new c((String) "FocalPlaneXResolution", 41486, 5), new c((String) "FocalPlaneYResolution", 41487, 5), new c((String) "FocalPlaneResolutionUnit", 41488, 3), new c((String) "SubjectLocation", 41492, 3), new c((String) "ExposureIndex", 41493, 5), new c((String) "SensingMethod", 41495, 3), new c((String) "FileSource", 41728, 7), new c((String) "SceneType", 41729, 7), new c((String) "CFAPattern", 41730, 7), new c((String) "CustomRendered", 41985, 3), new c((String) "ExposureMode", 41986, 3), new c((String) "WhiteBalance", 41987, 3), new c((String) "DigitalZoomRatio", 41988, 5), new c((String) "FocalLengthIn35mmFilm", 41989, 3), new c((String) "SceneCaptureType", 41990, 3), new c((String) "GainControl", 41991, 3), new c((String) "Contrast", 41992, 3), new c((String) "Saturation", 41993, 3), new c((String) "Sharpness", 41994, 3), new c((String) "DeviceSettingDescription", 41995, 7), new c((String) "SubjectDistanceRange", 41996, 3), new c((String) "ImageUniqueID", 42016, 2)};
        c cVar8 = new c("ThumbnailImageWidth", 256, 3, 4);
        c cVar9 = new c("ThumbnailImageLength", FTPReply.PATHNAME_CREATED, 3, 4);
        c cVar10 = new c("RowsPerStrip", 278, 3, 4);
        c cVar11 = new c("StripByteCounts", 279, 3, 4);
        c[] cVarArr = {cVar8, cVar9, new c((String) "BitsPerSample", 258, 3), new c((String) "Compression", 259, 3), new c((String) "PhotometricInterpretation", (int) Deflate.MIN_LOOKAHEAD, 3), new c((String) "ImageDescription", 270, 2), new c((String) "Make", 271, 2), new c((String) "Model", 272, 2), new c((String) "StripOffsets", 3, 4), new c((String) "Orientation", 274, 3), new c((String) "SamplesPerPixel", 277, 3), cVar10, cVar11, new c((String) "XResolution", 282, 5), new c((String) "YResolution", 283, 5), new c((String) "PlanarConfiguration", 284, 3), new c((String) "ResolutionUnit", 296, 3), new c((String) "TransferFunction", (int) BaseRequest.InvitationReply, 3), new c((String) "Software", 305, 2), new c((String) "DateTime", 306, 2), new c((String) "Artist", 315, 2), new c((String) "WhitePoint", 318, 5), new c((String) "PrimaryChromaticities", 319, 5), new c((String) "JPEGInterchangeFormat", (int) GL20.GL_LESS, 4), new c((String) "JPEGInterchangeFormatLength", (int) GL20.GL_EQUAL, 4), new c((String) "YCbCrCoefficients", 529, 5), new c((String) "YCbCrSubSampling", (int) FTPReply.NOT_LOGGED_IN, 3), new c((String) "YCbCrPositioning", 531, 3), new c((String) "ReferenceBlackWhite", (int) FTPReply.NEED_ACCOUNT_FOR_STORING_FILES, 5), new c((String) "Copyright", 33432, 2), new c((String) "ExifIFDPointer", 34665, 4), new c((String) "GPSInfoIFDPointer", (int) GL30.GL_DRAW_BUFFER0, 4)};
        hT = cVarArr;
        hU = new c[][]{hP, hQ, hR, hS, cVarArr};
        c[][] cVarArr2 = hU;
        hZ = new HashMap[cVarArr2.length];
        ia = new HashMap[cVarArr2.length];
        Charset forName = Charset.forName("US-ASCII");
        ic = forName;
        ie = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        hL = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < hU.length; i++) {
            hZ[i] = new HashMap();
            ia[i] = new HashMap();
            for (c cVar12 : hU[i]) {
                hZ[i].put(Integer.valueOf(cVar12.number), cVar12);
                ia[i].put(cVar12.name, cVar12);
            }
        }
    }

    public ac(String str) throws IOException {
        if (str != null) {
            this.f3if = str;
            eD();
            return;
        }
        throw new IllegalArgumentException("filename cannot be null");
    }

    private void a(a aVar, int i) throws IOException {
        int i2;
        a aVar2 = aVar;
        if (aVar.eJ() + 2 <= aVar.f1715io) {
            short readShort = aVar.readShort();
            if (aVar.eJ() + ((long) (readShort * 12)) <= aVar.f1715io) {
                for (short s = 0; s < readShort; s = (short) (s + 1)) {
                    int readUnsignedShort = aVar.readUnsignedShort();
                    int readUnsignedShort2 = aVar.readUnsignedShort();
                    int readInt = aVar.readInt();
                    long eJ = aVar.eJ() + 4;
                    c cVar = (c) hZ[i].get(Integer.valueOf(readUnsignedShort));
                    if (cVar != null && readUnsignedShort2 > 0) {
                        int[] iArr = hN;
                        if (readUnsignedShort2 < iArr.length) {
                            int i3 = iArr[readUnsignedShort2] * readInt;
                            if (i3 > 4) {
                                long readUnsignedInt = aVar.readUnsignedInt();
                                if (((long) i3) + readUnsignedInt <= aVar.f1715io) {
                                    aVar2.seek(readUnsignedInt);
                                }
                            }
                            int t = t(readUnsignedShort);
                            if (t >= 0) {
                                long j = -1;
                                if (readUnsignedShort2 != 3) {
                                    if (readUnsignedShort2 == 4) {
                                        j = aVar.readUnsignedInt();
                                    } else if (readUnsignedShort2 == 8) {
                                        i2 = aVar.readShort();
                                    } else if (readUnsignedShort2 == 9) {
                                        i2 = aVar.readInt();
                                    }
                                    if (j > 0 && j < aVar.f1715io) {
                                        aVar2.seek(j);
                                        a(aVar2, t);
                                    }
                                } else {
                                    i2 = aVar.readUnsignedShort();
                                }
                                j = (long) i2;
                                aVar2.seek(j);
                                a(aVar2, t);
                            } else {
                                byte[] bArr = new byte[(hN[readUnsignedShort2] * readInt)];
                                aVar2.readFully(bArr);
                                this.ig[i].put(cVar.name, new b(readUnsignedShort2, readInt, bArr));
                                if (aVar.eJ() == eJ) {
                                }
                            }
                        }
                    }
                    aVar2.seek(eJ);
                }
                if (aVar.eJ() + 4 <= aVar.f1715io) {
                    long readUnsignedInt2 = aVar.readUnsignedInt();
                    if (readUnsignedInt2 > 8 && readUnsignedInt2 < aVar.f1715io) {
                        aVar2.seek(readUnsignedInt2);
                        a(aVar2, 4);
                    }
                }
            }
        }
    }

    private void a(byte[] bArr, int i) throws IOException {
        ByteOrder byteOrder;
        a aVar = new a(bArr);
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
            outline73.append(Integer.toHexString(readShort));
            throw new IOException(outline73.toString());
        }
        this.ih = byteOrder;
        aVar.setByteOrder(this.ih);
        int readUnsignedShort = aVar.readUnsignedShort();
        if (readUnsignedShort == 42) {
            long readUnsignedInt = aVar.readUnsignedInt();
            if (readUnsignedInt < 8 || readUnsignedInt >= ((long) bArr.length)) {
                throw new IOException(GeneratedOutlineSupport.outline45("Invalid first Ifd offset: ", readUnsignedInt));
            }
            long j = readUnsignedInt - 8;
            if (j <= 0 || aVar.skip(j) == j) {
                a(aVar, 0);
                String attribute = getAttribute(hX.name);
                String attribute2 = getAttribute(hY.name);
                if (attribute != null && attribute2 != null) {
                    try {
                        int parseInt = Integer.parseInt(attribute);
                        int min = Math.min(Integer.parseInt(attribute2) + parseInt, bArr.length) - parseInt;
                        if (parseInt > 0 && min > 0) {
                            this.ii = true;
                            this.ij = i + parseInt;
                            this.ik = min;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            } else {
                throw new IOException(GeneratedOutlineSupport.outline45("Couldn't jump to first Ifd: ", j));
            }
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Invalid exif start: ");
            outline732.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(outline732.toString());
        }
    }

    private b aC(String str) {
        for (int i = 0; i < hU.length; i++) {
            Object obj = this.ig[i].get(str);
            if (obj != null) {
                return (b) obj;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0083 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ef A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            java.io.DataInputStream r0 = new java.io.DataInputStream
            r0.<init>(r11)
            byte r1 = r0.readByte()
            java.lang.String r2 = "Invalid marker: "
            r3 = -1
            if (r1 != r3) goto L_0x013e
            byte r4 = r0.readByte()
            r5 = -40
            if (r4 != r5) goto L_0x0127
            r1 = 2
        L_0x0017:
            byte r2 = r0.readByte()
            if (r2 != r3) goto L_0x010e
            r2 = 1
            int r1 = r1 + r2
            byte r4 = r0.readByte()
            int r1 = r1 + r2
            r5 = -39
            if (r4 == r5) goto L_0x010d
            r5 = -38
            if (r4 != r5) goto L_0x002e
            goto L_0x010d
        L_0x002e:
            int r5 = r0.readUnsignedShort()
            int r5 = r5 + -2
            int r1 = r1 + 2
            java.lang.String r6 = "Invalid length"
            if (r5 < 0) goto L_0x0107
            r7 = -31
            java.lang.String r8 = "Invalid exif"
            r9 = 0
            if (r4 == r7) goto L_0x00b4
            r7 = -2
            if (r4 == r7) goto L_0x008b
            switch(r4) {
                case -64: goto L_0x0052;
                case -63: goto L_0x0052;
                case -62: goto L_0x0052;
                case -61: goto L_0x0052;
                default: goto L_0x0047;
            }
        L_0x0047:
            switch(r4) {
                case -59: goto L_0x0052;
                case -58: goto L_0x0052;
                case -57: goto L_0x0052;
                default: goto L_0x004a;
            }
        L_0x004a:
            switch(r4) {
                case -55: goto L_0x0052;
                case -54: goto L_0x0052;
                case -53: goto L_0x0052;
                default: goto L_0x004d;
            }
        L_0x004d:
            switch(r4) {
                case -51: goto L_0x0052;
                case -50: goto L_0x0052;
                case -49: goto L_0x0052;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x00dc
        L_0x0052:
            int r4 = r0.skipBytes(r2)
            if (r4 != r2) goto L_0x0083
            java.util.HashMap[] r2 = r10.ig
            r2 = r2[r9]
            int r4 = r0.readUnsignedShort()
            long r7 = (long) r4
            java.nio.ByteOrder r4 = r10.ih
            com.freshchat.consumer.sdk.j.ac$b r4 = com.freshchat.consumer.sdk.j.ac.b.a(r7, r4)
            java.lang.String r7 = "ImageLength"
            r2.put(r7, r4)
            java.util.HashMap[] r2 = r10.ig
            r2 = r2[r9]
            int r4 = r0.readUnsignedShort()
            long r7 = (long) r4
            java.nio.ByteOrder r4 = r10.ih
            com.freshchat.consumer.sdk.j.ac$b r4 = com.freshchat.consumer.sdk.j.ac.b.a(r7, r4)
            java.lang.String r7 = "ImageWidth"
            r2.put(r7, r4)
            int r5 = r5 + -5
            goto L_0x00dc
        L_0x0083:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Invalid SOFx"
            r11.<init>(r0)
            throw r11
        L_0x008b:
            byte[] r4 = new byte[r5]
            int r7 = r0.read(r4)
            if (r7 != r5) goto L_0x00ae
            java.lang.String r5 = "UserComment"
            java.lang.String r7 = r10.getAttribute(r5)
            if (r7 != 0) goto L_0x00db
            java.util.HashMap[] r7 = r10.ig
            r2 = r7[r2]
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r8 = ic
            r7.<init>(r4, r8)
            com.freshchat.consumer.sdk.j.ac$b r4 = com.freshchat.consumer.sdk.j.ac.b.aD(r7)
            r2.put(r5, r4)
            goto L_0x00db
        L_0x00ae:
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r8)
            throw r11
        L_0x00b4:
            r2 = 6
            if (r5 >= r2) goto L_0x00b8
            goto L_0x00dc
        L_0x00b8:
            byte[] r4 = new byte[r2]
            int r7 = r11.read(r4)
            if (r7 != r2) goto L_0x0101
            int r1 = r1 + 6
            int r5 = r5 + -6
            byte[] r2 = ie
            boolean r2 = java.util.Arrays.equals(r4, r2)
            if (r2 != 0) goto L_0x00cd
            goto L_0x00dc
        L_0x00cd:
            if (r5 <= 0) goto L_0x00fb
            byte[] r2 = new byte[r5]
            int r4 = r0.read(r2)
            if (r4 != r5) goto L_0x00f5
            r10.a(r2, r1)
            int r1 = r1 + r5
        L_0x00db:
            r5 = 0
        L_0x00dc:
            if (r5 < 0) goto L_0x00ef
            int r2 = r0.skipBytes(r5)
            if (r2 != r5) goto L_0x00e7
            int r1 = r1 + r5
            goto L_0x0017
        L_0x00e7:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Invalid JPEG segment"
            r11.<init>(r0)
            throw r11
        L_0x00ef:
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r6)
            throw r11
        L_0x00f5:
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r8)
            throw r11
        L_0x00fb:
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r8)
            throw r11
        L_0x0101:
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r8)
            throw r11
        L_0x0107:
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r6)
            throw r11
        L_0x010d:
            return
        L_0x010e:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Invalid marker:"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            r1 = r2 & 255(0xff, float:3.57E-43)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x0127:
            java.io.IOException r11 = new java.io.IOException
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            r1 = r1 & 255(0xff, float:3.57E-43)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x013e:
            java.io.IOException r11 = new java.io.IOException
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            r1 = r1 & 255(0xff, float:3.57E-43)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.ac.b(java.io.InputStream):void");
    }

    private void eD() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f3if);
            for (int i = 0; i < hU.length; i++) {
                this.ig[i] = new HashMap();
            }
            b(fileInputStream);
        } catch (IOException unused) {
        } catch (Throwable th) {
            eE();
            throw th;
        }
        eE();
    }

    private void eE() {
        String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null) {
            this.ig[0].put("DateTime", b.aD(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.ig[0].put("ImageWidth", b.a(0, this.ih));
        }
        if (getAttribute("ImageLength") == null) {
            this.ig[0].put("ImageLength", b.a(0, this.ih));
        }
        if (getAttribute("Orientation") == null) {
            this.ig[0].put("Orientation", b.a(0, this.ih));
        }
        if (getAttribute("LightSource") == null) {
            this.ig[1].put("LightSource", b.a(0, this.ih));
        }
    }

    public static int t(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = hW;
            if (i2 >= iArr.length) {
                return -1;
            }
            if (hV[i2].number == i) {
                return iArr[i2];
            }
            i2++;
        }
    }

    public String getAttribute(String str) {
        b aC = aC(str);
        if (aC != null) {
            if (!ib.contains(str)) {
                return aC.getStringValue(this.ih);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = aC.format;
                if (i != 5 && i != 10) {
                    return null;
                }
                d[] dVarArr = (d[]) aC.b(this.ih);
                if (dVarArr.length != 3) {
                    return null;
                }
                return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) dVarArr[0].numerator) / ((float) dVarArr[0].denominator))), Integer.valueOf((int) (((float) dVarArr[1].numerator) / ((float) dVarArr[1].denominator))), Integer.valueOf((int) (((float) dVarArr[2].numerator) / ((float) dVarArr[2].denominator)))});
            }
            try {
                return Double.toString(aC.getDoubleValue(this.ih));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int getAttributeInt(String str, int i) {
        b aC = aC(str);
        if (aC == null) {
            return i;
        }
        try {
            return aC.getIntValue(this.ih);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
