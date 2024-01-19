package com.mpl.androidapp.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/model/ChatGroup;", "", "groupName", "", "groupUrl", "groupCoverUrl", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getGroupCoverUrl", "()Ljava/lang/String;", "getGroupName", "getGroupUrl", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatGroup.kt */
public final class ChatGroup {
    public final String groupCoverUrl;
    public final String groupName;
    public final String groupUrl;
    public boolean isSelected;

    public ChatGroup(String str, String str2, String str3, boolean z) {
        GeneratedOutlineSupport.outline97(str, "groupName", str2, "groupUrl", str3, "groupCoverUrl");
        this.groupName = str;
        this.groupUrl = str2;
        this.groupCoverUrl = str3;
        this.isSelected = z;
    }

    public static /* synthetic */ ChatGroup copy$default(ChatGroup chatGroup, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatGroup.groupName;
        }
        if ((i & 2) != 0) {
            str2 = chatGroup.groupUrl;
        }
        if ((i & 4) != 0) {
            str3 = chatGroup.groupCoverUrl;
        }
        if ((i & 8) != 0) {
            z = chatGroup.isSelected;
        }
        return chatGroup.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.groupName;
    }

    public final String component2() {
        return this.groupUrl;
    }

    public final String component3() {
        return this.groupCoverUrl;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final ChatGroup copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "groupName");
        Intrinsics.checkNotNullParameter(str2, "groupUrl");
        Intrinsics.checkNotNullParameter(str3, "groupCoverUrl");
        return new ChatGroup(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatGroup)) {
            return false;
        }
        ChatGroup chatGroup = (ChatGroup) obj;
        return Intrinsics.areEqual(this.groupName, chatGroup.groupName) && Intrinsics.areEqual(this.groupUrl, chatGroup.groupUrl) && Intrinsics.areEqual(this.groupCoverUrl, chatGroup.groupCoverUrl) && this.isSelected == chatGroup.isSelected;
    }

    public final String getGroupCoverUrl() {
        return this.groupCoverUrl;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final String getGroupUrl() {
        return this.groupUrl;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.groupCoverUrl, GeneratedOutlineSupport.outline11(this.groupUrl, this.groupName.hashCode() * 31, 31), 31);
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
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ChatGroup(groupName=");
        outline73.append(this.groupName);
        outline73.append(", groupUrl=");
        outline73.append(this.groupUrl);
        outline73.append(", groupCoverUrl=");
        outline73.append(this.groupCoverUrl);
        outline73.append(", isSelected=");
        return GeneratedOutlineSupport.outline65(outline73, this.isSelected, ')');
    }
}
