package com.userexperior;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.Logger;
import com.mpl.androidapp.Featurestag;
import com.userexperior.UserExperior;
import com.userexperior.c.b.d;
import com.userexperior.e.h;
import com.userexperior.interfaces.recording.UserExperiorListener;
import com.userexperior.models.recording.enums.UeCustomType;
import com.userexperior.services.recording.EventSession;
import com.userexperior.services.recording.f;
import com.userexperior.services.recording.f.AnonymousClass28;
import com.userexperior.services.recording.f.AnonymousClass29;
import com.userexperior.services.recording.f.AnonymousClass37;
import com.userexperior.ui.UeConsentActivity;
import com.userexperior.utilities.a;
import com.userexperior.utilities.b;
import com.userexperior.utilities.e;
import com.userexperior.utilities.j;
import com.userexperior.utilities.l;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import org.apache.fontbox.cmap.CMap;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.json.JSONObject;

public class UserExperior {
    public static final String TAG = "UserExperior";
    public static String UE_SDK_APP_VERSION_KEY;
    public static boolean isInitialized;
    public static UserExperiorListener userExperiorListener;

    @Deprecated
    public static void consent() {
        if (isInitialized) {
            try {
                Context a2 = a.a();
                if (!a2.getSharedPreferences(TAG, 0).getBoolean("consent", false)) {
                    Intent intent = new Intent(a2, UeConsentActivity.class);
                    intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
                    a2.startActivity(intent);
                }
            } catch (Exception e2) {
                GeneratedOutlineSupport.outline95(e2, new StringBuilder("consent: "), Level.INFO);
            }
        } else {
            b.a(Level.SEVERE, "Can't c, UE not initialized");
        }
    }

