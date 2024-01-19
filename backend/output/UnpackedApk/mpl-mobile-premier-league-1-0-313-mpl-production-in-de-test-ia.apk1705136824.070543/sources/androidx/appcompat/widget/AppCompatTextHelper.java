package androidx.appcompat.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class AppCompatTextHelper {
    public boolean mAsyncFontPending;
    public final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    public TintInfo mDrawableBottomTint;
    public TintInfo mDrawableEndTint;
    public TintInfo mDrawableLeftTint;
    public TintInfo mDrawableRightTint;
    public TintInfo mDrawableStartTint;
    public TintInfo mDrawableTint;
    public TintInfo mDrawableTopTint;
    public Typeface mFontTypeface;
    public int mFontWeight = -1;
    public int mStyle = 0;
    public final TextView mView;

    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    public static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    public final void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    public void applyCompoundDrawablesTints() {
        if (!(this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    public boolean isAutoSizeEnabled() {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        return appCompatTextViewAutoSizeHelper.supportsAutoSizeText() && appCompatTextViewAutoSizeHelper.mAutoSizeTextType != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:233:0x044e, code lost:
        if (r3 != null) goto L_0x0455;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x042e  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0476  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04bf  */
    /* JADX WARNING: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(android.util.AttributeSet r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r8 = r18
            r9 = r19
            android.widget.TextView r1 = r0.mView
            android.content.Context r10 = r1.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r11 = androidx.appcompat.widget.AppCompatDrawableManager.get()
            int[] r1 = androidx.appcompat.R$styleable.AppCompatTextHelper
            r12 = 0
            androidx.appcompat.widget.TintTypedArray r13 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r10, r8, r1, r9, r12)
            android.widget.TextView r1 = r0.mView
            android.content.Context r2 = r1.getContext()
            int[] r3 = androidx.appcompat.R$styleable.AppCompatTextHelper
            android.content.res.TypedArray r5 = r13.mWrapped
            r7 = 0
            r4 = r18
            r6 = r19
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r1 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_textAppearance
            r14 = -1
            int r1 = r13.getResourceId(r1, r14)
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableLeft
            boolean r2 = r13.hasValue(r2)
            if (r2 == 0) goto L_0x0044
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableLeft
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r0.mDrawableLeftTint = r2
        L_0x0044:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableTop
            boolean r2 = r13.hasValue(r2)
            if (r2 == 0) goto L_0x0058
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableTop
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r0.mDrawableTopTint = r2
        L_0x0058:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableRight
            boolean r2 = r13.hasValue(r2)
            if (r2 == 0) goto L_0x006c
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableRight
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r0.mDrawableRightTint = r2
        L_0x006c:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableBottom
            boolean r2 = r13.hasValue(r2)
            if (r2 == 0) goto L_0x0080
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableBottom
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r0.mDrawableBottomTint = r2
        L_0x0080:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableStart
            boolean r2 = r13.hasValue(r2)
            if (r2 == 0) goto L_0x0094
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableStart
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r0.mDrawableStartTint = r2
        L_0x0094:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableEnd
            boolean r2 = r13.hasValue(r2)
            if (r2 == 0) goto L_0x00a8
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableEnd
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r0.mDrawableEndTint = r2
        L_0x00a8:
            android.content.res.TypedArray r2 = r13.mWrapped
            r2.recycle()
            android.widget.TextView r2 = r0.mView
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 23
            r4 = 26
            if (r1 == r14) goto L_0x013f
            int[] r5 = androidx.appcompat.R$styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r6 = new androidx.appcompat.widget.TintTypedArray
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r1, r5)
            r6.<init>(r10, r1)
            if (r2 != 0) goto L_0x00d8
            int r1 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r1 = r6.hasValue(r1)
            if (r1 == 0) goto L_0x00d8
            int r1 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r1 = r6.getBoolean(r1, r12)
            r5 = 1
            goto L_0x00da
        L_0x00d8:
            r1 = 0
            r5 = 0
        L_0x00da:
            r0.updateTypefaceAndStyle(r10, r6)
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 >= r3) goto L_0x0112
            int r7 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            boolean r7 = r6.hasValue(r7)
            if (r7 == 0) goto L_0x00f0
            int r7 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            android.content.res.ColorStateList r7 = r6.getColorStateList(r7)
            goto L_0x00f1
        L_0x00f0:
            r7 = 0
        L_0x00f1:
            int r15 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            boolean r15 = r6.hasValue(r15)
            if (r15 == 0) goto L_0x0100
            int r15 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r15 = r6.getColorStateList(r15)
            goto L_0x0101
        L_0x0100:
            r15 = 0
        L_0x0101:
            int r13 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            boolean r13 = r6.hasValue(r13)
            if (r13 == 0) goto L_0x0110
            int r13 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r13 = r6.getColorStateList(r13)
            goto L_0x0115
        L_0x0110:
            r13 = 0
            goto L_0x0115
        L_0x0112:
            r7 = 0
            r13 = 0
            r15 = 0
        L_0x0115:
            int r14 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            boolean r14 = r6.hasValue(r14)
            if (r14 == 0) goto L_0x0124
            int r14 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            java.lang.String r14 = r6.getString(r14)
            goto L_0x0125
        L_0x0124:
            r14 = 0
        L_0x0125:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r4) goto L_0x0138
            int r3 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            boolean r3 = r6.hasValue(r3)
            if (r3 == 0) goto L_0x0138
            int r3 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            java.lang.String r3 = r6.getString(r3)
            goto L_0x0139
        L_0x0138:
            r3 = 0
        L_0x0139:
            android.content.res.TypedArray r6 = r6.mWrapped
            r6.recycle()
            goto L_0x0146
        L_0x013f:
            r1 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0146:
            int[] r6 = androidx.appcompat.R$styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r4 = new androidx.appcompat.widget.TintTypedArray
            android.content.res.TypedArray r6 = r10.obtainStyledAttributes(r8, r6, r9, r12)
            r4.<init>(r10, r6)
            if (r2 != 0) goto L_0x0162
            int r6 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x0162
            int r1 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r1 = r4.getBoolean(r1, r12)
            r5 = 1
        L_0x0162:
            int r6 = android.os.Build.VERSION.SDK_INT
            r12 = 23
            if (r6 >= r12) goto L_0x0192
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x0176
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            android.content.res.ColorStateList r7 = r4.getColorStateList(r6)
        L_0x0176:
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x0184
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r15 = r4.getColorStateList(r6)
        L_0x0184:
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x0192
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r13 = r4.getColorStateList(r6)
        L_0x0192:
            int r6 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x01a0
            int r6 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            java.lang.String r14 = r4.getString(r6)
        L_0x01a0:
            int r6 = android.os.Build.VERSION.SDK_INT
            r12 = 26
            if (r6 < r12) goto L_0x01b4
            int r6 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x01b4
            int r3 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            java.lang.String r3 = r4.getString(r3)
        L_0x01b4:
            int r6 = android.os.Build.VERSION.SDK_INT
            r12 = 28
            if (r6 < r12) goto L_0x01d5
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textSize
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x01d5
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textSize
            r12 = -1
            int r6 = r4.getDimensionPixelSize(r6, r12)
            if (r6 != 0) goto L_0x01d5
            android.widget.TextView r6 = r0.mView
            r12 = 0
            r16 = r11
            r11 = 0
            r6.setTextSize(r11, r12)
            goto L_0x01d7
        L_0x01d5:
            r16 = r11
        L_0x01d7:
            r0.updateTypefaceAndStyle(r10, r4)
            android.content.res.TypedArray r4 = r4.mWrapped
            r4.recycle()
            if (r7 == 0) goto L_0x01e6
            android.widget.TextView r4 = r0.mView
            r4.setTextColor(r7)
        L_0x01e6:
            if (r15 == 0) goto L_0x01ed
            android.widget.TextView r4 = r0.mView
            r4.setHintTextColor(r15)
        L_0x01ed:
            if (r13 == 0) goto L_0x01f4
            android.widget.TextView r4 = r0.mView
            r4.setLinkTextColor(r13)
        L_0x01f4:
            if (r2 != 0) goto L_0x01fd
            if (r5 == 0) goto L_0x01fd
            android.widget.TextView r2 = r0.mView
            r2.setAllCaps(r1)
        L_0x01fd:
            android.graphics.Typeface r1 = r0.mFontTypeface
            if (r1 == 0) goto L_0x0213
            int r2 = r0.mFontWeight
            r4 = -1
            if (r2 != r4) goto L_0x020e
            android.widget.TextView r2 = r0.mView
            int r4 = r0.mStyle
            r2.setTypeface(r1, r4)
            goto L_0x0213
        L_0x020e:
            android.widget.TextView r2 = r0.mView
            r2.setTypeface(r1)
        L_0x0213:
            if (r3 == 0) goto L_0x021a
            android.widget.TextView r1 = r0.mView
            r1.setFontVariationSettings(r3)
        L_0x021a:
            r11 = 24
            if (r14 == 0) goto L_0x0241
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r11) goto L_0x022c
            android.widget.TextView r1 = r0.mView
            android.os.LocaleList r2 = android.os.LocaleList.forLanguageTags(r14)
            r1.setTextLocales(r2)
            goto L_0x0241
        L_0x022c:
            r1 = 44
            int r1 = r14.indexOf(r1)
            r2 = 0
            java.lang.String r1 = r14.substring(r2, r1)
            android.widget.TextView r3 = r0.mView
            java.util.Locale r1 = java.util.Locale.forLanguageTag(r1)
            r3.setTextLocale(r1)
            goto L_0x0242
        L_0x0241:
            r2 = 0
        L_0x0242:
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r12 = r0.mAutoSizeTextHelper
            android.content.Context r1 = r12.mContext
            int[] r3 = androidx.appcompat.R$styleable.AppCompatTextView
            android.content.res.TypedArray r13 = r1.obtainStyledAttributes(r8, r3, r9, r2)
            android.widget.TextView r1 = r12.mTextView
            android.content.Context r2 = r1.getContext()
            int[] r3 = androidx.appcompat.R$styleable.AppCompatTextView
            r7 = 0
            r4 = r18
            r5 = r13
            r6 = r19
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r1 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeTextType
            boolean r1 = r13.hasValue(r1)
            if (r1 == 0) goto L_0x026e
            int r1 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeTextType
            r2 = 0
            int r1 = r13.getInt(r1, r2)
            r12.mAutoSizeTextType = r1
        L_0x026e:
            int r1 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeStepGranularity
            boolean r1 = r13.hasValue(r1)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 == 0) goto L_0x027f
            int r1 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeStepGranularity
            float r1 = r13.getDimension(r1, r2)
            goto L_0x0281
        L_0x027f:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0281:
            int r3 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeMinTextSize
            boolean r3 = r13.hasValue(r3)
            if (r3 == 0) goto L_0x0290
            int r3 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeMinTextSize
            float r3 = r13.getDimension(r3, r2)
            goto L_0x0292
        L_0x0290:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0292:
            int r4 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeMaxTextSize
            boolean r4 = r13.hasValue(r4)
            if (r4 == 0) goto L_0x02a1
            int r4 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizeMaxTextSize
            float r4 = r13.getDimension(r4, r2)
            goto L_0x02a3
        L_0x02a1:
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x02a3:
            int r5 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizePresetSizes
            boolean r5 = r13.hasValue(r5)
            if (r5 == 0) goto L_0x02dd
            int r5 = androidx.appcompat.R$styleable.AppCompatTextView_autoSizePresetSizes
            r6 = 0
            int r5 = r13.getResourceId(r5, r6)
            if (r5 <= 0) goto L_0x02dd
            android.content.res.Resources r6 = r13.getResources()
            android.content.res.TypedArray r5 = r6.obtainTypedArray(r5)
            int r6 = r5.length()
            int[] r7 = new int[r6]
            if (r6 <= 0) goto L_0x02da
            r9 = 0
        L_0x02c5:
            if (r9 >= r6) goto L_0x02d1
            r14 = -1
            int r15 = r5.getDimensionPixelSize(r9, r14)
            r7[r9] = r15
            int r9 = r9 + 1
            goto L_0x02c5
        L_0x02d1:
            int[] r6 = r12.cleanupAutoSizePresetSizes(r7)
            r12.mAutoSizeTextSizesInPx = r6
            r12.setupAutoSizeUniformPresetSizesConfiguration()
        L_0x02da:
            r5.recycle()
        L_0x02dd:
            r13.recycle()
            boolean r5 = r12.supportsAutoSizeText()
            r6 = 2
            if (r5 == 0) goto L_0x031b
            int r5 = r12.mAutoSizeTextType
            r7 = 1
            if (r5 != r7) goto L_0x031e
            boolean r5 = r12.mHasPresetAutoSizeValues
            if (r5 != 0) goto L_0x0317
            android.content.Context r5 = r12.mContext
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            int r7 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0304
            r3 = 1094713344(0x41400000, float:12.0)
            float r3 = android.util.TypedValue.applyDimension(r6, r3, r5)
        L_0x0304:
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x030e
            r4 = 1121976320(0x42e00000, float:112.0)
            float r4 = android.util.TypedValue.applyDimension(r6, r4, r5)
        L_0x030e:
            int r5 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0314
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0314:
            r12.validateAndSetAutoSizeTextTypeUniformConfiguration(r3, r4, r1)
        L_0x0317:
            r12.setupAutoSizeText()
            goto L_0x031e
        L_0x031b:
            r1 = 0
            r12.mAutoSizeTextType = r1
        L_0x031e:
            boolean r1 = androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE
            if (r1 == 0) goto L_0x035d
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r0.mAutoSizeTextHelper
            int r3 = r1.mAutoSizeTextType
            if (r3 == 0) goto L_0x035d
            int[] r1 = r1.mAutoSizeTextSizesInPx
            int r3 = r1.length
            if (r3 <= 0) goto L_0x035d
            android.widget.TextView r3 = r0.mView
            int r3 = r3.getAutoSizeStepGranularity()
            float r3 = (float) r3
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0357
            android.widget.TextView r1 = r0.mView
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r2 = r0.mAutoSizeTextHelper
            float r2 = r2.mAutoSizeMinTextSizeInPx
            int r2 = java.lang.Math.round(r2)
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r3 = r0.mAutoSizeTextHelper
            float r3 = r3.mAutoSizeMaxTextSizeInPx
            int r3 = java.lang.Math.round(r3)
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r4 = r0.mAutoSizeTextHelper
            float r4 = r4.mAutoSizeStepGranularityInPx
            int r4 = java.lang.Math.round(r4)
            r5 = 0
            r1.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5)
            goto L_0x035d
        L_0x0357:
            r5 = 0
            android.widget.TextView r2 = r0.mView
            r2.setAutoSizeTextTypeUniformWithPresetSizes(r1, r5)
        L_0x035d:
            int[] r1 = androidx.appcompat.R$styleable.AppCompatTextView
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r8, r1)
            int r2 = androidx.appcompat.R$styleable.AppCompatTextView_drawableLeftCompat
            r3 = -1
            int r2 = r1.getResourceId(r2, r3)
            if (r2 == r3) goto L_0x0373
            r4 = r16
            android.graphics.drawable.Drawable r2 = r4.getDrawable(r10, r2)
            goto L_0x0376
        L_0x0373:
            r4 = r16
            r2 = 0
        L_0x0376:
            int r5 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTopCompat
            int r5 = r1.getResourceId(r5, r3)
            if (r5 == r3) goto L_0x0383
            android.graphics.drawable.Drawable r5 = r4.getDrawable(r10, r5)
            goto L_0x0384
        L_0x0383:
            r5 = 0
        L_0x0384:
            int r7 = androidx.appcompat.R$styleable.AppCompatTextView_drawableRightCompat
            int r7 = r1.getResourceId(r7, r3)
            if (r7 == r3) goto L_0x0391
            android.graphics.drawable.Drawable r7 = r4.getDrawable(r10, r7)
            goto L_0x0392
        L_0x0391:
            r7 = 0
        L_0x0392:
            int r8 = androidx.appcompat.R$styleable.AppCompatTextView_drawableBottomCompat
            int r8 = r1.getResourceId(r8, r3)
            if (r8 == r3) goto L_0x039f
            android.graphics.drawable.Drawable r8 = r4.getDrawable(r10, r8)
            goto L_0x03a0
        L_0x039f:
            r8 = 0
        L_0x03a0:
            int r9 = androidx.appcompat.R$styleable.AppCompatTextView_drawableStartCompat
            int r9 = r1.getResourceId(r9, r3)
            if (r9 == r3) goto L_0x03ad
            android.graphics.drawable.Drawable r9 = r4.getDrawable(r10, r9)
            goto L_0x03ae
        L_0x03ad:
            r9 = 0
        L_0x03ae:
            int r12 = androidx.appcompat.R$styleable.AppCompatTextView_drawableEndCompat
            int r12 = r1.getResourceId(r12, r3)
            if (r12 == r3) goto L_0x03bb
            android.graphics.drawable.Drawable r3 = r4.getDrawable(r10, r12)
            goto L_0x03bc
        L_0x03bb:
            r3 = 0
        L_0x03bc:
            r4 = 3
            if (r9 != 0) goto L_0x0411
            if (r3 == 0) goto L_0x03c2
            goto L_0x0411
        L_0x03c2:
            if (r2 != 0) goto L_0x03ca
            if (r5 != 0) goto L_0x03ca
            if (r7 != 0) goto L_0x03ca
            if (r8 == 0) goto L_0x0433
        L_0x03ca:
            android.widget.TextView r3 = r0.mView
            android.graphics.drawable.Drawable[] r3 = r3.getCompoundDrawablesRelative()
            r9 = 0
            r12 = r3[r9]
            if (r12 != 0) goto L_0x03fb
            r12 = r3[r6]
            if (r12 == 0) goto L_0x03da
            goto L_0x03fb
        L_0x03da:
            android.widget.TextView r3 = r0.mView
            android.graphics.drawable.Drawable[] r3 = r3.getCompoundDrawables()
            android.widget.TextView r12 = r0.mView
            if (r2 == 0) goto L_0x03e5
            goto L_0x03e7
        L_0x03e5:
            r2 = r3[r9]
        L_0x03e7:
            if (r5 == 0) goto L_0x03ea
            goto L_0x03ed
        L_0x03ea:
            r5 = 1
            r5 = r3[r5]
        L_0x03ed:
            if (r7 == 0) goto L_0x03f0
            goto L_0x03f2
        L_0x03f0:
            r7 = r3[r6]
        L_0x03f2:
            if (r8 == 0) goto L_0x03f5
            goto L_0x03f7
        L_0x03f5:
            r8 = r3[r4]
        L_0x03f7:
            r12.setCompoundDrawablesWithIntrinsicBounds(r2, r5, r7, r8)
            goto L_0x0433
        L_0x03fb:
            android.widget.TextView r2 = r0.mView
            r7 = 0
            r9 = r3[r7]
            if (r5 == 0) goto L_0x0403
            goto L_0x0406
        L_0x0403:
            r5 = 1
            r5 = r3[r5]
        L_0x0406:
            r6 = r3[r6]
            if (r8 == 0) goto L_0x040b
            goto L_0x040d
        L_0x040b:
            r8 = r3[r4]
        L_0x040d:
            r2.setCompoundDrawablesRelativeWithIntrinsicBounds(r9, r5, r6, r8)
            goto L_0x0433
        L_0x0411:
            android.widget.TextView r2 = r0.mView
            android.graphics.drawable.Drawable[] r2 = r2.getCompoundDrawablesRelative()
            android.widget.TextView r7 = r0.mView
            if (r9 == 0) goto L_0x041c
            goto L_0x0420
        L_0x041c:
            r9 = 0
            r12 = r2[r9]
            r9 = r12
        L_0x0420:
            if (r5 == 0) goto L_0x0423
            goto L_0x0426
        L_0x0423:
            r5 = 1
            r5 = r2[r5]
        L_0x0426:
            if (r3 == 0) goto L_0x0429
            goto L_0x042b
        L_0x0429:
            r3 = r2[r6]
        L_0x042b:
            if (r8 == 0) goto L_0x042e
            goto L_0x0430
        L_0x042e:
            r8 = r2[r4]
        L_0x0430:
            r7.setCompoundDrawablesRelativeWithIntrinsicBounds(r9, r5, r3, r8)
        L_0x0433:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTint
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x046d
            int r2 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTint
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x0451
            r3 = 0
            int r3 = r1.getResourceId(r2, r3)
            if (r3 == 0) goto L_0x0451
            android.content.res.ColorStateList r3 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r10, r3)
            if (r3 == 0) goto L_0x0451
            goto L_0x0455
        L_0x0451:
            android.content.res.ColorStateList r3 = r1.getColorStateList(r2)
        L_0x0455:
            android.widget.TextView r2 = r0.mView
            if (r2 == 0) goto L_0x046b
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r11) goto L_0x0461
            r2.setCompoundDrawableTintList(r3)
            goto L_0x046d
        L_0x0461:
            boolean r4 = r2 instanceof androidx.core.widget.TintableCompoundDrawablesView
            if (r4 == 0) goto L_0x046d
            androidx.core.widget.TintableCompoundDrawablesView r2 = (androidx.core.widget.TintableCompoundDrawablesView) r2
            r2.setSupportCompoundDrawablesTintList(r3)
            goto L_0x046d
        L_0x046b:
            r2 = 0
            throw r2
        L_0x046d:
            r2 = 0
            int r3 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTintMode
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0499
            int r3 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTintMode
            r4 = -1
            int r3 = r1.getInt(r3, r4)
            android.graphics.PorterDuff$Mode r3 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r3, r2)
            android.widget.TextView r2 = r0.mView
            if (r2 == 0) goto L_0x0497
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r11) goto L_0x048d
            r2.setCompoundDrawableTintMode(r3)
            goto L_0x0499
        L_0x048d:
            boolean r4 = r2 instanceof androidx.core.widget.TintableCompoundDrawablesView
            if (r4 == 0) goto L_0x0499
            androidx.core.widget.TintableCompoundDrawablesView r2 = (androidx.core.widget.TintableCompoundDrawablesView) r2
            r2.setSupportCompoundDrawablesTintMode(r3)
            goto L_0x0499
        L_0x0497:
            r2 = 0
            throw r2
        L_0x0499:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextView_firstBaselineToTopHeight
            r3 = -1
            int r2 = r1.getDimensionPixelSize(r2, r3)
            int r4 = androidx.appcompat.R$styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r4 = r1.getDimensionPixelSize(r4, r3)
            int r5 = androidx.appcompat.R$styleable.AppCompatTextView_lineHeight
            int r5 = r1.getDimensionPixelSize(r5, r3)
            r1.recycle()
            if (r2 == r3) goto L_0x04b6
            android.widget.TextView r1 = r0.mView
            androidx.core.widget.CompoundButtonCompat.setFirstBaselineToTopHeight(r1, r2)
        L_0x04b6:
            if (r4 == r3) goto L_0x04bd
            android.widget.TextView r1 = r0.mView
            androidx.core.widget.CompoundButtonCompat.setLastBaselineToBottomHeight(r1, r4)
        L_0x04bd:
            if (r5 == r3) goto L_0x04c4
            android.widget.TextView r1 = r0.mView
            androidx.core.widget.CompoundButtonCompat.setLineHeight(r1, r5)
        L_0x04c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    public void onSetTextAppearance(Context context, int i) {
        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(i, R$styleable.TextAppearance));
        if (tintTypedArray.hasValue(R$styleable.TextAppearance_textAllCaps)) {
            this.mView.setAllCaps(tintTypedArray.getBoolean(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23) {
            if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_textColor)) {
                ColorStateList colorStateList = tintTypedArray.getColorStateList(R$styleable.TextAppearance_android_textColor);
                if (colorStateList != null) {
                    this.mView.setTextColor(colorStateList);
                }
            }
            if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_textColorLink)) {
                ColorStateList colorStateList2 = tintTypedArray.getColorStateList(R$styleable.TextAppearance_android_textColorLink);
                if (colorStateList2 != null) {
                    this.mView.setLinkTextColor(colorStateList2);
                }
            }
            if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_textColorHint)) {
                ColorStateList colorStateList3 = tintTypedArray.getColorStateList(R$styleable.TextAppearance_android_textColorHint);
                if (colorStateList3 != null) {
                    this.mView.setHintTextColor(colorStateList3);
                }
            }
        }
        if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_textSize) && tintTypedArray.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, tintTypedArray);
        if (VERSION.SDK_INT >= 26 && tintTypedArray.hasValue(R$styleable.TextAppearance_fontVariationSettings)) {
            String string = tintTypedArray.getString(R$styleable.TextAppearance_fontVariationSettings);
            if (string != null) {
                this.mView.setFontVariationSettings(string);
            }
        }
        tintTypedArray.mWrapped.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    public void populateSurroundingTextIfNeeded(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        CharSequence charSequence;
        if (VERSION.SDK_INT < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            int i = VERSION.SDK_INT;
            if (i >= 30) {
                b.setInitialSurroundingSubText(editorInfo, text, 0);
            } else if (text == null) {
                throw null;
            } else if (i >= 30) {
                b.setInitialSurroundingSubText(editorInfo, text, 0);
            } else {
                int i2 = editorInfo.initialSelStart;
                int i3 = editorInfo.initialSelEnd;
                int i4 = i2 > i3 ? i3 - 0 : i2 + 0;
                int i5 = editorInfo.initialSelStart;
                int i6 = editorInfo.initialSelEnd;
                int i7 = i5 > i6 ? i5 - 0 : i6 + 0;
                int length = text.length();
                if (i4 < 0 || i7 > length) {
                    EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
                    return;
                }
                int i8 = editorInfo.inputType & 4095;
                if (i8 == 129 || i8 == 225 || i8 == 18) {
                    EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
                } else if (length <= 2048) {
                    EditorInfoCompat.setSurroundingText(editorInfo, text, i4, i7);
                } else {
                    int i9 = i7 - i4;
                    int i10 = i9 > 1024 ? 0 : i9;
                    int i11 = 2048 - i10;
                    int min = Math.min(text.length() - i7, i11 - Math.min(i4, (int) (((double) i11) * 0.8d)));
                    int min2 = Math.min(i4, i11 - min);
                    int i12 = i4 - min2;
                    if (EditorInfoCompat.isCutOnSurrogate(text, i12, 0)) {
                        i12++;
                        min2--;
                    }
                    if (EditorInfoCompat.isCutOnSurrogate(text, (i7 + min) - 1, 1)) {
                        min--;
                    }
                    int i13 = min2 + i10 + min;
                    if (i10 != i9) {
                        charSequence = TextUtils.concat(new CharSequence[]{text.subSequence(i12, i12 + min2), text.subSequence(i7, min + i7)});
                    } else {
                        charSequence = text.subSequence(i12, i13 + i12);
                    }
                    int i14 = min2 + 0;
                    EditorInfoCompat.setSurroundingText(editorInfo, charSequence, i14, i10 + i14);
                }
            }
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = appCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr2);
                if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("None of the preset sizes is valid: ");
                    outline73.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(outline73.toString());
                }
            } else {
                appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
            }
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (!appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            return;
        }
        if (i == 0) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
            appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = new int[0];
            appCompatTextViewAutoSizeHelper.mNeedsAutoSizeText = false;
        } else if (i == 1) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Unknown auto-size text type: ", i));
        }
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        TintInfo tintInfo2 = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo2;
        this.mDrawableTopTint = tintInfo2;
        this.mDrawableRightTint = tintInfo2;
        this.mDrawableBottomTint = tintInfo2;
        this.mDrawableStartTint = tintInfo2;
        this.mDrawableEndTint = tintInfo2;
    }

    public void setCompoundDrawableTintMode(Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        TintInfo tintInfo2 = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo2;
        this.mDrawableTopTint = tintInfo2;
        this.mDrawableRightTint = tintInfo2;
        this.mDrawableBottomTint = tintInfo2;
        this.mDrawableStartTint = tintInfo2;
        this.mDrawableEndTint = tintInfo2;
    }

    public final void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        int i;
        this.mStyle = tintTypedArray.getInt(R$styleable.TextAppearance_android_textStyle, this.mStyle);
        boolean z = false;
        if (VERSION.SDK_INT >= 28) {
            int i2 = tintTypedArray.getInt(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i2;
            if (i2 != -1) {
                this.mStyle = (this.mStyle & 2) | 0;
            }
        }
        if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_fontFamily) || tintTypedArray.hasValue(R$styleable.TextAppearance_fontFamily)) {
            this.mFontTypeface = null;
            if (tintTypedArray.hasValue(R$styleable.TextAppearance_fontFamily)) {
                i = R$styleable.TextAppearance_fontFamily;
            } else {
                i = R$styleable.TextAppearance_android_fontFamily;
            }
            final int i3 = this.mFontWeight;
            final int i4 = this.mStyle;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mView);
                try {
                    Typeface font = tintTypedArray.getFont(i, this.mStyle, new FontCallback() {
                        public void onFontRetrievalFailed(int i) {
                        }

                        public void onFontRetrieved(Typeface typeface) {
                            if (VERSION.SDK_INT >= 28) {
                                int i = i3;
                                if (i != -1) {
                                    typeface = Typeface.create(typeface, i, (i4 & 2) != 0);
                                }
                            }
                            AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
                            WeakReference weakReference = weakReference;
                            if (appCompatTextHelper.mAsyncFontPending) {
                                appCompatTextHelper.mFontTypeface = typeface;
                                TextView textView = (TextView) weakReference.get();
                                if (textView == null) {
                                    return;
                                }
                                if (ViewCompat.isAttachedToWindow(textView)) {
                                    textView.post(new Runnable(appCompatTextHelper, textView, typeface, appCompatTextHelper.mStyle) {
                                        public final /* synthetic */ int val$style;
                                        public final /* synthetic */ TextView val$textView;
                                        public final /* synthetic */ Typeface val$typeface;

                                        {
                                            this.val$textView = r2;
                                            this.val$typeface = r3;
                                            this.val$style = r4;
                                        }

                                        public void run() {
                                            this.val$textView.setTypeface(this.val$typeface, this.val$style);
                                        }
                                    });
                                } else {
                                    textView.setTypeface(typeface, appCompatTextHelper.mStyle);
                                }
                            }
                        }
                    });
                    if (font != null) {
                        if (VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            this.mFontTypeface = Typeface.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                        }
                    }
                    this.mAsyncFontPending = this.mFontTypeface == null;
                } catch (NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null) {
                String string = tintTypedArray.getString(i);
                if (string != null) {
                    if (VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                        this.mFontTypeface = Typeface.create(string, this.mStyle);
                    } else {
                        Typeface create = Typeface.create(string, 0);
                        int i5 = this.mFontWeight;
                        if ((this.mStyle & 2) != 0) {
                            z = true;
                        }
                        this.mFontTypeface = Typeface.create(create, i5, z);
                    }
                }
            }
            return;
        }
        if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_typeface)) {
            this.mAsyncFontPending = false;
            int i6 = tintTypedArray.getInt(R$styleable.TextAppearance_android_typeface, 1);
            if (i6 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i6 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i6 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
        }
    }
}
