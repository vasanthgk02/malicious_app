package com.google.android.material.internal;

import a.a.a.a.d.b;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Constructor;

public final class StaticLayoutBuilderCompat {
    public static final int DEFAULT_HYPHENATION_FREQUENCY = (VERSION.SDK_INT >= 23 ? 1 : 0);
    public static Constructor<StaticLayout> constructor;
    public static boolean initialized;
    public static Object textDirection;
    public Alignment alignment;
    public TruncateAt ellipsize;
    public int end;
    public int hyphenationFrequency;
    public boolean includePad;
    public boolean isRtl;
    public float lineSpacingAdd;
    public float lineSpacingMultiplier;
    public int maxLines;
    public final TextPaint paint;
    public CharSequence source;
    public int start = 0;
    public final int width;

    public static class StaticLayoutBuilderCompatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public StaticLayoutBuilderCompatException(Throwable th) {
            // StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error thrown initializing StaticLayout ");
            // outline73.append(th.getMessage());
            super(outline73.toString(), th);
        }
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i;
        this.end = charSequence.length();
        this.alignment = Alignment.ALIGN_NORMAL;
        this.maxLines = Integer.MAX_VALUE;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
        this.includePad = true;
        this.ellipsize = null;
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if (this.source == null) {
            this.source = "";
        }
        int max = Math.max(0, this.width);
        CharSequence charSequence = this.source;
        if (this.maxLines == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.paint, (float) max, this.ellipsize);
        }
        this.end = Math.min(charSequence.length(), this.end);
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            if (this.isRtl && this.maxLines == 1) {
                this.alignment = Alignment.ALIGN_OPPOSITE;
            }
            Builder obtain = Builder.obtain(charSequence, this.start, this.end, this.paint, max);
            obtain.setAlignment(this.alignment);
            obtain.setIncludePad(this.includePad);
            obtain.setTextDirection(this.isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TruncateAt truncateAt = this.ellipsize;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.maxLines);
            if (!(this.lineSpacingAdd == 0.0f && this.lineSpacingMultiplier == 1.0f)) {
                obtain.setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier);
            }
            if (this.maxLines > 1) {
                obtain.setHyphenationFrequency(this.hyphenationFrequency);
            }
            return obtain.build();
        }
        if (!initialized) {
            try {
                Class<TextDirectionHeuristic> cls = TextDirectionHeuristic.class;
                textDirection = this.isRtl && i >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TruncateAt.class, Integer.TYPE, Integer.TYPE});
                constructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
                initialized = true;
            } catch (Exception e2) {
                throw new StaticLayoutBuilderCompatException(e2);
            }
        }
        try {
            Constructor<StaticLayout> constructor2 = constructor;
            b.checkNotNull(constructor2);
            Object obj = textDirection;
            b.checkNotNull(obj);
            return (StaticLayout) constructor2.newInstance(new Object[]{charSequence, Integer.valueOf(this.start), Integer.valueOf(this.end), this.paint, Integer.valueOf(max), this.alignment, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.includePad), null, Integer.valueOf(max), Integer.valueOf(this.maxLines)});
        } catch (Exception e3) {
            throw new StaticLayoutBuilderCompatException(e3);
        }
    }
}
