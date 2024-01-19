package io.hansel.hanselsdk;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import io.hansel.b.a;
import io.hansel.core.b;
import io.hansel.pebbletracesdk.EndGame;
import io.hansel.pebbletracesdk.HanselInitializationListener;
import java.util.HashMap;
import java.util.Map;

public class Hansel {
    public static void disableDeviceIdLog() {
        b.e().b();
    }

    public static void enableDebugLogs() {
        b.e().c();
    }

    public static HashMap<String, String> getInteractionMaps() {
        return b.e().f();
    }

    public static HanselUser getUser() {
        return b.e().j();
    }

    public static boolean handlePushPayload(Context context, Bundle bundle) {
        return b.e().a(context, bundle);
    }

    public static boolean handlePushPayload(Context context, Map<String, String> map) {
        return b.e().a(context, map);
    }

    public static void init(Application application) {
        init(application, null, null);
    }

    public static void init(Application application, String str, String str2) {
        b.e().a(application, str, str2);
    }

    public static boolean isPushFromHansel(Bundle bundle) {
        return b.e().a(bundle);
    }

    public static boolean isPushFromHansel(Map<String, String> map) {
        return b.e().a(map);
    }

    public static boolean onBackButtonPressed() {
        return b.e().l();
    }

    public static void onSetScreen(String str) {
        b.e().a(str);
    }

    public static void onUnsetScreen() {
        b.e().m();
    }

    public static void registerHanselActionListener(String str, HanselActionListener hanselActionListener) {
        b.e().a(str, hanselActionListener);
    }

    public static void setAppFont(String str) {
        b.e().b(str);
    }

    public static void setEndGame(EndGame endGame) {
        b.e().a(endGame);
    }

    public static void setHanselIndex(View view, String str) {
        a.a(view, str);
    }

    public static void setHanselInitializationListener(HanselInitializationListener hanselInitializationListener) {
        b.e().a(hanselInitializationListener);
    }

    public static void setHanselSyncStateListener(HanselRequestType hanselRequestType, HanselSyncStateListener hanselSyncStateListener) {
        b.e().a(hanselRequestType, hanselSyncStateListener);
    }

    public static void setNewToken(Context context, String str) {
        b.e().a(context, str);
    }

    public static void setTypeface(Typeface typeface) {
        io.hansel.a.a.a(typeface);
    }

    public static void showToast(String str, boolean z) {
        b.e().a(str, z);
    }
}
