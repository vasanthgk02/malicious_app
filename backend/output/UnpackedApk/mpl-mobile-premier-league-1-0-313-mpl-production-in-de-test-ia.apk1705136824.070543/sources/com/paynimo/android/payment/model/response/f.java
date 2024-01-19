package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class f implements Serializable {
    public static final long serialVersionUID = 1;
    public String errorcode = "";
    public String errordesc = "";
    public String id = "";
    public String statusCode = "";

    public String getErrorcode() {
        return this.errorcode;
    }

    public String getErrordesc() {
        return this.errordesc;
    }

    public String getId() {
        return this.id;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setErrorcode(String str) {
        this.errorcode = str;
    }

    public void setErrordesc(String str) {
        this.errordesc = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Instruction [id=");
        outline73.append(this.id);
        outline73.append(", statusCode=");
        outline73.append(this.statusCode);
        outline73.append(", errorcode=");
        outline73.append(this.errorcode);
        outline73.append(", errordesc=");
        return GeneratedOutlineSupport.outline62(outline73, this.errordesc, CMapParser.MARK_END_OF_ARRAY);
    }
}
