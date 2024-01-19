package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomBoldTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public final class CustomViewStatsContainerBinding implements ViewBinding {
    public final ConstraintLayout cashWonContainerId;
    public final ConstraintLayout contestsPlayedContainerId;
    public final ImageView imgCashWonIconId;
    public final ConstraintLayout root;
    public final ConstraintLayout rootView;
    public final CustomRegularTextView textView10;
    public final CustomRegularTextView textView5;
    public final CustomBoldTextView txtCashWonValueId;
    public final CustomRegularTextView txtContestsPlayedDisplayId;
    public final CustomBoldTextView txtContestsPlayedValueId;
    public final CustomBoldTextView txtWinRateValueId;
    public final ConstraintLayout winRateContainerValueId;

    public CustomViewStatsContainerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ConstraintLayout constraintLayout4, CustomRegularTextView customRegularTextView, CustomRegularTextView customRegularTextView2, CustomBoldTextView customBoldTextView, CustomRegularTextView customRegularTextView3, CustomBoldTextView customBoldTextView2, CustomBoldTextView customBoldTextView3, ConstraintLayout constraintLayout5) {
        this.rootView = constraintLayout;
        this.cashWonContainerId = constraintLayout2;
        this.contestsPlayedContainerId = constraintLayout3;
        this.imgCashWonIconId = imageView;
        this.root = constraintLayout4;
        this.textView10 = customRegularTextView;
        this.textView5 = customRegularTextView2;
        this.txtCashWonValueId = customBoldTextView;
        this.txtContestsPlayedDisplayId = customRegularTextView3;
        this.txtContestsPlayedValueId = customBoldTextView2;
        this.txtWinRateValueId = customBoldTextView3;
        this.winRateContainerValueId = constraintLayout5;
    }

    public static CustomViewStatsContainerBinding bind(View view) {
        int i = R.id.cashWonContainerId;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cashWonContainerId);
        if (constraintLayout != null) {
            i = R.id.contestsPlayedContainerId;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.contestsPlayedContainerId);
            if (constraintLayout2 != null) {
                i = R.id.imgCashWonIconId;
                ImageView imageView = (ImageView) view.findViewById(R.id.imgCashWonIconId);
                if (imageView != null) {
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                    i = R.id.textView10;
                    CustomRegularTextView customRegularTextView = (CustomRegularTextView) view.findViewById(R.id.textView10);
                    if (customRegularTextView != null) {
                        i = R.id.textView5;
                        CustomRegularTextView customRegularTextView2 = (CustomRegularTextView) view.findViewById(R.id.textView5);
                        if (customRegularTextView2 != null) {
                            i = R.id.txtCashWonValueId;
                            CustomBoldTextView customBoldTextView = (CustomBoldTextView) view.findViewById(R.id.txtCashWonValueId);
                            if (customBoldTextView != null) {
                                i = R.id.txtContestsPlayedDisplayId;
                                CustomRegularTextView customRegularTextView3 = (CustomRegularTextView) view.findViewById(R.id.txtContestsPlayedDisplayId);
                                if (customRegularTextView3 != null) {
                                    i = R.id.txtContestsPlayedValueId;
                                    CustomBoldTextView customBoldTextView2 = (CustomBoldTextView) view.findViewById(R.id.txtContestsPlayedValueId);
                                    if (customBoldTextView2 != null) {
                                        i = R.id.txtWinRateValueId;
                                        CustomBoldTextView customBoldTextView3 = (CustomBoldTextView) view.findViewById(R.id.txtWinRateValueId);
                                        if (customBoldTextView3 != null) {
                                            i = R.id.winRateContainerValueId;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.winRateContainerValueId);
                                            if (constraintLayout4 != null) {
                                                CustomViewStatsContainerBinding customViewStatsContainerBinding = new CustomViewStatsContainerBinding(constraintLayout3, constraintLayout, constraintLayout2, imageView, constraintLayout3, customRegularTextView, customRegularTextView2, customBoldTextView, customRegularTextView3, customBoldTextView2, customBoldTextView3, constraintLayout4);
                                                return customViewStatsContainerBinding;
                                            }
                                        }
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

    public static CustomViewStatsContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CustomViewStatsContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.custom_view_stats_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
