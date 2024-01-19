package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public final class ListItemGamebroadcastMessageBinding implements ViewBinding {
    public final ConstraintLayout clMsgBubble;
    public final ShapeableImageView ivChatAvatar;
    public final LinearLayout rootView;
    public final CustomRegularTextView tvChatMessage;
    public final CustomMediumTextView tvChatUserName;

    public ListItemGamebroadcastMessageBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, CustomRegularTextView customRegularTextView, CustomMediumTextView customMediumTextView) {
        this.rootView = linearLayout;
        this.clMsgBubble = constraintLayout;
        this.ivChatAvatar = shapeableImageView;
        this.tvChatMessage = customRegularTextView;
        this.tvChatUserName = customMediumTextView;
    }

    public static ListItemGamebroadcastMessageBinding bind(View view) {
        int i = R.id.clMsgBubble;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clMsgBubble);
        if (constraintLayout != null) {
            i = R.id.ivChatAvatar;
            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.ivChatAvatar);
            if (shapeableImageView != null) {
                i = R.id.tvChatMessage;
                CustomRegularTextView customRegularTextView = (CustomRegularTextView) view.findViewById(R.id.tvChatMessage);
                if (customRegularTextView != null) {
                    i = R.id.tvChatUserName;
                    CustomMediumTextView customMediumTextView = (CustomMediumTextView) view.findViewById(R.id.tvChatUserName);
                    if (customMediumTextView != null) {
                        ListItemGamebroadcastMessageBinding listItemGamebroadcastMessageBinding = new ListItemGamebroadcastMessageBinding((LinearLayout) view, constraintLayout, shapeableImageView, customRegularTextView, customMediumTextView);
                        return listItemGamebroadcastMessageBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ListItemGamebroadcastMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ListItemGamebroadcastMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.list_item_gamebroadcast_message, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
