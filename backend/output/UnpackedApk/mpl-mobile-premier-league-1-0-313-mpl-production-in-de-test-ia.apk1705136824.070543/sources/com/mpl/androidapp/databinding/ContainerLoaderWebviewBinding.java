package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.mpl.androidapp.R;

public final class ContainerLoaderWebviewBinding implements ViewBinding {
    public final ProgressBar assetsDownloadProgress;
    public final ConstraintLayout assetsLoadingLayout;
    public final Guideline guideline;
    public final AppCompatTextView header;
    public final ConstraintLayout logo;
    public final ShapeableImageView logoOne;
    public final AppCompatTextView networkError;
    public final AppCompatTextView progressText;
    public final ConstraintLayout rootView;
    public final AppCompatTextView tipsText;

    public ContainerLoaderWebviewBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, Guideline guideline2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout3, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.rootView = constraintLayout;
        this.assetsDownloadProgress = progressBar;
        this.assetsLoadingLayout = constraintLayout2;
        this.guideline = guideline2;
        this.header = appCompatTextView;
        this.logo = constraintLayout3;
        this.logoOne = shapeableImageView;
        this.networkError = appCompatTextView2;
        this.progressText = appCompatTextView3;
        this.tipsText = appCompatTextView4;
    }

    public static ContainerLoaderWebviewBinding bind(View view) {
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
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.logo);
                    if (constraintLayout2 != null) {
                        i = R.id.logo_one;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.logo_one);
                        if (shapeableImageView != null) {
                            i = R.id.network_error;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.network_error);
                            if (appCompatTextView2 != null) {
                                i = R.id.progress_text;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) view.findViewById(R.id.progress_text);
                                if (appCompatTextView3 != null) {
                                    i = R.id.tips_text;
                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) view.findViewById(R.id.tips_text);
                                    if (appCompatTextView4 != null) {
                                        ContainerLoaderWebviewBinding containerLoaderWebviewBinding = new ContainerLoaderWebviewBinding(constraintLayout, progressBar, constraintLayout, guideline2, appCompatTextView, constraintLayout2, shapeableImageView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                        return containerLoaderWebviewBinding;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ContainerLoaderWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ContainerLoaderWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.container_loader_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
