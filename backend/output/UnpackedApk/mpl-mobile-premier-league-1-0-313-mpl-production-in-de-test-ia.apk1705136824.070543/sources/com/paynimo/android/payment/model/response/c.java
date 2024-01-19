package com.paynimo.android.payment.model.response;

import java.io.Serializable;

public class c implements Serializable {
    public static final long serialVersionUID = 1;
    public String allowed;
    public String card_bank_name;
    public String card_issuer_authority;
    public String card_issuer_bank_code;
    public String card_issuer_bank_name;
    public String card_scope;
    public String card_type;
    public String request_Bank_Type_Flg;
    public String request_bank_name;
    public String statuscode;
    public String statusdesc;

    public String getAllowed() {
        return this.allowed;
    }

    public String getCard_bank_name() {
        return this.card_bank_name;
    }

    public String getCard_issuer_authority() {
        return this.card_issuer_authority;
    }

    public String getCard_issuer_bank_code() {
        return this.card_issuer_bank_code;
    }

    public String getCard_issuer_bank_name() {
        return this.card_issuer_bank_name;
    }

    public String getCard_scope() {
        return this.card_scope;
    }

    public String getCard_type() {
        return this.card_type;
    }

    public String getRequest_Bank_Type_Flg() {
        return this.request_Bank_Type_Flg;
    }

    public String getRequest_bank_name() {
        return this.request_bank_name;
    }

    public String getStatuscode() {
        return this.statuscode;
    }

    public String getStatusdesc() {
        return this.statusdesc;
    }

    public void setAllowed(String str) {
        this.allowed = str;
    }

    public void setCard_bank_name(String str) {
        this.card_bank_name = str;
    }

    public void setCard_issuer_authority(String str) {
        this.card_issuer_authority = str;
    }

    public void setCard_issuer_bank_code(String str) {
        this.card_issuer_bank_code = str;
    }

    public void setCard_issuer_bank_name(String str) {
        this.card_issuer_bank_name = str;
    }

    public void setCard_scope(String str) {
        this.card_scope = str;
    }

    public void setCard_type(String str) {
        this.card_type = str;
    }

    public void setRequest_Bank_Type_Flg(String str) {
        this.request_Bank_Type_Flg = str;
    }

    public void setRequest_bank_name(String str) {
        this.request_bank_name = str;
    }

    public void setStatuscode(String str) {
        this.statuscode = str;
    }

    public void setStatusdesc(String str) {
        this.statusdesc = str;
    }
}
