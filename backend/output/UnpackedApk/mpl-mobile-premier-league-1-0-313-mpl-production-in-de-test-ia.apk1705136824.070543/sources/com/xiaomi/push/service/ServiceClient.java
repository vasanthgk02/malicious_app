package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.bb;
import com.xiaomi.push.cg;
import com.xiaomi.push.ch;
import com.xiaomi.push.ci;
import com.xiaomi.push.cl;
import com.xiaomi.push.cu;
import com.xiaomi.push.j;
import com.xiaomi.push.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.NameValuePair;

public class ServiceClient {

    /* renamed from: a  reason: collision with root package name */
    public static long f4807a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static ServiceClient f779a;

    /* renamed from: a  reason: collision with other field name */
    public static String f780a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4808b = (cu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a  reason: collision with other field name */
    public Context f781a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f782a = null;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f783a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public boolean f784a = false;

    /* renamed from: b  reason: collision with other field name */
    public Messenger f785b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f786b = false;

    public ServiceClient(Context context) {
        this.f781a = context.getApplicationContext();
        if (a()) {
            b.c("use miui push service");
            this.f784a = true;
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", a());
            intent.putExtra(bd.C, this.f781a.getPackageName());
            a();
            return intent;
        }
        Intent intent2 = new Intent(this.f781a, XMPushService.class);
        intent2.putExtra(bd.C, this.f781a.getPackageName());
        b();
        return intent2;
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m751a() {
        try {
            if (this.f781a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Entry next : map.entrySet()) {
            sb.append((String) next.getKey());
            sb.append(":");
            sb.append((String) next.getValue());
            if (i < map.size()) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair next : list) {
                if (next != null) {
                    hashMap.put(next.getName(), next.getValue());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m752a() {
        this.f781a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f781a, XMPushService.class), 2, 1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m753a(Intent intent) {
        if (this.f786b) {
            Message a2 = a(intent);
            if (this.f783a.size() >= 50) {
                this.f783a.remove(0);
            }
            this.f783a.add(a2);
            return;
        } else if (this.f785b == null) {
            this.f781a.bindService(intent, new bm(this), 1);
            this.f786b = true;
            this.f783a.clear();
            this.f783a.add(a(intent));
        } else {
            try {
                this.f785b.send(a(intent));
            } catch (RemoteException unused) {
                this.f785b = null;
                this.f786b = false;
            }
        }
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(bd.r, str);
        intent.putExtra(bd.u, str2);
        intent.putExtra(bd.w, str3);
        intent.putExtra(bd.y, str5);
        intent.putExtra(bd.x, str4);
        intent.putExtra(bd.z, z);
        intent.putExtra(bd.G, f780a);
        intent.putExtra(bd.K, this.f782a);
        if (map != null && map.size() > 0) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(bd.A, a2);
            }
        }
        if (map2 != null && map2.size() > 0) {
            String a3 = a(map2);
            if (!TextUtils.isEmpty(a3)) {
                intent.putExtra(bd.B, a3);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m754a() {
        if (j.f4793e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f781a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b() {
        this.f781a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f781a, XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f779a == null) {
            f779a = new ServiceClient(context);
        }
        return f779a;
    }

    public static String getSession() {
        return f780a;
    }

    public static void setSession(String str) {
        f780a = str;
    }

    public boolean batchSendMessage(ci[] ciVarArr, boolean z) {
        if (!y.a(this.f781a)) {
            return false;
        }
        Intent a2 = a();
        int length = ciVarArr.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < ciVarArr.length; i++) {
            String a3 = bb.a();
            if (!TextUtils.isEmpty(a3)) {
                cg cgVar = new cg("pf", null, null, null);
                cg cgVar2 = new cg("sent", null, null, null);
                cgVar2.a(a3);
                cgVar.a(cgVar2);
                ciVarArr[i].a(cgVar);
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SEND:");
            outline73.append(ciVarArr[i].a());
            b.c(outline73.toString());
            bundleArr[i] = ciVarArr[i].a();
        }
        if (length <= 0) {
            return false;
        }
        a2.setAction(bd.g);
        a2.putExtra(bd.G, f780a);
        a2.putExtra("ext_packets", bundleArr);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public void checkAlive() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a2);
    }

    public boolean closeChannel() {
        Intent a2 = a();
        a2.setAction(bd.i);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str) {
        Intent a2 = a();
        a2.setAction(bd.i);
        a2.putExtra(bd.u, str);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str, String str2) {
        Intent a2 = a();
        a2.setAction(bd.i);
        a2.putExtra(bd.u, str);
        a2.putExtra(bd.r, str2);
        return startServiceSafely(a2);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bd.j);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a2);
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f784a;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a2 = a();
        a2.setAction(bd.f4901d);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
        return 0;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bd.k);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
    }

    public boolean sendIQ(ch chVar) {
        if (!y.a(this.f781a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = chVar.a();
        if (a3 == null) {
            return false;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SEND:");
        outline73.append(chVar.a());
        b.c(outline73.toString());
        a2.setAction(bd.f4903f);
        a2.putExtra(bd.G, f780a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(ci ciVar, boolean z) {
        if (!y.a(this.f781a)) {
            return false;
        }
        Intent a2 = a();
        String a3 = bb.a();
        if (!TextUtils.isEmpty(a3)) {
            cg cgVar = new cg("pf", null, null, null);
            cg cgVar2 = new cg("sent", null, null, null);
            cgVar2.a(a3);
            cgVar.a(cgVar2);
            ciVar.a(cgVar);
        }
        Bundle a4 = ciVar.a();
        if (a4 == null) {
            return false;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SEND:");
        outline73.append(ciVar.a());
        b.c(outline73.toString());
        a2.setAction(bd.f4902e);
        a2.putExtra(bd.G, f780a);
        a2.putExtra("ext_packet", a4);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (!y.a(this.f781a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.a((String) "Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent a2 = a();
        a2.setAction(bd.f4902e);
        a2.putExtra(bd.G, f780a);
        a2.putExtra("ext_raw_packet", bArr);
        int indexOf = str.indexOf(ColorPropConverter.PREFIX_RESOURCE);
        String str4 = null;
        String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            str4 = str.substring(indexOf + 1, lastIndexOf);
            str3 = str.substring(lastIndexOf + 1);
        } else {
            str3 = null;
        }
        a2.putExtra(bd.r, substring);
        a2.putExtra(bd.s, str4);
        a2.putExtra(bd.t, str3);
        StringBuilder sb = new StringBuilder();
        sb.append(f4808b);
        long j = f4807a;
        f4807a = 1 + j;
        sb.append(j);
        a2.putExtra("ext_pkt_id", sb.toString());
        a2.putExtra("ext_chid", str2);
        b.e("SEND: chid=" + str2 + ", packetId=" + r6);
        return startServiceSafely(a2);
    }

    public boolean sendPresence(cl clVar) {
        if (!y.a(this.f781a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = clVar.a();
        if (a3 == null) {
            return false;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SEND:");
        outline73.append(clVar.a());
        b.c(outline73.toString());
        a2.setAction(bd.h);
        a2.putExtra(bd.G, f780a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    public void setMessenger(Messenger messenger) {
        this.f782a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (f.a() || VERSION.SDK_INT < 26) {
                this.f781a.startService(intent);
            } else {
                a(intent);
            }
            return true;
        } catch (Exception e2) {
            b.a((Throwable) e2);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bd.l);
        if (map != null) {
            String a3 = a(map);
            if (!TextUtils.isEmpty(a3)) {
                a2.putExtra(bd.A, a3);
            }
        }
        if (map2 != null) {
            String a4 = a(map2);
            if (!TextUtils.isEmpty(a4)) {
                a2.putExtra(bd.B, a4);
            }
        }
        a2.putExtra(bd.u, str);
        startServiceSafely(a2);
    }
}
