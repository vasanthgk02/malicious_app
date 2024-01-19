package androidx.datastore.preferences.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    public static final ByteArrayCopier byteArrayCopier = (Android.isOnAndroidDevice() ? new SystemByteArrayCopier(null) : new ArraysByteArrayCopier(null));
    public int hash = 0;

    public static abstract class AbstractByteIterator implements Iterator {
        public Object next() {
            return Byte.valueOf(((AnonymousClass1) this).nextByte());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        public ArraysByteArrayCopier(AnonymousClass1 r1) {
        }

        public byte[] copyFrom(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i, int i2);
    }

    public static final class CodedBuilder {
        public final byte[] buffer;
        public final CodedOutputStream output;

        public CodedBuilder(int i, AnonymousClass1 r2) {
            byte[] bArr = new byte[i];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }

        public ByteString build() {
            if (this.output.spaceLeft() == 0) {
                return new LiteralByteString(this.buffer);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static abstract class LeafByteString extends ByteString {
        public Iterator iterator() {
            return new AbstractByteIterator() {
                public final int limit = ByteString.this.size();
                public int position = 0;

                public boolean hasNext() {
                    return this.position < this.limit;
                }

                public byte nextByte() {
                    int i = this.position;
                    if (i < this.limit) {
                        this.position = i + 1;
                        return ByteString.this.internalByteAt(i);
                    }
                    throw new NoSuchElementException();
                }
            };
        }
    }

    public static class LiteralByteString extends LeafByteString {
        public static final long serialVersionUID = 1;
        public final byte[] bytes;

        public LiteralByteString(byte[] bArr) {
            if (bArr != null) {
                this.bytes = bArr;
                return;
            }
            throw null;
        }

        public byte byteAt(int i) {
            return this.bytes[i];
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int i = this.hash;
            int i2 = literalByteString.hash;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
            int size = size();
            if (size > literalByteString.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= literalByteString.size()) {
                byte[] bArr = this.bytes;
                byte[] bArr2 = literalByteString.bytes;
                int offsetIntoBytes = getOffsetIntoBytes() + size;
                int offsetIntoBytes2 = getOffsetIntoBytes();
                int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + 0;
                while (true) {
                    if (offsetIntoBytes2 >= offsetIntoBytes) {
                        break;
                    } else if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                        z = false;
                        break;
                    } else {
                        offsetIntoBytes2++;
                        offsetIntoBytes3++;
                    }
                }
                return z;
            } else {
                StringBuilder outline75 = GeneratedOutlineSupport.outline75("Ran off end of other: ", 0, ", ", size, ", ");
                outline75.append(literalByteString.size());
                throw new IllegalArgumentException(outline75.toString());
            }
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        public byte internalByteAt(int i) {
            return this.bytes[i];
        }

        public int size() {
            return this.bytes.length;
        }
    }

    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        public SystemByteArrayCopier(AnonymousClass1 r1) {
        }

        public byte[] copyFrom(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    public static int checkRange(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline42("Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("End index: ", i2, " >= ", i3));
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        checkRange(i, i + i2, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i, i2));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.UTF_8));
    }

    public static CodedBuilder newCodedBuilder(int i) {
        return new CodedBuilder(i, null);
    }

    public static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public abstract byte byteAt(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int size = size();
            LiteralByteString literalByteString = (LiteralByteString) this;
            i = Internal.partialHash(size, literalByteString.bytes, literalByteString.getOffsetIntoBytes() + 0, size);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    public abstract byte internalByteAt(int i);

    public Iterator iterator() {
        return new AbstractByteIterator() {
            public final int limit = ByteString.this.size();
            public int position = 0;

            public boolean hasNext() {
                return this.position < this.limit;
            }

            public byte nextByte() {
                int i = this.position;
                if (i < this.limit) {
                    this.position = i + 1;
                    return ByteString.this.internalByteAt(i);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public final String toStringUtf8() {
        Charset charset = Internal.UTF_8;
        if (size() == 0) {
            return "";
        }
        LiteralByteString literalByteString = (LiteralByteString) this;
        return new String(literalByteString.bytes, literalByteString.getOffsetIntoBytes(), literalByteString.size(), charset);
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }
}
