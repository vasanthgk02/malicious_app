package org.apache.fontbox.ttf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.lang.CharEncoding;

public final class TTFSubsetter {
    public static final byte[] PAD_BUF = {0, 0, 0};
    public final SortedSet<Integer> glyphIds;
    public boolean hasAddedCompoundReferences;
    public final List<String> keepTables;
    public String prefix;
    public final TrueTypeFont ttf;
    public final SortedMap<Integer, Integer> uniToGID;
    public final CmapSubtable unicodeCmap;

    public TTFSubsetter(TrueTypeFont trueTypeFont) throws IOException {
        this(trueTypeFont, null);
    }

    private void addCompoundReferences() throws IOException {
        boolean z;
        byte b2;
        if (!this.hasAddedCompoundReferences) {
            this.hasAddedCompoundReferences = true;
            do {
                GlyphTable glyph = this.ttf.getGlyph();
                long[] offsets = this.ttf.getIndexToLocation().getOffsets();
                InputStream originalData = this.ttf.getOriginalData();
                TreeSet treeSet = null;
                try {
                    originalData.skip(glyph.getOffset());
                    long j = 0;
                    Iterator it = this.glyphIds.iterator();
                    while (true) {
                        z = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        Integer num = (Integer) it.next();
                        long j2 = offsets[num.intValue()];
                        long j3 = offsets[num.intValue() + 1] - j2;
                        originalData.skip(j2 - j);
                        int i = (int) j3;
                        byte[] bArr = new byte[i];
                        originalData.read(bArr);
                        if (i >= 2 && bArr[0] == -1 && bArr[1] == -1) {
                            int i2 = 10;
                            do {
                                b2 = ((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255);
                                int i3 = i2 + 2;
                                byte b3 = ((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255);
                                if (!this.glyphIds.contains(Integer.valueOf(b3))) {
                                    if (treeSet == null) {
                                        treeSet = new TreeSet();
                                    }
                                    treeSet.add(Integer.valueOf(b3));
                                }
                                int i4 = i3 + 2;
                                i2 = (b2 & 1) != 0 ? i4 + 4 : i4 + 2;
                                if ((b2 & 128) != 0) {
                                    i2 += 8;
                                } else if ((b2 & 64) != 0) {
                                    i2 += 4;
                                } else if ((b2 & 8) != 0) {
                                    i2 += 2;
                                }
                            } while ((b2 & 32) != 0);
                            j = offsets[num.intValue() + 1];
                        } else {
                            j = offsets[num.intValue() + 1];
                        }
                    }
                    if (treeSet != null) {
                        this.glyphIds.addAll(treeSet);
                    }
                    if (treeSet != null) {
                        z = true;
                        continue;
                    }
                } finally {
                    originalData.close();
                }
            } while (z);
        }
    }

    private byte[] buildCmapTable() throws IOException {
        if (this.ttf.getCmap() != null) {
            List<String> list = this.keepTables;
            if (list == null || list.contains(CmapTable.TAG)) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                writeUint16(dataOutputStream, 0);
                writeUint16(dataOutputStream, 1);
                writeUint16(dataOutputStream, 3);
                writeUint16(dataOutputStream, 1);
                writeUint32(dataOutputStream, 12);
                Iterator<Entry<Integer, Integer>> it = this.uniToGID.entrySet().iterator();
                it.next();
                Entry next = it.next();
                int newGlyphId = getNewGlyphId((Integer) next.getValue());
                int[] iArr = new int[this.uniToGID.size()];
                int[] iArr2 = new int[this.uniToGID.size()];
                int[] iArr3 = new int[this.uniToGID.size()];
                int i = newGlyphId;
                int i2 = 0;
                Entry entry = next;
                while (it.hasNext()) {
                    Entry next2 = it.next();
                    int newGlyphId2 = getNewGlyphId((Integer) next2.getValue());
                    if (((Integer) next2.getKey()).intValue() <= 65535) {
                        if (((Integer) next2.getKey()).intValue() != ((Integer) entry.getKey()).intValue() + 1 || newGlyphId2 - i != ((Integer) next2.getKey()).intValue() - ((Integer) next.getKey()).intValue()) {
                            if (i != 0) {
                                iArr[i2] = ((Integer) next.getKey()).intValue();
                                iArr2[i2] = ((Integer) entry.getKey()).intValue();
                                iArr3[i2] = i - ((Integer) next.getKey()).intValue();
                            } else {
                                if (!((Integer) next.getKey()).equals(entry.getKey())) {
                                    iArr[i2] = ((Integer) next.getKey()).intValue() + 1;
                                    iArr2[i2] = ((Integer) entry.getKey()).intValue();
                                    iArr3[i2] = i - ((Integer) next.getKey()).intValue();
                                }
                                next = next2;
                                i = newGlyphId2;
                            }
                            i2++;
                            next = next2;
                            i = newGlyphId2;
                        }
                        entry = next2;
                    } else {
                        throw new UnsupportedOperationException("non-BMP Unicode character");
                    }
                }
                iArr[i2] = ((Integer) next.getKey()).intValue();
                iArr2[i2] = ((Integer) entry.getKey()).intValue();
                iArr3[i2] = i - ((Integer) next.getKey()).intValue();
                int i3 = i2 + 1;
                iArr[i3] = 65535;
                iArr2[i3] = 65535;
                iArr3[i3] = 1;
                int i4 = i3 + 1;
                int pow = ((int) Math.pow(2.0d, Math.floor((double) log2(i4)))) * 2;
                writeUint16(dataOutputStream, 4);
                writeUint16(dataOutputStream, (i4 * 4 * 2) + 16);
                writeUint16(dataOutputStream, 0);
                int i5 = i4 * 2;
                writeUint16(dataOutputStream, i5);
                writeUint16(dataOutputStream, pow);
                writeUint16(dataOutputStream, log2(pow / 2));
                writeUint16(dataOutputStream, i5 - pow);
                for (int i6 = 0; i6 < i4; i6++) {
                    writeUint16(dataOutputStream, iArr2[i6]);
                }
                writeUint16(dataOutputStream, 0);
                for (int i7 = 0; i7 < i4; i7++) {
                    writeUint16(dataOutputStream, iArr[i7]);
                }
                for (int i8 = 0; i8 < i4; i8++) {
                    writeUint16(dataOutputStream, iArr3[i8]);
                }
                for (int i9 = 0; i9 < i4; i9++) {
                    writeUint16(dataOutputStream, 0);
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010b A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0119 A[Catch:{ all -> 0x012e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] buildGlyfTable(long[] r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            org.apache.fontbox.ttf.TrueTypeFont r2 = r1.ttf
            org.apache.fontbox.ttf.GlyphTable r2 = r2.getGlyph()
            org.apache.fontbox.ttf.TrueTypeFont r3 = r1.ttf
            org.apache.fontbox.ttf.IndexToLocationTable r3 = r3.getIndexToLocation()
            long[] r3 = r3.getOffsets()
            org.apache.fontbox.ttf.TrueTypeFont r4 = r1.ttf
            java.io.InputStream r4 = r4.getOriginalData()
            long r5 = r2.getOffset()     // Catch:{ all -> 0x012e }
            r4.skip(r5)     // Catch:{ all -> 0x012e }
            java.util.SortedSet<java.lang.Integer> r2 = r1.glyphIds     // Catch:{ all -> 0x012e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x012e }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
        L_0x0030:
            boolean r13 = r2.hasNext()     // Catch:{ all -> 0x012e }
            if (r13 == 0) goto L_0x0124
            java.lang.Object r13 = r2.next()     // Catch:{ all -> 0x012e }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x012e }
            int r14 = r13.intValue()     // Catch:{ all -> 0x012e }
            r14 = r3[r14]     // Catch:{ all -> 0x012e }
            int r13 = r13.intValue()     // Catch:{ all -> 0x012e }
            r16 = 1
            int r13 = r13 + 1
            r17 = r3[r13]     // Catch:{ all -> 0x012e }
            long r5 = r17 - r14
            int r13 = r8 + 1
            r21[r8] = r9     // Catch:{ all -> 0x012e }
            long r11 = r14 - r11
            r4.skip(r11)     // Catch:{ all -> 0x012e }
            int r8 = (int) r5     // Catch:{ all -> 0x012e }
            byte[] r11 = new byte[r8]     // Catch:{ all -> 0x012e }
            r4.read(r11)     // Catch:{ all -> 0x012e }
            r12 = 2
            if (r8 < r12) goto L_0x00f5
            byte r12 = r11[r7]     // Catch:{ all -> 0x012e }
            r7 = -1
            if (r12 != r7) goto L_0x00f5
            byte r12 = r11[r16]     // Catch:{ all -> 0x012e }
            if (r12 != r7) goto L_0x00f5
            r7 = 10
        L_0x006b:
            byte r8 = r11[r7]     // Catch:{ all -> 0x012e }
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << 8
            int r12 = r7 + 1
            byte r12 = r11[r12]     // Catch:{ all -> 0x012e }
            r12 = r12 & 255(0xff, float:3.57E-43)
            r8 = r8 | r12
            int r7 = r7 + 2
            byte r12 = r11[r7]     // Catch:{ all -> 0x012e }
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            int r16 = r7 + 1
            r18 = r2
            byte r2 = r11[r16]     // Catch:{ all -> 0x012e }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r2 = r2 | r12
            java.util.SortedSet<java.lang.Integer> r12 = r1.glyphIds     // Catch:{ all -> 0x012e }
            r19 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012e }
            boolean r3 = r12.contains(r3)     // Catch:{ all -> 0x012e }
            if (r3 != 0) goto L_0x00a0
            java.util.SortedSet<java.lang.Integer> r3 = r1.glyphIds     // Catch:{ all -> 0x012e }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012e }
            r3.add(r12)     // Catch:{ all -> 0x012e }
        L_0x00a0:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012e }
            int r2 = r1.getNewGlyphId(r2)     // Catch:{ all -> 0x012e }
            int r3 = r2 >>> 8
            byte r3 = (byte) r3     // Catch:{ all -> 0x012e }
            r11[r7] = r3     // Catch:{ all -> 0x012e }
            byte r2 = (byte) r2     // Catch:{ all -> 0x012e }
            r11[r16] = r2     // Catch:{ all -> 0x012e }
            int r7 = r7 + 2
            r2 = r8 & 1
            if (r2 == 0) goto L_0x00b9
            int r7 = r7 + 4
            goto L_0x00bb
        L_0x00b9:
            int r7 = r7 + 2
        L_0x00bb:
            r2 = r8 & 128(0x80, float:1.8E-43)
            if (r2 == 0) goto L_0x00c2
            int r7 = r7 + 8
            goto L_0x00cf
        L_0x00c2:
            r2 = r8 & 64
            if (r2 == 0) goto L_0x00c9
            int r7 = r7 + 4
            goto L_0x00cf
        L_0x00c9:
            r2 = r8 & 8
            if (r2 == 0) goto L_0x00cf
            int r7 = r7 + 2
        L_0x00cf:
            r2 = r8 & 32
            if (r2 != 0) goto L_0x00ef
            r2 = r8 & 256(0x100, float:3.59E-43)
            r3 = 256(0x100, float:3.59E-43)
            if (r2 != r3) goto L_0x00e9
            byte r2 = r11[r7]     // Catch:{ all -> 0x012e }
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            int r3 = r7 + 1
            byte r3 = r11[r3]     // Catch:{ all -> 0x012e }
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            int r7 = r7 + 2
            int r7 = r7 + r2
        L_0x00e9:
            r2 = 0
            r0.write(r11, r2, r7)     // Catch:{ all -> 0x012e }
            long r2 = (long) r7     // Catch:{ all -> 0x012e }
            goto L_0x0100
        L_0x00ef:
            r2 = r18
            r3 = r19
            goto L_0x006b
        L_0x00f5:
            r18 = r2
            r19 = r3
            if (r8 <= 0) goto L_0x0101
            r2 = 0
            r0.write(r11, r2, r8)     // Catch:{ all -> 0x012e }
            long r2 = (long) r8     // Catch:{ all -> 0x012e }
        L_0x0100:
            long r9 = r9 + r2
        L_0x0101:
            r2 = 4
            long r7 = r9 % r2
            r11 = 0
            int r16 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r16 == 0) goto L_0x0119
            long r2 = r9 % r2
            int r3 = (int) r2     // Catch:{ all -> 0x012e }
            int r2 = 4 - r3
            byte[] r3 = PAD_BUF     // Catch:{ all -> 0x012e }
            r7 = 0
            r0.write(r3, r7, r2)     // Catch:{ all -> 0x012e }
            long r2 = (long) r2     // Catch:{ all -> 0x012e }
            long r9 = r9 + r2
            goto L_0x011a
        L_0x0119:
            r7 = 0
        L_0x011a:
            long r2 = r14 + r5
            r11 = r2
            r8 = r13
            r2 = r18
            r3 = r19
            goto L_0x0030
        L_0x0124:
            r21[r8] = r9     // Catch:{ all -> 0x012e }
            r4.close()
            byte[] r0 = r0.toByteArray()
            return r0
        L_0x012e:
            r0 = move-exception
            r4.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.fontbox.ttf.TTFSubsetter.buildGlyfTable(long[]):byte[]");
    }

    private byte[] buildHeadTable() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        HeaderTable header = this.ttf.getHeader();
        writeFixed(dataOutputStream, (double) header.getVersion());
        writeFixed(dataOutputStream, (double) header.getFontRevision());
        writeUint32(dataOutputStream, 0);
        writeUint32(dataOutputStream, header.getMagicNumber());
        writeUint16(dataOutputStream, header.getFlags());
        writeUint16(dataOutputStream, header.getUnitsPerEm());
        writeLongDateTime(dataOutputStream, header.getCreated());
        writeLongDateTime(dataOutputStream, header.getModified());
        writeSInt16(dataOutputStream, header.getXMin());
        writeSInt16(dataOutputStream, header.getYMin());
        writeSInt16(dataOutputStream, header.getXMax());
        writeSInt16(dataOutputStream, header.getYMax());
        writeUint16(dataOutputStream, header.getMacStyle());
        writeUint16(dataOutputStream, header.getLowestRecPPEM());
        writeSInt16(dataOutputStream, header.getFontDirectionHint());
        writeSInt16(dataOutputStream, 1);
        writeSInt16(dataOutputStream, header.getGlyphDataFormat());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildHheaTable() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        HorizontalHeaderTable horizontalHeader = this.ttf.getHorizontalHeader();
        writeFixed(dataOutputStream, (double) horizontalHeader.getVersion());
        writeSInt16(dataOutputStream, horizontalHeader.getAscender());
        writeSInt16(dataOutputStream, horizontalHeader.getDescender());
        writeSInt16(dataOutputStream, horizontalHeader.getLineGap());
        writeUint16(dataOutputStream, horizontalHeader.getAdvanceWidthMax());
        writeSInt16(dataOutputStream, horizontalHeader.getMinLeftSideBearing());
        writeSInt16(dataOutputStream, horizontalHeader.getMinRightSideBearing());
        writeSInt16(dataOutputStream, horizontalHeader.getXMaxExtent());
        writeSInt16(dataOutputStream, horizontalHeader.getCaretSlopeRise());
        writeSInt16(dataOutputStream, horizontalHeader.getCaretSlopeRun());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved1());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved2());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved3());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved4());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved5());
        writeSInt16(dataOutputStream, horizontalHeader.getMetricDataFormat());
        writeUint16(dataOutputStream, this.glyphIds.subSet(Integer.valueOf(0), Integer.valueOf(horizontalHeader.getNumberOfHMetrics())).size());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildHmtxTable() throws IOException {
        long j;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HorizontalHeaderTable horizontalHeader = this.ttf.getHorizontalHeader();
        HorizontalMetricsTable horizontalMetrics = this.ttf.getHorizontalMetrics();
        byte[] bArr = new byte[4];
        InputStream originalData = this.ttf.getOriginalData();
        try {
            originalData.skip(horizontalMetrics.getOffset());
            long j2 = 0;
            for (Integer num : this.glyphIds) {
                int i = 2;
                if (num.intValue() < horizontalHeader.getNumberOfHMetrics()) {
                    j = (long) (num.intValue() * 4);
                } else {
                    j = (long) (((num.intValue() - horizontalHeader.getNumberOfHMetrics()) * 2) + (horizontalHeader.getNumberOfHMetrics() * 4));
                }
                if (j != j2) {
                    long j3 = j - j2;
                    if (j3 != originalData.skip(j3)) {
                        throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
                    }
                }
                if (num.intValue() < horizontalHeader.getNumberOfHMetrics()) {
                    i = 4;
                }
                if (i == originalData.read(bArr, 0, i)) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    j2 = ((long) i) + j;
                } else {
                    throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            originalData.close();
        }
    }

    public static byte[] buildLocaTable(long[] jArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (long writeUint32 : jArr) {
            writeUint32(dataOutputStream, writeUint32);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildMaxpTable() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        MaximumProfileTable maximumProfile = this.ttf.getMaximumProfile();
        writeFixed(dataOutputStream, 1.0d);
        writeUint16(dataOutputStream, this.glyphIds.size());
        writeUint16(dataOutputStream, maximumProfile.getMaxPoints());
        writeUint16(dataOutputStream, maximumProfile.getMaxContours());
        writeUint16(dataOutputStream, maximumProfile.getMaxCompositePoints());
        writeUint16(dataOutputStream, maximumProfile.getMaxCompositeContours());
        writeUint16(dataOutputStream, maximumProfile.getMaxZones());
        writeUint16(dataOutputStream, maximumProfile.getMaxTwilightPoints());
        writeUint16(dataOutputStream, maximumProfile.getMaxStorage());
        writeUint16(dataOutputStream, maximumProfile.getMaxFunctionDefs());
        writeUint16(dataOutputStream, maximumProfile.getMaxInstructionDefs());
        writeUint16(dataOutputStream, maximumProfile.getMaxStackElements());
        writeUint16(dataOutputStream, maximumProfile.getMaxSizeOfInstructions());
        writeUint16(dataOutputStream, maximumProfile.getMaxComponentElements());
        writeUint16(dataOutputStream, maximumProfile.getMaxComponentDepth());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildNameTable() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        NamingTable naming = this.ttf.getNaming();
        if (naming != null) {
            List<String> list = this.keepTables;
            if (list == null || list.contains("name")) {
                List<NameRecord> nameRecords = naming.getNameRecords();
                int i = 0;
                for (NameRecord shouldCopyNameRecord : nameRecords) {
                    if (shouldCopyNameRecord(shouldCopyNameRecord)) {
                        i++;
                    }
                }
                writeUint16(dataOutputStream, 0);
                writeUint16(dataOutputStream, i);
                writeUint16(dataOutputStream, (i * 12) + 6);
                if (i == 0) {
                    return null;
                }
                byte[][] bArr = new byte[i][];
                int i2 = 0;
                for (NameRecord next : nameRecords) {
                    if (shouldCopyNameRecord(next)) {
                        int platformId = next.getPlatformId();
                        int platformEncodingId = next.getPlatformEncodingId();
                        String str = "ISO-8859-1";
                        if (platformId == 3 && platformEncodingId == 1) {
                            str = CharEncoding.UTF_16BE;
                        } else if (platformId == 2) {
                            if (platformEncodingId == 0) {
                                str = "US-ASCII";
                            } else if (platformEncodingId == 1) {
                                str = "UTF16-BE";
                            }
                        }
                        String string = next.getString();
                        if (next.getNameId() == 6 && this.prefix != null) {
                            string = GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, string);
                        }
                        bArr[i2] = string.getBytes(str);
                        i2++;
                    }
                }
                int i3 = 0;
                int i4 = 0;
                for (NameRecord next2 : nameRecords) {
                    if (shouldCopyNameRecord(next2)) {
                        writeUint16(dataOutputStream, next2.getPlatformId());
                        writeUint16(dataOutputStream, next2.getPlatformEncodingId());
                        writeUint16(dataOutputStream, next2.getLanguageId());
                        writeUint16(dataOutputStream, next2.getNameId());
                        writeUint16(dataOutputStream, bArr[i3].length);
                        writeUint16(dataOutputStream, i4);
                        i4 += bArr[i3].length;
                        i3++;
                    }
                }
                for (int i5 = 0; i5 < i; i5++) {
                    dataOutputStream.write(bArr[i5]);
                }
                dataOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }

    private byte[] buildOS2Table() throws IOException {
        OS2WindowsMetricsTable oS2Windows = this.ttf.getOS2Windows();
        if (oS2Windows != null) {
            List<String> list = this.keepTables;
            if (list == null || list.contains("OS/2")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                writeUint16(dataOutputStream, oS2Windows.getVersion());
                writeSInt16(dataOutputStream, oS2Windows.getAverageCharWidth());
                writeUint16(dataOutputStream, oS2Windows.getWeightClass());
                writeUint16(dataOutputStream, oS2Windows.getWidthClass());
                writeSInt16(dataOutputStream, oS2Windows.getFsType());
                writeSInt16(dataOutputStream, oS2Windows.getSubscriptXSize());
                writeSInt16(dataOutputStream, oS2Windows.getSubscriptYSize());
                writeSInt16(dataOutputStream, oS2Windows.getSubscriptXOffset());
                writeSInt16(dataOutputStream, oS2Windows.getSubscriptYOffset());
                writeSInt16(dataOutputStream, oS2Windows.getSuperscriptXSize());
                writeSInt16(dataOutputStream, oS2Windows.getSuperscriptYSize());
                writeSInt16(dataOutputStream, oS2Windows.getSuperscriptXOffset());
                writeSInt16(dataOutputStream, oS2Windows.getSuperscriptYOffset());
                writeSInt16(dataOutputStream, oS2Windows.getStrikeoutSize());
                writeSInt16(dataOutputStream, oS2Windows.getStrikeoutPosition());
                writeUint8(dataOutputStream, oS2Windows.getFamilyClass());
                writeUint8(dataOutputStream, oS2Windows.getFamilySubClass());
                dataOutputStream.write(oS2Windows.getPanose());
                writeUint32(dataOutputStream, 0);
                writeUint32(dataOutputStream, 0);
                writeUint32(dataOutputStream, 0);
                writeUint32(dataOutputStream, 0);
                dataOutputStream.write(oS2Windows.getAchVendId().getBytes("US-ASCII"));
                Iterator<Entry<Integer, Integer>> it = this.uniToGID.entrySet().iterator();
                it.next();
                writeUint16(dataOutputStream, oS2Windows.getFsSelection());
                writeUint16(dataOutputStream, ((Integer) it.next().getKey()).intValue());
                writeUint16(dataOutputStream, this.uniToGID.lastKey().intValue());
                writeUint16(dataOutputStream, oS2Windows.getTypoAscender());
                writeUint16(dataOutputStream, oS2Windows.getTypoDescender());
                writeUint16(dataOutputStream, oS2Windows.getTypoLineGap());
                writeUint16(dataOutputStream, oS2Windows.getWinAscent());
                writeUint16(dataOutputStream, oS2Windows.getWinDescent());
                dataOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }

    private byte[] buildPostTable() throws IOException {
        PostScriptTable postScript = this.ttf.getPostScript();
        if (postScript != null) {
            List<String> list = this.keepTables;
            if (list == null || list.contains("post")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                writeFixed(dataOutputStream, 2.0d);
                writeFixed(dataOutputStream, (double) postScript.getItalicAngle());
                writeSInt16(dataOutputStream, postScript.getUnderlinePosition());
                writeSInt16(dataOutputStream, postScript.getUnderlineThickness());
                writeUint32(dataOutputStream, postScript.getIsFixedPitch());
                writeUint32(dataOutputStream, postScript.getMinMemType42());
                writeUint32(dataOutputStream, postScript.getMaxMemType42());
                writeUint32(dataOutputStream, postScript.getMinMemType1());
                writeUint32(dataOutputStream, postScript.getMaxMemType1());
                writeUint16(dataOutputStream, this.glyphIds.size());
                TreeMap treeMap = new TreeMap();
                for (Integer intValue : this.glyphIds) {
                    String name = postScript.getName(intValue.intValue());
                    Integer num = WGL4Names.MAC_GLYPH_NAMES_INDICES.get(name);
                    if (num != null) {
                        writeUint16(dataOutputStream, num.intValue());
                    } else {
                        Integer num2 = (Integer) treeMap.get(name);
                        if (num2 == null) {
                            num2 = Integer.valueOf(treeMap.size());
                            treeMap.put(name, num2);
                        }
                        writeUint16(dataOutputStream, num2.intValue() + 258);
                    }
                }
                for (String bytes : treeMap.keySet()) {
                    byte[] bytes2 = bytes.getBytes(Charset.forName("US-ASCII"));
                    writeUint8(dataOutputStream, bytes2.length);
                    dataOutputStream.write(bytes2);
                }
                dataOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }

    private int getNewGlyphId(Integer num) {
        return this.glyphIds.headSet(num).size();
    }

    public static int log2(int i) {
        return (int) Math.round(Math.log((double) i) / Math.log(2.0d));
    }

    public static boolean shouldCopyNameRecord(NameRecord nameRecord) {
        if (nameRecord.getPlatformId() == 3 && nameRecord.getPlatformEncodingId() == 1 && nameRecord.getLanguageId() == 1033 && nameRecord.getNameId() >= 0 && nameRecord.getNameId() < 7) {
            return true;
        }
        return false;
    }

    public static long toUInt32(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 16);
    }

    public static long toUInt32(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16) | ((((long) bArr[2]) & 255) << 8) | (255 & ((long) bArr[3]));
    }

    public static long writeFileHeader(DataOutputStream dataOutputStream, int i) throws IOException {
        dataOutputStream.writeInt(65536);
        dataOutputStream.writeShort(i);
        int highestOneBit = Integer.highestOneBit(i);
        int i2 = highestOneBit * 16;
        dataOutputStream.writeShort(i2);
        int log2 = log2(highestOneBit);
        dataOutputStream.writeShort(log2);
        int i3 = (i * 16) - i2;
        dataOutputStream.writeShort(i3);
        return toUInt32(log2, i3) + toUInt32(i, i2) + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }

    public static void writeFixed(DataOutputStream dataOutputStream, double d2) throws IOException {
        double floor = Math.floor(d2);
        dataOutputStream.writeShort((int) floor);
        dataOutputStream.writeShort((int) ((d2 - floor) * 65536.0d));
    }

    public static void writeLongDateTime(DataOutputStream dataOutputStream, Calendar calendar) throws IOException {
        dataOutputStream.writeLong((calendar.getTimeInMillis() - new GregorianCalendar(1904, 0, 1).getTimeInMillis()) / 1000);
    }

    public static void writeSInt16(DataOutputStream dataOutputStream, short s) throws IOException {
        dataOutputStream.writeShort(s);
    }

    public static void writeTableBody(OutputStream outputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        outputStream.write(bArr);
        int i = length % 4;
        if (i != 0) {
            outputStream.write(PAD_BUF, 0, 4 - i);
        }
    }

    public static long writeTableHeader(DataOutputStream dataOutputStream, String str, long j, byte[] bArr) throws IOException {
        int length = bArr.length;
        long j2 = 0;
        for (int i = 0; i < length; i++) {
            j2 += (((long) bArr[i]) & 255) << (24 - ((i % 4) * 8));
        }
        long j3 = j2 & 4294967295L;
        byte[] bytes = str.getBytes("US-ASCII");
        dataOutputStream.write(bytes, 0, 4);
        dataOutputStream.writeInt((int) j3);
        dataOutputStream.writeInt((int) j);
        dataOutputStream.writeInt(bArr.length);
        return toUInt32(bytes) + j3 + j3 + j + ((long) bArr.length);
    }

    public static void writeUint16(DataOutputStream dataOutputStream, int i) throws IOException {
        dataOutputStream.writeShort(i);
    }

    public static void writeUint32(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeInt((int) j);
    }

    public static void writeUint8(DataOutputStream dataOutputStream, int i) throws IOException {
        dataOutputStream.writeByte(i);
    }

    public void add(int i) {
        int glyphId = this.unicodeCmap.getGlyphId(i);
        if (glyphId != 0) {
            this.uniToGID.put(Integer.valueOf(i), Integer.valueOf(glyphId));
            this.glyphIds.add(Integer.valueOf(glyphId));
        }
    }

    public void addAll(Set<Integer> set) {
        for (Integer intValue : set) {
            add(intValue.intValue());
        }
    }

    public Map<Integer, Integer> getGIDMap() throws IOException {
        addCompoundReferences();
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Integer intValue : this.glyphIds) {
            hashMap.put(Integer.valueOf(i), Integer.valueOf(intValue.intValue()));
            i++;
        }
        return hashMap;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void writeToStream(OutputStream outputStream) throws IOException {
        addCompoundReferences();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        try {
            long[] jArr = new long[(this.glyphIds.size() + 1)];
            byte[] buildHeadTable = buildHeadTable();
            byte[] buildHheaTable = buildHheaTable();
            byte[] buildMaxpTable = buildMaxpTable();
            byte[] buildNameTable = buildNameTable();
            byte[] buildOS2Table = buildOS2Table();
            byte[] buildGlyfTable = buildGlyfTable(jArr);
            byte[] buildLocaTable = buildLocaTable(jArr);
            byte[] buildCmapTable = buildCmapTable();
            byte[] buildHmtxTable = buildHmtxTable();
            byte[] buildPostTable = buildPostTable();
            TreeMap treeMap = new TreeMap();
            if (buildOS2Table != null) {
                treeMap.put("OS/2", buildOS2Table);
            }
            if (buildCmapTable != null) {
                treeMap.put(CmapTable.TAG, buildCmapTable);
            }
            if (buildGlyfTable != null) {
                treeMap.put(GlyphTable.TAG, buildGlyfTable);
            }
            treeMap.put(HeaderTable.TAG, buildHeadTable);
            treeMap.put(HorizontalHeaderTable.TAG, buildHheaTable);
            treeMap.put(HorizontalMetricsTable.TAG, buildHmtxTable);
            if (buildLocaTable != null) {
                treeMap.put(IndexToLocationTable.TAG, buildLocaTable);
            }
            treeMap.put(MaximumProfileTable.TAG, buildMaxpTable);
            if (buildNameTable != null) {
                treeMap.put("name", buildNameTable);
            }
            if (buildPostTable != null) {
                treeMap.put("post", buildPostTable);
            }
            for (Entry next : this.ttf.getTableMap().entrySet()) {
                String str = (String) next.getKey();
                TTFTable tTFTable = (TTFTable) next.getValue();
                if (!treeMap.containsKey(str) && (this.keepTables == null || this.keepTables.contains(str))) {
                    treeMap.put(str, this.ttf.getTableBytes(tTFTable));
                }
            }
            long writeFileHeader = writeFileHeader(dataOutputStream, treeMap.size());
            long size = (((long) treeMap.size()) * 16) + 12;
            for (Entry entry : treeMap.entrySet()) {
                writeFileHeader += writeTableHeader(dataOutputStream, (String) entry.getKey(), size, (byte[]) entry.getValue());
                size += (long) (((((byte[]) entry.getValue()).length + 3) / 4) * 4);
            }
            long j = 2981146554L - (writeFileHeader & 4294967295L);
            buildHeadTable[8] = (byte) ((int) (j >>> 24));
            buildHeadTable[9] = (byte) ((int) (j >>> 16));
            buildHeadTable[10] = (byte) ((int) (j >>> 8));
            buildHeadTable[11] = (byte) ((int) j);
            for (byte[] writeTableBody : treeMap.values()) {
                writeTableBody(dataOutputStream, writeTableBody);
            }
        } finally {
            dataOutputStream.close();
        }
    }

    public TTFSubsetter(TrueTypeFont trueTypeFont, List<String> list) throws IOException {
        this.ttf = trueTypeFont;
        this.keepTables = list;
        this.uniToGID = new TreeMap();
        this.glyphIds = new TreeSet();
        this.unicodeCmap = trueTypeFont.getUnicodeCmap();
        this.glyphIds.add(Integer.valueOf(0));
    }
}
