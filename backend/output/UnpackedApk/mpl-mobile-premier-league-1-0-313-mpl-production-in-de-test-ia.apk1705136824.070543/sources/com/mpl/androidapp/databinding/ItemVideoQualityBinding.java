package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;

public abstract class ItemVideoQualityBinding extends ViewDataBinding {
    public final AppCompatTextView quality;

    public ItemVideoQualityBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.quality = appCompatTextView;
    }

    public static ItemVideoQualityBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ItemVideoQualityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoQualityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_quality, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemVideoQualityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoQualityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_quality, null, false, obj);
    }

    @Deprecated
    public static ItemVideoQualityBinding bind(View view, Object obj) {
        return (ItemVideoQualityBinding) ViewDataBinding.bind(obj, view, R.layout.item_video_quality);
    }

    public static ItemVideoQualityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    public static ItemVideoQualityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }
}
