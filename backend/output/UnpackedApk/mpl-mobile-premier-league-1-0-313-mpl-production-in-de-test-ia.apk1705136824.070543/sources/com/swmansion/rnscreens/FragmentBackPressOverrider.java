package com.swmansion.rnscreens;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/FragmentBackPressOverrider;", "", "fragment", "Landroidx/fragment/app/Fragment;", "mOnBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/fragment/app/Fragment;Landroidx/activity/OnBackPressedCallback;)V", "mIsBackCallbackAdded", "", "overrideBackAction", "getOverrideBackAction", "()Z", "setOverrideBackAction", "(Z)V", "maybeAddBackCallback", "", "removeBackCallbackIfAdded", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentBackPressOverrider.kt */
public final class FragmentBackPressOverrider {
    public final Fragment fragment;
    public boolean mIsBackCallbackAdded;
    public final OnBackPressedCallback mOnBackPressedCallback;
    public boolean overrideBackAction = true;

    public FragmentBackPressOverrider(Fragment fragment2, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "mOnBackPressedCallback");
        this.fragment = fragment2;
        this.mOnBackPressedCallback = onBackPressedCallback;
    }

    public final void maybeAddBackCallback() {
        if (!this.mIsBackCallbackAdded && this.overrideBackAction) {
            FragmentActivity activity = this.fragment.getActivity();
            if (activity != null) {
                OnBackPressedDispatcher onBackPressedDispatcher = activity.getOnBackPressedDispatcher();
                if (onBackPressedDispatcher != null) {
                    onBackPressedDispatcher.addCallback(this.fragment, this.mOnBackPressedCallback);
                }
            }
            this.mIsBackCallbackAdded = true;
        }
    }
}
