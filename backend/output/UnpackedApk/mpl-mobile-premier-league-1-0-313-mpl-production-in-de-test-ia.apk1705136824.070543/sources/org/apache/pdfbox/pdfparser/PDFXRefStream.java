package org.apache.pdfbox.pdfparser;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdfwriter.COSWriterXRefEntry;

public class PDFXRefStream implements PDFXRef {
    public static final int ENTRY_FREE = 0;
    public static final int ENTRY_NORMAL = 1;
    public static final int ENTRY_OBJSTREAM = 2;
    public final Set<Long> objectNumbers = new TreeSet();
    public long size = -1;
    public final COSStream stream = new COSStream(new COSDictionary());
    public final Map<Long, Object> streamData = new TreeMap();

    public class FreeReference {
        public long nextFree;
        public int nextGenNumber;

        public FreeReference() {
        }
    }

    public class NormalReference {
        public int genNumber;
        public long offset;

        public NormalReference() {
        }
    }

    public class ObjectStreamReference {
        public long objectNumberOfObjectStream;
        public long offset;

        public ObjectStreamReference() {
        }
    }

    private List<Long> getIndexEntry() {
        LinkedList linkedList = new LinkedList();
        Long l = null;
        Long l2 = null;
        for (Long next : this.objectNumbers) {
            if (l == null) {
                l2 = Long.valueOf(1);
                l = next;
            }
            if (l2.longValue() + l.longValue() == next.longValue()) {
                l2 = Long.valueOf(l2.longValue() + 1);
            }
            if (l2.longValue() + l.longValue() < next.longValue()) {
                linkedList.add(l);
                linkedList.add(l2);
                l2 = Long.valueOf(1);
                l = next;
            }
        }
        linkedList.add(l);
        linkedList.add(l2);
        return linkedList;
    }

    private long getSizeEntry() {
        return this.size;
    }

    private int[] getWEntry() {
        long[] jArr = new long[3];
        Iterator<Object> it = this.streamData.values().iterator();
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (next instanceof FreeReference) {
                    FreeReference freeReference = (FreeReference) next;
                    jArr[0] = Math.max(jArr[0], 0);
                    jArr[1] = Math.max(jArr[1], freeReference.nextFree);
                    jArr[2] = Math.max(jArr[2], (long) freeReference.nextGenNumber);
                } else if (next instanceof NormalReference) {
                    NormalReference normalReference = (NormalReference) next;
                    jArr[0] = Math.max(jArr[0], 1);
                    jArr[1] = Math.max(jArr[1], normalReference.offset);
                    jArr[2] = Math.max(jArr[2], (long) normalReference.genNumber);
                } else if (next instanceof ObjectStreamReference) {
                    ObjectStreamReference objectStreamReference = (ObjectStreamReference) next;
                    jArr[0] = Math.max(jArr[0], 2);
                    jArr[1] = Math.max(jArr[1], objectStreamReference.offset);
                    jArr[2] = Math.max(jArr[2], objectStreamReference.objectNumberOfObjectStream);
                } else {
                    throw new RuntimeException("unexpected reference type");
                }
            } else {
                int[] iArr = new int[3];
                for (int i = 0; i < 3; i++) {
                    while (jArr[i] > 0) {
                        iArr[i] = iArr[i] + 1;
                        jArr[i] = jArr[i] >> 8;
                    }
                }
                return iArr;
            }
        }
    }

    private void writeNumber(OutputStream outputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        for (int i3 = 0; i3 < i; i3++) {
            outputStream.write(bArr[(i - i3) - 1]);
        }
    }

    private void writeStreamData(OutputStream outputStream, int[] iArr) throws IOException {
        for (Object next : this.streamData.values()) {
            if (next instanceof FreeReference) {
                FreeReference freeReference = (FreeReference) next;
                writeNumber(outputStream, 0, iArr[0]);
                writeNumber(outputStream, freeReference.nextFree, iArr[1]);
                writeNumber(outputStream, (long) freeReference.nextGenNumber, iArr[2]);
            } else if (next instanceof NormalReference) {
                NormalReference normalReference = (NormalReference) next;
                writeNumber(outputStream, 1, iArr[0]);
                writeNumber(outputStream, normalReference.offset, iArr[1]);
                writeNumber(outputStream, (long) normalReference.genNumber, iArr[2]);
            } else if (next instanceof ObjectStreamReference) {
                ObjectStreamReference objectStreamReference = (ObjectStreamReference) next;
                writeNumber(outputStream, 2, iArr[0]);
                writeNumber(outputStream, objectStreamReference.offset, iArr[1]);
                writeNumber(outputStream, objectStreamReference.objectNumberOfObjectStream, iArr[2]);
            } else {
                throw new RuntimeException("unexpected reference type");
            }
        }
        outputStream.flush();
        outputStream.close();
    }

    public void addEntry(COSWriterXRefEntry cOSWriterXRefEntry) {
        this.objectNumbers.add(Long.valueOf(cOSWriterXRefEntry.getKey().getNumber()));
        if (cOSWriterXRefEntry.isFree()) {
            FreeReference freeReference = new FreeReference();
            freeReference.nextGenNumber = cOSWriterXRefEntry.getKey().getGeneration();
            long number = cOSWriterXRefEntry.getKey().getNumber();
            freeReference.nextFree = number;
            this.streamData.put(Long.valueOf(number), freeReference);
            return;
        }
        NormalReference normalReference = new NormalReference();
        normalReference.genNumber = cOSWriterXRefEntry.getKey().getGeneration();
        normalReference.offset = cOSWriterXRefEntry.getOffset();
        this.streamData.put(Long.valueOf(cOSWriterXRefEntry.getKey().getNumber()), normalReference);
    }

    public void addTrailerInfo(COSDictionary cOSDictionary) {
        for (Entry next : cOSDictionary.entrySet()) {
            COSName cOSName = (COSName) next.getKey();
            if (COSName.INFO.equals(cOSName) || COSName.ROOT.equals(cOSName) || COSName.ENCRYPT.equals(cOSName) || COSName.ID.equals(cOSName) || COSName.PREV.equals(cOSName)) {
                this.stream.setItem(cOSName, (COSBase) next.getValue());
            }
        }
    }

    public COSObject getObject(int i) {
        return null;
    }

    public COSStream getStream() throws IOException {
        this.stream.setItem(COSName.TYPE, (COSBase) COSName.XREF);
        if (this.size != -1) {
            this.stream.setLong(COSName.SIZE, getSizeEntry());
            this.stream.setFilters(COSName.FLATE_DECODE);
            List<Long> indexEntry = getIndexEntry();
            COSArray cOSArray = new COSArray();
            for (Long longValue : indexEntry) {
                cOSArray.add((COSBase) COSInteger.get(longValue.longValue()));
            }
            this.stream.setItem(COSName.INDEX, (COSBase) cOSArray);
            int[] wEntry = getWEntry();
            COSArray cOSArray2 = new COSArray();
            for (int i : wEntry) {
                cOSArray2.add((COSBase) COSInteger.get((long) i));
            }
            this.stream.setItem(COSName.W, (COSBase) cOSArray2);
            writeStreamData(this.stream.createUnfilteredStream(), wEntry);
            for (COSName dictionaryObject : this.stream.keySet()) {
                this.stream.getDictionaryObject(dictionaryObject).setDirect(true);
            }
            return this.stream;
        }
        throw new IllegalArgumentException("size is not set in xrefstream");
    }

    public void setSize(long j) {
        this.size = j;
    }
}
