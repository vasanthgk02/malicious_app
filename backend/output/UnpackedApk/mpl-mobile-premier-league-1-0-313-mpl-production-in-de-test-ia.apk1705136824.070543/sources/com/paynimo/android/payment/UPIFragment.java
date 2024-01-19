package com.paynimo.android.payment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.g;
import com.paynimo.android.payment.event.l;
import com.paynimo.android.payment.event.m;
import com.paynimo.android.payment.event.p;
import com.paynimo.android.payment.event.q;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.b;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.h;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.model.response.k.s;
import com.paynimo.android.payment.network.NetworkStateReceiver;
import com.paynimo.android.payment.util.Constant;
import com.reactnativecommunity.webview.RNCWebViewManager;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import dmax.dialog.R$style;
import dmax.dialog.SpotsDialog;
import in.juspay.hypersdk.core.InflateView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

public class UPIFragment extends Fragment implements OnClickListener {
    public static final int CALL_UPI_APPS = 10;
    public static final String CONFIG_TYPE_NUMBER = "number";
    public static final String CONFIG_TYPE_SELECT = "select";
    public static final String CONFIG_TYPE_TEXT = "text";
    public static final CharSequence CURRENCY = "currency";
    public static final String DEFAULT_MERCHANT_CODE = "5411";
    public static final String ENTER_VPA_BANK_CODE = "2010";
    public static final int ENTER_VPA_COUNT_VALUE = 27;
    public static final String FRAGMENT_TAG = "UPI";
    public static final int GOOGLE_PAY_REQUEST_CODE = 123;
    public static final String HDFC_BANK_CODE = "3090";
    public static final int MODE_APPS = 1;
    public static final int MODE_VPA = 2;
    public static final int UPI_INTENT_COUNT_VALUE = 6;
    public static final String VPA_NAME = "vpa_name";
    public static final String VPA_VALIDATION_URL = "https://www.paynimo.com/api/CommonAPI/VPAValidation";
    public AlertDialog alertDialog = null;
    public String bankName;
    public Button btnApps;
    public Button btnPay;
    public Button btnVPA;
    public Checkout checkoutData;
    public CheckBox chkSaveVPA;
    public int countDownInterval = 1000;
    public b data;
    public IntfOnFragmentDataPass dataPasser;
    public EditText edtVPA;
    public LinearLayout llPSP;
    public LinearLayout lytConfigs;
    public LinearLayout lytNote;
    public AlertDialog mLoading;
    public a mService;
    public d mServiceManager;
    public List<Object> mUpiHandlers;
    public int millisInFuture = 30000;
    public int omvCallCount = 1;
    public r pmiData;
    public int previousSelectedPosition = -1;
    public boolean rememberVault;
    public RequestPayload request_payload;
    public int selectedMode = -1;
    public String selected_bank_code = "";
    public int seleted_app_pos;
    public Spinner spnPSP;
    public Date startTime;
    public CountDownTimer timer;
    public String txnID = null;
    public TextView txtPSP;
    public GridView upiGrid;
    public String vpa = null;

    public class GetJsonTask extends AsyncTask<Void, Void, JSONObject> {
        public String URL;
        public JSONObject jsonObjSend;

        public GetJsonTask(String str, JSONObject jSONObject) {
            this.URL = str;
            this.jsonObjSend = jSONObject;
        }

