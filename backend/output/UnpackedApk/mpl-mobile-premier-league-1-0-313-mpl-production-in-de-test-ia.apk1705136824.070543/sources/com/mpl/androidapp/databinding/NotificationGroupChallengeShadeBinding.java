package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationGroupChallengeShadeBinding implements ViewBinding {
    public final ImageView notificationGameIcon;
    public final ImageView notificationGroupIcon;
    public final ImageView notificationSenderAvatar;
    public final RelativeLayout rootView;

    public NotificationGroupChallengeShadeBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.rootView = relativeLayout;
        this.notificationGameIcon = imageView;
        this.notificationGroupIcon = imageView2;
        this.notificationSenderAvatar = imageView3;
    }

    public static NotificationGroupChallengeShadeBinding bind(View view) {
        int i = R.id.notification_gameIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.notification_gameIcon);
        if (imageView != null) {
            i = R.id.notification_groupIcon;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.notification_groupIcon);
            if (imageView2 != null) {
                i = R.id.notification_sender_avatar;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.notification_sender_avatar);
                if (imageView3 != null) {
                    return new NotificationGroupChallengeShadeBinding((RelativeLayout) view, imageView, imageView2, imageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationGroupChallengeShadeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationGroupChallengeShadeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_group_challenge_shade, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}