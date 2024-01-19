package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001d\u001eB\u000f\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005B\u000f\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0018H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/facebook/share/model/ShareVideoContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareModel;", "builder", "(Lcom/facebook/share/model/ShareVideoContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "contentTitle", "getContentTitle", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto", "()Lcom/facebook/share/model/SharePhoto;", "video", "Lcom/facebook/share/model/ShareVideo;", "getVideo", "()Lcom/facebook/share/model/ShareVideo;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareVideoContent.kt */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements Object {
    public static final Creator<ShareVideoContent> CREATOR = new ShareVideoContent$Companion$CREATOR$1();
    public final String contentDescription;
    public final String contentTitle;
    public final SharePhoto previewPhoto;
    public final ShareVideo video;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0012\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareVideoContent;", "()V", "contentDescription", "", "getContentDescription$facebook_common_release", "()Ljava/lang/String;", "setContentDescription$facebook_common_release", "(Ljava/lang/String;)V", "contentTitle", "getContentTitle$facebook_common_release", "setContentTitle$facebook_common_release", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto$facebook_common_release", "()Lcom/facebook/share/model/SharePhoto;", "setPreviewPhoto$facebook_common_release", "(Lcom/facebook/share/model/SharePhoto;)V", "video", "Lcom/facebook/share/model/ShareVideo;", "getVideo$facebook_common_release", "()Lcom/facebook/share/model/ShareVideo;", "setVideo$facebook_common_release", "(Lcom/facebook/share/model/ShareVideo;)V", "build", "readFrom", "content", "setContentDescription", "setContentTitle", "setPreviewPhoto", "setVideo", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareVideoContent.kt */
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareVideoContent, Builder> {
        public String contentDescription;
        public String contentTitle;
        public SharePhoto previewPhoto;
        public ShareVideo video;
    }

    public ShareVideoContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        super((com.facebook.share.model.ShareContent.Builder<M, B>) builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.previewPhoto = builder.previewPhoto;
        this.video = builder.video;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [android.os.Parcelable, com.facebook.share.model.SharePhoto] */
    /* JADX WARNING: type inference failed for: r3v4, types: [android.os.Parcelable, com.facebook.share.model.ShareVideo] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v3, types: [android.os.Parcelable, com.facebook.share.model.SharePhoto]
      assigns: [com.facebook.share.model.SharePhoto]
      uses: [android.os.Parcelable]
      mth insns count: 11
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(android.os.Parcel r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            super.writeToParcel(r2, r3)
            java.lang.String r3 = r1.contentDescription
            r2.writeString(r3)
            java.lang.String r3 = r1.contentTitle
            r2.writeString(r3)
            com.facebook.share.model.SharePhoto r3 = r1.previewPhoto
            r0 = 0
            r2.writeParcelable(r3, r0)
            com.facebook.share.model.ShareVideo r3 = r1.video
            r2.writeParcelable(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.model.ShareVideoContent.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareVideoContent(Parcel parcel) {
        SharePhoto sharePhoto;
        // Intrinsics.checkNotNullParameter(parcel, "parcel");
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        com.facebook.share.model.SharePhoto.Builder builder = new com.facebook.share.model.SharePhoto.Builder();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        com.facebook.share.model.SharePhoto.Builder readFrom = builder.readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        if (readFrom.imageUrl == null && readFrom.bitmap == null) {
            sharePhoto = null;
        } else {
            sharePhoto = readFrom.build();
        }
        this.previewPhoto = sharePhoto;
        com.facebook.share.model.ShareVideo.Builder builder2 = new com.facebook.share.model.ShareVideo.Builder();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ShareVideo shareVideo = (ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader());
        if (shareVideo != null) {
            builder2.localUrl = shareVideo.localUrl;
        }
        this.video = builder2.build();
    }
}
