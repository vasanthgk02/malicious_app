package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/Highlight;", "", "expireAt", "", "id", "", "streamId", "type", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExpireAt", "()J", "getId", "()Ljava/lang/String;", "getStreamId", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Highlight.kt */
public final class Highlight {
    @SerializedName("expireAt")
    public final long expireAt;
    @SerializedName("id")
    public final String id;
    @SerializedName("streamId")
    public final String streamId;
    @SerializedName("type")
    public final String type;

    public Highlight(long j, String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "id", str2, "streamId", str3, "type");
        this.expireAt = j;
        this.id = str;
        this.streamId = str2;
        this.type = str3;
    }

    public static /* synthetic */ Highlight copy$default(Highlight highlight, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = highlight.expireAt;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = highlight.id;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = highlight.streamId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = highlight.type;
        }
        return highlight.copy(j2, str4, str5, str3);
    }

    public final long component1() {
        return this.expireAt;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.streamId;
    }

    public final String component4() {
        return this.type;
    }

    public final Highlight copy(long j, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "streamId");
        Intrinsics.checkNotNullParameter(str3, "type");
        Highlight highlight = new Highlight(j, str, str2, str3);
        return highlight;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Highlight)) {
            return false;
        }
        Highlight highlight = (Highlight) obj;
        return this.expireAt == highlight.expireAt && Intrinsics.areEqual(this.id, highlight.id) && Intrinsics.areEqual(this.streamId, highlight.streamId) && Intrinsics.areEqual(this.type, highlight.type);
    }

    public final long getExpireAt() {
        return this.expireAt;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStreamId() {
        return this.streamId;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() + GeneratedOutlineSupport.outline11(this.streamId, GeneratedOutlineSupport.outline11(this.id, C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.expireAt) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Highlight(expireAt=");
        outline73.append(this.expireAt);
        outline73.append(", id=");
        outline73.append(this.id);
        outline73.append(", streamId=");
        outline73.append(this.streamId);
        outline73.append(", type=");
        return GeneratedOutlineSupport.outline59(outline73, this.type, ')');
    }
}
