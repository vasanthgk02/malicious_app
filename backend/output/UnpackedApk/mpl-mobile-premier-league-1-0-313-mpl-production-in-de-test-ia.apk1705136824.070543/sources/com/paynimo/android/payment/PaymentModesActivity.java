package com.paynimo.android.payment;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.CardTypeParser.CardType;
import com.paynimo.android.payment.a.e;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.a0;
import com.paynimo.android.payment.event.b0;
import com.paynimo.android.payment.event.c0;
import com.paynimo.android.payment.event.g;
import com.paynimo.android.payment.event.i;
import com.paynimo.android.payment.event.v;
import com.paynimo.android.payment.event.x;
import com.paynimo.android.payment.event.y;
import com.paynimo.android.payment.event.z;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.a;
import com.paynimo.android.payment.model.request.Item;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.request.k;
import com.paynimo.android.payment.model.response.h;
import com.paynimo.android.payment.model.response.k.c;
import com.paynimo.android.payment.model.response.k.f;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.network.NetworkStateReceiver;
import com.paynimo.android.payment.util.Constant;
import com.paynimo.android.payment.util.Validation;
import com.paynimo.android.payment.util.b;
import com.xiaomi.mipush.sdk.Constants;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import in.juspay.hypersdk.core.InflateView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class PaymentModesActivity extends EventedBaseActivity implements OnItemClickListener, OnClickListener, OnItemSelectedListener {
    public static final String ENTER_VPA_BANK_CODE = "2010";
    public static final String HDFC_BANK_CODE = "3090";
    public static final Boolean SINGLE_PAYMENT_MODE_OFF = Boolean.FALSE;
    public static final Boolean SINGLE_PAYMENT_MODE_ON = Boolean.TRUE;
    public static final String STATUS_SUCCESS = "0300";
    public static final String VAULT_ROW_DATA = "vaultedRowData";
    public static final String VAULT_ROW_TEXT = "vaultedRowText";
    public static final String VAULT_ROW_TYPE = "vaultedRowType";
    public static final String VAULT_TYPE_CARDS = "vaultedCards";
    public static final String VAULT_TYPE_HEADERS = "vaultedHeaders";
    public static final String VAULT_TYPE_IMPS = "vaultedImps";
    public static final String VAULT_TYPE_OTHER_OPTIONS = "otherOptions";
    public static Context application_context;
    public static boolean isSIEnabledFromMerchant;
    public static Context myContext;
    public String TAG = "PaymentModesActivity";
    public TextWatcher VaultedOtpTextWatcher;
    public Context activitycontxt = this;
    public Calendar cal;
    public String cardDataType = "";
    public CardType cardType = CardType.YetUnknown;
    public Checkout checkout;
    public RetainedFragment dataFragment;
    public a dataObject;
    public int day;
    public int default_cvv_digit = 2;
    public String inputCardType;
    public boolean isCardBinValid;
    public boolean isDataLoaded = false;
    public boolean isDialogShown = false;
    public Boolean isSIEnabledFromMerchantScreeen;
    public Boolean isSINonEditableViewVisible;
    public boolean isTxnMerchantInitiated = false;
    public String issuer;
    public e listMultipleRowAdapter;
    public ListView listVaulted;
    public com.paynimo.android.payment.b.a mService;
    public d mServiceManager;
    public int month;
    public ArrayList<String> payment_enabled_modes_list = new ArrayList<>();
    public com.paynimo.android.payment.model.response.k.a pmiBanks;
    public String publickey = "";
    public Button quickPay;
    public RequestPayload request_payload;
    public String requestedPaymentMethod;
    public Checkout savedCheckout;
    public Settings settingsData;
    public Date startTime;
    public TextView tv_amount;
    public TextView tv_amount_text;
    public List<HashMap<String, Object>> vaultedDataList = new ArrayList();
    public int vaulted_cvv_digit = 2;
    public TextWatcher vaultedvalidationTextWatcher;
    public EditText verification_saved_card;
    public ViewGroup vg_content_container;
    public WebView webView;
    public int year;

    public static class Factory {
        public static Intent getAuthorizationIntent(Context context, boolean z) {
            PaymentModesActivity.application_context = context.getApplicationContext();
            Settings settings = new Settings();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.ARGUMENT_DATA_SETTING, settings);
            Intent intent = new Intent(context, PaymentModesActivity.class);
            intent.putExtras(bundle);
            return intent;
        }
    }

    public static class Settings implements Parcelable {
        public static final Creator<Settings> CREATOR = new Creator<Settings>() {
            public Settings createFromParcel(Parcel parcel) {
                return new Settings(parcel);
            }

            public Settings[] newArray(int i) {
                return new Settings[i];
            }
        };
        public String accountHolder;
        public String accountNumber;
        public String bankNumber;
        public HashSet<CardType> cardTypes = new HashSet<>();
        public String cardnumber;
        public String directDebitCountry;
        public String expiryMonth;
        public String expiryYear;
        public boolean safeStoreEnabled;
        public String verification;

        static {
            Context context = PaymentModesActivity.application_context;
            if (context != null) {
                CardTypeParser.setContext(context);
            } else if (PaymentModesActivity.myContext != null) {
                Context access$1700 = PaymentModesActivity.myContext;
                PaymentModesActivity.application_context = access$1700;
                CardTypeParser.setContext(access$1700);
            }
        }

        public Settings() {
            CardTypeParser.setContext(PaymentModesActivity.application_context);
            this.cardTypes.add(CardType.Visa);
            this.cardTypes.add(CardType.Rupay);
            this.cardTypes.add(CardType.Maestro);
            this.cardTypes.add(CardType.MasterCard);
            this.cardTypes.add(CardType.AmericanExpress);
            this.cardTypes.add(CardType.DinersClub);
            this.cardTypes.add(CardType.Discover);
            this.cardTypes.add(CardType.UnionPay);
            this.cardTypes.add(CardType.JCB);
        }

        private void checkValidCardType(CardType cardType) {
            if (cardType == CardType.Invalid || cardType == CardType.YetUnknown) {
                throw new IllegalArgumentException(cardType + " cannot be enabled!");
            }
        }

        public int describeContents() {
            return 0;
        }

        public void disableCreditCardType(CardType cardType) {
            this.cardTypes.remove(cardType);
        }

        public void disableDirectDebit() {
            setDirectDebitCountry(null);
        }

        public void enableCreditCardType(CardType cardType) {
            this.cardTypes.add(cardType);
        }

        public String getAccountHolder() {
            return this.accountHolder;
        }

        public String getAccountNumber() {
            return this.accountNumber;
        }

        public Collection<CardType> getAllowedCardTypes() {
            return this.cardTypes;
        }

        public String getBankNumber() {
            return this.bankNumber;
        }

        public String getCardNumber() {
            return this.cardnumber;
        }

        public HashSet<CardType> getCardTypes() {
            return this.cardTypes;
        }

        public String getDirectDebitCountry() {
            return this.directDebitCountry;
        }

        public String getExpiryMonth() {
            return this.expiryMonth;
        }

        public String getExpiryYear() {
            return this.expiryYear;
        }

        public String getVerification() {
            return this.verification;
        }

        public boolean isCreditCardPaymentAllowed() {
            return this.cardTypes.size() > 0;
        }

        public boolean isDirectDebitPaymentAllowed() {
            return this.directDebitCountry != null;
        }

        public boolean isSafeStoreEnabled() {
            return this.safeStoreEnabled;
        }

        public void setCreditCardPredefinedData(String str, String str2, String str3, String str4, String str5) {
            this.accountHolder = str;
            this.cardnumber = str2;
            this.expiryMonth = str3;
            this.expiryYear = str4;
            this.verification = str5;
        }

        public void setDirectDebitCountry(String str) {
            this.directDebitCountry = str;
        }

        public void setDirectDebitPredefinedData(String str, String str2, String str3) {
            this.accountHolder = str;
            this.accountNumber = str2;
            this.bankNumber = str3;
        }

        public void setSafeStoreEnabled(boolean z) {
            this.safeStoreEnabled = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.accountHolder);
            parcel.writeString(this.cardnumber);
            parcel.writeString(this.expiryMonth);
            parcel.writeString(this.expiryYear);
            parcel.writeString(this.verification);
            parcel.writeString(this.accountNumber);
            parcel.writeString(this.bankNumber);
            parcel.writeByte(this.safeStoreEnabled ? (byte) 1 : 0);
            parcel.writeString(this.directDebitCountry);
            parcel.writeSerializable(this.cardTypes);
        }

        public Settings(CardType... cardTypeArr) {
            for (CardType cardType : cardTypeArr) {
                checkValidCardType(cardType);
                this.cardTypes.add(cardType);
            }
        }

        public Settings(String str) {
            this.directDebitCountry = str;
        }

        public Settings(Parcel parcel) {
            this.accountHolder = parcel.readString();
            this.cardnumber = parcel.readString();
            this.expiryMonth = parcel.readString();
            this.expiryYear = parcel.readString();
            this.verification = parcel.readString();
            this.accountNumber = parcel.readString();
            this.bankNumber = parcel.readString();
            this.safeStoreEnabled = parcel.readByte() != 0;
            this.directDebitCountry = parcel.readString();
            this.cardTypes = (HashSet) parcel.readSerializable();
        }
    }

    public PaymentModesActivity() {
        Boolean bool = Boolean.FALSE;
        this.isSINonEditableViewVisible = bool;
        this.isSIEnabledFromMerchantScreeen = bool;
        this.vaultedvalidationTextWatcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                try {
                    if (PaymentModesActivity.this.verification_saved_card.getText().toString().length() > PaymentModesActivity.this.vaulted_cvv_digit) {
                        PaymentModesActivity.this.quickPay.requestFocus();
                    }
                } catch (Exception unused) {
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                EditText access$000 = PaymentModesActivity.this.verification_saved_card;
                PaymentModesActivity paymentModesActivity = PaymentModesActivity.this;
                access$000.setTextColor(ContextCompat.getColor(paymentModesActivity, paymentModesActivity.getResources().getIdentifier("defaultTextColor", "color", PaymentModesActivity.this.getApplicationContext().getPackageName())));
            }
        };
        this.VaultedOtpTextWatcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                EditText access$000 = PaymentModesActivity.this.verification_saved_card;
                PaymentModesActivity paymentModesActivity = PaymentModesActivity.this;
                access$000.setTextColor(ContextCompat.getColor(paymentModesActivity, paymentModesActivity.getResources().getIdentifier("defaultTextColor", "color", PaymentModesActivity.this.getApplicationContext().getPackageName())));
                if (PaymentModesActivity.this.verification_saved_card.getText().length() >= 4 && PaymentModesActivity.this.verification_saved_card.getText().length() <= 7) {
                    if (IMPSValidator.validateOTP(PaymentModesActivity.this.getApplicationContext(), PaymentModesActivity.this.verification_saved_card)) {
                        PaymentModesActivity.this.quickPay.requestFocus();
                        return;
                    }
                    EditText access$0002 = PaymentModesActivity.this.verification_saved_card;
                    PaymentModesActivity paymentModesActivity2 = PaymentModesActivity.this;
                    access$0002.setTextColor(ContextCompat.getColor(paymentModesActivity2, paymentModesActivity2.getResources().getIdentifier("errorTextColor", "color", PaymentModesActivity.this.getApplicationContext().getPackageName())));
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    private Boolean ValidateBankCode(String str) {
        return Boolean.valueOf(!str.equalsIgnoreCase(""));
    }

    private void callTarRequest(String str, String str2) {
        int i;
        String str3;
        String str4;
        try {
            if (NetworkStateReceiver.isOnline(this.activitycontxt)) {
                try {
                    Checkout checkout2 = this.checkout;
                    if (checkout2 != null) {
                        Constant.showOutputLog(this.TAG, " Start TAR response");
                        Checkout checkout3 = this.checkout;
                        Checkout checkout4 = checkout2;
                        d dVar = this.mServiceManager;
                        str4 = Constant.TAG_ERROR_DEFAULT_ERROR;
                        i = -2;
                        try {
                            b.callEventLogging("", "txnResponse", "txnResponse:received", 0, "PASS", checkout3, "", "", "", "", dVar, this);
                            this.startTime = new Date();
                            Checkout checkout5 = checkout4;
                            checkout5.setTransactionRequestType(Constant.REQUEST_TYPE_TAR);
                            checkout5.setTransactionDescription(str);
                            this.request_payload = checkout5.getMerchantRequestPayload();
                            showProgressLoader();
                            this.mServiceManager.callUserTARRequest(this.request_payload, this.activitycontxt);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                    str4 = Constant.TAG_ERROR_DEFAULT_ERROR;
                    i = -2;
                    str3 = str4;
                    try {
                        showAlertDialog(i, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, str3);
                    } catch (Exception unused3) {
                        showAlertDialog(i, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, str3);
                    }
                }
            } else {
                Object obj = Constant.TAG_ERROR_DEFAULT_ERROR;
                EventBus.getDefault().post(new g(false));
            }
        } catch (Exception unused4) {
            str3 = Constant.TAG_ERROR_DEFAULT_ERROR;
            i = -2;
            showAlertDialog(i, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, str3);
        }
    }

    public static Object getKeyFromValue(Map map, Object obj) {
        for (Object next : map.keySet()) {
            if (map.get(next).equals(obj)) {
                return next;
            }
        }
        return null;
    }

    private void hideProgressLoader() {
        findViewById(getResources().getIdentifier("application_header", "id", getPackageName())).setVisibility(0);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(8);
    }

    private void initialiseView() {
        ListView listView = (ListView) findViewById(getResources().getIdentifier("paynimo_list_payment_vaulted_modes", "id", getApplicationContext().getPackageName()));
        this.listVaulted = listView;
        listView.setVisibility(8);
        this.tv_amount = (TextView) findViewById(getResources().getIdentifier("paynimo_tv_payment_mode_amount", "id", getApplicationContext().getPackageName()));
        this.tv_amount_text = (TextView) findViewById(getResources().getIdentifier("paynimo_tv_amount_text", "id", getApplicationContext().getPackageName()));
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), getResources().getString(getResources().getIdentifier("paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())));
        this.vg_content_container = (ViewGroup) findViewById(getResources().getIdentifier("paynimo_content_container", "id", getApplicationContext().getPackageName()));
        this.tv_amount_text.setTypeface(createFromAsset);
        this.tv_amount_text.setText(getResources().getIdentifier("paynimo_payment_mode_amount_rupee_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName()));
        this.webView = (WebView) findViewById(getResources().getIdentifier("paynimo_webview", "id", getPackageName()));
    }

    private boolean isInvalidAadharNumber(Checkout checkout2) {
        if (!this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING) || !GeneratedOutlineSupport.outline107(checkout2, "Y") || checkout2.getMerchantRequestPayload().getConsumer().getAadharNo() == null || checkout2.getMerchantRequestPayload().getConsumer().getAadharNo().isEmpty()) {
            return false;
        }
        return !com.paynimo.android.payment.util.d.validateAadharNumber(checkout2.getMerchantRequestPayload().getConsumer().getAadharNo().trim());
    }

    private boolean isInvalidAccName(Checkout checkout2) {
        if (!this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING) || !GeneratedOutlineSupport.outline107(checkout2, "Y") || checkout2.getMerchantRequestPayload().getConsumer().getAccountHolderName() == null || checkout2.getMerchantRequestPayload().getConsumer().getAccountHolderName().isEmpty()) {
            return false;
        }
        return !com.paynimo.android.payment.util.d.validateAccHolderName(this, checkout2.getMerchantRequestPayload().getConsumer().getAccountHolderName().trim());
    }

    private boolean isInvalidAccNo(Checkout checkout2) {
        if (!this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING) || !GeneratedOutlineSupport.outline107(checkout2, "Y") || checkout2.getMerchantRequestPayload().getConsumer().getAccountNo() == null || checkout2.getMerchantRequestPayload().getConsumer().getAccountNo().isEmpty()) {
            return false;
        }
        return !com.paynimo.android.payment.util.d.validateAccountNo(this, checkout2.getMerchantRequestPayload().getConsumer().getAccountNo().trim());
    }

    private boolean isInvalidIFSC(Checkout checkout2) {
        if (!this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING) || !GeneratedOutlineSupport.outline107(checkout2, "Y") || checkout2.getMerchantRequestPayload().getPayment().getInstrument().getiFSC() == null || checkout2.getMerchantRequestPayload().getPayment().getInstrument().getiFSC().isEmpty()) {
            return false;
        }
        return !com.paynimo.android.payment.util.d.validateIFSC(this, checkout2.getMerchantRequestPayload().getPayment().getInstrument().getiFSC().trim());
    }

    private boolean isMerchantSpecificDataValid(String str) {
        Boolean bool;
        if (str.equalsIgnoreCase("All")) {
            bool = Boolean.FALSE;
        } else {
            boolean z = true;
            if (str.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CARDS)) {
                if (!this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getToken().isEmpty() || this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier().isEmpty()) {
                    if (!this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier().equalsIgnoreCase("") || this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getToken().equalsIgnoreCase("")) {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                } else {
                    bool = Boolean.valueOf(CardValidator.luhnCheck(this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier()));
                }
            } else if (str.equalsIgnoreCase("IMPS")) {
                String token = this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getToken();
                String mobileNumber = this.checkout.getMerchantRequestPayload().getConsumer().getMobileNumber();
                String token2 = this.checkout.getMerchantRequestPayload().getPayment().getMethod().getToken();
                String verificationCode = this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getVerificationCode();
                if (IMPSValidator.validateIsEmpty(token) || IMPSValidator.validateIsEmpty(mobileNumber) || IMPSValidator.validateIsEmpty(token2) || IMPSValidator.validateIsEmpty(verificationCode)) {
                    if (IMPSValidator.validateIsEmpty(token) || IMPSValidator.validateIsEmpty(token2) || IMPSValidator.validateIsEmpty(verificationCode)) {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                } else {
                    boolean z2 = token.length() == 7 && Validation.isNumericData(token).booleanValue() && Validation.isValidMobileNo(mobileNumber).booleanValue();
                    if (verificationCode.length() != 6 || !Validation.isOTPString(verificationCode, String.valueOf(3), String.valueOf(6)).booleanValue() || !z2) {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                }
            } else if (str.equalsIgnoreCase("UPI")) {
                String token3 = this.checkout.getMerchantRequestPayload().getPayment().getMethod().getToken();
                this.checkout.getMerchantRequestPayload().getConsumer().getAccountNo();
                String vpa = this.checkout.getMerchantRequestPayload().getConsumer().getVpa();
                if (token3 == null || !ValidateBankCode(token3).booleanValue()) {
                    bool = Boolean.FALSE;
                } else if (!token3.equalsIgnoreCase("2010")) {
                    bool = Boolean.TRUE;
                } else if (vpa == null || vpa.isEmpty()) {
                    bool = Boolean.FALSE;
                } else {
                    bool = Boolean.TRUE;
                }
            } else {
                bool = ValidateBankCode(this.checkout.getMerchantRequestPayload().getPayment().getMethod().getToken());
            }
        }
        return bool.booleanValue();
    }

    private void loadSettings(Bundle bundle) {
        this.settingsData = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
    }

    private void openRequestedFragment(String str, c cVar, Boolean bool) {
        Checkout checkoutData = this.dataFragment.getData().getCheckoutData();
        r pmiResponseData = this.dataFragment.getData().getPmiResponseData();
        if (pmiResponseData != null && checkoutData != null && str.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_DIGITALMANDATE)) {
            Intent authorizationIntent = com.paynimo.android.payment.DigitalMandateActivity.Factory.getAuthorizationIntent(getApplicationContext(), true);
            authorizationIntent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkoutData);
            authorizationIntent.putExtra(Constant.ARGUMENT_DATA_PMI_RESPONSE, pmiResponseData);
            authorizationIntent.putExtra(PaymentActivity.EXTRA_REQUESTED_PAYMENT_MODE, str);
            startActivityForResult(authorizationIntent, PaymentActivity.REQUEST_CODE);
        } else if (pmiResponseData == null || checkoutData == null || str.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_DIGITALMANDATE)) {
            Constant.showOutputLog(this.TAG, " PaymentActivity Extras is Null!");
            transactionError(Constant.TAG_ERROR_REQUEST_PAYMENT_MODE_CODE, Constant.TAG_ERROR_REQUEST_PAYMENT_MODE);
        } else {
            Intent authorizationIntent2 = com.paynimo.android.payment.PaymentActivity.Factory.getAuthorizationIntent(getApplicationContext(), true);
            authorizationIntent2.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkoutData);
            authorizationIntent2.putExtra(Constant.ARGUMENT_DATA_PMI_RESPONSE, pmiResponseData);
            authorizationIntent2.putExtra(PaymentActivity.ARGUMENT_DATA_VAULT_DATA_INFO, cVar);
            authorizationIntent2.putExtra(PaymentActivity.EXTRA_PUBLIC_KEY, this.publickey);
            authorizationIntent2.putExtra(PaymentActivity.EXTRA_REQUESTED_PAYMENT_MODE, str);
            authorizationIntent2.putExtra(PaymentActivity.EXTRA_SINGLE_MODE_SELECTED, bool);
            startActivityForResult(authorizationIntent2, PaymentActivity.REQUEST_CODE);
        }
    }

    private void openVaultDialog(String str, c cVar) {
        ArrayAdapter arrayAdapter;
        ViewGroup viewGroup;
        String str2 = str;
        c cVar2 = cVar;
        String str3 = "drawable";
        if (!str2.equalsIgnoreCase(VAULT_TYPE_CARDS) || this.isDialogShown) {
            String str4 = "paynimo_card_si_non_edit_container";
            String str5 = "id";
            c cVar3 = cVar2;
            if (str2.equalsIgnoreCase(VAULT_TYPE_IMPS) && !this.isDialogShown) {
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(1);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                dialog.setContentView(getResources().getIdentifier("paynimo_dialog_vault_card", "layout", getApplicationContext().getPackageName()));
                dialog.setCanceledOnTouchOutside(true);
                TextView textView = (TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_bankname_label", str5, dialog);
                TextView textView2 = (TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_cardno_label", str5, dialog);
                ImageView imageView = (ImageView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_icon", str5, dialog);
                EditText editText = (EditText) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_card_vault_et_cvv", str5, dialog);
                this.verification_saved_card = editText;
                editText.setOnEditorActionListener(new OnEditorActionListener() {
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if ((keyEvent != null && keyEvent.getKeyCode() == 66) || i == 6) {
                            PaymentModesActivity.this.quickPay.setPressed(true);
                            PaymentModesActivity.this.quickPay.invalidate();
                            PaymentModesActivity.this.quickPay.performClick();
                        }
                        return false;
                    }
                });
                this.verification_saved_card.setHint(getApplicationContext().getResources().getIdentifier("paynimo_imps_vaulted_otp_hint", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName()));
                ((TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_field_label", str5, dialog)).setText(getApplicationContext().getResources().getIdentifier("paynimo_dialog_vaulted_field_imps", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName()));
                GeneratedOutlineSupport.outline20(this, getResources(), "lyt_paynimo_si", str5, dialog).setVisibility(8);
                GeneratedOutlineSupport.outline20(this, getResources(), str4, str5, dialog).setVisibility(8);
                GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_card_si_container", str5, dialog).setVisibility(8);
                this.verification_saved_card.setFilters(new InputFilter[]{new LengthFilter(6)});
                this.verification_saved_card.addTextChangedListener(this.VaultedOtpTextWatcher);
                final c cVar4 = cVar;
                if (cVar4 != null) {
                    String aliasName = cVar.getAliasName();
                    String maskedCardNo = cVar.getMaskedCardNo();
                    if (aliasName != null && !aliasName.isEmpty() && maskedCardNo != null && !maskedCardNo.isEmpty()) {
                        textView.setText(aliasName);
                        textView2.setText(maskedCardNo);
                        imageView.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_imps_icon", str3, getApplicationContext().getPackageName()));
                    }
                }
                ((ImageView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_vault_cancel", str5, dialog)).setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        PaymentModesActivity.this.verification_saved_card.removeTextChangedListener(PaymentModesActivity.this.vaultedvalidationTextWatcher);
                        ((InputMethodManager) PaymentModesActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(PaymentModesActivity.this.verification_saved_card.getWindowToken(), 0);
                        PaymentModesActivity.this.isDialogShown = false;
                        dialog.dismiss();
                    }
                });
                Button button = (Button) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_card_vault_pay_btn", str5, dialog);
                this.quickPay = button;
                button.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        PaymentModesActivity.this.verification_saved_card.removeTextChangedListener(PaymentModesActivity.this.VaultedOtpTextWatcher);
                        if (PaymentModesActivity.this.verification_saved_card.getText().length() < 4 || PaymentModesActivity.this.verification_saved_card.getText().length() > 7) {
                            PaymentModesActivity.this.verification_saved_card.setError(PaymentModesActivity.this.getApplicationContext().getString(PaymentModesActivity.this.getApplicationContext().getResources().getIdentifier("paynimo_cc_invalid_otp", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getApplicationContext().getPackageName())));
                        } else if (IMPSValidator.validateOTP(PaymentModesActivity.this.getApplicationContext(), PaymentModesActivity.this.verification_saved_card)) {
                            ((InputMethodManager) PaymentModesActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(PaymentModesActivity.this.verification_saved_card.getWindowToken(), 0);
                            String cardId = cVar4.getCardId();
                            String trim = PaymentModesActivity.this.verification_saved_card.getText().toString().trim();
                            String trim2 = PaymentModesActivity.this.pmiBanks.getImps().trim();
                            if (trim2 != null && !trim2.isEmpty()) {
                                PaymentModesActivity.this.prepareVaultedIMPSPayment(trim2, cardId, trim);
                            }
                            PaymentModesActivity.this.isDialogShown = false;
                            dialog.dismiss();
                        }
                    }
                });
                dialog.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        if (PaymentModesActivity.this.isDialogShown) {
                            PaymentModesActivity.this.isDialogShown = false;
                        }
                    }
                });
                this.isDialogShown = true;
                dialog.setCanceledOnTouchOutside(false);
                ((InputMethodManager) getSystemService("input_method")).toggleSoftInputFromWindow(this.verification_saved_card.getWindowToken(), 2, 0);
                dialog.show();
                return;
            }
            return;
        }
        this.vaulted_cvv_digit = this.default_cvv_digit;
        Dialog dialog2 = new Dialog(this);
        dialog2.requestWindowFeature(1);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog2.setContentView(getResources().getIdentifier("paynimo_dialog_vault_card", "layout", getApplicationContext().getPackageName()));
        dialog2.setCanceledOnTouchOutside(true);
        EditText editText2 = (EditText) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_card_vault_et_cvv", "id", dialog2);
        this.verification_saved_card = editText2;
        editText2.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((keyEvent != null && keyEvent.getKeyCode() == 66) || i == 6) {
                    PaymentModesActivity.this.quickPay.setPressed(true);
                    PaymentModesActivity.this.quickPay.invalidate();
                    PaymentModesActivity.this.quickPay.performClick();
                }
                return false;
            }
        });
        this.verification_saved_card.setHint(getApplicationContext().getResources().getIdentifier("paynimo_cc_verification_hint", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName()));
        ((TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_field_label", "id", dialog2)).setText(getApplicationContext().getResources().getIdentifier("paynimo_dialog_vaulted_field_card", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName()));
        LinearLayout linearLayout = (LinearLayout) dialog2.findViewById(getResources().getIdentifier("lyt_paynimo_si", "id", getPackageName()));
        CheckBox checkBox = (CheckBox) dialog2.findViewById(getResources().getIdentifier("paynimo_vault_card_checkbox_si", "id", getPackageName()));
        ScrollView scrollView = (ScrollView) dialog2.findViewById(getResources().getIdentifier("paynimo_card_main_container", "id", getPackageName()));
        final ViewGroup viewGroup2 = (ViewGroup) dialog2.findViewById(getResources().getIdentifier("paynimo_card_si_container", "id", getPackageName()));
        final EditText editText3 = (EditText) dialog2.findViewById(getResources().getIdentifier("paynimo_card_et_debit_start_date", "id", getPackageName()));
        ViewGroup viewGroup3 = (ViewGroup) dialog2.findViewById(getResources().getIdentifier("paynimo_card_si_non_edit_container", "id", getPackageName()));
        TextView textView3 = (TextView) dialog2.findViewById(getResources().getIdentifier("paynimo_card_n_et_debit_start_date", "id", getPackageName()));
        TextView textView4 = (TextView) dialog2.findViewById(getResources().getIdentifier("paynimo_card_n_et_debit_end_date", "id", getPackageName()));
        TextView textView5 = (TextView) dialog2.findViewById(getResources().getIdentifier("paynimo_card_n_et_amount_debit", "id", getPackageName()));
        TextView textView6 = (TextView) dialog2.findViewById(getResources().getIdentifier("paynimo_card_n_et_amountType", "id", getPackageName()));
        TextView textView7 = (TextView) dialog2.findViewById(getResources().getIdentifier("paynimo_card_n_et_frequency", "id", getPackageName()));
        ImageButton imageButton = (ImageButton) dialog2.findViewById(getResources().getIdentifier("paynimo_vault_card_eb_start_date", "id", getPackageName()));
        ImageView imageView2 = (ImageView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_icon", "id", dialog2);
        ImageButton imageButton2 = (ImageButton) dialog2.findViewById(getResources().getIdentifier("paynimo_vault_card_eb_end_date", "id", getPackageName()));
        TextView textView8 = (TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_cardno_label", "id", dialog2);
        Spinner spinner = (Spinner) dialog2.findViewById(getResources().getIdentifier("paynimo_card_spinner_amountType", "id", getPackageName()));
        TextView textView9 = (TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_card_bankname_label", "id", dialog2);
        Spinner spinner2 = (Spinner) dialog2.findViewById(getResources().getIdentifier("paynimo_card_spinner_frequency", "id", getPackageName()));
        EditText editText4 = (EditText) dialog2.findViewById(getResources().getIdentifier("paynimo_card_et_amount_debit", "id", getPackageName()));
        TextView textView10 = (TextView) dialog2.findViewById(getResources().getIdentifier("paynimo_vault_card_si_info", "id", getPackageName()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Dialog dialog3 = dialog2;
        linkedHashMap.put("As and when presented", "ADHO");
        linkedHashMap.put("Bi- monthly", "BIMN");
        linkedHashMap.put("Daily", "DAIL");
        linkedHashMap.put("Monthly", "MNTH");
        linkedHashMap.put("Quarterly", "QURT");
        linkedHashMap.put("Semi annually", "MIAN");
        linkedHashMap.put("Weekly", "Week");
        linkedHashMap.put("Yearly", "YEAR");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str6 = "id";
        linkedHashMap2.put("Variable", "M");
        linkedHashMap2.put("Fixed", PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        Set keySet = linkedHashMap2.keySet();
        Set keySet2 = linkedHashMap.keySet();
        LinkedHashMap linkedHashMap3 = linkedHashMap2;
        LinkedHashMap linkedHashMap4 = linkedHashMap;
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, 17367048, (String[]) keySet.toArray(new String[keySet.size()]));
        arrayAdapter2.setDropDownViewResource(17367049);
        EditText editText5 = (EditText) dialog2.findViewById(getResources().getIdentifier("paynimo_card_et_debit_end_date", "id", getPackageName()));
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, 17367048, (String[]) keySet2.toArray(new String[keySet2.size()]));
        arrayAdapter3.setDropDownViewResource(17367049);
        textView10.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        checkBox.setVisibility(8);
        textView10.setVisibility(8);
        viewGroup2.setVisibility(8);
        viewGroup3.setVisibility(8);
        spinner.setAdapter(arrayAdapter2);
        spinner2.setAdapter(arrayAdapter3);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        String action = this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getAction();
        boolean z = isSIEnabledFromMerchant;
        if (z) {
            this.isSIEnabledFromMerchantScreeen = Boolean.TRUE;
            checkBox.setVisibility(0);
            checkBox.setChecked(true);
            textView10.setVisibility(0);
            viewGroup = viewGroup3;
            arrayAdapter = arrayAdapter3;
            textView10.setText(getResources().getString(getResources().getIdentifier("paynimo_cc_si_view_detail_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())));
            viewGroup2.setVisibility(8);
        } else {
            viewGroup = viewGroup3;
            arrayAdapter = arrayAdapter3;
            if (!z && action.equalsIgnoreCase("Y")) {
                checkBox.setVisibility(0);
                checkBox.setChecked(false);
                this.checkout.setPaymentInstructionStartDateTime("");
                this.checkout.setPaymentInstructionEndDateTime("");
                this.checkout.setPaymentInstructionAmount("");
                this.checkout.setPaymentInstructionLimit("");
                this.checkout.setPaymentInstructionAction("N");
                textView10.setVisibility(8);
            } else if (!isSIEnabledFromMerchant && action.equalsIgnoreCase("N")) {
                checkBox.setVisibility(0);
                checkBox.setChecked(false);
                this.checkout.setPaymentInstructionStartDateTime("");
                this.checkout.setPaymentInstructionEndDateTime("");
                this.checkout.setPaymentInstructionAmount("");
                this.checkout.setPaymentInstructionLimit("");
                this.checkout.setPaymentInstructionAction("N");
                textView10.setVisibility(8);
            }
        }
        Calendar instance = Calendar.getInstance();
        this.cal = instance;
        this.day = instance.get(5);
        this.month = this.cal.get(2);
        this.year = this.cal.get(1);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
        outline73.append(this.day);
        String sb = outline73.toString();
        String outline41 = GeneratedOutlineSupport.outline41("", this.month + 1);
        StringBuilder outline81 = GeneratedOutlineSupport.outline81(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        CheckBox checkBox2 = checkBox;
        outline81.append(this.year);
        outline81.append("");
        editText3.setText(outline81);
        StringBuilder sb2 = new StringBuilder();
        GeneratedOutlineSupport.outline103(sb2, sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb2.append(this.year + 20);
        sb2.append("");
        final EditText editText6 = editText5;
        editText6.setText(sb2);
        EditText editText7 = editText4;
        editText7.setText("1000.00");
        final AnonymousClass6 r1 = new OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                int i4 = i2 + 1;
                String outline41 = GeneratedOutlineSupport.outline41("", i3);
                String outline412 = GeneratedOutlineSupport.outline41("", i4);
                if (i3 > 0 && i3 < 10) {
                    outline41 = GeneratedOutlineSupport.outline41("0", i3);
                }
                if (i4 > 0 && i4 < 10) {
                    outline412 = GeneratedOutlineSupport.outline41("0", i4);
                }
                EditText editText = editText3;
                editText.setText((outline41 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + outline412 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i).trim());
            }
        };
        final AnonymousClass7 r4 = new OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                int i4 = i2 + 1;
                String outline41 = GeneratedOutlineSupport.outline41("", i3);
                String outline412 = GeneratedOutlineSupport.outline41("", i4);
                if (i3 > 0 && i3 < 10) {
                    outline41 = GeneratedOutlineSupport.outline41("0", i3);
                }
                if (i4 > 0 && i4 < 10) {
                    outline412 = GeneratedOutlineSupport.outline41("0", i4);
                }
                EditText editText = editText6;
                StringBuilder sb = new StringBuilder();
                sb.append(outline41);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(outline412);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(i);
                editText.setText(sb);
            }
        };
        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(AnonymousClass27.YEAR, PaymentModesActivity.this.year);
                bundle.putInt(AnonymousClass27.MONTH, PaymentModesActivity.this.month);
                bundle.putInt("day", PaymentModesActivity.this.day);
                datePickerFragment.setArguments(bundle);
                datePickerFragment.setCallBack(r1);
                datePickerFragment.show(PaymentModesActivity.this.getSupportFragmentManager(), (String) "Date Picker");
            }
        });
        imageButton2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(AnonymousClass27.YEAR, PaymentModesActivity.this.year);
                bundle.putInt(AnonymousClass27.MONTH, PaymentModesActivity.this.month);
                bundle.putInt("day", PaymentModesActivity.this.day);
                datePickerFragment.setArguments(bundle);
                datePickerFragment.setCallBack(r4);
                datePickerFragment.show(PaymentModesActivity.this.getSupportFragmentManager(), (String) "Date Picker");
            }
        });
        final EditText editText8 = editText3;
        LinkedHashMap linkedHashMap5 = linkedHashMap3;
        final EditText editText9 = editText6;
        Dialog dialog4 = dialog3;
        ViewGroup viewGroup4 = viewGroup;
        final Spinner spinner3 = spinner;
        EditText editText10 = editText7;
        final ArrayAdapter arrayAdapter4 = arrayAdapter2;
        AnonymousClass10 r15 = r0;
        final Spinner spinner4 = spinner2;
        EditText editText11 = editText3;
        final ArrayAdapter arrayAdapter5 = arrayAdapter;
        Spinner spinner5 = spinner2;
        CheckBox checkBox3 = checkBox2;
        final EditText editText12 = editText10;
        ImageView imageView3 = imageView2;
        TextView textView11 = textView10;
        final ViewGroup viewGroup5 = viewGroup4;
        TextView textView12 = textView8;
        Spinner spinner6 = spinner;
        final TextView textView13 = textView11;
        AnonymousClass10 r0 = new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (!PaymentModesActivity.this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                        viewGroup2.setVisibility(0);
                        editText8.setKeyListener(null);
                        editText9.setKeyListener(null);
                        spinner3.setAdapter(arrayAdapter4);
                        spinner4.setAdapter(arrayAdapter5);
                        int access$700 = PaymentModesActivity.this.month + 1;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                        outline73.append(PaymentModesActivity.this.day);
                        String sb = outline73.toString();
                        String outline41 = GeneratedOutlineSupport.outline41("", access$700);
                        if (PaymentModesActivity.this.day > 0 && PaymentModesActivity.this.day < 10) {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("0");
                            outline732.append(PaymentModesActivity.this.day);
                            sb = outline732.toString();
                        }
                        if (access$700 > 0 && access$700 < 10) {
                            outline41 = GeneratedOutlineSupport.outline41("0", access$700);
                        }
                        EditText editText = editText8;
                        StringBuilder outline81 = GeneratedOutlineSupport.outline81(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        outline81.append(PaymentModesActivity.this.year);
                        outline81.append(CMap.SPACE);
                        editText.setText(outline81);
                        EditText editText2 = editText9;
                        StringBuilder outline812 = GeneratedOutlineSupport.outline81(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        outline812.append(PaymentModesActivity.this.year + 20);
                        outline812.append(CMap.SPACE);
                        editText2.setText(outline812);
                        editText12.setText("1000.00");
                    }
                } else if (PaymentModesActivity.this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                    viewGroup5.setVisibility(8);
                    PaymentModesActivity.this.isSINonEditableViewVisible = Boolean.FALSE;
                    TextView textView = textView13;
                    PaymentModesActivity paymentModesActivity = PaymentModesActivity.this;
                    textView.setText(paymentModesActivity.getString(paymentModesActivity.getResources().getIdentifier("paynimo_card_view_si", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                } else {
                    editText8.setText("");
                    editText9.setText("");
                    editText12.setText("");
                    viewGroup2.setVisibility(8);
                }
            }
        };
        checkBox3.setOnCheckedChangeListener(r15);
        textView13.setText(getString(getResources().getIdentifier("paynimo_card_show_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())));
        final TextView textView14 = textView13;
        final ViewGroup viewGroup6 = viewGroup4;
        final TextView textView15 = textView3;
        final TextView textView16 = textView4;
        final TextView textView17 = textView5;
        final TextView textView18 = textView6;
        final TextView textView19 = textView7;
        final LinkedHashMap linkedHashMap6 = linkedHashMap4;
        final LinkedHashMap linkedHashMap7 = linkedHashMap5;
        AnonymousClass11 r02 = new OnClickListener() {
            public void onClick(View view) {
                if (!PaymentModesActivity.this.isSINonEditableViewVisible.booleanValue()) {
                    PaymentModesActivity.this.isSINonEditableViewVisible = Boolean.TRUE;
                    TextView textView = textView14;
                    PaymentModesActivity paymentModesActivity = PaymentModesActivity.this;
                    textView.setText(paymentModesActivity.getString(paymentModesActivity.getResources().getIdentifier("paynimo_card_hide_si", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                    viewGroup6.setVisibility(0);
                    textView15.setKeyListener(null);
                    textView16.setKeyListener(null);
                    textView17.setKeyListener(null);
                    textView18.setKeyListener(null);
                    textView19.setKeyListener(null);
                    if (PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() > 0) {
                        textView15.setText(PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime());
                    } else {
                        TextView textView2 = textView15;
                        PaymentModesActivity paymentModesActivity2 = PaymentModesActivity.this;
                        textView2.setError(paymentModesActivity2.getString(paymentModesActivity2.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                    }
                    if (PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() > 0) {
                        textView16.setText(PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime());
                    } else {
                        TextView textView3 = textView16;
                        PaymentModesActivity paymentModesActivity3 = PaymentModesActivity.this;
                        textView3.setError(paymentModesActivity3.getString(paymentModesActivity3.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                    }
                    if (PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() > 0) {
                        textView17.setText(PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getLimit());
                    } else {
                        TextView textView4 = textView17;
                        PaymentModesActivity paymentModesActivity4 = PaymentModesActivity.this;
                        textView4.setError(paymentModesActivity4.getString(paymentModesActivity4.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                    }
                    String frequency = PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getFrequency();
                    if (frequency.equals(null) || frequency.length() <= 0) {
                        TextView textView5 = textView19;
                        PaymentModesActivity paymentModesActivity5 = PaymentModesActivity.this;
                        textView5.setError(paymentModesActivity5.getString(paymentModesActivity5.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                    } else {
                        try {
                            textView19.setText((String) PaymentModesActivity.getKeyFromValue(linkedHashMap6, frequency));
                        } catch (Exception unused) {
                        }
                    }
                    String type = PaymentModesActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getType();
                    if (type.equals(null) || type.length() <= 0) {
                        TextView textView6 = textView18;
                        PaymentModesActivity paymentModesActivity6 = PaymentModesActivity.this;
                        textView6.setError(paymentModesActivity6.getString(paymentModesActivity6.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                        return;
                    }
                    try {
                        textView18.setText((String) PaymentModesActivity.getKeyFromValue(linkedHashMap7, type));
                    } catch (Exception unused2) {
                    }
                } else {
                    PaymentModesActivity.this.isSINonEditableViewVisible = Boolean.FALSE;
                    TextView textView7 = textView14;
                    PaymentModesActivity paymentModesActivity7 = PaymentModesActivity.this;
                    textView7.setText(paymentModesActivity7.getString(paymentModesActivity7.getResources().getIdentifier("paynimo_card_view_si", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())));
                    viewGroup6.setVisibility(8);
                }
            }
        };
        textView13.setOnClickListener(r02);
        if (cVar != null) {
            String cstat = cVar.getCstat();
            String maskedCardNo2 = cVar.getMaskedCardNo();
            String cardIssuerAuthority = cVar.getCardIssuerAuthority();
            if (cstat != null && !cstat.isEmpty() && cardIssuerAuthority != null && !cardIssuerAuthority.isEmpty() && maskedCardNo2 != null && !maskedCardNo2.isEmpty()) {
                textView9.setText(cstat);
                textView12.setText(maskedCardNo2);
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_VISA)) {
                    imageView3.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_visa", str3, getApplicationContext().getPackageName()));
                } else {
                    String str7 = str3;
                    ImageView imageView4 = imageView3;
                    if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MC)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_mastercard", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MAESTRO)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_maestro", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_AMEX)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_american_express", str7, getApplicationContext().getPackageName()));
                        this.vaulted_cvv_digit = this.default_cvv_digit + 1;
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DINER)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_diners_club", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_RUPAY)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_rupay", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DISCOVER)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_discover", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_IP)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_instapayment", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_LASER)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_laser", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_JCB)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_jcb", str7, getApplicationContext().getPackageName()));
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_UP)) {
                        imageView4.setImageResource(getApplicationContext().getResources().getIdentifier("paynimo_unionpay", str7, getApplicationContext().getPackageName()));
                    }
                }
            }
        }
        this.verification_saved_card.setFilters(new InputFilter[]{new LengthFilter(this.vaulted_cvv_digit + 1)});
        this.verification_saved_card.addTextChangedListener(this.vaultedvalidationTextWatcher);
        String str8 = str6;
        final Dialog dialog5 = dialog4;
        ((ImageView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_list_vault_cancel", str8, dialog5)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PaymentModesActivity.this.verification_saved_card.removeTextChangedListener(PaymentModesActivity.this.vaultedvalidationTextWatcher);
                ((InputMethodManager) PaymentModesActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(PaymentModesActivity.this.verification_saved_card.getWindowToken(), 0);
                PaymentModesActivity.this.isDialogShown = false;
                dialog5.dismiss();
            }
        });
        Button button2 = (Button) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_card_vault_pay_btn", str8, dialog5);
        this.quickPay = button2;
        final CheckBox checkBox4 = checkBox3;
        final EditText editText13 = editText11;
        final EditText editText14 = editText5;
        final EditText editText15 = editText10;
        final LinkedHashMap linkedHashMap8 = linkedHashMap4;
        final Spinner spinner7 = spinner5;
        final LinkedHashMap linkedHashMap9 = linkedHashMap5;
        final Spinner spinner8 = spinner6;
        AnonymousClass13 r13 = r0;
        final c cVar5 = cVar;
        Button button3 = button2;
        final Dialog dialog6 = dialog5;
        AnonymousClass13 r03 = new OnClickListener() {
            public void onClick(View view) {
                if (checkBox4.isChecked() && PaymentModesActivity.this.dataFragment.getData().getPmiResponseData() != null) {
                    PaymentModesActivity paymentModesActivity = PaymentModesActivity.this;
                    if (!paymentModesActivity.validateSIData(paymentModesActivity.dataFragment.getData().getPmiResponseData(), checkBox4.isChecked(), editText13.getText().toString(), editText14.getText().toString(), editText15.getText().toString()).booleanValue()) {
                        PaymentModesActivity paymentModesActivity2 = PaymentModesActivity.this;
                        Toast.makeText(paymentModesActivity2, paymentModesActivity2.getResources().getString(PaymentModesActivity.this.getResources().getIdentifier("paynimo_cc_si_validation_error_message", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getPackageName())), 1).show();
                        return;
                    } else if (checkBox4.isChecked()) {
                        PaymentModesActivity.this.checkout.setPaymentInstructionStartDateTime(editText13.getText().toString().trim());
                        PaymentModesActivity.this.checkout.setPaymentInstructionEndDateTime(editText14.getText().toString().trim());
                        PaymentModesActivity.this.checkout.setPaymentInstructionAmount(editText15.getText().toString().trim());
                        PaymentModesActivity.this.checkout.setPaymentInstructionLimit(editText15.getText().toString().trim());
                        PaymentModesActivity.this.checkout.setPaymentInstructionAction("Y");
                        String str = null;
                        String str2 = linkedHashMap8.containsKey(spinner7.getSelectedItem().toString()) ? (String) linkedHashMap8.get(spinner7.getSelectedItem().toString()) : null;
                        if (linkedHashMap9.containsKey(spinner8.getSelectedItem().toString())) {
                            str = (String) linkedHashMap9.get(spinner8.getSelectedItem().toString());
                        }
                        PaymentModesActivity.this.checkout.setPaymentInstructionType(str);
                        PaymentModesActivity.this.checkout.setPaymentInstructionFrequency(str2);
                    } else {
                        PaymentModesActivity.this.checkout.setPaymentInstructionAction("N");
                        PaymentModesActivity.this.checkout.setPaymentInstructionType("");
                        PaymentModesActivity.this.checkout.setPaymentInstructionLimit("");
                        PaymentModesActivity.this.checkout.setPaymentInstructionFrequency("");
                        PaymentModesActivity.this.checkout.setPaymentInstructionStartDateTime("");
                        PaymentModesActivity.this.checkout.setPaymentInstructionEndDateTime("");
                    }
                }
                PaymentModesActivity.this.verification_saved_card.removeTextChangedListener(PaymentModesActivity.this.vaultedvalidationTextWatcher);
                String cardIssuerAuthority = cVar5.getCardIssuerAuthority();
                String cardId = cVar5.getCardId();
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MAESTRO)) {
                    String trim = PaymentModesActivity.this.pmiBanks.getCards().getCredit().trim();
                    if (trim == null || trim.isEmpty()) {
                        String trim2 = PaymentModesActivity.this.pmiBanks.getCards().getDebit().trim();
                        if (trim2 == null || trim2.isEmpty()) {
                            PaymentModesActivity.this.prepareVaultedCardPayment(trim2, cardId, "");
                        } else {
                            PaymentModesActivity.this.prepareVaultedCardPayment(trim2, cardId, "");
                        }
                    } else {
                        PaymentModesActivity.this.prepareVaultedCardPayment(trim, cardId, "");
                    }
                    ((InputMethodManager) PaymentModesActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(PaymentModesActivity.this.verification_saved_card.getWindowToken(), 0);
                    PaymentModesActivity.this.isDialogShown = false;
                    dialog6.dismiss();
                } else if (PaymentModesActivity.this.verification_saved_card.getText().toString().length() <= PaymentModesActivity.this.default_cvv_digit || !Validation.isCVVString(PaymentModesActivity.this.verification_saved_card.getText().toString()).booleanValue()) {
                    PaymentModesActivity.this.verification_saved_card.setError(PaymentModesActivity.this.getApplicationContext().getString(PaymentModesActivity.this.getApplicationContext().getResources().getIdentifier("paynimo_cc_invalid_cvv", NetworkingModule.REQUEST_BODY_KEY_STRING, PaymentModesActivity.this.getApplicationContext().getPackageName())));
                    PaymentModesActivity.this.verification_saved_card.requestFocus();
                } else {
                    ((InputMethodManager) PaymentModesActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(PaymentModesActivity.this.verification_saved_card.getWindowToken(), 0);
                    String trim3 = PaymentModesActivity.this.verification_saved_card.getText().toString().trim();
                    if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_AMEX)) {
                        String trim4 = PaymentModesActivity.this.pmiBanks.getCards().getAmex().trim();
                        if (trim4 == null || trim4.isEmpty()) {
                            ((PaymentActivity) PaymentModesActivity.this.getApplicationContext()).showSingleButtonDialog(PaymentModesActivity.this.getApplicationContext(), CardFragment.CARD_NOT_SUPPORTED);
                        } else {
                            PaymentModesActivity.this.prepareVaultedCardPayment(trim4, cardId, trim3);
                        }
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DINER)) {
                        String trim5 = PaymentModesActivity.this.pmiBanks.getCards().getDiner().trim();
                        if (trim5 == null || trim5.isEmpty()) {
                            ((PaymentActivity) PaymentModesActivity.this.getApplicationContext()).showSingleButtonDialog(PaymentModesActivity.this.getApplicationContext(), CardFragment.CARD_NOT_SUPPORTED);
                        } else {
                            PaymentModesActivity.this.prepareVaultedCardPayment(trim5, cardId, trim3);
                        }
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DISCOVER)) {
                        String trim6 = PaymentModesActivity.this.pmiBanks.getCards().getDiscover().trim();
                        if (trim6 == null || trim6.isEmpty()) {
                            ((PaymentActivity) PaymentModesActivity.this.getApplicationContext()).showSingleButtonDialog(PaymentModesActivity.this.getApplicationContext(), CardFragment.CARD_NOT_SUPPORTED);
                        } else {
                            PaymentModesActivity.this.prepareVaultedCardPayment(trim6, cardId, trim3);
                        }
                    } else {
                        String trim7 = PaymentModesActivity.this.pmiBanks.getCards().getCredit().trim();
                        if (trim7 == null || trim7.isEmpty()) {
                            String trim8 = PaymentModesActivity.this.pmiBanks.getCards().getDebit().trim();
                            if (trim8 == null || trim8.isEmpty()) {
                                PaymentModesActivity.this.prepareVaultedCardPayment(trim8, cardId, trim3);
                            } else {
                                PaymentModesActivity.this.prepareVaultedCardPayment(trim8, cardId, trim3);
                            }
                        } else {
                            PaymentModesActivity.this.prepareVaultedCardPayment(trim7, cardId, trim3);
                        }
                    }
                    PaymentModesActivity.this.isDialogShown = false;
                    dialog6.dismiss();
                }
            }
        };
        button3.setOnClickListener(r13);
        dialog5.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (PaymentModesActivity.this.isDialogShown) {
                    PaymentModesActivity.this.isDialogShown = false;
                }
            }
        });
        this.isDialogShown = true;
        dialog5.setCanceledOnTouchOutside(false);
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
        dialog5.show();
    }

    private void prepareWebviewDataForBank(h hVar) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            new ArrayList();
            String subType = hVar.getAuthentication().getSubType();
            if (subType == null || !subType.equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_NET)) {
                Constant.showOutputLog(this.TAG, "subtype is not NET type=================>>>");
                return;
            }
            String bankAcsUrl = hVar.getACS().getBankAcsUrl();
            if (bankAcsUrl == null || bankAcsUrl.equalsIgnoreCase("")) {
                transactionError(Constant.TAG_ERROR_INVALID_URL_CODE, Constant.TAG_ERROR_INVALID_URL);
                return;
            }
            List<Map> bankAcsParams = hVar.getACS().getBankAcsParams();
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("BankCode", hVar.getBankSelectionCode());
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
            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.checkout);
            startActivityForResult(intent, 2);
        } catch (Exception unused) {
            transactionError(Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    private void prepareWebviewDataForCards(h hVar) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            new ArrayList();
            String bankAcsUrl = hVar.getACS().getBankAcsUrl();
            if (bankAcsUrl == null || bankAcsUrl.equalsIgnoreCase("")) {
                showAlertDialog(-2, Constant.TAG_ERROR_INVALID_URL_CODE, Constant.TAG_ERROR_INVALID_URL);
                return;
            }
            List<Map> bankAcsParams = hVar.getACS().getBankAcsParams();
            Intent intent = new Intent(this, WebViewActivity.class);
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
                String sb2 = sb.toString();
                intent.putExtra("req_load_type_param", sb2.substring(0, sb2.length() - 1));
            } else {
                intent.putExtra("req_load_type_param", "");
            }
            intent.putExtra("req_load_type", Constant.WEBVIEW_TYPE_POSTURL);
            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.checkout);
            startActivityForResult(intent, 2);
        } catch (Exception unused) {
            showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:24|25|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        transactionError(com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0092 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void proceedWithBankCode(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            if (r6 == 0) goto L_0x00a8
            boolean r2 = r6.isEmpty()
            if (r2 != 0) goto L_0x00a8
            java.lang.String r2 = r5.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = " ==>>  BankCode is : "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            com.paynimo.android.payment.util.Constant.showOutputLog(r2, r3)
            boolean r2 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r5)     // Catch:{ Exception -> 0x00a4 }
            if (r2 == 0) goto L_0x0096
            com.paynimo.android.payment.model.Checkout r2 = r5.checkout     // Catch:{ Exception -> 0x0092 }
            if (r2 == 0) goto L_0x00af
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x0092 }
            r2.<init>()     // Catch:{ Exception -> 0x0092 }
            r5.startTime = r2     // Catch:{ Exception -> 0x0092 }
            com.paynimo.android.payment.model.Checkout r2 = r5.checkout     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "T"
            r2.setTransactionRequestType(r3)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r2 = r5.requestedPaymentMethod     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "Netbanking"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0073
            java.lang.String r2 = r5.requestedPaymentMethod     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "Pay with QR Code"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0092 }
            if (r2 == 0) goto L_0x004f
            goto L_0x0073
        L_0x004f:
            java.lang.String r2 = r5.requestedPaymentMethod     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "CashCards"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0092 }
            if (r2 == 0) goto L_0x0061
            com.paynimo.android.payment.model.Checkout r2 = r5.checkout     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "A"
            r2.setPaymentMethodType(r3)     // Catch:{ Exception -> 0x0092 }
            goto L_0x007a
        L_0x0061:
            java.lang.String r2 = r5.requestedPaymentMethod     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "EMI"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0092 }
            if (r2 == 0) goto L_0x007a
            com.paynimo.android.payment.model.Checkout r2 = r5.checkout     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "E"
            r2.setPaymentMethodType(r3)     // Catch:{ Exception -> 0x0092 }
            goto L_0x007a
        L_0x0073:
            com.paynimo.android.payment.model.Checkout r2 = r5.checkout     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "N"
            r2.setPaymentMethodType(r3)     // Catch:{ Exception -> 0x0092 }
        L_0x007a:
            com.paynimo.android.payment.model.Checkout r2 = r5.checkout     // Catch:{ Exception -> 0x0092 }
            r2.setPaymentMethodToken(r6)     // Catch:{ Exception -> 0x0092 }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkout     // Catch:{ Exception -> 0x0092 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0092 }
            r5.request_payload = r6     // Catch:{ Exception -> 0x0092 }
            r5.showProgressLoader()     // Catch:{ Exception -> 0x0092 }
            com.paynimo.android.payment.b.d r6 = r5.mServiceManager     // Catch:{ Exception -> 0x0092 }
            com.paynimo.android.payment.model.request.RequestPayload r2 = r5.request_payload     // Catch:{ Exception -> 0x0092 }
            r6.callUserTRequest(r2, r5)     // Catch:{ Exception -> 0x0092 }
            goto L_0x00af
        L_0x0092:
            r5.transactionError(r1, r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00af
        L_0x0096:
            de.greenrobot.event.EventBus r6 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x00a4 }
            com.paynimo.android.payment.event.g r2 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x00a4 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a4 }
            r6.post(r2)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00af
        L_0x00a4:
            r5.transactionError(r1, r0)
            goto L_0x00af
        L_0x00a8:
            java.lang.String r6 = r5.TAG
            java.lang.String r0 = " BankCode is EMPTY or NULL"
            com.paynimo.android.payment.util.Constant.showOutputLog(r6, r0)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.PaymentModesActivity.proceedWithBankCode(java.lang.String):void");
    }

    private void proceedWithBankNumber() {
        if (!this.checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
            return;
        }
        if (!this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getToken().equalsIgnoreCase("") || this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier().equalsIgnoreCase("")) {
            this.isTxnMerchantInitiated = true;
            startVaultedCardNetworkTask("00000");
            return;
        }
        String identifier = this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier();
        String month2 = this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getExpiry().getMonth();
        String year2 = this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getExpiry().getYear();
        if (CardTypeParser.getContext() == null) {
            application_context = getApplicationContext();
        }
        CardType cardType2 = CardType.getCardType(identifier, this.settingsData.getAllowedCardTypes());
        this.cardType = cardType2;
        if (cardType2 == CardType.YetUnknown || cardType2 == CardType.Invalid) {
            transactionError(Constant.TAG_ERROR_CARD_VALIDATION_CODE, Constant.TAG_ERROR_CARD_VALIDATION);
            return;
        }
        this.cardDataType = cardType2.toString();
        if (identifier == null || month2 == null || year2 == null || !CardValidator.validateDate((Context) this, month2, year2)) {
            transactionError(Constant.TAG_ERROR_CARD_VALIDATION_CODE, Constant.TAG_ERROR_CARD_VALIDATION);
            return;
        }
        this.isTxnMerchantInitiated = true;
        startBinCheckTask(identifier.substring(0, 6), "", this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getToken(), this.checkout.getMerchantRequestPayload().getTransaction().getIsRegistration(), this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getAction());
    }

    private void retrieveSavedInstanceData(Bundle bundle) {
        this.settingsData = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.checkout = (Checkout) bundle.getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
    }

    private void setCardBinFormat() {
    }

    private void setDefaultValues() {
        Checkout checkout2 = this.savedCheckout;
        if (checkout2 != null) {
            this.dataObject.setCheckoutData(checkout2);
            this.dataObject.setPmiResponseData(new r());
        }
    }

    private void setListeners() {
        this.listVaulted.setOnItemClickListener(this);
    }

    private void setModes(com.paynimo.android.payment.model.response.k.a aVar, f fVar) {
        List<HashMap<String, Object>> list = this.vaultedDataList;
        if (list != null) {
            list.clear();
        }
        if (fVar.getCardVaultCount() > 0) {
            this.vaultedDataList.add(GeneratedOutlineSupport.outline88(VAULT_ROW_TYPE, VAULT_TYPE_HEADERS, VAULT_ROW_TEXT, "Saved Cards"));
            List<c> cardVault = fVar.getCardVault();
            if (cardVault != null) {
                for (c put : cardVault) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(VAULT_ROW_TYPE, VAULT_TYPE_CARDS);
                    hashMap.put(VAULT_ROW_DATA, put);
                    this.vaultedDataList.add(hashMap);
                }
            }
        }
        if (!isSIEnabledFromMerchant && fVar.getImpsVaultCount() > 0) {
            this.vaultedDataList.add(GeneratedOutlineSupport.outline88(VAULT_ROW_TYPE, VAULT_TYPE_HEADERS, VAULT_ROW_TEXT, "Saved IMPS"));
            List<c> impsVault = fVar.getImpsVault();
            if (impsVault != null) {
                for (c put2 : impsVault) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(VAULT_ROW_TYPE, VAULT_TYPE_IMPS);
                    hashMap2.put(VAULT_ROW_DATA, put2);
                    this.vaultedDataList.add(hashMap2);
                }
            }
        }
        if (aVar.getCards() != null && ((aVar.getCards().getAmex() != null && aVar.getCards().getAmex().length() > 0) || ((aVar.getCards().getCredit() != null && aVar.getCards().getCredit().length() > 0) || ((aVar.getCards().getDebit() != null && aVar.getCards().getDebit().length() > 0) || ((aVar.getCards().getDiner() != null && aVar.getCards().getDiner().length() > 0) || ((aVar.getCards().getDiscover() != null && aVar.getCards().getDiscover().length() > 0) || ((aVar.getCards().getIvr() != null && aVar.getCards().getIvr().length() > 0) || (aVar.getCards().getRupay() != null && aVar.getCards().getRupay().length() > 0)))))))) {
            this.payment_enabled_modes_list.add(PaymentActivity.PAYMENT_METHOD_CARDS);
        }
        if (aVar.getNetBanking() != null && (aVar.getNetBanking().getOtherBanksCount() > 0 || aVar.getNetBanking().getTopBanksCount() > 0)) {
            this.payment_enabled_modes_list.add(PaymentActivity.PAYMENT_METHOD_NETBANKING);
        }
        if (!isSIEnabledFromMerchant && aVar.getImps() != null && !aVar.getImps().isEmpty()) {
            this.payment_enabled_modes_list.add("IMPS");
        }
        if (!isSIEnabledFromMerchant && aVar.getWallets() != null && (aVar.getWallets().getOtherBanksCount() > 0 || aVar.getWallets().getTopBanksCount() > 0)) {
            this.payment_enabled_modes_list.add(PaymentActivity.PAYMENT_METHOD_WALLETS);
        }
        if (!isSIEnabledFromMerchant && aVar.getCashCards() != null && (aVar.getCashCards().getOtherBanksCount() > 0 || aVar.getCashCards().getTopBanksCount() > 0)) {
            this.payment_enabled_modes_list.add(PaymentActivity.PAYMENT_METHOD_CASHCARDS);
        }
        if (!isSIEnabledFromMerchant && aVar.getEmiBanks() != null && (aVar.getEmiBanks().getOtherBanksCount() > 0 || aVar.getEmiBanks().getTopBanksCount() > 0)) {
            this.payment_enabled_modes_list.add("EMI");
        }
        if (!isSIEnabledFromMerchant && aVar.getUpi() != null && (aVar.getUpi().getOtherBanksCount() > 0 || aVar.getUpi().getTopBanksCount() > 0)) {
            this.payment_enabled_modes_list.add("UPI");
        }
        if (!isSIEnabledFromMerchant && aVar.getMVISA() != null && (aVar.getMVISA().getOtherBanksCount() > 0 || aVar.getMVISA().getTopBanksCount() > 0)) {
            this.payment_enabled_modes_list.add(PaymentActivity.PAYMENT_METHOD_MVISA);
        }
        if (aVar.getDigitalMandate() != null && (aVar.getDigitalMandate().getOtherBanksCount() > 0 || (aVar.getDigitalMandate().getTopBanksCount() > 0 && this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getAction() != null && (GeneratedOutlineSupport.outline107(this.checkout, "A") || GeneratedOutlineSupport.outline107(this.checkout, "Y"))))) {
            this.payment_enabled_modes_list.add(PaymentActivity.PAYMENT_METHOD_DIGITALMANDATE);
            if (this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getAction() != null && GeneratedOutlineSupport.outline107(this.checkout, "Y")) {
                this.payment_enabled_modes_list.remove(PaymentActivity.PAYMENT_METHOD_NETBANKING);
            }
        }
        if (this.payment_enabled_modes_list.size() > 0) {
            HashMap outline87 = GeneratedOutlineSupport.outline87(VAULT_ROW_TYPE, VAULT_TYPE_HEADERS);
            if (fVar.getCardVaultCount() > 0 || fVar.getImpsVaultCount() > 0) {
                outline87.put(VAULT_ROW_TEXT, "Other Payment Options");
            } else {
                outline87.put(VAULT_ROW_TEXT, "Pay With");
            }
            this.vaultedDataList.add(outline87);
            Iterator<String> it = this.payment_enabled_modes_list.iterator();
            while (it.hasNext()) {
                this.vaultedDataList.add(GeneratedOutlineSupport.outline88(VAULT_ROW_TYPE, VAULT_TYPE_OTHER_OPTIONS, VAULT_ROW_TEXT, it.next()));
            }
        }
        this.listMultipleRowAdapter = new e(this, this.vaultedDataList, this.checkout, this.mServiceManager);
        if (this.requestedPaymentMethod.equalsIgnoreCase("All")) {
            this.listVaulted.setAdapter(this.listMultipleRowAdapter);
            this.vg_content_container.setVisibility(0);
        } else if (this.payment_enabled_modes_list.contains(this.requestedPaymentMethod)) {
            String token = this.checkout.getMerchantRequestPayload().getPayment().getMethod().getToken();
            if (this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING)) {
                if (!token.equalsIgnoreCase("")) {
                    ArrayList arrayList = new ArrayList();
                    List<com.paynimo.android.payment.model.response.k.b> topBanks = aVar.getNetBanking().getTopBanks();
                    if (topBanks != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode : topBanks) {
                            arrayList.add(bankCode.getBankCode());
                        }
                    }
                    List<com.paynimo.android.payment.model.response.k.b> otherBanks = aVar.getNetBanking().getOtherBanks();
                    if (otherBanks != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode2 : otherBanks) {
                            arrayList.add(bankCode2.getBankCode());
                        }
                    }
                    if (arrayList.contains(token)) {
                        openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                    } else {
                        transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                    }
                } else {
                    openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                }
            } else if (this.requestedPaymentMethod.equalsIgnoreCase("EMI")) {
                if (!token.equalsIgnoreCase("")) {
                    ArrayList arrayList2 = new ArrayList();
                    List<com.paynimo.android.payment.model.response.k.b> topBanks2 = aVar.getEmiBanks().getTopBanks();
                    if (topBanks2 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode3 : topBanks2) {
                            arrayList2.add(bankCode3.getBankCode());
                        }
                    }
                    List<com.paynimo.android.payment.model.response.k.b> otherBanks2 = aVar.getEmiBanks().getOtherBanks();
                    if (otherBanks2 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode4 : otherBanks2) {
                            arrayList2.add(bankCode4.getBankCode());
                        }
                    }
                    if (arrayList2.contains(token)) {
                        openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                    } else {
                        transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                    }
                } else {
                    openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                }
            } else if (this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_WALLETS)) {
                if (!token.equalsIgnoreCase("")) {
                    ArrayList arrayList3 = new ArrayList();
                    List<com.paynimo.android.payment.model.response.k.b> topBanks3 = aVar.getWallets().getTopBanks();
                    if (topBanks3 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode5 : topBanks3) {
                            arrayList3.add(bankCode5.getBankCode());
                        }
                    }
                    List<com.paynimo.android.payment.model.response.k.b> otherBanks3 = aVar.getWallets().getOtherBanks();
                    if (otherBanks3 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode6 : otherBanks3) {
                            arrayList3.add(bankCode6.getBankCode());
                        }
                    }
                    if (arrayList3.contains(token)) {
                        openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                    } else {
                        transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                    }
                } else {
                    openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                }
            } else if (this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CASHCARDS)) {
                if (!token.equalsIgnoreCase("")) {
                    ArrayList arrayList4 = new ArrayList();
                    List<com.paynimo.android.payment.model.response.k.b> topBanks4 = aVar.getCashCards().getTopBanks();
                    if (topBanks4 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode7 : topBanks4) {
                            arrayList4.add(bankCode7.getBankCode());
                        }
                    }
                    List<com.paynimo.android.payment.model.response.k.b> otherBanks4 = aVar.getCashCards().getOtherBanks();
                    if (otherBanks4 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode8 : otherBanks4) {
                            arrayList4.add(bankCode8.getBankCode());
                        }
                    }
                    if (arrayList4.contains(token)) {
                        openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                    } else {
                        transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                    }
                } else {
                    openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                }
            } else if (this.requestedPaymentMethod.equalsIgnoreCase("IMPS") || this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CARDS)) {
                openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
            } else if (this.requestedPaymentMethod.equalsIgnoreCase("UPI")) {
                if (!token.equalsIgnoreCase("")) {
                    ArrayList arrayList5 = new ArrayList();
                    if (token.equalsIgnoreCase("3090")) {
                        List<com.paynimo.android.payment.model.response.k.b> topBanks5 = aVar.getMVISA().getTopBanks();
                        if (topBanks5 != null) {
                            for (com.paynimo.android.payment.model.response.k.b bankCode9 : topBanks5) {
                                arrayList5.add(bankCode9.getBankCode());
                            }
                        }
                        List<com.paynimo.android.payment.model.response.k.b> otherBanks5 = aVar.getMVISA().getOtherBanks();
                        if (otherBanks5 != null) {
                            for (com.paynimo.android.payment.model.response.k.b bankCode10 : otherBanks5) {
                                arrayList5.add(bankCode10.getBankCode());
                            }
                        }
                        if (arrayList5.contains(token)) {
                            openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                        } else {
                            transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                        }
                    } else {
                        List<com.paynimo.android.payment.model.response.k.b> topBanks6 = aVar.getUpi().getTopBanks();
                        if (topBanks6 != null) {
                            for (com.paynimo.android.payment.model.response.k.b bankCode11 : topBanks6) {
                                arrayList5.add(bankCode11.getBankCode());
                            }
                        }
                        List<com.paynimo.android.payment.model.response.k.b> otherBanks6 = aVar.getUpi().getOtherBanks();
                        if (otherBanks6 != null) {
                            for (com.paynimo.android.payment.model.response.k.b bankCode12 : otherBanks6) {
                                arrayList5.add(bankCode12.getBankCode());
                            }
                        }
                        if (arrayList5.contains(token)) {
                            openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                        } else {
                            transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                        }
                    }
                } else {
                    openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                }
            } else if (!this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_MVISA)) {
            } else {
                if (!token.equalsIgnoreCase("")) {
                    ArrayList arrayList6 = new ArrayList();
                    List<com.paynimo.android.payment.model.response.k.b> topBanks7 = aVar.getMVISA().getTopBanks();
                    if (topBanks7 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode13 : topBanks7) {
                            arrayList6.add(bankCode13.getBankCode());
                        }
                    }
                    List<com.paynimo.android.payment.model.response.k.b> otherBanks7 = aVar.getMVISA().getOtherBanks();
                    if (otherBanks7 != null) {
                        for (com.paynimo.android.payment.model.response.k.b bankCode14 : otherBanks7) {
                            arrayList6.add(bankCode14.getBankCode());
                        }
                    }
                    if (arrayList6.contains(token)) {
                        openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                    } else {
                        transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                    }
                } else {
                    openRequestedFragment(this.requestedPaymentMethod, new c(), SINGLE_PAYMENT_MODE_ON);
                }
            }
        } else {
            transactionError(Constant.TAG_ERROR_REQUEST_PAYMENT_MODE_CODE, Constant.TAG_ERROR_REQUEST_PAYMENT_MODE);
        }
    }

    private void showBackPressedDialog() {
        final Dialog dialog = new Dialog(this.activitycontxt);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_custom_dialog_text", "id", dialog)).setText(getResources().getString(getResources().getIdentifier("paynimo_back_press_dialog_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_custom_dialog_ButtonOK", "id", dialog)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                b.callEventLogging("", "click", "button:Back", 0, "PASS", PaymentModesActivity.this.checkout, "", "", "", "", PaymentModesActivity.this.mServiceManager, PaymentModesActivity.this);
                PaymentModesActivity.this.transactionCancelled();
            }
        });
        ((Button) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_custom_dialog_ButtonCancel", "id", dialog)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showProgressLoader() {
        findViewById(getResources().getIdentifier("application_header", "id", getPackageName())).setVisibility(8);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(0);
        this.webView.loadUrl("file:///android_asset/paynimo_loader_gif.gif");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|6|7|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startBinCheckTask(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r4 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            r2 = -2
            r3 = 0
            r4.issuer = r3     // Catch:{ Exception -> 0x0068 }
            r4.inputCardType = r3     // Catch:{ Exception -> 0x0068 }
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r4)     // Catch:{ Exception -> 0x0068 }
            if (r3 == 0) goto L_0x005a
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x0056 }
            r3.<init>()     // Catch:{ Exception -> 0x0056 }
            r4.startTime = r3     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.request.c r3 = new com.paynimo.android.payment.model.request.c     // Catch:{ Exception -> 0x0056 }
            r3.<init>()     // Catch:{ Exception -> 0x0056 }
            r3.setBin(r5)     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.Checkout r5 = r4.checkout     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.request.RequestPayload r5 = r5.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.request.o r5 = r5.getMerchant()     // Catch:{ Exception -> 0x0056 }
            java.lang.String r5 = r5.getIdentifier()     // Catch:{ Exception -> 0x0056 }
            r3.setSubmer_code(r5)     // Catch:{ Exception -> 0x0056 }
            r3.setBank_code(r6)     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.Checkout r5 = r4.checkout     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.request.RequestPayload r5 = r5.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.request.s r5 = r5.getTransaction()     // Catch:{ Exception -> 0x0056 }
            java.lang.String r5 = r5.getIdentifier()     // Catch:{ Exception -> 0x0056 }
            r3.setSrc_prn(r5)     // Catch:{ Exception -> 0x0056 }
            r3.setPayment_instrument_token(r7)     // Catch:{ Exception -> 0x0056 }
            r3.setTransaction_isRegistration(r8)     // Catch:{ Exception -> 0x0056 }
            r3.setPayment_instruction_action(r9)     // Catch:{ Exception -> 0x0056 }
            r4.showProgressLoader()     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.b.d r5 = r4.mServiceManager     // Catch:{ Exception -> 0x0056 }
            r5.callUserBinCheckAPI(r3, r4)     // Catch:{ Exception -> 0x0056 }
            goto L_0x006b
        L_0x0056:
            r4.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x0068 }
            goto L_0x006b
        L_0x005a:
            de.greenrobot.event.EventBus r5 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0068 }
            com.paynimo.android.payment.event.g r6 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0068 }
            r7 = 0
            r6.<init>(r7)     // Catch:{ Exception -> 0x0068 }
            r5.post(r6)     // Catch:{ Exception -> 0x0068 }
            goto L_0x006b
        L_0x0068:
            r4.showAlertDialog(r2, r1, r0)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.PaymentModesActivity.startBinCheckTask(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|(1:9)|10|11|12|13|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0051 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startCardNetworkTask(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Y"
            java.lang.String r1 = "DEFAULT ERROR"
            java.lang.String r2 = "ERROR_PAYNIMO_003"
            r3 = -2
            boolean r4 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r6)     // Catch:{ Exception -> 0x0063 }
            if (r4 == 0) goto L_0x0055
            com.paynimo.android.payment.model.Checkout r4 = r6.checkout     // Catch:{ Exception -> 0x0051 }
            if (r4 == 0) goto L_0x0066
            java.util.Date r4 = new java.util.Date     // Catch:{ Exception -> 0x0051 }
            r4.<init>()     // Catch:{ Exception -> 0x0051 }
            r6.startTime = r4     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.model.Checkout r4 = r6.checkout     // Catch:{ Exception -> 0x0051 }
            java.lang.String r5 = "TWD"
            r4.setTransactionRequestType(r5)     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.model.Checkout r4 = r6.checkout     // Catch:{ Exception -> 0x0051 }
            java.lang.String r5 = "C"
            r4.setPaymentMethodType(r5)     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.model.Checkout r4 = r6.checkout     // Catch:{ Exception -> 0x0051 }
            r4.setPaymentMethodToken(r7)     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.model.Checkout r7 = r6.checkout     // Catch:{ Exception -> 0x0051 }
            r7.setTransactionForced3DSCall(r0)     // Catch:{ Exception -> 0x0051 }
            boolean r7 = r6.isSimExists()     // Catch:{ Exception -> 0x0051 }
            if (r7 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            java.lang.String r0 = "N"
        L_0x0039:
            com.paynimo.android.payment.model.Checkout r7 = r6.checkout     // Catch:{ Exception -> 0x0051 }
            r7.setTransactionSmsSending(r0)     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.model.Checkout r7 = r6.checkout     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.model.request.RequestPayload r7 = r7.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0051 }
            r6.request_payload = r7     // Catch:{ Exception -> 0x0051 }
            r6.showProgressLoader()     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.b.d r7 = r6.mServiceManager     // Catch:{ Exception -> 0x0051 }
            com.paynimo.android.payment.model.request.RequestPayload r0 = r6.request_payload     // Catch:{ Exception -> 0x0051 }
            r7.callUserTWDRequest(r0, r6)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0066
        L_0x0051:
            r6.showAlertDialog(r3, r2, r1)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0066
        L_0x0055:
            de.greenrobot.event.EventBus r7 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0063 }
            com.paynimo.android.payment.event.g r0 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0063 }
            r4 = 0
            r0.<init>(r4)     // Catch:{ Exception -> 0x0063 }
            r7.post(r0)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0066
        L_0x0063:
            r6.showAlertDialog(r3, r2, r1)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.PaymentModesActivity.startCardNetworkTask(java.lang.String):void");
    }

    private void startPMICall() {
        this.listVaulted.setVisibility(8);
        this.checkout.setTransactionRequestType(Constant.REQUEST_TYPE_PMI);
        this.request_payload = this.checkout.getMerchantRequestPayload();
        if (NetworkStateReceiver.isOnline(this.activitycontxt)) {
            try {
                this.startTime = new Date();
                showProgressLoader();
                this.mServiceManager.callPMIRequest(this.request_payload, this.activitycontxt);
            } catch (Exception unused) {
            }
        } else {
            EventBus.getDefault().post(new g(false));
        }
    }

    private void startVaultedCardNetworkTask(String str) {
        if (str == null || str.isEmpty()) {
            Constant.showOutputLog(this.TAG, " BankCode is EMPTY or NULL");
            return;
        }
        try {
            if (NetworkStateReceiver.isOnline(this)) {
                try {
                    if (this.checkout != null) {
                        this.checkout.setTransactionRequestType(Constant.REQUEST_TYPE_TCD);
                        this.checkout.setPaymentMethodType("C");
                        this.checkout.setPaymentMethodToken(str);
                        if (this.checkout.getMerchantRequestPayload().getTransaction().getType().trim().equals("PREAUTH")) {
                            this.checkout.setTransactionForced3DSCall("Y");
                        } else {
                            this.checkout.setTransactionForced3DSCall("N");
                        }
                        this.startTime = new Date();
                        this.request_payload = this.checkout.getMerchantRequestPayload();
                        showProgressLoader();
                        this.mServiceManager.callUserTWDRequest(this.request_payload, this);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
                }
            } else {
                EventBus.getDefault().post(new g(false));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    /* access modifiers changed from: private */
    public void transactionCancelled() {
        setResult(0, new Intent());
        finish();
    }

    /* access modifiers changed from: private */
    public void transactionError(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra(PaymentActivity.RETURN_ERROR_CODE, str);
        intent.putExtra("error_description", str2);
        setResult(-2, intent);
        finish();
    }

    private boolean validateCheckoutObjectHasSpace(Checkout checkout2) {
        boolean z = false;
        if (checkout2 != null) {
            if (checkout2.getMerchantRequestPayload().getMerchant().getIdentifier() != null) {
                checkout2.getMerchantRequestPayload().getMerchant().setIdentifier(checkout2.getMerchantRequestPayload().getMerchant().getIdentifier().trim());
                if (!checkout2.getMerchantRequestPayload().getMerchant().getIdentifier().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getTransaction().getIdentifier() != null) {
                    checkout2.getMerchantRequestPayload().getTransaction().setIdentifier(checkout2.getMerchantRequestPayload().getTransaction().getIdentifier().trim());
                    if (!checkout2.getMerchantRequestPayload().getTransaction().getIdentifier().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getTransaction().getReference() != null) {
                        checkout2.getMerchantRequestPayload().getTransaction().setReference(checkout2.getMerchantRequestPayload().getTransaction().getReference().trim());
                        if (!checkout2.getMerchantRequestPayload().getTransaction().getReference().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getTransaction().getType() != null) {
                            checkout2.getMerchantRequestPayload().getTransaction().setType(checkout2.getMerchantRequestPayload().getTransaction().getType().trim());
                            if (!checkout2.getMerchantRequestPayload().getTransaction().getType().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getTransaction().getSubType() != null) {
                                checkout2.getMerchantRequestPayload().getTransaction().setSubType(checkout2.getMerchantRequestPayload().getTransaction().getSubType().trim());
                                if (!checkout2.getMerchantRequestPayload().getTransaction().getSubType().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getTransaction().getCurrency() != null) {
                                    checkout2.getMerchantRequestPayload().getTransaction().setCurrency(checkout2.getMerchantRequestPayload().getTransaction().getCurrency().trim());
                                    if (!checkout2.getMerchantRequestPayload().getTransaction().getCurrency().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getTransaction().getAmount() != null) {
                                        checkout2.getMerchantRequestPayload().getTransaction().setAmount(checkout2.getMerchantRequestPayload().getTransaction().getAmount().trim());
                                        if (!checkout2.getMerchantRequestPayload().getTransaction().getAmount().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getTransaction().getDateTime() != null) {
                                            checkout2.getMerchantRequestPayload().getTransaction().setDateTime(checkout2.getMerchantRequestPayload().getTransaction().getDateTime().trim());
                                            if (!checkout2.getMerchantRequestPayload().getTransaction().getDateTime().contains(CMap.SPACE) && checkout2.getMerchantRequestPayload().getCart().getItem() != null && checkout2.getMerchantRequestPayload().getCart().getItem().size() > 0) {
                                                ArrayList arrayList = new ArrayList(checkout2.getMerchantRequestPayload().getCart().getItem());
                                                checkout2.getMerchantRequestPayload().getCart().getItem().clear();
                                                for (int i = 0; i < arrayList.size(); i++) {
                                                    Item item = (Item) arrayList.get(i);
                                                    String identifier = item.getIdentifier();
                                                    String amount = item.getAmount();
                                                    if (!(identifier == null || amount == null)) {
                                                        item.setIdentifier(identifier.trim());
                                                        item.setAmount(amount.trim());
                                                        checkout2.getMerchantRequestPayload().getCart().addItem(item);
                                                    }
                                                }
                                                arrayList.clear();
                                                List<Item> item2 = checkout2.getMerchantRequestPayload().getCart().getItem();
                                                int i2 = 0;
                                                while (i2 < item2.size()) {
                                                    Item item3 = item2.get(i2);
                                                    String identifier2 = item3.getIdentifier();
                                                    String amount2 = item3.getAmount();
                                                    if (identifier2 != null && !identifier2.isEmpty() && !identifier2.contains(CMap.SPACE) && amount2 != null && !amount2.isEmpty() && !amount2.contains(CMap.SPACE)) {
                                                        i2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        z = true;
        return z;
    }

    private boolean validateCheckoutObjectIsEmpty(Checkout checkout2) {
        boolean z = false;
        if (checkout2 != null) {
            if (checkout2.getMerchantRequestPayload().getMerchant().getIdentifier() != null && !checkout2.getMerchantRequestPayload().getMerchant().getIdentifier().isEmpty() && checkout2.getMerchantRequestPayload().getTransaction().getIdentifier() != null && !checkout2.getMerchantRequestPayload().getTransaction().getIdentifier().isEmpty() && checkout2.getMerchantRequestPayload().getTransaction().getReference() != null && !checkout2.getMerchantRequestPayload().getTransaction().getReference().isEmpty() && checkout2.getMerchantRequestPayload().getTransaction().getType() != null && !checkout2.getMerchantRequestPayload().getTransaction().getType().isEmpty() && checkout2.getMerchantRequestPayload().getTransaction().getSubType() != null && !checkout2.getMerchantRequestPayload().getTransaction().getSubType().isEmpty() && checkout2.getMerchantRequestPayload().getTransaction().getCurrency() != null && !checkout2.getMerchantRequestPayload().getTransaction().getCurrency().isEmpty() && checkout2.getMerchantRequestPayload().getTransaction().getAmount() != null && !checkout2.getMerchantRequestPayload().getTransaction().getAmount().isEmpty() && checkout2.getMerchantRequestPayload().getTransaction().getDateTime() != null && !checkout2.getMerchantRequestPayload().getTransaction().getDateTime().isEmpty() && checkout2.getMerchantRequestPayload().getCart().getItem() != null && checkout2.getMerchantRequestPayload().getCart().getItem().size() > 0) {
                List<Item> item = checkout2.getMerchantRequestPayload().getCart().getItem();
                int i = 0;
                while (i < item.size()) {
                    Item item2 = item.get(i);
                    String identifier = item2.getIdentifier();
                    String amount = item2.getAmount();
                    if (identifier != null && !identifier.isEmpty() && amount != null && !amount.isEmpty()) {
                        i++;
                    }
                }
            }
            return true;
        }
        z = true;
        return z;
    }

    /* access modifiers changed from: private */
    public Boolean validateSIData(r rVar, boolean z, String str, String str2, String str3) {
        Boolean bool = Boolean.FALSE;
        if (!rVar.getSIEnable().equalsIgnoreCase("S") && !rVar.getSIEnable().equalsIgnoreCase("SI")) {
            return Boolean.TRUE;
        }
        if (GeneratedOutlineSupport.outline107(this.checkout, "Y")) {
            if (this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() <= 0 || this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() <= 0 || this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() <= 0 || this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getFrequency().length() <= 0 || this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getType().length() <= 0) {
                return bool;
            }
            return Boolean.TRUE;
        } else if (!z) {
            return Boolean.TRUE;
        } else {
            if (str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
                return bool;
            }
            return Boolean.TRUE;
        }
    }

    public boolean isSimExists() {
        return ((TelephonyManager) getSystemService("phone")).getSimState() == 5;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 7281) {
            if (i2 == -1) {
                if (intent != null) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, (Checkout) intent.getSerializableExtra(Constant.ARGUMENT_DATA_CHECKOUT));
                        setResult(i2, intent2);
                        finish();
                    } catch (Exception unused) {
                    }
                }
            } else if (i2 == -2) {
                if (intent.hasExtra(PaymentActivity.RETURN_ERROR_CODE) && intent.hasExtra("error_description")) {
                    transactionError(intent.getStringExtra(PaymentActivity.RETURN_ERROR_CODE), intent.getStringExtra("error_description"));
                }
            } else if (i2 == 0) {
                transactionCancelled();
            } else if (i2 == -3) {
                if (!this.requestedPaymentMethod.equalsIgnoreCase("All")) {
                    transactionCancelled();
                } else if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("BankCode") && intent.getExtras().getBoolean("BankCode")) {
                    transactionCancelled();
                }
            } else if (i2 == -4) {
                setResult(-4, new Intent());
                finish();
            }
        } else if (i == 2) {
            Constant.showOutputLog(this.TAG, "======>>>>>>>Tar Request");
            if (i2 == -1) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("msg");
                    String stringExtra2 = intent.getStringExtra("tpsl_mrct_cd");
                    if (stringExtra != null && stringExtra2 != null) {
                        Checkout checkout2 = this.checkout;
                        if (checkout2 == null || checkout2.getMerchantRequestPayload().getTransaction().getDeviceIdentifier() == null || !this.checkout.getMerchantRequestPayload().getTransaction().getDeviceIdentifier().equalsIgnoreCase("Android")) {
                            Intent intent3 = new Intent();
                            Checkout checkout3 = new Checkout();
                            checkout3.setMerchantResponse(stringExtra);
                            checkout3.setMerchantIdentifier(stringExtra2);
                            intent3.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout3);
                            setResult(-1, intent3);
                            finish();
                            return;
                        }
                        callTarRequest(stringExtra, stringExtra2);
                    }
                }
            } else if (i2 == -2) {
                transactionError(intent.getStringExtra(PaymentActivity.RETURN_ERROR_CODE), intent.getStringExtra("error_description"));
            } else if (i2 == 0) {
                transactionCancelled();
            } else if (i2 == -3) {
                transactionCancelled();
            }
        }
    }

    public void onBackPressed() {
        showBackPressedDialog();
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("==>>");
        outline73.append(this.TAG);
        Constant.showOutputLog(outline73.toString(), "onCreate");
        setContentView(getResources().getIdentifier("paynimo_activity_paymentmodes", "layout", getApplicationContext().getPackageName()));
        myContext = getApplicationContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.checkout = (Checkout) intent.getSerializableExtra(Constant.ARGUMENT_DATA_CHECKOUT);
            this.savedCheckout = (Checkout) intent.getSerializableExtra(Constant.ARGUMENT_DATA_CHECKOUT);
            this.publickey = intent.getStringExtra(PaymentActivity.EXTRA_PUBLIC_KEY);
            this.requestedPaymentMethod = intent.getStringExtra(PaymentActivity.EXTRA_REQUESTED_PAYMENT_MODE);
            this.settingsData = (Settings) intent.getParcelableExtra(Constant.ARGUMENT_DATA_SETTING);
        }
        this.dataObject = new a();
        com.paynimo.android.payment.b.a aVar = new com.paynimo.android.payment.b.a();
        this.mService = aVar;
        this.mServiceManager = new d(aVar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        RetainedFragment retainedFragment = (RetainedFragment) supportFragmentManager.findFragmentByTag("data");
        this.dataFragment = retainedFragment;
        if (retainedFragment == null) {
            this.dataFragment = new RetainedFragment();
            supportFragmentManager.beginTransaction().add((Fragment) this.dataFragment, (String) "data").commit();
            setDefaultValues();
            this.dataFragment.setData(this.dataObject);
        } else if (this.isDataLoaded) {
            this.dataObject = retainedFragment.getData();
        } else {
            setDefaultValues();
            this.dataFragment.setData(this.dataObject);
        }
        initialiseView();
        setListeners();
        loadSettings(intent.getExtras());
        if (bundle != null) {
            retrieveSavedInstanceData(bundle);
        }
        Checkout checkout2 = this.checkout;
        if (checkout2 != null) {
            this.tv_amount.setText(checkout2.getMerchantRequestPayload().getTransaction().getAmount());
            isSIEnabledFromMerchant = GeneratedOutlineSupport.outline107(this.checkout, "Y") && !this.checkout.getMerchantRequestPayload().getConsumer().getIdentifier().equalsIgnoreCase("");
            if (this.checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                if (!isMerchantSpecificDataValid(this.requestedPaymentMethod)) {
                    transactionError(Constant.TAG_ERROR_CHECKOUT_VALIDATION_CODE, Constant.TAG_ERROR_CHECKOUT_VALIDATION);
                } else if (validateCheckoutObjectIsEmpty(this.checkout)) {
                    transactionError(Constant.TAG_ERROR_CHECKOUT_EMPTY_VALIDATION_CODE, Constant.TAG_ERROR_CHECKOUT_EMPTY_VALIDATION);
                } else if (validateCheckoutObjectHasSpace(this.checkout)) {
                    transactionError(Constant.TAG_ERROR_CHECKOUT_SPACE_VALIDATION_CODE, Constant.TAG_ERROR_CHECKOUT_SPACE_VALIDATION);
                } else if (isInvalidAadharNumber(this.checkout)) {
                    transactionError(Constant.TAG_ERROR_AADHAR_VALIDATION_CODE, Constant.TAG_ERROR_AADHAR_VALIDATION);
                } else if (isInvalidIFSC(this.checkout)) {
                    transactionError(Constant.TAG_ERROR_IFSC_VALIDATION_CODE, Constant.TAG_ERROR_IFSC_VALIDATION);
                } else if (isInvalidAccName(this.checkout)) {
                    transactionError(Constant.TAG_ERROR_ACC_HOLDER_NAME_VALIDATION_CODE, Constant.TAG_ERROR_ACC_HOLDER_NAME_VALIDATION);
                } else if (isInvalidAccNo(this.checkout)) {
                    transactionError(Constant.TAG_ERROR_ACC_NO_VALIDATION_CODE, Constant.TAG_ERROR_ACC_NO_VALIDATION);
                } else if (this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CARDS)) {
                    startCardNetworkTask("00000");
                } else {
                    startPMICall();
                }
            } else if (validateCheckoutObjectIsEmpty(this.checkout)) {
                transactionError(Constant.TAG_ERROR_CHECKOUT_EMPTY_VALIDATION_CODE, Constant.TAG_ERROR_CHECKOUT_EMPTY_VALIDATION);
            } else if (validateCheckoutObjectHasSpace(this.checkout)) {
                transactionError(Constant.TAG_ERROR_CHECKOUT_SPACE_VALIDATION_CODE, Constant.TAG_ERROR_CHECKOUT_SPACE_VALIDATION);
            } else {
                startPMICall();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("==>>");
        outline73.append(this.TAG);
        Constant.showOutputLog(outline73.toString(), "onDestroy");
        this.dataFragment.setData(this.dataObject);
    }

    @Subscribe
    public void onEvent(i iVar) {
        Constant.showOutputLog(this.TAG, "got PMI response");
        hideProgressLoader();
        this.listVaulted.setVisibility(0);
        long time = new Date().getTime() - this.startTime.getTime();
        if (iVar.getmPMIresponse() != null) {
            Constant.showOutputLog(this.TAG, iVar.getmPMIresponse().toString());
            this.dataObject.setPmiResponseData(iVar.getmPMIresponse());
            this.dataFragment.setData(this.dataObject);
            this.isDataLoaded = true;
            if (iVar.getmPMIresponse().getError().getErrorCode().isEmpty()) {
                setCardBinFormat();
                k instruction = this.checkout.getMerchantRequestPayload().getPayment().getInstruction();
                if (iVar.getmPMIresponse().getSIEnable().equalsIgnoreCase("S") || iVar.getmPMIresponse().getSIEnable().equalsIgnoreCase("SI") || !instruction.getAction().equalsIgnoreCase("Y")) {
                    Checkout checkout2 = this.checkout;
                    d dVar = this.mServiceManager;
                    String str = Constant.TAG_ERROR_DEFAULT_ERROR;
                    String str2 = "Y";
                    d dVar2 = dVar;
                    String str3 = Constant.TAG_ERROR_DEFAULT_ERROR_CODE;
                    b.callEventLogging(Constant.REQUEST_TYPE_PMI, "load", "checkoutUI:loaded", time, "PASS", checkout2, "", "", "", "", dVar2, this);
                    this.pmiBanks = iVar.getmPMIresponse().getBanks();
                    f customerVault = iVar.getmPMIresponse().getCustomerVault();
                    if (this.pmiBanks.getDigitalMandate() != null && (this.pmiBanks.getDigitalMandate().getTopBanksCount() > 0 || this.pmiBanks.getDigitalMandate().getOtherBanksCount() > 0)) {
                        if ((instruction.getAction() == null || !instruction.getAction().equalsIgnoreCase(str2)) && !instruction.getAction().equalsIgnoreCase("N") && !instruction.getAction().equalsIgnoreCase("A")) {
                            this.pmiBanks.setDigitalMandate(null);
                        } else {
                            com.paynimo.android.payment.model.response.k.a aVar = this.pmiBanks;
                            aVar.setDigitalMandate(aVar.getDigitalMandate());
                        }
                    }
                    if (instruction.getAction().equalsIgnoreCase(str2) && (this.requestedPaymentMethod.equalsIgnoreCase("All") || this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING))) {
                        com.paynimo.android.payment.model.response.k.h digitalMandate = this.pmiBanks.getDigitalMandate();
                        com.paynimo.android.payment.model.response.k.d cards = this.pmiBanks.getCards();
                        if (digitalMandate != null || (cards != null && ((cards.getCredit() != null && !cards.getCredit().isEmpty()) || ((cards.getDebit() != null && !cards.getDebit().isEmpty()) || ((cards.getAmex() != null && !cards.getAmex().isEmpty()) || ((cards.getDiner() != null && !cards.getDiner().isEmpty()) || ((cards.getDiscover() != null && !cards.getDiscover().isEmpty()) || ((cards.getIvr() != null && !cards.getIvr().isEmpty()) || (cards.getRupay() != null && !cards.getRupay().isEmpty()))))))))) {
                            Intent authorizationIntent = com.paynimo.android.payment.DigitalMandateActivity.Factory.getAuthorizationIntent(getApplicationContext(), true);
                            authorizationIntent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.savedCheckout);
                            authorizationIntent.putExtra(Constant.ARGUMENT_DATA_PMI_RESPONSE, iVar.getmPMIresponse());
                            authorizationIntent.putExtra(PaymentActivity.EXTRA_REQUESTED_PAYMENT_MODE, this.requestedPaymentMethod);
                            startActivityForResult(authorizationIntent, PaymentActivity.REQUEST_CODE);
                            return;
                        }
                        Constant.showOutputLog(this.TAG, "got NULL Banks value in PMI response");
                        transactionError(Constant.TAG_ERROR_REQUEST_PAYMENT_MODE_CODE, Constant.TAG_ERROR_REQUEST_PAYMENT_MODE);
                    } else if (this.pmiBanks != null && customerVault != null && ((instruction.getAction().equalsIgnoreCase(str2) || this.checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase(str2)) && this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CARDS))) {
                        proceedWithBankNumber();
                    } else if (this.checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase(str2) && isMerchantSpecificDataValid(this.requestedPaymentMethod) && !this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CARDS) && !this.requestedPaymentMethod.equalsIgnoreCase("UPI") && !this.requestedPaymentMethod.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_WALLETS)) {
                        proceedWithBankCode(this.checkout.getMerchantRequestPayload().getPayment().getMethod().getToken());
                    } else if (this.pmiBanks == null || customerVault == null || instruction.getAction().equalsIgnoreCase(str2)) {
                        Constant.showOutputLog(this.TAG, "got NULL Banks value in PMI response");
                        transactionError(str3, str);
                    } else {
                        setModes(this.pmiBanks, customerVault);
                    }
                } else {
                    b.callEventLogging(Constant.REQUEST_TYPE_PMI, "load", "checkoutUI:loaded", time, GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
                    transactionError(Constant.TAG_ERROR_SI_NOT_ENABLED_CODE, Constant.TAG_ERROR_SI_NOT_ENABLED);
                }
            } else {
                Constant.showOutputLog(this.TAG, "Null Banks data response");
                b.callEventLogging(Constant.REQUEST_TYPE_PMI, "load", "checkoutUI:loaded", time, GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
                transactionError(iVar.getmPMIresponse().getError().getErrorCode(), iVar.getmPMIresponse().getError().getErrorDesc());
            }
        } else {
            Constant.showOutputLog(this.TAG, "Null PMI response");
            b.callEventLogging(Constant.REQUEST_TYPE_PMI, "load", "checkoutUI:loaded", time, GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
            transactionError(Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i;
        if (adapterView.getId() == getResources().getIdentifier("paynimo_list_payment_modes", "id", getApplicationContext().getPackageName())) {
            String str = this.payment_enabled_modes_list.get(i2);
            b.callEventLogging("", "click", GeneratedOutlineSupport.outline50("nav:", str), 0, "PASS", this.checkout, str, "", "", "", this.mServiceManager, this);
            openRequestedFragment(str, new c(), SINGLE_PAYMENT_MODE_OFF);
        } else if (adapterView.getId() == getResources().getIdentifier("paynimo_list_payment_vaulted_modes", "id", getApplicationContext().getPackageName())) {
            HashMap hashMap = this.vaultedDataList.get(i2);
            if (hashMap.containsKey(VAULT_ROW_TYPE)) {
                String str2 = (String) hashMap.get(VAULT_ROW_TYPE);
                if (str2.equalsIgnoreCase(VAULT_TYPE_CARDS) || str2.equalsIgnoreCase(VAULT_TYPE_IMPS)) {
                    openVaultDialog(str2, (c) hashMap.get(VAULT_ROW_DATA));
                } else if (str2.equalsIgnoreCase(VAULT_TYPE_OTHER_OPTIONS)) {
                    b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", 0, "PASS", this.checkout, "", "", "", "", this.mServiceManager, this);
                    openRequestedFragment((String) hashMap.get(VAULT_ROW_TEXT), new c(), SINGLE_PAYMENT_MODE_OFF);
                } else {
                    str2.equalsIgnoreCase(VAULT_TYPE_HEADERS);
                }
            }
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onPause() {
        super.onPause();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("==>>");
        outline73.append(this.TAG);
        Constant.showOutputLog(outline73.toString(), "onPause");
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.settingsData = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.checkout = (Checkout) bundle.getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
    }

    public void onResume() {
        super.onResume();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("==>>");
        outline73.append(this.TAG);
        Constant.showOutputLog(outline73.toString(), "onResume");
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, this.checkout);
        bundle.putParcelable(Constant.ARGUMENT_DATA_SETTING, this.settingsData);
        super.onSaveInstanceState(bundle);
    }

    public void prepareVaultedCardPayment(String str, String str2, String str3) {
        c cVar = new c();
        cVar.setCardIssuerAuthority(str);
        cVar.setCardId(str2);
        cVar.setAliasName(str3);
        openRequestedFragment(PaymentActivity.PAYMENT_METHOD_CARDS, cVar, SINGLE_PAYMENT_MODE_OFF);
    }

    public void prepareVaultedIMPSPayment(String str, String str2, String str3) {
        c cVar = new c();
        cVar.setCardIssuerAuthority(str);
        cVar.setCardId(str2);
        cVar.setAliasName(str3);
        openRequestedFragment("IMPS", cVar, SINGLE_PAYMENT_MODE_OFF);
    }

    public void showAlertDialog(int i, final String str, final String str2) {
        final Dialog dialog = new Dialog(this.activitycontxt);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_custom_dialog_text", "id", dialog)).setText(getResources().getString(getResources().getIdentifier("paynimo_payments_error", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_custom_dialog_ButtonOK", "id", dialog)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ((Button) GeneratedOutlineSupport.outline20(this, getResources(), "paynimo_custom_dialog_ButtonCancel", "id", dialog)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                PaymentModesActivity.this.transactionError(str, str2);
            }
        });
        dialog.show();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startDeRegisterCardNetworkTask(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            if (r6 == 0) goto L_0x005a
            boolean r2 = r6.isEmpty()
            if (r2 != 0) goto L_0x005a
            r2 = -2
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r5)     // Catch:{ Exception -> 0x0056 }
            if (r3 == 0) goto L_0x0048
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x0061
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "CDR"
            r3.setTransactionRequestType(r4)     // Catch:{ Exception -> 0x0044 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "C"
            r3.setPaymentMethodType(r4)     // Catch:{ Exception -> 0x0044 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "N"
            r3.setTransactionIsRegistration(r4)     // Catch:{ Exception -> 0x0044 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0044 }
            r3.setPaymentInstrumentToken(r6)     // Catch:{ Exception -> 0x0044 }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkout     // Catch:{ Exception -> 0x0044 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0044 }
            r5.request_payload = r6     // Catch:{ Exception -> 0x0044 }
            r5.showProgressLoader()     // Catch:{ Exception -> 0x0044 }
            com.paynimo.android.payment.b.d r6 = r5.mServiceManager     // Catch:{ Exception -> 0x0044 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r5.request_payload     // Catch:{ Exception -> 0x0044 }
            r6.callCardDeregisterRequest(r3, r5)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0061
        L_0x0044:
            r5.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x0056 }
            goto L_0x0061
        L_0x0048:
            de.greenrobot.event.EventBus r6 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.event.g r3 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0056 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ Exception -> 0x0056 }
            r6.post(r3)     // Catch:{ Exception -> 0x0056 }
            goto L_0x0061
        L_0x0056:
            r5.showAlertDialog(r2, r1, r0)
            goto L_0x0061
        L_0x005a:
            java.lang.String r6 = r5.TAG
            java.lang.String r0 = " BankCode is EMPTY or NULL"
            com.paynimo.android.payment.util.Constant.showOutputLog(r6, r0)
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.PaymentModesActivity.startDeRegisterCardNetworkTask(java.lang.String):void");
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.h hVar) {
        hideProgressLoader();
        b.callEventLogging(Constant.REQUEST_TYPE_PMI, "load", "checkoutUI:loaded", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
        transactionError(Constant.TAG_ERROR_NETWORK_ERROR_CODE, hVar.getError().getErrorDesc());
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.d dVar) {
        Constant.showOutputLog(this.TAG, "got CDR response");
        hideProgressLoader();
        if (dVar.getResponse() != null) {
            Constant.showOutputLog(this.TAG, dVar.getResponse().toString());
            try {
                if (dVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    h paymentMethod = dVar.getResponse().getPaymentMethod();
                    if (paymentMethod == null) {
                        Constant.showOutputLog(this.TAG, "got NULL PaymentMethod value in CDR response");
                    } else if (paymentMethod.getPaymentTransaction().getStatusCode().equalsIgnoreCase("0300")) {
                        String instrumentToken = paymentMethod.getInstrumentToken();
                        for (HashMap next : this.vaultedDataList) {
                            if (next.containsKey(VAULT_ROW_TYPE) && next.containsValue(VAULT_TYPE_CARDS) && ((c) next.get(VAULT_ROW_DATA)).getCardId().equals(instrumentToken)) {
                                this.vaultedDataList.remove(next);
                                this.listMultipleRowAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                    } else {
                        showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
                    }
                } else {
                    transactionError(dVar.getResponse().getPaymentMethod().getError().getCode(), dVar.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception unused) {
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            Constant.showOutputLog(this.TAG, "Null CDR response");
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.c cVar) {
        hideProgressLoader();
        showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, cVar.getError().getDesc());
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b5 A[Catch:{ Exception -> 0x0338 }] */
    @de.greenrobot.event.Subscribe
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEvent(com.paynimo.android.payment.event.w r16) {
        /*
            r15 = this;
            r13 = r15
            java.lang.String r0 = r13.TAG
            java.lang.String r1 = "got Bin Check response"
            com.paynimo.android.payment.util.Constant.showOutputLog(r0, r1)
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()
            r14 = 1
            if (r0 == 0) goto L_0x033b
            long r0 = com.android.tools.r8.GeneratedOutlineSupport.outline13()
            java.util.Date r2 = r13.startTime
            long r2 = r2.getTime()
            long r3 = r0 - r2
            com.paynimo.android.payment.model.Checkout r6 = r13.checkout
            com.paynimo.android.payment.b.d r11 = r13.mServiceManager
            java.lang.String r0 = ""
            java.lang.String r1 = "load"
            java.lang.String r2 = "Cards:CONSOLIDATED_BIN_CHECK"
            java.lang.String r5 = "PASS"
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r12 = r15
            com.paynimo.android.payment.util.b.callEventLogging(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12)
            java.lang.String r0 = r13.TAG
            com.paynimo.android.payment.model.response.c r1 = r16.getResponse()
            java.lang.String r1 = r1.toString()
            com.paynimo.android.payment.util.Constant.showOutputLog(r0, r1)
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getAllowed()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0335
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getAllowed()     // Catch:{ Exception -> 0x0338 }
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r2 = "Enter valid Card details"
            java.lang.String r3 = "ERROR_PAYNIMO_023"
            if (r1 != 0) goto L_0x00ab
            java.lang.String r1 = "yes"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x00ab
            r13.isCardBinValid = r14     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCard_issuer_authority()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0088
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCard_issuer_authority()     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r0 != 0) goto L_0x0088
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCard_issuer_authority()     // Catch:{ Exception -> 0x0338 }
            r13.issuer = r0     // Catch:{ Exception -> 0x0338 }
        L_0x0088:
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCard_type()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x00b1
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCard_type()     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r0 != 0) goto L_0x00b1
            com.paynimo.android.payment.model.response.c r0 = r16.getResponse()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCard_type()     // Catch:{ Exception -> 0x0338 }
            r13.inputCardType = r0     // Catch:{ Exception -> 0x0338 }
            goto L_0x00b1
        L_0x00ab:
            r0 = 0
            r13.isCardBinValid = r0     // Catch:{ Exception -> 0x0338 }
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
        L_0x00b1:
            boolean r0 = r13.isTxnMerchantInitiated     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0361
            boolean r0 = r13.isCardBinValid     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0331
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r13.cardType     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.Maestro     // Catch:{ Exception -> 0x0338 }
            java.lang.String r4 = "DBT"
            java.lang.String r5 = ""
            java.lang.String r6 = "CRT"
            if (r0 != r1) goto L_0x016a
            java.lang.String r0 = r13.issuer     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x012f
            java.lang.String r0 = r13.issuer     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r1 = "maestro"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x012f
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0103
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0103
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCredit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x00fe
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x00fe
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x00fe:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0103:
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0361
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0361
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDebit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x012a
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x012a
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x012a:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x012f:
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCredit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x014a
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x014a
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x014a:
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDebit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0165
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x0165
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0165:
            r15.startCardNetworkTask(r5)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x016a:
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r13.cardType     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.AmericanExpress     // Catch:{ Exception -> 0x0338 }
            if (r0 != r1) goto L_0x0190
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getAmex()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x018b
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x018b
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x018b:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0190:
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r13.cardType     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.DinersClub     // Catch:{ Exception -> 0x0338 }
            if (r0 != r1) goto L_0x01b6
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDiner()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x01b1
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x01b1
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x01b1:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x01b6:
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r13.cardType     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.Discover     // Catch:{ Exception -> 0x0338 }
            if (r0 != r1) goto L_0x01dc
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDiscover()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x01d7
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x01d7
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x01d7:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x01dc:
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r13.cardType     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.Rupay     // Catch:{ Exception -> 0x0338 }
            if (r0 != r1) goto L_0x02a2
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getRupay()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x01fd
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x01fd
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x01fd:
            java.lang.String r0 = r13.issuer     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0267
            java.lang.String r0 = r13.issuer     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r1 = "rupay"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0267
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x023b
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x023b
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCredit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0236
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x0236
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0236:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x023b:
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0361
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0361
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDebit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0262
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x0262
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0262:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0267:
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCredit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0282
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x0282
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0282:
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDebit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x029d
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x029d
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x029d:
            r15.startCardNetworkTask(r5)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x02a2:
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x02ce
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x02ce
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCredit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x02c9
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02c9
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x02c9:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x02ce:
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x02f9
            java.lang.String r0 = r13.inputCardType     // Catch:{ Exception -> 0x0338 }
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x02f9
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDebit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x02f5
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f5
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x02f5:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x02f9:
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getCredit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x0313
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x0313
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0313:
            com.paynimo.android.payment.model.response.k.a r0 = r13.pmiBanks     // Catch:{ Exception -> 0x0338 }
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.getDebit()     // Catch:{ Exception -> 0x0338 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x032d
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0338 }
            if (r1 != 0) goto L_0x032d
            r15.startCardNetworkTask(r0)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x032d:
            r15.startCardNetworkTask(r5)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0331:
            r15.transactionError(r3, r2)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0335:
            r13.isCardBinValid = r14     // Catch:{ Exception -> 0x0338 }
            goto L_0x0361
        L_0x0338:
            r13.isCardBinValid = r14
            goto L_0x0361
        L_0x033b:
            long r0 = com.android.tools.r8.GeneratedOutlineSupport.outline13()
            java.util.Date r2 = r13.startTime
            long r2 = r2.getTime()
            long r3 = r0 - r2
            com.paynimo.android.payment.model.Checkout r6 = r13.checkout
            com.paynimo.android.payment.b.d r11 = r13.mServiceManager
            java.lang.String r0 = ""
            java.lang.String r1 = "load"
            java.lang.String r2 = "Cards:CONSOLIDATED_BIN_CHECK"
            java.lang.String r5 = "FAIL"
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r12 = r15
            com.paynimo.android.payment.util.b.callEventLogging(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.isCardBinValid = r14
        L_0x0361:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.PaymentModesActivity.onEvent(com.paynimo.android.payment.event.w):void");
    }

    @Subscribe
    public void onEvent(v vVar) {
        this.isCardBinValid = false;
        b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
        transactionError(Constant.TAG_ERROR_CARD_VALIDATION_CODE, Constant.TAG_ERROR_CARD_VALIDATION);
    }

    @Subscribe
    public void onEvent(c0 c0Var) {
        Constant.showOutputLog(this.TAG, "got TWD response");
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(8);
        if (c0Var.getResponse() != null) {
            b.callEventLogging("", "click", "button:CardSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", "", this.issuer, this.inputCardType, this.mServiceManager, this);
            Constant.showOutputLog(this.TAG, c0Var.getResponse().toString());
            try {
                if (c0Var.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    h paymentMethod = c0Var.getResponse().getPaymentMethod();
                    String responseType = c0Var.getResponse().getResponseType();
                    String subType = paymentMethod.getAuthentication().getSubType();
                    if (responseType == null || responseType.trim().length() == 0) {
                        Constant.showOutputLog(this.TAG, "got NULL PaymentMethod value in Twd response");
                    } else if (subType == null || !subType.equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_3DS) || !responseType.equalsIgnoreCase("web")) {
                        String str = this.TAG;
                        Constant.showOutputLog(str, " Subtype is not 3ds=================>>>" + subType);
                    } else {
                        Constant.showOutputLog(this.TAG, "3DS condition verified");
                        prepareWebviewDataForCards(paymentMethod);
                    }
                } else {
                    transactionError(c0Var.getResponse().getPaymentMethod().getError().getCode(), c0Var.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception unused) {
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            b.callEventLogging("", "click", "button:CardSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", this.issuer, this.inputCardType, this.mServiceManager, this);
            Constant.showOutputLog(this.TAG, "Null TWD response");
        }
    }

    @Subscribe
    public void onEvent(b0 b0Var) {
        b.callEventLogging("", "click", "button:CardSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", this.issuer, this.inputCardType, this.mServiceManager, this);
        b0Var.getError();
        throw null;
    }

    @Subscribe
    public void onEvent(y yVar) {
        Constant.showOutputLog(this.TAG, "got TAR response");
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(8);
        if (yVar.getResponse() != null) {
            b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(this.TAG, yVar.getResponse().toString());
            try {
                if (yVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    Intent intent = new Intent();
                    Checkout checkout2 = new Checkout();
                    checkout2.setMerchantResponsePayload(yVar.getResponse());
                    intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout2);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                transactionError(yVar.getResponse().getPaymentMethod().getError().getCode(), yVar.getResponse().getPaymentMethod().getError().getDesc());
            } catch (Exception unused) {
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(this.TAG, "Null TAR response");
        }
    }

    @Subscribe
    public void onEvent(x xVar) {
        b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
        transactionError(Constant.TAG_ERROR_NETWORK_ERROR_CODE, xVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(a0 a0Var) {
        Constant.showOutputLog(this.TAG, "got T response");
        if (a0Var.getResponse() != null) {
            b.callEventLogging("T", "click", GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("button:"), this.requestedPaymentMethod, "Submit"), GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, this.requestedPaymentMethod, "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(this.TAG, a0Var.getResponse().toString());
            try {
                if (a0Var.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    h paymentMethod = a0Var.getResponse().getPaymentMethod();
                    if (paymentMethod != null) {
                        prepareWebviewDataForBank(paymentMethod);
                    } else {
                        Constant.showOutputLog(this.TAG, "got NULL PaymentMethod value in T response");
                    }
                } else {
                    transactionError(a0Var.getResponse().getPaymentMethod().getError().getCode(), a0Var.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception unused) {
                transactionError(a0Var.getResponse().getPaymentMethod().getError().getCode(), a0Var.getResponse().getPaymentMethod().getError().getDesc());
            }
        } else {
            b.callEventLogging("T", "click", GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("button:"), this.requestedPaymentMethod, "Submit"), GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, PaymentActivity.PAYMENT_METHOD_NETBANKING, "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(this.TAG, "Null T response");
        }
    }

    @Subscribe
    public void onEvent(z zVar) {
        b.callEventLogging("T", "click", GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("button:"), this.requestedPaymentMethod, "Submit"), GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, PaymentActivity.PAYMENT_METHOD_NETBANKING, "", "", "", this.mServiceManager, this);
        transactionError(Constant.TAG_ERROR_NETWORK_ERROR_CODE, zVar.getError().getDesc());
    }
}
