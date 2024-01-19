package io.hansel.userjourney.models;

import io.hansel.core.json.CoreJSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f5445a;

    /* renamed from: b  reason: collision with root package name */
    public String f5446b;

    /* renamed from: c  reason: collision with root package name */
    public String f5447c;

    /* renamed from: d  reason: collision with root package name */
    public CoreJSONObject f5448d;

    /* renamed from: e  reason: collision with root package name */
    public CoreJSONObject f5449e;

    public c(String str, String str2, String str3, CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        this.f5445a = str2;
        this.f5446b = str3;
        this.f5447c = str;
        this.f5448d = coreJSONObject;
        this.f5449e = coreJSONObject2;
    }

    public CoreJSONObject a() {
        return this.f5448d;
    }

    public String b() {
        return this.f5445a + this.f5446b;
    }

    public String c() {
        return this.f5447c;
    }

    public CoreJSONObject d() {
        return this.f5449e;
    }
}
