package com.freshchat.consumer.sdk.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import com.freshchat.consumer.sdk.j.cc;
import com.freshchat.consumer.sdk.j.q;

@TargetApi(14)
public class d extends cc {
    private void a(Activity activity) {
        try {
            e.i((Context) activity).cb();
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[Catch:{ Exception -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.app.Activity r11) {
        /*
            r10 = this;
            com.freshchat.consumer.sdk.b.e r0 = com.freshchat.consumer.sdk.b.e.i(r11)     // Catch:{ Exception -> 0x002e }
            java.lang.String r0 = r0.ca()     // Catch:{ Exception -> 0x002e }
            r1 = 0
            boolean r2 = com.freshchat.consumer.sdk.j.as.isEmpty(r0)     // Catch:{ Exception -> 0x002e }
            r3 = 1
            if (r2 == 0) goto L_0x0012
        L_0x0010:
            r1 = 1
            goto L_0x0028
        L_0x0012:
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x002e }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002e }
            com.freshchat.consumer.sdk.beans.config.RemoteConfig r0 = com.freshchat.consumer.sdk.j.ap.bD(r11)     // Catch:{ Exception -> 0x002e }
            long r8 = r0.getSessionTimeoutInterval()     // Catch:{ Exception -> 0x002e }
            long r6 = r6 - r4
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0028
            goto L_0x0010
        L_0x0028:
            if (r1 == 0) goto L_0x0032
            com.freshchat.consumer.sdk.j.b.U(r11)     // Catch:{ Exception -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r11 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r11)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.b.d.b(android.app.Activity):void");
    }

    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    public void onActivityResumed(Activity activity) {
        b(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
