package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationGroupChallengeBigLayoutBinding implements ViewBinding {
    public final LinearLayout actionLayout;
    public final ImageView notificationGameIcon;
    public final ImageView notificationGroupIcon;
    public final TextView notificationOpenGroup;
    public final TextView notificationReply;
    public final ImageView notificationSenderAvatar;
    public final RelativeLayout rootView;

    public NotificationGroupChallengeBigLayoutBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ImageView imageView3) {
        this.rootView = relativeLayout;
        this.actionLayout = linearLayout;
        this.notificationGameIcon = imageView;
        this.notificationGroupIcon = imageView2;
        this.notificationOpenGroup = textView;
        this.notificationReply = textView2;
        this.notificationSenderAvatar = imageView3;
    }

    public static NotificationGroupChallengeBigLayoutBinding bind(View view) {
        int i = R.id.action_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.action_layout);
        if (linearLayout != null) {
            i = R.id.notification_gameIcon;
            ImageView imageView = (ImageView) view.findViewById(R.id.notification_gameIcon);
            if (imageView != null) {
                i = R.id.notification_groupIcon;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.notification_groupIcon);
                if (imageView2 != null) {
                    i = R.id.notification_open_group;
                    TextView textView = (TextView) view.findViewById(R.id.notification_open_group);
                    if (textView != null) {
                        i = R.id.notification_reply;
                        TextView textView2 = (TextView) view.findViewById(R.id.notification_reply);
                        if (textView2 != null) {
                            i = R.id.notification_sender_avatar;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.notification_sender_avatar);
                            if (imageView3 != null) {
                                NotificationGroupChallengeBigLayoutBinding notificationGroupChallengeBigLayoutBinding = new NotificationGroupChallengeBigLayoutBinding((RelativeLayout) view, linearLayout, imageView, imageView2, textView, textView2, imageView3);
                                return notificationGroupChallengeBigLayoutBinding;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationGroupChallengeBigLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationGroupChallengeBigLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_group_challenge_big_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
