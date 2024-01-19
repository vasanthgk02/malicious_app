package com.paynimo.android.payment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paynimo.android.payment.util.d;
import java.util.ArrayList;

public class AadharFragment extends Fragment {
    public static final String VID_URL = "https://resident.uidai.gov.in/vid-generation";
    public Button btn_generate_vid;
    public EditText et_aadhar_no;
    public EditText et_account_holder_name;
    public EditText et_ifsc_code;
    public String firstNumbers;
    public LinearLayout lyt_bank_details;
    public Spinner spn_account_type;
    public TextView tv_bank_error_text;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_aadhar", "layout", getActivity().getPackageName()), viewGroup, false);
        this.lyt_bank_details = (LinearLayout) inflate.findViewById(getResources().getIdentifier("paynimo_lyt_bank_details", "id", getActivity().getPackageName()));
        this.et_aadhar_no = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_et_aadhar_number", "id", getActivity().getPackageName()));
        this.et_ifsc_code = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_et_ifsc_code", "id", getActivity().getPackageName()));
        this.et_account_holder_name = (EditText) inflate.findViewById(getResources().getIdentifier("paynimo_et_account_holder_name", "id", getActivity().getPackageName()));
        this.spn_account_type = (Spinner) inflate.findViewById(getResources().getIdentifier("paynimo_spn_account_type", "id", getActivity().getPackageName()));
        ArrayList arrayList = new ArrayList();
        arrayList.add("Select Account Type");
        arrayList.add("Saving");
        arrayList.add("Current");
        arrayList.add("Cash Credit");
        this.spn_account_type.setAdapter(new ArrayAdapter(getActivity(), 17367043, arrayList));
        this.tv_bank_error_text = (TextView) inflate.findViewById(getResources().getIdentifier("paynimo_bank_error_text", "id", getActivity().getPackageName()));
        Button button = (Button) inflate.findViewById(getResources().getIdentifier("paynimo_btn_generate_vid", "id", getActivity().getPackageName()));
        this.btn_generate_vid = button;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AadharFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(AadharFragment.VID_URL)));
            }
        });
        this.et_aadhar_no.addTextChangedListener(new TextWatcher() {
            public int aadharLength = 0;
            public boolean isDelete = false;

            public void afterTextChanged(Editable editable) {
                String showAadharWithIntervals = ((DigitalMandateActivity) AadharFragment.this.getActivity()).showAadharWithIntervals(AadharFragment.this.et_aadhar_no.getText().toString().replaceAll("\\s", ""), 4);
                if (this.aadharLength < showAadharWithIntervals.length()) {
                    this.isDelete = false;
                } else {
                    this.isDelete = true;
                }
                String replaceAll = showAadharWithIntervals.substring(0, Math.min(6, showAadharWithIntervals.length())).replaceAll("\\s", "");
                if (AadharFragment.this.firstNumbers == null || !AadharFragment.this.firstNumbers.equals(replaceAll)) {
                    AadharFragment.this.firstNumbers = replaceAll;
                    AadharFragment.this.et_aadhar_no.setFilters(new InputFilter[]{new LengthFilter(14)});
                }
                if (showAadharWithIntervals.length() > 14) {
                    showAadharWithIntervals = showAadharWithIntervals.substring(0, 14);
                }
                AadharFragment.this.et_aadhar_no.removeTextChangedListener(this);
                int aadharMarkerPosition = ((DigitalMandateActivity) AadharFragment.this.getActivity()).getAadharMarkerPosition(AadharFragment.this.et_aadhar_no.getSelectionStart(), this.isDelete, 4);
                AadharFragment.this.et_aadhar_no.setText(showAadharWithIntervals);
                if (showAadharWithIntervals.length() != 11) {
                    EditText access$000 = AadharFragment.this.et_aadhar_no;
                    if (aadharMarkerPosition >= showAadharWithIntervals.length()) {
                        aadharMarkerPosition = showAadharWithIntervals.length();
                    }
                    access$000.setSelection(aadharMarkerPosition);
                } else {
                    AadharFragment.this.et_aadhar_no.setSelection(showAadharWithIntervals.length());
                }
                AadharFragment.this.et_aadhar_no.addTextChangedListener(this);
                if (showAadharWithIntervals.length() >= 14 && d.validateAadharNumber(showAadharWithIntervals.replaceAll("\\s", ""))) {
                    AadharFragment.this.et_account_holder_name.requestFocus();
                }
                this.aadharLength = showAadharWithIntervals.length();
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.et_ifsc_code.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (obj != null && !obj.isEmpty() && obj.trim().length() == 11) {
                    FragmentActivity activity = AadharFragment.this.getActivity();
                    AadharFragment.this.getActivity();
                    ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(AadharFragment.this.et_ifsc_code.getWindowToken(), 0);
                    ((DigitalMandateActivity) AadharFragment.this.getActivity()).getIFSCDetails(obj.trim());
                } else if (obj != null && !obj.isEmpty() && obj.trim().length() < 11) {
                    AadharFragment.this.lyt_bank_details.setVisibility(8);
                    AadharFragment.this.tv_bank_error_text.setVisibility(8);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        return inflate;
    }

    public void onPause() {
        super.onPause();
    }
}
