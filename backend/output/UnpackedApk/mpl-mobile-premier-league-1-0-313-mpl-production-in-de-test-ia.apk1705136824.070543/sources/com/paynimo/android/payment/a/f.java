package com.paynimo.android.payment.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.response.k.c;
import java.util.ArrayList;

public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Activity f1381a;

    /* renamed from: b  reason: collision with root package name */
    public int f1382b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f1383c;

    /* renamed from: d  reason: collision with root package name */
    public LayoutInflater f1384d = null;

    /* renamed from: e  reason: collision with root package name */
    public Checkout f1385e;

    /* renamed from: f  reason: collision with root package name */
    public d f1386f;
    public boolean g = false;

    public class a implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.paynimo.android.payment.model.response.k.c f1388b;

        /* renamed from: com.paynimo.android.payment.a.f$a$a  reason: collision with other inner class name */
        public class C0016a implements DialogInterface.OnClickListener {
            public C0016a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Checkout b2 = f.this.f1385e;
                a aVar = a.this;
                com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:RemoveSavedInstrumentYes", 0, "PASS", b2, PaymentActivity.PAYMENT_METHOD_CUSTOMERVAULTS, "", aVar.f1387a, "", f.this.f1386f, f.this.f1381a);
                f.this.g = false;
                dialogInterface.dismiss();
                ((PaymentActivity) f.this.f1381a).startDeRegisterCardNetworkTask(a.this.f1388b.getCardId());
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Checkout b2 = f.this.f1385e;
                a aVar = a.this;
                com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:RemoveSavedInstrumentNo", 0, "PASS", b2, PaymentActivity.PAYMENT_METHOD_CUSTOMERVAULTS, "", aVar.f1387a, "", f.this.f1386f, f.this.f1381a);
                f.this.g = false;
                dialogInterface.dismiss();
            }
        }

        public class c implements OnCancelListener {
            public c() {
            }

            public void onCancel(DialogInterface dialogInterface) {
                if (f.this.g) {
                    f.this.g = false;
                }
            }
        }

        public a(String str, com.paynimo.android.payment.model.response.k.c cVar) {
            this.f1387a = str;
            this.f1388b = cVar;
        }

        public void onClick(View view) {
            if (!f.this.g) {
                com.paynimo.android.payment.util.b.callEventLogging("", "click", "button:RemoveInst", 0, "PASS", f.this.f1385e, PaymentActivity.PAYMENT_METHOD_CUSTOMERVAULTS, "", this.f1387a, "", f.this.f1386f, f.this.f1381a);
                AlertDialog create = new Builder(f.this.f1381a, f.this.f1381a.getResources().getIdentifier("DialogStylePaynimo", "style", f.this.f1381a.getPackageName())).create();
                create.setMessage(f.this.f1381a.getString(f.this.f1381a.getResources().getIdentifier("paynimo_alert_delete_card", NetworkingModule.REQUEST_BODY_KEY_STRING, f.this.f1381a.getPackageName())));
                create.setButton(-1, f.this.f1381a.getString(f.this.f1381a.getResources().getIdentifier("paynimo_alert_yes", NetworkingModule.REQUEST_BODY_KEY_STRING, f.this.f1381a.getPackageName())), new C0016a());
                create.setButton(-2, f.this.f1381a.getString(f.this.f1381a.getResources().getIdentifier("paynimo_alert_no", NetworkingModule.REQUEST_BODY_KEY_STRING, f.this.f1381a.getPackageName())), new b());
                create.setOnCancelListener(new c());
                f.this.g = true;
                create.setCanceledOnTouchOutside(false);
                create.show();
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f1393a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1394b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f1395c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f1396d;
    }

    public f(Activity activity, int i, ArrayList<c> arrayList, Checkout checkout, d dVar) {
        this.f1381a = activity;
        this.f1382b = i;
        this.f1383c = arrayList;
        this.f1385e = checkout;
        this.f1386f = dVar;
        this.f1384d = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f1383c.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f1384d.inflate(this.f1382b, null);
            bVar = new b();
            bVar.f1393a = (TextView) view.findViewById(this.f1381a.getResources().getIdentifier("paynimo_list_card_bankname_label", "id", this.f1381a.getPackageName()));
            bVar.f1394b = (TextView) view.findViewById(this.f1381a.getResources().getIdentifier("paynimo_list_card_cardno_label", "id", this.f1381a.getPackageName()));
            bVar.f1395c = (ImageView) view.findViewById(this.f1381a.getResources().getIdentifier("paynimo_list_card_icon", "id", this.f1381a.getPackageName()));
            bVar.f1396d = (TextView) view.findViewById(this.f1381a.getResources().getIdentifier("paynimo_list_delete_icon", "id", this.f1381a.getPackageName()));
            bVar.f1396d.setTypeface(Typeface.createFromAsset(this.f1381a.getAssets(), this.f1381a.getResources().getString(this.f1381a.getResources().getIdentifier("paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, this.f1381a.getPackageName()))));
            bVar.f1396d.setText("x");
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        c cVar = this.f1383c.get(i);
        if (cVar != null) {
            String cstat = cVar.getCstat();
            String maskedCardNo = cVar.getMaskedCardNo();
            String cardIssuerAuthority = cVar.getCardIssuerAuthority();
            if (cstat != null && !cstat.isEmpty() && cardIssuerAuthority != null && !cardIssuerAuthority.isEmpty() && maskedCardNo != null && !maskedCardNo.isEmpty()) {
                bVar.f1393a.setText(cstat);
                bVar.f1394b.setText(maskedCardNo);
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_VISA)) {
                    ImageView imageView = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_visa", "drawable", imageView);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MC)) {
                    ImageView imageView2 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_mastercard", "drawable", imageView2);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_MAESTRO)) {
                    ImageView imageView3 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_maestro", "drawable", imageView3);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_AMEX)) {
                    ImageView imageView4 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_american_express", "drawable", imageView4);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DINER)) {
                    ImageView imageView5 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_diners_club", "drawable", imageView5);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_RUPAY)) {
                    ImageView imageView6 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_rupay", "drawable", imageView6);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_DISCOVER)) {
                    ImageView imageView7 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_discover", "drawable", imageView7);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_IP)) {
                    ImageView imageView8 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_instapayment", "drawable", imageView8);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_LASER)) {
                    ImageView imageView9 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_laser", "drawable", imageView9);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_JCB)) {
                    ImageView imageView10 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_jcb", "drawable", imageView10);
                }
                if (cardIssuerAuthority.equalsIgnoreCase(PaymentActivity.CARD_I_AUTHORITY_UP)) {
                    ImageView imageView11 = bVar.f1395c;
                    GeneratedOutlineSupport.outline92(this.f1381a, this.f1381a.getResources(), "paynimo_unionpay", "drawable", imageView11);
                }
            }
            bVar.f1396d.setOnClickListener(new a(cardIssuerAuthority, cVar));
        }
        return view;
    }
}
