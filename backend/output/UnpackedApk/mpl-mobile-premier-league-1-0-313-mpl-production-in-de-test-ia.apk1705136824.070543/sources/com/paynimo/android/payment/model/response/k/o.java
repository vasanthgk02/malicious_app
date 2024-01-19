package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class o implements Serializable {
    public static final long serialVersionUID = 1;
    public String errorCode = "";
    public String errorDesc = "";
    public Boolean errorDisplay = Boolean.FALSE;

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public Boolean getErrorDisplay() {
        return this.errorDisplay;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorDesc(String str) {
        this.errorDesc = str;
    }

    public void setErrorDisplay(Boolean bool) {
        this.errorDisplay = bool;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error [errorCode=");
        outline73.append(this.errorCode);
        outline73.append(", errorDesc=");
        outline73.append(this.errorDesc);
        outline73.append(", errorDisplay=");
        outline73.append(this.errorDisplay);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
