package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityDownloadBinding implements ViewBinding {
    public final Button download;
    public final ProgressBar progress;
    public final FrameLayout rootView;

    public ActivityDownloadBinding(FrameLayout frameLayout, Button button, ProgressBar progressBar) {
        this.rootView = frameLayout;
        this.download = button;
        this.progress = progressBar;
    }

    public static ActivityDownloadBinding bind(View view) {
        int i = R.id.download;
        Button button = (Button) view.findViewById(R.id.download);
        if (button != null) {
            i = R.id.progress;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
            if (progressBar != null) {
                return new ActivityDownloadBinding((FrameLayout) view, button, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_download, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
