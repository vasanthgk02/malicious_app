package org.apache.pdfbox.pdfparser;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.utility.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdfparser.XrefTrailerResolver.XRefType;

public class COSParser extends BaseParser {
    public static final int DEFAULT_TRAIL_BYTECOUNT = 2048;
    public static final char[] EOF_MARKER = {'%', '%', 'E', 'O', 'F'};
    public static final String FDF_DEFAULT_VERSION = "1.0";
    public static final String FDF_HEADER = "%FDF-";
    public static final long MINIMUM_SEARCH_OFFSET = 6;
    public static final char[] OBJ_MARKER = {'o', 'b', 'j'};
    public static final String PDF_DEFAULT_VERSION = "1.4";
    public static final String PDF_HEADER = "%PDF-";
    public static final char[] STARTXREF = {'s', 't', 'a', 'r', 't', 'x', 'r', 'e', 'f'};
    public static final int STREAMCOPYBUFLEN = 8192;
    public static final String SYSPROP_EOFLOOKUPRANGE = "org.apache.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange";
    public static final String SYSPROP_PARSEMINIMAL = "org.apache.pdfbox.pdfparser.nonSequentialPDFParser.parseMinimal";
    public static final String TMP_FILE_PREFIX = "tmpPDF";
    public static final int X = 120;
    public static final char[] XREF_STREAM = {'/', 'X', 'R', 'e', 'f'};
    public static final char[] XREF_TABLE = {'x', 'r', 'e', 'f'};
    public Map<COSObjectKey, Long> bfSearchCOSObjectKeyOffsets = null;
    public List<Long> bfSearchXRefStreamsOffsets = null;
    public List<Long> bfSearchXRefTablesOffsets = null;
    public long fileLen;
    public boolean inGetLength = false;
    public boolean initialParseDone = false;
    public boolean isLenient = true;
    public final boolean parseMinimalCatalog = BaseParser.TRUE.equals(System.getProperty(SYSPROP_PARSEMINIMAL));
    public int readTrailBytes = 2048;
    public final byte[] streamCopyBuf = new byte[8192];
    public long trailerOffset;
    public XrefTrailerResolver xrefTrailerResolver = new XrefTrailerResolver();

