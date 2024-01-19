package com.mpl.androidapp.onesignal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.Util;

public class DialogActivity extends Activity implements OnClickListener {
    public static final String TAG = "DialogActivity";
    public Button dialogOkButton;

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel_button) {
            finish();
        } else if (id == R.id.ok_button) {
            if (this.dialogOkButton.getText().toString().equalsIgnoreCase("Rate Us")) {
                Util.openAppInPlayStore(this);
            }
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 589334142, bundle);
    }
}
