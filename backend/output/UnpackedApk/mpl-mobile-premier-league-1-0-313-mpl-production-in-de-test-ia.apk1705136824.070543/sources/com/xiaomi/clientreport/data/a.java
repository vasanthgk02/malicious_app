package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.push.ae;
import org.json.JSONObject;

public class a {
    public String clientInterfaceId;
    public String miuiVersion = f.a();
    public String os = ae.a();
    public String pkgName;
    public int production;
    public int reportType;
    public String sdkVersion;

    public String getPackageName() {
        return this.pkgName;
    }

    public void setAppPackageName(String str) {
        this.pkgName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public JSONObject toJson() {
        return new JSONObject();
    }

    public String toJsonString() {
        return null;
    }
}
