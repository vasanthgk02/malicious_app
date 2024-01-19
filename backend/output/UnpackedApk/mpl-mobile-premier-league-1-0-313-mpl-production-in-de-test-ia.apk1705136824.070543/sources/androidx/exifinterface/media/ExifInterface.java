package androidx.exifinterface.media;

import android.content.res.AssetManager.AssetInputStream;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.net.ftp.FTPReply;
import org.jboss.netty.util.internal.jzlib.Deflate;
import sfs2x.client.entities.invitation.InvitationReply;
import sfs2x.client.requests.BaseRequest;

public class ExifInterface {
    public static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", GL30.GL_DRAW_BUFFER0, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
    public static final ExifTag[][] EXIF_TAGS;
    public static final byte[] IDENTIFIER_EXIF_APP1;
    public static final ExifTag[] IFD_EXIF_TAGS = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", GL30.GL_MAX_DRAW_BUFFERS, 2), new ExifTag("PhotographicSensitivity", GL30.GL_DRAW_BUFFER2, 3), new ExifTag("OECF", GL30.GL_DRAW_BUFFER3, 7), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    public static final ExifTag[] IFD_GPS_TAGS = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3)};
    public static final ExifTag[] IFD_INTEROPERABILITY_TAGS = {new ExifTag("InteroperabilityIndex", 1, 2)};
    public static final ExifTag[] IFD_THUMBNAIL_TAGS = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", InvitationReply.EXPIRED, 4), new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", FTPReply.PATHNAME_CREATED, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", Deflate.MIN_LOOKAHEAD, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", BaseRequest.InvitationReply, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", GL20.GL_LESS, 4), new ExifTag("JPEGInterchangeFormatLength", GL20.GL_EQUAL, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", FTPReply.NOT_LOGGED_IN, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", FTPReply.NEED_ACCOUNT_FOR_STORING_FILES, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", GL30.GL_DRAW_BUFFER0, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
    public static final ExifTag[] IFD_TIFF_TAGS = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", InvitationReply.EXPIRED, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", FTPReply.PATHNAME_CREATED, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", Deflate.MIN_LOOKAHEAD, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", BaseRequest.InvitationReply, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", GL20.GL_LESS, 4), new ExifTag("JPEGInterchangeFormatLength", GL20.GL_EQUAL, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", FTPReply.NOT_LOGGED_IN, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", FTPReply.NEED_ACCOUNT_FOR_STORING_FILES, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", GL30.GL_DRAW_BUFFER0, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7)};
    public static final byte[] JPEG_SIGNATURE = {-1, -40, -1};
    public static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS = {new ExifTag("PreviewImageStart", FTPReply.PATHNAME_CREATED, 4), new ExifTag("PreviewImageLength", 258, 4)};
    public static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS = {new ExifTag("AspectFrame", 4371, 3)};
    public static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    public static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final ExifTag[] ORF_MAKER_NOTE_TAGS = {new ExifTag("ThumbnailImage", 256, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
    public static final ExifTag[] PEF_TAGS;
    public static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag("StripOffsets", 273, 3);
    public static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    public static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    public static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    public static SimpleDateFormat sFormatter;
    public static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    public final AssetInputStream mAssetInputStream;
    public final HashMap<String, ExifAttribute>[] mAttributes = new HashMap[EXIF_TAGS.length];
    public Set<Integer> mAttributesOffsets = new HashSet(EXIF_TAGS.length);
    public ByteOrder mExifByteOrder = ByteOrder.BIG_ENDIAN;
    public int mExifOffset;
    public final String mFilename;
    public int mMimeType;
    public int mOrfMakerNoteOffset;
    public int mOrfThumbnailLength;
    public int mOrfThumbnailOffset;
    public int mRw2JpgFromRawOffset;
    public int mThumbnailCompression;

    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        public ByteOrder mByteOrder;
        public DataInputStream mDataInputStream;
        public final int mLength;
        public int mPosition;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
        }

        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        public byte readByte() throws IOException {
            int i = this.mPosition + 1;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.mPosition + i2;
            this.mPosition = i3;
            if (i3 > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            int i = this.mPosition + 4;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.mByteOrder);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            return null;
        }

        public long readLong() throws IOException {
            int i = this.mPosition + 8;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                int read5 = this.mDataInputStream.read();
                int read6 = this.mDataInputStream.read();
                int read7 = this.mDataInputStream.read();
                int read8 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.mByteOrder);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.mByteOrder);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
                    outline73.append(this.mByteOrder);
                    throw new IOException(outline73.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public void seek(long j) throws IOException {
            int i = this.mPosition;
            if (((long) i) > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.mLength - this.mPosition);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.mDataInputStream.skipBytes(min - i2);
            }
            this.mPosition += i2;
            return i2;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            int length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }
    }

    public static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(int i, int i2, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytes = bArr;
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes2 = (str + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes2.length, bytes2);
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * 1)]);
            wrap.order(byteOrder);
            for (int i = 0; i < 1; i++) {
                wrap.putInt((int) jArr[i]);
            }
            return new ExifAttribute(4, 1, wrap.array());
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            Rational[] rationalArr = {rational};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * 1)]);
            wrap.order(byteOrder);
            for (int i = 0; i < 1; i++) {
                Rational rational2 = rationalArr[i];
                wrap.putInt((int) rational2.numerator);
                wrap.putInt((int) rational2.denominator);
            }
            return new ExifAttribute(5, 1, wrap.array());
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            int[] iArr = {i};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 < 1; i2++) {
                wrap.putShort((short) iArr[i2]);
            }
            return new ExifAttribute(3, 1, wrap.array());
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (value instanceof String) {
                return Double.parseDouble((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length == 1) {
                        Rational rational = rationalArr[0];
                        return ((double) rational.numerator) / ((double) rational.denominator);
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (value instanceof String) {
                return Integer.parseInt((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
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
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(value instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) value;
                while (i < rationalArr.length) {
                    sb.append(rationalArr[i].numerator);
                    sb.append('/');
                    sb.append(rationalArr[i].denominator);
                    i++;
                    if (i != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:140:0x0156 A[SYNTHETIC, Splitter:B:140:0x0156] */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x015d A[SYNTHETIC, Splitter:B:148:0x015d] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object getValue(java.nio.ByteOrder r9) {
            /*
                r8 = this;
                r0 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x015a, all -> 0x0153 }
                byte[] r2 = r8.bytes     // Catch:{ IOException -> 0x015a, all -> 0x0153 }
                r1.<init>(r2)     // Catch:{ IOException -> 0x015a, all -> 0x0153 }
                r1.mByteOrder = r9     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r9 = r8.format     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r2 = 1
                r3 = 0
                switch(r9) {
                    case 1: goto L_0x011a;
                    case 2: goto L_0x00d0;
                    case 3: goto L_0x00bb;
                    case 4: goto L_0x00a6;
                    case 5: goto L_0x0088;
                    case 6: goto L_0x011a;
                    case 7: goto L_0x00d0;
                    case 8: goto L_0x0073;
                    case 9: goto L_0x005e;
                    case 10: goto L_0x003e;
                    case 11: goto L_0x0028;
                    case 12: goto L_0x0013;
                    default: goto L_0x0011;
                }     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x0011:
                goto L_0x014c
            L_0x0013:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x0017:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x0024
                double r4 = r1.readDouble()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r4     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x0017
            L_0x0024:
                r1.close()     // Catch:{ IOException -> 0x0027 }
            L_0x0027:
                return r9
            L_0x0028:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x002c:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x003a
                float r2 = r1.readFloat()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                double r4 = (double) r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r4     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x002c
            L_0x003a:
                r1.close()     // Catch:{ IOException -> 0x003d }
            L_0x003d:
                return r9
            L_0x003e:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                androidx.exifinterface.media.ExifInterface$Rational[] r9 = new androidx.exifinterface.media.ExifInterface.Rational[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x0042:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x005a
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                long r4 = (long) r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                long r6 = (long) r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                androidx.exifinterface.media.ExifInterface$Rational r2 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x0042
            L_0x005a:
                r1.close()     // Catch:{ IOException -> 0x005d }
            L_0x005d:
                return r9
            L_0x005e:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x0062:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x006f
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x0062
            L_0x006f:
                r1.close()     // Catch:{ IOException -> 0x0072 }
            L_0x0072:
                return r9
            L_0x0073:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x0077:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x0084
                short r2 = r1.readShort()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x0077
            L_0x0084:
                r1.close()     // Catch:{ IOException -> 0x0087 }
            L_0x0087:
                return r9
            L_0x0088:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                androidx.exifinterface.media.ExifInterface$Rational[] r9 = new androidx.exifinterface.media.ExifInterface.Rational[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x008c:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x00a2
                long r4 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                long r6 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                androidx.exifinterface.media.ExifInterface$Rational r2 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x008c
            L_0x00a2:
                r1.close()     // Catch:{ IOException -> 0x00a5 }
            L_0x00a5:
                return r9
            L_0x00a6:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                long[] r9 = new long[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x00aa:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x00b7
                long r4 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r4     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x00aa
            L_0x00b7:
                r1.close()     // Catch:{ IOException -> 0x00ba }
            L_0x00ba:
                return r9
            L_0x00bb:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x00bf:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x00cc
                int r2 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r3 + 1
                goto L_0x00bf
            L_0x00cc:
                r1.close()     // Catch:{ IOException -> 0x00cf }
            L_0x00cf:
                return r9
            L_0x00d0:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte[] r4 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r4 = r4.length     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r9 < r4) goto L_0x00f1
                r9 = 0
            L_0x00d8:
                byte[] r4 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r4 = r4.length     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r9 >= r4) goto L_0x00ec
                byte[] r4 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte r4 = r4[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte[] r5 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte r5 = r5[r9]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r4 == r5) goto L_0x00e9
                r2 = 0
                goto L_0x00ec
            L_0x00e9:
                int r9 = r9 + 1
                goto L_0x00d8
            L_0x00ec:
                if (r2 == 0) goto L_0x00f1
                byte[] r9 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r3 = r9.length     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x00f1:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9.<init>()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x00f6:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r3 >= r2) goto L_0x0112
                byte[] r2 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte r2 = r2[r3]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r2 != 0) goto L_0x0101
                goto L_0x0112
            L_0x0101:
                r4 = 32
                if (r2 < r4) goto L_0x010a
                char r2 = (char) r2     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9.append(r2)     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                goto L_0x010f
            L_0x010a:
                r2 = 63
                r9.append(r2)     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
            L_0x010f:
                int r3 = r3 + 1
                goto L_0x00f6
            L_0x0112:
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r1.close()     // Catch:{ IOException -> 0x0119 }
            L_0x0119:
                return r9
            L_0x011a:
                byte[] r9 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r9 = r9.length     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r9 != r2) goto L_0x013f
                byte[] r9 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r9 < 0) goto L_0x013f
                byte[] r9 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                if (r9 > r2) goto L_0x013f
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                char[] r2 = new char[r2]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte[] r4 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte r4 = r4[r3]     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                int r4 = r4 + 48
                char r4 = (char) r4     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r2[r3] = r4     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9.<init>(r2)     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r1.close()     // Catch:{ IOException -> 0x013e }
            L_0x013e:
                return r9
            L_0x013f:
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                byte[] r2 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                java.nio.charset.Charset r3 = androidx.exifinterface.media.ExifInterface.ASCII     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r9.<init>(r2, r3)     // Catch:{ IOException -> 0x015b, all -> 0x0150 }
                r1.close()     // Catch:{ IOException -> 0x014b }
            L_0x014b:
                return r9
            L_0x014c:
                r1.close()     // Catch:{ IOException -> 0x014f }
            L_0x014f:
                return r0
            L_0x0150:
                r9 = move-exception
                r0 = r1
                goto L_0x0154
            L_0x0153:
                r9 = move-exception
            L_0x0154:
                if (r0 == 0) goto L_0x0159
                r0.close()     // Catch:{ IOException -> 0x0159 }
            L_0x0159:
                throw r9
            L_0x015a:
                r1 = r0
            L_0x015b:
                if (r1 == 0) goto L_0x0160
                r1.close()     // Catch:{ IOException -> 0x0160 }
            L_0x0160:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("(");
            outline73.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
            outline73.append(", data length:");
            return GeneratedOutlineSupport.outline57(outline73, this.bytes.length, ")");
        }
    }

    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        public ExifTag(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }
    }

    public static class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    static {
        Integer valueOf = Integer.valueOf(1);
        Integer valueOf2 = Integer.valueOf(3);
        Integer valueOf3 = Integer.valueOf(2);
        Integer valueOf4 = Integer.valueOf(8);
        Arrays.asList(new Integer[]{valueOf, Integer.valueOf(6), valueOf2, valueOf4});
        Integer valueOf5 = Integer.valueOf(7);
        Integer valueOf6 = Integer.valueOf(5);
        Arrays.asList(new Integer[]{valueOf3, valueOf5, Integer.valueOf(4), valueOf6});
        ExifTag[] exifTagArr = {new ExifTag("ColorSpace", 55, 3)};
        PEF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = IFD_TIFF_TAGS;
        EXIF_TAGS = new ExifTag[][]{exifTagArr2, IFD_EXIF_TAGS, IFD_GPS_TAGS, IFD_INTEROPERABILITY_TAGS, IFD_THUMBNAIL_TAGS, exifTagArr2, ORF_MAKER_NOTE_TAGS, ORF_CAMERA_SETTINGS_TAGS, ORF_IMAGE_PROCESSING_TAGS, exifTagArr};
        ExifTag[][] exifTagArr3 = EXIF_TAGS;
        sExifTagMapsForReading = new HashMap[exifTagArr3.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr3.length];
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            sExifTagMapsForReading[i] = new HashMap<>();
            sExifTagMapsForWriting[i] = new HashMap<>();
            for (ExifTag exifTag : EXIF_TAGS[i]) {
                sExifTagMapsForReading[i].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
            }
        }
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[0].number), valueOf6);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[1].number), valueOf);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[2].number), valueOf3);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[3].number), valueOf2);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[4].number), valueOf5);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[5].number), valueOf4);
        Pattern.compile(".*[1-9].*");
        Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[SYNTHETIC, Splitter:B:16:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(java.lang.String r3) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r0 = EXIF_TAGS
            int r0 = r0.length
            java.util.HashMap[] r0 = new java.util.HashMap[r0]
            r2.mAttributes = r0
            java.util.HashSet r0 = new java.util.HashSet
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r1 = EXIF_TAGS
            int r1 = r1.length
            r0.<init>(r1)
            r2.mAttributesOffsets = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r2.mExifByteOrder = r0
            if (r3 == 0) goto L_0x003a
            r0 = 0
            r2.mAssetInputStream = r0
            r2.mFilename = r3
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0030 }
            r1.<init>(r3)     // Catch:{ all -> 0x0030 }
            r2.loadAttributes(r1)     // Catch:{ all -> 0x002d }
            r1.close()     // Catch:{ RuntimeException -> 0x002b, Exception -> 0x002a }
        L_0x002a:
            return
        L_0x002b:
            r3 = move-exception
            throw r3
        L_0x002d:
            r3 = move-exception
            r0 = r1
            goto L_0x0031
        L_0x0030:
            r3 = move-exception
        L_0x0031:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ RuntimeException -> 0x0037, Exception -> 0x0039 }
            goto L_0x0039
        L_0x0037:
            r3 = move-exception
            throw r3
        L_0x0039:
            throw r3
        L_0x003a:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "filename cannot be null"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.lang.String):void");
    }

    public static long[] convertToLongArray(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = (long) iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    public final void addDefaultValuesForCompatibility() {
        String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null && getAttribute("DateTime") == null) {
            this.mAttributes[0].put("DateTime", ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.mAttributes[0].put("ImageWidth", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute("ImageLength") == null) {
            this.mAttributes[0].put("ImageLength", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute("Orientation") == null) {
            this.mAttributes[0].put("Orientation", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute("LightSource") == null) {
            this.mAttributes[1].put("LightSource", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
    }

    public String getAttribute(String str) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = exifAttribute.format;
                if (i != 5 && i != 10) {
                    return null;
                }
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 3) {
                    Arrays.toString(rationalArr);
                    return null;
                }
                return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) rationalArr[0].numerator) / ((float) rationalArr[0].denominator))), Integer.valueOf((int) (((float) rationalArr[1].numerator) / ((float) rationalArr[1].denominator))), Integer.valueOf((int) (((float) rationalArr[2].numerator) / ((float) rationalArr[2].denominator)))});
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final ExifAttribute getExifAttribute(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            ExifAttribute exifAttribute = this.mAttributes[i].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0086 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r9.mByteOrder = r0
            long r0 = (long) r10
            r9.seek(r0)
            byte r0 = r9.readByte()
            java.lang.String r1 = "Invalid marker: "
            r2 = -1
            if (r0 != r2) goto L_0x014f
            r3 = 1
            int r10 = r10 + r3
            byte r4 = r9.readByte()
            r5 = -40
            if (r4 != r5) goto L_0x0138
            int r10 = r10 + r3
        L_0x001c:
            byte r0 = r9.readByte()
            if (r0 != r2) goto L_0x011f
            int r10 = r10 + r3
            byte r0 = r9.readByte()
            int r10 = r10 + r3
            r1 = -39
            if (r0 == r1) goto L_0x011a
            r1 = -38
            if (r0 != r1) goto L_0x0032
            goto L_0x011a
        L_0x0032:
            int r1 = r9.readUnsignedShort()
            int r1 = r1 + -2
            int r10 = r10 + 2
            java.lang.String r4 = "Invalid length"
            if (r1 < 0) goto L_0x0114
            r5 = -31
            java.lang.String r6 = "Invalid exif"
            if (r0 == r5) goto L_0x00b7
            r5 = -2
            if (r0 == r5) goto L_0x008e
            switch(r0) {
                case -64: goto L_0x0055;
                case -63: goto L_0x0055;
                case -62: goto L_0x0055;
                case -61: goto L_0x0055;
                default: goto L_0x004a;
            }
        L_0x004a:
            switch(r0) {
                case -59: goto L_0x0055;
                case -58: goto L_0x0055;
                case -57: goto L_0x0055;
                default: goto L_0x004d;
            }
        L_0x004d:
            switch(r0) {
                case -55: goto L_0x0055;
                case -54: goto L_0x0055;
                case -53: goto L_0x0055;
                default: goto L_0x0050;
            }
        L_0x0050:
            switch(r0) {
                case -51: goto L_0x0055;
                case -50: goto L_0x0055;
                case -49: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x00e9
        L_0x0055:
            int r0 = r9.skipBytes(r3)
            if (r0 != r3) goto L_0x0086
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r0 = r8.mAttributes
            r0 = r0[r11]
            int r5 = r9.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r8.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(r5, r7)
            java.lang.String r6 = "ImageLength"
            r0.put(r6, r5)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r0 = r8.mAttributes
            r0 = r0[r11]
            int r5 = r9.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r8.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(r5, r7)
            java.lang.String r6 = "ImageWidth"
            r0.put(r6, r5)
            int r1 = r1 + -5
            goto L_0x00e9
        L_0x0086:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid SOFx"
            r9.<init>(r10)
            throw r9
        L_0x008e:
            byte[] r0 = new byte[r1]
            int r5 = r9.read(r0)
            if (r5 != r1) goto L_0x00b1
            java.lang.String r1 = "UserComment"
            java.lang.String r5 = r8.getAttribute(r1)
            if (r5 != 0) goto L_0x00e8
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r5 = r8.mAttributes
            r5 = r5[r3]
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r7 = ASCII
            r6.<init>(r0, r7)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r0 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r6)
            r5.put(r1, r0)
            goto L_0x00e8
        L_0x00b1:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r6)
            throw r9
        L_0x00b7:
            r0 = 6
            if (r1 >= r0) goto L_0x00bb
            goto L_0x00e9
        L_0x00bb:
            byte[] r5 = new byte[r0]
            int r7 = r9.read(r5)
            if (r7 != r0) goto L_0x010e
            int r10 = r10 + 6
            int r1 = r1 + -6
            byte[] r0 = IDENTIFIER_EXIF_APP1
            boolean r0 = java.util.Arrays.equals(r5, r0)
            if (r0 != 0) goto L_0x00d0
            goto L_0x00e9
        L_0x00d0:
            if (r1 <= 0) goto L_0x0108
            r8.mExifOffset = r10
            byte[] r0 = new byte[r1]
            int r5 = r9.read(r0)
            if (r5 != r1) goto L_0x0102
            int r10 = r10 + r1
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r5 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r5.<init>(r0)
            r8.parseTiffHeaders(r5, r1)
            r8.readImageFileDirectory(r5, r11)
        L_0x00e8:
            r1 = 0
        L_0x00e9:
            if (r1 < 0) goto L_0x00fc
            int r0 = r9.skipBytes(r1)
            if (r0 != r1) goto L_0x00f4
            int r10 = r10 + r1
            goto L_0x001c
        L_0x00f4:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid JPEG segment"
            r9.<init>(r10)
            throw r9
        L_0x00fc:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r4)
            throw r9
        L_0x0102:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r6)
            throw r9
        L_0x0108:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r6)
            throw r9
        L_0x010e:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r6)
            throw r9
        L_0x0114:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r4)
            throw r9
        L_0x011a:
            java.nio.ByteOrder r10 = r8.mExifByteOrder
            r9.mByteOrder = r10
            return
        L_0x011f:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid marker:"
            java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
            r11 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0138:
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            r11 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x014f:
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            r11 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    public final int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        boolean z;
        boolean z2;
        boolean z3;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            z = true;
            if (i2 >= bArr2.length) {
                z2 = true;
                break;
            } else if (bArr[i2] != bArr2[i2]) {
                z2 = false;
                break;
            } else {
                i2++;
            }
        }
        if (z2) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i3 = 0;
        while (true) {
            if (i3 >= bytes.length) {
                z3 = true;
                break;
            } else if (bArr[i3] != bytes[i3]) {
                z3 = false;
                break;
            } else {
                i3++;
            }
        }
        if (z3) {
            return 9;
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.mByteOrder = readByteOrder;
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        if (readShort == 20306 || readShort == 21330) {
            return 7;
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder2 = readByteOrder(byteOrderedDataInputStream2);
        this.mExifByteOrder = readByteOrder2;
        byteOrderedDataInputStream2.mByteOrder = readByteOrder2;
        short readShort2 = byteOrderedDataInputStream2.readShort();
        byteOrderedDataInputStream2.close();
        if (readShort2 != 85) {
            z = false;
        }
        if (z) {
            i = 10;
        }
        return i;
    }

    public final void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get("MakerNote");
        if (exifAttribute != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.mByteOrder = this.mExifByteOrder;
            byte[] bArr = new byte[ORF_MAKER_NOTE_HEADER_1.length];
            byteOrderedDataInputStream2.readFully(bArr);
            byteOrderedDataInputStream2.seek(0);
            byte[] bArr2 = new byte[ORF_MAKER_NOTE_HEADER_2.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            if (Arrays.equals(bArr, ORF_MAKER_NOTE_HEADER_1)) {
                byteOrderedDataInputStream2.seek(8);
            } else if (Arrays.equals(bArr2, ORF_MAKER_NOTE_HEADER_2)) {
                byteOrderedDataInputStream2.seek(12);
            }
            readImageFileDirectory(byteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = this.mAttributes[7].get("PreviewImageLength");
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.mAttributes[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.mAttributes[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Arrays.toString(iArr);
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i2, this.mExifByteOrder);
                    this.mAttributes[0].put("ImageWidth", createUShort);
                    this.mAttributes[0].put("ImageLength", createUShort2);
                }
            }
        }
    }

    public final void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.skipBytes(4);
        byteOrderedDataInputStream.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        getJpegAttributes(byteOrderedDataInputStream, i, 5);
        byteOrderedDataInputStream.seek((long) i2);
        byteOrderedDataInputStream.mByteOrder = ByteOrder.BIG_ENDIAN;
        int readInt = byteOrderedDataInputStream.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.mExifByteOrder);
                this.mAttributes[0].put("ImageLength", createUShort);
                this.mAttributes[0].put("ImageWidth", createUShort2);
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    public final void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        readImageFileDirectory(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 5);
        updateImageSizeValues(byteOrderedDataInputStream, 4);
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = this.mAttributes[1].get("PixelYDimension");
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.mAttributes[0].put("ImageWidth", exifAttribute);
            this.mAttributes[0].put("ImageLength", exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        isThumbnail(this.mAttributes[4]);
        if (this.mMimeType == 8) {
            ExifAttribute exifAttribute3 = this.mAttributes[1].get("MakerNote");
            if (exifAttribute3 != null) {
                ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute3.bytes);
                byteOrderedDataInputStream2.mByteOrder = this.mExifByteOrder;
                byteOrderedDataInputStream2.seek(6);
                readImageFileDirectory(byteOrderedDataInputStream2, 9);
                ExifAttribute exifAttribute4 = this.mAttributes[9].get("ColorSpace");
                if (exifAttribute4 != null) {
                    this.mAttributes[1].put("ColorSpace", exifAttribute4);
                }
            }
        }
    }

    public final void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        getRawAttributes(byteOrderedDataInputStream);
        if (this.mAttributes[0].get("JpgFromRaw") != null) {
            getJpegAttributes(byteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
        }
        ExifAttribute exifAttribute = this.mAttributes[0].get("ISO");
        ExifAttribute exifAttribute2 = this.mAttributes[1].get("PhotographicSensitivity");
        if (exifAttribute != null && exifAttribute2 == null) {
            this.mAttributes[1].put("PhotographicSensitivity", exifAttribute);
        }
    }

    public final void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        int i;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("JPEGInterchangeFormatLength");
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int min = Math.min(exifAttribute2.getIntValue(this.mExifByteOrder), byteOrderedDataInputStream.available() - intValue);
            int i2 = this.mMimeType;
            if (i2 == 4 || i2 == 9 || i2 == 10) {
                i = this.mExifOffset;
            } else {
                if (i2 == 7) {
                    i = this.mOrfMakerNoteOffset;
                }
                if (intValue > 0 && min > 0 && this.mFilename == null && this.mAssetInputStream == null) {
                    byteOrderedDataInputStream.seek((long) intValue);
                    byteOrderedDataInputStream.readFully(new byte[min]);
                    return;
                }
                return;
            }
            intValue += i;
            if (intValue > 0) {
            }
        }
    }

    public final boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (intValue <= 512 && intValue2 <= 512) {
                return true;
            }
        }
        return false;
    }

    public final void loadAttributes(InputStream inputStream) throws IOException {
        int i = 0;
        while (i < EXIF_TAGS.length) {
            try {
                this.mAttributes[i] = new HashMap<>();
                i++;
            } catch (IOException unused) {
            } catch (Throwable th) {
                addDefaultValuesForCompatibility();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.mMimeType = getMimeType(bufferedInputStream);
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream((InputStream) bufferedInputStream);
        switch (this.mMimeType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                getRawAttributes(byteOrderedDataInputStream);
                break;
            case 4:
                getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                break;
            case 7:
                getOrfAttributes(byteOrderedDataInputStream);
                break;
            case 9:
                getRafAttributes(byteOrderedDataInputStream);
                break;
            case 10:
                getRw2Attributes(byteOrderedDataInputStream);
                break;
        }
        setThumbnailData(byteOrderedDataInputStream);
        addDefaultValuesForCompatibility();
    }

    public final void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.mByteOrder = readByteOrder;
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i2 = this.mMimeType;
        if (i2 == 7 || i2 == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt < 8 || readInt >= i) {
                throw new IOException(GeneratedOutlineSupport.outline41("Invalid first Ifd offset: ", readInt));
            }
            int i3 = readInt - 8;
            if (i3 > 0 && byteOrderedDataInputStream.skipBytes(i3) != i3) {
                throw new IOException(GeneratedOutlineSupport.outline41("Couldn't jump to first Ifd: ", i3));
            }
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid start code: ");
        outline73.append(Integer.toHexString(readUnsignedShort));
        throw new IOException(outline73.toString());
    }

    public final ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid byte order: ");
        outline73.append(Integer.toHexString(readShort));
        throw new IOException(outline73.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b4, code lost:
        if (r6 <= 2147483647L) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r23, int r24) throws java.io.IOException {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r4 = r1.mPosition
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.mPosition
            int r3 = r3 + 2
            int r4 = r1.mLength
            if (r3 <= r4) goto L_0x001a
            return
        L_0x001a:
            short r3 = r23.readShort()
            int r4 = r1.mPosition
            int r5 = r3 * 12
            int r5 = r5 + r4
            int r4 = r1.mLength
            if (r5 > r4) goto L_0x029a
            if (r3 > 0) goto L_0x002b
            goto L_0x029a
        L_0x002b:
            r5 = 0
        L_0x002c:
            r8 = 4
            if (r5 >= r3) goto L_0x0257
            int r9 = r23.readUnsignedShort()
            int r10 = r23.readUnsignedShort()
            int r11 = r23.readInt()
            int r12 = r1.mPosition
            long r12 = (long) r12
            r14 = 4
            long r12 = r12 + r14
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r16 = sExifTagMapsForReading
            r4 = r16[r2]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r9)
            java.lang.Object r4 = r4.get(r14)
            androidx.exifinterface.media.ExifInterface$ExifTag r4 = (androidx.exifinterface.media.ExifInterface.ExifTag) r4
            r14 = 9
            r16 = 1
            r6 = 7
            r7 = 3
            if (r4 != 0) goto L_0x0059
            goto L_0x00b7
        L_0x0059:
            if (r10 <= 0) goto L_0x00b7
            int[] r15 = IFD_FORMAT_BYTES_PER_FORMAT
            int r15 = r15.length
            if (r10 < r15) goto L_0x0061
            goto L_0x00b7
        L_0x0061:
            int r15 = r4.primaryFormat
            if (r15 == r6) goto L_0x0094
            if (r10 != r6) goto L_0x0068
            goto L_0x0094
        L_0x0068:
            if (r15 == r10) goto L_0x0094
            int r6 = r4.secondaryFormat
            if (r6 != r10) goto L_0x006f
            goto L_0x0094
        L_0x006f:
            if (r15 == r8) goto L_0x0073
            if (r6 != r8) goto L_0x0076
        L_0x0073:
            if (r10 != r7) goto L_0x0076
            goto L_0x0094
        L_0x0076:
            int r6 = r4.primaryFormat
            if (r6 == r14) goto L_0x007e
            int r6 = r4.secondaryFormat
            if (r6 != r14) goto L_0x0083
        L_0x007e:
            r6 = 8
            if (r10 != r6) goto L_0x0083
            goto L_0x0094
        L_0x0083:
            int r6 = r4.primaryFormat
            r15 = 12
            if (r6 == r15) goto L_0x008d
            int r6 = r4.secondaryFormat
            if (r6 != r15) goto L_0x0092
        L_0x008d:
            r6 = 11
            if (r10 != r6) goto L_0x0092
            goto L_0x0094
        L_0x0092:
            r6 = 0
            goto L_0x0095
        L_0x0094:
            r6 = 1
        L_0x0095:
            if (r6 != 0) goto L_0x009c
            java.lang.String[] r6 = IFD_FORMAT_NAMES
            r6 = r6[r10]
            goto L_0x00b7
        L_0x009c:
            r6 = 7
            if (r10 != r6) goto L_0x00a1
            int r10 = r4.primaryFormat
        L_0x00a1:
            long r14 = (long) r11
            int[] r19 = IFD_FORMAT_BYTES_PER_FORMAT
            r6 = r19[r10]
            long r7 = (long) r6
            long r6 = r7 * r14
            r14 = 0
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x00b9
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x00bb
            goto L_0x00b9
        L_0x00b7:
            r6 = 0
        L_0x00b9:
            r16 = 0
        L_0x00bb:
            if (r16 != 0) goto L_0x00c4
            r1.seek(r12)
            r16 = r3
            goto L_0x0250
        L_0x00c4:
            java.lang.String r8 = "Compression"
            r14 = 4
            int r16 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x0163
            int r14 = r23.readInt()
            int r15 = r0.mMimeType
            r16 = r3
            r3 = 7
            if (r15 != r3) goto L_0x0136
            java.lang.String r3 = r4.name
            java.lang.String r15 = "MakerNote"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00e4
            r0.mOrfMakerNoteOffset = r14
            goto L_0x012f
        L_0x00e4:
            r3 = 6
            if (r2 != r3) goto L_0x012f
            java.lang.String r15 = r4.name
            java.lang.String r3 = "ThumbnailImage"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x012f
            r0.mOrfThumbnailOffset = r14
            r0.mOrfThumbnailLength = r11
            java.nio.ByteOrder r3 = r0.mExifByteOrder
            r15 = 6
            androidx.exifinterface.media.ExifInterface$ExifAttribute r3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(r15, r3)
            int r15 = r0.mOrfThumbnailOffset
            r18 = r10
            r17 = r11
            long r10 = (long) r15
            java.nio.ByteOrder r15 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r10 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(r10, r15)
            int r11 = r0.mOrfThumbnailLength
            r20 = r12
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(r11, r13)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r12 = r0.mAttributes
            r13 = 4
            r12 = r12[r13]
            r12.put(r8, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r13]
            java.lang.String r12 = "JPEGInterchangeFormat"
            r3.put(r12, r10)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r13]
            java.lang.String r10 = "JPEGInterchangeFormatLength"
            r3.put(r10, r11)
            goto L_0x014c
        L_0x012f:
            r18 = r10
            r17 = r11
            r20 = r12
            goto L_0x014c
        L_0x0136:
            r18 = r10
            r17 = r11
            r20 = r12
            r3 = 10
            if (r15 != r3) goto L_0x014c
            java.lang.String r3 = r4.name
            java.lang.String r10 = "JpgFromRaw"
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x014c
            r0.mRw2JpgFromRawOffset = r14
        L_0x014c:
            long r10 = (long) r14
            long r12 = r10 + r6
            int r3 = r1.mLength
            long r14 = (long) r3
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x015c
            r1.seek(r10)
            r12 = r20
            goto L_0x0169
        L_0x015c:
            r12 = r20
            r1.seek(r12)
            goto L_0x0250
        L_0x0163:
            r16 = r3
            r18 = r10
            r17 = r11
        L_0x0169:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r3 = sExifPointerTagMap
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object r3 = r3.get(r9)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x01e8
            r6 = -1
            r10 = r18
            r4 = 3
            if (r10 == r4) goto L_0x019d
            r4 = 4
            if (r10 == r4) goto L_0x0198
            r4 = 8
            if (r10 == r4) goto L_0x0193
            r4 = 9
            if (r10 == r4) goto L_0x018e
            r4 = 13
            if (r10 == r4) goto L_0x018e
            goto L_0x01a2
        L_0x018e:
            int r4 = r23.readInt()
            goto L_0x01a1
        L_0x0193:
            short r4 = r23.readShort()
            goto L_0x01a1
        L_0x0198:
            long r6 = r23.readUnsignedInt()
            goto L_0x01a2
        L_0x019d:
            int r4 = r23.readUnsignedShort()
        L_0x01a1:
            long r6 = (long) r4
        L_0x01a2:
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x01e4
            int r4 = r1.mLength
            long r8 = (long) r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x01e4
            java.util.Set<java.lang.Integer> r4 = r0.mAttributesOffsets
            int r8 = (int) r6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r4 = r4.contains(r8)
            if (r4 != 0) goto L_0x01c7
            r1.seek(r6)
            int r3 = r3.intValue()
            r0.readImageFileDirectory(r1, r3)
            goto L_0x01e4
        L_0x01c7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "Skip jump into the IFD since it has already been read: IfdType "
            r4.append(r8)
            r4.append(r3)
            java.lang.String r3 = " (at "
            r4.append(r3)
            r4.append(r6)
            java.lang.String r3 = ")"
            r4.append(r3)
            r4.toString()
        L_0x01e4:
            r1.seek(r12)
            goto L_0x0250
        L_0x01e8:
            r10 = r18
            int r3 = (int) r6
            byte[] r3 = new byte[r3]
            r1.readFully(r3)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            r7 = r17
            r6.<init>(r10, r7, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r2]
            java.lang.String r7 = r4.name
            r3.put(r7, r6)
            java.lang.String r3 = r4.name
            java.lang.String r7 = "DNGVersion"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x020d
            r3 = 3
            r0.mMimeType = r3
        L_0x020d:
            java.lang.String r3 = r4.name
            java.lang.String r7 = "Make"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0221
            java.lang.String r3 = r4.name
            java.lang.String r7 = "Model"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x022f
        L_0x0221:
            java.nio.ByteOrder r3 = r0.mExifByteOrder
            java.lang.String r3 = r6.getStringValue(r3)
            java.lang.String r7 = "PENTAX"
            boolean r3 = r3.contains(r7)
            if (r3 != 0) goto L_0x0242
        L_0x022f:
            java.lang.String r3 = r4.name
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0246
            java.nio.ByteOrder r3 = r0.mExifByteOrder
            int r3 = r6.getIntValue(r3)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r3 != r4) goto L_0x0246
        L_0x0242:
            r3 = 8
            r0.mMimeType = r3
        L_0x0246:
            int r3 = r1.mPosition
            long r3 = (long) r3
            int r6 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0250
            r1.seek(r12)
        L_0x0250:
            int r5 = r5 + 1
            short r5 = (short) r5
            r3 = r16
            goto L_0x002c
        L_0x0257:
            int r2 = r1.mPosition
            r3 = 4
            int r2 = r2 + r3
            int r3 = r1.mLength
            if (r2 > r3) goto L_0x029a
            int r2 = r23.readInt()
            long r3 = (long) r2
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x029a
            int r5 = r1.mLength
            if (r2 >= r5) goto L_0x029a
            java.util.Set<java.lang.Integer> r5 = r0.mAttributesOffsets
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r5.contains(r2)
            if (r2 != 0) goto L_0x029a
            r1.seek(r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x028c
            r0.readImageFileDirectory(r1, r3)
            goto L_0x029a
        L_0x028c:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x029a
            r0.readImageFileDirectory(r1, r3)
        L_0x029a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.readImageFileDirectory(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (java.util.Arrays.equals(r1, BITS_PER_SAMPLE_GREYSCALE_2) != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (java.util.Arrays.equals(r1, BITS_PER_SAMPLE_RGB) != false) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setThumbnailData(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r12) throws java.io.IOException {
        /*
            r11 = this;
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r0 = r11.mAttributes
            r1 = 4
            r0 = r0[r1]
            java.lang.String r1 = "Compression"
            java.lang.Object r1 = r0.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r1 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r1
            r2 = 6
            if (r1 == 0) goto L_0x00cc
            java.nio.ByteOrder r3 = r11.mExifByteOrder
            int r1 = r1.getIntValue(r3)
            r11.mThumbnailCompression = r1
            r3 = 1
            if (r1 == r3) goto L_0x0027
            if (r1 == r2) goto L_0x0022
            r4 = 7
            if (r1 == r4) goto L_0x0027
            goto L_0x00d1
        L_0x0022:
            r11.handleThumbnailFromJfif(r12, r0)
            goto L_0x00d1
        L_0x0027:
            java.lang.String r1 = "BitsPerSample"
            java.lang.Object r1 = r0.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r1 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r1
            r4 = 0
            if (r1 == 0) goto L_0x006d
            java.nio.ByteOrder r5 = r11.mExifByteOrder
            java.lang.Object r1 = r1.getValue(r5)
            int[] r1 = (int[]) r1
            int[] r5 = BITS_PER_SAMPLE_RGB
            boolean r5 = java.util.Arrays.equals(r5, r1)
            if (r5 == 0) goto L_0x0043
            goto L_0x006e
        L_0x0043:
            int r5 = r11.mMimeType
            r6 = 3
            if (r5 != r6) goto L_0x006d
            java.lang.String r5 = "PhotometricInterpretation"
            java.lang.Object r5 = r0.get(r5)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r5
            if (r5 == 0) goto L_0x006d
            java.nio.ByteOrder r6 = r11.mExifByteOrder
            int r5 = r5.getIntValue(r6)
            if (r5 != r3) goto L_0x0062
            int[] r6 = BITS_PER_SAMPLE_GREYSCALE_2
            boolean r6 = java.util.Arrays.equals(r1, r6)
            if (r6 != 0) goto L_0x006e
        L_0x0062:
            if (r5 != r2) goto L_0x006d
            int[] r2 = BITS_PER_SAMPLE_RGB
            boolean r1 = java.util.Arrays.equals(r1, r2)
            if (r1 == 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r3 = 0
        L_0x006e:
            if (r3 == 0) goto L_0x00d1
            java.lang.String r1 = "StripOffsets"
            java.lang.Object r1 = r0.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r1 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r1
            java.lang.String r2 = "StripByteCounts"
            java.lang.Object r0 = r0.get(r2)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r0 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r0
            if (r1 == 0) goto L_0x00d1
            if (r0 == 0) goto L_0x00d1
            java.nio.ByteOrder r2 = r11.mExifByteOrder
            java.lang.Object r1 = r1.getValue(r2)
            long[] r1 = convertToLongArray(r1)
            java.nio.ByteOrder r2 = r11.mExifByteOrder
            java.lang.Object r0 = r0.getValue(r2)
            long[] r0 = convertToLongArray(r0)
            if (r1 != 0) goto L_0x009b
            goto L_0x00d1
        L_0x009b:
            if (r0 != 0) goto L_0x009e
            goto L_0x00d1
        L_0x009e:
            r2 = 0
            int r5 = r0.length
            r6 = 0
        L_0x00a2:
            if (r6 >= r5) goto L_0x00aa
            r7 = r0[r6]
            long r2 = r2 + r7
            int r6 = r6 + 1
            goto L_0x00a2
        L_0x00aa:
            int r3 = (int) r2
            byte[] r2 = new byte[r3]
            r3 = 0
            r5 = 0
            r6 = 0
        L_0x00b0:
            int r7 = r1.length
            if (r3 >= r7) goto L_0x00d1
            r7 = r1[r3]
            int r8 = (int) r7
            r9 = r0[r3]
            int r7 = (int) r9
            int r8 = r8 - r5
            long r9 = (long) r8
            r12.seek(r9)
            int r5 = r5 + r8
            byte[] r8 = new byte[r7]
            r12.read(r8)
            int r5 = r5 + r7
            java.lang.System.arraycopy(r8, r4, r2, r6, r7)
            int r6 = r6 + r7
            int r3 = r3 + 1
            goto L_0x00b0
        L_0x00cc:
            r11.mThumbnailCompression = r2
            r11.handleThumbnailFromJfif(r12, r0)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.setThumbnailData(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream):void");
    }

    public final void swapBasedOnImageSize(int i, int i2) throws IOException {
        if (!this.mAttributes[i].isEmpty() && !this.mAttributes[i2].isEmpty()) {
            ExifAttribute exifAttribute = this.mAttributes[i].get("ImageLength");
            ExifAttribute exifAttribute2 = this.mAttributes[i].get("ImageWidth");
            ExifAttribute exifAttribute3 = this.mAttributes[i2].get("ImageLength");
            ExifAttribute exifAttribute4 = this.mAttributes[i2].get("ImageWidth");
            if (exifAttribute != null && exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                if (intValue < intValue3 && intValue2 < intValue4) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i2];
                    hashMapArr[i2] = hashMap;
                }
            }
        }
    }

    public final void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.mAttributes[i].get("DefaultCropSize");
        ExifAttribute exifAttribute4 = this.mAttributes[i].get("SensorTopBorder");
        ExifAttribute exifAttribute5 = this.mAttributes[i].get("SensorLeftBorder");
        ExifAttribute exifAttribute6 = this.mAttributes[i].get("SensorBottomBorder");
        ExifAttribute exifAttribute7 = this.mAttributes[i].get("SensorRightBorder");
        if (exifAttribute3 != null) {
            if (exifAttribute3.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Arrays.toString(rationalArr);
                    return;
                } else {
                    exifAttribute2 = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                    exifAttribute = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
                }
            } else {
                int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Arrays.toString(iArr);
                    return;
                } else {
                    exifAttribute2 = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                    exifAttribute = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
                }
            }
            this.mAttributes[i].put("ImageWidth", exifAttribute2);
            this.mAttributes[i].put("ImageLength", exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            ExifAttribute exifAttribute8 = this.mAttributes[i].get("ImageLength");
            ExifAttribute exifAttribute9 = this.mAttributes[i].get("ImageWidth");
            if (exifAttribute8 == null || exifAttribute9 == null) {
                ExifAttribute exifAttribute10 = this.mAttributes[i].get("JPEGInterchangeFormat");
                if (exifAttribute10 != null) {
                    getJpegAttributes(byteOrderedDataInputStream, exifAttribute10.getIntValue(this.mExifByteOrder), i);
                }
            }
        } else {
            int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute6.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute7.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute5.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i].put("ImageLength", createUShort);
                this.mAttributes[i].put("ImageWidth", createUShort2);
            }
        }
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            this.mFilename = null;
            if (inputStream instanceof AssetInputStream) {
                this.mAssetInputStream = (AssetInputStream) inputStream;
            } else {
                this.mAssetInputStream = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }
}
