package com.userexperior.utilities;

import android.app.Activity;
import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.R;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class SecureViewBucket {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4258a = "SecureViewBucket";

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, List<View>> f4259b;

    public static List<View> a(Activity activity) {
        Object obj;
        if (activity == null) {
            return null;
        }
        new StringBuilder("getSecureViews for : ").append(activity.toString());
        HashMap<String, List<View>> hashMap = f4259b;
        if (hashMap != null) {
            if (hashMap.containsKey(activity.toString())) {
                obj = f4259b.get(activity.toString());
            } else if (f4259b.containsKey("MainActivity")) {
                obj = f4259b.get("MainActivity");
            }
            return (List) obj;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void addInSecureViewBucket(android.view.View r2) {
        /*
            if (r2 != 0) goto L_0x0003
            return
        L_0x0003:
            android.content.Context r0 = com.userexperior.utilities.a.a()
            java.lang.String r0 = com.userexperior.utilities.l.y(r0)
            java.lang.String r1 = "rn"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "MainActivity"
            goto L_0x001e
        L_0x0016:
            android.content.Context r0 = r2.getContext()
            java.lang.String r0 = r0.toString()
        L_0x001e:
            java.util.HashMap<java.lang.String, java.util.List<android.view.View>> r1 = f4259b
            if (r1 != 0) goto L_0x0029
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            f4259b = r1
        L_0x0029:
            java.util.HashMap<java.lang.String, java.util.List<android.view.View>> r1 = f4259b
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L_0x0045
            java.util.HashMap<java.lang.String, java.util.List<android.view.View>> r1 = f4259b
            java.lang.Object r1 = r1.get(r0)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x003f
            r1.add(r2)
            goto L_0x004d
        L_0x003f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            goto L_0x004a
        L_0x0045:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x004a:
            r1.add(r2)
        L_0x004d:
            java.util.HashMap<java.lang.String, java.util.List<android.view.View>> r2 = f4259b
            r2.put(r0, r1)
            com.userexperior.services.recording.f r2 = com.userexperior.services.recording.f.g()
            com.userexperior.services.recording.i r2 = r2.f4142e
            if (r2 == 0) goto L_0x0063
            com.userexperior.services.recording.c r2 = r2.f4245c
            if (r2 == 0) goto L_0x0063
            android.app.Activity r0 = r2.f4123a
            r2.b(r0)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.utilities.SecureViewBucket.addInSecureViewBucket(android.view.View):void");
    }

    public static void removeFromSecureViewBucket(View view) {
        if (view != null) {
            try {
                view.setTag(R.string.ue_dont_mask, "com.userexperior.dontmask");
            } catch (Exception e2) {
                GeneratedOutlineSupport.outline95(e2, new StringBuilder("rfsvb: "), Level.INFO);
            }
        } else {
            b.a(Level.INFO, "rfsvb: view is null");
        }
    }
}
