package com.jakewharton.processphoenix;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public final class ProcessPhoenix extends Activity {
    public static void triggerRebirth(Context context, Intent... intentArr) {
        if (intentArr.length >= 1) {
            intentArr[0].addFlags(268468224);
            Intent intent = new Intent(context, ProcessPhoenix.class);
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.putParcelableArrayListExtra("phoenix_restart_intents", new ArrayList(Arrays.asList(intentArr)));
            intent.putExtra("phoenix_main_process_pid", Process.myPid());
            context.startActivity(intent);
            return;
        }
        throw new IllegalArgumentException("intents cannot be empty");
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1159889568, bundle);
    }

    public static void triggerRebirth(Context context) {
        Intent[] intentArr = new Intent[1];
        String packageName = context.getPackageName();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            intentArr[0] = launchIntentForPackage;
            triggerRebirth(context, intentArr);
            return;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline52("Unable to determine default activity for ", packageName, ". Does an activity specify the DEFAULT category in its intent filter?"));
    }
}
