package com.facebook.common.references;

import java.lang.ref.SoftReference;

public class OOMSoftReference<T> {
    public SoftReference<T> softRef1 = null;
    public SoftReference<T> softRef2 = null;
    public SoftReference<T> softRef3 = null;

    public void clear() {
        SoftReference<T> softReference = this.softRef1;
        if (softReference != null) {
            softReference.clear();
            this.softRef1 = null;
        }
        SoftReference<T> softReference2 = this.softRef2;
        if (softReference2 != null) {
            softReference2.clear();
            this.softRef2 = null;
        }
        SoftReference<T> softReference3 = this.softRef3;
        if (softReference3 != null) {
            softReference3.clear();
            this.softRef3 = null;
        }
    }
}
