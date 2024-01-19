package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.xiaomi.channel.commonutils.logger.b;

public class BridgeActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 51;
        window.setAttributes(attributes);
    }

    public void onResume() {
        super.onResume();
        try {
            Intent intent = getIntent();
            if (intent != null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    PushMessageHandler.a(getApplicationContext(), intent2);
                }
            }
        } catch (Exception e2) {
            b.a((Throwable) e2);
        } catch (Throwable th) {
            finish();
            throw th;
        }
        finish();
    }
}
