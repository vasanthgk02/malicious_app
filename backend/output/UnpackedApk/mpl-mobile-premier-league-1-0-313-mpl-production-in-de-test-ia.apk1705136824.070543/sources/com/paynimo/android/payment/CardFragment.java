package com.paynimo.android.payment;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
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
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.CardTypeParser.CardType;
import com.paynimo.android.payment.PaymentActivity.Settings;
import com.paynimo.android.payment.a.f;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.g;
import com.paynimo.android.payment.event.s;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.b;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.h;
import com.paynimo.android.payment.model.response.k.c;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.network.NetworkStateReceiver;
import com.paynimo.android.payment.util.Constant;
import com.paynimo.android.payment.util.Validation;
import com.xiaomi.mipush.sdk.Constants;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import in.juspay.hypersdk.core.InflateView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class CardFragment extends Fragment implements OnDateSetListener, OnClickListener, OnItemClickListener, OnCheckedChangeListener, OnItemSelectedListener {
    public static String CARD_NOT_SUPPORTED = "Currently we are not supporting your card. Please try with some other card.";
    public static final String FRAGMENT_TAG = "CardFragment";
    public static final int MAX_NEEDED_NUMBERS = 6;
    public static final String PERMISSION_READ_PHONE_STATE = "Read Phone State";
    public static final int PERMISSION_REQUEST_CODE = 11;
    public static final int UNBOUNDED = MeasureSpec.makeMeasureSpec(0, 0);
    public static final int centuryPrefix = 0;
    public static boolean isPermissionAsked = false;
    public static final int milleniumPrefix = 2;
    public TextWatcher CCTextWatcher;
    public f adapter;
    public ArrayAdapter<String> adapter_amountType;
    public ArrayAdapter<String> adapter_frequency;
    public Calendar cal;
    public Boolean calledFromPaymentModes;
    public boolean canReadPhoneState;
    public String cardDataType;
    public EditText cardNumber;
    public CardType cardType;
    public ImageView ccImage;
    public CheckBox checkbox_si_new_card;
    public CheckBox checkbox_si_vault_card;
    public CheckBox checkbox_vault_card;
    public Checkout checkoutData;
    public ViewGroup container_new_card;
    public ViewGroup container_vault_card;
    public b data;
    public IntfOnFragmentDataPass dataPasser;
    public EditText dateText;
    public TextWatcher dateTextWatcher;
    public int day;
    public int default_cvv_digit;
    public OnDateSetListener endDatePickerListener;
    public EditText etAmountDebitNewCard;
    public EditText etAmountDebitVaultCard;
    public EditText etEndDateNewCard;
    public EditText etEndDateVaultCard;
    public EditText etStartDateNewCard;
    public EditText etStartDateVaultCard;
    public String firstNumbers;
    public ImageButton ibEndDateNewCard;
    public ImageButton ibEndDateVaultCard;
    public ImageButton ibStartDateNewCard;
    public ImageButton ibStartDateVaultCard;
    public String inputCardType;
    public boolean isCardBinValid;
    public boolean isDialogShown;
    public Boolean isSIEnabledFromMerchantScreeen;
    public Boolean isSINonEditableViewVisible;
    public boolean isTxnMerchantInitiated;
    public String issuer;
    public ListView list;
    public a mService;
    public d mServiceManager;
    public Map<String, String> mapInstrumentAmountType = new LinkedHashMap();
    public Map<String, String> mapInstrumentFrequency = new LinkedHashMap();
    public int month;
    public TextView n_etAmountDebitNewCard;
    public TextView n_etAmountDebitVaultCard;
    public TextView n_etAmountTypeNewCard;
    public TextView n_etAmountTypeVaultCard;
    public TextView n_etEndDateNewCard;
    public TextView n_etEndDateVaultCard;
    public TextView n_etFrequencyNewCard;
    public TextView n_etFrequencyVaultCard;
    public TextView n_etStartDateNewCard;
    public TextView n_etStartDateVaultCard;
    public ViewGroup n_si_container_new_card;
    public ViewGroup n_si_container_vault_card;
    public EditText name;
    public Button payButton;
    public TextView paynimo_card_list_header;
    public r pmiData;
    public Button quickPay;
    public RequestPayload request_payload;
    public c selectedVaultData;
    public Settings settingsData;
    public ViewGroup si_container_new_card;
    public ViewGroup si_container_vault_card;
    public Boolean singleModeSelected;
    public Spinner spinner_amount_type_new_card;
    public Spinner spinner_amount_type_vault_card;
    public Spinner spinner_frequency_new_card;
    public Spinner spinner_frequency_vault_card;
    public OnDateSetListener startDatePickerListener;
    public Date startTime;
    public TextView tvSIErrorBlock;
    public TextView tvSiInfoNewCard;
    public TextView tvSiInfoVaultCard;
    public TextWatcher validationTextWatcher;
    public ArrayList<c> vaultedCardsData = new ArrayList<>();
    public int vaulted_cvv_digit;
    public TextWatcher vaultedvalidationTextWatcher;
    public EditText verification;
    public EditText verification_saved_card;
    public int year;

    public CardFragment() {
        Boolean bool = Boolean.FALSE;
        this.isSIEnabledFromMerchantScreeen = bool;
        this.isSINonEditableViewVisible = bool;
        this.cardType = CardType.YetUnknown;
        this.cardDataType = "";
        this.default_cvv_digit = 2;
        this.vaulted_cvv_digit = 2;
        this.isDialogShown = false;
        this.canReadPhoneState = false;
        this.calledFromPaymentModes = Boolean.FALSE;
        this.isTxnMerchantInitiated = false;
        this.CCTextWatcher = new TextWatcher() {
            public int ccardLength = 0;
            public boolean isDelete = false;

            public void afterTextChanged(Editable editable) {
                CardFragment.this.cardNumber.setTextColor(ContextCompat.getColor(CardFragment.this.getActivity(), CardFragment.this.getResources().getIdentifier("defaultTextColor", "color", CardFragment.this.getActivity().getPackageName())));
                String showCCardWithIntervals = CardFragment.this.showCCardWithIntervals(CardFragment.this.cardNumber.getText().toString().replaceAll("\\s", ""), CardFragment.this.cardType);
                if (this.ccardLength < showCCardWithIntervals.length()) {
                    this.isDelete = false;
                } else {
                    this.isDelete = true;
                }
                String replaceAll = showCCardWithIntervals.substring(0, Math.min(7, showCCardWithIntervals.length())).replaceAll("\\s", "");
                if (CardFragment.this.firstNumbers == null || !CardFragment.this.firstNumbers.equals(replaceAll)) {
                    CardFragment.this.firstNumbers = replaceAll;
                    CardFragment cardFragment = CardFragment.this;
                    cardFragment.cardType = CardType.getCardType(cardFragment.firstNumbers, CardFragment.this.settingsData.getAllowedCardTypes());
                    CardFragment.this.cardNumber.setFilters(new InputFilter[]{new LengthFilter(CardFragment.this.cardType.getNumberOfIntervals() + CardFragment.this.cardType.getMaxLength())});
                }
                CardValidator.isValidCardType(CardFragment.this.getActivity(), CardFragment.this.cardNumber, CardFragment.this.cardType);
                if (CardFragment.this.cardType == CardType.YetUnknown || CardFragment.this.cardType == CardType.Invalid) {
                    CardFragment.this.ccImage.setVisibility(8);
                } else {
                    CardFragment.this.ccImage.setVisibility(0);
                    CardFragment.this.ccImage.setImageResource(CardFragment.this.cardType.getImageId());
                    CardFragment cardFragment2 = CardFragment.this;
                    cardFragment2.cardDataType = cardFragment2.cardType.toString();
                }
                int numberOfIntervals = CardFragment.this.cardType.getNumberOfIntervals() + CardFragment.this.cardType.getMaxLength();
                if (showCCardWithIntervals.length() > numberOfIntervals) {
                    showCCardWithIntervals = showCCardWithIntervals.substring(0, numberOfIntervals);
                }
                CardFragment.this.cardNumber.removeTextChangedListener(this);
                CardFragment cardFragment3 = CardFragment.this;
                int cCardMarkerPosition = cardFragment3.getCCardMarkerPosition(cardFragment3.cardNumber.getSelectionStart(), this.isDelete, CardFragment.this.cardType);
                CardFragment.this.cardNumber.setText(showCCardWithIntervals);
                EditText access$300 = CardFragment.this.cardNumber;
                if (cCardMarkerPosition >= showCCardWithIntervals.length()) {
                    cCardMarkerPosition = showCCardWithIntervals.length();
                }
                access$300.setSelection(cCardMarkerPosition);
                CardFragment.this.cardNumber.addTextChangedListener(this);
                if (CardFragment.this.cardType != CardType.Invalid) {
                    if (showCCardWithIntervals.length() == CardFragment.this.cardType.getNumberOfIntervals() + CardFragment.this.cardType.getMaxLength() && CardValidator.validateCreditCardNumber(CardFragment.this.getActivity(), CardFragment.this.cardNumber, CardFragment.this.cardType, CardFragment.this.settingsData.getAllowedCardTypes())) {
                        CardFragment.this.dateText.requestFocus();
                        String replace = showCCardWithIntervals.replace(CMap.SPACE, "");
                        if (replace != null) {
                            CardFragment.this.startBinCheckTask(replace.substring(0, 6), "", "", CardFragment.this.checkbox_vault_card.isChecked() ? "Y" : "N", CardFragment.this.checkbox_si_new_card.isChecked() ? "Y" : "N");
                        }
                    }
                }
                this.ccardLength = showCCardWithIntervals.length();
                if (CardFragment.this.cardType != CardType.Invalid) {
                    CardFragment.this.verification.setFilters(new InputFilter[]{new LengthFilter(CardFragment.this.cardType.getCVCLength())});
                    if (CardFragment.this.verification.length() > 0) {
                        CardValidator.validateCheckNumber(CardFragment.this.getActivity(), CardFragment.this.verification, CardFragment.this.cardType);
                    }
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CardFragment.this.tvSIErrorBlock.setText("");
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dateTextWatcher = new TextWatcher() {
            public int dateCursor;
            public int dateLength;
            public String formatedDate;
            public boolean isDateDelete = false;

            public void afterTextChanged(Editable editable) {
                CardFragment.this.dateText.setTextColor(ContextCompat.getColor(CardFragment.this.getActivity(), CardFragment.this.getResources().getIdentifier("defaultTextColor", "color", CardFragment.this.getActivity().getPackageName())));
                String obj = CardFragment.this.dateText.getText().toString();
                this.formatedDate = obj;
                this.isDateDelete = this.dateLength > obj.length();
                CardFragment.this.dateText.removeTextChangedListener(this);
                this.dateCursor = CardFragment.this.dateText.getSelectionStart();
                dateFormated(this.isDateDelete);
                CardFragment.this.dateText.setText(this.formatedDate);
                CardFragment.this.dateText.setSelection(this.dateCursor);
                CardFragment.this.dateText.addTextChangedListener(this);
                if (this.formatedDate.length() > 4) {
                    if (!CardValidator.validateDateFormat(this.formatedDate) || !CardValidator.validateDate((Context) CardFragment.this.getActivity(), CardFragment.this.dateText, false)) {
                        CardFragment.this.dateText.setTextColor(ContextCompat.getColor(CardFragment.this.getActivity(), CardFragment.this.getResources().getIdentifier("errorTextColor", "color", CardFragment.this.getActivity().getPackageName())));
                    } else {
                        CardFragment.this.verification.requestFocus();
                    }
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
        this.vaultedvalidationTextWatcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                try {
                    if (CardFragment.this.verification_saved_card.getText().toString().length() > CardFragment.this.vaulted_cvv_digit) {
                        CardFragment.this.quickPay.requestFocus();
                    }
                } catch (Exception unused) {
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CardFragment.this.verification_saved_card.setTextColor(ContextCompat.getColor(CardFragment.this.getActivity(), CardFragment.this.getResources().getIdentifier("defaultTextColor", "color", CardFragment.this.getActivity().getPackageName())));
            }
        };
        this.validationTextWatcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                try {
                    if (CardFragment.this.cardDataType.equalsIgnoreCase("AmericanExpress")) {
                        if (CardFragment.this.verification.getText().toString().length() > 3) {
                            CardFragment.this.name.requestFocus();
                        }
                    } else if (CardFragment.this.verification.getText().toString().length() > 2) {
                        CardFragment.this.name.requestFocus();
                    }
                } catch (Exception unused) {
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CardFragment.this.verification.setTextColor(ContextCompat.getColor(CardFragment.this.getActivity(), CardFragment.this.getResources().getIdentifier("defaultTextColor", "color", CardFragment.this.getActivity().getPackageName())));
                CardType access$400 = CardFragment.this.cardType;
                CardType cardType = CardType.YetUnknown;
            }
        };
        this.startDatePickerListener = new OnDateSetListener() {
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
                if (CardFragment.this.isDialogShown) {
                    EditText access$2300 = CardFragment.this.etStartDateVaultCard;
                    StringBuilder sb = new StringBuilder();
                    sb.append(outline41);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(outline412);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(i);
                    access$2300.setText(sb);
                    return;
                }
                EditText access$2400 = CardFragment.this.etStartDateNewCard;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(outline41);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(outline412);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(i);
                access$2400.setText(sb2);
            }
        };
        this.endDatePickerListener = new OnDateSetListener() {
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
                if (CardFragment.this.isDialogShown) {
                    EditText access$2500 = CardFragment.this.etEndDateVaultCard;
                    StringBuilder sb = new StringBuilder();
                    sb.append(outline41);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(outline412);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(i);
                    access$2500.setText(sb);
                    return;
                }
                EditText access$2600 = CardFragment.this.etEndDateNewCard;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(outline41);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(outline412);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(i);
                access$2600.setText(sb2);
            }
        };
    }

    private boolean addPermission(List<String> list2, String str) {
        if (!com.paynimo.android.payment.util.d.checkPermission(getActivity(), str)) {
            list2.add(str);
            if (!shouldShowRequestPermissionRationale(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkCardDetailsAndProceed() {
        /*
            r21 = this;
            r0 = r21
            java.lang.Boolean r1 = r21.validateSIData()
            boolean r1 = r1.booleanValue()
            r2 = 1
            if (r1 != 0) goto L_0x0035
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            android.content.res.Resources r3 = r21.getResources()
            android.content.res.Resources r4 = r21.getResources()
            androidx.fragment.app.FragmentActivity r5 = r21.getActivity()
            java.lang.String r5 = r5.getPackageName()
            java.lang.String r6 = "paynimo_cc_si_validation_error_message"
            java.lang.String r7 = "string"
            int r4 = r4.getIdentifier(r6, r7, r5)
            java.lang.String r3 = r3.getString(r4)
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r3, r2)
            r1.show()
            return
        L_0x0035:
            com.paynimo.android.payment.model.b r1 = new com.paynimo.android.payment.model.b
            r1.<init>()
            r0.data = r1
            android.widget.EditText r1 = r0.cardNumber
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            int r1 = r1.length()
            r3 = 6
            if (r1 <= r3) goto L_0x0063
            android.widget.EditText r1 = r0.cardNumber
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            com.paynimo.android.payment.PaymentActivity$Settings r3 = r0.settingsData
            java.util.Collection r3 = r3.getAllowedCardTypes()
            com.paynimo.android.payment.CardTypeParser$CardType r1 = com.paynimo.android.payment.CardTypeParser.CardType.getCardType(r1, r3)
            r0.cardType = r1
        L_0x0063:
            android.widget.CheckBox r1 = r0.checkbox_vault_card
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x006e
            java.lang.String r1 = "Y"
            goto L_0x0070
        L_0x006e:
            java.lang.String r1 = "N"
        L_0x0070:
            com.paynimo.android.payment.CardTypeParser$CardType r3 = r0.cardType
            com.paynimo.android.payment.CardTypeParser$CardType r4 = com.paynimo.android.payment.CardTypeParser.CardType.Maestro
            r5 = 5
            r6 = 3
            java.lang.String r7 = "20"
            r8 = 2
            r9 = 0
            java.lang.String r10 = "\\s"
            java.lang.String r11 = "DBT"
            java.lang.String r12 = "CRT"
            java.lang.String r13 = ""
            if (r3 != r4) goto L_0x01df
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            android.widget.EditText r3 = r0.name
            android.widget.EditText r4 = r0.cardNumber
            com.paynimo.android.payment.CardTypeParser$CardType r14 = r0.cardType
            com.paynimo.android.payment.PaymentActivity$Settings r15 = r0.settingsData
            java.util.Collection r15 = r15.getAllowedCardTypes()
            boolean r2 = com.paynimo.android.payment.CardValidator.validate(r2, r3, r4, r14, r15)
            if (r2 == 0) goto L_0x04c7
            android.widget.EditText r2 = r0.cardNumber
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.replaceAll(r10, r13)
            android.widget.EditText r3 = r0.name
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            android.widget.EditText r4 = r0.dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            android.text.Editable r4 = r4.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            java.lang.String r4 = r4.substring(r9, r8)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            r8.<init>()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            r8.append(r7)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            android.widget.EditText r7 = r0.dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            android.text.Editable r7 = r7.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            java.lang.String r5 = r7.substring(r6, r5)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            r8.append(r5)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            java.lang.String r5 = r8.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x00de }
            goto L_0x00e0
        L_0x00de:
            r4 = r13
            r5 = r4
        L_0x00e0:
            android.widget.EditText r6 = r0.verification
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.trim()
            com.paynimo.android.payment.model.b r7 = r0.data
            r7.setConsumerInstrumentToken(r13)
            com.paynimo.android.payment.model.b r7 = r0.data
            r7.setVaultConsumerInstrument(r1)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentIdentifier(r2)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentHolderName(r3)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentExpiryMonth(r4)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentExpiryYear(r5)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentCVC(r6)
            com.paynimo.android.payment.IntfOnFragmentDataPass r1 = r0.dataPasser
            com.paynimo.android.payment.model.b r2 = r0.data
            r1.cardDataFromFragment(r2)
            java.lang.String r1 = r0.issuer
            if (r1 == 0) goto L_0x019c
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = "maestro"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x019c
            java.lang.String r1 = r0.inputCardType
            if (r1 == 0) goto L_0x0162
            boolean r1 = r1.equalsIgnoreCase(r12)
            if (r1 == 0) goto L_0x0162
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getCredit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x0151
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0151
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x0151:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x0162:
            java.lang.String r1 = r0.inputCardType
            if (r1 == 0) goto L_0x04c7
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x04c7
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDebit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x018b
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x018b
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x018b:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x019c:
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getCredit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x01bb
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x01bb
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x01bb:
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDebit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x01da
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x01da
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x01da:
            r0.startCardNetworkTask(r13)
            goto L_0x04c7
        L_0x01df:
            androidx.fragment.app.FragmentActivity r3 = r21.getActivity()
            android.widget.EditText r4 = r0.dateText
            boolean r2 = com.paynimo.android.payment.CardValidator.validateDate(r3, r4, r2)
            if (r2 != 0) goto L_0x01ec
            return
        L_0x01ec:
            androidx.fragment.app.FragmentActivity r14 = r21.getActivity()
            android.widget.EditText r15 = r0.name
            android.widget.EditText r2 = r0.cardNumber
            android.widget.EditText r3 = r0.dateText
            android.widget.EditText r4 = r0.verification
            com.paynimo.android.payment.CardTypeParser$CardType r5 = r0.cardType
            com.paynimo.android.payment.PaymentActivity$Settings r6 = r0.settingsData
            java.util.Collection r20 = r6.getAllowedCardTypes()
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            boolean r2 = com.paynimo.android.payment.CardValidator.validate(r14, r15, r16, r17, r18, r19, r20)
            if (r2 == 0) goto L_0x04c7
            android.widget.EditText r2 = r0.cardNumber
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.replaceAll(r10, r13)
            android.widget.EditText r3 = r0.name
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            android.widget.EditText r4 = r0.dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0254 }
            android.text.Editable r4 = r4.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0254 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0254 }
            java.lang.String r4 = r4.substring(r9, r8)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0254 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            r5.<init>()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            r5.append(r7)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            android.widget.EditText r6 = r0.dateText     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            android.text.Editable r6 = r6.getText()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            r7 = 5
            r8 = 3
            java.lang.String r6 = r6.substring(r8, r7)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            r5.append(r6)     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception | StringIndexOutOfBoundsException -> 0x0255 }
            goto L_0x0256
        L_0x0254:
            r4 = r13
        L_0x0255:
            r5 = r13
        L_0x0256:
            android.widget.EditText r6 = r0.verification
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.trim()
            com.paynimo.android.payment.model.b r7 = r0.data
            r7.setConsumerInstrumentToken(r13)
            com.paynimo.android.payment.model.b r7 = r0.data
            r7.setVaultConsumerInstrument(r1)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentIdentifier(r2)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentHolderName(r3)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentExpiryMonth(r4)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentExpiryYear(r5)
            com.paynimo.android.payment.model.b r1 = r0.data
            r1.setConsumerInstrumentCVC(r6)
            com.paynimo.android.payment.IntfOnFragmentDataPass r1 = r0.dataPasser
            com.paynimo.android.payment.model.b r2 = r0.data
            r1.cardDataFromFragment(r2)
            com.paynimo.android.payment.CardTypeParser$CardType r1 = r0.cardType
            com.paynimo.android.payment.CardTypeParser$CardType r2 = com.paynimo.android.payment.CardTypeParser.CardType.AmericanExpress
            if (r1 != r2) goto L_0x02c4
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getAmex()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x02b3
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x02b3
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x02b3:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x02c4:
            com.paynimo.android.payment.CardTypeParser$CardType r2 = com.paynimo.android.payment.CardTypeParser.CardType.DinersClub
            if (r1 != r2) goto L_0x02f8
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDiner()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x02e7
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x02e7
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x02e7:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x02f8:
            com.paynimo.android.payment.CardTypeParser$CardType r2 = com.paynimo.android.payment.CardTypeParser.CardType.Discover
            if (r1 != r2) goto L_0x032c
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDiscover()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x031b
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x031b
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x031b:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x032c:
            com.paynimo.android.payment.CardTypeParser$CardType r2 = com.paynimo.android.payment.CardTypeParser.CardType.Rupay
            if (r1 != r2) goto L_0x0416
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getRupay()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x034f
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x034f
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x034f:
            java.lang.String r1 = r0.issuer
            if (r1 == 0) goto L_0x03d3
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = "rupay"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x03d3
            java.lang.String r1 = r0.inputCardType
            if (r1 == 0) goto L_0x0399
            boolean r1 = r1.equalsIgnoreCase(r12)
            if (r1 == 0) goto L_0x0399
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getCredit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x0388
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0388
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x0388:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x0399:
            java.lang.String r1 = r0.inputCardType
            if (r1 == 0) goto L_0x04c7
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x04c7
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDebit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x03c2
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x03c2
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x03c2:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x03d3:
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getCredit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x03f2
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x03f2
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x03f2:
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDebit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x0411
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0411
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x0411:
            r0.startCardNetworkTask(r13)
            goto L_0x04c7
        L_0x0416:
            java.lang.String r1 = r0.inputCardType
            if (r1 == 0) goto L_0x0450
            boolean r1 = r1.equalsIgnoreCase(r12)
            if (r1 == 0) goto L_0x0450
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getCredit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x043f
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x043f
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x043f:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x0450:
            java.lang.String r1 = r0.inputCardType
            if (r1 == 0) goto L_0x0488
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x0488
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDebit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x0478
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0478
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x0478:
            androidx.fragment.app.FragmentActivity r1 = r21.getActivity()
            com.paynimo.android.payment.PaymentActivity r1 = (com.paynimo.android.payment.PaymentActivity) r1
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            java.lang.String r3 = CARD_NOT_SUPPORTED
            r1.showSingleButtonDialog(r2, r3)
            goto L_0x04c7
        L_0x0488:
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getCredit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x04a6
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x04a6
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x04a6:
            com.paynimo.android.payment.model.response.k.r r1 = r0.pmiData
            com.paynimo.android.payment.model.response.k.a r1 = r1.getBanks()
            com.paynimo.android.payment.model.response.k.d r1 = r1.getCards()
            java.lang.String r1 = r1.getDebit()
            java.lang.String r1 = r1.trim()
            if (r1 == 0) goto L_0x04c4
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x04c4
            r0.startCardNetworkTask(r1)
            goto L_0x04c7
        L_0x04c4:
            r0.startCardNetworkTask(r13)
        L_0x04c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.CardFragment.checkCardDetailsAndProceed():void");
    }

    public static Object getKeyFromValue(Map map, Object obj) {
        for (Object next : map.keySet()) {
            if (map.get(next).equals(obj)) {
                return next;
            }
        }
        return null;
    }

    public static CardFragment instance(Settings settings, Checkout checkout, r rVar, Boolean bool, c cVar) {
        CardFragment cardFragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.ARGUMENT_DATA_SETTING, settings);
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, rVar);
        bundle.putBoolean(PaymentActivity.EXTRA_SINGLE_MODE_SELECTED, bool.booleanValue());
        bundle.putSerializable(PaymentActivity.ARGUMENT_DATA_VAULT_DATA_INFO, cVar);
        cardFragment.setArguments(bundle);
        return cardFragment;
    }

    private void openSIEditableContainer(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.si_container_new_card.setVisibility(0);
                this.etStartDateNewCard.setKeyListener(null);
                this.etEndDateNewCard.setKeyListener(null);
                this.spinner_amount_type_new_card.setAdapter(this.adapter_amountType);
                this.spinner_frequency_new_card.setAdapter(this.adapter_frequency);
                int i = this.month + 1;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(this.day);
                String sb = outline73.toString();
                String outline41 = GeneratedOutlineSupport.outline41("", i);
                int i2 = this.day;
                if (i2 > 0 && i2 < 10) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("0");
                    outline732.append(this.day);
                    sb = outline732.toString();
                }
                if (i > 0 && i < 10) {
                    outline41 = GeneratedOutlineSupport.outline41("0", i);
                }
                EditText editText = this.etStartDateNewCard;
                StringBuilder outline81 = GeneratedOutlineSupport.outline81(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                outline81.append(this.year);
                outline81.append(CMap.SPACE);
                editText.setText(outline81);
                EditText editText2 = this.etEndDateNewCard;
                StringBuilder outline812 = GeneratedOutlineSupport.outline81(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                outline812.append(this.year + 30);
                outline812.append(CMap.SPACE);
                editText2.setText(outline812);
                this.etAmountDebitNewCard.setText("1000.00");
                return;
            }
            this.etStartDateNewCard.setText("");
            this.etEndDateNewCard.setText("");
            this.etAmountDebitNewCard.setText("");
            this.si_container_new_card.setVisibility(8);
        } else if (z) {
            this.si_container_vault_card.setVisibility(0);
            this.etStartDateVaultCard.setKeyListener(null);
            this.etEndDateVaultCard.setKeyListener(null);
            this.spinner_amount_type_vault_card.setAdapter(this.adapter_amountType);
            this.spinner_frequency_vault_card.setAdapter(this.adapter_frequency);
            int i3 = this.month + 1;
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("");
            outline733.append(this.day);
            String sb2 = outline733.toString();
            String outline412 = GeneratedOutlineSupport.outline41("", i3);
            int i4 = this.day;
            if (i4 > 0 && i4 < 10) {
                StringBuilder outline734 = GeneratedOutlineSupport.outline73("0");
                outline734.append(this.day);
                sb2 = outline734.toString();
            }
            if (i3 > 0 && i3 < 10) {
                outline412 = GeneratedOutlineSupport.outline41("0", i3);
            }
            EditText editText3 = this.etStartDateVaultCard;
            StringBuilder outline813 = GeneratedOutlineSupport.outline81(sb2, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline412, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            outline813.append(this.year);
            outline813.append(CMap.SPACE);
            editText3.setText(outline813);
            EditText editText4 = this.etEndDateVaultCard;
            StringBuilder outline814 = GeneratedOutlineSupport.outline81(sb2, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline412, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            outline814.append(this.year + 30);
            outline814.append(CMap.SPACE);
            editText4.setText(outline814);
            this.etAmountDebitVaultCard.setText("1000.00");
        } else {
            this.etStartDateVaultCard.setText("");
            this.etEndDateVaultCard.setText("");
            this.etAmountDebitVaultCard.setText("");
            this.si_container_vault_card.setVisibility(8);
        }
    }

    private void openVaultDialog(View view, int i) {
        resetCalendar();
        final c cVar = this.vaultedCardsData.get(i);
        this.vaulted_cvv_digit = this.default_cvv_digit;
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_vault_card", "layout", getActivity().getPackageName()));
        dialog.setCanceledOnTouchOutside(true);
        TextView textView = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_list_card_bankname_label", "id", dialog);
        TextView textView2 = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_list_card_cardno_label", "id", dialog);
        ImageView imageView = (ImageView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_list_card_icon", "id", dialog);
        EditText editText = (EditText) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_vault_et_cvv", "id", dialog);
        this.verification_saved_card = editText;
        editText.setHint(getActivity().getResources().getIdentifier("paynimo_cc_verification_hint", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName()));
        ((TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_list_card_field_label", "id", dialog)).setText(getActivity().getResources().getIdentifier("paynimo_dialog_vaulted_field_card", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName()));
        this.tvSiInfoVaultCard = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_vault_card_si_info", "id", dialog);
        this.tvSIErrorBlock.setVisibility(8);
        this.si_container_vault_card = (ViewGroup) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_si_container", "id", dialog);
        this.etStartDateVaultCard = (EditText) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_et_debit_start_date", "id", dialog);
        this.etEndDateVaultCard = (EditText) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_et_debit_end_date", "id", dialog);
        this.etAmountDebitVaultCard = (EditText) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_et_amount_debit", "id", dialog);
        this.n_si_container_vault_card = (ViewGroup) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_si_non_edit_container", "id", dialog);
        this.n_etStartDateVaultCard = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_n_et_debit_start_date", "id", dialog);
        this.n_etEndDateVaultCard = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_n_et_debit_end_date", "id", dialog);
        this.n_etAmountDebitVaultCard = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_n_et_amount_debit", "id", dialog);
        this.n_etAmountTypeVaultCard = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_n_et_amountType", "id", dialog);
        this.n_etFrequencyVaultCard = (TextView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_n_et_frequency", "id", dialog);
        this.ibStartDateVaultCard = (ImageButton) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_vault_card_eb_start_date", "id", dialog);
        this.ibEndDateVaultCard = (ImageButton) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_vault_card_eb_end_date", "id", dialog);
        this.spinner_amount_type_vault_card = (Spinner) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_spinner_amountType", "id", dialog);
        this.spinner_frequency_vault_card = (Spinner) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_spinner_frequency", "id", dialog);
        this.checkbox_si_vault_card = (CheckBox) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_vault_card_checkbox_si", "id", dialog);
        this.tvSiInfoVaultCard.setOnClickListener(this);
        this.ibStartDateVaultCard.setOnClickListener(this);
        this.ibEndDateVaultCard.setOnClickListener(this);
        this.checkbox_si_vault_card.setOnCheckedChangeListener(this);
        this.checkbox_si_vault_card.setVisibility(8);
        this.tvSiInfoVaultCard.setVisibility(8);
        this.si_container_vault_card.setVisibility(8);
        this.n_si_container_vault_card.setVisibility(8);
        this.spinner_amount_type_vault_card.setOnItemSelectedListener(this);
        this.spinner_frequency_vault_card.setOnItemSelectedListener(this);
        if (GeneratedOutlineSupport.outline107(this.checkoutData, "Y")) {
            this.checkbox_si_vault_card.setVisibility(0);
            this.checkbox_si_vault_card.setChecked(true);
        }
        if ((this.pmiData.getSIEnable().equalsIgnoreCase("S") || this.pmiData.getSIEnable().equalsIgnoreCase("SI")) && !GeneratedOutlineSupport.outline107(this.checkoutData, "D")) {
            this.checkbox_si_vault_card.setVisibility(0);
            openSIEditableContainer(false, false);
            setInitialViewInstrumentValues(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getAction(), false);
        }
        if (cVar != null) {
            String cstat = cVar.getCstat();
            String maskedCardNo = cVar.getMaskedCardNo();
            String cardIssuerAuthority = cVar.getCardIssuerAuthority();
            if (cstat != null && !cstat.isEmpty() && cardIssuerAuthority != null && !cardIssuerAuthority.isEmpty() && maskedCardNo != null && !maskedCardNo.isEmpty()) {
                textView.setText(cstat);
                textView2.setText(maskedCardNo);
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_VISA)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_visa", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MC)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_mastercard", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MAESTRO)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_maestro", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_AMEX)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_american_express", "drawable", getActivity().getPackageName()));
                    this.vaulted_cvv_digit = this.default_cvv_digit + 1;
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DINER)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_diners_club", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_RUPAY)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_rupay", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DISCOVER)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_discover", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_IP)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_instapayment", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_LASER)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_laser", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_JCB)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_jcb", "drawable", getActivity().getPackageName()));
                } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_UP)) {
                    imageView.setImageResource(getActivity().getResources().getIdentifier("paynimo_unionpay", "drawable", getActivity().getPackageName()));
                }
            }
        }
        this.verification_saved_card.setFilters(new InputFilter[]{new LengthFilter(this.vaulted_cvv_digit + 1)});
        this.verification_saved_card.addTextChangedListener(this.vaultedvalidationTextWatcher);
        this.verification_saved_card.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((keyEvent != null && keyEvent.getKeyCode() == 66) || i == 6) {
                    CardFragment.this.quickPay.setPressed(true);
                    CardFragment.this.quickPay.invalidate();
                    CardFragment.this.quickPay.performClick();
                }
                return false;
            }
        });
        ((ImageView) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_list_vault_cancel", "id", dialog)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CardFragment.this.verification_saved_card.removeTextChangedListener(CardFragment.this.vaultedvalidationTextWatcher);
                ((InputMethodManager) CardFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(CardFragment.this.verification_saved_card.getWindowToken(), 0);
                CardFragment.this.isDialogShown = false;
                dialog.dismiss();
                CardFragment.this.resetCalendar();
            }
        });
        Button button = (Button) GeneratedOutlineSupport.outline15(this, getResources(), "paynimo_card_vault_pay_btn", "id", dialog);
        this.quickPay = button;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CardFragment.this.verification_saved_card.removeTextChangedListener(CardFragment.this.vaultedvalidationTextWatcher);
                String cardIssuerAuthority = cVar.getCardIssuerAuthority();
                String cardId = cVar.getCardId();
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MAESTRO)) {
                    String trim = CardFragment.this.pmiData.getBanks().getCards().getCredit().trim();
                    if (trim == null || trim.isEmpty()) {
                        String trim2 = CardFragment.this.pmiData.getBanks().getCards().getDebit().trim();
                        if (trim2 == null || trim2.isEmpty()) {
                            CardFragment.this.startVaultedCardNetworkTask(trim2, cardId, "", false);
                        } else {
                            CardFragment.this.startVaultedCardNetworkTask(trim2, cardId, "", false);
                        }
                    } else {
                        CardFragment.this.startVaultedCardNetworkTask(trim, cardId, "", false);
                    }
                    ((InputMethodManager) CardFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(CardFragment.this.verification_saved_card.getWindowToken(), 0);
                    CardFragment.this.isDialogShown = false;
                    dialog.dismiss();
                    CardFragment.this.resetCalendar();
                } else if (CardFragment.this.verification_saved_card.getText().toString().length() <= CardFragment.this.default_cvv_digit || !Validation.isCVVString(CardFragment.this.verification_saved_card.getText().toString()).booleanValue()) {
                    CardFragment.this.verification_saved_card.setError(CardFragment.this.getActivity().getString(CardFragment.this.getActivity().getResources().getIdentifier("paynimo_cc_invalid_cvv", NetworkingModule.REQUEST_BODY_KEY_STRING, CardFragment.this.getActivity().getPackageName())));
                    CardFragment.this.verification_saved_card.requestFocus();
                } else {
                    ((InputMethodManager) CardFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(CardFragment.this.verification_saved_card.getWindowToken(), 0);
                    String trim3 = CardFragment.this.verification_saved_card.getText().toString().trim();
                    if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_AMEX)) {
                        String trim4 = CardFragment.this.pmiData.getBanks().getCards().getAmex().trim();
                        if (trim4 == null || trim4.isEmpty()) {
                            ((PaymentActivity) CardFragment.this.getActivity()).showSingleButtonDialog(CardFragment.this.getActivity(), CardFragment.CARD_NOT_SUPPORTED);
                        } else {
                            CardFragment.this.startVaultedCardNetworkTask(trim4, cardId, trim3, false);
                        }
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DINER)) {
                        String trim5 = CardFragment.this.pmiData.getBanks().getCards().getDiner().trim();
                        if (trim5 == null || trim5.isEmpty()) {
                            ((PaymentActivity) CardFragment.this.getActivity()).showSingleButtonDialog(CardFragment.this.getActivity(), CardFragment.CARD_NOT_SUPPORTED);
                        } else {
                            CardFragment.this.startVaultedCardNetworkTask(trim5, cardId, trim3, false);
                        }
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DISCOVER)) {
                        String trim6 = CardFragment.this.pmiData.getBanks().getCards().getDiscover().trim();
                        if (trim6 == null || trim6.isEmpty()) {
                            ((PaymentActivity) CardFragment.this.getActivity()).showSingleButtonDialog(CardFragment.this.getActivity(), CardFragment.CARD_NOT_SUPPORTED);
                        } else {
                            CardFragment.this.startVaultedCardNetworkTask(trim6, cardId, trim3, false);
                        }
                    } else if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_RUPAY)) {
                        String trim7 = CardFragment.this.pmiData.getBanks().getCards().getRupay().trim();
                        if (trim7 == null || trim7.isEmpty()) {
                            ((PaymentActivity) CardFragment.this.getActivity()).showSingleButtonDialog(CardFragment.this.getActivity(), CardFragment.CARD_NOT_SUPPORTED);
                        } else {
                            CardFragment.this.startVaultedCardNetworkTask(trim7, cardId, trim3, false);
                        }
                    } else {
                        String trim8 = CardFragment.this.pmiData.getBanks().getCards().getCredit().trim();
                        if (trim8 == null || trim8.isEmpty()) {
                            String trim9 = CardFragment.this.pmiData.getBanks().getCards().getDebit().trim();
                            if (trim9 == null || trim9.isEmpty()) {
                                CardFragment.this.startVaultedCardNetworkTask(trim9, cardId, trim3, false);
                            } else {
                                CardFragment.this.startVaultedCardNetworkTask(trim9, cardId, trim3, false);
                            }
                        } else {
                            CardFragment.this.startVaultedCardNetworkTask(trim8, cardId, trim3, false);
                        }
                    }
                    CardFragment.this.isDialogShown = false;
                    dialog.dismiss();
                    CardFragment.this.resetCalendar();
                }
            }
        });
        dialog.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                CardFragment.this.resetCalendar();
                if (CardFragment.this.isDialogShown) {
                    CardFragment.this.isDialogShown = false;
                }
            }
        });
        this.isDialogShown = true;
        dialog.setCanceledOnTouchOutside(false);
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
        dialog.show();
    }

    private void prepareListData() {
        this.vaultedCardsData = (ArrayList) this.pmiData.getCustomerVault().getCardVault();
        f fVar = new f(getActivity(), getResources().getIdentifier("paynimo_listitem_cardvaulted", "layout", getActivity().getPackageName()), this.vaultedCardsData, this.checkoutData, this.mServiceManager);
        this.adapter = fVar;
    }

    private void prepareWebviewData(h hVar) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            new ArrayList();
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
                String sb2 = sb.toString();
                intent.putExtra("req_load_type_param", sb2.substring(0, sb2.length() - 1));
            } else {
                intent.putExtra("req_load_type_param", "");
            }
            intent.putExtra("req_load_type", Constant.WEBVIEW_TYPE_POSTURL);
            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, this.checkoutData);
            getActivity().startActivityForResult(intent, 2);
        } catch (Exception unused) {
            ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
        }
    }

    /* access modifiers changed from: private */
    public void resetCalendar() {
        Calendar instance = Calendar.getInstance();
        this.cal = instance;
        this.day = instance.get(5);
        this.month = this.cal.get(2);
        this.year = this.cal.get(1);
    }

    private void setImage() {
        this.cardNumber.setTextColor(ContextCompat.getColor(getActivity(), getResources().getIdentifier("defaultTextColor", "color", getActivity().getPackageName())));
        String showCCardWithIntervals = showCCardWithIntervals(this.cardNumber.getText().toString().replaceAll("\\s", ""), this.cardType);
        boolean z = showCCardWithIntervals.length() <= 0;
        String replaceAll = showCCardWithIntervals.substring(0, Math.min(7, showCCardWithIntervals.length())).replaceAll("\\s", "");
        String str = this.firstNumbers;
        if (str == null || !str.equals(replaceAll)) {
            this.firstNumbers = replaceAll;
            CardType cardType2 = CardType.getCardType(replaceAll, this.settingsData.getAllowedCardTypes());
            this.cardType = cardType2;
            this.cardNumber.setFilters(new InputFilter[]{new LengthFilter(this.cardType.getNumberOfIntervals() + cardType2.getMaxLength())});
        }
        CardValidator.isValidCardType(getActivity(), this.cardNumber, this.cardType);
        CardType cardType3 = this.cardType;
        if (cardType3 == CardType.YetUnknown || cardType3 == CardType.Invalid) {
            this.ccImage.setVisibility(8);
        } else {
            this.ccImage.setVisibility(0);
            this.ccImage.setImageResource(this.cardType.getImageId());
            this.cardDataType = this.cardType.toString();
        }
        int numberOfIntervals = this.cardType.getNumberOfIntervals() + this.cardType.getMaxLength();
        if (showCCardWithIntervals.length() > numberOfIntervals) {
            showCCardWithIntervals = showCCardWithIntervals.substring(0, numberOfIntervals);
        }
        int cCardMarkerPosition = getCCardMarkerPosition(this.cardNumber.getSelectionStart(), z, this.cardType);
        this.cardNumber.setText(showCCardWithIntervals);
        EditText editText = this.cardNumber;
        if (cCardMarkerPosition >= showCCardWithIntervals.length()) {
            cCardMarkerPosition = showCCardWithIntervals.length();
        }
        editText.setSelection(cCardMarkerPosition);
        if (this.cardType != CardType.Invalid) {
            if (showCCardWithIntervals.length() == this.cardType.getNumberOfIntervals() + this.cardType.getMaxLength() && CardValidator.validateCreditCardNumber(getActivity(), this.cardNumber, this.cardType, this.settingsData.getAllowedCardTypes())) {
                this.dateText.requestFocus();
            }
        }
        showCCardWithIntervals.length();
        if (this.cardType != CardType.Invalid) {
            this.verification.setFilters(new InputFilter[]{new LengthFilter(this.cardType.getCVCLength())});
            if (this.verification.length() > 0) {
                CardValidator.validateCheckNumber(getActivity(), this.verification, this.cardType);
            }
        }
    }

    private void setInitialViewInstrumentValues(String str, boolean z) {
        if (z) {
            if (!PaymentModesActivity.isSIEnabledFromMerchant || !str.equalsIgnoreCase("Y")) {
                this.checkbox_si_new_card.setChecked(false);
                this.checkbox_si_new_card.setClickable(true);
                this.tvSiInfoNewCard.setVisibility(8);
                return;
            }
            this.isSIEnabledFromMerchantScreeen = Boolean.TRUE;
            this.checkbox_si_new_card.setChecked(true);
            this.checkbox_si_new_card.setClickable(false);
            this.checkbox_si_new_card.setAlpha(0.5f);
            this.checkbox_vault_card.setChecked(true);
            this.checkbox_vault_card.setClickable(false);
            this.checkbox_vault_card.setAlpha(0.5f);
            this.tvSiInfoNewCard.setVisibility(0);
            this.tvSiInfoNewCard.setText(getResources().getString(getResources().getIdentifier("paynimo_cc_si_view_detail_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
        } else if (!PaymentModesActivity.isSIEnabledFromMerchant || !str.equalsIgnoreCase("Y")) {
            this.checkbox_si_vault_card.setChecked(false);
            this.checkbox_si_vault_card.setClickable(true);
            this.tvSiInfoVaultCard.setVisibility(8);
        } else {
            this.isSIEnabledFromMerchantScreeen = Boolean.TRUE;
            this.checkbox_si_vault_card.setChecked(true);
            this.checkbox_si_vault_card.setClickable(false);
            this.checkbox_si_vault_card.setAlpha(0.5f);
            this.checkbox_vault_card.setChecked(true);
            this.checkbox_vault_card.setClickable(false);
            this.checkbox_vault_card.setAlpha(0.5f);
            this.tvSiInfoVaultCard.setVisibility(0);
            this.tvSiInfoVaultCard.setText(getResources().getString(getResources().getIdentifier("paynimo_cc_si_view_detail_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
        }
    }

    private void setListData() {
        this.list.setAdapter(this.adapter);
        LayoutParams layoutParams = this.list.getLayoutParams();
        int size = this.vaultedCardsData.size();
        if (size > 0) {
            this.container_vault_card.setVisibility(0);
            try {
                int dimension = ((int) getResources().getDimension(getResources().getIdentifier("paynimo_vaultedCardsRowHeight", "dimen", getActivity().getPackageName()))) + 30;
                if (size == 1) {
                    layoutParams.height = (dimension * 1) - 30;
                    this.list.setDividerHeight(0);
                    this.paynimo_card_list_header.setText(getResources().getIdentifier("paynimo_card_v_heading_label_single", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName()));
                } else if (size == 2) {
                    layoutParams.height = (dimension * 2) - 180;
                } else if (size >= 3) {
                    layoutParams.height = dimension * 3;
                }
                this.list.setPadding(0, 0, 0, 0);
            } catch (Exception unused) {
                layoutParams.height = 0;
            }
        } else {
            layoutParams.height = 0;
            this.container_vault_card.setVisibility(8);
        }
        this.list.setLayoutParams(layoutParams);
    }

    private void showBinCheckError() {
        this.cardNumber.setTextColor(ContextCompat.getColor(getActivity(), getActivity().getResources().getIdentifier("errorTextColor", "color", getActivity().getPackageName())));
        this.cardNumber.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_cc_card_bin_check_error_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
        this.cardNumber.requestFocus();
    }

    private void showMessageOKCancel(String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        Builder builder = new Builder(getActivity(), getResources().getIdentifier("DialogStylePaynimo", "style", getActivity().getPackageName()));
        builder.P.mMessage = str;
        builder.setPositiveButton((CharSequence) getResources().getString(getResources().getIdentifier("paynimo_custom_dialog_ok_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())), onClickListener);
        builder.setNegativeButton((CharSequence) getResources().getString(getResources().getIdentifier("paynimo_custom_dialog_cancel_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())), onClickListener2);
        builder.show();
    }

    /* access modifiers changed from: private */
    public void startBinCheckTask(String str, String str2, String str3, String str4, String str5) {
        try {
            this.issuer = null;
            this.inputCardType = null;
            if (NetworkStateReceiver.isOnline(getActivity())) {
                try {
                    this.startTime = new Date();
                    com.paynimo.android.payment.model.request.c cVar = new com.paynimo.android.payment.model.request.c();
                    cVar.setBin(str);
                    cVar.setSubmer_code(this.checkoutData.getMerchantRequestPayload().getMerchant().getIdentifier());
                    cVar.setBank_code(str2);
                    cVar.setSrc_prn(this.checkoutData.getMerchantRequestPayload().getTransaction().getIdentifier());
                    cVar.setPayment_instrument_token(str3);
                    cVar.setTransaction_isRegistration(str4);
                    cVar.setPayment_instruction_action(str5);
                    this.mServiceManager.callBinCheckAPI(cVar, getActivity());
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

    private void startCardNetworkTask(String str) {
        try {
            if (NetworkStateReceiver.isOnline(getActivity())) {
                try {
                    if (this.checkoutData != null) {
                        this.startTime = new Date();
                        this.checkoutData.setTransactionRequestType(Constant.REQUEST_TYPE_TWD);
                        this.checkoutData.setPaymentMethodType("C");
                        this.checkoutData.setPaymentMethodToken(str);
                        if (this.checkoutData.getMerchantRequestPayload().getTransaction().getType().trim().equals("PREAUTH")) {
                            this.checkoutData.setTransactionForced3DSCall("Y");
                        } else {
                            this.checkoutData.setTransactionForced3DSCall("N");
                        }
                        this.checkoutData.setTransactionSmsSending((!this.canReadPhoneState || !isSimExists()) ? "N" : "Y");
                        this.checkoutData.setPaymentInstrumentIdentifier(PaymentActivity.ConsumerInstrumentIdentifier);
                        this.checkoutData.setPaymentInstrumentExpiryMonth(PaymentActivity.ConsumerInstrumentExpiryMonth);
                        this.checkoutData.setPaymentInstrumentExpiryYear(PaymentActivity.ConsumerInstrumentExpiryYear);
                        this.checkoutData.setPaymentInstrumentVerificationCode(PaymentActivity.ConsumerInstrumentCVC);
                        this.checkoutData.setPaymentInstrumentHolderName(PaymentActivity.ConsumerInstrumentHolderName);
                        this.checkoutData.setTransactionIsRegistration(PaymentActivity.VaultConsumerInstrument);
                        this.checkoutData.setPaymentInstrumentToken(PaymentActivity.ConsumerInstrumentToken);
                        if (this.pmiData.getSIEnable().equalsIgnoreCase("S") || this.pmiData.getSIEnable().equalsIgnoreCase("SI")) {
                            String str2 = "";
                            if (this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                                if (!this.checkbox_si_new_card.isChecked()) {
                                    this.checkoutData.setPaymentInstructionAction("N");
                                    this.checkoutData.setPaymentInstructionType(str2);
                                    this.checkoutData.setPaymentInstructionLimit(str2);
                                    this.checkoutData.setPaymentInstructionFrequency(str2);
                                    this.checkoutData.setPaymentInstructionStartDateTime(str2);
                                    this.checkoutData.setPaymentInstructionEndDateTime(str2);
                                } else if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() > 0 && this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() > 0 && this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() > 0 && this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getFrequency().length() > 0) {
                                    this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getType().length();
                                }
                            } else if (this.checkbox_si_new_card.isChecked()) {
                                this.checkoutData.setPaymentInstructionAction("Y");
                                this.checkoutData.setPaymentInstructionLimit(this.etAmountDebitNewCard.getText().toString());
                                this.checkoutData.setPaymentInstructionStartDateTime(this.etStartDateNewCard.getText().toString());
                                this.checkoutData.setPaymentInstructionEndDateTime(this.etEndDateNewCard.getText().toString());
                                String str3 = this.mapInstrumentFrequency.containsKey(this.spinner_frequency_new_card.getSelectedItem().toString()) ? this.mapInstrumentFrequency.get(this.spinner_frequency_new_card.getSelectedItem().toString()) : str2;
                                if (this.mapInstrumentAmountType.containsKey(this.spinner_amount_type_new_card.getSelectedItem().toString())) {
                                    str2 = this.mapInstrumentAmountType.get(this.spinner_amount_type_new_card.getSelectedItem().toString());
                                }
                                this.checkoutData.setPaymentInstructionType(str2);
                                this.checkoutData.setPaymentInstructionFrequency(str3);
                            } else {
                                this.checkoutData.setPaymentInstructionAction("N");
                                this.checkoutData.setPaymentInstructionType(str2);
                                this.checkoutData.setPaymentInstructionLimit(str2);
                                this.checkoutData.setPaymentInstructionFrequency(str2);
                                this.checkoutData.setPaymentInstructionStartDateTime(str2);
                                this.checkoutData.setPaymentInstructionEndDateTime(str2);
                            }
                        }
                        RequestPayload merchantRequestPayload = this.checkoutData.getMerchantRequestPayload();
                        this.request_payload = merchantRequestPayload;
                        this.mServiceManager.callTWDRequest(merchantRequestPayload, getActivity());
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

    /* access modifiers changed from: private */
    public void startVaultedCardNetworkTask(String str, String str2, String str3, boolean z) {
        b bVar = new b();
        this.data = bVar;
        bVar.setConsumerInstrumentToken(str2);
        this.data.setConsumerInstrumentCVC(str3.toString().trim());
        this.data.setVaultConsumerInstrument("N");
        this.dataPasser.cardDataFromFragment(this.data);
        if (str == null || str.isEmpty()) {
            Constant.showOutputLog(FRAGMENT_TAG, " BankCode is EMPTY or NULL");
            return;
        }
        try {
            if (NetworkStateReceiver.isOnline(getActivity())) {
                try {
                    if (this.checkoutData != null) {
                        this.checkoutData.setTransactionRequestType(Constant.REQUEST_TYPE_TCD);
                        this.checkoutData.setPaymentMethodType("C");
                        this.checkoutData.setPaymentMethodToken(str);
                        this.checkoutData.setPaymentInstrumentIdentifier(PaymentActivity.ConsumerInstrumentIdentifier);
                        this.checkoutData.setPaymentInstrumentExpiryMonth(PaymentActivity.ConsumerInstrumentExpiryMonth);
                        this.checkoutData.setPaymentInstrumentExpiryYear(PaymentActivity.ConsumerInstrumentExpiryYear);
                        this.checkoutData.setPaymentInstrumentVerificationCode(PaymentActivity.ConsumerInstrumentCVC);
                        this.checkoutData.setPaymentInstrumentHolderName(PaymentActivity.ConsumerInstrumentHolderName);
                        this.checkoutData.setTransactionIsRegistration(PaymentActivity.VaultConsumerInstrument);
                        this.checkoutData.setPaymentInstrumentToken(PaymentActivity.ConsumerInstrumentToken);
                        if (this.checkoutData.getMerchantRequestPayload().getTransaction().getType().trim().equals("PREAUTH")) {
                            this.checkoutData.setTransactionForced3DSCall("Y");
                        } else {
                            this.checkoutData.setTransactionForced3DSCall("N");
                        }
                        if (this.pmiData.getSIEnable().equalsIgnoreCase("S") || this.pmiData.getSIEnable().equalsIgnoreCase("SI")) {
                            String str4 = "";
                            if (this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                                if (!z) {
                                    if (this.checkbox_si_vault_card.isChecked()) {
                                        if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() > 0 && this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() > 0 && this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() > 0 && this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getFrequency().length() > 0) {
                                            this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getType().length();
                                        }
                                    } else if (!z) {
                                        this.checkoutData.setPaymentInstructionAction("N");
                                        this.checkoutData.setPaymentInstructionType(str4);
                                        this.checkoutData.setPaymentInstructionLimit(str4);
                                        this.checkoutData.setPaymentInstructionFrequency(str4);
                                        this.checkoutData.setPaymentInstructionStartDateTime(str4);
                                        this.checkoutData.setPaymentInstructionEndDateTime(str4);
                                    }
                                }
                            } else if (this.checkbox_si_vault_card != null && this.checkbox_si_vault_card.isChecked()) {
                                this.checkoutData.setPaymentInstructionAction("Y");
                                this.checkoutData.setPaymentInstructionLimit(this.etAmountDebitVaultCard.getText().toString());
                                this.checkoutData.setPaymentInstructionStartDateTime(this.etStartDateVaultCard.getText().toString());
                                this.checkoutData.setPaymentInstructionEndDateTime(this.etEndDateVaultCard.getText().toString());
                                String str5 = this.mapInstrumentFrequency.containsKey(this.spinner_frequency_vault_card.getSelectedItem().toString()) ? this.mapInstrumentFrequency.get(this.spinner_frequency_vault_card.getSelectedItem().toString()) : str4;
                                if (this.mapInstrumentAmountType.containsKey(this.spinner_amount_type_vault_card.getSelectedItem().toString())) {
                                    str4 = this.mapInstrumentAmountType.get(this.spinner_amount_type_vault_card.getSelectedItem().toString());
                                }
                                this.checkoutData.setPaymentInstructionType(str4);
                                this.checkoutData.setPaymentInstructionFrequency(str5);
                            } else if (!z) {
                                this.checkoutData.setPaymentInstructionAction("N");
                                this.checkoutData.setPaymentInstructionType(str4);
                                this.checkoutData.setPaymentInstructionLimit(str4);
                                this.checkoutData.setPaymentInstructionFrequency(str4);
                                this.checkoutData.setPaymentInstructionStartDateTime(str4);
                                this.checkoutData.setPaymentInstructionEndDateTime(str4);
                            }
                        }
                        this.startTime = new Date();
                        this.request_payload = this.checkoutData.getMerchantRequestPayload();
                        ((PaymentActivity) getActivity()).showProgressLoader();
                        this.mServiceManager.callTWDRequest(this.request_payload, getActivity());
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

    private Boolean validateSIData() {
        Boolean bool = Boolean.FALSE;
        if (!this.pmiData.getSIEnable().equalsIgnoreCase("S") && !this.pmiData.getSIEnable().equalsIgnoreCase("SI")) {
            return Boolean.TRUE;
        }
        if (GeneratedOutlineSupport.outline107(this.checkoutData, "Y")) {
            if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() <= 0 || this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() <= 0 || this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() <= 0 || this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getFrequency().length() <= 0 || this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getType().length() <= 0) {
                return bool;
            }
            return Boolean.TRUE;
        } else if (!this.checkbox_si_new_card.isChecked()) {
            return Boolean.TRUE;
        } else {
            if (this.etStartDateNewCard.getText().length() <= 0 || this.etEndDateNewCard.getText().length() <= 0 || this.etAmountDebitNewCard.getText().length() <= 0) {
                return bool;
            }
            return Boolean.TRUE;
        }
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

    public boolean isSimExists() {
        return ((TelephonyManager) getActivity().getSystemService("phone")).getSimState() == 5;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.isSINonEditableViewVisible = Boolean.valueOf(bundle.getBoolean("KEY_SI_NON_VIEW", false));
            this.isSIEnabledFromMerchantScreeen = Boolean.valueOf(bundle.getBoolean("KEY_SI_ENABLED_FRM_MRCHT", false));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
        Constant.showOutputLog("==>>CardFragment", "onAttach");
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

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.checkbox_vault_card) {
            if (!z && this.checkbox_si_new_card.isChecked()) {
                this.checkbox_vault_card.setChecked(true);
            }
        } else if (compoundButton == this.checkbox_si_new_card) {
            if (z) {
                if (!this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                    openSIEditableContainer(true, true);
                }
                if (!this.checkbox_vault_card.isChecked()) {
                    this.checkbox_vault_card.setChecked(true);
                    return;
                }
                return;
            }
            this.tvSIErrorBlock.setText("");
            if (this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                this.n_si_container_new_card.setVisibility(8);
                this.isSINonEditableViewVisible = Boolean.FALSE;
                this.tvSiInfoNewCard.setText(getString(getResources().getIdentifier("paynimo_card_show_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                this.checkbox_si_new_card.setChecked(true);
                return;
            }
            openSIEditableContainer(false, true);
        } else if (compoundButton != this.checkbox_si_vault_card) {
        } else {
            if (!z) {
                this.tvSIErrorBlock.setText("");
                if (this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                    this.n_si_container_vault_card.setVisibility(8);
                    this.isSINonEditableViewVisible = Boolean.FALSE;
                    this.tvSiInfoVaultCard.setText(getString(getResources().getIdentifier("paynimo_card_show_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                    this.checkbox_si_vault_card.setChecked(true);
                    return;
                }
                openSIEditableContainer(false, false);
            } else if (!this.isSIEnabledFromMerchantScreeen.booleanValue()) {
                openSIEditableContainer(true, false);
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == getResources().getIdentifier("paynimo_card_si_info", "id", getActivity().getPackageName())) {
            if (!this.isSINonEditableViewVisible.booleanValue()) {
                this.isSINonEditableViewVisible = Boolean.TRUE;
                this.tvSiInfoNewCard.setText(getString(getResources().getIdentifier("paynimo_card_hide_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                this.n_si_container_new_card.setVisibility(0);
                this.n_etStartDateNewCard.setKeyListener(null);
                this.n_etEndDateNewCard.setKeyListener(null);
                this.n_etAmountDebitNewCard.setKeyListener(null);
                this.n_etAmountTypeNewCard.setKeyListener(null);
                this.n_etFrequencyNewCard.setKeyListener(null);
                if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() > 0) {
                    this.n_etStartDateNewCard.setText(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime());
                } else {
                    this.n_etStartDateNewCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                }
                if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() > 0) {
                    this.n_etEndDateNewCard.setText(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime());
                } else {
                    this.n_etEndDateNewCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                }
                if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() > 0) {
                    this.n_etAmountDebitNewCard.setText(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit());
                } else {
                    this.n_etAmountDebitNewCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                }
                String frequency = this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getFrequency();
                if (frequency.equals(null) || frequency.length() <= 0) {
                    this.n_etFrequencyNewCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                } else {
                    try {
                        this.n_etFrequencyNewCard.setText((String) getKeyFromValue(this.mapInstrumentFrequency, frequency));
                    } catch (Exception unused) {
                    }
                }
                String type = this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getType();
                if (type.equals(null) || type.length() <= 0) {
                    this.n_etAmountTypeNewCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                    return;
                }
                try {
                    this.n_etAmountTypeNewCard.setText((String) getKeyFromValue(this.mapInstrumentAmountType, type));
                } catch (Exception unused2) {
                }
            } else {
                this.isSINonEditableViewVisible = Boolean.FALSE;
                this.tvSiInfoNewCard.setText(getString(getResources().getIdentifier("paynimo_card_show_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                this.n_si_container_new_card.setVisibility(8);
            }
        } else if (view.getId() == getResources().getIdentifier("paynimo_card_eb_start_date", "id", getActivity().getPackageName())) {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            Bundle bundle = new Bundle();
            String[] split = this.etStartDateNewCard.getText().toString().trim().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            this.day = Integer.valueOf(split[0].trim()).intValue();
            this.month = Integer.valueOf(split[1].trim()).intValue();
            int intValue = Integer.valueOf(split[2].trim()).intValue();
            this.year = intValue;
            bundle.putInt(AnonymousClass27.YEAR, intValue);
            bundle.putInt(AnonymousClass27.MONTH, this.month - 1);
            bundle.putInt("day", this.day);
            datePickerFragment.setArguments(bundle);
            datePickerFragment.setCallBack(this.startDatePickerListener);
            datePickerFragment.show(getFragmentManager(), (String) "Date Picker");
        } else if (view.getId() == getResources().getIdentifier("paynimo_card_eb_end_date", "id", getActivity().getPackageName())) {
            DatePickerFragment datePickerFragment2 = new DatePickerFragment();
            Bundle bundle2 = new Bundle();
            String[] split2 = this.etEndDateNewCard.getText().toString().trim().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            this.day = Integer.valueOf(split2[0].trim()).intValue();
            this.month = Integer.valueOf(split2[1].trim()).intValue();
            int intValue2 = Integer.valueOf(split2[2].trim()).intValue();
            this.year = intValue2;
            bundle2.putInt(AnonymousClass27.YEAR, intValue2);
            bundle2.putInt(AnonymousClass27.MONTH, this.month - 1);
            bundle2.putInt("day", this.day);
            datePickerFragment2.setArguments(bundle2);
            datePickerFragment2.setCallBack(this.endDatePickerListener);
            datePickerFragment2.show(getFragmentManager(), (String) "Date Picker");
        } else if (view.getId() == getResources().getIdentifier("paynimo_card_pay_btn", "id", getActivity().getPackageName())) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.name.getWindowToken(), 0);
            checkCardDetailsAndProceed();
        } else if (view.getId() == getResources().getIdentifier("paynimo_vault_card_si_info", "id", getActivity().getPackageName())) {
            if (!this.isSINonEditableViewVisible.booleanValue()) {
                this.isSINonEditableViewVisible = Boolean.TRUE;
                this.tvSiInfoVaultCard.setText(getString(getResources().getIdentifier("paynimo_card_hide_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                this.n_si_container_vault_card.setVisibility(0);
                this.n_etStartDateVaultCard.setKeyListener(null);
                this.n_etEndDateVaultCard.setKeyListener(null);
                this.n_etAmountDebitVaultCard.setKeyListener(null);
                this.n_etAmountTypeVaultCard.setKeyListener(null);
                this.n_etFrequencyVaultCard.setKeyListener(null);
                if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() > 0) {
                    this.n_etStartDateVaultCard.setText(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime());
                } else {
                    this.n_etStartDateVaultCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                }
                if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() > 0) {
                    this.n_etEndDateVaultCard.setText(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime());
                } else {
                    this.n_etEndDateVaultCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                }
                if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() > 0) {
                    this.n_etAmountDebitVaultCard.setText(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit());
                } else {
                    this.n_etAmountDebitVaultCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                }
                String frequency2 = this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getFrequency();
                if (frequency2.equals(null) || frequency2.length() <= 0) {
                    this.n_etFrequencyVaultCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                } else {
                    try {
                        this.n_etFrequencyVaultCard.setText((String) getKeyFromValue(this.mapInstrumentFrequency, frequency2));
                    } catch (Exception unused3) {
                    }
                }
                String type2 = this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getType();
                if (type2.equals(null) || type2.length() <= 0) {
                    this.n_etAmountTypeVaultCard.setError(getActivity().getString(getActivity().getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                    return;
                }
                this.n_etAmountTypeVaultCard.setText((String) getKeyFromValue(this.mapInstrumentAmountType, type2));
                return;
            }
            this.isSINonEditableViewVisible = Boolean.FALSE;
            this.tvSiInfoVaultCard.setText(getString(getResources().getIdentifier("paynimo_card_show_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
            this.n_si_container_vault_card.setVisibility(8);
        } else if (view.getId() == getResources().getIdentifier("paynimo_vault_card_eb_start_date", "id", getActivity().getPackageName())) {
            DatePickerFragment datePickerFragment3 = new DatePickerFragment();
            Bundle bundle3 = new Bundle();
            String[] split3 = this.etStartDateVaultCard.getText().toString().trim().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            this.day = Integer.valueOf(split3[0].trim()).intValue();
            this.month = Integer.valueOf(split3[1].trim()).intValue();
            int intValue3 = Integer.valueOf(split3[2].trim()).intValue();
            this.year = intValue3;
            bundle3.putInt(AnonymousClass27.YEAR, intValue3);
            bundle3.putInt(AnonymousClass27.MONTH, this.month - 1);
            bundle3.putInt("day", this.day);
            datePickerFragment3.setArguments(bundle3);
            datePickerFragment3.setCallBack(this.startDatePickerListener);
            datePickerFragment3.show(getFragmentManager(), (String) "Date Picker");
        } else if (view.getId() == getResources().getIdentifier("paynimo_vault_card_eb_end_date", "id", getActivity().getPackageName())) {
            DatePickerFragment datePickerFragment4 = new DatePickerFragment();
            Bundle bundle4 = new Bundle();
            String[] split4 = this.etEndDateVaultCard.getText().toString().trim().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            this.day = Integer.valueOf(split4[0].trim()).intValue();
            this.month = Integer.valueOf(split4[1].trim()).intValue();
            int intValue4 = Integer.valueOf(split4[2].trim()).intValue();
            this.year = intValue4;
            bundle4.putInt(AnonymousClass27.YEAR, intValue4);
            bundle4.putInt(AnonymousClass27.MONTH, this.month - 1);
            bundle4.putInt("day", this.day);
            datePickerFragment4.setArguments(bundle4);
            datePickerFragment4.setCallBack(this.endDatePickerListener);
            datePickerFragment4.show(getFragmentManager(), (String) "Date Picker");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.checkoutData = (Checkout) getArguments().getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) getArguments().getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
        this.settingsData = (Settings) getArguments().getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.pmiData = (r) getArguments().getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
        this.selectedVaultData = (c) getArguments().getSerializable(PaymentActivity.ARGUMENT_DATA_VAULT_DATA_INFO);
        this.singleModeSelected = Boolean.valueOf(getArguments().getBoolean(PaymentActivity.EXTRA_SINGLE_MODE_SELECTED, false));
        a aVar = new a();
        this.mService = aVar;
        this.mServiceManager = new d(aVar);
        resetCalendar();
        this.mapInstrumentAmountType.put("Variable", "M");
        this.mapInstrumentAmountType.put("Fixed", PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        Set<String> keySet = this.mapInstrumentAmountType.keySet();
        this.mapInstrumentFrequency.put("As and when presented", "ADHO");
        this.mapInstrumentFrequency.put("Bi- monthly", "BIMN");
        this.mapInstrumentFrequency.put("Daily", "DAIL");
        this.mapInstrumentFrequency.put("Monthly", "MNTH");
        this.mapInstrumentFrequency.put("Quarterly", "QURT");
        this.mapInstrumentFrequency.put("Semi annually", "MIAN");
        this.mapInstrumentFrequency.put("Weekly", "Week");
        this.mapInstrumentFrequency.put("Yearly", "YEAR");
        Set<String> keySet2 = this.mapInstrumentFrequency.keySet();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), 17367048, (String[]) keySet.toArray(new String[keySet.size()]));
        this.adapter_amountType = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(getActivity(), 17367048, (String[]) keySet2.toArray(new String[keySet2.size()]));
        this.adapter_frequency = arrayAdapter2;
        arrayAdapter2.setDropDownViewResource(17367049);
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_card", "layout", getActivity().getPackageName()), viewGroup, false);
        this.container_vault_card = (LinearLayout) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_container_vault_card", "id", inflate);
        this.container_new_card = (LinearLayout) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_container_fresh_card", "id", inflate);
        this.payButton = (Button) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_pay_btn", "id", inflate);
        this.cardNumber = (EditText) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_cardNumber", "id", inflate);
        ImageView imageView = (ImageView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_imageview", "id", inflate);
        this.ccImage = imageView;
        imageView.setVisibility(8);
        this.dateText = (EditText) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_dateText", "id", inflate);
        this.verification = (EditText) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_verificationText", "id", inflate);
        this.name = (EditText) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_nameText", "id", inflate);
        this.checkbox_vault_card = (CheckBox) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_checkbox_vault_card", "id", inflate);
        this.checkbox_si_new_card = (CheckBox) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_checkbox_si", "id", inflate);
        this.list = (ListView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_list", "id", inflate);
        this.paynimo_card_list_header = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_list_header", "id", inflate);
        this.tvSiInfoNewCard = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_si_info", "id", inflate);
        TextView textView = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_si_error_message_block", "id", inflate);
        this.tvSIErrorBlock = textView;
        textView.setVisibility(8);
        this.si_container_new_card = (ViewGroup) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_si_container", "id", inflate);
        this.etStartDateNewCard = (EditText) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_et_debit_start_date", "id", inflate);
        this.etEndDateNewCard = (EditText) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_et_debit_end_date", "id", inflate);
        this.etAmountDebitNewCard = (EditText) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_et_amount_debit", "id", inflate);
        this.n_si_container_new_card = (ViewGroup) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_si_non_edit_container", "id", inflate);
        this.n_etStartDateNewCard = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_n_et_debit_start_date", "id", inflate);
        this.n_etEndDateNewCard = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_n_et_debit_end_date", "id", inflate);
        this.n_etAmountDebitNewCard = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_n_et_amount_debit", "id", inflate);
        this.n_etAmountTypeNewCard = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_n_et_amountType", "id", inflate);
        this.n_etFrequencyNewCard = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_n_et_frequency", "id", inflate);
        this.ibStartDateNewCard = (ImageButton) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_eb_start_date", "id", inflate);
        this.ibEndDateNewCard = (ImageButton) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_eb_end_date", "id", inflate);
        this.spinner_amount_type_new_card = (Spinner) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_spinner_amountType", "id", inflate);
        this.spinner_frequency_new_card = (Spinner) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_spinner_frequency", "id", inflate);
        ScrollView scrollView = (ScrollView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_main_container", "id", inflate);
        this.paynimo_card_list_header = (TextView) GeneratedOutlineSupport.outline16(this, getResources(), "paynimo_card_list_header", "id", inflate);
        this.tvSiInfoNewCard.setOnClickListener(this);
        this.ibStartDateNewCard.setOnClickListener(this);
        this.ibEndDateNewCard.setOnClickListener(this);
        this.payButton.setOnClickListener(this);
        this.checkbox_vault_card.setOnCheckedChangeListener(this);
        this.checkbox_si_new_card.setOnCheckedChangeListener(this);
        this.list.setOnItemClickListener(this);
        this.list.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        this.checkbox_si_new_card.setVisibility(8);
        this.tvSiInfoNewCard.setVisibility(8);
        this.si_container_new_card.setVisibility(8);
        this.n_si_container_new_card.setVisibility(8);
        this.spinner_amount_type_new_card.setOnItemSelectedListener(this);
        this.spinner_frequency_new_card.setOnItemSelectedListener(this);
        Checkout checkout = this.checkoutData;
        if (!(checkout == null || this.pmiData == null)) {
            if (checkout.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                scrollView.setVisibility(4);
                String isRegistration = this.checkoutData.getMerchantRequestPayload().getTransaction().getIsRegistration();
                String verificationCode = this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getVerificationCode();
                if (PaymentModesActivity.isSIEnabledFromMerchant && GeneratedOutlineSupport.outline107(this.checkoutData, "Y")) {
                    this.checkbox_si_new_card.setChecked(true);
                    this.checkbox_si_new_card.setClickable(false);
                    this.checkbox_si_new_card.setAlpha(0.5f);
                }
                if (!this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getToken().equalsIgnoreCase("") || this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier().equalsIgnoreCase("")) {
                    this.calledFromPaymentModes = Boolean.TRUE;
                    startVaultedCardNetworkTask("00000", this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getToken(), verificationCode, true);
                } else {
                    String identifier = this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier();
                    String month2 = this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getExpiry().getMonth();
                    String year2 = this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getExpiry().getYear();
                    CardType cardType2 = CardType.getCardType(identifier, this.settingsData.getAllowedCardTypes());
                    this.cardType = cardType2;
                    if (cardType2 == CardType.YetUnknown || cardType2 == CardType.Invalid) {
                        ((PaymentActivity) getActivity()).transactionError(Constant.TAG_ERROR_CARD_VALIDATION_CODE, Constant.TAG_ERROR_CARD_VALIDATION);
                    } else {
                        this.cardDataType = cardType2.toString();
                        if (identifier == null || month2 == null || year2 == null || !CardValidator.validateDate((Context) getActivity(), month2, year2)) {
                            ((PaymentActivity) getActivity()).transactionError(Constant.TAG_ERROR_CARD_VALIDATION_CODE, Constant.TAG_ERROR_CARD_VALIDATION);
                        } else {
                            this.isTxnMerchantInitiated = true;
                            b bVar = new b();
                            this.data = bVar;
                            bVar.setConsumerInstrumentToken("");
                            this.data.setVaultConsumerInstrument(isRegistration);
                            this.data.setConsumerInstrumentIdentifier(this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getIdentifier());
                            this.data.setConsumerInstrumentHolderName(this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getHolder().getName());
                            this.data.setConsumerInstrumentExpiryMonth(this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getExpiry().getMonth());
                            this.data.setConsumerInstrumentExpiryYear(this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getExpiry().getYear());
                            this.data.setConsumerInstrumentCVC(verificationCode);
                            this.dataPasser.cardDataFromFragment(this.data);
                            startBinCheckTask(identifier.substring(0, 6), "", this.checkoutData.getMerchantRequestPayload().getPayment().getInstrument().getToken(), this.checkoutData.getMerchantRequestPayload().getTransaction().getIsRegistration(), this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getAction());
                        }
                    }
                }
            } else {
                getActivity().findViewById(getResources().getIdentifier("imageView1", "id", getActivity().getPackageName())).setVisibility(0);
                scrollView.setVisibility(0);
                prepareListData();
                setListData();
                if ((this.pmiData.getSIEnable().equalsIgnoreCase("S") || this.pmiData.getSIEnable().equalsIgnoreCase("SI")) && !GeneratedOutlineSupport.outline107(this.checkoutData, "D")) {
                    this.checkbox_si_new_card.setVisibility(0);
                    setInitialViewInstrumentValues(this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getAction(), true);
                }
                if (this.checkoutData.getMerchantRequestPayload().getConsumer().getIdentifier().equalsIgnoreCase("")) {
                    this.checkbox_vault_card.setChecked(false);
                    this.checkbox_vault_card.setClickable(false);
                    this.checkbox_vault_card.setAlpha(0.5f);
                }
                if (!this.singleModeSelected.booleanValue()) {
                    c cVar = this.selectedVaultData;
                    if (cVar == null) {
                        Constant.showOutputLog(FRAGMENT_TAG, "selectedVaultData is null");
                    } else if (cVar.getCardId().equalsIgnoreCase("")) {
                        this.container_new_card.setVisibility(0);
                        this.container_vault_card.setVisibility(8);
                    } else {
                        this.container_new_card.setVisibility(4);
                        this.container_vault_card.setVisibility(4);
                        String cardIssuerAuthority = this.selectedVaultData.getCardIssuerAuthority();
                        String cardId = this.selectedVaultData.getCardId();
                        String aliasName = this.selectedVaultData.getAliasName();
                        this.calledFromPaymentModes = Boolean.TRUE;
                        startVaultedCardNetworkTask(cardIssuerAuthority, cardId, aliasName, true);
                    }
                } else if (this.pmiData.getCustomerVault().getCardVaultCount() > 0) {
                    this.container_new_card.setVisibility(0);
                    this.container_vault_card.setVisibility(0);
                } else {
                    this.container_vault_card.setVisibility(8);
                }
            }
        }
        return inflate;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
        Constant.showOutputLog("==>>CardFragment", "onDetach");
    }

    @Subscribe
    public void onEvent(s sVar) {
        Constant.showOutputLog(FRAGMENT_TAG, "got TWD response");
        ((PaymentActivity) getActivity()).hideProgressLoader();
        if (sVar.getResponse() != null) {
            long outline13 = GeneratedOutlineSupport.outline13() - this.startTime.getTime();
            Checkout checkout = this.checkoutData;
            String str = this.issuer;
            String str2 = this.inputCardType;
            com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:CardSubmit", outline13, "PASS", checkout, "", "", str, str2, this.mServiceManager, getActivity());
            Constant.showOutputLog(FRAGMENT_TAG, sVar.getResponse().toString());
            try {
                if (sVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    h paymentMethod = sVar.getResponse().getPaymentMethod();
                    String responseType = sVar.getResponse().getResponseType();
                    String subType = paymentMethod.getAuthentication().getSubType();
                    if (responseType == null || responseType.trim().length() == 0) {
                        Constant.showOutputLog(FRAGMENT_TAG, "got NULL PaymentMethod value in Twd response");
                    } else if (subType == null || !subType.equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_3DS) || !responseType.equalsIgnoreCase("web")) {
                        Constant.showOutputLog(FRAGMENT_TAG, " Subtype is not 3ds=================>>>" + subType);
                    } else {
                        Constant.showOutputLog(FRAGMENT_TAG, "3DS condition verified");
                        prepareWebviewData(paymentMethod);
                    }
                } else if (this.checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y")) {
                    ((PaymentActivity) getActivity()).transactionError(sVar.getResponse().getPaymentMethod().getError().getCode(), sVar.getResponse().getPaymentMethod().getError().getDesc());
                } else {
                    if (!this.calledFromPaymentModes.booleanValue()) {
                        if (sVar.getResponse().getPaymentMethod().getAuthentication().getSubType().equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_STANDALONE)) {
                            if (this.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getAction().equalsIgnoreCase("Y")) {
                                this.tvSIErrorBlock.setVisibility(0);
                                this.tvSIErrorBlock.setText(sVar.getResponse().getPaymentMethod().getError().getDesc());
                                return;
                            }
                            return;
                        }
                    }
                    if (!this.calledFromPaymentModes.booleanValue() || !sVar.getResponse().getPaymentMethod().getAuthentication().getSubType().equalsIgnoreCase(Constant.TAG_CARD_SUBTYPE_STANDALONE)) {
                        ((PaymentActivity) getActivity()).transactionError(sVar.getResponse().getPaymentMethod().getError().getCode(), sVar.getResponse().getPaymentMethod().getError().getDesc());
                        return;
                    }
                    AlertDialog create = new Builder(getActivity(), getActivity().getResources().getIdentifier("DialogStylePaynimo", "style", getActivity().getPackageName())).create();
                    String desc = sVar.getResponse().getPaymentMethod().getError().getDesc();
                    AlertController alertController = create.mAlert;
                    alertController.mMessage = desc;
                    TextView textView = alertController.mMessageView;
                    if (textView != null) {
                        textView.setText(desc);
                    }
                    create.setButton(-3, "Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            CardFragment.this.getActivity().setResult(-3);
                            CardFragment.this.getActivity().finish();
                        }
                    });
                    create.show();
                }
            } catch (Exception unused) {
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            long outline132 = GeneratedOutlineSupport.outline13() - this.startTime.getTime();
            Checkout checkout2 = this.checkoutData;
            String str3 = this.issuer;
            String str4 = this.inputCardType;
            com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:CardSubmit", outline132, GopayLinkingHandler.STATUS_FAIL, checkout2, "", "", str3, str4, this.mServiceManager, getActivity());
            Constant.showOutputLog(FRAGMENT_TAG, "Null TWD response");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.isDialogShown) {
            openVaultDialog(view, i);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>CardFragment", "onPause");
        this.cardNumber.removeTextChangedListener(this.CCTextWatcher);
        this.dateText.removeTextChangedListener(this.dateTextWatcher);
        this.verification.removeTextChangedListener(this.validationTextWatcher);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 11) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(0));
        for (int i2 = 0; i2 < strArr.length; i2++) {
            hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
        if (((Integer) hashMap.get("android.permission.READ_PHONE_STATE")).intValue() == 0) {
            this.canReadPhoneState = true;
        } else {
            this.canReadPhoneState = false;
        }
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>CardFragment", "onResume");
        if (VERSION.SDK_INT < 23) {
            this.canReadPhoneState = true;
        } else if (!isPermissionAsked) {
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (!addPermission(arrayList2, "android.permission.READ_PHONE_STATE")) {
                arrayList.add(PERMISSION_READ_PHONE_STATE);
            }
            if (arrayList2.size() > 0) {
                if (!arrayList2.contains("android.permission.READ_PHONE_STATE")) {
                    this.canReadPhoneState = true;
                }
                if (arrayList.size() > 0) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("You need to grant access to ");
                    outline73.append((String) arrayList.get(0));
                    String sb = outline73.toString();
                    for (int i = 1; i < arrayList.size(); i++) {
                        StringBuilder outline78 = GeneratedOutlineSupport.outline78(sb, ", ");
                        outline78.append((String) arrayList.get(i));
                        sb = outline78.toString();
                    }
                    showMessageOKCancel(sb, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            CardFragment.isPermissionAsked = true;
                            CardFragment cardFragment = CardFragment.this;
                            List list = arrayList2;
                            cardFragment.requestPermissions((String[]) list.toArray(new String[list.size()]), 11);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (arrayList2.contains("android.permission.READ_PHONE_STATE")) {
                                CardFragment.this.canReadPhoneState = false;
                            }
                        }
                    });
                    return;
                }
                isPermissionAsked = true;
                requestPermissions((String[]) arrayList2.toArray(new String[arrayList2.size()]), 11);
                return;
            } else if (com.paynimo.android.payment.util.d.checkPermission(getActivity(), "android.permission.READ_PHONE_STATE")) {
                this.canReadPhoneState = true;
            } else {
                this.canReadPhoneState = false;
            }
        } else if (com.paynimo.android.payment.util.d.checkPermission(getActivity(), "android.permission.READ_PHONE_STATE")) {
            this.canReadPhoneState = true;
        } else {
            this.canReadPhoneState = false;
        }
        this.cardNumber.addTextChangedListener(this.CCTextWatcher);
        this.dateText.addTextChangedListener(this.dateTextWatcher);
        this.verification.addTextChangedListener(this.validationTextWatcher);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("KEY_SI_NON_VIEW", this.isSINonEditableViewVisible.booleanValue());
        bundle.putBoolean("KEY_SI_ENABLED_FRM_MRCHT", this.isSIEnabledFromMerchantScreeen.booleanValue());
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

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.r rVar) {
        ((PaymentActivity) getActivity()).hideProgressLoader();
        com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:CardSubmit", new Date().getTime() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "", "", this.issuer, this.inputCardType, this.mServiceManager, getActivity());
        ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, rVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.b bVar) {
        Constant.showOutputLog(FRAGMENT_TAG, "got Bin Check response");
        if (bVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkoutData, "", "", "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog(FRAGMENT_TAG, bVar.getResponse().toString());
            try {
                if (bVar.getResponse().getAllowed() != null) {
                    String allowed = bVar.getResponse().getAllowed();
                    if (allowed.isEmpty() || !allowed.equalsIgnoreCase("yes")) {
                        this.isCardBinValid = false;
                        showBinCheckError();
                    } else {
                        this.isCardBinValid = true;
                        if (bVar.getResponse().getCard_issuer_authority() != null && !bVar.getResponse().getCard_issuer_authority().isEmpty()) {
                            this.issuer = bVar.getResponse().getCard_issuer_authority();
                        }
                        if (bVar.getResponse().getCard_type() != null && !bVar.getResponse().getCard_type().isEmpty()) {
                            this.inputCardType = bVar.getResponse().getCard_type();
                        }
                    }
                    if (!this.isTxnMerchantInitiated) {
                        return;
                    }
                    if (this.isCardBinValid) {
                        startCardNetworkTask("00000");
                    } else {
                        ((PaymentActivity) getActivity()).transactionError(Constant.TAG_ERROR_CARD_VALIDATION_CODE, Constant.TAG_ERROR_CARD_VALIDATION);
                    }
                } else {
                    this.isCardBinValid = true;
                }
            } catch (Exception unused) {
                this.isCardBinValid = true;
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "", "", "", "", this.mServiceManager, getActivity());
            this.isCardBinValid = true;
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.a aVar) {
        this.isCardBinValid = false;
        com.paynimo.android.payment.util.b.callEventLogging("", "load", "Cards:CONSOLIDATED_BIN_CHECK", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "", "", "", "", this.mServiceManager, getActivity());
        showBinCheckError();
    }
}
