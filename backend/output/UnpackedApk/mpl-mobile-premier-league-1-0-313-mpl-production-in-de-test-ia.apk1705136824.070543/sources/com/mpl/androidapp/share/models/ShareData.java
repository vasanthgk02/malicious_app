package com.mpl.androidapp.share.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.ct.C.ShareEventUsingApplication;
import com.mpl.androidapp.miniprofile.extensions.StringExtKt;
import com.mpl.androidapp.share.utils.Keys.ShareFormat;
import com.mpl.androidapp.share.utils.Keys.SharePlatform;
import com.mpl.androidapp.share.utils.Keys.ShareType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b8\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010E\u001a\u00020\u00112\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\rHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018¨\u0006I"}, d2 = {"Lcom/mpl/androidapp/share/models/ShareData;", "", "shareType", "", "sharePlatform", "shareFormat", "textToBeShared", "imageUriToBeShared", "deepLinkPayload", "appFlyersLink", "gameName", "referralCode", "gameId", "", "entryPoint", "screenName", "shareSkipScreen", "", "isSharePlatformPresent", "packageName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getAppFlyersLink", "()Ljava/lang/String;", "setAppFlyersLink", "(Ljava/lang/String;)V", "getDeepLinkPayload", "setDeepLinkPayload", "getEntryPoint", "setEntryPoint", "getGameId", "()I", "getGameName", "setGameName", "getImageUriToBeShared", "setImageUriToBeShared", "()Z", "setSharePlatformPresent", "(Z)V", "getPackageName", "setPackageName", "getReferralCode", "setReferralCode", "getScreenName", "getShareFormat", "setShareFormat", "getSharePlatform", "setSharePlatform", "getShareSkipScreen", "setShareSkipScreen", "getShareType", "setShareType", "getTextToBeShared", "setTextToBeShared", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareData.kt */
public final class ShareData {
    public String appFlyersLink;
    public String deepLinkPayload;
    public String entryPoint;
    public final int gameId;
    public String gameName;
    public String imageUriToBeShared;
    public boolean isSharePlatformPresent;
    public String packageName;
    public String referralCode;
    public final String screenName;
    public String shareFormat;
    public String sharePlatform;
    public boolean shareSkipScreen;
    public String shareType;
    public String textToBeShared;