    public COSParser(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    private void addExcludedToList(COSName[] cOSNameArr, COSDictionary cOSDictionary, Set<Long> set) {
        if (cOSNameArr != null) {
            for (COSName item : cOSNameArr) {
                COSBase item2 = cOSDictionary.getItem(item);
                if (item2 instanceof COSObject) {
                    set.add(Long.valueOf(getObjectId((COSObject) item2)));
                }
            }
        }
    }

    private void addNewToList(Queue<COSBase> queue, Collection<COSBase> collection, Set<Long> set) {
        for (COSBase addNewToList : collection) {
            addNewToList(queue, addNewToList, set);
        }
    }

    private void bfSearchForObjects() throws IOException {
        Long l;
        if (this.bfSearchCOSObjectKeyOffsets == null) {
            this.bfSearchCOSObjectKeyOffsets = new HashMap();
            long offset = this.pdfSource.getOffset();
            char[] charArray = " obj".toCharArray();
            long j = 6;
            long j2 = 6;
            while (true) {
                this.pdfSource.seek(j2);
                if (isString(charArray)) {
                    long j3 = j2 - 1;
                    this.pdfSource.seek(j3);
                    int peek = this.pdfSource.peek();
                    if (peek > 47 && peek < 58) {
                        int i = peek - 48;
                        long j4 = j3 - 1;
                        this.pdfSource.seek(j4);
                        if (isSpace()) {
                            while (j4 > j && isSpace()) {
                                j4--;
                                this.pdfSource.seek(j4);
                            }
                            int i2 = 0;
                            while (j4 > j && isDigit()) {
                                j4--;
                                this.pdfSource.seek(j4);
                                i2++;
                            }
                            if (i2 > 0) {
                                this.pdfSource.read();
                                byte[] readFully = this.pdfSource.readFully(i2);
                                try {
                                    l = Long.valueOf(new String(readFully, 0, readFully.length, "ISO-8859-1"));
                                } catch (NumberFormatException unused) {
                                    l = null;
                                }
                                if (l != null) {
                                    this.bfSearchCOSObjectKeyOffsets.put(new COSObjectKey(l.longValue(), i), Long.valueOf(j4 + 1));
                                }
                            }
                        }
                    }
                }
                j2++;
                if (this.pdfSource.isEOF()) {
                    this.pdfSource.seek(offset);
                    return;
                }
                j = 6;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long bfSearchForXRef(long r11, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            if (r13 != 0) goto L_0x0005
            r10.bfSearchForXRefTables()
        L_0x0005:
            r10.bfSearchForXRefStreams()
            r0 = -1
            if (r13 != 0) goto L_0x0015
            java.util.List<java.lang.Long> r13 = r10.bfSearchXRefTablesOffsets
            if (r13 == 0) goto L_0x0015
            long r2 = r10.searchNearestValue(r13, r11)
            goto L_0x0016
        L_0x0015:
            r2 = r0
        L_0x0016:
            java.util.List<java.lang.Long> r13 = r10.bfSearchXRefStreamsOffsets
            if (r13 == 0) goto L_0x001f
            long r4 = r10.searchNearestValue(r13, r11)
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r13 <= 0) goto L_0x004c
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x004c
            long r0 = r11 - r2
            long r11 = r11 - r4
            long r6 = java.lang.Math.abs(r0)
            long r8 = java.lang.Math.abs(r11)
            int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r13 <= 0) goto L_0x0042
            java.util.List<java.lang.Long> r13 = r10.bfSearchXRefStreamsOffsets
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            r13.remove(r0)
            r0 = r11
            goto L_0x0067
        L_0x0042:
            java.util.List<java.lang.Long> r11 = r10.bfSearchXRefTablesOffsets
            java.lang.Long r12 = java.lang.Long.valueOf(r2)
            r11.remove(r12)
            goto L_0x0067
        L_0x004c:
            if (r13 <= 0) goto L_0x0059
            java.util.List<java.lang.Long> r11 = r10.bfSearchXRefTablesOffsets
            java.lang.Long r12 = java.lang.Long.valueOf(r2)
            r11.remove(r12)
            r0 = r2
            goto L_0x0067
        L_0x0059:
            int r11 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r11 <= 0) goto L_0x0067
            java.util.List<java.lang.Long> r11 = r10.bfSearchXRefStreamsOffsets
            java.lang.Long r12 = java.lang.Long.valueOf(r4)
            r11.remove(r12)
            r0 = r4
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.COSParser.bfSearchForXRef(long, boolean):long");
    }

    private void bfSearchForXRefStreams() throws IOException {
        if (this.bfSearchXRefStreamsOffsets == null) {
            this.bfSearchXRefStreamsOffsets = new Vector();
            long offset = this.pdfSource.getOffset();
            this.pdfSource.seek(6);
            char[] charArray = " obj".toCharArray();
            while (!this.pdfSource.isEOF()) {
                if (isString(XREF_STREAM)) {
                    long offset2 = this.pdfSource.getOffset();
                    boolean z = false;
                    long j = -1;
                    for (int i = 1; i < 30 && !z; i++) {
                        long j2 = offset2 - ((long) (i * 10));
                        if (j2 > 0) {
                            this.pdfSource.seek(j2);
                            int i2 = 0;
                            while (true) {
                                if (i2 >= 10) {
                                    break;
                                } else if (isString(charArray)) {
                                    long j3 = j2 - 1;
                                    this.pdfSource.seek(j3);
                                    if (isDigit(this.pdfSource.peek())) {
                                        long j4 = j3 - 1;
                                        this.pdfSource.seek(j4);
                                        if (isSpace()) {
                                            long j5 = j4 - 1;
                                            this.pdfSource.seek(j5);
                                            int i3 = 0;
                                            while (j5 > 6 && isDigit()) {
                                                j5--;
                                                this.pdfSource.seek(j5);
                                                i3++;
                                            }
                                            if (i3 > 0) {
                                                this.pdfSource.read();
                                                j = this.pdfSource.getOffset();
                                            }
                                        }
                                    }
                                    z = true;
                                } else {
                                    j2++;
                                    this.pdfSource.read();
                                    i2++;
                                }
                            }
                        }
                    }
                    if (j > -1) {
                        this.bfSearchXRefStreamsOffsets.add(Long.valueOf(j));
                    }
                    this.pdfSource.seek(offset2 + 5);
                }
                this.pdfSource.read();
            }
            this.pdfSource.seek(offset);
        }
    }

    private void bfSearchForXRefTables() throws IOException {
        if (this.bfSearchXRefTablesOffsets == null) {
            this.bfSearchXRefTablesOffsets = new Vector();
            long offset = this.pdfSource.getOffset();
            this.pdfSource.seek(6);
            while (!this.pdfSource.isEOF()) {
                if (isString(XREF_TABLE)) {
                    long offset2 = this.pdfSource.getOffset();
                    this.pdfSource.seek(offset2 - 1);
                    if (isWhitespace()) {
                        this.bfSearchXRefTablesOffsets.add(Long.valueOf(offset2));
                    }
                    this.pdfSource.seek(offset2 + 4);
                }
                this.pdfSource.read();
            }
            this.pdfSource.seek(offset);
        }
    }

    private long calculateXRefFixedOffset(long j, boolean z) throws IOException {
        if (j < 0) {
            return 0;
        }
        long bfSearchForXRef = bfSearchForXRef(j, z);
        if (bfSearchForXRef > -1) {
            return bfSearchForXRef;
        }
        return 0;
    }

    private boolean checkObjectKeys(COSObjectKey cOSObjectKey, long j) throws IOException {
        if (j < 6) {
            return false;
        }
        long number = cOSObjectKey.getNumber();
        int generation = cOSObjectKey.getGeneration();
        long offset = this.pdfSource.getOffset();
        this.pdfSource.seek(j);
        try {
            if (isString(createObjectString(number, generation).getBytes("ISO-8859-1"))) {
                this.pdfSource.seek(offset);
                this.pdfSource.seek(offset);
                return true;
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.pdfSource.seek(offset);
            throw th;
        }
        this.pdfSource.seek(offset);
        return false;
    }

    private long checkXRefOffset(long j) throws IOException {
        if (!this.isLenient) {
            return j;
        }
        this.pdfSource.seek(j);
        if (this.pdfSource.peek() == 120 && isString(XREF_TABLE)) {
            return j;
        }
        if (j > 0) {
            long checkXRefStreamOffset = checkXRefStreamOffset(j, true);
            if (checkXRefStreamOffset > -1) {
                return checkXRefStreamOffset;
            }
        }
        return calculateXRefFixedOffset(j, false);
    }

    private long checkXRefStreamOffset(long j, boolean z) throws IOException {
        if (this.isLenient && j != 0) {
            this.pdfSource.seek(j - 1);
            if (isWhitespace(this.pdfSource.read())) {
                int peek = this.pdfSource.peek();
                if (peek > 47 && peek < 58) {
                    try {
                        readObjectNumber();
                        readGenerationNumber();
                        readExpectedString(OBJ_MARKER, true);
                        this.pdfSource.seek(j);
                        return j;
                    } catch (IOException unused) {
                        this.pdfSource.seek(j);
                    }
                }
            }
            if (z) {
                j = -1;
            } else {
                j = calculateXRefFixedOffset(j, true);
            }
        }
        return j;
    }

    private void checkXrefOffsets() throws IOException {
        if (this.isLenient) {
            Map<COSObjectKey, Long> xrefTable = this.xrefTrailerResolver.getXrefTable();
            if (xrefTable != null) {
                boolean z = false;
                Iterator<Entry<COSObjectKey, Long>> it = xrefTable.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry next = it.next();
                    COSObjectKey cOSObjectKey = (COSObjectKey) next.getKey();
                    Long l = (Long) next.getValue();
                    if (l != null && l.longValue() >= 0 && !checkObjectKeys(cOSObjectKey, l.longValue())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    bfSearchForObjects();
                    Map<COSObjectKey, Long> map = this.bfSearchCOSObjectKeyOffsets;
                    if (map != null && !map.isEmpty()) {
                        xrefTable.putAll(this.bfSearchCOSObjectKeyOffsets);
                    }
                }
            }
        }
    }

    private String createObjectString(long j, int i) {
        return Long.toString(j) + CMap.SPACE + Integer.toString(i) + " obj";
    }

    /* JADX INFO: finally extract failed */
    private COSNumber getLength(COSBase cOSBase) throws IOException {
        COSNumber cOSNumber;
        if (cOSBase == null) {
            return null;
        }
        if (!this.inGetLength) {
            try {
                this.inGetLength = true;
                if (cOSBase instanceof COSNumber) {
                    cOSNumber = (COSNumber) cOSBase;
                } else if (cOSBase instanceof COSObject) {
                    COSObject cOSObject = (COSObject) cOSBase;
                    if (cOSObject.getObject() == null) {
                        long offset = this.pdfSource.getOffset();
                        parseObjectDynamically(cOSObject, true);
                        this.pdfSource.seek(offset);
                        if (cOSObject.getObject() == null) {
                            throw new IOException("Length object content was not read.");
                        }
                    }
                    if (cOSObject.getObject() instanceof COSNumber) {
                        cOSNumber = (COSNumber) cOSObject.getObject();
                    } else {
                        throw new IOException("Wrong type of referenced length object " + cOSObject + ": " + cOSObject.getObject().getClass().getSimpleName());
                    }
                } else {
                    throw new IOException("Wrong type of length object: " + cOSBase.getClass().getSimpleName());
                }
                this.inGetLength = false;
                return cOSNumber;
            } catch (Throwable th) {
                this.inGetLength = false;
                throw th;
            }
        } else {
            throw new IOException("Loop while reading length from " + cOSBase);
        }
    }

    private long getObjectId(COSObject cOSObject) {
        return (cOSObject.getObjectNumber() << 32) | ((long) cOSObject.getGenerationNumber());
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b6 A[Catch:{ NumberFormatException -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parseHeader(java.lang.String r7, java.lang.String r8) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = r6.readLine()
            boolean r1 = r0.contains(r7)
            r2 = 0
            if (r1 != 0) goto L_0x002b
            java.lang.String r0 = r6.readLine()
        L_0x000f:
            boolean r1 = r0.contains(r7)
            if (r1 != 0) goto L_0x002b
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0026
            char r1 = r0.charAt(r2)
            boolean r1 = java.lang.Character.isDigit(r1)
            if (r1 == 0) goto L_0x0026
            goto L_0x002b
        L_0x0026:
            java.lang.String r0 = r6.readLine()
            goto L_0x000f
        L_0x002b:
            boolean r1 = r0.contains(r7)
            r3 = 0
            if (r1 != 0) goto L_0x0039
            org.apache.pdfbox.io.PushBackInputStream r7 = r6.pdfSource
            r7.seek(r3)
            return r2
        L_0x0039:
            int r1 = r0.indexOf(r7)
            if (r1 <= 0) goto L_0x0047
            int r5 = r0.length()
            java.lang.String r0 = r0.substring(r1, r5)
        L_0x0047:
            boolean r1 = r0.startsWith(r7)
            if (r1 == 0) goto L_0x0075
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r5 = "\\d.\\d"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r1 = r0.matches(r1)
            if (r1 != 0) goto L_0x0075
            int r1 = r0.length()
            int r2 = r7.length()
            int r2 = r2 + 3
            if (r1 >= r2) goto L_0x00a9
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r7, r8)
            goto L_0x00a9
        L_0x0075:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r1 = r7.length()
            int r1 = r1 + 3
            int r5 = r0.length()
            java.lang.String r1 = r0.substring(r1, r5)
            r8.append(r1)
            java.lang.String r1 = "\n"
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            int r7 = r7.length()
            int r7 = r7 + 3
            java.lang.String r0 = r0.substring(r2, r7)
            org.apache.pdfbox.io.PushBackInputStream r7 = r6.pdfSource
            java.lang.String r1 = "ISO-8859-1"
            byte[] r8 = r8.getBytes(r1)
            r7.unread(r8)
        L_0x00a9:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = 1
            java.lang.String r1 = "-"
            java.lang.String[] r1 = r0.split(r1)     // Catch:{ NumberFormatException -> 0x00bd }
            int r2 = r1.length     // Catch:{ NumberFormatException -> 0x00bd }
            r5 = 2
            if (r2 != r5) goto L_0x00be
            r1 = r1[r8]     // Catch:{ NumberFormatException -> 0x00bd }
            float r7 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00bd }
            goto L_0x00be
        L_0x00bd:
        L_0x00be:
            r1 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x00ce
            org.apache.pdfbox.cos.COSDocument r0 = r6.document
            r0.setVersion(r7)
            org.apache.pdfbox.io.PushBackInputStream r7 = r6.pdfSource
            r7.seek(r3)
            return r8
        L_0x00ce:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "Error getting header version: "
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r8, r0)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.COSParser.parseHeader(java.lang.String, java.lang.String):boolean");
    }

    private long parseXrefObjStream(long j, boolean z) throws IOException {
        readObjectNumber();
        readGenerationNumber();
        readExpectedString(OBJ_MARKER, true);
        COSDictionary parseCOSDictionary = parseCOSDictionary();
        COSStream parseCOSStream = parseCOSStream(parseCOSDictionary);
        parseXrefStream(parseCOSStream, (long) ((int) j), z);
        parseCOSStream.close();
        return parseCOSDictionary.getLong(COSName.PREV);
    }

    private long searchNearestValue(List<Long> list, long j) {
        List<Long> list2 = list;
        int size = list.size();
        long j2 = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long longValue = j - list2.get(i2).longValue();
            if (j2 == -1 || Math.abs(j2) > Math.abs(longValue)) {
                i = i2;
                j2 = longValue;
            }
        }
        if (i > -1) {
            return list2.get(i).longValue();
        }
        return -1;
    }

