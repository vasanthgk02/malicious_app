package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.m;
import java.io.Serializable;
import org.apache.commons.lang.StringEscapeUtils;

public final class d implements JSONAware, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final d f2028a = new d("EC", m.RECOMMENDED);

    /* renamed from: b  reason: collision with root package name */
    public static final d f2029b = new d("RSA", m.REQUIRED);

    /* renamed from: c  reason: collision with root package name */
    public static final d f2030c = new d("oct", m.OPTIONAL);

    /* renamed from: d  reason: collision with root package name */
    public static final d f2031d = new d("OKP", m.OPTIONAL);

    /* renamed from: e  reason: collision with root package name */
    public final String f2032e;

    public d(String str, m mVar) {
        this.f2032e = str;
    }

    public static d a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The key type to parse must not be null");
        } else if (str.equals(f2028a.f2032e)) {
            return f2028a;
        } else {
            if (str.equals(f2029b.f2032e)) {
                return f2029b;
            }
            if (str.equals(f2030c.f2032e)) {
                return f2030c;
            }
            return str.equals(f2031d.f2032e) ? f2031d : new d(str, null);
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof d) && this.f2032e.equals(obj.toString());
    }

    public int hashCode() {
        return this.f2032e.hashCode();
    }

    public String toJSONString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("\"");
        outline73.append(JSONObject.escape(this.f2032e));
        outline73.append(StringEscapeUtils.CSV_QUOTE);
        return outline73.toString();
    }

    public String toString() {
        return this.f2032e;
    }
}
