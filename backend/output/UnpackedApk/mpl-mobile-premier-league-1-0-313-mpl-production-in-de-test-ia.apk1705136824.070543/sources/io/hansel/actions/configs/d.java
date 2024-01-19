package io.hansel.actions.configs;

import com.userexperior.utilities.k;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import java.util.ArrayList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f5061a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f5062b;

    /* renamed from: c  reason: collision with root package name */
    public g f5063c;

    /* renamed from: d  reason: collision with root package name */
    public f f5064d;

    public d a(String str, CoreJSONObject coreJSONObject) {
        this.f5061a = coreJSONObject.optString(k.f4287a);
        coreJSONObject.optString("dt");
        this.f5062b = new ArrayList<>();
        CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("av");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                this.f5062b.add(optJSONArray.optString(i));
            }
        }
        coreJSONObject.optString("suite", null);
        this.f5063c = new g(coreJSONObject.optJSONObject("det"));
        String optString = coreJSONObject.optString("data_source", null);
        if (optString != null) {
            this.f5064d = f.valueOf(optString);
        }
        return this;
    }

    public ArrayList<String> a() {
        return this.f5062b;
    }

    public String b() {
        return this.f5061a;
    }

    public f c() {
        return this.f5064d;
    }

    public g d() {
        return this.f5063c;
    }
}
