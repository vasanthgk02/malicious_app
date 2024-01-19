package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.GameStreamErrorView;

public abstract class FragmentErrorViewBinding extends ViewDataBinding {
    public final GameStreamErrorView noConnectivityView;

    public FragmentErrorViewBinding(Object obj, View view, int i, GameStreamErrorView gameStreamErrorView) {
        super(obj, view, i);
        this.noConnectivityView = gameStreamErrorView;
    }

    public static FragmentErrorViewBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static FragmentErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentErrorViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_error_view, viewGroup, z, obj);
    }

    @Deprecated
    public static FragmentErrorViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentErrorViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_error_view, null, false, obj);
    }

    @Deprecated
    public static FragmentErrorViewBinding bind(View view, Object obj) {
        return (FragmentErrorViewBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_error_view);
    }

    public static FragmentErrorViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    public static FragmentErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }
}
