package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;

public abstract class ContentGameManagmentBinding extends ViewDataBinding {
    public ContentGameManagmentBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ContentGameManagmentBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ContentGameManagmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ContentGameManagmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.content_game_managment, viewGroup, z, obj);
    }

    @Deprecated
    public static ContentGameManagmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ContentGameManagmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.content_game_managment, null, false, obj);
    }

    @Deprecated
    public static ContentGameManagmentBinding bind(View view, Object obj) {
        return (ContentGameManagmentBinding) ViewDataBinding.bind(obj, view, R.layout.content_game_managment);
    }

    public static ContentGameManagmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    public static ContentGameManagmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }
}
