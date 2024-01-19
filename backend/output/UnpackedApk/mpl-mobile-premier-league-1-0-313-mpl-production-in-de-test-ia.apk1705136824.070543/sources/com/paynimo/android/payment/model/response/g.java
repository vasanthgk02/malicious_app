package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class g implements Serializable {
    public static final long serialVersionUID = 1;
    public String initiator = "";
    public String message = "";
    public String numberOfDigit = "";
    public String target = "";
    public String type = "";

    public String getInitiator() {
        return this.initiator;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNumberOfDigit() {
        return this.numberOfDigit;
    }

    public String getTarget() {
        return this.target;
    }

    public String getType() {
        return this.type;
    }

    public void setInitiator(String str) {
        this.initiator = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNumberOfDigit(String str) {
        this.numberOfDigit = str;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("OTP [initiator=");
        outline73.append(this.initiator);
        outline73.append(", message=");
        outline73.append(this.message);
        outline73.append(", numberOfDigit=");
        outline73.append(this.numberOfDigit);
        outline73.append(", target=");
        outline73.append(this.target);
        outline73.append(", type=");
        return GeneratedOutlineSupport.outline62(outline73, this.type, CMapParser.MARK_END_OF_ARRAY);
    }
}
