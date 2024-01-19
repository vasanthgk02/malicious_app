package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class n implements Serializable {
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
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ENACHBankCard{bankCode='");
        GeneratedOutlineSupport.outline99(outline73, this.bankCode, ExtendedMessageFormat.QUOTE, ", bankName='");
        GeneratedOutlineSupport.outline99(outline73, this.bankName, ExtendedMessageFormat.QUOTE, ", optionFlag='");
        GeneratedOutlineSupport.outline99(outline73, this.optionFlag, ExtendedMessageFormat.QUOTE, ", performanceFlag='");
        return GeneratedOutlineSupport.outline60(outline73, this.performanceFlag, ExtendedMessageFormat.QUOTE, '}');
    }
}
