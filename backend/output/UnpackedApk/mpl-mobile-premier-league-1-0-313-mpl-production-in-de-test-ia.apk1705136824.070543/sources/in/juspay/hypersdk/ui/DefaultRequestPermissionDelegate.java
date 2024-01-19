package in.juspay.hypersdk.ui;

import in.juspay.hypersdk.core.HyperFragment;

public class DefaultRequestPermissionDelegate implements RequestPermissionDelegate {
    public final HyperFragment fragment;

    public DefaultRequestPermissionDelegate(HyperFragment hyperFragment) {
        this.fragment = hyperFragment;
    }

    public void requestPermission(String[] strArr, int i) {
        this.fragment.requestPermissions(strArr, i);
    }
}
