package com.userexperior.services.recording;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.razorpay.AnalyticsConstants;
import com.userexperior.UserExperior;
import com.userexperior.a.a.f;
import com.userexperior.c.a.e;
import com.userexperior.d.a.d;
import com.userexperior.d.b.c;
import com.userexperior.e.b.k;
import com.userexperior.e.o;
import com.userexperior.e.s;
import com.userexperior.e.t;
import com.userexperior.e.y;
import com.userexperior.interfaces.a;
import com.userexperior.interfaces.recording.b;
import com.userexperior.interfaces.recording.g;
import com.userexperior.models.recording.WindowCallback;
import com.userexperior.models.recording.enums.UeCustomType;
import com.userexperior.models.recording.enums.h;
import com.userexperior.models.recording.enums.i;
import com.userexperior.services.JIUploadService;
import com.userexperior.utilities.j;
import com.userexperior.utilities.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import sfs2x.client.util.ClientDisconnectionReason;

public class f extends HandlerThread implements ComponentCallbacks2, b {

    /* renamed from: a  reason: collision with root package name */
    public static f f4138a;
    public static final String h = f.class.getSimpleName();
    public int A = 0;
    public int B = 0;
    public boolean C = false;
    public Map<String, Long> D = new HashMap();
    public HashSet<Integer> E;
    public CountDownTimer F;
    public boolean G;
    public final String H = "SCROLL_PAUSE";
    public HashMap<String, e> I = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Application f4139b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f4140c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4141d;

    /* renamed from: e  reason: collision with root package name */
    public i f4142e;

    /* renamed from: f  reason: collision with root package name */
    public a f4143f;
    public Context g = l();
    public boolean i;
    public boolean j;
    public final int k = 0;
    public final int l = 1;
    public final int m = 2;
    public int n = 0;
    public long o;
    public long p;
    public String q;
    public String r;
    public boolean s = false;
    public boolean t = false;
    public d u;
    public UncaughtExceptionHandler v;
    public com.userexperior.models.recording.a w;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;

    public f() {
        super(h);
    }

    /* access modifiers changed from: private */
    public long a(long j2) {
        long j3;
        synchronized (this) {
            StringBuilder sb = new StringBuilder("Image Number : ");
            sb.append(this.B);
            sb.append(" = ");
            sb.append(this.B * 200);
            new StringBuilder("recordingTimeInMillisWrtScreenshots = ").append(this.o);
            new StringBuilder("delta time = ").append(j2 - this.p);
            j3 = this.o + (j2 - this.p);
            if (j3 < 0) {
                j3 = 0;
            }
            new StringBuilder("eventDownTime ").append(((float) j3) / 1000.0f);
        }
        return j3;
    }

    public static /* synthetic */ com.userexperior.c.a.a a(f fVar, h hVar, InputEvent inputEvent, String str, g gVar) {
        long j2;
        if (inputEvent != null) {
            j2 = fVar.a(inputEvent instanceof MotionEvent ? ((MotionEvent) inputEvent).getDownTime() : ((KeyEvent) inputEvent).getDownTime());
        } else {
            j2 = 0;
        }
        com.userexperior.c.a.a aVar = new com.userexperior.c.a.a(com.userexperior.models.recording.enums.a.USER, hVar, inputEvent, str, j2, gVar);
        return aVar;
    }

