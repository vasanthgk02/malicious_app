package org.apache.fontbox.cff;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.apache.fontbox.cmap.CMapParser;

public class IndexData {
    public int count;
    public int[] data;
    public int[] offset;

    public IndexData(int i) {
        this.count = i;
        this.offset = new int[(i + 1)];
    }

    public byte[] getBytes(int i) {
        int[] iArr = this.offset;
        int i2 = iArr[i + 1] - iArr[i];
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) this.data[(this.offset[i] - 1) + i3];
        }
        return bArr;
    }

    public int getCount() {
        return this.count;
    }

    public int getOffset(int i) {
        return this.offset[i];
    }

    public void initData(int i) {
        this.data = new int[i];
    }

    public void setData(int i, int i2) {
        this.data[i] = i2;
    }

    public void setOffset(int i, int i2) {
        this.offset[i] = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline94(IndexData.class, sb, "[count=");
        sb.append(this.count);
        sb.append(", offset=");
        sb.append(Arrays.toString(this.offset));
        sb.append(", data=");
        sb.append(Arrays.toString(this.data));
        sb.append(CMapParser.MARK_END_OF_ARRAY);
        return sb.toString();
    }
}