        public JSONObject doInBackground(Void... voidArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.URL).openConnection()));
                httpURLConnection.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
                httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
                httpURLConnection.setRequestProperty("Accept", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
                httpURLConnection.setDoOutput(true);
                String jSONObject = this.jsonObjSend.toString();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                byte[] bytes = jSONObject.getBytes(WebViewGamesContainer.ENCODING_NAME);
                outputStream.write(bytes, 0, bytes.length);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine.trim());
                    } else {
                        System.out.println(sb.toString());
                        return new JSONObject(sb.toString());
                    }
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(JSONObject jSONObject) {
            try {
                if (jSONObject.has("status")) {
                    if (jSONObject.getString("status") != null && jSONObject.getString("status").equalsIgnoreCase(BaseParser.TRUE)) {
                        if (!UPIFragment.this.checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                            String trim = UPIFragment.this.edtVPA.getText().toString().trim();
                            if (UPIFragment.this.pmiData.getBanks().getUpi().getTopBanksCount() > 0) {
                                UPIFragment.this.selected_bank_code = UPIFragment.this.pmiData.getBanks().getUpi().getTopBanks().get(0).getBankCode();
                            } else {
                                UPIFragment.this.selected_bank_code = UPIFragment.this.pmiData.getBanks().getUpi().getOtherBanks().get(0).getBankCode();
                            }
                            UPIFragment.this.checkoutData.setConsumerVPA(trim);
                        }
                        ((InputMethodManager) UPIFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(UPIFragment.this.edtVPA.getWindowToken(), 0);
                        UPIFragment.this.callVPAFromUser(UPIFragment.this.selected_bank_code);
                        return;
                    }
                }
                if (UPIFragment.this.checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                    ((PaymentActivity) UPIFragment.this.getActivity()).transactionError(Constant.TAG_ERROR_CHECKOUT_VALIDATION_CODE, Constant.TAG_ERROR_CHECKOUT_VALIDATION);
                } else {
                    Toast.makeText(UPIFragment.this.getActivity(), "Kindly enter your registered VPA to proceed.", 0).show();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean checkIfValidVPA(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("merchantCode", this.checkoutData.getMerchantRequestPayload().getMerchant().getIdentifier());
            jSONObject.put("merchantTranId", this.checkoutData.getMerchantRequestPayload().getTransaction().getIdentifier());
            jSONObject.put("vpa_id", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new GetJsonTask(VPA_VALIDATION_URL, jSONObject).execute(new Void[0]);
        return false;
    }

    private void hideProgressBar() {
        AlertDialog alertDialog2 = this.mLoading;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.mLoading = null;
        }
    }

    public static UPIFragment instance(Checkout checkout, r rVar) {
        UPIFragment uPIFragment = new UPIFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, rVar);
        uPIFragment.setArguments(bundle);
        return uPIFragment;
    }

    /* access modifiers changed from: private */
    public void makeSVCall() {
        try {
            if (NetworkStateReceiver.isOnline(getActivity())) {
                try {
                    if (this.checkoutData != null) {
                        this.startTime = new Date();
                        Checkout checkout = new Checkout();
                        checkout.setMerchantIdentifier(this.checkoutData.getMerchantRequestPayload().getMerchant().getIdentifier());
                        checkout.setTransactionDeviceIdentifier(this.checkoutData.getMerchantRequestPayload().getTransaction().getDeviceIdentifier());
                        checkout.setTransactionAmount(this.checkoutData.getMerchantRequestPayload().getTransaction().getAmount());
                        checkout.setTransactionCurrency(this.checkoutData.getMerchantRequestPayload().getTransaction().getCurrency());
                        if (this.txnID != null) {
                            checkout.setTransactionToken(this.txnID.startsWith("TPS") ? this.txnID.replace("TPS", "") : this.txnID);
                        }
                        checkout.setTransactionDateTime(this.checkoutData.getMerchantRequestPayload().getTransaction().getDateTime());
                        checkout.setTransactionRequestType(Constant.REQUEST_TYPE_SV);
                        checkout.setConsumerIdentifier(this.checkoutData.getMerchantRequestPayload().getConsumer().getIdentifier());
                        this.request_payload = checkout.getMerchantRequestPayload();
                        if (this.selectedMode == 1) {
                            showProgressBar(false);
                        }
                        this.mServiceManager.callSVRequest(this.request_payload, getActivity());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
                }
            } else {
                EventBus.getDefault().post(new g(false));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    private void networkCallWithBankCode(String str) {
        if (str == null || str.isEmpty()) {
            Constant.showOutputLog("UPI", " BankCode is EMPTY or NULL");
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" ==>>  BankCode is : ");
        outline73.append(this.selected_bank_code);
        Constant.showOutputLog("UPI", outline73.toString());
        try {
            if (NetworkStateReceiver.isOnline(getActivity())) {
                try {
                    if (this.checkoutData != null) {
                        this.startTime = new Date();
                        this.checkoutData.setTransactionRequestType("T");
                        this.checkoutData.setPaymentMethodType("N");
                        this.checkoutData.setPaymentMethodToken(str);
                        this.request_payload = this.checkoutData.getMerchantRequestPayload();
                        ((PaymentActivity) getActivity()).showProgressLoader();
                        this.mServiceManager.callTRequest(this.request_payload, getActivity());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
                }
            } else {
                EventBus.getDefault().post(new g(false));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    private void prepareListData() {
        s upi = this.pmiData.getBanks().getUpi();
        if (upi != null) {
            int topBanksCount = upi.getTopBanksCount();
            int otherBanksCount = upi.getOtherBanksCount();
            if (topBanksCount > 0) {
                List<com.paynimo.android.payment.model.response.k.b> topBanks = upi.getTopBanks();
                if (topBanks != null) {
                    for (com.paynimo.android.payment.model.response.k.b next : topBanks) {
                        if (next != null && next.getBankCode() != null) {
                            this.selected_bank_code = next.getBankCode();
                            return;
                        }
                    }
                }
            }
            if (otherBanksCount > 0) {
                List<com.paynimo.android.payment.model.response.k.b> otherBanks = upi.getOtherBanks();
                if (otherBanks != null) {
                    Iterator<com.paynimo.android.payment.model.response.k.b> it = otherBanks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.paynimo.android.payment.model.response.k.b next2 = it.next();
                        if (next2 != null && next2.getBankCode() != null) {
                            this.selected_bank_code = next2.getBankCode();
                            break;
                        }
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
                Constant.showOutputLog("UPI", "subtype is not NET type=================>>>");
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
            getActivity().startActivityForResult(intent, 2);
        } catch (Exception unused) {
            ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    /* access modifiers changed from: private */
    public void showBackPressedDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getActivity().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_text", "id", getActivity().getPackageName()))).setText(getResources().getString(getResources().getIdentifier("paynimo_upi_back_press_dialog_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonOK", "id", getActivity().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                UPIFragment.this.getActivity().setResult(-4, new Intent());
                UPIFragment.this.getActivity().finish();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getActivity().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                UPIFragment.this.showProgressBar(true);
            }
        });
        dialog.show();
    }

    /* access modifiers changed from: private */
    public void showProgressBar(boolean z) {
        if (z) {
            SpotsDialog spotsDialog = new SpotsDialog(getActivity(), getResources().getString(getResources().getIdentifier("paynimo_loader_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())), R$style.SpotsDialogDefault, z, new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    UPIFragment.this.showBackPressedDialog();
                }
            }, null);
            this.mLoading = spotsDialog;
        } else {
            SpotsDialog spotsDialog2 = new SpotsDialog(getActivity(), getResources().getString(getResources().getIdentifier("paynimo_loader_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())), R$style.SpotsDialogDefault, z, null, null);
            this.mLoading = spotsDialog2;
        }
        this.mLoading.show();
    }

    public void callUPICreateTxn(String str) {
        try {
            if (NetworkStateReceiver.isOnline(getActivity())) {
                try {
                    if (this.checkoutData != null) {
                        this.startTime = new Date();
                        this.checkoutData.setTransactionRequestType(Constant.REQUEST_TYPE_TUI);
                        this.checkoutData.setPaymentMethodToken(str);
                        this.request_payload = this.checkoutData.getMerchantRequestPayload();
                        showProgressBar(false);
                        this.mServiceManager.callTUIRequest(this.request_payload, getActivity());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
                }
            } else {
                EventBus.getDefault().post(new g(false));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    public void callVPAFromUser(String str) {
        try {
            if (NetworkStateReceiver.isOnline(getActivity())) {
                try {
                    if (this.checkoutData != null) {
                        this.startTime = new Date();
                        this.checkoutData.setTransactionRequestType(this.rememberVault ? Constant.REQUEST_TYPE_TWUR : Constant.REQUEST_TYPE_TWU);
                        this.checkoutData.setPaymentMethodToken(str);
                        this.request_payload = this.checkoutData.getMerchantRequestPayload();
                        showProgressBar(false);
                        this.mServiceManager.callTUIRequest(this.request_payload, getActivity());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
                }
            } else {
                EventBus.getDefault().post(new g(false));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10) {
            if (i2 == -1) {
                this.millisInFuture = 10000;
                makeSVCall();
            } else if (i2 == -4) {
                AlertDialog alertDialog2 = this.mLoading;
                if (alertDialog2 != null && alertDialog2.isShowing()) {
                    hideProgressBar();
                    showProgressBar(true);
                }
            } else if (i2 == 0) {
                ((PaymentActivity) getActivity()).transactionCancelled();
            }
        } else if (i != 123) {
        } else {
            if (i2 == -1) {
                this.millisInFuture = 10000;
                makeSVCall();
            } else if (i2 == 0) {
                ((PaymentActivity) getActivity()).transactionCancelled();
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
        Constant.showOutputLog("==>>UPI", "onAttach");
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

    public void onClick(View view) {
        if (view.getId() == getResources().getIdentifier("paynimo_upi_pay_btn", "id", getActivity().getPackageName())) {
            b bVar = new b();
            this.data = bVar;
            this.dataPasser.cardDataFromFragment(bVar);
            if (this.edtVPA.getText().toString() == null || this.edtVPA.getText().toString().trim().isEmpty()) {
                Toast.makeText(getActivity(), "Kindly enter your registered VPA to proceed.", 0).show();
            } else {
                checkIfValidVPA(this.edtVPA.getText().toString().trim());
            }
        } else if (view.getId() == getResources().getIdentifier("paynimo_btn_apps", "id", getActivity().getPackageName())) {
            this.upiGrid.setVisibility(8);
            this.lytNote.setVisibility(8);
            this.selectedMode = 1;
            b bVar2 = new b();
            this.data = bVar2;
            this.dataPasser.cardDataFromFragment(bVar2);
            int topBanksCount = this.pmiData.getBanks().getMVISA().getTopBanksCount();
            if (topBanksCount > 0) {
                int i = 0;
                while (true) {
                    if (i >= topBanksCount) {
                        break;
                    }
                    com.paynimo.android.payment.model.response.k.b bVar3 = this.pmiData.getBanks().getMVISA().getTopBanks().get(i);
                    if (bVar3.getBankCode().equalsIgnoreCase("3090")) {
                        String bankCode = bVar3.getBankCode();
                        this.selected_bank_code = bankCode;
                        callUPICreateTxn(bankCode);
                        break;
                    }
                    i++;
                }
            }
            int otherBanksCount = this.pmiData.getBanks().getMVISA().getOtherBanksCount();
            if (otherBanksCount > 0) {
                for (int i2 = 0; i2 < otherBanksCount; i2++) {
                    com.paynimo.android.payment.model.response.k.b bVar4 = this.pmiData.getBanks().getMVISA().getOtherBanks().get(i2);
                    if (bVar4.getBankCode().equalsIgnoreCase("3090")) {
                        String bankCode2 = bVar4.getBankCode();
                        this.selected_bank_code = bankCode2;
                        callUPICreateTxn(bankCode2);
                        return;
                    }
                }
            }
        } else if (view.getId() == getResources().getIdentifier("paynimo_btn_VPA", "id", getActivity().getPackageName())) {
            this.upiGrid.setVisibility(8);
            this.lytNote.setVisibility(0);
            this.selectedMode = 2;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.checkoutData = (Checkout) getArguments().getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        r rVar = (r) getArguments().getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
        this.pmiData = rVar;
        this.mUpiHandlers = rVar.getUpiHandlers();
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_upi", "layout", getActivity().getPackageName()), viewGroup, false);
        this.upiGrid = (GridView) inflate.findViewById(getResources().getIdentifier("paynimo_grid_upi", "id", getActivity().getPackageName()));
        this.lytNote = (LinearLayout) inflate.findViewById(getResources().getIdentifier("paynimo_note_lyt", "id", getActivity().getPackageName()));
        this.llPSP = (LinearLayout) inflate.findViewById(getResources().getIdentifier("paynimo_ll_psp", "id", getActivity().getPackageName()));
        this.lytConfigs = (LinearLayout) inflate.findViewById(getResources().getIdentifier("paynimo_ll_configs", "id", getActivity().getPackageName()));
        this.edtVPA = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_edt_VPA", "id", getActivity().getPackageName()));
        TextView textView = (TextView) inflate.findViewById(getResources().getIdentifier("paynimo_txt_psp", "id", getActivity().getPackageName()));
        this.txtPSP = textView;
        textView.setVisibility(8);
        Spinner spinner = (Spinner) inflate.findViewById(getResources().getIdentifier("paynimo_spn_PSP", "id", getActivity().getPackageName()));
        this.spnPSP = spinner;
        spinner.setVisibility(8);
        Button button = (Button) inflate.findViewById(getResources().getIdentifier("paynimo_btn_apps", "id", getActivity().getPackageName()));
        this.btnApps = button;
        button.setVisibility(8);
        this.btnApps.setOnClickListener(this);
        this.chkSaveVPA = (CheckBox) inflate.findViewById(getResources().getIdentifier("paynimo_chk_save_vpa", "id", getActivity().getPackageName()));
        Button button2 = (Button) inflate.findViewById(getResources().getIdentifier("paynimo_btn_VPA", "id", getActivity().getPackageName()));
        this.btnVPA = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) inflate.findViewById(getResources().getIdentifier("paynimo_upi_pay_btn", "id", getActivity().getPackageName()));
        this.btnPay = button3;
        button3.setOnClickListener(this);
        SpotsDialog spotsDialog = new SpotsDialog(getActivity(), getResources().getString(getResources().getIdentifier("paynimo_loader_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())), R$style.SpotsDialogDefault, true, new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                UPIFragment.this.showBackPressedDialog();
            }
        }, null);
        this.alertDialog = spotsDialog;
        a aVar = new a();
        this.mService = aVar;
        this.mServiceManager = new d(aVar);
        Checkout checkout = this.checkoutData;
        if (!(checkout == null || this.pmiData == null)) {
            if (checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                String token = this.checkoutData.getMerchantRequestPayload().getPayment().getMethod().getToken();
                this.vpa = this.checkoutData.getMerchantRequestPayload().getConsumer().getVpa();
                if (token != null && !token.isEmpty()) {
                    this.selected_bank_code = token;
                } else if (this.pmiData.getBanks().getUpi().getTopBanksCount() > 0) {
                    this.selected_bank_code = this.pmiData.getBanks().getUpi().getTopBanks().get(0).getBankCode();
                } else {
                    this.selected_bank_code = this.pmiData.getBanks().getUpi().getOtherBanks().get(0).getBankCode();
                }
                if (this.checkoutData.getMerchantRequestPayload().getTransaction().getIsRegistration().equalsIgnoreCase("Y")) {
                    this.rememberVault = true;
                } else {
                    this.rememberVault = false;
                }
                String str = this.selected_bank_code;
                if (str == null || !str.equalsIgnoreCase("2010")) {
                    String str2 = this.selected_bank_code;
                    if (str2 != null && str2.equalsIgnoreCase("3090")) {
                        this.upiGrid.setVisibility(8);
                        this.lytNote.setVisibility(8);
                        this.selectedMode = 1;
                        b bVar = new b();
                        this.data = bVar;
                        this.dataPasser.cardDataFromFragment(bVar);
                        callUPICreateTxn(this.selected_bank_code);
                    }
                } else {
                    this.edtVPA.setText(this.vpa);
                    this.selectedMode = 2;
                    checkIfValidVPA(this.vpa);
                }
            } else {
                prepareListData();
            }
        }
        int topBanksCount = this.pmiData.getBanks().getMVISA().getTopBanksCount();
        if (topBanksCount > 0) {
            int i = 0;
            while (true) {
                if (i >= topBanksCount) {
                    break;
                } else if (this.pmiData.getBanks().getMVISA().getTopBanks().get(i).getBankCode().equalsIgnoreCase("3090")) {
                    this.btnApps.setVisibility(0);
                    break;
                } else {
                    i++;
                }
            }
        }
        int otherBanksCount = this.pmiData.getBanks().getMVISA().getOtherBanksCount();
        if (otherBanksCount > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= otherBanksCount) {
                    break;
                } else if (this.pmiData.getBanks().getMVISA().getOtherBanks().get(i2).getBankCode().equalsIgnoreCase("3090")) {
                    this.btnApps.setVisibility(0);
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (this.btnApps.getVisibility() == 8) {
            this.btnVPA.performClick();
            this.btnVPA.setVisibility(8);
        }
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
        Constant.showOutputLog("==>>UPI", "onDetach");
    }

    @Subscribe
    public void onEvent(q qVar) {
        Constant.showOutputLog("UPI", "got T response");
        hideProgressBar();
        if (qVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:UPISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog("UPI", qVar.getResponse().toString());
            try {
                if (qVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    h paymentMethod = qVar.getResponse().getPaymentMethod();
                    if (paymentMethod != null) {
                        prepareWebviewData(paymentMethod);
                    } else {
                        Constant.showOutputLog("UPI", "got NULL PaymentMethod value in T response");
                    }
                } else {
                    ((PaymentActivity) getActivity()).transactionError(qVar.getResponse().getPaymentMethod().getError().getCode(), qVar.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:UPISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog("UPI", "Null T response");
        }
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>UPI", "onPause");
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>UPI", "onResume");
    }

    @Subscribe
    public void onEvent(p pVar) {
        com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:UPISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
        hideProgressBar();
        ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, pVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.s sVar) {
        String str;
        String str2 = "TPS";
        Constant.showOutputLog("UPI", "got TWU response");
        if (this.selectedMode == 1) {
            hideProgressBar();
        }
        if (sVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging(this.rememberVault ? Constant.REQUEST_TYPE_TWUR : Constant.REQUEST_TYPE_TWU, "click", "button:UPISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog("UPI", sVar.getResponse().toString());
            try {
                if (sVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusCode().equalsIgnoreCase(PaymentActivity.TRANSACTION_STATUS_DIGITAL_MANDATE_SUCCESS)) {
                    if (this.selectedMode == 1) {
                        String str3 = null;
                        this.vpa = null;
                        String merchantAdditionalDetails = sVar.getResponse().getMerchantAdditionalDetails();
                        if (merchantAdditionalDetails != null) {
                            if (!merchantAdditionalDetails.isEmpty()) {
                                String[] split = merchantAdditionalDetails.split("\\}\\{");
                                if (split != null && split.length > 0) {
                                    for (String replace : split) {
                                        String replace2 = replace.replace("{", "").replace("}", "");
                                        if (replace2.contains(VPA_NAME)) {
                                            String[] split2 = replace2.split(":");
                                            if (split2 != null && split2.length > 0) {
                                                this.vpa = split2[1];
                                            }
                                        } else if (replace2.contains(CURRENCY)) {
                                            String[] split3 = replace2.split(":");
                                            if (split3 != null && split3.length > 0) {
                                                str3 = split3[1];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (!(sVar.getResponse().getPaymentMethod().getPaymentTransaction() == null || sVar.getResponse().getPaymentMethod().getPaymentTransaction().getIdentifier() == null || sVar.getResponse().getPaymentMethod().getPaymentTransaction().getIdentifier().isEmpty())) {
                            this.txnID = sVar.getResponse().getPaymentMethod().getPaymentTransaction().getIdentifier();
                        }
                        if (this.vpa != null && !this.vpa.isEmpty() && str3 != null && !str3.isEmpty() && this.txnID != null && !this.txnID.isEmpty()) {
                            Intent intent = new Intent(getActivity(), UPIActivity.class);
                            StringBuilder sb = new StringBuilder();
                            sb.append("upi://pay?pn=");
                            sb.append(this.pmiData.getMerchantName());
                            sb.append("&pa=");
                            sb.append(this.vpa);
                            sb.append("&mc=");
                            if (!this.pmiData.getMerchantCategoryCode().equalsIgnoreCase("0")) {
                                if (!this.pmiData.getMerchantCategoryCode().isEmpty()) {
                                    str = this.pmiData.getMerchantCategoryCode();
                                    sb.append(str);
                                    sb.append("&tr=");
                                    if (!this.txnID.startsWith(str2) || !this.selected_bank_code.equalsIgnoreCase("3090")) {
                                        str2 = "";
                                    }
                                    sb.append(str2);
                                    sb.append(this.txnID);
                                    sb.append("&am=");
                                    sb.append(this.checkoutData.getMerchantRequestPayload().getTransaction().getAmount());
                                    sb.append("&cu=");
                                    sb.append(str3);
                                    String sb2 = sb.toString();
                                    intent.putExtra(Constant.ARGUMENT_DATA_PMI_RESPONSE, this.pmiData);
                                    intent.putExtra(Constant.ARGUMENT_UPI_URI, sb2);
                                    intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.checkoutData);
                                    intent.putExtra(Constant.ARGUMENT_UPI_TXN_ID, this.txnID);
                                    startActivityForResult(intent, 10);
                                }
                            }
                            str = DEFAULT_MERCHANT_CODE;
                            sb.append(str);
                            sb.append("&tr=");
                            if (!this.txnID.startsWith(str2)) {
                            }
                            str2 = "";
                            sb.append(str2);
                            sb.append(this.txnID);
                            sb.append("&am=");
                            sb.append(this.checkoutData.getMerchantRequestPayload().getTransaction().getAmount());
                            sb.append("&cu=");
                            sb.append(str3);
                            String sb22 = sb.toString();
                            intent.putExtra(Constant.ARGUMENT_DATA_PMI_RESPONSE, this.pmiData);
                            intent.putExtra(Constant.ARGUMENT_UPI_URI, sb22);
                            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.checkoutData);
                            intent.putExtra(Constant.ARGUMENT_UPI_TXN_ID, this.txnID);
                            startActivityForResult(intent, 10);
                        }
                    } else if (this.selectedMode == 2) {
                        if (!(sVar.getResponse().getPaymentMethod().getPaymentTransaction() == null || sVar.getResponse().getPaymentMethod().getPaymentTransaction().getIdentifier() == null || sVar.getResponse().getPaymentMethod().getPaymentTransaction().getIdentifier().isEmpty())) {
                            this.txnID = sVar.getResponse().getPaymentMethod().getPaymentTransaction().getIdentifier();
                        }
                        AnonymousClass2 r1 = new CountDownTimer((long) this.millisInFuture, (long) this.countDownInterval) {
                            public void onFinish() {
                                UPIFragment.this.millisInFuture = 10000;
                                UPIFragment.this.makeSVCall();
                            }

                            public void onTick(long j) {
                            }
                        };
                        this.timer = r1.start();
                    }
                } else if (this.checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                    ((PaymentActivity) getActivity()).transactionError(sVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusCode(), sVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusMessage());
                } else {
                    Intent intent2 = new Intent();
                    Checkout checkout = new Checkout();
                    checkout.setMerchantResponsePayload(sVar.getResponse());
                    intent2.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
                    getActivity().setResult(-1, intent2);
                    if (this.alertDialog.isShowing()) {
                        try {
                            this.alertDialog.dismiss();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    getActivity().finish();
                }
            } catch (Exception unused) {
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging(this.rememberVault ? Constant.REQUEST_TYPE_TWUR : Constant.REQUEST_TYPE_TWU, "click", "button:UPISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog("UPI", "Null TWD response");
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.r rVar) {
        com.paynimo.android.payment.util.b.callEventLogging(this.rememberVault ? Constant.REQUEST_TYPE_TWUR : Constant.REQUEST_TYPE_TWU, "click", "button:UPISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
        hideProgressBar();
        ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, rVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(m mVar) {
        Constant.showOutputLog("UPI", "got SV response");
        if (mVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_SV, "svResponse", "UPI:SV", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog("UPI", mVar.getResponse().toString());
            try {
                if (!mVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusCode().equalsIgnoreCase("0396")) {
                    hideProgressBar();
                    if (mVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusCode() == null || !mVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusCode().equalsIgnoreCase("0300")) {
                        ((PaymentActivity) getActivity()).transactionError(mVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusCode(), mVar.getResponse().getPaymentMethod().getPaymentTransaction().getStatusMessage());
                        return;
                    }
                    Intent intent = new Intent();
                    Checkout checkout = new Checkout();
                    checkout.setMerchantResponsePayload(mVar.getResponse());
                    intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
                    getActivity().setResult(-1, intent);
                    getActivity().finish();
                } else if (this.selectedMode == 1) {
                    if (this.omvCallCount <= 6) {
                        this.omvCallCount++;
                        AnonymousClass3 r1 = new CountDownTimer((long) this.millisInFuture, (long) this.countDownInterval) {
                            public void onFinish() {
                                UPIFragment.this.makeSVCall();
                            }

                            public void onTick(long j) {
                            }
                        };
                        this.timer = r1.start();
                        return;
                    }
                    hideProgressBar();
                    if (this.alertDialog.isShowing()) {
                        try {
                            this.alertDialog.dismiss();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    Intent intent2 = new Intent();
                    Checkout checkout2 = new Checkout();
                    checkout2.setMerchantResponsePayload(mVar.getResponse());
                    intent2.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout2);
                    getActivity().setResult(-4, intent2);
                    getActivity().finish();
                } else if (this.selectedMode != 2) {
                } else {
                    if (this.omvCallCount <= 27) {
                        this.omvCallCount++;
                        AnonymousClass4 r12 = new CountDownTimer((long) this.millisInFuture, (long) this.countDownInterval) {
                            public void onFinish() {
                                UPIFragment.this.makeSVCall();
                            }

                            public void onTick(long j) {
                            }
                        };
                        this.timer = r12.start();
                        return;
                    }
                    hideProgressBar();
                    getActivity().setResult(0);
                    if (this.alertDialog.isShowing()) {
                        try {
                            this.alertDialog.dismiss();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    getActivity().finish();
                }
            } catch (Exception unused) {
                if (this.alertDialog.isShowing()) {
                    try {
                        this.alertDialog.dismiss();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_SV, "svResponse", "UPI:SV", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog("UPI", "Null SV response");
        }
    }

    @Subscribe
    public void onEvent(l lVar) {
        com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_SV, "svResponse", "UPI:SV", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", this.bankName, "", "", this.mServiceManager, getActivity());
        hideProgressBar();
        if (this.alertDialog.isShowing()) {
            try {
                this.alertDialog.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, lVar.getError().getDesc());
    }
}
