package com.mpl.androidapp.webview.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.MPLBaseActivity;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.utils.InternetConnectionInfo;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.lifecycle.WebViewGameLifecycleObserver;
import com.mpl.androidapp.webview.view.activities.WebViewGameActivity;
import com.mpl.androidapp.webview.view.dialogs.WebViewGameConnDialog;
import com.mpl.androidapp.webview.view.dialogs.WebViewGameExitDialog;
import com.mpl.androidapp.webview.view.dialogs.WebViewGameOneActionExitDialog;
import com.netcore.android.SMTConfigConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 2*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u00012B#\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0012\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001eJ\u0016\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010/\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\u000e\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u001eR\u001c\u0010\t\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/mpl/androidapp/webview/base/WebViewBaseActivity;", "VIEW_BINDING", "Landroidx/viewbinding/ViewBinding;", "Lcom/mpl/androidapp/MPLBaseActivity;", "inflate", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "Lcom/mpl/androidapp/webview/base/InflateActivity;", "(Lkotlin/jvm/functions/Function1;)V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "changeOrientation", "", "mode", "", "handleProgress", "isDisplay", "", "isConnectedToNetwork", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "removeFragmentIfAlreadyAdded", "fragmentTag", "resetFragmentsStates", "setWakelock", "isWakeLockEnabled", "showConnectivityDialog", "errorMessage", "callback", "Lcom/mpl/androidapp/webview/view/activities/WebViewGameActivity;", "showErrorDialogToExit", "showExitDialog", "toggleSystemUI", "isHidden", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewBaseActivity.kt */
public abstract class WebViewBaseActivity<VIEW_BINDING extends ViewBinding> extends MPLBaseActivity {
    public static final Companion Companion = new Companion(null);
    public static final String MSG_HIDE_UI = "Hiding the system UI for web-view game";
    public static final String MSG_SHOW_UI = "Showing the system UI for web-view game";
    public static final String TAG_CONNECTION_FRAGMENT = "WebViewGameConnDialog";
    public static final String TAG_GAME_EXIT_FRAGMENT = "WebViewGameExitDialog";
    public static final String TAG_GAME_ONE_ACTION_EXIT_FRAGMENT = "WebViewGameOneActionExitDialog";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public VIEW_BINDING binding;
    public final Function1<LayoutInflater, VIEW_BINDING> inflate;
    public ProgressDialog progressDialog;
    public WakeLock wakeLock;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/webview/base/WebViewBaseActivity$Companion;", "", "()V", "MSG_HIDE_UI", "", "MSG_SHOW_UI", "TAG_CONNECTION_FRAGMENT", "TAG_GAME_EXIT_FRAGMENT", "TAG_GAME_ONE_ACTION_EXIT_FRAGMENT", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewBaseActivity.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebViewBaseActivity(Function1<? super LayoutInflater, ? extends VIEW_BINDING> function1) {
        Intrinsics.checkNotNullParameter(function1, "inflate");
        this.inflate = function1;
    }

    private final void removeFragmentIfAlreadyAdded(String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    private final void resetFragmentsStates() {
        removeFragmentIfAlreadyAdded(TAG_GAME_EXIT_FRAGMENT);
        removeFragmentIfAlreadyAdded(TAG_CONNECTION_FRAGMENT);
        removeFragmentIfAlreadyAdded(TAG_GAME_ONE_ACTION_EXIT_FRAGMENT);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void changeOrientation(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "mode");
        if (CharsKt__CharKt.equals((String) SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE, str, true)) {
            i = 6;
        } else {
            i = CharsKt__CharKt.equals((String) "sensor", str, true) ? 10 : 7;
        }
        setRequestedOrientation(i);
    }

    public final VIEW_BINDING getBinding() {
        VIEW_BINDING view_binding = this.binding;
        if (view_binding != null) {
            return view_binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final ProgressDialog getProgressDialog() {
        return this.progressDialog;
    }

    public final void handleProgress(boolean z) {
        boolean z2 = false;
        if (z) {
            ProgressDialog progressDialog2 = this.progressDialog;
            if (!(progressDialog2 == null || progressDialog2 == null)) {
                progressDialog2.cancel();
            }
            ProgressDialog progressDialog3 = new ProgressDialog(this);
            this.progressDialog = progressDialog3;
            if (progressDialog3 != null) {
                progressDialog3.setMessage(getResources().getString(R.string.loading_three_dot));
                progressDialog3.setProgressStyle(0);
                progressDialog3.show();
                progressDialog3.setCancelable(false);
                return;
            }
            return;
        }
        ProgressDialog progressDialog4 = this.progressDialog;
        if (progressDialog4 != null) {
            if (progressDialog4 != null && progressDialog4.isShowing()) {
                z2 = true;
            }
            if (z2) {
                ProgressDialog progressDialog5 = this.progressDialog;
                if (progressDialog5 != null) {
                    progressDialog5.cancel();
                }
            }
        }
    }

    public final boolean isConnectedToNetwork() {
        return InternetConnectionInfo.INSTANCE.isNetworkAvailable(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Function1<LayoutInflater, VIEW_BINDING> function1 = this.inflate;
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        setBinding((ViewBinding) function1.invoke(layoutInflater));
        setContentView(getBinding().getRoot());
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
        getLifecycle().addObserver(new WebViewGameLifecycleObserver());
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        toggleSystemUI(true);
    }

    public final void setBinding(VIEW_BINDING view_binding) {
        Intrinsics.checkNotNullParameter(view_binding, "<set-?>");
        this.binding = view_binding;
    }

    public final void setProgressDialog(ProgressDialog progressDialog2) {
        this.progressDialog = progressDialog2;
    }

    public final void setWakelock(boolean z) {
        if (z) {
            Object systemService = getSystemService("power");
            if (systemService != null) {
                WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(805306369, "webview:podcast");
                this.wakeLock = newWakeLock;
                if (newWakeLock != null) {
                    newWakeLock.acquire();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }
        WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null && wakeLock2.isHeld()) {
            wakeLock2.release();
        }
    }

    public final void showConnectivityDialog(String str, WebViewGameActivity webViewGameActivity) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Intrinsics.checkNotNullParameter(webViewGameActivity, "callback");
        if (!isFinishing()) {
            MLogger.d("WebViewGames", Intrinsics.stringPlus("Exception: ", str));
            try {
                resetFragmentsStates();
                WebViewGameConnDialog webViewGameConnDialog = new WebViewGameConnDialog();
                webViewGameConnDialog.setCallback(webViewGameActivity);
                webViewGameConnDialog.show(getSupportFragmentManager(), (String) TAG_CONNECTION_FRAGMENT);
            } catch (Exception e2) {
                MLogger.d("WebViewGames", e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public final void showErrorDialogToExit(String str, WebViewGameActivity webViewGameActivity) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Intrinsics.checkNotNullParameter(webViewGameActivity, "callback");
        if (!isFinishing()) {
            MLogger.d("WebViewGames", Intrinsics.stringPlus("Exception: ", str));
            try {
                resetFragmentsStates();
                WebViewGameOneActionExitDialog webViewGameOneActionExitDialog = new WebViewGameOneActionExitDialog();
                webViewGameOneActionExitDialog.setCallback(webViewGameActivity);
                webViewGameOneActionExitDialog.show(getSupportFragmentManager(), (String) TAG_GAME_ONE_ACTION_EXIT_FRAGMENT);
            } catch (Exception e2) {
                MLogger.d("WebViewGames", e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public final void showExitDialog(WebViewGameActivity webViewGameActivity) {
        Intrinsics.checkNotNullParameter(webViewGameActivity, "callback");
        if (!isFinishing()) {
            try {
                resetFragmentsStates();
                WebViewGameExitDialog webViewGameExitDialog = new WebViewGameExitDialog();
                webViewGameExitDialog.setCallback(webViewGameActivity);
                webViewGameExitDialog.show(getSupportFragmentManager(), (String) TAG_GAME_EXIT_FRAGMENT);
            } catch (Exception e2) {
                MLogger.d("WebViewGames", e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public final void toggleSystemUI(boolean z) {
        Window window = getWindow();
        if (window != null) {
            if (z) {
                MLogger.d("WebViewGames", MSG_HIDE_UI);
                window.getDecorView().setSystemUiVisibility(5894);
                return;
            }
            MLogger.d("WebViewGames", MSG_SHOW_UI);
            window.clearFlags(8192);
            window.clearFlags(128);
        }
    }
}
