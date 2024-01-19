package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class AutoStartPermissionLayoutBinding implements ViewBinding {
    public final TextView autoStartButton;
    public final TextView autoStartTitle;
    public final LinearLayout autoStartToastLayout;
    public final LinearLayout rootView;

    public AutoStartPermissionLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.autoStartButton = textView;
        this.autoStartTitle = textView2;
        this.autoStartToastLayout = linearLayout2;
    }

    public static AutoStartPermissionLayoutBinding bind(View view) {
        int i = R.id.auto_start_button;
        TextView textView = (TextView) view.findViewById(R.id.auto_start_button);
        if (textView != null) {
            i = R.id.auto_start_title;
            TextView textView2 = (TextView) view.findViewById(R.id.auto_start_title);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new AutoStartPermissionLayoutBinding(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AutoStartPermissionLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AutoStartPermissionLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.auto_start_permission_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
