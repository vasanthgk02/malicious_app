package org.apache.pdfbox.pdfwriter;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSObjectKey;

public class COSWriterXRefEntry implements Comparable<COSWriterXRefEntry> {
    public static final COSWriterXRefEntry NULLENTRY;
    public boolean free = false;
    public COSObjectKey key;
    public COSBase object;
    public long offset;

    static {
        COSWriterXRefEntry cOSWriterXRefEntry = new COSWriterXRefEntry(0, null, new COSObjectKey(0, 65535));
        NULLENTRY = cOSWriterXRefEntry;
        cOSWriterXRefEntry.setFree(true);
    }

    public COSWriterXRefEntry(long j, COSBase cOSBase, COSObjectKey cOSObjectKey) {
        setOffset(j);
        setObject(cOSBase);
        setKey(cOSObjectKey);
    }

    public static COSWriterXRefEntry getNullEntry() {
        return NULLENTRY;
    }

    private void setKey(COSObjectKey cOSObjectKey) {
        this.key = cOSObjectKey;
    }

    private void setObject(COSBase cOSBase) {
        this.object = cOSBase;
    }

    public COSObjectKey getKey() {
        return this.key;
    }

    public COSBase getObject() {
        return this.object;
    }

    public long getOffset() {
        return this.offset;
    }

    public boolean isFree() {
        return this.free;
    }

    public void setFree(boolean z) {
        this.free = z;
    }

    public final void setOffset(long j) {
        this.offset = j;
    }

    public int compareTo(COSWriterXRefEntry cOSWriterXRefEntry) {
        if (cOSWriterXRefEntry == null || getKey().getNumber() < cOSWriterXRefEntry.getKey().getNumber()) {
            return -1;
        }
        return getKey().getNumber() > cOSWriterXRefEntry.getKey().getNumber() ? 1 : 0;
    }
}
