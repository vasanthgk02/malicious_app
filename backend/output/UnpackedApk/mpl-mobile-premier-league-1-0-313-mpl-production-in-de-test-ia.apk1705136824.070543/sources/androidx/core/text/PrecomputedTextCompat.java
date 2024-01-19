package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Objects;

public class PrecomputedTextCompat implements Spannable {

    public static final class Params {
        public final int mBreakStrategy;
        public final int mHyphenationFrequency;
        public final TextPaint mPaint;
        public final TextDirectionHeuristic mTextDir;

        @SuppressLint({"NewApi"})
        public Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (VERSION.SDK_INT >= 29) {
                new Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = i;
            this.mHyphenationFrequency = i2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return equalsWithoutTextDirection(params) && this.mTextDir == params.mTextDir;
        }

        public boolean equalsWithoutTextDirection(Params params) {
            if ((VERSION.SDK_INT >= 23 && (this.mBreakStrategy != params.mBreakStrategy || this.mHyphenationFrequency != params.mHyphenationFrequency)) || this.mPaint.getTextSize() != params.mPaint.getTextSize() || this.mPaint.getTextScaleX() != params.mPaint.getTextScaleX() || this.mPaint.getTextSkewX() != params.mPaint.getTextSkewX() || this.mPaint.getLetterSpacing() != params.mPaint.getLetterSpacing() || !TextUtils.equals(this.mPaint.getFontFeatureSettings(), params.mPaint.getFontFeatureSettings()) || this.mPaint.getFlags() != params.mPaint.getFlags()) {
                return false;
            }
            if (VERSION.SDK_INT >= 24) {
                if (!this.mPaint.getTextLocales().equals(params.mPaint.getTextLocales())) {
                    return false;
                }
            } else if (!this.mPaint.getTextLocale().equals(params.mPaint.getTextLocale())) {
                return false;
            }
            if (this.mPaint.getTypeface() == null) {
                if (params.mPaint.getTypeface() != null) {
                    return false;
                }
            } else if (!this.mPaint.getTypeface().equals(params.mPaint.getTypeface())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (VERSION.SDK_INT >= 24) {
                return Objects.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
            }
            return Objects.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("textSize=");
            outline73.append(this.mPaint.getTextSize());
            sb.append(outline73.toString());
            sb.append(", textScaleX=" + this.mPaint.getTextScaleX());
            sb.append(", textSkewX=" + this.mPaint.getTextSkewX());
            sb.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            if (VERSION.SDK_INT >= 24) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73(", textLocale=");
                outline732.append(this.mPaint.getTextLocales());
                sb.append(outline732.toString());
            } else {
                StringBuilder outline733 = GeneratedOutlineSupport.outline73(", textLocale=");
                outline733.append(this.mPaint.getTextLocale());
                sb.append(outline733.toString());
            }
            StringBuilder outline734 = GeneratedOutlineSupport.outline73(", typeface=");
            outline734.append(this.mPaint.getTypeface());
            sb.append(outline734.toString());
            if (VERSION.SDK_INT >= 26) {
                StringBuilder outline735 = GeneratedOutlineSupport.outline73(", variationSettings=");
                outline735.append(this.mPaint.getFontVariationSettings());
                sb.append(outline735.toString());
            }
            StringBuilder outline736 = GeneratedOutlineSupport.outline73(", textDir=");
            outline736.append(this.mTextDir);
            sb.append(outline736.toString());
            sb.append(", breakStrategy=" + this.mBreakStrategy);
            sb.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            sb.append("}");
            return sb.toString();
        }

        public Params(android.text.PrecomputedText.Params params) {
            this.mPaint = params.getTextPaint();
            this.mTextDir = params.getTextDirection();
            this.mBreakStrategy = params.getBreakStrategy();
            this.mHyphenationFrequency = params.getHyphenationFrequency();
            int i = VERSION.SDK_INT;
        }
    }

    public char charAt(int i) {
        throw null;
    }

    public int getSpanEnd(Object obj) {
        throw null;
    }

    public int getSpanFlags(Object obj) {
        throw null;
    }

    public int getSpanStart(Object obj) {
        throw null;
    }

    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (VERSION.SDK_INT >= 29) {
            throw null;
        }
        throw null;
    }

    public int length() {
        throw null;
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        throw null;
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (VERSION.SDK_INT >= 29) {
            throw null;
        } else {
            throw null;
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (VERSION.SDK_INT >= 29) {
            throw null;
        } else {
            throw null;
        }
    }

    public CharSequence subSequence(int i, int i2) {
        throw null;
    }

    public String toString() {
        throw null;
    }
}
