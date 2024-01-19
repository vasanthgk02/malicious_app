package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationContentLayoutBinding implements ViewBinding {
    public final LinearLayout notificationContent;
    public final TextView notificationMsg;
    public final TextView notificationTitle;
    public final LinearLayout rootView;

    public NotificationContentLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.notificationContent = linearLayout2;
        this.notificationMsg = textView;
        this.notificationTitle = textView2;
    }

    public static NotificationContentLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.notification_msg;
        TextView textView = (TextView) view.findViewById(R.id.notification_msg);
        if (textView != null) {
            i = R.id.notification_title;
            TextView textView2 = (TextView) view.findViewById(R.id.notification_title);
            if (textView2 != null) {
                return new NotificationContentLayoutBinding((LinearLayout) view, linearLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationContentLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationContentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_content_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
