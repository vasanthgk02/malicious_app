package com.bumptech.glide.util;

import com.android.tools.r8.GeneratedOutlineSupport;

public class MultiClassKey {
    public Class<?> first;
    public Class<?> second;
    public Class<?> third;

    public MultiClassKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MultiClassKey.class != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second) && Util.bothNullOrEqual(this.third, multiClassKey.third);
    }

    public int hashCode() {
        int hashCode = (this.second.hashCode() + (this.first.hashCode() * 31)) * 31;
        Class<?> cls = this.third;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MultiClassKey{first=");
        outline73.append(this.first);
        outline73.append(", second=");
        outline73.append(this.second);
        outline73.append('}');
        return outline73.toString();
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.first = cls;
        this.second = cls2;
        this.third = cls3;
    }
}