    public ShareData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11, boolean z, boolean z2, String str12) {
        String str13 = str2;
        String str14 = str3;
        String str15 = str4;
        String str16 = str5;
        String str17 = str6;
        String str18 = str7;
        String str19 = str8;
        String str20 = str9;
        String str21 = str10;
        String str22 = str11;
        String str23 = str12;
        Intrinsics.checkNotNullParameter(str, ShareEventUsingApplication.PROPERTY_SHARE_TYPE);
        Intrinsics.checkNotNullParameter(str13, "sharePlatform");
        Intrinsics.checkNotNullParameter(str14, "shareFormat");
        Intrinsics.checkNotNullParameter(str15, "textToBeShared");
        Intrinsics.checkNotNullParameter(str16, "imageUriToBeShared");
        Intrinsics.checkNotNullParameter(str17, "deepLinkPayload");
        Intrinsics.checkNotNullParameter(str18, "appFlyersLink");
        Intrinsics.checkNotNullParameter(str19, "gameName");
        Intrinsics.checkNotNullParameter(str20, "referralCode");
        Intrinsics.checkNotNullParameter(str21, "entryPoint");
        Intrinsics.checkNotNullParameter(str22, "screenName");
        Intrinsics.checkNotNullParameter(str23, "packageName");
        this.shareType = str;
        this.sharePlatform = str13;
        this.shareFormat = str14;
        this.textToBeShared = str15;
        this.imageUriToBeShared = str16;
        this.deepLinkPayload = str17;
        this.appFlyersLink = str18;
        this.gameName = str19;
        this.referralCode = str20;
        this.gameId = i;
        this.entryPoint = str21;
        this.screenName = str22;
        this.shareSkipScreen = z;
        this.isSharePlatformPresent = z2;
        this.packageName = str23;
    }

    public static /* synthetic */ ShareData copy$default(ShareData shareData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11, boolean z, boolean z2, String str12, int i2, Object obj) {
        ShareData shareData2 = shareData;
        int i3 = i2;
        return shareData.copy((i3 & 1) != 0 ? shareData2.shareType : str, (i3 & 2) != 0 ? shareData2.sharePlatform : str2, (i3 & 4) != 0 ? shareData2.shareFormat : str3, (i3 & 8) != 0 ? shareData2.textToBeShared : str4, (i3 & 16) != 0 ? shareData2.imageUriToBeShared : str5, (i3 & 32) != 0 ? shareData2.deepLinkPayload : str6, (i3 & 64) != 0 ? shareData2.appFlyersLink : str7, (i3 & 128) != 0 ? shareData2.gameName : str8, (i3 & 256) != 0 ? shareData2.referralCode : str9, (i3 & 512) != 0 ? shareData2.gameId : i, (i3 & 1024) != 0 ? shareData2.entryPoint : str10, (i3 & 2048) != 0 ? shareData2.screenName : str11, (i3 & 4096) != 0 ? shareData2.shareSkipScreen : z, (i3 & 8192) != 0 ? shareData2.isSharePlatformPresent : z2, (i3 & 16384) != 0 ? shareData2.packageName : str12);
    }

    public final String component1() {
        return this.shareType;
    }

    public final int component10() {
        return this.gameId;
    }

    public final String component11() {
        return this.entryPoint;
    }

    public final String component12() {
        return this.screenName;
    }

    public final boolean component13() {
        return this.shareSkipScreen;
    }

    public final boolean component14() {
        return this.isSharePlatformPresent;
    }

    public final String component15() {
        return this.packageName;
    }

    public final String component2() {
        return this.sharePlatform;
    }

    public final String component3() {
        return this.shareFormat;
    }

    public final String component4() {
        return this.textToBeShared;
    }

    public final String component5() {
        return this.imageUriToBeShared;
    }

    public final String component6() {
        return this.deepLinkPayload;
    }

    public final String component7() {
        return this.appFlyersLink;
    }

    public final String component8() {
        return this.gameName;
    }

    public final String component9() {
        return this.referralCode;
    }

    public final ShareData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11, boolean z, boolean z2, String str12) {
        String str13 = str;
        Intrinsics.checkNotNullParameter(str13, ShareEventUsingApplication.PROPERTY_SHARE_TYPE);
        String str14 = str2;
        Intrinsics.checkNotNullParameter(str14, "sharePlatform");
        String str15 = str3;
        Intrinsics.checkNotNullParameter(str15, "shareFormat");
        String str16 = str4;
        Intrinsics.checkNotNullParameter(str16, "textToBeShared");
        String str17 = str5;
        Intrinsics.checkNotNullParameter(str17, "imageUriToBeShared");
        String str18 = str6;
        Intrinsics.checkNotNullParameter(str18, "deepLinkPayload");
        String str19 = str7;
        Intrinsics.checkNotNullParameter(str19, "appFlyersLink");
        String str20 = str8;
        Intrinsics.checkNotNullParameter(str20, "gameName");
        String str21 = str9;
        Intrinsics.checkNotNullParameter(str21, "referralCode");
        String str22 = str10;
        Intrinsics.checkNotNullParameter(str22, "entryPoint");
        String str23 = str11;
        Intrinsics.checkNotNullParameter(str23, "screenName");
        Intrinsics.checkNotNullParameter(str12, "packageName");
        ShareData shareData = new ShareData(str13, str14, str15, str16, str17, str18, str19, str20, str21, i, str22, str23, z, z2, str12);
        return shareData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareData)) {
            return false;
        }
        ShareData shareData = (ShareData) obj;
        return Intrinsics.areEqual(this.shareType, shareData.shareType) && Intrinsics.areEqual(this.sharePlatform, shareData.sharePlatform) && Intrinsics.areEqual(this.shareFormat, shareData.shareFormat) && Intrinsics.areEqual(this.textToBeShared, shareData.textToBeShared) && Intrinsics.areEqual(this.imageUriToBeShared, shareData.imageUriToBeShared) && Intrinsics.areEqual(this.deepLinkPayload, shareData.deepLinkPayload) && Intrinsics.areEqual(this.appFlyersLink, shareData.appFlyersLink) && Intrinsics.areEqual(this.gameName, shareData.gameName) && Intrinsics.areEqual(this.referralCode, shareData.referralCode) && this.gameId == shareData.gameId && Intrinsics.areEqual(this.entryPoint, shareData.entryPoint) && Intrinsics.areEqual(this.screenName, shareData.screenName) && this.shareSkipScreen == shareData.shareSkipScreen && this.isSharePlatformPresent == shareData.isSharePlatformPresent && Intrinsics.areEqual(this.packageName, shareData.packageName);
    }

    public final String getAppFlyersLink() {
        return this.appFlyersLink;
    }

    public final String getDeepLinkPayload() {
        return this.deepLinkPayload;
    }

    public final String getEntryPoint() {
        return this.entryPoint;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getImageUriToBeShared() {
        return this.imageUriToBeShared;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getReferralCode() {
        return this.referralCode;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final String getShareFormat() {
        return this.shareFormat;
    }

    public final String getSharePlatform() {
        return this.sharePlatform;
    }

    public final boolean getShareSkipScreen() {
        return this.shareSkipScreen;
    }

    public final String getShareType() {
        return this.shareType;
    }

    public final String getTextToBeShared() {
        return this.textToBeShared;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.gameName, GeneratedOutlineSupport.outline11(this.appFlyersLink, GeneratedOutlineSupport.outline11(this.deepLinkPayload, GeneratedOutlineSupport.outline11(this.imageUriToBeShared, GeneratedOutlineSupport.outline11(this.textToBeShared, GeneratedOutlineSupport.outline11(this.shareFormat, GeneratedOutlineSupport.outline11(this.sharePlatform, this.shareType.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31);
        int outline112 = GeneratedOutlineSupport.outline11(this.screenName, GeneratedOutlineSupport.outline11(this.entryPoint, (GeneratedOutlineSupport.outline11(this.referralCode, outline11, 31) + this.gameId) * 31, 31), 31);
        boolean z = this.shareSkipScreen;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (outline112 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isSharePlatformPresent;
        if (!z2) {
            i = z2;
        }
        return this.packageName.hashCode() + ((i2 + i) * 31);
    }

    public final boolean isSharePlatformPresent() {
        return this.isSharePlatformPresent;
    }

    public final void setAppFlyersLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appFlyersLink = str;
    }

    public final void setDeepLinkPayload(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deepLinkPayload = str;
    }

    public final void setEntryPoint(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.entryPoint = str;
    }

    public final void setGameName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameName = str;
    }

    public final void setImageUriToBeShared(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUriToBeShared = str;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void setReferralCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.referralCode = str;
    }

    public final void setShareFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareFormat = str;
    }

    public final void setSharePlatform(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sharePlatform = str;
    }

    public final void setSharePlatformPresent(boolean z) {
        this.isSharePlatformPresent = z;
    }

    public final void setShareSkipScreen(boolean z) {
        this.shareSkipScreen = z;
    }

    public final void setShareType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareType = str;
    }

    public final void setTextToBeShared(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.textToBeShared = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ShareData(shareType=");
        outline73.append(this.shareType);
        outline73.append(", sharePlatform=");
        outline73.append(this.sharePlatform);
        outline73.append(", shareFormat=");
        outline73.append(this.shareFormat);
        outline73.append(", textToBeShared=");
        outline73.append(this.textToBeShared);
        outline73.append(", imageUriToBeShared=");
        outline73.append(this.imageUriToBeShared);
        outline73.append(", deepLinkPayload=");
        outline73.append(this.deepLinkPayload);
        outline73.append(", appFlyersLink=");
        outline73.append(this.appFlyersLink);
        outline73.append(", gameName=");
        outline73.append(this.gameName);
        outline73.append(", referralCode=");
        outline73.append(this.referralCode);
        outline73.append(", gameId=");
        outline73.append(this.gameId);
        outline73.append(", entryPoint=");
        outline73.append(this.entryPoint);
        outline73.append(", screenName=");
        outline73.append(this.screenName);
        outline73.append(", shareSkipScreen=");
        outline73.append(this.shareSkipScreen);
        outline73.append(", isSharePlatformPresent=");
        outline73.append(this.isSharePlatformPresent);
        outline73.append(", packageName=");
        return GeneratedOutlineSupport.outline59(outline73, this.packageName, ')');
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public /* synthetic */ ShareData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11, boolean z, boolean z2, String str12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        // int i3 = i2;
        this((i3 & 1) != 0 ? ShareType.TEXT_ONLY : str, (i3 & 2) != 0 ? SharePlatform.ALL : str2, (i3 & 4) != 0 ? ShareFormat.WITH_APP_FLYERS : str3, (i3 & 8) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str4, (i3 & 16) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str5, (i3 & 32) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str6, (i3 & 64) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str7, (i3 & 128) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str8, (i3 & 256) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str9, i, (i3 & 1024) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str10, (i3 & 2048) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str11, (i3 & 4096) != 0 ? true : z, (i3 & 8192) != 0 ? false : z2, (i3 & 16384) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str12);
    }
}
