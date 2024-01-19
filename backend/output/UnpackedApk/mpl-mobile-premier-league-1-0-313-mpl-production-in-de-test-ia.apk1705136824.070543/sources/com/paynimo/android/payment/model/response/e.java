package com.paynimo.android.payment.model.response;

import java.io.Serializable;

public class e implements Serializable {
    public String BankName;
    public String BeneficiaryName;
    public String Branch;
    public String BranchAddress;
    public String City;
    public String District;
    public String ErrorCode;
    public String ErrorDesc;
    public String IFSCCode;
    public String MICR;
    public String State;
    public String TransferChannel;
    public String isNACH;

    public String getBankName() {
        return this.BankName;
    }

    public String getBeneficiaryName() {
        return this.BeneficiaryName;
    }

    public String getBranch() {
        return this.Branch;
    }

    public String getBranchAddress() {
        return this.BranchAddress;
    }

    public String getCity() {
        return this.City;
    }

    public String getDistrict() {
        return this.District;
    }

    public String getErrorCode() {
        return this.ErrorCode;
    }

    public String getErrorDesc() {
        return this.ErrorDesc;
    }

    public String getIFSCCode() {
        return this.IFSCCode;
    }

    public String getIsNACH() {
        return this.isNACH;
    }

    public String getMICR() {
        return this.MICR;
    }

    public String getState() {
        return this.State;
    }

    public String getTransferChannel() {
        return this.TransferChannel;
    }

    public void setBankName(String str) {
        this.BankName = str;
    }

    public void setBeneficiaryName(String str) {
        this.BeneficiaryName = str;
    }

    public void setBranch(String str) {
        this.Branch = str;
    }

    public void setBranchAddress(String str) {
        this.BranchAddress = str;
    }

    public void setCity(String str) {
        this.City = str;
    }

    public void setDistrict(String str) {
        this.District = str;
    }

    public void setErrorCode(String str) {
        this.ErrorCode = str;
    }

    public void setErrorDesc(String str) {
        this.ErrorDesc = str;
    }

    public void setIFSCCode(String str) {
        this.IFSCCode = str;
    }

    public void setIsNACH(String str) {
        this.isNACH = str;
    }

    public void setMICR(String str) {
        this.MICR = str;
    }

    public void setState(String str) {
        this.State = str;
    }

    public void setTransferChannel(String str) {
        this.TransferChannel = str;
    }
}
