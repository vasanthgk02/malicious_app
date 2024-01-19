package com.paynimo.android.payment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.paynimo.android.payment.a.d;
import com.paynimo.android.payment.a.f;
import com.paynimo.android.payment.event.p;
import com.paynimo.android.payment.event.q;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.util.Constant;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class CustomerVaultsFragment extends Fragment implements OnItemClickListener {
    public static final String FRAGMENT_TAG = "CashCard";
    public f adapterCard;
    public d adapterImps;
    public Checkout checkoutData;
    public IntfOnFragmentDataPass dataPasser;
    public ListView listCard;
    public ListView listImps;
    public r pmiData;

    public static CustomerVaultsFragment instance(Checkout checkout, r rVar) {
        CustomerVaultsFragment customerVaultsFragment = new CustomerVaultsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, rVar);
        customerVaultsFragment.setArguments(bundle);
        return customerVaultsFragment;
    }

    private void prepareListData() {
    }

    private void setListData() {
        this.listCard.setAdapter(this.adapterCard);
        this.listImps.setAdapter(this.adapterImps);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
        Constant.showOutputLog("==>>CashCard", "onAttach");
        try {
            this.dataPasser = (IntfOnFragmentDataPass) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(getActivity().toString() + " must implement IntfOnFragmentDataPass Interface");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.checkoutData = (Checkout) getArguments().getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) getArguments().getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_customervault", "layout", getActivity().getPackageName()), viewGroup, false);
        this.listCard = (ListView) inflate.findViewById(getResources().getIdentifier("paynimo_list", "id", getActivity().getPackageName()));
        this.listImps = (ListView) inflate.findViewById(getResources().getIdentifier("paynimo_list", "id", getActivity().getPackageName()));
        this.listCard.setOnItemClickListener(this);
        this.listImps.setOnItemClickListener(this);
        if (!(this.checkoutData == null || this.pmiData == null)) {
            prepareListData();
            setListData();
        }
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
        Constant.showOutputLog("==>>CashCard", "onDetach");
    }

    @Subscribe
    public void onEvent(q qVar) {
        Constant.showOutputLog("CashCard", "got T response");
        if (qVar.getResponse() != null) {
            Constant.showOutputLog("CashCard", qVar.getResponse().toString());
            try {
                if (!qVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    ((PaymentActivity) getActivity()).transactionError(qVar.getResponse().getPaymentMethod().getError().getCode(), qVar.getResponse().getPaymentMethod().getError().getDesc());
                } else if (qVar.getResponse().getPaymentMethod() == null) {
                    Constant.showOutputLog("CashCard", "got NULL PaymentMethod value in T response");
                }
            } catch (Exception unused) {
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            Constant.showOutputLog("CashCard", "Null T response");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>CashCard", "onPause");
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>CashCard", "onResume");
    }

    @Subscribe
    public void onEvent(p pVar) {
        ((PaymentActivity) getActivity()).transactionError(Constant.TAG_ERROR_NETWORK_ERROR_CODE, pVar.getError().getDesc());
    }
}
