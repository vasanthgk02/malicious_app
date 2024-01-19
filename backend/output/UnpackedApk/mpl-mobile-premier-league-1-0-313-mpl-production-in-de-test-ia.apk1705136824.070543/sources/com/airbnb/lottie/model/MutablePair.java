package com.airbnb.lottie.model;

import androidx.core.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMap;

public class MutablePair<T> {
    public T first;
    public T second;

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f2 = pair.first;
        T t = this.first;
        if (f2 == t || (f2 != null && f2.equals(t))) {
            S s = pair.second;
            T t2 = this.second;
            if (s == t2 || (s != null && s.equals(t2))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        T t = this.first;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.second;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Pair{");
        outline73.append(String.valueOf(this.first));
        outline73.append(CMap.SPACE);
        outline73.append(String.valueOf(this.second));
        outline73.append("}");
        return outline73.toString();
    }
}
