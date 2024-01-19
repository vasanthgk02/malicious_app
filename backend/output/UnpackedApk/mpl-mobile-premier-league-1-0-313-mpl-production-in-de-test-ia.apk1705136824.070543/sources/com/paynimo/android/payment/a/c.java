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
import com.paynimo.android.payment.model.response.k.b;
import com.userexperior.e.h;
import java.util.ArrayList;
import java.util.TreeSet;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f1349a;

    /* renamed from: b  reason: collision with root package name */
    public String f1350b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f1351c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public TreeSet<Integer> f1352d = new TreeSet<>();

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f1353e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f1354a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1355b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f1356c;
    }

    public c(Context context, String str) {
        this.f1349a = context;
        this.f1350b = str;
        this.f1353e = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void addItem(b bVar) {
        this.f1351c.add(bVar);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(b bVar) {
        this.f1351c.add(bVar);
        this.f1352d.add(Integer.valueOf(this.f1351c.size() - 1));
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f1351c.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return this.f1352d.contains(Integer.valueOf(i)) ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            aVar = new a();
            if (itemViewType == 0) {
                view = this.f1353e.inflate(this.f1349a.getResources().getIdentifier("paynimo_listitem_paymentmodes", "layout", this.f1349a.getPackageName()), null);
                aVar.f1354a = (TextView) view.findViewById(this.f1349a.getResources().getIdentifier("paynimo_list_pm_text_label", "id", this.f1349a.getPackageName()));
                aVar.f1355b = (TextView) view.findViewById(this.f1349a.getResources().getIdentifier("paynimo_list_pm_icon", "id", this.f1349a.getPackageName()));
                aVar.f1356c = (TextView) view.findViewById(this.f1349a.getResources().getIdentifier("paynimo_list_arrow_icon", "id", this.f1349a.getPackageName()));
            } else if (itemViewType == 1) {
                view = this.f1353e.inflate(this.f1349a.getResources().getIdentifier("paynimo_listitem_custom_header", "layout", this.f1349a.getPackageName()), null);
                aVar.f1354a = (TextView) view.findViewById(this.f1349a.getResources().getIdentifier("paynimoListHeaderSeparator", "id", this.f1349a.getPackageName()));
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (itemViewType == 0) {
            AssetManager assets = this.f1349a.getAssets();
            Resources resources = this.f1349a.getResources();
            Typeface createFromAsset = Typeface.createFromAsset(assets, GeneratedOutlineSupport.outline32(this.f1349a, this.f1349a.getResources(), "paynimo_icons_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, resources));
            aVar.f1355b.setTypeface(createFromAsset);
            if (this.f1350b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_NETBANKING)) {
                aVar.f1355b.setText("I");
            } else if (this.f1350b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_CASHCARDS)) {
                aVar.f1355b.setText("L");
            } else if (this.f1350b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_WALLETS)) {
                aVar.f1355b.setText("T");
            } else if (this.f1350b.equalsIgnoreCase("EMI")) {
                aVar.f1355b.setText(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
            } else if (this.f1350b.equalsIgnoreCase("UPI")) {
                aVar.f1355b.setText("S");
            } else if (this.f1350b.equalsIgnoreCase(PaymentActivity.PAYMENT_METHOD_MVISA)) {
                aVar.f1355b.setText("R");
            }
            aVar.f1356c.setTypeface(createFromAsset);
            aVar.f1356c.setText(h.f3998a);
        }
        aVar.f1354a.setText(this.f1351c.get(i).getBankName());
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isEnabled(int i) {
        return getItemViewType(i) == 0;
    }

    public b getItem(int i) {
        return this.f1351c.get(i);
    }
}
