package com.google.firebase.heartbeatinfo;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public final class AutoValue_HeartBeatResult extends HeartBeatResult {
    public final List<String> usedDates;
    public final String userAgent;

    public AutoValue_HeartBeatResult(String str, List<String> list) {
        if (str != null) {
            this.userAgent = str;
            if (list != null) {
                this.usedDates = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        AutoValue_HeartBeatResult autoValue_HeartBeatResult = (AutoValue_HeartBeatResult) ((HeartBeatResult) obj);
        if (!this.userAgent.equals(autoValue_HeartBeatResult.userAgent) || !this.usedDates.equals(autoValue_HeartBeatResult.usedDates)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.userAgent.hashCode() ^ 1000003) * 1000003) ^ this.usedDates.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HeartBeatResult{userAgent=");
        outline73.append(this.userAgent);
        outline73.append(", usedDates=");
        return GeneratedOutlineSupport.outline64(outline73, this.usedDates, "}");
    }
}
