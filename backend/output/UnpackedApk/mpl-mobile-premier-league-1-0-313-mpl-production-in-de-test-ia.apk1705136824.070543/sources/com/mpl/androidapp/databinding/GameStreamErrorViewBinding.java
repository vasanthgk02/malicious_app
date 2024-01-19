package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public abstract class GameStreamErrorViewBinding extends ViewDataBinding {
    public final ImageView connectivityImgId;
    public final Guideline guideline6;
    public final ImageView smallLineId;
    public final ImageView streamCloseId;
    public final CustomRegularTextView txtPleaseTryAgain;
    public final CustomMediumTextView txtSomethingWentWrong;
    public final CustomMediumTextView txtTryAgain;

    public GameStreamErrorViewBinding(Object obj, View view, int i, ImageView imageView, Guideline guideline, ImageView imageView2, ImageView imageView3, CustomRegularTextView customRegularTextView, CustomMediumTextView customMediumTextView, CustomMediumTextView customMediumTextView2) {
        super(obj, view, i);
        this.connectivityImgId = imageView;
        this.guideline6 = guideline;
        this.smallLineId = imageView2;
        this.streamCloseId = imageView3;
        this.txtPleaseTryAgain = customRegularTextView;
        this.txtSomethingWentWrong = customMediumTextView;
        this.txtTryAgain = customMediumTextView2;
    }

    public static GameStreamErrorViewBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static GameStreamErrorViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static GameStreamErrorViewBinding bind(View view, Object obj) {
        return (GameStreamErrorViewBinding) ViewDataBinding.bind(obj, view, R.layout.game_stream_error_view);
    }

    public static GameStreamErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static GameStreamErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GameStreamErrorViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.game_stream_error_view, viewGroup, z, obj);
    }

    @Deprecated
    public static GameStreamErrorViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GameStreamErrorViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.game_stream_error_view, null, false, obj);
    }
}
