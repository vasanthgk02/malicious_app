package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;

public final class ContentShareMplBinding implements ViewBinding {
    public final ConstraintLayout rootView;
    public final SimpleDraweeView shareImage;
    public final TextView shareText;

    public ContentShareMplBinding(ConstraintLayout constraintLayout, SimpleDraweeView simpleDraweeView, TextView textView) {
        this.rootView = constraintLayout;
        this.shareImage = simpleDraweeView;
        this.shareText = textView;
    }

    public static ContentShareMplBinding bind(View view) {
        int i = R.id.share_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.share_image);
        if (simpleDraweeView != null) {
            i = R.id.share_text;
            TextView textView = (TextView) view.findViewById(R.id.share_text);
            if (textView != null) {
                return new ContentShareMplBinding((ConstraintLayout) view, simpleDraweeView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ContentShareMplBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ContentShareMplBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.content_share_mpl, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
