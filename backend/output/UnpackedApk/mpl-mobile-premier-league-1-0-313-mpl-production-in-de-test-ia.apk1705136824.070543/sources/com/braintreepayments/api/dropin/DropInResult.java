package com.braintreepayments.api.dropin;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.interfaces.PaymentMethodNoncesUpdatedListener;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.List;

public class DropInResult implements Parcelable {
    public static final Creator<DropInResult> CREATOR = new Creator<DropInResult>() {
        public Object createFromParcel(Parcel parcel) {
            return new DropInResult(parcel);
        }

        public Object[] newArray(int i) {
            return new DropInResult[i];
        }
    };
    public String mDeviceData;
    public PaymentMethodNonce mPaymentMethodNonce;
    public PaymentMethodType mPaymentMethodType;

    /* renamed from: com.braintreepayments.api.dropin.DropInResult$2  reason: invalid class name */
    public final class AnonymousClass2 implements PaymentMethodNoncesUpdatedListener {
        public void onPaymentMethodNoncesUpdated(List<PaymentMethodNonce> list) {
            throw null;
        }
    }

    public DropInResult() {
    }

    public static void setLastUsedPaymentMethodType(Context context, PaymentMethodNonce paymentMethodNonce) {
        context.getApplicationContext().getSharedPreferences("BraintreeApi", 0).edit().putString("com.braintreepayments.api.dropin.LAST_USED_PAYMENT_METHOD_TYPE", PaymentMethodType.forType(paymentMethodNonce).getCanonicalName()).apply();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        PaymentMethodType paymentMethodType = this.mPaymentMethodType;
        parcel.writeInt(paymentMethodType == null ? -1 : paymentMethodType.ordinal());
        parcel.writeParcelable(this.mPaymentMethodNonce, i);
        parcel.writeString(this.mDeviceData);
    }

    public DropInResult(Parcel parcel) {
        PaymentMethodType paymentMethodType;
        int readInt = parcel.readInt();
        if (readInt == -1) {
            paymentMethodType = null;
        } else {
            paymentMethodType = PaymentMethodType.values()[readInt];
        }
        this.mPaymentMethodType = paymentMethodType;
        this.mPaymentMethodNonce = (PaymentMethodNonce) parcel.readParcelable(PaymentMethodNonce.class.getClassLoader());
        this.mDeviceData = parcel.readString();
    }
}
