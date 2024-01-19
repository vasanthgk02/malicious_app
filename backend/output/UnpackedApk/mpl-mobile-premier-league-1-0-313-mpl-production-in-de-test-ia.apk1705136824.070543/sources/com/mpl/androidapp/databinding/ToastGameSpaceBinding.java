package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;

public abstract class ToastGameSpaceBinding extends ViewDataBinding {
    public final ConstraintLayout cvToast;
    public final ConstraintLayout cvToastContainer;
    public final ImageView ivDone;
    public final TextView tvMessage;

    public ToastGameSpaceBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.cvToast = constraintLayout;
        this.cvToastContainer = constraintLayout2;
        this.ivDone = imageView;
        this.tvMessage = textView;
    }

    public static ToastGameSpaceBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ToastGameSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ToastGameSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.toast_game_space, viewGroup, z, obj);
    }

    public static ToastGameSpaceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ToastGameSpaceBinding bind(View view, Object obj) {
        return (ToastGameSpaceBinding) ViewDataBinding.bind(obj, view, R.layout.toast_game_space);
    }

    public static ToastGameSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ToastGameSpaceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ToastGameSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.toast_game_space, null, false, obj);
    }
}
