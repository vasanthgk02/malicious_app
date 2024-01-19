package org.apache.fontbox.cmap;

public class CIDRange {
    public final int cid;
    public final char from;
    public final char to;

    public CIDRange(char c2, char c3, int i) {
        this.from = c2;
        this.to = c3;
        this.cid = i;
    }

    public int map(char c2) {
        char c3 = this.from;
        if (c3 > c2 || c2 > this.to) {
            return -1;
        }
        return (c2 - c3) + this.cid;
    }

    public int unmap(int i) {
        int i2 = this.cid;
        if (i2 <= i) {
            char c2 = this.to;
            char c3 = this.from;
            if (i <= (c2 - c3) + i2) {
                return (i - i2) + c3;
            }
        }
        return -1;
    }
}
