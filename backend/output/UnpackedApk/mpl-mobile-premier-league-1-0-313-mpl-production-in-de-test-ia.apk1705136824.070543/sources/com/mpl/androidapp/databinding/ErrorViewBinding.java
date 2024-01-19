package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;

public abstract class ErrorViewBinding extends ViewDataBinding {
    public final AppCompatImageView icon;
    public final AppCompatTextView message;

    public ErrorViewBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.icon = appCompatImageView;
        this.message = appCompatTextView;
    }

    public static ErrorViewBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ErrorViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.error_view, viewGroup, z, obj);
    }

    public static ErrorViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ErrorViewBinding bind(View view, Object obj) {
        return (ErrorViewBinding) ViewDataBinding.bind(obj, view, R.layout.error_view);
    }

    public static ErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ErrorViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ErrorViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.error_view, null, false, obj);
    }
}
