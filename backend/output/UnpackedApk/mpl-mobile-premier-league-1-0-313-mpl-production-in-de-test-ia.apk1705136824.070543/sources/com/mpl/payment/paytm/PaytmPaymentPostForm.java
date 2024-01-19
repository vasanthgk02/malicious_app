package com.mpl.payment.paytm;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public final class PaytmPaymentPostForm {
    public String amount;
    public String mobileNo;
    public String paymentMethod;

    public String getAmount() {
        return this.amount;
    }

    public String getNumber() {
        return this.mobileNo;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setNumber(String str) {
        this.mobileNo = str;
    }

    public void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PaytmPaymentPostForm{paymentMethod='");
        GeneratedOutlineSupport.outline99(outline73, this.paymentMethod, ExtendedMessageFormat.QUOTE, ", amount='");
        GeneratedOutlineSupport.outline99(outline73, this.amount, ExtendedMessageFormat.QUOTE, ", number='");
        return GeneratedOutlineSupport.outline60(outline73, this.mobileNo, ExtendedMessageFormat.QUOTE, '}');
    }
}
