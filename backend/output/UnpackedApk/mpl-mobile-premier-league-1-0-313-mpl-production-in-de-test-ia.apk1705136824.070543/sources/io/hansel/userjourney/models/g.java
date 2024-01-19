package io.hansel.userjourney.models;

import android.content.Context;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.userjourney.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final long f5464a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, Set<PromptGoalEventCriteriaInfo>> f5465b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final CoreJSONArray f5466c;

    public g(Context context, CoreJSONObject coreJSONObject, String str) {
        this.f5464a = coreJSONObject.optLong("ad_in_mins", p.c(context, str)) * 60000;
        CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("goals");
        this.f5466c = optJSONArray;
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!optJSONArray.isNull(i)) {
                    CoreJSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    a(b.a(optJSONObject.optString("nm"), optJSONObject.optString("ven")), new PromptGoalEventCriteriaInfo(optJSONObject.optJSONObject(HSLCriteriaBuilder.CRITERIA), optJSONObject.optJSONObject("type")));
                }
            }
        }
    }

    private void a(String str, PromptGoalEventCriteriaInfo promptGoalEventCriteriaInfo) {
        if (!this.f5465b.containsKey(str)) {
            this.f5465b.put(str, new HashSet());
        }
        this.f5465b.get(str).add(promptGoalEventCriteriaInfo);
    }

    public long a() {
        return this.f5464a;
    }

    public void a(String str, Set<PromptGoalEventCriteriaInfo> set) {
        if (!this.f5465b.containsKey(str)) {
            this.f5465b.put(str, new HashSet());
        }
        this.f5465b.get(str).addAll(set);
    }

    public CoreJSONArray b() {
        return this.f5466c;
    }

    public HashMap<String, Set<PromptGoalEventCriteriaInfo>> c() {
        return this.f5465b;
    }
}
