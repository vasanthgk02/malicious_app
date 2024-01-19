package com.twitter.sdk.android.tweetcomposer;

import android.app.Activity;
import android.os.Bundle;
import com.inca.security.Proxy.iIiIiIiIii;

public class ComposerActivity extends Activity {
    public ComposerController composerController;

    public interface Finisher {
    }

    public class FinisherImpl implements Finisher {
        public FinisherImpl() {
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.composerController.onClose();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1351425641, bundle);
    }
}
