package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/LiveStream;", "", "state", "", "(Ljava/lang/String;)V", "getState", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveStream.kt */
public final class LiveStream {
    @SerializedName("state")
    public final String state;

    public LiveStream(String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        this.state = str;
    }

    public static /* synthetic */ LiveStream copy$default(LiveStream liveStream, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveStream.state;
        }
        return liveStream.copy(str);
    }

    public final String component1() {
        return this.state;
    }

    public final LiveStream copy(String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        return new LiveStream(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveStream) && Intrinsics.areEqual(this.state, ((LiveStream) obj).state);
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("LiveStream(state="), this.state, ')');
    }
}
