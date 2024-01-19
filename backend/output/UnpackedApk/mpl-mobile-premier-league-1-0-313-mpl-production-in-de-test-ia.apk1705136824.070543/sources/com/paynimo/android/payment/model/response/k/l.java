package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class l implements Serializable {
    public String bankCode = "";
    public String bankName = "";
    public String optionFlag = "";
    public String performanceFlag = "";

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getOptionFlag() {
        return this.optionFlag;
    }

    public String getPerformanceFlag() {
        return this.performanceFlag;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setOptionFlag(String str) {
        this.optionFlag = str;
    }

    public void setPerformanceFlag(String str) {
        this.performanceFlag = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("EMandateBank [bankCode=");
        outline73.append(this.bankCode);
        outline73.append(", bankName=");
        outline73.append(this.bankName);
        outline73.append(", optionFlag=");
        outline73.append(this.optionFlag);
        outline73.append(", performanceFlag=");
        return GeneratedOutlineSupport.outline62(outline73, this.performanceFlag, CMapParser.MARK_END_OF_ARRAY);
    }
}
