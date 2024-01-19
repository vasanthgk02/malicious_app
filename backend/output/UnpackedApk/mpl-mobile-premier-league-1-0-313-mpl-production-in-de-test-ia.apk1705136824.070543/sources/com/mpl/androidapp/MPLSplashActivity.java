package com.mpl.androidapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.network.modules.listeners.IResponseListener;

public class MPLSplashActivity extends AppCompatActivity {
    public static final String TAG = "AppLoading:MPLSplashActivity";

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1006240388, bundle);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 356614385, new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public void startLoginInBackground() {
        MLogger.d(TAG, "startLoginInBackground: ");
        NetworkUtils.loginMPLInBackground(this, getIntent().getStringExtra("mplAccessToken"), new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                MLogger.d(IResponseListener.TAG, "onResponseFail: ");
                MPLSplashActivity.this.startMPLReactContainerActivity();
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                MLogger.d(IResponseListener.TAG, "onResponseSuccess: ");
                MPLSplashActivity.this.startMPLReactContainerActivity();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0085, code lost:
        if (r0.equals("IN") != false) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startMPLReactContainerActivity() {
        /*
            r9 = this;
            android.content.Intent r0 = r9.getIntent()
            if (r0 == 0) goto L_0x001f
            android.content.Intent r0 = r9.getIntent()
            java.lang.String r1 = "login_user_phone_number_v2"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L_0x001f
            android.content.Intent r0 = r9.getIntent()
            java.lang.String r0 = r0.getStringExtra(r1)
            java.lang.String r1 = "samosa_login_user_phone_number_v2"
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveStringInNormalPref(r9, r1, r0)
        L_0x001f:
            java.lang.String r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getCountryCode()
            java.lang.String r1 = com.mpl.androidapp.utils.CountryUtils.getSplashImage()
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "startMPLReactContainerActivity: "
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "countryCode: "
            r5 = 1
            r2[r5] = r3
            r3 = 2
            r2[r3] = r0
            r6 = 3
            java.lang.String r7 = "splashImage: "
            r2[r6] = r7
            r6 = 4
            r2[r6] = r1
            java.lang.String r6 = "AppLoading:MPLSplashActivity"
            com.mpl.androidapp.utils.MLogger.d(r6, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r6 = 2132017168(0x7f140010, float:1.9672607E38)
            if (r2 == 0) goto L_0x0055
            android.app.Application r0 = r9.getApplication()
            r0.setTheme(r6)
            goto L_0x00b1
        L_0x0055:
            java.lang.String r0 = r0.toUpperCase()
            r2 = -1
            int r7 = r0.hashCode()
            r8 = 2341(0x925, float:3.28E-42)
            if (r7 == r8) goto L_0x007f
            r4 = 2718(0xa9e, float:3.809E-42)
            if (r7 == r4) goto L_0x0075
            r4 = 2816(0xb00, float:3.946E-42)
            if (r7 == r4) goto L_0x006b
            goto L_0x0088
        L_0x006b:
            java.lang.String r4 = "XX"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0088
            r4 = 1
            goto L_0x0089
        L_0x0075:
            java.lang.String r4 = "US"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0088
            r4 = 2
            goto L_0x0089
        L_0x007f:
            java.lang.String r7 = "IN"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r4 = -1
        L_0x0089:
            java.lang.String r0 = "en_IN"
            if (r4 == 0) goto L_0x00ab
            if (r4 == r5) goto L_0x00a0
            if (r4 == r3) goto L_0x0099
            android.app.Application r0 = r9.getApplication()
            r0.setTheme(r6)
            goto L_0x00b1
        L_0x0099:
            com.mpl.androidapp.utils.WindowUtil.setUsaTheme(r9, r1)
            com.mpl.androidapp.utils.WindowUtil.setDefaultLanguage(r0)
            goto L_0x00b1
        L_0x00a0:
            android.app.Application r0 = r9.getApplication()
            r1 = 2132017177(0x7f140019, float:1.9672625E38)
            r0.setTheme(r1)
            goto L_0x00b1
        L_0x00ab:
            com.mpl.androidapp.utils.WindowUtil.setIndiaTheme(r9, r1)
            com.mpl.androidapp.utils.WindowUtil.setDefaultLanguage(r0)
        L_0x00b1:
            android.content.Intent r0 = r9.getIntent()
            if (r0 == 0) goto L_0x00bc
            android.content.Intent r0 = r9.getIntent()
            goto L_0x00c1
        L_0x00bc:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
        L_0x00c1:
            r1 = 65536(0x10000, float:9.1835E-41)
            r0.addFlags(r1)
            r1 = 4194304(0x400000, float:5.877472E-39)
            r0.addFlags(r1)
            r1 = 2097152(0x200000, float:2.938736E-39)
            r0.addFlags(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            java.lang.Class<com.mpl.androidapp.react.MPLReactContainerActivity> r2 = com.mpl.androidapp.react.MPLReactContainerActivity.class
            r1.<init>(r9, r2)
            r0.setComponent(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 == r2) goto L_0x00e9
            r2 = 25
            if (r1 != r2) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            r9.startActivity(r0)
            goto L_0x00f1
        L_0x00e9:
            android.content.Context r1 = r9.getApplicationContext()
            r2 = 0
            androidx.core.content.ContextCompat.startActivity(r1, r0, r2)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.MPLSplashActivity.startMPLReactContainerActivity():void");
    }
}
