package com.clevertap.android.sdk.inapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;

public class CTInAppHtmlFooterFragment extends CTInAppBasePartialHtmlFragment {
    public ViewGroup getLayout(View view) {
        return (ViewGroup) view.findViewById(R$id.inapp_html_footer_frame_layout);
    }

    public View getView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R$layout.inapp_html_footer, viewGroup, false);
    }
}
