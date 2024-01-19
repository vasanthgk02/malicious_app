package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import java.io.Serializable;
import org.apache.commons.lang.StringEscapeUtils;

public final class c implements JSONAware, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final c f1986a = new c("DEF");

    /* renamed from: b  reason: collision with root package name */
    public final String f1987b;

    public c(String str) {
        this.f1987b = str;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof c) && this.f1987b.equals(obj.toString());
    }

    public int hashCode() {
        return this.f1987b.hashCode();
    }

    public String toJSONString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("\"");
        outline73.append(JSONObject.escape(this.f1987b));
        outline73.append(StringEscapeUtils.CSV_QUOTE);
        return outline73.toString();
    }

    public String toString() {
        return this.f1987b;
    }
}
