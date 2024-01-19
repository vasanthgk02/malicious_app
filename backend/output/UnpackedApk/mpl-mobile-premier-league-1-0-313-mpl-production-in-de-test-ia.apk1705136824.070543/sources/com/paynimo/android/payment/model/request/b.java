package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class b implements Serializable {
    public static final long serialVersionUID = 1;
    public String subType = "";
    public String token = "";
    public String type = "";

    public String getSubType() {
        return this.subType;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Authentication [type=");
        outline73.append(this.type);
        outline73.append(", subType=");
        outline73.append(this.subType);
        outline73.append(", token=");
        return GeneratedOutlineSupport.outline62(outline73, this.token, CMapParser.MARK_END_OF_ARRAY);
    }
}
