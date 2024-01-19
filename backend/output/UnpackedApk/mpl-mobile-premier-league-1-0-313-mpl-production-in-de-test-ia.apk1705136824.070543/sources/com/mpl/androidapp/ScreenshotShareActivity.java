package com.mpl.androidapp;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.PromiseImpl;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.react.modules.SharedPrefModule;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import org.apache.fontbox.cmap.CMapParser;

public class ScreenshotShareActivity extends MPLBaseActivity {
    public static final String TAG = "ScreenshotShareActivity";

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1464468048, bundle);
    }

    public void shareUnityScreenshot(String str, String str2, boolean z, String str3, boolean z2, String str4) {
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("shareUnityScreenshot() called with: gameName = [", str, "], screenName = [", str2, "], shouldCloseScreen = [");
        outline82.append(z);
        outline82.append("], shareImagePath = [");
        outline82.append(str3);
        outline82.append("], screenshotuiDisabled = [");
        outline82.append(z2);
        outline82.append("], screenshotshareoptions = [");
        outline82.append(str4);
        outline82.append(CMapParser.MARK_END_OF_ARRAY);
        MLogger.d(TAG, outline82.toString());
        try {
            final String str5 = str;
            final String str6 = str2;
            final boolean z3 = z;
            AnonymousClass1 r15 = r4;
            final String str7 = str3;
            final String str8 = str4;
            final boolean z4 = z2;
            AnonymousClass1 r4 = new Callback() {
                public void invoke(Object... objArr) {
                    SharedPrefModule.shareInAppScreenShot(ScreenshotShareActivity.this, ConfigManager.getPlatformConfig().optString("unity.inApp.share.message", ScreenshotShareActivity.this.getString(R.string.share_default_message)).replace("{INVITE_CODE}", MSharedPreferencesUtils.getUserReferralCode()).replace("{GAME_NAME}", str5).replace("{URL}", objArr[0]), str6, z3, str7, str8, z4);
                    if (z4) {
                        ScreenshotShareActivity.this.finish();
                    }
                }
            };
            final String str9 = str2;
            final boolean z5 = z;
            final String str10 = str3;
            final String str11 = str4;
            final boolean z6 = z2;
            AnonymousClass2 r42 = new Callback() {
                public void invoke(Object... objArr) {
                    SharedPrefModule.shareInAppScreenShot(ScreenshotShareActivity.this, String.format(ConfigManager.getReferralNudgeConfig().optString("message", "%s"), new Object[]{ConfigManager.getReferralNudgeConfig().optString("default.url", "")}), str9, z5, str10, str11, z6);
                    if (z6) {
                        ScreenshotShareActivity.this.finish();
                    }
                }
            };
            PromiseImpl promiseImpl = new PromiseImpl(r15, r42);
            CommonUtils.createAppsFlyerReferralLink(MPLApplication.getInstance(), "{}", promiseImpl);
        } catch (Exception e2) {
            MLogger.e(TAG, "shareUnityScreenshot: ", e2);
        }
    }
}
