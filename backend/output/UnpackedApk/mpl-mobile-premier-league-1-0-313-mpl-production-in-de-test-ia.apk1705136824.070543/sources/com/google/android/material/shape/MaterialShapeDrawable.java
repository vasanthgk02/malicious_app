package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearancePathProvider.Lazy;
import com.google.android.material.shape.ShapeAppearancePathProvider.PathListener;
import com.google.android.material.shape.ShapePath.ShadowCompatOperation;
import java.util.BitSet;
import java.util.Objects;
import sfs2x.client.entities.invitation.InvitationReply;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final String TAG = MaterialShapeDrawable.class.getSimpleName();
    public static final Paint clearPaint = new Paint(1);
    public final BitSet containsIncompatibleShadowOp;
    public final ShadowCompatOperation[] cornerShadowOperation;
    public MaterialShapeDrawableState drawableState;
    public final ShadowCompatOperation[] edgeShadowOperation;
    public final Paint fillPaint;
    public final RectF insetRectF;
    public final Matrix matrix;
    public final Path path;
    public final RectF pathBounds;
    public boolean pathDirty;
    public final Path pathInsetByStroke;
    public final ShapeAppearancePathProvider pathProvider;
    public final PathListener pathShadowListener;
    public final RectF rectF;
    public final Region scratchRegion;
    public boolean shadowBitmapDrawingEnable;
    public final ShadowRenderer shadowRenderer;
    public final Paint strokePaint;
    public ShapeAppearanceModel strokeShapeAppearance;
    public PorterDuffColorFilter strokeTintFilter;
    public PorterDuffColorFilter tintFilter;
    public final Region transparentRegion;

    public static final class MaterialShapeDrawableState extends ConstantState {
        public int alpha = InvitationReply.EXPIRED;
        public ColorFilter colorFilter;
        public float elevation = 0.0f;
        public ElevationOverlayProvider elevationOverlayProvider;
        public ColorStateList fillColor = null;
        public float interpolation = 1.0f;
        public Rect padding = null;
        public Style paintStyle = Style.FILL_AND_STROKE;
        public float parentAbsoluteElevation = 0.0f;
        public float scale = 1.0f;
        public int shadowCompatMode = 0;
        public int shadowCompatOffset = 0;
        public int shadowCompatRadius = 0;
        public int shadowCompatRotation = 0;
        public ShapeAppearanceModel shapeAppearanceModel;
        public ColorStateList strokeColor = null;
        public ColorStateList strokeTintList = null;
        public float strokeWidth;
        public ColorStateList tintList = null;
        public Mode tintMode = Mode.SRC_IN;
        public float translationZ = 0.0f;
        public boolean useTintColorForShadow = false;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel2, ElevationOverlayProvider elevationOverlayProvider2) {
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.elevationOverlayProvider = null;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(MaterialShapeDrawableState materialShapeDrawableState) {
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.colorFilter = materialShapeDrawableState.colorFilter;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.useTintColorForShadow = materialShapeDrawableState.useTintColorForShadow;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.translationZ = materialShapeDrawableState.translationZ;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.strokeTintList = materialShapeDrawableState.strokeTintList;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new Rect(materialShapeDrawableState.padding);
            }
        }
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f2) {
        int resolveOrThrow = ImageOriginUtils.resolveOrThrow(context, R$attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        materialShapeDrawable.updateZ();
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.elevation != f2) {
            materialShapeDrawableState.elevation = f2;
            materialShapeDrawable.updateZ();
        }
        return materialShapeDrawable;
    }

    public final void calculatePath(RectF rectF2, Path path2) {
        calculatePathForSize(rectF2, path2);
        if (this.drawableState.scale != 1.0f) {
            this.matrix.reset();
            Matrix matrix2 = this.matrix;
            float f2 = this.drawableState.scale;
            matrix2.setScale(f2, f2, rectF2.width() / 2.0f, rectF2.height() / 2.0f);
            path2.transform(this.matrix);
        }
        path2.computeBounds(this.pathBounds, true);
    }

    public final void calculatePathForSize(RectF rectF2, Path path2) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
        float f2 = materialShapeDrawableState.interpolation;
        shapeAppearancePathProvider.calculatePath(shapeAppearanceModel, f2, rectF2, this.pathShadowListener, path2);
    }

    public final PorterDuffColorFilter calculateTintFilter(ColorStateList colorStateList, Mode mode, Paint paint, boolean z) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (colorStateList == null || mode == null) {
            if (z) {
                int color = paint.getColor();
                int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
                if (compositeElevationOverlayIfNeeded != color) {
                    porterDuffColorFilter = new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, Mode.SRC_IN);
                    return porterDuffColorFilter;
                }
            }
            porterDuffColorFilter = null;
            return porterDuffColorFilter;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public int compositeElevationOverlayIfNeeded(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f2 = materialShapeDrawableState.elevation + materialShapeDrawableState.translationZ + materialShapeDrawableState.parentAbsoluteElevation;
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i, f2) : i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ec, code lost:
        if ((!isRoundRect() && !r10.path.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L_0x00ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            android.graphics.Paint r0 = r10.fillPaint
            android.graphics.PorterDuffColorFilter r1 = r10.tintFilter
            r0.setColorFilter(r1)
            android.graphics.Paint r0 = r10.fillPaint
            int r0 = r0.getAlpha()
            android.graphics.Paint r1 = r10.fillPaint
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r10.drawableState
            int r2 = r2.alpha
            int r3 = r2 >>> 7
            int r2 = r2 + r3
            int r2 = r2 * r0
            int r2 = r2 >>> 8
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r10.strokePaint
            android.graphics.PorterDuffColorFilter r2 = r10.strokeTintFilter
            r1.setColorFilter(r2)
            android.graphics.Paint r1 = r10.strokePaint
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r10.drawableState
            float r2 = r2.strokeWidth
            r1.setStrokeWidth(r2)
            android.graphics.Paint r1 = r10.strokePaint
            int r1 = r1.getAlpha()
            android.graphics.Paint r2 = r10.strokePaint
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r3 = r10.drawableState
            int r3 = r3.alpha
            int r4 = r3 >>> 7
            int r3 = r3 + r4
            int r3 = r3 * r1
            int r3 = r3 >>> 8
            r2.setAlpha(r3)
            boolean r2 = r10.pathDirty
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x00c7
            float r2 = r10.getStrokeInsetLength()
            float r2 = -r2
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r5 = r10.drawableState
            com.google.android.material.shape.ShapeAppearanceModel r5 = r5.shapeAppearanceModel
            if (r5 == 0) goto L_0x00c6
            com.google.android.material.shape.ShapeAppearanceModel$Builder r6 = new com.google.android.material.shape.ShapeAppearanceModel$Builder
            r6.<init>(r5)
            com.google.android.material.shape.CornerSize r7 = r5.topLeftCornerSize
            boolean r8 = r7 instanceof com.google.android.material.shape.RelativeCornerSize
            if (r8 == 0) goto L_0x0060
            goto L_0x0066
        L_0x0060:
            com.google.android.material.shape.AdjustedCornerSize r8 = new com.google.android.material.shape.AdjustedCornerSize
            r8.<init>(r2, r7)
            r7 = r8
        L_0x0066:
            r6.topLeftCornerSize = r7
            com.google.android.material.shape.CornerSize r7 = r5.topRightCornerSize
            boolean r8 = r7 instanceof com.google.android.material.shape.RelativeCornerSize
            if (r8 == 0) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            com.google.android.material.shape.AdjustedCornerSize r8 = new com.google.android.material.shape.AdjustedCornerSize
            r8.<init>(r2, r7)
            r7 = r8
        L_0x0075:
            r6.topRightCornerSize = r7
            com.google.android.material.shape.CornerSize r7 = r5.bottomLeftCornerSize
            boolean r8 = r7 instanceof com.google.android.material.shape.RelativeCornerSize
            if (r8 == 0) goto L_0x007e
            goto L_0x0084
        L_0x007e:
            com.google.android.material.shape.AdjustedCornerSize r8 = new com.google.android.material.shape.AdjustedCornerSize
            r8.<init>(r2, r7)
            r7 = r8
        L_0x0084:
            r6.bottomLeftCornerSize = r7
            com.google.android.material.shape.CornerSize r5 = r5.bottomRightCornerSize
            boolean r7 = r5 instanceof com.google.android.material.shape.RelativeCornerSize
            if (r7 == 0) goto L_0x008d
            goto L_0x0093
        L_0x008d:
            com.google.android.material.shape.AdjustedCornerSize r7 = new com.google.android.material.shape.AdjustedCornerSize
            r7.<init>(r2, r5)
            r5 = r7
        L_0x0093:
            r6.bottomRightCornerSize = r5
            com.google.android.material.shape.ShapeAppearanceModel r2 = r6.build()
            r10.strokeShapeAppearance = r2
            com.google.android.material.shape.ShapeAppearancePathProvider r5 = r10.pathProvider
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r6 = r10.drawableState
            float r6 = r6.interpolation
            android.graphics.RectF r7 = r10.insetRectF
            android.graphics.RectF r8 = r10.getBoundsAsRectF()
            r7.set(r8)
            float r7 = r10.getStrokeInsetLength()
            android.graphics.RectF r8 = r10.insetRectF
            r8.inset(r7, r7)
            android.graphics.RectF r7 = r10.insetRectF
            android.graphics.Path r8 = r10.pathInsetByStroke
            r5.calculatePath(r2, r6, r7, r8)
            android.graphics.RectF r2 = r10.getBoundsAsRectF()
            android.graphics.Path r5 = r10.path
            r10.calculatePath(r2, r5)
            r10.pathDirty = r3
            goto L_0x00c7
        L_0x00c6:
            throw r4
        L_0x00c7:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r10.drawableState
            int r5 = r2.shadowCompatMode
            r6 = 2
            r7 = 1
            if (r5 == r7) goto L_0x00f0
            int r2 = r2.shadowCompatRadius
            if (r2 <= 0) goto L_0x00f0
            if (r5 == r6) goto L_0x00ee
            boolean r2 = r10.isRoundRect()
            if (r2 != 0) goto L_0x00eb
            android.graphics.Path r2 = r10.path
            boolean r2 = r2.isConvex()
            if (r2 != 0) goto L_0x00eb
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r2 >= r5) goto L_0x00eb
            r2 = 1
            goto L_0x00ec
        L_0x00eb:
            r2 = 0
        L_0x00ec:
            if (r2 == 0) goto L_0x00f0
        L_0x00ee:
            r2 = 1
            goto L_0x00f1
        L_0x00f0:
            r2 = 0
        L_0x00f1:
            if (r2 != 0) goto L_0x00f5
            goto L_0x018d
        L_0x00f5:
            r11.save()
            int r2 = r10.getShadowOffsetX()
            int r5 = r10.getShadowOffsetY()
            float r2 = (float) r2
            float r5 = (float) r5
            r11.translate(r2, r5)
            boolean r2 = r10.shadowBitmapDrawingEnable
            if (r2 != 0) goto L_0x0111
            r10.drawCompatShadow(r11)
            r11.restore()
            goto L_0x018d
        L_0x0111:
            android.graphics.RectF r2 = r10.pathBounds
            float r2 = r2.width()
            android.graphics.Rect r5 = r10.getBounds()
            int r5 = r5.width()
            float r5 = (float) r5
            float r2 = r2 - r5
            int r2 = (int) r2
            android.graphics.RectF r5 = r10.pathBounds
            float r5 = r5.height()
            android.graphics.Rect r6 = r10.getBounds()
            int r6 = r6.height()
            float r6 = (float) r6
            float r5 = r5 - r6
            int r5 = (int) r5
            if (r2 < 0) goto L_0x01dd
            if (r5 < 0) goto L_0x01dd
            android.graphics.RectF r6 = r10.pathBounds
            float r6 = r6.width()
            int r6 = (int) r6
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r7 = r10.drawableState
            int r7 = r7.shadowCompatRadius
            r8 = 2
            int r6 = com.android.tools.r8.GeneratedOutlineSupport.outline7(r7, r8, r6, r2)
            android.graphics.RectF r7 = r10.pathBounds
            float r7 = r7.height()
            int r7 = (int) r7
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r8 = r10.drawableState
            int r8 = r8.shadowCompatRadius
            r9 = 2
            int r7 = com.android.tools.r8.GeneratedOutlineSupport.outline7(r8, r9, r7, r5)
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r6, r7, r8)
            android.graphics.Canvas r7 = new android.graphics.Canvas
            r7.<init>(r6)
            android.graphics.Rect r8 = r10.getBounds()
            int r8 = r8.left
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r9 = r10.drawableState
            int r9 = r9.shadowCompatRadius
            int r8 = r8 - r9
            int r8 = r8 - r2
            float r2 = (float) r8
            android.graphics.Rect r8 = r10.getBounds()
            int r8 = r8.top
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r9 = r10.drawableState
            int r9 = r9.shadowCompatRadius
            int r8 = r8 - r9
            int r8 = r8 - r5
            float r5 = (float) r8
            float r8 = -r2
            float r9 = -r5
            r7.translate(r8, r9)
            r10.drawCompatShadow(r7)
            r11.drawBitmap(r6, r2, r5, r4)
            r6.recycle()
            r11.restore()
        L_0x018d:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r10.drawableState
            android.graphics.Paint$Style r2 = r2.paintStyle
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL_AND_STROKE
            if (r2 == r4) goto L_0x0199
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            if (r2 != r4) goto L_0x019a
        L_0x0199:
            r3 = 1
        L_0x019a:
            if (r3 == 0) goto L_0x01ad
            android.graphics.Paint r6 = r10.fillPaint
            android.graphics.Path r7 = r10.path
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r10.drawableState
            com.google.android.material.shape.ShapeAppearanceModel r8 = r2.shapeAppearanceModel
            android.graphics.RectF r9 = r10.getBoundsAsRectF()
            r4 = r10
            r5 = r11
            r4.drawShape(r5, r6, r7, r8, r9)
        L_0x01ad:
            boolean r2 = r10.hasStroke()
            if (r2 == 0) goto L_0x01d2
            android.graphics.Paint r5 = r10.strokePaint
            android.graphics.Path r6 = r10.pathInsetByStroke
            com.google.android.material.shape.ShapeAppearanceModel r7 = r10.strokeShapeAppearance
            android.graphics.RectF r2 = r10.insetRectF
            android.graphics.RectF r3 = r10.getBoundsAsRectF()
            r2.set(r3)
            float r2 = r10.getStrokeInsetLength()
            android.graphics.RectF r3 = r10.insetRectF
            r3.inset(r2, r2)
            android.graphics.RectF r8 = r10.insetRectF
            r3 = r10
            r4 = r11
            r3.drawShape(r4, r5, r6, r7, r8)
        L_0x01d2:
            android.graphics.Paint r11 = r10.fillPaint
            r11.setAlpha(r0)
            android.graphics.Paint r11 = r10.strokePaint
            r11.setAlpha(r1)
            return
        L_0x01dd:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "Invalid shadow bounds. Check that the treatments result in a valid path."
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.MaterialShapeDrawable.draw(android.graphics.Canvas):void");
    }

    public final void drawCompatShadow(Canvas canvas) {
        this.containsIncompatibleShadowOp.cardinality();
        if (this.drawableState.shadowCompatOffset != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.shadowPaint);
        }
        for (int i = 0; i < 4; i++) {
            this.cornerShadowOperation[i].draw(ShadowCompatOperation.IDENTITY_MATRIX, this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
            this.edgeShadowOperation[i].draw(ShadowCompatOperation.IDENTITY_MATRIX, this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate((float) (-shadowOffsetX), (float) (-shadowOffsetY));
            canvas.drawPath(this.path, clearPaint);
            canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
        }
    }

    public final void drawShape(Canvas canvas, Paint paint, Path path2, ShapeAppearanceModel shapeAppearanceModel, RectF rectF2) {
        if (shapeAppearanceModel.isRoundRect(rectF2)) {
            float cornerSize = shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF2) * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF2, cornerSize, cornerSize, paint);
            return;
        }
        canvas.drawPath(path2, paint);
    }

    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    public ConstantState getConstantState() {
        return this.drawableState;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.drawableState.shadowCompatMode != 2) {
            if (isRoundRect()) {
                outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.interpolation);
                return;
            }
            calculatePath(getBoundsAsRectF(), this.path);
            if (this.path.isConvex() || VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.path);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.drawableState.padding;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public int getShadowOffsetX() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (Math.sin(Math.toRadians((double) materialShapeDrawableState.shadowCompatRotation)) * ((double) materialShapeDrawableState.shadowCompatOffset));
    }

    public int getShadowOffsetY() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (Math.cos(Math.toRadians((double) materialShapeDrawableState.shadowCompatRotation)) * ((double) materialShapeDrawableState.shadowCompatOffset));
    }

    public final float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.topLeftCornerSize.getCornerSize(getBoundsAsRectF());
    }

    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public final boolean hasStroke() {
        Style style = this.drawableState.paintStyle;
        return (style == Style.FILL_AND_STROKE || style == Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        updateZ();
    }

    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF());
    }

    public boolean isStateful() {
        if (!super.isStateful()) {
            ColorStateList colorStateList = this.drawableState.tintList;
            if (colorStateList == null || !colorStateList.isStateful()) {
                ColorStateList colorStateList2 = this.drawableState.strokeTintList;
                if (colorStateList2 == null || !colorStateList2.isStateful()) {
                    ColorStateList colorStateList3 = this.drawableState.strokeColor;
                    if (colorStateList3 == null || !colorStateList3.isStateful()) {
                        ColorStateList colorStateList4 = this.drawableState.fillColor;
                        if (colorStateList4 == null || !colorStateList4.isStateful()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z = updateColorsForState(iArr) || updateTintFilter();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void setAlpha(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.alpha != i) {
            materialShapeDrawableState.alpha = i;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.colorFilter = colorFilter;
        super.invalidateSelf();
    }

    public void setElevation(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.elevation != f2) {
            materialShapeDrawableState.elevation = f2;
            updateZ();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.fillColor != colorStateList) {
            materialShapeDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.interpolation != f2) {
            materialShapeDrawableState.interpolation = f2;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public void setPaintStyle(Style style) {
        this.drawableState.paintStyle = style;
        super.invalidateSelf();
    }

    public void setShadowColor(int i) {
        this.shadowRenderer.setShadowColor(i);
        this.drawableState.useTintColorForShadow = false;
        super.invalidateSelf();
    }

    public void setShadowCompatibilityMode(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatMode != i) {
            materialShapeDrawableState.shadowCompatMode = i;
            super.invalidateSelf();
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        invalidateSelf();
    }

    public void setStroke(float f2, int i) {
        this.drawableState.strokeWidth = f2;
        invalidateSelf();
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.strokeColor != colorStateList) {
            materialShapeDrawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeWidth(float f2) {
        this.drawableState.strokeWidth = f2;
        invalidateSelf();
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        super.invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.tintMode != mode) {
            materialShapeDrawableState.tintMode = mode;
            updateTintFilter();
            super.invalidateSelf();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean updateColorsForState(int[] r5) {
        /*
            r4 = this;
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r4.drawableState
            android.content.res.ColorStateList r0 = r0.fillColor
            r1 = 1
            if (r0 == 0) goto L_0x001e
            android.graphics.Paint r0 = r4.fillPaint
            int r0 = r0.getColor()
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r4.drawableState
            android.content.res.ColorStateList r2 = r2.fillColor
            int r2 = r2.getColorForState(r5, r0)
            if (r0 == r2) goto L_0x001e
            android.graphics.Paint r0 = r4.fillPaint
            r0.setColor(r2)
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r4.drawableState
            android.content.res.ColorStateList r2 = r2.strokeColor
            if (r2 == 0) goto L_0x003b
            android.graphics.Paint r2 = r4.strokePaint
            int r2 = r2.getColor()
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r3 = r4.drawableState
            android.content.res.ColorStateList r3 = r3.strokeColor
            int r5 = r3.getColorForState(r5, r2)
            if (r2 == r5) goto L_0x003b
            android.graphics.Paint r0 = r4.strokePaint
            r0.setColor(r5)
            goto L_0x003c
        L_0x003b:
            r1 = r0
        L_0x003c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.MaterialShapeDrawable.updateColorsForState(int[]):boolean");
    }

    public final boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        this.tintFilter = calculateTintFilter(materialShapeDrawableState.tintList, materialShapeDrawableState.tintMode, this.fillPaint, true);
        MaterialShapeDrawableState materialShapeDrawableState2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(materialShapeDrawableState2.strokeTintList, materialShapeDrawableState2.tintMode, this.strokePaint, false);
        MaterialShapeDrawableState materialShapeDrawableState3 = this.drawableState;
        if (materialShapeDrawableState3.useTintColorForShadow) {
            this.shadowRenderer.setShadowColor(materialShapeDrawableState3.tintList.getColorForState(getState(), 0));
        }
        if (!Objects.equals(porterDuffColorFilter, this.tintFilter) || !Objects.equals(porterDuffColorFilter2, this.strokeTintFilter)) {
            return true;
        }
        return false;
    }

    public final void updateZ() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f2 = materialShapeDrawableState.elevation + materialShapeDrawableState.translationZ;
        materialShapeDrawableState.shadowCompatRadius = (int) Math.ceil((double) (0.75f * f2));
        this.drawableState.shadowCompatOffset = (int) Math.ceil((double) (f2 * 0.25f));
        updateTintFilter();
        super.invalidateSelf();
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    public MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.cornerShadowOperation = new ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        this.fillPaint = new Paint(1);
        this.strokePaint = new Paint(1);
        this.shadowRenderer = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = Lazy.INSTANCE;
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.pathProvider = shapeAppearancePathProvider;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = materialShapeDrawableState;
        this.strokePaint.setStyle(Style.STROKE);
        this.fillPaint.setStyle(Style.FILL);
        clearPaint.setColor(-1);
        clearPaint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new PathListener() {
        };
    }

    public void setStroke(float f2, ColorStateList colorStateList) {
        this.drawableState.strokeWidth = f2;
        invalidateSelf();
        setStrokeColor(colorStateList);
    }
}
