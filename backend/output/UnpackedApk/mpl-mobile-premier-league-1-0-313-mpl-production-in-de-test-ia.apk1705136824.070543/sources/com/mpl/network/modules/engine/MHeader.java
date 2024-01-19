package com.mpl.network.modules.engine;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Keep
public final class MHeader {
    public String mKey;
    public String mValue;

    public MHeader(String str, String str2) {
        this.mKey = str;
        this.mValue = str2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MHeader)) {
            return false;
        }
        MHeader mHeader = (MHeader) obj;
        if (TextUtils.isEmpty(this.mKey) || !this.mKey.equals(mHeader.mKey) || TextUtils.isEmpty(this.mValue) || !this.mValue.equals(mHeader.mKey)) {
            z = false;
        }
        return z;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MHeader{Key='");
        GeneratedOutlineSupport.outline99(outline73, this.mKey, ExtendedMessageFormat.QUOTE, ", Value='");
        return GeneratedOutlineSupport.outline60(outline73, this.mValue, ExtendedMessageFormat.QUOTE, '}');
    }
}
