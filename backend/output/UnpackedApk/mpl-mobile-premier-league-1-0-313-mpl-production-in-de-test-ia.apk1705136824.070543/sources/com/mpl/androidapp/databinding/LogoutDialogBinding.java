package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class LogoutDialogBinding implements ViewBinding {
    public final TextView dialogMsg;
    public final Button dialogOk;
    public final LinearLayout errorRootDialog;
    public final ProgressBar logoutProgress;
    public final LinearLayout rootView;

    public LogoutDialogBinding(LinearLayout linearLayout, TextView textView, Button button, LinearLayout linearLayout2, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.dialogMsg = textView;
        this.dialogOk = button;
        this.errorRootDialog = linearLayout2;
        this.logoutProgress = progressBar;
    }

    public static LogoutDialogBinding bind(View view) {
        int i = R.id.dialog_msg;
        TextView textView = (TextView) view.findViewById(R.id.dialog_msg);
        if (textView != null) {
            i = R.id.dialog_ok;
            Button button = (Button) view.findViewById(R.id.dialog_ok);
            if (button != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.logout_progress;
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.logout_progress);
                if (progressBar != null) {
                    LogoutDialogBinding logoutDialogBinding = new LogoutDialogBinding(linearLayout, textView, button, linearLayout, progressBar);
                    return logoutDialogBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LogoutDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LogoutDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.logout_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
