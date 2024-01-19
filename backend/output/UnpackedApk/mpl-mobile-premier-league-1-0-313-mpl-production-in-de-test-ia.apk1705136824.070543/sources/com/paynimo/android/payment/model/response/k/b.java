package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class b implements Serializable {
    public static final long serialVersionUID = 1;
    public String bankCode;
    public String bankName;
    public String optionFlag;

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getOptionFlag() {
        return this.optionFlag;
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

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BanksData [bankCode=");
        outline73.append(this.bankCode);
        outline73.append(", bankName=");
        outline73.append(this.bankName);
        outline73.append(", optionFlag=");
        return GeneratedOutlineSupport.outline62(outline73, this.optionFlag, CMapParser.MARK_END_OF_ARRAY);
    }
}
