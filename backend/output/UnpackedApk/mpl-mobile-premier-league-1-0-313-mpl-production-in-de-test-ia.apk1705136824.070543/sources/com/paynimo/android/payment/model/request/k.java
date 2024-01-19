package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class k implements Serializable {
    public static final long serialVersionUID = 1;
    public String action = "D";
    public String amount = "";
    public String debitDay = "";
    public String debitFlag = "N";
    public String description = "";
    public String endDateTime = "";
    public String frequency = "";
    public String identifier = "";
    public String limit = "";
    public String occurrence = "";
    public String reference = "";
    public String startDateTime = "";
    public String type = "";
    public String validity = "";

    public String getAction() {
        return this.action;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getDebitDay() {
        return this.debitDay;
    }

    public String getDebitFlag() {
        return this.debitFlag;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEndDateTime() {
        return this.endDateTime;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getLimit() {
        return this.limit;
    }

    public String getOccurrence() {
        return this.occurrence;
    }

    public String getReference() {
        return this.reference;
    }

    public String getStartDateTime() {
        return this.startDateTime;
    }

    public String getType() {
        return this.type;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setDebitDay(String str) {
        this.debitDay = str;
    }

    public void setDebitFlag(String str) {
        this.debitFlag = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEndDateTime(String str) {
        this.endDateTime = str;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setLimit(String str) {
        this.limit = str;
    }

    public void setOccurrence(String str) {
        this.occurrence = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public void setStartDateTime(String str) {
        this.startDateTime = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValidity(String str) {
        this.validity = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Instruction [identifier=");
        outline73.append(this.identifier);
        outline73.append(", reference=");
        outline73.append(this.reference);
        outline73.append(", description=");
        outline73.append(this.description);
        outline73.append(", action=");
        outline73.append(this.action);
        outline73.append(", type=");
        outline73.append(this.type);
        outline73.append(", limit=");
        outline73.append(this.limit);
        outline73.append(", amount=");
        outline73.append(this.amount);
        outline73.append(", occurrence=");
        outline73.append(this.occurrence);
        outline73.append(", frequency=");
        outline73.append(this.frequency);
        outline73.append(", validity=");
        outline73.append(this.validity);
        outline73.append(", startDateTime=");
        outline73.append(this.startDateTime);
        outline73.append(", endDateTime=");
        outline73.append(this.endDateTime);
        outline73.append(", debitDay=");
        outline73.append(this.debitDay);
        outline73.append(", debitFlag=");
        return GeneratedOutlineSupport.outline62(outline73, this.debitFlag, CMapParser.MARK_END_OF_ARRAY);
    }
}
