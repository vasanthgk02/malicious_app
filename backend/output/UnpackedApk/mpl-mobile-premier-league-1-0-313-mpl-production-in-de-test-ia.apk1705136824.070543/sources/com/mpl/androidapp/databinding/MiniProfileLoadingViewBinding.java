package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;

public abstract class MiniProfileLoadingViewBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final Guideline guideline10;
    public final Guideline guideline11;
    public final Guideline guideline12;
    public final Guideline guideline13;
    public final Guideline guideline14;
    public final Guideline guideline16;
    public final Guideline guideline18;
    public final Guideline guideline19;
    public final Guideline guideline21;
    public final Guideline guideline23;
    public final Guideline guideline7;
    public final Guideline guideline8;
    public final Guideline guideline9;
    public final ImageView miniProfileBadge;
    public final ImageView miniProfileDescription;
    public final ImageView miniProfilePersonName;
    public final ImageView textView12;
    public final ImageView textView13;
    public final ImageView textView14;
    public final CustomMediumTextView viewProfileLoadingLeftBtnActionId;
    public final CustomMediumTextView viewProfileLoadingRightBtnActionId;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileLoadingViewBinding(Object obj, View view, int i, Barrier barrier2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline15, Guideline guideline17, Guideline guideline20, Guideline guideline22, Guideline guideline24, Guideline guideline25, Guideline guideline26, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, CustomMediumTextView customMediumTextView, CustomMediumTextView customMediumTextView2) {
        super(obj, view, i);
        this.barrier = barrier2;
        this.guideline10 = guideline;
        this.guideline11 = guideline2;
        this.guideline12 = guideline3;
        this.guideline13 = guideline4;
        this.guideline14 = guideline5;
        this.guideline16 = guideline6;
        this.guideline18 = guideline15;
        this.guideline19 = guideline17;
        this.guideline21 = guideline20;
        this.guideline23 = guideline22;
        this.guideline7 = guideline24;
        this.guideline8 = guideline25;
        this.guideline9 = guideline26;
        this.miniProfileBadge = imageView;
        this.miniProfileDescription = imageView2;
        this.miniProfilePersonName = imageView3;
        this.textView12 = imageView4;
        this.textView13 = imageView5;
        this.textView14 = imageView6;
        this.viewProfileLoadingLeftBtnActionId = customMediumTextView;
        this.viewProfileLoadingRightBtnActionId = customMediumTextView2;
    }

    public static MiniProfileLoadingViewBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static MiniProfileLoadingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static MiniProfileLoadingViewBinding bind(View view, Object obj) {
        return (MiniProfileLoadingViewBinding) ViewDataBinding.bind(obj, view, R.layout.mini_profile_loading_view);
    }

    public static MiniProfileLoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static MiniProfileLoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MiniProfileLoadingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mini_profile_loading_view, viewGroup, z, obj);
    }

    @Deprecated
    public static MiniProfileLoadingViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MiniProfileLoadingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mini_profile_loading_view, null, false, obj);
    }
}
