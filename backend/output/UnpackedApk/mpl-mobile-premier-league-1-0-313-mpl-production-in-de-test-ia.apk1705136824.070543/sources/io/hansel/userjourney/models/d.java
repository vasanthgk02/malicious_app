package io.hansel.userjourney.models;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.userjourney.r.f;
import java.util.HashSet;
import java.util.Set;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f5450a;

    /* renamed from: b  reason: collision with root package name */
    public f f5451b;

    /* renamed from: c  reason: collision with root package name */
    public String f5452c;

    /* renamed from: d  reason: collision with root package name */
    public String f5453d;

    /* renamed from: e  reason: collision with root package name */
    public Set<c> f5454e;

    public d(String str, String str2, f fVar, CoreJSONArray coreJSONArray, String str3) {
        this.f5450a = str;
        this.f5452c = str2;
        this.f5453d = str3;
        this.f5451b = fVar;
        HashSet hashSet = new HashSet();
        int length = coreJSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(a(coreJSONArray.optJSONObject(i)));
        }
        this.f5454e = hashSet;
    }

    private c a(CoreJSONObject coreJSONObject) {
        c cVar = new c(coreJSONObject.optString("id"), coreJSONObject.optString("nm"), coreJSONObject.optString("ven"), coreJSONObject.optJSONObject(HSLCriteriaBuilder.CRITERIA), coreJSONObject.optJSONObject("type"));
        return cVar;
    }

    public Set<String> a() {
        HashSet hashSet = new HashSet();
        Set<c> set = this.f5454e;
        if (set != null) {
            for (c c2 : set) {
                hashSet.add(c2.c());
            }
        }
        return hashSet;
    }

    public Set<c> b() {
        return this.f5454e;
    }

    public String c() {
        return this.f5452c;
    }

    public String d() {
        return this.f5450a;
    }

    public String e() {
        return this.f5453d;
    }

    public f f() {
        return this.f5451b;
    }
}
