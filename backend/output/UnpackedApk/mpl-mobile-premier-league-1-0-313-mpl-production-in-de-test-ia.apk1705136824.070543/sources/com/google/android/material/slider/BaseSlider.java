package com.google.android.material.slider;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayApi18;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.net.ftp.FTPReply;

public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_Slider;
    public static final String TAG = BaseSlider.class.getSimpleName();
    public AccessibilityEventSender accessibilityEventSender;
    public final AccessibilityHelper accessibilityHelper;
    public final AccessibilityManager accessibilityManager;
    public int activeThumbIdx;
    public final Paint activeTicksPaint;
    public final Paint activeTrackPaint;
    public final List<L> changeListeners;
    public int defaultThumbRadius;
    public boolean dirtyConfig;
    public int focusedThumbIdx;
    public LabelFormatter formatter;
    public ColorStateList haloColor;
    public final Paint haloPaint;
    public int haloRadius;
    public final Paint inactiveTicksPaint;
    public final Paint inactiveTrackPaint;
    public boolean isLongPress;
    public int labelBehavior;
    public final TooltipDrawableFactory labelMaker;
    public int labelPadding;
    public final List<TooltipDrawable> labels;
    public boolean labelsAreAnimatedIn;
    public ValueAnimator labelsInAnimator;
    public ValueAnimator labelsOutAnimator;
    public MotionEvent lastEvent;
    public int minTrackSidePadding;
    public final int scaledTouchSlop;
    public int separationUnit;
    public float stepSize;
    public final MaterialShapeDrawable thumbDrawable;
    public boolean thumbIsPressed;
    public final Paint thumbPaint;
    public int thumbRadius;
    public ColorStateList tickColorActive;
    public ColorStateList tickColorInactive;
    public boolean tickVisible;
    public float[] ticksCoordinates;
    public float touchDownX;
    public final List<T> touchListeners;
    public float touchPosition;
    public ColorStateList trackColorActive;
    public ColorStateList trackColorInactive;
    public int trackHeight;
    public int trackSidePadding;
    public int trackTop;
    public int trackWidth;
    public float valueFrom;
    public float valueTo;
    public ArrayList<Float> values;
    public int widgetHeight;

    public class AccessibilityEventSender implements Runnable {
        public int virtualViewId = -1;

        public AccessibilityEventSender(AnonymousClass1 r2) {
        }

        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }
    }

    public static class AccessibilityHelper extends ExploreByTouchHelper {
        public final BaseSlider<?, ?, ?> slider;
        public Rect virtualViewBounds = new Rect();

        public AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.slider = baseSlider;
        }

        public int getVirtualViewAt(float f2, float f3) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f2, (int) f3)) {
                    return i;
                }
            }
            return -1;
        }

        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (i2 == 4096 || i2 == 8192) {
                float access$800 = this.slider.calculateStepIncrement(20);
                if (i2 == 8192) {
                    access$800 = -access$800;
                }
                if (this.slider.isRtl()) {
                    access$800 = -access$800;
                }
                if (!this.slider.snapThumbToValue(i, b.clamp(this.slider.getValues().get(i).floatValue() + access$800, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                    return false;
                }
                this.slider.updateHaloHotspot();
                this.slider.postInvalidate();
                invalidateVirtualView(i);
                return true;
            }
            if (i2 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (this.slider.snapThumbToValue(i, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    this.slider.updateHaloHotspot();
                    this.slider.postInvalidate();
                    invalidateVirtualView(i);
                    return true;
                }
            }
            return false;
        }

        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            accessibilityNodeInfoCompat.addAction(AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.slider.getValues();
            float floatValue = values.get(i).floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.mInfo.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.mInfo.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.mInfo.setRangeInfo(RangeInfo.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.mInfo.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb.append(this.slider.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                if (i == this.slider.getValues().size() - 1) {
                    str = this.slider.getContext().getString(R$string.material_slider_range_end);
                } else {
                    str = i == 0 ? this.slider.getContext().getString(R$string.material_slider_range_start) : "";
                }
                sb.append(str);
                sb.append(this.slider.formatValue(floatValue));
            }
            accessibilityNodeInfoCompat.mInfo.setContentDescription(sb.toString());
            this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
            accessibilityNodeInfoCompat.mInfo.setBoundsInParent(this.virtualViewBounds);
        }
    }

    public static class SliderState extends BaseSavedState {
        public static final Creator<SliderState> CREATOR = new Creator<SliderState>() {
            public Object createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            public Object[] newArray(int i) {
                return new SliderState[i];
            }
        };
        public boolean hasFocus;
        public float stepSize;
        public float valueFrom;
        public float valueTo;
        public ArrayList<Float> values;

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        public SliderState(Parcel parcel, AnonymousClass1 r3) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }
    }

    public interface TooltipDrawableFactory {
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            floatValue2 = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue2);
        float normalizeValue2 = normalizeValue(floatValue);
        if (isRtl()) {
            return new float[]{normalizeValue2, normalizeValue};
        }
        return new float[]{normalizeValue, normalizeValue2};
    }

    private float getValueOfTouchPosition() {
        double d2;
        float f2 = this.touchPosition;
        float f3 = this.stepSize;
        if (f3 > 0.0f) {
            int i = (int) ((this.valueTo - this.valueFrom) / f3);
            d2 = ((double) Math.round(f2 * ((float) i))) / ((double) i);
        } else {
            d2 = (double) f2;
        }
        if (isRtl()) {
            d2 = 1.0d - d2;
        }
        float f4 = this.valueTo;
        float f5 = this.valueFrom;
        return (float) ((d2 * ((double) (f4 - f5))) + ((double) f5));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.touchPosition;
        if (isRtl()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.valueTo;
        float f4 = this.valueFrom;
        return GeneratedOutlineSupport.outline3(f3, f4, f2, f4);
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.values.size() != arrayList.size() || !this.values.equals(arrayList)) {
                this.values = arrayList;
                int i = 1;
                this.dirtyConfig = true;
                this.focusedThumbIdx = 0;
                updateHaloHotspot();
                if (this.labels.size() > this.values.size()) {
                    List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
                    for (TooltipDrawable next : subList) {
                        if (ViewCompat.isAttachedToWindow(this)) {
                            detachLabelFromContentView(next);
                        }
                    }
                    subList.clear();
                }
                while (this.labels.size() < this.values.size()) {
                    AnonymousClass1 r1 = (AnonymousClass1) this.labelMaker;
                    TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), r11, R$styleable.Slider, r12, DEF_STYLE_RES, new int[0]);
                    Context context = BaseSlider.this.getContext();
                    int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip);
                    TooltipDrawable tooltipDrawable = new TooltipDrawable(context, null, 0, resourceId);
                    TypedArray obtainStyledAttributes2 = ThemeEnforcement.obtainStyledAttributes(tooltipDrawable.context, null, R$styleable.Tooltip, 0, resourceId, new int[0]);
                    tooltipDrawable.arrowSize = tooltipDrawable.context.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
                    ShapeAppearanceModel shapeAppearanceModel = tooltipDrawable.drawableState.shapeAppearanceModel;
                    if (shapeAppearanceModel != null) {
                        Builder builder = new Builder(shapeAppearanceModel);
                        builder.bottomEdge = tooltipDrawable.createMarkerEdge();
                        tooltipDrawable.drawableState.shapeAppearanceModel = builder.build();
                        tooltipDrawable.invalidateSelf();
                        CharSequence text = obtainStyledAttributes2.getText(R$styleable.Tooltip_android_text);
                        if (!TextUtils.equals(tooltipDrawable.text, text)) {
                            tooltipDrawable.text = text;
                            tooltipDrawable.textDrawableHelper.textWidthDirty = true;
                            tooltipDrawable.invalidateSelf();
                        }
                        tooltipDrawable.textDrawableHelper.setTextAppearance(ImageOriginUtils.getTextAppearance(tooltipDrawable.context, obtainStyledAttributes2, R$styleable.Tooltip_android_textAppearance), tooltipDrawable.context);
                        int resolveOrThrow = ImageOriginUtils.resolveOrThrow(tooltipDrawable.context, R$attr.colorOnBackground, TooltipDrawable.class.getCanonicalName());
                        tooltipDrawable.setFillColor(ColorStateList.valueOf(obtainStyledAttributes2.getColor(R$styleable.Tooltip_backgroundTint, ColorUtils.compositeColors(ColorUtils.setAlphaComponent(resolveOrThrow, 153), ColorUtils.setAlphaComponent(ImageOriginUtils.resolveOrThrow(tooltipDrawable.context, 16842801, TooltipDrawable.class.getCanonicalName()), FTPReply.ENTERING_EPSV_MODE)))));
                        tooltipDrawable.setStrokeColor(ColorStateList.valueOf(ImageOriginUtils.resolveOrThrow(tooltipDrawable.context, R$attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
                        tooltipDrawable.padding = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
                        tooltipDrawable.minWidth = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
                        tooltipDrawable.minHeight = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
                        tooltipDrawable.layoutMargin = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
                        obtainStyledAttributes2.recycle();
                        obtainStyledAttributes.recycle();
                        this.labels.add(tooltipDrawable);
                        if (ViewCompat.isAttachedToWindow(this)) {
                            attachLabelToContentView(tooltipDrawable);
                        }
                    } else {
                        throw null;
                    }
                }
                if (this.labels.size() == 1) {
                    i = 0;
                }
                for (TooltipDrawable strokeWidth : this.labels) {
                    strokeWidth.setStrokeWidth((float) i);
                }
                dispatchOnChangedProgramatically();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    public final void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        ViewGroup contentView = ImageOriginUtils.getContentView(this);
        if (tooltipDrawable == null) {
            throw null;
        } else if (contentView != null) {
            int[] iArr = new int[2];
            contentView.getLocationOnScreen(iArr);
            tooltipDrawable.locationOnScreenX = iArr[0];
            contentView.getWindowVisibleDisplayFrame(tooltipDrawable.displayFrame);
            contentView.addOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
        }
    }

    public final float calculateStepIncrement(int i) {
        float f2 = this.stepSize;
        if (f2 == 0.0f) {
            f2 = 1.0f;
        }
        float f3 = (this.valueTo - this.valueFrom) / f2;
        float f4 = (float) i;
        if (f3 <= f4) {
            return f2;
        }
        return ((float) Math.round(f3 / f4)) * f2;
    }

    public final int calculateTop() {
        int i = this.trackTop;
        int i2 = 0;
        if (this.labelBehavior == 1) {
            i2 = this.labels.get(0).getIntrinsicHeight();
        }
        return i + i2;
    }

    public final ValueAnimator createLabelAnimator(boolean z) {
        float f2 = 0.0f;
        float f3 = z ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z ? this.labelsOutAnimator : this.labelsInAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            f3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        if (z) {
            f2 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f3, f2});
        ofFloat.setDuration(z ? 83 : 117);
        ofFloat.setInterpolator(z ? AnimationUtils.DECELERATE_INTERPOLATOR : AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (TooltipDrawable next : BaseSlider.this.labels) {
                    next.tooltipPivotY = 1.2f;
                    next.tooltipScaleX = floatValue;
                    next.tooltipScaleY = floatValue;
                    next.labelOpacity = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, floatValue);
                    next.invalidateSelf();
                }
                ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
            }
        });
        return ofFloat;
    }

    public final void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay = ImageOriginUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            ((ViewOverlayApi18) contentViewOverlay).viewOverlay.remove(tooltipDrawable);
            ViewGroup contentView = ImageOriginUtils.getContentView(this);
            if (tooltipDrawable == null) {
                throw null;
            } else if (contentView != null) {
                contentView.removeOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
            }
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void dispatchOnChangedProgramatically() {
        for (L l : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                l.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable next : this.labels) {
            if (next.isStateful()) {
                next.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    public final void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator createLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = createLabelAnimator;
            this.labelsInAnimator = null;
            createLabelAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    for (TooltipDrawable remove : BaseSlider.this.labels) {
                        ((ViewOverlayApi18) ImageOriginUtils.getContentViewOverlay(BaseSlider.this)).viewOverlay.remove(remove);
                    }
                }
            });
            this.labelsOutAnimator.start();
        }
    }

    public final String formatValue(float f2) {
        if (this.formatter != null) {
            return this.formatter.getFormattedValue(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", new Object[]{Float.valueOf(f2)});
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.mAccessibilityFocusedVirtualViewId;
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public final int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.drawableState.elevation;
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.thumbDrawable.drawableState.strokeColor;
    }

    public float getThumbStrokeWidth() {
        return this.thumbDrawable.drawableState.strokeWidth;
    }

    public ColorStateList getThumbTintList() {
        return this.thumbDrawable.drawableState.fillColor;
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public final boolean isInVerticalScrollingContainer() {
        ViewParent parent = getParent();
        while (true) {
            boolean z = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) {
                z = true;
            }
            if (z && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    public final boolean isRtl() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public final void maybeCalculateTicksCoordinates() {
        if (this.stepSize > 0.0f) {
            validateConfigurationIfDirty();
            int min = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
            float[] fArr = this.ticksCoordinates;
            if (fArr == null || fArr.length != min * 2) {
                this.ticksCoordinates = new float[(min * 2)];
            }
            float f2 = ((float) this.trackWidth) / ((float) (min - 1));
            for (int i = 0; i < min * 2; i += 2) {
                float[] fArr2 = this.ticksCoordinates;
                fArr2[i] = (((float) (i / 2)) * f2) + ((float) this.trackSidePadding);
                fArr2[i + 1] = (float) calculateTop();
            }
        }
    }

    public final boolean moveFocus(int i) {
        int i2 = this.focusedThumbIdx;
        long j = ((long) i2) + ((long) i);
        long size = (long) (this.values.size() - 1);
        if (j < 0) {
            j = 0;
        } else if (j > size) {
            j = size;
        }
        int i3 = (int) j;
        this.focusedThumbIdx = i3;
        if (i3 == i2) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = i3;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    public final boolean moveFocusInAbsoluteDirection(int i) {
        if (isRtl()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return moveFocus(i);
    }

    public final float normalizeValue(float f2) {
        float f3 = this.valueFrom;
        float f4 = (f2 - f3) / (this.valueTo - f3);
        return isRtl() ? 1.0f - f4 : f4;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable attachLabelToContentView : this.labels) {
            attachLabelToContentView(attachLabelToContentView);
        }
    }

    public void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 != null) {
            removeCallbacks(accessibilityEventSender2);
        }
        this.labelsAreAnimatedIn = false;
        for (TooltipDrawable detachLabelFromContentView : this.labels) {
            detachLabelFromContentView(detachLabelFromContentView);
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            maybeCalculateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTop = calculateTop();
        int i = this.trackWidth;
        float[] activeRange = getActiveRange();
        int i2 = this.trackSidePadding;
        float f2 = (float) i;
        float f3 = (activeRange[1] * f2) + ((float) i2);
        float f4 = (float) (i2 + i);
        if (f3 < f4) {
            float f5 = (float) calculateTop;
            canvas.drawLine(f3, f5, f4, f5, this.inactiveTrackPaint);
        }
        float f6 = (float) this.trackSidePadding;
        float f7 = (activeRange[0] * f2) + f6;
        if (f7 > f6) {
            float f8 = (float) calculateTop;
            canvas.drawLine(f6, f8, f7, f8, this.inactiveTrackPaint);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            int i3 = this.trackWidth;
            float[] activeRange2 = getActiveRange();
            float f9 = (float) this.trackSidePadding;
            float f10 = (float) i3;
            float f11 = (float) calculateTop;
            Canvas canvas2 = canvas;
            canvas2.drawLine((activeRange2[0] * f10) + f9, f11, (activeRange2[1] * f10) + f9, f11, this.activeTrackPaint);
        }
        if (this.tickVisible && this.stepSize > 0.0f) {
            float[] activeRange3 = getActiveRange();
            int round = Math.round(activeRange3[0] * ((float) ((this.ticksCoordinates.length / 2) - 1)));
            int round2 = Math.round(activeRange3[1] * ((float) ((this.ticksCoordinates.length / 2) - 1)));
            int i4 = round * 2;
            canvas.drawPoints(this.ticksCoordinates, 0, i4, this.inactiveTicksPaint);
            int i5 = round2 * 2;
            canvas.drawPoints(this.ticksCoordinates, i4, i5 - i4, this.activeTicksPaint);
            float[] fArr = this.ticksCoordinates;
            canvas.drawPoints(fArr, i5, fArr.length - i5, this.inactiveTicksPaint);
        }
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            int i6 = this.trackWidth;
            if (shouldDrawCompatHalo()) {
                int normalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) i6)) + ((float) this.trackSidePadding));
                if (VERSION.SDK_INT < 28) {
                    int i7 = this.haloRadius;
                    canvas.clipRect((float) (normalizeValue - i7), (float) (calculateTop - i7), (float) (normalizeValue + i7), (float) (i7 + calculateTop), Op.UNION);
                }
                canvas.drawCircle((float) normalizeValue, (float) calculateTop, (float) this.haloRadius, this.haloPaint);
            }
            if (!(this.activeThumbIdx == -1 || this.labelBehavior == 2)) {
                if (!this.labelsAreAnimatedIn) {
                    this.labelsAreAnimatedIn = true;
                    ValueAnimator createLabelAnimator = createLabelAnimator(true);
                    this.labelsInAnimator = createLabelAnimator;
                    this.labelsOutAnimator = null;
                    createLabelAnimator.start();
                }
                Iterator<TooltipDrawable> it = this.labels.iterator();
                for (int i8 = 0; i8 < this.values.size() && it.hasNext(); i8++) {
                    if (i8 != this.focusedThumbIdx) {
                        setValueForLabel(it.next(), this.values.get(i8).floatValue());
                    }
                }
                if (it.hasNext()) {
                    setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
                } else {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
                }
            }
        }
        int i9 = this.trackWidth;
        if (!isEnabled()) {
            Iterator<Float> it2 = this.values.iterator();
            while (it2.hasNext()) {
                canvas.drawCircle((normalizeValue(it2.next().floatValue()) * ((float) i9)) + ((float) this.trackSidePadding), (float) calculateTop, (float) this.thumbRadius, this.thumbPaint);
            }
        }
        Iterator<Float> it3 = this.values.iterator();
        while (it3.hasNext()) {
            canvas.save();
            int normalizeValue2 = this.trackSidePadding + ((int) (normalizeValue(it3.next().floatValue()) * ((float) i9)));
            int i10 = this.thumbRadius;
            canvas.translate((float) (normalizeValue2 - i10), (float) (calculateTop - i10));
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            this.activeThumbIdx = -1;
            ensureLabelsRemoved();
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        if (i == 1) {
            moveFocus(Integer.MAX_VALUE);
        } else if (i == 2) {
            moveFocus(LinearLayoutManager.INVALID_OFFSET);
        } else if (i == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else if (i == 66) {
            moveFocusInAbsoluteDirection(LinearLayoutManager.INVALID_OFFSET);
        }
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r5v5, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r5v7, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v9, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v10, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v13, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v14, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v15, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v16, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r5v25 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.Boolean, java.lang.Float]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Float, java.lang.Boolean]
      mth insns count: 112
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r12, android.view.KeyEvent r13) {
        /*
            r11 = this;
            boolean r0 = r11.isEnabled()
            if (r0 != 0) goto L_0x000b
            boolean r12 = super.onKeyDown(r12, r13)
            return r12
        L_0x000b:
            java.util.ArrayList<java.lang.Float> r0 = r11.values
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x0017
            r11.activeThumbIdx = r1
        L_0x0017:
            int r0 = r11.activeThumbIdx
            r3 = 66
            r4 = 61
            r5 = 0
            r6 = 81
            r7 = 70
            r8 = 69
            r9 = -1
            if (r0 != r9) goto L_0x0083
            if (r12 == r4) goto L_0x0057
            if (r12 == r3) goto L_0x004d
            if (r12 == r6) goto L_0x0047
            if (r12 == r8) goto L_0x0041
            if (r12 == r7) goto L_0x0047
            switch(r12) {
                case 21: goto L_0x003b;
                case 22: goto L_0x0035;
                case 23: goto L_0x004d;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0077
        L_0x0035:
            r11.moveFocusInAbsoluteDirection(r2)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x003b:
            r11.moveFocusInAbsoluteDirection(r9)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x0041:
            r11.moveFocus(r9)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x0047:
            r11.moveFocus(r2)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x004d:
            int r0 = r11.focusedThumbIdx
            r11.activeThumbIdx = r0
            r11.postInvalidate()
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x0057:
            boolean r0 = r13.hasNoModifiers()
            if (r0 == 0) goto L_0x0066
            boolean r0 = r11.moveFocus(r2)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            goto L_0x0077
        L_0x0066:
            boolean r0 = r13.isShiftPressed()
            if (r0 == 0) goto L_0x0075
            boolean r0 = r11.moveFocus(r9)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            goto L_0x0077
        L_0x0075:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
        L_0x0077:
            if (r5 == 0) goto L_0x007e
            boolean r12 = r5.booleanValue()
            goto L_0x0082
        L_0x007e:
            boolean r12 = super.onKeyDown(r12, r13)
        L_0x0082:
            return r12
        L_0x0083:
            boolean r0 = r11.isLongPress
            boolean r10 = r13.isLongPress()
            r0 = r0 | r10
            r11.isLongPress = r0
            if (r0 == 0) goto L_0x0095
            r0 = 20
            float r0 = r11.calculateStepIncrement(r0)
            goto L_0x009e
        L_0x0095:
            float r0 = r11.stepSize
            r10 = 0
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 != 0) goto L_0x009e
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x009e:
            r10 = 21
            if (r12 == r10) goto L_0x00c4
            r10 = 22
            if (r12 == r10) goto L_0x00b8
            if (r12 == r8) goto L_0x00b2
            if (r12 == r7) goto L_0x00ad
            if (r12 == r6) goto L_0x00ad
            goto L_0x00d0
        L_0x00ad:
            java.lang.Float r5 = java.lang.Float.valueOf(r0)
            goto L_0x00d0
        L_0x00b2:
            float r0 = -r0
            java.lang.Float r5 = java.lang.Float.valueOf(r0)
            goto L_0x00d0
        L_0x00b8:
            boolean r5 = r11.isRtl()
            if (r5 == 0) goto L_0x00bf
            float r0 = -r0
        L_0x00bf:
            java.lang.Float r5 = java.lang.Float.valueOf(r0)
            goto L_0x00d0
        L_0x00c4:
            boolean r5 = r11.isRtl()
            if (r5 == 0) goto L_0x00cb
            goto L_0x00cc
        L_0x00cb:
            float r0 = -r0
        L_0x00cc:
            java.lang.Float r5 = java.lang.Float.valueOf(r0)
        L_0x00d0:
            if (r5 == 0) goto L_0x00f4
            java.util.ArrayList<java.lang.Float> r12 = r11.values
            int r13 = r11.activeThumbIdx
            java.lang.Object r12 = r12.get(r13)
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            float r13 = r5.floatValue()
            float r13 = r13 + r12
            int r12 = r11.activeThumbIdx
            boolean r12 = r11.snapThumbToValue(r12, r13)
            if (r12 == 0) goto L_0x00f3
            r11.updateHaloHotspot()
            r11.postInvalidate()
        L_0x00f3:
            return r2
        L_0x00f4:
            r0 = 23
            if (r12 == r0) goto L_0x0118
            if (r12 == r4) goto L_0x0101
            if (r12 == r3) goto L_0x0118
            boolean r12 = super.onKeyDown(r12, r13)
            return r12
        L_0x0101:
            boolean r12 = r13.hasNoModifiers()
            if (r12 == 0) goto L_0x010c
            boolean r12 = r11.moveFocus(r2)
            return r12
        L_0x010c:
            boolean r12 = r13.isShiftPressed()
            if (r12 == 0) goto L_0x0117
            boolean r12 = r11.moveFocus(r9)
            return r12
        L_0x0117:
            return r1
        L_0x0118:
            r11.activeThumbIdx = r9
            r11.ensureLabelsRemoved()
            r11.postInvalidate()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    public void onMeasure(int i, int i2) {
        int i3 = this.widgetHeight;
        int i4 = 0;
        if (this.labelBehavior == 1) {
            i4 = this.labels.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3 + i4, 1073741824));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
        updateHaloHotspot();
    }

    public final void onStartTrackingTouch() {
        for (T onStartTrackingTouch : this.touchListeners) {
            onStartTrackingTouch.onStartTrackingTouch(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f2 = (x - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        this.touchPosition = f2;
        float max = Math.max(0.0f, f2);
        this.touchPosition = max;
        this.touchPosition = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x;
            if (!isInVerticalScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            MotionEvent motionEvent2 = this.lastEvent;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= ((float) this.scaledTouchSlop) && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= ((float) this.scaledTouchSlop) && pickActiveThumb()) {
                onStartTrackingTouch();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
                for (T onStopTrackingTouch : this.touchListeners) {
                    onStopTrackingTouch.onStopTrackingTouch(this);
                }
            }
            ensureLabelsRemoved();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (isInVerticalScrollingContainer() && Math.abs(x - this.touchDownX) < ((float) this.scaledTouchSlop)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                onStartTrackingTouch();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(motionEvent);
        return true;
    }

    public boolean pickActiveThumb() {
        boolean z = true;
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float normalizeValue = (normalizeValue(valueOfTouchPositionAbsolute) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i = 1; i < this.values.size(); i++) {
            float abs2 = Math.abs(this.values.get(i).floatValue() - valueOfTouchPositionAbsolute);
            float normalizeValue2 = (normalizeValue(this.values.get(i).floatValue()) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z2 = !isRtl() ? normalizeValue2 - normalizeValue < 0.0f : normalizeValue2 - normalizeValue > 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(normalizeValue2 - normalizeValue) < ((float) this.scaledTouchSlop)) {
                    this.activeThumbIdx = -1;
                    return false;
                } else if (z2) {
                    this.activeThumbIdx = i;
                }
            }
            abs = abs2;
        }
        if (this.activeThumbIdx == -1) {
            z = false;
        }
        return z;
    }

    public void setActiveThumbIndex(int i) {
        this.activeThumbIdx = i;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i);
        postInvalidate();
    }

    public void setHaloRadius(int i) {
        if (i != this.haloRadius) {
            this.haloRadius = i;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                postInvalidate();
                return;
            }
            RippleDrawable rippleDrawable = (RippleDrawable) background;
            int i2 = this.haloRadius;
            if (VERSION.SDK_INT >= 23) {
                rippleDrawable.setRadius(i2);
            } else {
                Class<RippleDrawable> cls = RippleDrawable.class;
                try {
                    cls.getDeclaredMethod("setMaxRadius", new Class[]{Integer.TYPE}).invoke(rippleDrawable, new Object[]{Integer.valueOf(i2)});
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                    throw new IllegalStateException("Couldn't set RippleDrawable radius", e2);
                }
            }
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.haloColor)) {
            this.haloColor = colorStateList;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                this.haloPaint.setColor(colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor()));
                this.haloPaint.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public void setLabelBehavior(int i) {
        if (this.labelBehavior != i) {
            this.labelBehavior = i;
            requestLayout();
        }
    }

    public void setLabelFormatter(LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setSeparationUnit(int i) {
        this.separationUnit = i;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.toString(f2), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
        } else if (this.stepSize != f2) {
            this.stepSize = f2;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.elevation != f2) {
            materialShapeDrawableState.elevation = f2;
            materialShapeDrawable.updateZ();
        }
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbRadius(int i) {
        if (i != this.thumbRadius) {
            this.thumbRadius = i;
            this.trackSidePadding = this.minTrackSidePadding + Math.max(i - this.defaultThumbRadius, 0);
            if (ViewCompat.isLaidOut(this)) {
                this.trackWidth = Math.max(getWidth() - (this.trackSidePadding * 2), 0);
                maybeCalculateTicksCoordinates();
            }
            MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
            Builder builder = new Builder();
            float f2 = (float) this.thumbRadius;
            CornerTreatment createCornerTreatment = TextAppearanceConfig.createCornerTreatment(0);
            builder.topLeftCorner = createCornerTreatment;
            float compatCornerTreatmentSize = Builder.compatCornerTreatmentSize(createCornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                builder.setTopLeftCornerSize(compatCornerTreatmentSize);
            }
            builder.topRightCorner = createCornerTreatment;
            float compatCornerTreatmentSize2 = Builder.compatCornerTreatmentSize(createCornerTreatment);
            if (compatCornerTreatmentSize2 != -1.0f) {
                builder.setTopRightCornerSize(compatCornerTreatmentSize2);
            }
            builder.bottomRightCorner = createCornerTreatment;
            float compatCornerTreatmentSize3 = Builder.compatCornerTreatmentSize(createCornerTreatment);
            if (compatCornerTreatmentSize3 != -1.0f) {
                builder.setBottomRightCornerSize(compatCornerTreatmentSize3);
            }
            builder.bottomLeftCorner = createCornerTreatment;
            float compatCornerTreatmentSize4 = Builder.compatCornerTreatmentSize(createCornerTreatment);
            if (compatCornerTreatmentSize4 != -1.0f) {
                builder.setBottomLeftCornerSize(compatCornerTreatmentSize4);
            }
            builder.setAllCornerSizes(f2);
            materialShapeDrawable.drawableState.shapeAppearanceModel = builder.build();
            materialShapeDrawable.invalidateSelf();
            MaterialShapeDrawable materialShapeDrawable2 = this.thumbDrawable;
            int i2 = this.thumbRadius;
            materialShapeDrawable2.setBounds(0, 0, i2 * 2, i2 * 2);
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.thumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        materialShapeDrawable.drawableState.strokeWidth = f2;
        materialShapeDrawable.invalidateSelf();
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.thumbDrawable.drawableState.fillColor)) {
            this.thumbDrawable.setFillColor(colorStateList);
            invalidate();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorActive)) {
            this.tickColorActive = colorStateList;
            this.activeTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorInactive)) {
            this.tickColorInactive = colorStateList;
            this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.tickVisible != z) {
            this.tickVisible = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorActive)) {
            this.trackColorActive = colorStateList;
            this.activeTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTrackHeight(int i) {
        if (this.trackHeight != i) {
            this.trackHeight = i;
            this.inactiveTrackPaint.setStrokeWidth((float) i);
            this.activeTrackPaint.setStrokeWidth((float) this.trackHeight);
            this.inactiveTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
            this.activeTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorInactive)) {
            this.trackColorInactive = colorStateList;
            this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public final void setValueForLabel(TooltipDrawable tooltipDrawable, float f2) {
        String formatValue = formatValue(f2);
        if (!TextUtils.equals(tooltipDrawable.text, formatValue)) {
            tooltipDrawable.text = formatValue;
            tooltipDrawable.textDrawableHelper.textWidthDirty = true;
            tooltipDrawable.invalidateSelf();
        }
        int normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f2) * ((float) this.trackWidth)))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int calculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(normalizeValue, calculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + normalizeValue, calculateTop);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ImageOriginUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ((ViewOverlayApi18) ImageOriginUtils.getContentViewOverlay(this)).viewOverlay.add(tooltipDrawable);
    }

    public void setValueFrom(float f2) {
        this.valueFrom = f2;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.valueTo = f2;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public final boolean shouldDrawCompatHalo() {
        return !(getBackground() instanceof RippleDrawable);
    }

    public final boolean snapThumbToValue(int i, float f2) {
        if (((double) Math.abs(f2 - this.values.get(i).floatValue())) < 1.0E-4d) {
            return false;
        }
        float f3 = 0.0f;
        float minSeparation = this.stepSize == 0.0f ? getMinSeparation() : 0.0f;
        if (this.separationUnit == 0) {
            if (minSeparation != 0.0f) {
                float f4 = (minSeparation - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
                float f5 = this.valueFrom;
                f3 = GeneratedOutlineSupport.outline3(f5, this.valueTo, f4, f5);
            }
            minSeparation = f3;
        }
        if (isRtl()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        this.values.set(i, Float.valueOf(b.clamp(f2, i3 < 0 ? this.valueFrom : minSeparation + this.values.get(i3).floatValue(), i2 >= this.values.size() ? this.valueTo : this.values.get(i2).floatValue() - minSeparation)));
        this.focusedThumbIdx = i;
        for (L onValueChange : this.changeListeners) {
            onValueChange.onValueChange(this, this.values.get(i).floatValue(), true);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
            if (accessibilityEventSender2 == null) {
                this.accessibilityEventSender = new AccessibilityEventSender<>(null);
            } else {
                removeCallbacks(accessibilityEventSender2);
            }
            AccessibilityEventSender accessibilityEventSender3 = this.accessibilityEventSender;
            accessibilityEventSender3.virtualViewId = i;
            postDelayed(accessibilityEventSender3, 200);
        }
        return true;
    }

    public final boolean snapTouchPosition() {
        return snapThumbToValue(this.activeThumbIdx, getValueOfTouchPosition());
    }

    public void updateBoundsForVirturalViewId(int i, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * ((float) this.trackWidth)));
        int calculateTop = calculateTop();
        int i2 = this.thumbRadius;
        rect.set(normalizeValue - i2, calculateTop - i2, normalizeValue + i2, calculateTop + i2);
    }

    public final void updateHaloHotspot() {
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int normalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) this.trackWidth)) + ((float) this.trackSidePadding));
                int calculateTop = calculateTop();
                int i = this.haloRadius;
                background.setHotspotBounds(normalizeValue - i, calculateTop - i, normalizeValue + i, calculateTop + i);
            }
        }
    }

    public final void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            float f2 = this.valueFrom;
            float f3 = this.valueTo;
            if (f2 >= f3) {
                throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[]{Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
            } else if (f3 <= f2) {
                throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[]{Float.toString(this.valueTo), Float.toString(this.valueFrom)}));
            } else if (this.stepSize <= 0.0f || valueLandsOnTick(f3)) {
                Iterator<Float> it = this.values.iterator();
                while (it.hasNext()) {
                    Float next = it.next();
                    if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[]{Float.toString(next.floatValue()), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
                    } else if (this.stepSize > 0.0f && !valueLandsOnTick(next.floatValue())) {
                        throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{Float.toString(next.floatValue()), Float.toString(this.valueFrom), Float.toString(this.stepSize), Float.toString(this.stepSize)}));
                    }
                }
                float f4 = this.stepSize;
                if (f4 != 0.0f) {
                    if (((float) ((int) f4)) != f4) {
                        String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[]{"stepSize", Float.valueOf(f4)});
                    }
                    float f5 = this.valueFrom;
                    if (((float) ((int) f5)) != f5) {
                        String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[]{"valueFrom", Float.valueOf(f5)});
                    }
                    float f6 = this.valueTo;
                    if (((float) ((int) f6)) != f6) {
                        String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[]{"valueTo", Float.valueOf(f6)});
                    }
                }
                this.dirtyConfig = false;
            } else {
                throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
            }
        }
    }

    public final boolean valueLandsOnTick(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    public BaseSlider(Context context, final AttributeSet attributeSet, final int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        this.thumbDrawable = new MaterialShapeDrawable();
        this.separationUnit = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        paint.setStyle(Style.STROKE);
        this.inactiveTrackPaint.setStrokeCap(Cap.ROUND);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(Style.STROKE);
        this.activeTrackPaint.setStrokeCap(Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        paint3.setStyle(Style.FILL);
        this.thumbPaint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(Style.FILL);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(Style.STROKE);
        this.inactiveTicksPaint.setStrokeCap(Cap.ROUND);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(Style.STROKE);
        this.activeTicksPaint.setStrokeCap(Cap.ROUND);
        Resources resources = context2.getResources();
        this.widgetHeight = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(R$dimen.mtrl_slider_thumb_radius);
        this.trackTop = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
        this.labelMaker = new TooltipDrawableFactory() {
        };
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.Slider, i, DEF_STYLE_RES, new int[0]);
        this.valueFrom = obtainStyledAttributes.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = obtainStyledAttributes.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.Slider_trackColor);
        int i2 = hasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorInactive;
        int i3 = hasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorActive;
        setTrackInactiveTintList(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i2) == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_inactive_track_color) : ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i2));
        setTrackActiveTintList(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i3) == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_active_track_color) : ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i3));
        this.thumbDrawable.setFillColor(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.Slider_thumbColor));
        if (obtainStyledAttributes.hasValue(R$styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R$styleable.Slider_thumbStrokeWidth, 0.0f));
        setHaloTintList(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.Slider_haloColor) == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_halo_color) : ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.Slider_haloColor));
        this.tickVisible = obtainStyledAttributes.getBoolean(R$styleable.Slider_tickVisible, true);
        boolean hasValue2 = obtainStyledAttributes.hasValue(R$styleable.Slider_tickColor);
        int i4 = hasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorInactive;
        int i5 = hasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorActive;
        setTickInactiveTintList(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i4) == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_inactive_tick_marks_color) : ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i4));
        setTickActiveTintList(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i5) == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_active_tick_marks_color) : ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, i5));
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        this.labelBehavior = obtainStyledAttributes.getInt(R$styleable.Slider_labelBehavior, 0);
        if (!obtainStyledAttributes.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        this.thumbDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper2 = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper2;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper2);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList(list));
    }
}
