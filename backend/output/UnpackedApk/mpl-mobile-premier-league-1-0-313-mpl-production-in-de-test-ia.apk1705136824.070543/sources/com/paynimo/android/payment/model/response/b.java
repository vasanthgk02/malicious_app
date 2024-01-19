package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class b implements Serializable {
    public static final long serialVersionUID = 1;
    public String subType = "";
    public String type = "";

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Authentication [type=");
        outline73.append(this.type);
        outline73.append(", subType=");
        return GeneratedOutlineSupport.outline62(outline73, this.subType, CMapParser.MARK_END_OF_ARRAY);
    }
}
