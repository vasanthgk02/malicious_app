package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public final class ItemPlayerBinding implements ViewBinding {
    public final Group groupPlayerOne;
    public final Group groupPlayerTwo;
    public final Guideline guideline;
    public final Guideline guideline2;
    public final Guideline guideline3;
    public final Guideline guideline4;
    public final Guideline guideline5;
    public final ImageView imgPlayerOneId;
    public final ConstraintLayout rootView;
    public final CustomMediumTextView txtFollowPlayerOneId;
    public final CustomRegularTextView txtPlayerOneNameId;

    public ItemPlayerBinding(ConstraintLayout constraintLayout, Group group, Group group2, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, ImageView imageView, CustomMediumTextView customMediumTextView, CustomRegularTextView customRegularTextView) {
        this.rootView = constraintLayout;
        this.groupPlayerOne = group;
        this.groupPlayerTwo = group2;
        this.guideline = guideline6;
        this.guideline2 = guideline7;
        this.guideline3 = guideline8;
        this.guideline4 = guideline9;
        this.guideline5 = guideline10;
        this.imgPlayerOneId = imageView;
        this.txtFollowPlayerOneId = customMediumTextView;
        this.txtPlayerOneNameId = customRegularTextView;
    }

    public static ItemPlayerBinding bind(View view) {
        int i = R.id.groupPlayerOne;
        Group group = (Group) view.findViewById(R.id.groupPlayerOne);
        if (group != null) {
            i = R.id.groupPlayerTwo;
            Group group2 = (Group) view.findViewById(R.id.groupPlayerTwo);
            if (group2 != null) {
                i = R.id.guideline;
                Guideline guideline6 = (Guideline) view.findViewById(R.id.guideline);
                if (guideline6 != null) {
                    i = R.id.guideline2;
                    Guideline guideline7 = (Guideline) view.findViewById(R.id.guideline2);
                    if (guideline7 != null) {
                        i = R.id.guideline3;
                        Guideline guideline8 = (Guideline) view.findViewById(R.id.guideline3);
                        if (guideline8 != null) {
                            i = R.id.guideline4;
                            Guideline guideline9 = (Guideline) view.findViewById(R.id.guideline4);
                            if (guideline9 != null) {
                                i = R.id.guideline5;
                                Guideline guideline10 = (Guideline) view.findViewById(R.id.guideline5);
                                if (guideline10 != null) {
                                    i = R.id.imgPlayerOneId;
                                    ImageView imageView = (ImageView) view.findViewById(R.id.imgPlayerOneId);
                                    if (imageView != null) {
                                        i = R.id.txtFollowPlayerOneId;
                                        CustomMediumTextView customMediumTextView = (CustomMediumTextView) view.findViewById(R.id.txtFollowPlayerOneId);
                                        if (customMediumTextView != null) {
                                            i = R.id.txtPlayerOneNameId;
                                            CustomRegularTextView customRegularTextView = (CustomRegularTextView) view.findViewById(R.id.txtPlayerOneNameId);
                                            if (customRegularTextView != null) {
                                                ItemPlayerBinding itemPlayerBinding = new ItemPlayerBinding((ConstraintLayout) view, group, group2, guideline6, guideline7, guideline8, guideline9, guideline10, imageView, customMediumTextView, customRegularTextView);
                                                return itemPlayerBinding;
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

    public static ItemPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_player, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
