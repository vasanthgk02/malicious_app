package com.mpl.androidapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class RoundedCornersTransformation extends BitmapTransformation {
    public static final String ID = "com.mpl.androidapp.utils.RoundedCornersTransformation.1";
    public static final int VERSION = 1;
    public CornerType cornerType;
    public int diameter;
    public int margin;
    public int radius;

    /* renamed from: com.mpl.androidapp.utils.RoundedCornersTransformation$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0071 */
        static {
            /*
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType[] r0 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType = r0
                r1 = 1
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r2 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.ALL     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x002b }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.TOP     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r1 = 7
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                r0 = 8
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0041 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.LEFT     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                r1 = 9
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.RIGHT     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r0 = 10
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.OTHER_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r1 = 11
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.OTHER_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                r0 = 12
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0061 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                r1 = 13
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                r0 = 14
                int[] r2 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r3 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = $SwitchMap$com$mpl$androidapp$utils$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.mpl.androidapp.utils.RoundedCornersTransformation$CornerType r2 = com.mpl.androidapp.utils.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2 = 15
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.RoundedCornersTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int i, int i2) {
        this(i, i2, CornerType.ALL);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF((float) i, f3 - ((float) i2), (float) (i + i2), f3);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF((float) i4, (float) i4, (float) (i4 + this.diameter), f3 - ((float) this.radius)), paint);
        int i5 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i5), (float) i5, f2, f3), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.diameter;
        RectF rectF = new RectF(f2 - ((float) i), f3 - ((float) i), f2, f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) i3, (float) i3, f2 - ((float) this.radius), f3), paint);
        int i4 = this.radius;
        canvas.drawRect(new RectF(f2 - ((float) i4), (float) this.margin, f2, f3 - ((float) i4)), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        RectF rectF = new RectF((float) this.margin, f3 - ((float) this.diameter), f2, f3);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF((float) i2, (float) i2, f2, f3 - ((float) this.radius)), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.diameter;
        RectF rectF2 = new RectF(f2 - ((float) i4), f3 - ((float) i4), f2, f3);
        int i5 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        int i6 = this.margin;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + this.radius), f2 - ((float) this.diameter), f3), paint);
        int i7 = this.margin;
        canvas.drawRect(new RectF((float) (this.diameter + i7), (float) i7, f2, f3 - ((float) this.radius)), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.diameter;
        int i2 = this.margin;
        RectF rectF = new RectF(f2 - ((float) i), (float) i2, f2, (float) (i2 + i));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.diameter;
        RectF rectF2 = new RectF((float) i4, f3 - ((float) i5), (float) (i4 + i5), f3);
        int i6 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.margin;
        int i8 = this.radius;
        canvas.drawRect(new RectF((float) i7, (float) i7, f2 - ((float) i8), f3 - ((float) i8)), paint);
        int i9 = this.margin;
        int i10 = this.radius;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), f2, f3), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.diameter), f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i3), (float) i3, f2, f3), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f2, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF(f2 - ((float) this.diameter), (float) this.margin, f2, f3);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), f2 - ((float) i5), f3), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f2, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        RectF rectF2 = new RectF((float) i3, (float) i3, (float) (i3 + this.diameter), f3);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, paint);
        int i5 = this.margin;
        int i6 = this.radius;
        canvas.drawRect(new RectF((float) (i5 + i6), (float) (i5 + i6), f2, f3), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        RectF rectF = new RectF((float) this.margin, f3 - ((float) this.diameter), f2, f3);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        RectF rectF2 = new RectF(f2 - ((float) this.diameter), (float) this.margin, f2, f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        int i4 = this.radius;
        canvas.drawRect(new RectF((float) i3, (float) i3, f2 - ((float) i4), f3 - ((float) i4)), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.diameter), f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF((float) this.margin, f3 - ((float) this.diameter), f2, f3);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF((float) (i4 + i5), (float) i4, f2, f3 - ((float) i5)), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        RectF rectF = new RectF(f2 - ((float) this.diameter), (float) this.margin, f2, f3);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF((float) i2, (float) i2, f2 - ((float) this.radius), f3), paint);
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        float f4 = f2 - ((float) i);
        float f5 = f3 - ((float) i);
        switch (this.cornerType.ordinal()) {
            case 0:
                int i2 = this.margin;
                RectF rectF = new RectF((float) i2, (float) i2, f4, f5);
                int i3 = this.radius;
                canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
                return;
            case 1:
                drawTopLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 2:
                drawTopRightRoundRect(canvas, paint, f4, f5);
                return;
            case 3:
                drawBottomLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 4:
                drawBottomRightRoundRect(canvas, paint, f4, f5);
                return;
            case 5:
                drawTopRoundRect(canvas, paint, f4, f5);
                return;
            case 6:
                drawBottomRoundRect(canvas, paint, f4, f5);
                return;
            case 7:
                drawLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 8:
                drawRightRoundRect(canvas, paint, f4, f5);
                return;
            case 9:
                drawOtherTopLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 10:
                drawOtherTopRightRoundRect(canvas, paint, f4, f5);
                return;
            case 11:
                drawOtherBottomLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 12:
                drawOtherBottomRightRoundRect(canvas, paint, f4, f5);
                return;
            case 13:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 14:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f4, f5);
                return;
            default:
                int i4 = this.margin;
                RectF rectF2 = new RectF((float) i4, (float) i4, f4, f5);
                int i5 = this.radius;
                canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
                return;
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), (float) (i4 + i5), f3), paint);
        int i6 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i6), (float) i6, f2, f3), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.diameter;
        int i2 = this.margin;
        RectF rectF = new RectF(f2 - ((float) i), (float) i2, f2, (float) (i2 + i));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF((float) i4, (float) i4, f2 - ((float) this.radius), f3), paint);
        int i5 = this.radius;
        canvas.drawRect(new RectF(f2 - ((float) i5), (float) (this.margin + i5), f2, f3), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f2, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) i3, (float) (i3 + this.radius), f2, f3), paint);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (roundedCornersTransformation.radius == this.radius && roundedCornersTransformation.diameter == this.diameter && roundedCornersTransformation.margin == this.margin && roundedCornersTransformation.cornerType == this.cornerType) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.cornerType.ordinal() * 10) + (this.margin * 100) + (this.diameter * 1000) + ((this.radius * 10000) - 697435804);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RoundedTransformation(radius=");
        outline73.append(this.radius);
        outline73.append(", margin=");
        outline73.append(this.margin);
        outline73.append(", diameter=");
        outline73.append(this.diameter);
        outline73.append(", cornerType=");
        outline73.append(this.cornerType.name());
        outline73.append(")");
        return outline73.toString();
    }

    public Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(width, height, Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        setCanvasBitmapDensity(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, (float) width, (float) height);
        return bitmap2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(ID);
        outline73.append(this.radius);
        outline73.append(this.diameter);
        outline73.append(this.margin);
        outline73.append(this.cornerType);
        messageDigest.update(outline73.toString().getBytes(Key.CHARSET));
    }

    public RoundedCornersTransformation(int i, int i2, CornerType cornerType2) {
        this.radius = i;
        this.diameter = i * 2;
        this.margin = i2;
        this.cornerType = cornerType2;
    }
}
