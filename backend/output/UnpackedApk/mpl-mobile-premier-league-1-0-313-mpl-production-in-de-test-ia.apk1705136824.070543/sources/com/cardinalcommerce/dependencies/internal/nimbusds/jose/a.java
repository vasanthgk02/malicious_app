package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import java.io.Serializable;
import org.apache.commons.lang.StringEscapeUtils;

public class a implements JSONAware, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1976a = new a("none", m.REQUIRED);

    /* renamed from: b  reason: collision with root package name */
    public final String f1977b;

    public a(String str, m mVar) {
        if (str != null) {
            this.f1977b = str;
            return;
        }
        throw new IllegalArgumentException("The algorithm name must not be null");
    }

    public static a a(String str) {
        if (str == null) {
            return null;
        }
        return new a(str, null);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof a) && this.f1977b.equals(obj.toString());
    }

    public final int hashCode() {
        return this.f1977b.hashCode();
    }

    public final String toJSONString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("\"");
        outline73.append(JSONObject.escape(this.f1977b));
        outline73.append(StringEscapeUtils.CSV_QUOTE);
        return outline73.toString();
    }

    public final String toString() {
        return this.f1977b;
    }
}
