package com.netcore.android.notification.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u0000 82\u00020\u0001:\u00018BA\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b5\u00106B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b5\u00107J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJV\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000eJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\nJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R$\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010%R$\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\"\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010%R$\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\"\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010%R$\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\"\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010%R\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010,\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010/R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\"\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010%R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010\n\"\u0004\b4\u0010/¨\u00069"}, d2 = {"Lcom/netcore/android/notification/models/SMTCarouselItemData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "id", "imgTitle", "imgMsg", "imgUrl", "imgDeeplink", "mMediaLocalPath", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/netcore/android/notification/models/SMTCarouselItemData;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImgDeeplink", "setImgDeeplink", "(Ljava/lang/String;)V", "getImgMsg", "setImgMsg", "getMMediaLocalPath", "setMMediaLocalPath", "getImgTitle", "setImgTitle", "I", "getId", "setId", "(I)V", "getImgUrl", "setImgUrl", "mDownloadStatus", "getMDownloadStatus", "setMDownloadStatus", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTCarouselItemData.kt */
public final class SMTCarouselItemData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    public int id;
    public String imgDeeplink;
    public String imgMsg;
    public String imgTitle;
    public String imgUrl;
    public int mDownloadStatus;
    public String mMediaLocalPath;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/notification/models/SMTCarouselItemData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/netcore/android/notification/models/SMTCarouselItemData;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/netcore/android/notification/models/SMTCarouselItemData;", "", "size", "", "newArray", "(I)[Lcom/netcore/android/notification/models/SMTCarouselItemData;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTCarouselItemData.kt */
    public static final class CREATOR implements Creator<SMTCarouselItemData> {
        public CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public SMTCarouselItemData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SMTCarouselItemData(parcel);
        }

        public SMTCarouselItemData[] newArray(int i) {
            return new SMTCarouselItemData[i];
        }
    }

    public SMTCarouselItemData(int i, String str, String str2, String str3, String str4, String str5) {
        this.id = i;
        this.imgTitle = str;
        this.imgMsg = str2;
        this.imgUrl = str3;
        this.imgDeeplink = str4;
        this.mMediaLocalPath = str5;
    }

    public static /* synthetic */ SMTCarouselItemData copy$default(SMTCarouselItemData sMTCarouselItemData, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sMTCarouselItemData.id;
        }
        if ((i2 & 2) != 0) {
            str = sMTCarouselItemData.imgTitle;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = sMTCarouselItemData.imgMsg;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = sMTCarouselItemData.imgUrl;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = sMTCarouselItemData.imgDeeplink;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = sMTCarouselItemData.mMediaLocalPath;
        }
        return sMTCarouselItemData.copy(i, str6, str7, str8, str9, str5);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.imgTitle;
    }

    public final String component3() {
        return this.imgMsg;
    }

    public final String component4() {
        return this.imgUrl;
    }

    public final String component5() {
        return this.imgDeeplink;
    }

    public final String component6() {
        return this.mMediaLocalPath;
    }

    public final SMTCarouselItemData copy(int i, String str, String str2, String str3, String str4, String str5) {
        SMTCarouselItemData sMTCarouselItemData = new SMTCarouselItemData(i, str, str2, str3, str4, str5);
        return sMTCarouselItemData;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.mMediaLocalPath, r3.mMediaLocalPath) != false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0043
            boolean r0 = r3 instanceof com.netcore.android.notification.models.SMTCarouselItemData
            if (r0 == 0) goto L_0x0041
            com.netcore.android.notification.models.SMTCarouselItemData r3 = (com.netcore.android.notification.models.SMTCarouselItemData) r3
            int r0 = r2.id
            int r1 = r3.id
            if (r0 != r1) goto L_0x0041
            java.lang.String r0 = r2.imgTitle
            java.lang.String r1 = r3.imgTitle
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r2.imgMsg
            java.lang.String r1 = r3.imgMsg
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r2.imgUrl
            java.lang.String r1 = r3.imgUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r2.imgDeeplink
            java.lang.String r1 = r3.imgDeeplink
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r2.mMediaLocalPath
            java.lang.String r3 = r3.mMediaLocalPath
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r3 = 0
            return r3
        L_0x0043:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.notification.models.SMTCarouselItemData.equals(java.lang.Object):boolean");
    }

    public final int getId() {
        return this.id;
    }

    public final String getImgDeeplink() {
        return this.imgDeeplink;
    }

    public final String getImgMsg() {
        return this.imgMsg;
    }

    public final String getImgTitle() {
        return this.imgTitle;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final int getMDownloadStatus() {
        return this.mDownloadStatus;
    }

    public final String getMMediaLocalPath() {
        return this.mMediaLocalPath;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.imgTitle;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imgMsg;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imgUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imgDeeplink;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mMediaLocalPath;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setImgDeeplink(String str) {
        this.imgDeeplink = str;
    }

    public final void setImgMsg(String str) {
        this.imgMsg = str;
    }

    public final void setImgTitle(String str) {
        this.imgTitle = str;
    }

    public final void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public final void setMDownloadStatus(int i) {
        this.mDownloadStatus = i;
    }

    public final void setMMediaLocalPath(String str) {
        this.mMediaLocalPath = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SMTCarouselItemData(id=");
        outline73.append(this.id);
        outline73.append(", imgTitle=");
        outline73.append(this.imgTitle);
        outline73.append(", imgMsg=");
        outline73.append(this.imgMsg);
        outline73.append(", imgUrl=");
        outline73.append(this.imgUrl);
        outline73.append(", imgDeeplink=");
        outline73.append(this.imgDeeplink);
        outline73.append(", mMediaLocalPath=");
        return GeneratedOutlineSupport.outline62(outline73, this.mMediaLocalPath, ")");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.imgTitle);
        parcel.writeString(this.imgMsg);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.imgDeeplink);
        parcel.writeString(this.mMediaLocalPath);
        parcel.writeInt(this.mDownloadStatus);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SMTCarouselItemData(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, "parcel");
        this(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        this.mDownloadStatus = parcel.readInt();
    }
}
