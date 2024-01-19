package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareMediaContent$Builder;", "builder", "(Lcom/facebook/share/model/ShareMediaContent$Builder;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "media", "", "Lcom/facebook/share/model/ShareMedia;", "getMedia", "()Ljava/util/List;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareMediaContent.kt */
public final class ShareMediaContent extends ShareContent<ShareMediaContent, Object> {
    public static final Creator<ShareMediaContent> CREATOR = new ShareMediaContent$Companion$CREATOR$1();
    public final List<ShareMedia<?, ?>> media;

    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.util.List<com.facebook.share.model.ShareMedia<?, ?>>] */
    /* JADX WARNING: type inference failed for: r5v4, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShareMediaContent(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r4.<init>(r5)
            java.lang.Class<com.facebook.share.model.ShareMedia> r0 = com.facebook.share.model.ShareMedia.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable[] r5 = r5.readParcelableArray(r0)
            if (r5 != 0) goto L_0x0016
            r5 = 0
            goto L_0x002c
        L_0x0016:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r5.length
            r2 = 0
        L_0x001d:
            if (r2 >= r1) goto L_0x002b
            r3 = r5[r2]
            com.facebook.share.model.ShareMedia r3 = (com.facebook.share.model.ShareMedia) r3
            if (r3 == 0) goto L_0x0028
            r0.add(r3)
        L_0x0028:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x002b:
            r5 = r0
        L_0x002c:
            if (r5 != 0) goto L_0x0030
            kotlin.collections.EmptyList r5 = kotlin.collections.EmptyList.INSTANCE
        L_0x0030:
            r4.media = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.model.ShareMediaContent.<init>(android.os.Parcel):void");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        Object[] array = this.media.toArray(new ShareMedia[0]);
        if (array != null) {
            parcel.writeParcelableArray((Parcelable[]) array, i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
