package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ApkDownloadNotificationBinding implements ViewBinding {
    public final ProgressBar apkDownloadProgress;
    public final TextView downloadPercentage;
    public final TextView gameName;
    public final TextView gameStatus;
    public final ImageView notificationGameIcon;
    public final RelativeLayout rootView;

    public ApkDownloadNotificationBinding(RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, ImageView imageView) {
        this.rootView = relativeLayout;
        this.apkDownloadProgress = progressBar;
        this.downloadPercentage = textView;
        this.gameName = textView2;
        this.gameStatus = textView3;
        this.notificationGameIcon = imageView;
    }

    public static ApkDownloadNotificationBinding bind(View view) {
        int i = R.id.apkDownloadProgress;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.apkDownloadProgress);
        if (progressBar != null) {
            i = R.id.downloadPercentage;
            TextView textView = (TextView) view.findViewById(R.id.downloadPercentage);
            if (textView != null) {
                i = R.id.gameName;
                TextView textView2 = (TextView) view.findViewById(R.id.gameName);
                if (textView2 != null) {
                    i = R.id.gameStatus;
                    TextView textView3 = (TextView) view.findViewById(R.id.gameStatus);
                    if (textView3 != null) {
                        i = R.id.notification_gameIcon;
                        ImageView imageView = (ImageView) view.findViewById(R.id.notification_gameIcon);
                        if (imageView != null) {
                            ApkDownloadNotificationBinding apkDownloadNotificationBinding = new ApkDownloadNotificationBinding((RelativeLayout) view, progressBar, textView, textView2, textView3, imageView);
                            return apkDownloadNotificationBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ApkDownloadNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ApkDownloadNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.apk_download_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
