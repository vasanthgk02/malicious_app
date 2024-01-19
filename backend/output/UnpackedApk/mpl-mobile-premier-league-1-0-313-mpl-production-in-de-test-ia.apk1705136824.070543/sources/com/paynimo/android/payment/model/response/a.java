package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class a implements Serializable {
    public static final long serialVersionUID = 1;
    public String bankAcsFormName = "";
    public String bankAcsHttpMethod = "";
    public List bankAcsParams;
    public String bankAcsUrl = "";

    public String getBankAcsFormName() {
        return this.bankAcsFormName;
    }

    public String getBankAcsHttpMethod() {
        return this.bankAcsHttpMethod;
    }

    public List getBankAcsParams() {
        return this.bankAcsParams;
    }

    public String getBankAcsUrl() {
        return this.bankAcsUrl;
    }

    public void setBankAcsFormName(String str) {
        this.bankAcsFormName = str;
    }

    public void setBankAcsHttpMethod(String str) {
        this.bankAcsHttpMethod = str;
    }

    public void setBankAcsParams(List list) {
        this.bankAcsParams = list;
    }

    public void setBankAcsUrl(String str) {
        this.bankAcsUrl = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ACS [bankAcsFormName=");
        outline73.append(this.bankAcsFormName);
        outline73.append(", bankAcsHttpMethod=");
        outline73.append(this.bankAcsHttpMethod);
        outline73.append(", bankAcsParams=");
        outline73.append(this.bankAcsParams);
        outline73.append(", bankAcsUrl=");
        return GeneratedOutlineSupport.outline62(outline73, this.bankAcsUrl, CMapParser.MARK_END_OF_ARRAY);
    }
}
