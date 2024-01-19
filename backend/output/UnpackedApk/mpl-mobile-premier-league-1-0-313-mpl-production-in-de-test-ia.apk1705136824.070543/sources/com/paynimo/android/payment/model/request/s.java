package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class s implements Serializable {
    public static final long serialVersionUID = 1;
    public String amount = "";
    public String currency = "";
    public String dateTime = "";
    public String description = "";
    public String deviceIdentifier = "Android";
    public String forced3DSCall = "N";
    public String identifier = "";
    public String isRegistration = "N";
    public String merchantInitiated = "N";
    public String reference = "";
    public String requestType = "";
    public String securityToken = "";
    public String smsSending = "";
    public String subType = "";
    public String token = "";
    public String type = "";

    public String getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdentifier() {
        return this.deviceIdentifier;
    }

    public String getForced3DSCall() {
        return this.forced3DSCall;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getIsRegistration() {
        return this.isRegistration;
    }

    public String getMerchantInitiated() {
        return this.merchantInitiated;
    }

    public String getReference() {
        return this.reference;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public String getSmsSending() {
        return this.smsSending;
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

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDeviceIdentifier(String str) {
        this.deviceIdentifier = str;
    }

    public void setForced3DSCall(String str) {
        this.forced3DSCall = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setIsRegistration(String str) {
        this.isRegistration = str;
    }

    public void setMerchantInitiated(String str) {
        this.merchantInitiated = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public void setRequestType(String str) {
        this.requestType = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }

    public void setSmsSending(String str) {
        this.smsSending = str;
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

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Transaction [requestType=");
        outline73.append(this.requestType);
        outline73.append(", token=");
        outline73.append(this.token);
        outline73.append(", identifier=");
        outline73.append(this.identifier);
        outline73.append(", type=");
        outline73.append(this.type);
        outline73.append(", subType=");
        outline73.append(this.subType);
        outline73.append(", currency=");
        outline73.append(this.currency);
        outline73.append(", amount=");
        outline73.append(this.amount);
        outline73.append(", dateTime=");
        outline73.append(this.dateTime);
        outline73.append(", reference=");
        outline73.append(this.reference);
        outline73.append(", description=");
        outline73.append(this.description);
        outline73.append(", isRegistration=");
        outline73.append(this.isRegistration);
        outline73.append(", deviceIdentifier=");
        outline73.append(this.deviceIdentifier);
        outline73.append(", forced3DSCall=");
        outline73.append(this.forced3DSCall);
        outline73.append(", smsSending=");
        outline73.append(this.smsSending);
        outline73.append(", merchantInitiated=");
        outline73.append(this.merchantInitiated);
        outline73.append(", securityToken=");
        return GeneratedOutlineSupport.outline62(outline73, this.securityToken, CMapParser.MARK_END_OF_ARRAY);
    }
}
