package com.paynimo.android.payment.model;

import com.paynimo.android.payment.model.response.k.r;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Checkout f1430a;

    /* renamed from: b  reason: collision with root package name */
    public r f1431b;

    public Checkout getCheckoutData() {
        return this.f1430a;
    }

    public r getPmiResponseData() {
        return this.f1431b;
    }

    public void setCheckoutData(Checkout checkout) {
        this.f1430a = checkout;
    }

    public void setPmiResponseData(r rVar) {
        this.f1431b = rVar;
    }
}
