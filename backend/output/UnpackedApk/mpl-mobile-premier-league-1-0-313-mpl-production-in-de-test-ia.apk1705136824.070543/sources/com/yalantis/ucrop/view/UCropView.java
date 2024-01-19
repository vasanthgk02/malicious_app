package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.R$id;
import com.yalantis.ucrop.R$layout;
import com.yalantis.ucrop.R$styleable;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

public class UCropView extends FrameLayout {
    public GestureCropImageView mGestureCropImageView;
    public final OverlayView mViewOverlay;

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView getCropImageView() {
        return this.mGestureCropImageView;
    }

    public OverlayView getOverlayView() {
        return this.mViewOverlay;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.ucrop_view, this, true);
        this.mGestureCropImageView = (GestureCropImageView) findViewById(R$id.image_view_crop);
        this.mViewOverlay = (OverlayView) findViewById(R$id.view_overlay);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ucrop_UCropView);
        OverlayView overlayView = this.mViewOverlay;
        if (overlayView != null) {
            overlayView.mCircleDimmedLayer = obtainStyledAttributes.getBoolean(R$styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
            int color = obtainStyledAttributes.getColor(R$styleable.ucrop_UCropView_ucrop_dimmed_color, overlayView.getResources().getColor(R$color.ucrop_color_default_dimmed));
            overlayView.mDimmedColor = color;
            overlayView.mDimmedStrokePaint.setColor(color);
            overlayView.mDimmedStrokePaint.setStyle(Style.STROKE);
            overlayView.mDimmedStrokePaint.setStrokeWidth(1.0f);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ucrop_UCropView_ucrop_frame_stroke_size, overlayView.getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_frame_stoke_width));
            int color2 = obtainStyledAttributes.getColor(R$styleable.ucrop_UCropView_ucrop_frame_color, overlayView.getResources().getColor(R$color.ucrop_color_default_crop_frame));
            overlayView.mCropFramePaint.setStrokeWidth((float) dimensionPixelSize);
            overlayView.mCropFramePaint.setColor(color2);
            overlayView.mCropFramePaint.setStyle(Style.STROKE);
            overlayView.mCropFrameCornersPaint.setStrokeWidth((float) (dimensionPixelSize * 3));
            overlayView.mCropFrameCornersPaint.setColor(color2);
            overlayView.mCropFrameCornersPaint.setStyle(Style.STROKE);
            overlayView.mShowCropFrame = obtainStyledAttributes.getBoolean(R$styleable.ucrop_UCropView_ucrop_show_frame, true);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ucrop_UCropView_ucrop_grid_stroke_size, overlayView.getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_grid_stoke_width));
            int color3 = obtainStyledAttributes.getColor(R$styleable.ucrop_UCropView_ucrop_grid_color, overlayView.getResources().getColor(R$color.ucrop_color_default_crop_grid));
            overlayView.mCropGridPaint.setStrokeWidth((float) dimensionPixelSize2);
            overlayView.mCropGridPaint.setColor(color3);
            overlayView.mCropGridRowCount = obtainStyledAttributes.getInt(R$styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
            overlayView.mCropGridColumnCount = obtainStyledAttributes.getInt(R$styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
            overlayView.mShowCropGrid = obtainStyledAttributes.getBoolean(R$styleable.ucrop_UCropView_ucrop_show_grid, true);
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            if (gestureCropImageView != null) {
                float abs = Math.abs(obtainStyledAttributes.getFloat(R$styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
                float abs2 = Math.abs(obtainStyledAttributes.getFloat(R$styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
                if (abs == 0.0f || abs2 == 0.0f) {
                    gestureCropImageView.mTargetAspectRatio = 0.0f;
                } else {
                    gestureCropImageView.mTargetAspectRatio = abs / abs2;
                }
                obtainStyledAttributes.recycle();
                this.mGestureCropImageView.setCropBoundsChangeListener(new CropBoundsChangeListener() {
                });
                this.mViewOverlay.setOverlayViewChangeListener(new OverlayViewChangeListener() {
                });
                return;
            }
            throw null;
        }
        throw null;
    }
}
