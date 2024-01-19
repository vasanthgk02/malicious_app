package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class r implements Serializable {
    public static final long serialVersionUID = 1;
    public String SIEnable = "";
    public String bankSelectionAtMerchantEnd = "";
    public a banks;
    public String binValidateFlag = "";
    public String customerId = "";
    public f customerVault;
    public o error;
    public String helpdeskEmail;
    public String helpdeskNo;
    public String mandatePurpose;
    public String merchantCategoryCode = "";
    public String merchantCode = "";
    public String merchantName = "";
    public String surchargeCollectionFlag;
    @SerializedName("UPIHandlers")
    public List<Object> upiHandlers;
    public String utilityNo;

    public String getBankSelectionAtMerchantEnd() {
        return this.bankSelectionAtMerchantEnd;
    }

    public a getBanks() {
        return this.banks;
    }

    public String getBinValidateFlag() {
        return this.binValidateFlag;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public f getCustomerVault() {
        return this.customerVault;
    }

    public o getError() {
        return this.error;
    }

    public String getHelpdeskEmail() {
        return this.helpdeskEmail;
    }

    public String getHelpdeskNo() {
        return this.helpdeskNo;
    }

    public String getMandatePurpose() {
        return this.mandatePurpose;
    }

    public String getMerchantCategoryCode() {
        return this.merchantCategoryCode;
    }

    public String getMerchantCode() {
        return this.merchantCode;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getSIEnable() {
        return this.SIEnable;
    }

    public String getSurchargeCollectionFlag() {
        return this.surchargeCollectionFlag;
    }

    public List<Object> getUpiHandlers() {
        return this.upiHandlers;
    }

    public String getUtilityNo() {
        return this.utilityNo;
    }

    public void setBankSelectionAtMerchantEnd(String str) {
        this.bankSelectionAtMerchantEnd = str;
    }

    public void setBanks(a aVar) {
        this.banks = aVar;
    }

    public void setBinValidateFlag(String str) {
        this.binValidateFlag = str;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setCustomerVault(f fVar) {
        this.customerVault = fVar;
    }

    public void setError(o oVar) {
        this.error = oVar;
    }

    public void setHelpdeskEmail(String str) {
        this.helpdeskEmail = str;
    }

    public void setHelpdeskNo(String str) {
        this.helpdeskNo = str;
    }

    public void setMandatePurpose(String str) {
        this.mandatePurpose = str;
    }

    public void setMerchantCategoryCode(String str) {
        this.merchantCategoryCode = str;
    }

    public void setMerchantCode(String str) {
        this.merchantCode = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setSIEnable(String str) {
        this.SIEnable = str;
    }

    public void setSurchargeCollectionFlag(String str) {
        this.surchargeCollectionFlag = str;
    }

    public void setUpiHandlers(List<Object> list) {
        this.upiHandlers = list;
    }

    public void setUtilityNo(String str) {
        this.utilityNo = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ResponsePMI [merchantCode=");
        outline73.append(this.merchantCode);
        outline73.append(", customerId=");
        outline73.append(this.customerId);
        outline73.append(", bankSelectionAtMerchantEnd=");
        outline73.append(this.bankSelectionAtMerchantEnd);
        outline73.append(", SIEnable=");
        outline73.append(this.SIEnable);
        outline73.append(", merchantName=");
        outline73.append(this.merchantName);
        outline73.append(", merchantCategoryCode=");
        outline73.append(this.merchantCategoryCode);
        outline73.append(", mandatePurpose=");
        outline73.append(this.mandatePurpose);
        outline73.append(", utilityNo=");
        outline73.append(this.utilityNo);
        outline73.append(", helpdeskNo=");
        outline73.append(this.helpdeskNo);
        outline73.append(", helpdeskEmail=");
        outline73.append(this.helpdeskEmail);
        outline73.append(", surchargeCollectionFlag=");
        outline73.append(this.surchargeCollectionFlag);
        outline73.append(", binValidateFlag=");
        outline73.append(this.binValidateFlag);
        outline73.append(", banks=");
        outline73.append(this.banks.toString());
        outline73.append(", customerVault=");
        outline73.append(this.customerVault);
        outline73.append(", error=");
        outline73.append(this.error.toString());
        outline73.append(", upiHandlers=");
        outline73.append(this.upiHandlers.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
