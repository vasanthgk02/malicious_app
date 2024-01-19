package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class SuspiciousAppFoundDialogBinding implements ViewBinding {
    public final Button dialogCancel;
    public final TextView dialogMsg;
    public final Button dialogOk;
    public final TextView dialogTitle;
    public final ConstraintLayout errorView;
    public final ConstraintLayout errorViewContentView;
    public final ImageView imgAction;
    public final ConstraintLayout rootView;
    public final TextView storageTxt;
    public final View view;

    public SuspiciousAppFoundDialogBinding(ConstraintLayout constraintLayout, Button button, TextView textView, Button button2, TextView textView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView3, View view2) {
        this.rootView = constraintLayout;
        this.dialogCancel = button;
        this.dialogMsg = textView;
        this.dialogOk = button2;
        this.dialogTitle = textView2;
        this.errorView = constraintLayout2;
        this.errorViewContentView = constraintLayout3;
        this.imgAction = imageView;
        this.storageTxt = textView3;
        this.view = view2;
    }

    public static SuspiciousAppFoundDialogBinding bind(View view2) {
        int i = R.id.dialog_cancel;
        Button button = (Button) view2.findViewById(R.id.dialog_cancel);
        if (button != null) {
            i = R.id.dialog_msg;
            TextView textView = (TextView) view2.findViewById(R.id.dialog_msg);
            if (textView != null) {
                i = R.id.dialog_ok;
                Button button2 = (Button) view2.findViewById(R.id.dialog_ok);
                if (button2 != null) {
                    i = R.id.dialog_title;
                    TextView textView2 = (TextView) view2.findViewById(R.id.dialog_title);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view2;
                        i = R.id.error_view_content_view;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.error_view_content_view);
                        if (constraintLayout2 != null) {
                            i = R.id.img_action;
                            ImageView imageView = (ImageView) view2.findViewById(R.id.img_action);
                            if (imageView != null) {
                                i = R.id.storageTxt;
                                TextView textView3 = (TextView) view2.findViewById(R.id.storageTxt);
                                if (textView3 != null) {
                                    i = R.id.view;
                                    View findViewById = view2.findViewById(R.id.view);
                                    if (findViewById != null) {
                                        SuspiciousAppFoundDialogBinding suspiciousAppFoundDialogBinding = new SuspiciousAppFoundDialogBinding(constraintLayout, button, textView, button2, textView2, constraintLayout, constraintLayout2, imageView, textView3, findViewById);
                                        return suspiciousAppFoundDialogBinding;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }

    public static SuspiciousAppFoundDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SuspiciousAppFoundDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.suspicious_app_found_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
