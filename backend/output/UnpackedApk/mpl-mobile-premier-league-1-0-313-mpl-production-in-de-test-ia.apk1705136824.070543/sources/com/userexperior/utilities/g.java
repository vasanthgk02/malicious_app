package com.userexperior.utilities;

import android.content.BroadcastReceiver.PendingResult;
import android.os.AsyncTask;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.interfaces.recording.c;
import java.lang.ref.WeakReference;
import java.util.logging.Level;

public final class g extends AsyncTask<String, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    public final String f4275a = "recentapps";

    /* renamed from: b  reason: collision with root package name */
    public final String f4276b = "homekey";

    /* renamed from: c  reason: collision with root package name */
    public c f4277c;

    /* renamed from: d  reason: collision with root package name */
    public PendingResult f4278d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<f> f4279e;

    public g(f fVar, c cVar, PendingResult pendingResult) {
        this.f4277c = cVar;
        this.f4278d = pendingResult;
        this.f4279e = new WeakReference<>(fVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Void doInBackground(String... strArr) {
        f fVar;
        try {
            boolean z = true;
            if (strArr.length <= 1) {
                return null;
            }
            boolean z2 = false;
            String str = strArr[0];
            if (str == null || !str.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                StringBuilder sb = new StringBuilder("action != ACTION_CLOSE_SYSTEM_DIALOGS. first ");
                if (f.g) {
                    z = false;
                }
                sb.append(z);
                f.g = false;
                this.f4278d.finish();
                return null;
            }
            String str2 = strArr[1];
            StringBuilder sb2 = new StringBuilder("action:");
            sb2.append(str);
            sb2.append(" reason:");
            sb2.append(str2);
            if (!(str2 == null || this.f4277c == null)) {
                if (str2.equals("homekey")) {
                    StringBuilder sb3 = new StringBuilder("SYSTEM_DIALOG_REASON_HOME_KEY. alreadyDetected = ");
                    if (!f.g) {
                        z2 = true;
                    }
                    sb3.append(z2);
                    if (!f.g) {
                        this.f4277c.a();
                        if (!(this.f4279e == null || this.f4279e.get() == null)) {
                            fVar = (f) this.f4279e.get();
                        }
                        f.g = true;
                    }
                } else if (str2.equals("recentapps")) {
                    StringBuilder sb4 = new StringBuilder("SYSTEM_DIALOG_REASON_RECENT_APPS. alreadyDetected = ");
                    if (!f.g) {
                        z2 = true;
                    }
                    sb4.append(z2);
                    if (!f.g) {
                        if (!(this.f4279e == null || this.f4279e.get() == null)) {
                            fVar = (f) this.f4279e.get();
                        }
                        f.g = true;
                    }
                }
                f.a(fVar);
                f.g = true;
            }
            this.f4278d.finish();
            return null;
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("Ex : HD - doInBackground() : "), Level.SEVERE);
        }
    }
}
