package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;

public abstract class ViewExternalShareBinding extends ViewDataBinding {
    public final AppCompatImageView copyLinkIcon;
    public final AppCompatTextView copyLinkText;
    public final AppCompatImageView instagramIcon;
    public final AppCompatTextView instagramText;
    public final AppCompatImageView telegramIcon;
    public final AppCompatTextView telegramText;
    public final AppCompatImageView whatsappIcon;
    public final AppCompatTextView whatsappText;

    public ViewExternalShareBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView4) {
        super(obj, view, i);
        this.copyLinkIcon = appCompatImageView;
        this.copyLinkText = appCompatTextView;
        this.instagramIcon = appCompatImageView2;
        this.instagramText = appCompatTextView2;
        this.telegramIcon = appCompatImageView3;
        this.telegramText = appCompatTextView3;
        this.whatsappIcon = appCompatImageView4;
        this.whatsappText = appCompatTextView4;
    }

    public static ViewExternalShareBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static ViewExternalShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ViewExternalShareBinding bind(View view, Object obj) {
        return (ViewExternalShareBinding) ViewDataBinding.bind(obj, view, R.layout.view_external_share);
    }

    public static ViewExternalShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ViewExternalShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewExternalShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_external_share, viewGroup, z, obj);
    }

    @Deprecated
    public static ViewExternalShareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewExternalShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_external_share, null, false, obj);
    }
}
