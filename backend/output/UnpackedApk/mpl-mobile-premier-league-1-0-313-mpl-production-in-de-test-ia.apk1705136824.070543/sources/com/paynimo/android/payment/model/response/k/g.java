package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class g implements Serializable {
    public static final long serialVersionUID = 1;
    public String bankCode;
    public String bankName;
    public i eAuthBank;
    public j eAuthBankBio;
    public l eMandateBank;
    public m eNACHBank;
    public n eNACHBankCard;
    public boolean isHeader = false;
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

    public i geteAuthBank() {
        return this.eAuthBank;
    }

    public j geteAuthBankBio() {
        return this.eAuthBankBio;
    }

    public l geteMandateBank() {
        return this.eMandateBank;
    }

    public m geteNACHBank() {
        return this.eNACHBank;
    }

    public n geteNACHBankCard() {
        return this.eNACHBankCard;
    }

    public boolean isHeader() {
        return this.isHeader;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setHeader(boolean z) {
        this.isHeader = z;
    }

    public void setOptionFlag(String str) {
        this.optionFlag = str;
    }

    public void seteAuthBank(i iVar) {
        this.eAuthBank = iVar;
    }

    public void seteAuthBankBio(j jVar) {
        this.eAuthBankBio = jVar;
    }

    public void seteMandateBank(l lVar) {
        this.eMandateBank = lVar;
    }

    public void seteNACHBank(m mVar) {
        this.eNACHBank = mVar;
    }

    public void seteNACHBankCard(n nVar) {
        this.eNACHBankCard = nVar;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DigitalBanksData [bankCode=");
        outline73.append(this.bankCode);
        outline73.append(", bankName=");
        outline73.append(this.bankName);
        outline73.append(", optionFlag=");
        outline73.append(this.optionFlag);
        outline73.append(", eAuthBank=");
        outline73.append(this.eAuthBank);
        outline73.append(", eMandateBank=");
        outline73.append(this.eMandateBank);
        outline73.append(", eAuthBankBio=");
        outline73.append(this.eAuthBankBio);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
