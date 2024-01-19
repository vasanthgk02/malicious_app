package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import java.io.Serializable;
import org.apache.commons.lang.StringEscapeUtils;

public final class f implements JSONAware, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public final String f2005d;

    public f(String str) {
        this.f2005d = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f2005d.toLowerCase().equals(((f) obj).f2005d.toLowerCase());
    }

    public int hashCode() {
        return this.f2005d.toLowerCase().hashCode();
    }

    public String toJSONString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("\"");
        outline73.append(JSONObject.escape(this.f2005d));
        outline73.append(StringEscapeUtils.CSV_QUOTE);
        return outline73.toString();
    }

    public String toString() {
        return this.f2005d;
    }
}
