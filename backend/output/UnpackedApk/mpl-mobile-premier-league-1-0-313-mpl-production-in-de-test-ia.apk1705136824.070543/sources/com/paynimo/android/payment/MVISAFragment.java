package com.paynimo.android.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.a.c;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.q;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.b;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.h;
import com.paynimo.android.payment.model.response.k.p;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.util.Constant;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import in.juspay.hypersdk.core.InflateView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class MVISAFragment extends Fragment implements OnItemClickListener {
    public static final String FRAGMENT_TAG = "mVISA";
    public c adapter;
    public String bankName;
    public HashMap<String, String> banksData = new HashMap<>();
    public Checkout checkoutData;
    public b data;
    public IntfOnFragmentDataPass dataPasser;
    public EditText edtSearch;
    public ListView list;
    public a mService;
    public d mServiceManager;
    public r pmiData;
    public RequestPayload request_payload;
    public String searchText;
    public String selected_bank_code = "";
    public Date startTime;

    public static MVISAFragment instance(Checkout checkout, r rVar) {
        MVISAFragment mVISAFragment = new MVISAFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, rVar);
        mVISAFragment.setArguments(bundle);
        return mVISAFragment;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        ((com.paynimo.android.payment.PaymentActivity) getActivity()).showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0066 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void networkCallWithBankCode(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            java.lang.String r2 = "mVISA"
            if (r6 == 0) goto L_0x008c
            boolean r3 = r6.isEmpty()
            if (r3 != 0) goto L_0x008c
            java.lang.String r3 = " ==>>  BankCode is : "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r4 = r5.selected_bank_code
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.paynimo.android.payment.util.Constant.showOutputLog(r2, r3)
            r2 = -2
            androidx.fragment.app.FragmentActivity r3 = r5.getActivity()     // Catch:{ Exception -> 0x007e }
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r3)     // Catch:{ Exception -> 0x007e }
            if (r3 == 0) goto L_0x0070
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x0066 }
            if (r3 == 0) goto L_0x0091
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x0066 }
            r3.<init>()     // Catch:{ Exception -> 0x0066 }
            r5.startTime = r3     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "T"
            r3.setTransactionRequestType(r4)     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "N"
            r3.setPaymentMethodType(r4)     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x0066 }
            r3.setPaymentMethodToken(r6)     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkoutData     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0066 }
            r5.request_payload = r6     // Catch:{ Exception -> 0x0066 }
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6     // Catch:{ Exception -> 0x0066 }
            r6.showProgressLoader()     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.b.d r6 = r5.mServiceManager     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r5.request_payload     // Catch:{ Exception -> 0x0066 }
            androidx.fragment.app.FragmentActivity r4 = r5.getActivity()     // Catch:{ Exception -> 0x0066 }
            r6.callTRequest(r3, r4)     // Catch:{ Exception -> 0x0066 }
            goto L_0x0091
        L_0x0066:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6     // Catch:{ Exception -> 0x007e }
            r6.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x007e }
            goto L_0x0091
        L_0x0070:
            de.greenrobot.event.EventBus r6 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.event.g r3 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x007e }
            r4 = 0
            r3.<init>(r4)     // Catch:{ Exception -> 0x007e }
            r6.post(r3)     // Catch:{ Exception -> 0x007e }
            goto L_0x0091
        L_0x007e:
            r6 = move-exception
            r6.printStackTrace()
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6
            r6.showAlertDialog(r2, r1, r0)
            goto L_0x0091
        L_0x008c:
            java.lang.String r6 = " BankCode is EMPTY or NULL"
            com.paynimo.android.payment.util.Constant.showOutputLog(r2, r6)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.MVISAFragment.networkCallWithBankCode(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void prepareListData(String str) {
        p mvisa = this.pmiData.getBanks().getMVISA();
        if (mvisa != null) {
            int topBanksCount = mvisa.getTopBanksCount();
            int otherBanksCount = mvisa.getOtherBanksCount();
            if (topBanksCount > 0) {
                com.paynimo.android.payment.model.response.k.b bVar = new com.paynimo.android.payment.model.response.k.b();
                if (otherBanksCount > 0) {
                    bVar.setBankName("Popular Banks");
                    bVar.setBankCode("");
                } else {
                    bVar.setBankName("Banks");
                    bVar.setBankCode("");
                }
                List<com.paynimo.android.payment.model.response.k.b> topBanks = mvisa.getTopBanks();
                if (topBanks != null) {
                    for (com.paynimo.android.payment.model.response.k.b next : topBanks) {
                        if (next.getBankName().equalsIgnoreCase("IMSL mVisa")) {
                            next.setBankName(FRAGMENT_TAG);
                        }
                        if (str == null || str.length() <= 0) {
                            this.adapter.addItem(next);
                        } else if (next.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                            this.adapter.addItem(next);
                        }
                        this.banksData.put(next.getBankName(), next.getBankCode());
                    }
                }
            }
            if (otherBanksCount > 0) {
                com.paynimo.android.payment.model.response.k.b bVar2 = new com.paynimo.android.payment.model.response.k.b();
                if (topBanksCount > 0) {
                    bVar2.setBankName("Other Banks");
                    bVar2.setBankCode("");
                } else {
                    bVar2.setBankName("Banks");
                    bVar2.setBankCode("");
                }
                List<com.paynimo.android.payment.model.response.k.b> otherBanks = mvisa.getOtherBanks();
                if (otherBanks != null) {
                    for (com.paynimo.android.payment.model.response.k.b next2 : otherBanks) {
                        if (next2.getBankName().equalsIgnoreCase("IMSL mVisa")) {
                            next2.setBankName(FRAGMENT_TAG);
                        }
                        if (str == null || str.length() <= 0) {
                            this.adapter.addItem(next2);
                        } else if (next2.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                            this.adapter.addItem(next2);
                        }
                        this.banksData.put(next2.getBankName(), next2.getBankCode());
                    }
                }
            }
        }
    }

    private void prepareWebviewData(h hVar) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            new ArrayList();
            String subType = hVar.getAuthentication().getSubType();
            if (subType == null || !subType.equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_NET)) {
                Constant.showOutputLog(FRAGMENT_TAG, "subtype is not NET type=================>>>");
                return;
            }
            String bankAcsUrl = hVar.getACS().getBankAcsUrl();
            if (bankAcsUrl == null || bankAcsUrl.equalsIgnoreCase("")) {
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_INVALID_URL_CODE, Constant.TAG_ERROR_INVALID_URL);
                return;
            }
            List<Map> bankAcsParams = hVar.getACS().getBankAcsParams();
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra("web_url", bankAcsUrl);
            if (bankAcsParams.size() > 0) {
                for (Map entrySet : bankAcsParams) {
                    for (Entry entry : entrySet.entrySet()) {
                        hashMap.put(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
                for (Object next : hashMap.keySet()) {
                    sb.append(next.toString() + InflateView.SETTER_EQUALS + URLEncoder.encode((String) hashMap.get(next.toString()), "UTF-8") + "&");
                }
                intent.putExtra("req_load_type", Constant.WEBVIEW_TYPE_POSTURL);
                String sb2 = sb.toString();
                intent.putExtra("req_load_type_param", sb2.substring(0, sb2.length() - 1));
            } else {
                intent.putExtra("req_load_type", Constant.WEBVIEW_TYPE_POSTURL);
                intent.putExtra("req_load_type_param", "");
            }
            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.checkoutData);
            getActivity().startActivityForResult(intent, 2);
        } catch (Exception unused) {
            ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    /* access modifiers changed from: private */
    public void setListData() {
        getActivity().findViewById(getResources().getIdentifier("imageView1", "id", getActivity().getPackageName())).setVisibility(0);
        this.edtSearch.setVisibility(0);
        this.list.setAdapter(this.adapter);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
        Constant.showOutputLog("==>>mVISA", "onAttach");
        Object activity = getActivity();
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        try {
            this.dataPasser = (IntfOnFragmentDataPass) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement IntfOnFragmentDataPass Interface");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.checkoutData = (Checkout) getArguments().getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) getArguments().getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_netbanking", "layout", getActivity().getPackageName()), viewGroup, false);
        this.searchText = "";
        EditText editText = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_et_search_bank", "id", getActivity().getPackageName()));
        this.edtSearch = editText;
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                MVISAFragment.this.adapter = new c(MVISAFragment.this.getActivity(), PaymentActivity.PAYMENT_METHOD_MVISA);
                MVISAFragment.this.searchText = editable.toString();
                MVISAFragment mVISAFragment = MVISAFragment.this;
                mVISAFragment.prepareListData(mVISAFragment.searchText);
                MVISAFragment.this.setListData();
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.list = (ListView) inflate.findViewById(getResources().getIdentifier("paynimo_list", "id", getActivity().getPackageName()));
        this.adapter = new c(getActivity(), PaymentActivity.PAYMENT_METHOD_MVISA);
        a aVar = new a();
        this.mService = aVar;
        this.mServiceManager = new d(aVar);
        this.list.setOnItemClickListener(this);
        Checkout checkout = this.checkoutData;
        if (!(checkout == null || this.pmiData == null)) {
            String token = checkout.getMerchantRequestPayload().getPayment().getMethod().getToken();
            if (this.checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                networkCallWithBankCode(token);
            } else {
                prepareListData(this.searchText);
                setListData();
            }
        }
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
        Constant.showOutputLog("==>>mVISA", "onDetach");
    }

    @Subscribe
    public void onEvent(q qVar) {
        Constant.showOutputLog(FRAGMENT_TAG, "got T response");
        ((PaymentActivity) getActivity()).hideProgressLoader();
        if (qVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:PaywithQRcodeSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkoutData, PaymentActivity.PAYMENT_METHOD_MVISA, this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog(FRAGMENT_TAG, qVar.getResponse().toString());
            try {
                if (qVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    h paymentMethod = qVar.getResponse().getPaymentMethod();
                    if (paymentMethod != null) {
                        prepareWebviewData(paymentMethod);
                    } else {
                        Constant.showOutputLog(FRAGMENT_TAG, "got NULL PaymentMethod value in T response");
                    }
                } else {
                    ((PaymentActivity) getActivity()).transactionError(qVar.getResponse().getPaymentMethod().getError().getCode(), qVar.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:PaywithQRcodeSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, PaymentActivity.PAYMENT_METHOD_MVISA, this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog(FRAGMENT_TAG, "Null T response");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = new b();
        this.data = bVar;
        this.dataPasser.cardDataFromFragment(bVar);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.edtSearch.getWindowToken(), 0);
        String charSequence = ((TextView) view.findViewById(getResources().getIdentifier("paynimo_list_pm_text_label", "id", getActivity().getPackageName()))).getText().toString();
        this.bankName = charSequence;
        if (this.banksData.containsKey(charSequence)) {
            String str = this.banksData.get(this.bankName);
            this.selected_bank_code = str;
            networkCallWithBankCode(str);
            return;
        }
        Constant.showOutputLog(FRAGMENT_TAG, " HashMap does not contain the BANK NAME");
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>mVISA", "onPause");
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>mVISA", "onResume");
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.p pVar) {
        ((PaymentActivity) getActivity()).hideProgressLoader();
        com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:PaywithQRcodeSubmit", new Date().getTime() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, PaymentActivity.PAYMENT_METHOD_MVISA, this.bankName, "", "", this.mServiceManager, getActivity());
        ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, pVar.getError().getDesc());
    }
}
