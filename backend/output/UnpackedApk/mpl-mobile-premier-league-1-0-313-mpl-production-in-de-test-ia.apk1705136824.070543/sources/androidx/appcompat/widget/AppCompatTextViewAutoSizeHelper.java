package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class AppCompatTextViewAutoSizeHelper {
    public static final RectF TEMP_RECTF = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap<>();
    public float mAutoSizeMaxTextSizeInPx = -1.0f;
    public float mAutoSizeMinTextSizeInPx = -1.0f;
    public float mAutoSizeStepGranularityInPx = -1.0f;
    public int[] mAutoSizeTextSizesInPx = new int[0];
    public int mAutoSizeTextType = 0;
    public final Context mContext;
    public boolean mHasPresetAutoSizeValues = false;
    public final Impl mImpl;
    public boolean mNeedsAutoSizeText = false;
    public TextPaint mTempTextPaint;
    public final TextView mTextView;

    public static class Impl {
        public void computeAndSetTextDirection(Builder builder, TextView textView) {
        }

        public boolean isHorizontallyScrollable(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public static class Impl23 extends Impl {
        public void computeAndSetTextDirection(Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public static class Impl29 extends Impl23 {
        public void computeAndSetTextDirection(Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        public boolean isHorizontallyScrollable(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        int i = VERSION.SDK_INT;
        if (i >= 29) {
            this.mImpl = new Impl29();
        } else if (i >= 23) {
            this.mImpl = new Impl23();
        } else {
            this.mImpl = new Impl();
        }
    }

    public static Method getTextViewMethod(String str) {
        try {
            Method method = sTextViewMethodByNameCache.get(str);
            if (method == null) {
                method = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    sTextViewMethodByNameCache.put(str, method);
                }
            }
            return method;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T invokeAndReturnWithDefault(Object obj, String str, T t) {
        try {
            return getTextViewMethod(str).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return t;
        }
    }

    public void autoSizeText() {
        int i;
        if (supportsAutoSizeText() && this.mAutoSizeTextType != 0) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() > 0 && this.mTextView.getMeasuredWidth() > 0) {
                    if (this.mImpl.isHorizontallyScrollable(this.mTextView)) {
                        i = 1048576;
                    } else {
                        i = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                    }
                    int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                    if (i > 0 && height > 0) {
                        synchronized (TEMP_RECTF) {
                            TEMP_RECTF.setEmpty();
                            TEMP_RECTF.right = (float) i;
                            TEMP_RECTF.bottom = (float) height;
                            float findLargestTextSizeWhichFits = (float) findLargestTextSizeWhichFits(TEMP_RECTF);
                            if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                                setTextSizeInternal(0, findLargestTextSizeWhichFits);
                            }
                        }
                    }
                }
                return;
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    public final int[] cleanupAutoSizePresetSizes(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    public final int findLargestTextSizeWhichFits(RectF rectF) {
        StaticLayout staticLayout;
        int i;
        RectF rectF2 = rectF;
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            while (i4 <= i2) {
                int i6 = (i4 + i2) / 2;
                int i7 = this.mAutoSizeTextSizesInPx[i6];
                CharSequence text = this.mTextView.getText();
                TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
                if (transformationMethod != null) {
                    CharSequence transformation = transformationMethod.getTransformation(text, this.mTextView);
                    if (transformation != null) {
                        text = transformation;
                    }
                }
                int maxLines = this.mTextView.getMaxLines();
                TextPaint textPaint = this.mTempTextPaint;
                if (textPaint == null) {
                    this.mTempTextPaint = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.mTempTextPaint.set(this.mTextView.getPaint());
                this.mTempTextPaint.setTextSize((float) i7);
                Alignment alignment = (Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Alignment.ALIGN_NORMAL);
                int round = Math.round(rectF2.right);
                if (VERSION.SDK_INT >= 23) {
                    Builder obtain = Builder.obtain(text, i3, text.length(), this.mTempTextPaint, round);
                    obtain.setAlignment(alignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
                    try {
                        this.mImpl.computeAndSetTextDirection(obtain, this.mTextView);
                    } catch (ClassCastException unused) {
                    }
                    staticLayout = obtain.build();
                    i = -1;
                } else {
                    i = -1;
                    StaticLayout staticLayout2 = new StaticLayout(text, this.mTempTextPaint, round, alignment, this.mTextView.getLineSpacingMultiplier(), this.mTextView.getLineSpacingExtra(), this.mTextView.getIncludeFontPadding());
                    staticLayout = staticLayout2;
                }
                if ((maxLines == i || (staticLayout.getLineCount() <= maxLines && staticLayout.getLineEnd(staticLayout.getLineCount() - 1) == text.length())) && ((float) staticLayout.getHeight()) <= rectF2.bottom) {
                    i3 = 0;
                    int i8 = i6 + 1;
                    i5 = i4;
                    i4 = i8;
                } else {
                    i5 = i6 - 1;
                    i2 = i5;
                    i3 = 0;
                }
            }
            return this.mAutoSizeTextSizesInPx[i5];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public void setTextSizeInternal(int i, float f2) {
        Resources resources;
        Context context = this.mContext;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f2, resources.getDisplayMetrics());
        if (applyDimension != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(applyDimension);
            boolean isInLayout = this.mTextView.isInLayout();
            if (this.mTextView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(this.mTextView, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (!isInLayout) {
                    this.mTextView.requestLayout();
                } else {
                    this.mTextView.forceLayout();
                }
                this.mTextView.invalidate();
            }
        }
    }

    public final boolean setupAutoSizeText() {
        if (!supportsAutoSizeText() || this.mAutoSizeTextType != 1) {
            this.mNeedsAutoSizeText = false;
        } else {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int floor = ((int) Math.floor((double) ((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx))) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round((((float) i) * this.mAutoSizeStepGranularityInPx) + this.mAutoSizeMinTextSizeInPx);
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            }
            this.mNeedsAutoSizeText = true;
        }
        return this.mNeedsAutoSizeText;
    }

    public final boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int length = this.mAutoSizeTextSizesInPx.length;
        boolean z = length > 0;
        this.mHasPresetAutoSizeValues = z;
        if (z) {
            this.mAutoSizeTextType = 1;
            int[] iArr = this.mAutoSizeTextSizesInPx;
            this.mAutoSizeMinTextSizeInPx = (float) iArr[0];
            this.mAutoSizeMaxTextSizeInPx = (float) iArr[length - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return this.mHasPresetAutoSizeValues;
    }

    public final boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    public final void validateAndSetAutoSizeTextTypeUniformConfiguration(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = f2;
            this.mAutoSizeMaxTextSizeInPx = f3;
            this.mAutoSizeStepGranularityInPx = f4;
            this.mHasPresetAutoSizeValues = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }
}
