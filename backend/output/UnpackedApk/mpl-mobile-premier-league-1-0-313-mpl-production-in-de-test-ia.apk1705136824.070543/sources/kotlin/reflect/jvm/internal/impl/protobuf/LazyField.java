package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class LazyField extends LazyFieldLite {

    public static class LazyEntry<K> implements Entry<K, Object> {
        public Entry<K, LazyField> entry;

        public LazyEntry(Entry entry2, AnonymousClass1 r2) {
            this.entry = entry2;
        }

        public K getKey() {
            return this.entry.getKey();
        }

        public Object getValue() {
            LazyField value = this.entry.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                LazyField value = this.entry.getValue();
                MessageLite messageLite = value.value;
                value.value = (MessageLite) obj;
                value.bytes = null;
                value.isDirty = true;
                return messageLite;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    public static class LazyIterator<K> implements Iterator<Entry<K, Object>> {
        public Iterator<Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Entry<K, Object>> it) {
            this.iterator = it;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Object next() {
            Entry next = this.iterator.next();
            return next.getValue() instanceof LazyField ? new LazyEntry(next, null) : next;
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public MessageLite getValue() {
        if (this.value == null) {
            synchronized (this) {
                if (this.value == null) {
                    try {
                        if (this.bytes == null) {
                            this.value = null;
                        } else {
                            throw null;
                        }
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return this.value;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