    public static /* synthetic */ com.userexperior.c.a.a a(f fVar, h hVar, MotionEvent motionEvent, MotionEvent motionEvent2, String str) {
        com.userexperior.c.a.a aVar = new com.userexperior.c.a.a(com.userexperior.models.recording.enums.a.USER, hVar, motionEvent, motionEvent2, str, fVar.a(motionEvent != null ? motionEvent.getDownTime() : 0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public com.userexperior.c.a.a a(String str, h hVar, long j2) {
        com.userexperior.models.recording.enums.a aVar;
        long j3;
        int ordinal = hVar.ordinal();
        h hVar2 = h.HOME_BUTTON_PRESSED;
        if (ordinal == 16) {
            aVar = com.userexperior.models.recording.enums.a.USER;
        } else {
            int ordinal2 = hVar.ordinal();
            h hVar3 = h.APP_LAUNCH;
            if (ordinal2 == 21) {
                aVar = com.userexperior.models.recording.enums.a.USER;
                j3 = 0;
                com.userexperior.c.a.a aVar2 = new com.userexperior.c.a.a(aVar, hVar, (InputEvent) null, str, j3, (g) null);
                return aVar2;
            }
            aVar = com.userexperior.models.recording.enums.a.SYSTEM;
        }
        j3 = a(j2);
        com.userexperior.c.a.a aVar22 = new com.userexperior.c.a.a(aVar, hVar, (InputEvent) null, str, j3, (g) null);
        return aVar22;
    }

    public static /* synthetic */ com.userexperior.c.a.a a(String str, h hVar, String str2, long j2) {
        com.userexperior.c.a.a aVar = new com.userexperior.c.a.a(com.userexperior.models.recording.enums.a.UE, hVar, str2, str, j2);
        return aVar;
    }

    public static /* synthetic */ com.userexperior.c.a.a a(String str, h hVar, String str2, String str3, long j2) {
        com.userexperior.c.a.a aVar = new com.userexperior.c.a.a(com.userexperior.models.recording.enums.a.UE, hVar, str2, str3, str, j2);
        return aVar;
    }

    public static /* synthetic */ com.userexperior.c.a.a a(String str, h hVar, String str2, HashMap hashMap, long j2) {
        com.userexperior.c.a.a aVar = new com.userexperior.c.a.a(com.userexperior.models.recording.enums.a.UE, hVar, str2, hashMap, str, j2);
        return aVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (i2 >= this.n && (this.f4141d && this.x)) {
            this.x = false;
            this.n = 0;
            a(false);
            this.p = SystemClock.uptimeMillis();
            if (this.f4142e != null) {
                com.userexperior.models.recording.a aVar = this.w;
                this.f4142e.a(aVar != null ? aVar.c() : null, 300);
                com.userexperior.utilities.b.a(Level.INFO, "R -- R");
            }
            new StringBuilder("doWriteForOtherEvents = true at ").append(SystemClock.uptimeMillis());
            this.t = true;
            if (i2 == 2) {
                this.f4140c.postDelayed(new Runnable() {
                    public final void run() {
                        f.h;
                        new StringBuilder("doWriteForMotionEvents = true at ").append(SystemClock.uptimeMillis());
                        f.this.s = true;
                    }
                }, 300);
            } else {
                new StringBuilder("doWriteForMotionEvents = true at ").append(SystemClock.uptimeMillis());
                this.s = true;
            }
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        com.userexperior.models.recording.a aVar = this.w;
        if (aVar != null) {
            a(h.TAP, aVar.d(), (InputEvent) motionEvent, (g) new com.userexperior.interfaces.recording.f(str, true));
        } else {
            a(h.TAP, i.a().getClass().getSimpleName(), (InputEvent) motionEvent, (g) new com.userexperior.interfaces.recording.f(str, true));
        }
    }

    /* access modifiers changed from: private */
    public void a(com.userexperior.c.a.a aVar) {
        if (this.q == null) {
            this.q = j.i(this.g);
        }
        this.r = j.a(this.q);
        StringBuilder sb = new StringBuilder("POSTING EVENT [ ");
        sb.append(aVar.f3796b);
        sb.append(" ]");
        if (this.r != null) {
            Handler handler = this.f4140c;
            if (handler != null) {
                handler.post(new com.userexperior.d.b.a(aVar, this.r));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(h hVar, String str, HashMap<String, Object> hashMap, String str2, long j2) {
        Handler handler = this.f4140c;
        if (handler != null) {
            final h hVar2 = hVar;
            final String str3 = str2;
            final long j3 = j2;
            final String str4 = str;
            final HashMap<String, Object> hashMap2 = hashMap;
            AnonymousClass13 r0 = new Runnable() {
                public final void run() {
                    f.h;
                    StringBuilder sb = new StringBuilder("event (2) ");
                    sb.append(hVar2);
                    sb.append(CMap.SPACE);
                    sb.append(str3);
                    sb.append(CMap.SPACE);
                    sb.append(j3);
                    f.this.b(false);
                    f.this.u();
                    if (f.this.t) {
                        f.this.a(f.a(str3, hVar2, str4, hashMap2, j3));
                    } else {
                        f.h;
                    }
                }
            };
            handler.post(r0);
        }
    }

    public static void a(com.userexperior.models.recording.f fVar) {
        try {
            File file = new File(fVar.f4086c);
            File[] listFiles = file.listFiles();
            if ((file.exists() && file.isDirectory()) && listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.getName().equals("events.json")) {
                        StringBuilder sb = new StringBuilder();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        bufferedReader.close();
                        if (sb.toString().contains("]{")) {
                            String[] split = sb.toString().split("]\\{");
                            String str = split[0];
                            String concat = "{".concat(String.valueOf(split[1]));
                            StringBuilder sb2 = new StringBuilder(concat);
                            if (concat.substring(concat.length() - 1).equals(",")) {
                                FileWriter fileWriter = new FileWriter(file2, false);
                                sb2.setCharAt(sb2.lastIndexOf(sb2.substring(sb2.length() - 1)), ' ');
                                String replace = sb2.toString().replace(CMap.SPACE, "");
                                fileWriter.write(str + "," + replace + CMapParser.MARK_END_OF_ARRAY);
                                fileWriter.close();
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static /* synthetic */ void a(f fVar, int i2) {
        if (i2 >= fVar.n) {
            fVar.n = i2;
            if (fVar.f4141d && (!fVar.x)) {
                fVar.x = true;
                i iVar = fVar.f4142e;
                if (iVar != null) {
                    iVar.a(i2);
                    com.userexperior.utilities.b.a(Level.INFO, "R -- P");
                }
                fVar.s = false;
                if (i2 == 1 || i2 == 2) {
                    fVar.t = true;
                } else {
                    fVar.t = false;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r23v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v12, types: [java.io.File[]] */
    /* JADX WARNING: type inference failed for: r23v1 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r23v2 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r23v3 */
    /* JADX WARNING: type inference failed for: r23v4 */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r23v5 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r23v6 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: type inference failed for: r23v7 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* JADX WARNING: type inference failed for: r23v8 */
    /* JADX WARNING: type inference failed for: r23v9 */
    /* JADX WARNING: type inference failed for: r23v10 */
    /* JADX WARNING: type inference failed for: r23v11 */
    /* JADX WARNING: type inference failed for: r23v12 */
    /* JADX WARNING: type inference failed for: r23v13 */
    /* JADX WARNING: type inference failed for: r23v14 */
    /* JADX WARNING: type inference failed for: r23v15 */
    /* JADX WARNING: type inference failed for: r23v16 */
    /* JADX WARNING: type inference failed for: r7v55 */
    /* JADX WARNING: type inference failed for: r23v17 */
    /* JADX WARNING: type inference failed for: r23v18 */
    /* JADX WARNING: type inference failed for: r23v19 */
    /* JADX WARNING: type inference failed for: r7v56 */
    /* JADX WARNING: type inference failed for: r23v20 */
    /* JADX WARNING: type inference failed for: r7v57 */
    /* JADX WARNING: type inference failed for: r7v58 */
    /* JADX WARNING: type inference failed for: r7v59 */
    /* JADX WARNING: type inference failed for: r23v21 */
    /* JADX WARNING: type inference failed for: r23v22 */
    /* JADX WARNING: type inference failed for: r23v23 */
    /* JADX WARNING: type inference failed for: r23v24 */
    /* JADX WARNING: type inference failed for: r23v25 */
    /* JADX WARNING: type inference failed for: r23v26 */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02c8, code lost:
        if (r15.charAt(r15.length() - 1) == '}') goto L_0x02ca;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r23v1
      assigns: []
      uses: []
      mth insns count: 395
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x030d A[Catch:{ Exception -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0315 A[Catch:{ Exception -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a0 A[SYNTHETIC, Splitter:B:62:0x01a0] */
    /* JADX WARNING: Unknown variable types count: 15 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.userexperior.services.recording.f r21, com.userexperior.c.b.a r22, boolean r23) {
        /*
            r1 = r21
            r2 = r22
            java.lang.String r3 = "]{"
            if (r2 == 0) goto L_0x0483
            java.lang.String r5 = r2.f3824e
            boolean r6 = r2.f3825f
            int r0 = r2.i
            android.content.Context r7 = r1.g
            java.lang.String r8 = "idleTimeout"
            java.lang.String r9 = "UserExperior"
            r10 = 0
            if (r7 == 0) goto L_0x00e2
            if (r23 == 0) goto L_0x00e2
            com.userexperior.a.a.f r11 = new com.userexperior.a.a.f
            r11.<init>()
            java.lang.String r11 = r11.a(r2)
            com.userexperior.utilities.d r12 = com.userexperior.utilities.d.a()
            if (r12 == 0) goto L_0x002a
            r13 = 1
            goto L_0x002b
        L_0x002a:
            r13 = 0
        L_0x002b:
            if (r11 == 0) goto L_0x002f
            r14 = 1
            goto L_0x0030
        L_0x002f:
            r14 = 0
        L_0x0030:
            r13 = r13 & r14
            if (r13 == 0) goto L_0x0055
            byte[] r13 = r12.a(r11)
            byte[] r12 = r12.f4267a
            android.content.SharedPreferences r14 = r7.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r14 = r14.edit()
            if (r12 == 0) goto L_0x004f
            java.lang.String r12 = android.util.Base64.encodeToString(r12, r10)
            java.lang.String r15 = "ksiv"
            r14.putString(r15, r12)
            r14.apply()
        L_0x004f:
            if (r13 == 0) goto L_0x0055
            java.lang.String r11 = android.util.Base64.encodeToString(r13, r10)
        L_0x0055:
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r12 = "appConfigInstance"
            r7.putString(r12, r11)
            r7.apply()
            android.content.Context r7 = r1.g
            boolean r11 = r2.f3821b
            java.lang.String r11 = java.lang.String.valueOf(r11)
            com.userexperior.utilities.l.a(r7, r11)
            android.content.Context r7 = r1.g
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r11 = "captureType"
            r7.putString(r11, r5)
            r7.apply()
            android.content.Context r7 = r1.g
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r11 = "conditionalCaptureStatus"
            r7.putBoolean(r11, r6)
            r7.apply()
            android.content.Context r7 = r1.g
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r11 = "videoColor"
            r7.putInt(r11, r0)
            r7.apply()
            android.content.Context r0 = r1.g
            boolean r7 = r2.k
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r11 = "autoMasking"
            r0.putBoolean(r11, r7)
            r0.apply()
            android.content.Context r0 = r1.g
            int r7 = r2.m
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putInt(r8, r7)
            r0.apply()
            android.content.Context r0 = r1.g
            int r7 = r2.n
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r9, r10)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r11 = "videoQuality"
            r0.putInt(r11, r7)
            r0.apply()
        L_0x00e2:
            android.content.Context r0 = r1.g
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r9, r10)
            r7 = 2
            int r0 = r0.getInt(r8, r7)
            com.userexperior.models.recording.a r7 = r1.w
            if (r7 == 0) goto L_0x00fb
            if (r0 > 0) goto L_0x00f6
            long r8 = com.userexperior.c.b.a.f3820a
            goto L_0x00f9
        L_0x00f6:
            int r0 = r0 * 1000
            long r8 = (long) r0
        L_0x00f9:
            r7.f4054a = r8
        L_0x00fb:
            boolean r0 = r2.f3821b
            if (r0 == 0) goto L_0x045d
            com.userexperior.utilities.i.a()
            boolean r0 = com.userexperior.utilities.i.b()
            if (r0 == 0) goto L_0x0401
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x034d }
            android.content.Context r7 = r1.g     // Catch:{ Exception -> 0x034d }
            java.lang.String r7 = com.userexperior.utilities.j.f(r7)     // Catch:{ Exception -> 0x034d }
            r0.<init>(r7)     // Catch:{ Exception -> 0x034d }
            java.io.File[] r7 = r0.listFiles()     // Catch:{ Exception -> 0x034d }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x034d }
            if (r0 == 0) goto L_0x0351
            if (r7 == 0) goto L_0x0351
            int r8 = r7.length     // Catch:{ Exception -> 0x034d }
            r9 = 0
        L_0x0121:
            if (r9 >= r8) goto L_0x0351
            r0 = r7[r9]     // Catch:{ Exception -> 0x034d }
            if (r0 == 0) goto L_0x0340
            boolean r11 = r0.isDirectory()     // Catch:{ Exception -> 0x034d }
            if (r11 == 0) goto L_0x0340
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x034d }
            java.lang.String r12 = "Crash Logs"
            boolean r11 = r11.contains(r12)     // Catch:{ Exception -> 0x034d }
            if (r11 != 0) goto L_0x0340
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x034d }
            java.lang.String r12 = "Anr Logs"
            boolean r11 = r11.contains(r12)     // Catch:{ Exception -> 0x034d }
            if (r11 != 0) goto L_0x0340
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x034d }
            java.lang.String r12 = "acri.txt"
            boolean r11 = r11.contains(r12)     // Catch:{ Exception -> 0x034d }
            if (r11 != 0) goto L_0x0340
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x034d }
            java.lang.String r12 = ".zip"
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x034d }
            if (r11 != 0) goto L_0x0340
            android.content.Context r11 = r1.g     // Catch:{ Exception -> 0x034d }
            java.lang.String r12 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x034d }
            java.util.HashMap r11 = com.userexperior.utilities.l.s(r11)     // Catch:{ Exception -> 0x034d }
            if (r11 == 0) goto L_0x0187
            if (r12 == 0) goto L_0x0187
            java.lang.Object r11 = r11.get(r12)     // Catch:{ Exception -> 0x034d }
            com.userexperior.models.recording.f r11 = (com.userexperior.models.recording.f) r11     // Catch:{ Exception -> 0x034d }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x034d }
            java.lang.String r14 = "get session_detail with sessionid = "
            r13.<init>(r14)     // Catch:{ Exception -> 0x034d }
            r13.append(r12)     // Catch:{ Exception -> 0x034d }
            java.lang.String r12 = " :"
            r13.append(r12)     // Catch:{ Exception -> 0x034d }
            r13.append(r11)     // Catch:{ Exception -> 0x034d }
            if (r11 == 0) goto L_0x0187
            r11 = 1
            goto L_0x0188
        L_0x0187:
            r11 = 0
        L_0x0188:
            if (r11 != 0) goto L_0x0340
            java.lang.String r11 = r1.q     // Catch:{ Exception -> 0x034d }
            if (r11 == 0) goto L_0x019a
            java.lang.String r11 = r1.q     // Catch:{ Exception -> 0x034d }
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x034d }
            boolean r11 = r11.contains(r12)     // Catch:{ Exception -> 0x034d }
            if (r11 != 0) goto L_0x0340
        L_0x019a:
            java.io.File[] r11 = r0.listFiles()     // Catch:{ Exception -> 0x034d }
            if (r11 == 0) goto L_0x0340
            int r12 = r11.length     // Catch:{ Exception -> 0x032e }
            r13 = 0
        L_0x01a2:
            if (r13 >= r12) goto L_0x0340
            r14 = r11[r13]     // Catch:{ Exception -> 0x032e }
            java.lang.String r15 = r14.getName()     // Catch:{ Exception -> 0x032e }
            java.lang.String r4 = "events.json"
            boolean r4 = r15.equals(r4)     // Catch:{ Exception -> 0x032e }
            if (r4 == 0) goto L_0x0321
            long r17 = r14.length()     // Catch:{ Exception -> 0x032e }
            r19 = 0
            int r4 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x0321
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x032e }
            java.io.FileReader r15 = new java.io.FileReader     // Catch:{ Exception -> 0x032e }
            r15.<init>(r14)     // Catch:{ Exception -> 0x032e }
            r4.<init>(r15)     // Catch:{ Exception -> 0x032e }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032e }
            r15.<init>()     // Catch:{ Exception -> 0x032e }
        L_0x01cb:
            java.lang.String r10 = r4.readLine()     // Catch:{ Exception -> 0x032e }
            if (r10 == 0) goto L_0x01d5
            r15.append(r10)     // Catch:{ Exception -> 0x032e }
            goto L_0x01cb
        L_0x01d5:
            r4.close()     // Catch:{ Exception -> 0x032e }
            r4 = 0
            char r10 = r15.charAt(r4)     // Catch:{ Exception -> 0x032e }
            r4 = 91
            if (r10 != r4) goto L_0x02af
            java.lang.String r4 = r15.toString()     // Catch:{ Exception -> 0x032e }
            boolean r4 = r4.contains(r3)     // Catch:{ Exception -> 0x032e }
            java.lang.String r10 = ","
            if (r4 != 0) goto L_0x0224
            int r4 = r15.length()     // Catch:{ Exception -> 0x032e }
            r16 = 1
            int r4 = r4 + -1
            java.lang.String r4 = r15.substring(r4)     // Catch:{ Exception -> 0x032e }
            boolean r4 = r4.equals(r10)     // Catch:{ Exception -> 0x032e }
            if (r4 == 0) goto L_0x0224
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ Exception -> 0x032e }
            r10 = 0
            r4.<init>(r14, r10)     // Catch:{ Exception -> 0x032e }
            int r10 = r15.length()     // Catch:{ Exception -> 0x032e }
            r14 = 1
            int r10 = r10 - r14
            java.lang.String r10 = r15.substring(r10)     // Catch:{ Exception -> 0x032e }
            int r10 = r15.lastIndexOf(r10)     // Catch:{ Exception -> 0x032e }
            r14 = 93
            r15.setCharAt(r10, r14)     // Catch:{ Exception -> 0x032e }
            java.lang.String r10 = r15.toString()     // Catch:{ Exception -> 0x032e }
            r4.write(r10)     // Catch:{ Exception -> 0x032e }
            r4.close()     // Catch:{ Exception -> 0x032e }
            goto L_0x02aa
        L_0x0224:
            java.lang.String r4 = r15.toString()     // Catch:{ Exception -> 0x032e }
            boolean r4 = r4.contains(r3)     // Catch:{ Exception -> 0x032e }
            if (r4 == 0) goto L_0x02aa
            java.lang.String r4 = r15.toString()     // Catch:{ Exception -> 0x032e }
            java.lang.String r15 = "]\\{"
            java.lang.String[] r4 = r4.split(r15)     // Catch:{ Exception -> 0x032e }
            r18 = r3
            r15 = 0
            r3 = r4[r15]     // Catch:{ Exception -> 0x02a7 }
            r15 = 1
            r4 = r4[r15]     // Catch:{ Exception -> 0x02a7 }
            java.lang.String r15 = "{"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x02a7 }
            java.lang.String r4 = r15.concat(r4)     // Catch:{ Exception -> 0x02a7 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a7 }
            r15.<init>(r4)     // Catch:{ Exception -> 0x02a7 }
            int r19 = r4.length()     // Catch:{ Exception -> 0x02a7 }
            r23 = r7
            r16 = 1
            int r7 = r19 + -1
            java.lang.String r4 = r4.substring(r7)     // Catch:{ Exception -> 0x031f }
            boolean r4 = r4.equals(r10)     // Catch:{ Exception -> 0x031f }
            if (r4 == 0) goto L_0x02ca
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ Exception -> 0x031f }
            r7 = 0
            r4.<init>(r14, r7)     // Catch:{ Exception -> 0x031f }
            int r7 = r15.length()     // Catch:{ Exception -> 0x031f }
            r14 = 1
            int r7 = r7 - r14
            java.lang.String r7 = r15.substring(r7)     // Catch:{ Exception -> 0x031f }
            int r7 = r15.lastIndexOf(r7)     // Catch:{ Exception -> 0x031f }
            r14 = 32
            r15.setCharAt(r7, r14)     // Catch:{ Exception -> 0x031f }
            java.lang.String r7 = r15.toString()     // Catch:{ Exception -> 0x031f }
            java.lang.String r14 = " "
            java.lang.String r15 = ""
            java.lang.String r7 = r7.replace(r14, r15)     // Catch:{ Exception -> 0x031f }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031f }
            r14.<init>()     // Catch:{ Exception -> 0x031f }
            r14.append(r3)     // Catch:{ Exception -> 0x031f }
            r14.append(r10)     // Catch:{ Exception -> 0x031f }
            r14.append(r7)     // Catch:{ Exception -> 0x031f }
            java.lang.String r3 = "]"
            r14.append(r3)     // Catch:{ Exception -> 0x031f }
            java.lang.String r3 = r14.toString()     // Catch:{ Exception -> 0x031f }
            r4.write(r3)     // Catch:{ Exception -> 0x031f }
            r4.close()     // Catch:{ Exception -> 0x031f }
            goto L_0x02cc
        L_0x02a7:
            r0 = move-exception
            goto L_0x0331
        L_0x02aa:
            r18 = r3
            r23 = r7
            goto L_0x02cc
        L_0x02af:
            r18 = r3
            r23 = r7
            r3 = 0
            char r4 = r15.charAt(r3)     // Catch:{ Exception -> 0x031f }
            r3 = 123(0x7b, float:1.72E-43)
            if (r4 != r3) goto L_0x02cc
            int r3 = r15.length()     // Catch:{ Exception -> 0x031f }
            r4 = 1
            int r3 = r3 - r4
            char r3 = r15.charAt(r3)     // Catch:{ Exception -> 0x031f }
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 != r4) goto L_0x02cc
        L_0x02ca:
            r3 = 0
            goto L_0x02cd
        L_0x02cc:
            r3 = 1
        L_0x02cd:
            com.userexperior.models.recording.f r4 = new com.userexperior.models.recording.f     // Catch:{ Exception -> 0x031f }
            r4.<init>()     // Catch:{ Exception -> 0x031f }
            android.content.Context r7 = r1.g     // Catch:{ Exception -> 0x031f }
            java.lang.String r7 = com.userexperior.utilities.l.n(r7)     // Catch:{ Exception -> 0x031f }
            r4.f4084a = r7     // Catch:{ Exception -> 0x031f }
            android.content.Context r7 = r1.g     // Catch:{ Exception -> 0x031f }
            java.lang.String r7 = com.userexperior.utilities.l.o(r7)     // Catch:{ Exception -> 0x031f }
            r4.f4087d = r7     // Catch:{ Exception -> 0x031f }
            android.content.Context r7 = r1.g     // Catch:{ Exception -> 0x031f }
            boolean r7 = com.userexperior.utilities.l.q(r7)     // Catch:{ Exception -> 0x031f }
            r4.f4088e = r7     // Catch:{ Exception -> 0x031f }
            android.content.Context r7 = r1.g     // Catch:{ Exception -> 0x031f }
            java.lang.String r7 = com.userexperior.utilities.l.l(r7)     // Catch:{ Exception -> 0x031f }
            r4.j = r7     // Catch:{ Exception -> 0x031f }
            com.userexperior.c.c.a r7 = new com.userexperior.c.c.a     // Catch:{ Exception -> 0x031f }
            r7.<init>()     // Catch:{ Exception -> 0x031f }
            android.content.Context r10 = r1.g     // Catch:{ Exception -> 0x031f }
            com.userexperior.c.c.a r7 = r7.a(r10)     // Catch:{ Exception -> 0x031f }
            r4.t = r7     // Catch:{ Exception -> 0x031f }
            java.lang.String r7 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x031f }
            r4.r = r7     // Catch:{ Exception -> 0x031f }
            java.lang.String r7 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x031f }
            r4.f4086c = r7     // Catch:{ Exception -> 0x031f }
            if (r3 == 0) goto L_0x0315
            com.userexperior.models.recording.enums.i r3 = com.userexperior.models.recording.enums.i.END_SQUARE_BRACKET_APPENDED     // Catch:{ Exception -> 0x031f }
            r4.f4085b = r3     // Catch:{ Exception -> 0x031f }
            r3 = 1
            r4.s = r3     // Catch:{ Exception -> 0x031f }
            goto L_0x0319
        L_0x0315:
            com.userexperior.models.recording.enums.i r3 = com.userexperior.models.recording.enums.i.JSON_FILE_CREATED     // Catch:{ Exception -> 0x031f }
            r4.f4085b = r3     // Catch:{ Exception -> 0x031f }
        L_0x0319:
            android.content.Context r3 = r1.g     // Catch:{ Exception -> 0x031f }
            com.userexperior.utilities.l.a(r3, r4)     // Catch:{ Exception -> 0x031f }
            goto L_0x0325
        L_0x031f:
            r0 = move-exception
            goto L_0x0333
        L_0x0321:
            r18 = r3
            r23 = r7
        L_0x0325:
            int r13 = r13 + 1
            r7 = r23
            r3 = r18
            r10 = 0
            goto L_0x01a2
        L_0x032e:
            r0 = move-exception
            r18 = r3
        L_0x0331:
            r23 = r7
        L_0x0333:
            r0.printStackTrace()     // Catch:{ Exception -> 0x034d }
            java.util.logging.Level r3 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x034d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x034d }
            com.userexperior.utilities.b.a(r3, r0)     // Catch:{ Exception -> 0x034d }
            goto L_0x0344
        L_0x0340:
            r18 = r3
            r23 = r7
        L_0x0344:
            int r9 = r9 + 1
            r7 = r23
            r3 = r18
            r10 = 0
            goto L_0x0121
        L_0x034d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0351:
            android.content.Context r0 = r1.g
            java.util.HashMap r0 = com.userexperior.utilities.l.s(r0)
            android.content.Context r3 = r1.g
            com.userexperior.c.c.f r4 = com.userexperior.utilities.a.a(r3)
            r7 = 0
            com.userexperior.services.JIUploadService.a(r3, r4, r7)
            r21.v()
            r21.w()
            if (r0 == 0) goto L_0x03ff
            int r4 = r0.size()
            if (r4 != 0) goto L_0x0371
            goto L_0x03ff
        L_0x0371:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0379:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x03ff
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Session Key = "
            r7.<init>(r8)
            java.lang.Object r8 = r4.getKey()
            r7.append(r8)
            java.lang.Object r4 = r4.getValue()
            com.userexperior.models.recording.f r4 = (com.userexperior.models.recording.f) r4
            if (r4 == 0) goto L_0x03fa
            java.io.File r7 = new java.io.File
            java.lang.String r8 = r4.f4086c
            r7.<init>(r8)
            java.util.Date r8 = new java.util.Date
            long r9 = r7.lastModified()
            r8.<init>(r9)
            long r8 = r8.getTime()
            long r10 = java.lang.System.currentTimeMillis()
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MINUTES
            long r8 = com.userexperior.e.h.a(r8, r10, r12)
            r10 = 2880(0xb40, double:1.423E-320)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x03ed
            r1.a(r7)
            r0.remove()
            android.content.Context r8 = r1.g
            java.lang.String r4 = r4.f4086c
            com.userexperior.utilities.l.d(r8, r4)
            java.util.logging.Level r4 = java.util.logging.Level.INFO
            java.lang.String r8 = "Deleting the s - older than xx hours......"
            com.userexperior.utilities.b.a(r4, r8)
            java.util.logging.Level r4 = java.util.logging.Level.INFO
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "delete = "
            r8.<init>(r9)
            boolean r7 = r7.exists()
            r9 = 1
            r7 = r7 ^ r9
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.userexperior.utilities.b.a(r4, r7)
            goto L_0x0379
        L_0x03ed:
            a(r4)
            com.userexperior.d.b.c r7 = new com.userexperior.d.b.c
            r7.<init>(r3, r4)
            android.os.Handler r4 = r1.f4140c
            r4.post(r7)
        L_0x03fa:
            r0.remove()
            goto L_0x0379
        L_0x03ff:
            r3 = 0
            goto L_0x0402
        L_0x0401:
            r3 = 1
        L_0x0402:
            r1.C = r3
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "lS = "
            r3.<init>(r4)
            boolean r2 = r2.f3821b
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.userexperior.utilities.b.a(r0, r2)
            com.userexperior.interfaces.recording.UserExperiorListener r0 = com.userexperior.UserExperior.getUserExperiorListener()
            java.lang.String r2 = "1"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x0454
            java.lang.String r2 = "2"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x042e
            goto L_0x0454
        L_0x042e:
            java.lang.String r2 = "3"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x043e
            java.lang.String r2 = "4"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0449
        L_0x043e:
            if (r6 == 0) goto L_0x0449
            r21.p()
            if (r0 == 0) goto L_0x045c
            r0.onUserExperiorStarted()
            return
        L_0x0449:
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r2 = "Rule based R or S conditions did not match!"
            com.userexperior.utilities.b.a(r0, r2)
            r21.o()
            goto L_0x045c
        L_0x0454:
            r21.p()
            if (r0 == 0) goto L_0x045c
            r0.onUserExperiorStarted()
        L_0x045c:
            return
        L_0x045d:
            r3 = 0
            r1.C = r3
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "licenseStatus = "
            r3.<init>(r4)
            boolean r4 = r2.f3821b
            r3.append(r4)
            java.lang.String r4 = " : "
            r3.append(r4)
            java.lang.String r2 = r2.f3822c
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.userexperior.utilities.b.a(r0, r2)
            r21.o()
            return
        L_0x0483:
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r2 = "Internet on but no data or config is null, will start ue anyway!"
            com.userexperior.utilities.b.a(r0, r2)
            android.content.Context r0 = r1.g
            java.lang.String r2 = "NA"
            com.userexperior.utilities.l.a(r0, r2)
            r2 = 1
            r1.C = r2
            r21.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.f.a(com.userexperior.services.recording.f, com.userexperior.c.b.a, boolean):void");
    }

    public static /* synthetic */ void a(f fVar, com.userexperior.models.recording.f fVar2) {
        c cVar;
        int i2 = fVar.A;
        if (i2 > 0) {
            boolean z2 = true;
            fVar.A = i2 - 1;
            com.userexperior.c.b.a e2 = l.e(fVar.g);
            if (e2 == null || !e2.f3821b) {
                z2 = false;
            }
            if (z2 || fVar.C) {
                if (fVar2 != null) {
                    fVar2.f4085b = i.INITIAL_STATE;
                    cVar = new c(fVar.g, fVar2);
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    fVar.f4140c.post(cVar);
                }
            } else {
                com.userexperior.utilities.b.a(Level.INFO, "UF --> Version Un-subscribed");
            }
            l.b(fVar.g);
        }
    }

    public static /* synthetic */ void a(f fVar, String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                fVar.a(file);
            }
        }
    }

    public static /* synthetic */ void a(f fVar, String str, String str2, String str3, long j2) {
        if (fVar.f4141d) {
            final h hVar = str2.trim().equalsIgnoreCase(UeCustomType.EVENT) ? h.EVENT : str2.trim().equalsIgnoreCase(UeCustomType.MSG) ? h.MSG : h.TAG;
            Handler handler = fVar.f4140c;
            if (handler != null) {
                final String str4 = str3;
                final long j3 = j2;
                final String str5 = str;
                AnonymousClass11 r0 = new Runnable() {
                    public final void run() {
                        f.h;
                        StringBuilder sb = new StringBuilder("event (2) ");
                        sb.append(hVar);
                        sb.append(CMap.SPACE);
                        sb.append(str4);
                        sb.append(CMap.SPACE);
                        sb.append(j3);
                        f.this.b(false);
                        f.this.u();
                        if (f.this.t) {
                            f.this.a(f.a(str4, hVar, str5, j3));
                        } else {
                            f.h;
                        }
                    }
                };
                handler.post(r0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0101 A[SYNTHETIC, Splitter:B:57:0x0101] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.userexperior.services.recording.f r8, java.lang.StringBuilder r9, com.userexperior.models.recording.f r10) {
        /*
            int r0 = r8.A
            if (r0 > 0) goto L_0x000d
            java.util.logging.Level r8 = java.util.logging.Level.WARNING
            java.lang.String r9 = "u per r session exhausted :a"
            com.userexperior.utilities.b.a(r8, r9)
            return
        L_0x000d:
            r1 = 1
            int r0 = r0 - r1
            r8.A = r0
            java.lang.String r0 = "Anr Log :\n------------------------\n"
            if (r9 == 0) goto L_0x001d
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = r0.concat(r9)
        L_0x001d:
            java.lang.String r9 = "\n\n --- Device details ---\n"
            java.lang.String r9 = r0.concat(r9)
            com.userexperior.c.c.a r0 = new com.userexperior.c.c.a
            r0.<init>()
            android.content.Context r2 = r8.g
            r0.a(r2)
            com.userexperior.a.a.h r2 = new com.userexperior.a.a.h
            r2.<init>()
            r2.f3752b = r1
            com.userexperior.a.a.f r1 = r2.a()
            java.lang.String r0 = r1.a(r0)
            java.lang.String r9 = r9.concat(r0)
            android.content.Context r0 = r8.g
            java.lang.String r0 = com.userexperior.utilities.j.c(r0)
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            r0 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00d6 }
            android.content.Context r3 = r8.g     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r3 = com.userexperior.utilities.j.f(r3)     // Catch:{ Exception -> 0x00d6 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00d6 }
            double r3 = com.userexperior.e.h.a(r2)     // Catch:{ Exception -> 0x00d6 }
            r5 = 4632233691727265792(0x4049000000000000, double:50.0)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0098
            java.io.File r2 = r1.getParentFile()     // Catch:{ Exception -> 0x00d6 }
            if (r2 == 0) goto L_0x0070
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00d6 }
            if (r3 != 0) goto L_0x0070
            r2.mkdirs()     // Catch:{ Exception -> 0x00d6 }
        L_0x0070:
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00d6 }
            if (r2 != 0) goto L_0x0081
            r1.createNewFile()     // Catch:{ Exception -> 0x00d6 }
            if (r10 == 0) goto L_0x0081
            java.lang.String r2 = r1.getName()     // Catch:{ Exception -> 0x00d6 }
            r10.o = r2     // Catch:{ Exception -> 0x00d6 }
        L_0x0081:
            java.io.FileWriter r10 = new java.io.FileWriter     // Catch:{ Exception -> 0x00d6 }
            r10.<init>(r1)     // Catch:{ Exception -> 0x00d6 }
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x00d6 }
            r2.<init>(r10)     // Catch:{ Exception -> 0x00d6 }
            r2.write(r9)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
        L_0x008e:
            com.userexperior.e.h.c(r1)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            goto L_0x00d0
        L_0x0092:
            r8 = move-exception
            r0 = r2
            goto L_0x00ff
        L_0x0095:
            r9 = move-exception
            r0 = r2
            goto L_0x00d7
        L_0x0098:
            java.util.logging.Level r3 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r4 = "aBuffer went beyond limit 50.....deleting data :a"
            com.userexperior.utilities.b.a(r3, r4)     // Catch:{ Exception -> 0x00d6 }
            com.userexperior.e.h.b(r2)     // Catch:{ Exception -> 0x00d6 }
            java.io.File r2 = r1.getParentFile()     // Catch:{ Exception -> 0x00d6 }
            if (r2 == 0) goto L_0x00b1
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00d6 }
            if (r3 != 0) goto L_0x00b1
            r2.mkdirs()     // Catch:{ Exception -> 0x00d6 }
        L_0x00b1:
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00d6 }
            if (r2 != 0) goto L_0x00c2
            r1.createNewFile()     // Catch:{ Exception -> 0x00d6 }
            if (r10 == 0) goto L_0x00c2
            java.lang.String r2 = r1.getName()     // Catch:{ Exception -> 0x00d6 }
            r10.o = r2     // Catch:{ Exception -> 0x00d6 }
        L_0x00c2:
            java.io.FileWriter r10 = new java.io.FileWriter     // Catch:{ Exception -> 0x00d6 }
            r10.<init>(r1)     // Catch:{ Exception -> 0x00d6 }
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x00d6 }
            r2.<init>(r10)     // Catch:{ Exception -> 0x00d6 }
            r2.write(r9)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            goto L_0x008e
        L_0x00d0:
            r2.close()     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00fb
        L_0x00d4:
            r8 = move-exception
            goto L_0x00ff
        L_0x00d6:
            r9 = move-exception
        L_0x00d7:
            java.util.logging.Level r10 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x00d4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            java.lang.String r2 = "Ex : EM - uploadANRData() : "
            r1.<init>(r2)     // Catch:{ all -> 0x00d4 }
            java.lang.String r2 = r9.getMessage()     // Catch:{ all -> 0x00d4 }
            r1.append(r2)     // Catch:{ all -> 0x00d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d4 }
            com.userexperior.utilities.b.a(r10, r1)     // Catch:{ all -> 0x00d4 }
            r9.getMessage()     // Catch:{ all -> 0x00d4 }
            if (r0 == 0) goto L_0x00fb
            r0.close()     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00fb
        L_0x00f7:
            r9 = move-exception
            r9.getMessage()
        L_0x00fb:
            r8.w()
            return
        L_0x00ff:
            if (r0 == 0) goto L_0x0109
            r0.close()     // Catch:{ Exception -> 0x0105 }
            goto L_0x0109
        L_0x0105:
            r9 = move-exception
            r9.getMessage()
        L_0x0109:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.f.a(com.userexperior.services.recording.f, java.lang.StringBuilder, com.userexperior.models.recording.f):void");
    }

    private void a(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (file.isDirectory() && listFiles != null) {
                for (File a2 : listFiles) {
                    a(a2);
                }
            }
            StringBuilder sb = new StringBuilder("file - ");
            sb.append(file.getName());
            sb.append(" deleted = ");
            sb.append(file.delete());
        }
    }

    private void a(boolean z2) {
        try {
            if (this.w != null) {
                this.w.a(z2);
                this.w.f();
            }
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("Ex : EM - startTimers : "), Level.SEVERE);
        }
    }

    public static /* synthetic */ StringBuilder b(com.userexperior.d.a.a aVar) {
        if (aVar == null || aVar.getCause() == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        aVar.printStackTrace(new PrintWriter(stringWriter));
        String str = "\nCaused by: " + aVar.getCause().toString();
        return GeneratedOutlineSupport.outline73(stringWriter.toString().replace(str, "\nCaused by: " + aVar.getCause().getMessage()));
    }

    public static /* synthetic */ void b(f fVar, com.userexperior.c.a.a aVar) {
        if (fVar.s) {
            fVar.a(aVar);
            return;
        }
        StringBuilder sb = new StringBuilder("skipping ");
        sb.append(aVar.f3796b);
        sb.append(". because doWriteForMotionEvent is false");
    }

    private void b(String str, long j2, HashMap<String, String> hashMap) {
        Handler handler = this.f4140c;
        if (handler != null) {
            final String str2 = str;
            final long j3 = j2;
            final HashMap<String, String> hashMap2 = hashMap;
            AnonymousClass27 r1 = new Runnable() {
                public final void run() {
                    f.h;
                    synchronized (this) {
                        if (f.this.D != null) {
                            if (f.this.D.containsKey(str2)) {
                                f.this.D.remove(str2);
                            }
                            f.this.D.put(str2, Long.valueOf(j3));
                        }
                        f.this.a(str2, -1, j3, hashMap2, (HashMap<String, String>) null);
                    }
                }
            };
            handler.post(r1);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void b(boolean z2) {
        if (this.G && !this.x) {
            StringBuilder sb = new StringBuilder("DISABLE SCROLL PAUSE. isUserEvent = ");
            sb.append(z2);
            sb.append(". currentImageNumber =  ");
            sb.append(this.B);
            if (this.E != null && z2) {
                new StringBuilder("adding screenshot_num - > ").append(this.B);
                this.E.add(Integer.valueOf(this.B));
            }
            if (this.f4142e != null) {
                this.f4142e.a(0);
                this.f4142e.a(this.w != null ? this.w.c() : null, 0);
            }
            if (this.F != null) {
                this.F.cancel();
                this.F = null;
            }
        }
        this.G = false;
    }

    public static f g() {
        if (f4138a == null) {
            synchronized (f.class) {
                try {
                    if (f4138a == null) {
                        f4138a = new f();
                    }
                }
            }
        }
        return f4138a;
    }

    public static Activity i() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            if (invoke == null) {
                return null;
            }
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            for (Object next : map.values()) {
                Class<?> cls2 = next.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(next)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    if (declaredField3.get(next) instanceof Activity) {
                        return (Activity) declaredField3.get(next);
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            com.userexperior.utilities.b.a(level, "Ex : EM - getActivity : " + e2.getMessage());
            e2.printStackTrace();
            e2.getMessage();
        }
    }

    public static /* synthetic */ void i(f fVar) {
        l.r(fVar.g);
        l.d(fVar.g);
        Editor edit = fVar.g.getSharedPreferences(UserExperior.TAG, 0).edit();
        edit.remove("lastImageNum");
        edit.apply();
    }

    public static /* synthetic */ void k(f fVar) {
        String str;
        StringBuilder sb;
        Level level;
        try {
            long j2 = fVar.g.getSharedPreferences(UserExperior.TAG, 0).getLong("lcha", 0);
            long a2 = com.userexperior.e.h.a(j2, System.currentTimeMillis(), TimeUnit.SECONDS);
            if (j2 != 0) {
                if (a2 <= 1800) {
                    if (fVar.f4140c != null) {
                        fVar.f4140c.post(new Runnable() {
                            public final void run() {
                                f.a(f.this, l.e(f.this.g), false);
                                com.userexperior.utilities.b.a(Level.INFO, "nhc");
                            }
                        });
                    }
                    return;
                }
            }
            com.userexperior.utilities.b.a(Level.INFO, "lch30");
            Editor edit = fVar.g.getSharedPreferences(UserExperior.TAG, 0).edit();
            edit.remove("tpVal");
            edit.apply();
            com.userexperior.b.a a3 = com.userexperior.b.a.a();
            String ueSdkAppVersionKey = UserExperior.getUeSdkAppVersionKey();
            com.userexperior.utilities.b.a(Level.CONFIG, "Check Subscription : ".concat(String.valueOf(ueSdkAppVersionKey)));
            AnonymousClass1 r6 = new t<String>() {
                public final /* synthetic */ void a(Object obj) {
                    final String str = (String) obj;
                    Context a2 = f.this.g;
                    long currentTimeMillis = System.currentTimeMillis();
                    Editor edit = a2.getSharedPreferences(UserExperior.TAG, 0).edit();
                    edit.putLong("lcha", currentTimeMillis);
                    edit.apply();
                    com.userexperior.utilities.b.a(Level.INFO, "cuh");
                    f.h;
                    if (f.this.f4140c != null) {
                        f.this.f4140c.post(new Runnable() {
                            public final void run() {
                                com.userexperior.a.a.f fVar = new com.userexperior.a.a.f();
                                String str = str;
                                f.a(f.this, (str == null || str.isEmpty() || str.startsWith("<html>")) ? null : (com.userexperior.c.b.a) fVar.a(str, com.userexperior.c.b.a.class), true);
                            }
                        });
                    } else {
                        f.h;
                    }
                }
            };
            AnonymousClass12 r7 = new s() {
                public final void a(y yVar) {
                    if (f.this.f4140c != null) {
                        f.this.f4140c.post(new Runnable() {
                            public final void run() {
                                l.a(f.this.g, (String) AnalyticsConstants.NOT_AVAILABLE);
                                f.this.C = true;
                                f.a(f.this, l.e(f.this.g), false);
                                com.userexperior.utilities.b.a(Level.INFO, "some error at config or no internet, but ue started");
                            }
                        });
                    } else {
                        f.h;
                    }
                }
            };
            Context a4 = com.userexperior.utilities.a.a();
            com.userexperior.b.a.AnonymousClass7 r3 = new k("https://userexperior.online/status/api/config/".concat(String.valueOf(ueSdkAppVersionKey)), r6, r7, Secure.getString(a4.getContentResolver(), "android_id"), a4) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f3789a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f3790b;

                {
                    this.f3789a = r5;
                    this.f3790b = r6;
                }

                public final Map<String, String> b() {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Constant.HEADER_ANDROID_DEVICE_ID, this.f3789a);
                    hashMap.put("appSessionId", l.n(this.f3790b));
                    hashMap.put("deviceInfo", new f().a((Object) new com.userexperior.c.c.a().a(this.f3790b)));
                    hashMap.put("appPackage", this.f3790b.getPackageName());
                    return hashMap;
                }
            };
            a3.a((o<T>) r3);
        } catch (Exception e2) {
            level = Level.INFO;
            sb = new StringBuilder("EM: issue at fetching subs: ");
            str = e2.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
        } catch (OutOfMemoryError e3) {
            level = Level.INFO;
            sb = new StringBuilder("EM: issue at fetching subs: ");
            str = e3.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
        } catch (InternalError e4) {
            level = Level.INFO;
            sb = new StringBuilder("EM: issue at fetching subs: ");
            str = e4.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        Map<String, Long> map = this.D;
        if (map != null) {
            map.clear();
        }
        this.D = new HashMap();
    }

    /* access modifiers changed from: private */
    public void o() {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    f.h;
                    com.userexperior.utilities.b.a(Level.INFO, "<-- STOP R - REASON :  Subscription or Rule based R Failed -->");
                    l.r(f.this.g);
                    l.d(f.this.g);
                    if (f.this.f4141d) {
                        f.this.q();
                        f.this.r();
                        return;
                    }
                    f.h;
                    com.userexperior.utilities.b.a(Level.WARNING, "NOT in R state");
                    l.b(f.this.g);
                    f.this.x();
                }
            });
        }
    }

    private void p() {
        if (this.f4141d) {
            com.userexperior.utilities.b.a(Level.INFO, "a in r state");
            return;
        }
        this.n = 0;
        this.A = 3;
        this.f4141d = true;
        this.x = false;
        this.s = true;
        this.t = true;
        try {
            a(true);
            this.B = 0;
            this.o = 0;
            this.p = SystemClock.uptimeMillis();
            Context context = this.g;
            com.userexperior.c.b.c cVar = new com.userexperior.c.b.c();
            cVar.f3864a = Calendar.getInstance().getTimeInMillis();
            cVar.f3865b = "default_task";
            cVar.f3867d = "default_description";
            cVar.f3866c = "default_username";
            String a2 = new com.userexperior.a.a.f().a((Object) cVar);
            Editor edit = context.getSharedPreferences(UserExperior.TAG, 0).edit();
            edit.putString("currentTaskJSON", a2);
            edit.apply();
            this.q = j.a(this.g);
            this.r = this.q + File.separator + "events.json";
            com.userexperior.utilities.b.a(Level.INFO, "ito");
            if (this.q == null) {
                this.q = j.i(this.g);
            }
            com.userexperior.utilities.b.a(Level.INFO, "BSS");
            if (!(this.f4142e == null || this.f4139b == null)) {
                i iVar = this.f4142e;
                Context context2 = this.g;
                String str = this.q;
                iVar.j = 200;
                if (iVar.f4244b == null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("session_base_path", str);
                    bundle.putParcelable("reply_to", iVar.f4243a);
                    ScreenShotService.a(context2, iVar, bundle);
                }
                com.userexperior.utilities.f fVar = new com.userexperior.utilities.f(iVar.m);
                iVar.i = fVar;
                fVar.f4273e = new com.userexperior.interfaces.recording.c() {
                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061 A[Catch:{ Exception -> 0x0084 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A[Catch:{ Exception -> 0x0084 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078 A[Catch:{ Exception -> 0x0084 }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void a() {
                        /*
                            r5 = this;
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            java.lang.String r0 = r0.l     // Catch:{ Exception -> 0x0084 }
                            java.lang.String r1 = "fr"
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0084 }
                            if (r0 == 0) goto L_0x0021
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.b r0 = r0.f4246d     // Catch:{ Exception -> 0x0084 }
                            if (r0 == 0) goto L_0x0057
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.i r1 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.b r1 = r1.f4246d     // Catch:{ Exception -> 0x0084 }
                            int r1 = r1.f4113a     // Catch:{ Exception -> 0x0084 }
                            goto L_0x0054
                        L_0x0021:
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            java.lang.String r0 = r0.l     // Catch:{ Exception -> 0x0084 }
                            java.lang.String r1 = "ca"
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0084 }
                            if (r0 == 0) goto L_0x0042
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.a r0 = r0.f4247e     // Catch:{ Exception -> 0x0084 }
                            if (r0 == 0) goto L_0x0057
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.i r1 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.a r1 = r1.f4247e     // Catch:{ Exception -> 0x0084 }
                            int r1 = r1.f4107a     // Catch:{ Exception -> 0x0084 }
                            goto L_0x0054
                        L_0x0042:
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.c r0 = r0.f4245c     // Catch:{ Exception -> 0x0084 }
                            if (r0 == 0) goto L_0x0057
                            com.userexperior.services.recording.i r0 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.i r1 = com.userexperior.services.recording.i.this     // Catch:{ Exception -> 0x0084 }
                            com.userexperior.services.recording.c r1 = r1.f4245c     // Catch:{ Exception -> 0x0084 }
                            int r1 = r1.f4124b     // Catch:{ Exception -> 0x0084 }
                        L_0x0054:
                            r0.h = r1     // Catch:{ Exception -> 0x0084 }
                        L_0x0057:
                            com.userexperior.services.recording.f r0 = com.userexperior.services.recording.f.g()     // Catch:{ Exception -> 0x0084 }
                            android.app.Activity r1 = com.userexperior.services.recording.i.f4242f     // Catch:{ Exception -> 0x0084 }
                            if (r1 == 0) goto L_0x006e
                            android.app.Activity r1 = com.userexperior.services.recording.i.f4242f     // Catch:{ Exception -> 0x0084 }
                            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0084 }
                            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x0084 }
                            goto L_0x0070
                        L_0x006e:
                            java.lang.String r1 = "APPLICATION"
                        L_0x0070:
                            com.userexperior.models.recording.enums.h r2 = com.userexperior.models.recording.enums.h.HOME_BUTTON_PRESSED     // Catch:{ Exception -> 0x0084 }
                            java.lang.String r3 = com.userexperior.models.recording.a.h()     // Catch:{ Exception -> 0x0084 }
                            if (r3 == 0) goto L_0x007c
                            java.lang.String r1 = com.userexperior.models.recording.a.h()     // Catch:{ Exception -> 0x0084 }
                        L_0x007c:
                            long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0084 }
                            r0.a(r2, r1, r3)     // Catch:{ Exception -> 0x0084 }
                            return
                        L_0x0084:
                            r0 = move-exception
                            java.util.logging.Level r1 = java.util.logging.Level.WARNING
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            java.lang.String r3 = "Error: HBP - "
                            r2.<init>(r3)
                            com.android.tools.r8.GeneratedOutlineSupport.outline95(r0, r2, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.i.AnonymousClass2.a():void");
                    }
                };
                fVar.f4274f = new com.userexperior.utilities.h(fVar, fVar);
                if (iVar.i != null) {
                    com.userexperior.utilities.f fVar2 = iVar.i;
                    if (fVar2.f4274f != null) {
                        fVar2.f4271c.registerReceiver(fVar2.f4274f, fVar2.f4272d);
                    }
                }
            }
            this.E = new LinkedHashSet();
            Editor edit2 = this.g.getSharedPreferences(UserExperior.TAG, 0).edit();
            edit2.remove("__ue_paused_image_list");
            edit2.apply();
            String simpleName = i() != null ? i().getClass().getSimpleName() : "APPLICATION";
            if (this.g.getSharedPreferences(UserExperior.TAG, 0).getBoolean("isNewAsi", false)) {
                h hVar = h.APP_LAUNCH;
                if (com.userexperior.models.recording.a.h() != null) {
                    simpleName = com.userexperior.models.recording.a.h();
                }
                a(hVar, simpleName, 0);
                l.v(this.g);
            }
            Editor edit3 = this.g.getSharedPreferences(UserExperior.TAG, 0).edit();
            edit3.remove("isNewAsi");
            edit3.apply();
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("issue at EM: sR - "), Level.INFO);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x018d A[Catch:{ RemoteException -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01b7 A[Catch:{ Exception -> 0x01c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q() {
        /*
            r9 = this;
            android.content.Context r0 = r9.g
            com.userexperior.utilities.l.v(r0)
            com.userexperior.models.recording.a.a()
            com.userexperior.models.recording.a.b()
            com.userexperior.provider.UeContentProvider.b()
            android.content.Context r0 = r9.g
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = "UserExperior"
            r4 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r4)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r5 = "sessionEndTime"
            r0.putLong(r5, r1)
            r0.apply()
            android.content.Context r0 = r9.g
            int r1 = r9.B
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r4)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r2 = "lastImageNum"
            r0.putInt(r2, r1)
            r0.apply()
            r9.n()
            com.userexperior.models.recording.f r0 = r9.k()
            com.userexperior.c.a.d r1 = new com.userexperior.c.a.d
            android.content.Context r2 = r9.g
            java.lang.String r2 = com.userexperior.utilities.l.z(r2)
            android.content.Context r5 = r9.g
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r3, r4)
            java.lang.String r6 = "appLaunchLatency"
            r7 = 0
            long r5 = r5.getLong(r6, r7)
            r1.<init>(r2, r5)
            r0.y = r1
            android.content.Context r1 = r9.g
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r4)
            java.lang.String r2 = "sst"
            long r1 = r1.getLong(r2, r7)
            r0.g = r1
            java.util.HashMap<java.lang.String, com.userexperior.c.a.e> r1 = r9.I
            r0.v = r1
            android.content.Context r1 = r9.g
            com.userexperior.utilities.l.a(r1, r0)
            java.util.HashMap<java.lang.String, com.userexperior.c.a.e> r0 = r9.I
            if (r0 == 0) goto L_0x007c
            r0.clear()
        L_0x007c:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r9.I = r0
            boolean r0 = r9.f4141d
            if (r0 != 0) goto L_0x0094
            java.util.logging.Level r0 = java.util.logging.Level.WARNING
            java.lang.String r1 = "Not in recording state"
            com.userexperior.utilities.b.a(r0, r1)
            android.content.Context r0 = r9.g
            com.userexperior.utilities.l.b(r0)
            return
        L_0x0094:
            r9.f4141d = r4
            r9.x()
            android.content.Context r0 = r9.g
            java.lang.String r0 = com.userexperior.utilities.l.f(r0)
            com.userexperior.services.recording.i r1 = r9.f4142e
            if (r1 == 0) goto L_0x00de
            android.os.Message r2 = android.os.Message.obtain()
            r5 = 45855(0xb31f, float:6.4257E-41)
            r2.what = r5
            java.lang.String r5 = "user_device_id"
            android.os.Bundle r0 = com.android.tools.r8.GeneratedOutlineSupport.outline14(r5, r0)
            r2.obj = r0
            android.os.Messenger r0 = r1.f4243a
            r2.replyTo = r0
            android.os.Messenger r0 = r1.f4244b     // Catch:{ RemoteException -> 0x00c3 }
            if (r0 == 0) goto L_0x00de
            android.os.Messenger r0 = r1.f4244b     // Catch:{ RemoteException -> 0x00c3 }
            r0.send(r2)     // Catch:{ RemoteException -> 0x00c3 }
            goto L_0x00de
        L_0x00c3:
            r0 = move-exception
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Error saveDeviceId(): "
            r2.<init>(r5)
            java.lang.String r5 = r0.getMessage()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.userexperior.utilities.b.a(r1, r2)
            r0.printStackTrace()
        L_0x00de:
            android.content.Context r0 = r9.g
            java.util.HashSet<java.lang.Integer> r1 = r9.E
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r4)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            com.userexperior.a.a.f r2 = new com.userexperior.a.a.f
            r2.<init>()
            java.lang.String r1 = r2.a(r1)
            java.lang.String r2 = "__ue_paused_image_list"
            r0.putString(r2, r1)
            r0.apply()
            com.userexperior.services.recording.i r0 = r9.f4142e
            if (r0 == 0) goto L_0x01e9
            java.util.logging.Level r1 = java.util.logging.Level.INFO
            java.lang.String r2 = "R -- SP"
            com.userexperior.utilities.b.a(r1, r2)
            com.userexperior.services.recording.f r1 = g()     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.services.recording.i$3 r2 = new com.userexperior.services.recording.i$3     // Catch:{ Exception -> 0x01c3 }
            r2.<init>()     // Catch:{ Exception -> 0x01c3 }
            r1.a(r2)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r1 = r0.l     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = "fr"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = "t ---> "
            if (r1 == 0) goto L_0x013d
            com.userexperior.services.recording.b r1 = r0.f4246d     // Catch:{ Exception -> 0x01c3 }
            if (r1 == 0) goto L_0x0188
            java.util.logging.Level r1 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x01c3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c3 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.services.recording.b r2 = r0.f4246d     // Catch:{ Exception -> 0x01c3 }
            int r2 = r2.f4113a     // Catch:{ Exception -> 0x01c3 }
            r3.append(r2)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.utilities.b.a(r1, r2)     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.services.recording.b r1 = r0.f4246d     // Catch:{ Exception -> 0x01c3 }
            int r1 = r1.f4113a     // Catch:{ Exception -> 0x01c3 }
            goto L_0x0182
        L_0x013d:
            java.lang.String r1 = r0.l     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r3 = "ca"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x01c3 }
            if (r1 == 0) goto L_0x0165
            com.userexperior.services.recording.a r1 = r0.f4247e     // Catch:{ Exception -> 0x01c3 }
            if (r1 == 0) goto L_0x0188
            java.util.logging.Level r1 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x01c3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c3 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.services.recording.a r2 = r0.f4247e     // Catch:{ Exception -> 0x01c3 }
            int r2 = r2.f4107a     // Catch:{ Exception -> 0x01c3 }
            r3.append(r2)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.utilities.b.a(r1, r2)     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.services.recording.a r1 = r0.f4247e     // Catch:{ Exception -> 0x01c3 }
            int r1 = r1.f4107a     // Catch:{ Exception -> 0x01c3 }
            goto L_0x0182
        L_0x0165:
            com.userexperior.services.recording.c r1 = r0.f4245c     // Catch:{ Exception -> 0x01c3 }
            if (r1 == 0) goto L_0x0188
            java.util.logging.Level r1 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x01c3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c3 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.services.recording.c r2 = r0.f4245c     // Catch:{ Exception -> 0x01c3 }
            int r2 = r2.f4124b     // Catch:{ Exception -> 0x01c3 }
            r3.append(r2)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.utilities.b.a(r1, r2)     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.services.recording.c r1 = r0.f4245c     // Catch:{ Exception -> 0x01c3 }
            int r1 = r1.f4124b     // Catch:{ Exception -> 0x01c3 }
        L_0x0182:
            int r2 = r0.j     // Catch:{ Exception -> 0x01c3 }
            int r1 = r1 * r2
            long r1 = (long) r1
            goto L_0x0189
        L_0x0188:
            r1 = r7
        L_0x0189:
            android.os.Messenger r3 = r0.f4244b     // Catch:{ RemoteException -> 0x0197 }
            if (r3 == 0) goto L_0x01b2
            android.os.Messenger r3 = r0.f4244b     // Catch:{ RemoteException -> 0x0197 }
            android.os.Message r1 = com.userexperior.services.recording.i.a(r1)     // Catch:{ RemoteException -> 0x0197 }
            r3.send(r1)     // Catch:{ RemoteException -> 0x0197 }
            goto L_0x01b2
        L_0x0197:
            r1 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x01c3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r5 = "Error saveTime(): "
            r3.<init>(r5)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r5 = r1.getMessage()     // Catch:{ Exception -> 0x01c3 }
            r3.append(r5)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01c3 }
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Exception -> 0x01c3 }
            r1.printStackTrace()     // Catch:{ Exception -> 0x01c3 }
        L_0x01b2:
            java.util.Timer r1 = r0.g     // Catch:{ Exception -> 0x01c3 }
            r2 = 0
            if (r1 == 0) goto L_0x01be
            java.util.Timer r1 = r0.g     // Catch:{ Exception -> 0x01c3 }
            r1.cancel()     // Catch:{ Exception -> 0x01c3 }
            r0.g = r2     // Catch:{ Exception -> 0x01c3 }
        L_0x01be:
            r0.f4245c = r2     // Catch:{ Exception -> 0x01c3 }
            r0.f4246d = r2     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01e9
        L_0x01c3:
            r0 = move-exception
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Ex : SSC - stopRecording : "
            r2.<init>(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.userexperior.utilities.b.a(r1, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Exception Ex while stop recording "
            r1.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
        L_0x01e9:
            r9.x = r4
            r9.o = r7
            r9.s = r4
            r9.t = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.f.q():void");
    }

    /* access modifiers changed from: private */
    public void r() {
        com.userexperior.utilities.b.a(Level.INFO, "UBSS");
        i iVar = this.f4142e;
        if (iVar != null) {
            Context context = this.g;
            if (iVar.f4244b != null) {
                context.unbindService(iVar);
                iVar.f4244b = null;
            }
            iVar.b();
        }
    }

    private void s() {
        if (!WindowCallback.c() && WindowCallback.b() != null) {
            a(WindowCallback.b(), WindowCallback.a());
        }
        if (WindowCallback.d()) {
            MotionEvent e2 = WindowCallback.e();
            MotionEvent f2 = WindowCallback.f();
            if (!(e2 == null || f2 == null)) {
                com.userexperior.models.recording.a aVar = this.w;
                if (aVar != null) {
                    a(h.SWIPE, aVar.d(), e2, f2);
                    return;
                }
                a(h.SWIPE, i.a().getClass().getSimpleName(), e2, f2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void t() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "enablePauseDueToScroll. isPausedDueToScroll = "
            r0.<init>(r1)     // Catch:{ all -> 0x0047 }
            boolean r1 = r2.G     // Catch:{ all -> 0x0047 }
            r0.append(r1)     // Catch:{ all -> 0x0047 }
            boolean r0 = r2.f4141d     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0045
            com.userexperior.services.recording.i r0 = r2.f4142e     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x001b
            com.userexperior.services.recording.i r0 = r2.f4142e     // Catch:{ all -> 0x0047 }
            r1 = 0
            r0.a(r1)     // Catch:{ all -> 0x0047 }
        L_0x001b:
            r0 = 1
            r2.G = r0     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "resetPauseToScrollCountDownTimer. isPausedDueToScroll = "
            r0.<init>(r1)     // Catch:{ all -> 0x0047 }
            boolean r1 = r2.G     // Catch:{ all -> 0x0047 }
            r0.append(r1)     // Catch:{ all -> 0x0047 }
            android.os.CountDownTimer r0 = r2.F     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x003a
            android.os.CountDownTimer r0 = r2.F     // Catch:{ all -> 0x0047 }
            r0.cancel()     // Catch:{ all -> 0x0047 }
            android.os.CountDownTimer r0 = r2.F     // Catch:{ all -> 0x0047 }
            r0.start()     // Catch:{ all -> 0x0047 }
            monitor-exit(r2)
            return
        L_0x003a:
            com.userexperior.services.recording.f$18 r0 = new com.userexperior.services.recording.f$18     // Catch:{ all -> 0x0047 }
            r0.<init>()     // Catch:{ all -> 0x0047 }
            android.os.CountDownTimer r0 = r0.start()     // Catch:{ all -> 0x0047 }
            r2.F = r0     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r2)
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.f.t():void");
    }

    /* access modifiers changed from: private */
    public void u() {
        try {
            if (this.f4141d) {
                if (this.j) {
                    a(1);
                    this.j = false;
                } else if (this.w != null) {
                    try {
                        this.w.f();
                    } catch (Exception e2) {
                        Level level = Level.SEVERE;
                        com.userexperior.utilities.b.a(level, "Ex : EM - checkAndResumeAR : " + e2.getMessage());
                    }
                }
                if (this.i) {
                    b();
                    this.i = false;
                }
            }
        } catch (Exception e3) {
            Level level2 = Level.SEVERE;
            com.userexperior.utilities.b.a(level2, "Ex : EM - checkAndResumeAR - 2 : " + e3.getMessage());
            new StringBuilder("Error : ").append(e3.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        com.userexperior.c.c.d dVar;
        String str;
        Level level;
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        File file = new File(j.d(this.g));
        File[] listFiles = file.listFiles();
        if (!file.exists() || !file.isDirectory() || listFiles == null || listFiles.length == 0) {
            dVar = null;
        } else {
            for (File file2 : listFiles) {
                if (file2 == null) {
                    level = Level.INFO;
                    str = "c file does not exist";
                } else if (!file2.exists() || !file2.isFile() || !file2.getName().endsWith(".log")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(file);
                    sb.append(" skipped.....");
                } else if (com.userexperior.e.h.a(new Date(file2.lastModified()).getTime(), System.currentTimeMillis(), TimeUnit.MINUTES) > 2880) {
                    boolean delete = file2.delete();
                    a(file2);
                    com.userexperior.utilities.b.a(Level.INFO, "Deleting the cl - older than xx hours......");
                    level = Level.INFO;
                    str = "delete = ".concat(String.valueOf(delete));
                } else {
                    synchronizedList.add(new com.userexperior.c.c.e(file2.getPath(), com.userexperior.models.recording.enums.d.CRASH_LOG));
                    com.userexperior.e.h.c(file2);
                }
                com.userexperior.utilities.b.a(level, str);
            }
            dVar = new com.userexperior.c.c.d(synchronizedList);
        }
        com.userexperior.utilities.i.a();
        if (com.userexperior.utilities.i.b()) {
            if (dVar != null) {
                List<com.userexperior.c.c.e> list = dVar.f3887d;
                if (!(list == null || list.size() == 0)) {
                    JIUploadService.a(this.g, dVar);
                }
            }
            return;
        }
        com.userexperior.utilities.b.a(Level.SEVERE, "Device not connected to Internet!");
    }

    /* access modifiers changed from: private */
    public void w() {
        com.userexperior.c.c.d dVar;
        String str;
        Level level;
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        File file = new File(j.e(this.g));
        File[] listFiles = file.listFiles();
        if (!file.exists() || !file.isDirectory() || listFiles == null || listFiles.length == 0) {
            dVar = null;
        } else {
            for (File file2 : listFiles) {
                if (file2 == null) {
                    level = Level.INFO;
                    str = "a file does not exist";
                } else if (!file2.exists() || !file2.isFile() || !file2.getName().endsWith("_A.log")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(file);
                    sb.append(" skipped.....");
                } else if (com.userexperior.e.h.a(new Date(file2.lastModified()).getTime(), System.currentTimeMillis(), TimeUnit.MINUTES) > 2880) {
                    boolean delete = file2.delete();
                    a(file2);
                    com.userexperior.utilities.b.a(Level.INFO, "Deleting the al - older than xx hours......");
                    level = Level.INFO;
                    str = "delete = ".concat(String.valueOf(delete));
                } else {
                    synchronizedList.add(new com.userexperior.c.c.e(file2.getPath(), com.userexperior.models.recording.enums.d.ANR_LOG));
                    com.userexperior.e.h.c(file2);
                }
                com.userexperior.utilities.b.a(level, str);
            }
            dVar = new com.userexperior.c.c.d(synchronizedList);
        }
        com.userexperior.utilities.i.a();
        if (com.userexperior.utilities.i.b()) {
            if (dVar != null) {
                List<com.userexperior.c.c.e> list = dVar.f3887d;
                if (!(list == null || list.size() == 0)) {
                    JIUploadService.b(this.g, dVar);
                }
            }
            return;
        }
        com.userexperior.utilities.b.a(Level.SEVERE, "Device not connected to Internet!");
    }

    /* access modifiers changed from: private */
    public void x() {
        try {
            if (this.w != null) {
                this.w.e();
                this.w.g();
            }
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("Ex : EM - stopTimers : "), Level.SEVERE);
        }
    }

    public final void a() {
        this.y = false;
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    com.userexperior.utilities.b.a(Level.INFO, "<-- Application PAUSED -->");
                    f.this.n();
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
                    com.userexperior.utilities.b.a(Level.WARNING, "NOT in R state");
                    l.b(f.this.g);
                }
            });
        }
    }

    public final void a(final Activity activity) {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    f.h;
                    new StringBuilder("setLatestActivity ").append(Thread.currentThread().getName());
                    if (activity == null) {
                        com.userexperior.utilities.b.a(Level.WARNING, "latestActivity is null");
                        return;
                    }
                    f.h;
                    new StringBuilder("set latest activity called : ").append(activity.toString());
                    if (f.this.f4142e != null) {
                        f.this.f4142e.a(activity);
                    } else {
                        f.h;
                    }
                }
            });
        }
    }

    public final void a(Context context) {
        if (this.w == null) {
            com.userexperior.models.recording.a aVar = new com.userexperior.models.recording.a(this);
            this.w = aVar;
            Application application = (Application) context;
            this.f4139b = application;
            application.registerActivityLifecycleCallbacks(aVar);
        }
    }

    public final void a(final com.userexperior.d.a.a aVar) {
        com.userexperior.c.a.a aVar2;
        l.r(this.g);
        if (this.f4141d) {
            s();
            long uptimeMillis = SystemClock.uptimeMillis();
            com.userexperior.models.recording.a aVar3 = this.w;
            if (aVar3 != null) {
                String d2 = aVar3.d() != null ? this.w.d() : "APPLICATION";
                if (com.userexperior.models.recording.a.h() != null) {
                    d2 = com.userexperior.models.recording.a.h();
                }
                aVar2 = a(d2, h.ANR, uptimeMillis);
            } else {
                aVar2 = a((String) "Application", h.ANR, uptimeMillis);
            }
            a(aVar2);
            Handler handler = this.f4140c;
            if (handler != null) {
                handler.post(new Runnable() {
                    public final void run() {
                        f.this.q();
                        f.this.r();
                        Editor edit = f.this.g.getSharedPreferences(UserExperior.TAG, 0).edit();
                        edit.putBoolean("doesANROccurred", true);
                        edit.apply();
                        StringBuilder b2 = f.b(aVar);
                        com.userexperior.models.recording.f r = f.this.k();
                        r.k = false;
                        r.l = true;
                        Throwable cause = aVar.getCause();
                        if (cause != null) {
                            r.n = cause.getMessage();
                        }
                        r.f4085b = i.INITIAL_STATE;
                        f.a(f.this, b2, r);
                        l.a(f.this.g, r);
                        f.a(f.this, r);
                        if (l.a(f.this.g) != null) {
                            l.b(f.this.g);
                        }
                    }
                });
            }
            return;
        }
        d dVar = this.u;
        if (dVar != null) {
            dVar.interrupt();
        }
    }

    public final void a(h hVar, String str, long j2) {
        Handler handler = this.f4140c;
        if (handler != null) {
            final h hVar2 = hVar;
            final String str2 = str;
            final long j3 = j2;
            AnonymousClass10 r1 = new Runnable() {
                public final void run() {
                    f.h;
                    StringBuilder sb = new StringBuilder("event (1) ");
                    sb.append(hVar2);
                    sb.append(CMap.SPACE);
                    sb.append(str2);
                    sb.append(CMap.SPACE);
                    sb.append(j3);
                    f.this.b(false);
                    f.this.u();
                    if (f.this.t) {
                        f fVar = f.this;
                        fVar.a(fVar.a(str2, hVar2, j3));
                        return;
                    }
                    f.h;
                }
            };
            handler.post(r1);
        }
    }

    public final void a(h hVar, String str, InputEvent inputEvent, g gVar) {
        Handler handler = this.f4140c;
        if (handler != null) {
            final h hVar2 = hVar;
            final String str2 = str;
            final InputEvent inputEvent2 = inputEvent;
            final g gVar2 = gVar;
            AnonymousClass16 r1 = new Runnable() {
                public final void run() {
                    f.h;
                    StringBuilder sb = new StringBuilder("event (5) ");
                    sb.append(hVar2);
                    sb.append(" on ");
                    sb.append(str2);
                    f.this.b(true);
                    f.this.u();
                    f fVar = f.this;
                    f.b(fVar, f.a(fVar, hVar2, inputEvent2, str2, gVar2));
                }
            };
            handler.post(r1);
        }
    }

    public final void a(final h hVar, final String str, final MotionEvent motionEvent) {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    f.h;
                    StringBuilder sb = new StringBuilder("event (4) ");
                    sb.append(hVar);
                    sb.append(" on ");
                    sb.append(str);
                    f.this.b(true);
                    f.this.u();
                    f fVar = f.this;
                    f.b(fVar, f.a(fVar, hVar, (InputEvent) motionEvent, str, (g) null));
                }
            });
        }
    }

    public final void a(h hVar, String str, MotionEvent motionEvent, MotionEvent motionEvent2) {
        StringBuilder sb = new StringBuilder("event (6) ");
        sb.append(hVar);
        sb.append(" on ");
        sb.append(str);
        Handler handler = this.f4140c;
        if (handler != null) {
            final h hVar2 = hVar;
            final MotionEvent motionEvent3 = motionEvent;
            final MotionEvent motionEvent4 = motionEvent2;
            final String str2 = str;
            AnonymousClass17 r1 = new Runnable() {
                public final void run() {
                    if (hVar2 != h.SWIPE) {
                        f.this.b(true);
                    }
                    f.this.u();
                    f fVar = f.this;
                    f.b(fVar, f.a(fVar, hVar2, motionEvent3, motionEvent4, str2));
                }
            };
            handler.post(r1);
        }
    }

    public final void a(h hVar, String str, String str2, String str3, long j2) {
        Handler handler = this.f4140c;
        if (handler != null) {
            final h hVar2 = hVar;
            final String str4 = str3;
            final long j3 = j2;
            final String str5 = str;
            final String str6 = str2;
            AnonymousClass14 r0 = new Runnable() {
                public final void run() {
                    f.h;
                    StringBuilder sb = new StringBuilder("event (3) ");
                    sb.append(hVar2);
                    sb.append(CMap.SPACE);
                    sb.append(str4);
                    sb.append(CMap.SPACE);
                    sb.append(j3);
                    f.this.b(false);
                    f.this.u();
                    if (f.this.t) {
                        f.this.a(f.a(str4, hVar2, str5, str6, j3));
                    } else {
                        f.h;
                    }
                }
            };
            handler.post(r0);
        }
    }

    public final void a(Runnable runnable) {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public final void a(String str, int i2, long j2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        String str2;
        String str3 = str;
        u();
        if (this.t) {
            long a2 = a(SystemClock.uptimeMillis());
            if (com.userexperior.models.recording.a.h() != null) {
                str2 = com.userexperior.models.recording.a.h();
            } else {
                com.userexperior.models.recording.a aVar = this.w;
                str2 = aVar != null ? aVar.d() : "APPLICATION";
            }
            e eVar = new e(str, str2, i2, a2, j2, hashMap, hashMap2);
            long j3 = eVar.f3817c;
            HashMap<String, e> hashMap3 = this.I;
            if (hashMap3.containsKey(str + j3) && eVar.f3816b != -1) {
                HashMap<String, e> hashMap4 = this.I;
                hashMap4.remove(str + j3);
            }
            HashMap<String, e> hashMap5 = this.I;
            hashMap5.put(str + j3, eVar);
            if (this.q == null) {
                this.q = j.i(this.g);
            }
            String a3 = j.a(this.q);
            this.r = a3;
            if (a3 != null) {
                Handler handler = this.f4140c;
                if (handler != null) {
                    handler.post(new com.userexperior.d.b.b(eVar, this.r));
                }
            }
        }
    }

    public final void a(String str, long j2, HashMap<String, String> hashMap) {
        b(str, j2, hashMap);
    }

    public final void b() {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    Level level;
                    String str;
                    f.this.n();
                    f.this.y = true;
                    if (!f.this.z) {
                        level = Level.SEVERE;
                        str = "UserExperior not initalized";
                    } else if (l.t(f.this.g)) {
                        level = Level.INFO;
                        str = "awtr: user has o-o";
                    } else {
                        com.userexperior.e.h.a(f.this.g);
                        f.i(f.this);
                        if (f.this.f4141d) {
                            level = Level.SEVERE;
                            str = "a in r state";
                        } else {
                            boolean z = f.this.g.getSharedPreferences(UserExperior.TAG, 0).getBoolean("stopRecFlag", false);
                            boolean x = l.x(f.this.g);
                            if (!z && !x) {
                                f.k(f.this);
                            }
                            return;
                        }
                    }
                    com.userexperior.utilities.b.a(level, str);
                }
            });
        }
    }

    public final void c() {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    f.h;
                    f.this.b(true);
                }
            });
        }
    }

    public final void d() {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        f.this.t();
                    } catch (Exception e2) {
                        f.h;
                        new StringBuilder("ex = ").append(e2.getMessage());
                    }
                }
            });
        }
    }

    public final void e() {
        new StringBuilder("timeout ").append(Thread.currentThread().getName());
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    f.h;
                    com.userexperior.utilities.b.a(Level.INFO, "<-- STOP R - REASON :  TIMEOUT");
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
                    com.userexperior.utilities.b.a(Level.WARNING, "NOT in R state");
                    l.b(f.this.g);
                }
            });
        }
        this.i = true;
    }

    public final void f() {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    f.h;
                    com.userexperior.utilities.b.a(Level.INFO, ClientDisconnectionReason.IDLE);
                    f.this.j = true;
                    f.a(f.this, 1);
                }
            });
        }
    }

    public final void h() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.f4140c = new Handler(myLooper);
        } else {
            this.f4140c = null;
        }
    }

    public final void j() {
        if (this.f4140c == null) {
            h();
        }
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    if (!f.this.f4141d) {
                        f.this.n();
                        f.k(f.this);
                        com.userexperior.utilities.b.a(Level.INFO, "A - U2!");
                        l.c(f.this.g, false);
                        return;
                    }
                    com.userexperior.utilities.b.a(Level.INFO, "A - U a");
                }
            });
        }
    }

    public final com.userexperior.models.recording.f k() {
        if (this.q == null) {
            this.q = j.i(this.g);
        }
        com.userexperior.models.recording.f c2 = l.c(this.g, this.q);
        if (c2 == null) {
            c2 = new com.userexperior.models.recording.f();
        }
        String str = this.q;
        c2.r = str;
        c2.f4086c = str;
        c2.f4084a = l.n(this.g);
        c2.f4087d = l.o(this.g);
        c2.f4088e = l.q(this.g);
        c2.j = l.l(this.g);
        c2.f4089f = l.j(this.g);
        c2.h = (long) l.m(this.g);
        c2.i = l.a(this.g);
        c2.t = new com.userexperior.c.c.a().a(this.g);
        return c2;
    }

    public final Context l() {
        Application application = this.f4139b;
        return application != null ? application.getApplicationContext() : i() != null ? i().getApplicationContext() : com.userexperior.utilities.a.a();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLooperPrepared() {
        Thread.currentThread().setName("ue_EM");
        this.z = true;
        a aVar = this.f4143f;
        if (aVar != null) {
            aVar.a();
        }
        try {
            h();
            if (this.f4139b != null) {
                d dVar = new d();
                this.u = dVar;
                dVar.f3905a = this;
                dVar.f3906b = null;
                dVar.start();
                this.v = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
            } else {
                new StringBuilder("quitting looper ").append(quitSafely());
            }
            if (this.f4140c != null) {
                this.f4140c.post(new Runnable() {
                    public final void run() {
                        f.h;
                        Activity i = f.i();
                        if (f.this.y) {
                            com.userexperior.utilities.b.a(Level.INFO, "app already in runnning state");
                            return;
                        }
                        if (!(i == null || f.this.w == null)) {
                            f.this.w.onActivityResumed(i);
                        }
                    }
                });
            }
        } catch (Exception e2) {
            GeneratedOutlineSupport.outline95(e2, new StringBuilder("Ex : EM - onLP : "), Level.SEVERE);
        }
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(final int i2) {
        Handler handler = this.f4140c;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    com.userexperior.utilities.b.a(Level.WARNING, "Recording stopped due to LOW MEMORY.");
                    int i = i2;
                    if (i == 5 || i == 10 || i == 15) {
                        com.userexperior.utilities.b.a(Level.WARNING, "Recording stopped due to LOW MEMORY.");
                        l.r(f.this.g);
                        l.d(f.this.g);
                        if (f.this.f4141d) {
                            f.this.q();
                            com.userexperior.models.recording.f r = f.this.k();
                            l.a(f.this.g, r);
                            f.a(f.this, r);
                            f.this.r();
                            return;
                        }
                        f.h;
                        l.b(f.this.g);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0221 A[Catch:{ Exception -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x023c A[Catch:{ Exception -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0281 A[SYNTHETIC, Splitter:B:119:0x0281] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uncaughtException(java.lang.Thread r18, java.lang.Throwable r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            java.lang.String r0 = ""
            android.content.Context r4 = r1.g     // Catch:{ Exception -> 0x02a8 }
            com.userexperior.c.b.a r4 = com.userexperior.utilities.l.e(r4)     // Catch:{ Exception -> 0x02a8 }
            if (r4 == 0) goto L_0x0042
            java.lang.String r5 = r4.f3824e     // Catch:{ Exception -> 0x02a8 }
            boolean r6 = r4.f3825f     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r7 = "3"
            boolean r7 = r5.equals(r7)     // Catch:{ Exception -> 0x02a8 }
            if (r7 != 0) goto L_0x0024
            java.lang.String r7 = "4"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x02a8 }
            if (r5 == 0) goto L_0x0032
        L_0x0024:
            if (r6 != 0) goto L_0x0032
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x0031
            if (r2 == 0) goto L_0x0031
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x02a8 }
            r0.uncaughtException(r2, r3)     // Catch:{ Exception -> 0x02a8 }
        L_0x0031:
            return
        L_0x0032:
            boolean r4 = r4.f3821b     // Catch:{ Exception -> 0x02a8 }
            if (r4 != 0) goto L_0x0042
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x0041
            if (r2 == 0) goto L_0x0041
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x02a8 }
            r0.uncaughtException(r2, r3)     // Catch:{ Exception -> 0x02a8 }
        L_0x0041:
            return
        L_0x0042:
            boolean r4 = r1.f4141d     // Catch:{ Exception -> 0x02a8 }
            if (r4 != 0) goto L_0x0052
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x0051
            if (r2 == 0) goto L_0x0051
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x02a8 }
            r0.uncaughtException(r2, r3)     // Catch:{ Exception -> 0x02a8 }
        L_0x0051:
            return
        L_0x0052:
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x02a8 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028c }
            java.lang.String r7 = "exception: "
            r6.<init>(r7)     // Catch:{ Exception -> 0x028c }
            java.lang.String r7 = r19.getMessage()     // Catch:{ Exception -> 0x028c }
            r6.append(r7)     // Catch:{ Exception -> 0x028c }
            r17.s()     // Catch:{ Exception -> 0x028c }
            boolean r6 = r1.t     // Catch:{ Exception -> 0x028c }
            if (r6 == 0) goto L_0x028b
            long r12 = r1.a(r4)     // Catch:{ Exception -> 0x028c }
            com.userexperior.models.recording.a r4 = r1.w     // Catch:{ Exception -> 0x028c }
            if (r4 == 0) goto L_0x009c
            com.userexperior.models.recording.a r4 = r1.w     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = r4.d()     // Catch:{ Exception -> 0x028c }
            if (r4 == 0) goto L_0x0082
            com.userexperior.models.recording.a r4 = r1.w     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = r4.d()     // Catch:{ Exception -> 0x028c }
            goto L_0x0084
        L_0x0082:
            java.lang.String r4 = "APPLICATION"
        L_0x0084:
            java.lang.String r5 = com.userexperior.models.recording.a.h()     // Catch:{ Exception -> 0x028c }
            if (r5 == 0) goto L_0x008e
            java.lang.String r4 = com.userexperior.models.recording.a.h()     // Catch:{ Exception -> 0x028c }
        L_0x008e:
            r11 = r4
            com.userexperior.c.a.a r4 = new com.userexperior.c.a.a     // Catch:{ Exception -> 0x028c }
            com.userexperior.models.recording.enums.a r8 = com.userexperior.models.recording.enums.a.SYSTEM     // Catch:{ Exception -> 0x028c }
            com.userexperior.models.recording.enums.h r9 = com.userexperior.models.recording.enums.h.EXCEPTION     // Catch:{ Exception -> 0x028c }
            r10 = 0
            r14 = 0
            r7 = r4
            r7.<init>(r8, r9, r10, r11, r12, r14)     // Catch:{ Exception -> 0x028c }
            goto L_0x00aa
        L_0x009c:
            com.userexperior.c.a.a r4 = new com.userexperior.c.a.a     // Catch:{ Exception -> 0x028c }
            com.userexperior.models.recording.enums.a r8 = com.userexperior.models.recording.enums.a.SYSTEM     // Catch:{ Exception -> 0x028c }
            com.userexperior.models.recording.enums.h r9 = com.userexperior.models.recording.enums.h.EXCEPTION     // Catch:{ Exception -> 0x028c }
            r10 = 0
            java.lang.String r11 = "Application"
            r14 = 0
            r7 = r4
            r7.<init>(r8, r9, r10, r11, r12, r14)     // Catch:{ Exception -> 0x028c }
        L_0x00aa:
            r1.a(r4)     // Catch:{ Exception -> 0x028c }
            java.lang.Class r4 = r19.getClass()     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x028c }
            java.lang.String r5 = "class "
            java.lang.String r4 = r4.replace(r5, r0)     // Catch:{ Exception -> 0x028c }
            r17.q()     // Catch:{ Exception -> 0x028c }
            r17.r()     // Catch:{ Exception -> 0x028c }
            r19.printStackTrace()     // Catch:{ Exception -> 0x028c }
            java.io.StringWriter r5 = new java.io.StringWriter     // Catch:{ Exception -> 0x028c }
            r5.<init>()     // Catch:{ Exception -> 0x028c }
            java.io.PrintWriter r6 = new java.io.PrintWriter     // Catch:{ Exception -> 0x028c }
            r6.<init>(r5)     // Catch:{ Exception -> 0x028c }
            r3.printStackTrace(r6)     // Catch:{ Exception -> 0x028c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028c }
            r6.<init>()     // Catch:{ Exception -> 0x028c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x028c }
            r6.append(r5)     // Catch:{ Exception -> 0x028c }
            java.lang.String r5 = "com.userexperior"
            int r5 = r6.indexOf(r5)     // Catch:{ Exception -> 0x028c }
            r7 = -1
            r8 = 0
            r9 = 1
            if (r5 == r7) goto L_0x00f2
            java.lang.String r5 = "com.userexperior.models.recording.WindowCallback"
            int r5 = r6.indexOf(r5)     // Catch:{ Exception -> 0x028c }
            if (r5 != r7) goto L_0x00f2
            r5 = 1
            goto L_0x00f3
        L_0x00f2:
            r5 = 0
        L_0x00f3:
            com.userexperior.models.recording.f r7 = r17.k()     // Catch:{ Exception -> 0x028c }
            r7.l = r8     // Catch:{ Exception -> 0x028c }
            r7.k = r9     // Catch:{ Exception -> 0x028c }
            android.content.Context r10 = r1.g     // Catch:{ Exception -> 0x028c }
            com.userexperior.utilities.l.a(r10, r7)     // Catch:{ Exception -> 0x028c }
            r7.m = r4     // Catch:{ Exception -> 0x028c }
            r7.q = r6     // Catch:{ Exception -> 0x028c }
            android.content.Context r4 = r1.g     // Catch:{ Exception -> 0x028c }
            java.lang.String r10 = "UserExperior"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r10, r8)     // Catch:{ Exception -> 0x028c }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x028c }
            java.lang.String r8 = "isAppCrashed"
            r4.putBoolean(r8, r9)     // Catch:{ Exception -> 0x028c }
            r4.apply()     // Catch:{ Exception -> 0x028c }
            if (r2 == 0) goto L_0x011e
            java.lang.String r0 = r18.getName()     // Catch:{ Exception -> 0x028c }
        L_0x011e:
            r4 = r0
            java.lang.String r0 = "Crash Log :\n------------------------\n"
            java.lang.String r8 = r6.toString()     // Catch:{ Exception -> 0x028c }
            java.lang.String r0 = r0.concat(r8)     // Catch:{ Exception -> 0x028c }
            java.lang.String r8 = "\n\nThread : "
            java.lang.String r10 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x028c }
            java.lang.String r8 = r8.concat(r10)     // Catch:{ Exception -> 0x028c }
            java.lang.String r0 = r0.concat(r8)     // Catch:{ Exception -> 0x028c }
            java.lang.String r8 = "\n--- Device details ---\n"
            java.lang.String r0 = r0.concat(r8)     // Catch:{ Exception -> 0x028c }
            com.userexperior.a.a.h r8 = new com.userexperior.a.a.h     // Catch:{ Exception -> 0x028c }
            r8.<init>()     // Catch:{ Exception -> 0x028c }
            r8.f3752b = r9     // Catch:{ Exception -> 0x028c }
            com.userexperior.a.a.f r8 = r8.a()     // Catch:{ Exception -> 0x028c }
            com.userexperior.c.c.a r9 = r7.t     // Catch:{ Exception -> 0x028c }
            java.lang.String r8 = r8.a(r9)     // Catch:{ Exception -> 0x028c }
            java.lang.String r0 = r0.concat(r8)     // Catch:{ Exception -> 0x028c }
            android.content.Context r8 = r1.g     // Catch:{ Exception -> 0x028c }
            java.lang.String r8 = com.userexperior.utilities.j.b(r8)     // Catch:{ Exception -> 0x028c }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x028c }
            r9.<init>(r8)     // Catch:{ Exception -> 0x028c }
            r10 = 0
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x01f2 }
            android.content.Context r12 = r1.g     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r12 = com.userexperior.utilities.j.f(r12)     // Catch:{ Exception -> 0x01f2 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x01f2 }
            double r12 = com.userexperior.e.h.a(r11)     // Catch:{ Exception -> 0x01f2 }
            r14 = 4632233691727265792(0x4049000000000000, double:50.0)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x01ac
            java.io.File r11 = r9.getParentFile()     // Catch:{ Exception -> 0x01f2 }
            if (r11 == 0) goto L_0x0182
            boolean r12 = r11.exists()     // Catch:{ Exception -> 0x01f2 }
            if (r12 != 0) goto L_0x0182
            r11.mkdirs()     // Catch:{ Exception -> 0x01f2 }
        L_0x0182:
            boolean r11 = r9.exists()     // Catch:{ Exception -> 0x01f2 }
            if (r11 != 0) goto L_0x0193
            r9.createNewFile()     // Catch:{ Exception -> 0x01f2 }
            r7.p = r8     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r8 = r9.getName()     // Catch:{ Exception -> 0x01f2 }
            r7.o = r8     // Catch:{ Exception -> 0x01f2 }
        L_0x0193:
            java.io.FileWriter r8 = new java.io.FileWriter     // Catch:{ Exception -> 0x01f2 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x01f2 }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x01f2 }
            r11.<init>(r8)     // Catch:{ Exception -> 0x01f2 }
            r11.write(r0)     // Catch:{ Exception -> 0x01a9, all -> 0x01a4 }
        L_0x01a0:
            com.userexperior.e.h.c(r9)     // Catch:{ Exception -> 0x01a9, all -> 0x01a4 }
            goto L_0x01e4
        L_0x01a4:
            r0 = move-exception
            r2 = r0
            r10 = r11
            goto L_0x027f
        L_0x01a9:
            r0 = move-exception
            r10 = r11
            goto L_0x01f3
        L_0x01ac:
            java.util.logging.Level r12 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r13 = "cBuffer went beyond limit 50.....deleting data"
            com.userexperior.utilities.b.a(r12, r13)     // Catch:{ Exception -> 0x01f2 }
            com.userexperior.e.h.b(r11)     // Catch:{ Exception -> 0x01f2 }
            java.io.File r11 = r9.getParentFile()     // Catch:{ Exception -> 0x01f2 }
            if (r11 == 0) goto L_0x01c5
            boolean r12 = r11.exists()     // Catch:{ Exception -> 0x01f2 }
            if (r12 != 0) goto L_0x01c5
            r11.mkdirs()     // Catch:{ Exception -> 0x01f2 }
        L_0x01c5:
            boolean r11 = r9.exists()     // Catch:{ Exception -> 0x01f2 }
            if (r11 != 0) goto L_0x01d6
            r9.createNewFile()     // Catch:{ Exception -> 0x01f2 }
            r7.p = r8     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r8 = r9.getName()     // Catch:{ Exception -> 0x01f2 }
            r7.o = r8     // Catch:{ Exception -> 0x01f2 }
        L_0x01d6:
            java.io.FileWriter r8 = new java.io.FileWriter     // Catch:{ Exception -> 0x01f2 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x01f2 }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x01f2 }
            r11.<init>(r8)     // Catch:{ Exception -> 0x01f2 }
            r11.write(r0)     // Catch:{ Exception -> 0x01a9, all -> 0x01a4 }
            goto L_0x01a0
        L_0x01e4:
            r11.close()     // Catch:{ Exception -> 0x01e8 }
            goto L_0x0216
        L_0x01e8:
            r0 = move-exception
            r8 = r0
        L_0x01ea:
            r8.getMessage()     // Catch:{ Exception -> 0x028c }
            goto L_0x0216
        L_0x01ee:
            r0 = move-exception
            r2 = r0
            goto L_0x027f
        L_0x01f2:
            r0 = move-exception
        L_0x01f3:
            java.util.logging.Level r8 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x01ee }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ee }
            java.lang.String r11 = "Ex : EM - saveCRF : "
            r9.<init>(r11)     // Catch:{ all -> 0x01ee }
            java.lang.String r11 = r0.getMessage()     // Catch:{ all -> 0x01ee }
            r9.append(r11)     // Catch:{ all -> 0x01ee }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01ee }
            com.userexperior.utilities.b.a(r8, r9)     // Catch:{ all -> 0x01ee }
            r0.getMessage()     // Catch:{ all -> 0x01ee }
            if (r10 == 0) goto L_0x0216
            r10.close()     // Catch:{ Exception -> 0x0213 }
            goto L_0x0216
        L_0x0213:
            r0 = move-exception
            r8 = r0
            goto L_0x01ea
        L_0x0216:
            com.userexperior.models.recording.enums.i r0 = com.userexperior.models.recording.enums.i.INITIAL_STATE     // Catch:{ Exception -> 0x028c }
            r7.f4085b = r0     // Catch:{ Exception -> 0x028c }
            android.content.Context r0 = r1.g     // Catch:{ Exception -> 0x028c }
            com.userexperior.utilities.l.a(r0, r7)     // Catch:{ Exception -> 0x028c }
            if (r5 != 0) goto L_0x023c
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = "APP CRASH - \n"
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ Exception -> 0x028c }
            com.userexperior.utilities.b.a(r0, r4)     // Catch:{ Exception -> 0x028c }
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x028c }
            if (r0 == 0) goto L_0x023b
            if (r2 == 0) goto L_0x023b
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x028c }
            r0.uncaughtException(r2, r3)     // Catch:{ Exception -> 0x028c }
        L_0x023b:
            return
        L_0x023c:
            if (r4 == 0) goto L_0x025f
            java.lang.String r0 = "main"
            boolean r0 = r4.equals(r0)     // Catch:{ Exception -> 0x028c }
            if (r0 == 0) goto L_0x025f
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = "Main Thread Crash - \n"
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ Exception -> 0x028c }
            com.userexperior.utilities.b.a(r0, r4)     // Catch:{ Exception -> 0x028c }
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x028c }
            if (r0 == 0) goto L_0x025e
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.v     // Catch:{ Exception -> 0x028c }
            r0.uncaughtException(r2, r3)     // Catch:{ Exception -> 0x028c }
        L_0x025e:
            return
        L_0x025f:
            android.content.Context r0 = r1.g     // Catch:{ Exception -> 0x028c }
            com.userexperior.services.recording.EventSession.b(r0)     // Catch:{ Exception -> 0x028c }
            r19.printStackTrace()     // Catch:{ Exception -> 0x028c }
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x028c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = "SDK CRASH - \n"
            r2.<init>(r4)     // Catch:{ Exception -> 0x028c }
            java.lang.String r4 = r19.getMessage()     // Catch:{ Exception -> 0x028c }
            r2.append(r4)     // Catch:{ Exception -> 0x028c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x028c }
            com.userexperior.utilities.b.a(r0, r2)     // Catch:{ Exception -> 0x028c }
            return
        L_0x027f:
            if (r10 == 0) goto L_0x028a
            r10.close()     // Catch:{ Exception -> 0x0285 }
            goto L_0x028a
        L_0x0285:
            r0 = move-exception
            r4 = r0
            r4.getMessage()     // Catch:{ Exception -> 0x028c }
        L_0x028a:
            throw r2     // Catch:{ Exception -> 0x028c }
        L_0x028b:
            return
        L_0x028c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x02a8 }
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x02a8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r5 = "Ex: EM - issue with UncaughtExceptionHandler "
            r4.<init>(r5)     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x02a8 }
            r4.append(r0)     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x02a8 }
            com.userexperior.utilities.b.a(r2, r0)     // Catch:{ Exception -> 0x02a8 }
            return
        L_0x02a8:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Ex : EM - unEx : "
            r4.<init>(r5)
            java.lang.String r3 = r19.getMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.userexperior.utilities.b.a(r2, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "issue with Uncaught Exception"
            r2.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.f.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
