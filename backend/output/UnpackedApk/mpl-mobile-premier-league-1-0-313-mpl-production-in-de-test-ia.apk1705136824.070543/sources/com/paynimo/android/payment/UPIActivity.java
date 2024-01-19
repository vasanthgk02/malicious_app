package com.paynimo.android.payment;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.a.g;
import com.paynimo.android.payment.a.g.b;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.k;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.request.t;
import com.paynimo.android.payment.model.response.j;
import com.paynimo.android.payment.util.Constant;
import de.greenrobot.event.Subscribe;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class UPIActivity extends EventedBaseActivity {
    public static final int CALL_UPI = 1;
    public static final String TAG = "UPIAct";
    public Adapter adapter;
    public Checkout checkoutData;
    public LayoutManager layoutManager;
    public a mService;
    public d mServiceManager;
    public RequestPayload request_payload;
    public Date startTime;
    public String txnID;
    public RecyclerView upiList;
    public String uri;
    public WebView webView;

    /* access modifiers changed from: private */
    public void finishActivityForChangeInPaymentMode() {
        setResult(-3, new Intent());
        finish();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        showAlertDialog(com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00c7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void makeSVAbortCall() {
        /*
            r5 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            boolean r2 = com.paynimo.android.payment.network.NetworkStateReceiver.isOnline(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r2 == 0) goto L_0x00cb
            com.paynimo.android.payment.model.Checkout r2 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            if (r2 == 0) goto L_0x00dc
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x00c7 }
            r2.<init>()     // Catch:{ Exception -> 0x00c7 }
            r5.startTime = r2     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.Checkout r2 = new com.paynimo.android.payment.model.Checkout     // Catch:{ Exception -> 0x00c7 }
            r2.<init>()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r3.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.o r3 = r3.getMerchant()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r3.getIdentifier()     // Catch:{ Exception -> 0x00c7 }
            r2.setMerchantIdentifier(r3)     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r3.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.s r3 = r3.getTransaction()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r3.getDeviceIdentifier()     // Catch:{ Exception -> 0x00c7 }
            r2.setTransactionDeviceIdentifier(r3)     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r3.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.s r3 = r3.getTransaction()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r3.getAmount()     // Catch:{ Exception -> 0x00c7 }
            r2.setTransactionAmount(r3)     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r3.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.s r3 = r3.getTransaction()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r3.getCurrency()     // Catch:{ Exception -> 0x00c7 }
            r2.setTransactionCurrency(r3)     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r3.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.s r3 = r3.getTransaction()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r3.getIdentifier()     // Catch:{ Exception -> 0x00c7 }
            r2.setTransactionIdentifier(r3)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = "ABORT"
            r2.setTransactionType(r3)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r5.txnID     // Catch:{ Exception -> 0x00c7 }
            if (r3 == 0) goto L_0x008f
            java.lang.String r3 = r5.txnID     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "TPS"
            boolean r3 = r3.startsWith(r4)     // Catch:{ Exception -> 0x00c7 }
            if (r3 == 0) goto L_0x008a
            java.lang.String r3 = r5.txnID     // Catch:{ Exception -> 0x00c7 }
            r4 = 3
            java.lang.String r3 = r3.substring(r4)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x008c
        L_0x008a:
            java.lang.String r3 = r5.txnID     // Catch:{ Exception -> 0x00c7 }
        L_0x008c:
            r2.setTransactionToken(r3)     // Catch:{ Exception -> 0x00c7 }
        L_0x008f:
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r3.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.s r3 = r3.getTransaction()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r3.getDateTime()     // Catch:{ Exception -> 0x00c7 }
            r2.setTransactionDateTime(r3)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = "SV"
            r2.setTransactionRequestType(r3)     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.Checkout r3 = r5.checkoutData     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r3.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.d r3 = r3.getConsumer()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = r3.getIdentifier()     // Catch:{ Exception -> 0x00c7 }
            r2.setConsumerIdentifier(r3)     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r2 = r2.getMerchantRequestPayload()     // Catch:{ Exception -> 0x00c7 }
            r5.request_payload = r2     // Catch:{ Exception -> 0x00c7 }
            r5.showProgressLoader()     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.b.d r2 = r5.mServiceManager     // Catch:{ Exception -> 0x00c7 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r5.request_payload     // Catch:{ Exception -> 0x00c7 }
            r2.callSVAbortRequest(r3, r5)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00dc
        L_0x00c7:
            r5.showAlertDialog(r1, r0)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dc
        L_0x00cb:
            de.greenrobot.event.EventBus r2 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x00d9 }
            com.paynimo.android.payment.event.g r3 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x00d9 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ Exception -> 0x00d9 }
            r2.post(r3)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dc
        L_0x00d9:
            r5.showAlertDialog(r1, r0)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.UPIActivity.makeSVAbortCall():void");
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
                UPIActivity.this.transactionCancelled();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void hideProgressLoader() {
        findViewById(getResources().getIdentifier("application_header", "id", getPackageName())).setVisibility(0);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
        findViewById(getResources().getIdentifier("paynimo_upi_list", "id", getPackageName())).setVisibility(0);
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(8);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    j jVar = new j();
                    Set keySet = extras.keySet();
                    if (keySet != null && keySet.size() > 0 && extras.containsKey("Status")) {
                        String string = extras.getString("Status");
                        if (string != null && (string.toUpperCase().equalsIgnoreCase(GopayLinkingHandler.STATUS_FAIL) || string.toUpperCase().equalsIgnoreCase("FAILURE"))) {
                            makeSVAbortCall();
                        } else if (string != null && string.toUpperCase().equalsIgnoreCase("SUBMITTED")) {
                            setResult(-4, new Intent());
                            finish();
                        } else if (string == null || !string.toUpperCase().equalsIgnoreCase("PENDING")) {
                            jVar.setStatus(string + "");
                            if (extras.containsKey(Constant.TAG_RESPONSE)) {
                                String string2 = extras.getString(Constant.TAG_RESPONSE);
                                jVar.setResponse(string2 + "");
                            }
                            if (extras.containsKey("txnRef")) {
                                String string3 = extras.getString("txnRef");
                                jVar.setTxnRef(string3 + "");
                            }
                            if (extras.containsKey("ApprovalRefNo")) {
                                String string4 = extras.getString("ApprovalRefNo");
                                jVar.setApprovalRefNo(string4 + "");
                            }
                            if (extras.containsKey("txnId")) {
                                String string5 = extras.getString("txnId");
                                jVar.setTxnId(string5 + "");
                            }
                            if (extras.containsKey(APayConstants.RESPONSE_CODE)) {
                                String string6 = extras.getString(APayConstants.RESPONSE_CODE);
                                jVar.setResponseCode(string6 + "");
                            }
                            if (extras.containsKey("TrtxnRef")) {
                                String string7 = extras.getString("TrtxnRef");
                                jVar.setTrtxnRef(string7 + "");
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("UPIResponse", jVar);
                            setResult(-1, intent2);
                            finish();
                        } else {
                            setResult(-1, new Intent());
                            finish();
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            makeSVAbortCall();
        }
    }

    public void onBackPressed() {
        showBackPressedDialog();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getResources().getIdentifier("paynimo_activity_upi", "layout", getPackageName()));
        Intent intent = getIntent();
        if (intent != null) {
            this.uri = intent.getStringExtra(Constant.ARGUMENT_UPI_URI);
            this.checkoutData = (Checkout) intent.getSerializableExtra(Constant.ARGUMENT_DATA_CHECKOUT);
            this.txnID = intent.getStringExtra(Constant.ARGUMENT_UPI_TXN_ID);
        }
        this.upiList = (RecyclerView) findViewById(getResources().getIdentifier("paynimo_upi_list", "id", getPackageName()));
        this.webView = (WebView) findViewById(getResources().getIdentifier("paynimo_webview", "id", getPackageName()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.layoutManager = linearLayoutManager;
        this.upiList.setLayoutManager(linearLayoutManager);
        a aVar = new a();
        this.mService = aVar;
        this.mServiceManager = new d(aVar);
        if (this.uri != null) {
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(this.uri)), 128);
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo next : queryIntentActivities) {
                t tVar = new t();
                String charSequence = next.loadLabel(packageManager).toString();
                tVar.setPackageName(next.activityInfo.packageName);
                tVar.setName(charSequence);
                tVar.setDrawable(next.loadIcon(packageManager));
                arrayList.add(tVar);
            }
            this.adapter = new g(this, arrayList, new b() {
                public void onItemClick(t tVar) {
                    com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:UPIAppSelect", 0, GopayLinkingHandler.STATUS_FAIL, UPIActivity.this.checkoutData, "UPI", tVar.getName(), "", "", UPIActivity.this.mServiceManager, UPIActivity.this);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UPIActivity.this.uri));
                    intent.setPackage(tVar.getPackageName());
                    UPIActivity.this.startActivityForResult(intent, 1);
                }
            });
            RecyclerView recyclerView = this.upiList;
            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), 1));
            this.upiList.setAdapter(this.adapter);
        }
    }

    @Subscribe
    public void onEvent(k kVar) {
        Constant.showOutputLog(TAG, "got SVAbort response");
        hideProgressLoader();
        if (kVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_SV_ABORT, "svAbortResponse", "UPI:SVAbort", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", this.checkoutData, "UPI", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, kVar.getResponse().toString());
            try {
                if (kVar.getResponse().getPaymentMethod().getError().getCode().isEmpty()) {
                    Intent intent = new Intent();
                    Checkout checkout = new Checkout();
                    checkout.setMerchantResponsePayload(kVar.getResponse());
                    intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                transactionError(kVar.getResponse().getPaymentMethod().getError().getCode(), kVar.getResponse().getPaymentMethod().getError().getDesc());
            } catch (Exception unused) {
                showAlertDialog(Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_SV, "svAbortResponse", "UPI:SVAbort", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", "", "", "", this.mServiceManager, this);
            Constant.showOutputLog(TAG, "Null SVAbort response");
        }
    }

    public void showAlertDialog(final String str, final String str2) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_text", "id", getApplicationContext().getPackageName()))).setText(getResources().getString(getResources().getIdentifier("paynimo_payments_error", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonOK", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                UPIActivity.this.finishActivityForChangeInPaymentMode();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getApplicationContext().getPackageName()))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                UPIActivity.this.transactionError(str, str2);
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
        findViewById(getResources().getIdentifier("paynimo_upi_list", "id", getPackageName())).setVisibility(8);
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(0);
        this.webView.loadUrl("file:///android_asset/paynimo_loader_gif.gif");
    }

    public void transactionCancelled() {
        setResult(0, new Intent());
        finish();
    }

    public void transactionError(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra(PaymentActivity.RETURN_ERROR_CODE, str);
        intent.putExtra("error_description", str2);
        setResult(-2, intent);
        finish();
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.j jVar) {
        com.paynimo.android.payment.util.b.callEventLogging(Constant.REQUEST_TYPE_SV_ABORT, "svAbortResponse", "UPI:SVAbort", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, this.checkoutData, "UPI", "", "", "", this.mServiceManager, this);
        hideProgressLoader();
        showAlertDialog(Constant.TAG_ERROR_NETWORK_ERROR_CODE, jVar.getError().getDesc());
    }
}
