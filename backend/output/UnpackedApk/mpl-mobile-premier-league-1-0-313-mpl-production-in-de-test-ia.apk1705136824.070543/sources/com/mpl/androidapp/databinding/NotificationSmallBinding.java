package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationSmallBinding implements ViewBinding {
    public final RelativeLayout rootView;

    public NotificationSmallBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    public static NotificationSmallBinding bind(View view) {
        if (view != null) {
            return new NotificationSmallBinding((RelativeLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static NotificationSmallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationSmallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_small, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
