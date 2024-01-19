package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationSmallStickyBinding implements ViewBinding {
    public final TextView mpl;
    public final ImageView notificationGroupIcon;
    public final ImageView notificationSenderAvatar;
    public final TextView notificationTitle;
    public final RelativeLayout rootView;

    public NotificationSmallStickyBinding(RelativeLayout relativeLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2) {
        this.rootView = relativeLayout;
        this.mpl = textView;
        this.notificationGroupIcon = imageView;
        this.notificationSenderAvatar = imageView2;
        this.notificationTitle = textView2;
    }

    public static NotificationSmallStickyBinding bind(View view) {
        int i = R.id.mpl;
        TextView textView = (TextView) view.findViewById(R.id.mpl);
        if (textView != null) {
            i = R.id.notification_groupIcon;
            ImageView imageView = (ImageView) view.findViewById(R.id.notification_groupIcon);
            if (imageView != null) {
                i = R.id.notification_sender_avatar;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.notification_sender_avatar);
                if (imageView2 != null) {
                    i = R.id.notification_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.notification_title);
                    if (textView2 != null) {
                        NotificationSmallStickyBinding notificationSmallStickyBinding = new NotificationSmallStickyBinding((RelativeLayout) view, textView, imageView, imageView2, textView2);
                        return notificationSmallStickyBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationSmallStickyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationSmallStickyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_small_sticky, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
