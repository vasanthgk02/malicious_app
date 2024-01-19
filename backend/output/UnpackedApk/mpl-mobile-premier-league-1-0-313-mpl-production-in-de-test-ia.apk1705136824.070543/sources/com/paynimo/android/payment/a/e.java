package com.paynimo.android.payment.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.PaymentActivity;
import com.paynimo.android.payment.PaymentModesActivity;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.response.k.c;
import com.userexperior.e.h;
import java.util.HashMap;
import java.util.List;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

public class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Activity f1364a;

    /* renamed from: b  reason: collision with root package name */
    public List<HashMap<String, Object>> f1365b;

    /* renamed from: c  reason: collision with root package name */
    public Checkout f1366c;

    /* renamed from: d  reason: collision with root package name */
    public d f1367d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f1368e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1369f = false;

    public class a implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1370a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f1371b;

        /* renamed from: com.paynimo.android.payment.a.e$a$a  reason: collision with other inner class name */
        public class C0015a implements DialogInterface.OnClickListener {
            public C0015a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Checkout b2 = e.this.f1366c;
                a aVar = a.this;
                com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:RemoveSavedInstrumentYes", 0, "PASS", b2, PaymentActivity.PAYMENT_METHOD_CUSTOMERVAULTS, "", aVar.f1370a, "", e.this.f1367d, e.this.f1364a);
                e.this.f1369f = false;
                dialogInterface.dismiss();
                ((PaymentModesActivity) e.this.f1364a).startDeRegisterCardNetworkTask(a.this.f1371b.getCardId());
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Checkout b2 = e.this.f1366c;
                a aVar = a.this;
                com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:RemoveSavedInstrumentNo", 0, "PASS", b2, PaymentActivity.PAYMENT_METHOD_CUSTOMERVAULTS, "", aVar.f1370a, "", e.this.f1367d, e.this.f1364a);
                e.this.f1369f = false;
                dialogInterface.dismiss();
            }
        }

        public a(String str, c cVar) {
            this.f1370a = str;
            this.f1371b = cVar;
        }

        public void onClick(View view) {
            if (!e.this.f1369f) {
                com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:RemoveInst", 0, "PASS", e.this.f1366c, PaymentActivity.PAYMENT_METHOD_CUSTOMERVAULTS, "", this.f1370a, "", e.this.f1367d, e.this.f1364a);
                AlertDialog create = new Builder(e.this.f1364a, e.this.f1364a.getResources().getIdentifier("DialogStylePaynimo", "style", e.this.f1364a.getPackageName())).create();
                create.setMessage(e.this.f1364a.getString(e.this.f1364a.getResources().getIdentifier("paynimo_alert_delete_card", NetworkingModule.REQUEST_BODY_KEY_STRING, e.this.f1364a.getPackageName())));
                create.setButton(-1, e.this.f1364a.getString(e.this.f1364a.getResources().getIdentifier("paynimo_alert_yes", NetworkingModule.REQUEST_BODY_KEY_STRING, e.this.f1364a.getPackageName())), new C0015a());
                create.setButton(-2, e.this.f1364a.getString(e.this.f1364a.getResources().getIdentifier("paynimo_alert_no", NetworkingModule.REQUEST_BODY_KEY_STRING, e.this.f1364a.getPackageName())), new b());
                create.show();
                e.this.f1369f = true;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f1375a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1376b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f1377c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f1378d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f1379e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f1380f;
    }

    public e(Activity activity, List<HashMap<String, Object>> list, Checkout checkout, d dVar) {
        this.f1364a = activity;
        this.f1365b = list;
        this.f1366c = checkout;
        this.f1367d = dVar;
        this.f1368e = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f1365b.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        HashMap hashMap = this.f1365b.get(i);
        if (hashMap.containsKey(PaymentModesActivity.VAULT_ROW_TYPE)) {
            String str = (String) hashMap.get(PaymentModesActivity.VAULT_ROW_TYPE);
            if (str.equalsIgnoreCase(PaymentModesActivity.VAULT_TYPE_CARDS) || str.equalsIgnoreCase(PaymentModesActivity.VAULT_TYPE_IMPS)) {
                return 0;
            }
            if (str.equalsIgnoreCase(PaymentModesActivity.VAULT_TYPE_HEADERS)) {
                return 1;
            }
            if (str.equalsIgnoreCase(PaymentModesActivity.VAULT_TYPE_OTHER_OPTIONS)) {
                return 2;
            }
        }
        return 3;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            bVar = new b();
            if (itemViewType == 0) {
                view = this.f1368e.inflate(this.f1364a.getResources().getIdentifier("paynimo_listitem_cardvaulted", "layout", this.f1364a.getPackageName()), null);
                bVar.f1375a = (TextView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimo_list_card_bankname_label", "id", this.f1364a.getPackageName()));
                bVar.f1376b = (TextView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimo_list_card_cardno_label", "id", this.f1364a.getPackageName()));
                bVar.f1377c = (ImageView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimo_list_card_icon", "id", this.f1364a.getPackageName()));
                bVar.f1378d = (TextView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimo_list_delete_icon", "id", this.f1364a.getPackageName()));
                bVar.f1378d.setTypeface(Typeface.createFromAsset(this.f1364a.getAssets(), this.f1364a.getResources().getString(this.f1364a.getResources().getIdentifier("paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, this.f1364a.getPackageName()))));
                bVar.f1378d.setText("x");
            } else if (itemViewType == 1) {
                view = this.f1368e.inflate(this.f1364a.getResources().getIdentifier("paynimo_listitem_custom_header", "layout", this.f1364a.getPackageName()), null);
                bVar.f1375a = (TextView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimoListHeaderSeparator", "id", this.f1364a.getPackageName()));
            } else if (itemViewType == 2) {
                view = this.f1368e.inflate(this.f1364a.getResources().getIdentifier("paynimo_listitem_paymentmodes", "layout", this.f1364a.getPackageName()), null);
                bVar.f1375a = (TextView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimo_list_pm_text_label", "id", this.f1364a.getPackageName()));
                bVar.f1379e = (TextView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimo_list_pm_icon", "id", this.f1364a.getPackageName()));
                bVar.f1380f = (TextView) view.findViewById(this.f1364a.getResources().getIdentifier("paynimo_list_arrow_icon", "id", this.f1364a.getPackageName()));
            }
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (itemViewType == 0) {
            HashMap hashMap = this.f1365b.get(i);
            c cVar = (c) hashMap.get(PaymentModesActivity.VAULT_ROW_DATA);
            String str = (String) hashMap.get(PaymentModesActivity.VAULT_ROW_TYPE);
            if (str.equalsIgnoreCase(PaymentModesActivity.VAULT_TYPE_CARDS)) {
                if (cVar != null) {
                    String cstat = cVar.getCstat();
                    String maskedCardNo = cVar.getMaskedCardNo();
                    String cardIssuerAuthority = cVar.getCardIssuerAuthority();
                    if (cstat != null && !cstat.isEmpty() && cardIssuerAuthority != null && !cardIssuerAuthority.isEmpty() && maskedCardNo != null && !maskedCardNo.isEmpty()) {
                        bVar.f1375a.setText(cstat);
                        bVar.f1376b.setText(maskedCardNo);
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_VISA)) {
                            ImageView imageView = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_visa", "drawable", imageView);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MC)) {
                            ImageView imageView2 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_mastercard", "drawable", imageView2);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MAESTRO)) {
                            ImageView imageView3 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_maestro", "drawable", imageView3);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_AMEX)) {
                            ImageView imageView4 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_american_express", "drawable", imageView4);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DINER)) {
                            ImageView imageView5 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_diners_club", "drawable", imageView5);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_RUPAY)) {
                            ImageView imageView6 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_rupay", "drawable", imageView6);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DISCOVER)) {
                            ImageView imageView7 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_discover", "drawable", imageView7);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_IP)) {
                            ImageView imageView8 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_instapayment", "drawable", imageView8);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_LASER)) {
                            ImageView imageView9 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_laser", "drawable", imageView9);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_JCB)) {
                            ImageView imageView10 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_jcb", "drawable", imageView10);
                        }
                        if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_UP)) {
                            ImageView imageView11 = bVar.f1377c;
                            GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_unionpay", "drawable", imageView11);
                        }
                        bVar.f1378d.setOnClickListener(new a(cardIssuerAuthority, cVar));
                    }
                }
            } else if (str.equalsIgnoreCase(PaymentModesActivity.VAULT_TYPE_IMPS) && cVar != null) {
                String aliasName = cVar.getAliasName();
                String maskedCardNo2 = cVar.getMaskedCardNo();
                if (aliasName != null && !aliasName.isEmpty() && maskedCardNo2 != null && !maskedCardNo2.isEmpty()) {
                    bVar.f1375a.setText(aliasName);
                    bVar.f1376b.setText(maskedCardNo2);
                    ImageView imageView12 = bVar.f1377c;
                    GeneratedOutlineSupport.outline92(this.f1364a, this.f1364a.getResources(), "paynimo_imps_icon", "drawable", imageView12);
                }
            }
        } else if (itemViewType == 1) {
            bVar.f1375a.setText((String) this.f1365b.get(i).get(PaymentModesActivity.VAULT_ROW_TEXT));
        } else if (itemViewType == 2) {
            String str2 = (String) this.f1365b.get(i).get(PaymentModesActivity.VAULT_ROW_TEXT);
            if (str2 != null && !str2.isEmpty()) {
                bVar.f1375a.setText(str2);
                Typeface createFromAsset = Typeface.createFromAsset(this.f1364a.getAssets(), this.f1364a.getResources().getString(this.f1364a.getResources().getIdentifier("paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, this.f1364a.getPackageName())));
                bVar.f1379e.setTypeface(createFromAsset);
                if (str2.equals(PaymentActivity.PAYMENT_METHOD_CARDS)) {
                    bVar.f1379e.setText("K");
                } else if (str2.equals(PaymentActivity.PAYMENT_METHOD_NETBANKING)) {
                    bVar.f1379e.setText("I");
                } else if (str2.equals("IMPS")) {
                    bVar.f1379e.setText("P");
                } else if (str2.equals(PaymentActivity.PAYMENT_METHOD_WALLETS)) {
                    bVar.f1379e.setText("T");
                } else if (str2.equals(PaymentActivity.PAYMENT_METHOD_CASHCARDS)) {
                    bVar.f1379e.setText("L");
                } else if (str2.equals("EMI")) {
                    bVar.f1379e.setText(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
                } else if (str2.equals("UPI")) {
                    bVar.f1379e.setText("S");
                } else if (str2.equals(PaymentActivity.PAYMENT_METHOD_MVISA)) {
                    bVar.f1379e.setText("R");
                } else if (str2.equals(PaymentActivity.PAYMENT_METHOD_DIGITALMANDATE)) {
                    bVar.f1379e.setText("N");
                }
                bVar.f1380f.setTypeface(createFromAsset);
                bVar.f1380f.setText(h.f3998a);
            }
        }
        return view;
    }

    public int getViewTypeCount() {
        return 3;
    }
}
