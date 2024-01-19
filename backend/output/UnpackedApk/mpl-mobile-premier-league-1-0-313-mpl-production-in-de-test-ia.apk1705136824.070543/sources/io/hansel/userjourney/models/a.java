package io.hansel.userjourney.models;

import android.content.Context;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.userjourney.g;
import io.hansel.userjourney.r.c;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f5437a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f5438b;

    public a(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        this.f5437a = coreJSONObject.optString("id");
        this.f5438b = g.a(str, str2, coreJSONObject.optJSONArray("s"), context);
    }

    public ArrayList<c> a() {
        return this.f5438b;
    }

    public String b() {
        return this.f5437a;
    }
}
