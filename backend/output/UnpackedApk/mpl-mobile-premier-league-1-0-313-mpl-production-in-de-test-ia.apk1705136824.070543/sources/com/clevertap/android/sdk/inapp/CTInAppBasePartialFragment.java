package com.clevertap.android.sdk.inapp;

import androidx.fragment.app.FragmentManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Utils;
import java.lang.ref.WeakReference;

public abstract class CTInAppBasePartialFragment extends CTInAppBaseFragment {
    public void cleanup() {
        if (!Utils.isActivityDead(getActivity()) && !this.isCleanedUp.get()) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                try {
                    fragmentManager.beginTransaction().remove(this).commit();
                } catch (IllegalStateException unused) {
                    fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
                }
            }
        }
        this.isCleanedUp.set(true);
    }

    public void generateListener() {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig != null) {
            this.listenerWeakReference = new WeakReference<>(CleverTapAPI.instanceWithConfig(this.context, cleverTapInstanceConfig).coreState.inAppController);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        didDismiss(null);
    }

    public void onPause() {
        super.onPause();
    }

    public void onStart() {
        super.onStart();
        if (this.isCleanedUp.get()) {
            cleanup();
        }
    }
}
