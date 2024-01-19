package io.hansel.ujmtracker.m;

import android.content.Context;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.ujmtracker.n.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import sfs2x.client.requests.LoginRequest;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f5390a;

    /* renamed from: b  reason: collision with root package name */
    public String f5391b;

    /* renamed from: c  reason: collision with root package name */
    public String f5392c;

    /* renamed from: d  reason: collision with root package name */
    public i f5393d;

    /* renamed from: e  reason: collision with root package name */
    public int f5394e;

    /* renamed from: f  reason: collision with root package name */
    public int f5395f;
    public Context g;

    public h(Context context, String str, String str2, i iVar) {
        this(str, str2, iVar);
        this.g = context;
    }

    public h(String str, String str2, i iVar) {
        a(str, str2, iVar);
    }

    private CoreJSONArray a(ArrayList<d> arrayList) {
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        try {
            Enumeration<T> enumeration = Collections.enumeration(arrayList);
            HashMap hashMap = new HashMap();
            String str = "";
            while (enumeration.hasMoreElements()) {
                CoreJSONObject coreJSONObject = (CoreJSONObject) ((d) enumeration.nextElement()).b();
                String optString = coreJSONObject.optString("ui");
                String optString2 = coreJSONObject.optString(LoginRequest.KEY_PRIVILEGE_ID);
                coreJSONObject.remove("ui");
                coreJSONObject.remove(LoginRequest.KEY_PRIVILEGE_ID);
                String next = coreJSONObject.keys().next();
                CoreJSONObject coreJSONObject2 = (CoreJSONObject) hashMap.get(optString);
                if (coreJSONObject2 == null) {
                    coreJSONObject2 = new CoreJSONObject();
                }
                CoreJSONArray optJSONArray = coreJSONObject2.optJSONArray(next);
                if (optJSONArray == null) {
                    optJSONArray = new CoreJSONArray();
                }
                optJSONArray.put((Object) coreJSONObject.getJSONObject(next));
                coreJSONObject2.put(next, (Object) optJSONArray);
                hashMap.put(optString, coreJSONObject2);
                str = optString2;
            }
            ArrayList arrayList2 = new ArrayList(hashMap.keySet());
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                String str2 = (String) arrayList2.get(i);
                CoreJSONObject coreJSONObject3 = (CoreJSONObject) hashMap.get(str2);
                CoreJSONObject coreJSONObject4 = new CoreJSONObject(coreJSONObject3 == null ? "" : coreJSONObject3.toString());
                CoreJSONObject coreJSONObject5 = new CoreJSONObject();
                coreJSONObject5.put((String) "td", (Object) coreJSONObject4);
                coreJSONArray.put((Object) new a(str, str2, coreJSONObject5));
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return coreJSONArray;
    }

    private void a(String str, String str2, i iVar) {
        this.f5391b = str;
        this.f5392c = str2;
        this.f5393d = iVar;
        if (iVar == null) {
            this.f5393d = new i();
        }
        this.f5390a = 1073741823;
        this.f5394e = 100;
        this.f5395f = 5;
    }

    public int a() {
        return this.f5395f;
    }

    public Object a(byte[] bArr) {
        String str = new String(bArr, WebViewGamesContainer.ENCODING_NAME);
        char charAt = str.charAt(0);
        String substring = str.substring(1);
        return charAt == 'O' ? new CoreJSONObject(substring) : charAt == 'A' ? new CoreJSONArray(substring) : substring;
    }

    public ArrayList<d> a(ArrayList<d> arrayList, boolean z) {
        int i = 0;
        if (z) {
            ArrayList<d> arrayList2 = new ArrayList<>();
            int size = arrayList == null ? 0 : arrayList.size();
            while (i < size) {
                arrayList2.add(arrayList.get(i));
                i++;
            }
            return arrayList2;
        }
        ArrayList<d> arrayList3 = new ArrayList<>();
        int i2 = 10;
        long j = (long) 10;
        long currentTimeMillis = ((System.currentTimeMillis() / 1000) / j) * j * 1000;
        int size2 = arrayList == null ? 0 : arrayList.size();
        while (i < size2) {
            d dVar = arrayList.get(i);
            if (dVar.f() <= currentTimeMillis) {
                arrayList3.add(dVar);
            }
            i++;
        }
        int intFromSharedPreferences = HSLInternalUtils.getIntFromSharedPreferences(this.g, "ha_time");
        if (intFromSharedPreferences > 0) {
            i2 = intFromSharedPreferences;
        }
        long j2 = (long) i2;
        e().a((((j2 * 1000) + ((((System.currentTimeMillis() / 1000) / j2) * j2) * 1000)) - System.currentTimeMillis()) / 1000);
        return arrayList3;
    }

    public void a(String str) {
        this.f5392c = str;
    }

    public void a(ArrayList<d> arrayList, k kVar, j jVar) {
        l lVar = new l(a.c().a(), a.c().e(), f(), a(arrayList), new m(kVar, jVar));
        a.c().a((HSLServerRequest) lVar);
    }

    public boolean a(d dVar) {
        return true;
    }

    public byte[] a(Object obj) {
        if (obj != null) {
            char c2 = ' ';
            String str = null;
            if (obj instanceof String) {
                str = (String) obj;
                c2 = 'S';
            } else if (obj instanceof CoreJSONObject) {
                str = obj.toString();
                c2 = 'O';
            } else if (obj instanceof CoreJSONArray) {
                str = obj.toString();
                c2 = 'A';
            }
            if (str != null) {
                return (c2 + str).getBytes(WebViewGamesContainer.ENCODING_NAME);
            }
            throw new Exception("JSONDataHandler couldn'd serialize the data");
        }
        throw new Exception("Data can't be null");
    }

    public d b(d dVar) {
        throw null;
    }

    public String b() {
        return this.f5391b;
    }

    public int c() {
        return this.f5394e;
    }

    public int d() {
        return this.f5390a;
    }

    public i e() {
        return this.f5393d;
    }

    public String f() {
        return this.f5392c;
    }
}
