package com.paynimo.android.payment.model.response;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class i implements Serializable {
    public static final long serialVersionUID = 1;
    public String amount = "";
    public String balanceAmount = "";
    public String bankReferenceIdentifier = "";
    public String dateTime = "";
    public String errorMessage = "";
    public String identifier = "";
    public f instruction;
    public String refundIdentifier = "";
    public String statusCode = "";
    public String statusMessage = "";

    public String getAmount() {
        return this.amount;
    }

    public String getBalanceAmount() {
        return this.balanceAmount;
    }

    public String getBankReferenceIdentifier() {
        return this.bankReferenceIdentifier;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public f getInstruction() {
        return this.instruction;
    }

    public String getRefundIdentifier() {
        return this.refundIdentifier;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBalanceAmount(String str) {
        this.balanceAmount = str;
    }

    public void setBankReferenceIdentifier(String str) {
        this.bankReferenceIdentifier = str;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setInstruction(f fVar) {
        this.instruction = fVar;
    }

    public void setRefundIdentifier(String str) {
        this.refundIdentifier = str;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PaymentTransaction [amount=");
        outline73.append(this.amount);
        outline73.append(", balanceAmount=");
        outline73.append(this.balanceAmount);
        outline73.append(", bankReferenceIdentifier=");
        outline73.append(this.bankReferenceIdentifier);
        outline73.append(", dateTime=");
        outline73.append(this.dateTime);
        outline73.append(", errorMessage=");
        outline73.append(this.errorMessage);
        outline73.append(", identifier=");
        outline73.append(this.identifier);
        outline73.append(", refundIdentifier=");
        outline73.append(this.refundIdentifier);
        outline73.append(", statusCode=");
        outline73.append(this.statusCode);
        outline73.append(", statusMessage=");
        outline73.append(this.statusMessage);
        outline73.append(", instruction=");
        outline73.append(this.instruction);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
