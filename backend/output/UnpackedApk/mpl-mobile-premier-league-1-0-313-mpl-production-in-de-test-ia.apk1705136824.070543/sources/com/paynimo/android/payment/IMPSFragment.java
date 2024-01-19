package com.paynimo.android.payment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.a.d;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.event.t;
import com.paynimo.android.payment.event.u;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.b;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.k.c;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.util.Constant;
import com.smartfoxserver.bitswarm.util.Logging;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import java.util.ArrayList;
import java.util.Date;

public class IMPSFragment extends Fragment implements OnClickListener, OnItemClickListener {
    public static final String FRAGMENT_TAG = "IMPS";
    public TextWatcher VaultedOtpTextWatcher = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
            IMPSFragment.this.vaulted_otp_imps.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("defaultTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
            if (IMPSFragment.this.vaulted_otp_imps.getText().length() >= 4 && IMPSFragment.this.vaulted_otp_imps.getText().length() <= 7) {
                if (IMPSValidator.validateOTP(IMPSFragment.this.getActivity(), IMPSFragment.this.vaulted_otp_imps)) {
                    IMPSFragment.this.quickPay.requestFocus();
                } else {
                    IMPSFragment.this.vaulted_otp_imps.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("errorTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public d adapter;
    public CheckBox checkbox_vault_imps;
    public Checkout checkoutData;
    public ViewGroup container_new_imps;
    public ViewGroup container_vault_imps;
    public b data;
    public IntfOnFragmentDataPass dataPasser;
    public ListView list;
    public a mService;
    public com.paynimo.android.payment.b.d mServiceManager;
    public EditText mmidNumber;
    public TextWatcher mmidTextWatcher = new TextWatcher() {
        public String mmidNoText;

        public void afterTextChanged(Editable editable) {
            IMPSFragment.this.mmidNumber.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("defaultTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
            String obj = IMPSFragment.this.mmidNumber.getText().toString();
            this.mmidNoText = obj;
            if (obj.length() <= 6) {
                return;
            }
            if (IMPSValidator.validateMMIDNumber(IMPSFragment.this.getActivity(), IMPSFragment.this.mmidNumber)) {
                IMPSFragment.this.otpCode.requestFocus();
            } else {
                IMPSFragment.this.mmidNumber.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("errorTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public TextWatcher mobileNoTextWatcher = new TextWatcher() {
        public String mobileNoText;

        public void afterTextChanged(Editable editable) {
            IMPSFragment.this.mobileNumber.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("defaultTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
            String obj = IMPSFragment.this.mobileNumber.getText().toString();
            this.mobileNoText = obj;
            if (obj.length() <= 9) {
                return;
            }
            if (IMPSValidator.validateMobileNumber(IMPSFragment.this.getActivity(), IMPSFragment.this.mobileNumber)) {
                IMPSFragment.this.mmidNumber.requestFocus();
            } else {
                IMPSFragment.this.mobileNumber.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("errorTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public EditText mobileNumber;
    public EditText otpCode;
    public TextWatcher otpTextWatcher = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
            IMPSFragment.this.otpCode.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("defaultTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
            if (IMPSFragment.this.otpCode.getText().length() >= 4 && IMPSFragment.this.otpCode.getText().length() <= 7) {
                if (IMPSValidator.validateOTP(IMPSFragment.this.getActivity(), IMPSFragment.this.otpCode)) {
                    IMPSFragment.this.payButton.requestFocus();
                } else {
                    IMPSFragment.this.otpCode.setTextColor(ContextCompat.getColor(IMPSFragment.this.getActivity(), IMPSFragment.this.getResources().getIdentifier("errorTextColor", "color", IMPSFragment.this.getActivity().getPackageName())));
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public Button payButton;
    public r pmiData;
    public Button quickPay;
    public RequestPayload request_payload;
    public c selectedVaultData;
    public Boolean singleModeSelected;
    public Date startTime;
    public ArrayList<c> vaultedIMPSData = new ArrayList<>();
    public EditText vaulted_otp_imps;

    private void checkIMPSDetailsAndProceed() {
        String str = this.checkbox_vault_imps.isChecked() ? "Y" : "N";
        if (IMPSValidator.validate(getActivity(), this.mobileNumber, this.mmidNumber, this.otpCode)) {
            b bVar = new b();
            bVar.setVaultConsumerInstrument(str);
            this.dataPasser.cardDataFromFragment(bVar);
            startImpsNetworkTask(this.mobileNumber.getText().toString().trim(), this.mmidNumber.getText().toString().trim(), this.otpCode.getText().toString().trim(), this.pmiData.getBanks().getImps());
            return;
        }
        Constant.showOutputLog("IMPS", " =================>> Validation Error");
    }

    public static IMPSFragment instance(Checkout checkout, r rVar, Boolean bool, c cVar) {
        IMPSFragment iMPSFragment = new IMPSFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, rVar);
        bundle.putBoolean(PaymentActivity.EXTRA_SINGLE_MODE_SELECTED, bool.booleanValue());
        bundle.putSerializable(PaymentActivity.ARGUMENT_DATA_VAULT_DATA_INFO, cVar);
        iMPSFragment.setArguments(bundle);
        return iMPSFragment;
    }

    private void openVaultDialog(View view, int i) {
        final c cVar = this.vaultedIMPSData.get(i);
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_vault_card", "layout", getActivity().getPackageName()));
        dialog.setCanceledOnTouchOutside(true);
        TextView textView = (TextView) dialog.findViewById(getResources().getIdentifier("paynimo_list_card_bankname_label", "id", getActivity().getPackageName()));
        TextView textView2 = (TextView) dialog.findViewById(getResources().getIdentifier("paynimo_list_card_cardno_label", "id", getActivity().getPackageName()));
        ImageView imageView = (ImageView) dialog.findViewById(getResources().getIdentifier("paynimo_list_card_icon", "id", getActivity().getPackageName()));
        EditText editText = (EditText) dialog.findViewById(getResources().getIdentifier("paynimo_card_vault_et_cvv", "id", getActivity().getPackageName()));
        this.vaulted_otp_imps = editText;
        editText.setHint(getActivity().getResources().getIdentifier("paynimo_imps_vaulted_otp_hint", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName()));
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_list_card_field_label", "id", getActivity().getPackageName()))).setText(getActivity().getResources().getIdentifier("paynimo_dialog_vaulted_field_imps", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName()));
        this.vaulted_otp_imps.setFilters(new InputFilter[]{new LengthFilter(6)});
        this.vaulted_otp_imps.addTextChangedListener(this.VaultedOtpTextWatcher);
        if (cVar != null) {
            String aliasName = cVar.getAliasName();
            String maskedCardNo = cVar.getMaskedCardNo();
            if (aliasName != null && !aliasName.isEmpty() && maskedCardNo != null && !maskedCardNo.isEmpty()) {
                textView.setText(aliasName);
                textView2.setText(maskedCardNo);
                imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_imps_icon", "drawable", getActivity().getPackageName()));
            }
        }
        ((ImageView) dialog.findViewById(getResources().getIdentifier("paynimo_list_vault_cancel", "id", getActivity().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Button button = (Button) dialog.findViewById(getResources().getIdentifier("paynimo_card_vault_pay_btn", "id", getActivity().getPackageName()));
        this.quickPay = button;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                IMPSFragment.this.vaulted_otp_imps.removeTextChangedListener(IMPSFragment.this.VaultedOtpTextWatcher);
                if (IMPSFragment.this.vaulted_otp_imps.getText().length() < 4 || IMPSFragment.this.vaulted_otp_imps.getText().length() > 7) {
                    IMPSFragment.this.vaulted_otp_imps.setError(IMPSFragment.this.getActivity().getString(IMPSFragment.this.getActivity().getResources().getIdentifier("paynimo_cc_invalid_otp", NetworkingModule.REQUEST_BODY_KEY_STRING, IMPSFragment.this.getActivity().getPackageName())));
                } else if (IMPSValidator.validateOTP(IMPSFragment.this.getActivity(), IMPSFragment.this.vaulted_otp_imps)) {
                    String cardId = cVar.getCardId();
                    String trim = IMPSFragment.this.vaulted_otp_imps.getText().toString().trim();
                    String trim2 = IMPSFragment.this.pmiData.getBanks().getImps().trim();
                    if (trim2 != null && !trim2.isEmpty()) {
                        IMPSFragment.this.startVaultedIMPSNetworkTask(trim2, cardId, trim);
                    }
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    private void prepareListData() {
        this.vaultedIMPSData = (ArrayList) this.pmiData.getCustomerVault().getImpsVault();
        this.adapter = new d(getActivity(), getResources().getIdentifier("paynimo_listitem_cardvaulted", "layout", getActivity().getPackageName()), this.vaultedIMPSData);
    }

    private void setListData() {
        this.list.setAdapter(this.adapter);
        LayoutParams layoutParams = this.list.getLayoutParams();
        int size = this.vaultedIMPSData.size();
        if (size > 0) {
            this.container_vault_imps.setVisibility(0);
            try {
                int dimension = ((int) getResources().getDimension(getResources().getIdentifier("paynimo_vaultedCardsRowHeight", "dimen", getActivity().getPackageName()))) + 10;
                if (size == 1) {
                    layoutParams.height = dimension * 1;
                } else if (size == 2) {
                    layoutParams.height = dimension * 2;
                } else if (size >= 3) {
                    layoutParams.height = dimension * 3;
                }
            } catch (Exception unused) {
                layoutParams.height = 0;
            }
        } else {
            layoutParams.height = 0;
            this.container_vault_imps.setVisibility(8);
        }
        this.list.setLayoutParams(layoutParams);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        ((com.paynimo.android.payment.PaymentActivity) getActivity()).showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x007e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startImpsNetworkTask(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r5 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            java.lang.String r2 = "IMPS"
            if (r9 == 0) goto L_0x00a0
            boolean r3 = r9.isEmpty()
            if (r3 != 0) goto L_0x00a0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = " ==>>  BankCode is : "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.paynimo.android.payment.util.Constant.showOutputLog(r2, r3)
            r2 = -2
            androidx.fragment.app.FragmentActivity r3 = r5.getActivity()     // Catch:{ Exception -> 0x0096 }
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r3)     // Catch:{ Exception -> 0x0096 }
            if (r3 == 0) goto L_0x0088
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            if (r3 == 0) goto L_0x00a5
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x007e }
            r3.<init>()     // Catch:{ Exception -> 0x007e }
            r5.startTime = r3     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            java.lang.String r4 = "TWI"
            r3.setTransactionRequestType(r4)     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            java.lang.String r4 = "I"
            r3.setPaymentMethodType(r4)     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            r3.setPaymentMethodToken(r9)     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r9 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            r9.setConsumerMobileNumber(r6)     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            r6.setPaymentInstrumentIdentifier(r7)     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            r6.setPaymentInstrumentVerificationCode(r8)     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            java.lang.String r7 = com.paynimo.android.payment.PaymentActivity.VaultConsumerInstrument     // Catch:{ Exception -> 0x007e }
            r6.setTransactionIsRegistration(r7)     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkoutData     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()     // Catch:{ Exception -> 0x007e }
            r5.request_payload = r6     // Catch:{ Exception -> 0x007e }
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6     // Catch:{ Exception -> 0x007e }
            r6.showProgressLoader()     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.b.d r6 = r5.mServiceManager     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.model.request.RequestPayload r7 = r5.request_payload     // Catch:{ Exception -> 0x007e }
            androidx.fragment.app.FragmentActivity r8 = r5.getActivity()     // Catch:{ Exception -> 0x007e }
            r6.callTWIRequest(r7, r8)     // Catch:{ Exception -> 0x007e }
            goto L_0x00a5
        L_0x007e:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x0096 }
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6     // Catch:{ Exception -> 0x0096 }
            r6.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x0096 }
            goto L_0x00a5
        L_0x0088:
            de.greenrobot.event.EventBus r6 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0096 }
            com.paynimo.android.payment.event.g r7 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0096 }
            r8 = 0
            r7.<init>(r8)     // Catch:{ Exception -> 0x0096 }
            r6.post(r7)     // Catch:{ Exception -> 0x0096 }
            goto L_0x00a5
        L_0x0096:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6
            r6.showAlertDialog(r2, r1, r0)
            goto L_0x00a5
        L_0x00a0:
            java.lang.String r6 = " BankCode is EMPTY or NULL"
            com.paynimo.android.payment.util.Constant.showOutputLog(r2, r6)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.IMPSFragment.startImpsNetworkTask(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        ((com.paynimo.android.payment.PaymentActivity) getActivity()).showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0085 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startVaultedIMPSNetworkTask(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            com.paynimo.android.payment.model.b r2 = new com.paynimo.android.payment.model.b
            r2.<init>()
            r3.data = r2
            r2.setConsumerInstrumentToken(r5)
            com.paynimo.android.payment.model.b r5 = r3.data
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.trim()
            r5.setConsumerInstrumentCVC(r6)
            com.paynimo.android.payment.model.b r5 = r3.data
            java.lang.String r6 = "N"
            r5.setVaultConsumerInstrument(r6)
            com.paynimo.android.payment.IntfOnFragmentDataPass r5 = r3.dataPasser
            com.paynimo.android.payment.model.b r6 = r3.data
            r5.cardDataFromFragment(r6)
            if (r4 == 0) goto L_0x00a7
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x00a7
            r5 = -2
            androidx.fragment.app.FragmentActivity r6 = r3.getActivity()     // Catch:{ Exception -> 0x009d }
            boolean r6 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r6)     // Catch:{ Exception -> 0x009d }
            if (r6 == 0) goto L_0x008f
            com.paynimo.android.payment.model.Checkout r6 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            if (r6 == 0) goto L_0x00ae
            com.paynimo.android.payment.model.Checkout r6 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            java.lang.String r2 = "TWI"
            r6.setTransactionRequestType(r2)     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.Checkout r6 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            java.lang.String r2 = "I"
            r6.setPaymentMethodType(r2)     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.Checkout r6 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            r6.setPaymentMethodToken(r4)     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.Checkout r4 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            java.lang.String r6 = com.paynimo.android.payment.PaymentActivity.ConsumerInstrumentToken     // Catch:{ Exception -> 0x0085 }
            r4.setPaymentInstrumentToken(r6)     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.Checkout r4 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            java.lang.String r6 = com.paynimo.android.payment.PaymentActivity.ConsumerInstrumentCVC     // Catch:{ Exception -> 0x0085 }
            r4.setPaymentInstrumentVerificationCode(r6)     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.Checkout r4 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            java.lang.String r6 = com.paynimo.android.payment.PaymentActivity.VaultConsumerInstrument     // Catch:{ Exception -> 0x0085 }
            r4.setTransactionIsRegistration(r6)     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.Checkout r4 = r3.checkoutData     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.request.RequestPayload r4 = r4.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0085 }
            r3.request_payload = r4     // Catch:{ Exception -> 0x0085 }
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.PaymentActivity r4 = (com.paynimo.android.payment.PaymentActivity) r4     // Catch:{ Exception -> 0x0085 }
            r4.showProgressLoader()     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.b.d r4 = r3.mServiceManager     // Catch:{ Exception -> 0x0085 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r3.request_payload     // Catch:{ Exception -> 0x0085 }
            androidx.fragment.app.FragmentActivity r2 = r3.getActivity()     // Catch:{ Exception -> 0x0085 }
            r4.callTWIRequest(r6, r2)     // Catch:{ Exception -> 0x0085 }
            goto L_0x00ae
        L_0x0085:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ Exception -> 0x009d }
            com.paynimo.android.payment.PaymentActivity r4 = (com.paynimo.android.payment.PaymentActivity) r4     // Catch:{ Exception -> 0x009d }
            r4.showAlertDialog(r5, r1, r0)     // Catch:{ Exception -> 0x009d }
            goto L_0x00ae
        L_0x008f:
            de.greenrobot.event.EventBus r4 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x009d }
            com.paynimo.android.payment.event.g r6 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x009d }
            r2 = 0
            r6.<init>(r2)     // Catch:{ Exception -> 0x009d }
            r4.post(r6)     // Catch:{ Exception -> 0x009d }
            goto L_0x00ae
        L_0x009d:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.paynimo.android.payment.PaymentActivity r4 = (com.paynimo.android.payment.PaymentActivity) r4
            r4.showAlertDialog(r5, r1, r0)
            goto L_0x00ae
        L_0x00a7:
            java.lang.String r4 = "IMPS"
            java.lang.String r5 = " BankCode is EMPTY or NULL"
            com.paynimo.android.payment.util.Constant.showOutputLog(r4, r5)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.IMPSFragment.startVaultedIMPSNetworkTask(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
        Constant.showOutputLog("============>>>>>>>>>IMPS", "onAttach");
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
        if (view.getId() == getResources().getIdentifier("paynimo_imps_pay_btn", "id", getActivity().getPackageName())) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.otpCode.getWindowToken(), 0);
            checkIMPSDetailsAndProceed();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.checkoutData = (Checkout) getArguments().getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) getArguments().getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
        this.selectedVaultData = (c) getArguments().getSerializable(PaymentActivity.ARGUMENT_DATA_VAULT_DATA_INFO);
        this.singleModeSelected = Boolean.valueOf(getArguments().getBoolean(PaymentActivity.EXTRA_SINGLE_MODE_SELECTED, false));
        a aVar = new a();
        this.mService = aVar;
        this.mServiceManager = new com.paynimo.android.payment.b.d(aVar);
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_imps", "layout", getActivity().getPackageName()), viewGroup, false);
        this.container_vault_imps = (LinearLayout) inflate.findViewById(getResources().getIdentifier("paynimo_imps_container_vault_imps", "id", getActivity().getPackageName()));
        this.container_new_imps = (LinearLayout) inflate.findViewById(getResources().getIdentifier("paynimo_imps_container_fresh_imps", "id", getActivity().getPackageName()));
        this.payButton = (Button) inflate.findViewById(getResources().getIdentifier("paynimo_imps_pay_btn", "id", getActivity().getPackageName()));
        this.list = (ListView) inflate.findViewById(getResources().getIdentifier("paynimo_list", "id", getActivity().getPackageName()));
        this.mobileNumber = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_imps_mobileNumberText", "id", getActivity().getPackageName()));
        this.mmidNumber = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_imps_mmidText", "id", getActivity().getPackageName()));
        this.otpCode = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_imps_otpCodeText", "id", getActivity().getPackageName()));
        this.checkbox_vault_imps = (CheckBox) inflate.findViewById(getResources().getIdentifier("paynimo_imps_checkbox_vault_imps", "id", getActivity().getPackageName()));
        ScrollView scrollView = (ScrollView) inflate.findViewById(getResources().getIdentifier("paynimo_imps_main_container", "id", getActivity().getPackageName()));
        this.payButton.setOnClickListener(this);
        this.list.setOnItemClickListener(this);
        this.list.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        Checkout checkout = this.checkoutData;
        if (!(checkout == null || this.pmiData == null)) {
            if (checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                scrollView.setVisibility(4);
                String isRegistration = this.checkoutData.getMerchantRequestPayload().getTransaction().getIsRegistration();
                String verificationCode = this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getVerificationCode();
                String str = this.checkoutData.getMerchantRequestPayload().getPayment().getMethod().getToken().toString();
                String mobileNumber2 = this.checkoutData.getMerchantRequestPayload().getConsumer().getMobileNumber();
                String str2 = this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier().toString();
                String str3 = this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getToken().toString();
                if (!str2.equalsIgnoreCase("") || str3.equalsIgnoreCase("")) {
                    startVaultedIMPSNetworkTask(str, str3, verificationCode);
                } else {
                    b bVar = new b();
                    this.data = bVar;
                    bVar.setConsumerInstrumentToken("");
                    this.data.setVaultConsumerInstrument(isRegistration);
                    this.dataPasser.cardDataFromFragment(this.data);
                    startImpsNetworkTask(mobileNumber2, str2, verificationCode, str);
                }
            } else {
                getActivity().findViewById(getResources().getIdentifier("imageView1", "id", getActivity().getPackageName())).setVisibility(0);
                scrollView.setVisibility(0);
                prepareListData();
                setListData();
                if (this.checkoutData.getMerchantRequestPayload().getConsumer().getIdentifier().equalsIgnoreCase("")) {
                    this.checkbox_vault_imps.setChecked(false);
                    this.checkbox_vault_imps.setEnabled(false);
                }
                if (!this.singleModeSelected.booleanValue()) {
                    c cVar = this.selectedVaultData;
                    if (cVar == null) {
                        Constant.showOutputLog("IMPS", "selectedVaultData is null");
                    } else if (cVar.getCardId().equalsIgnoreCase("")) {
                        this.container_new_imps.setVisibility(0);
                        this.container_vault_imps.setVisibility(8);
                    } else {
                        this.container_new_imps.setVisibility(4);
                        this.container_vault_imps.setVisibility(4);
                        startVaultedIMPSNetworkTask(this.selectedVaultData.getCardIssuerAuthority(), this.selectedVaultData.getCardId(), this.selectedVaultData.getAliasName());
                    }
                } else if (this.pmiData.getCustomerVault().getImpsVaultCount() > 0) {
                    this.container_new_imps.setVisibility(0);
                    this.container_vault_imps.setVisibility(0);
                } else {
                    this.container_vault_imps.setVisibility(8);
                }
            }
        }
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
        Constant.showOutputLog("==>>IMPS", "onDetach");
    }

    @Subscribe
    public void onEvent(u uVar) {
        Constant.showOutputLog("IMPS", "got IMPS response");
        ((PaymentActivity) getActivity()).hideProgressLoader();
        if (uVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TWI, "click", "button:EMISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkoutData, "EMI", "", "", Logging.TAB, this.mServiceManager, getActivity());
            Constant.showOutputLog("IMPS", uVar.getResponse().toString());
            try {
                if (uVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    this.dataPasser.sendResponseBackFromFragment(uVar.getResponse(), -1, "");
                } else {
                    ((PaymentActivity) getActivity()).transactionError(uVar.getResponse().getPaymentMethod().getError().getCode(), uVar.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception unused) {
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TWI, "click", "button:EMISubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "EMI", "", "", Logging.TAB, this.mServiceManager, getActivity());
            Constant.showOutputLog("IMPS", "Null IMPS response");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        openVaultDialog(view, i);
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>IMPS", "onPause");
        this.mobileNumber.removeTextChangedListener(this.mobileNoTextWatcher);
        this.mmidNumber.removeTextChangedListener(this.mmidTextWatcher);
        this.otpCode.removeTextChangedListener(this.otpTextWatcher);
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>IMPS", "onResume");
        this.mobileNumber.addTextChangedListener(this.mobileNoTextWatcher);
        this.mmidNumber.addTextChangedListener(this.mmidTextWatcher);
        this.otpCode.addTextChangedListener(this.otpTextWatcher);
    }

    @Subscribe
    public void onEvent(t tVar) {
        ((PaymentActivity) getActivity()).hideProgressLoader();
        com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TWI, "click", "button:EMISubmit", new Date().getTime() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "EMI", "", "", Logging.TAB, this.mServiceManager, getActivity());
        ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, tVar.getError().getDesc());
    }
}
