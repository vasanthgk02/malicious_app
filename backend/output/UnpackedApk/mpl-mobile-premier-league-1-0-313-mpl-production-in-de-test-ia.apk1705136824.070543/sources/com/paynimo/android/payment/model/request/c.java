package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.util.Constant;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class c implements Serializable {
    public static final long serialVersionUID = 1;
    public String action = Constant.ACTION_BIN_CHECK;
    public String bank_code = "";
    public String bin;
    public String payment_instruction_action;
    public String payment_instrument_token;
    public String src_prn;
    public String submer_code;
    public String transaction_isRegistration;

    public String getAction() {
        return this.action;
    }

    public String getBank_code() {
        return this.bank_code;
    }

    public String getBin() {
        return this.bin;
    }

    public String getPayment_instruction_action() {
        return this.payment_instruction_action;
    }

    public String getPayment_instrument_token() {
        return this.payment_instrument_token;
    }

    public String getSrc_prn() {
        return this.src_prn;
    }

    public String getSubmer_code() {
        return this.submer_code;
    }

    public String getTransaction_isRegistration() {
        return this.transaction_isRegistration;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setBank_code(String str) {
        this.bank_code = str;
    }

    public void setBin(String str) {
        this.bin = str;
    }

    public void setPayment_instruction_action(String str) {
        this.payment_instruction_action = str;
    }

    public void setPayment_instrument_token(String str) {
        this.payment_instrument_token = str;
    }

    public void setSrc_prn(String str) {
        this.src_prn = str;
    }

    public void setSubmer_code(String str) {
        this.submer_code = str;
    }

    public void setTransaction_isRegistration(String str) {
        this.transaction_isRegistration = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BinCheckRequest [bin=");
        outline73.append(this.bin);
        outline73.append(", submer_code=");
        outline73.append(this.submer_code);
        outline73.append(", action=");
        outline73.append(this.action);
        outline73.append(", bank_code=");
        outline73.append(this.bank_code);
        outline73.append(", src_prn=");
        outline73.append(this.src_prn);
        outline73.append(", payment_instrument_token=");
        outline73.append(this.payment_instrument_token);
        outline73.append(", transaction_isRegistration=");
        outline73.append(this.transaction_isRegistration);
        outline73.append(", payment_instruction_action=");
        return GeneratedOutlineSupport.outline62(outline73, this.payment_instruction_action, CMapParser.MARK_END_OF_ARRAY);
    }
}
