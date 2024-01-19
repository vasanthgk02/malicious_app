package org.apache.fontbox.cmap;

import java.util.List;

public class CodespaceRange {
    public byte[] end;
    public byte[] start;

    public byte[] getEnd() {
        return this.end;
    }

    public byte[] getStart() {
        return this.start;
    }

    public boolean isFullMatch(List<Byte> list) {
        if (list.size() < this.start.length || list.size() > this.end.length) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            byte b2 = this.start[i] & 255;
            byte b3 = this.end[i] & 255;
            byte byteValue = list.get(i).byteValue() & 255;
            if (byteValue > b3 || byteValue < b2) {
                return false;
            }
        }
        return true;
    }

    public boolean isPartialMatch(byte b2, int i) {
        byte b3 = b2 & 255;
        return b3 <= (this.end[i] & 255) && b3 >= (this.start[i] & 255);
    }

    public boolean matches(byte[] bArr) {
        if (bArr.length < this.start.length || bArr.length > this.end.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = this.start[i] & 255;
            byte b3 = this.end[i] & 255;
            byte b4 = bArr[i] & 255;
            if (b4 > b3 || b4 < b2) {
                return false;
            }
        }
        return true;
    }

    public void setEnd(byte[] bArr) {
        this.end = bArr;
    }

    public void setStart(byte[] bArr) {
        this.start = bArr;
    }
}
