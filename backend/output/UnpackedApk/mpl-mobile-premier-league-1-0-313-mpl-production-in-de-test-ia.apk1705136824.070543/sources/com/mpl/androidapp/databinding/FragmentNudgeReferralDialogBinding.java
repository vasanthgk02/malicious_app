package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class FragmentNudgeReferralDialogBinding implements ViewBinding {
    public final LinearLayout LinearLayoutShareNowNudge;
    public final LinearLayout btnLayoutNudge;
    public final ImageView imageviewCloseButtonNudge;
    public final AppCompatButton moreoptionbuttonNudge;
    public final ConstraintLayout rootView;
    public final ImageView screenshotimageNudge;
    public final AppCompatButton shareNowBtnNudge;
    public final TextView textviewNudge;
    public final AppCompatButton whattsappbuttonNudge;

    public FragmentNudgeReferralDialogBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, AppCompatButton appCompatButton, ImageView imageView2, AppCompatButton appCompatButton2, TextView textView, AppCompatButton appCompatButton3) {
        this.rootView = constraintLayout;
        this.LinearLayoutShareNowNudge = linearLayout;
        this.btnLayoutNudge = linearLayout2;
        this.imageviewCloseButtonNudge = imageView;
        this.moreoptionbuttonNudge = appCompatButton;
        this.screenshotimageNudge = imageView2;
        this.shareNowBtnNudge = appCompatButton2;
        this.textviewNudge = textView;
        this.whattsappbuttonNudge = appCompatButton3;
    }

    public static FragmentNudgeReferralDialogBinding bind(View view) {
        int i = R.id.LinearLayoutShareNowNudge;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.LinearLayoutShareNowNudge);
        if (linearLayout != null) {
            i = R.id.btnLayout_nudge;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.btnLayout_nudge);
            if (linearLayout2 != null) {
                i = R.id.imageview_close_button_nudge;
                ImageView imageView = (ImageView) view.findViewById(R.id.imageview_close_button_nudge);
                if (imageView != null) {
                    i = R.id.moreoptionbutton_nudge;
                    AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.moreoptionbutton_nudge);
                    if (appCompatButton != null) {
                        i = R.id.screenshotimage_nudge;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.screenshotimage_nudge);
                        if (imageView2 != null) {
                            i = R.id.share_now_btn_nudge;
                            AppCompatButton appCompatButton2 = (AppCompatButton) view.findViewById(R.id.share_now_btn_nudge);
                            if (appCompatButton2 != null) {
                                i = R.id.textview_nudge;
                                TextView textView = (TextView) view.findViewById(R.id.textview_nudge);
                                if (textView != null) {
                                    i = R.id.whattsappbutton_nudge;
                                    AppCompatButton appCompatButton3 = (AppCompatButton) view.findViewById(R.id.whattsappbutton_nudge);
                                    if (appCompatButton3 != null) {
                                        FragmentNudgeReferralDialogBinding fragmentNudgeReferralDialogBinding = new FragmentNudgeReferralDialogBinding((ConstraintLayout) view, linearLayout, linearLayout2, imageView, appCompatButton, imageView2, appCompatButton2, textView, appCompatButton3);
                                        return fragmentNudgeReferralDialogBinding;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentNudgeReferralDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNudgeReferralDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_nudge_referral_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
