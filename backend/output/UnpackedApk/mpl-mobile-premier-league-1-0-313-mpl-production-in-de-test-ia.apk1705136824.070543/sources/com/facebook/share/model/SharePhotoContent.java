package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/model/SharePhotoContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/SharePhotoContent$Builder;", "builder", "(Lcom/facebook/share/model/SharePhotoContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "photos", "", "Lcom/facebook/share/model/SharePhoto;", "getPhotos", "()Ljava/util/List;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SharePhotoContent.kt */
public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Creator<SharePhotoContent> CREATOR = new SharePhotoContent$Companion$CREATOR$1();
    public final List<SharePhoto> photos;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u000b\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0010\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/SharePhotoContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/SharePhotoContent;", "()V", "photos", "", "Lcom/facebook/share/model/SharePhoto;", "getPhotos$facebook_common_release", "()Ljava/util/List;", "addPhoto", "photo", "addPhotos", "", "build", "readFrom", "content", "setPhotos", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SharePhotoContent.kt */
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<SharePhotoContent, Builder> {
        public final List<SharePhoto> photos = new ArrayList();

        public final Builder addPhotos(List<SharePhoto> list) {
            if (list != null) {
                for (SharePhoto next : list) {
                    if (next != null) {
                        this.photos.add(new com.facebook.share.model.SharePhoto.Builder().readFrom(next).build());
                    }
                }
            }
            return this;
        }
    }

    public SharePhotoContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        super((com.facebook.share.model.ShareContent.Builder<M, B>) builder);
        this.photos = ArraysKt___ArraysJvmKt.toList(builder.photos);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [android.os.Parcelable[], com.facebook.share.model.SharePhoto[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v5, types: [android.os.Parcelable[], com.facebook.share.model.SharePhoto[]]
      assigns: [com.facebook.share.model.SharePhoto[]]
      uses: [android.os.Parcelable[]]
      mth insns count: 13
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            super.writeToParcel(r3, r4)
            java.util.List<com.facebook.share.model.SharePhoto> r1 = r2.photos
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "photos"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 0
            com.facebook.share.model.SharePhoto[] r0 = new com.facebook.share.model.SharePhoto[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            if (r0 == 0) goto L_0x0021
            com.facebook.share.model.SharePhoto[] r0 = (com.facebook.share.model.SharePhoto[]) r0
            r3.writeParcelableArray(r0, r4)
            return
        L_0x0021:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T>"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.model.SharePhotoContent.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SharePhotoContent(Parcel parcel) {
        Iterable iterable;
        // Intrinsics.checkNotNullParameter(parcel, "parcel");
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
        if (readParcelableArray == null) {
            iterable = EmptyList.INSTANCE;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : readParcelableArray) {
                if (parcelable instanceof ShareMedia) {
                    arrayList.add(parcelable);
                }
            }
            iterable = arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next : iterable) {
            if (next instanceof SharePhoto) {
                arrayList2.add(next);
            }
        }
        this.photos = ArraysKt___ArraysJvmKt.toList(arrayList2);
    }
}
