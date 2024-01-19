package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;

public class AdaptiveReceiveBufferSizePredictor implements ReceiveBufferSizePredictor {
    public static final int DEFAULT_INITIAL = 1024;
    public static final int DEFAULT_MAXIMUM = 65536;
    public static final int DEFAULT_MINIMUM = 64;
    public static final int INDEX_DECREMENT = 1;
    public static final int INDEX_INCREMENT = 4;
    public static final int[] SIZE_TABLE;
    public boolean decreaseNow;
    public int index;
    public final int maxIndex;
    public final int minIndex;
    public int nextReceiveBufferSize;

    static {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 <= 8; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        int i3 = 4;
        while (true) {
            i = 0;
            if (i3 >= 32) {
                break;
            }
            long j = 1 << i3;
            long j2 = j >>> 4;
            long j3 = j - (j2 << 3);
            while (i < 8) {
                j3 += j2;
                if (j3 > 2147483647L) {
                    arrayList.add(Integer.valueOf(Integer.MAX_VALUE));
                } else {
                    arrayList.add(Integer.valueOf((int) j3));
                }
                i++;
            }
            i3++;
        }
        SIZE_TABLE = new int[arrayList.size()];
        while (true) {
            int[] iArr = SIZE_TABLE;
            if (i < iArr.length) {
                iArr[i] = ((Integer) arrayList.get(i)).intValue();
                i++;
            } else {
                return;
            }
        }
    }

    public AdaptiveReceiveBufferSizePredictor() {
        this(64, 1024, 65536);
    }

    public static int getSizeTableIndex(int i) {
        if (i <= 16) {
            return i - 1;
        }
        int i2 = 0;
        int i3 = i;
        do {
            i3 >>>= 1;
            i2++;
        } while (i3 != 0);
        int i4 = i2 << 3;
        int i5 = i4 - 25;
        for (int i6 = i4 - 18; i6 >= i5; i6--) {
            if (i >= SIZE_TABLE[i6]) {
                return i6;
            }
        }
        throw new Error("shouldn't reach here; please file a bug report.");
    }

    public int nextReceiveBufferSize() {
        return this.nextReceiveBufferSize;
    }

    public void previousReceiveBufferSize(int i) {
        if (i <= SIZE_TABLE[Math.max(0, (this.index - 1) - 1)]) {
            if (this.decreaseNow) {
                int max = Math.max(this.index - 1, this.minIndex);
                this.index = max;
                this.nextReceiveBufferSize = SIZE_TABLE[max];
                this.decreaseNow = false;
                return;
            }
            this.decreaseNow = true;
        } else if (i >= this.nextReceiveBufferSize) {
            int min = Math.min(this.index + 4, this.maxIndex);
            this.index = min;
            this.nextReceiveBufferSize = SIZE_TABLE[min];
            this.decreaseNow = false;
        }
    }

    public AdaptiveReceiveBufferSizePredictor(int i, int i2, int i3) {
        if (i <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("minimum: ", i));
        } else if (i2 < i) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("initial: ", i2));
        } else if (i3 >= i2) {
            int sizeTableIndex = getSizeTableIndex(i);
            if (SIZE_TABLE[sizeTableIndex] < i) {
                this.minIndex = sizeTableIndex + 1;
            } else {
                this.minIndex = sizeTableIndex;
            }
            int sizeTableIndex2 = getSizeTableIndex(i3);
            if (SIZE_TABLE[sizeTableIndex2] > i3) {
                this.maxIndex = sizeTableIndex2 - 1;
            } else {
                this.maxIndex = sizeTableIndex2;
            }
            int sizeTableIndex3 = getSizeTableIndex(i2);
            this.index = sizeTableIndex3;
            this.nextReceiveBufferSize = SIZE_TABLE[sizeTableIndex3];
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maximum: ", i3));
        }
    }
}
