package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationStickyLargeBinding implements ViewBinding {
    public final ImageView notificationGroupIcon;
    public final ImageView notificationSenderAvatar;
    public final RelativeLayout rootView;

    public NotificationStickyLargeBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.notificationGroupIcon = imageView;
        this.notificationSenderAvatar = imageView2;
    }

    public static NotificationStickyLargeBinding bind(View view) {
        int i = R.id.notification_groupIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.notification_groupIcon);
        if (imageView != null) {
            i = R.id.notification_sender_avatar;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.notification_sender_avatar);
            if (imageView2 != null) {
                return new NotificationStickyLargeBinding((RelativeLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationStickyLargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationStickyLargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_sticky_large, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}