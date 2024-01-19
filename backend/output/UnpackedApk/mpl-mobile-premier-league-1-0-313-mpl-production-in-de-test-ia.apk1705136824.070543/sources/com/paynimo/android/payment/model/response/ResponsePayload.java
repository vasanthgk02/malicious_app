package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class ResponsePayload implements Serializable {
    public static final long serialVersionUID = 1;
    public String merchantAdditionalDetails = "";
    public String merchantCode = "";
    public String merchantTransactionIdentifier = "";
    public String merchantTransactionRequestType = "";
    public h paymentMethod;
    public String responseType = "";
    public String transactionState = "";

    public String getMerchantAdditionalDetails() {
        return this.merchantAdditionalDetails;
    }

    public String getMerchantCode() {
        return this.merchantCode;
    }

    public String getMerchantTransactionIdentifier() {
        return this.merchantTransactionIdentifier;
    }

    public String getMerchantTransactionRequestType() {
        return this.merchantTransactionRequestType;
    }

    public h getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getResponseType() {
        return this.responseType;
    }

    public String getTransactionState() {
        return this.transactionState;
    }

    public void setMerchantAdditionalDetails(String str) {
        this.merchantAdditionalDetails = str;
    }

    public void setMerchantCode(String str) {
        this.merchantCode = str;
    }

    public void setMerchantTransactionIdentifier(String str) {
        this.merchantTransactionIdentifier = str;
    }

    public void setMerchantTransactionRequestType(String str) {
        this.merchantTransactionRequestType = str;
    }

    public void setPaymentMethod(h hVar) {
        this.paymentMethod = hVar;
    }

    public void setResponseType(String str) {
        this.responseType = str;
    }

    public void setTransactionState(String str) {
        this.transactionState = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ResponsePayload [merchantCode=");
        outline73.append(this.merchantCode);
        outline73.append(", merchantTransactionIdentifier=");
        outline73.append(this.merchantTransactionIdentifier);
        outline73.append(", merchantTransactionRequestType=");
        outline73.append(this.merchantTransactionRequestType);
        outline73.append(", responseType=");
        outline73.append(this.responseType);
        outline73.append(", transactionState=");
        outline73.append(this.transactionState);
        outline73.append(", merchantAdditionalDetails=");
        outline73.append(this.merchantAdditionalDetails);
        outline73.append(", paymentMethod=");
        outline73.append(this.paymentMethod.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
