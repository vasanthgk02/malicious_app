package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class DlgDownloaderDisabledBinding implements ViewBinding {
    public final ImageView closeActionId;
    public final DlgDownloaderDisabledContainerBinding contentsContainerId;
    public final LinearLayout rootView;

    public DlgDownloaderDisabledBinding(LinearLayout linearLayout, ImageView imageView, DlgDownloaderDisabledContainerBinding dlgDownloaderDisabledContainerBinding) {
        this.rootView = linearLayout;
        this.closeActionId = imageView;
        this.contentsContainerId = dlgDownloaderDisabledContainerBinding;
    }

    public static DlgDownloaderDisabledBinding bind(View view) {
        int i = R.id.closeActionId;
        ImageView imageView = (ImageView) view.findViewById(R.id.closeActionId);
        if (imageView != null) {
            i = R.id.contentsContainerId;
            View findViewById = view.findViewById(R.id.contentsContainerId);
            if (findViewById != null) {
                return new DlgDownloaderDisabledBinding((LinearLayout) view, imageView, DlgDownloaderDisabledContainerBinding.bind(findViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DlgDownloaderDisabledBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DlgDownloaderDisabledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dlg_downloader_disabled, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
