package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class AssetsDownloadProgressBinding implements ViewBinding {
    public final TextView dialogTitle;
    public final LinearLayout errorRootDialog;
    public final LinearLayout rootView;

    public AssetsDownloadProgressBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.dialogTitle = textView;
        this.errorRootDialog = linearLayout2;
    }

    public static AssetsDownloadProgressBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.dialog_title);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new AssetsDownloadProgressBinding(linearLayout, textView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.dialog_title)));
    }

    public static AssetsDownloadProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AssetsDownloadProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.assets_download_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
