package com.shield.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.preference.PreferenceManager;
import com.shield.android.Shield.DeviceResultStateListener;
import com.shield.android.c.m;
import com.shield.android.c.p;
import com.shield.android.d.f;
import com.shield.android.f.d.k;
import com.shield.android.f.d.l;
import com.shield.android.g.a;
import com.shield.android.internal.i;
import com.shield.android.view.CaptchaDialog;
import com.shield.android.view.InternalBlockedDialog;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.jboss.netty.channel.socket.http.HttpTunnelingServlet;
import org.json.JSONObject;

public class ShieldFingerprintUseCase {

    /* renamed from: a  reason: collision with root package name */
    public final ShieldCallback<JSONObject> f1465a;
    public boolean appInBackground = false;

    /* renamed from: b  reason: collision with root package name */
    public final Thread f1466b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1467c = false;
    public DeviceResultStateListener deviceResultStateListener;

    /* renamed from: e  reason: collision with root package name */
    public final com.shield.android.f.b f1468e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1469f;
    public int g = 0;
    public com.shield.android.internal.c h;
    public JSONObject i;
    public ShieldException j;
    public boolean k = true;
    public final Context l;
    public final BlockedDialog m;
    public boolean needBackgroundListener = false;

    public class CaptchaReceiver extends BroadcastReceiver {
        public CaptchaReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("RESULT_OK", false);
            com.shield.android.f.d dVar = (com.shield.android.f.d) ShieldFingerprintUseCase.this.f1468e;
            dVar.b((i) new l(booleanExtra));
            if (!booleanExtra) {
                Intent intent2 = new Intent(context.getApplicationContext(), InternalBlockedDialog.class);
                intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
                context.getApplicationContext().startActivity(intent2);
            }
        }
    }

    public class b implements ShieldCallback<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1471a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1472b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HashMap f1473c;

        public b(ShieldCallback shieldCallback, String str, HashMap hashMap) {
            this.f1471a = shieldCallback;
            this.f1472b = str;
            this.f1473c = hashMap;
        }

        public void onFailure(ShieldException shieldException) {
            ShieldFingerprintUseCase shieldFingerprintUseCase = ShieldFingerprintUseCase.this;
            String str = this.f1472b;
            HashMap hashMap = this.f1473c;
            ShieldCallback shieldCallback = this.f1471a;
            if (shieldFingerprintUseCase.f1467c) {
                shieldCallback.onSuccess(Boolean.TRUE);
                return;
            }
            com.shield.android.f.d dVar = (com.shield.android.f.d) shieldFingerprintUseCase.f1468e;
            dVar.a(new k(new c(shieldCallback), str, hashMap));
        }

        public void onSuccess(Object obj) {
            this.f1471a.onSuccess((Boolean) obj);
        }
    }

    public class c implements ShieldCallback<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1475a;

        public c(ShieldCallback shieldCallback) {
            this.f1475a = shieldCallback;
        }

        public void onFailure(ShieldException shieldException) {
            this.f1475a.onFailure(shieldException);
        }

        public void onSuccess(Object obj) {
            this.f1475a.onSuccess((Boolean) obj);
        }
    }

    public class d implements ShieldCallback<Boolean> {
        public d() {
        }

        public void onFailure(ShieldException shieldException) {
            com.shield.android.f.d dVar = (com.shield.android.f.d) ShieldFingerprintUseCase.this.f1468e;
            dVar.a(new com.shield.android.f.d.b());
        }

        public void onSuccess(Object obj) {
            Boolean bool = (Boolean) obj;
        }
    }

    public class e implements ShieldCallback<Pair<com.shield.android.internal.c, JSONObject>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1477a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f1478b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DeviceResultStateListener f1479c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1480d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f1481e;

        public e(ShieldCallback shieldCallback, boolean z, DeviceResultStateListener deviceResultStateListener, String str, HashMap hashMap) {
            this.f1477a = shieldCallback;
            this.f1478b = z;
            this.f1479c = deviceResultStateListener;
            this.f1480d = str;
            this.f1481e = hashMap;
        }

        public void onFailure(ShieldException shieldException) {
            ShieldFingerprintUseCase.this.deviceSignatureDoOnFailure(shieldException, this.f1480d, this.f1481e, this.f1477a, this.f1478b, this.f1479c, true);
        }

        public void onSuccess(Object obj) {
            ShieldFingerprintUseCase.this.deviceSignatureDoOnSuccess((Pair) obj, this.f1477a, this.f1478b, this.f1479c);
        }
    }

    public class f implements ShieldCallback<Pair<com.shield.android.internal.c, JSONObject>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShieldCallback f1483a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f1484b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DeviceResultStateListener f1485c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1486d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f1487e;

        public f(ShieldCallback shieldCallback, boolean z, DeviceResultStateListener deviceResultStateListener, String str, HashMap hashMap) {
            this.f1483a = shieldCallback;
            this.f1484b = z;
            this.f1485c = deviceResultStateListener;
            this.f1486d = str;
            this.f1487e = hashMap;
        }

        public void onFailure(ShieldException shieldException) {
            ShieldFingerprintUseCase.this.deviceSignatureDoOnFailure(shieldException, this.f1486d, this.f1487e, this.f1483a, this.f1484b, this.f1485c, false);
        }

        public void onSuccess(Object obj) {
            ShieldFingerprintUseCase.this.deviceSignatureDoOnSuccess((Pair) obj, this.f1483a, this.f1484b, this.f1485c);
        }
    }

    public class g implements ShieldCallback<JSONObject> {
        public g() {
        }

        public void onFailure(ShieldException shieldException) {
            if (com.shield.android.internal.f.a().f1677b && shieldException.getMessage() != null) {
                shieldException.getLocalizedMessage();
            }
            ShieldFingerprintUseCase shieldFingerprintUseCase = ShieldFingerprintUseCase.this;
            JSONObject jSONObject = shieldFingerprintUseCase.i;
            if (jSONObject == null) {
                shieldFingerprintUseCase.j = shieldException;
                if (jSONObject == null) {
                    DeviceResultStateListener deviceResultStateListener = shieldFingerprintUseCase.deviceResultStateListener;
                    if (deviceResultStateListener != null) {
                        deviceResultStateListener.isReady();
                    }
                }
            }
        }

        public void onSuccess(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
        }
    }

    public class h implements ShieldCallback<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f1490a;

        public h(boolean z) {
            this.f1490a = z;
        }

        public void onFailure(ShieldException shieldException) {
            ShieldFingerprintUseCase shieldFingerprintUseCase = ShieldFingerprintUseCase.this;
            boolean z = this.f1490a;
            com.shield.android.f.d dVar = (com.shield.android.f.d) shieldFingerprintUseCase.f1468e;
            dVar.a(new com.shield.android.f.d.g(z));
        }

        public void onSuccess(Object obj) {
            Boolean bool = (Boolean) obj;
        }
    }

    public ShieldFingerprintUseCase(Context context, boolean z, ShieldCallback shieldCallback, Thread thread, boolean z2, com.shield.android.f.b bVar, String str) {
        this.needBackgroundListener = z;
        this.f1465a = shieldCallback;
        this.f1466b = thread;
        this.f1467c = z2;
        this.f1468e = bVar;
        this.f1469f = str;
        this.l = context;
        this.m = null;
        ((com.shield.android.f.d) bVar).b((i) new com.shield.android.f.d.c());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        Intent intent = new Intent(this.l.getApplicationContext(), InternalBlockedDialog.class);
        intent.addFlags(335544320);
        this.l.getApplicationContext().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("captcha_broadcast");
        LocalBroadcastManager.getInstance(this.l.getApplicationContext()).registerReceiver(new CaptchaReceiver(), intentFilter);
        Intent a2 = CaptchaDialog.a(this.l.getApplicationContext(), CaptchaType.TEXT_CAPTCHA, false);
        a2.addFlags(335544320);
        this.l.getApplicationContext().startActivity(a2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        Intent intent = new Intent(this.l.getApplicationContext(), InternalBlockedDialog.class);
        intent.addFlags(335544320);
        this.l.getApplicationContext().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("captcha_broadcast");
        LocalBroadcastManager.getInstance(this.l.getApplicationContext()).registerReceiver(new CaptchaReceiver(), intentFilter);
        Intent a2 = CaptchaDialog.a(this.l.getApplicationContext(), CaptchaType.TEXT_CAPTCHA, false);
        a2.addFlags(335544320);
        this.l.getApplicationContext().startActivity(a2);
    }

    public void deviceSignatureDoOnFailure(ShieldException shieldException, String str, HashMap<String, String> hashMap, ShieldCallback<JSONObject> shieldCallback, boolean z, DeviceResultStateListener deviceResultStateListener2, boolean z2) {
        String str2;
        ShieldCallback<JSONObject> shieldCallback2 = shieldCallback;
        ShieldException unexpectedError = shieldException == null ? ShieldException.unexpectedError(new Throwable("unknown error getting device result")) : shieldException;
        if (unexpectedError.code == 301) {
            com.shield.android.internal.f.a().b(unexpectedError.body, new Object[0]);
            if (unexpectedError.body != null) {
                try {
                    JSONObject jSONObject = new JSONObject(unexpectedError.body);
                    if (jSONObject.has(HttpTunnelingServlet.ENDPOINT)) {
                        PreferenceManager.getDefaultSharedPreferences(this.l.getApplicationContext()).edit().putString(z2 ? "fallback_endpoint" : HttpTunnelingServlet.ENDPOINT, jSONObject.optString(HttpTunnelingServlet.ENDPOINT, "")).apply();
                    }
                    if (jSONObject.has("version")) {
                        Editor edit = PreferenceManager.getDefaultSharedPreferences(this.l.getApplicationContext()).edit();
                        if (z2) {
                            str2 = "fallback_version";
                        } else {
                            str2 = "version";
                        }
                        edit.putString(str2, String.valueOf(jSONObject.optInt("version", 0))).apply();
                    }
                } catch (Exception unused) {
                }
            }
            if (this.g < 3) {
                sendDeviceSignature(str, hashMap, shieldCallback, z, deviceResultStateListener2);
                this.g++;
                return;
            }
            if (this.k) {
                shieldCallback.onFailure(unexpectedError);
            }
            JSONObject jSONObject2 = this.i;
            if (jSONObject2 == null) {
                this.j = unexpectedError;
                if (jSONObject2 == null) {
                    DeviceResultStateListener deviceResultStateListener3 = this.deviceResultStateListener;
                    if (deviceResultStateListener3 != null) {
                        deviceResultStateListener3.isReady();
                    }
                }
            }
        } else if (z2) {
            if (this.k) {
                shieldCallback.onFailure(unexpectedError);
            }
            JSONObject jSONObject3 = this.i;
            if (jSONObject3 == null) {
                this.j = unexpectedError;
                if (jSONObject3 == null) {
                    DeviceResultStateListener deviceResultStateListener4 = this.deviceResultStateListener;
                    if (deviceResultStateListener4 != null) {
                        deviceResultStateListener4.isReady();
                    }
                }
            }
        } else {
            HashMap<String, String> hashMap2 = hashMap == null ? new HashMap<>() : hashMap;
            hashMap2.put("fallback_url", String.valueOf(true));
            hashMap2.put("fallback_error", unexpectedError.message);
            internalSendDeviceSignature(str, hashMap2, shieldCallback, z, deviceResultStateListener2, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0084 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deviceSignatureDoOnSuccess(android.util.Pair<com.shield.android.internal.c, org.json.JSONObject> r8, com.shield.android.ShieldCallback<org.json.JSONObject> r9, boolean r10, com.shield.android.Shield.DeviceResultStateListener r11) {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to get device result"
            if (r8 != 0) goto L_0x001b
            java.lang.Throwable r8 = new java.lang.Throwable
            r8.<init>(r0)
            com.shield.android.ShieldException r8 = com.shield.android.ShieldException.unexpectedError(r8)
            r7.j = r8
            org.json.JSONObject r8 = r7.i
            if (r8 != 0) goto L_0x001a
            com.shield.android.Shield$DeviceResultStateListener r8 = r7.deviceResultStateListener
            if (r8 == 0) goto L_0x001a
            r8.isReady()
        L_0x001a:
            return
        L_0x001b:
            java.lang.Object r1 = r8.first
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x005b
            r4 = r1
            com.shield.android.internal.c r4 = (com.shield.android.internal.c) r4     // Catch:{ Exception -> 0x0046 }
            boolean r3 = r4.f1671c     // Catch:{ Exception -> 0x0046 }
            r7.k = r3     // Catch:{ Exception -> 0x0042 }
            r4 = r1
            com.shield.android.internal.c r4 = (com.shield.android.internal.c) r4     // Catch:{ Exception -> 0x0042 }
            boolean r4 = r4.f1669a     // Catch:{ Exception -> 0x0042 }
            r5 = r1
            com.shield.android.internal.c r5 = (com.shield.android.internal.c) r5     // Catch:{ Exception -> 0x003f }
            boolean r2 = r5.f1670b     // Catch:{ Exception -> 0x003f }
            com.shield.android.internal.c r1 = (com.shield.android.internal.c) r1     // Catch:{ Exception -> 0x0039 }
            r6 = r3
            r3 = r2
            r2 = r4
            r4 = r6
            goto L_0x005d
        L_0x0039:
            r1 = move-exception
            r6 = r3
            r3 = r2
            r2 = r4
            r4 = r6
            goto L_0x0049
        L_0x003f:
            r1 = move-exception
            r2 = r4
            goto L_0x0043
        L_0x0042:
            r1 = move-exception
        L_0x0043:
            r4 = r3
            r3 = 0
            goto L_0x0049
        L_0x0046:
            r1 = move-exception
            r3 = 0
            r4 = 1
        L_0x0049:
            com.shield.android.internal.f r5 = com.shield.android.internal.f.a()
            boolean r5 = r5.f1677b
            if (r5 == 0) goto L_0x005d
            java.lang.String r5 = r1.getMessage()
            if (r5 == 0) goto L_0x005d
            r1.getLocalizedMessage()
            goto L_0x005d
        L_0x005b:
            r3 = 0
            r4 = 1
        L_0x005d:
            java.lang.Object r1 = r8.second
            if (r1 == 0) goto L_0x0072
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            java.lang.Object r10 = r8.first
            com.shield.android.internal.c r10 = (com.shield.android.internal.c) r10
            r7.setLatestDeviceResult(r1, r10)
            if (r4 == 0) goto L_0x0082
            java.lang.Object r8 = r8.second
            r9.onSuccess(r8)
            goto L_0x0082
        L_0x0072:
            if (r4 == 0) goto L_0x0082
            if (r10 != 0) goto L_0x0082
            java.lang.Throwable r8 = new java.lang.Throwable
            r8.<init>(r0)
            com.shield.android.ShieldException r8 = com.shield.android.ShieldException.unexpectedError(r8)
            r9.onFailure(r8)
        L_0x0082:
            if (r2 == 0) goto L_0x009d
            if (r4 == 0) goto L_0x009d
            boolean r8 = r7.appInBackground
            if (r8 == 0) goto L_0x008b
            return
        L_0x008b:
            android.os.Handler r8 = new android.os.Handler
            android.os.Looper r9 = android.os.Looper.getMainLooper()
            r8.<init>(r9)
            com.shield.android.-$$Lambda$ShieldFingerprintUseCase$O_L2Ln71LUpYHcCSSUNwrsqjBDI r9 = new com.shield.android.-$$Lambda$ShieldFingerprintUseCase$O_L2Ln71LUpYHcCSSUNwrsqjBDI
            r9.<init>()
            r8.post(r9)
            goto L_0x00b7
        L_0x009d:
            if (r3 == 0) goto L_0x00b7
            if (r4 == 0) goto L_0x00b7
            boolean r8 = r7.appInBackground
            if (r8 == 0) goto L_0x00a6
            return
        L_0x00a6:
            android.os.Handler r8 = new android.os.Handler
            android.os.Looper r9 = android.os.Looper.getMainLooper()
            r8.<init>(r9)
            com.shield.android.-$$Lambda$ShieldFingerprintUseCase$GaMwYet1CaY6v3-7KFCU1m9yXV0 r9 = new com.shield.android.-$$Lambda$ShieldFingerprintUseCase$GaMwYet1CaY6v3-7KFCU1m9yXV0
            r9.<init>()
            r8.post(r9)
        L_0x00b7:
            org.json.JSONObject r8 = r7.i
            if (r8 != 0) goto L_0x00d1
            java.lang.Throwable r8 = new java.lang.Throwable
            r8.<init>(r0)
            com.shield.android.ShieldException r8 = com.shield.android.ShieldException.unexpectedError(r8)
            r7.j = r8
            org.json.JSONObject r8 = r7.i
            if (r8 != 0) goto L_0x00d1
            com.shield.android.Shield$DeviceResultStateListener r8 = r7.deviceResultStateListener
            if (r8 == 0) goto L_0x00d1
            r8.isReady()
        L_0x00d1:
            if (r11 == 0) goto L_0x00d6
            r11.isReady()
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.ShieldFingerprintUseCase.deviceSignatureDoOnSuccess(android.util.Pair, com.shield.android.ShieldCallback, boolean, com.shield.android.Shield$DeviceResultStateListener):void");
    }

    public void internalSendDeviceSignature(String str, HashMap<String, String> hashMap, ShieldCallback<JSONObject> shieldCallback, boolean z, DeviceResultStateListener deviceResultStateListener2, boolean z2) {
        if (z2) {
            com.shield.android.f.b bVar = this.f1468e;
            e eVar = new e(shieldCallback, z, deviceResultStateListener2, str, hashMap);
            com.shield.android.f.d dVar = (com.shield.android.f.d) bVar;
            dVar.a(new com.shield.android.f.d.i(eVar, str, hashMap));
            return;
        }
        com.shield.android.f.b bVar2 = this.f1468e;
        f fVar = new f(shieldCallback, z, deviceResultStateListener2, str, hashMap);
        com.shield.android.f.d dVar2 = (com.shield.android.f.d) bVar2;
        dVar2.b((i) new com.shield.android.f.d.h(fVar, str, hashMap));
    }

    public void sendDeviceSignature(String str, HashMap<String, String> hashMap, ShieldCallback<JSONObject> shieldCallback, boolean z, DeviceResultStateListener deviceResultStateListener2) {
        if (!this.f1467c) {
            internalSendDeviceSignature(str, hashMap, shieldCallback, z, deviceResultStateListener2, false);
        } else {
            try {
                throw null;
            } catch (Exception unused) {
            }
        }
    }

    public void setLatestDeviceResult(JSONObject jSONObject, com.shield.android.internal.c cVar) {
        this.j = null;
        boolean z = this.i == null;
        this.i = jSONObject;
        DeviceResultStateListener deviceResultStateListener2 = this.deviceResultStateListener;
        if (deviceResultStateListener2 != null && z) {
            deviceResultStateListener2.isReady();
        }
        if (cVar != null) {
            this.h = cVar;
        }
    }

    public void startFridaListener(com.shield.android.d.f fVar) {
        m mVar = ((com.shield.android.f.d) this.f1468e).p().f1550e;
        if (mVar != null) {
            a aVar = mVar.f1535d;
            if (aVar.f1665f || aVar.g || aVar.h || aVar.j || aVar.k || aVar.m || aVar.l) {
                if (mVar.f1533b == null) {
                    mVar.f1533b = new ScheduledThreadPoolExecutor(1);
                }
                mVar.f1533b.scheduleWithFixedDelay(new Runnable(fVar) {
                    public final /* synthetic */ f f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        m.this.a(this.f$1);
                    }
                }, 7000, 7000, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(HashMap hashMap, p pVar, String str, DeviceResultStateListener deviceResultStateListener2, Location location) {
        if (location != null) {
            try {
                Locale locale = Locale.ENGLISH;
                hashMap.put("LATLNG", String.format(locale, "%.6f,%.6f", new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}));
                pVar.d();
            } catch (Exception unused) {
            }
        }
        sendDeviceSignature(str, hashMap, deviceResultStateListener2);
    }

    public void sendDeviceSignature(String str, HashMap<String, String> hashMap, DeviceResultStateListener deviceResultStateListener2) {
        if (this.f1465a == null) {
            sendDeviceSignature(str, hashMap, new g(), false, deviceResultStateListener2);
        } else if (this.f1466b != null) {
            new Thread(new Runnable(str, hashMap, deviceResultStateListener2) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ HashMap f$2;
                public final /* synthetic */ DeviceResultStateListener f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    ShieldFingerprintUseCase.this.a(this.f$1, this.f$2, this.f$3);
                }
            }, this.f1466b.getName()).start();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(str, hashMap, deviceResultStateListener2) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ HashMap f$2;
                public final /* synthetic */ DeviceResultStateListener f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    ShieldFingerprintUseCase.this.b(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, HashMap hashMap, DeviceResultStateListener deviceResultStateListener2) {
        sendDeviceSignature(str, hashMap, this.f1465a, true, deviceResultStateListener2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str, HashMap hashMap, DeviceResultStateListener deviceResultStateListener2) {
        sendDeviceSignature(str, hashMap, this.f1465a, true, deviceResultStateListener2);
    }
}
