package com.braintreepayments.browserswitch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.braintreepayments.api.BraintreeFragment;
import org.json.JSONObject;

public abstract class BrowserSwitchFragment extends Fragment implements BrowserSwitchListener {
    public BrowserSwitchClient browserSwitchClient = null;
    public String returnUrlScheme;

    public void onAttach(Context context) {
        super.onAttach(context);
        String packageName = context.getApplicationContext().getPackageName();
        this.returnUrlScheme = packageName.toLowerCase().replace("_", "") + ".browserswitch";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.browserSwitchClient = new BrowserSwitchClient(new BrowserSwitchConfig(), new ActivityFinder(), BrowserSwitchPersistentStore.INSTANCE, ((BraintreeFragment) this).mReturnUrlScheme);
    }

    public void onResume() {
        BrowserSwitchResult browserSwitchResult;
        super.onResume();
        BrowserSwitchClient browserSwitchClient2 = this.browserSwitchClient;
        Uri uri = null;
        if (browserSwitchClient2 != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Context applicationContext = activity.getApplicationContext();
                BrowserSwitchRequest activeRequest = browserSwitchClient2.persistentStore.getActiveRequest(applicationContext);
                if (activeRequest == null) {
                    return;
                }
                if (browserSwitchClient2.persistentStore != null) {
                    applicationContext.getApplicationContext().getSharedPreferences("com.braintreepayament.browserswitch.persistentstore", 0).edit().remove("browserSwitch.request").apply();
                    int i = activeRequest.requestCode;
                    JSONObject jSONObject = activeRequest.metadata;
                    if (activeRequest.state.equalsIgnoreCase("SUCCESS")) {
                        Uri uri2 = activeRequest.uri;
                        browserSwitchResult = new BrowserSwitchResult(1, null, jSONObject);
                        uri = uri2;
                    } else {
                        browserSwitchResult = new BrowserSwitchResult(2, null, jSONObject);
                    }
                    onBrowserSwitchResult(i, browserSwitchResult, uri);
                    return;
                }
                throw null;
            }
            throw new IllegalStateException("Fragment must be attached to an activity.");
        }
        throw null;
    }
}
