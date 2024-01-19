package in.juspay.hypersdk.ui;

import android.content.Intent;
import android.os.Bundle;
import in.juspay.hypersdk.core.HyperFragment;

public class DefaultActivityLaunchDelegate implements ActivityLaunchDelegate {
    public HyperFragment fragment;

    public DefaultActivityLaunchDelegate(HyperFragment hyperFragment) {
        this.fragment = hyperFragment;
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.fragment.startActivityForResult(intent, i, bundle, false);
    }
}
