package com.braintreepayments.api.dropin.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.braintreepayments.api.dropin.view.PaymentMethodItemView;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.ArrayList;
import java.util.List;

public class VaultManagerPaymentMethodsAdapter extends Adapter<ViewHolder> {
    public OnClickListener mClickListener;
    public final List<PaymentMethodNonce> mPaymentMethodNonces = new ArrayList();

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public VaultManagerPaymentMethodsAdapter(OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public int getItemCount() {
        return this.mPaymentMethodNonces.size();
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        final PaymentMethodItemView paymentMethodItemView = (PaymentMethodItemView) ((ViewHolder) viewHolder).itemView;
        paymentMethodItemView.setPaymentMethod(this.mPaymentMethodNonces.get(i), true);
        paymentMethodItemView.setOnDeleteIconClick(new OnClickListener() {
            public void onClick(View view) {
                OnClickListener onClickListener = VaultManagerPaymentMethodsAdapter.this.mClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(paymentMethodItemView);
                }
            }
        });
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(new PaymentMethodItemView(viewGroup.getContext()));
    }
}
