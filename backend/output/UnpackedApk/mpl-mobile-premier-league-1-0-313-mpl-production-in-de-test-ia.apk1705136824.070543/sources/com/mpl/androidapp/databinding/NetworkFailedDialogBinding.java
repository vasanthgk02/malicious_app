package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NetworkFailedDialogBinding implements ViewBinding {
    public final TextView dialogMsg;
    public final Button dialogOk;
    public final TextView dialogTitle;
    public final LinearLayout errorRootDialog;
    public final LinearLayout rootView;

    public NetworkFailedDialogBinding(LinearLayout linearLayout, TextView textView, Button button, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.dialogMsg = textView;
        this.dialogOk = button;
        this.dialogTitle = textView2;
        this.errorRootDialog = linearLayout2;
    }

    public static NetworkFailedDialogBinding bind(View view) {
        int i = R.id.dialog_msg;
        TextView textView = (TextView) view.findViewById(R.id.dialog_msg);
        if (textView != null) {
            i = R.id.dialog_ok;
            Button button = (Button) view.findViewById(R.id.dialog_ok);
            if (button != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) view.findViewById(R.id.dialog_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    NetworkFailedDialogBinding networkFailedDialogBinding = new NetworkFailedDialogBinding(linearLayout, textView, button, textView2, linearLayout);
                    return networkFailedDialogBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NetworkFailedDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NetworkFailedDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.network_failed_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
