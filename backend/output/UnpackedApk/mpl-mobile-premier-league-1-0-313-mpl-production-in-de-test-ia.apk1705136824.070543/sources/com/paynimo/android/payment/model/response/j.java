package com.paynimo.android.payment.model.response;

import java.io.Serializable;

public class j implements Serializable {
    public String ApprovalRefNo = "";
    public String Status = "";
    public String TrtxnRef = "";
    public String response = "";
    public String responseCode = "";
    public String txnId = "";
    public String txnRef = "";

    public String getApprovalRefNo() {
        return this.ApprovalRefNo;
    }

    public String getResponse() {
        return this.response;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.Status;
    }

    public String getTrtxnRef() {
        return this.TrtxnRef;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public String getTxnRef() {
        return this.txnRef;
    }

    public void setApprovalRefNo(String str) {
        this.ApprovalRefNo = str;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public void setStatus(String str) {
        this.Status = str;
    }

    public void setTrtxnRef(String str) {
        this.TrtxnRef = str;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setTxnRef(String str) {
        this.txnRef = str;
    }
}
