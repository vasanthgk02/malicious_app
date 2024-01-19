package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0019H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00118F¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/facebook/share/model/ShareStoryContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareStoryContent$Builder;", "builder", "(Lcom/facebook/share/model/ShareStoryContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "attributionLink", "", "getAttributionLink", "()Ljava/lang/String;", "backgroundAsset", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAsset", "()Lcom/facebook/share/model/ShareMedia;", "backgroundColorList", "", "getBackgroundColorList", "()Ljava/util/List;", "stickerAsset", "Lcom/facebook/share/model/SharePhoto;", "getStickerAsset", "()Lcom/facebook/share/model/SharePhoto;", "describeContents", "", "readUnmodifiableStringList", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareStoryContent.kt */
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Object> {
    public static final Creator<ShareStoryContent> CREATOR = new ShareStoryContent$Companion$CREATOR$1();
    public final String attributionLink;
    public final ShareMedia<?, ?> backgroundAsset;
    public final List<String> backgroundColorList;
    public final SharePhoto stickerAsset;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareStoryContent(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, "parcel");
        super(parcel);
        this.backgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.stickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.backgroundColorList = arrayList.isEmpty() ? null : ArraysKt___ArraysJvmKt.toList(arrayList);
        this.attributionLink = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [android.os.Parcelable, com.facebook.share.model.ShareMedia<?, ?>] */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.os.Parcelable, com.facebook.share.model.SharePhoto] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1, types: [android.os.Parcelable, com.facebook.share.model.ShareMedia<?, ?>]
      assigns: [com.facebook.share.model.ShareMedia<?, ?>]
      uses: [android.os.Parcelable]
      mth insns count: 14
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
            com.facebook.share.model.ShareMedia<?, ?> r3 = r1.backgroundAsset
            r0 = 0
            r2.writeParcelable(r3, r0)
            com.facebook.share.model.SharePhoto r3 = r1.stickerAsset
            r2.writeParcelable(r3, r0)
            java.util.List<java.lang.String> r3 = r1.backgroundColorList
            if (r3 != 0) goto L_0x0019
            r3 = 0
            goto L_0x001d
        L_0x0019:
            java.util.List r3 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r3)
        L_0x001d:
            r2.writeStringList(r3)
            java.lang.String r3 = r1.attributionLink
            r2.writeString(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.model.ShareStoryContent.writeToParcel(android.os.Parcel, int):void");
    }
}
