package com.mpl.androidapp.share.deeplink;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/share/deeplink/ShareDeepLinkPayloads;", "", "()V", "navPayloadForCodeMergeGames", "", "gameId", "", "navPayloadForWebGames", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareDeepLinkPayloads.kt */
public final class ShareDeepLinkPayloads {
    public static final ShareDeepLinkPayloads INSTANCE = new ShareDeepLinkPayloads();

    public final String navPayloadForCodeMergeGames(int i) {
        return GeneratedOutlineSupport.outline42("{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":", i, "}}}");
    }

    public final String navPayloadForWebGames(int i) {
        return GeneratedOutlineSupport.outline42("{\"actionType\":\"nav\",\"actionPayload\":{\"param\":{\"gameId\":", i, ",\"isThirdPartyApk\":\"true\",\"isWebApkFlow\":\"true\",\"route\": \"GamesTab\"}}}");
    }
}
