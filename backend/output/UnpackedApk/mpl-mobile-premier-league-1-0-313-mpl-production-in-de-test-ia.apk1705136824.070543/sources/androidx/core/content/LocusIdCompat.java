package androidx.core.content;

import android.content.LocusId;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public final class LocusIdCompat {
    public final String mId;
    public final LocusId mWrapped;

    public LocusIdCompat(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mId = str;
            if (VERSION.SDK_INT >= 29) {
                this.mWrapped = new LocusId(str);
            } else {
                this.mWrapped = null;
            }
        } else {
            throw new IllegalArgumentException("id cannot be empty");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.mId;
        if (str != null) {
            return str.equals(locusIdCompat.mId);
        }
        if (locusIdCompat.mId != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.mId;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LocusIdCompat[");
        int length = this.mId.length();
        outline73.append(length + "_chars");
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
