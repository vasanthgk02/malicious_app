package com.mpl.androidapp.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/model/Chat1V1;", "", "userId", "", "userName", "profileUrl", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setSelected", "(Z)V", "getProfileUrl", "()Ljava/lang/String;", "getUserId", "getUserName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Chat1V1.kt */
public final class Chat1V1 {
    public boolean isSelected;
    public final String profileUrl;
    public final String userId;
    public final String userName;

    public Chat1V1(String str, String str2, String str3, boolean z) {
        GeneratedOutlineSupport.outline97(str, "userId", str2, "userName", str3, "profileUrl");
        this.userId = str;
        this.userName = str2;
        this.profileUrl = str3;
        this.isSelected = z;
    }

    public static /* synthetic */ Chat1V1 copy$default(Chat1V1 chat1V1, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chat1V1.userId;
        }
        if ((i & 2) != 0) {
            str2 = chat1V1.userName;
        }
        if ((i & 4) != 0) {
            str3 = chat1V1.profileUrl;
        }
        if ((i & 8) != 0) {
            z = chat1V1.isSelected;
        }
        return chat1V1.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.profileUrl;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final Chat1V1 copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "userName");
        Intrinsics.checkNotNullParameter(str3, "profileUrl");
        return new Chat1V1(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Chat1V1)) {
            return false;
        }
        Chat1V1 chat1V1 = (Chat1V1) obj;
        return Intrinsics.areEqual(this.userId, chat1V1.userId) && Intrinsics.areEqual(this.userName, chat1V1.userName) && Intrinsics.areEqual(this.profileUrl, chat1V1.profileUrl) && this.isSelected == chat1V1.isSelected;
    }

    public final String getProfileUrl() {
        return this.profileUrl;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.profileUrl, GeneratedOutlineSupport.outline11(this.userName, this.userId.hashCode() * 31, 31), 31);
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return outline11 + (z ? 1 : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Chat1V1(userId=");
        outline73.append(this.userId);
        outline73.append(", userName=");
        outline73.append(this.userName);
        outline73.append(", profileUrl=");
        outline73.append(this.profileUrl);
        outline73.append(", isSelected=");
        return GeneratedOutlineSupport.outline65(outline73, this.isSelected, ')');
    }
}
