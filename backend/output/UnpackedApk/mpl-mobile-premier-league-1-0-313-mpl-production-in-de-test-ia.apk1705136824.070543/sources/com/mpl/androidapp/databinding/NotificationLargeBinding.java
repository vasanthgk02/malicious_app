package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class NotificationLargeBinding implements ViewBinding {
    public final ImageView rootView;

    public NotificationLargeBinding(ImageView imageView) {
        this.rootView = imageView;
    }

    public static NotificationLargeBinding bind(View view) {
        if (view != null) {
            return new NotificationLargeBinding((ImageView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static NotificationLargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationLargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_large, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ImageView getRoot() {
        return this.rootView;
    }
}
