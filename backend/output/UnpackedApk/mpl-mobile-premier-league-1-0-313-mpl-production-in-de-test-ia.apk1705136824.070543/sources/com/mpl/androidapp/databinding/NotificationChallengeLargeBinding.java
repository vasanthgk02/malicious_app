package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationChallengeLargeBinding implements ViewBinding {
    public final ImageView notificationGroupIcon;
    public final TextView notificationPlayNow;
    public final ImageView notificationSenderAvatar;
    public final RelativeLayout rootView;

    public NotificationChallengeLargeBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.notificationGroupIcon = imageView;
        this.notificationPlayNow = textView;
        this.notificationSenderAvatar = imageView2;
    }

    public static NotificationChallengeLargeBinding bind(View view) {
        int i = R.id.notification_groupIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.notification_groupIcon);
        if (imageView != null) {
            i = R.id.notification_play_now;
            TextView textView = (TextView) view.findViewById(R.id.notification_play_now);
            if (textView != null) {
                i = R.id.notification_sender_avatar;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.notification_sender_avatar);
                if (imageView2 != null) {
                    return new NotificationChallengeLargeBinding((RelativeLayout) view, imageView, textView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationChallengeLargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationChallengeLargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_challenge_large, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
