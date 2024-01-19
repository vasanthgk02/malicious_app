package com.paynimo.android.payment.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.PaymentActivity;
import com.paynimo.android.payment.model.response.k.g;
import com.userexperior.e.h;
import java.util.ArrayList;
import java.util.TreeSet;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f1337a;

    /* renamed from: b  reason: collision with root package name */
    public String f1338b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<g> f1339c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public TreeSet<Integer> f1340d = new TreeSet<>();

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f1341e;

    /* renamed from: com.paynimo.android.payment.a.a$a  reason: collision with other inner class name */
    public static class C0014a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f1342a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1343b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f1344c;
    }

    public a(Context context, String str) {
        this.f1337a = context;
        this.f1338b = str;
        this.f1341e = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void addItem(g gVar) {
        this.f1339c.add(gVar);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(g gVar) {
        this.f1339c.add(gVar);
        this.f1340d.add(Integer.valueOf(this.f1339c.size() - 1));
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f1339c.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return this.f1340d.contains(Integer.valueOf(i)) ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0014a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            aVar = new C0014a();
            if (itemViewType == 0) {
                view = this.f1341e.inflate(this.f1337a.getResources().getIdentifier("paynimo_listitem_paymentmodes", "layout", this.f1337a.getPackageName()), null);
                aVar.f1342a = (TextView) view.findViewById(this.f1337a.getResources().getIdentifier("paynimo_list_pm_text_label", "id", this.f1337a.getPackageName()));
                aVar.f1343b = (TextView) view.findViewById(this.f1337a.getResources().getIdentifier("paynimo_list_pm_icon", "id", this.f1337a.getPackageName()));
                aVar.f1344c = (TextView) view.findViewById(this.f1337a.getResources().getIdentifier("paynimo_list_arrow_icon", "id", this.f1337a.getPackageName()));
            } else if (itemViewType == 1) {
                view = this.f1341e.inflate(this.f1337a.getResources().getIdentifier("paynimo_listitem_custom_header", "layout", this.f1337a.getPackageName()), null);
                aVar.f1342a = (TextView) view.findViewById(this.f1337a.getResources().getIdentifier("paynimoListHeaderSeparator", "id", this.f1337a.getPackageName()));
            }
            view.setTag(aVar);
        } else {
            aVar = (C0014a) view.getTag();
            if (aVar.f1343b == null && itemViewType == 0) {
                view = this.f1341e.inflate(this.f1337a.getResources().getIdentifier("paynimo_listitem_paymentmodes", "layout", this.f1337a.getPackageName()), null);
                aVar.f1342a = (TextView) view.findViewById(this.f1337a.getResources().getIdentifier("paynimo_list_pm_text_label", "id", this.f1337a.getPackageName()));
                aVar.f1343b = (TextView) view.findViewById(this.f1337a.getResources().getIdentifier("paynimo_list_pm_icon", "id", this.f1337a.getPackageName()));
                aVar.f1344c = (TextView) view.findViewById(this.f1337a.getResources().getIdentifier("paynimo_list_arrow_icon", "id", this.f1337a.getPackageName()));
                view.setTag(aVar);
            }
        }
        if (itemViewType == 0) {
            AssetManager assets = this.f1337a.getAssets();
            Resources resources = this.f1337a.getResources();
            Typeface createFromAsset = Typeface.createFromAsset(assets, GeneratedOutlineSupport.outline32(this.f1337a, this.f1337a.getResources(), "paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, resources));
            aVar.f1343b.setTypeface(createFromAsset);
            if (this.f1338b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING)) {
                aVar.f1343b.setText("I");
            } else if (this.f1338b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CASHCARDS)) {
                aVar.f1343b.setText("L");
            } else if (this.f1338b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_WALLETS)) {
                aVar.f1343b.setText("T");
            } else if (this.f1338b.equalsIgnoreCase("EMI")) {
                aVar.f1343b.setText(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
            } else if (this.f1338b.equalsIgnoreCase("UPI")) {
                aVar.f1343b.setText("S");
            } else if (this.f1338b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_MVISA)) {
                aVar.f1343b.setText("R");
            } else if (this.f1338b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_DIGITALMANDATE)) {
                aVar.f1343b.setText("N");
            }
            aVar.f1344c.setTypeface(createFromAsset);
            aVar.f1344c.setText(h.f3998a);
        }
        aVar.f1342a.setText(this.f1339c.get(i).getBankName());
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isEnabled(int i) {
        return getItemViewType(i) == 0;
    }

    public g getItem(int i) {
        return this.f1339c.get(i);
    }
}
