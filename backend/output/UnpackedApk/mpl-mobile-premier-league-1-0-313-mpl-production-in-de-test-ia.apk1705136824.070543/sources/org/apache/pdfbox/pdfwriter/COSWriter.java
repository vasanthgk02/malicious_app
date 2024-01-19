package org.apache.pdfbox.pdfwriter;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.utility.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateInfo;
import org.apache.pdfbox.cos.ICOSVisitor;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfparser.PDFXRefStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.util.Charsets;
import org.apache.pdfbox.util.Hex;

public class COSWriter implements ICOSVisitor, Closeable {
    public static final byte[] ARRAY_CLOSE = CMapParser.MARK_END_OF_ARRAY.getBytes(Charsets.US_ASCII);
    public static final byte[] ARRAY_OPEN = "[".getBytes(Charsets.US_ASCII);
    public static final byte[] COMMENT = {37};
    public static final byte[] DICT_CLOSE = CMapParser.MARK_END_OF_DICTIONARY.getBytes(Charsets.US_ASCII);
    public static final byte[] DICT_OPEN = "<<".getBytes(Charsets.US_ASCII);
    public static final byte[] ENDOBJ = BaseParser.ENDOBJ_STRING.getBytes(Charsets.US_ASCII);
    public static final byte[] ENDSTREAM = BaseParser.ENDSTREAM_STRING.getBytes(Charsets.US_ASCII);
    public static final byte[] EOF = "%%EOF".getBytes(Charsets.US_ASCII);
    public static final byte[] GARBAGE = {-10, -28, -4, -33};
    public static final byte[] OBJ = "obj".getBytes(Charsets.US_ASCII);
    public static final byte[] REFERENCE = "R".getBytes(Charsets.US_ASCII);
    public static final byte[] SPACE = {32};
    public static final byte[] STARTXREF = "startxref".getBytes(Charsets.US_ASCII);
    public static final byte[] STREAM = BaseParser.STREAM_STRING.getBytes(Charsets.US_ASCII);
    public static final byte[] TRAILER = "trailer".getBytes(Charsets.US_ASCII);
    public static final byte[] VERSION = "PDF-1.4".getBytes(Charsets.US_ASCII);
    public static final byte[] XREF = "xref".getBytes(Charsets.US_ASCII);
    public static final byte[] XREF_FREE = f.f1288a.getBytes(Charsets.US_ASCII);
    public static final byte[] XREF_USED = "n".getBytes(Charsets.US_ASCII);
    public final Set<COSBase> actualsAdded = new HashSet();
    public long byteRangeLength;
    public long byteRangeOffset;
    public COSObjectKey currentObjectKey = null;
    public FDFDocument fdfDocument = null;
    public final NumberFormat formatDecimal = NumberFormat.getNumberInstance(Locale.US);
    public final NumberFormat formatXrefGeneration = new DecimalFormat("00000");
    public final NumberFormat formatXrefOffset = new DecimalFormat("0000000000");
    public InputStream incrementalInput;
    public OutputStream incrementalOutput;
    public boolean incrementalUpdate = false;
    public final Map<COSObjectKey, COSBase> keyObject = new Hashtable();
    public long number = 0;
    public final Map<COSBase, COSObjectKey> objectKeys = new Hashtable();
    public final Deque<COSBase> objectsToWrite = new LinkedList();
    public final Set<COSBase> objectsToWriteSet = new HashSet();
    public OutputStream output;
    public PDDocument pdDocument = null;
    public boolean reachedSignature = false;
    public SignatureInterface signatureInterface;
    public long signatureLength;
    public long signatureOffset;
    public COSStandardOutputStream standardOutput;
    public long startxref = 0;
    public boolean willEncrypt = false;
    public final Set<COSBase> writtenObjects = new HashSet();
    public final List<COSWriterXRefEntry> xRefEntries = new ArrayList();

    public COSWriter(OutputStream outputStream) {
        setOutput(outputStream);
        setStandardOutput(new COSStandardOutputStream(this.output));
        this.formatDecimal.setMaximumFractionDigits(10);
        this.formatDecimal.setGroupingUsed(false);
    }

