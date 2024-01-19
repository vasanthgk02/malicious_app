package com.freshchat.consumer.sdk.m;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.k.k;

public class j extends a {
    public AppCompatEditText dS;
    public AppCompatButton dT;
    public k pc;

    private void g(View view) {
        this.dS = (AppCompatEditText) view.findViewById(R.id.freshchat_calendar_email_edittext);
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.freshchat_calendar_next_button);
        this.dT = appCompatButton;
        appCompatButton.setEnabled(false);
        this.dS.addTextChangedListener(new l(this));
        this.dT.setOnClickListener(new m(this));
        String bi = this.pc.bi();
        if (as.a(bi)) {
            this.dS.setText(bi);
        }
    }

    public void cc(Context context) {
        this.pc = new k(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.freshchat_fragment_calendar_email_entry, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g(view);
        view.post(new k(this, view));
    }
}
