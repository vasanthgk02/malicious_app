package com.mpl.androidapp.miniprofile.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006#"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/VideoSegments;", "Landroid/os/Parcelable;", "timestamp", "", "title", "", "isSegmentSelected", "", "thumbnail", "(JLjava/lang/String;ZLjava/lang/String;)V", "()Z", "setSegmentSelected", "(Z)V", "getThumbnail", "()Ljava/lang/String;", "getTimestamp", "()J", "getTitle", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSegments.kt */
public final class VideoSegments implements Parcelable {
    public static final android.os.Parcelable.Creator<VideoSegments> CREATOR = new Creator();
    @SerializedName("segmentSelected")
    public boolean isSegmentSelected;
    @SerializedName("thumbnail")
    public final String thumbnail;
    @SerializedName("timestamp")
    public final long timestamp;
    @SerializedName("title")
    public final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoSegments.kt */
    public static final class Creator implements android.os.Parcelable.Creator<VideoSegments> {
        public final VideoSegments createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            VideoSegments videoSegments = new VideoSegments(parcel.readLong(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
            return videoSegments;
        }

        public final VideoSegments[] newArray(int i) {
            return new VideoSegments[i];
        }
    }

    public VideoSegments(long j, String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "thumbnail");
        this.timestamp = j;
        this.title = str;
        this.isSegmentSelected = z;
        this.thumbnail = str2;
    }

    public static /* synthetic */ VideoSegments copy$default(VideoSegments videoSegments, long j, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = videoSegments.timestamp;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = videoSegments.title;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            z = videoSegments.isSegmentSelected;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str2 = videoSegments.thumbnail;
        }
        return videoSegments.copy(j2, str3, z2, str2);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.isSegmentSelected;
    }

    public final String component4() {
        return this.thumbnail;
    }

    public final VideoSegments copy(long j, String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "thumbnail");
        VideoSegments videoSegments = new VideoSegments(j, str, z, str2);
        return videoSegments;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSegments)) {
            return false;
        }
        VideoSegments videoSegments = (VideoSegments) obj;
        return this.timestamp == videoSegments.timestamp && Intrinsics.areEqual(this.title, videoSegments.title) && this.isSegmentSelected == videoSegments.isSegmentSelected && Intrinsics.areEqual(this.thumbnail, videoSegments.thumbnail);
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.title, C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.timestamp) * 31, 31);
        boolean z = this.isSegmentSelected;
        if (z) {
            z = true;
        }
        return this.thumbnail.hashCode() + ((outline11 + (z ? 1 : 0)) * 31);
    }

    public final boolean isSegmentSelected() {
        return this.isSegmentSelected;
    }

    public final void setSegmentSelected(boolean z) {
        this.isSegmentSelected = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("VideoSegments(timestamp=");
        outline73.append(this.timestamp);
        outline73.append(", title=");
        outline73.append(this.title);
        outline73.append(", isSegmentSelected=");
        outline73.append(this.isSegmentSelected);
        outline73.append(", thumbnail=");
        return GeneratedOutlineSupport.outline59(outline73, this.thumbnail, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.title);
        parcel.writeInt(this.isSegmentSelected ? 1 : 0);
        parcel.writeString(this.thumbnail);
    }

    public /* synthetic */ VideoSegments(long j, String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i & 4) != 0 ? false : z, str2);
    }
}