    private void addObjectToWrite(COSBase cOSBase) {
        COSBase object = cOSBase instanceof COSObject ? ((COSObject) cOSBase).getObject() : cOSBase;
        if (!this.writtenObjects.contains(cOSBase) && !this.objectsToWriteSet.contains(cOSBase) && !this.actualsAdded.contains(object)) {
            COSBase cOSBase2 = null;
            Object obj = object != null ? this.objectKeys.get(object) : null;
            if (obj != null) {
                cOSBase2 = this.keyObject.get(obj);
            }
            if (object == null || !this.objectKeys.containsKey(object) || !(cOSBase instanceof COSUpdateInfo) || ((COSUpdateInfo) cOSBase).isNeedToBeUpdated() || !(cOSBase2 instanceof COSUpdateInfo) || ((COSUpdateInfo) cOSBase2).isNeedToBeUpdated()) {
                this.objectsToWrite.add(cOSBase);
                this.objectsToWriteSet.add(cOSBase);
                if (object != null) {
                    this.actualsAdded.add(object);
                }
            }
        }
    }

    private void doWriteSignature() throws IOException {
        if (this.signatureOffset != 0 && this.byteRangeOffset != 0) {
            long available = (long) this.incrementalInput.available();
            long j = this.signatureOffset;
            long j2 = this.signatureLength + j;
            StringBuilder outline76 = GeneratedOutlineSupport.outline76("0 ", j, CMap.SPACE);
            outline76.append(j2);
            outline76.append(CMap.SPACE);
            outline76.append((getStandardOutput().getPos() - (this.signatureLength + available)) - (this.signatureOffset - available));
            outline76.append(CMapParser.MARK_END_OF_ARRAY);
            String sb = outline76.toString();
            if (this.byteRangeLength - ((long) sb.length()) >= 0) {
                ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.output;
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bytes = sb.getBytes();
                int i = 0;
                while (true) {
                    long j3 = (long) i;
                    if (j3 >= this.byteRangeLength) {
                        break;
                    }
                    if (i >= bytes.length) {
                        byteArray[(int) ((this.byteRangeOffset + j3) - available)] = 32;
                    } else {
                        byteArray[(int) ((this.byteRangeOffset + j3) - available)] = bytes[i];
                    }
                    i++;
                }
                byte[] byteArray2 = IOUtils.toByteArray(this.incrementalInput);
                byte[] bArr = new byte[(byteArray.length - ((int) this.signatureLength))];
                int i2 = (int) (this.signatureOffset - available);
                System.arraycopy(byteArray, 0, bArr, 0, i2);
                long j4 = this.signatureLength;
                System.arraycopy(byteArray, ((int) j4) + i2, bArr, i2, (byteArray.length - i2) - ((int) j4));
                String hexString = new COSString(this.signatureInterface.sign(new SequenceInputStream(new ByteArrayInputStream(byteArray2), new ByteArrayInputStream(bArr)))).toHexString();
                if (((long) hexString.length()) <= this.signatureLength - 2) {
                    byte[] bytes2 = hexString.getBytes();
                    System.arraycopy(bytes2, 0, byteArray, i2 + 1, bytes2.length);
                    this.incrementalOutput.write(byteArray2);
                    this.incrementalOutput.write(byteArray);
                    return;
                }
                throw new IOException("Can't write signature, not enough space");
            }
            throw new IOException("Can't write new ByteRange, not enough space");
        }
    }

