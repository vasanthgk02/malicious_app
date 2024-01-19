package com.mpl.androidapp.unity.reactNavigation;

import android.content.Intent;
import com.facebook.react.bridge.ReactContext;
import com.mpl.androidapp.unity.utils.UnityProfileConstants;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/unity/reactNavigation/UnityReactNavigationImpl;", "", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "intent", "Landroid/content/Intent;", "(Lcom/facebook/react/bridge/ReactContext;Landroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "listener", "Lcom/mpl/androidapp/unity/reactNavigation/UnityReactNavigation;", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "getUnityMiniProfileData", "", "getUnityMiniProfileFlag", "", "isUnityMiniProfileIntent", "openFullUserProfile", "", "setListener", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityReactNavigationImpl.kt */
public final class UnityReactNavigationImpl {
    public static final Companion Companion = new Companion(null);
    public static final String INTENT_DOES_NOT_CONTAIN_KEY = "Intent is not having the key to start mini profile";
    public static final String INTENT_DOES_NOT_CONTAIN_REACT_DEEP_LINK_DATA_KEY = "Intent is not having the react data key";
    public static final String INTENT_IS_NULL = "Intent passed is null";
    public static final String INTENT_UNITY_MINI_PROFILE_FLOW_IS_FALSE = "Intent unity profile flow is false";
    public static final String REACT_CONTEXT_NULL = "React context is null";
    public final Intent intent;
    public UnityReactNavigation listener;
    public final ReactContext reactContext;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/unity/reactNavigation/UnityReactNavigationImpl$Companion;", "", "()V", "INTENT_DOES_NOT_CONTAIN_KEY", "", "INTENT_DOES_NOT_CONTAIN_REACT_DEEP_LINK_DATA_KEY", "INTENT_IS_NULL", "INTENT_UNITY_MINI_PROFILE_FLOW_IS_FALSE", "REACT_CONTEXT_NULL", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityReactNavigationImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnityReactNavigationImpl() {
        this(null, null, 3, null);
    }

    public UnityReactNavigationImpl(ReactContext reactContext2, Intent intent2) {
        this.reactContext = reactContext2;
        this.intent = intent2;
    }

    private final String getUnityMiniProfileData() {
        Intent intent2 = this.intent;
        boolean z = false;
        if (intent2 != null && intent2.hasExtra(UnityProfileConstants.UNITY_MINI_PROFILE_DEEP_LINK)) {
            z = true;
        }
        return z ? this.intent.getStringExtra(UnityProfileConstants.UNITY_MINI_PROFILE_DEEP_LINK) : "";
    }

    private final boolean getUnityMiniProfileFlag() {
        Intent intent2 = this.intent;
        boolean z = true;
        if (intent2 == null || !intent2.hasExtra(UnityProfileConstants.UNITY_MINI_PROFILE_FLAG)) {
            z = false;
        }
        if (z) {
            return this.intent.getBooleanExtra(UnityProfileConstants.UNITY_MINI_PROFILE_FLAG, false);
        }
        return false;
    }

    private final boolean isUnityMiniProfileIntent() {
        if (this.reactContext == null) {
            MLogger.d("UnitiyMiniProfile", REACT_CONTEXT_NULL);
            return false;
        }
        Intent intent2 = this.intent;
        if (intent2 == null) {
            MLogger.d("UnitiyMiniProfile", INTENT_IS_NULL);
            return false;
        } else if (!intent2.hasExtra(UnityProfileConstants.UNITY_MINI_PROFILE_FLAG)) {
            MLogger.d(UnityProfileConstants.UNITY_MINI_PROFILE_FLAG, INTENT_DOES_NOT_CONTAIN_KEY);
            return false;
        } else if (!this.intent.hasExtra(UnityProfileConstants.UNITY_MINI_PROFILE_DEEP_LINK)) {
            MLogger.d(UnityProfileConstants.UNITY_MINI_PROFILE_FLAG, INTENT_DOES_NOT_CONTAIN_REACT_DEEP_LINK_DATA_KEY);
            return false;
        } else if (getUnityMiniProfileFlag()) {
            return true;
        } else {
            MLogger.d(UnityProfileConstants.UNITY_MINI_PROFILE_FLAG, INTENT_UNITY_MINI_PROFILE_FLOW_IS_FALSE);
            return false;
        }
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    public final void openFullUserProfile() {
        if (isUnityMiniProfileIntent()) {
            String unityMiniProfileData = getUnityMiniProfileData();
            if (unityMiniProfileData != null) {
                UnityReactNavigation unityReactNavigation = this.listener;
                if (unityReactNavigation != null) {
                    unityReactNavigation.openMiniProfile("notification_data", unityMiniProfileData);
                }
            }
        }
    }

    public final void setListener(UnityReactNavigation unityReactNavigation) {
        Intrinsics.checkNotNullParameter(unityReactNavigation, "listener");
        this.listener = unityReactNavigation;
    }

    public /* synthetic */ UnityReactNavigationImpl(ReactContext reactContext2, Intent intent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : reactContext2, (i & 2) != 0 ? null : intent2);
    }
}
