package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomBoldTextView;

public final class ViewVerticalSegmentsBinding implements ViewBinding {
    public final ImageView btnSegmentsCloseId;
    public final View dividerId;
    public final Guideline guideline15;
    public final Guideline guideline22;
    public final Guideline guideline24;
    public final ConstraintLayout rootView;
    public final CustomBoldTextView segmentsHeadId;
    public final RecyclerView segmentsVerticalListId;

    public ViewVerticalSegmentsBinding(ConstraintLayout constraintLayout, ImageView imageView, View view, Guideline guideline, Guideline guideline2, Guideline guideline3, CustomBoldTextView customBoldTextView, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.btnSegmentsCloseId = imageView;
        this.dividerId = view;
        this.guideline15 = guideline;
        this.guideline22 = guideline2;
        this.guideline24 = guideline3;
        this.segmentsHeadId = customBoldTextView;
        this.segmentsVerticalListId = recyclerView;
    }

    public static ViewVerticalSegmentsBinding bind(View view) {
        int i = R.id.btnSegmentsCloseId;
        ImageView imageView = (ImageView) view.findViewById(R.id.btnSegmentsCloseId);
        if (imageView != null) {
            i = R.id.dividerId;
            View findViewById = view.findViewById(R.id.dividerId);
            if (findViewById != null) {
                i = R.id.guideline15;
                Guideline guideline = (Guideline) view.findViewById(R.id.guideline15);
                if (guideline != null) {
                    i = R.id.guideline22;
                    Guideline guideline2 = (Guideline) view.findViewById(R.id.guideline22);
                    if (guideline2 != null) {
                        i = R.id.guideline24;
                        Guideline guideline3 = (Guideline) view.findViewById(R.id.guideline24);
                        if (guideline3 != null) {
                            i = R.id.segmentsHeadId;
                            CustomBoldTextView customBoldTextView = (CustomBoldTextView) view.findViewById(R.id.segmentsHeadId);
                            if (customBoldTextView != null) {
                                i = R.id.segmentsVerticalListId;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.segmentsVerticalListId);
                                if (recyclerView != null) {
                                    ViewVerticalSegmentsBinding viewVerticalSegmentsBinding = new ViewVerticalSegmentsBinding((ConstraintLayout) view, imageView, findViewById, guideline, guideline2, guideline3, customBoldTextView, recyclerView);
                                    return viewVerticalSegmentsBinding;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewVerticalSegmentsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewVerticalSegmentsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_vertical_segments, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
