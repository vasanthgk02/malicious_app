package androidx.core.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Objects;
import org.apache.fontbox.cmap.CMap;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f2, S s) {
        this.first = f2;
        this.second = s;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (Objects.equals(pair.first, this.first) && Objects.equals(pair.second, this.second)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        F f2 = this.first;
        int i = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.second;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Pair{");
        outline73.append(this.first);
        outline73.append(CMap.SPACE);
        outline73.append(this.second);
        outline73.append("}");
        return outline73.toString();
    }
}
