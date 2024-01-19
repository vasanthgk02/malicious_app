package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.view.ErrorView;

public abstract class ActivityEditorRouterBinding extends ViewDataBinding {
    public final AppCompatTextView downloadStatus;
    public final ErrorView errorLayout;
    public final AppCompatImageView logo;
    public final ProgressBar progressBar;
    public final AppCompatTextView progressPercent;

    public ActivityEditorRouterBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, ErrorView errorView, AppCompatImageView appCompatImageView, ProgressBar progressBar2, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.downloadStatus = appCompatTextView;
        this.errorLayout = errorView;
        this.logo = appCompatImageView;
        this.progressBar = progressBar2;
        this.progressPercent = appCompatTextView2;
    }

    public static ActivityEditorRouterBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ActivityEditorRouterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityEditorRouterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_editor_router, viewGroup, z, obj);
    }

    public static ActivityEditorRouterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ActivityEditorRouterBinding bind(View view, Object obj) {
        return (ActivityEditorRouterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_editor_router);
    }

    public static ActivityEditorRouterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ActivityEditorRouterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityEditorRouterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_editor_router, null, false, obj);
    }
}
