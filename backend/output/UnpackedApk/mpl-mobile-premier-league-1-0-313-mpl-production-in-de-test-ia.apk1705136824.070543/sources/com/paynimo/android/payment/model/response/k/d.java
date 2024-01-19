package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class d implements Serializable {
    public static final long serialVersionUID = 1;
    public String amex = "";
    public String credit = "";
    public String debit = "";
    public String diner = "";
    public String discover = "";
    public String ivr = "";
    public String rupay = "";

    public String getAmex() {
        return this.amex;
    }

    public String getCredit() {
        return this.credit;
    }

    public String getDebit() {
        return this.debit;
    }

    public String getDiner() {
        return this.diner;
    }

    public String getDiscover() {
        return this.discover;
    }

    public String getIvr() {
        return this.ivr;
    }

    public String getRupay() {
        return this.rupay;
    }

    public void setAmex(String str) {
        this.amex = str;
    }

    public void setCredit(String str) {
        this.credit = str;
    }

    public void setDebit(String str) {
        this.debit = str;
    }

    public void setDiner(String str) {
        this.diner = str;
    }

    public void setDiscover(String str) {
        this.discover = str;
    }

    public void setIvr(String str) {
        this.ivr = str;
    }

    public void setRupay(String str) {
        this.rupay = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cards [debit=");
        outline73.append(this.debit);
        outline73.append(", credit=");
        outline73.append(this.credit);
        outline73.append(", amex=");
        outline73.append(this.amex);
        outline73.append(", rupay=");
        outline73.append(this.rupay);
        outline73.append(", diner=");
        outline73.append(this.diner);
        outline73.append(", discover=");
        outline73.append(this.discover);
        outline73.append(", ivr=");
        return GeneratedOutlineSupport.outline62(outline73, this.ivr, CMapParser.MARK_END_OF_ARRAY);
    }
}
