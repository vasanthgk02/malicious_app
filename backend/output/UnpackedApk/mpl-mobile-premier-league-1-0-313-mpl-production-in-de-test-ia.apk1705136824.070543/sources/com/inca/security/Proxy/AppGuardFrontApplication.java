package com.inca.security.Proxy;

import android.app.Application;
import android.content.Context;
import com.inca.security.DexProtect.Binder;
import java.lang.reflect.Method;
import org.apache.fontbox.ttf.GlyfDescript;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

/* compiled from: vb */
public class AppGuardFrontApplication extends Application {
    public static final /* synthetic */ int IIiIIIIiii = 22;
    public static final /* synthetic */ int IiIiIIiIii = 11;
    public static final /* synthetic */ int IiiIIiiiii = 24;
    public static final /* synthetic */ int iIIIiiIIIi = 17;
    public static final /* synthetic */ int iIiIIIiIii = 23;
    public static final /* synthetic */ int iIiiIIiiIi = 15;
    public static final /* synthetic */ int iiIiIIIIii = 13;
    public static final /* synthetic */ int iiIiIiIiiI = 5;
    public static final /* synthetic */ int iiiiiIIiiI = 16;
    public static final /* synthetic */ int iiiiiiiIii = 12;
    private /* synthetic */ byte[] IIIIIIiIII = {69, 25, 64, 5, 75, 30, 64, 89, 87, 2, 84, 7, 75, 5, 80, 89, 73, 2, 72, 3, 77, 19, 65, 15, 10, HttpCodecUtil.COLON, 81, 27, 80, 30, 96, 18, 92};
    private /* synthetic */ Application IIiIIIIiIi = null;
    private /* synthetic */ byte[] IiIIiiIIii = {54, 84, 7, 99, 2, 69, 5, 64, 62, 87, 24, 72, 22, 80, 18, 64};
    private /* synthetic */ Context IiIiIIIIIi = null;
    private /* synthetic */ byte[] IiIiiIIiII = {73, 56, 81, 3, 65, 5, 103, 24, 74, 3, 65, 15, 80};
    private /* synthetic */ byte[] IiIiiiIIII = {26, 101, 7, 84, 27, 77, 20, 69, 3, 77, 24, 74};
    private /* synthetic */ boolean IiIiiiIiII = false;
    private /* synthetic */ byte[] IiiiIIIIIi = {77, 25, 87, 3, 69, 27, 72};
    private /* synthetic */ byte[] iIIiIIiiII = {26, 101, 27, 72, 54, 84, 7, 72, 30, 71, 22, 80, 30, 75, 25, 87};
    private /* synthetic */ byte[] iIIiIiiiiI = {73, 62, 74, 30, 80, 30, 69, 27, 101, 7, 84, 27, 77, 20, 69, 3, 77, 24, 74};
    private /* synthetic */ byte[] iiIIIiIIII = {26, 116, 22, 71, 28, 69, GlyfDescript.X_DUAL, 65, 62, 74, 17, 75};
    private /* synthetic */ byte[] iiIIIiiIiI = {20, 75, 26, 10, 30, 74, 20, 69, 89, 87, 18, 71, 2, 86, 30, 80, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 10, 39, 86, 24, 92, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 10, 54, 84, 7, 99, 2, 69, 5, 64, 39, 86, 24, 92, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 101, 7, 84, 27, 77, 20, 69, 3, 77, 24, 74};
    private /* synthetic */ byte[] iiiIIIIiiI = {22, 80, 3, 69, 20, 76};
    private /* synthetic */ byte[] iiiiIiiiii = {73, 54, 71, 3, 77, 1, 77, 3, 93, 35, 76, 5, 65, 22, 64};

