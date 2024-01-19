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

public final class FragmentAppsealingDialogBinding implements ViewBinding {
    public final Button closeBtn;
    public final TextView dialogMsg;
    public final TextView dialogTitle;
    public final ImageView imgAction;
    public final ConstraintLayout rootView;
    public final View view;

    public FragmentAppsealingDialogBinding(ConstraintLayout constraintLayout, Button button, TextView textView, TextView textView2, ImageView imageView, View view2) {
        this.rootView = constraintLayout;
        this.closeBtn = button;
        this.dialogMsg = textView;
        this.dialogTitle = textView2;
        this.imgAction = imageView;
        this.view = view2;
    }

    public static FragmentAppsealingDialogBinding bind(View view2) {
        int i = R.id.close_btn;
        Button button = (Button) view2.findViewById(R.id.close_btn);
        if (button != null) {
            i = R.id.dialog_msg;
            TextView textView = (TextView) view2.findViewById(R.id.dialog_msg);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) view2.findViewById(R.id.dialog_title);
                if (textView2 != null) {
                    i = R.id.img_action;
                    ImageView imageView = (ImageView) view2.findViewById(R.id.img_action);
                    if (imageView != null) {
                        i = R.id.view;
                        View findViewById = view2.findViewById(R.id.view);
                        if (findViewById != null) {
                            FragmentAppsealingDialogBinding fragmentAppsealingDialogBinding = new FragmentAppsealingDialogBinding((ConstraintLayout) view2, button, textView, textView2, imageView, findViewById);
                            return fragmentAppsealingDialogBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }

    public static FragmentAppsealingDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAppsealingDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_appsealing_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
