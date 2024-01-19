package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomBoldTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public final class BroadcastMiniProfileViewBinding implements ViewBinding {
    public final CustomMediumTextView displayBannerIcon;
    public final CustomMediumTextView followersValueId;
    public final CustomMediumTextView followingValueId;
    public final CustomViewStatsContainerBinding gameStatsId;
    public final Guideline guideline23;
    public final ImageView kycBadgeId;
    public final ImageView miniProfileAccDelImgViewId;
    public final ImageView miniProfileBadge;
    public final CustomMediumTextView miniProfileDescAccDel;
    public final CustomBoldTextView miniProfileDisplayName;
    public final ImageView miniProfileImgViewId;
    public final CustomBoldTextView miniProfileNameAccDel;
    public final CustomBoldTextView miniProfilePersonName;
    public final ConstraintLayout profileActiveContainerId;
    public final ConstraintLayout profileDeletedContainerId;
    public final ScrollView rootView;
    public final CustomRegularTextView textView8;
    public final CustomRegularTextView textView9;
    public final View view2;
    public final View view3;
    public final CustomMediumTextView viewProfileLeftBtnActionId;
    public final CustomMediumTextView viewProfileRightBtnActionId;

    public BroadcastMiniProfileViewBinding(ScrollView scrollView, CustomMediumTextView customMediumTextView, CustomMediumTextView customMediumTextView2, CustomMediumTextView customMediumTextView3, CustomViewStatsContainerBinding customViewStatsContainerBinding, Guideline guideline, ImageView imageView, ImageView imageView2, ImageView imageView3, CustomMediumTextView customMediumTextView4, CustomBoldTextView customBoldTextView, ImageView imageView4, CustomBoldTextView customBoldTextView2, CustomBoldTextView customBoldTextView3, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CustomRegularTextView customRegularTextView, CustomRegularTextView customRegularTextView2, View view, View view4, CustomMediumTextView customMediumTextView5, CustomMediumTextView customMediumTextView6) {
        this.rootView = scrollView;
        this.displayBannerIcon = customMediumTextView;
        this.followersValueId = customMediumTextView2;
        this.followingValueId = customMediumTextView3;
        this.gameStatsId = customViewStatsContainerBinding;
        this.guideline23 = guideline;
        this.kycBadgeId = imageView;
        this.miniProfileAccDelImgViewId = imageView2;
        this.miniProfileBadge = imageView3;
        this.miniProfileDescAccDel = customMediumTextView4;
        this.miniProfileDisplayName = customBoldTextView;
        this.miniProfileImgViewId = imageView4;
        this.miniProfileNameAccDel = customBoldTextView2;
        this.miniProfilePersonName = customBoldTextView3;
        this.profileActiveContainerId = constraintLayout;
        this.profileDeletedContainerId = constraintLayout2;
        this.textView8 = customRegularTextView;
        this.textView9 = customRegularTextView2;
        this.view2 = view;
        this.view3 = view4;
        this.viewProfileLeftBtnActionId = customMediumTextView5;
        this.viewProfileRightBtnActionId = customMediumTextView6;
    }

    public static BroadcastMiniProfileViewBinding bind(View view) {
        View view4 = view;
        int i = R.id.displayBannerIcon;
        CustomMediumTextView customMediumTextView = (CustomMediumTextView) view4.findViewById(R.id.displayBannerIcon);
        if (customMediumTextView != null) {
            i = R.id.followersValueId;
            CustomMediumTextView customMediumTextView2 = (CustomMediumTextView) view4.findViewById(R.id.followersValueId);
            if (customMediumTextView2 != null) {
                i = R.id.followingValueId;
                CustomMediumTextView customMediumTextView3 = (CustomMediumTextView) view4.findViewById(R.id.followingValueId);
                if (customMediumTextView3 != null) {
                    i = R.id.gameStatsId;
                    View findViewById = view4.findViewById(R.id.gameStatsId);
                    if (findViewById != null) {
                        CustomViewStatsContainerBinding bind = CustomViewStatsContainerBinding.bind(findViewById);
                        i = R.id.guideline23;
                        Guideline guideline = (Guideline) view4.findViewById(R.id.guideline23);
                        if (guideline != null) {
                            i = R.id.kycBadgeId;
                            ImageView imageView = (ImageView) view4.findViewById(R.id.kycBadgeId);
                            if (imageView != null) {
                                i = R.id.miniProfileAccDelImgViewId;
                                ImageView imageView2 = (ImageView) view4.findViewById(R.id.miniProfileAccDelImgViewId);
                                if (imageView2 != null) {
                                    i = R.id.miniProfileBadge;
                                    ImageView imageView3 = (ImageView) view4.findViewById(R.id.miniProfileBadge);
                                    if (imageView3 != null) {
                                        i = R.id.miniProfileDescAccDel;
                                        CustomMediumTextView customMediumTextView4 = (CustomMediumTextView) view4.findViewById(R.id.miniProfileDescAccDel);
                                        if (customMediumTextView4 != null) {
                                            i = R.id.miniProfileDisplayName;
                                            CustomBoldTextView customBoldTextView = (CustomBoldTextView) view4.findViewById(R.id.miniProfileDisplayName);
                                            if (customBoldTextView != null) {
                                                i = R.id.miniProfileImgViewId;
                                                ImageView imageView4 = (ImageView) view4.findViewById(R.id.miniProfileImgViewId);
                                                if (imageView4 != null) {
                                                    i = R.id.miniProfileNameAccDel;
                                                    CustomBoldTextView customBoldTextView2 = (CustomBoldTextView) view4.findViewById(R.id.miniProfileNameAccDel);
                                                    if (customBoldTextView2 != null) {
                                                        i = R.id.miniProfilePersonName;
                                                        CustomBoldTextView customBoldTextView3 = (CustomBoldTextView) view4.findViewById(R.id.miniProfilePersonName);
                                                        if (customBoldTextView3 != null) {
                                                            i = R.id.profileActiveContainerId;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view4.findViewById(R.id.profileActiveContainerId);
                                                            if (constraintLayout != null) {
                                                                i = R.id.profileDeletedContainerId;
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view4.findViewById(R.id.profileDeletedContainerId);
                                                                if (constraintLayout2 != null) {
                                                                    i = R.id.textView8;
                                                                    CustomRegularTextView customRegularTextView = (CustomRegularTextView) view4.findViewById(R.id.textView8);
                                                                    if (customRegularTextView != null) {
                                                                        i = R.id.textView9;
                                                                        CustomRegularTextView customRegularTextView2 = (CustomRegularTextView) view4.findViewById(R.id.textView9);
                                                                        if (customRegularTextView2 != null) {
                                                                            i = R.id.view2;
                                                                            View findViewById2 = view4.findViewById(R.id.view2);
                                                                            if (findViewById2 != null) {
                                                                                i = R.id.view3;
                                                                                View findViewById3 = view4.findViewById(R.id.view3);
                                                                                if (findViewById3 != null) {
                                                                                    i = R.id.viewProfileLeftBtnActionId;
                                                                                    CustomMediumTextView customMediumTextView5 = (CustomMediumTextView) view4.findViewById(R.id.viewProfileLeftBtnActionId);
                                                                                    if (customMediumTextView5 != null) {
                                                                                        i = R.id.viewProfileRightBtnActionId;
                                                                                        CustomMediumTextView customMediumTextView6 = (CustomMediumTextView) view4.findViewById(R.id.viewProfileRightBtnActionId);
                                                                                        if (customMediumTextView6 != null) {
                                                                                            BroadcastMiniProfileViewBinding broadcastMiniProfileViewBinding = new BroadcastMiniProfileViewBinding((ScrollView) view4, customMediumTextView, customMediumTextView2, customMediumTextView3, bind, guideline, imageView, imageView2, imageView3, customMediumTextView4, customBoldTextView, imageView4, customBoldTextView2, customBoldTextView3, constraintLayout, constraintLayout2, customRegularTextView, customRegularTextView2, findViewById2, findViewById3, customMediumTextView5, customMediumTextView6);
                                                                                            return broadcastMiniProfileViewBinding;
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BroadcastMiniProfileViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BroadcastMiniProfileViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.broadcast_mini_profile_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
