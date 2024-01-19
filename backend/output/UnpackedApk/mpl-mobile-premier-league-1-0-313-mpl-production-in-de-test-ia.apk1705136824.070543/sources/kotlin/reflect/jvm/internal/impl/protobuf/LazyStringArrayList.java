package kotlin.reflect.jvm.internal.impl.protobuf;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList EMPTY = new UnmodifiableLazyStringList(new LazyStringArrayList());
    public final List<Object> list;

    public LazyStringArrayList() {
        this.list = new ArrayList();
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
        this.list.add(i, (String) obj);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public void clear() {
        this.list.clear();
        this.modCount++;
    }

    public Object get(int i) {
        String str;
        Object obj = this.list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            str = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.list.set(i, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            str = Internal.toStringUtf8(bArr);
            if (TweetUtils.isValidUtf8(bArr, 0, bArr.length)) {
                this.list.set(i, str);
            }
        }
        return str;
    }

    public ByteString getByteString(int i) {
        ByteString byteString;
        Object obj = this.list.get(i);
        if (obj instanceof ByteString) {
            byteString = (ByteString) obj;
        } else if (obj instanceof String) {
            byteString = ByteString.copyFromUtf8((String) obj);
        } else {
            byteString = ByteString.copyFrom((byte[]) obj);
        }
        if (byteString != obj) {
            this.list.set(i, byteString);
        }
        return byteString;
    }

    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }

    public Object remove(int i) {
        Object remove = this.list.remove(i);
        this.modCount++;
        return asString(remove);
    }

    public Object set(int i, Object obj) {
        return asString(this.list.set(i, (String) obj));
    }

    public int size() {
        return this.list.size();
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.list.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.list = new ArrayList(lazyStringList.size());
        addAll(size(), lazyStringList);
    }

    public void add(ByteString byteString) {
        this.list.add(byteString);
        this.modCount++;
    }
}
