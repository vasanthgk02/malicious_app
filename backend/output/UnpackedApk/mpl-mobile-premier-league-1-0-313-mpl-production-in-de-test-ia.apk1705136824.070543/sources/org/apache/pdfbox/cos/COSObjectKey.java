package org.apache.pdfbox.cos;

import org.apache.fontbox.cmap.CMap;

public class COSObjectKey implements Comparable<COSObjectKey> {
    public final int generation;
    public final long number;

    public COSObjectKey(COSObject cOSObject) {
        this(cOSObject.getObjectNumber(), cOSObject.getGenerationNumber());
    }

    public boolean equals(Object obj) {
        COSObjectKey cOSObjectKey = obj instanceof COSObjectKey ? (COSObjectKey) obj : null;
        return cOSObjectKey != null && cOSObjectKey.getNumber() == getNumber() && cOSObjectKey.getGeneration() == getGeneration();
    }

    public int getGeneration() {
        return this.generation;
    }

    public long getNumber() {
        return this.number;
    }

    public int hashCode() {
        return Long.valueOf(this.number + ((long) this.generation)).hashCode();
    }

    public String toString() {
        return Long.toString(this.number) + CMap.SPACE + Integer.toString(this.generation) + " R";
    }

    public COSObjectKey(long j, int i) {
        this.number = j;
        this.generation = i;
    }

    public int compareTo(COSObjectKey cOSObjectKey) {
        if (getNumber() < cOSObjectKey.getNumber()) {
            return -1;
        }
        if (getNumber() > cOSObjectKey.getNumber()) {
            return 1;
        }
        if (getGeneration() < cOSObjectKey.getGeneration()) {
            return -1;
        }
        if (getGeneration() > cOSObjectKey.getGeneration()) {
            return 1;
        }
        return 0;
    }
}
