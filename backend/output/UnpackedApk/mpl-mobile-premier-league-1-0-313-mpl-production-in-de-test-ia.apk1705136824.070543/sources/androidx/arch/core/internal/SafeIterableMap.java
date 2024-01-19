package androidx.arch.core.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.apache.fontbox.cmap.CMapParser;

public class SafeIterableMap<K, V> implements Iterable<java.util.Map.Entry<K, V>> {
    public Entry<K, V> mEnd;
    public WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap<>();
    public int mSize = 0;
    public Entry<K, V> mStart;

    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        public AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        public Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mPrevious;
        }

        public Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mNext;
        }
    }

    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        public Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mNext;
        }

        public Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mPrevious;
        }
    }

    public static class Entry<K, V> implements java.util.Map.Entry<K, V> {
        public final K mKey;
        public Entry<K, V> mNext;
        public Entry<K, V> mPrevious;
        public final V mValue;

        public Entry(K k, V v) {
            this.mKey = k;
            this.mValue = v;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (!this.mKey.equals(entry.mKey) || !this.mValue.equals(entry.mValue)) {
                z = false;
            }
            return z;
        }

        public K getKey() {
            return this.mKey;
        }

        public V getValue() {
            return this.mValue;
        }

        public int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + InflateView.SETTER_EQUALS + this.mValue;
        }
    }

    public class IteratorWithAdditions implements Iterator<java.util.Map.Entry<K, V>>, SupportRemove<K, V> {
        public boolean mBeforeStart = true;
        public Entry<K, V> mCurrent;

        public IteratorWithAdditions() {
        }

        public boolean hasNext() {
            boolean z = true;
            if (this.mBeforeStart) {
                if (SafeIterableMap.this.mStart == null) {
                    z = false;
                }
                return z;
            }
            Entry<K, V> entry = this.mCurrent;
            if (entry == null || entry.mNext == null) {
                z = false;
            }
            return z;
        }

        public Object next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.mStart;
            } else {
                Entry<K, V> entry = this.mCurrent;
                this.mCurrent = entry != null ? entry.mNext : null;
            }
            return this.mCurrent;
        }

        public void supportRemove(Entry<K, V> entry) {
            Entry<K, V> entry2 = this.mCurrent;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                this.mBeforeStart = entry3 == null;
            }
        }
    }

    public static abstract class ListIterator<K, V> implements Iterator<java.util.Map.Entry<K, V>>, SupportRemove<K, V> {
        public Entry<K, V> mExpectedEnd;
        public Entry<K, V> mNext;

        public ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        public abstract Entry<K, V> backward(Entry<K, V> entry);

        public abstract Entry<K, V> forward(Entry<K, V> entry);

        public boolean hasNext() {
            return this.mNext != null;
        }

        public Object next() {
            Entry<K, V> entry = this.mNext;
            Entry<K, V> entry2 = this.mExpectedEnd;
            this.mNext = (entry == entry2 || entry2 == null) ? null : forward(entry);
            return entry;
        }

        public void supportRemove(Entry<K, V> entry) {
            Entry<K, V> entry2 = null;
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            Entry<K, V> entry3 = this.mExpectedEnd;
            if (entry3 == entry) {
                this.mExpectedEnd = backward(entry3);
            }
            Entry<K, V> entry4 = this.mNext;
            if (entry4 == entry) {
                Entry<K, V> entry5 = this.mExpectedEnd;
                if (!(entry4 == entry5 || entry5 == null)) {
                    entry2 = forward(entry4);
                }
                this.mNext = entry2;
            }
        }
    }

    public interface SupportRemove<K, V> {
        void supportRemove(Entry<K, V> entry);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (((androidx.arch.core.internal.SafeIterableMap.ListIterator) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof androidx.arch.core.internal.SafeIterableMap
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            androidx.arch.core.internal.SafeIterableMap r7 = (androidx.arch.core.internal.SafeIterableMap) r7
            int r1 = r6.mSize
            int r3 = r7.mSize
            if (r1 == r3) goto L_0x0013
            return r2
        L_0x0013:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x001b:
            r3 = r1
            androidx.arch.core.internal.SafeIterableMap$ListIterator r3 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0044
            r4 = r7
            androidx.arch.core.internal.SafeIterableMap$ListIterator r4 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0044
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L_0x003b
            if (r4 != 0) goto L_0x0043
        L_0x003b:
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x001b
        L_0x0043:
            return r2
        L_0x0044:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L_0x0053
            androidx.arch.core.internal.SafeIterableMap$ListIterator r7 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.arch.core.internal.SafeIterableMap.equals(java.lang.Object):boolean");
    }

    public Entry<K, V> get(K k) {
        Entry<K, V> entry = this.mStart;
        while (entry != null && !entry.mKey.equals(k)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (!listIterator.hasNext()) {
                return i;
            }
            i += ((java.util.Map.Entry) listIterator.next()).hashCode();
        }
    }

    public Iterator<java.util.Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public IteratorWithAdditions iteratorWithAdditions() {
        IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions<>();
        this.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Entry<K, V> put(K k, V v) {
        Entry<K, V> entry = new Entry<>(k, v);
        this.mSize++;
        Entry<K, V> entry2 = this.mEnd;
        if (entry2 == null) {
            this.mStart = entry;
            this.mEnd = entry;
            return entry;
        }
        entry2.mNext = entry;
        entry.mPrevious = entry2;
        this.mEnd = entry;
        return entry;
    }

    public V putIfAbsent(K k, V v) {
        Entry entry = get(k);
        if (entry != null) {
            return entry.mValue;
        }
        put(k, v);
        return null;
    }

    public V remove(K k) {
        Entry entry = get(k);
        if (entry == null) {
            return null;
        }
        this.mSize--;
        if (!this.mIterators.isEmpty()) {
            for (SupportRemove<K, V> supportRemove : this.mIterators.keySet()) {
                supportRemove.supportRemove(entry);
            }
        }
        Entry<K, V> entry2 = entry.mPrevious;
        if (entry2 != null) {
            entry2.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        Entry<K, V> entry3 = entry.mNext;
        if (entry3 != null) {
            entry3.mPrevious = entry.mPrevious;
        } else {
            this.mEnd = entry.mPrevious;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        Iterator it = iterator();
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (listIterator.hasNext()) {
                outline73.append(((java.util.Map.Entry) listIterator.next()).toString());
                if (listIterator.hasNext()) {
                    outline73.append(", ");
                }
            } else {
                outline73.append(CMapParser.MARK_END_OF_ARRAY);
                return outline73.toString();
            }
        }
    }
}
