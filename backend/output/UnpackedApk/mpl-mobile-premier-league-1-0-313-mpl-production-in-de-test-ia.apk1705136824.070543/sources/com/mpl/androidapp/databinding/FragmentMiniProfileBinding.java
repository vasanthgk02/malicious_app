package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.GameStreamErrorView;
import com.mpl.androidapp.miniprofile.view.customviews.MiniProfileLoadingView;
import com.mpl.androidapp.miniprofile.view.customviews.MiniProfileView;

public final class FragmentMiniProfileBinding implements ViewBinding {
    public final ImageView closeBtn;
    public final GameStreamErrorView profileErrorViewId;
    public final MiniProfileLoadingView profileLoadingViewId;
    public final MiniProfileView profileViewId;
    public final LinearLayout rootView;

    public FragmentMiniProfileBinding(LinearLayout linearLayout, ImageView imageView, GameStreamErrorView gameStreamErrorView, MiniProfileLoadingView miniProfileLoadingView, MiniProfileView miniProfileView) {
        this.rootView = linearLayout;
        this.closeBtn = imageView;
        this.profileErrorViewId = gameStreamErrorView;
        this.profileLoadingViewId = miniProfileLoadingView;
        this.profileViewId = miniProfileView;
    }

    public static FragmentMiniProfileBinding bind(View view) {
        int i = R.id.close_btn;
        ImageView imageView = (ImageView) view.findViewById(R.id.close_btn);
        if (imageView != null) {
            i = R.id.profileErrorViewId;
            GameStreamErrorView gameStreamErrorView = (GameStreamErrorView) view.findViewById(R.id.profileErrorViewId);
            if (gameStreamErrorView != null) {
                i = R.id.profileLoadingViewId;
                MiniProfileLoadingView miniProfileLoadingView = (MiniProfileLoadingView) view.findViewById(R.id.profileLoadingViewId);
                if (miniProfileLoadingView != null) {
                    i = R.id.profileViewId;
                    MiniProfileView miniProfileView = (MiniProfileView) view.findViewById(R.id.profileViewId);
                    if (miniProfileView != null) {
                        FragmentMiniProfileBinding fragmentMiniProfileBinding = new FragmentMiniProfileBinding((LinearLayout) view, imageView, gameStreamErrorView, miniProfileLoadingView, miniProfileView);
                        return fragmentMiniProfileBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMiniProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMiniProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mini_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