    private void doWriteXRefInc(COSDocument cOSDocument, long j) throws IOException {
        if (cOSDocument.isXRefStream() || j != -1) {
            PDFXRefStream pDFXRefStream = new PDFXRefStream();
            for (COSWriterXRefEntry addEntry : getXRefEntries()) {
                pDFXRefStream.addEntry(addEntry);
            }
            COSDictionary trailer = cOSDocument.getTrailer();
            trailer.removeItem(COSName.PREV);
            pDFXRefStream.addTrailerInfo(trailer);
            pDFXRefStream.setSize(getNumber() + 2);
            setStartxref(getStandardOutput().getPos());
            doWriteObject(pDFXRefStream.getStream());
        }
        if (!cOSDocument.isXRefStream() || j != -1) {
            COSDictionary trailer2 = cOSDocument.getTrailer();
            trailer2.setLong(COSName.PREV, cOSDocument.getStartXref());
            if (j != -1) {
                COSName cOSName = COSName.XREF_STM;
                trailer2.removeItem(cOSName);
                trailer2.setLong(cOSName, getStartxref());
            }
            doWriteXRefTable();
            doWriteTrailer(cOSDocument);
        }
    }

    private void doWriteXRefTable() throws IOException {
        addXRefEntry(COSWriterXRefEntry.getNullEntry());
        Collections.sort(getXRefEntries());
        setStartxref(getStandardOutput().getPos());
        getStandardOutput().write(XREF);
        getStandardOutput().writeEOL();
        Long[] xRefRanges = getXRefRanges(getXRefEntries());
        int length = xRefRanges.length;
        int i = 0;
        for (int i2 = 0; i2 < length && length % 2 == 0; i2 += 2) {
            int i3 = i2 + 1;
            writeXrefRange(xRefRanges[i2].longValue(), xRefRanges[i3].longValue());
            int i4 = 0;
            while (((long) i4) < xRefRanges[i3].longValue()) {
                writeXrefEntry(this.xRefEntries.get(i));
                i4++;
                i++;
            }
        }
    }

    private COSObjectKey getObjectKey(COSBase cOSBase) {
        COSBase object = cOSBase instanceof COSObject ? ((COSObject) cOSBase).getObject() : cOSBase;
        COSObjectKey cOSObjectKey = null;
        if (object != null) {
            cOSObjectKey = this.objectKeys.get(object);
        }
        if (cOSObjectKey == null) {
            cOSObjectKey = this.objectKeys.get(cOSBase);
        }
        if (cOSObjectKey == null) {
            setNumber(getNumber() + 1);
            cOSObjectKey = new COSObjectKey(getNumber(), 0);
            this.objectKeys.put(cOSBase, cOSObjectKey);
            if (object != null) {
                this.objectKeys.put(object, cOSObjectKey);
            }
        }
        return cOSObjectKey;
    }

    public static Long[] getXRefRanges(List<COSWriterXRefEntry> list) {
        ArrayList arrayList = new ArrayList();
        long j = -2;
        long j2 = 1;
        for (COSWriterXRefEntry key : list) {
            long number2 = (long) ((int) key.getKey().getNumber());
            if (number2 == j + 1) {
                j2++;
            } else if (j != -2) {
                arrayList.add(Long.valueOf((j - j2) + 1));
                arrayList.add(Long.valueOf(j2));
                j2 = 1;
            }
            j = number2;
        }
        if (list.size() > 0) {
            arrayList.add(Long.valueOf((j - j2) + 1));
            arrayList.add(Long.valueOf(j2));
        }
        return (Long[]) arrayList.toArray(new Long[arrayList.size()]);
    }

    private void prepareIncrement(PDDocument pDDocument) {
        if (pDDocument != null) {
            try {
                COSDocument document = pDDocument.getDocument();
                long j = 0;
                for (COSObjectKey next : document.getXrefTable().keySet()) {
                    COSBase object = document.getObjectFromPool(next).getObject();
                    if (!(object == null || next == null || (object instanceof COSNumber))) {
                        this.objectKeys.put(object, next);
                        this.keyObject.put(next, object);
                    }
                    if (next != null) {
                        long number2 = next.getNumber();
                        if (number2 > j) {
                            j = number2;
                        }
                    }
                }
                setNumber(j);
            } catch (IOException e2) {
                e2.getMessage();
            }
        }
    }

    private void setOutput(OutputStream outputStream) {
        this.output = outputStream;
    }

    private void setStandardOutput(COSStandardOutputStream cOSStandardOutputStream) {
        this.standardOutput = cOSStandardOutputStream;
    }

