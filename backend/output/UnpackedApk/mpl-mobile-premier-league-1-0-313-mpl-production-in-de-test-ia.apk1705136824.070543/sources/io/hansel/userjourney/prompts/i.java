package io.hansel.userjourney.prompts;

import com.razorpay.AnalyticsConstants;
import io.hansel.core.json.CoreJSONObject;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5547a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5548b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5549c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5550d = false;

    public i(CoreJSONObject coreJSONObject) {
        this.f5547a = coreJSONObject.optBoolean("showbody", true);
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("showbody_onevent");
        this.f5548b = false;
        this.f5549c = true;
        if (optJSONObject != null && optJSONObject.optString("event").equals("click")) {
            this.f5548b = true;
            this.f5549c = optJSONObject.optBoolean(AnalyticsConstants.SHOW, true);
        }
    }

    public boolean a() {
        return this.f5548b;
    }

    public boolean b() {
        return this.f5547a;
    }

    public boolean c() {
        return this.f5549c;
    }

    public boolean d() {
        return this.f5550d;
    }

    public void e() {
        this.f5550d = true;
    }
}
