package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class DlgWebviewGameConnWindowBinding implements ViewBinding {
    public final AppCompatTextView description;
    public final AppCompatImageView errorIcon;
    public final View gestureBar;
    public final AppCompatTextView header;
    public final AppCompatButton retry;
    public final ConstraintLayout rootView;

    public DlgWebviewGameConnWindowBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, View view, AppCompatTextView appCompatTextView2, AppCompatButton appCompatButton) {
        this.rootView = constraintLayout;
        this.description = appCompatTextView;
        this.errorIcon = appCompatImageView;
        this.gestureBar = view;
        this.header = appCompatTextView2;
        this.retry = appCompatButton;
    }

    public static DlgWebviewGameConnWindowBinding bind(View view) {
        int i = R.id.description;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.description);
        if (appCompatTextView != null) {
            i = R.id.error_icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.error_icon);
            if (appCompatImageView != null) {
                i = R.id.gesture_bar;
                View findViewById = view.findViewById(R.id.gesture_bar);
                if (findViewById != null) {
                    i = R.id.header;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.header);
                    if (appCompatTextView2 != null) {
                        i = R.id.retry;
                        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.retry);
                        if (appCompatButton != null) {
                            DlgWebviewGameConnWindowBinding dlgWebviewGameConnWindowBinding = new DlgWebviewGameConnWindowBinding((ConstraintLayout) view, appCompatTextView, appCompatImageView, findViewById, appCompatTextView2, appCompatButton);
                            return dlgWebviewGameConnWindowBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DlgWebviewGameConnWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DlgWebviewGameConnWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dlg_webview_game_conn_window, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
