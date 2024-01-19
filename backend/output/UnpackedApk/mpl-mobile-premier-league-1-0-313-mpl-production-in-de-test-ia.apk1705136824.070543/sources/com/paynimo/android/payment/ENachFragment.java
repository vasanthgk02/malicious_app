package com.paynimo.android.payment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class ENachFragment extends Fragment {
    public static final String VID_URL = "https://resident.uidai.gov.in/web/resident/vidgeneration";
    public EditText et_account_holder_name;
    public String firstNumbers;
    public LinearLayout lyt_bank_details;
    public Spinner spn_account_type;
    public TextView tv_bank_error_text;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_enach", "layout", getActivity().getPackageName()), viewGroup, false);
        this.lyt_bank_details = (LinearLayout) inflate.findViewById(getResources().getIdentifier("paynimo_lyt_bank_details", "id", getActivity().getPackageName()));
        this.et_account_holder_name = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_et_account_holder_name", "id", getActivity().getPackageName()));
        this.spn_account_type = (Spinner) inflate.findViewById(getResources().getIdentifier("paynimo_spn_account_type", "id", getActivity().getPackageName()));
        ArrayList arrayList = new ArrayList();
        arrayList.add("Select Account Type");
        arrayList.add("Saving");
        arrayList.add("Current");
        this.spn_account_type.setAdapter(new ArrayAdapter(getActivity(), 17367043, arrayList));
        this.tv_bank_error_text = (TextView) inflate.findViewById(getResources().getIdentifier("paynimo_bank_error_text", "id", getActivity().getPackageName()));
        return inflate;
    }

    public void onPause() {
        super.onPause();
    }
}
