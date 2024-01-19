package io.hansel.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.hansel.core.logger.HSLLogger;

public class DiagnosticsCommandReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() != null && intent.getAction().equals("io.hansel.diagnostics.request")) {
                    String stringExtra = intent.getStringExtra("d");
                    String stringExtra2 = intent.getStringExtra("p");
                    if (stringExtra != null) {
                        new b(context).a(stringExtra, stringExtra2);
                    }
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }
}
