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

public final class DlgWebviewGameExitWindowBinding implements ViewBinding {
    public final AppCompatButton cancel;
    public final AppCompatTextView description;
    public final AppCompatImageView errorIcon;
    public final View gestureBar;
    public final AppCompatTextView header;
    public final AppCompatButton retry;
    public final ConstraintLayout rootView;

    public DlgWebviewGameExitWindowBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, View view, AppCompatTextView appCompatTextView2, AppCompatButton appCompatButton2) {
        this.rootView = constraintLayout;
        this.cancel = appCompatButton;
        this.description = appCompatTextView;
        this.errorIcon = appCompatImageView;
        this.gestureBar = view;
        this.header = appCompatTextView2;
        this.retry = appCompatButton2;
    }

    public static DlgWebviewGameExitWindowBinding bind(View view) {
        int i = R.id.cancel;
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.cancel);
        if (appCompatButton != null) {
            i = R.id.description;
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
                            AppCompatButton appCompatButton2 = (AppCompatButton) view.findViewById(R.id.retry);
                            if (appCompatButton2 != null) {
                                DlgWebviewGameExitWindowBinding dlgWebviewGameExitWindowBinding = new DlgWebviewGameExitWindowBinding((ConstraintLayout) view, appCompatButton, appCompatTextView, appCompatImageView, findViewById, appCompatTextView2, appCompatButton2);
                                return dlgWebviewGameExitWindowBinding;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DlgWebviewGameExitWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DlgWebviewGameExitWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dlg_webview_game_exit_window, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
