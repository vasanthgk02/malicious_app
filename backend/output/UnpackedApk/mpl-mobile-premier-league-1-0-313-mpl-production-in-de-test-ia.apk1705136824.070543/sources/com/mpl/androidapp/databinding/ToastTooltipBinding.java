package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ToastTooltipBinding implements ViewBinding {
    public final LinearLayoutCompat customToastLayout;
    public final LinearLayoutCompat rootView;

    public ToastTooltipBinding(LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2) {
        this.rootView = linearLayoutCompat;
        this.customToastLayout = linearLayoutCompat2;
    }

    public static ToastTooltipBinding bind(View view) {
        if (view != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            return new ToastTooltipBinding(linearLayoutCompat, linearLayoutCompat);
        }
        throw new NullPointerException("rootView");
    }

    public static ToastTooltipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToastTooltipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.toast_tooltip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }
}
