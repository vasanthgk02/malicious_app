package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class n implements Serializable {
    public String AppId;
    public String BankCode;
    public String BankName;
    public String CardType;
    public String CardVendor;
    public String ConsumerId;
    public String DeviceId;
    public String EventAction;
    public String EventCategory;
    public String EventStatus;
    public String Journey;
    public String MerchantId;
    public String MerchantTxnId;
    public String PaymentOption;
    public String ReferenceId;
    public String RequestToken;
    public long ResponseTime;
    public String Session;
    public String Timestamp;
    public String TxnAmount;
    public String TxnCurrency;
    public String UserAgent;

    public String getAppId() {
        return this.AppId;
    }

    public String getBankCode() {
        return this.BankCode;
    }

    public String getBankName() {
        return this.BankName;
    }

    public String getCardType() {
        return this.CardType;
    }

    public String getCardVendor() {
        return this.CardVendor;
    }

    public String getConsumerId() {
        return this.ConsumerId;
    }

    public String getDeviceId() {
        return this.DeviceId;
    }

    public String getEventAction() {
        return this.EventAction;
    }

    public String getEventCategory() {
        return this.EventCategory;
    }

    public String getEventStatus() {
        return this.EventStatus;
    }

    public String getJourney() {
        return this.Journey;
    }

    public String getMerchantId() {
        return this.MerchantId;
    }

    public String getMerchantTxnId() {
        return this.MerchantTxnId;
    }

    public String getPaymentOption() {
        return this.PaymentOption;
    }

    public String getReferenceId() {
        return this.ReferenceId;
    }

    public String getRequestToken() {
        return this.RequestToken;
    }

    public long getResponseTime() {
        return this.ResponseTime;
    }

    public String getSession() {
        return this.Session;
    }

    public String getTimestamp() {
        return this.Timestamp;
    }

    public String getTxnAmount() {
        return this.TxnAmount;
    }

    public String getTxnCurrency() {
        return this.TxnCurrency;
    }

    public String getUserAgent() {
        return this.UserAgent;
    }

    public void setAppId(String str) {
        this.AppId = str;
    }

    public void setBankCode(String str) {
        this.BankCode = str;
    }

    public void setBankName(String str) {
        this.BankName = str;
    }

    public void setCardType(String str) {
        this.CardType = str;
    }

    public void setCardVendor(String str) {
        this.CardVendor = str;
    }

    public void setConsumerId(String str) {
        this.ConsumerId = str;
    }

    public void setDeviceId(String str) {
        this.DeviceId = str;
    }

    public void setEventAction(String str) {
        this.EventAction = str;
    }

    public void setEventCategory(String str) {
        this.EventCategory = str;
    }

    public void setEventStatus(String str) {
        this.EventStatus = str;
    }

    public void setJourney(String str) {
        this.Journey = str;
    }

    public void setMerchantId(String str) {
        this.MerchantId = str;
    }

    public void setMerchantTxnId(String str) {
        this.MerchantTxnId = str;
    }

    public void setPaymentOption(String str) {
        this.PaymentOption = str;
    }

    public void setReferenceId(String str) {
        this.ReferenceId = str;
    }

    public void setRequestToken(String str) {
        this.RequestToken = str;
    }

    public void setResponseTime(long j) {
        this.ResponseTime = j;
    }

    public void setSession(String str) {
        this.Session = str;
    }

    public void setTimestamp(String str) {
        this.Timestamp = str;
    }

    public void setTxnAmount(String str) {
        this.TxnAmount = str;
    }

    public void setTxnCurrency(String str) {
        this.TxnCurrency = str;
    }

    public void setUserAgent(String str) {
        this.UserAgent = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LoggingRequest [Timestamp=");
        outline73.append(this.Timestamp);
        outline73.append(", Session=");
        outline73.append(this.Session);
        outline73.append(", AppId=");
        outline73.append(this.AppId);
        outline73.append(", RequestToken=");
        outline73.append(this.RequestToken);
        outline73.append(", Journey=");
        outline73.append(this.Journey);
        outline73.append(", EventAction=");
        outline73.append(this.EventAction);
        outline73.append(", EventCategory=");
        outline73.append(this.EventCategory);
        outline73.append(", MerchantTxnId=");
        outline73.append(this.MerchantTxnId);
        outline73.append(", ReferenceId=");
        outline73.append(this.ReferenceId);
        outline73.append(", ConsumerId=");
        outline73.append(this.ConsumerId);
        outline73.append(", MerchantId=");
        outline73.append(this.MerchantId);
        outline73.append(", DeviceId=");
        outline73.append(this.DeviceId);
        outline73.append(", UserAgent=");
        outline73.append(this.UserAgent);
        outline73.append(", ResponseTime=");
        outline73.append(this.ResponseTime);
        outline73.append(", EventStatus=");
        outline73.append(this.EventStatus);
        outline73.append(", PaymentOption=");
        outline73.append(this.PaymentOption);
        outline73.append(", BankName=");
        outline73.append(this.BankName);
        outline73.append(", BankCode=");
        outline73.append(this.BankCode);
        outline73.append(", CardVendor=");
        outline73.append(this.CardVendor);
        outline73.append(", CardType");
        outline73.append(this.CardType);
        outline73.append(", TxnAmount=");
        outline73.append(this.TxnAmount);
        outline73.append(", TxnCurrency=");
        return GeneratedOutlineSupport.outline62(outline73, this.TxnCurrency, CMapParser.MARK_END_OF_ARRAY);
    }
}
