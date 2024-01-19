package com.mpl.androidapp.unity.base;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.mpl.androidapp.miniprofile.extensions.ActivityExtKt;
import com.unity3d.player.UnityPlayerActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/unity/base/UnityPlayerBaseActivity;", "Lcom/unity3d/player/UnityPlayerActivity;", "()V", "getAvailableRamMbForUnity", "", "getAvailableRamPercentForUnity", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setScreenSecureForUnity", "isSecure", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityPlayerBaseActivity.kt */
public class UnityPlayerBaseActivity extends UnityPlayerActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: setScreenSecureForUnity$lambda-1  reason: not valid java name */
    public static final void m22setScreenSecureForUnity$lambda1(boolean z, UnityPlayerBaseActivity unityPlayerBaseActivity) {
        Intrinsics.checkNotNullParameter(unityPlayerBaseActivity, "this$0");
        if (z) {
            unityPlayerBaseActivity.getWindow().setFlags(8192, 8192);
        } else {
            unityPlayerBaseActivity.getWindow().clearFlags(8192);
        }
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

    public double getAvailableRamMbForUnity() {
        return ActivityExtKt.getAvailableRamMb(this);
    }

    public double getAvailableRamPercentForUnity() {
        return ActivityExtKt.getAvailableRamPercent(this);
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
    }

    public void setScreenSecureForUnity(boolean z) {
        if (getWindow() != null) {
            runOnUiThread(new Runnable(z, this) {
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ UnityPlayerBaseActivity f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    UnityPlayerBaseActivity.m22setScreenSecureForUnity$lambda1(this.f$0, this.f$1);
                }
            });
        }
    }
}
