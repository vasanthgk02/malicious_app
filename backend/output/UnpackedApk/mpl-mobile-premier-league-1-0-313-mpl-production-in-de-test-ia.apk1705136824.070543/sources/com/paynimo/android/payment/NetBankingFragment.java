package com.paynimo.android.payment;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.paynimo.android.payment.a.c;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.event.p;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.h;
import com.paynimo.android.payment.model.response.k.b;
import com.paynimo.android.payment.model.response.k.q;
import com.paynimo.android.payment.model.response.k.r;
import com.paynimo.android.payment.util.Constant;
import com.xiaomi.mipush.sdk.Constants;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import in.juspay.hypersdk.core.InflateView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class NetBankingFragment extends Fragment implements OnItemClickListener {
    public static final String FRAGMENT_TAG = "NetbankingFragment";
    public static Checkout checkoutData;
    public static r pmiData;
    public c adapter;
    public String bankName;
    public HashMap<String, b> banksData = new HashMap<>();
    public Calendar cal;
    public com.paynimo.android.payment.model.b data;
    public IntfOnFragmentDataPass dataPasser;
    public int day;
    public EditText edtSearch;
    public boolean isDialogShown = false;
    public Boolean isSINonEditableViewVisible = Boolean.FALSE;
    public ListView list;
    public a mService;
    public d mServiceManager;
    public int month;
    public RequestPayload request_payload;
    public String searchText;
    public String selected_bank_code = "";
    public Date startTime;
    public int year;

    public static Object getKeyFromValue(Map map, Object obj) {
        for (Object next : map.keySet()) {
            if (map.get(next).equals(obj)) {
                return next;
            }
        }
        return null;
    }

    public static NetBankingFragment instance(Checkout checkout, r rVar) {
        NetBankingFragment netBankingFragment = new NetBankingFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        bundle.putSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE, rVar);
        netBankingFragment.setArguments(bundle);
        return netBankingFragment;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        ((com.paynimo.android.payment.PaymentActivity) getActivity()).showAlertDialog(-2, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR_CODE, com.paynimo.android.payment.util.Constant.TAG_ERROR_DEFAULT_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0066 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void networkCallWithBankCode(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "DEFAULT ERROR"
            java.lang.String r1 = "ERROR_PAYNIMO_003"
            java.lang.String r2 = "NetbankingFragment"
            if (r6 == 0) goto L_0x0088
            boolean r3 = r6.isEmpty()
            if (r3 != 0) goto L_0x0088
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
            com.paynimo.android.payment.model.Checkout r3 = checkoutData     // Catch:{ Exception -> 0x0066 }
            if (r3 == 0) goto L_0x008d
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x0066 }
            r3.<init>()     // Catch:{ Exception -> 0x0066 }
            r5.startTime = r3     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r3 = checkoutData     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "T"
            r3.setTransactionRequestType(r4)     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r3 = checkoutData     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "N"
            r3.setPaymentMethodType(r4)     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r3 = checkoutData     // Catch:{ Exception -> 0x0066 }
            r3.setPaymentMethodToken(r6)     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.Checkout r6 = checkoutData     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.request.RequestPayload r6 = r6.getMerchantRequestPayload()     // Catch:{ Exception -> 0x0066 }
            r5.request_payload = r6     // Catch:{ Exception -> 0x0066 }
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6     // Catch:{ Exception -> 0x0066 }
            r6.showProgressLoader()     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.b.d r6 = r5.mServiceManager     // Catch:{ Exception -> 0x0066 }
            com.paynimo.android.payment.model.request.RequestPayload r3 = r5.request_payload     // Catch:{ Exception -> 0x0066 }
            androidx.fragment.app.FragmentActivity r4 = r5.getActivity()     // Catch:{ Exception -> 0x0066 }
            r6.callTRequest(r3, r4)     // Catch:{ Exception -> 0x0066 }
            goto L_0x008d
        L_0x0066:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6     // Catch:{ Exception -> 0x007e }
            r6.showAlertDialog(r2, r1, r0)     // Catch:{ Exception -> 0x007e }
            goto L_0x008d
        L_0x0070:
            de.greenrobot.event.EventBus r6 = de.greenrobot.event.EventBus.getDefault()     // Catch:{ Exception -> 0x007e }
            com.paynimo.android.payment.event.g r3 = new com.paynimo.android.payment.event.g     // Catch:{ Exception -> 0x007e }
            r4 = 0
            r3.<init>(r4)     // Catch:{ Exception -> 0x007e }
            r6.post(r3)     // Catch:{ Exception -> 0x007e }
            goto L_0x008d
        L_0x007e:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            com.paynimo.android.payment.PaymentActivity r6 = (com.paynimo.android.payment.PaymentActivity) r6
            r6.showAlertDialog(r2, r1, r0)
            goto L_0x008d
        L_0x0088:
            java.lang.String r6 = " BankCode is EMPTY or NULL"
            com.paynimo.android.payment.util.Constant.showOutputLog(r2, r6)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paynimo.android.payment.NetBankingFragment.networkCallWithBankCode(java.lang.String):void");
    }

    private void openSIDialog(boolean z) {
        ArrayAdapter arrayAdapter;
        ArrayAdapter arrayAdapter2;
        Spinner spinner;
        if (!this.isDialogShown) {
            Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.setContentView(getResources().getIdentifier("paynimo_dialog_si_on_netbanking", "layout", getActivity().getPackageName()));
            dialog.setCanceledOnTouchOutside(true);
            LinearLayout linearLayout = (LinearLayout) GeneratedOutlineSupport.outline19(this, getResources(), "lyt_paynimo_si", "id", dialog);
            CheckBox checkBox = (CheckBox) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_vault_card_checkbox_si", "id", dialog);
            ScrollView scrollView = (ScrollView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_main_container", "id", dialog);
            final ViewGroup viewGroup = (ViewGroup) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_si_container", "id", dialog);
            EditText editText = (EditText) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_et_account_number", "id", dialog);
            View outline19 = GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_si_divider", "id", dialog);
            final EditText editText2 = (EditText) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_et_debit_start_date", "id", dialog);
            final EditText editText3 = (EditText) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_et_debit_end_date", "id", dialog);
            EditText editText4 = (EditText) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_et_amount_debit", "id", dialog);
            ViewGroup viewGroup2 = (ViewGroup) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_si_non_edit_container", "id", dialog);
            EditText editText5 = (EditText) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_n_et_account_number", "id", dialog);
            TextView textView = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_n_tv_account_number", "id", dialog);
            View outline192 = GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_si_n_divider", "id", dialog);
            TextView textView2 = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_n_et_debit_start_date", "id", dialog);
            TextView textView3 = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_n_et_debit_end_date", "id", dialog);
            TextView textView4 = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_n_et_amount_debit", "id", dialog);
            TextView textView5 = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_n_et_amountType", "id", dialog);
            TextView textView6 = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_n_et_frequency", "id", dialog);
            ImageButton imageButton = (ImageButton) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_vault_card_eb_start_date", "id", dialog);
            Spinner spinner2 = (Spinner) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_spinner_amountType", "id", dialog);
            Spinner spinner3 = (Spinner) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_spinner_frequency", "id", dialog);
            TextView textView7 = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_vault_card_si_info", "id", dialog);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str = "id";
            Dialog dialog2 = dialog;
            linkedHashMap.put("As and when presented", "ADHO");
            linkedHashMap.put("Bi- monthly", "BIMN");
            linkedHashMap.put("Daily", "DAIL");
            linkedHashMap.put("Monthly", "MNTH");
            linkedHashMap.put("Quarterly", "QURT");
            linkedHashMap.put("Semi annually", "MIAN");
            linkedHashMap.put("Weekly", "Week");
            linkedHashMap.put("Yearly", "YEAR");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            TextView textView8 = (TextView) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_card_tv_account_number", "id", dialog);
            linkedHashMap2.put("Variable", "M");
            linkedHashMap2.put("Fixed", PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
            Set keySet = linkedHashMap2.keySet();
            Set keySet2 = linkedHashMap.keySet();
            LinkedHashMap linkedHashMap3 = linkedHashMap;
            LinkedHashMap linkedHashMap4 = linkedHashMap2;
            FragmentActivity activity = getActivity();
            ImageButton imageButton2 = (ImageButton) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_vault_card_eb_end_date", "id", dialog);
            ArrayAdapter arrayAdapter3 = new ArrayAdapter(activity, 17367048, (String[]) keySet.toArray(new String[keySet.size()]));
            arrayAdapter3.setDropDownViewResource(17367049);
            ArrayAdapter arrayAdapter4 = new ArrayAdapter(getActivity(), 17367048, (String[]) keySet2.toArray(new String[keySet2.size()]));
            arrayAdapter4.setDropDownViewResource(17367049);
            checkBox.setVisibility(8);
            textView7.setVisibility(8);
            viewGroup.setVisibility(8);
            viewGroup2.setVisibility(8);
            spinner2.setAdapter(arrayAdapter3);
            spinner3.setAdapter(arrayAdapter4);
            if (z) {
                checkBox.setVisibility(0);
                checkBox.setChecked(true);
                checkBox.setClickable(false);
                textView7.setVisibility(0);
                spinner = spinner3;
                arrayAdapter = arrayAdapter4;
                arrayAdapter2 = arrayAdapter3;
                textView7.setText(getResources().getString(getResources().getIdentifier("paynimo_cc_si_view_detail_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
                viewGroup2.setVisibility(8);
                viewGroup.setVisibility(8);
            } else {
                spinner = spinner3;
                arrayAdapter = arrayAdapter4;
                arrayAdapter2 = arrayAdapter3;
                checkBox.setVisibility(0);
                checkBox.setChecked(false);
                checkoutData.setPaymentInstructionStartDateTime("");
                checkoutData.setPaymentInstructionEndDateTime("");
                checkoutData.setPaymentInstructionAmount("");
                checkoutData.setPaymentInstructionLimit("");
                checkoutData.setPaymentInstructionAction("N");
                textView7.setVisibility(8);
                viewGroup2.setVisibility(8);
                viewGroup.setVisibility(8);
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
            TextView textView9 = textView7;
            outline81.append(this.year);
            outline81.append("");
            editText2.setText(outline81);
            StringBuilder sb2 = new StringBuilder();
            GeneratedOutlineSupport.outline103(sb2, sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(this.year + 20);
            sb2.append("");
            editText3.setText(sb2);
            editText4.setText("1000.00");
            final AnonymousClass2 r1 = new OnDateSetListener() {
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
                    EditText editText = editText2;
                    editText.setText((outline41 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + outline412 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i).trim());
                }
            };
            final AnonymousClass3 r3 = new OnDateSetListener() {
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
                    bundle.putInt(AnonymousClass27.YEAR, NetBankingFragment.this.year);
                    bundle.putInt(AnonymousClass27.MONTH, NetBankingFragment.this.month);
                    bundle.putInt("day", NetBankingFragment.this.day);
                    datePickerFragment.setArguments(bundle);
                    datePickerFragment.setCallBack(r1);
                    datePickerFragment.show(NetBankingFragment.this.getFragmentManager(), (String) "Date Picker");
                }
            });
            imageButton2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    DatePickerFragment datePickerFragment = new DatePickerFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(AnonymousClass27.YEAR, NetBankingFragment.this.year + 20);
                    bundle.putInt(AnonymousClass27.MONTH, NetBankingFragment.this.month);
                    bundle.putInt("day", NetBankingFragment.this.day);
                    datePickerFragment.setArguments(bundle);
                    datePickerFragment.setCallBack(r3);
                    datePickerFragment.show(NetBankingFragment.this.getFragmentManager(), (String) "Date Picker");
                }
            });
            final EditText editText6 = editText2;
            TextView textView10 = textView9;
            final EditText editText7 = editText3;
            Spinner spinner4 = spinner;
            final Spinner spinner5 = spinner2;
            Spinner spinner6 = spinner2;
            final ArrayAdapter arrayAdapter5 = arrayAdapter2;
            ViewGroup viewGroup3 = viewGroup2;
            final Spinner spinner7 = spinner4;
            EditText editText8 = editText4;
            final ArrayAdapter arrayAdapter6 = arrayAdapter;
            EditText editText9 = editText3;
            final EditText editText10 = editText8;
            EditText editText11 = editText2;
            final EditText editText12 = editText;
            TextView textView11 = textView10;
            final TextView textView12 = textView8;
            CheckBox checkBox2 = checkBox;
            final View view = outline19;
            AnonymousClass6 r0 = new OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        viewGroup.setVisibility(0);
                        editText6.setKeyListener(null);
                        editText7.setKeyListener(null);
                        spinner5.setAdapter(arrayAdapter5);
                        spinner7.setAdapter(arrayAdapter6);
                        int access$500 = NetBankingFragment.this.month + 1;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                        outline73.append(NetBankingFragment.this.day);
                        String sb = outline73.toString();
                        String outline41 = GeneratedOutlineSupport.outline41("", access$500);
                        if (NetBankingFragment.this.day > 0 && NetBankingFragment.this.day < 10) {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("0");
                            outline732.append(NetBankingFragment.this.day);
                            sb = outline732.toString();
                        }
                        if (access$500 > 0 && access$500 < 10) {
                            outline41 = GeneratedOutlineSupport.outline41("0", access$500);
                        }
                        EditText editText = editText6;
                        StringBuilder outline81 = GeneratedOutlineSupport.outline81(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        outline81.append(NetBankingFragment.this.year);
                        outline81.append(CMap.SPACE);
                        editText.setText(outline81);
                        EditText editText2 = editText7;
                        StringBuilder outline812 = GeneratedOutlineSupport.outline81(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, outline41, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        outline812.append(NetBankingFragment.this.year + 20);
                        outline812.append(CMap.SPACE);
                        editText2.setText(outline812);
                        editText10.setText("1000.00");
                        if (NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo().trim().length() > 0) {
                            editText12.setText(NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo());
                            editText12.setKeyListener(null);
                            textView12.setText(NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo());
                            editText12.setVisibility(8);
                            textView12.setVisibility(0);
                            view.setVisibility(0);
                            return;
                        }
                        ((InputMethodManager) NetBankingFragment.this.getActivity().getSystemService("input_method")).toggleSoftInputFromWindow(editText12.getWindowToken(), 2, 0);
                        editText12.setVisibility(0);
                        textView12.setVisibility(8);
                        view.setVisibility(8);
                        editText12.requestFocus();
                        return;
                    }
                    ((InputMethodManager) NetBankingFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(editText12.getWindowToken(), 0);
                    viewGroup.setVisibility(8);
                }
            };
            checkBox2.setOnCheckedChangeListener(r0);
            CheckBox checkBox3 = checkBox2;
            TextView textView13 = textView11;
            textView13.setText(getString(getResources().getIdentifier("paynimo_card_show_si", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())));
            final TextView textView14 = textView13;
            final ViewGroup viewGroup4 = viewGroup3;
            final TextView textView15 = textView;
            final EditText editText13 = editText5;
            final View view2 = outline192;
            final TextView textView16 = textView2;
            final TextView textView17 = textView3;
            final TextView textView18 = textView4;
            final LinkedHashMap linkedHashMap5 = linkedHashMap3;
            final TextView textView19 = textView6;
            CheckBox checkBox4 = checkBox3;
            AnonymousClass7 r15 = r0;
            final LinkedHashMap linkedHashMap6 = linkedHashMap4;
            TextView textView20 = textView13;
            final TextView textView21 = textView5;
            AnonymousClass7 r02 = new OnClickListener() {
                public void onClick(View view) {
                    if (!NetBankingFragment.this.isSINonEditableViewVisible.booleanValue()) {
                        NetBankingFragment.this.isSINonEditableViewVisible = Boolean.TRUE;
                        TextView textView = textView14;
                        NetBankingFragment netBankingFragment = NetBankingFragment.this;
                        textView.setText(netBankingFragment.getString(netBankingFragment.getResources().getIdentifier("paynimo_card_hide_si", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())));
                        viewGroup4.setVisibility(0);
                        if (NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo().trim().length() > 0) {
                            textView15.setText(NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo());
                            editText13.setVisibility(8);
                            textView15.setVisibility(0);
                            view2.setVisibility(0);
                        } else {
                            ((InputMethodManager) NetBankingFragment.this.getActivity().getSystemService("input_method")).toggleSoftInputFromWindow(editText13.getWindowToken(), 2, 0);
                            editText13.setVisibility(0);
                            textView15.setVisibility(8);
                            view2.setVisibility(8);
                            editText13.requestFocus();
                        }
                        if (NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() > 0) {
                            textView16.setText(NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime());
                        } else {
                            TextView textView2 = textView16;
                            NetBankingFragment netBankingFragment2 = NetBankingFragment.this;
                            textView2.setError(netBankingFragment2.getString(netBankingFragment2.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())));
                        }
                        if (NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() > 0) {
                            textView17.setText(NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime());
                        } else {
                            TextView textView3 = textView17;
                            NetBankingFragment netBankingFragment3 = NetBankingFragment.this;
                            textView3.setError(netBankingFragment3.getString(netBankingFragment3.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())));
                        }
                        if (NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() > 0) {
                            textView18.setText(NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit());
                        } else {
                            TextView textView4 = textView18;
                            NetBankingFragment netBankingFragment4 = NetBankingFragment.this;
                            textView4.setError(netBankingFragment4.getString(netBankingFragment4.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())));
                        }
                        String frequency = NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getFrequency();
                        if (frequency.equals(null) || frequency.length() <= 0) {
                            TextView textView5 = textView19;
                            NetBankingFragment netBankingFragment5 = NetBankingFragment.this;
                            textView5.setError(netBankingFragment5.getString(netBankingFragment5.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())));
                        } else {
                            try {
                                textView19.setText((String) NetBankingFragment.getKeyFromValue(linkedHashMap5, frequency));
                            } catch (Exception unused) {
                            }
                        }
                        String type = NetBankingFragment.checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getType();
                        if (type.equals(null) || type.length() <= 0) {
                            TextView textView6 = textView21;
                            NetBankingFragment netBankingFragment6 = NetBankingFragment.this;
                            textView6.setError(netBankingFragment6.getString(netBankingFragment6.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())));
                            return;
                        }
                        try {
                            textView21.setText((String) NetBankingFragment.getKeyFromValue(linkedHashMap6, type));
                        } catch (Exception unused2) {
                        }
                    } else {
                        NetBankingFragment.this.isSINonEditableViewVisible = Boolean.FALSE;
                        ((InputMethodManager) NetBankingFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(editText13.getWindowToken(), 0);
                        TextView textView7 = textView14;
                        NetBankingFragment netBankingFragment7 = NetBankingFragment.this;
                        textView7.setText(netBankingFragment7.getString(netBankingFragment7.getResources().getIdentifier("paynimo_card_show_si", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())));
                        viewGroup4.setVisibility(8);
                    }
                }
            };
            textView20.setOnClickListener(r15);
            String str2 = str;
            final Dialog dialog3 = dialog2;
            final CheckBox checkBox5 = checkBox4;
            final boolean z2 = z;
            final EditText editText14 = editText5;
            final EditText editText15 = editText;
            final EditText editText16 = editText11;
            final EditText editText17 = editText9;
            final EditText editText18 = editText8;
            final LinkedHashMap linkedHashMap7 = linkedHashMap3;
            final Spinner spinner8 = spinner4;
            final LinkedHashMap linkedHashMap8 = linkedHashMap4;
            AnonymousClass8 r16 = r0;
            final Button button = (Button) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_si_on_netbanking_submit_btn", str2, dialog3);
            final Spinner spinner9 = spinner6;
            String str3 = str2;
            final Dialog dialog4 = dialog3;
            AnonymousClass8 r03 = new OnClickListener() {
                public void onClick(View view) {
                    if (!checkBox5.isChecked() || NetBankingFragment.pmiData == null) {
                        NetBankingFragment.checkoutData.setPaymentInstructionAction("N");
                        NetBankingFragment.checkoutData.setPaymentInstructionAmount("");
                        NetBankingFragment.checkoutData.setPaymentInstructionType("");
                        NetBankingFragment.checkoutData.setPaymentInstructionLimit("");
                        NetBankingFragment.checkoutData.setPaymentInstructionFrequency("");
                        NetBankingFragment.checkoutData.setPaymentInstructionStartDateTime("");
                        NetBankingFragment.checkoutData.setPaymentInstructionEndDateTime("");
                        ((InputMethodManager) NetBankingFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(editText15.getWindowToken(), 0);
                        NetBankingFragment.this.isDialogShown = false;
                        dialog4.dismiss();
                        NetBankingFragment netBankingFragment = NetBankingFragment.this;
                        netBankingFragment.networkCallWithBankCode(netBankingFragment.selected_bank_code);
                    } else {
                        if (z2) {
                            if (NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo() == null || NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo().trim().length() <= 0) {
                                if (editText14.getText().toString() == null || editText14.getText().toString().trim().length() <= 0) {
                                    Toast.makeText(NetBankingFragment.this.getActivity(), NetBankingFragment.this.getResources().getString(NetBankingFragment.this.getResources().getIdentifier("paynimo_cc_si_validation_account_no_error_message", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())), 1).show();
                                    return;
                                }
                                NetBankingFragment.checkoutData.setConsumerAccountNo(editText14.getText().toString().trim());
                            }
                        } else if (NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo() == null || NetBankingFragment.checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo().trim().length() <= 0) {
                            if (editText15.getText().toString() == null || editText15.getText().toString().trim().length() <= 0) {
                                Toast.makeText(NetBankingFragment.this.getActivity(), NetBankingFragment.this.getResources().getString(NetBankingFragment.this.getResources().getIdentifier("paynimo_cc_si_validation_account_no_error_message", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())), 1).show();
                                return;
                            }
                            NetBankingFragment.checkoutData.setConsumerAccountNo(editText15.getText().toString().trim());
                        }
                        if (!NetBankingFragment.this.validateSIData(NetBankingFragment.pmiData, editText15.getText().toString(), checkBox5.isChecked(), editText16.getText().toString(), editText17.getText().toString(), editText18.getText().toString()).booleanValue()) {
                            Toast.makeText(NetBankingFragment.this.getActivity(), NetBankingFragment.this.getResources().getString(NetBankingFragment.this.getResources().getIdentifier("paynimo_cc_si_validation_error_message", NetworkingModule.REQUEST_BODY_KEY_STRING, NetBankingFragment.this.getActivity().getPackageName())), 1).show();
                            return;
                        }
                        if (!z2) {
                            NetBankingFragment.checkoutData.setPaymentInstructionStartDateTime(editText16.getText().toString().trim());
                            NetBankingFragment.checkoutData.setPaymentInstructionEndDateTime(editText17.getText().toString().trim());
                            NetBankingFragment.checkoutData.setPaymentInstructionAmount(editText18.getText().toString().trim());
                            NetBankingFragment.checkoutData.setPaymentInstructionLimit(editText18.getText().toString().trim());
                            NetBankingFragment.checkoutData.setPaymentInstructionAction("Y");
                            String str = null;
                            String str2 = linkedHashMap7.containsKey(spinner8.getSelectedItem().toString()) ? (String) linkedHashMap7.get(spinner8.getSelectedItem().toString()) : null;
                            if (linkedHashMap8.containsKey(spinner9.getSelectedItem().toString())) {
                                str = (String) linkedHashMap8.get(spinner9.getSelectedItem().toString());
                            }
                            NetBankingFragment.checkoutData.setPaymentInstructionType(str);
                            NetBankingFragment.checkoutData.setPaymentInstructionFrequency(str2);
                        }
                        ((InputMethodManager) NetBankingFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(editText15.getWindowToken(), 0);
                        NetBankingFragment.this.isDialogShown = false;
                        dialog4.dismiss();
                        NetBankingFragment netBankingFragment2 = NetBankingFragment.this;
                        netBankingFragment2.networkCallWithBankCode(netBankingFragment2.selected_bank_code);
                    }
                }
            };
            button.setOnClickListener(r16);
            ((Button) GeneratedOutlineSupport.outline19(this, getResources(), "paynimo_si_on_netbanking_cancel_btn", str3, dialog3)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    NetBankingFragment.this.isSINonEditableViewVisible = Boolean.FALSE;
                    ((InputMethodManager) NetBankingFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(button.getWindowToken(), 0);
                    NetBankingFragment.this.isDialogShown = false;
                    dialog3.dismiss();
                }
            });
            dialog3.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    NetBankingFragment.this.isSINonEditableViewVisible = Boolean.FALSE;
                    if (NetBankingFragment.this.isDialogShown) {
                        NetBankingFragment.this.isDialogShown = false;
                    }
                }
            });
            this.isDialogShown = true;
            dialog3.setCanceledOnTouchOutside(false);
            dialog3.show();
            return;
        }
    }

    /* access modifiers changed from: private */
    public void prepareListData(String str, String str2) {
        q netBanking = pmiData.getBanks().getNetBanking();
        if (netBanking != null) {
            int topBanksCount = netBanking.getTopBanksCount();
            int otherBanksCount = netBanking.getOtherBanksCount();
            if (topBanksCount > 0) {
                if (GeneratedOutlineSupport.outline107(checkoutData, "Y")) {
                    b bVar = new b();
                    bVar.setBankName("Banks");
                    bVar.setBankCode("");
                } else {
                    b bVar2 = new b();
                    if (otherBanksCount > 0) {
                        bVar2.setBankName("Popular Banks");
                        bVar2.setBankCode("");
                    } else {
                        bVar2.setBankName("Banks");
                        bVar2.setBankCode("");
                    }
                    if (str2 == null) {
                        this.adapter.addSectionHeaderItem(bVar2);
                    } else {
                        bVar2.setBankName("Banks");
                        this.adapter.addSectionHeaderItem(bVar2);
                    }
                }
                List<b> topBanks = netBanking.getTopBanks();
                if (topBanks != null) {
                    for (b next : topBanks) {
                        if (str2 == null) {
                            if (GeneratedOutlineSupport.outline107(checkoutData, "Y")) {
                                if (!(next == null || next.getOptionFlag() == null || !next.getOptionFlag().equalsIgnoreCase("S"))) {
                                    if (this.adapter.getCount() == 0) {
                                        b bVar3 = new b();
                                        bVar3.setBankName("Banks");
                                        bVar3.setBankCode("");
                                        this.adapter.addSectionHeaderItem(bVar3);
                                    }
                                    if (str == null || str.length() <= 0) {
                                        this.adapter.addItem(next);
                                        this.banksData.put(next.getBankName(), next);
                                    } else if (next.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                                        this.adapter.addItem(next);
                                        this.banksData.put(next.getBankName(), next);
                                    }
                                }
                            } else if (GeneratedOutlineSupport.outline107(checkoutData, "N")) {
                                if (str == null || str.length() <= 0) {
                                    this.adapter.addItem(next);
                                    this.banksData.put(next.getBankName(), next);
                                } else if (next != null && next.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                                    this.adapter.addItem(next);
                                    this.banksData.put(next.getBankName(), next);
                                }
                            } else if (str == null || str.length() <= 0) {
                                if (!(next == null || next.getOptionFlag() == null || next.getOptionFlag().equalsIgnoreCase("S"))) {
                                    this.adapter.addItem(next);
                                    this.banksData.put(next.getBankName(), next);
                                }
                            } else if (next.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault())) && next.getOptionFlag() != null && !next.getOptionFlag().equalsIgnoreCase("S")) {
                                this.adapter.addItem(next);
                                this.banksData.put(next.getBankName(), next);
                            }
                        } else if (next.getBankCode() != null && next.getBankCode().equalsIgnoreCase(str2)) {
                            if (this.adapter.getCount() == 0) {
                                b bVar4 = new b();
                                bVar4.setBankName("Banks");
                                bVar4.setBankCode("");
                                this.adapter.addSectionHeaderItem(bVar4);
                            }
                            if (str == null || str.length() <= 0) {
                                this.adapter.addItem(next);
                                this.banksData.put(next.getBankName(), next);
                            } else if (next.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                                this.adapter.addItem(next);
                                this.banksData.put(next.getBankName(), next);
                            }
                            return;
                        }
                    }
                }
            }
            if (otherBanksCount > 0) {
                if (GeneratedOutlineSupport.outline107(checkoutData, "Y")) {
                    b bVar5 = new b();
                    bVar5.setBankName("Banks");
                    bVar5.setBankCode("");
                } else {
                    b bVar6 = new b();
                    if (topBanksCount > 0) {
                        bVar6.setBankName("Other Banks");
                        bVar6.setBankCode("");
                    } else {
                        bVar6.setBankName("Banks");
                        bVar6.setBankCode("");
                    }
                    if (str2 == null) {
                        this.adapter.addSectionHeaderItem(bVar6);
                    } else if (this.adapter.getCount() == 0) {
                        bVar6.setBankName("Banks");
                        this.adapter.addSectionHeaderItem(bVar6);
                    }
                }
                List<b> otherBanks = netBanking.getOtherBanks();
                if (otherBanks != null) {
                    Iterator<b> it = otherBanks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b next2 = it.next();
                        if (str2 == null) {
                            if (GeneratedOutlineSupport.outline107(checkoutData, "Y")) {
                                if (!(next2 == null || next2.getOptionFlag() == null || !next2.getOptionFlag().equalsIgnoreCase("S"))) {
                                    if (this.adapter.getCount() == 0) {
                                        b bVar7 = new b();
                                        bVar7.setBankName("Banks");
                                        bVar7.setBankCode("");
                                        this.adapter.addSectionHeaderItem(bVar7);
                                    }
                                    if (str == null || str.length() <= 0) {
                                        this.adapter.addItem(next2);
                                        this.banksData.put(next2.getBankName(), next2);
                                    } else if (next2.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                                        this.adapter.addItem(next2);
                                        this.banksData.put(next2.getBankName(), next2);
                                    }
                                }
                            } else if (GeneratedOutlineSupport.outline107(checkoutData, "N")) {
                                if (str == null || str.length() <= 0) {
                                    this.adapter.addItem(next2);
                                    this.banksData.put(next2.getBankName(), next2);
                                } else if (next2 != null && next2.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                                    this.adapter.addItem(next2);
                                    this.banksData.put(next2.getBankName(), next2);
                                }
                            } else if (str == null || str.length() <= 0) {
                                if (!(next2 == null || next2.getOptionFlag() == null || next2.getOptionFlag().equalsIgnoreCase("S"))) {
                                    this.adapter.addItem(next2);
                                    this.banksData.put(next2.getBankName(), next2);
                                }
                            } else if (next2 != null && next2.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault())) && next2.getOptionFlag() != null && !next2.getOptionFlag().equalsIgnoreCase("S")) {
                                this.adapter.addItem(next2);
                                this.banksData.put(next2.getBankName(), next2);
                            }
                        } else if (next2.getBankCode() != null && next2.getBankCode().equalsIgnoreCase(str2)) {
                            if (this.adapter.getCount() == 0) {
                                b bVar8 = new b();
                                bVar8.setBankName("Banks");
                                bVar8.setBankCode("");
                                this.adapter.addSectionHeaderItem(bVar8);
                            }
                            if (str == null || str.length() <= 0) {
                                this.adapter.addItem(next2);
                                this.banksData.put(next2.getBankName(), next2);
                            } else if (next2.getBankName().toUpperCase(Locale.getDefault()).contains(str.toUpperCase(Locale.getDefault()))) {
                                this.adapter.addItem(next2);
                                this.banksData.put(next2.getBankName(), next2);
                            }
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
            intent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkoutData);
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

    private void showAlertDialog(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new Builder(getActivity()).create();
        if (str != null && !str.isEmpty()) {
            create.setTitle(str);
        }
        if (str2 != null && !str2.isEmpty()) {
            AlertController alertController = create.mAlert;
            alertController.mMessage = str2;
            TextView textView = alertController.mMessageView;
            if (textView != null) {
                textView.setText(str2);
            }
        }
        if (onClickListener != null) {
            create.setButton(-1, getActivity().getString(getResources().getIdentifier("paynimo_custom_dialog_ok_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())), onClickListener);
        }
        if (onClickListener2 != null) {
            create.setButton(-2, getActivity().getString(getResources().getIdentifier("paynimo_custom_dialog_cancel_label", NetworkingModule.REQUEST_BODY_KEY_STRING, getActivity().getPackageName())), onClickListener2);
        }
        create.show();
    }

    /* access modifiers changed from: private */
    public Boolean validateSIData(r rVar, String str, boolean z, String str2, String str3, String str4) {
        Boolean bool = Boolean.FALSE;
        if (!rVar.getSIEnable().equalsIgnoreCase("S") && !rVar.getSIEnable().equalsIgnoreCase("SI")) {
            return Boolean.TRUE;
        }
        if (GeneratedOutlineSupport.outline107(checkoutData, "Y")) {
            if (checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo().length() <= 0 || checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getEndDateTime().length() <= 0 || checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getStartDateTime().length() <= 0 || checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getLimit().length() <= 0 || checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getFrequency().length() <= 0 || checkoutData.getMerchantRequestPayload().getPayment().getInstruction().getType().length() <= 0) {
                return bool;
            }
            return Boolean.TRUE;
        } else if (!z) {
            return Boolean.TRUE;
        } else {
            if (str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0 || str4.length() <= 0) {
                return bool;
            }
            return Boolean.TRUE;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
        Constant.showOutputLog("==>>NetbankingFragment", "onAttach");
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
        checkoutData = (Checkout) getArguments().getSerializable(Constant.ARGUMENT_DATA_CHECKOUT);
        pmiData = (r) getArguments().getSerializable(Constant.ARGUMENT_DATA_PMI_RESPONSE);
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_netbanking", "layout", getActivity().getPackageName()), viewGroup, false);
        this.searchText = "";
        EditText editText = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_et_search_bank", "id", getActivity().getPackageName()));
        this.edtSearch = editText;
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                NetBankingFragment.this.adapter = new c(NetBankingFragment.this.getActivity(), PaymentActivity.PAYMENT_METHOD_NETBANKING);
                NetBankingFragment.this.searchText = editable.toString();
                NetBankingFragment netBankingFragment = NetBankingFragment.this;
                netBankingFragment.prepareListData(netBankingFragment.searchText, null);
                NetBankingFragment.this.setListData();
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.list = (ListView) inflate.findViewById(getResources().getIdentifier("paynimo_list", "id", getActivity().getPackageName()));
        this.adapter = new c(getActivity(), PaymentActivity.PAYMENT_METHOD_NETBANKING);
        a aVar = new a();
        this.mService = aVar;
        this.mServiceManager = new d(aVar);
        this.list.setOnItemClickListener(this);
        Checkout checkout = checkoutData;
        if (!(checkout == null || pmiData == null)) {
            String token = checkout.getMerchantRequestPayload().getPayment().getMethod().getToken();
            if (checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y") && ((GeneratedOutlineSupport.outline107(checkoutData, "D") || GeneratedOutlineSupport.outline107(checkoutData, "")) && token != null && !token.isEmpty())) {
                networkCallWithBankCode(token);
            } else if (checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y") && GeneratedOutlineSupport.outline107(checkoutData, "Y") && checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo() != null && !checkoutData.getMerchantRequestPayload().getConsumer().getAccountNo().isEmpty() && token != null && !token.isEmpty()) {
                networkCallWithBankCode(token);
            } else if (checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y") && GeneratedOutlineSupport.outline107(checkoutData, "N") && token != null && !token.isEmpty()) {
                prepareListData(this.searchText, token);
                setListData();
            } else if (!checkoutData.getMerchantRequestPayload().getTransaction().getMerchantInitiated().equalsIgnoreCase("Y") || !GeneratedOutlineSupport.outline107(checkoutData, "Y") || token == null || token.isEmpty()) {
                prepareListData(this.searchText, null);
                setListData();
            } else {
                prepareListData(this.searchText, token);
                setListData();
            }
        }
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
        Constant.showOutputLog("==>>NetbankingFragment", "onDetach");
    }

    @Subscribe
    public void onEvent(com.paynimo.android.payment.event.q qVar) {
        Constant.showOutputLog(FRAGMENT_TAG, "got T response");
        ((PaymentActivity) getActivity()).hideProgressLoader();
        if (qVar.getResponse() != null) {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:NetbankingSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), "PASS", checkoutData, PaymentActivity.PAYMENT_METHOD_NETBANKING, this.bankName, "", "", this.mServiceManager, getActivity());
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
            } catch (Exception unused) {
                ((PaymentActivity) getActivity()).showAlertDialog(-2, Constant.TAG_ERROR_DEFAULT_ERROR_CODE, Constant.TAG_ERROR_DEFAULT_ERROR);
            }
        } else {
            com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:NetbankingSubmit", GeneratedOutlineSupport.outline13() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, checkoutData, PaymentActivity.PAYMENT_METHOD_NETBANKING, this.bankName, "", "", this.mServiceManager, getActivity());
            Constant.showOutputLog(FRAGMENT_TAG, "Null T response");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.paynimo.android.payment.model.b bVar = new com.paynimo.android.payment.model.b();
        this.data = bVar;
        this.dataPasser.cardDataFromFragment(bVar);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.edtSearch.getWindowToken(), 0);
        String charSequence = ((TextView) view.findViewById(getResources().getIdentifier("paynimo_list_pm_text_label", "id", getActivity().getPackageName()))).getText().toString();
        this.bankName = charSequence;
        if (this.banksData.containsKey(charSequence)) {
            b bVar2 = this.banksData.get(this.bankName);
            this.selected_bank_code = bVar2.getBankCode();
            if ((!pmiData.getSIEnable().equalsIgnoreCase("S") && !pmiData.getSIEnable().equalsIgnoreCase("SI")) || (!GeneratedOutlineSupport.outline107(checkoutData, "Y") && !GeneratedOutlineSupport.outline107(checkoutData, "N"))) {
                networkCallWithBankCode(this.selected_bank_code);
            } else if (bVar2.getOptionFlag() == null || !bVar2.getOptionFlag().equalsIgnoreCase("S")) {
                networkCallWithBankCode(this.selected_bank_code);
            } else if (GeneratedOutlineSupport.outline107(checkoutData, "Y")) {
                openSIDialog(true);
            } else {
                openSIDialog(false);
            }
        } else {
            Constant.showOutputLog(FRAGMENT_TAG, " HashMap does not contain the BANK NAME");
        }
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>NetbankingFragment", "onPause");
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>NetbankingFragment", "onResume");
    }

    @Subscribe
    public void onEvent(p pVar) {
        ((PaymentActivity) getActivity()).hideProgressLoader();
        com.paynimo.android.payment.util.b.callEventLogging("T", "click", "button:NetbankingSubmit", new Date().getTime() - this.startTime.getTime(), GopayLinkingHandler.STATUS_FAIL, checkoutData, PaymentActivity.PAYMENT_METHOD_NETBANKING, this.bankName, "", "", this.mServiceManager, getActivity());
        ((PaymentActivity) getActivity()).transactionError(Constant.TAG_ERROR_NETWORK_ERROR_CODE, pVar.getError().getDesc());
    }
}
