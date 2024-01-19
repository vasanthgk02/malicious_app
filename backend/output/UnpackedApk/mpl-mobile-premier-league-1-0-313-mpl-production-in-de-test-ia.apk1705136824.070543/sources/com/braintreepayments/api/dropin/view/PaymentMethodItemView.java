package com.braintreepayments.api.dropin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.dropin.R$id;
import com.braintreepayments.api.dropin.R$layout;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.PaymentMethodNonce;

public class PaymentMethodItemView extends LinearLayout {
    public View mDeleteIcon;
    public TextView mDescription;
    public View mDivider;
    public ImageView mIcon;
    public PaymentMethodNonce mPaymentMethodNonce;
    public TextView mTitle;

    public PaymentMethodItemView(Context context) {
        super(context);
        init();
    }

    public PaymentMethodNonce getPaymentMethodNonce() {
        return this.mPaymentMethodNonce;
    }

    public final void init() {
        if (!isInEditMode()) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R$layout.bt_vault_manager_list_item, this);
            this.mIcon = (ImageView) findViewById(R$id.bt_payment_method_icon);
            this.mTitle = (TextView) findViewById(R$id.bt_payment_method_title);
            this.mDescription = (TextView) findViewById(R$id.bt_payment_method_description);
            this.mDeleteIcon = findViewById(R$id.bt_payment_method_delete_icon);
            this.mDivider = findViewById(R$id.bt_payment_method_divider);
        }
    }

    public void setOnDeleteIconClick(OnClickListener onClickListener) {
        this.mDeleteIcon.setOnClickListener(onClickListener);
    }

    public void setPaymentMethod(PaymentMethodNonce paymentMethodNonce, boolean z) {
        this.mPaymentMethodNonce = paymentMethodNonce;
        PaymentMethodType forType = PaymentMethodType.forType(paymentMethodNonce);
        if (z) {
            this.mIcon.setImageResource(forType.getDrawable());
            this.mDeleteIcon.setVisibility(0);
            this.mDivider.setVisibility(0);
        } else {
            this.mIcon.setImageResource(forType.getVaultedDrawable());
            this.mDeleteIcon.setVisibility(8);
            this.mDivider.setVisibility(8);
        }
        this.mTitle.setText(forType.getLocalizedName());
        if (paymentMethodNonce instanceof CardNonce) {
            TextView textView = this.mDescription;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("••• ••");
            outline73.append(((CardNonce) paymentMethodNonce).mLastTwo);
            textView.setText(outline73.toString());
            return;
        }
        this.mDescription.setText(paymentMethodNonce.getDescription());
    }

    public PaymentMethodItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PaymentMethodItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
