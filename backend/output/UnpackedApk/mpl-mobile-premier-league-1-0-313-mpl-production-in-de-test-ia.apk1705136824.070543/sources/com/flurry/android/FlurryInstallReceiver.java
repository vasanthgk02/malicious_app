package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.flurry.sdk.jq;
import com.flurry.sdk.nx;
import in.juspay.hypersdk.core.InflateView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class FlurryInstallReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1694a = FlurryInstallReceiver.class.getSimpleName();

    public final void onReceive(Context context, Intent intent) {
        String str;
        intent.getAction();
        String string = intent.getExtras().getString("referrer");
        if (string != null && "com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            if (!string.contains(InflateView.SETTER_EQUALS)) {
                try {
                    str = URLDecoder.decode(string, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    str = "";
                }
                string = str;
            }
            jq jqVar = new jq(context);
            synchronized (jqVar) {
                if (string != null) {
                    jqVar.f1696e = string;
                }
                File file = jqVar.f1695d;
                String str2 = jqVar.f1696e;
                if (file != null) {
                    if (str2 == null) {
                        file.getAbsolutePath();
                        file.delete();
                    } else {
                        file.getAbsolutePath();
                        FileOutputStream fileOutputStream = null;
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(str2.getBytes());
                                nx.a(fileOutputStream2);
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    Log.getStackTraceString(th);
                                } finally {
                                    nx.a(fileOutputStream);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            Log.getStackTraceString(th);
                        }
                    }
                }
            }
        }
    }
}
