package com.braintreepayments.api.dropin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.dropin.R$id;
import com.braintreepayments.api.dropin.R$layout;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.List;

public class VaultedPaymentMethodsAdapter extends Adapter<ViewHolder> {
    public List<PaymentMethodNonce> mPaymentMethodNonces;
    public PaymentMethodNonceCreatedListener mSelectedListener;

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public TextView description;
        public ImageView icon;
        public TextView title;

        public ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R$id.bt_payment_method_icon);
            this.title = (TextView) view.findViewById(R$id.bt_payment_method_title);
            this.description = (TextView) view.findViewById(R$id.bt_payment_method_description);
        }
    }

    public VaultedPaymentMethodsAdapter(PaymentMethodNonceCreatedListener paymentMethodNonceCreatedListener, List<PaymentMethodNonce> list) {
        this.mSelectedListener = paymentMethodNonceCreatedListener;
        this.mPaymentMethodNonces = list;
    }

    public int getItemCount() {
        return this.mPaymentMethodNonces.size();
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final PaymentMethodNonce paymentMethodNonce = this.mPaymentMethodNonces.get(i);
        PaymentMethodType forType = PaymentMethodType.forType(paymentMethodNonce);
        viewHolder2.icon.setImageResource(forType.getVaultedDrawable());
        viewHolder2.title.setText(forType.getLocalizedName());
        if (paymentMethodNonce instanceof CardNonce) {
            TextView textView = viewHolder2.description;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("••• ••");
            outline73.append(((CardNonce) paymentMethodNonce).mLastTwo);
            textView.setText(outline73.toString());
        } else {
            viewHolder2.description.setText(paymentMethodNonce.getDescription());
        }
        viewHolder2.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                VaultedPaymentMethodsAdapter.this.mSelectedListener.onPaymentMethodNonceCreated(paymentMethodNonce);
            }
        });
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bt_vaulted_payment_method_card, viewGroup, false));
    }
}
