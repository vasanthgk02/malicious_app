package com.mpl.androidapp.share.deeplink;

import com.mpl.androidapp.share.models.ShareData;
import com.mpl.androidapp.share.utils.Keys.ShareType;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ.\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/share/deeplink/DeepLinkObjects;", "", "()V", "prepCodeMergeImgShare", "Lcom/mpl/androidapp/share/models/ShareData;", "gameId", "", "shareMessage", "", "launchFrom", "screenName", "sharePlatform", "imageUriToBeShared", "prepWebFlowGameTxtShare", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeepLinkObjects.kt */
public final class DeepLinkObjects {
    public static final DeepLinkObjects INSTANCE = new DeepLinkObjects();

    public final ShareData prepCodeMergeImgShare(int i, String str, String str2, String str3, String str4, String str5) {
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str, "shareMessage");
        Intrinsics.checkNotNullParameter(str2, "launchFrom");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        Intrinsics.checkNotNullParameter(str4, "sharePlatform");
        Intrinsics.checkNotNullParameter(str5, "imageUriToBeShared");
        String navPayloadForCodeMergeGames = ShareDeepLinkPayloads.INSTANCE.navPayloadForCodeMergeGames(i);
        String userReferralCode = MSharedPreferencesUtils.getUserReferralCode();
        Intrinsics.checkNotNullExpressionValue(userReferralCode, "getUserReferralCode()");
        ShareData shareData = new ShareData(ShareType.TEXT_AND_IMAGE, str6, null, str, str5, navPayloadForCodeMergeGames, null, null, userReferralCode, i, str2, str3, false, false, null, 28868, null);
        return shareData;
    }

    public final ShareData prepWebFlowGameTxtShare(int i, String str, String str2, String str3, String str4) {
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str, "shareMessage");
        Intrinsics.checkNotNullParameter(str2, "launchFrom");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        Intrinsics.checkNotNullParameter(str4, "sharePlatform");
        String navPayloadForWebGames = ShareDeepLinkPayloads.INSTANCE.navPayloadForWebGames(i);
        String userReferralCode = MSharedPreferencesUtils.getUserReferralCode();
        Intrinsics.checkNotNullExpressionValue(userReferralCode, "getUserReferralCode()");
        ShareData shareData = new ShareData(ShareType.TEXT_ONLY, str5, null, str, null, navPayloadForWebGames, null, null, userReferralCode, i, str2, str3, false, false, null, 28884, null);
        return shareData;
    }
}
