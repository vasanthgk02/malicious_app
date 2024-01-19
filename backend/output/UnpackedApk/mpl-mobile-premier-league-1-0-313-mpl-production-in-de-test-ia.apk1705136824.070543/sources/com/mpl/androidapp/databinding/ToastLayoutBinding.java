package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ToastLayoutBinding implements ViewBinding {
    public final LinearLayout customToastLayout;
    public final TextView message;
    public final LinearLayout rootView;
    public final TextView title;

    public ToastLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.customToastLayout = linearLayout2;
        this.message = textView;
        this.title = textView2;
    }

    public static ToastLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.message;
        TextView textView = (TextView) view.findViewById(R.id.message);
        if (textView != null) {
            i = R.id.title;
            TextView textView2 = (TextView) view.findViewById(R.id.title);
            if (textView2 != null) {
                return new ToastLayoutBinding((LinearLayout) view, linearLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ToastLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToastLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.toast_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
