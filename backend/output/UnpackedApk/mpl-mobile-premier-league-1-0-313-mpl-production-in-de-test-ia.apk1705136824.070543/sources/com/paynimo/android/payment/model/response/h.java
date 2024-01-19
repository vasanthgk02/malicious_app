package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class h implements Serializable {
    public static final long serialVersionUID = 1;
    public a aCS;
    public b authentication;
    public String bankSelectionCode = "";
    public d error;
    public String instrumentAliasName = "";
    public String instrumentToken = "";
    public g oTP;
    public i paymentTransaction;
    public String token = "";

    public a getACS() {
        return this.aCS;
    }

    public b getAuthentication() {
        return this.authentication;
    }

    public String getBankSelectionCode() {
        return this.bankSelectionCode;
    }

    public d getError() {
        return this.error;
    }

    public String getInstrumentAliasName() {
        return this.instrumentAliasName;
    }

    public String getInstrumentToken() {
        return this.instrumentToken;
    }

    public g getOTP() {
        return this.oTP;
    }

    public i getPaymentTransaction() {
        return this.paymentTransaction;
    }

    public String getToken() {
        return this.token;
    }

    public void setACS(a aVar) {
        this.aCS = aVar;
    }

    public void setAuthentication(b bVar) {
        this.authentication = bVar;
    }

    public void setBankSelectionCode(String str) {
        this.bankSelectionCode = str;
    }

    public void setError(d dVar) {
        this.error = dVar;
    }

    public void setInstrumentAliasName(String str) {
        this.instrumentAliasName = str;
    }

    public void setInstrumentToken(String str) {
        this.instrumentToken = str;
    }

    public void setOTP(g gVar) {
        this.oTP = gVar;
    }

    public void setPaymentTransaction(i iVar) {
        this.paymentTransaction = iVar;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PaymentMethod [token=");
        outline73.append(this.token);
        outline73.append(", instrumentAliasName=");
        outline73.append(this.instrumentAliasName);
        outline73.append(", instrumentToken=");
        outline73.append(this.instrumentToken);
        outline73.append(", bankSelectionCode=");
        outline73.append(this.bankSelectionCode);
        outline73.append(", aCS=");
        outline73.append(this.aCS.toString());
        outline73.append(", oTP=");
        outline73.append(this.oTP.toString());
        outline73.append(", paymentTransaction=");
        outline73.append(this.paymentTransaction.toString());
        outline73.append(", authentication=");
        outline73.append(this.authentication.toString());
        outline73.append(", error=");
        outline73.append(this.error.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