    private boolean validateStreamLength(long j) throws IOException {
        long offset = this.pdfSource.getOffset();
        long j2 = j + offset;
        boolean z = false;
        if (j2 <= this.fileLen) {
            this.pdfSource.seek(j2);
            skipSpaces();
            if (isString(BaseParser.ENDSTREAM)) {
                z = true;
            }
            this.pdfSource.seek(offset);
        }
        return z;
    }

    public File createTmpFile(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream;
        Throwable th;
        try {
            File createTempFile = File.createTempFile(TMP_FILE_PREFIX, ".pdf");
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                IOUtils.copy(inputStream, fileOutputStream);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(fileOutputStream);
                return createTempFile;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public COSDocument getDocument() throws IOException {
        COSDocument cOSDocument = this.document;
        if (cOSDocument != null) {
            return cOSDocument;
        }
        throw new IOException("You must call parse() before calling getDocument()");
    }

    /* JADX INFO: finally extract failed */
    public final long getStartxrefOffset() throws IOException {
        try {
            int i = this.fileLen < ((long) this.readTrailBytes) ? (int) this.fileLen : this.readTrailBytes;
            byte[] bArr = new byte[i];
            long j = this.fileLen - ((long) i);
            this.pdfSource.seek(j);
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int read = this.pdfSource.read(bArr, i2, i3);
                if (read >= 1) {
                    i2 += read;
                } else {
                    throw new IOException("No more bytes to read for trailing buffer, but expected: " + i3);
                }
            }
            this.pdfSource.seek(0);
            int lastIndexOf = lastIndexOf(EOF_MARKER, bArr, i);
            if (lastIndexOf >= 0) {
                i = lastIndexOf;
            } else if (this.isLenient) {
                new String(EOF_MARKER);
            } else {
                throw new IOException(GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("Missing end of file marker '"), new String(EOF_MARKER), "'"));
            }
            int lastIndexOf2 = lastIndexOf(STARTXREF, bArr, i);
            long j2 = j + ((long) lastIndexOf2);
            if (lastIndexOf2 >= 0) {
                return j2;
            }
            if (this.isLenient) {
                return -1;
            }
            throw new IOException("Missing 'startxref' marker.");
        } catch (Throwable th) {
            this.pdfSource.seek(0);
            throw th;
        }
    }

