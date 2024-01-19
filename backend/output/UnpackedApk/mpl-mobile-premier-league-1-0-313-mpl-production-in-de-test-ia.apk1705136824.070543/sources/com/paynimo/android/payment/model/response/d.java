package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class d implements Serializable {
    public static final long serialVersionUID = 1;
    public String code = "";
    public String desc = "";

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error [code=");
        outline73.append(this.code);
        outline73.append(", desc=");
        return GeneratedOutlineSupport.outline62(outline73, this.desc, CMapParser.MARK_END_OF_ARRAY);
    }
}
