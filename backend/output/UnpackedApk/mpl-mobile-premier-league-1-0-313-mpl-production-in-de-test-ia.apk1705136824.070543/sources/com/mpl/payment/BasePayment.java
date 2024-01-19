package com.mpl.payment;

import com.mpl.network.modules.engine.MHeader;
import java.util.List;

public abstract class BasePayment {
    public String mAmount;
    public String mAuth;
    public String mEmail;
    public List<MHeader> mHeaders;
    public String mNumber;
    public String mPaymentGatWay;
    public String mUrl;

    public abstract void initiatePayment();
}
