package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class l implements Serializable {
    public static final long serialVersionUID = 1;
    public String acquirer = "";
    public String action = "";
    public String alias = "";
    public b authentication = new b();
    public String bIC = "";
    public e expiry = new e();
    public f holder = new f();
    public String iBAN = "";
    public String iFSC = "";
    public String identifier = "";
    public m issuance = new m();
    public String issuer = "";
    public String mICR = "";
    public String processor = "";
    public String provider = "";
    public String subType = "";
    public String token = "";
    public String type = "";
    public String verificationCode = "";

    public String getAcquirer() {
        return this.acquirer;
    }

    public String getAction() {
        return this.action;
    }

    public String getAlias() {
        return this.alias;
    }

    public b getAuthentication() {
        return this.authentication;
    }

    public e getExpiry() {
        return this.expiry;
    }

    public f getHolder() {
        return this.holder;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public m getIssuance() {
        return this.issuance;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public String getProcessor() {
        return this.processor;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public String getbIC() {
        return this.bIC;
    }

    public String getiBAN() {
        return this.iBAN;
    }

    public String getiFSC() {
        return this.iFSC;
    }

    public String getmICR() {
        return this.mICR;
    }

    public void setAcquirer(String str) {
        this.acquirer = str;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setAuthentication(b bVar) {
        this.authentication = bVar;
    }

    public void setExpiry(e eVar) {
        this.expiry = eVar;
    }

    public void setHolder(f fVar) {
        this.holder = fVar;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setIssuance(m mVar) {
        this.issuance = mVar;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public void setProcessor(String str) {
        this.processor = str;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVerificationCode(String str) {
        this.verificationCode = str;
    }

    public void setbIC(String str) {
        this.bIC = str;
    }

    public void setiBAN(String str) {
        this.iBAN = str;
    }

    public void setiFSC(String str) {
        this.iFSC = str;
    }

    public void setmICR(String str) {
        this.mICR = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Instrument [token=");
        outline73.append(this.token);
        outline73.append(", action=");
        outline73.append(this.action);
        outline73.append(", type=");
        outline73.append(this.type);
        outline73.append(", subType=");
        outline73.append(this.subType);
        outline73.append(", identifier=");
        outline73.append(this.identifier);
        outline73.append(", alias=");
        outline73.append(this.alias);
        outline73.append(", holder=");
        outline73.append(this.holder.toString());
        outline73.append(", provider=");
        outline73.append(this.provider);
        outline73.append(", acquirer=");
        outline73.append(this.acquirer);
        outline73.append(", processor=");
        outline73.append(this.processor);
        outline73.append(", issuer=");
        outline73.append(this.issuer);
        outline73.append(", iFSC=");
        outline73.append(this.iFSC);
        outline73.append(", mICR=");
        outline73.append(this.mICR);
        outline73.append(", bIC=");
        outline73.append(this.bIC);
        outline73.append(", iBAN=");
        outline73.append(this.iBAN);
        outline73.append(", issuance=");
        outline73.append(this.issuance.toString());
        outline73.append(", expiry=");
        outline73.append(this.expiry.toString());
        outline73.append(", verificationCode=");
        outline73.append(this.verificationCode);
        outline73.append(", authentication=");
        outline73.append(this.authentication.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