    public static void writeString(COSString cOSString, OutputStream outputStream) throws IOException {
        writeString(cOSString.getBytes(), cOSString.getForceHexForm(), outputStream);
    }

    private void writeXrefEntry(COSWriterXRefEntry cOSWriterXRefEntry) throws IOException {
        String format = this.formatXrefOffset.format(cOSWriterXRefEntry.getOffset());
        String format2 = this.formatXrefGeneration.format((long) cOSWriterXRefEntry.getKey().getGeneration());
        getStandardOutput().write(format.getBytes(Charsets.ISO_8859_1));
        getStandardOutput().write(SPACE);
        getStandardOutput().write(format2.getBytes(Charsets.ISO_8859_1));
        getStandardOutput().write(SPACE);
        getStandardOutput().write(cOSWriterXRefEntry.isFree() ? XREF_FREE : XREF_USED);
        getStandardOutput().writeCRLF();
    }

    private void writeXrefRange(long j, long j2) throws IOException {
        getStandardOutput().write(String.valueOf(j).getBytes());
        getStandardOutput().write(SPACE);
        getStandardOutput().write(String.valueOf(j2).getBytes());
        getStandardOutput().writeEOL();
    }

    public void addXRefEntry(COSWriterXRefEntry cOSWriterXRefEntry) {
        getXRefEntries().add(cOSWriterXRefEntry);
    }

