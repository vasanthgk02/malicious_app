package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString.LiteralByteString;
import androidx.datastore.preferences.protobuf.Internal.ProtobufList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringArrayList EMPTY_LIST;
    public final List<Object> list;

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(10);
        EMPTY_LIST = lazyStringArrayList;
        lazyStringArrayList.isMutable = false;
    }

    public LazyStringArrayList(int i) {
        this.list = new ArrayList(i);
    }

    public static String asString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    public void add(int i, Object obj) {
        ensureIsMutable();
        this.list.add(i, (String) obj);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public void clear() {
        ensureIsMutable();
        this.list.clear();
        this.modCount++;
    }

    public Object get(int i) {
        String str;
        Object obj = this.list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        boolean z = true;
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            str = byteString.toStringUtf8();
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            int offsetIntoBytes = literalByteString.getOffsetIntoBytes();
            if (Utf8.processor.partialIsValidUtf8(0, literalByteString.bytes, offsetIntoBytes, literalByteString.size() + offsetIntoBytes) != 0) {
                z = false;
            }
            if (z) {
                this.list.set(i, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            str = Internal.toStringUtf8(bArr);
            if (Utf8.processor.partialIsValidUtf8(0, bArr, 0, bArr.length) != 0) {
                z = false;
            }
            if (z) {
                this.list.set(i, str);
            }
        }
        return str;
    }

    public Object getRaw(int i) {
        return this.list.get(i);
    }

    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    public LazyStringList getUnmodifiableView() {
        return this.isMutable ? new UnmodifiableLazyStringList(this) : this;
    }

    public ProtobufList mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.list);
            return new LazyStringArrayList(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public Object remove(int i) {
        ensureIsMutable();
        Object remove = this.list.remove(i);
        this.modCount++;
        return asString(remove);
    }

    public Object set(int i, Object obj) {
        ensureIsMutable();
        return asString(this.list.set(i, (String) obj));
    }

    public int size() {
        return this.list.size();
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.list.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public LazyStringArrayList(ArrayList<Object> arrayList) {
        this.list = arrayList;
    }

    public void add(ByteString byteString) {
        ensureIsMutable();
        this.list.add(byteString);
        this.modCount++;
    }
}