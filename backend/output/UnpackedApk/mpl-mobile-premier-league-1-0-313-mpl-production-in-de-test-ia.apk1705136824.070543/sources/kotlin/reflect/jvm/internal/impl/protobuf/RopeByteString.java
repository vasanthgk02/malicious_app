package kotlin.reflect.jvm.internal.impl.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator;

public class RopeByteString extends ByteString {
    public static final int[] minLengthByDepth;
    public int hash = 0;
    public final ByteString left;
    public final int leftLength;
    public final ByteString right;
    public final int totalLength;
    public final int treeDepth;

    public static class Balancer {
        public final Stack<ByteString> prefixesStack = new Stack<>();

        public Balancer(AnonymousClass1 r1) {
        }

        public final void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, byteString.size());
                if (binarySearch < 0) {
                    binarySearch = (-(binarySearch + 1)) - 1;
                }
                int i = RopeByteString.minLengthByDepth[binarySearch + 1];
                if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= i) {
                    this.prefixesStack.push(byteString);
                    return;
                }
                int i2 = RopeByteString.minLengthByDepth[binarySearch];
                ByteString pop = this.prefixesStack.pop();
                while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < i2) {
                    pop = new RopeByteString(this.prefixesStack.pop(), pop);
                }
                RopeByteString ropeByteString = new RopeByteString(pop, byteString);
                while (!this.prefixesStack.isEmpty()) {
                    int binarySearch2 = Arrays.binarySearch(RopeByteString.minLengthByDepth, ropeByteString.totalLength);
                    if (binarySearch2 < 0) {
                        binarySearch2 = (-(binarySearch2 + 1)) - 1;
                    }
                    if (this.prefixesStack.peek().size() >= RopeByteString.minLengthByDepth[binarySearch2 + 1]) {
                        break;
                    }
                    ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
                }
                this.prefixesStack.push(ropeByteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString2 = (RopeByteString) byteString;
                doBalance(ropeByteString2.left);
                doBalance(ropeByteString2.right);
            } else {
                String valueOf = String.valueOf(byteString.getClass());
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline62(new StringBuilder(valueOf.length() + 49), "Has a new type of ByteString been created? Found ", valueOf));
            }
        }
    }

    public static class PieceIterator implements Iterator<LiteralByteString> {
        public final Stack<RopeByteString> breadCrumbs = new Stack<>();
        public LiteralByteString next;

        public PieceIterator(ByteString byteString, AnonymousClass1 r2) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            this.next = (LiteralByteString) byteString;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public LiteralByteString next() {
            LiteralByteString literalByteString;
            boolean z;
            LiteralByteString literalByteString2 = this.next;
            if (literalByteString2 != null) {
                while (true) {
                    if (!this.breadCrumbs.isEmpty()) {
                        ByteString byteString = this.breadCrumbs.pop().right;
                        while (byteString instanceof RopeByteString) {
                            RopeByteString ropeByteString = (RopeByteString) byteString;
                            this.breadCrumbs.push(ropeByteString);
                            byteString = ropeByteString.left;
                        }
                        literalByteString = (LiteralByteString) byteString;
                        if (literalByteString.size() == 0) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (!z) {
                            break;
                        }
                    } else {
                        literalByteString = null;
                        break;
                    }
                }
                this.next = literalByteString;
                return literalByteString2;
            }
            throw new NoSuchElementException();
        }
    }

    public class RopeByteIterator implements ByteIterator {
        public ByteIterator bytes;
        public int bytesRemaining;
        public final PieceIterator pieces;

        public RopeByteIterator(RopeByteString ropeByteString, AnonymousClass1 r3) {
            PieceIterator pieceIterator = new PieceIterator(ropeByteString, null);
            this.pieces = pieceIterator;
            this.bytes = pieceIterator.next().iterator();
            this.bytesRemaining = ropeByteString.totalLength;
        }

        public boolean hasNext() {
            return this.bytesRemaining > 0;
        }

        public Object next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            if (!this.bytes.hasNext()) {
                this.bytes = this.pieces.next().iterator();
            }
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(Integer.MAX_VALUE));
        minLengthByDepth = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i4 < iArr.length) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                i4++;
            } else {
                return;
            }
        }
    }

    public RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = byteString2.size() + size;
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString = byteString instanceof RopeByteString ? (RopeByteString) byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() != 0) {
            int size = byteString2.size() + byteString.size();
            if (size < 128) {
                return concatenateBytes(byteString, byteString2);
            }
            if (ropeByteString != null) {
                if (byteString2.size() + ropeByteString.right.size() < 128) {
                    byteString2 = new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
                }
            }
            if (ropeByteString == null || ropeByteString.left.getTreeDepth() <= ropeByteString.right.getTreeDepth() || ropeByteString.treeDepth <= byteString2.getTreeDepth()) {
                if (size >= minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1]) {
                    return new RopeByteString(byteString, byteString2);
                }
                Balancer balancer = new Balancer(null);
                balancer.doBalance(byteString);
                balancer.doBalance(byteString2);
                ByteString pop = balancer.prefixesStack.pop();
                while (!balancer.prefixesStack.isEmpty()) {
                    pop = new RopeByteString(balancer.prefixesStack.pop(), pop);
                }
                return pop;
            }
            byteString2 = new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
        }
        return byteString2;
    }

    public static LiteralByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            this.left.copyToInternal(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.right.copyToInternal(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.left.copyToInternal(bArr, i, i2, i6);
            this.right.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        if (this.hash != 0) {
            int peekCachedHashCode = byteString.peekCachedHashCode();
            if (!(peekCachedHashCode == 0 || this.hash == peekCachedHashCode)) {
                return false;
            }
        }
        PieceIterator pieceIterator = new PieceIterator(this, null);
        LiteralByteString literalByteString = (LiteralByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString, null);
        LiteralByteString literalByteString2 = (LiteralByteString) pieceIterator2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = literalByteString.size() - i;
            int size2 = literalByteString2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? literalByteString.equalsRange(literalByteString2, i2, min) : literalByteString2.equalsRange(literalByteString, i, min))) {
                z = false;
                break;
            }
            i3 += min;
            int i4 = this.totalLength;
            if (i3 < i4) {
                if (min == size) {
                    literalByteString = (LiteralByteString) pieceIterator.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    literalByteString2 = (LiteralByteString) pieceIterator2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 != i4) {
                throw new IllegalStateException();
            }
        }
        return z;
    }

    public int getTreeDepth() {
        return this.treeDepth;
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int i2 = this.totalLength;
            i = partialHash(i2, 0, i2);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    public boolean isBalanced() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return new RopeByteIterator(this, null);
    }

    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialHash(this.left.partialHash(i, i2, i6), 0, i3 - i6);
    }

    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    public int peekCachedHashCode() {
        return this.hash;
    }

    public int size() {
        return this.totalLength;
    }

    public String toString(String str) throws UnsupportedEncodingException {
        byte[] bArr;
        int i = this.totalLength;
        if (i == 0) {
            bArr = Internal.EMPTY_BYTE_ARRAY;
        } else {
            byte[] bArr2 = new byte[i];
            copyToInternal(bArr2, 0, 0, i);
            bArr = bArr2;
        }
        return new String(bArr, str);
    }

    public void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.leftLength;
        if (i3 <= i4) {
            this.left.writeToInternal(outputStream, i, i2);
        } else if (i >= i4) {
            this.right.writeToInternal(outputStream, i - i4, i2);
        } else {
            int i5 = i4 - i;
            this.left.writeToInternal(outputStream, i, i5);
            this.right.writeToInternal(outputStream, 0, i2 - i5);
        }
    }

    /* renamed from: iterator  reason: collision with other method in class */
    public ByteIterator m968iterator() {
        return new RopeByteIterator(this, null);
    }
}
