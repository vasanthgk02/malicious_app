package com.badlogic.gdx.graphics;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.fontbox.cmap.CMapParser;

public final class VertexAttributes implements Iterable<VertexAttribute>, Comparable<VertexAttributes> {
    public final VertexAttribute[] attributes;
    public ReadonlyIterable<VertexAttribute> iterable;
    public long mask = -1;
    public final int vertexSize;

    public static class ReadonlyIterable<T> implements Iterable<T> {
        public final T[] array;
        public ReadonlyIterator iterator1;
        public ReadonlyIterator iterator2;

        public ReadonlyIterable(T[] tArr) {
            this.array = tArr;
        }

        public Iterator<T> iterator() {
            if (this.iterator1 == null) {
                this.iterator1 = new ReadonlyIterator(this.array);
                this.iterator2 = new ReadonlyIterator(this.array);
            }
            ReadonlyIterator readonlyIterator = this.iterator1;
            if (!readonlyIterator.valid) {
                readonlyIterator.index = 0;
                readonlyIterator.valid = true;
                this.iterator2.valid = false;
                return readonlyIterator;
            }
            ReadonlyIterator readonlyIterator2 = this.iterator2;
            readonlyIterator2.index = 0;
            readonlyIterator2.valid = true;
            readonlyIterator.valid = false;
            return readonlyIterator2;
        }
    }

    public static class ReadonlyIterator<T> implements Iterator<T>, Iterable<T> {
        public final T[] array;
        public int index;
        public boolean valid = true;

        public ReadonlyIterator(T[] tArr) {
            this.array = tArr;
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.index < this.array.length;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator<T> iterator() {
            return this;
        }

        public T next() {
            int i = this.index;
            T[] tArr = this.array;
            if (i >= tArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            } else if (this.valid) {
                this.index = i + 1;
                return tArr[i];
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            throw new GdxRuntimeException((String) "Remove not allowed.");
        }

        public void reset() {
            this.index = 0;
        }
    }

    public static final class Usage {
        public static final int BiNormal = 256;
        public static final int BoneWeight = 64;
        public static final int ColorPacked = 4;
        public static final int ColorUnpacked = 2;
        public static final int Generic = 32;
        public static final int Normal = 8;
        public static final int Position = 1;
        public static final int Tangent = 128;
        public static final int TextureCoordinates = 16;
    }

    public VertexAttributes(VertexAttribute... vertexAttributeArr) {
        if (vertexAttributeArr.length != 0) {
            VertexAttribute[] vertexAttributeArr2 = new VertexAttribute[vertexAttributeArr.length];
            for (int i = 0; i < vertexAttributeArr.length; i++) {
                vertexAttributeArr2[i] = vertexAttributeArr[i];
            }
            this.attributes = vertexAttributeArr2;
            this.vertexSize = calculateOffsets();
            return;
        }
        throw new IllegalArgumentException("attributes must be >= 1");
    }

    private int calculateOffsets() {
        int i = 0;
        int i2 = 0;
        while (true) {
            VertexAttribute[] vertexAttributeArr = this.attributes;
            if (i >= vertexAttributeArr.length) {
                return i2;
            }
            VertexAttribute vertexAttribute = vertexAttributeArr[i];
            vertexAttribute.offset = i2;
            i2 += vertexAttribute.getSizeInBytes();
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VertexAttributes)) {
            return false;
        }
        VertexAttributes vertexAttributes = (VertexAttributes) obj;
        if (this.attributes.length != vertexAttributes.attributes.length) {
            return false;
        }
        int i = 0;
        while (true) {
            VertexAttribute[] vertexAttributeArr = this.attributes;
            if (i >= vertexAttributeArr.length) {
                return true;
            }
            if (!vertexAttributeArr[i].equals(vertexAttributes.attributes[i])) {
                return false;
            }
            i++;
        }
    }

    public VertexAttribute findByUsage(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (get(i2).usage == i) {
                return get(i2);
            }
        }
        return null;
    }

    public VertexAttribute get(int i) {
        return this.attributes[i];
    }

    public long getMask() {
        if (this.mask == -1) {
            long j = 0;
            int i = 0;
            while (true) {
                VertexAttribute[] vertexAttributeArr = this.attributes;
                if (i >= vertexAttributeArr.length) {
                    break;
                }
                j |= (long) vertexAttributeArr[i].usage;
                i++;
            }
            this.mask = j;
        }
        return this.mask;
    }

    public long getMaskWithSizePacked() {
        return getMask() | (((long) this.attributes.length) << 32);
    }

    public int getOffset(int i, int i2) {
        VertexAttribute findByUsage = findByUsage(i);
        if (findByUsage == null) {
            return i2;
        }
        return findByUsage.offset / 4;
    }

    public int hashCode() {
        long length = (long) (this.attributes.length * 61);
        int i = 0;
        while (true) {
            VertexAttribute[] vertexAttributeArr = this.attributes;
            if (i >= vertexAttributeArr.length) {
                return (int) (length ^ (length >> 32));
            }
            length = (length * 61) + ((long) vertexAttributeArr[i].hashCode());
            i++;
        }
    }

    public Iterator<VertexAttribute> iterator() {
        if (this.iterable == null) {
            this.iterable = new ReadonlyIterable<>(this.attributes);
        }
        return this.iterable.iterator();
    }

    public int size() {
        return this.attributes.length;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        for (int i = 0; i < this.attributes.length; i++) {
            outline73.append("(");
            outline73.append(this.attributes[i].alias);
            outline73.append(", ");
            outline73.append(this.attributes[i].usage);
            outline73.append(", ");
            outline73.append(this.attributes[i].numComponents);
            outline73.append(", ");
            outline73.append(this.attributes[i].offset);
            outline73.append(")");
            outline73.append("\n");
        }
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public int compareTo(VertexAttributes vertexAttributes) {
        VertexAttribute[] vertexAttributeArr = this.attributes;
        int length = vertexAttributeArr.length;
        VertexAttribute[] vertexAttributeArr2 = vertexAttributes.attributes;
        if (length != vertexAttributeArr2.length) {
            return vertexAttributeArr.length - vertexAttributeArr2.length;
        }
        int i = -1;
        int i2 = (getMask() > vertexAttributes.getMask() ? 1 : (getMask() == vertexAttributes.getMask() ? 0 : -1));
        if (i2 != 0) {
            if (i2 >= 0) {
                i = 1;
            }
            return i;
        }
        for (int length2 = this.attributes.length - 1; length2 >= 0; length2--) {
            VertexAttribute vertexAttribute = this.attributes[length2];
            VertexAttribute vertexAttribute2 = vertexAttributes.attributes[length2];
            int i3 = vertexAttribute.usage;
            int i4 = vertexAttribute2.usage;
            if (i3 != i4) {
                return i3 - i4;
            }
            int i5 = vertexAttribute.unit;
            int i6 = vertexAttribute2.unit;
            if (i5 != i6) {
                return i5 - i6;
            }
            int i7 = vertexAttribute.numComponents;
            int i8 = vertexAttribute2.numComponents;
            if (i7 != i8) {
                return i7 - i8;
            }
            boolean z = vertexAttribute.normalized;
            if (z != vertexAttribute2.normalized) {
                if (z) {
                    i = 1;
                }
                return i;
            }
            int i9 = vertexAttribute.type;
            int i10 = vertexAttribute2.type;
            if (i9 != i10) {
                return i9 - i10;
            }
        }
        return 0;
    }

    public int getOffset(int i) {
        return getOffset(i, 0);
    }
}
