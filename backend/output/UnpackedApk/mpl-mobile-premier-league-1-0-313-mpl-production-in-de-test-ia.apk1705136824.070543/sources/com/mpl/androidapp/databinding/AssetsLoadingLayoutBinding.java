package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class AssetsLoadingLayoutBinding implements ViewBinding {
    public final ProgressBar assetsDownloadProgress;
    public final ConstraintLayout assetsLoadingLayout;
    public final Guideline guideline;
    public final AppCompatTextView header;
    public final AppCompatImageView logo;
    public final AppCompatTextView networkError;
    public final AppCompatTextView progressText;
    public final ConstraintLayout rootView;
    public final AppCompatTextView tipsText;

    public AssetsLoadingLayoutBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, Guideline guideline2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.rootView = constraintLayout;
        this.assetsDownloadProgress = progressBar;
        this.assetsLoadingLayout = constraintLayout2;
        this.guideline = guideline2;
        this.header = appCompatTextView;
        this.logo = appCompatImageView;
        this.networkError = appCompatTextView2;
        this.progressText = appCompatTextView3;
        this.tipsText = appCompatTextView4;
    }

    public static AssetsLoadingLayoutBinding bind(View view) {
        int i = R.id.assets_download_progress;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.assets_download_progress);
        if (progressBar != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.guideline;
            Guideline guideline2 = (Guideline) view.findViewById(R.id.guideline);
            if (guideline2 != null) {
                i = R.id.header;
                AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.header);
                if (appCompatTextView != null) {
                    i = R.id.logo;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.logo);
                    if (appCompatImageView != null) {
                        i = R.id.network_error;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.network_error);
                        if (appCompatTextView2 != null) {
                            i = R.id.progress_text;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) view.findViewById(R.id.progress_text);
                            if (appCompatTextView3 != null) {
                                i = R.id.tips_text;
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) view.findViewById(R.id.tips_text);
                                if (appCompatTextView4 != null) {
                                    AssetsLoadingLayoutBinding assetsLoadingLayoutBinding = new AssetsLoadingLayoutBinding(constraintLayout, progressBar, constraintLayout, guideline2, appCompatTextView, appCompatImageView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                    return assetsLoadingLayoutBinding;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AssetsLoadingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AssetsLoadingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.assets_loading_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
