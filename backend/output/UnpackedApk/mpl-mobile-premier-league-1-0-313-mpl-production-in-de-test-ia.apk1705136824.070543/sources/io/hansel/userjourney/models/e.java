package io.hansel.userjourney.models;

import androidx.core.app.NotificationCompatJellybean;
import io.hansel.core.criteria.HSLCriteriaAttributes;
import io.hansel.core.json.CoreJSONObject;
import java.util.HashSet;
import java.util.Set;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f5455a;

    /* renamed from: b  reason: collision with root package name */
    public HSLCriteriaAttributes f5456b;

    /* renamed from: c  reason: collision with root package name */
    public CoreJSONObject f5457c;

    public e(String str, HSLCriteriaAttributes hSLCriteriaAttributes, CoreJSONObject coreJSONObject) {
        this.f5455a = str;
        this.f5456b = hSLCriteriaAttributes;
        this.f5457c = coreJSONObject;
    }

    public Set<String> a() {
        HashSet hashSet = new HashSet();
        CoreJSONObject coreJSONObject = this.f5457c;
        if (coreJSONObject != null) {
            String optString = coreJSONObject.optString(NotificationCompatJellybean.KEY_LABEL);
            if (optString != null && optString.equals("sum")) {
                String optString2 = this.f5457c.optString("property");
                if (optString2 != null) {
                    hashSet.add(optString2);
                }
            }
        }
        return hashSet;
    }

    public HSLCriteriaAttributes b() {
        return this.f5456b;
    }

    public String c() {
        return this.f5455a;
    }
}
