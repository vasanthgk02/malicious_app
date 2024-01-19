package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class Item implements Serializable {
    public static final long serialVersionUID = 1;
    public String amount = "";
    public String comAmt = "";
    public String description = "";
    public String identifier = "";
    public String providerIdentifier = "";
    public String reference = "";
    public String sKU = "";
    public String surchargeOrDiscountAmount = "";

    public Item(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.identifier = str;
        this.amount = str2;
        this.surchargeOrDiscountAmount = str3;
        this.comAmt = str4;
        this.sKU = str5;
        this.reference = str6;
        this.description = str7;
        this.providerIdentifier = str8;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getComAmt() {
        return this.comAmt;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getProviderIdentifier() {
        return this.providerIdentifier;
    }

    public String getReference() {
        return this.reference;
    }

    public String getSurchargeOrDiscountAmount() {
        return this.surchargeOrDiscountAmount;
    }

    public String getsKU() {
        return this.sKU;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setComAmt(String str) {
        this.comAmt = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setProviderIdentifier(String str) {
        this.providerIdentifier = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public void setSurchargeOrDiscountAmount(String str) {
        this.surchargeOrDiscountAmount = str;
    }

    public void setsKU(String str) {
        this.sKU = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Item [identifier=");
        outline73.append(this.identifier);
        outline73.append(", amount=");
        outline73.append(this.amount);
        outline73.append(", surchargeOrDiscountAmount=");
        outline73.append(this.surchargeOrDiscountAmount);
        outline73.append(", comAmt=");
        outline73.append(this.comAmt);
        outline73.append(", sKU=");
        outline73.append(this.sKU);
        outline73.append(", reference=");
        outline73.append(this.reference);
        outline73.append(", description=");
        outline73.append(this.description);
        outline73.append(", providerIdentifier=");
        return GeneratedOutlineSupport.outline62(outline73, this.providerIdentifier, CMapParser.MARK_END_OF_ARRAY);
    }

    public Item() {
    }
}
