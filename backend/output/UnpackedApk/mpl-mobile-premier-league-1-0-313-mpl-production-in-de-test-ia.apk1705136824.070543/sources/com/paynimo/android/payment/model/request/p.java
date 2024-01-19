package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class p implements Serializable {
    public static final long serialVersionUID = 1;
    public String token = "";
    public String type = "";

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Method [type=");
        outline73.append(this.type);
        outline73.append(", token=");
        return GeneratedOutlineSupport.outline62(outline73, this.token, CMapParser.MARK_END_OF_ARRAY);
    }
}
