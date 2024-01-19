package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import com.inca.security.Proxy.iIiIiIiIii;
import java.io.Serializable;

public class PlayerActivity extends Activity {
    public PlayerController playerController;

    public static class PlayerItem implements Serializable {
        public final String callToActionText = null;
        public final String callToActionUrl = null;
        public final boolean looping;
        public final boolean showVideoControls;
        public final String url;

        public PlayerItem(String str, boolean z, boolean z2, String str2, String str3) {
            this.url = str;
            this.looping = z;
            this.showVideoControls = z2;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R$anim.tw__slide_out);
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 2024374238, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, 1625389673, new Object[0]);
    }

    public void onPause() {
        iIiIiIiIii.IiiiIiiiII(this, -932491685, new Object[0]);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 1129280575, new Object[0]);
    }
}
