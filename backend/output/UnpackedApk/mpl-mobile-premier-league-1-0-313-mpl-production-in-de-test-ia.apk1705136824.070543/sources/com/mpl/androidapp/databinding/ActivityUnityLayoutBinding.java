package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityUnityLayoutBinding implements ViewBinding {
    public final FrameLayout gameContainer;
    public final ImageView gameIcon;
    public final LinearLayout gameIconContainer;
    public final ConstraintLayout gameLayoutContainer;
    public final ImageView gameLogotype;
    public final TextView loadingGameText;
    public final ConstraintLayout rootView;

    public ActivityUnityLayoutBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView) {
        this.rootView = constraintLayout;
        this.gameContainer = frameLayout;
        this.gameIcon = imageView;
        this.gameIconContainer = linearLayout;
        this.gameLayoutContainer = constraintLayout2;
        this.gameLogotype = imageView2;
        this.loadingGameText = textView;
    }

    public static ActivityUnityLayoutBinding bind(View view) {
        int i = R.id.game_container;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.game_container);
        if (frameLayout != null) {
            i = R.id.game_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.game_icon);
            if (imageView != null) {
                i = R.id.game_icon_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.game_icon_container);
                if (linearLayout != null) {
                    i = R.id.game_layout_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.game_layout_container);
                    if (constraintLayout != null) {
                        i = R.id.game_logotype;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.game_logotype);
                        if (imageView2 != null) {
                            i = R.id.loading_game_text;
                            TextView textView = (TextView) view.findViewById(R.id.loading_game_text);
                            if (textView != null) {
                                ActivityUnityLayoutBinding activityUnityLayoutBinding = new ActivityUnityLayoutBinding((ConstraintLayout) view, frameLayout, imageView, linearLayout, constraintLayout, imageView2, textView);
                                return activityUnityLayoutBinding;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityUnityLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUnityLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_unity_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