    /* access modifiers changed from: private */
    public static native /* synthetic */ String IiIiIiiIII(int i);

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x008f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private /* synthetic */ void iIiiIiiiIi(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.inca.security.Core.ObjectReflector r0 = new com.inca.security.Core.ObjectReflector     // Catch:{ Exception -> 0x008f }
            android.content.Context r1 = r4.IiIiIIIIIi     // Catch:{ Exception -> 0x008f }
            r2 = 16
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = r4.iIiiIiiiIi(r2, r3)     // Catch:{ Exception -> 0x008f }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x008f }
            android.app.Application r1 = r4.IIiIIIIiIi     // Catch:{ Exception -> 0x008f }
            r0.set(r1)     // Catch:{ Exception -> 0x008f }
            com.inca.security.Core.ObjectReflector r0 = new com.inca.security.Core.ObjectReflector     // Catch:{ Exception -> 0x008f }
            android.content.Context r1 = r4.IiIiIIIIIi     // Catch:{ Exception -> 0x008f }
            r2 = 5
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = r4.iIiiIiiiIi(r2, r3)     // Catch:{ Exception -> 0x008f }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x008f }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x008f }
            com.inca.security.Core.ObjectReflector r1 = new com.inca.security.Core.ObjectReflector     // Catch:{ Exception -> 0x008f }
            r2 = 11
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = r4.iIiiIiiiIi(r2, r3)     // Catch:{ Exception -> 0x008f }
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x008f }
            android.app.Application r2 = r4.IIiIIIIiIi     // Catch:{ Exception -> 0x008f }
            r1.set(r2)     // Catch:{ Exception -> 0x008f }
            com.inca.security.Core.ObjectReflector r1 = new com.inca.security.Core.ObjectReflector     // Catch:{ Exception -> 0x008f }
            r2 = 12
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = r4.iIiiIiiiIi(r2, r3)     // Catch:{ Exception -> 0x008f }
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x008f }
            java.lang.Object r0 = r1.get()     // Catch:{ Exception -> 0x008f }
            com.inca.security.Core.ObjectReflector r1 = new com.inca.security.Core.ObjectReflector     // Catch:{ Exception -> 0x008f }
            r2 = 15
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = r4.iIiiIiiiIi(r2, r3)     // Catch:{ Exception -> 0x008f }
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x008f }
            android.app.Application r2 = r4.IIiIIIIiIi     // Catch:{ Exception -> 0x008f }
            r1.set(r2)     // Catch:{ Exception -> 0x008f }
            if (r5 == 0) goto L_0x008f
            boolean r1 = r4.IiIiiiIiII     // Catch:{ Exception -> 0x008f }
            if (r1 != 0) goto L_0x008f
            com.inca.security.Core.ObjectReflector r1 = new com.inca.security.Core.ObjectReflector     // Catch:{ Exception -> 0x008f }
            r2 = 13
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = r4.iIiiIiiiIi(r2, r5)     // Catch:{ Exception -> 0x008f }
            r1.<init>(r0, r5)     // Catch:{ Exception -> 0x008f }
            java.lang.Object r5 = r1.get()     // Catch:{ Exception -> 0x008f }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ Exception -> 0x008f }
            r0 = 1
            r4.IiIiiiIiII = r0     // Catch:{ Exception -> 0x008f }
            r5.remove(r4)     // Catch:{ Exception -> 0x008f }
            android.app.Application r0 = r4.IIiIIIIiIi     // Catch:{ Exception -> 0x008f }
            r5.add(r0)     // Catch:{ Exception -> 0x008f }
            goto L_0x008f
        L_0x008d:
            r5 = move-exception
            goto L_0x0091
        L_0x008f:
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            return
        L_0x0091:
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inca.security.Proxy.AppGuardFrontApplication.iIiiIiiiIi(boolean):void");
    }

    public void onCreate() {
        super.onCreate();
        if (!iIiiIiiiIi() || (iIiiIiiiIi() && iiiIIiIIIi())) {
            iiiIIiIIIi();
        } else {
            iIiiIiiiIi();
        }
    }

    static {
        try {
            if (Binder.getABI() == 0) {
                System.loadLibrary("compatible");
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private /* synthetic */ String iIiiIiiiIi(int i, Boolean bool) throws Exception {
        byte[] bArr;
        if (bool.booleanValue()) {
            return IiIiIiiIII(i);
        }
        byte[] bArr2 = null;
        if (i == 5) {
            bArr = this.iiIIIiIIII;
        } else if (i == 15) {
            bArr = this.iIIiIiiiiI;
        } else if (i == 16) {
            bArr = this.IiIiiIIiII;
        } else if (i != 23) {
            if (i != 24) {
                switch (i) {
                    case 11:
                        bArr = this.IiIiiiIIII;
                        break;
                    case 12:
                        bArr = this.iiiiIiiiii;
                        break;
                    case 13:
                        bArr = this.iIIiIIiiII;
                        break;
                }
            } else {
                bArr2 = this.IiiiIIIIIi;
            }
            bArr = bArr2;
        } else {
            bArr = this.IIIIIIiIII;
        }
        return iIiiIiiiIi(new String(bArr, "UTF-8"));
    }

    public String getPackageName() {
        if (iIiiIiiiIi() && (!iIiiIiiiIi() || !iiiIIiIIIi())) {
            return super.getPackageName();
        }
        if (!this.IiIiiiIiII) {
            iIiiIiiiIi(true);
        }
        return "";
    }

    private /* synthetic */ void iiiiIIIIii() {
        try {
            this.IIiIIIIiIi = (Application) Class.forName(iIiiIiiiIi(new String(this.iiIIIiiIiI, "UTF-8"))).newInstance();
            iIiiIiiiIi(false);
            Method declaredMethod = Application.class.getDeclaredMethod(iIiiIiiiIi(new String(this.iiiIIIIiiI, "UTF-8")), new Class[]{Context.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.IIiIIIIiIi, new Object[]{this.IiIiIIIIIi});
        } catch (Exception unused) {
        }
    }

    public void attachBaseContext(Context context) {
        try {
            Class.forName(iIiiIiiiIi(23, Boolean.valueOf(false))).getDeclaredMethod(iIiiIiiiIi(24, Boolean.valueOf(false)), new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Exception unused) {
        }
        super.attachBaseContext(context);
        this.IiIiIIIIIi = context;
        if (!iIiiIiiiIi() || (iIiiIiiiIi() && iiiIIiIIIi())) {
            iiiiIIIIii();
        }
    }

    private /* synthetic */ String iIiiIiiiIi(String str) {
        int length = str.length();
        int i = length - 1;
        char[] cArr = new char[length];
        while (i >= 0) {
            int i2 = i - 1;
            cArr[i] = (char) (str.charAt(i) ^ '$');
            if (i2 < 0) {
                break;
            }
            i = i2 - 1;
            cArr[i2] = (char) (str.charAt(i2) ^ 'w');
        }
        return new String(cArr);
    }
}
