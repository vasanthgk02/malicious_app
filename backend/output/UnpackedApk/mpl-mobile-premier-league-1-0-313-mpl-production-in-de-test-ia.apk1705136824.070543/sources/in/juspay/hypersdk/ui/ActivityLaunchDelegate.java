package in.juspay.hypersdk.ui;

import android.content.Intent;
import android.os.Bundle;

public interface ActivityLaunchDelegate {
    void startActivityForResult(Intent intent, int i, Bundle bundle);
}