    @Deprecated
    public static void endTimer(String str) throws Exception {
        try {
            endTimer(str, (HashMap<String, String>) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void endTimer(String str, HashMap<String, String> hashMap) throws Exception {
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("Given timer name is either null or empty.");
        } else if (str.length() <= 250) {
            if (isInitialized) {
                long currentTimeMillis = System.currentTimeMillis();
                f g = f.g();
                if (g != null) {
                    try {
                        if (g.f4140c != null) {
                            Handler handler = g.f4140c;
                            AnonymousClass28 r2 = new Runnable(str, currentTimeMillis, hashMap) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f4205a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ long f4206b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ HashMap f4207c;

                                {
                                    this.f4205a = r2;
                                    this.f4206b = r3;
                                    this.f4207c = r5;
                                }

                                /* JADX WARNING: Code restructure failed: missing block: B:23:0x00aa, code lost:
                                    return;
                                 */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void run() {
                                    /*
                                        r9 = this;
                                        monitor-enter(r9)
                                        com.userexperior.services.recording.f.h     // Catch:{ all -> 0x00ab }
                                        com.userexperior.services.recording.f r0 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.util.Map r0 = r0.D     // Catch:{ all -> 0x00ab }
                                        if (r0 == 0) goto L_0x00a9
                                        com.userexperior.services.recording.f r0 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.util.Map r0 = r0.D     // Catch:{ all -> 0x00ab }
                                        java.lang.String r1 = r9.f4205a     // Catch:{ all -> 0x00ab }
                                        boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x00ab }
                                        if (r0 == 0) goto L_0x00a9
                                        com.userexperior.services.recording.f r0 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.util.Map r0 = r0.D     // Catch:{ all -> 0x00ab }
                                        java.lang.String r1 = r9.f4205a     // Catch:{ all -> 0x00ab }
                                        java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00ab }
                                        java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x00ab }
                                        if (r0 == 0) goto L_0x00a9
                                        long r1 = r0.longValue()     // Catch:{ all -> 0x00ab }
                                        r3 = 0
                                        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                                        if (r5 == 0) goto L_0x0095
                                        long r1 = r9.f4206b     // Catch:{ all -> 0x00ab }
                                        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                                        if (r5 != 0) goto L_0x003b
                                        goto L_0x0095
                                    L_0x003b:
                                        long r1 = r0.longValue()     // Catch:{ all -> 0x00ab }
                                        long r3 = r9.f4206b     // Catch:{ all -> 0x00ab }
                                        java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00ab }
                                        long r1 = com.userexperior.e.h.a(r1, r3, r5)     // Catch:{ all -> 0x00ab }
                                        r3 = 0
                                        com.userexperior.services.recording.f r4 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.util.HashMap r4 = r4.I     // Catch:{ all -> 0x00ab }
                                        boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x00ab }
                                        if (r4 != 0) goto L_0x0075
                                        com.userexperior.services.recording.f r4 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.util.HashMap r4 = r4.I     // Catch:{ all -> 0x00ab }
                                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
                                        r5.<init>()     // Catch:{ all -> 0x00ab }
                                        java.lang.String r6 = r9.f4205a     // Catch:{ all -> 0x00ab }
                                        r5.append(r6)     // Catch:{ all -> 0x00ab }
                                        r5.append(r0)     // Catch:{ all -> 0x00ab }
                                        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ab }
                                        java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00ab }
                                        com.userexperior.c.a.e r4 = (com.userexperior.c.a.e) r4     // Catch:{ all -> 0x00ab }
                                        if (r4 == 0) goto L_0x0075
                                        java.util.HashMap<java.lang.String, java.lang.String> r3 = r4.f3818d     // Catch:{ all -> 0x00ab }
                                    L_0x0075:
                                        r6 = r3
                                        com.userexperior.services.recording.f r3 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.lang.String r4 = r9.f4205a     // Catch:{ all -> 0x00ab }
                                        int r5 = (int) r1     // Catch:{ all -> 0x00ab }
                                        long r7 = r0.longValue()     // Catch:{ all -> 0x00ab }
                                        java.util.HashMap r0 = r9.f4207c     // Catch:{ all -> 0x00ab }
                                        r1 = r3
                                        r2 = r4
                                        r3 = r5
                                        r4 = r7
                                        r7 = r0
                                        r1.a(r2, r3, r4, r6, r7)     // Catch:{ all -> 0x00ab }
                                        com.userexperior.services.recording.f r0 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.util.Map r0 = r0.D     // Catch:{ all -> 0x00ab }
                                        java.lang.String r1 = r9.f4205a     // Catch:{ all -> 0x00ab }
                                        r0.remove(r1)     // Catch:{ all -> 0x00ab }
                                        goto L_0x00a9
                                    L_0x0095:
                                        java.util.logging.Level r0 = java.util.logging.Level.INFO     // Catch:{ all -> 0x00ab }
                                        java.lang.String r1 = "Start/End Timer is not set properly"
                                        com.userexperior.utilities.b.a(r0, r1)     // Catch:{ all -> 0x00ab }
                                        com.userexperior.services.recording.f r0 = com.userexperior.services.recording.f.this     // Catch:{ all -> 0x00ab }
                                        java.util.Map r0 = r0.D     // Catch:{ all -> 0x00ab }
                                        java.lang.String r1 = r9.f4205a     // Catch:{ all -> 0x00ab }
                                        r0.remove(r1)     // Catch:{ all -> 0x00ab }
                                        monitor-exit(r9)     // Catch:{ all -> 0x00ab }
                                        return
                                    L_0x00a9:
                                        monitor-exit(r9)     // Catch:{ all -> 0x00ab }
                                        return
                                    L_0x00ab:
                                        r0 = move-exception
                                        monitor-exit(r9)     // Catch:{ all -> 0x00ab }
                                        throw r0
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.f.AnonymousClass28.run():void");
                                }
                            };
                            handler.post(r2);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            b.a(Level.SEVERE, "Can't end timer, UserExperior SDK not initialized");
        } else {
            throw new Exception("Given timer name length is more than supported limit - 250 characters");
        }
    }

    public static void endTimer(String str, JSONObject jSONObject) {
        try {
            HashMap<String, Object> a2 = h.a(jSONObject);
            HashMap hashMap = new HashMap();
            for (Entry next : a2.entrySet()) {
                if (next.getValue() instanceof String) {
                    hashMap.put((String) next.getKey(), (String) next.getValue());
                }
            }
            endTimer(str, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean getOptOutStatus() {
        return l.t(a.a());
    }

    public static String getSessionUrl(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        f g = f.g();
        if (g != null) {
            HashMap hashMap = new HashMap();
            com.userexperior.c.b.a e2 = l.e(g.g);
            d dVar = e2 != null ? e2.h : null;
            if (dVar == null) {
                return null;
            }
            if (dVar.f3869a) {
                hashMap.put("firebasegoogleanalytics", "fga");
                hashMap.put("firebasegoogleAnalytics", "fga");
                hashMap.put("firebaseGoogleanalytics", "fga");
                hashMap.put("firebaseGoogleAnalytics", "fga");
                hashMap.put("Firebasegoogleanalytics", "fga");
                hashMap.put("FirebasegoogleAnalytics", "fga");
                hashMap.put("FirebaseGoogleanalytics", "fga");
                hashMap.put("FirebaseGoogleAnalytics", "fga");
            }
            if (dVar.f3870b) {
                hashMap.put("firebasecrashlytics", "fc");
                hashMap.put("firebaseCrashlytics", "fc");
                hashMap.put("Firebasecrashlytics", "fc");
                hashMap.put(Logger.TAG, "fc");
            }
            if (dVar.f3871c) {
                hashMap.put("Amplitude", "amp");
                hashMap.put("amplitude", "amp");
            }
            if (dVar.f3872d) {
                hashMap.put("Mixpanel", "mp");
                hashMap.put("mixpanel", "mp");
            }
            if (dVar.f3873e) {
                hashMap.put("CleverTap", "ct");
                hashMap.put("cleverTap", "ct");
                hashMap.put("clevertap", "ct");
                hashMap.put(Featurestag.CLEVERTAP, "ct");
            }
            if (dVar.f3874f) {
                hashMap.put("AppsFlyer", "af");
                hashMap.put("appsFlyer", "af");
                hashMap.put("appsflyer", "af");
                hashMap.put(Featurestag.APPSFLYER, "af");
            }
            if (dVar.g) {
                hashMap.put("Apptimize", "am");
                hashMap.put("apptimize", "am");
            }
            if (dVar.h) {
                hashMap.put("Moengage", "mo");
                hashMap.put("moengage", "mo");
                hashMap.put("moEngage", "mo");
                hashMap.put("MoEngage", "mo");
            }
            if (!hashMap.containsKey(str)) {
                return null;
            }
            String string = g.g.getSharedPreferences(TAG, 0).getString("tpToken", null);
            int i = g.g.getSharedPreferences(TAG, 0).getInt("tpVal", 100);
            com.userexperior.models.recording.f k = g.k();
            if (string == null) {
                string = e2.o + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.a(i);
                Editor edit = g.g.getSharedPreferences(TAG, 0).edit();
                edit.putInt("tpVal", i + 1);
                edit.apply();
            }
            Editor edit2 = g.g.getSharedPreferences(TAG, 0).edit();
            edit2.putString("tpToken", string);
            edit2.apply();
            k.w = string;
            k.x = e2.p;
            l.a(g.g, k);
            return "uxr.app/e/".concat(String.valueOf(string));
        }
        b.a(Level.SEVERE, "Can't gSU, UE not initialized(EM)");
        return null;
    }

    public static String getUeSdkAppVersionKey() {
        return UE_SDK_APP_VERSION_KEY;
    }

    public static UserExperiorListener getUserExperiorListener() {
        return userExperiorListener;
    }

    public static boolean isRecording() {
        if (!isInitialized) {
            b.a(Level.SEVERE, "isRecording() failed. UserExperior SDK not initialized");
            return false;
        }
        if (f.g() != null) {
            f g = f.g();
            if (g.f4141d && !l.x(g.g)) {
                return true;
            }
        }
        return false;
    }

    public static void logEvent(String str) throws Exception {
        try {
            setCustomTag(str, UeCustomType.EVENT);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void logEvent(String str, HashMap<String, Object> hashMap) throws Exception {
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("Given event is either null or empty.");
        } else if (str.length() > 256) {
            throw new Exception("Given event length is more than supported limit - 255 characters");
        } else if (hashMap == null || hashMap.size() == 0) {
            logEvent(str);
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (isInitialized) {
                f g = f.g();
                if (g != null) {
                    try {
                        if (g.f4140c != null) {
                            Handler handler = g.f4140c;
                            com.userexperior.services.recording.f.AnonymousClass2 r1 = new Runnable(str, hashMap, uptimeMillis) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f4186a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ HashMap f4187b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f4188c;

                                {
                                    this.f4186a = r2;
                                    this.f4187b = r3;
                                    this.f4188c = r4;
                                }

                                public final void run() {
                                    String str;
                                    if (f.this.w != null) {
                                        Activity c2 = f.this.w.c();
                                        if (c2 != null) {
                                            str = c2.getClass().getSimpleName();
                                            f fVar = f.this;
                                            fVar.a(com.userexperior.models.recording.enums.h.EVENT, this.f4186a, this.f4187b, str, fVar.a(this.f4188c));
                                        }
                                    }
                                    str = "APPLICATION";
                                    f fVar2 = f.this;
                                    fVar2.a(com.userexperior.models.recording.enums.h.EVENT, this.f4186a, this.f4187b, str, fVar2.a(this.f4188c));
                                }
                            };
                            handler.post(r1);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            b.a(Level.SEVERE, "Can't log evt, UserExperior SDK not initialized");
        }
    }

    public static void logEvent(String str, JSONObject jSONObject) {
        try {
            logEvent(str, h.a(jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void logMessage(String str) throws Exception {
        try {
            setCustomTag(str, UeCustomType.MSG);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void logMessage(String str, HashMap<String, Object> hashMap) throws Exception {
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("Given msg is either null or empty.");
        } else if (str.length() > 256) {
            throw new Exception("Given msg length is more than supported limit - 255 characters");
        } else if (hashMap == null || hashMap.size() == 0) {
            logMessage(str);
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (isInitialized) {
                f g = f.g();
                if (g != null) {
                    try {
                        if (g.f4140c != null) {
                            Handler handler = g.f4140c;
                            com.userexperior.services.recording.f.AnonymousClass3 r1 = new Runnable(str, hashMap, uptimeMillis) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f4212a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ HashMap f4213b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f4214c;

                                {
                                    this.f4212a = r2;
                                    this.f4213b = r3;
                                    this.f4214c = r4;
                                }

                                public final void run() {
                                    String str;
                                    if (f.this.w != null) {
                                        Activity c2 = f.this.w.c();
                                        if (c2 != null) {
                                            str = c2.getClass().getSimpleName();
                                            f fVar = f.this;
                                            fVar.a(com.userexperior.models.recording.enums.h.MSG, this.f4212a, this.f4213b, str, fVar.a(this.f4214c));
                                        }
                                    }
                                    str = "APPLICATION";
                                    f fVar2 = f.this;
                                    fVar2.a(com.userexperior.models.recording.enums.h.MSG, this.f4212a, this.f4213b, str, fVar2.a(this.f4214c));
                                }
                            };
                            handler.post(r1);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            b.a(Level.SEVERE, "Can't log msg, UserExperior SDK not initialized");
        }
    }

    public static void logMessage(String str, JSONObject jSONObject) {
        try {
            logMessage(str, h.a(jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void optIn() {
        try {
            if (isInitialized) {
                Context a2 = a.a();
                l.a(a2, false);
                startRecording(a2, getUeSdkAppVersionKey());
                b.a(Level.INFO, "o-i");
                return;
            }
            b.a(Level.SEVERE, "Can't oI, UE not initialized");
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("oI: "), Level.INFO);
        }
    }

    public static void optOut() {
        try {
            if (isInitialized) {
                l.a(a.a(), true);
                f g = f.g();
                if (g != null) {
                    if (g.f4140c != null) {
                        g.f4140c.post(new Runnable() {
                            public final void run() {
                                String i = j.i(f.this.g);
                                f.this.o();
                                l.d(f.this.g, i);
                                l.b(f.this.g);
                                f.a(f.this, i);
                                b.a(Level.INFO, "o-o");
                            }
                        });
                    }
                    return;
                }
                b.a(Level.SEVERE, "Can't oO, UE not initialized(EM)");
                return;
            }
            b.a(Level.SEVERE, "Can't oO, UE not initialized");
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("oo: "), Level.INFO);
        }
    }

    public static void pauseRecording() {
        b.a(Level.INFO, "### PRA");
        if (isInitialized) {
            f g = f.g();
            if (g != null) {
                if (g.f4140c == null) {
                    g.h();
                }
                Handler handler = g.f4140c;
                if (handler != null) {
                    handler.post(new Runnable() {
                        public final void run() {
                            f.this.x();
                            l.c(f.this.g, true);
                            f.a(f.this, 2);
                        }
                    });
                }
                return;
            }
        }
        b.a(Level.SEVERE, "Can't pauseRecording, UserExperior SDK not initialized");
    }

    public static void resumeRecording() {
        Level level;
        String str;
        b.a(Level.INFO, "### RRA");
        if (isInitialized) {
            f g = f.g();
            if (g != null) {
                Handler handler = g.f4140c;
                if (handler != null) {
                    handler.post(new Runnable() {
                        public final void run() {
                            String str;
                            Level level;
                            if (!f.this.f4141d) {
                                f.this.j();
                                level = Level.INFO;
                                str = "R -- R v S -- R";
                            } else {
                                f.this.a(2);
                                level = Level.INFO;
                                str = "R resumed with pause-resume called......";
                            }
                            b.a(level, str);
                            l.c(f.this.g, false);
                        }
                    });
                }
                return;
            }
            level = Level.SEVERE;
            str = "Can't resumeRecording, UserExperior SDK not initialized(EM)";
        } else {
            level = Level.SEVERE;
            str = "Can't resumeRecording, UserExperior SDK not initialized";
        }
        b.a(level, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c A[SYNTHETIC, Splitter:B:38:0x009c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void sendException(java.lang.Throwable r11, java.lang.String r12) {
        /*
            if (r11 != 0) goto L_0x000a
            java.util.logging.Level r11 = java.util.logging.Level.INFO
            java.lang.String r12 = "Can't send exception, Exception Obj is null"
            com.userexperior.utilities.b.a(r11, r12)
            return
        L_0x000a:
            if (r12 == 0) goto L_0x0142
            java.lang.String r0 = ""
            boolean r1 = r12.equalsIgnoreCase(r0)
            if (r1 != 0) goto L_0x0142
            int r1 = r12.length()
            r2 = 250(0xfa, float:3.5E-43)
            if (r1 <= r2) goto L_0x001e
            goto L_0x0142
        L_0x001e:
            boolean r1 = isInitialized
            java.lang.String r2 = "Can't send exception, UserExperior SDK not initialized"
            if (r1 == 0) goto L_0x013c
            com.userexperior.services.recording.f r1 = com.userexperior.services.recording.f.g()
            if (r1 == 0) goto L_0x0136
            boolean r2 = r1.f4141d     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x0130
            com.userexperior.services.recording.i r2 = r1.f4142e     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x0130
            com.userexperior.services.recording.i r1 = r1.f4142e     // Catch:{ Exception -> 0x0131 }
            int r2 = r1.n     // Catch:{ Exception -> 0x0131 }
            r3 = 1
            int r2 = r2 + r3
            r1.n = r2     // Catch:{ Exception -> 0x0131 }
            com.userexperior.services.recording.f r4 = com.userexperior.services.recording.f.g()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r2 = r1.l     // Catch:{ Exception -> 0x0131 }
            java.lang.String r5 = "fr"
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x0053
            com.userexperior.services.recording.b r2 = r1.f4246d     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x006f
            com.userexperior.services.recording.b r2 = r1.f4246d     // Catch:{ Exception -> 0x0131 }
            int r2 = r2.f4113a     // Catch:{ Exception -> 0x0131 }
        L_0x0050:
            r1.h = r2     // Catch:{ Exception -> 0x0131 }
            goto L_0x006f
        L_0x0053:
            java.lang.String r2 = r1.l     // Catch:{ Exception -> 0x0131 }
            java.lang.String r5 = "ca"
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x0066
            com.userexperior.services.recording.a r2 = r1.f4247e     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x006f
            com.userexperior.services.recording.a r2 = r1.f4247e     // Catch:{ Exception -> 0x0131 }
            int r2 = r2.f4107a     // Catch:{ Exception -> 0x0131 }
            goto L_0x0050
        L_0x0066:
            com.userexperior.services.recording.c r2 = r1.f4245c     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x006f
            com.userexperior.services.recording.c r2 = r1.f4245c     // Catch:{ Exception -> 0x0131 }
            int r2 = r2.f4124b     // Catch:{ Exception -> 0x0131 }
            goto L_0x0050
        L_0x006f:
            java.lang.Class r2 = r11.getClass()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r6 = r2.getCanonicalName()     // Catch:{ Exception -> 0x0131 }
            android.app.Activity r2 = com.userexperior.services.recording.i.f4242f     // Catch:{ Exception -> 0x0131 }
            if (r2 == 0) goto L_0x0086
            android.app.Activity r2 = com.userexperior.services.recording.i.f4242f     // Catch:{ Exception -> 0x0131 }
            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ Exception -> 0x0131 }
            goto L_0x0088
        L_0x0086:
            java.lang.String r2 = "APPLICATION"
        L_0x0088:
            r8 = r2
            com.userexperior.models.recording.enums.h r5 = com.userexperior.models.recording.enums.h.ERROR     // Catch:{ Exception -> 0x0131 }
            int r2 = r1.h     // Catch:{ Exception -> 0x0131 }
            int r7 = r1.j     // Catch:{ Exception -> 0x0131 }
            int r2 = r2 * r7
            long r9 = (long) r2     // Catch:{ Exception -> 0x0131 }
            r7 = r12
            r4.a(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0131 }
            int r2 = r1.n     // Catch:{ Exception -> 0x0131 }
            r4 = 10
            if (r2 > r4) goto L_0x0130
            java.lang.StringBuilder r11 = com.userexperior.services.recording.i.a(r11)     // Catch:{ IOException -> 0x012c }
            android.content.Context r2 = com.userexperior.utilities.a.a()     // Catch:{ IOException -> 0x012c }
            java.lang.String r2 = com.userexperior.utilities.j.i(r2)     // Catch:{ IOException -> 0x012c }
            java.lang.String r2 = com.userexperior.utilities.j.b(r2)     // Catch:{ IOException -> 0x012c }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x012c }
            r4.<init>(r2)     // Catch:{ IOException -> 0x012c }
            boolean r2 = r4.exists()     // Catch:{ IOException -> 0x012c }
            if (r2 == 0) goto L_0x00c0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x012c }
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x012c }
            r3 = 0
            r1.k = r3     // Catch:{ IOException -> 0x012c }
            goto L_0x00d5
        L_0x00c0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x012c }
            java.lang.String r5 = "file is created "
            r2.<init>(r5)     // Catch:{ IOException -> 0x012c }
            boolean r5 = r4.createNewFile()     // Catch:{ IOException -> 0x012c }
            r2.append(r5)     // Catch:{ IOException -> 0x012c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x012c }
            r2.<init>(r4)     // Catch:{ IOException -> 0x012c }
            r1.k = r3     // Catch:{ IOException -> 0x012c }
        L_0x00d5:
            boolean r3 = r1.k     // Catch:{ IOException -> 0x012c }
            if (r3 == 0) goto L_0x00db
            java.lang.String r0 = "Handled Exception Log(s) :\n------------------------\n\n"
        L_0x00db:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x012c }
            java.lang.String r4 = "#"
            r3.<init>(r4)     // Catch:{ IOException -> 0x012c }
            int r1 = r1.n     // Catch:{ IOException -> 0x012c }
            r3.append(r1)     // Catch:{ IOException -> 0x012c }
            java.lang.String r1 = " "
            r3.append(r1)     // Catch:{ IOException -> 0x012c }
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x012c }
            r3.append(r11)     // Catch:{ IOException -> 0x012c }
            java.lang.String r11 = r3.toString()     // Catch:{ IOException -> 0x012c }
            java.lang.String r11 = r0.concat(r11)     // Catch:{ IOException -> 0x012c }
            boolean r0 = r12.isEmpty()     // Catch:{ IOException -> 0x012c }
            if (r0 != 0) goto L_0x011e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x012c }
            java.lang.String r1 = "\nTag: "
            r0.<init>(r1)     // Catch:{ IOException -> 0x012c }
            r0.append(r12)     // Catch:{ IOException -> 0x012c }
            java.lang.String r12 = "\n"
            r0.append(r12)     // Catch:{ IOException -> 0x012c }
            java.lang.String r12 = r0.toString()     // Catch:{ IOException -> 0x012c }
            java.lang.String r11 = r11.concat(r12)     // Catch:{ IOException -> 0x012c }
            java.lang.String r12 = "\n-----------------------------------------------------------------------\n\n"
            java.lang.String r11 = r11.concat(r12)     // Catch:{ IOException -> 0x012c }
        L_0x011e:
            byte[] r11 = r11.getBytes()     // Catch:{ IOException -> 0x012c }
            r2.write(r11)     // Catch:{ IOException -> 0x012c }
            r2.flush()     // Catch:{ IOException -> 0x012c }
            r2.close()     // Catch:{ IOException -> 0x012c }
            return
        L_0x012c:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ Exception -> 0x0131 }
        L_0x0130:
            return
        L_0x0131:
            r11 = move-exception
            r11.printStackTrace()
            return
        L_0x0136:
            java.util.logging.Level r11 = java.util.logging.Level.SEVERE
            com.userexperior.utilities.b.a(r11, r2)
            return
        L_0x013c:
            java.util.logging.Level r11 = java.util.logging.Level.SEVERE
            com.userexperior.utilities.b.a(r11, r2)
            return
        L_0x0142:
            java.util.logging.Level r11 = java.util.logging.Level.INFO
            java.lang.String r12 = "Given exception tag is either null or its length is more than supported limit - 250 characters"
            com.userexperior.utilities.b.a(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.UserExperior.sendException(java.lang.Throwable, java.lang.String):void");
    }

    @Deprecated
    public static void setCustomTag(String str, String str2) throws Exception {
        if (str == null || str.equalsIgnoreCase("") || str2 == null || str2.equalsIgnoreCase("")) {
            throw new Exception("Given custom tag/custom type is either null or empty.");
        } else if (str.length() <= 256) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (isInitialized) {
                f g = f.g();
                if (g != null) {
                    try {
                        if (g.f4140c != null) {
                            Handler handler = g.f4140c;
                            AnonymousClass37 r2 = new Runnable(str, str2, uptimeMillis) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f4223a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f4224b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f4225c;

                                {
                                    this.f4223a = r2;
                                    this.f4224b = r3;
                                    this.f4225c = r4;
                                }

                                public final void run() {
                                    String str;
                                    if (f.this.w != null) {
                                        Activity c2 = f.this.w.c();
                                        if (c2 != null) {
                                            str = c2.getClass().getSimpleName();
                                            f fVar = f.this;
                                            f.a(fVar, this.f4223a, this.f4224b, str, fVar.a(this.f4225c));
                                        }
                                    }
                                    str = "APPLICATION";
                                    f fVar2 = f.this;
                                    f.a(fVar2, this.f4223a, this.f4224b, str, fVar2.a(this.f4225c));
                                }
                            };
                            handler.post(r2);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            b.a(Level.SEVERE, "Can't set custom tag, UserExperior SDK not initialized");
        } else {
            throw new Exception("Given custom tag length is more than supported limit - 256 characters");
        }
    }

    public static void setDeviceLocation(double d2, double d3) throws Exception {
        if (d2 == 0.0d && d3 == 0.0d) {
            throw new Exception("Given location params are incorrect.");
        }
        if (isInitialized) {
            f g = f.g();
            if (g != null) {
                try {
                    if (g.f4140c != null) {
                        Handler handler = g.f4140c;
                        AnonymousClass29 r2 = new Runnable(d2, d3) {

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ double f4209a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ double f4210b;

                            {
                                this.f4209a = r2;
                                this.f4210b = r4;
                            }

                            public final void run() {
                                if (f.this.f4141d) {
                                    Context a2 = f.this.g;
                                    double d2 = this.f4209a;
                                    double d3 = this.f4210b;
                                    Editor edit = a2.getSharedPreferences(UserExperior.TAG, 0).edit();
                                    edit.putString("latitudeLongitude", d2 + CMap.SPACE + d3);
                                    edit.apply();
                                    return;
                                }
                                f.h;
                            }
                        };
                        handler.post(r2);
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
        b.a(Level.SEVERE, "Can't set device location, UserExperior SDK not initialized");
    }

    public static void setUserExperiorListener(UserExperiorListener userExperiorListener2) {
        userExperiorListener = userExperiorListener2;
    }

    public static void setUserIdentifier(final String str) throws Exception {
        if (str.length() > 250) {
            throw new Exception("Given userIdentifier length is more than supported limit - 250 characters");
        } else if (!isInitialized) {
            b.a(Level.SEVERE, "setUserIdentifier() failed. UserExperior SDK not initialized");
        } else if (f.g() != null) {
            Context a2 = a.a();
            String i = l.i(a2);
            if (i != null && !i.equalsIgnoreCase(str.trim())) {
                Editor edit = a2.getSharedPreferences(TAG, 0).edit();
                edit.remove("userProp");
                edit.apply();
            }
            Editor edit2 = f.g().g.getSharedPreferences(TAG, 0).edit();
            edit2.putString("userDeviceIdOnMainProcess", str.toString());
            edit2.apply();
        } else {
            b.a(Level.SEVERE, "setUserIdentifier() failed. UserExperior SDK not initialized.(EM)");
            new Timer().schedule(new TimerTask() {
                public final void run() {
                    try {
                        UserExperior.setUserIdentifier(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }, 500);
        }
    }

    public static void setUserProperties(final HashMap<String, Object> hashMap) throws Exception {
        if (!isInitialized) {
            b.a(Level.SEVERE, "setUserIdentifier() failed. UserExperior SDK not initialized");
        } else if (f.g() != null) {
            new StringBuilder("setUserProperties -->").append(hashMap);
            f g = f.g();
            Editor edit = g.g.getSharedPreferences(TAG, 0).edit();
            edit.putString("userProp", new com.userexperior.a.a.f().a((Object) hashMap));
            edit.apply();
            com.userexperior.models.recording.f k = g.k();
            k.u = hashMap;
            l.a(g.g, k);
        } else {
            b.a(Level.SEVERE, "setUserProperties failed. UserExperior SDK not initialized.(EM)");
            new Timer().schedule(new TimerTask() {
                public final void run() {
                    try {
                        UserExperior.setUserProperties(hashMap);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }, 500);
        }
    }

    public static void setUserProperties(JSONObject jSONObject) {
        try {
            setUserProperties(h.a(jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void startRecording(final Context context, String str) {
        try {
            if (getOptOutStatus()) {
                b.a(Level.INFO, "sr: User has o-o.");
            } else if (VERSION.SDK_INT <= 33) {
                f g = f.g();
                g.a(context.getApplicationContext());
                if (!isInitialized) {
                    UE_SDK_APP_VERSION_KEY = str.trim();
                    new Thread(new Runnable() {
                        public final void run() {
                            h.b(context);
                            l.b(context, false);
                            l.c(context, false);
                        }
                    }).start();
                    isInitialized = true;
                    EventSession.a(context);
                    g.f4143f = new com.userexperior.interfaces.a() {
                        public final void a() {
                            UserExperior.isInitialized = true;
                            b.a(Level.INFO, "A-U");
                        }
                    };
                    return;
                }
                l.b(context, false);
                g.j();
            } else {
                new StringBuilder("Sorry!!! UserExperior does not provide for Android ").append(VERSION.SDK_INT);
                Level level = Level.INFO;
                b.a(level, "Sorry!!! UserExperior does not provide for Android " + VERSION.SDK_INT);
            }
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("issue at init: "), Level.INFO);
        }
    }

    public static void startRecording(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(TAG, 0).edit();
        edit.putString("appPlatform", str2);
        edit.apply();
        Editor edit2 = context.getSharedPreferences(TAG, 0).edit();
        edit2.putString("sv", str3);
        edit2.apply();
        startRecording(context, str);
    }

    public static void startScreen(String str) throws Exception {
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("Given screen name is either null or empty.");
        } else if (str.length() <= 250) {
            if (isInitialized) {
                f g = f.g();
                if (g != null) {
                    try {
                        if (g.f4140c != null) {
                            g.f4140c.post(new Runnable(str) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f4199a;

                                {
                                    this.f4199a = r2;
                                }

                                public final void run() {
                                    if (!f.this.f4141d) {
                                        f.h;
                                    } else if (f.this.f4142e != null) {
                                        f.this.f4142e;
                                        i.a(this.f4199a);
                                        f.h;
                                    }
                                }
                            });
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            b.a(Level.SEVERE, "Can't set screen name, UserExperior SDK not initialized");
        } else {
            throw new Exception("Given screen name length is more than supported limit - 250 characters");
        }
    }

    @Deprecated
    public static void startTimer(String str) throws Exception {
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("Given timer name is either null or empty.");
        } else if (str.length() <= 250) {
            if (isInitialized) {
                long currentTimeMillis = System.currentTimeMillis();
                f g = f.g();
                if (g != null) {
                    try {
                        g.a(str, currentTimeMillis, (HashMap<String, String>) null);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            b.a(Level.SEVERE, "Can't set timer, UserExperior SDK not initialized");
        } else {
            throw new Exception("Given timer name length is more than supported limit - 250 characters");
        }
    }

    public static void startTimer(String str, HashMap<String, String> hashMap) throws Exception {
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("Given timer name is either null or empty.");
        } else if (str.length() <= 250) {
            if (isInitialized) {
                long currentTimeMillis = System.currentTimeMillis();
                f g = f.g();
                if (g != null) {
                    try {
                        g.a(str, currentTimeMillis, hashMap);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            b.a(Level.SEVERE, "Can't start timer, UserExperior SDK not initialized");
        } else {
            throw new Exception("Given timer name length is more than supported limit - 250 characters");
        }
    }

    public static void startTimer(String str, JSONObject jSONObject) {
        try {
            HashMap<String, Object> a2 = h.a(jSONObject);
            HashMap hashMap = new HashMap();
            for (Entry next : a2.entrySet()) {
                if (next.getValue() instanceof String) {
                    hashMap.put((String) next.getKey(), (String) next.getValue());
                }
            }
            startTimer(str, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void stopRecording() {
        Level level;
        String str;
        b.a(Level.INFO, "### SRA");
        if (isInitialized) {
            f g = f.g();
            if (g != null) {
                l.b(a.a(), true);
                Handler handler = g.f4140c;
                if (handler != null) {
                    handler.post(new Runnable() {
                        public final void run() {
                            l.r(f.this.g);
                            l.d(f.this.g);
                            if (f.this.f4141d) {
                                f.this.q();
                                f.this.v();
                                f.this.w();
                                com.userexperior.models.recording.f r = f.this.k();
                                l.a(f.this.g, r);
                                f.a(f.this, r);
                                f.this.r();
                                return;
                            }
                            f.h;
                            l.b(f.this.g);
                        }
                    });
                }
                return;
            }
            level = Level.SEVERE;
            str = "Can't stopRecording, UserExperior SDK not initialized(EM)";
        } else {
            level = Level.SEVERE;
            str = "Can't stopRecording, UserExperior SDK not initialized";
        }
        b.a(level, str);
    }
}
