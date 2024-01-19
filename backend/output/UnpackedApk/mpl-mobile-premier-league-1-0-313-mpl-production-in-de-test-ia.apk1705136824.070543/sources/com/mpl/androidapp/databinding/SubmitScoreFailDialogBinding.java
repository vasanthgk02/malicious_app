package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class SubmitScoreFailDialogBinding implements ViewBinding {
    public final Button dialogCancel;
    public final TextView dialogMsg;
    public final Button dialogOk;
    public final TextView dialogTitle;
    public final LinearLayout errorRootDialog;
    public final LinearLayout rootView;

    public SubmitScoreFailDialogBinding(LinearLayout linearLayout, Button button, TextView textView, Button button2, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.dialogCancel = button;
        this.dialogMsg = textView;
        this.dialogOk = button2;
        this.dialogTitle = textView2;
        this.errorRootDialog = linearLayout2;
    }

    public static SubmitScoreFailDialogBinding bind(View view) {
        int i = R.id.dialog_cancel;
        Button button = (Button) view.findViewById(R.id.dialog_cancel);
        if (button != null) {
            i = R.id.dialog_msg;
            TextView textView = (TextView) view.findViewById(R.id.dialog_msg);
            if (textView != null) {
                i = R.id.dialog_ok;
                Button button2 = (Button) view.findViewById(R.id.dialog_ok);
                if (button2 != null) {
                    i = R.id.dialog_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.dialog_title);
                    if (textView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        SubmitScoreFailDialogBinding submitScoreFailDialogBinding = new SubmitScoreFailDialogBinding(linearLayout, button, textView, button2, textView2, linearLayout);
                        return submitScoreFailDialogBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SubmitScoreFailDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SubmitScoreFailDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.submit_score_fail_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
