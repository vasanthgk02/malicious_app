package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityFacebookShareBinding implements ViewBinding {
    public final ProgressBar checkingUpdateProgress;
    public final LinearLayout contentLayout;
    public final RelativeLayout rootView;
    public final LinearLayout shareFacebook;

    public ActivityFacebookShareBinding(RelativeLayout relativeLayout, ProgressBar progressBar, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = relativeLayout;
        this.checkingUpdateProgress = progressBar;
        this.contentLayout = linearLayout;
        this.shareFacebook = linearLayout2;
    }

    public static ActivityFacebookShareBinding bind(View view) {
        int i = R.id.checking_update_progress;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.checking_update_progress);
        if (progressBar != null) {
            i = R.id.content_layout;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
            if (linearLayout != null) {
                i = R.id.share_facebook;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.share_facebook);
                if (linearLayout2 != null) {
                    return new ActivityFacebookShareBinding((RelativeLayout) view, progressBar, linearLayout, linearLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityFacebookShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFacebookShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_facebook_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
