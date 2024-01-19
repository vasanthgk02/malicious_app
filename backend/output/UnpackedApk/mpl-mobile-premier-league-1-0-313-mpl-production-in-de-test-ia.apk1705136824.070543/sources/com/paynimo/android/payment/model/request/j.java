package com.paynimo.android.payment.model.request;

import java.io.Serializable;

public class j implements Serializable {
    public h payment;
    public String subType = "";
    public String type = "";

    public h getPayment() {
        return this.payment;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public void setPayment(h hVar) {
        this.payment = hVar;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
