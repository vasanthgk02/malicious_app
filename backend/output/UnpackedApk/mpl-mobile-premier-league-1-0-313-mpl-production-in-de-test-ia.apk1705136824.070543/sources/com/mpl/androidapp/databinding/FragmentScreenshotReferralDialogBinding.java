package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class FragmentScreenshotReferralDialogBinding implements ViewBinding {
    public final LinearLayout LinearLayoutShareNow;
    public final LinearLayout btnLayout;
    public final ImageView imageviewCloseButton;
    public final AppCompatButton moreoptionbutton;
    public final ConstraintLayout rootView;
    public final ImageView screenshotimage;
    public final AppCompatButton shareNowBtn;
    public final AppCompatButton whattsappbutton;

    public FragmentScreenshotReferralDialogBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, AppCompatButton appCompatButton, ImageView imageView2, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3) {
        this.rootView = constraintLayout;
        this.LinearLayoutShareNow = linearLayout;
        this.btnLayout = linearLayout2;
        this.imageviewCloseButton = imageView;
        this.moreoptionbutton = appCompatButton;
        this.screenshotimage = imageView2;
        this.shareNowBtn = appCompatButton2;
        this.whattsappbutton = appCompatButton3;
    }

    public static FragmentScreenshotReferralDialogBinding bind(View view) {
        int i = R.id.LinearLayoutShareNow;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.LinearLayoutShareNow);
        if (linearLayout != null) {
            i = R.id.btnLayout;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.btnLayout);
            if (linearLayout2 != null) {
                i = R.id.imageview_close_button;
                ImageView imageView = (ImageView) view.findViewById(R.id.imageview_close_button);
                if (imageView != null) {
                    i = R.id.moreoptionbutton;
                    AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.moreoptionbutton);
                    if (appCompatButton != null) {
                        i = R.id.screenshotimage;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.screenshotimage);
                        if (imageView2 != null) {
                            i = R.id.share_now_btn;
                            AppCompatButton appCompatButton2 = (AppCompatButton) view.findViewById(R.id.share_now_btn);
                            if (appCompatButton2 != null) {
                                i = R.id.whattsappbutton;
                                AppCompatButton appCompatButton3 = (AppCompatButton) view.findViewById(R.id.whattsappbutton);
                                if (appCompatButton3 != null) {
                                    FragmentScreenshotReferralDialogBinding fragmentScreenshotReferralDialogBinding = new FragmentScreenshotReferralDialogBinding((ConstraintLayout) view, linearLayout, linearLayout2, imageView, appCompatButton, imageView2, appCompatButton2, appCompatButton3);
                                    return fragmentScreenshotReferralDialogBinding;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentScreenshotReferralDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentScreenshotReferralDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_screenshot_referral_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
