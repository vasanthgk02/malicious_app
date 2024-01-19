package com.paynimo.android.payment;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.CardTypeParser.CardType;
import com.paynimo.android.payment.a.a;
import com.paynimo.android.payment.a.b;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.o;
import com.paynimo.android.payment.event.p;
import com.paynimo.android.payment.event.q;
import com.paynimo.android.payment.event.s;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.request.k;
import com.paynimo.android.payment.model.response.e;
import com.paynimo.android.payment.model.response.k.g;
import com.paynimo.android.payment.model.response.k.h;
import com.paynimo.android.payment.model.response.k.i;
import com.paynimo.android.payment.model.response.k.j;
import com.paynimo.android.payment.model.response.k.m;
import com.paynimo.android.payment.model.response.k.n;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.util.Constant;
import com.paynimo.android.payment.util.c;
import com.paynimo.android.payment.util.f;
import com.smartfoxserver.bitswarm.util.Logging;
import com.xiaomi.mipush.sdk.Constants;
import de.greenrobot.event.Subscribe;
import in.juspay.hypersdk.core.InflateView;
import java.io.File;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.apache.fontbox.afm.AFMParser;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DigitalMandateActivity extends EventedBaseActivity implements OnClickListener {
    public static final String ACTION_ESIGNRESPONSE = "com.nsdl.egov.esign.rdservice.fp.CAPTURE";
    public static String CARD_NOT_SUPPORTED = "Currently we are not supporting your card. Please try with some other card.";
    public static final String EAUTH_MODE = "AADHAAR";
    public static final String EMANDATE_MODE = "NETBANKING";
    public static final String ENACH_MODE = "ENACH";
    public static final int MANDATE_MODE_EAUTH = 0;
    public static final int MANDATE_MODE_EMANDATE = 1;
    public static final int MANDATE_MODE_ENACH = 2;
    public static final int MAX_NEEDED_NUMBERS = 6;
    public static final int PERMISSION_REQUEST_CODE = 11;
    public static final int REQUEST_CODE = 100;
    public static final String TAG = "DigitalMandateAct";
    public static Context application_context = null;
    public static final int centuryPrefix = 0;
    public static final int milleniumPrefix = 2;
    public static Context myContext;
    public TextWatcher CCTextWatcher = new TextWatcher() {
        public int ccardLength = 0;
        public boolean isDelete = false;

        public void afterTextChanged(Editable editable) {
            EditText access$3900 = DigitalMandateActivity.this.et_cardNumber;
            DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
            access$3900.setTextColor(ContextCompat.getColor(digitalMandateActivity, digitalMandateActivity.getResources().getIdentifier("defaultTextColor", "color", DigitalMandateActivity.this.getPackageName())));
            String showCCardWithIntervals = DigitalMandateActivity.this.showCCardWithIntervals(DigitalMandateActivity.this.et_cardNumber.getText().toString().replaceAll("\\s", ""), DigitalMandateActivity.this.cardType);
            this.isDelete = this.ccardLength >= showCCardWithIntervals.length();
            String replaceAll = showCCardWithIntervals.substring(0, Math.min(7, showCCardWithIntervals.length())).replaceAll("\\s", "");
            if (DigitalMandateActivity.this.firstNumbers == null || !DigitalMandateActivity.this.firstNumbers.equals(replaceAll)) {
                DigitalMandateActivity.this.firstNumbers = replaceAll;
                DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                digitalMandateActivity2.cardType = CardType.getCardType(digitalMandateActivity2.firstNumbers, DigitalMandateActivity.this.paymentSettings.getAllowedCardTypes());
                DigitalMandateActivity.this.et_cardNumber.setFilters(new InputFilter[]{new LengthFilter(DigitalMandateActivity.this.cardType.getNumberOfIntervals() + DigitalMandateActivity.this.cardType.getMaxLength())});
            }
            DigitalMandateActivity digitalMandateActivity3 = DigitalMandateActivity.this;
            CardValidator.isValidCardType(digitalMandateActivity3, digitalMandateActivity3.et_cardNumber, DigitalMandateActivity.this.cardType);
            if (DigitalMandateActivity.this.cardType == CardType.YetUnknown || DigitalMandateActivity.this.cardType == CardType.Invalid) {
                DigitalMandateActivity.this.card_imageview.setVisibility(8);
            } else {
                DigitalMandateActivity.this.card_imageview.setVisibility(0);
                DigitalMandateActivity.this.card_imageview.setImageResource(DigitalMandateActivity.this.cardType.getImageId());
                DigitalMandateActivity digitalMandateActivity4 = DigitalMandateActivity.this;
                digitalMandateActivity4.cardDataType = digitalMandateActivity4.cardType.toString();
            }
            int numberOfIntervals = DigitalMandateActivity.this.cardType.getNumberOfIntervals() + DigitalMandateActivity.this.cardType.getMaxLength();
            if (showCCardWithIntervals.length() > numberOfIntervals) {
                showCCardWithIntervals = showCCardWithIntervals.substring(0, numberOfIntervals);
            }
            DigitalMandateActivity.this.et_cardNumber.removeTextChangedListener(this);
            DigitalMandateActivity digitalMandateActivity5 = DigitalMandateActivity.this;
            int cCardMarkerPosition = digitalMandateActivity5.getCCardMarkerPosition(digitalMandateActivity5.et_cardNumber.getSelectionStart(), this.isDelete, DigitalMandateActivity.this.cardType);
            DigitalMandateActivity.this.et_cardNumber.setText(showCCardWithIntervals);
            EditText access$39002 = DigitalMandateActivity.this.et_cardNumber;
            if (cCardMarkerPosition >= showCCardWithIntervals.length()) {
                cCardMarkerPosition = showCCardWithIntervals.length();
            }
            access$39002.setSelection(cCardMarkerPosition);
            DigitalMandateActivity.this.et_cardNumber.addTextChangedListener(this);
            if (DigitalMandateActivity.this.cardType != CardType.Invalid) {
                if (showCCardWithIntervals.length() == DigitalMandateActivity.this.cardType.getNumberOfIntervals() + DigitalMandateActivity.this.cardType.getMaxLength()) {
                    DigitalMandateActivity digitalMandateActivity6 = DigitalMandateActivity.this;
                    if (CardValidator.validateCreditCardNumber(digitalMandateActivity6, digitalMandateActivity6.et_cardNumber, DigitalMandateActivity.this.cardType, DigitalMandateActivity.this.paymentSettings.getAllowedCardTypes())) {
                        DigitalMandateActivity.this.et_dateText.requestFocus();
                        String replace = showCCardWithIntervals.replace(CMap.SPACE, "");
                        if (replace != null) {
                            DigitalMandateActivity.this.startBinCheckTask(replace.substring(0, 6), "", "", "Y", "Y");
                        }
                    }
                }
            }
            this.ccardLength = showCCardWithIntervals.length();
            if (DigitalMandateActivity.this.cardType != CardType.Invalid) {
                DigitalMandateActivity.this.et_verificationText.setFilters(new InputFilter[]{new LengthFilter(DigitalMandateActivity.this.cardType.getCVCLength())});
                if (DigitalMandateActivity.this.et_verificationText.length() > 0) {
                    DigitalMandateActivity digitalMandateActivity7 = DigitalMandateActivity.this;
                    CardValidator.validateCheckNumber(digitalMandateActivity7, digitalMandateActivity7.et_verificationText, DigitalMandateActivity.this.cardType);
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            DigitalMandateActivity.this.tvSIErrorBlock.setText("");
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public Bundle PaymentSettingsBundle;
    public a adapter;
    public ArrayAdapter<String> adapter_amountType;
    public ArrayAdapter<String> adapter_debitDay;
    public ArrayAdapter<String> adapter_frequency;
    public String bankAcsBiometricUrl;
    public HashMap<String, g> banksData = new HashMap<>();
    public ArrayList<g> banksList = new ArrayList<>();
    public Button btn_pay;
    public Calendar cal;
    public String cardDataType = "";
    public CardType cardType = CardType.YetUnknown;
    public ImageView card_imageview;
    public Checkout checkout;
    public boolean consumable;
    public Fragment currFragment;
    public TextWatcher dateTextWatcher = new TextWatcher() {
        public int dateCursor;
        public int dateLength;
        public String formatedDate;
        public boolean isDateDelete = false;

        public void afterTextChanged(Editable editable) {
            EditText access$4500 = DigitalMandateActivity.this.et_dateText;
            DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
            access$4500.setTextColor(ContextCompat.getColor(digitalMandateActivity, digitalMandateActivity.getResources().getIdentifier("defaultTextColor", "color", DigitalMandateActivity.this.getPackageName())));
            String obj = DigitalMandateActivity.this.et_dateText.getText().toString();
            this.formatedDate = obj;
            this.isDateDelete = this.dateLength > obj.length();
            DigitalMandateActivity.this.et_dateText.removeTextChangedListener(this);
            this.dateCursor = DigitalMandateActivity.this.et_dateText.getSelectionStart();
            dateFormated(this.isDateDelete);
            DigitalMandateActivity.this.et_dateText.setText(this.formatedDate);
            DigitalMandateActivity.this.et_dateText.setSelection(this.dateCursor);
            DigitalMandateActivity.this.et_dateText.addTextChangedListener(this);
            if (this.formatedDate.length() > 4) {
                if (CardValidator.validateDateFormat(this.formatedDate)) {
                    DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                    if (CardValidator.validateDate((Context) digitalMandateActivity2, digitalMandateActivity2.et_dateText, false)) {
                        DigitalMandateActivity.this.et_verificationText.requestFocus();
                    }
                }
                EditText access$45002 = DigitalMandateActivity.this.et_dateText;
                DigitalMandateActivity digitalMandateActivity3 = DigitalMandateActivity.this;
                access$45002.setTextColor(ContextCompat.getColor(digitalMandateActivity3, digitalMandateActivity3.getResources().getIdentifier("errorTextColor", "color", DigitalMandateActivity.this.getPackageName())));
            }
            this.dateLength = this.formatedDate.length();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void dateFormated(boolean z) {
            String replaceAll = this.formatedDate.replaceAll("/", "");
            this.formatedDate = replaceAll;
            if (replaceAll.length() == 3 && !z) {
                int i = this.dateCursor;
                if (i == 3) {
                    this.dateCursor = i + 1;
                }
            }
            if (this.formatedDate.length() == 2 && z) {
                int i2 = this.dateCursor;
                if (i2 > 1) {
                    this.dateCursor = i2 - 1;
                }
            }
            if (this.formatedDate.length() > 2) {
                this.formatedDate = this.formatedDate.substring(0, 2) + "/" + this.formatedDate.substring(2);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public int day;
    public List<String> debitDaysList = new ArrayList();
    public int default_cvv_digit = 2;
    public EditText dm_et_account_number;
    public List<Integer> eNachModeList = new ArrayList();
    public List<Integer> eSign = new ArrayList();
    public OnDateSetListener endDatePickerListener = new OnDateSetListener() {
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
            EditText access$3700 = DigitalMandateActivity.this.et_debit_end_date;
            StringBuilder sb = new StringBuilder();
            sb.append(outline41);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(outline412);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(i);
            access$3700.setText(sb);
        }
    };
    public EditText et_aadhar_number;
    public EditText et_account_holder_name;
    public EditText et_account_number;
    public EditText et_amount_debit;
    public EditText et_cardNumber;
    public EditText et_dateText;
    public EditText et_debit_end_date;
    public EditText et_debit_start_date;
    public EditText et_email_id;
    public EditText et_ifsc_code;
    public EditText et_mobile_number;
    public EditText et_nameText;
    public EditText et_pan_number;
    public EditText et_phone_number;
    public EditText et_verificationText;
    public String firstNumbers;
    public ImageButton ibEndDate;
    public ImageButton ibStartDate;
    public String inputCardType;
    public boolean isCardBinValid;
    public boolean isNACH = false;
    public boolean isSafestoreEnabled;
    public String issuer;
    public LinearLayout lyt_bank_details;
    public LinearLayout lyt_bank_list;
    public LinearLayout lyt_card;
    public LinearLayout lyt_debit_day;
    public LinearLayout lyt_dm_tab;
    public LinearLayout lyt_enach;
    public LinearLayout lyt_rdo_group;
    public com.paynimo.android.payment.b.a mService;
    public d mServiceManager;
    public Map<String, String> mapInstrumentAmountType = new LinkedHashMap();
    public Map<String, String> mapInstrumentFrequency = new LinkedHashMap();
    public int month;
    public String msg;
    public LinearLayout n_lyt_debit_day;
    public LinearLayout n_lyt_enach;
    public Spinner n_spinner_debitDay;
    public TextView n_tv_amountType;
    public TextView n_tv_amount_debit;
    public TextView n_tv_debit_end_date;
    public TextView n_tv_debit_start_date;
    public TextView n_tv_frequency;
    public TextView n_tv_mandate_purpose;
    public TextView n_tv_utility_no;
    public Settings paymentSettings;
    public PaymentType paymentType;
    public r pmiData;
    public RadioButton rdo_OTP;
    public RadioButton rdo_account;
    public RadioButton rdo_biometric;
    public RadioButton rdo_card;
    public RadioButton rdo_debit_card;
    public RadioButton rdo_netbanking;
    public RequestPayload request_payload;
    public String requestedPaymentMethod;
    public c resultType;
    public RadioGroup rg_esign_modes;
    public RadioGroup rg_mode;
    public Checkout savedCheckout;
    public ScrollView scroll_main;
    public String selected_bank = "";
    public String selected_bank_name = "";
    public LinearLayout si_container;
    public LinearLayout si_non_edit_container;
    public Spinner spinner_account_type;
    public Spinner spinner_amountType;
    public Spinner spinner_debitDay;
    public Spinner spinner_frequency;
    public Spinner spinner_top_banks;
    public OnDateSetListener startDatePickerListener = new OnDateSetListener() {
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
            EditText access$3600 = DigitalMandateActivity.this.et_debit_start_date;
            access$3600.setText((outline41 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + outline412 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i).trim());
        }
    };
    public Date startTime;
    public TabLayout tabLayout;
    public String token = "";
    public TextView tvSIErrorBlock;
    public TextView tv_bank_address;
    public TextView tv_bank_branch;
    public TextView tv_bank_district;
    public TextView tv_bank_error_text;
    public TextView tv_bank_micr;
    public TextView tv_bank_name;
    public TextView tv_bank_state;
    public TextView tv_biometric_note_text;
    public TextView tv_mandate_purpose;
    public TextView tv_register_mandate;
    public TextView tv_select_bank;
    public TextView tv_utility_no;
    public TextWatcher validationTextWatcher = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
            try {
                if (DigitalMandateActivity.this.cardDataType.equalsIgnoreCase("AmericanExpress")) {
                    if (DigitalMandateActivity.this.et_verificationText.getText().toString().length() > 3) {
                        DigitalMandateActivity.this.et_nameText.requestFocus();
                    }
                } else if (DigitalMandateActivity.this.et_verificationText.getText().toString().length() > 2) {
                    DigitalMandateActivity.this.et_nameText.requestFocus();
                }
            } catch (Exception unused) {
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EditText access$4700 = DigitalMandateActivity.this.et_verificationText;
            DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
            access$4700.setTextColor(ContextCompat.getColor(digitalMandateActivity, digitalMandateActivity.getResources().getIdentifier("defaultTextColor", "color", DigitalMandateActivity.this.getPackageName())));
            CardType access$4000 = DigitalMandateActivity.this.cardType;
            CardType cardType = CardType.YetUnknown;
        }
    };
    public int vaulted_cvv_digit = 2;
    public CustomPager viewPager;
    public ViewPagerAdapter viewPagerAdapter;
    public View view_divider;
    public WebView webView;
    public int year;

    /* renamed from: com.paynimo.android.payment.DigitalMandateActivity$15  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass15 {
        public static final /* synthetic */ int[] $SwitchMap$com$paynimo$android$payment$DigitalMandateActivity$PaymentType;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                com.paynimo.android.payment.DigitalMandateActivity$PaymentType[] r0 = com.paynimo.android.payment.DigitalMandateActivity.PaymentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$paynimo$android$payment$DigitalMandateActivity$PaymentType = r0
                r1 = 1
                r2 = 2
                com.paynimo.android.payment.DigitalMandateActivity$PaymentType r3 = com.paynimo.android.payment.DigitalMandateActivity.PaymentType.TRANSACTION     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 3
                int[] r3 = $SwitchMap$com$paynimo$android$payment$DigitalMandateActivity$PaymentType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.paynimo.android.payment.DigitalMandateActivity$PaymentType r4 = com.paynimo.android.payment.DigitalMandateActivity.PaymentType.PREAUTHORIZATION     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r2 = $SwitchMap$com$paynimo$android$payment$DigitalMandateActivity$PaymentType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.paynimo.android.payment.DigitalMandateActivity$PaymentType r3 = com.paynimo.android.payment.DigitalMandateActivity.PaymentType.TOKEN     // Catch:{ NoSuchFieldError -> 0x001d }
                r3 = 0
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$paynimo$android$payment$DigitalMandateActivity$PaymentType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.paynimo.android.payment.DigitalMandateActivity$PaymentType r2 = com.paynimo.android.payment.DigitalMandateActivity.PaymentType.TOKEN_WITH_PARAMS     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.AnonymousClass15.<clinit>():void");
        }
    }

    public static class Factory {
        public static Intent getAuthorizationIntent(Context context, boolean z) {
            DigitalMandateActivity.application_context = context.getApplicationContext();
            Settings settings = new Settings();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.ARGUMENT_DATA_SETTING, settings);
            Intent intent = new Intent(context, DigitalMandateActivity.class);
            intent.putExtras(bundle);
            return intent;
        }
    }

    public enum PaymentType implements Parcelable {
        TOKEN,
        TOKEN_WITH_PARAMS,
        TRANSACTION,
        PREAUTHORIZATION;
        
        public static final Creator<PaymentType> CREATOR = null;

        /* access modifiers changed from: public */
        static {
            CREATOR = new Creator<PaymentType>() {
                public PaymentType createFromParcel(Parcel parcel) {
                    return PaymentType.values()[parcel.readInt()];
                }

                public PaymentType[] newArray(int i) {
                    return new PaymentType[i];
                }
            };
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(ordinal());
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
            Context context = DigitalMandateActivity.application_context;
            if (context != null) {
                CardTypeParser.setContext(context);
            } else if (DigitalMandateActivity.myContext != null) {
                Context access$3500 = DigitalMandateActivity.myContext;
                DigitalMandateActivity.application_context = access$3500;
                CardTypeParser.setContext(access$3500);
            }
        }

        public Settings() {
            CardTypeParser.setContext(DigitalMandateActivity.application_context);
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

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public int mCurrentPosition = -1;

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return DigitalMandateActivity.this.eSign.size();
        }

        public Fragment getItem(int i) {
            DigitalMandateActivity.this.currFragment = null;
            int size = DigitalMandateActivity.this.eSign.size();
            Integer valueOf = Integer.valueOf(0);
            Integer valueOf2 = Integer.valueOf(2);
            Integer valueOf3 = Integer.valueOf(1);
            if (size == 1) {
                if (i == 0 && DigitalMandateActivity.this.eSign.contains(valueOf)) {
                    DigitalMandateActivity.this.currFragment = new AadharFragment();
                } else if (i == 0 && DigitalMandateActivity.this.eSign.contains(valueOf3)) {
                    DigitalMandateActivity.this.currFragment = new EMandateFragment();
                } else if (i == 0 && DigitalMandateActivity.this.eSign.contains(valueOf2)) {
                    DigitalMandateActivity.this.currFragment = new ENachFragment();
                }
            } else if (DigitalMandateActivity.this.eSign.size() == 2) {
                if (i == 0 && DigitalMandateActivity.this.eSign.contains(valueOf)) {
                    DigitalMandateActivity.this.currFragment = new AadharFragment();
                } else if (i == 0 && DigitalMandateActivity.this.eSign.contains(valueOf3) && DigitalMandateActivity.this.eSign.contains(valueOf2)) {
                    DigitalMandateActivity.this.currFragment = new EMandateFragment();
                } else if (i == 1 && DigitalMandateActivity.this.eSign.contains(valueOf) && DigitalMandateActivity.this.eSign.contains(valueOf3)) {
                    DigitalMandateActivity.this.currFragment = new EMandateFragment();
                } else if (i == 1 && ((DigitalMandateActivity.this.eSign.contains(valueOf) || DigitalMandateActivity.this.eSign.contains(valueOf3)) && DigitalMandateActivity.this.eSign.contains(valueOf2))) {
                    DigitalMandateActivity.this.currFragment = new ENachFragment();
                }
            } else if (DigitalMandateActivity.this.eSign.size() == 3) {
                if (i == 0) {
                    DigitalMandateActivity.this.currFragment = new AadharFragment();
                } else if (i == 1) {
                    DigitalMandateActivity.this.currFragment = new EMandateFragment();
                } else if (i == 2) {
                    DigitalMandateActivity.this.currFragment = new ENachFragment();
                }
            }
            return DigitalMandateActivity.this.currFragment;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
            if (com.paynimo.android.payment.DigitalMandateActivity.access$800(r6.this$0).contains(r3) != false) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b5, code lost:
            if (com.paynimo.android.payment.DigitalMandateActivity.access$800(r6.this$0).contains(r5) != false) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
            if (com.paynimo.android.payment.DigitalMandateActivity.access$800(r6.this$0).contains(r3) != false) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00db, code lost:
            if (r7 == 2) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return com.paynimo.android.payment.DigitalMandateActivity.ENACH_MODE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.CharSequence getPageTitle(int r7) {
            /*
                r6 = this;
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                int r0 = r0.size()
                r1 = 0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r2 = 2
                java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
                r4 = 1
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                if (r0 != r4) goto L_0x004b
                if (r7 != 0) goto L_0x002b
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L_0x002b
                goto L_0x00d3
            L_0x002b:
                if (r7 != 0) goto L_0x003b
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                boolean r0 = r0.contains(r5)
                if (r0 == 0) goto L_0x003b
                goto L_0x00d8
            L_0x003b:
                if (r7 != 0) goto L_0x00e0
                com.paynimo.android.payment.DigitalMandateActivity r7 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r7 = r7.eSign
                boolean r7 = r7.contains(r3)
                if (r7 == 0) goto L_0x00e0
                goto L_0x00dd
            L_0x004b:
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                int r0 = r0.size()
                if (r0 != r2) goto L_0x00c4
                if (r7 != 0) goto L_0x0067
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L_0x0067
                goto L_0x00d3
            L_0x0067:
                if (r7 != 0) goto L_0x0082
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                boolean r0 = r0.contains(r5)
                if (r0 == 0) goto L_0x0082
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                boolean r0 = r0.contains(r3)
                if (r0 == 0) goto L_0x0082
                goto L_0x00d8
            L_0x0082:
                if (r7 != r4) goto L_0x009d
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L_0x009d
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                boolean r0 = r0.contains(r5)
                if (r0 == 0) goto L_0x009d
                goto L_0x00d8
            L_0x009d:
                if (r7 != r4) goto L_0x00e0
                com.paynimo.android.payment.DigitalMandateActivity r7 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r7 = r7.eSign
                boolean r7 = r7.contains(r1)
                if (r7 != 0) goto L_0x00b7
                com.paynimo.android.payment.DigitalMandateActivity r7 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r7 = r7.eSign
                boolean r7 = r7.contains(r5)
                if (r7 == 0) goto L_0x00e0
            L_0x00b7:
                com.paynimo.android.payment.DigitalMandateActivity r7 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r7 = r7.eSign
                boolean r7 = r7.contains(r3)
                if (r7 == 0) goto L_0x00e0
                goto L_0x00dd
            L_0x00c4:
                com.paynimo.android.payment.DigitalMandateActivity r0 = com.paynimo.android.payment.DigitalMandateActivity.this
                java.util.List r0 = r0.eSign
                int r0 = r0.size()
                r1 = 3
                if (r0 != r1) goto L_0x00e0
                if (r7 != 0) goto L_0x00d6
            L_0x00d3:
                java.lang.String r7 = "AADHAAR"
                goto L_0x00e1
            L_0x00d6:
                if (r7 != r4) goto L_0x00db
            L_0x00d8:
                java.lang.String r7 = "NETBANKING"
                goto L_0x00e1
            L_0x00db:
                if (r7 != r2) goto L_0x00e0
            L_0x00dd:
                java.lang.String r7 = "ENACH"
                goto L_0x00e1
            L_0x00e0:
                r7 = 0
            L_0x00e1:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.ViewPagerAdapter.getPageTitle(int):java.lang.CharSequence");
        }

        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (i != this.mCurrentPosition) {
                Fragment fragment = (Fragment) obj;
                CustomPager customPager = (CustomPager) viewGroup;
                if (fragment != null && fragment.getView() != null) {
                    this.mCurrentPosition = i;
                    customPager.measureCurrentView(fragment.getView());
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void callTarRequest(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r7 = "DEFAULT ERROR"
            java.lang.String r0 = "ERROR_PAYNIMO_003"
            r1 = -2
            android.content.Context r2 = application_context     // Catch:{ Exception -> 0x0043 }
            boolean r2 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r2)     // Catch:{ Exception -> 0x0043 }
            if (r2 == 0) goto L_0x0035
            com.paynimo.android.payment.model.Checkout r2 = r5.checkout     // Catch:{ Exception -> 0x0031 }
            if (r2 == 0) goto L_0x0046
            java.lang.String r3 = "DigitalMandateAct"
            java.lang.String r4 = " Start TAR response"
            com.paynimo.android.payment.util.Constant.showOutputLog(r3, r4)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = "TAR"
            r2.setTransactionRequestType(r3)     // Catch:{ Exception -> 0x0031 }
            r2.setTransactionDescription(r6)     // Catch:{ Exception -> 0x0031 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r2.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0031 }
            r5.request_payload = r6     // Catch:{ Exception -> 0x0031 }
            r5.showProgressLoader()     // Catch:{ Exception -> 0x0031 }
            com.paynimo.android.payment.b.d r6 = r5.mServiceManager     // Catch:{ Exception -> 0x0031 }
            com.paynimo.android.payment.model.request.RequestPayload r2 = r5.request_payload     // Catch:{ Exception -> 0x0031 }
            r6.callTARRequest(r2, r5)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0046
        L_0x0031:
            r5.showAlertDialog(r1, r0, r7)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0046
        L_0x0035:
            de.greenrobot.event.EventBus r6 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0043 }
            com.paynimo.android.payment.event.g r2 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0043 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ Exception -> 0x0043 }
            r6.post(r2)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0046
        L_0x0043:
            r5.showAlertDialog(r1, r0, r7)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.callTarRequest(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkIfAccountDataIsFilled() {
        /*
            r15 = this;
            java.lang.String r0 = r15.selected_bank_name
            if (r0 == 0) goto L_0x0554
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0554
            com.google.android.material.tabs.TabLayout r0 = r15.tabLayout
            int r0 = r0.getSelectedTabPosition()
            java.lang.String r1 = r15.selected_bank
            if (r1 == 0) goto L_0x003b
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x003b
            java.util.HashMap<java.lang.String, com.paynimo.android.payment.model.response.k.g> r1 = r15.banksData
            if (r1 == 0) goto L_0x003b
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x003b
            java.util.HashMap<java.lang.String, com.paynimo.android.payment.model.response.k.g> r1 = r15.banksData
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            java.lang.Object r1 = r1.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            com.paynimo.android.payment.model.response.k.g r1 = (com.paynimo.android.payment.model.response.k.g) r1
            goto L_0x0045
        L_0x003b:
            java.util.HashMap<java.lang.String, com.paynimo.android.payment.model.response.k.g> r1 = r15.banksData
            java.lang.String r2 = r15.selected_bank_name
            java.lang.Object r1 = r1.get(r2)
            com.paynimo.android.payment.model.response.k.g r1 = (com.paynimo.android.payment.model.response.k.g) r1
        L_0x0045:
            com.google.android.material.tabs.TabLayout r2 = r15.tabLayout
            com.google.android.material.tabs.TabLayout$Tab r2 = r2.getTabAt(r0)
            r3 = 0
            if (r2 == 0) goto L_0x0053
            java.lang.CharSequence r2 = r2.text
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
        L_0x0053:
            java.lang.String r2 = "CC"
            r4 = 3
            java.lang.String r5 = "paynimo_bank_error_text"
            java.lang.String r6 = "paynimo_lyt_bank_details"
            java.lang.String r7 = "paynimo_spn_account_type"
            java.lang.String r8 = "paynimo_et_account_number"
            java.lang.String r9 = "paynimo_et_account_holder_name"
            r10 = 1
            java.lang.String r11 = ""
            java.lang.String r12 = "id"
            if (r3 == 0) goto L_0x01ba
            java.lang.String r13 = "AADHAAR"
            boolean r13 = r3.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x01ba
            if (r1 == 0) goto L_0x01ba
            com.paynimo.android.payment.model.response.k.i r13 = r1.geteAuthBank()
            if (r13 != 0) goto L_0x007d
            com.paynimo.android.payment.model.response.k.j r13 = r1.geteAuthBankBio()
            if (r13 == 0) goto L_0x01ba
        L_0x007d:
            com.paynimo.android.payment.CustomPager r3 = r15.viewPager
            android.view.View r0 = r3.getChildAt(r0)
            if (r0 == 0) goto L_0x01b9
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r13 = "paynimo_et_aadhar_number"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r13, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_aadhar_number = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r9, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_account_holder_name = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r8, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_account_number = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r8 = "paynimo_et_ifsc_code"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r8, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_ifsc_code = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r7, r12, r0)
            android.widget.Spinner r3 = (android.widget.Spinner) r3
            r15.spinner_account_type = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r6, r12, r0)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r15.lyt_bank_details = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r6 = "paynimo_lyt_rdo_group"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r6, r12, r0)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r15.lyt_rdo_group = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r15.tv_bank_error_text = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = "paynimo_biometric_note_text"
            android.view.View r0 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r15.tv_biometric_note_text = r0
            android.widget.EditText r0 = r15.et_account_holder_name
            if (r0 == 0) goto L_0x0106
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x0107
        L_0x0106:
            r0 = r11
        L_0x0107:
            android.widget.EditText r3 = r15.et_account_number
            if (r3 == 0) goto L_0x0114
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            goto L_0x0115
        L_0x0114:
            r3 = r11
        L_0x0115:
            android.widget.EditText r5 = r15.et_ifsc_code
            if (r5 == 0) goto L_0x0121
            android.text.Editable r5 = r5.getText()
            java.lang.String r11 = r5.toString()
        L_0x0121:
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x01b7
            boolean r5 = com.paynimo.android.payment.util.d.validateAccHolderName(r15, r0)
            if (r5 == 0) goto L_0x01b7
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x01b7
            boolean r5 = com.paynimo.android.payment.util.d.validateAccountNo(r15, r3)
            if (r5 == 0) goto L_0x01b7
            boolean r5 = r11.isEmpty()
            if (r5 != 0) goto L_0x01b7
            boolean r5 = com.paynimo.android.payment.util.d.validateIFSC(r15, r11)
            if (r5 == 0) goto L_0x01b7
            android.widget.Spinner r5 = r15.spinner_account_type
            int r5 = r5.getSelectedItemPosition()
            if (r5 <= 0) goto L_0x01b7
            boolean r5 = r15.isNACH
            if (r5 == 0) goto L_0x01b7
            com.paynimo.android.payment.model.Checkout r5 = r15.checkout
            java.lang.String r0 = r0.trim()
            r5.setConsumerAccountHolderName(r0)
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            java.lang.String r3 = r3.trim()
            r0.setConsumerAccountNo(r3)
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            java.lang.String r3 = r11.toUpperCase()
            java.lang.String r3 = r3.trim()
            r0.setPaymentInstrumentIFSC(r3)
            com.paynimo.android.payment.model.response.k.j r0 = r1.geteAuthBankBio()
            if (r0 == 0) goto L_0x018c
            android.widget.RadioButton r0 = r15.rdo_biometric
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L_0x018c
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.response.k.j r1 = r1.geteAuthBankBio()
            java.lang.String r1 = r1.getBankCode()
            r0.setPaymentMethodToken(r1)
            goto L_0x0199
        L_0x018c:
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.response.k.i r1 = r1.geteAuthBank()
            java.lang.String r1 = r1.getBankCode()
            r0.setPaymentMethodToken(r1)
        L_0x0199:
            android.widget.Spinner r0 = r15.spinner_account_type
            int r0 = r0.getSelectedItemPosition()
            if (r0 != r4) goto L_0x01a7
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            r0.setConsumerAccountType(r2)
            goto L_0x01b6
        L_0x01a7:
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            android.widget.Spinner r1 = r15.spinner_account_type
            java.lang.Object r1 = r1.getSelectedItem()
            java.lang.String r1 = r1.toString()
            r0.setConsumerAccountType(r1)
        L_0x01b6:
            return r10
        L_0x01b7:
            r0 = 0
            return r0
        L_0x01b9:
            return r10
        L_0x01ba:
            java.lang.String r4 = "paynimo_digital_mandate_invalid_acc_number_error_message"
            java.lang.String r10 = "paynimo_digital_mandate_invalid_acc_holder_name_error_message"
            java.lang.String r13 = "string"
            if (r3 == 0) goto L_0x027f
            java.lang.String r14 = "NETBANKING"
            boolean r14 = r3.equalsIgnoreCase(r14)
            if (r14 == 0) goto L_0x027f
            if (r1 == 0) goto L_0x027f
            com.paynimo.android.payment.model.response.k.l r14 = r1.geteMandateBank()
            if (r14 == 0) goto L_0x027f
            com.paynimo.android.payment.CustomPager r2 = r15.viewPager
            android.view.View r0 = r2.getChildAt(r0)
            if (r0 == 0) goto L_0x027d
            android.content.res.Resources r2 = r15.getResources()
            android.view.View r2 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r2, r9, r12, r0)
            android.widget.EditText r2 = (android.widget.EditText) r2
            r15.et_account_holder_name = r2
            android.content.res.Resources r2 = r15.getResources()
            java.lang.String r3 = "paynimo_digital_mandate_account_number"
            android.view.View r0 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r2, r3, r12, r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r15.dm_et_account_number = r0
            android.widget.EditText r0 = r15.et_account_holder_name
            if (r0 == 0) goto L_0x0201
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x0202
        L_0x0201:
            r0 = r11
        L_0x0202:
            android.widget.EditText r2 = r15.dm_et_account_number
            if (r2 == 0) goto L_0x020e
            android.text.Editable r2 = r2.getText()
            java.lang.String r11 = r2.toString()
        L_0x020e:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0262
            boolean r2 = com.paynimo.android.payment.util.d.validateAccHolderName(r15, r0)
            if (r2 == 0) goto L_0x0262
            com.paynimo.android.payment.model.Checkout r2 = r15.checkout
            java.lang.String r0 = r0.trim()
            r2.setConsumerAccountHolderName(r0)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x0247
            boolean r0 = com.paynimo.android.payment.util.d.validateAccountNo(r15, r11)
            if (r0 == 0) goto L_0x0247
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            java.lang.String r2 = r11.trim()
            r0.setConsumerAccountNo(r2)
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.response.k.l r1 = r1.geteMandateBank()
            java.lang.String r1 = r1.getBankCode()
            r0.setPaymentMethodToken(r1)
            r0 = 1
            return r0
        L_0x0247:
            android.widget.EditText r0 = r15.et_account_number
            android.content.res.Resources r1 = r15.getResources()
            android.content.res.Resources r2 = r15.getResources()
            java.lang.String r3 = r15.getPackageName()
            int r2 = r2.getIdentifier(r4, r13, r3)
            java.lang.String r1 = r1.getString(r2)
            r0.setError(r1)
            r0 = 0
            return r0
        L_0x0262:
            r0 = 0
            android.widget.EditText r1 = r15.et_account_holder_name
            android.content.res.Resources r2 = r15.getResources()
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r4 = r15.getPackageName()
            int r3 = r3.getIdentifier(r10, r13, r4)
            java.lang.String r2 = r2.getString(r3)
            r1.setError(r2)
            return r0
        L_0x027d:
            r0 = 1
            return r0
        L_0x027f:
            if (r3 == 0) goto L_0x0552
            java.lang.String r14 = "ENACH"
            boolean r3 = r3.equalsIgnoreCase(r14)
            if (r3 == 0) goto L_0x0552
            if (r1 == 0) goto L_0x0552
            com.paynimo.android.payment.model.response.k.m r3 = r1.geteNACHBank()
            if (r3 != 0) goto L_0x0297
            com.paynimo.android.payment.model.response.k.n r3 = r1.geteNACHBankCard()
            if (r3 == 0) goto L_0x0552
        L_0x0297:
            com.paynimo.android.payment.CustomPager r3 = r15.viewPager
            android.view.View r0 = r3.getChildAt(r0)
            if (r0 == 0) goto L_0x0550
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r9, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_account_holder_name = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r8, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_account_number = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r7, r12, r0)
            android.widget.Spinner r3 = (android.widget.Spinner) r3
            r15.spinner_account_type = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r6, r12, r0)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r15.lyt_bank_details = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r6 = "paynimo_rg_enach_modes"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r6, r12, r0)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r15.lyt_rdo_group = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r15.tv_bank_error_text = r3
            android.content.res.Resources r3 = r15.getResources()
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r6, r12, r0)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r15.lyt_rdo_group = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = "paynimo_rdo_netbanking"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            r15.rdo_netbanking = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = "paynimo_rdo_debit_card"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            r15.rdo_debit_card = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = "paynimo_et_phone_number"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_phone_number = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = "paynimo_et_mobile_number"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_mobile_number = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = "paynimo_et_pan_number"
            android.view.View r3 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r15.et_pan_number = r3
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = "paynimo_et_email_id"
            android.view.View r0 = com.android.tools.r8.GeneratedOutlineSupport.outline18(r15, r3, r5, r12, r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r15.et_email_id = r0
            android.widget.EditText r0 = r15.et_account_holder_name
            if (r0 == 0) goto L_0x0356
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x0357
        L_0x0356:
            r0 = r11
        L_0x0357:
            android.widget.EditText r3 = r15.et_account_number
            if (r3 == 0) goto L_0x0363
            android.text.Editable r3 = r3.getText()
            java.lang.String r11 = r3.toString()
        L_0x0363:
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x0535
            boolean r3 = com.paynimo.android.payment.util.d.validateAccHolderName(r15, r0)
            if (r3 == 0) goto L_0x0535
            com.paynimo.android.payment.model.Checkout r3 = r15.checkout
            java.lang.String r0 = r0.trim()
            r3.setConsumerAccountHolderName(r0)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x051a
            boolean r0 = com.paynimo.android.payment.util.d.validateAccountNo(r15, r11)
            if (r0 == 0) goto L_0x051a
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            java.lang.String r3 = r11.trim()
            r0.setConsumerAccountNo(r3)
            android.widget.EditText r0 = r15.et_phone_number
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            android.widget.EditText r3 = r15.et_mobile_number
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            android.widget.EditText r4 = r15.et_pan_number
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r4.trim()
            android.widget.EditText r5 = r15.et_email_id
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.trim()
            if (r0 == 0) goto L_0x0406
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x0406
            int r6 = r0.length()
            r7 = 8
            if (r6 < r7) goto L_0x03e9
            boolean r6 = com.paynimo.android.payment.util.d.validatePhone(r0)
            if (r6 == 0) goto L_0x03e9
            com.paynimo.android.payment.model.Checkout r6 = r15.checkout
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()
            com.paynimo.android.payment.model.request.d r6 = r6.getConsumer()
            r6.setPhoneNumber(r0)
            goto L_0x0406
        L_0x03e9:
            android.widget.EditText r0 = r15.et_phone_number
            android.content.res.Resources r1 = r15.getResources()
            android.content.res.Resources r2 = r15.getResources()
            java.lang.String r3 = r15.getPackageName()
            java.lang.String r4 = "paynimo_digital_mandate_invalid_phone_no_error_message"
            int r2 = r2.getIdentifier(r4, r13, r3)
            java.lang.String r1 = r1.getString(r2)
            r0.setError(r1)
            r0 = 0
            return r0
        L_0x0406:
            if (r3 == 0) goto L_0x043f
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x043f
            boolean r0 = com.paynimo.android.payment.util.d.validateMobileNo(r15, r3)
            if (r0 == 0) goto L_0x0422
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.request.RequestPayload r0 = r0.getMerchantRequestPayload()
            com.paynimo.android.payment.model.request.d r0 = r0.getConsumer()
            r0.setMobileNumber(r3)
            goto L_0x043f
        L_0x0422:
            android.widget.EditText r0 = r15.et_mobile_number
            android.content.res.Resources r1 = r15.getResources()
            android.content.res.Resources r2 = r15.getResources()
            java.lang.String r3 = r15.getPackageName()
            java.lang.String r4 = "paynimo_digital_mandate_invalid_mobile_no_error_message"
            int r2 = r2.getIdentifier(r4, r13, r3)
            java.lang.String r1 = r1.getString(r2)
            r0.setError(r1)
            r0 = 0
            return r0
        L_0x043f:
            if (r4 == 0) goto L_0x0480
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x0480
            int r0 = r4.length()
            r3 = 10
            if (r0 != r3) goto L_0x0463
            boolean r0 = com.paynimo.android.payment.util.d.validatePAN(r15, r4)
            if (r0 == 0) goto L_0x0463
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.request.RequestPayload r0 = r0.getMerchantRequestPayload()
            com.paynimo.android.payment.model.request.d r0 = r0.getConsumer()
            r0.setPan(r4)
            goto L_0x0480
        L_0x0463:
            android.widget.EditText r0 = r15.et_pan_number
            android.content.res.Resources r1 = r15.getResources()
            android.content.res.Resources r2 = r15.getResources()
            java.lang.String r3 = r15.getPackageName()
            java.lang.String r4 = "paynimo_digital_mandate_invalid_pan_error_message"
            int r2 = r2.getIdentifier(r4, r13, r3)
            java.lang.String r1 = r1.getString(r2)
            r0.setError(r1)
            r0 = 0
            return r0
        L_0x0480:
            if (r5 == 0) goto L_0x04b9
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x04b9
            boolean r0 = com.paynimo.android.payment.util.d.validateEmail(r5)
            if (r0 == 0) goto L_0x049c
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.request.RequestPayload r0 = r0.getMerchantRequestPayload()
            com.paynimo.android.payment.model.request.d r0 = r0.getConsumer()
            r0.setEmailID(r5)
            goto L_0x04b9
        L_0x049c:
            android.widget.EditText r0 = r15.et_email_id
            android.content.res.Resources r1 = r15.getResources()
            android.content.res.Resources r2 = r15.getResources()
            java.lang.String r3 = r15.getPackageName()
            java.lang.String r4 = "paynimo_digital_mandate_invalid_email_error_message"
            int r2 = r2.getIdentifier(r4, r13, r3)
            java.lang.String r1 = r1.getString(r2)
            r0.setError(r1)
            r0 = 0
            return r0
        L_0x04b9:
            android.widget.Spinner r0 = r15.spinner_account_type
            int r0 = r0.getSelectedItemPosition()
            if (r0 <= 0) goto L_0x0518
            android.widget.Spinner r0 = r15.spinner_account_type
            int r0 = r0.getSelectedItemPosition()
            r3 = 3
            if (r0 != r3) goto L_0x04d0
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            r0.setConsumerAccountType(r2)
            goto L_0x04df
        L_0x04d0:
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            android.widget.Spinner r2 = r15.spinner_account_type
            java.lang.Object r2 = r2.getSelectedItem()
            java.lang.String r2 = r2.toString()
            r0.setConsumerAccountType(r2)
        L_0x04df:
            com.paynimo.android.payment.model.response.k.m r0 = r1.geteNACHBank()
            if (r0 == 0) goto L_0x04fb
            android.widget.RadioButton r0 = r15.rdo_netbanking
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L_0x04fb
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.response.k.m r1 = r1.geteNACHBank()
            java.lang.String r1 = r1.getBankCode()
            r0.setPaymentMethodToken(r1)
            goto L_0x0516
        L_0x04fb:
            com.paynimo.android.payment.model.response.k.n r0 = r1.geteNACHBankCard()
            if (r0 == 0) goto L_0x0516
            android.widget.RadioButton r0 = r15.rdo_debit_card
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L_0x0516
            com.paynimo.android.payment.model.Checkout r0 = r15.checkout
            com.paynimo.android.payment.model.response.k.n r1 = r1.geteNACHBankCard()
            java.lang.String r1 = r1.getBankCode()
            r0.setPaymentMethodToken(r1)
        L_0x0516:
            r0 = 1
            return r0
        L_0x0518:
            r0 = 0
            return r0
        L_0x051a:
            r0 = 0
            android.widget.EditText r1 = r15.et_account_number
            android.content.res.Resources r2 = r15.getResources()
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r5 = r15.getPackageName()
            int r3 = r3.getIdentifier(r4, r13, r5)
            java.lang.String r2 = r2.getString(r3)
            r1.setError(r2)
            return r0
        L_0x0535:
            r0 = 0
            android.widget.EditText r1 = r15.et_account_holder_name
            android.content.res.Resources r2 = r15.getResources()
            android.content.res.Resources r3 = r15.getResources()
            java.lang.String r4 = r15.getPackageName()
            int r3 = r3.getIdentifier(r10, r13, r4)
            java.lang.String r2 = r2.getString(r3)
            r1.setError(r2)
            return r0
        L_0x0550:
            r0 = 0
            return r0
        L_0x0552:
            r0 = 0
            return r0
        L_0x0554:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.checkIfAccountDataIsFilled():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x025f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkIfCardDataIsFilledAndProceed() {
        /*
            r19 = this;
            r7 = r19
            android.widget.EditText r0 = r7.et_cardNumber
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            r1 = 6
            if (r0 <= r1) goto L_0x0029
            android.widget.EditText r0 = r7.et_cardNumber
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            com.paynimo.android.payment.DigitalMandateActivity$Settings r1 = r7.paymentSettings
            java.util.Collection r1 = r1.getAllowedCardTypes()
            com.paynimo.android.payment.CardTypeParser$CardType r0 = com.paynimo.android.payment.CardTypeParser.CardType.getCardType(r0, r1)
            r7.cardType = r0
        L_0x0029:
            java.lang.String r8 = "Y"
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r7.cardType
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.Maestro
            r9 = 5
            r10 = 3
            java.lang.String r11 = "20"
            r12 = 2
            r13 = 0
            java.lang.String r14 = "\\s"
            java.lang.String r15 = "DBT"
            java.lang.String r6 = "CRT"
            java.lang.String r5 = ""
            if (r0 != r1) goto L_0x0195
            android.widget.EditText r1 = r7.et_nameText
            android.widget.EditText r2 = r7.et_cardNumber
            com.paynimo.android.payment.DigitalMandateActivity$Settings r3 = r7.paymentSettings
            java.util.Collection r3 = r3.getAllowedCardTypes()
            boolean r0 = com.paynimo.android.payment.CardValidator.validate(r7, r1, r2, r0, r3)
            if (r0 == 0) goto L_0x03c7
            android.widget.EditText r0 = r7.et_cardNumber
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.replaceAll(r14, r5)
            android.widget.EditText r1 = r7.et_nameText
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            android.widget.EditText r2 = r7.et_dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            android.text.Editable r2 = r2.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            java.lang.String r2 = r2.substring(r13, r12)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            r3.<init>()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            r3.append(r11)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            android.widget.EditText r4 = r7.et_dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            android.text.Editable r4 = r4.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            java.lang.String r4 = r4.substring(r10, r9)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            r3.append(r4)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0098 }
            r18 = r5
            r5 = r2
            r2 = r18
            goto L_0x0099
        L_0x0098:
            r2 = r5
        L_0x0099:
            android.widget.EditText r3 = r7.et_verificationText
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout
            r4.setTransactionIsRegistration(r8)
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout
            r4.setPaymentInstrumentIdentifier(r0)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentHolderName(r1)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentExpiryMonth(r5)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentExpiryYear(r2)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentVerificationCode(r3)
            java.lang.String r0 = r7.issuer
            if (r0 == 0) goto L_0x0135
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "maestro"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0135
            java.lang.String r0 = r7.inputCardType
            if (r0 == 0) goto L_0x0105
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x0105
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getCredit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x00fe
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x00fe
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x00fe:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x0105:
            java.lang.String r0 = r7.inputCardType
            if (r0 == 0) goto L_0x03c7
            boolean r0 = r0.equalsIgnoreCase(r15)
            if (r0 == 0) goto L_0x03c7
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getDebit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x012e
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x012e
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x012e:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x0135:
            java.lang.String r0 = r7.inputCardType
            if (r0 == 0) goto L_0x0165
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x0165
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getCredit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x015e
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x015e
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x015e:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x0165:
            java.lang.String r0 = r7.inputCardType
            if (r0 == 0) goto L_0x03c7
            boolean r0 = r0.equalsIgnoreCase(r15)
            if (r0 == 0) goto L_0x03c7
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getDebit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x018e
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x018e
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x018e:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x0195:
            android.widget.EditText r0 = r7.et_dateText
            r1 = 1
            boolean r0 = com.paynimo.android.payment.CardValidator.validateDate(r7, r0, r1)
            if (r0 != 0) goto L_0x019f
            return
        L_0x019f:
            android.widget.EditText r1 = r7.et_nameText
            android.widget.EditText r2 = r7.et_cardNumber
            android.widget.EditText r3 = r7.et_dateText
            android.widget.EditText r4 = r7.et_verificationText
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r7.cardType
            com.paynimo.android.payment.DigitalMandateActivity$Settings r9 = r7.paymentSettings
            java.util.Collection r9 = r9.getAllowedCardTypes()
            r16 = r0
            r0 = r19
            r10 = r5
            r5 = r16
            r17 = r6
            r6 = r9
            boolean r0 = com.paynimo.android.payment.CardValidator.validate(r0, r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x03c7
            android.widget.EditText r0 = r7.et_cardNumber
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.replaceAll(r14, r10)
            android.widget.EditText r1 = r7.et_nameText
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            android.widget.EditText r2 = r7.et_dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0205 }
            android.text.Editable r2 = r2.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0205 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0205 }
            java.lang.String r5 = r2.substring(r13, r12)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0205 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            r2.<init>()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            r2.append(r11)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            android.widget.EditText r3 = r7.et_dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            android.text.Editable r3 = r3.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            r4 = 5
            r6 = 3
            java.lang.String r3 = r3.substring(r6, r4)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            r2.append(r3)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0206 }
            goto L_0x0207
        L_0x0205:
            r5 = r10
        L_0x0206:
            r2 = r10
        L_0x0207:
            android.widget.EditText r3 = r7.et_verificationText
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout
            r4.setTransactionIsRegistration(r8)
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout
            r4.setPaymentInstrumentIdentifier(r0)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentHolderName(r1)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentExpiryMonth(r5)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentExpiryYear(r2)
            com.paynimo.android.payment.model.Checkout r0 = r7.checkout
            r0.setPaymentInstrumentVerificationCode(r3)
            com.paynimo.android.payment.CardTypeParser$CardType r0 = r7.cardType
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.AmericanExpress
            if (r0 != r1) goto L_0x025f
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getAmex()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x0258
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0258
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x0258:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x025f:
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.DinersClub
            if (r0 != r1) goto L_0x0289
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getDiner()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x0282
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0282
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x0282:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x0289:
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.Discover
            if (r0 != r1) goto L_0x02b3
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getDiscover()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x02ac
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x02ac
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x02ac:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x02b3:
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.Rupay
            if (r0 != r1) goto L_0x0388
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getRupay()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x02d6
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x02d6
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x02d6:
            java.lang.String r0 = r7.issuer
            if (r0 == 0) goto L_0x0348
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "rupay"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0348
            java.lang.String r0 = r7.inputCardType
            if (r0 == 0) goto L_0x0318
            r1 = r17
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0318
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getCredit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x0311
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0311
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x0311:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x0318:
            java.lang.String r0 = r7.inputCardType
            if (r0 == 0) goto L_0x03c7
            boolean r0 = r0.equalsIgnoreCase(r15)
            if (r0 == 0) goto L_0x03c7
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getDebit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x0341
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0341
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x0341:
            java.lang.String r0 = CARD_NOT_SUPPORTED
            r7.showSingleButtonDialog(r7, r0)
            goto L_0x03c7
        L_0x0348:
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getCredit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x0366
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0366
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x0366:
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getDebit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x0384
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0384
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x0384:
            r7.startCardNetworkTask(r10)
            goto L_0x03c7
        L_0x0388:
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getCredit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x03a6
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x03a6
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x03a6:
            com.paynimo.android.payment.model.response.k.r r0 = r7.pmiData
            com.paynimo.android.payment.model.response.k.a r0 = r0.getBanks()
            com.paynimo.android.payment.model.response.k.d r0 = r0.getCards()
            java.lang.String r0 = r0.getDebit()
            java.lang.String r0 = r0.trim()
            if (r0 == 0) goto L_0x03c4
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x03c4
            r7.startCardNetworkTask(r0)
            goto L_0x03c7
        L_0x03c4:
            r7.startCardNetworkTask(r10)
        L_0x03c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.checkIfCardDataIsFilledAndProceed():void");
    }

    private boolean checkIfEMandateDataIsFilled() {
        boolean z = true;
        if (!isSIDataFilled()) {
            String obj = this.et_debit_start_date.getText().toString();
            String obj2 = this.et_debit_end_date.getText().toString();
            String obj3 = this.et_amount_debit.getText().toString();
            if (obj != null && !obj.isEmpty() && obj2 != null && !obj2.isEmpty() && obj3 != null && !obj3.isEmpty() && this.mapInstrumentFrequency.containsKey(this.spinner_frequency.getSelectedItem().toString())) {
                String str = this.mapInstrumentFrequency.get(this.spinner_frequency.getSelectedItem().toString());
                if (this.mapInstrumentAmountType.containsKey(this.spinner_amountType.getSelectedItem().toString())) {
                    String str2 = this.mapInstrumentAmountType.get(this.spinner_amountType.getSelectedItem().toString());
                    String str3 = null;
                    boolean z2 = this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getDebitFlag() != null && this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getDebitFlag().equalsIgnoreCase("Y");
                    if (z2 && this.spinner_debitDay.getSelectedItem() != null && !this.spinner_debitDay.getSelectedItem().toString().equalsIgnoreCase("SELECT DEBIT DAY")) {
                        str3 = this.spinner_debitDay.getSelectedItem().toString();
                    }
                    if (z2) {
                        if (str3 == null) {
                            return false;
                        }
                        this.checkout.setPaymentInstructionDebitDay(str3);
                    }
                    if (!(str == null || str2 == null)) {
                        this.checkout.setPaymentInstructionStartDateTime(obj);
                        this.checkout.setPaymentInstructionEndDateTime(obj2);
                        this.checkout.setPaymentInstructionAmount(obj3);
                        this.checkout.setPaymentInstructionLimit(obj3);
                        this.checkout.setPaymentInstructionAction("Y");
                        this.checkout.setPaymentInstructionType(str2);
                        this.checkout.setPaymentInstructionFrequency(str);
                        return true;
                    }
                }
            }
            return false;
        } else if (this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getDebitFlag() == null || !this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getDebitFlag().equalsIgnoreCase("Y") || this.n_spinner_debitDay.getSelectedItem() == null || this.n_spinner_debitDay.getSelectedItem().toString().equalsIgnoreCase("SELECT DEBIT DAY")) {
            if (this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getDebitFlag() == null || !this.checkout.getMerchantRequestPayload().getPayment().getInstruction().getDebitFlag().equalsIgnoreCase("N")) {
                z = false;
            }
            return z;
        } else {
            this.checkout.setPaymentInstructionDebitDay(this.n_spinner_debitDay.getSelectedItem().toString());
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void finishActivityForChangeInPaymentMode() {
        Intent intent = new Intent();
        intent.putExtra("BankCode", true);
        setResult(-3, intent);
        finish();
    }

    private void hideProgressLoader() {
        findViewById(getResources().getIdentifier("paynimo_header", "id", getPackageName())).setVisibility(0);
        findViewById(getResources().getIdentifier("paynimo_scroll_main", "id", getPackageName())).setVisibility(0);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(8);
    }

    private void initialiseViews() {
        String str;
        this.scroll_main = (ScrollView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_scroll_main", "id");
        this.si_non_edit_container = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_si_non_edit_container", "id");
        this.n_tv_debit_start_date = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_n_tv_debit_start_date", "id");
        this.n_tv_debit_end_date = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_n_tv_debit_end_date", "id");
        this.n_tv_amount_debit = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_n_tv_amount_debit", "id");
        this.n_tv_amountType = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_n_tv_amountType", "id");
        this.n_tv_frequency = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_n_tv_frequency", "id");
        this.view_divider = GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_view_divider", "id");
        this.n_lyt_debit_day = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_n_lyt_debit_day", "id");
        this.n_spinner_debitDay = (Spinner) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_n_spinner_debitDay", "id");
        this.si_container = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_si_container", "id");
        this.et_debit_start_date = (EditText) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_et_debit_start_date", "id");
        this.et_debit_end_date = (EditText) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_et_debit_end_date", "id");
        this.et_amount_debit = (EditText) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_et_amount_debit", "id");
        this.ibStartDate = (ImageButton) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_dm_ib_start_date", "id");
        this.ibEndDate = (ImageButton) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_dm_ib_end_date", "id");
        this.spinner_amountType = (Spinner) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_spinner_amountType", "id");
        this.spinner_frequency = (Spinner) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_spinner_frequency", "id");
        this.lyt_debit_day = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_lyt_debit_day", "id");
        this.spinner_debitDay = (Spinner) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_spinner_debitDay", "id");
        this.mapInstrumentFrequency.put("As and when presented", "ADHO");
        this.mapInstrumentFrequency.put("Bi- monthly", "BIMN");
        this.mapInstrumentFrequency.put("Daily", "DAIL");
        this.mapInstrumentFrequency.put("Monthly", "MNTH");
        this.mapInstrumentFrequency.put("Quarterly", "QURT");
        this.mapInstrumentFrequency.put("Semi annually", "MIAN");
        this.mapInstrumentFrequency.put("Weekly", "WEEK");
        this.mapInstrumentFrequency.put("Yearly", "YEAR");
        this.mapInstrumentAmountType.put("Variable", "M");
        this.mapInstrumentAmountType.put("Fixed", PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        this.debitDaysList.add("SELECT DEBIT DAY");
        for (int i = 1; i < 32; i++) {
            List<String> list = this.debitDaysList;
            if (i < 10) {
                str = GeneratedOutlineSupport.outline41("0", i);
            } else {
                str = i + "";
            }
            list.add(str);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, 17367048, this.debitDaysList);
        this.adapter_debitDay = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.n_spinner_debitDay.setAdapter(this.adapter_debitDay);
        this.spinner_debitDay.setAdapter(this.adapter_debitDay);
        this.tv_select_bank = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_select_bank", "id");
        this.tv_register_mandate = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_register_mandate", "id");
        this.rg_mode = (RadioGroup) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_rg_mode", "id");
        this.rdo_account = (RadioButton) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_rdo_account", "id");
        this.rdo_card = (RadioButton) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_rdo_card", "id");
        h digitalMandate = this.pmiData.getBanks().getDigitalMandate();
        if (digitalMandate != null) {
            if (digitalMandate.getTopBanksCount() > 0 || digitalMandate.getOtherBanksCount() > 0) {
                this.rdo_account.setVisibility(0);
            } else {
                this.rdo_account.setVisibility(8);
            }
        }
        com.paynimo.android.payment.model.response.k.d cards = this.pmiData.getBanks().getCards();
        if (cards == null || ((cards.getCredit() == null || cards.getCredit().isEmpty()) && ((cards.getDebit() == null || cards.getDebit().isEmpty()) && ((cards.getAmex() == null || cards.getAmex().isEmpty()) && ((cards.getDiner() == null || cards.getDiner().isEmpty()) && ((cards.getDiscover() == null || cards.getDiscover().isEmpty()) && ((cards.getIvr() == null || cards.getIvr().isEmpty()) && (cards.getRupay() == null || cards.getRupay().isEmpty())))))))) {
            this.rdo_card.setVisibility(8);
        } else {
            this.rdo_card.setVisibility(0);
        }
        this.lyt_bank_list = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_lyt_bank_list", "id");
        this.lyt_card = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_lyt_card", "id");
        this.spinner_top_banks = (Spinner) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_top_banks_spinner", "id");
        this.et_cardNumber = (EditText) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_cardNumber", "id");
        this.card_imageview = (ImageView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_imageview", "id");
        this.et_dateText = (EditText) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_dateText", "id");
        this.et_verificationText = (EditText) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_verificationText", "id");
        this.et_nameText = (EditText) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_nameText", "id");
        TextView textView = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_card_si_error_message_block", "id");
        this.tvSIErrorBlock = textView;
        textView.setVisibility(8);
        this.lyt_dm_tab = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_lyt_dm_tab", "id");
        this.tabLayout = (TabLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_tab", "id");
        this.viewPager = (CustomPager) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_digital_mandate_view_pager", "id");
        this.btn_pay = (Button) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_btn_pay", "id");
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), getResources().getString(getResources().getIdentifier("paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())));
        SpannableString spannableString = new SpannableString(String.format(getString(getResources().getIdentifier("paynimo_digital_mandate_btn_pay_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName()), new Object[]{this.checkout.getMerchantRequestPayload().getTransaction().getAmount()}), new Object[0]));
        spannableString.setSpan(new com.paynimo.android.payment.util.a("", createFromAsset), 4, 5, 33);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), 4, 5, 33);
        this.btn_pay.setText(spannableString);
        this.webView = (WebView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_webview", "id");
        this.lyt_enach = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_lyt_enach", "id");
        this.n_lyt_enach = (LinearLayout) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_n_lyt_enach", "id");
        this.tv_utility_no = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_tv_utility_no", "id");
        this.tv_mandate_purpose = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_tv_mandate_purpose", "id");
        this.n_tv_utility_no = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_n_tv_utility_no", "id");
        this.n_tv_mandate_purpose = (TextView) GeneratedOutlineSupport.outline17(this, getResources(), "paynimo_n_tv_mandate_purpose", "id");
    }

    private boolean isMerchantSpecificDataValid(String str) {
        Boolean bool;
        if (str.equalsIgnoreCase("All")) {
            bool = Boolean.FALSE;
        } else if (!str.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CARDS)) {
            bool = validateBankCode(this.checkout.getMerchantRequestPayload().getPayment().getMethod().getToken());
        } else if (!this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getToken().isEmpty() || this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier().isEmpty()) {
            bool = Boolean.valueOf(this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier().equalsIgnoreCase("") && !this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getToken().equalsIgnoreCase(""));
        } else {
            bool = Boolean.valueOf(CardValidator.luhnCheck(this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier()));
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public boolean isSIDataFilled() {
        k instruction = this.checkout.getMerchantRequestPayload().getPayment().getInstruction();
        return instruction.getAction() != null && (instruction.getAction().equalsIgnoreCase("Y") || instruction.getAction().equalsIgnoreCase("N")) && instruction.getStartDateTime() != null && !instruction.getStartDateTime().isEmpty() && instruction.getEndDateTime() != null && !instruction.getEndDateTime().isEmpty() && instruction.getLimit() != null && !instruction.getLimit().isEmpty() && instruction.getType() != null && !instruction.getType().isEmpty() && instruction.getFrequency() != null && !instruction.getFrequency().isEmpty();
    }

    private void loadSettings(Bundle bundle) {
        Settings settings = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.paymentSettings = settings;
        if (settings != null) {
            this.isSafestoreEnabled = settings.isSafeStoreEnabled();
        }
        Bundle bundle2 = new Bundle();
        this.PaymentSettingsBundle = bundle2;
        bundle2.putParcelable(Constant.ARGUMENT_DATA_SETTING, this.paymentSettings);
        this.paymentType = PaymentType.TRANSACTION;
        this.resultType = c.TRANSACTION;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:35|36|42) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00c5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void networkCallWithBankCode(int r8) {
        /*
            r7 = this;
            java.lang.String r0 = "1.0"
            java.lang.String r1 = "DEFAULT ERROR"
            java.lang.String r2 = "ERROR_PAYNIMO_003"
            java.lang.String r3 = " ==>>  BankName is : "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r4 = r7.selected_bank_name
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "DigitalMandateAct"
            com.paynimo.android.payment.util.Constant.showOutputLog(r4, r3)
            r3 = -2
            boolean r4 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r7)     // Catch:{ Exception -> 0x00d6 }
            r5 = 0
            if (r4 == 0) goto L_0x00c9
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout     // Catch:{ Exception -> 0x00c5 }
            if (r4 == 0) goto L_0x00d9
            android.widget.RadioButton r4 = r7.rdo_biometric     // Catch:{ Exception -> 0x00c5 }
            if (r4 == 0) goto L_0x0042
            android.widget.RadioButton r4 = r7.rdo_biometric     // Catch:{ Exception -> 0x00c5 }
            boolean r4 = r4.isChecked()     // Catch:{ Exception -> 0x00c5 }
            if (r4 == 0) goto L_0x0042
            android.widget.RadioButton r4 = r7.rdo_biometric     // Catch:{ Exception -> 0x00c5 }
            int r4 = r4.getVisibility()     // Catch:{ Exception -> 0x00c5 }
            if (r4 != 0) goto L_0x0042
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r6 = "TND"
            r4.setTransactionRequestType(r6)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x0050
        L_0x0042:
            java.util.Date r4 = new java.util.Date     // Catch:{ Exception -> 0x00c5 }
            r4.<init>()     // Catch:{ Exception -> 0x00c5 }
            r7.startTime = r4     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r6 = "T"
            r4.setTransactionRequestType(r6)     // Catch:{ Exception -> 0x00c5 }
        L_0x0050:
            com.paynimo.android.payment.model.Checkout r4 = r7.checkout     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r6 = "N"
            r4.setPaymentMethodType(r6)     // Catch:{ Exception -> 0x00c5 }
            if (r8 != 0) goto L_0x0094
            java.util.List<java.lang.Integer> r4 = r7.eSign     // Catch:{ Exception -> 0x00c5 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00c5 }
            boolean r4 = r4.contains(r6)     // Catch:{ Exception -> 0x00c5 }
            if (r4 == 0) goto L_0x0094
            com.paynimo.android.payment.model.Checkout r8 = r7.checkout     // Catch:{ Exception -> 0x00c5 }
            r7.savedCheckout = r8     // Catch:{ Exception -> 0x00c5 }
            r8.setTransactionAmount(r0)     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.Checkout r8 = r7.savedCheckout     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.request.RequestPayload r8 = r8.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.request.Cart r8 = r8.getCart()     // Catch:{ Exception -> 0x00c5 }
            java.util.List r8 = r8.getItem()     // Catch:{ Exception -> 0x00c5 }
            if (r8 == 0) goto L_0x008b
            int r4 = r8.size()     // Catch:{ Exception -> 0x00c5 }
            if (r4 <= 0) goto L_0x008b
            java.lang.Object r8 = r8.get(r5)     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.request.Item r8 = (com.paynimo.android.payment.model.request.Item) r8     // Catch:{ Exception -> 0x00c5 }
            r8.setAmount(r0)     // Catch:{ Exception -> 0x00c5 }
        L_0x008b:
            com.paynimo.android.payment.model.Checkout r8 = r7.savedCheckout     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.request.RequestPayload r8 = r8.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c5 }
            r7.request_payload = r8     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00ba
        L_0x0094:
            r0 = 1
            if (r8 == 0) goto L_0x0099
            if (r8 != r0) goto L_0x00a5
        L_0x0099:
            java.util.List<java.lang.Integer> r8 = r7.eSign     // Catch:{ Exception -> 0x00c5 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00c5 }
            boolean r8 = r8.contains(r0)     // Catch:{ Exception -> 0x00c5 }
            if (r8 != 0) goto L_0x00b2
        L_0x00a5:
            java.util.List<java.lang.Integer> r8 = r7.eSign     // Catch:{ Exception -> 0x00c5 }
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00c5 }
            boolean r8 = r8.contains(r0)     // Catch:{ Exception -> 0x00c5 }
            if (r8 == 0) goto L_0x00ba
        L_0x00b2:
            com.paynimo.android.payment.model.Checkout r8 = r7.checkout     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.request.RequestPayload r8 = r8.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c5 }
            r7.request_payload = r8     // Catch:{ Exception -> 0x00c5 }
        L_0x00ba:
            r7.showProgressLoader()     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.b.d r8 = r7.mServiceManager     // Catch:{ Exception -> 0x00c5 }
            com.paynimo.android.payment.model.request.RequestPayload r0 = r7.request_payload     // Catch:{ Exception -> 0x00c5 }
            r8.callTRequest(r0, r7)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00d9
        L_0x00c5:
            r7.showAlertDialog(r3, r2, r1)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00d9
        L_0x00c9:
            de.greenrobot.event.EventBus r8 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x00d6 }
            com.paynimo.android.payment.event.g r0 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x00d6 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00d6 }
            r8.post(r0)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00d9
        L_0x00d6:
            r7.showAlertDialog(r3, r2, r1)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.networkCallWithBankCode(int):void");
    }

    private void prepareListData(String str) {
        g next;
        ArrayList<g> arrayList = this.banksList;
        if (arrayList != null && arrayList.size() > 0) {
            this.banksList.clear();
        }
        HashMap<String, g> hashMap = this.banksData;
        if (hashMap != null && hashMap.size() > 0) {
            this.banksData.clear();
        }
        h digitalMandate = this.pmiData.getBanks().getDigitalMandate();
        if (digitalMandate != null) {
            int topBanksCount = digitalMandate.getTopBanksCount();
            int otherBanksCount = digitalMandate.getOtherBanksCount();
            if (topBanksCount > 0) {
                if (GeneratedOutlineSupport.outline107(this.checkout, "Y")) {
                    g gVar = new g();
                    gVar.setBankName("Banks");
                    gVar.setBankCode("");
                } else {
                    g gVar2 = new g();
                    if (otherBanksCount > 0) {
                        gVar2.setBankName("Popular Banks");
                        gVar2.setBankCode("");
                    } else {
                        gVar2.setBankName("Banks");
                        gVar2.setBankCode("");
                    }
                    if (str == null) {
                        gVar2.setHeader(true);
                        this.banksList.add(gVar2);
                        this.adapter.addSectionHeaderItem(gVar2);
                    } else {
                        gVar2.setBankName("Banks");
                        gVar2.setHeader(true);
                        this.banksList.add(gVar2);
                        this.adapter.addSectionHeaderItem(gVar2);
                    }
                }
                List<g> topBanks = digitalMandate.getTopBanks();
                if (topBanks != null) {
                    for (g next2 : topBanks) {
                        if (str == null) {
                            if (!(next2 == null || (next2.geteAuthBank() == null && next2.geteMandateBank() == null && next2.geteAuthBankBio() == null && next2.geteNACHBankCard() == null && next2.geteNACHBank() == null))) {
                                if (this.adapter.getCount() == 0) {
                                    g gVar3 = new g();
                                    gVar3.setBankName("Banks");
                                    gVar3.setBankCode("");
                                    gVar3.setHeader(true);
                                    this.banksList.add(gVar3);
                                    this.adapter.addSectionHeaderItem(gVar3);
                                }
                                this.adapter.addItem(next2);
                                this.banksList.add(next2);
                                this.banksData.put(next2.getBankName(), next2);
                            }
                        } else if (next2.getBankCode() == null || !next2.getBankCode().equalsIgnoreCase(str)) {
                            if (next2.geteMandateBank() != null && next2.geteMandateBank().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next2.geteMandateBank().getBankName();
                                this.selected_bank = next2.getBankName();
                                this.adapter.addItem(next2);
                                this.banksList.add(next2);
                                this.banksData.put(next2.geteMandateBank().getBankCode(), next2);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(1));
                                return;
                            } else if (next2.geteAuthBankBio() != null && next2.geteAuthBankBio().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next2.geteAuthBankBio().getBankName();
                                this.selected_bank = next2.getBankName();
                                this.adapter.addItem(next2);
                                this.banksList.add(next2);
                                this.banksData.put(next2.geteAuthBankBio().getBankCode(), next2);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(0));
                                return;
                            } else if (next2.geteAuthBank() != null && next2.geteAuthBank().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next2.geteAuthBank().getBankName();
                                this.selected_bank = next2.getBankName();
                                this.adapter.addItem(next2);
                                this.banksList.add(next2);
                                this.banksData.put(next2.geteAuthBank().getBankCode(), next2);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(0));
                                return;
                            } else if (next2.geteNACHBank() != null && next2.geteNACHBank().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next2.geteNACHBank().getBankName();
                                this.selected_bank = next2.getBankName();
                                this.adapter.addItem(next2);
                                this.banksList.add(next2);
                                this.banksData.put(next2.geteNACHBank().getBankCode(), next2);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(2));
                                return;
                            } else if (next2.geteNACHBankCard() != null && next2.geteNACHBankCard().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next2.geteNACHBankCard().getBankName();
                                this.selected_bank = next2.getBankName();
                                this.adapter.addItem(next2);
                                this.banksList.add(next2);
                                this.banksData.put(next2.geteNACHBankCard().getBankCode(), next2);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(2));
                                return;
                            }
                        } else if (next2.geteAuthBank() == null && next2.geteAuthBankBio() == null && next2.geteMandateBank() == null && next2.geteNACHBank() == null && next2.geteNACHBankCard() == null) {
                            transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                        } else {
                            this.selected_bank_name = next2.getBankName();
                            this.selected_bank = next2.getBankName();
                            this.adapter.addItem(next2);
                            this.banksList.add(next2);
                            this.banksData.put(next2.getBankCode(), next2);
                            this.eSign.clear();
                            if (!(next2.geteAuthBank() == null && next2.geteAuthBankBio() == null)) {
                                this.eSign.add(Integer.valueOf(0));
                            }
                            if (next2.geteMandateBank() != null) {
                                this.eSign.add(Integer.valueOf(1));
                            }
                            if (!(next2.geteNACHBank() == null && next2.geteNACHBankCard() == null)) {
                                this.eSign.add(Integer.valueOf(2));
                            }
                            return;
                        }
                    }
                }
            }
            if (otherBanksCount > 0) {
                if (GeneratedOutlineSupport.outline107(this.checkout, "Y")) {
                    g gVar4 = new g();
                    gVar4.setBankName("Banks");
                    gVar4.setBankCode("");
                } else {
                    g gVar5 = new g();
                    if (topBanksCount > 0) {
                        gVar5.setBankName("Other Banks");
                        gVar5.setBankCode("");
                    } else {
                        gVar5.setBankName("Banks");
                        gVar5.setBankCode("");
                    }
                    if (str == null) {
                        gVar5.setHeader(true);
                        this.banksList.add(gVar5);
                        this.adapter.addSectionHeaderItem(gVar5);
                    } else if (this.adapter.getCount() == 0) {
                        gVar5.setBankName("Banks");
                        gVar5.setHeader(true);
                        this.banksList.add(gVar5);
                        this.adapter.addSectionHeaderItem(gVar5);
                    }
                }
                List<g> otherBanks = digitalMandate.getOtherBanks();
                if (otherBanks != null) {
                    Iterator<g> it = otherBanks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        next = it.next();
                        if (str == null) {
                            if (!(next == null || (next.geteAuthBank() == null && next.geteMandateBank() == null && next.geteAuthBankBio() == null && next.geteNACHBank() == null && next.geteNACHBankCard() == null))) {
                                if (this.adapter.getCount() == 0) {
                                    g gVar6 = new g();
                                    gVar6.setBankName("Banks");
                                    gVar6.setBankCode("");
                                    gVar6.setHeader(true);
                                    this.banksList.add(gVar6);
                                    this.adapter.addSectionHeaderItem(gVar6);
                                }
                                this.adapter.addItem(next);
                                this.banksList.add(next);
                                this.banksData.put(next.getBankName(), next);
                            }
                        } else if (next.getBankCode() == null || !next.getBankCode().equalsIgnoreCase(str)) {
                            if (next.geteMandateBank() != null && next.geteMandateBank().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next.geteMandateBank().getBankName();
                                this.selected_bank = next.getBankName();
                                this.adapter.addItem(next);
                                this.banksList.add(next);
                                this.banksData.put(next.geteMandateBank().getBankCode(), next);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(1));
                                return;
                            } else if (next.geteAuthBankBio() != null && next.geteAuthBankBio().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next.geteAuthBankBio().getBankName();
                                this.selected_bank = next.getBankName();
                                this.adapter.addItem(next);
                                this.banksList.add(next);
                                this.banksData.put(next.geteAuthBankBio().getBankCode(), next);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(0));
                                return;
                            } else if (next.geteAuthBank() != null && next.geteAuthBank().getBankCode().equalsIgnoreCase(str)) {
                                this.selected_bank_name = next.geteAuthBank().getBankName();
                                this.selected_bank = next.getBankName();
                                this.adapter.addItem(next);
                                this.banksList.add(next);
                                this.banksData.put(next.geteAuthBank().getBankCode(), next);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(0));
                                return;
                            } else if (next.geteNACHBank() == null || !next.geteNACHBank().getBankCode().equalsIgnoreCase(str)) {
                                if (next.geteNACHBankCard() != null && next.geteNACHBankCard().getBankCode().equalsIgnoreCase(str)) {
                                    this.selected_bank_name = next.geteNACHBankCard().getBankName();
                                    this.selected_bank = next.getBankName();
                                    this.adapter.addItem(next);
                                    this.banksList.add(next);
                                    this.banksData.put(next.geteNACHBankCard().getBankCode(), next);
                                    this.eSign.clear();
                                    this.eSign.add(Integer.valueOf(2));
                                    break;
                                }
                            } else {
                                this.selected_bank_name = next.geteNACHBank().getBankName();
                                this.selected_bank = next.getBankName();
                                this.adapter.addItem(next);
                                this.banksList.add(next);
                                this.banksData.put(next.geteNACHBank().getBankCode(), next);
                                this.eSign.clear();
                                this.eSign.add(Integer.valueOf(2));
                                return;
                            }
                        } else if (next.geteAuthBank() == null && next.geteAuthBankBio() == null && next.geteMandateBank() == null && next.geteNACHBank() == null && next.geteNACHBankCard() == null) {
                            transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
                        } else {
                            this.selected_bank_name = next.getBankName();
                            this.selected_bank = next.getBankName();
                            this.adapter.addItem(next);
                            this.banksList.add(next);
                            this.banksData.put(next.getBankCode(), next);
                            this.eSign.clear();
                        }
                    }
                    this.selected_bank_name = next.getBankName();
                    this.selected_bank = next.getBankName();
                    this.adapter.addItem(next);
                    this.banksList.add(next);
                    this.banksData.put(next.getBankCode(), next);
                    this.eSign.clear();
                    if (!(next.geteAuthBank() == null && next.geteAuthBankBio() == null)) {
                        this.eSign.add(Integer.valueOf(0));
                    }
                    if (next.geteMandateBank() != null) {
                        this.eSign.add(Integer.valueOf(1));
                    }
                    if (!(next.geteNACHBank() == null && next.geteNACHBankCard() == null)) {
                        this.eSign.add(Integer.valueOf(2));
                    }
                }
            }
        }
    }

    private void prepareWebviewDataForAccounts(com.paynimo.android.payment.model.response.h hVar) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            new ArrayList();
            String subType = hVar.getAuthentication().getSubType();
            if (subType == null || !subType.equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_NET)) {
                Constant.showOutputLog(TAG, "subtype is not NET type=================>>>");
                return;
            }
            String bankAcsUrl = hVar.getACS().getBankAcsUrl();
            if (bankAcsUrl == null || bankAcsUrl.equalsIgnoreCase("")) {
                showAlertDialog(-2, Constant.TAG_ERROR_INVALID_URL_CODE, Constant.TAG_ERROR_INVALID_URL);
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
            showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    private void prepareWebviewDataForCard(com.paynimo.android.payment.model.response.h hVar) {
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

    private void retrieveSavedInstanceData(Bundle bundle) {
        this.paymentSettings = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.checkout = (Checkout) bundle.getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) bundle.getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
    }

    private void setESignModes() {
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.tabLayout.getTabAt(0);
    }

    private void setImage() {
        this.et_cardNumber.setTextColor(ContextCompat.getColor(this, getResources().getIdentifier("defaultTextColor", "color", getPackageName())));
        String showCCardWithIntervals = showCCardWithIntervals(this.et_cardNumber.getText().toString().replaceAll("\\s", ""), this.cardType);
        boolean z = showCCardWithIntervals.length() <= 0;
        String replaceAll = showCCardWithIntervals.substring(0, Math.min(7, showCCardWithIntervals.length())).replaceAll("\\s", "");
        String str = this.firstNumbers;
        if (str == null || !str.equals(replaceAll)) {
            this.firstNumbers = replaceAll;
            CardType cardType2 = CardType.getCardType(replaceAll, this.paymentSettings.getAllowedCardTypes());
            this.cardType = cardType2;
            this.et_cardNumber.setFilters(new InputFilter[]{new LengthFilter(this.cardType.getNumberOfIntervals() + cardType2.getMaxLength())});
        }
        CardValidator.isValidCardType(this, this.et_cardNumber, this.cardType);
        CardType cardType3 = this.cardType;
        if (cardType3 == CardType.YetUnknown || cardType3 == CardType.Invalid) {
            this.card_imageview.setVisibility(8);
        } else {
            this.card_imageview.setVisibility(0);
            this.card_imageview.setImageResource(this.cardType.getImageId());
            this.cardDataType = this.cardType.toString();
        }
        int numberOfIntervals = this.cardType.getNumberOfIntervals() + this.cardType.getMaxLength();
        if (showCCardWithIntervals.length() > numberOfIntervals) {
            showCCardWithIntervals = showCCardWithIntervals.substring(0, numberOfIntervals);
        }
        int cCardMarkerPosition = getCCardMarkerPosition(this.et_cardNumber.getSelectionStart(), z, this.cardType);
        this.et_cardNumber.setText(showCCardWithIntervals);
        EditText editText = this.et_cardNumber;
        if (cCardMarkerPosition >= showCCardWithIntervals.length()) {
            cCardMarkerPosition = showCCardWithIntervals.length();
        }
        editText.setSelection(cCardMarkerPosition);
        if (this.cardType != CardType.Invalid) {
            if (showCCardWithIntervals.length() == this.cardType.getNumberOfIntervals() + this.cardType.getMaxLength() && CardValidator.validateCreditCardNumber(this, this.et_cardNumber, this.cardType, this.paymentSettings.getAllowedCardTypes())) {
                this.et_dateText.requestFocus();
            }
        }
        showCCardWithIntervals.length();
        if (this.cardType != CardType.Invalid) {
            this.et_verificationText.setFilters(new InputFilter[]{new LengthFilter(this.cardType.getCVCLength())});
            if (this.et_verificationText.length() > 0) {
                CardValidator.validateCheckNumber(this, this.et_verificationText, this.cardType);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setListData() {
        String token2 = this.checkout.getMerchantRequestPayload().getPayment().getMethod().getToken();
        if (token2 == null || token2.isEmpty()) {
            prepareListData(null);
            this.spinner_top_banks.setAdapter(new b(this, 17367048, this.banksList));
            return;
        }
        prepareListData(token2);
        ArrayList<g> arrayList = this.banksList;
        if (arrayList == null || arrayList.size() != 0) {
            this.spinner_top_banks.setAdapter(new b(this, 17367048, this.banksList));
            this.spinner_top_banks.setSelection(0);
            this.spinner_top_banks.setEnabled(false);
            this.spinner_top_banks.setOnItemSelectedListener(null);
            this.lyt_dm_tab.setVisibility(0);
            ViewPagerAdapter viewPagerAdapter2 = new ViewPagerAdapter(getSupportFragmentManager());
            this.viewPagerAdapter = viewPagerAdapter2;
            this.viewPager.setAdapter(viewPagerAdapter2);
            this.tabLayout.setupWithViewPager(this.viewPager);
            this.viewPager.setCurrentItem(0);
            ViewParent parent = this.viewPager.getParent();
            CustomPager customPager = this.viewPager;
            parent.requestChildFocus(customPager, customPager);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    int selectedTabPosition = DigitalMandateActivity.this.tabLayout.getSelectedTabPosition();
                    Tab tabAt = DigitalMandateActivity.this.tabLayout.getTabAt(selectedTabPosition);
                    String str5 = tabAt != null ? (String) tabAt.text : null;
                    g gVar = (g) DigitalMandateActivity.this.banksData.values().toArray()[0];
                    String accountType = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountType();
                    String accountHolderName = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountHolderName();
                    String accountNo = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountNo();
                    String str6 = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getiFSC();
                    String phoneNumber = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getPhoneNumber();
                    String mobileNumber = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getMobileNumber();
                    String pan = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getPan();
                    String emailID = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getEmailID();
                    String str7 = Constant.TAG_ERROR_ACC_TYPE_VALIDATION_CODE;
                    String str8 = emailID;
                    String str9 = pan;
                    String str10 = mobileNumber;
                    String str11 = phoneNumber;
                    String str12 = Constant.TAG_ERROR_ACC_TYPE_VALIDATION;
                    if (str5 != null) {
                        String str13 = str7;
                        if (!str5.equalsIgnoreCase(DigitalMandateActivity.EAUTH_MODE) || (gVar.geteAuthBank() == null && gVar.geteAuthBankBio() == null)) {
                            str3 = "Saving";
                            str2 = "Current";
                            str = str12;
                            str7 = str13;
                        } else {
                            View childAt = DigitalMandateActivity.this.viewPager.getChildAt(selectedTabPosition);
                            if (childAt != null) {
                                DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                String str14 = "Current";
                                String str15 = "Saving";
                                digitalMandateActivity.et_aadhar_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity.getResources(), "paynimo_et_aadhar_number", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                digitalMandateActivity2.et_account_holder_name = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity2.getResources(), "paynimo_et_account_holder_name", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity3 = DigitalMandateActivity.this;
                                digitalMandateActivity3.et_account_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity3.getResources(), "paynimo_et_account_number", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity4 = DigitalMandateActivity.this;
                                digitalMandateActivity4.et_ifsc_code = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity4.getResources(), "paynimo_et_ifsc_code", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity5 = DigitalMandateActivity.this;
                                digitalMandateActivity5.spinner_account_type = (Spinner) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity5.getResources(), "paynimo_spn_account_type", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity6 = DigitalMandateActivity.this;
                                digitalMandateActivity6.lyt_rdo_group = (LinearLayout) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity6.getResources(), "paynimo_lyt_rdo_group", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity7 = DigitalMandateActivity.this;
                                digitalMandateActivity7.rg_esign_modes = (RadioGroup) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity7.getResources(), "paynimo_rg_esign_modes", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity8 = DigitalMandateActivity.this;
                                digitalMandateActivity8.rdo_OTP = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity8.getResources(), "paynimo_rdo_OTP", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity9 = DigitalMandateActivity.this;
                                digitalMandateActivity9.rdo_biometric = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity9.getResources(), "paynimo_rdo_biometric", "id", childAt);
                                DigitalMandateActivity digitalMandateActivity10 = DigitalMandateActivity.this;
                                digitalMandateActivity10.tv_biometric_note_text = (TextView) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity10.getResources(), "paynimo_biometric_note_text", "id", childAt);
                                if (gVar.geteAuthBankBio() != null && gVar.geteAuthBankBio().getBankCode() != null) {
                                    DigitalMandateActivity.this.lyt_rdo_group.setVisibility(0);
                                    DigitalMandateActivity.this.rdo_biometric.setChecked(true);
                                    DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(0);
                                    if (VERSION.SDK_INT >= 24) {
                                        TextView access$1800 = DigitalMandateActivity.this.tv_biometric_note_text;
                                        DigitalMandateActivity digitalMandateActivity11 = DigitalMandateActivity.this;
                                        access$1800.setText(Html.fromHtml(digitalMandateActivity11.getString(digitalMandateActivity11.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())), 0));
                                    } else {
                                        TextView access$18002 = DigitalMandateActivity.this.tv_biometric_note_text;
                                        DigitalMandateActivity digitalMandateActivity12 = DigitalMandateActivity.this;
                                        access$18002.setText(Html.fromHtml(digitalMandateActivity12.getString(digitalMandateActivity12.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()))));
                                    }
                                    DigitalMandateActivity.this.rg_esign_modes.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                            if (i == DigitalMandateActivity.this.getResources().getIdentifier("paynimo_rdo_biometric", "id", DigitalMandateActivity.this.getPackageName())) {
                                                DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(0);
                                                if (VERSION.SDK_INT >= 24) {
                                                    TextView access$1800 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                    DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                                    access$1800.setText(Html.fromHtml(digitalMandateActivity.getString(digitalMandateActivity.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())), 0));
                                                    return;
                                                }
                                                TextView access$18002 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                                access$18002.setText(Html.fromHtml(digitalMandateActivity2.getString(digitalMandateActivity2.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()))));
                                                return;
                                            }
                                            DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                        }
                                    });
                                    if (DigitalMandateActivity.this.selected_bank_name != null && (DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBankBio().getBankName()) || DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBank().getBankName()))) {
                                        DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                        if (DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBankBio().getBankName())) {
                                            DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(0);
                                            TextView access$18003 = DigitalMandateActivity.this.tv_biometric_note_text;
                                            DigitalMandateActivity digitalMandateActivity13 = DigitalMandateActivity.this;
                                            access$18003.setText(Html.fromHtml(digitalMandateActivity13.getString(digitalMandateActivity13.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()))));
                                            DigitalMandateActivity.this.rdo_biometric.setChecked(true);
                                        } else {
                                            DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                            DigitalMandateActivity.this.rdo_OTP.setChecked(true);
                                        }
                                    }
                                } else if (DigitalMandateActivity.this.lyt_rdo_group != null) {
                                    DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                    DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                }
                                if (accountHolderName != null && !accountHolderName.isEmpty()) {
                                    DigitalMandateActivity.this.et_account_holder_name.setText(accountHolderName.trim());
                                    DigitalMandateActivity.this.et_account_holder_name.setKeyListener(null);
                                }
                                if (accountNo != null && !accountNo.isEmpty()) {
                                    DigitalMandateActivity.this.et_account_number.setText(accountNo.trim());
                                    DigitalMandateActivity.this.et_account_number.setKeyListener(null);
                                }
                                if (str6 != null && !str6.isEmpty()) {
                                    DigitalMandateActivity.this.et_ifsc_code.setText(str6.trim());
                                }
                                if (accountType != null && !accountType.isEmpty()) {
                                    String str16 = str15;
                                    String str17 = str14;
                                    if (accountType.equalsIgnoreCase(str16) || accountType.equalsIgnoreCase(str17) || accountType.equalsIgnoreCase(AFMParser.CC)) {
                                        if (accountType.equalsIgnoreCase(str16)) {
                                            DigitalMandateActivity.this.spinner_account_type.setSelection(1);
                                        }
                                        if (accountType.equalsIgnoreCase(str17)) {
                                            DigitalMandateActivity.this.spinner_account_type.setSelection(2);
                                        }
                                        if (accountType.equalsIgnoreCase(AFMParser.CC)) {
                                            DigitalMandateActivity.this.spinner_account_type.setSelection(3);
                                        }
                                        DigitalMandateActivity.this.spinner_account_type.setEnabled(false);
                                        DigitalMandateActivity.this.spinner_account_type.setOnItemSelectedListener(null);
                                        return;
                                    }
                                    DigitalMandateActivity.this.transactionError(str13, str12);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        str3 = "Saving";
                        str2 = "Current";
                        str = str12;
                    }
                    String str18 = str;
                    if (str5 == null || !str5.equalsIgnoreCase(DigitalMandateActivity.EMANDATE_MODE)) {
                        str4 = str7;
                    } else {
                        str4 = str7;
                        if (DigitalMandateActivity.this.eSign.contains(Integer.valueOf(1)) && gVar.geteMandateBank() != null) {
                            View childAt2 = DigitalMandateActivity.this.viewPager.getChildAt(selectedTabPosition);
                            if (childAt2 != null) {
                                DigitalMandateActivity digitalMandateActivity14 = DigitalMandateActivity.this;
                                digitalMandateActivity14.et_account_holder_name = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity14.getResources(), "paynimo_et_account_holder_name", "id", childAt2);
                                DigitalMandateActivity digitalMandateActivity15 = DigitalMandateActivity.this;
                                digitalMandateActivity15.dm_et_account_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity15.getResources(), "paynimo_digital_mandate_account_number", "id", childAt2);
                                if (accountHolderName != null && !accountHolderName.isEmpty()) {
                                    DigitalMandateActivity.this.et_account_holder_name.setText(accountHolderName.trim());
                                    DigitalMandateActivity.this.et_account_holder_name.setKeyListener(null);
                                }
                                if (accountNo != null && !accountNo.isEmpty()) {
                                    DigitalMandateActivity.this.dm_et_account_number.setText(accountNo.trim());
                                    DigitalMandateActivity.this.dm_et_account_number.setKeyListener(null);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    if (str5 != null && str5.equalsIgnoreCase(DigitalMandateActivity.ENACH_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(2))) {
                        if (gVar.geteNACHBank() != null || gVar.geteNACHBankCard() != null) {
                            View childAt3 = DigitalMandateActivity.this.viewPager.getChildAt(selectedTabPosition);
                            if (childAt3 != null) {
                                DigitalMandateActivity digitalMandateActivity16 = DigitalMandateActivity.this;
                                digitalMandateActivity16.et_account_holder_name = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity16.getResources(), "paynimo_et_account_holder_name", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity17 = DigitalMandateActivity.this;
                                digitalMandateActivity17.et_account_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity17.getResources(), "paynimo_et_account_number", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity18 = DigitalMandateActivity.this;
                                digitalMandateActivity18.et_ifsc_code = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity18.getResources(), "paynimo_et_ifsc_code", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity19 = DigitalMandateActivity.this;
                                digitalMandateActivity19.spinner_account_type = (Spinner) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity19.getResources(), "paynimo_spn_account_type", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity20 = DigitalMandateActivity.this;
                                digitalMandateActivity20.et_phone_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity20.getResources(), "paynimo_et_phone_number", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity21 = DigitalMandateActivity.this;
                                digitalMandateActivity21.et_mobile_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity21.getResources(), "paynimo_et_mobile_number", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity22 = DigitalMandateActivity.this;
                                digitalMandateActivity22.et_pan_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity22.getResources(), "paynimo_et_pan_number", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity23 = DigitalMandateActivity.this;
                                digitalMandateActivity23.et_email_id = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity23.getResources(), "paynimo_et_email_id", "id", childAt3);
                                DigitalMandateActivity digitalMandateActivity24 = DigitalMandateActivity.this;
                                digitalMandateActivity24.lyt_rdo_group = (LinearLayout) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity24.getResources(), "paynimo_lyt_enach_rdo_group", "id", childAt3);
                                if (gVar.geteNACHBankCard() == null || gVar.geteNACHBank() == null) {
                                    DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                } else {
                                    DigitalMandateActivity.this.lyt_rdo_group.setVisibility(0);
                                }
                                if (accountHolderName != null && !accountHolderName.isEmpty()) {
                                    DigitalMandateActivity.this.et_account_holder_name.setText(accountHolderName.trim());
                                    DigitalMandateActivity.this.et_account_holder_name.setKeyListener(null);
                                }
                                if (accountNo != null && !accountNo.isEmpty()) {
                                    DigitalMandateActivity.this.et_account_number.setText(accountNo.trim());
                                    DigitalMandateActivity.this.et_account_number.setKeyListener(null);
                                }
                                if (str11 != null && !str11.isEmpty()) {
                                    DigitalMandateActivity.this.et_phone_number.setText(str11);
                                    DigitalMandateActivity.this.et_phone_number.setKeyListener(null);
                                }
                                if (str10 != null && !str10.isEmpty()) {
                                    DigitalMandateActivity.this.et_mobile_number.setText(str10);
                                    DigitalMandateActivity.this.et_mobile_number.setKeyListener(null);
                                }
                                if (str9 != null && !str9.isEmpty()) {
                                    DigitalMandateActivity.this.et_pan_number.setText(str9);
                                    DigitalMandateActivity.this.et_pan_number.setKeyListener(null);
                                }
                                if (str8 != null && !str8.isEmpty()) {
                                    DigitalMandateActivity.this.et_email_id.setText(str8);
                                    DigitalMandateActivity.this.et_email_id.setKeyListener(null);
                                }
                                if (accountType != null && !accountType.isEmpty()) {
                                    if (accountType.equalsIgnoreCase(str3) || accountType.equalsIgnoreCase(str2)) {
                                        if (accountType.equalsIgnoreCase(str3)) {
                                            DigitalMandateActivity.this.spinner_account_type.setSelection(1);
                                        }
                                        if (accountType.equalsIgnoreCase(str2)) {
                                            DigitalMandateActivity.this.spinner_account_type.setSelection(2);
                                        }
                                        DigitalMandateActivity.this.spinner_account_type.setEnabled(false);
                                        DigitalMandateActivity.this.spinner_account_type.setOnItemSelectedListener(null);
                                        return;
                                    }
                                    DigitalMandateActivity.this.transactionError(str4, str18);
                                }
                            }
                        }
                    }
                }
            }, 50);
            return;
        }
        transactionError(Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED_CODE, Constant.TAG_ERROR_BANK_CODE_NOT_SUPPORTED);
    }

    private void setListeners() {
        this.ibStartDate.setOnClickListener(this);
        this.ibEndDate.setOnClickListener(this);
        this.rg_mode.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int i2 = i;
                DigitalMandateActivity.this.btn_pay.setVisibility(0);
                if (i2 == DigitalMandateActivity.this.getResources().getIdentifier("paynimo_rdo_account", "id", DigitalMandateActivity.this.getPackageName())) {
                    com.paynimo.android.payment.util.b.callEventLogging("", "click", "radio:DigitalMandateAccount", 0, "PASS", DigitalMandateActivity.this.checkout, "", "", "", "", DigitalMandateActivity.this.mServiceManager, DigitalMandateActivity.this);
                    DigitalMandateActivity.this.lyt_bank_list.setVisibility(0);
                    DigitalMandateActivity.this.lyt_card.setVisibility(8);
                    DigitalMandateActivity.this.adapter = new a(DigitalMandateActivity.this, PaymentActivity.PAYMENT_METHOD_DIGITALMANDATE);
                    DigitalMandateActivity.this.setListData();
                } else if (i2 == DigitalMandateActivity.this.getResources().getIdentifier("paynimo_rdo_card", "id", DigitalMandateActivity.this.getPackageName())) {
                    com.paynimo.android.payment.util.b.callEventLogging("", "click", "radio:DigitalMandateCard", 0, "PASS", DigitalMandateActivity.this.checkout, "", "", "", "", DigitalMandateActivity.this.mServiceManager, DigitalMandateActivity.this);
                    DigitalMandateActivity.this.lyt_bank_list.setVisibility(8);
                    DigitalMandateActivity.this.lyt_card.setVisibility(0);
                    DigitalMandateActivity.this.lyt_dm_tab.setVisibility(8);
                    DigitalMandateActivity.this.lyt_card.getParent().requestChildFocus(DigitalMandateActivity.this.lyt_card, DigitalMandateActivity.this.lyt_card);
                    Typeface createFromAsset = Typeface.createFromAsset(DigitalMandateActivity.this.getAssets(), DigitalMandateActivity.this.getResources().getString(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())));
                    DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                    SpannableString spannableString = new SpannableString(String.format(digitalMandateActivity.getString(digitalMandateActivity.getResources().getIdentifier("paynimo_digital_mandate_btn_pay_label", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()), new Object[]{DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getTransaction().getAmount()}), new Object[0]));
                    spannableString.setSpan(new com.paynimo.android.payment.util.a("", createFromAsset), 4, 5, 33);
                    spannableString.setSpan(new RelativeSizeSpan(0.8f), 4, 5, 33);
                    DigitalMandateActivity.this.btn_pay.setText(spannableString);
                }
            }
        });
        this.spinner_top_banks.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long j) {
                String charSequence = ((TextView) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, DigitalMandateActivity.this.getResources(), "paynimo_txt_bank_name", "id", view)).getText().toString();
                DigitalMandateActivity.this.eSign.clear();
                if (DigitalMandateActivity.this.banksData.containsKey(charSequence)) {
                    final g gVar = (g) DigitalMandateActivity.this.banksData.get(charSequence);
                    DigitalMandateActivity.this.selected_bank_name = charSequence;
                    final int i2 = 0;
                    DigitalMandateActivity.this.lyt_dm_tab.setVisibility(0);
                    i iVar = gVar.geteAuthBank();
                    j jVar = gVar.geteAuthBankBio();
                    if (iVar == null && jVar == null) {
                        i2 = -1;
                    } else {
                        DigitalMandateActivity.this.eSign.add(Integer.valueOf(0));
                    }
                    if (gVar.geteMandateBank() != null) {
                        DigitalMandateActivity.this.eSign.add(Integer.valueOf(1));
                        if (i2 == -1) {
                            i2++;
                        }
                    }
                    m mVar = gVar.geteNACHBank();
                    n nVar = gVar.geteNACHBankCard();
                    if (!(mVar == null && nVar == null)) {
                        DigitalMandateActivity.this.eSign.add(Integer.valueOf(2));
                        if (i2 == -1) {
                            i2++;
                        }
                    }
                    DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                    digitalMandateActivity.viewPagerAdapter = new ViewPagerAdapter(digitalMandateActivity.getSupportFragmentManager());
                    DigitalMandateActivity.this.viewPager.setAdapter(DigitalMandateActivity.this.viewPagerAdapter);
                    DigitalMandateActivity.this.tabLayout.setupWithViewPager(DigitalMandateActivity.this.viewPager);
                    DigitalMandateActivity.this.viewPager.getParent().requestChildFocus(DigitalMandateActivity.this.viewPager, DigitalMandateActivity.this.viewPager);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (i2 == 0 && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(0)) && (gVar.geteAuthBank() != null || gVar.geteAuthBankBio() != null)) {
                                View childAt = DigitalMandateActivity.this.viewPager.getChildAt(i);
                                if (childAt != null) {
                                    DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                    digitalMandateActivity.lyt_rdo_group = (LinearLayout) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity.getResources(), "paynimo_lyt_rdo_group", "id", childAt);
                                    DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                    digitalMandateActivity2.rg_esign_modes = (RadioGroup) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity2.getResources(), "paynimo_rg_esign_modes", "id", childAt);
                                    DigitalMandateActivity digitalMandateActivity3 = DigitalMandateActivity.this;
                                    digitalMandateActivity3.rdo_OTP = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity3.getResources(), "paynimo_rdo_OTP", "id", childAt);
                                    DigitalMandateActivity digitalMandateActivity4 = DigitalMandateActivity.this;
                                    digitalMandateActivity4.rdo_biometric = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity4.getResources(), "paynimo_rdo_biometric", "id", childAt);
                                    DigitalMandateActivity digitalMandateActivity5 = DigitalMandateActivity.this;
                                    digitalMandateActivity5.tv_biometric_note_text = (TextView) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity5.getResources(), "paynimo_biometric_note_text", "id", childAt);
                                    if (gVar.geteAuthBankBio() != null && gVar.geteAuthBankBio().getBankCode() != null) {
                                        if (DigitalMandateActivity.this.lyt_rdo_group != null) {
                                            DigitalMandateActivity.this.lyt_rdo_group.setVisibility(0);
                                            DigitalMandateActivity.this.rdo_OTP.setChecked(true);
                                            DigitalMandateActivity.this.rg_esign_modes.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                                                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                                    if (i == DigitalMandateActivity.this.getResources().getIdentifier("paynimo_rdo_biometric", "id", DigitalMandateActivity.this.getPackageName())) {
                                                        DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(0);
                                                        if (VERSION.SDK_INT >= 24) {
                                                            TextView access$1800 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                            DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                                            access$1800.setText(Html.fromHtml(digitalMandateActivity.getString(digitalMandateActivity.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())), 0));
                                                            return;
                                                        }
                                                        TextView access$18002 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                        DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                                        access$18002.setText(Html.fromHtml(digitalMandateActivity2.getString(digitalMandateActivity2.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()))));
                                                        return;
                                                    }
                                                    DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                                }
                                            });
                                        }
                                        if (DigitalMandateActivity.this.selected_bank_name == null) {
                                            return;
                                        }
                                        if ((DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBankBio().getBankName()) || DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBank().getBankName())) && DigitalMandateActivity.this.lyt_rdo_group != null) {
                                            DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                            if (DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBankBio().getBankName())) {
                                                DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(0);
                                                if (VERSION.SDK_INT >= 24) {
                                                    TextView access$1800 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                    DigitalMandateActivity digitalMandateActivity6 = DigitalMandateActivity.this;
                                                    access$1800.setText(Html.fromHtml(digitalMandateActivity6.getString(digitalMandateActivity6.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())), 0));
                                                } else {
                                                    TextView access$18002 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                    DigitalMandateActivity digitalMandateActivity7 = DigitalMandateActivity.this;
                                                    access$18002.setText(Html.fromHtml(digitalMandateActivity7.getString(digitalMandateActivity7.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()))));
                                                }
                                                DigitalMandateActivity.this.rdo_biometric.setChecked(true);
                                                return;
                                            }
                                            DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                            DigitalMandateActivity.this.rdo_OTP.setChecked(true);
                                        }
                                    } else if (DigitalMandateActivity.this.lyt_rdo_group != null) {
                                        DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                        DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                    }
                                }
                            } else if (i2 == 1 && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(1)) && gVar.geteMandateBank() != null) {
                                String accountHolderName = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountHolderName();
                                String accountNo = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountNo();
                                View childAt2 = DigitalMandateActivity.this.viewPager.getChildAt(i);
                                if (childAt2 != null) {
                                    DigitalMandateActivity digitalMandateActivity8 = DigitalMandateActivity.this;
                                    digitalMandateActivity8.et_account_holder_name = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity8.getResources(), "paynimo_et_account_holder_name", "id", childAt2);
                                    DigitalMandateActivity digitalMandateActivity9 = DigitalMandateActivity.this;
                                    digitalMandateActivity9.dm_et_account_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity9.getResources(), "paynimo_digital_mandate_account_number", "id", childAt2);
                                    if (accountHolderName != null && !accountHolderName.isEmpty()) {
                                        DigitalMandateActivity.this.et_account_holder_name.setText(accountHolderName.trim());
                                        DigitalMandateActivity.this.et_account_holder_name.setKeyListener(null);
                                    }
                                    if (accountNo != null && !accountNo.isEmpty()) {
                                        DigitalMandateActivity.this.dm_et_account_number.setText(accountNo.trim());
                                        DigitalMandateActivity.this.dm_et_account_number.setKeyListener(null);
                                    }
                                    if (accountNo != null && !accountNo.isEmpty()) {
                                        DigitalMandateActivity.this.et_account_number.setText(accountNo.trim());
                                        DigitalMandateActivity.this.et_account_number.setKeyListener(null);
                                    }
                                }
                            } else if (i2 == 2 && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(2))) {
                                if (gVar.geteNACHBank() != null || gVar.geteNACHBankCard() != null) {
                                    View childAt3 = DigitalMandateActivity.this.viewPager.getChildAt(i);
                                    if (childAt3 != null) {
                                        DigitalMandateActivity digitalMandateActivity10 = DigitalMandateActivity.this;
                                        digitalMandateActivity10.et_account_holder_name = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity10.getResources(), "paynimo_et_account_holder_name", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity11 = DigitalMandateActivity.this;
                                        digitalMandateActivity11.et_account_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity11.getResources(), "paynimo_et_account_number", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity12 = DigitalMandateActivity.this;
                                        digitalMandateActivity12.et_ifsc_code = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity12.getResources(), "paynimo_et_ifsc_code", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity13 = DigitalMandateActivity.this;
                                        digitalMandateActivity13.spinner_account_type = (Spinner) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity13.getResources(), "paynimo_spn_account_type", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity14 = DigitalMandateActivity.this;
                                        digitalMandateActivity14.et_phone_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity14.getResources(), "paynimo_et_phone_number", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity15 = DigitalMandateActivity.this;
                                        digitalMandateActivity15.et_mobile_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity15.getResources(), "paynimo_et_mobile_number", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity16 = DigitalMandateActivity.this;
                                        digitalMandateActivity16.et_pan_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity16.getResources(), "paynimo_et_pan_number", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity17 = DigitalMandateActivity.this;
                                        digitalMandateActivity17.et_email_id = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity17.getResources(), "paynimo_et_email_id", "id", childAt3);
                                        DigitalMandateActivity digitalMandateActivity18 = DigitalMandateActivity.this;
                                        digitalMandateActivity18.lyt_rdo_group = (LinearLayout) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity18.getResources(), "paynimo_lyt_enach_rdo_group", "id", childAt3);
                                        String accountType = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountType();
                                        String accountHolderName2 = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountHolderName();
                                        String accountNo2 = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountNo();
                                        String phoneNumber = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getPhoneNumber();
                                        String mobileNumber = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getMobileNumber();
                                        String pan = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getPan();
                                        String emailID = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getEmailID();
                                        if (gVar.geteNACHBankCard() == null || gVar.geteNACHBank() == null) {
                                            DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                        } else {
                                            DigitalMandateActivity.this.lyt_rdo_group.setVisibility(0);
                                        }
                                        if (accountHolderName2 != null && !accountHolderName2.isEmpty()) {
                                            DigitalMandateActivity.this.et_account_holder_name.setText(accountHolderName2.trim());
                                            DigitalMandateActivity.this.et_account_holder_name.setKeyListener(null);
                                        }
                                        if (accountNo2 != null && !accountNo2.isEmpty()) {
                                            DigitalMandateActivity.this.et_account_number.setText(accountNo2.trim());
                                            DigitalMandateActivity.this.et_account_number.setKeyListener(null);
                                        }
                                        if (phoneNumber != null && !phoneNumber.isEmpty()) {
                                            DigitalMandateActivity.this.et_phone_number.setText(phoneNumber);
                                            DigitalMandateActivity.this.et_phone_number.setKeyListener(null);
                                        }
                                        if (mobileNumber != null && !mobileNumber.isEmpty()) {
                                            DigitalMandateActivity.this.et_mobile_number.setText(mobileNumber);
                                            DigitalMandateActivity.this.et_mobile_number.setKeyListener(null);
                                        }
                                        if (pan != null && !pan.isEmpty()) {
                                            DigitalMandateActivity.this.et_pan_number.setText(pan);
                                            DigitalMandateActivity.this.et_pan_number.setKeyListener(null);
                                        }
                                        if (emailID != null && !emailID.isEmpty()) {
                                            DigitalMandateActivity.this.et_email_id.setText(emailID);
                                            DigitalMandateActivity.this.et_email_id.setKeyListener(null);
                                        }
                                        if (accountType != null && !accountType.isEmpty()) {
                                            if (accountType.equalsIgnoreCase("Saving") || accountType.equalsIgnoreCase("Current")) {
                                                if (accountType.equalsIgnoreCase("Saving")) {
                                                    DigitalMandateActivity.this.spinner_account_type.setSelection(1);
                                                }
                                                if (accountType.equalsIgnoreCase("Current")) {
                                                    DigitalMandateActivity.this.spinner_account_type.setSelection(2);
                                                }
                                                DigitalMandateActivity.this.spinner_account_type.setEnabled(false);
                                                DigitalMandateActivity.this.spinner_account_type.setOnItemSelectedListener(null);
                                                return;
                                            }
                                            DigitalMandateActivity.this.transactionError(Constant.TAG_ERROR_ACC_TYPE_VALIDATION_CODE, Constant.TAG_ERROR_ACC_TYPE_VALIDATION);
                                        }
                                    }
                                }
                            }
                        }
                    }, 50);
                    return;
                }
                Constant.showOutputLog(DigitalMandateActivity.TAG, "HashMap does not contain the BANK NAME");
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        TabLayout tabLayout2 = this.tabLayout;
        AnonymousClass3 r1 = new OnTabSelectedListener() {
            public void onTabReselected(Tab tab) {
            }

            public void onTabSelected(Tab tab) {
                Tab tab2 = tab;
                String str = (String) tab2.text;
                if (str != null && str.equalsIgnoreCase(DigitalMandateActivity.EAUTH_MODE)) {
                    tab2.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_aadhar_active", "drawable", DigitalMandateActivity.this.getPackageName()));
                    if (DigitalMandateActivity.this.isSIDataFilled()) {
                        DigitalMandateActivity.this.n_lyt_enach.setVisibility(8);
                    } else {
                        DigitalMandateActivity.this.lyt_enach.setVisibility(8);
                    }
                    if (DigitalMandateActivity.this.eSign.size() > 1) {
                        String str2 = null;
                        for (int i = 1; i < DigitalMandateActivity.this.eSign.size(); i++) {
                            Tab tabAt = DigitalMandateActivity.this.tabLayout.getTabAt(i);
                            if (tabAt != null) {
                                str2 = (String) tabAt.text;
                            }
                            if (str2 != null && str2.equalsIgnoreCase(DigitalMandateActivity.EMANDATE_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(1))) {
                                tabAt.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_bank", "drawable", DigitalMandateActivity.this.getPackageName()));
                            } else if (str2 != null && str2.equalsIgnoreCase(DigitalMandateActivity.ENACH_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(2))) {
                                tabAt.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_enach", "drawable", DigitalMandateActivity.this.getPackageName()));
                            }
                        }
                    }
                    Button access$000 = DigitalMandateActivity.this.btn_pay;
                    DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                    access$000.setText(digitalMandateActivity.getString(digitalMandateActivity.getResources().getIdentifier("paynimo_digital_mandate_authenticate_now", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())));
                    final int selectedTabPosition = DigitalMandateActivity.this.tabLayout.getSelectedTabPosition();
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (DigitalMandateActivity.this.selected_bank_name != null) {
                                g gVar = null;
                                int i = 0;
                                while (true) {
                                    if (i >= DigitalMandateActivity.this.banksData.size()) {
                                        break;
                                    }
                                    g gVar2 = (g) DigitalMandateActivity.this.banksData.values().toArray()[i];
                                    if (gVar2 != null && gVar2.getBankName() != null && gVar2.getBankName().equalsIgnoreCase(DigitalMandateActivity.this.selected_bank_name)) {
                                        gVar = gVar2;
                                        break;
                                    }
                                    i++;
                                }
                                if (gVar != null && selectedTabPosition == 0 && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(0))) {
                                    if (gVar.geteAuthBank() != null || gVar.geteAuthBankBio() != null) {
                                        View childAt = DigitalMandateActivity.this.viewPager.getChildAt(selectedTabPosition);
                                        if (childAt != null) {
                                            DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                            digitalMandateActivity.lyt_rdo_group = (LinearLayout) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity.getResources(), "paynimo_lyt_rdo_group", "id", childAt);
                                            DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                            digitalMandateActivity2.rg_esign_modes = (RadioGroup) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity2.getResources(), "paynimo_rg_esign_modes", "id", childAt);
                                            DigitalMandateActivity digitalMandateActivity3 = DigitalMandateActivity.this;
                                            digitalMandateActivity3.rdo_OTP = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity3.getResources(), "paynimo_rdo_OTP", "id", childAt);
                                            DigitalMandateActivity digitalMandateActivity4 = DigitalMandateActivity.this;
                                            digitalMandateActivity4.rdo_biometric = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity4.getResources(), "paynimo_rdo_biometric", "id", childAt);
                                            DigitalMandateActivity digitalMandateActivity5 = DigitalMandateActivity.this;
                                            digitalMandateActivity5.tv_biometric_note_text = (TextView) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity5.getResources(), "paynimo_biometric_note_text", "id", childAt);
                                            if (gVar.geteAuthBankBio() != null && gVar.geteAuthBankBio().getBankCode() != null) {
                                                if (DigitalMandateActivity.this.lyt_rdo_group != null) {
                                                    DigitalMandateActivity.this.lyt_rdo_group.setVisibility(0);
                                                    DigitalMandateActivity.this.rdo_OTP.setChecked(true);
                                                    DigitalMandateActivity.this.rg_esign_modes.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                                                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                                            if (i == DigitalMandateActivity.this.getResources().getIdentifier("paynimo_rdo_biometric", "id", DigitalMandateActivity.this.getPackageName())) {
                                                                DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(0);
                                                                if (VERSION.SDK_INT >= 24) {
                                                                    TextView access$1800 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                                    DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                                                    access$1800.setText(Html.fromHtml(digitalMandateActivity.getString(digitalMandateActivity.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())), 0));
                                                                    return;
                                                                }
                                                                TextView access$18002 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                                DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                                                access$18002.setText(Html.fromHtml(digitalMandateActivity2.getString(digitalMandateActivity2.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()))));
                                                                return;
                                                            }
                                                            DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                                        }
                                                    });
                                                }
                                                if (DigitalMandateActivity.this.selected_bank_name == null) {
                                                    return;
                                                }
                                                if ((DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBankBio().getBankName()) || (gVar.geteAuthBank() != null && DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBank().getBankName()))) && DigitalMandateActivity.this.lyt_rdo_group != null) {
                                                    DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                                    if (DigitalMandateActivity.this.selected_bank_name.equalsIgnoreCase(gVar.geteAuthBankBio().getBankName())) {
                                                        DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(0);
                                                        if (VERSION.SDK_INT >= 24) {
                                                            TextView access$1800 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                            DigitalMandateActivity digitalMandateActivity6 = DigitalMandateActivity.this;
                                                            access$1800.setText(Html.fromHtml(digitalMandateActivity6.getString(digitalMandateActivity6.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())), 0));
                                                        } else {
                                                            TextView access$18002 = DigitalMandateActivity.this.tv_biometric_note_text;
                                                            DigitalMandateActivity digitalMandateActivity7 = DigitalMandateActivity.this;
                                                            access$18002.setText(Html.fromHtml(digitalMandateActivity7.getString(digitalMandateActivity7.getResources().getIdentifier("paynimo_digital_mandate_biometric_note", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()))));
                                                        }
                                                        DigitalMandateActivity.this.rdo_biometric.setChecked(true);
                                                        return;
                                                    }
                                                    DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                                    DigitalMandateActivity.this.rdo_OTP.setChecked(true);
                                                }
                                            } else if (DigitalMandateActivity.this.lyt_rdo_group != null) {
                                                DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                                DigitalMandateActivity.this.tv_biometric_note_text.setVisibility(8);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }, 50);
                } else if (str != null && str.equalsIgnoreCase(DigitalMandateActivity.EMANDATE_MODE)) {
                    tab2.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_bank_active", "drawable", DigitalMandateActivity.this.getPackageName()));
                    if (DigitalMandateActivity.this.isSIDataFilled()) {
                        DigitalMandateActivity.this.n_lyt_enach.setVisibility(8);
                    } else {
                        DigitalMandateActivity.this.lyt_enach.setVisibility(8);
                    }
                    if (DigitalMandateActivity.this.eSign.size() > 1) {
                        if (DigitalMandateActivity.this.eSign.size() == 2) {
                            if (DigitalMandateActivity.this.eSign.contains(Integer.valueOf(0))) {
                                Tab tabAt2 = DigitalMandateActivity.this.tabLayout.getTabAt(0);
                                if (tabAt2 != null) {
                                    tabAt2.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_aadhar", "drawable", DigitalMandateActivity.this.getPackageName()));
                                }
                            } else if (DigitalMandateActivity.this.eSign.contains(Integer.valueOf(2))) {
                                Tab tabAt3 = DigitalMandateActivity.this.tabLayout.getTabAt(1);
                                if (tabAt3 != null) {
                                    tabAt3.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_enach", "drawable", DigitalMandateActivity.this.getPackageName()));
                                }
                            }
                        }
                        if (DigitalMandateActivity.this.eSign.size() == 3) {
                            Tab tabAt4 = DigitalMandateActivity.this.tabLayout.getTabAt(0);
                            if (tabAt4 != null) {
                                tabAt4.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_aadhar", "drawable", DigitalMandateActivity.this.getPackageName()));
                            }
                            Tab tabAt5 = DigitalMandateActivity.this.tabLayout.getTabAt(2);
                            if (tabAt5 != null) {
                                tabAt5.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_enach", "drawable", DigitalMandateActivity.this.getPackageName()));
                            }
                        }
                    }
                    Typeface createFromAsset = Typeface.createFromAsset(DigitalMandateActivity.this.getAssets(), DigitalMandateActivity.this.getResources().getString(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())));
                    DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                    SpannableString spannableString = new SpannableString(String.format(digitalMandateActivity2.getString(digitalMandateActivity2.getResources().getIdentifier("paynimo_digital_mandate_btn_pay_label", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName()), new Object[]{DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getTransaction().getAmount()}), new Object[0]));
                    spannableString.setSpan(new com.paynimo.android.payment.util.a("", createFromAsset), 4, 5, 33);
                    spannableString.setSpan(new RelativeSizeSpan(0.8f), 4, 5, 33);
                    DigitalMandateActivity.this.btn_pay.setText(spannableString);
                    final int selectedTabPosition2 = DigitalMandateActivity.this.tabLayout.getSelectedTabPosition();
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            g gVar;
                            if (DigitalMandateActivity.this.selected_bank_name != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= DigitalMandateActivity.this.banksData.size()) {
                                        gVar = null;
                                        break;
                                    }
                                    gVar = (g) DigitalMandateActivity.this.banksData.values().toArray()[i];
                                    if (gVar != null && gVar.getBankName() != null && gVar.getBankName().equalsIgnoreCase(DigitalMandateActivity.this.selected_bank_name)) {
                                        break;
                                    }
                                    i++;
                                }
                                if (gVar != null) {
                                    View childAt = DigitalMandateActivity.this.viewPager.getChildAt(selectedTabPosition2);
                                    if (childAt != null) {
                                        String accountHolderName = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountHolderName();
                                        String accountNo = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountNo();
                                        DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                        digitalMandateActivity.et_account_holder_name = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity.getResources(), "paynimo_et_account_holder_name", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                        digitalMandateActivity2.dm_et_account_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity2.getResources(), "paynimo_digital_mandate_account_number", "id", childAt);
                                        if (accountHolderName != null && !accountHolderName.isEmpty()) {
                                            DigitalMandateActivity.this.et_account_holder_name.setText(accountHolderName.trim());
                                            DigitalMandateActivity.this.et_account_holder_name.setKeyListener(null);
                                        }
                                        if (accountNo != null && !accountNo.isEmpty()) {
                                            DigitalMandateActivity.this.dm_et_account_number.setText(accountNo.trim());
                                            DigitalMandateActivity.this.dm_et_account_number.setKeyListener(null);
                                        }
                                    }
                                }
                            }
                        }
                    }, 50);
                } else if (str != null && str.equalsIgnoreCase(DigitalMandateActivity.ENACH_MODE)) {
                    if (DigitalMandateActivity.this.isSIDataFilled()) {
                        DigitalMandateActivity.this.n_lyt_enach.setVisibility(0);
                    } else {
                        DigitalMandateActivity.this.lyt_enach.setVisibility(0);
                    }
                    Button access$0002 = DigitalMandateActivity.this.btn_pay;
                    DigitalMandateActivity digitalMandateActivity3 = DigitalMandateActivity.this;
                    access$0002.setText(digitalMandateActivity3.getString(digitalMandateActivity3.getResources().getIdentifier("paynimo_digital_mandate_register_now", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())));
                    final int selectedTabPosition3 = DigitalMandateActivity.this.tabLayout.getSelectedTabPosition();
                    tab2.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_enach_active", "drawable", DigitalMandateActivity.this.getPackageName()));
                    if (DigitalMandateActivity.this.eSign.size() > 1) {
                        int i2 = 0;
                        String str3 = null;
                        while (i2 < DigitalMandateActivity.this.eSign.size() - 1) {
                            Tab tabAt6 = DigitalMandateActivity.this.tabLayout.getTabAt(i2);
                            String str4 = tabAt6 != null ? (String) tabAt6.text : str3;
                            if (str4 != null && str4.equalsIgnoreCase(DigitalMandateActivity.EMANDATE_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(1))) {
                                tabAt6.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_bank", "drawable", DigitalMandateActivity.this.getPackageName()));
                            } else if (str4 != null && str4.equalsIgnoreCase(DigitalMandateActivity.EAUTH_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(0))) {
                                tabAt6.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_aadhar", "drawable", DigitalMandateActivity.this.getPackageName()));
                            }
                            i2++;
                            str3 = str4;
                        }
                    }
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            g gVar;
                            if (DigitalMandateActivity.this.selected_bank_name != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= DigitalMandateActivity.this.banksData.size()) {
                                        gVar = null;
                                        break;
                                    }
                                    gVar = (g) DigitalMandateActivity.this.banksData.values().toArray()[i];
                                    if (gVar != null && gVar.getBankName() != null && gVar.getBankName().equalsIgnoreCase(DigitalMandateActivity.this.selected_bank_name)) {
                                        break;
                                    }
                                    i++;
                                }
                                if (gVar == null) {
                                    return;
                                }
                                if (gVar.geteNACHBank() != null || gVar.geteNACHBankCard() != null) {
                                    View childAt = DigitalMandateActivity.this.viewPager.getChildAt(selectedTabPosition3);
                                    String accountType = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountType();
                                    String accountHolderName = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountHolderName();
                                    String accountNo = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getAccountNo();
                                    DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getPayment().getInstrument().getiFSC();
                                    String phoneNumber = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getPhoneNumber();
                                    String mobileNumber = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getMobileNumber();
                                    String pan = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getPan();
                                    String emailID = DigitalMandateActivity.this.checkout.getMerchantRequestPayload().getConsumer().getEmailID();
                                    if (childAt != null) {
                                        DigitalMandateActivity digitalMandateActivity = DigitalMandateActivity.this;
                                        digitalMandateActivity.et_account_holder_name = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity.getResources(), "paynimo_et_account_holder_name", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity2 = DigitalMandateActivity.this;
                                        digitalMandateActivity2.et_account_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity2.getResources(), "paynimo_et_account_number", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity3 = DigitalMandateActivity.this;
                                        digitalMandateActivity3.et_ifsc_code = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity3.getResources(), "paynimo_et_ifsc_code", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity4 = DigitalMandateActivity.this;
                                        digitalMandateActivity4.spinner_account_type = (Spinner) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity4.getResources(), "paynimo_spn_account_type", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity5 = DigitalMandateActivity.this;
                                        digitalMandateActivity5.et_phone_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity5.getResources(), "paynimo_et_phone_number", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity6 = DigitalMandateActivity.this;
                                        digitalMandateActivity6.et_mobile_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity6.getResources(), "paynimo_et_mobile_number", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity7 = DigitalMandateActivity.this;
                                        digitalMandateActivity7.et_pan_number = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity7.getResources(), "paynimo_et_pan_number", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity8 = DigitalMandateActivity.this;
                                        digitalMandateActivity8.et_email_id = (EditText) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity8.getResources(), "paynimo_et_email_id", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity9 = DigitalMandateActivity.this;
                                        digitalMandateActivity9.lyt_rdo_group = (LinearLayout) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity9.getResources(), "paynimo_lyt_enach_rdo_group", "id", childAt);
                                        if (accountHolderName != null && !accountHolderName.isEmpty()) {
                                            DigitalMandateActivity.this.et_account_holder_name.setText(accountHolderName.trim());
                                            DigitalMandateActivity.this.et_account_holder_name.setKeyListener(null);
                                        }
                                        if (accountNo != null && !accountNo.isEmpty()) {
                                            DigitalMandateActivity.this.et_account_number.setText(accountNo.trim());
                                            DigitalMandateActivity.this.et_account_number.setKeyListener(null);
                                        }
                                        if (phoneNumber != null && !phoneNumber.isEmpty()) {
                                            DigitalMandateActivity.this.et_phone_number.setText(phoneNumber);
                                            DigitalMandateActivity.this.et_phone_number.setKeyListener(null);
                                        }
                                        if (mobileNumber != null && !mobileNumber.isEmpty()) {
                                            DigitalMandateActivity.this.et_mobile_number.setText(mobileNumber);
                                            DigitalMandateActivity.this.et_mobile_number.setKeyListener(null);
                                        }
                                        if (pan != null && !pan.isEmpty()) {
                                            DigitalMandateActivity.this.et_pan_number.setText(pan);
                                            DigitalMandateActivity.this.et_pan_number.setKeyListener(null);
                                        }
                                        if (emailID != null && !emailID.isEmpty()) {
                                            DigitalMandateActivity.this.et_email_id.setText(emailID);
                                            DigitalMandateActivity.this.et_email_id.setKeyListener(null);
                                        }
                                        if (accountType != null && !accountType.isEmpty()) {
                                            if (accountType.equalsIgnoreCase("Saving") || accountType.equalsIgnoreCase("Current")) {
                                                if (accountType.equalsIgnoreCase("Saving")) {
                                                    DigitalMandateActivity.this.spinner_account_type.setSelection(1);
                                                }
                                                if (accountType.equalsIgnoreCase("Current")) {
                                                    DigitalMandateActivity.this.spinner_account_type.setSelection(2);
                                                }
                                                DigitalMandateActivity.this.spinner_account_type.setEnabled(false);
                                                DigitalMandateActivity.this.spinner_account_type.setOnItemSelectedListener(null);
                                            } else {
                                                DigitalMandateActivity.this.transactionError(Constant.TAG_ERROR_ACC_TYPE_VALIDATION_CODE, Constant.TAG_ERROR_ACC_TYPE_VALIDATION);
                                            }
                                        }
                                        DigitalMandateActivity digitalMandateActivity10 = DigitalMandateActivity.this;
                                        digitalMandateActivity10.lyt_rdo_group = (LinearLayout) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity10.getResources(), "paynimo_rg_enach_modes", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity11 = DigitalMandateActivity.this;
                                        digitalMandateActivity11.rdo_netbanking = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity11.getResources(), "paynimo_rdo_netbanking", "id", childAt);
                                        DigitalMandateActivity digitalMandateActivity12 = DigitalMandateActivity.this;
                                        digitalMandateActivity12.rdo_debit_card = (RadioButton) GeneratedOutlineSupport.outline18(DigitalMandateActivity.this, digitalMandateActivity12.getResources(), "paynimo_rdo_debit_card", "id", childAt);
                                        Button access$000 = DigitalMandateActivity.this.btn_pay;
                                        DigitalMandateActivity digitalMandateActivity13 = DigitalMandateActivity.this;
                                        access$000.setText(digitalMandateActivity13.getString(digitalMandateActivity13.getResources().getIdentifier("paynimo_digital_mandate_register_now", NetworkingModule.REQUEST_BODY_KEY_STRING, DigitalMandateActivity.this.getPackageName())));
                                        if (gVar.geteNACHBankCard() != null && gVar.geteNACHBank() != null) {
                                            DigitalMandateActivity.this.rdo_netbanking.setChecked(true);
                                            DigitalMandateActivity.this.lyt_rdo_group.setVisibility(0);
                                        } else if (gVar.geteNACHBank() != null) {
                                            DigitalMandateActivity.this.rdo_netbanking.setChecked(true);
                                        } else if (gVar.geteNACHBankCard() != null) {
                                            DigitalMandateActivity.this.rdo_debit_card.setChecked(true);
                                        } else {
                                            DigitalMandateActivity.this.lyt_rdo_group.setVisibility(8);
                                        }
                                    }
                                }
                            }
                        }
                    }, 50);
                }
            }

            public void onTabUnselected(Tab tab) {
                String str = tab != null ? (String) tab.text : null;
                if (str != null && str.equalsIgnoreCase(DigitalMandateActivity.EMANDATE_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(1))) {
                    tab.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_bank", "drawable", DigitalMandateActivity.this.getPackageName()));
                } else if (str != null && str.equalsIgnoreCase(DigitalMandateActivity.EAUTH_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(0))) {
                    tab.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_aadhar", "drawable", DigitalMandateActivity.this.getPackageName()));
                } else if (str != null && str.equalsIgnoreCase(DigitalMandateActivity.ENACH_MODE) && DigitalMandateActivity.this.eSign.contains(Integer.valueOf(2))) {
                    tab.setIcon(DigitalMandateActivity.this.getResources().getIdentifier("paynimo_enach", "drawable", DigitalMandateActivity.this.getPackageName()));
                }
            }
        };
        if (!tabLayout2.selectedListeners.contains(r1)) {
            tabLayout2.selectedListeners.add(r1);
        }
        this.btn_pay.setOnClickListener(this);
    }

    private void showBackPressedDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_text", "id", getApplicationContext().getPackageName()))).setText(getResources().getString(getResources().getIdentifier("paynimo_back_press_dialog_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonOK", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:Back", 0, "PASS", DigitalMandateActivity.this.checkout, "", "", "", "", DigitalMandateActivity.this.mServiceManager, DigitalMandateActivity.this);
                DigitalMandateActivity.this.transactionCancelled();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showBinCheckError() {
        this.et_cardNumber.setTextColor(ContextCompat.getColor(this, getResources().getIdentifier("errorTextColor", "color", getPackageName())));
        Toast.makeText(this, getString(getResources().getIdentifier("paynimo_cc_card_bin_check_error_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())), 0).show();
        this.et_cardNumber.setError(getString(getResources().getIdentifier("paynimo_cc_card_bin_check_error_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())));
        this.et_cardNumber.requestFocus();
    }

    private void showProgressLoader() {
        findViewById(getResources().getIdentifier("paynimo_header", "id", getPackageName())).setVisibility(8);
        findViewById(getResources().getIdentifier("paynimo_scroll_main", "id", getPackageName())).setVisibility(8);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(0);
        this.webView.loadUrl("file:///android_asset/paynimo_loader_gif.gif");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void start3DSecureNetworkTask() {
        /*
            r6 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            r2 = -2
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r6)     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x0037
            com.paynimo.android.payment.model.request.RequestPayload r3 = r6.request_payload     // Catch:{ Exception -> 0x0033 }
            if (r3 == 0) goto L_0x0048
            com.paynimo.android.payment.model.request.s r4 = r3.getTransaction()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = "TWD"
            r4.setRequestType(r5)     // Catch:{ Exception -> 0x0033 }
            com.paynimo.android.payment.model.request.s r4 = r3.getTransaction()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = "Y"
            r4.setForced3DSCall(r5)     // Catch:{ Exception -> 0x0033 }
            com.paynimo.android.payment.model.request.s r4 = r3.getTransaction()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = "N"
            r4.setSmsSending(r5)     // Catch:{ Exception -> 0x0033 }
            r6.showProgressLoader()     // Catch:{ Exception -> 0x0033 }
            com.paynimo.android.payment.b.d r4 = r6.mServiceManager     // Catch:{ Exception -> 0x0033 }
            r4.callTWDRequest(r3, r6)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0048
        L_0x0033:
            r6.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0048
        L_0x0037:
            de.greenrobot.event.EventBus r3 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0045 }
            com.paynimo.android.payment.event.g r4 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0045 }
            r5 = 0
            r4.<init>(r5)     // Catch:{ Exception -> 0x0045 }
            r3.post(r4)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0048
        L_0x0045:
            r6.showAlertDialog(r2, r1, r0)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.start3DSecureNetworkTask():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|6|7|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0053 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startBinCheckTask(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r4 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            r2 = -2
            r3 = 0
            r4.issuer = r3     // Catch:{ Exception -> 0x0065 }
            r4.inputCardType = r3     // Catch:{ Exception -> 0x0065 }
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r4)     // Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x0057
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x0053 }
            r3.<init>()     // Catch:{ Exception -> 0x0053 }
            r4.startTime = r3     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.model.request.c r3 = new com.paynimo.android.payment.model.request.c     // Catch:{ Exception -> 0x0053 }
            r3.<init>()     // Catch:{ Exception -> 0x0053 }
            r3.setBin(r5)     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.model.Checkout r5 = r4.checkout     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.model.request.RequestPayload r5 = r5.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.model.request.o r5 = r5.getMerchant()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = r5.getIdentifier()     // Catch:{ Exception -> 0x0053 }
            r3.setSubmer_code(r5)     // Catch:{ Exception -> 0x0053 }
            r3.setBank_code(r6)     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.model.Checkout r5 = r4.checkout     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.model.request.RequestPayload r5 = r5.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.model.request.s r5 = r5.getTransaction()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = r5.getIdentifier()     // Catch:{ Exception -> 0x0053 }
            r3.setSrc_prn(r5)     // Catch:{ Exception -> 0x0053 }
            r3.setPayment_instrument_token(r7)     // Catch:{ Exception -> 0x0053 }
            r3.setTransaction_isRegistration(r8)     // Catch:{ Exception -> 0x0053 }
            r3.setPayment_instruction_action(r9)     // Catch:{ Exception -> 0x0053 }
            com.paynimo.android.payment.b.d r5 = r4.mServiceManager     // Catch:{ Exception -> 0x0053 }
            r5.callBinCheckAPI(r3, r4)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0068
        L_0x0053:
            r4.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x0065 }
            goto L_0x0068
        L_0x0057:
            de.greenrobot.event.EventBus r5 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0065 }
            com.paynimo.android.payment.event.g r6 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0065 }
            r7 = 0
            r6.<init>(r7)     // Catch:{ Exception -> 0x0065 }
            r5.post(r6)     // Catch:{ Exception -> 0x0065 }
            goto L_0x0068
        L_0x0065:
            r4.showAlertDialog(r2, r1, r0)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.startBinCheckTask(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0072 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startCardNetworkTask(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            r2 = -2
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r5)     // Catch:{ Exception -> 0x0084 }
            if (r3 == 0) goto L_0x0076
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            if (r3 == 0) goto L_0x0087
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x0072 }
            r3.<init>()     // Catch:{ Exception -> 0x0072 }
            r5.startTime = r3     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "TWD"
            r3.setTransactionRequestType(r4)     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "C"
            r3.setPaymentMethodType(r4)     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            r3.setPaymentMethodToken(r6)     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.request.s r6 = r6.getTransaction()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r6 = r6.getType()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = "PREAUTH"
            boolean r6 = r6.equals(r3)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = "Y"
            java.lang.String r4 = "N"
            if (r6 == 0) goto L_0x004d
            com.paynimo.android.payment.model.Checkout r6 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            r6.setTransactionForced3DSCall(r3)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0052
        L_0x004d:
            com.paynimo.android.payment.model.Checkout r6 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            r6.setTransactionForced3DSCall(r4)     // Catch:{ Exception -> 0x0072 }
        L_0x0052:
            boolean r6 = r5.isSimExists()     // Catch:{ Exception -> 0x0072 }
            if (r6 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r3 = r4
        L_0x005a:
            com.paynimo.android.payment.model.Checkout r6 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            r6.setTransactionSmsSending(r3)     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.Checkout r6 = r5.checkout     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0072 }
            r5.request_payload = r6     // Catch:{ Exception -> 0x0072 }
            r5.showProgressLoader()     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.b.d r6 = r5.mServiceManager     // Catch:{ Exception -> 0x0072 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r5.request_payload     // Catch:{ Exception -> 0x0072 }
            r6.callTWDRequest(r3, r5)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0087
        L_0x0072:
            r5.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x0084 }
            goto L_0x0087
        L_0x0076:
            de.greenrobot.event.EventBus r6 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x0084 }
            com.paynimo.android.payment.event.g r3 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x0084 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ Exception -> 0x0084 }
            r6.post(r3)     // Catch:{ Exception -> 0x0084 }
            goto L_0x0087
        L_0x0084:
            r5.showAlertDialog(r2, r1, r0)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.startCardNetworkTask(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void transactionCancelled() {
        setResult(0, new Intent());
        finish();
    }

    private Boolean validateBankCode(String str) {
        return Boolean.valueOf(!str.equalsIgnoreCase(""));
    }

    public int getAadharMarkerPosition(int i, boolean z, int i2) {
        if (i % i2 == 0) {
            if (z) {
                return i;
            }
            i++;
        }
        return i;
    }

    public int getCCardMarkerPosition(int i, boolean z, CardType cardType2) {
        if (cardType2.getMarkersPositions().contains(Integer.valueOf(i))) {
            if (z) {
                return i;
            }
            i++;
        }
        return i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|6|7|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getIFSCDetails(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            r2 = -2
            boolean r3 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r6)     // Catch:{ Exception -> 0x005c }
            if (r3 == 0) goto L_0x004e
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            r6.startTime = r3     // Catch:{ Exception -> 0x004a }
            com.paynimo.android.payment.model.request.i r3 = new com.paynimo.android.payment.model.request.i     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            com.paynimo.android.payment.model.request.j r4 = new com.paynimo.android.payment.model.request.j     // Catch:{ Exception -> 0x004a }
            r4.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = "009"
            r4.setType(r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = "001"
            r4.setSubType(r5)     // Catch:{ Exception -> 0x004a }
            com.paynimo.android.payment.model.request.g r5 = new com.paynimo.android.payment.model.request.g     // Catch:{ Exception -> 0x004a }
            r5.<init>()     // Catch:{ Exception -> 0x004a }
            r5.setiFSC(r7)     // Catch:{ Exception -> 0x004a }
            com.paynimo.android.payment.model.request.r r7 = new com.paynimo.android.payment.model.request.r     // Catch:{ Exception -> 0x004a }
            r7.<init>()     // Catch:{ Exception -> 0x004a }
            r7.setInstrument(r5)     // Catch:{ Exception -> 0x004a }
            com.paynimo.android.payment.model.request.h r5 = new com.paynimo.android.payment.model.request.h     // Catch:{ Exception -> 0x004a }
            r5.<init>()     // Catch:{ Exception -> 0x004a }
            r5.setSender(r7)     // Catch:{ Exception -> 0x004a }
            r4.setPayment(r5)     // Catch:{ Exception -> 0x004a }
            r3.setTransaction(r4)     // Catch:{ Exception -> 0x004a }
            com.paynimo.android.payment.b.d r7 = r6.mServiceManager     // Catch:{ Exception -> 0x004a }
            r7.callIFSCRequest(r3, r6)     // Catch:{ Exception -> 0x004a }
            goto L_0x005f
        L_0x004a:
            r6.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x005c }
            goto L_0x005f
        L_0x004e:
            de.greenrobot.event.EventBus r7 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x005c }
            com.paynimo.android.payment.event.g r3 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x005c }
            r4 = 0
            r3.<init>(r4)     // Catch:{ Exception -> 0x005c }
            r7.post(r3)     // Catch:{ Exception -> 0x005c }
            goto L_0x005f
        L_0x005c:
            r6.showAlertDialog(r2, r1, r0)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.getIFSCDetails(java.lang.String):void");
    }

    public long getMilliFromDate(String str) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(str);
        } catch (ParseException unused) {
        }
        PrintStream printStream = System.out;
        printStream.println("Today is " + date);
        return date.getTime();
    }

    public File getPrivateAlbumStorageDir(Context context, String str) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DCIM), str);
        boolean mkdirs = file.mkdirs();
        return file;
    }

    public boolean isSimExists() {
        return ((TelephonyManager) getSystemService("phone")).getSimState() == 5;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            Constant.showOutputLog(TAG, "======>>>>>>>Tar Request");
            if (i2 == -1) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("msg");
                    String stringExtra2 = intent.getStringExtra("tpsl_mrct_cd");
                    if (stringExtra != null && stringExtra2 != null) {
                        callTarRequest(stringExtra, stringExtra2);
                    }
                }
            } else if (i2 == -2) {
                transactionError(intent.getStringExtra(PaymentActivity.RETURN_ERROR_CODE), intent.getStringExtra("error_description"));
            } else if (i2 == 0) {
                transactionCancelled();
            } else if (i2 == -3) {
                finishActivityForChangeInPaymentMode();
            }
        } else if (i == 100 && i2 == -1) {
            String stringExtra3 = intent.getStringExtra("signedResponse");
            if (stringExtra3 != null) {
                String str = this.bankAcsBiometricUrl;
                if (str == null || str.equalsIgnoreCase("")) {
                    showAlertDialog(-2, Constant.TAG_ERROR_INVALID_URL_CODE, Constant.TAG_ERROR_INVALID_URL);
                    return;
                }
                Intent intent2 = new Intent(this, WebViewActivity.class);
                intent2.putExtra("BankCode", "");
                intent2.putExtra("web_url", this.bankAcsBiometricUrl);
                intent2.putExtra("req_load_type", Constant.WEBVIEW_TYPE_POSTURL);
                StringBuilder sb = new StringBuilder();
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("msg=");
                outline73.append(URLEncoder.encode(stringExtra3));
                sb.append(outline73.toString());
                intent2.putExtra("req_load_type_param", sb.toString());
                intent2.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.checkout);
                startActivityForResult(intent2, 2);
            }
        }
    }

    public void onBackPressed() {
        showBackPressedDialog();
    }

    public void onClick(View view) {
        if (view.getId() == getResources().getIdentifier("paynimo_dm_ib_start_date", "id", getPackageName())) {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            String obj = this.et_debit_start_date.getText().toString();
            if (obj != null && !obj.isEmpty()) {
                String[] split = obj.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.year = Integer.parseInt(split[2]);
                this.month = Integer.parseInt(split[1]);
                this.day = Integer.parseInt(split[0]);
            }
            Bundle bundle = new Bundle();
            bundle.putInt(AnonymousClass27.YEAR, this.year);
            bundle.putInt(AnonymousClass27.MONTH, this.month - 1);
            bundle.putInt("day", this.day);
            datePickerFragment.setArguments(bundle);
            datePickerFragment.setCallBack(this.startDatePickerListener);
            datePickerFragment.show(getSupportFragmentManager(), (String) "Date Picker");
        } else if (view.getId() == getResources().getIdentifier("paynimo_dm_ib_end_date", "id", getPackageName())) {
            DatePickerFragment datePickerFragment2 = new DatePickerFragment();
            String obj2 = this.et_debit_end_date.getText().toString();
            if (obj2 != null && !obj2.isEmpty()) {
                String[] split2 = obj2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.year = Integer.parseInt(split2[2]);
                this.month = Integer.parseInt(split2[1]);
                this.day = Integer.parseInt(split2[0]);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AnonymousClass27.YEAR, this.year);
            bundle2.putInt(AnonymousClass27.MONTH, this.month - 1);
            bundle2.putInt("day", this.day);
            datePickerFragment2.setArguments(bundle2);
            datePickerFragment2.setCallBack(this.endDatePickerListener);
            datePickerFragment2.show(getSupportFragmentManager(), (String) "Date Picker");
        } else if (view.getId() == getResources().getIdentifier("paynimo_btn_pay", "id", getPackageName())) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.btn_pay.getWindowToken(), 0);
            if (this.rg_mode.getCheckedRadioButtonId() == getResources().getIdentifier("paynimo_rdo_account", "id", getPackageName())) {
                if (!checkIfEMandateDataIsFilled() || !checkIfAccountDataIsFilled()) {
                    Toast.makeText(this, "Kindly enter valid data in all mandatory fields.", 0).show();
                } else {
                    networkCallWithBankCode(this.tabLayout.getSelectedTabPosition());
                }
            } else if (this.rg_mode.getCheckedRadioButtonId() != getResources().getIdentifier("paynimo_rdo_card", "id", getPackageName())) {
            } else {
                if (!checkIfEMandateDataIsFilled() || !this.isCardBinValid) {
                    Toast.makeText(this, "Kindly enter valid data in all mandatory fields.", 0).show();
                } else {
                    checkIfCardDataIsFilledAndProceed();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0125 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x021c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onCreate(r12)
            android.content.res.Resources r0 = r11.getResources()
            java.lang.String r1 = r11.getPackageName()
            java.lang.String r2 = "paynimo_activity_digital_mandate"
            java.lang.String r3 = "layout"
            int r0 = r0.getIdentifier(r2, r3, r1)
            r11.setContentView(r0)
            android.content.Context r0 = r11.getApplicationContext()
            myContext = r0
            android.content.Intent r0 = r11.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            android.content.Intent r1 = r11.getIntent()
            android.content.Context r2 = com.paynimo.android.payment.CardTypeParser.getContext()
            if (r2 != 0) goto L_0x0034
            android.content.Context r2 = r11.getApplicationContext()
            application_context = r2
        L_0x0034:
            if (r1 == 0) goto L_0x005a
            java.lang.String r2 = "checkoutData"
            java.io.Serializable r3 = r1.getSerializableExtra(r2)
            com.paynimo.android.payment.model.Checkout r3 = (com.paynimo.android.payment.model.Checkout) r3
            r11.checkout = r3
            java.io.Serializable r2 = r1.getSerializableExtra(r2)
            com.paynimo.android.payment.model.Checkout r2 = (com.paynimo.android.payment.model.Checkout) r2
            r11.savedCheckout = r2
            java.lang.String r2 = "pmiResponseData"
            java.io.Serializable r2 = r1.getSerializableExtra(r2)
            com.paynimo.android.payment.model.response.k.r r2 = (com.paynimo.android.payment.model.response.k.r) r2
            r11.pmiData = r2
            java.lang.String r2 = "paynimo.payment.requestedPaymentMode"
            java.lang.String r1 = r1.getStringExtra(r2)
            r11.requestedPaymentMethod = r1
        L_0x005a:
            com.paynimo.android.payment.b.a r1 = new com.paynimo.android.payment.b.a
            r1.<init>()
            r11.mService = r1
            com.paynimo.android.payment.b.d r2 = new com.paynimo.android.payment.b.d
            r2.<init>(r1)
            r11.mServiceManager = r2
            r11.initialiseViews()
            r11.setListeners()
            com.paynimo.android.payment.model.Checkout r1 = r11.checkout
            com.paynimo.android.payment.model.request.RequestPayload r1 = r1.getMerchantRequestPayload()
            com.paynimo.android.payment.model.request.q r1 = r1.getPayment()
            com.paynimo.android.payment.model.request.k r1 = r1.getInstruction()
            java.lang.String r2 = r1.getAction()
            java.lang.String r3 = "Y"
            boolean r2 = r2.equalsIgnoreCase(r3)
            java.lang.String r4 = "Netbanking"
            r5 = 1
            r6 = 8
            if (r2 == 0) goto L_0x009f
            java.lang.String r2 = r11.requestedPaymentMethod
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L_0x009f
            android.widget.RadioButton r2 = r11.rdo_account
            r2.setChecked(r5)
            android.widget.RadioButton r2 = r11.rdo_card
            r2.setVisibility(r6)
        L_0x009f:
            com.paynimo.android.payment.model.Checkout r2 = r11.checkout
            com.paynimo.android.payment.model.request.RequestPayload r2 = r2.getMerchantRequestPayload()
            com.paynimo.android.payment.model.request.s r2 = r2.getTransaction()
            java.lang.String r2 = r2.getMerchantInitiated()
            boolean r2 = r2.equalsIgnoreCase(r3)
            java.lang.String r7 = "string"
            if (r2 == 0) goto L_0x00ec
            java.lang.String r2 = r11.requestedPaymentMethod
            boolean r2 = r11.isMerchantSpecificDataValid(r2)
            if (r2 == 0) goto L_0x00ec
            java.lang.String r2 = r1.getAction()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00ec
            java.lang.String r2 = r11.requestedPaymentMethod
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L_0x00ec
            android.widget.TextView r2 = r11.tv_select_bank
            android.content.res.Resources r4 = r11.getResources()
            java.lang.String r8 = r11.getPackageName()
            java.lang.String r9 = "paynimo_digital_mandate_selected_bank"
            int r4 = r4.getIdentifier(r9, r7, r8)
            r2.setText(r4)
            android.widget.RadioGroup r2 = r11.rg_mode
            r2.setVisibility(r6)
            android.widget.TextView r2 = r11.tv_register_mandate
            r2.setVisibility(r6)
        L_0x00ec:
            r11.loadSettings(r0)
            if (r12 == 0) goto L_0x00f4
            r11.retrieveSavedInstanceData(r12)
        L_0x00f4:
            boolean r12 = r11.isSIDataFilled()
            r0 = 0
            r2 = 0
            if (r12 == 0) goto L_0x0271
            android.widget.LinearLayout r12 = r11.si_non_edit_container
            r12.setVisibility(r2)
            java.lang.String r12 = r1.getStartDateTime()
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "dd-MM-yyyy"
            r4.<init>(r5)
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            java.util.Date r5 = r5.getTime()
            java.util.Date r12 = r4.parse(r12)     // Catch:{ ParseException -> 0x0121 }
            java.lang.String r5 = r4.format(r5)     // Catch:{ ParseException -> 0x0122 }
            java.util.Date r5 = r4.parse(r5)     // Catch:{ ParseException -> 0x0122 }
            goto L_0x0123
        L_0x0121:
            r12 = r0
        L_0x0122:
            r5 = r0
        L_0x0123:
            if (r12 == 0) goto L_0x0135
            if (r5 == 0) goto L_0x0135
            boolean r12 = r12.before(r5)
            if (r12 == 0) goto L_0x0135
            java.lang.String r12 = "ERROR_PAYNIMO_024"
            java.lang.String r0 = "Enter valid Start Date"
            r11.transactionError(r12, r0)
            return
        L_0x0135:
            android.widget.TextView r12 = r11.n_tv_debit_start_date
            java.lang.String r8 = r1.getStartDateTime()
            r12.setText(r8)
            java.lang.String r12 = r1.getEndDateTime()
            java.util.Date r0 = r4.parse(r12)     // Catch:{ ParseException -> 0x0147 }
            goto L_0x0148
        L_0x0147:
        L_0x0148:
            if (r0 == 0) goto L_0x015a
            if (r5 == 0) goto L_0x015a
            boolean r12 = r0.before(r5)
            if (r12 == 0) goto L_0x015a
            java.lang.String r12 = "ERROR_PAYNIMO_025"
            java.lang.String r0 = "Enter valid End Date"
            r11.transactionError(r12, r0)
            return
        L_0x015a:
            android.widget.TextView r12 = r11.n_tv_debit_end_date
            java.lang.String r0 = r1.getEndDateTime()
            r12.setText(r0)
            android.widget.TextView r12 = r11.n_tv_amount_debit
            java.lang.String r0 = r1.getLimit()
            r12.setText(r0)
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getUtilityNo()
            if (r12 == 0) goto L_0x018f
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getUtilityNo()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x018f
            android.widget.TextView r12 = r11.n_tv_utility_no
            com.paynimo.android.payment.model.response.k.r r0 = r11.pmiData
            java.lang.String r0 = r0.getUtilityNo()
            java.lang.String r0 = r0.trim()
            r12.setText(r0)
        L_0x018f:
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getMandatePurpose()
            if (r12 == 0) goto L_0x01b2
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getMandatePurpose()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x01b2
            android.widget.TextView r12 = r11.n_tv_mandate_purpose
            com.paynimo.android.payment.model.response.k.r r0 = r11.pmiData
            java.lang.String r0 = r0.getMandatePurpose()
            java.lang.String r0 = r0.trim()
            r12.setText(r0)
        L_0x01b2:
            java.lang.String r12 = r1.getType()
            java.lang.String r0 = "paynimo_emptyMSG"
            if (r12 == 0) goto L_0x01d0
            int r4 = r12.length()
            if (r4 <= 0) goto L_0x01d0
            java.util.Map<java.lang.String, java.lang.String> r4 = r11.mapInstrumentAmountType     // Catch:{ Exception -> 0x01ce }
            java.lang.Object r12 = com.paynimo.android.payment.util.d.getKeyFromValue(r4, r12)     // Catch:{ Exception -> 0x01ce }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01ce }
            android.widget.TextView r4 = r11.n_tv_amountType     // Catch:{ Exception -> 0x01ce }
            r4.setText(r12)     // Catch:{ Exception -> 0x01ce }
            goto L_0x01e5
        L_0x01ce:
            goto L_0x01e5
        L_0x01d0:
            android.widget.TextView r12 = r11.n_tv_amountType
            android.content.res.Resources r4 = r11.getResources()
            java.lang.String r5 = r11.getPackageName()
            int r4 = r4.getIdentifier(r0, r7, r5)
            java.lang.String r4 = r11.getString(r4)
            r12.setError(r4)
        L_0x01e5:
            java.lang.String r12 = r1.getFrequency()
            if (r12 == 0) goto L_0x0201
            int r4 = r12.length()
            if (r4 <= 0) goto L_0x0201
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.mapInstrumentFrequency     // Catch:{ Exception -> 0x01ff }
            java.lang.Object r12 = com.paynimo.android.payment.util.d.getKeyFromValue(r0, r12)     // Catch:{ Exception -> 0x01ff }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01ff }
            android.widget.TextView r0 = r11.n_tv_frequency     // Catch:{ Exception -> 0x01ff }
            r0.setText(r12)     // Catch:{ Exception -> 0x01ff }
            goto L_0x0216
        L_0x01ff:
            goto L_0x0216
        L_0x0201:
            android.widget.TextView r12 = r11.n_tv_frequency
            android.content.res.Resources r4 = r11.getResources()
            java.lang.String r5 = r11.getPackageName()
            int r0 = r4.getIdentifier(r0, r7, r5)
            java.lang.String r0 = r11.getString(r0)
            r12.setError(r0)
        L_0x0216:
            java.lang.String r12 = r1.getDebitFlag()
            if (r12 == 0) goto L_0x0260
            java.lang.String r12 = r1.getDebitFlag()
            boolean r12 = r12.equalsIgnoreCase(r3)
            if (r12 == 0) goto L_0x0260
            android.view.View r12 = r11.view_divider
            r12.setVisibility(r2)
            android.widget.LinearLayout r12 = r11.n_lyt_debit_day
            r12.setVisibility(r2)
            java.lang.String r12 = r1.getDebitDay()
            if (r12 == 0) goto L_0x026a
            boolean r0 = r12.isEmpty()
            if (r0 != 0) goto L_0x026a
            r0 = 0
        L_0x023d:
            java.util.List<java.lang.String> r1 = r11.debitDaysList
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x026a
            java.util.List<java.lang.String> r1 = r11.debitDaysList
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r12.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x025d
            android.widget.Spinner r1 = r11.n_spinner_debitDay
            r1.setSelection(r0)
            android.widget.Spinner r1 = r11.n_spinner_debitDay
            r1.setEnabled(r2)
        L_0x025d:
            int r0 = r0 + 1
            goto L_0x023d
        L_0x0260:
            android.view.View r12 = r11.view_divider
            r12.setVisibility(r6)
            android.widget.LinearLayout r12 = r11.n_lyt_debit_day
            r12.setVisibility(r6)
        L_0x026a:
            android.widget.LinearLayout r12 = r11.si_container
            r12.setVisibility(r6)
            goto L_0x03eb
        L_0x0271:
            android.widget.LinearLayout r12 = r11.si_non_edit_container
            r12.setVisibility(r6)
            android.widget.LinearLayout r12 = r11.si_container
            r12.setVisibility(r2)
            java.util.Calendar r12 = java.util.Calendar.getInstance()
            r11.cal = r12
            r4 = 5
            int r12 = r12.get(r4)
            r11.day = r12
            java.util.Calendar r12 = r11.cal
            r4 = 2
            int r12 = r12.get(r4)
            r11.month = r12
            java.util.Calendar r12 = r11.cal
            int r12 = r12.get(r5)
            r11.year = r12
            int r12 = r11.month
            int r12 = r12 + r5
            java.lang.String r4 = ""
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            int r7 = r11.day
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r4, r12)
            java.lang.String r8 = "0"
            r9 = 10
            if (r12 <= 0) goto L_0x02bb
            if (r12 >= r9) goto L_0x02bb
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r8, r12)
        L_0x02bb:
            int r12 = r11.day
            if (r12 <= 0) goto L_0x02ce
            if (r12 >= r9) goto L_0x02ce
            java.lang.StringBuilder r12 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            int r5 = r11.day
            r12.append(r5)
            java.lang.String r5 = r12.toString()
        L_0x02ce:
            android.widget.EditText r12 = r11.et_debit_start_date
            java.lang.String r8 = "-"
            java.lang.StringBuilder r9 = com.android.tools.r8.GeneratedOutlineSupport.outline81(r5, r8, r7, r8)
            int r10 = r11.year
            r9.append(r10)
            r9.append(r4)
            r12.setText(r9)
            android.widget.EditText r12 = r11.et_debit_start_date
            android.text.Editable r9 = r12.getText()
            java.lang.String r9 = r9.toString()
            int r9 = r9.length()
            r12.setSelection(r9)
            android.widget.EditText r12 = r11.et_debit_start_date
            r12.setKeyListener(r0)
            android.widget.EditText r12 = r11.et_debit_end_date
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline81(r5, r8, r7, r8)
            int r7 = r11.year
            int r7 = r7 + 20
            r5.append(r7)
            r5.append(r4)
            r12.setText(r5)
            android.widget.EditText r12 = r11.et_debit_end_date
            r12.setKeyListener(r0)
            java.util.Map<java.lang.String, java.lang.String> r12 = r11.mapInstrumentAmountType
            java.util.Set r12 = r12.keySet()
            int r0 = r12.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r12 = r12.toArray(r0)
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.mapInstrumentFrequency
            java.util.Set r0 = r0.keySet()
            int r4 = r0.size()
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.Object[] r0 = r0.toArray(r4)
            java.lang.String[] r0 = (java.lang.String[]) r0
            android.widget.ArrayAdapter r4 = new android.widget.ArrayAdapter
            r5 = 17367048(0x1090008, float:2.5162948E-38)
            r4.<init>(r11, r5, r12)
            r11.adapter_amountType = r4
            r12 = 17367049(0x1090009, float:2.516295E-38)
            r4.setDropDownViewResource(r12)
            android.widget.ArrayAdapter r4 = new android.widget.ArrayAdapter
            r4.<init>(r11, r5, r0)
            r11.adapter_frequency = r4
            r4.setDropDownViewResource(r12)
            android.widget.Spinner r12 = r11.spinner_amountType
            android.widget.ArrayAdapter<java.lang.String> r0 = r11.adapter_amountType
            r12.setAdapter(r0)
            android.widget.Spinner r12 = r11.spinner_frequency
            android.widget.ArrayAdapter<java.lang.String> r0 = r11.adapter_frequency
            r12.setAdapter(r0)
            java.lang.String r12 = r1.getDebitFlag()
            if (r12 == 0) goto L_0x03a0
            java.lang.String r12 = r1.getDebitFlag()
            boolean r12 = r12.equalsIgnoreCase(r3)
            if (r12 == 0) goto L_0x03a0
            android.widget.LinearLayout r12 = r11.lyt_debit_day
            r12.setVisibility(r2)
            java.lang.String r12 = r1.getDebitDay()
            if (r12 == 0) goto L_0x03a5
            boolean r0 = r12.isEmpty()
            if (r0 != 0) goto L_0x03a5
            r0 = 0
        L_0x037d:
            java.util.List<java.lang.String> r1 = r11.debitDaysList
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x03a5
            java.util.List<java.lang.String> r1 = r11.debitDaysList
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r12.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x039d
            android.widget.Spinner r1 = r11.spinner_debitDay
            r1.setSelection(r0)
            android.widget.Spinner r1 = r11.spinner_debitDay
            r1.setEnabled(r2)
        L_0x039d:
            int r0 = r0 + 1
            goto L_0x037d
        L_0x03a0:
            android.widget.LinearLayout r12 = r11.lyt_debit_day
            r12.setVisibility(r6)
        L_0x03a5:
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getUtilityNo()
            if (r12 == 0) goto L_0x03c8
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getUtilityNo()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x03c8
            android.widget.TextView r12 = r11.tv_utility_no
            com.paynimo.android.payment.model.response.k.r r0 = r11.pmiData
            java.lang.String r0 = r0.getUtilityNo()
            java.lang.String r0 = r0.trim()
            r12.setText(r0)
        L_0x03c8:
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getMandatePurpose()
            if (r12 == 0) goto L_0x03eb
            com.paynimo.android.payment.model.response.k.r r12 = r11.pmiData
            java.lang.String r12 = r12.getMandatePurpose()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x03eb
            android.widget.TextView r12 = r11.tv_mandate_purpose
            com.paynimo.android.payment.model.response.k.r r0 = r11.pmiData
            java.lang.String r0 = r0.getMandatePurpose()
            java.lang.String r0 = r0.trim()
            r12.setText(r0)
        L_0x03eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.DigitalMandateActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        Constant.showOutputLog("==>>DigitalMandateAct", "onDestroy");
    }

    @Subscribe
    public void onEvent(q qVar) {
        Constant.showOutputLog(TAG, "got T response");
        hideProgressLoader();
        if (qVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:DigitalMandateSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", this.selected_bank_name, "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, qVar.getResponse().toString());
            try {
                if (!qVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    transactionError(qVar.getResponse().getPaymentMethod().getError().getCode(), qVar.getResponse().getPaymentMethod().getError().getDesc());
                } else if (this.rdo_biometric == null || !this.rdo_biometric.isChecked() || this.rdo_biometric.getVisibility() != 0) {
                    com.paynimo.android.payment.model.response.h paymentMethod = qVar.getResponse().getPaymentMethod();
                    if (paymentMethod != null) {
                        prepareWebviewDataForAccounts(paymentMethod);
                    } else {
                        Constant.showOutputLog(TAG, "got NULL PaymentMethod value in T response");
                    }
                } else {
                    com.paynimo.android.payment.model.response.h paymentMethod2 = qVar.getResponse().getPaymentMethod();
                    HashMap hashMap = new HashMap();
                    new ArrayList();
                    String bankAcsUrl = paymentMethod2.getACS().getBankAcsUrl();
                    if (bankAcsUrl != null && !bankAcsUrl.equalsIgnoreCase("")) {
                        List<Map> bankAcsParams = paymentMethod2.getACS().getBankAcsParams();
                        if (bankAcsParams != null && bankAcsParams.size() > 0) {
                            this.msg = null;
                            for (Map entrySet : bankAcsParams) {
                                for (Entry entry : entrySet.entrySet()) {
                                    hashMap.put(entry.getKey().toString(), entry.getValue().toString());
                                }
                            }
                            for (Object next : hashMap.keySet()) {
                                if (next != null) {
                                    try {
                                        if (next.toString() != null && next.toString().equalsIgnoreCase("msg")) {
                                            String str = (String) hashMap.get(next.toString());
                                            this.msg = str;
                                            if (str != null && !str.isEmpty()) {
                                                NodeList elementsByTagName = new f().getDomElement(this.msg).getElementsByTagName("Esign");
                                                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                                                    Node item = elementsByTagName.item(0);
                                                    if (!(item == null || item.getAttributes() == null || item.getAttributes().getLength() <= 0)) {
                                                        Node namedItem = item.getAttributes().getNamedItem("responseUrl");
                                                        if (!(namedItem == null || namedItem.getNodeValue() == null || namedItem.getNodeValue().isEmpty())) {
                                                            this.bankAcsBiometricUrl = namedItem.getNodeValue();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            if (this.msg != null) {
                                Intent intent = new Intent();
                                intent.setAction(ACTION_ESIGNRESPONSE);
                                intent.putExtra("msg", this.msg);
                                intent.putExtra(com.mpl.androidapp.utils.Constant.ENV, Constant.NSDL_ENV);
                                intent.putExtra("returnUrl", BuildConfig.LIBRARY_PACKAGE_NAME);
                                startActivityForResult(intent, 100);
                                return;
                            }
                            showAlertDialog(-2, Constant.TAG_ERROR_EMPTY_MSG_CODE, Constant.TAG_ERROR_EMPTY_MSG);
                        }
                    }
                }
            } catch (Exception unused2) {
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:DigitalMandateSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", this.selected_bank_name, "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, "Null T response");
        }
    }

    public void onPause() {
        super.onPause();
        this.et_cardNumber.removeTextChangedListener(this.CCTextWatcher);
        this.et_dateText.removeTextChangedListener(this.dateTextWatcher);
        this.et_verificationText.removeTextChangedListener(this.validationTextWatcher);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.paymentSettings = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.checkout = (Checkout) bundle.getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) bundle.getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
    }

    public void onResume() {
        super.onResume();
        this.et_cardNumber.addTextChangedListener(this.CCTextWatcher);
        this.et_dateText.addTextChangedListener(this.dateTextWatcher);
        this.et_verificationText.addTextChangedListener(this.validationTextWatcher);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, this.checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, this.pmiData);
        bundle.putParcelable(Constant.ARGUMENT_DATA_SETTING, this.paymentSettings);
        super.onSaveInstanceState(bundle);
    }

    public String showAadharWithIntervals(String str, int i) {
        int i2 = 1;
        String str2 = "";
        for (char c2 : str.toCharArray()) {
            str2 = str2 + c2;
            if (i2 % i == 0) {
                str2 = GeneratedOutlineSupport.outline50(str2, CMap.SPACE);
            }
            i2++;
        }
        return str2;
    }

    public void showAlertDialog(int i, final String str, final String str2) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_text", "id", getApplicationContext().getPackageName()))).setText(getResources().getString(getResources().getIdentifier("paynimo_payments_error", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonOK", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                DigitalMandateActivity.this.finishActivityForChangeInPaymentMode();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                DigitalMandateActivity.this.transactionError(str, str2);
            }
        });
        dialog.show();
    }

    public String showCCardWithIntervals(String str, CardType cardType2) {
        int i = 1;
        String str2 = "";
        for (char c2 : str.toCharArray()) {
            str2 = str2 + c2;
            if (cardType2.getSpacesPositions().contains(Integer.valueOf(i))) {
                str2 = GeneratedOutlineSupport.outline50(str2, CMap.SPACE);
            }
            i++;
        }
        return str2;
    }

    public void showSingleButtonDialog(Context context, String str) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(context.getResources().getIdentifier("paynimo_dialog_one_button", "layout", context.getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(context.getResources().getIdentifier("paynimo_dialog_one_tv", "id", context.getPackageName()))).setText(str);
        ((Button) dialog.findViewById(context.getResources().getIdentifier("paynimo_dialog_one_btn", "id", context.getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void transactionError(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra(PaymentActivity.RETURN_ERROR_CODE, str);
        intent.putExtra("error_description", str2);
        setResult(-2, intent);
        finish();
    }

    @Subscribe
    public void onEvent(p pVar) {
        hideProgressLoader();
        com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:DigitalMandateSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", this.selected_bank_name, "", "", this.mServiceManager, this);
        transactionError(pVar.getError().getCode(), pVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(s sVar) {
        Constant.showOutputLog(TAG, "got TWD response");
        hideProgressLoader();
        if (sVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TWD, "click", "button:DigitalMandateSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", "", this.issuer, this.inputCardType, this.mServiceManager, this);
            Constant.showOutputLog(TAG, sVar.getResponse().toString());
            try {
                if (sVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    com.paynimo.android.payment.model.response.h paymentMethod = sVar.getResponse().getPaymentMethod();
                    String responseType = sVar.getResponse().getResponseType();
                    String subType = paymentMethod.getAuthentication().getSubType();
                    if (responseType == null || responseType.trim().length() == 0) {
                        Constant.showOutputLog(TAG, "got NULL PaymentMethod value in Twd response");
                    } else if (subType == null || !subType.equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_3DS) || !responseType.equalsIgnoreCase("web")) {
                        Constant.showOutputLog(TAG, " Subtype is not 3ds=================>>>" + subType);
                    } else {
                        Constant.showOutputLog(TAG, "3DS condition verified");
                        prepareWebviewDataForCard(paymentMethod);
                    }
                } else if (this.checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                    transactionError(sVar.getResponse().getPaymentMethod().getError().getCode(), sVar.getResponse().getPaymentMethod().getError().getDesc());
                } else if (sVar.getResponse().getPaymentMethod().getAuthentication().getSubType().equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_STANDALONE)) {
                    this.tvSIErrorBlock.setVisibility(0);
                    this.tvSIErrorBlock.setText(sVar.getResponse().getPaymentMethod().getError().getDesc());
                } else {
                    transactionError(sVar.getResponse().getPaymentMethod().getError().getCode(), sVar.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception unused) {
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TWD, "click", "button:DigitalMandateSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", this.issuer, this.inputCardType, this.mServiceManager, this);
            Constant.showOutputLog(TAG, "Null TWD response");
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.r rVar) {
        hideProgressLoader();
        com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TWD, "click", "button:DigitalMandateSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", this.issuer, this.inputCardType, this.mServiceManager, this);
        showAlertDialog(-2, rVar.getError().getCode(), rVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.f fVar) {
        Constant.showOutputLog(TAG, "got IFSC response");
        if (fVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_FETCH_IFSC_DETAILS, "load", "DigitalMandate:fetchIFSCDetails", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", this.selected_bank, "", Logging.TAB, this.mServiceManager, this);
            Constant.showOutputLog(TAG, fVar.getResponse().toString());
            try {
                e response = fVar.getResponse();
                View childAt = this.viewPager.getChildAt(this.tabLayout.getSelectedTabPosition());
                if (childAt != null) {
                    if (response.getIsNACH() != null) {
                        if (response.getIsNACH().equalsIgnoreCase("Y")) {
                            if (response.getBankName() == null || !response.getBankName().toLowerCase().contains(this.selected_bank.toLowerCase())) {
                                this.isNACH = false;
                                this.lyt_bank_details = (LinearLayout) childAt.findViewById(getResources().getIdentifier("paynimo_lyt_bank_details", "id", getPackageName()));
                                TextView textView = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_error_text", "id", getPackageName()));
                                this.tv_bank_error_text = textView;
                                textView.setVisibility(0);
                                this.tv_bank_error_text.setText(getString(getResources().getIdentifier("paynimo_digital_mandate_enter_selected_bank_ifsc", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())));
                                this.lyt_bank_details.setVisibility(8);
                                return;
                            }
                            this.isNACH = true;
                            this.lyt_bank_details = (LinearLayout) childAt.findViewById(getResources().getIdentifier("paynimo_lyt_bank_details", "id", getPackageName()));
                            this.tv_bank_name = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_name", "id", getPackageName()));
                            this.tv_bank_address = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_address", "id", getPackageName()));
                            this.tv_bank_branch = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_branch", "id", getPackageName()));
                            this.tv_bank_district = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_district", "id", getPackageName()));
                            this.tv_bank_state = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_state", "id", getPackageName()));
                            this.tv_bank_micr = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_micr", "id", getPackageName()));
                            this.tv_bank_error_text = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_error_text", "id", getPackageName()));
                            this.lyt_bank_details.setVisibility(0);
                            this.tv_bank_error_text.setVisibility(8);
                            if (response.getBankName() != null) {
                                this.tv_bank_name.setText(response.getBankName());
                            }
                            if (response.getBankName() != null) {
                                this.tv_bank_name.setText(response.getBankName());
                            }
                            if (response.getBranchAddress() != null) {
                                this.tv_bank_address.setText(response.getBranchAddress());
                            }
                            if (response.getBranch() != null) {
                                this.tv_bank_branch.setText(response.getBranch());
                            }
                            if (response.getDistrict() != null) {
                                this.tv_bank_district.setText(response.getDistrict());
                            }
                            if (response.getState() != null) {
                                this.tv_bank_state.setText(response.getState());
                            }
                            if (response.getMICR() != null) {
                                this.tv_bank_micr.setText(response.getMICR());
                                return;
                            }
                            return;
                        }
                    }
                    this.isNACH = false;
                    this.lyt_bank_details = (LinearLayout) childAt.findViewById(getResources().getIdentifier("paynimo_lyt_bank_details", "id", getPackageName()));
                    TextView textView2 = (TextView) childAt.findViewById(getResources().getIdentifier("paynimo_bank_error_text", "id", getPackageName()));
                    this.tv_bank_error_text = textView2;
                    textView2.setVisibility(0);
                    this.tv_bank_error_text.setText(getString(getResources().getIdentifier("paynimo_digital_mandate_ifsc_not_supported", NetworkingModule.REQUEST_BODY_KEY_STRING, getPackageName())));
                    this.lyt_bank_details.setVisibility(8);
                }
            } catch (Exception unused) {
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_FETCH_IFSC_DETAILS, "load", "DigitalMandate:fetchIFSCDetails", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", this.selected_bank, "", Logging.TAB, this.mServiceManager, this);
            Constant.showOutputLog(TAG, "Null TAR response");
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.e eVar) {
        com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_FETCH_IFSC_DETAILS, "load", "DigitalMandate:fetchIFSCDetails", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", this.selected_bank, "", Logging.TAB, this.mServiceManager, this);
        int selectedTabPosition = this.tabLayout.getSelectedTabPosition();
        this.isNACH = false;
        View childAt = this.viewPager.getChildAt(selectedTabPosition);
        if (childAt != null) {
            this.lyt_bank_details = (LinearLayout) GeneratedOutlineSupport.outline18(this, getResources(), "paynimo_lyt_bank_details", "id", childAt);
            TextView textView = (TextView) GeneratedOutlineSupport.outline18(this, getResources(), "paynimo_bank_error_text", "id", childAt);
            this.tv_bank_error_text = textView;
            textView.setVisibility(0);
            this.tv_bank_error_text.setText(eVar.getError().getErrorDesc());
            this.lyt_bank_details.setVisibility(8);
        }
    }

    @Subscribe
    public void onEvent(o oVar) {
        Constant.showOutputLog(TAG, "got TAR response");
        hideProgressLoader();
        if (oVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, oVar.getResponse().toString());
            try {
                if (oVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    Intent intent = new Intent();
                    Checkout checkout2 = new Checkout();
                    checkout2.setMerchantResponsePayload(oVar.getResponse());
                    intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout2);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                transactionError(oVar.getResponse().getPaymentMethod().getError().getCode(), oVar.getResponse().getPaymentMethod().getError().getDesc());
            } catch (Exception unused) {
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, "Null TAR response");
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.n nVar) {
        hideProgressLoader();
        com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
        transactionError(Constant.TAG_ERROR_NETWORK_ERROR_CODE, nVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.b bVar) {
        Constant.showOutputLog(TAG, "got Bin Check response");
        if (bVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, bVar.getResponse().toString());
            try {
                if (bVar.getResponse().getAllowed() != null) {
                    String allowed = bVar.getResponse().getAllowed();
                    if (allowed.isEmpty() || !allowed.equalsIgnoreCase("yes")) {
                        this.isCardBinValid = false;
                        showBinCheckError();
                        return;
                    }
                    this.isCardBinValid = true;
                    if (bVar.getResponse().getCard_issuer_authority() != null && !bVar.getResponse().getCard_issuer_authority().isEmpty()) {
                        this.issuer = bVar.getResponse().getCard_issuer_authority();
                    }
                    if (bVar.getResponse().getCard_type() != null && !bVar.getResponse().getCard_type().isEmpty()) {
                        this.inputCardType = bVar.getResponse().getCard_type();
                        return;
                    }
                    return;
                }
                this.isCardBinValid = true;
            } catch (Exception unused) {
                this.isCardBinValid = true;
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
            this.isCardBinValid = true;
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.a aVar) {
        this.isCardBinValid = false;
        com.paynimo.android.payment.util.b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
        showBinCheckError();
    }
}
