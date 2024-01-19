package org.apache.fontbox.ttf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.cmap.CMap;

public class CmapSubtable {
    public static final long LEAD_OFFSET = 55232;
    public static final long SURROGATE_OFFSET = -56613888;
    public Map<Integer, Integer> characterCodeToGlyphId = new HashMap();
    public int[] glyphIdToCharacterCode;
    public int platformEncodingId;
    public int platformId;
    public long subTableOffset;

    public class SubHeader {
        public final int entryCount;
        public final int firstCode;
        public final short idDelta;
        public final int idRangeOffset;

        /* access modifiers changed from: private */
        public int getEntryCount() {
            return this.entryCount;
        }

        /* access modifiers changed from: private */
        public int getFirstCode() {
            return this.firstCode;
        }

        /* access modifiers changed from: private */
        public short getIdDelta() {
            return this.idDelta;
        }

        /* access modifiers changed from: private */
        public int getIdRangeOffset() {
            return this.idRangeOffset;
        }

        public SubHeader(int i, int i2, short s, int i3) {
            this.firstCode = i;
            this.entryCount = i2;
            this.idDelta = s;
            this.idRangeOffset = i3;
        }
    }

    private int[] newGlyphIdToCharacterCode(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public Integer getCharacterCode(int i) {
        if (i >= 0) {
            int[] iArr = this.glyphIdToCharacterCode;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == -1) {
                    return null;
                }
                return Integer.valueOf(i2);
            }
        }
        return null;
    }

    public int getGlyphId(int i) {
        Integer num = this.characterCodeToGlyphId.get(Integer.valueOf(i));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPlatformEncodingId() {
        return this.platformEncodingId;
    }

    public int getPlatformId() {
        return this.platformId;
    }

    public void initData(TTFDataStream tTFDataStream) throws IOException {
        this.platformId = tTFDataStream.readUnsignedShort();
        this.platformEncodingId = tTFDataStream.readUnsignedShort();
        this.subTableOffset = tTFDataStream.readUnsignedInt();
    }

    public void initSubtable(CmapTable cmapTable, int i, TTFDataStream tTFDataStream) throws IOException {
        tTFDataStream.seek(cmapTable.getOffset() + this.subTableOffset);
        int readUnsignedShort = tTFDataStream.readUnsignedShort();
        if (readUnsignedShort < 8) {
            tTFDataStream.readUnsignedShort();
            tTFDataStream.readUnsignedShort();
        } else {
            tTFDataStream.readUnsignedShort();
            tTFDataStream.readUnsignedInt();
            tTFDataStream.readUnsignedInt();
        }
        if (readUnsignedShort == 0) {
            processSubtype0(tTFDataStream);
        } else if (readUnsignedShort == 2) {
            processSubtype2(tTFDataStream, i);
        } else if (readUnsignedShort == 4) {
            processSubtype4(tTFDataStream, i);
        } else if (readUnsignedShort == 6) {
            processSubtype6(tTFDataStream, i);
        } else if (readUnsignedShort == 8) {
            processSubtype8(tTFDataStream, i);
        } else if (readUnsignedShort != 10) {
            switch (readUnsignedShort) {
                case 12:
                    processSubtype12(tTFDataStream, i);
                    return;
                case 13:
                    processSubtype13(tTFDataStream, i);
                    return;
                case 14:
                    processSubtype14(tTFDataStream, i);
                    return;
                default:
                    throw new IOException(GeneratedOutlineSupport.outline41("Unknown cmap format:", readUnsignedShort));
            }
        } else {
            processSubtype10(tTFDataStream, i);
        }
    }

    public void processSubtype0(TTFDataStream tTFDataStream) throws IOException {
        byte[] read = tTFDataStream.read(256);
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(256);
        for (int i = 0; i < read.length; i++) {
            int i2 = (read[i] + 256) % 256;
            this.glyphIdToCharacterCode[i2] = i;
            this.characterCodeToGlyphId.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void processSubtype10(TTFDataStream tTFDataStream, int i) throws IOException {
        long readUnsignedInt = tTFDataStream.readUnsignedInt();
        long readUnsignedInt2 = tTFDataStream.readUnsignedInt();
        if (readUnsignedInt2 <= 2147483647L) {
            if (readUnsignedInt >= 0 && readUnsignedInt <= 1114111) {
                long j = readUnsignedInt + readUnsignedInt2;
                if (j <= 1114111 && (j < 55296 || j > 57343)) {
                    return;
                }
            }
            throw new IOException("Invalid Characters codes");
        }
        throw new IOException("Invalid number of Characters");
    }

    public void processSubtype12(TTFDataStream tTFDataStream, int i) throws IOException {
        int i2 = i;
        long readUnsignedInt = tTFDataStream.readUnsignedInt();
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i2);
        long j = 0;
        long j2 = 0;
        while (j2 < readUnsignedInt) {
            long readUnsignedInt2 = tTFDataStream.readUnsignedInt();
            long readUnsignedInt3 = tTFDataStream.readUnsignedInt();
            long readUnsignedInt4 = tTFDataStream.readUnsignedInt();
            if (readUnsignedInt2 < j || readUnsignedInt2 > 1114111 || (readUnsignedInt2 >= 55296 && readUnsignedInt2 <= 57343)) {
                throw new IOException("Invalid characters codes");
            } else if ((readUnsignedInt3 <= j || readUnsignedInt3 >= readUnsignedInt2) && readUnsignedInt3 <= 1114111 && (readUnsignedInt3 < 55296 || readUnsignedInt3 > 57343)) {
                long j3 = j;
                while (j3 <= readUnsignedInt3 - readUnsignedInt2) {
                    long j4 = readUnsignedInt4 + j3;
                    long j5 = readUnsignedInt;
                    if (j4 < ((long) i2)) {
                        long j6 = readUnsignedInt2 + j3;
                        int i3 = (j6 > 1114111 ? 1 : (j6 == 1114111 ? 0 : -1));
                        int i4 = (int) j4;
                        int i5 = (int) j6;
                        this.glyphIdToCharacterCode[i4] = i5;
                        this.characterCodeToGlyphId.put(Integer.valueOf(i5), Integer.valueOf(i4));
                        j3++;
                        readUnsignedInt = j5;
                    } else {
                        throw new IOException("Character Code greater than Integer.MAX_VALUE");
                    }
                }
                long j7 = readUnsignedInt;
                j2++;
                j = 0;
            } else {
                throw new IOException("Invalid characters codes");
            }
        }
    }

    public void processSubtype13(TTFDataStream tTFDataStream, int i) throws IOException {
        long readUnsignedInt = tTFDataStream.readUnsignedInt();
        long j = 0;
        long j2 = 0;
        while (j2 < readUnsignedInt) {
            long readUnsignedInt2 = tTFDataStream.readUnsignedInt();
            long readUnsignedInt3 = tTFDataStream.readUnsignedInt();
            long readUnsignedInt4 = tTFDataStream.readUnsignedInt();
            if (readUnsignedInt4 <= ((long) i)) {
                if (readUnsignedInt2 >= j) {
                    long j3 = 1114111;
                    if (readUnsignedInt2 <= 1114111 && (readUnsignedInt2 < 55296 || readUnsignedInt2 > 57343)) {
                        if ((readUnsignedInt3 <= j || readUnsignedInt3 >= readUnsignedInt2) && readUnsignedInt3 <= 1114111 && (readUnsignedInt3 < 55296 || readUnsignedInt3 > 57343)) {
                            long j4 = j;
                            while (j4 <= readUnsignedInt3 - readUnsignedInt2) {
                                long j5 = readUnsignedInt2 + j4;
                                if (j5 <= 2147483647L) {
                                    int i2 = (j5 > j3 ? 1 : (j5 == j3 ? 0 : -1));
                                    int i3 = (int) readUnsignedInt4;
                                    int i4 = (int) j5;
                                    this.glyphIdToCharacterCode[i3] = i4;
                                    this.characterCodeToGlyphId.put(Integer.valueOf(i4), Integer.valueOf(i3));
                                    j4++;
                                    j3 = 1114111;
                                } else {
                                    throw new IOException("Character Code greater than Integer.MAX_VALUE");
                                }
                            }
                            j2++;
                            j = 0;
                        } else {
                            throw new IOException("Invalid Characters codes");
                        }
                    }
                }
                throw new IOException("Invalid Characters codes");
            }
            return;
        }
    }

    public void processSubtype14(TTFDataStream tTFDataStream, int i) throws IOException {
    }

    public void processSubtype2(TTFDataStream tTFDataStream, int i) throws IOException {
        int[] iArr = new int[256];
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            iArr[i3] = tTFDataStream.readUnsignedShort();
            i2 = Math.max(i2, iArr[i3] / 8);
        }
        int i4 = i2 + 1;
        SubHeader[] subHeaderArr = new SubHeader[i4];
        for (int i5 = 0; i5 <= i2; i5++) {
            SubHeader subHeader = new SubHeader(tTFDataStream.readUnsignedShort(), tTFDataStream.readUnsignedShort(), tTFDataStream.readSignedShort(), (tTFDataStream.readUnsignedShort() - (((i4 - i5) - 1) * 8)) - 2);
            subHeaderArr[i5] = subHeader;
        }
        long currentPosition = tTFDataStream.getCurrentPosition();
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i);
        for (int i6 = 0; i6 <= i2; i6++) {
            SubHeader subHeader2 = subHeaderArr[i6];
            int access$100 = subHeader2.getFirstCode();
            int access$200 = subHeader2.getIdRangeOffset();
            short access$300 = subHeader2.getIdDelta();
            int access$400 = subHeader2.getEntryCount();
            tTFDataStream.seek(((long) access$200) + currentPosition);
            for (int i7 = 0; i7 < access$400; i7++) {
                int i8 = access$100 + i7 + (i6 << 8);
                int readUnsignedShort = tTFDataStream.readUnsignedShort();
                if (readUnsignedShort > 0) {
                    readUnsignedShort = (readUnsignedShort + access$300) % 65536;
                }
                this.glyphIdToCharacterCode[readUnsignedShort] = i8;
                this.characterCodeToGlyphId.put(Integer.valueOf(i8), Integer.valueOf(readUnsignedShort));
            }
        }
    }

    public void processSubtype4(TTFDataStream tTFDataStream, int i) throws IOException {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        TTFDataStream tTFDataStream2 = tTFDataStream;
        int readUnsignedShort = tTFDataStream.readUnsignedShort() / 2;
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        int[] readUnsignedShortArray = tTFDataStream2.readUnsignedShortArray(readUnsignedShort);
        tTFDataStream.readUnsignedShort();
        int[] readUnsignedShortArray2 = tTFDataStream2.readUnsignedShortArray(readUnsignedShort);
        int[] readUnsignedShortArray3 = tTFDataStream2.readUnsignedShortArray(readUnsignedShort);
        int[] readUnsignedShortArray4 = tTFDataStream2.readUnsignedShortArray(readUnsignedShort);
        HashMap hashMap = new HashMap();
        long currentPosition = tTFDataStream.getCurrentPosition();
        int i2 = 0;
        while (i2 < readUnsignedShort) {
            int i3 = readUnsignedShortArray2[i2];
            int i4 = readUnsignedShortArray[i2];
            int i5 = readUnsignedShortArray3[i2];
            int i6 = readUnsignedShortArray4[i2];
            if (!(i3 == 65535 || i4 == 65535)) {
                int i7 = i3;
                while (i7 <= i4) {
                    if (i6 == 0) {
                        int i8 = (i7 + i5) % 65536;
                        iArr = readUnsignedShortArray;
                        iArr3 = readUnsignedShortArray2;
                        hashMap.put(Integer.valueOf(i8), Integer.valueOf(i7));
                        iArr2 = readUnsignedShortArray3;
                        this.characterCodeToGlyphId.put(Integer.valueOf(i7), Integer.valueOf(i8));
                    } else {
                        iArr = readUnsignedShortArray;
                        iArr3 = readUnsignedShortArray2;
                        iArr2 = readUnsignedShortArray3;
                        tTFDataStream2.seek(((long) (((i2 - readUnsignedShort) + (i7 - i3) + (i6 / 2)) * 2)) + currentPosition);
                        int readUnsignedShort2 = tTFDataStream.readUnsignedShort();
                        if (readUnsignedShort2 != 0) {
                            int i9 = (readUnsignedShort2 + i5) % 65536;
                            if (!hashMap.containsKey(Integer.valueOf(i9))) {
                                hashMap.put(Integer.valueOf(i9), Integer.valueOf(i7));
                                this.characterCodeToGlyphId.put(Integer.valueOf(i7), Integer.valueOf(i9));
                            }
                        }
                    }
                    i7++;
                    readUnsignedShortArray = iArr;
                    readUnsignedShortArray2 = iArr3;
                    readUnsignedShortArray3 = iArr2;
                }
            }
            i2++;
            readUnsignedShortArray = readUnsignedShortArray;
            readUnsignedShortArray2 = readUnsignedShortArray2;
            readUnsignedShortArray3 = readUnsignedShortArray3;
        }
        if (!hashMap.isEmpty()) {
            this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(((Integer) Collections.max(hashMap.keySet())).intValue() + 1);
            for (Entry entry : hashMap.entrySet()) {
                this.glyphIdToCharacterCode[((Integer) entry.getKey()).intValue()] = ((Integer) entry.getValue()).intValue();
            }
        }
    }

    public void processSubtype6(TTFDataStream tTFDataStream, int i) throws IOException {
        int readUnsignedShort = tTFDataStream.readUnsignedShort();
        int readUnsignedShort2 = tTFDataStream.readUnsignedShort();
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i);
        int[] readUnsignedShortArray = tTFDataStream.readUnsignedShortArray(readUnsignedShort2);
        for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
            int i3 = readUnsignedShort + i2;
            this.glyphIdToCharacterCode[readUnsignedShortArray[i2]] = i3;
            this.characterCodeToGlyphId.put(Integer.valueOf(i3), Integer.valueOf(readUnsignedShortArray[i2]));
        }
    }

    public void processSubtype8(TTFDataStream tTFDataStream, int i) throws IOException {
        int i2 = i;
        int[] readUnsignedByteArray = tTFDataStream.readUnsignedByteArray(8192);
        long readUnsignedInt = tTFDataStream.readUnsignedInt();
        if (readUnsignedInt <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i2);
            long j = 0;
            long j2 = 0;
            while (j2 < readUnsignedInt) {
                long readUnsignedInt2 = tTFDataStream.readUnsignedInt();
                long readUnsignedInt3 = tTFDataStream.readUnsignedInt();
                long readUnsignedInt4 = tTFDataStream.readUnsignedInt();
                if (readUnsignedInt2 > readUnsignedInt3 || j > readUnsignedInt2) {
                    throw new IOException("Range invalid");
                }
                long j3 = readUnsignedInt2;
                while (j3 <= readUnsignedInt3) {
                    if (j3 <= 2147483647L) {
                        long j4 = readUnsignedInt;
                        int i3 = (int) j3;
                        if ((readUnsignedByteArray[i3 / 8] & (1 << (i3 % 8))) != 0) {
                            long j5 = (((j3 >> 10) + LEAD_OFFSET) << 10) + (j3 & 1023) + 56320 + SURROGATE_OFFSET;
                            if (j5 <= 2147483647L) {
                                i3 = (int) j5;
                            } else {
                                throw new IOException("[Sub Format 8] Invalid Character code");
                            }
                        }
                        int[] iArr = readUnsignedByteArray;
                        long j6 = (j3 - readUnsignedInt2) + readUnsignedInt4;
                        long j7 = readUnsignedInt2;
                        if (j6 > ((long) i2) || j6 > 2147483647L) {
                            throw new IOException("CMap contains an invalid glyph index");
                        }
                        int i4 = (int) j6;
                        this.glyphIdToCharacterCode[i4] = i3;
                        this.characterCodeToGlyphId.put(Integer.valueOf(i3), Integer.valueOf(i4));
                        j3++;
                        TTFDataStream tTFDataStream2 = tTFDataStream;
                        readUnsignedByteArray = iArr;
                        readUnsignedInt = j4;
                        readUnsignedInt2 = j7;
                    } else {
                        throw new IOException("[Sub Format 8] Invalid Character code");
                    }
                }
                int[] iArr2 = readUnsignedByteArray;
                j2++;
                TTFDataStream tTFDataStream3 = tTFDataStream;
                readUnsignedInt = readUnsignedInt;
                j = 0;
            }
            return;
        }
        throw new IOException("CMap ( Subtype8 ) is invalid");
    }

    public void setPlatformEncodingId(int i) {
        this.platformEncodingId = i;
    }

    public void setPlatformId(int i) {
        this.platformId = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{");
        outline73.append(getPlatformId());
        outline73.append(CMap.SPACE);
        outline73.append(getPlatformEncodingId());
        outline73.append("}");
        return outline73.toString();
    }
}
