package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;

public final class MsgItemLayoutNewBinding implements ViewBinding {
    public final LinearLayout rootView;
    public final SimpleDraweeView senderAvatar;
    public final TextView senderMsg;

    public MsgItemLayoutNewBinding(LinearLayout linearLayout, SimpleDraweeView simpleDraweeView, TextView textView) {
        this.rootView = linearLayout;
        this.senderAvatar = simpleDraweeView;
        this.senderMsg = textView;
    }

    public static MsgItemLayoutNewBinding bind(View view) {
        int i = R.id.sender_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.sender_avatar);
        if (simpleDraweeView != null) {
            i = R.id.sender_msg;
            TextView textView = (TextView) view.findViewById(R.id.sender_msg);
            if (textView != null) {
                return new MsgItemLayoutNewBinding((LinearLayout) view, simpleDraweeView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static MsgItemLayoutNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MsgItemLayoutNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.msg_item_layout_new, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
