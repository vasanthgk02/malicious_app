package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class d implements Serializable {
    public static final long serialVersionUID = 1;
    public String aadharNo = "";
    public String accountHolderName = "";
    public String accountNo = "";
    public String accountType = "";
    public String emailID = "";
    public String identifier = "";
    public String mobileNumber = "";
    public String pan = "";
    public String phoneNumber = "";
    public String vpa = "";

    public String getAadharNo() {
        return this.aadharNo;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getEmailID() {
        return this.emailID;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getPan() {
        return this.pan;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getVpa() {
        return this.vpa;
    }

    public void setAadharNo(String str) {
        this.aadharNo = str;
    }

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public void setAccountNo(String str) {
        this.accountNo = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setEmailID(String str) {
        this.emailID = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setPan(String str) {
        this.pan = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setVpa(String str) {
        this.vpa = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Consumer [identifier=");
        outline73.append(this.identifier);
        outline73.append(", emailID=");
        outline73.append(this.emailID);
        outline73.append(", mobileNumber=");
        outline73.append(this.mobileNumber);
        outline73.append(", accountNo=");
        outline73.append(this.accountNo);
        outline73.append(", accountHolderName=");
        outline73.append(this.accountHolderName);
        outline73.append(", aadharNo=");
        outline73.append(this.aadharNo);
        outline73.append(", accountType=");
        outline73.append(this.accountType);
        outline73.append(", vpa=");
        outline73.append(this.vpa);
        outline73.append(", pan=");
        outline73.append(this.pan);
        outline73.append(", phoneNumber=");
        return GeneratedOutlineSupport.outline62(outline73, this.phoneNumber, CMapParser.MARK_END_OF_ARRAY);
    }
}