    public void close() throws IOException {
        if (getStandardOutput() != null) {
            getStandardOutput().close();
        }
        if (getOutput() != null) {
            getOutput().close();
        }
        OutputStream outputStream = this.incrementalOutput;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void doWriteBody(COSDocument cOSDocument) throws IOException {
        COSDictionary trailer = cOSDocument.getTrailer();
        COSDictionary cOSDictionary = (COSDictionary) trailer.getDictionaryObject(COSName.ROOT);
        COSDictionary cOSDictionary2 = (COSDictionary) trailer.getDictionaryObject(COSName.INFO);
        COSDictionary cOSDictionary3 = (COSDictionary) trailer.getDictionaryObject(COSName.ENCRYPT);
        if (cOSDictionary != null) {
            addObjectToWrite(cOSDictionary);
        }
        if (cOSDictionary2 != null) {
            addObjectToWrite(cOSDictionary2);
        }
        while (this.objectsToWrite.size() > 0) {
            COSBase removeFirst = this.objectsToWrite.removeFirst();
            this.objectsToWriteSet.remove(removeFirst);
            doWriteObject(removeFirst);
        }
        this.willEncrypt = false;
        if (cOSDictionary3 != null) {
            addObjectToWrite(cOSDictionary3);
        }
        while (this.objectsToWrite.size() > 0) {
            COSBase removeFirst2 = this.objectsToWrite.removeFirst();
            this.objectsToWriteSet.remove(removeFirst2);
            doWriteObject(removeFirst2);
        }
    }

    public void doWriteHeader(COSDocument cOSDocument) throws IOException {
        String str;
        if (this.fdfDocument != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(COSParser.FDF_HEADER);
            outline73.append(Float.toString(this.fdfDocument.getDocument().getVersion()));
            str = outline73.toString();
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73(COSParser.PDF_HEADER);
            outline732.append(Float.toString(this.pdDocument.getDocument().getVersion()));
            str = outline732.toString();
        }
        getStandardOutput().write(str.getBytes(Charsets.ISO_8859_1));
        getStandardOutput().writeEOL();
        getStandardOutput().write(COMMENT);
        getStandardOutput().write(GARBAGE);
        getStandardOutput().writeEOL();
    }

    public void doWriteObject(COSBase cOSBase) throws IOException {
        this.writtenObjects.add(cOSBase);
        if (cOSBase instanceof COSDictionary) {
            COSBase item = ((COSDictionary) cOSBase).getItem(COSName.TYPE);
            if (item instanceof COSName) {
                COSName cOSName = (COSName) item;
                if (COSName.SIG.equals(cOSName) || COSName.DOC_TIME_STAMP.equals(cOSName)) {
                    this.reachedSignature = true;
                }
            }
        }
        this.currentObjectKey = getObjectKey(cOSBase);
        addXRefEntry(new COSWriterXRefEntry(getStandardOutput().getPos(), cOSBase, this.currentObjectKey));
        getStandardOutput().write(String.valueOf(this.currentObjectKey.getNumber()).getBytes(Charsets.ISO_8859_1));
        getStandardOutput().write(SPACE);
        getStandardOutput().write(String.valueOf(this.currentObjectKey.getGeneration()).getBytes(Charsets.ISO_8859_1));
        getStandardOutput().write(SPACE);
        getStandardOutput().write(OBJ);
        getStandardOutput().writeEOL();
        cOSBase.accept(this);
        getStandardOutput().writeEOL();
        getStandardOutput().write(ENDOBJ);
        getStandardOutput().writeEOL();
    }

    public void doWriteTrailer(COSDocument cOSDocument) throws IOException {
        getStandardOutput().write(TRAILER);
        getStandardOutput().writeEOL();
        COSDictionary trailer = cOSDocument.getTrailer();
        Collections.sort(getXRefEntries());
        trailer.setLong(COSName.SIZE, getXRefEntries().get(getXRefEntries().size() - 1).getKey().getNumber() + 1);
        if (!this.incrementalUpdate) {
            trailer.removeItem(COSName.PREV);
        }
        if (!cOSDocument.isXRefStream()) {
            trailer.removeItem(COSName.XREF_STM);
        }
        trailer.removeItem(COSName.DOC_CHECKSUM);
        trailer.accept(this);
    }

    public long getNumber() {
        return this.number;
    }

    public Map<COSBase, COSObjectKey> getObjectKeys() {
        return this.objectKeys;
    }

    public OutputStream getOutput() {
        return this.output;
    }

    public COSStandardOutputStream getStandardOutput() {
        return this.standardOutput;
    }

    public long getStartxref() {
        return this.startxref;
    }

    public List<COSWriterXRefEntry> getXRefEntries() {
        return this.xRefEntries;
    }

    public void setNumber(long j) {
        this.number = j;
    }

    public void setStartxref(long j) {
        this.startxref = j;
    }

    public Object visitFromArray(COSArray cOSArray) throws IOException {
        getStandardOutput().write(ARRAY_OPEN);
        Iterator<COSBase> it = cOSArray.iterator();
        int i = 0;
        while (it.hasNext()) {
            COSBase next = it.next();
            if (next instanceof COSDictionary) {
                if (next.isDirect()) {
                    visitFromDictionary((COSDictionary) next);
                } else {
                    addObjectToWrite(next);
                    writeReference(next);
                }
            } else if (next instanceof COSObject) {
                COSBase object = ((COSObject) next).getObject();
                if ((object instanceof COSDictionary) || object == null) {
                    addObjectToWrite(next);
                    writeReference(next);
                } else {
                    object.accept(this);
                }
            } else if (next == null) {
                COSNull.NULL.accept(this);
            } else {
                next.accept(this);
            }
            i++;
            if (it.hasNext()) {
                if (i % 10 == 0) {
                    getStandardOutput().writeEOL();
                } else {
                    getStandardOutput().write(SPACE);
                }
            }
        }
        getStandardOutput().write(ARRAY_CLOSE);
        getStandardOutput().writeEOL();
        return null;
    }

    public Object visitFromBoolean(COSBoolean cOSBoolean) throws IOException {
        cOSBoolean.writePDF(getStandardOutput());
        return null;
    }

    public Object visitFromDictionary(COSDictionary cOSDictionary) throws IOException {
        getStandardOutput().write(DICT_OPEN);
        getStandardOutput().writeEOL();
        for (Entry next : cOSDictionary.entrySet()) {
            COSBase cOSBase = (COSBase) next.getValue();
            if (cOSBase != null) {
                ((COSName) next.getKey()).accept(this);
                getStandardOutput().write(SPACE);
                if (cOSBase instanceof COSDictionary) {
                    COSDictionary cOSDictionary2 = (COSDictionary) cOSBase;
                    COSBase item = cOSDictionary2.getItem(COSName.XOBJECT);
                    if (item != null) {
                        item.setDirect(true);
                    }
                    COSBase item2 = cOSDictionary2.getItem(COSName.RESOURCES);
                    if (item2 != null) {
                        item2.setDirect(true);
                    }
                    if (cOSDictionary2.isDirect()) {
                        visitFromDictionary(cOSDictionary2);
                    } else {
                        addObjectToWrite(cOSDictionary2);
                        writeReference(cOSDictionary2);
                    }
                } else if (cOSBase instanceof COSObject) {
                    COSBase object = ((COSObject) cOSBase).getObject();
                    if ((object instanceof COSDictionary) || object == null) {
                        addObjectToWrite(cOSBase);
                        writeReference(cOSBase);
                    } else {
                        object.accept(this);
                    }
                } else if (this.reachedSignature && COSName.CONTENTS.equals(next.getKey())) {
                    this.signatureOffset = getStandardOutput().getPos();
                    cOSBase.accept(this);
                    this.signatureLength = getStandardOutput().getPos() - this.signatureOffset;
                } else if (!this.reachedSignature || !COSName.BYTERANGE.equals(next.getKey())) {
                    cOSBase.accept(this);
                } else {
                    this.byteRangeOffset = getStandardOutput().getPos() + 1;
                    cOSBase.accept(this);
                    this.byteRangeLength = (getStandardOutput().getPos() - 1) - this.byteRangeOffset;
                    this.reachedSignature = false;
                }
                getStandardOutput().writeEOL();
            }
        }
        getStandardOutput().write(DICT_CLOSE);
        getStandardOutput().writeEOL();
        return null;
    }

    public Object visitFromDocument(COSDocument cOSDocument) throws IOException {
        if (!this.incrementalUpdate) {
            doWriteHeader(cOSDocument);
        } else {
            getStandardOutput().writeCRLF();
        }
        doWriteBody(cOSDocument);
        COSDictionary trailer = cOSDocument.getTrailer();
        long j = -1;
        if (trailer != null) {
            j = trailer.getLong(COSName.XREF_STM);
        }
        if (this.incrementalUpdate || cOSDocument.isXRefStream()) {
            doWriteXRefInc(cOSDocument, j);
        } else {
            doWriteXRefTable();
            doWriteTrailer(cOSDocument);
        }
        getStandardOutput().write(STARTXREF);
        getStandardOutput().writeEOL();
        getStandardOutput().write(String.valueOf(getStartxref()).getBytes(Charsets.ISO_8859_1));
        getStandardOutput().writeEOL();
        getStandardOutput().write(EOF);
        getStandardOutput().writeEOL();
        if (this.incrementalUpdate) {
            doWriteSignature();
        }
        return null;
    }

    public Object visitFromFloat(COSFloat cOSFloat) throws IOException {
        cOSFloat.writePDF(getStandardOutput());
        return null;
    }

    public Object visitFromInt(COSInteger cOSInteger) throws IOException {
        cOSInteger.writePDF(getStandardOutput());
        return null;
    }

    public Object visitFromName(COSName cOSName) throws IOException {
        cOSName.writePDF(getStandardOutput());
        return null;
    }

    public Object visitFromNull(COSNull cOSNull) throws IOException {
        COSNull.writePDF(getStandardOutput());
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object visitFromStream(org.apache.pdfbox.cos.COSStream r9) throws java.io.IOException {
        /*
            r8 = this;
            org.apache.pdfbox.cos.COSName r0 = org.apache.pdfbox.cos.COSName.LENGTH
            org.apache.pdfbox.cos.COSBase r0 = r9.getDictionaryObject(r0)
            org.apache.pdfbox.cos.COSName r1 = org.apache.pdfbox.cos.COSName.TYPE
            java.lang.String r1 = r9.getNameAsString(r1)
            r2 = 0
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.isDirect()
            if (r0 != 0) goto L_0x001d
        L_0x0015:
            java.lang.String r0 = "XRef"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0030
        L_0x001d:
            long r0 = r9.getFilteredLength()
            org.apache.pdfbox.cos.COSInteger r0 = org.apache.pdfbox.cos.COSInteger.get(r0)
            r1 = 1
            r0.setDirect(r1)
            org.apache.pdfbox.cos.COSName r1 = org.apache.pdfbox.cos.COSName.LENGTH
            r9.setItem(r1, r0)
            r0 = r2
            goto L_0x003a
        L_0x0030:
            org.apache.pdfbox.cos.COSObject r0 = new org.apache.pdfbox.cos.COSObject
            r0.<init>(r2)
            org.apache.pdfbox.cos.COSName r1 = org.apache.pdfbox.cos.COSName.LENGTH
            r9.setItem(r1, r0)
        L_0x003a:
            java.io.InputStream r1 = r9.getFilteredStream()     // Catch:{ all -> 0x008f }
            r8.visitFromDictionary(r9)     // Catch:{ all -> 0x008c }
            org.apache.pdfbox.pdfwriter.COSStandardOutputStream r9 = r8.getStandardOutput()     // Catch:{ all -> 0x008c }
            byte[] r3 = STREAM     // Catch:{ all -> 0x008c }
            r9.write(r3)     // Catch:{ all -> 0x008c }
            org.apache.pdfbox.pdfwriter.COSStandardOutputStream r9 = r8.getStandardOutput()     // Catch:{ all -> 0x008c }
            r9.writeCRLF()     // Catch:{ all -> 0x008c }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r9]     // Catch:{ all -> 0x008c }
            r4 = 0
            r5 = 0
        L_0x0057:
            int r6 = r1.read(r3, r4, r9)     // Catch:{ all -> 0x008c }
            r7 = -1
            if (r6 == r7) goto L_0x0067
            org.apache.pdfbox.pdfwriter.COSStandardOutputStream r7 = r8.getStandardOutput()     // Catch:{ all -> 0x008c }
            r7.write(r3, r4, r6)     // Catch:{ all -> 0x008c }
            int r5 = r5 + r6
            goto L_0x0057
        L_0x0067:
            if (r0 == 0) goto L_0x0071
            long r3 = (long) r5     // Catch:{ all -> 0x008c }
            org.apache.pdfbox.cos.COSInteger r9 = org.apache.pdfbox.cos.COSInteger.get(r3)     // Catch:{ all -> 0x008c }
            r0.setObject(r9)     // Catch:{ all -> 0x008c }
        L_0x0071:
            org.apache.pdfbox.pdfwriter.COSStandardOutputStream r9 = r8.getStandardOutput()     // Catch:{ all -> 0x008c }
            r9.writeCRLF()     // Catch:{ all -> 0x008c }
            org.apache.pdfbox.pdfwriter.COSStandardOutputStream r9 = r8.getStandardOutput()     // Catch:{ all -> 0x008c }
            byte[] r0 = ENDSTREAM     // Catch:{ all -> 0x008c }
            r9.write(r0)     // Catch:{ all -> 0x008c }
            org.apache.pdfbox.pdfwriter.COSStandardOutputStream r9 = r8.getStandardOutput()     // Catch:{ all -> 0x008c }
            r9.writeEOL()     // Catch:{ all -> 0x008c }
            r1.close()
            return r2
        L_0x008c:
            r9 = move-exception
            r2 = r1
            goto L_0x0090
        L_0x008f:
            r9 = move-exception
        L_0x0090:
            if (r2 == 0) goto L_0x0095
            r2.close()
        L_0x0095:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfwriter.COSWriter.visitFromStream(org.apache.pdfbox.cos.COSStream):java.lang.Object");
    }

    public Object visitFromString(COSString cOSString) throws IOException {
        writeString(cOSString, (OutputStream) getStandardOutput());
        return null;
    }

    public void write(COSDocument cOSDocument) throws IOException {
        write(new PDDocument(cOSDocument));
    }

    public void writeReference(COSBase cOSBase) throws IOException {
        COSObjectKey objectKey = getObjectKey(cOSBase);
        getStandardOutput().write(String.valueOf(objectKey.getNumber()).getBytes(Charsets.ISO_8859_1));
        getStandardOutput().write(SPACE);
        getStandardOutput().write(String.valueOf(objectKey.getGeneration()).getBytes(Charsets.ISO_8859_1));
        getStandardOutput().write(SPACE);
        getStandardOutput().write(REFERENCE);
    }

    public static void writeString(byte[] bArr, OutputStream outputStream) throws IOException {
        writeString(bArr, false, outputStream);
    }

    public static void writeString(byte[] bArr, boolean z, OutputStream outputStream) throws IOException {
        boolean z2;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z2 = true;
                break;
            } else if (bArr[i2] < 0) {
                z2 = false;
                break;
            } else {
                i2++;
            }
        }
        if (!z2 || z) {
            outputStream.write(60);
            int length2 = bArr.length;
            while (i < length2) {
                outputStream.write(Hex.getBytes(bArr[i]));
                i++;
            }
            outputStream.write(62);
            return;
        }
        outputStream.write(40);
        int length3 = bArr.length;
        while (i < length3) {
            byte b2 = bArr[i];
            if (b2 == 40 || b2 == 41 || b2 == 92) {
                outputStream.write(92);
                outputStream.write(b2);
            } else {
                outputStream.write(b2);
            }
            i++;
        }
        outputStream.write(41);
    }

    public void write(PDDocument pDDocument) throws IOException {
        write(pDDocument, null);
    }

    public void write(PDDocument pDDocument, SignatureInterface signatureInterface2) throws IOException {
        long j;
        COSBase cOSBase;
        if (pDDocument.getDocumentId() == null) {
            j = System.currentTimeMillis();
        } else {
            j = pDDocument.getDocumentId().longValue();
        }
        Long valueOf = Long.valueOf(j);
        this.pdDocument = pDDocument;
        this.signatureInterface = signatureInterface2;
        if (this.incrementalUpdate) {
            prepareIncrement(pDDocument);
        }
        if (pDDocument.isAllSecurityToBeRemoved()) {
            this.willEncrypt = false;
            pDDocument.getDocument().getTrailer().removeItem(COSName.ENCRYPT);
        } else {
            this.willEncrypt = false;
        }
        COSDocument document = this.pdDocument.getDocument();
        COSDictionary trailer = document.getTrailer();
        COSArray cOSArray = (COSArray) trailer.getDictionaryObject(COSName.ID);
        boolean z = true;
        if (cOSArray != null && cOSArray.size() == 2) {
            z = false;
        }
        if (z || this.incrementalUpdate) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(Long.toString(valueOf.longValue()).getBytes(Charsets.ISO_8859_1));
                COSDictionary cOSDictionary = (COSDictionary) trailer.getDictionaryObject(COSName.INFO);
                if (cOSDictionary != null) {
                    for (COSBase obj : cOSDictionary.getValues()) {
                        instance.update(obj.toString().getBytes(Charsets.ISO_8859_1));
                    }
                }
                COSString cOSString = z ? new COSString(instance.digest()) : (COSString) cOSArray.get(0);
                if (z) {
                    cOSBase = cOSString;
                } else {
                    cOSBase = new COSString(instance.digest());
                }
                COSArray cOSArray2 = new COSArray();
                cOSArray2.add((COSBase) cOSString);
                cOSArray2.add(cOSBase);
                trailer.setItem(COSName.ID, (COSBase) cOSArray2);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        document.accept(this);
    }

    public COSWriter(OutputStream outputStream, InputStream inputStream) throws IOException {
        setOutput(new ByteArrayOutputStream());
        setStandardOutput(new COSStandardOutputStream(this.output, inputStream.available()));
        this.incrementalInput = inputStream;
        this.incrementalOutput = outputStream;
        this.incrementalUpdate = true;
        this.formatDecimal.setMaximumFractionDigits(10);
        this.formatDecimal.setGroupingUsed(false);
    }

    public void write(FDFDocument fDFDocument) throws IOException {
        this.fdfDocument = fDFDocument;
        this.willEncrypt = false;
        fDFDocument.getDocument().accept(this);
    }
}
