package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Layout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

public class RadialViewGroup extends ConstraintLayout {
    public MaterialShapeDrawable background;
    public int radius;
    public final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.updateLayoutParametersRunnable);
            handler.post(this.updateLayoutParametersRunnable);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.updateLayoutParametersRunnable);
            handler.post(this.updateLayoutParametersRunnable);
        }
    }

    public void setBackgroundColor(int i) {
        this.background.setFillColor(ColorStateList.valueOf(i));
    }

    public void updateLayoutParams() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f2 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != R$id.circle_center && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int i4 = R$id.circle_center;
                int i5 = this.radius;
                Layout layout = constraintSet.get(id).layout;
                layout.circleConstraint = i4;
                layout.circleRadius = i5;
                layout.circleAngle = f2;
                f2 = (360.0f / ((float) (childCount - i))) + f2;
            }
        }
        constraintSet.applyToInternal(this, true);
        setConstraintSet(null);
        requestLayout();
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.background = materialShapeDrawable;
        RelativeCornerSize relativeCornerSize = new RelativeCornerSize(0.5f);
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.drawableState.shapeAppearanceModel;
        if (shapeAppearanceModel != null) {
            Builder builder = new Builder(shapeAppearanceModel);
            builder.topLeftCornerSize = relativeCornerSize;
            builder.topRightCornerSize = relativeCornerSize;
            builder.bottomRightCornerSize = relativeCornerSize;
            builder.bottomLeftCornerSize = relativeCornerSize;
            materialShapeDrawable.drawableState.shapeAppearanceModel = builder.build();
            materialShapeDrawable.invalidateSelf();
            this.background.setFillColor(ColorStateList.valueOf(-1));
            ViewCompat.setBackground(this, this.background);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i, 0);
            this.radius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
            this.updateLayoutParametersRunnable = new Runnable() {
                public void run() {
                    RadialViewGroup.this.updateLayoutParams();
                }
            };
            obtainStyledAttributes.recycle();
            return;
        }
        throw null;
    }
}
