package com.paynimo.android.payment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.CardTypeParser.CardType;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.g;
import com.paynimo.android.payment.event.n;
import com.paynimo.android.payment.event.o;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.ResponsePayload;
import com.paynimo.android.payment.model.response.h;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.network.NetworkStateReceiver;
import com.paynimo.android.payment.util.Constant;
import com.paynimo.android.payment.util.b;
import com.paynimo.android.payment.util.c;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class PaymentActivity extends EventedBaseActivity implements IntfOnFragmentDataPass {
    public static final String ACTIVE_FRAGMENT_TAG_KEY = "activeFragmentTagKey";
    public static final String ARGUMENT_DATA_VAULT_DATA_INFO = "vaultedDataInfo";
    public static final String CARD_I_AUTHORITY_AMEX = "AMEX";
    public static final String CARD_I_AUTHORITY_DINER = "DINER";
    public static final String CARD_I_AUTHORITY_DISCOVER = "DISCOVER";
    public static final String CARD_I_AUTHORITY_IP = "IP";
    public static final String CARD_I_AUTHORITY_JCB = "JCB";
    public static final String CARD_I_AUTHORITY_LASER = "LASER";
    public static final String CARD_I_AUTHORITY_MAESTRO = "MAESTRO";
    public static final String CARD_I_AUTHORITY_MC = "MC";
    public static final String CARD_I_AUTHORITY_RUPAY = "RUPAY";
    public static final String CARD_I_AUTHORITY_UP = "UP";
    public static final String CARD_I_AUTHORITY_VISA = "VISA";
    public static String ConsumerInstrumentCVC = "";
    public static String ConsumerInstrumentExpiryMonth = "";
    public static String ConsumerInstrumentExpiryYear = "";
    public static String ConsumerInstrumentHolderName = "";
    public static String ConsumerInstrumentIdentifier = "";
    public static String ConsumerInstrumentToken = "";
    public static final String EXTRA_PUBLIC_KEY = "paynimo.payment.publicKey";
    public static final String EXTRA_REQUESTED_PAYMENT_MODE = "paynimo.payment.requestedPaymentMode";
    public static final String EXTRA_SINGLE_MODE_SELECTED = "paynimo.payment.singleMode";
    public static final String PAYMENT_METHOD_CARDS = "Cards";
    public static final String PAYMENT_METHOD_CASHCARDS = "CashCards";
    public static final String PAYMENT_METHOD_CUSTOMERVAULTS = "CustomerVault";
    public static final String PAYMENT_METHOD_DEFAULT = "All";
    public static final String PAYMENT_METHOD_DIGITALMANDATE = "Digital Mandate";
    public static final String PAYMENT_METHOD_EMI = "EMI";
    public static final String PAYMENT_METHOD_IMPS = "IMPS";
    public static final String PAYMENT_METHOD_MVISA = "Pay with QR Code";
    public static final String PAYMENT_METHOD_NETBANKING = "Netbanking";
    public static final String PAYMENT_METHOD_UPI = "UPI";
    public static final String PAYMENT_METHOD_WALLETS = "Wallet";
    public static final int REQUEST_CODE = 7281;
    public static final int RESULT_BACKPRESSED = -3;
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_ERROR = -2;
    public static final int RESULT_OK = -1;
    public static final int RESULT_PENDING = -4;
    public static final String RETURN_ERROR_CODE = "error_code";
    public static final String RETURN_ERROR_DESCRIPTION = "error_description";
    public static final String STATUS_SUCCESS = "0300";
    public static final String TAG = "PaymentAct";
    public static final String TRANSACTION_STATUS_DIGITAL_MANDATE_SUCCESS = "0398";
    public static final String TRANSACTION_STATUS_PREAUTH_RESERVE_SUCCESS = "0200";
    public static final String TRANSACTION_STATUS_SALES_DEBIT_SUCCESS = "0300";
    public static final String TRANSACTION_SUBTYPE_DEBIT = "DEBIT";
    public static final String TRANSACTION_SUBTYPE_RESERVE = "RESERVE";
    public static final String TRANSACTION_TYPE_PREAUTH = "PREAUTH";
    public static final String TRANSACTION_TYPE_SALE = "SALE";
    public static String VaultConsumerInstrument = "";
    public static Context application_context;
    public Bundle PaymentSettingsBundle;
    public String activeFragmentTag = "noFragment";
    public Context activitycontxt = this;
    public CardFragment cardFragment;
    public CashCardFragment cashcardFragment;
    public Checkout checkout;
    public boolean consumable;
    public CustomerVaultsFragment customerVaultsFragment;
    public EMIFragment emiFragment;
    public IMPSFragment impsFragment;
    public boolean isSafestoreEnabled;
    public a mService;
    public d mServiceManager;
    public MVISAFragment mVisaFragment;
    public NetBankingFragment netbankingFragment;
    public Settings paymentSettings;
    public PaymentType paymentType;
    public r pmiData;
    public String publickey;
    public RequestPayload request_payload;
    public String requestedPaymentMethod;
    public c resultType;
    public com.paynimo.android.payment.model.response.k.c selectedVaultData;
    public Boolean singleModeSelected;
    public Date startTime;
    public UPIFragment upiFragment;
    public WalletFragment walletFragment;
    public WebView webView;

    /* renamed from: com.paynimo.android.payment.PaymentActivity$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$paynimo$android$payment$PaymentActivity$PaymentType;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                com.paynimo.android.payment.PaymentActivity$PaymentType[] r0 = com.paynimo.android.payment.PaymentActivity.PaymentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$paynimo$android$payment$PaymentActivity$PaymentType = r0
                r1 = 1
                r2 = 2
                com.paynimo.android.payment.PaymentActivity$PaymentType r3 = com.paynimo.android.payment.PaymentActivity.PaymentType.TRANSACTION     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 3
                int[] r3 = $SwitchMap$com$paynimo$android$payment$PaymentActivity$PaymentType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.paynimo.android.payment.PaymentActivity$PaymentType r4 = com.paynimo.android.payment.PaymentActivity.PaymentType.PREAUTHORIZATION     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r2 = $SwitchMap$com$paynimo$android$payment$PaymentActivity$PaymentType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.paynimo.android.payment.PaymentActivity$PaymentType r3 = com.paynimo.android.payment.PaymentActivity.PaymentType.TOKEN     // Catch:{ NoSuchFieldError -> 0x001d }
                r3 = 0
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$paynimo$android$payment$PaymentActivity$PaymentType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.paynimo.android.payment.PaymentActivity$PaymentType r2 = com.paynimo.android.payment.PaymentActivity.PaymentType.TOKEN_WITH_PARAMS     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.PaymentActivity.AnonymousClass6.<clinit>():void");
        }
    }

    public static class Factory {
        public static Intent getAuthorizationIntent(Context context, boolean z) {
            PaymentActivity.application_context = context;
            Settings settings = new Settings();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.ARGUMENT_DATA_SETTING, settings);
            Intent intent = new Intent(context, PaymentActivity.class);
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
            Context context = PaymentActivity.application_context;
            if (context != null) {
                CardTypeParser.setContext(context);
            }
        }

        public Settings() {
            CardTypeParser.setContext(PaymentActivity.application_context);
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

    private void addListeners() {
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [int] */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v14, types: [com.paynimo.android.payment.b.d] */
    /* JADX WARNING: type inference failed for: r2v11, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v3
      assigns: []
      uses: []
      mth insns count: 72
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 12 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void callTarRequest(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r14 = r16
            java.lang.String r15 = "DEFAULT ERROR"
            java.lang.String r13 = "ERROR_PAYNIMO_003"
            android.content.Context r0 = r14.activitycontxt     // Catch:{ Exception -> 0x007e }
            boolean r0 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r0)     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x006b
            com.paynimo.android.payment.model.Checkout r0 = r14.checkout     // Catch:{ Exception -> 0x0058 }
            if (r0 == 0) goto L_0x0088
            java.lang.String r1 = "PaymentAct"
            java.lang.String r2 = " Start TAR response"
            com.paynimo.android.payment.util.Constant.showOutputLog(r1, r2)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = ""
            java.lang.String r2 = "txnResponse"
            java.lang.String r3 = "txnResponse:received"
            r4 = 0
            java.lang.String r6 = "PASS"
            com.paynimo.android.payment.model.Checkout r7 = r14.checkout     // Catch:{ Exception -> 0x0058 }
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            com.paynimo.android.payment.b.d r12 = r14.mServiceManager     // Catch:{ Exception -> 0x0058 }
            r18 = r15
            r15 = r13
            r13 = r16
            com.paynimo.android.payment.util.b.callEventLogging(r1, r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0056 }
            java.util.Date r1 = new java.util.Date     // Catch:{ Exception -> 0x0056 }
            r1.<init>()     // Catch:{ Exception -> 0x0056 }
            r14.startTime = r1     // Catch:{ Exception -> 0x0056 }
            java.lang.String r1 = "TAR"
            r0.setTransactionRequestType(r1)     // Catch:{ Exception -> 0x0056 }
            r1 = r17
            r0.setTransactionDescription(r1)     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.model.request.RequestPayload r0 = r0.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0056 }
            r14.request_payload = r0     // Catch:{ Exception -> 0x0056 }
            com.paynimo.android.payment.b.d r1 = r14.mServiceManager     // Catch:{ Exception -> 0x0056 }
            android.content.Context r2 = r14.activitycontxt     // Catch:{ Exception -> 0x0056 }
            r1.callTARRequest(r0, r2)     // Catch:{ Exception -> 0x0056 }
            goto L_0x0088
        L_0x0056:
            r0 = move-exception
            goto L_0x005c
        L_0x0058:
            r0 = move-exception
            r18 = r15
            r15 = r13
        L_0x005c:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0066 }
            r1 = r18
            r2 = -2
            r14.showAlertDialog(r2, r15, r1)     // Catch:{ Exception -> 0x007c }
            goto L_0x0088
        L_0x0066:
            r0 = move-exception
            r1 = r18
            r2 = -2
            goto L_0x0082
        L_0x006b:
            r1 = r15
            r2 = -2
            r15 = r13
            de.greenrobot.event.EventBus r0 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x007c }
            com.paynimo.android.payment.event.g r3 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x007c }
            r4 = 0
            r3.<init>(r4)     // Catch:{ Exception -> 0x007c }
            r0.post(r3)     // Catch:{ Exception -> 0x007c }
            goto L_0x0088
        L_0x007c:
            r0 = move-exception
            goto L_0x0082
        L_0x007e:
            r0 = move-exception
            r1 = r15
            r2 = -2
            r15 = r13
        L_0x0082:
            r0.printStackTrace()
            r14.showAlertDialog(r2, r15, r1)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.PaymentActivity.callTarRequest(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void finishActivityForChangeInPaymentMode() {
        b.callEventLogging("", "click", "button:Back", 0, "PASS", this.checkout, "", "", "", "", this.mServiceManager, this);
        setResult(-3, new Intent());
        finish();
    }

    private void initialiseView() {
        findViewById(getResources().getIdentifier("imageView1", "id", getPackageName())).setVisibility(8);
        this.webView = (WebView) findViewById(getResources().getIdentifier("paynimo_webview", "id", getPackageName()));
    }

    private void loadSettings(Bundle bundle) {
        Settings settings = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.paymentSettings = settings;
        this.isSafestoreEnabled = settings.isSafeStoreEnabled();
        Bundle bundle2 = new Bundle();
        this.PaymentSettingsBundle = bundle2;
        bundle2.putParcelable(Constant.ARGUMENT_DATA_SETTING, this.paymentSettings);
        this.paymentType = PaymentType.TRANSACTION;
        this.resultType = c.TRANSACTION;
    }

    private void openFragment(String str) {
        Constant.showOutputLog("==>>PaymentAct", "selected Fragment :" + str);
        if (str.equalsIgnoreCase(PAYMENT_METHOD_CARDS)) {
            CardFragment cardFragment2 = (CardFragment) getSupportFragmentManager().findFragmentByTag(CardFragment.FRAGMENT_TAG);
            this.cardFragment = cardFragment2;
            if (cardFragment2 == null) {
                this.cardFragment = CardFragment.instance(this.paymentSettings, this.checkout, this.pmiData, this.singleModeSelected, this.selectedVaultData);
            }
            replaceFragments(this.cardFragment, CardFragment.FRAGMENT_TAG);
        } else if (str.equalsIgnoreCase(PAYMENT_METHOD_NETBANKING)) {
            NetBankingFragment netBankingFragment = (NetBankingFragment) getSupportFragmentManager().findFragmentByTag(NetBankingFragment.FRAGMENT_TAG);
            this.netbankingFragment = netBankingFragment;
            if (netBankingFragment == null) {
                this.netbankingFragment = NetBankingFragment.instance(this.checkout, this.pmiData);
            }
            replaceFragments(this.netbankingFragment, NetBankingFragment.FRAGMENT_TAG);
        } else if (str.equalsIgnoreCase("IMPS")) {
            IMPSFragment iMPSFragment = (IMPSFragment) getSupportFragmentManager().findFragmentByTag("IMPS");
            this.impsFragment = iMPSFragment;
            if (iMPSFragment == null) {
                this.impsFragment = IMPSFragment.instance(this.checkout, this.pmiData, this.singleModeSelected, this.selectedVaultData);
            }
            replaceFragments(this.impsFragment, "IMPS");
        } else if (str.equalsIgnoreCase(PAYMENT_METHOD_WALLETS)) {
            WalletFragment walletFragment2 = (WalletFragment) getSupportFragmentManager().findFragmentByTag(WalletFragment.FRAGMENT_TAG);
            this.walletFragment = walletFragment2;
            if (walletFragment2 == null) {
                this.walletFragment = WalletFragment.instance(this.checkout, this.pmiData);
            }
            replaceFragments(this.walletFragment, WalletFragment.FRAGMENT_TAG);
        } else if (str.equalsIgnoreCase(PAYMENT_METHOD_CASHCARDS)) {
            CashCardFragment cashCardFragment = (CashCardFragment) getSupportFragmentManager().findFragmentByTag("CashCard");
            this.cashcardFragment = cashCardFragment;
            if (cashCardFragment == null) {
                this.cashcardFragment = CashCardFragment.instance(this.checkout, this.pmiData);
            }
            replaceFragments(this.cashcardFragment, "CashCard");
        } else if (str.equalsIgnoreCase(PAYMENT_METHOD_CUSTOMERVAULTS)) {
            CustomerVaultsFragment customerVaultsFragment2 = (CustomerVaultsFragment) getSupportFragmentManager().findFragmentByTag("CashCard");
            this.customerVaultsFragment = customerVaultsFragment2;
            if (customerVaultsFragment2 == null) {
                this.customerVaultsFragment = CustomerVaultsFragment.instance(this.checkout, this.pmiData);
            }
            replaceFragments(this.customerVaultsFragment, "CashCard");
        } else if (str.equalsIgnoreCase("EMI")) {
            EMIFragment eMIFragment = (EMIFragment) getSupportFragmentManager().findFragmentByTag("EMI");
            this.emiFragment = eMIFragment;
            if (eMIFragment == null) {
                this.emiFragment = EMIFragment.instance(this.checkout, this.pmiData);
            }
            replaceFragments(this.emiFragment, "EMI");
        } else if (str.equalsIgnoreCase("UPI")) {
            UPIFragment uPIFragment = (UPIFragment) getSupportFragmentManager().findFragmentByTag("EMI");
            this.upiFragment = uPIFragment;
            if (uPIFragment == null) {
                this.upiFragment = UPIFragment.instance(this.checkout, this.pmiData);
            }
            replaceFragments(this.upiFragment, "UPI");
        } else if (str.equalsIgnoreCase(PAYMENT_METHOD_MVISA)) {
            MVISAFragment mVISAFragment = (MVISAFragment) getSupportFragmentManager().findFragmentByTag(MVISAFragment.FRAGMENT_TAG);
            this.mVisaFragment = mVISAFragment;
            if (mVISAFragment == null) {
                this.mVisaFragment = MVISAFragment.instance(this.checkout, this.pmiData);
            }
            replaceFragments(this.mVisaFragment, MVISAFragment.FRAGMENT_TAG);
        } else {
            Constant.showOutputLog(TAG, "=====>>> No Payment Mode is available");
        }
    }

    private void retrieveSavedInstanceData(Bundle bundle) {
        this.activeFragmentTag = bundle.getString(ACTIVE_FRAGMENT_TAG_KEY);
        this.paymentSettings = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.checkout = (Checkout) bundle.getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) bundle.getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
    }

    private void setListeners() {
    }

    private void showBackPressedDialog() {
        final Dialog dialog = new Dialog(this.activitycontxt);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_text", "id", getApplicationContext().getPackageName()))).setText(getResources().getString(getResources().getIdentifier("paynimo_back_press_dialog_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonOK", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                PaymentActivity.this.transactionCancelled();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void cardDataFromFragment(com.paynimo.android.payment.model.b bVar) {
        ConsumerInstrumentToken = bVar.getConsumerInstrumentToken();
        VaultConsumerInstrument = bVar.getVaultConsumerInstrument();
        ConsumerInstrumentIdentifier = bVar.getConsumerInstrumentIdentifier();
        ConsumerInstrumentHolderName = bVar.getConsumerInstrumentHolderName();
        ConsumerInstrumentExpiryMonth = bVar.getConsumerInstrumentExpiryMonth();
        ConsumerInstrumentExpiryYear = bVar.getConsumerInstrumentExpiryYear();
        ConsumerInstrumentCVC = bVar.getConsumerInstrumentCVC();
    }

    public void hideProgressLoader() {
        findViewById(getResources().getIdentifier("application_header", "id", getPackageName())).setVisibility(0);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
        findViewById(getResources().getIdentifier("paynimo_payment_fragmentHolder", "id", getPackageName())).setVisibility(0);
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(8);
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
                        Checkout checkout2 = this.checkout;
                        if (checkout2 == null || checkout2.getMerchantRequestPayload().getTransaction().getDeviceIdentifier() == null || !this.checkout.getMerchantRequestPayload().getTransaction().getDeviceIdentifier().equalsIgnoreCase("Android")) {
                            Intent intent2 = new Intent();
                            Checkout checkout3 = new Checkout();
                            checkout3.setMerchantResponse(stringExtra);
                            checkout3.setMerchantIdentifier(stringExtra2);
                            intent2.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout3);
                            setResult(-1, intent2);
                            finish();
                            return;
                        }
                        callTarRequest(stringExtra, stringExtra2);
                    }
                }
            } else if (i2 == -2) {
                transactionError(intent.getStringExtra(RETURN_ERROR_CODE), intent.getStringExtra("error_description"));
            } else if (i2 == 0) {
                transactionCancelled();
            } else if (i2 == -3) {
                finishActivityForChangeInPaymentMode();
            }
        }
    }

    public void onBackPressed() {
        finishActivityForChangeInPaymentMode();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getResources().getIdentifier("paynimo_activity_payment", "layout", getApplicationContext().getPackageName()));
        Bundle extras = getIntent().getExtras();
        Intent intent = getIntent();
        if (CardTypeParser.getContext() == null) {
            application_context = getApplicationContext();
        }
        if (intent != null) {
            this.checkout = (Checkout) intent.getSerializableExtra(Constant.ARGUMENT_DATA_CHECKOUT);
            this.pmiData = (r) intent.getSerializableExtra(Constant.ARGUMENT_DATA_PMI_RESPONSE);
            this.selectedVaultData = (com.paynimo.android.payment.model.response.k.c) intent.getSerializableExtra(ARGUMENT_DATA_VAULT_DATA_INFO);
            this.publickey = intent.getStringExtra(EXTRA_PUBLIC_KEY);
            this.requestedPaymentMethod = intent.getStringExtra(EXTRA_REQUESTED_PAYMENT_MODE);
            this.singleModeSelected = Boolean.valueOf(intent.getBooleanExtra(EXTRA_SINGLE_MODE_SELECTED, false));
            a aVar = new a();
            this.mService = aVar;
            this.mServiceManager = new d(aVar);
        }
        initialiseView();
        addListeners();
        loadSettings(extras);
        if (bundle != null) {
            retrieveSavedInstanceData(bundle);
        }
        String str = this.requestedPaymentMethod;
        if (str != null && !str.isEmpty()) {
            openFragment(this.requestedPaymentMethod);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Constant.showOutputLog("==>>PaymentAct", "onDestroy");
    }

    @Subscribe
    public void onEvent(o oVar) {
        Constant.showOutputLog(TAG, "got TAR response");
        if (oVar.getResponse() != null) {
            b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkout, "", "", "", "", this.mServiceManager, this);
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
            } catch (Exception e2) {
                e2.printStackTrace();
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, "Null TAR response");
        }
    }

    public void onEventMainThread(g gVar) {
        if (!gVar.isInternetConnected()) {
            Toast.makeText(this, "No Internet connection!", 0).show();
            Constant.showOutputLog(TAG, "No Internet connection!");
        }
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>PaymentAct", "onPause");
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.activeFragmentTag = bundle.getString(ACTIVE_FRAGMENT_TAG_KEY);
        this.paymentSettings = (Settings) bundle.getParcelable(Constant.ARGUMENT_DATA_SETTING);
        this.checkout = (Checkout) bundle.getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        this.pmiData = (r) bundle.getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>PaymentAct", "onResume");
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(ACTIVE_FRAGMENT_TAG_KEY, this.activeFragmentTag);
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, this.checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, this.pmiData);
        bundle.putParcelable(Constant.ARGUMENT_DATA_SETTING, this.paymentSettings);
        super.onSaveInstanceState(bundle);
    }

    public void replaceFragments(Fragment fragment, String str) {
        if (!this.activeFragmentTag.equals(str)) {
            this.activeFragmentTag = str;
            try {
                getSupportFragmentManager().beginTransaction().replace(getResources().getIdentifier("paynimo_payment_fragmentHolder", "id", getApplicationContext().getPackageName()), fragment, str).commit();
            } catch (Exception unused) {
            }
        }
    }

    public void sendResponseBackFromActivity(int i, String str, String str2) {
        Intent intent = new Intent();
        if (i == -1) {
            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, new Checkout());
            setResult(i, intent);
            finish();
        }
        if (i == -2) {
            transactionError(str, str2);
        }
        if (i == 0) {
            setResult(i, intent);
            finish();
        }
    }

    public void sendResponseBackFromFragment(ResponsePayload responsePayload, int i, String str) {
        Intent intent = new Intent();
        if (i == -1) {
            Checkout checkout2 = new Checkout();
            checkout2.setMerchantResponsePayload(responsePayload);
            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout2);
        }
        if (i == -2) {
            intent.putExtra(PushMessageHelper.ERROR_MESSAGE, str);
        }
        setResult(i, intent);
        finish();
    }

    public void showAlertDialog(int i, final String str, final String str2) {
        final Dialog dialog = new Dialog(this.activitycontxt);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_text", "id", getApplicationContext().getPackageName()))).setText(getResources().getString(getResources().getIdentifier("paynimo_payments_error", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonOK", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                PaymentActivity.this.finishActivityForChangeInPaymentMode();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                PaymentActivity.this.transactionError(str, str2);
            }
        });
        dialog.show();
    }

    public void showProgressLoader() {
        findViewById(getResources().getIdentifier("application_header", "id", getPackageName())).setVisibility(8);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        findViewById(getResources().getIdentifier("paynimo_payment_fragmentHolder", "id", getPackageName())).setVisibility(8);
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(0);
        this.webView.loadUrl("file:///android_asset/paynimo_loader_gif.gif");
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

    public void startDeRegisterCardNetworkTask(String str) {
        if (str == null || str.isEmpty()) {
            Constant.showOutputLog(TAG, " BankCode is EMPTY or NULL");
            return;
        }
        try {
            if (NetworkStateReceiver.isOnline(this)) {
                try {
                    if (this.checkout != null) {
                        this.checkout.setTransactionRequestType(Constant.REQUEST_TYPE_CDR);
                        this.checkout.setPaymentMethodType("C");
                        this.checkout.setTransactionIsRegistration("N");
                        this.checkout.setPaymentInstrumentToken(str);
                        RequestPayload merchantRequestPayload = this.checkout.getMerchantRequestPayload();
                        this.request_payload = merchantRequestPayload;
                        this.mServiceManager.callCardDeregisterRequest(merchantRequestPayload, this);
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

    public void transactionCancelled() {
        setResult(0, new Intent());
        finish();
    }

    public void transactionError(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra(RETURN_ERROR_CODE, str);
        intent.putExtra("error_description", str2);
        setResult(-2, intent);
        finish();
    }

    @Subscribe
    public void onEvent(n nVar) {
        b.callEventLogging(Constant.REQUEST_TYPE_TAR, "decryptedResponse", "decryptedTxnResponse:received", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkout, "", "", "", "", this.mServiceManager, this);
        transactionError(Constant.TAG_ERROR_NETWORK_ERROR_CODE, nVar.getError().getDesc());
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.d dVar) {
        Constant.showOutputLog(TAG, "got CDR response");
        if (dVar.getResponse() != null) {
            Constant.showOutputLog(TAG, dVar.getResponse().toString());
            try {
                if (dVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    h paymentMethod = dVar.getResponse().getPaymentMethod();
                    if (paymentMethod == null) {
                        Constant.showOutputLog(TAG, "got NULL PaymentMethod value in CDR response");
                    } else if (paymentMethod.getPaymentTransaction().getStatusCode().equalsIgnoreCase("0300")) {
                        String instrumentToken = paymentMethod.getInstrumentToken();
                        Iterator<com.paynimo.android.payment.model.response.k.c> it = this.cardFragment.vaultedCardsData.iterator();
                        while (it.hasNext()) {
                            com.paynimo.android.payment.model.response.k.c next = it.next();
                            if (next.getCardId().equals(instrumentToken)) {
                                this.cardFragment.vaultedCardsData.remove(next);
                                this.cardFragment.adapter.notifyDataSetChanged();
                                return;
                            }
                        }
                    } else {
                        showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
                    }
                } else {
                    transactionError(dVar.getResponse().getPaymentMethod().getError().getCode(), dVar.getResponse().getPaymentMethod().getError().getDesc());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            Constant.showOutputLog(TAG, "Null CDR response");
        }
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.c cVar) {
        showAlertDialog(-2, Constant.TAG_ERROR_NETWORK_ERROR_CODE, cVar.getError().getDesc());
    }
}
