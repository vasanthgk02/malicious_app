package com.mpl.androidapp.webview.ct.utils;

import com.mpl.androidapp.webview.ct.WebViewGamesGamesCt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/webview/ct/utils/UtilWebGameEndToEndEvent;", "", "()V", "assetAlreadyDownloaded", "", "gameId", "", "assetDownloadFailure", "message", "", "assetDownloadInitiated", "assetDownloadSuccessful", "gameApiFailure", "gameApiInitiated", "gameApiSuccessful", "gameTileClicked", "webGameLoadInitiated", "webGameLoadSuccessful", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UtilWebGameEndToEndEvent.kt */
public final class UtilWebGameEndToEndEvent {
    public static final UtilWebGameEndToEndEvent INSTANCE = new UtilWebGameEndToEndEvent();

    public final void assetAlreadyDownloaded(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, false, false, false, false, true, false, false, false, false, false, 4030, null);
    }

    public final void assetDownloadFailure(int i, String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "message");
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, str2, false, false, false, true, false, false, false, false, false, false, 4060, null);
    }

    public final void assetDownloadInitiated(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, false, true, false, false, false, false, false, false, false, false, 4086, null);
    }

    public final void assetDownloadSuccessful(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, false, false, true, false, false, false, false, false, false, false, 4078, null);
    }

    public final void gameApiFailure(int i, String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "message");
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, str2, false, false, false, false, false, false, false, true, false, false, 3580, null);
    }

    public final void gameApiInitiated(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, false, false, false, false, false, true, false, false, false, false, 3966, null);
    }

    public final void gameApiSuccessful(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, false, false, false, false, false, false, true, false, false, false, 3838, null);
    }

    public final void gameTileClicked(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, true, false, false, false, false, false, false, false, false, false, 4090, null);
    }

    public final void webGameLoadInitiated(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, false, false, false, false, false, false, false, false, true, false, 3070, null);
    }

    public final void webGameLoadSuccessful(int i) {
        WebViewGamesGamesCt.sendWebGameEndToEndFlow$default(WebViewGamesGamesCt.INSTANCE, i, null, false, false, false, false, false, false, false, false, false, true, 2046, null);
    }
}
