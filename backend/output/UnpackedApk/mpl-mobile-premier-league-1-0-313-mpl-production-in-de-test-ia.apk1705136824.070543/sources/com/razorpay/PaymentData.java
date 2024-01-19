package com.razorpay;

import java.io.Serializable;
import org.json.JSONObject;

public class PaymentData implements Serializable {
    public String G__G_;
    public JSONObject R$$r_ = new JSONObject();
    public String a_$P$;
    public String d__1_;

    public final void Q_$2$(String str) {
        this.a_$P$ = str;
    }

    public final void R$$r_(String str) {
        this.G__G_ = str;
    }

    public final void a_$P$(String str) {
        this.d__1_ = str;
    }

    public JSONObject getData() {
        return this.R$$r_;
    }

    public String getExternalWallet() {
        return null;
    }

    public String getOrderId() {
        return this.d__1_;
    }

    public String getPaymentId() {
        return this.a_$P$;
    }

    public String getSignature() {
        return this.G__G_;
    }

    public String getUserContact() {
        return null;
    }

    public String getUserEmail() {
        return null;
    }

    public final void Q_$2$(JSONObject jSONObject) {
        this.R$$r_ = jSONObject;
    }
}
