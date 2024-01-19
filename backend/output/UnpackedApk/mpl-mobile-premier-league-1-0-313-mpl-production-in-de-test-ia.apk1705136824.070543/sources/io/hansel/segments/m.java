package io.hansel.segments;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaAttributes;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventData;
import java.util.HashSet;
import java.util.Set;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5270a;

    /* renamed from: b  reason: collision with root package name */
    public HSLCriteriaAttributes f5271b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5272c;

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f5273d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public boolean f5274e;

    public m(Context context, String str, CoreJSONObject coreJSONObject, boolean z) {
        this.f5270a = context;
        this.f5272c = str;
        this.f5274e = a(coreJSONObject);
        if (z) {
            c(coreJSONObject);
        } else {
            b(coreJSONObject);
        }
    }

    private boolean a(CoreJSONObject coreJSONObject) {
        String optString = coreJSONObject.optString("eval");
        return optString != null && optString.equals("smt");
    }

    private void b(CoreJSONObject coreJSONObject) {
        if (!this.f5274e) {
            CoreJSONObject optJSONObject = coreJSONObject.optJSONObject(HSLCriteriaBuilder.CRITERIA);
            if (optJSONObject != null) {
                HSLCriteriaAttributes build = HSLCriteriaBuilder.build(this.f5272c, optJSONObject, null, new HSLCriteriaAttributes(), true, this.f5273d);
                if (build != null) {
                    this.f5271b = build;
                }
            }
        }
    }

    private void c(CoreJSONObject coreJSONObject) {
        if (coreJSONObject != null) {
            HSLCriteriaAttributes buildStopConditionCriteria = HSLCriteriaBuilder.buildStopConditionCriteria(this.f5272c, coreJSONObject, this.f5273d);
            if (buildStopConditionCriteria != null) {
                this.f5271b = buildStopConditionCriteria;
            }
        }
    }

    public HSLCriteriaAttributes a() {
        return this.f5271b;
    }

    public boolean a(EventData eventData) {
        if (this.f5274e) {
            return p.b(this.f5270a, this.f5272c).booleanValue();
        }
        HSLCriteriaAttributes hSLCriteriaAttributes = this.f5271b;
        boolean z = hSLCriteriaAttributes == null || hSLCriteriaAttributes.getHslCriteriaNode() == null || this.f5271b.getHslCriteriaNode().evaluate(n.a(this.f5270a).c(), null, eventData);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("The evaluated value for the segment ");
        outline73.append(this.f5272c);
        outline73.append(" is ");
        outline73.append(z);
        HSLLogger.d(outline73.toString());
        return z;
    }

    public String b() {
        return this.f5272c;
    }

    public Set<String> c() {
        return this.f5273d;
    }

    public boolean d() {
        return this.f5274e;
    }
}
