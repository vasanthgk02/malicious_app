package kotlin.reflect.jvm.internal.impl.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator;

public class LiteralByteString extends ByteString {
    public final byte[] bytes;
    public int hash = 0;

    public class LiteralByteIterator implements ByteIterator {
        public final int limit;
        public int position = 0;

        public LiteralByteIterator(AnonymousClass1 r2) {
            this.limit = LiteralByteString.this.size();
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public Object next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.bytes;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new NoSuchElementException(e2.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public LiteralByteString(byte[] bArr) {
        this.bytes = bArr;
    }

    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return equalsRange((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline62(new StringBuilder(valueOf.length() + 49), "Has a new type of ByteString been created? Found ", valueOf));
    }

    public boolean equalsRange(LiteralByteString literalByteString, int i, int i2) {
        if (i2 > literalByteString.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i + i2 <= literalByteString.size()) {
            byte[] bArr = this.bytes;
            byte[] bArr2 = literalByteString.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i2;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        } else {
            int size2 = literalByteString.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline61(sb2, ", ", size2));
        }
    }

    public int getOffsetIntoBytes() {
        return 0;
    }

    public int getTreeDepth() {
        return 0;
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int size = size();
            i = partialHash(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    public boolean isBalanced() {
        return true;
    }

    public boolean isValidUtf8() {
        int offsetIntoBytes = getOffsetIntoBytes();
        return TweetUtils.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
    }

    public int partialHash(int i, int i2, int i3) {
        byte[] bArr = this.bytes;
        int offsetIntoBytes = getOffsetIntoBytes() + i2;
        for (int i4 = offsetIntoBytes; i4 < offsetIntoBytes + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        if (r9[r0] > -65) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
        if (r9[r0] > -65) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r9[r0] > -65) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int partialIsValidUtf8(int r8, int r9, int r10) {
        /*
            r7 = this;
            int r0 = r7.getOffsetIntoBytes()
            int r0 = r0 + r9
            byte[] r9 = r7.bytes
            int r10 = r10 + r0
            if (r8 == 0) goto L_0x008d
            if (r0 < r10) goto L_0x000e
            goto L_0x0091
        L_0x000e:
            byte r1 = (byte) r8
            r2 = -32
            r3 = -1
            r4 = -65
            if (r1 >= r2) goto L_0x0027
            r8 = -62
            if (r1 < r8) goto L_0x0024
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r0 <= r4) goto L_0x0021
            goto L_0x0024
        L_0x0021:
            r0 = r8
            goto L_0x008d
        L_0x0024:
            r8 = -1
            goto L_0x0091
        L_0x0027:
            r5 = -16
            if (r1 >= r5) goto L_0x0054
            int r8 = r8 >> 8
            int r8 = ~r8
            byte r8 = (byte) r8
            if (r8 != 0) goto L_0x003f
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r8 < r10) goto L_0x003c
            int r8 = com.twitter.sdk.android.tweetui.TweetUtils.incompleteStateFor(r1, r0)
            goto L_0x0091
        L_0x003c:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x003f:
            if (r8 > r4) goto L_0x0024
            r5 = -96
            if (r1 != r2) goto L_0x0047
            if (r8 < r5) goto L_0x0024
        L_0x0047:
            r2 = -19
            if (r1 != r2) goto L_0x004d
            if (r8 >= r5) goto L_0x0024
        L_0x004d:
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r0 <= r4) goto L_0x0021
            goto L_0x0024
        L_0x0054:
            int r2 = r8 >> 8
            int r2 = ~r2
            byte r2 = (byte) r2
            r5 = 0
            if (r2 != 0) goto L_0x0068
            int r8 = r0 + 1
            byte r2 = r9[r0]
            if (r8 < r10) goto L_0x0066
            int r8 = com.twitter.sdk.android.tweetui.TweetUtils.incompleteStateFor(r1, r2)
            goto L_0x0091
        L_0x0066:
            r0 = r8
            goto L_0x006b
        L_0x0068:
            int r8 = r8 >> 16
            byte r5 = (byte) r8
        L_0x006b:
            if (r5 != 0) goto L_0x0079
            int r8 = r0 + 1
            byte r5 = r9[r0]
            if (r8 < r10) goto L_0x0078
            int r8 = com.twitter.sdk.android.tweetui.TweetUtils.incompleteStateFor(r1, r2, r5)
            goto L_0x0091
        L_0x0078:
            r0 = r8
        L_0x0079:
            if (r2 > r4) goto L_0x0024
            int r8 = r1 << 28
            int r2 = r2 + 112
            int r2 = r2 + r8
            int r8 = r2 >> 30
            if (r8 != 0) goto L_0x0024
            if (r5 > r4) goto L_0x0024
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r0 <= r4) goto L_0x0021
            goto L_0x0024
        L_0x008d:
            int r8 = com.twitter.sdk.android.tweetui.TweetUtils.partialIsValidUtf8(r9, r0, r10)
        L_0x0091:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString.partialIsValidUtf8(int, int, int):int");
    }

    public int peekCachedHashCode() {
        return this.hash;
    }

    public int size() {
        return this.bytes.length;
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), str);
    }

    public void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.bytes, getOffsetIntoBytes() + i, i2);
    }

    public ByteIterator iterator() {
        return new LiteralByteIterator(null);
    }
}
