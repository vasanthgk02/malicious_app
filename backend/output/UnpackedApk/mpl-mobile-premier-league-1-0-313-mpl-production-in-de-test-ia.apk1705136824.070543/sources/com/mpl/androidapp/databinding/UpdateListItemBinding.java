package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;

public final class UpdateListItemBinding implements ViewBinding {
    public final LinearLayout rootView;
    public final SimpleDraweeView updateIcon;
    public final TextView updateText;

    public UpdateListItemBinding(LinearLayout linearLayout, SimpleDraweeView simpleDraweeView, TextView textView) {
        this.rootView = linearLayout;
        this.updateIcon = simpleDraweeView;
        this.updateText = textView;
    }

    public static UpdateListItemBinding bind(View view) {
        int i = R.id.update_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.update_icon);
        if (simpleDraweeView != null) {
            i = R.id.update_text;
            TextView textView = (TextView) view.findViewById(R.id.update_text);
            if (textView != null) {
                return new UpdateListItemBinding((LinearLayout) view, simpleDraweeView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static UpdateListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdateListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.update_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
