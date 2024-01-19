package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class DlgDownloaderDisabledContainerBinding implements ViewBinding {
    public final AppCompatTextView description;
    public final AppCompatImageView errorIcon;
    public final Guideline guideline17;
    public final Guideline guideline25;
    public final AppCompatTextView header;
    public final AppCompatButton retry;
    public final ConstraintLayout rootView;

    public DlgDownloaderDisabledContainerBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, Guideline guideline, Guideline guideline2, AppCompatTextView appCompatTextView2, AppCompatButton appCompatButton) {
        this.rootView = constraintLayout;
        this.description = appCompatTextView;
        this.errorIcon = appCompatImageView;
        this.guideline17 = guideline;
        this.guideline25 = guideline2;
        this.header = appCompatTextView2;
        this.retry = appCompatButton;
    }

    public static DlgDownloaderDisabledContainerBinding bind(View view) {
        int i = R.id.description;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.description);
        if (appCompatTextView != null) {
            i = R.id.error_icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.error_icon);
            if (appCompatImageView != null) {
                i = R.id.guideline17;
                Guideline guideline = (Guideline) view.findViewById(R.id.guideline17);
                if (guideline != null) {
                    i = R.id.guideline25;
                    Guideline guideline2 = (Guideline) view.findViewById(R.id.guideline25);
                    if (guideline2 != null) {
                        i = R.id.header;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.header);
                        if (appCompatTextView2 != null) {
                            i = R.id.retry;
                            AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.retry);
                            if (appCompatButton != null) {
                                DlgDownloaderDisabledContainerBinding dlgDownloaderDisabledContainerBinding = new DlgDownloaderDisabledContainerBinding((ConstraintLayout) view, appCompatTextView, appCompatImageView, guideline, guideline2, appCompatTextView2, appCompatButton);
                                return dlgDownloaderDisabledContainerBinding;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DlgDownloaderDisabledContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DlgDownloaderDisabledContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dlg_downloader_disabled_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
