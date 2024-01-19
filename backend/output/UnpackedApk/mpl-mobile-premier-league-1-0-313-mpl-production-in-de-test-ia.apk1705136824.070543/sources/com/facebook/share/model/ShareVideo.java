package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareMedia.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/facebook/share/model/ShareVideo;", "Lcom/facebook/share/model/ShareMedia;", "Lcom/facebook/share/model/ShareVideo$Builder;", "builder", "(Lcom/facebook/share/model/ShareVideo$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "localUrl", "Landroid/net/Uri;", "getLocalUrl", "()Landroid/net/Uri;", "mediaType", "Lcom/facebook/share/model/ShareMedia$Type;", "getMediaType", "()Lcom/facebook/share/model/ShareMedia$Type;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareVideo.kt */
public final class ShareVideo extends ShareMedia<ShareVideo, Builder> {
    public static final Creator<ShareVideo> CREATOR = new ShareVideo$Companion$CREATOR$1();
    public final Uri localUrl;
    public final Type mediaType = Type.VIDEO;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareVideo$Builder;", "Lcom/facebook/share/model/ShareMedia$Builder;", "Lcom/facebook/share/model/ShareVideo;", "()V", "localUrl", "Landroid/net/Uri;", "getLocalUrl$facebook_common_release", "()Landroid/net/Uri;", "setLocalUrl$facebook_common_release", "(Landroid/net/Uri;)V", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_common_release", "model", "setLocalUrl", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareVideo.kt */
    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder<ShareVideo, Builder> {
        public Uri localUrl;

        public ShareVideo build() {
            return new ShareVideo(this, null);
        }
    }

    public ShareVideo(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        super((com.facebook.share.model.ShareMedia.Builder<M, B>) builder);
        this.localUrl = builder.localUrl;
    }

    public int describeContents() {
        return 0;
    }

    public Type getMediaType() {
        return this.mediaType;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareVideo(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, "parcel");
        super(parcel);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
