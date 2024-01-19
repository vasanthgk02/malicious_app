package com.braintreepayments.api.dropin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.braintreepayments.api.dropin.R$id;
import com.braintreepayments.api.dropin.R$layout;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import java.util.ArrayList;

public class SupportedPaymentMethodsAdapter extends BaseAdapter {
    public ArrayList<PaymentMethodType> mAvailablePaymentMethods = new ArrayList<>();
    public Context mContext;
    public PaymentMethodSelectedListener mPaymentMethodSelectedListener;

    public interface PaymentMethodSelectedListener {
        void onPaymentMethodSelected(PaymentMethodType paymentMethodType);
    }

    public SupportedPaymentMethodsAdapter(Context context, PaymentMethodSelectedListener paymentMethodSelectedListener) {
        this.mContext = context;
        this.mPaymentMethodSelectedListener = paymentMethodSelectedListener;
    }

    public int getCount() {
        return this.mAvailablePaymentMethods.size();
    }

    public Object getItem(int i) {
        return this.mAvailablePaymentMethods.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R$layout.bt_payment_method_list_item, viewGroup, false);
        }
        final PaymentMethodType paymentMethodType = this.mAvailablePaymentMethods.get(i);
        ((ImageView) view.findViewById(R$id.bt_payment_method_icon)).setImageResource(paymentMethodType.getDrawable());
        ((TextView) view.findViewById(R$id.bt_payment_method_type)).setText(this.mContext.getString(paymentMethodType.getLocalizedName()));
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SupportedPaymentMethodsAdapter.this.mPaymentMethodSelectedListener.onPaymentMethodSelected(paymentMethodType);
            }
        });
        return view;
    }
}
