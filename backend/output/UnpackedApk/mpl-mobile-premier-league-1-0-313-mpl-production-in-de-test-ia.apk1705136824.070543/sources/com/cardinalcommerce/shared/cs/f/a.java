package com.cardinalcommerce.shared.cs.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.cardinalcommerce.shared.cs.utils.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2111a;

    /* renamed from: b  reason: collision with root package name */
    public int f2112b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f2113c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f2114d;

    /* renamed from: e  reason: collision with root package name */
    public int f2115e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f2116f;

    public a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
        for (int i = 0; i < installedApplications.size(); i++) {
            this.f2113c.add(installedApplications.get(i).packageName);
        }
        installedApplications.clear();
        this.f2112b = this.f2113c.size();
        this.f2111a = packageManager.isSafeMode();
        this.f2116f = h.a(packageManager.getInstallerPackageName(context.getPackageName()));
        this.f2114d = Arrays.asList(packageManager.getSystemAvailableFeatures()).size();
        this.f2115e = Arrays.asList(packageManager.getSystemSharedLibraryNames()).size();
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ApplicationCount", Integer.valueOf(this.f2112b));
            jSONObject.putOpt("IsSafeMode", Boolean.valueOf(this.f2111a));
            jSONObject.putOpt("ApplicationList", new JSONArray(this.f2113c));
            jSONObject.putOpt("SystemAvailableFeatures", Integer.valueOf(this.f2114d));
            jSONObject.putOpt("SystemSharedLibraryNames", Integer.valueOf(this.f2115e));
            jSONObject.putOpt("InstallerPackageName", h.b(this.f2116f));
        } catch (JSONException e2) {
            com.cardinalcommerce.shared.cs.utils.a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
