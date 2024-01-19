package com.mpl.androidapp.unity.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.ActivityUnityMiniProfileBinding;
import com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment;
import com.mpl.androidapp.model.UnityMiniProfileData;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.unity.utils.UnityProfileConstants;
import com.mpl.androidapp.unity.views.MiniProfileContainerFragment.Callback;
import com.mpl.androidapp.utils.MLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/unity/views/UnityMiniProfileActivity;", "Lcom/mpl/androidapp/MPLBaseActivity;", "Lcom/mpl/androidapp/unity/views/MiniProfileContainerFragment$Callback;", "()V", "binding", "Lcom/mpl/androidapp/databinding/ActivityUnityMiniProfileBinding;", "profileData", "Lcom/mpl/androidapp/model/UnityMiniProfileData;", "closeProfile", "", "getDataFromPreviousScreen", "hideSystemUi", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openProfile", "reactDeepLink", "", "startContainerFragment", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityMiniProfileActivity.kt */
public final class UnityMiniProfileActivity extends Hilt_UnityMiniProfileActivity implements Callback {
    public static final Companion Companion = new Companion(null);
    public static final String UNITY_PROFILE_DATA = "UNITY_PROFILE_DATA";
    public static final String UNITY_PROFILE_DATA_BUNDLE = "UNITY_PROFILE_DATA_BUNDLE";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public ActivityUnityMiniProfileBinding binding;
    public UnityMiniProfileData profileData;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/unity/views/UnityMiniProfileActivity$Companion;", "", "()V", "UNITY_PROFILE_DATA", "", "UNITY_PROFILE_DATA_BUNDLE", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityMiniProfileActivity.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

    public void closeProfile() {
        MLogger.d("UnitiyMiniProfile", "CloseProfile function " + this + ".javaClass.simpleName class is triggered");
        finish();
    }

    /* access modifiers changed from: 0000 */
    public final void getDataFromPreviousScreen() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundleExtra = intent.getBundleExtra(UNITY_PROFILE_DATA_BUNDLE);
            if (bundleExtra != null) {
                Parcelable parcelable = bundleExtra.getParcelable(UNITY_PROFILE_DATA);
                if (parcelable != null) {
                    this.profileData = (UnityMiniProfileData) parcelable;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.mpl.androidapp.model.UnityMiniProfileData");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void hideSystemUi() {
        Window window = getWindow();
        View decorView = window == null ? null : window.getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(5894);
        }
    }

    public void onBackPressed() {
        boolean z = true;
        MLogger.d("UnitiyMiniProfile", "onBack pressed event " + this + ".javaClass.simpleName class is triggered");
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        if (!fragments.isEmpty()) {
            Iterator<T> it = fragments.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Fragment) it.next()) instanceof MiniProfileFragment) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (z) {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 367414779, bundle);
    }

    public void openProfile(String str) {
        Intrinsics.checkNotNullParameter(str, "reactDeepLink");
        MLogger.d("UnitiyMiniProfile", "Open profile function " + this + ".javaClass.simpleName class is triggered");
        Intent intent = new Intent(this, MPLReactContainerActivity.class);
        intent.putExtra(UnityProfileConstants.UNITY_MINI_PROFILE_FLAG, true);
        intent.putExtra(UnityProfileConstants.UNITY_MINI_PROFILE_DEEP_LINK, str);
        finish();
        startActivity(intent);
    }

    /* access modifiers changed from: 0000 */
    public final void startContainerFragment() {
        if (this.profileData != null) {
            MiniProfileContainerFragment miniProfileContainerFragment = new MiniProfileContainerFragment();
            miniProfileContainerFragment.setCallback(this);
            UnityMiniProfileData unityMiniProfileData = this.profileData;
            if (unityMiniProfileData != null) {
                miniProfileContainerFragment.setProfileData(unityMiniProfileData);
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.replace((int) R.id.unityMiniProfileContainerId, (Fragment) miniProfileContainerFragment, (String) "MiniProfileContainerFragment");
                beginTransaction.commit();
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("profileData");
            throw null;
        }
        finish();
    }
}