    public boolean isLenient() {
        return this.isLenient;
    }

    public int lastIndexOf(char[] cArr, byte[] bArr, int i) {
        int length = cArr.length - 1;
        char c2 = cArr[length];
        while (true) {
            int i2 = length;
            while (true) {
                i--;
                if (i < 0) {
                    return -1;
                }
                if (bArr[i] == c2) {
                    i2--;
                    if (i2 < 0) {
                        return i;
                    }
                    c2 = cArr[i2];
                } else if (i2 < length) {
                    break;
                }
            }
            c2 = cArr[length];
        }
    }

    public COSStream parseCOSStream(COSDictionary cOSDictionary) throws IOException {
        COSStream createCOSStream = createCOSStream(cOSDictionary);
        OutputStream outputStream = null;
        try {
            readString();
            int read = this.pdfSource.read();
            while (read == 32) {
                read = this.pdfSource.read();
            }
            if (read == 13) {
                int read2 = this.pdfSource.read();
                if (read2 != 10) {
                    this.pdfSource.unread(read2);
                }
            } else if (read != 10) {
                this.pdfSource.unread(read);
            }
            COSNumber length = getLength(cOSDictionary.getItem(COSName.LENGTH));
            if (length == null) {
                if (!this.isLenient) {
                    throw new IOException("Missing length for stream.");
                }
            }
            boolean z = true;
            if (length != null && validateStreamLength(length.longValue())) {
                outputStream = createCOSStream.createFilteredStream(length);
                long longValue = length.longValue();
                int i = 0;
                while (true) {
                    if (longValue <= 0) {
                        z = false;
                        break;
                    }
                    int read3 = this.pdfSource.read(this.streamCopyBuf, 0, longValue > PlaybackStateCompat.ACTION_PLAY_FROM_URI ? 8192 : (int) longValue);
                    if (read3 <= 0) {
                        outputStream.close();
                        this.pdfSource.unread(i);
                        break;
                    }
                    outputStream.write(this.streamCopyBuf, 0, read3);
                    longValue -= (long) read3;
                    i += read3;
                }
            }
            if (z) {
                outputStream = createCOSStream.createFilteredStream();
                readUntilEndStream(new EndstreamOutputStream(outputStream));
            }
            String readString = readString();
            if (!readString.equals(BaseParser.ENDOBJ_STRING) || !this.isLenient) {
                if (readString.length() > 9) {
                    if (this.isLenient && readString.substring(0, 9).equals(BaseParser.ENDSTREAM_STRING)) {
                        this.pdfSource.getOffset();
                        this.pdfSource.unread(readString.substring(9).getBytes("ISO-8859-1"));
                    }
                }
                if (!readString.equals(BaseParser.ENDSTREAM_STRING)) {
                    throw new IOException("Error reading stream, expected='endstream' actual='" + readString + "' at offset " + this.pdfSource.getOffset());
                }
            } else {
                this.pdfSource.getOffset();
                this.pdfSource.unread(BaseParser.ENDOBJ);
            }
            return createCOSStream;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010b, code lost:
        if (r1.isEmpty() == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010e, code lost:
        r14 = ((java.util.List) r1.remove(r1.firstKey())).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0120, code lost:
        if (r14.hasNext() == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0122, code lost:
        r4 = (org.apache.pdfbox.cos.COSObject) r14.next();
        r5 = parseObjectDynamically(r4, false);
        r4.setObject(r5);
        addNewToList((java.util.Queue<org.apache.pdfbox.cos.COSBase>) r0, r5, (java.util.Set<java.lang.Long>) r3);
        r2.add(java.lang.Long.valueOf(getObjectId(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseDictObjects(org.apache.pdfbox.cos.COSDictionary r14, org.apache.pdfbox.cos.COSName... r15) throws java.io.IOException {
        /*
            r13 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r13.addExcludedToList(r15, r14, r2)
            java.util.Collection r14 = r14.getValues()
            r13.addNewToList(r0, r14, r3)
        L_0x001e:
            boolean r14 = r0.isEmpty()
            if (r14 == 0) goto L_0x002a
            boolean r14 = r1.isEmpty()
            if (r14 != 0) goto L_0x010d
        L_0x002a:
            java.lang.Object r14 = r0.poll()
            org.apache.pdfbox.cos.COSBase r14 = (org.apache.pdfbox.cos.COSBase) r14
            r15 = 0
            if (r14 == 0) goto L_0x0107
            boolean r4 = r14 instanceof org.apache.pdfbox.cos.COSDictionary
            if (r4 == 0) goto L_0x0041
            org.apache.pdfbox.cos.COSDictionary r14 = (org.apache.pdfbox.cos.COSDictionary) r14
            java.util.Collection r14 = r14.getValues()
            r13.addNewToList(r0, r14, r3)
            goto L_0x002a
        L_0x0041:
            boolean r4 = r14 instanceof org.apache.pdfbox.cos.COSArray
            if (r4 == 0) goto L_0x005b
            org.apache.pdfbox.cos.COSArray r14 = (org.apache.pdfbox.cos.COSArray) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x004b:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x002a
            java.lang.Object r15 = r14.next()
            org.apache.pdfbox.cos.COSBase r15 = (org.apache.pdfbox.cos.COSBase) r15
            r13.addNewToList(r0, r15, r3)
            goto L_0x004b
        L_0x005b:
            boolean r4 = r14 instanceof org.apache.pdfbox.cos.COSObject
            if (r4 == 0) goto L_0x002a
            org.apache.pdfbox.cos.COSObject r14 = (org.apache.pdfbox.cos.COSObject) r14
            long r4 = r13.getObjectId(r14)
            org.apache.pdfbox.cos.COSObjectKey r6 = new org.apache.pdfbox.cos.COSObjectKey
            long r7 = r14.getObjectNumber()
            int r9 = r14.getGenerationNumber()
            r6.<init>(r7, r9)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            boolean r4 = r2.contains(r4)
            if (r4 != 0) goto L_0x002a
            org.apache.pdfbox.pdfparser.XrefTrailerResolver r4 = r13.xrefTrailerResolver
            java.util.Map r4 = r4.getXrefTable()
            java.lang.Object r4 = r4.get(r6)
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x00fa
            long r7 = r4.longValue()
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x00fa
            long r7 = r4.longValue()
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a4
            java.util.List r14 = java.util.Collections.singletonList(r14)
            r1.put(r4, r14)
            goto L_0x002a
        L_0x00a4:
            org.apache.pdfbox.pdfparser.XrefTrailerResolver r5 = r13.xrefTrailerResolver
            java.util.Map r5 = r5.getXrefTable()
            org.apache.pdfbox.cos.COSObjectKey r7 = new org.apache.pdfbox.cos.COSObjectKey
            long r11 = r4.longValue()
            long r11 = -r11
            int r4 = (int) r11
            long r11 = (long) r4
            r7.<init>(r11, r15)
            java.lang.Object r15 = r5.get(r7)
            java.lang.Long r15 = (java.lang.Long) r15
            if (r15 == 0) goto L_0x00db
            long r4 = r15.longValue()
            int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x00db
            java.lang.Object r4 = r1.get(r15)
            java.util.List r4 = (java.util.List) r4
            if (r4 != 0) goto L_0x00d6
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.put(r15, r4)
        L_0x00d6:
            r4.add(r14)
            goto L_0x002a
        L_0x00db:
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid object stream xref object reference for key '"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = "': "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            r14.<init>(r15)
            throw r14
        L_0x00fa:
            org.apache.pdfbox.cos.COSDocument r14 = r13.document
            org.apache.pdfbox.cos.COSObject r14 = r14.getObjectFromPool(r6)
            org.apache.pdfbox.cos.COSNull r15 = org.apache.pdfbox.cos.COSNull.NULL
            r14.setObject(r15)
            goto L_0x002a
        L_0x0107:
            boolean r14 = r1.isEmpty()
            if (r14 == 0) goto L_0x010e
        L_0x010d:
            return
        L_0x010e:
            java.lang.Object r14 = r1.firstKey()
            java.lang.Object r14 = r1.remove(r14)
            java.util.List r14 = (java.util.List) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x011c:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x001e
            java.lang.Object r4 = r14.next()
            org.apache.pdfbox.cos.COSObject r4 = (org.apache.pdfbox.cos.COSObject) r4
            org.apache.pdfbox.cos.COSBase r5 = r13.parseObjectDynamically(r4, r15)
            r4.setObject(r5)
            r13.addNewToList(r0, r5, r3)
            long r4 = r13.getObjectId(r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.add(r4)
            goto L_0x011c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.COSParser.parseDictObjects(org.apache.pdfbox.cos.COSDictionary, org.apache.pdfbox.cos.COSName[]):void");
    }

    public boolean parseFDFHeader() throws IOException {
        return parseHeader(FDF_HEADER, "1.0");
    }

    public final COSBase parseObjectDynamically(COSObject cOSObject, boolean z) throws IOException {
        return parseObjectDynamically(cOSObject.getObjectNumber(), cOSObject.getGenerationNumber(), z);
    }

    public boolean parsePDFHeader() throws IOException {
        return parseHeader(PDF_HEADER, PDF_DEFAULT_VERSION);
    }

    public long parseStartXref() throws IOException {
        if (!isString(STARTXREF)) {
            return -1;
        }
        readString();
        skipSpaces();
        return readLong();
    }

    public boolean parseTrailer() throws IOException {
        if (this.pdfSource.peek() != 116) {
            return false;
        }
        long offset = this.pdfSource.getOffset();
        String readLine = readLine();
        if (!readLine.trim().equals("trailer")) {
            if (!readLine.startsWith("trailer")) {
                return false;
            }
            this.pdfSource.seek(offset + ((long) 7));
        }
        skipSpaces();
        this.xrefTrailerResolver.setTrailer(parseCOSDictionary());
        skipSpaces();
        return true;
    }

    public COSDictionary parseXref(long j) throws IOException {
        this.pdfSource.seek(j);
        long max = Math.max(0, parseStartXref());
        long checkXRefOffset = checkXRefOffset(max);
        if (checkXRefOffset > -1) {
            max = checkXRefOffset;
        }
        this.document.setStartXref(max);
        long j2 = max;
        while (true) {
            boolean z = true;
            if (j2 > -1) {
                this.pdfSource.seek(j2);
                skipSpaces();
                if (this.pdfSource.peek() == 120) {
                    parseXrefTable(j2);
                    this.trailerOffset = this.pdfSource.getOffset();
                    while (this.isLenient && this.pdfSource.peek() != 116) {
                        this.pdfSource.getOffset();
                        readLine();
                    }
                    if (parseTrailer()) {
                        COSDictionary currentTrailer = this.xrefTrailerResolver.getCurrentTrailer();
                        if (currentTrailer.containsKey(COSName.XREF_STM)) {
                            int i = currentTrailer.getInt(COSName.XREF_STM);
                            long j3 = (long) i;
                            long checkXRefStreamOffset = checkXRefStreamOffset(j3, false);
                            if (checkXRefStreamOffset > -1 && checkXRefStreamOffset != j3) {
                                i = (int) checkXRefStreamOffset;
                                currentTrailer.setInt(COSName.XREF_STM, i);
                            }
                            if (i > 0) {
                                this.pdfSource.seek((long) i);
                                skipSpaces();
                                parseXrefObjStream(j2, false);
                            } else if (!this.isLenient) {
                                throw new IOException(GeneratedOutlineSupport.outline41("Skipped XRef stream due to a corrupt offset:", i));
                            }
                        }
                        j2 = (long) currentTrailer.getInt(COSName.PREV);
                        if (j2 > -1) {
                            long checkXRefOffset2 = checkXRefOffset(j2);
                            if (checkXRefOffset2 > -1 && checkXRefOffset2 != j2) {
                                currentTrailer.setLong(COSName.PREV, checkXRefOffset2);
                                j2 = checkXRefOffset2;
                            }
                        }
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected trailer object at position: ");
                        outline73.append(this.pdfSource.getOffset());
                        throw new IOException(outline73.toString());
                    }
                } else {
                    j2 = parseXrefObjStream(j2, true);
                    if (j2 > -1) {
                        long checkXRefOffset3 = checkXRefOffset(j2);
                        if (checkXRefOffset3 > -1 && checkXRefOffset3 != j2) {
                            this.xrefTrailerResolver.getCurrentTrailer().setLong(COSName.PREV, checkXRefOffset3);
                            j2 = checkXRefOffset3;
                        }
                    }
                }
            } else {
                this.xrefTrailerResolver.setStartxref(max);
                COSDictionary trailer = this.xrefTrailerResolver.getTrailer();
                this.document.setTrailer(trailer);
                COSDocument cOSDocument = this.document;
                if (XRefType.STREAM != this.xrefTrailerResolver.getXrefType()) {
                    z = false;
                }
                cOSDocument.setIsXRefStream(z);
                checkXrefOffsets();
                this.document.addXRefTable(this.xrefTrailerResolver.getXrefTable());
                return trailer;
            }
        }
    }

    public void parseXrefStream(COSStream cOSStream, long j, boolean z) throws IOException {
        if (z) {
            this.xrefTrailerResolver.nextXrefObj(j, XRefType.STREAM);
            this.xrefTrailerResolver.setTrailer(cOSStream);
        }
        PDFXrefStreamParser pDFXrefStreamParser = new PDFXrefStreamParser(cOSStream, this.document, this.xrefTrailerResolver);
        pDFXrefStreamParser.parse();
        pDFXrefStreamParser.close();
    }

    public boolean parseXrefTable(long j) throws IOException {
        if (this.pdfSource.peek() != 120 || !readString().trim().equals("xref")) {
            return false;
        }
        String readString = readString();
        byte[] bytes = readString.getBytes("ISO-8859-1");
        this.pdfSource.unread(bytes, 0, bytes.length);
        this.xrefTrailerResolver.nextXrefObj(j, XRefType.TABLE);
        if (readString.startsWith("trailer")) {
            return false;
        }
        do {
            long readObjectNumber = (long) readObjectNumber();
            long readLong = readLong();
            skipSpaces();
            for (int i = 0; ((long) i) < readLong && !this.pdfSource.isEOF() && !isEndOfName((char) this.pdfSource.peek()) && this.pdfSource.peek() != 116; i++) {
                String[] split = readLine().split("\\s");
                if (split.length < 3) {
                    break;
                }
                if (split[split.length - 1].equals("n")) {
                    try {
                        int parseInt = Integer.parseInt(split[0]);
                        this.xrefTrailerResolver.setXRef(new COSObjectKey(readObjectNumber, Integer.parseInt(split[1])), (long) parseInt);
                    } catch (NumberFormatException e2) {
                        throw new IOException(e2);
                    }
                } else if (!split[2].equals(f.f1288a)) {
                    throw new IOException(GeneratedOutlineSupport.outline45("Corrupt XRefTable Entry - ObjID:", readObjectNumber));
                }
                readObjectNumber++;
                skipSpaces();
            }
            skipSpaces();
        } while (isDigit());
        return true;
    }

    public final COSDictionary rebuildTrailer() throws IOException {
        bfSearchForObjects();
        if (this.bfSearchCOSObjectKeyOffsets == null) {
            return null;
        }
        this.xrefTrailerResolver.nextXrefObj(0, XRefType.TABLE);
        for (COSObjectKey next : this.bfSearchCOSObjectKeyOffsets.keySet()) {
            this.xrefTrailerResolver.setXRef(next, this.bfSearchCOSObjectKeyOffsets.get(next).longValue());
        }
        this.xrefTrailerResolver.setStartxref(0);
        COSDictionary trailer = this.xrefTrailerResolver.getTrailer();
        getDocument().setTrailer(trailer);
        for (COSObjectKey next2 : this.bfSearchCOSObjectKeyOffsets.keySet()) {
            this.pdfSource.seek(this.bfSearchCOSObjectKeyOffsets.get(next2).longValue());
            readObjectNumber();
            readGenerationNumber();
            readExpectedString(OBJ_MARKER, true);
            try {
                COSDictionary parseCOSDictionary = parseCOSDictionary();
                if (parseCOSDictionary != null) {
                    if (COSName.CATALOG.equals(parseCOSDictionary.getCOSName(COSName.TYPE))) {
                        trailer.setItem(COSName.ROOT, (COSBase) this.document.getObjectFromPool(next2));
                    } else if (parseCOSDictionary.containsKey(COSName.TITLE) || parseCOSDictionary.containsKey(COSName.AUTHOR) || parseCOSDictionary.containsKey(COSName.SUBJECT) || parseCOSDictionary.containsKey(COSName.KEYWORDS) || parseCOSDictionary.containsKey(COSName.CREATOR) || parseCOSDictionary.containsKey(COSName.PRODUCER) || parseCOSDictionary.containsKey(COSName.CREATION_DATE)) {
                        trailer.setItem(COSName.INFO, (COSBase) this.document.getObjectFromPool(next2));
                    }
                }
            } catch (IOException unused) {
                "Skipped object " + next2 + ", either it's corrupt or not a dictionary";
            }
        }
        return trailer;
    }

    public void setEOFLookupRange(int i) {
        if (i > 15) {
            this.readTrailBytes = i;
        }
    }

    public void setLenient(boolean z) {
        if (!this.initialParseDone) {
            this.isLenient = z;
            return;
        }
        throw new IllegalArgumentException("Cannot change leniency after parsing");
    }

    private void addNewToList(Queue<COSBase> queue, COSBase cOSBase, Set<Long> set) {
        if (!(cOSBase instanceof COSObject) || set.add(Long.valueOf(getObjectId((COSObject) cOSBase)))) {
            queue.add(cOSBase);
        }
    }

    public COSBase parseObjectDynamically(long j, int i, boolean z) throws IOException {
        COSObjectKey cOSObjectKey = new COSObjectKey(j, i);
        COSObject objectFromPool = this.document.getObjectFromPool(cOSObjectKey);
        if (objectFromPool.getObject() == null) {
            Long l = this.xrefTrailerResolver.getXrefTable().get(cOSObjectKey);
            if (z && (l == null || l.longValue() <= 0)) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Object must be defined and must not be compressed object: ");
                outline73.append(cOSObjectKey.getNumber());
                outline73.append(":");
                outline73.append(cOSObjectKey.getGeneration());
                throw new IOException(outline73.toString());
            } else if (l == null) {
                objectFromPool.setObject(COSNull.NULL);
            } else if (l.longValue() > 0) {
                this.pdfSource.seek(l.longValue());
                long readObjectNumber = (long) readObjectNumber();
                int readGenerationNumber = readGenerationNumber();
                readExpectedString(OBJ_MARKER, true);
                if (readObjectNumber == cOSObjectKey.getNumber() && readGenerationNumber == cOSObjectKey.getGeneration()) {
                    skipSpaces();
                    COSBase parseDirObject = parseDirObject();
                    String readString = readString();
                    if (readString.equals(BaseParser.STREAM_STRING)) {
                        this.pdfSource.unread(readString.getBytes("ISO-8859-1"));
                        this.pdfSource.unread(32);
                        if (parseDirObject instanceof COSDictionary) {
                            parseDirObject = parseCOSStream((COSDictionary) parseDirObject);
                            skipSpaces();
                            readString = readLine();
                            if (!readString.startsWith(BaseParser.ENDOBJ_STRING) && readString.startsWith(BaseParser.ENDSTREAM_STRING)) {
                                readString = readString.substring(9).trim();
                                if (readString.length() == 0) {
                                    readString = readLine();
                                }
                            }
                        } else {
                            throw new IOException("Stream not preceded by dictionary (offset: " + l + ").");
                        }
                    }
                    objectFromPool.setObject(parseDirObject);
                    if (!readString.startsWith(BaseParser.ENDOBJ_STRING)) {
                        if (this.isLenient) {
                            "Object (" + readObjectNumber + ":" + readGenerationNumber + ") at offset " + l + " does not end with 'endobj' but with '" + readString + "'";
                        } else {
                            throw new IOException("Object (" + readObjectNumber + ":" + readGenerationNumber + ") at offset " + l + " does not end with 'endobj' but with '" + readString + "'");
                        }
                    }
                } else {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("XREF for ");
                    outline732.append(cOSObjectKey.getNumber());
                    outline732.append(":");
                    outline732.append(cOSObjectKey.getGeneration());
                    outline732.append(" points to wrong object: ");
                    outline732.append(readObjectNumber);
                    outline732.append(":");
                    outline732.append(readGenerationNumber);
                    throw new IOException(outline732.toString());
                }
            } else {
                int i2 = (int) (-l.longValue());
                COSBase parseObjectDynamically = parseObjectDynamically((long) i2, 0, true);
                if (parseObjectDynamically instanceof COSStream) {
                    PDFObjectStreamParser pDFObjectStreamParser = new PDFObjectStreamParser((COSStream) parseObjectDynamically, this.document);
                    pDFObjectStreamParser.parse();
                    pDFObjectStreamParser.close();
                    Set<Long> containedObjectNumbers = this.xrefTrailerResolver.getContainedObjectNumbers(i2);
                    for (COSObject next : pDFObjectStreamParser.getObjects()) {
                        COSObjectKey cOSObjectKey2 = new COSObjectKey(next);
                        if (containedObjectNumbers.contains(Long.valueOf(cOSObjectKey2.getNumber()))) {
                            this.document.getObjectFromPool(cOSObjectKey2).setObject(next.getObject());
                        }
                    }
                }
            }
        }
        return objectFromPool.getObject();
    }
}
