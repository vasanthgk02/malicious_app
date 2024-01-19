package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@DoNotStrip
public class MapIteratorHelper {
    @DoNotStrip
    public final Iterator<Entry> mIterator;
    @DoNotStrip
    public Object mKey;
    @DoNotStrip
    public Object mValue;

    @DoNotStrip
    public MapIteratorHelper(Map map) {
        this.mIterator = map.entrySet().iterator();
    }

    @DoNotStrip
    public boolean hasNext() {
        if (this.mIterator.hasNext()) {
            Entry next = this.mIterator.next();
            this.mKey = next.getKey();
            this.mValue = next.getValue();
            return true;
        }
        this.mKey = null;
        this.mValue = null;
        return false;
    }
}
