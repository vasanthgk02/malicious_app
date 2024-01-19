package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Layout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener;
import com.google.android.material.chip.Chip;

public class TimePickerView extends ConstraintLayout {
    public final ClockFaceView clockFace;
    public final ClockHandView clockHandView;
    public final Chip hourView;
    public final Chip minuteView;
    public OnDoubleTapListener onDoubleTapListener;
    public OnPeriodChangeListener onPeriodChangeListener;
    public OnSelectionChange onSelectionChangeListener;
    public final OnClickListener selectionListener;
    public final MaterialButtonToggleGroup toggle;

    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnPeriodChangeListener {
        void onPeriodChange(int i);
    }

    public interface OnSelectionChange {
        void onSelectionChanged(int i);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            updateToggleConstraints();
        }
    }

    public final void updateToggleConstraints() {
        if (this.toggle.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            char c2 = ViewCompat.getLayoutDirection(this) == 0 ? (char) 2 : 1;
            int i = R$id.material_clock_display;
            if (constraintSet.mConstraints.containsKey(Integer.valueOf(i))) {
                Constraint constraint = constraintSet.mConstraints.get(Integer.valueOf(i));
                if (constraint != null) {
                    switch (c2) {
                        case 1:
                            Layout layout = constraint.layout;
                            layout.leftToRight = -1;
                            layout.leftToLeft = -1;
                            layout.leftMargin = -1;
                            layout.goneLeftMargin = LinearLayoutManager.INVALID_OFFSET;
                            break;
                        case 2:
                            Layout layout2 = constraint.layout;
                            layout2.rightToRight = -1;
                            layout2.rightToLeft = -1;
                            layout2.rightMargin = -1;
                            layout2.goneRightMargin = LinearLayoutManager.INVALID_OFFSET;
                            break;
                        case 3:
                            Layout layout3 = constraint.layout;
                            layout3.topToBottom = -1;
                            layout3.topToTop = -1;
                            layout3.topMargin = 0;
                            layout3.goneTopMargin = LinearLayoutManager.INVALID_OFFSET;
                            break;
                        case 4:
                            Layout layout4 = constraint.layout;
                            layout4.bottomToTop = -1;
                            layout4.bottomToBottom = -1;
                            layout4.bottomMargin = 0;
                            layout4.goneBottomMargin = LinearLayoutManager.INVALID_OFFSET;
                            break;
                        case 5:
                            Layout layout5 = constraint.layout;
                            layout5.baselineToBaseline = -1;
                            layout5.baselineToTop = -1;
                            layout5.baselineToBottom = -1;
                            layout5.baselineMargin = 0;
                            layout5.goneBaselineMargin = LinearLayoutManager.INVALID_OFFSET;
                            break;
                        case 6:
                            Layout layout6 = constraint.layout;
                            layout6.startToEnd = -1;
                            layout6.startToStart = -1;
                            layout6.startMargin = 0;
                            layout6.goneStartMargin = LinearLayoutManager.INVALID_OFFSET;
                            break;
                        case 7:
                            Layout layout7 = constraint.layout;
                            layout7.endToStart = -1;
                            layout7.endToEnd = -1;
                            layout7.endMargin = 0;
                            layout7.goneEndMargin = LinearLayoutManager.INVALID_OFFSET;
                            break;
                        case 8:
                            Layout layout8 = constraint.layout;
                            layout8.circleAngle = -1.0f;
                            layout8.circleRadius = -1;
                            layout8.circleConstraint = -1;
                            break;
                        default:
                            throw new IllegalArgumentException("unknown constraint");
                    }
                }
            }
            constraintSet.applyToInternal(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectionListener = new OnClickListener() {
            public void onClick(View view) {
                OnSelectionChange onSelectionChange = TimePickerView.this.onSelectionChangeListener;
                if (onSelectionChange != null) {
                    onSelectionChange.onSelectionChanged(((Integer) view.getTag(R$id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.onButtonCheckedListeners.add(new OnButtonCheckedListener() {
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
                int i2 = i == R$id.material_clock_period_pm_button ? 1 : 0;
                OnPeriodChangeListener onPeriodChangeListener = TimePickerView.this.onPeriodChangeListener;
                if (onPeriodChangeListener != null && z) {
                    onPeriodChangeListener.onPeriodChange(i2);
                }
            }
        });
        this.minuteView = (Chip) findViewById(R$id.material_minute_tv);
        this.hourView = (Chip) findViewById(R$id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                OnDoubleTapListener onDoubleTapListener = TimePickerView.this.onDoubleTapListener;
                if (onDoubleTapListener != null) {
                    onDoubleTapListener.onDoubleTap();
                }
                return onDoubleTap;
            }
        });
        AnonymousClass4 r2 = new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.minuteView.setOnTouchListener(r2);
        this.hourView.setOnTouchListener(r2);
        this.minuteView.setTag(R$id.selection_type, Integer.valueOf(12));
        this.hourView.setTag(R$id.selection_type, Integer.valueOf(10));
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }
}
