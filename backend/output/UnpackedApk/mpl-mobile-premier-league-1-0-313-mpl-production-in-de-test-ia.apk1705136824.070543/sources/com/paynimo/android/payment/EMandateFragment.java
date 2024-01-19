package com.paynimo.android.payment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class EMandateFragment extends Fragment {
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(getResources().getIdentifier("paynimo_fragment_emandate", "layout", getActivity().getPackageName()), viewGroup, false);
    }

    public void onPause() {
        super.onPause();
    }
}
