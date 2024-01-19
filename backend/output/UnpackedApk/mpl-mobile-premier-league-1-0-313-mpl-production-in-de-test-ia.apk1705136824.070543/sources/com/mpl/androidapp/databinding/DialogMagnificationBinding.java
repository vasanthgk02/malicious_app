package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class DialogMagnificationBinding implements ViewBinding {
    public final TextView dialogMsg;
    public final TextView dialogTitle;
    public final LinearLayout magnificationRootDialog;
    public final LinearLayout rootView;

    public DialogMagnificationBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.dialogMsg = textView;
        this.dialogTitle = textView2;
        this.magnificationRootDialog = linearLayout2;
    }

    public static DialogMagnificationBinding bind(View view) {
        int i = R.id.dialog_msg;
        TextView textView = (TextView) view.findViewById(R.id.dialog_msg);
        if (textView != null) {
            i = R.id.dialog_title;
            TextView textView2 = (TextView) view.findViewById(R.id.dialog_title);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new DialogMagnificationBinding(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogMagnificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogMagnificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_magnification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
