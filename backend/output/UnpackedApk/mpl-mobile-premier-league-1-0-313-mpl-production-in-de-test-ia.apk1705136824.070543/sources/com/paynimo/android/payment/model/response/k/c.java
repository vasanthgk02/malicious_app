package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class c implements Serializable {
    public static final long serialVersionUID = 1;
    public String aliasName = "";
    public String cardId = "";
    public String cardIssuerAuthority = "";
    public String cstat = "";
    public String maskedCardNo = "";

    public String getAliasName() {
        return this.aliasName;
    }

    public String getCardId() {
        return this.cardId;
    }

    public String getCardIssuerAuthority() {
        return this.cardIssuerAuthority;
    }

    public String getCstat() {
        return this.cstat;
    }

    public String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }

    public void setCardIssuerAuthority(String str) {
        this.cardIssuerAuthority = str;
    }

    public void setCstat(String str) {
        this.cstat = str;
    }

    public void setMaskedCardNo(String str) {
        this.maskedCardNo = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CardVaultData [cardId=");
        outline73.append(this.cardId);
        outline73.append(", aliasName=");
        outline73.append(this.aliasName);
        outline73.append(", cstat=");
        outline73.append(this.cstat);
        outline73.append(", maskedCardNo=");
        outline73.append(this.maskedCardNo);
        outline73.append(", cardIssuerAuthority=");
        return GeneratedOutlineSupport.outline62(outline73, this.cardIssuerAuthority, CMapParser.MARK_END_OF_ARRAY);
    }
}
