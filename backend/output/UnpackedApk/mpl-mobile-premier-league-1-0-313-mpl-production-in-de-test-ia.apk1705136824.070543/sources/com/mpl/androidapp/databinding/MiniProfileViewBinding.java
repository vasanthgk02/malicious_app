package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomBoldTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public abstract class MiniProfileViewBinding extends ViewDataBinding {
    public final LinearLayout backgroundGreyContainerId;
    public final Barrier barrier;
    public final Barrier barrier1;
    public final Guideline bottomStripHeaderId;
    public final CustomMediumTextView cashWonValueId;
    public final CustomMediumTextView followersValueId;
    public final CustomMediumTextView followingValueId;
    public final Guideline guideline16;
    public final Guideline guideline23;
    public final Guideline guideline7;
    public final Guideline guideline8;
    public final Guideline guideline9;
    public final ImageView imageView4;
    public final ImageView kycBadgeId;
    public final ImageView miniProfileBadge;
    public final CustomRegularTextView miniProfileDescription;
    public final CustomBoldTextView miniProfileDisplayName;
    public final ImageView miniProfileImgViewId;
    public final CustomBoldTextView miniProfilePersonName;
    public final CustomRegularTextView textView7;
    public final CustomRegularTextView textView8;
    public final CustomRegularTextView textView9;
    public final CustomMediumTextView viewProfileLeftBtnActionId;
    public final CustomMediumTextView viewProfileRightBtnActionId;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileViewBinding(Object obj, View view, int i, LinearLayout linearLayout, Barrier barrier2, Barrier barrier3, Guideline guideline, CustomMediumTextView customMediumTextView, CustomMediumTextView customMediumTextView2, CustomMediumTextView customMediumTextView3, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, ImageView imageView, ImageView imageView2, ImageView imageView3, CustomRegularTextView customRegularTextView, CustomBoldTextView customBoldTextView, ImageView imageView5, CustomBoldTextView customBoldTextView2, CustomRegularTextView customRegularTextView2, CustomRegularTextView customRegularTextView3, CustomRegularTextView customRegularTextView4, CustomMediumTextView customMediumTextView4, CustomMediumTextView customMediumTextView5) {
        super(obj, view, i);
        this.backgroundGreyContainerId = linearLayout;
        this.barrier = barrier2;
        this.barrier1 = barrier3;
        this.bottomStripHeaderId = guideline;
        this.cashWonValueId = customMediumTextView;
        this.followersValueId = customMediumTextView2;
        this.followingValueId = customMediumTextView3;
        this.guideline16 = guideline2;
        this.guideline23 = guideline3;
        this.guideline7 = guideline4;
        this.guideline8 = guideline5;
        this.guideline9 = guideline6;
        this.imageView4 = imageView;
        this.kycBadgeId = imageView2;
        this.miniProfileBadge = imageView3;
        this.miniProfileDescription = customRegularTextView;
        this.miniProfileDisplayName = customBoldTextView;
        this.miniProfileImgViewId = imageView5;
        this.miniProfilePersonName = customBoldTextView2;
        this.textView7 = customRegularTextView2;
        this.textView8 = customRegularTextView3;
        this.textView9 = customRegularTextView4;
        this.viewProfileLeftBtnActionId = customMediumTextView4;
        this.viewProfileRightBtnActionId = customMediumTextView5;
    }

    public static MiniProfileViewBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static MiniProfileViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static MiniProfileViewBinding bind(View view, Object obj) {
        return (MiniProfileViewBinding) ViewDataBinding.bind(obj, view, R.layout.mini_profile_view);
    }

    public static MiniProfileViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static MiniProfileViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MiniProfileViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mini_profile_view, viewGroup, z, obj);
    }

    @Deprecated
    public static MiniProfileViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MiniProfileViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mini_profile_view, null, false, obj);
    }
}
