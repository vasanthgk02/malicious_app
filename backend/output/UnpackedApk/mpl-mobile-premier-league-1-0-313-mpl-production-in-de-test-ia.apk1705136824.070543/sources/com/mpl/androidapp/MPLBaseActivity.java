package com.mpl.androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.app.AppCompatActivity;
import com.inca.security.AppGuard.AppGuardClient;
import com.inca.security.AppGuard.AppGuardEventListener;
import com.mpl.androidapp.updater.AppInitialization;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.DialogData.TYPE;
import com.mpl.androidapp.utils.LocaleHelper;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.WindowUtil;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMapParser;

public class MPLBaseActivity extends AppCompatActivity {
    public static final String TAG = "MPLBaseActivity";
    public static final int UI_FLAG_IMMERSIVE = 5894;
    public AppInitialization initialization;
    public Boolean isTransparentThemeSet = Boolean.FALSE;
    public AppGuardClient mAppGuardClient;
    public BroadcastReceiver mNetworkChangeListener = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra("noConnectivity")) {
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                MPLBaseActivity.this.onNetworkConnectivityChanged(booleanExtra);
                MLogger.d(MPLBaseActivity.TAG, "onReceive: ", Boolean.valueOf(booleanExtra));
            }
        }
    };

    /* access modifiers changed from: private */
    public Intent getConnectivityIntent(boolean z) {
        Intent intent = new Intent();
        intent.setAction("com.mpl.androidapp.game.CONNECTIVITY_CHANGE");
        intent.putExtra("noConnectivity", z);
        return intent;
    }

    private void hideSystemUI() {
        MLogger.d(TAG, "hideSystemUI() called");
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void initAppGuardSDK() {
        try {
            this.mAppGuardClient = new AppGuardClient(this, new AppGuardEventListener() {
                public void onDetected(int i, byte[] bArr) {
                    MPLBaseActivity.sendAppGuardEvent(i, 2);
                }

                public void onError(int i, byte[] bArr) {
                    MPLBaseActivity.sendAppGuardEvent(i, 1);
                }

                public void onEvent(int i, byte[] bArr) {
                    MPLBaseActivity.sendAppGuardEvent(i, 0);
                }
            });
        } catch (Exception e2) {
            MLogger.d(TAG, "initAppGuardSDK: ", e2.getMessage());
        }
    }

    private void registerConnectivityNetworkMonitorForAPI21AndUp() {
        try {
            registerReceiver(this.mNetworkChangeListener, new IntentFilter("com.mpl.androidapp.game.CONNECTIVITY_CHANGE"));
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            Builder builder = new Builder();
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(builder.build(), new NetworkCallback() {
                    public void onAvailable(Network network) {
                        MLogger.d(MPLBaseActivity.TAG, "onAvailable: ");
                        MPLBaseActivity mPLBaseActivity = MPLBaseActivity.this;
                        mPLBaseActivity.sendBroadcast(mPLBaseActivity.getConnectivityIntent(false));
                    }

                    public void onLost(Network network) {
                        MLogger.d(MPLBaseActivity.TAG, "onLost: ");
                        MPLBaseActivity mPLBaseActivity = MPLBaseActivity.this;
                        mPLBaseActivity.sendBroadcast(mPLBaseActivity.getConnectivityIntent(true));
                    }
                });
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "registerConnectivityNetworkMonitorForAPI21AndUp: ");
        }
    }

    public static void sendAppGuardEvent(int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Shield ID", MSharedPreferencesUtils.getShieldId());
        hashMap.put("AppGuard Code", Integer.valueOf(i));
        hashMap.put("AppGuard Action", Integer.valueOf(i2));
        CleverTapAnalyticsUtils.sendEvent((String) "AppGuard Event", hashMap);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleHelper.onAttach(context));
    }

    public void hideMultiScreenDialog() {
    }

    public void onCreate(Bundle bundle) {
        if (this.isTransparentThemeSet.booleanValue()) {
            setTheme(R.style.Theme_Transparent);
        } else {
            WindowUtil.setCustomTheme(this);
        }
        super.onCreate(bundle);
        registerConnectivityNetworkMonitorForAPI21AndUp();
        initAppGuardSDK();
    }

    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.mNetworkChangeListener;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        MLogger.d(TAG, "onMultiWindowModeChanged: ", Boolean.valueOf(z));
        if (z) {
            showMultiScreenDialog(TYPE.SPLIT_SCREEN);
        } else {
            hideMultiScreenDialog();
        }
    }

    public void onNetworkConnectivityChanged(boolean z) {
        MLogger.d(TAG, "onNetworkConnectivityChanged: ", Boolean.valueOf(z));
    }

    public void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
        MLogger.d(TAG, "onPictureInPictureModeChanged: ", Boolean.valueOf(z));
        if (z) {
            showMultiScreenDialog(TYPE.SPLIT_SCREEN);
        } else {
            hideMultiScreenDialog();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MLogger.d(TAG, "onWindowFocusChanged() called with: hasFocus = [" + z + CMapParser.MARK_END_OF_ARRAY);
        if (VERSION.SDK_INT >= 24) {
            MLogger.d(TAG, "onWindowFocusChanged: ", Boolean.valueOf(isInMultiWindowMode()), Boolean.valueOf(isInPictureInPictureMode()));
            if (isInMultiWindowMode() || isInPictureInPictureMode()) {
                showMultiScreenDialog(TYPE.SPLIT_SCREEN);
            } else {
                hideMultiScreenDialog();
            }
        }
    }

    public void setTransparentTheme(Boolean bool) {
        this.isTransparentThemeSet = bool;
    }

    public void showMultiScreenDialog(TYPE type) {
    }

    public void slideDown(final View view) {
        runOnUiThread(new Runnable() {
            public void run() {
                View view = view;
                if (view != null && view.getVisibility() == 0) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) view.getHeight());
                    translateAnimation.setDuration(500);
                    translateAnimation.setFillAfter(true);
                    view.startAnimation(translateAnimation);
                }
            }
        });
    }

    public void slideUp(final View view) {
        runOnUiThread(new Runnable() {
            public void run() {
                View view = view;
                if (view == null) {
                    return;
                }
                if (view.getVisibility() == 8 || view.getVisibility() == 4) {
                    view.setVisibility(0);
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) view.getHeight(), 0.0f);
                    translateAnimation.setDuration(500);
                    translateAnimation.setFillAfter(true);
                    view.startAnimation(translateAnimation);
                }
            }
        });
    }
}
