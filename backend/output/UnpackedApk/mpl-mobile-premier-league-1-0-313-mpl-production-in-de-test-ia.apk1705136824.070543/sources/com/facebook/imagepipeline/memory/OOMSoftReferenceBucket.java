package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.lang.ref.SoftReference;
import java.util.LinkedList;

public class OOMSoftReferenceBucket<V> extends Bucket<V> {
    public LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList<>();

    public OOMSoftReferenceBucket(int i, int i2, int i3) {
        super(i, i2, i3, false);
    }

    public void addToFreeList(V v) {
        OOMSoftReference poll = this.mSpareReferences.poll();
        if (poll == null) {
            poll = new OOMSoftReference();
        }
        poll.softRef1 = new SoftReference<>(v);
        poll.softRef2 = new SoftReference<>(v);
        poll.softRef3 = new SoftReference<>(v);
        this.mFreeList.add(poll);
    }

    public V pop() {
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.mFreeList.poll();
        SoftReference softReference = oOMSoftReference.softRef1;
        V v = softReference == null ? null : softReference.get();
        oOMSoftReference.clear();
        this.mSpareReferences.add(oOMSoftReference);
        return v;
    }
}
