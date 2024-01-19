package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReactImageView extends GenericDraweeView {
    public static float[] sComputedCornerRadii = new float[4];
    public static final Matrix sInverse = new Matrix();
    public static final Matrix sMatrix = new Matrix();
    public static final Matrix sTileMatrix = new Matrix();
    public int mBackgroundColor;
    public RoundedColorDrawable mBackgroundImageDrawable;
    public int mBorderColor;
    public float[] mBorderCornerRadii;
    public float mBorderRadius;
    public float mBorderWidth;
    public ImageSource mCachedImageSource;
    public Object mCallerContext;
    public ControllerListener mControllerForTesting;
    public ControllerListener mControllerListener;
    public Drawable mDefaultImageDrawable;
    public final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    public int mFadeDurationMs;
    public GlobalImageLoadListener mGlobalImageLoadListener;
    public ReadableMap mHeaders;
    public ImageSource mImageSource;
    public boolean mIsDirty;
    public IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;
    public Drawable mLoadingImageDrawable;
    public int mOverlayColor;
    public boolean mProgressiveRenderingEnabled;
    public ImageResizeMethod mResizeMethod;
    public final RoundedCornerPostprocessor mRoundedCornerPostprocessor;
    public ScalingUtils$ScaleType mScaleType;
    public final List<ImageSource> mSources;
    public TileMode mTileMode;
    public final TilePostprocessor mTilePostprocessor;

    public class RoundedCornerPostprocessor extends BasePostprocessor {
        public RoundedCornerPostprocessor(AnonymousClass1 r2) {
        }

        public void process(Bitmap bitmap, Bitmap bitmap2) {
            Bitmap bitmap3 = bitmap;
            ReactImageView.this.cornerRadii(ReactImageView.sComputedCornerRadii);
            bitmap3.setHasAlpha(true);
            if (!ImageOriginUtils.floatsEqual(ReactImageView.sComputedCornerRadii[0], 0.0f) || !ImageOriginUtils.floatsEqual(ReactImageView.sComputedCornerRadii[1], 0.0f) || !ImageOriginUtils.floatsEqual(ReactImageView.sComputedCornerRadii[2], 0.0f) || !ImageOriginUtils.floatsEqual(ReactImageView.sComputedCornerRadii[3], 0.0f)) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                TileMode tileMode = TileMode.CLAMP;
                paint.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                Canvas canvas = new Canvas(bitmap3);
                float[] fArr = new float[8];
                float[] fArr2 = ReactImageView.sComputedCornerRadii;
                ((ScalingUtils$AbstractScaleType) ReactImageView.this.mScaleType).getTransform(ReactImageView.sMatrix, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), bitmap2.getWidth(), bitmap2.getHeight(), 0.0f, 0.0f);
                ReactImageView.sMatrix.invert(ReactImageView.sInverse);
                fArr[0] = ReactImageView.sInverse.mapRadius(fArr2[0]);
                fArr[1] = fArr[0];
                fArr[2] = ReactImageView.sInverse.mapRadius(fArr2[1]);
                fArr[3] = fArr[2];
                fArr[4] = ReactImageView.sInverse.mapRadius(fArr2[2]);
                fArr[5] = fArr[4];
                fArr[6] = ReactImageView.sInverse.mapRadius(fArr2[3]);
                fArr[7] = fArr[6];
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight()), fArr, Direction.CW);
                canvas.drawPath(path, paint);
                return;
            }
            super.process(bitmap, bitmap2);
        }
    }

    public class TilePostprocessor extends BasePostprocessor {
        public TilePostprocessor(AnonymousClass1 r2) {
        }

        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ((ScalingUtils$AbstractScaleType) ReactImageView.this.mScaleType).getTransform(ReactImageView.sTileMatrix, rect, bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            TileMode tileMode = ReactImageView.this.mTileMode;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(ReactImageView.sTileMatrix);
            paint.setShader(bitmapShader);
            CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            try {
                new Canvas((Bitmap) createBitmap.get()).drawRect(rect, paint);
                CloseableReference<Bitmap> clone = createBitmap.clone();
                createBitmap.close();
                return clone;
            } catch (Throwable th) {
                CloseableReference.closeSafely(createBitmap);
                throw th;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        // GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        // RoundingParams roundingParams = new RoundingParams();
        // if (roundingParams.mCornersRadii == null) {
            // roundingParams.mCornersRadii = new float[8];
        // }
        // Arrays.fill(roundingParams.mCornersRadii, 0.0f);
        // genericDraweeHierarchyBuilder.mRoundingParams = roundingParams;
        super(context, genericDraweeHierarchyBuilder.build());
        this.mResizeMethod = ImageResizeMethod.AUTO;
        this.mBackgroundColor = 0;
        this.mBorderRadius = Float.NaN;
        this.mTileMode = TileMode.CLAMP;
        this.mFadeDurationMs = -1;
        this.mScaleType = ScalingUtils$ScaleType.CENTER_CROP;
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mRoundedCornerPostprocessor = new RoundedCornerPostprocessor(null);
        this.mTilePostprocessor = new TilePostprocessor(null);
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
        this.mSources = new LinkedList();
    }

    public final void cornerRadii(float[] fArr) {
        float f2 = !ImageOriginUtils.isUndefined(this.mBorderRadius) ? this.mBorderRadius : 0.0f;
        float[] fArr2 = this.mBorderCornerRadii;
        fArr[0] = (fArr2 == null || ImageOriginUtils.isUndefined(fArr2[0])) ? f2 : this.mBorderCornerRadii[0];
        float[] fArr3 = this.mBorderCornerRadii;
        fArr[1] = (fArr3 == null || ImageOriginUtils.isUndefined(fArr3[1])) ? f2 : this.mBorderCornerRadii[1];
        float[] fArr4 = this.mBorderCornerRadii;
        fArr[2] = (fArr4 == null || ImageOriginUtils.isUndefined(fArr4[2])) ? f2 : this.mBorderCornerRadii[2];
        float[] fArr5 = this.mBorderCornerRadii;
        if (fArr5 != null && !ImageOriginUtils.isUndefined(fArr5[3])) {
            f2 = this.mBorderCornerRadii[3];
        }
        fArr[3] = f2;
    }

    public final boolean hasMultipleSources() {
        return this.mSources.size() > 1;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public final boolean isTiled() {
        return this.mTileMode != TileMode.CLAMP;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fe A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void maybeUpdateView() {
        /*
            r20 = this;
            r0 = r20
            boolean r1 = r0.mIsDirty
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r1 = r20.hasMultipleSources()
            if (r1 == 0) goto L_0x001a
            int r1 = r20.getWidth()
            if (r1 <= 0) goto L_0x0019
            int r1 = r20.getHeight()
            if (r1 > 0) goto L_0x001a
        L_0x0019:
            return
        L_0x001a:
            r1 = 0
            r0.mImageSource = r1
            java.util.List<com.facebook.react.views.imagehelper.ImageSource> r2 = r0.mSources
            boolean r2 = r2.isEmpty()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0039
            com.facebook.react.views.imagehelper.ImageSource r2 = new com.facebook.react.views.imagehelper.ImageSource
            android.content.Context r5 = r20.getContext()
            java.lang.String r6 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII="
            r2.<init>(r5, r6)
            java.util.List<com.facebook.react.views.imagehelper.ImageSource> r5 = r0.mSources
            r5.add(r2)
            goto L_0x00f0
        L_0x0039:
            boolean r2 = r20.hasMultipleSources()
            if (r2 == 0) goto L_0x00f0
            int r2 = r20.getWidth()
            int r5 = r20.getHeight()
            java.util.List<com.facebook.react.views.imagehelper.ImageSource> r6 = r0.mSources
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0056
            com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult r2 = new com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult
            r2.<init>(r1, r1, r1)
            goto L_0x00e7
        L_0x0056:
            int r7 = r6.size()
            if (r7 != r3) goto L_0x0069
            com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult r2 = new com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult
            java.lang.Object r5 = r6.get(r4)
            com.facebook.react.views.imagehelper.ImageSource r5 = (com.facebook.react.views.imagehelper.ImageSource) r5
            r2.<init>(r5, r1, r1)
            goto L_0x00e7
        L_0x0069:
            if (r2 <= 0) goto L_0x00e2
            if (r5 > 0) goto L_0x006f
            goto L_0x00e2
        L_0x006f:
            com.facebook.imagepipeline.core.ImagePipelineFactory r7 = com.facebook.imagepipeline.core.ImagePipelineFactory.getInstance()
            com.facebook.imagepipeline.core.ImagePipeline r7 = r7.getImagePipeline()
            int r2 = r2 * r5
            double r8 = (double) r2
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r8 = r8 * r10
            java.util.Iterator r2 = r6.iterator()
            r5 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r14 = r1
            r15 = r14
            r12 = r5
        L_0x008a:
            boolean r16 = r2.hasNext()
            if (r16 == 0) goto L_0x00c9
            java.lang.Object r16 = r2.next()
            com.facebook.react.views.imagehelper.ImageSource r16 = (com.facebook.react.views.imagehelper.ImageSource) r16
            double r17 = r16.getSize()
            double r17 = r17 / r8
            double r17 = r10 - r17
            double r17 = java.lang.Math.abs(r17)
            int r19 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r19 >= 0) goto L_0x00aa
            r15 = r16
            r5 = r17
        L_0x00aa:
            int r19 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r19 >= 0) goto L_0x00c6
            android.net.Uri r10 = r16.getUri()
            boolean r10 = r7.isInBitmapMemoryCache(r10)
            if (r10 != 0) goto L_0x00c2
            android.net.Uri r10 = r16.getUri()
            boolean r10 = r7.isInDiskCacheSync(r10)
            if (r10 == 0) goto L_0x00c6
        L_0x00c2:
            r14 = r16
            r12 = r17
        L_0x00c6:
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x008a
        L_0x00c9:
            if (r14 == 0) goto L_0x00dc
            if (r15 == 0) goto L_0x00dc
            java.lang.String r2 = r14.getSource()
            java.lang.String r5 = r15.getSource()
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x00dc
            r14 = r1
        L_0x00dc:
            com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult r2 = new com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult
            r2.<init>(r15, r14, r1)
            goto L_0x00e7
        L_0x00e2:
            com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult r2 = new com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult
            r2.<init>(r1, r1, r1)
        L_0x00e7:
            com.facebook.react.views.imagehelper.ImageSource r5 = r2.bestResult
            r0.mImageSource = r5
            com.facebook.react.views.imagehelper.ImageSource r2 = r2.bestResultInCache
            r0.mCachedImageSource = r2
            goto L_0x00fa
        L_0x00f0:
            java.util.List<com.facebook.react.views.imagehelper.ImageSource> r2 = r0.mSources
            java.lang.Object r2 = r2.get(r4)
            com.facebook.react.views.imagehelper.ImageSource r2 = (com.facebook.react.views.imagehelper.ImageSource) r2
            r0.mImageSource = r2
        L_0x00fa:
            com.facebook.react.views.imagehelper.ImageSource r2 = r0.mImageSource
            if (r2 != 0) goto L_0x00ff
            return
        L_0x00ff:
            com.facebook.react.views.image.ImageResizeMethod r5 = r0.mResizeMethod
            com.facebook.react.views.image.ImageResizeMethod r6 = com.facebook.react.views.image.ImageResizeMethod.AUTO
            if (r5 != r6) goto L_0x011a
            android.net.Uri r5 = r2.getUri()
            boolean r5 = com.facebook.common.util.UriUtil.isLocalContentUri(r5)
            if (r5 != 0) goto L_0x011e
            android.net.Uri r2 = r2.getUri()
            boolean r2 = com.facebook.common.util.UriUtil.isLocalFileUri(r2)
            if (r2 == 0) goto L_0x0120
            goto L_0x011e
        L_0x011a:
            com.facebook.react.views.image.ImageResizeMethod r2 = com.facebook.react.views.image.ImageResizeMethod.RESIZE
            if (r5 != r2) goto L_0x0120
        L_0x011e:
            r2 = 1
            goto L_0x0121
        L_0x0120:
            r2 = 0
        L_0x0121:
            if (r2 == 0) goto L_0x0130
            int r5 = r20.getWidth()
            if (r5 <= 0) goto L_0x012f
            int r5 = r20.getHeight()
            if (r5 > 0) goto L_0x0130
        L_0x012f:
            return
        L_0x0130:
            boolean r5 = r20.isTiled()
            if (r5 == 0) goto L_0x0143
            int r5 = r20.getWidth()
            if (r5 <= 0) goto L_0x0142
            int r5 = r20.getHeight()
            if (r5 > 0) goto L_0x0143
        L_0x0142:
            return
        L_0x0143:
            com.facebook.drawee.interfaces.DraweeHierarchy r5 = r20.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r5 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r5
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r6 = r0.mScaleType
            if (r6 == 0) goto L_0x0351
            r7 = 2
            com.facebook.drawee.drawable.ScaleTypeDrawable r8 = r5.getScaleTypeDrawableAtIndex(r7)
            r8.setScaleType(r6)
            android.graphics.drawable.Drawable r6 = r0.mDefaultImageDrawable
            if (r6 == 0) goto L_0x0165
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r8 = r0.mScaleType
            r5.setChildDrawableAtIndex(r3, r6)
            com.facebook.drawee.drawable.ScaleTypeDrawable r6 = r5.getScaleTypeDrawableAtIndex(r3)
            r6.setScaleType(r8)
        L_0x0165:
            android.graphics.drawable.Drawable r6 = r0.mLoadingImageDrawable
            if (r6 == 0) goto L_0x0175
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r8 = com.facebook.drawee.drawable.ScalingUtils$ScaleType.CENTER
            r5.setChildDrawableAtIndex(r3, r6)
            com.facebook.drawee.drawable.ScaleTypeDrawable r6 = r5.getScaleTypeDrawableAtIndex(r3)
            r6.setScaleType(r8)
        L_0x0175:
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r6 = r0.mScaleType
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r8 = com.facebook.drawee.drawable.ScalingUtils$ScaleType.CENTER_CROP
            if (r6 == r8) goto L_0x0181
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r8 = com.facebook.drawee.drawable.ScalingUtils$ScaleType.FOCUS_CROP
            if (r6 == r8) goto L_0x0181
            r6 = 1
            goto L_0x0182
        L_0x0181:
            r6 = 0
        L_0x0182:
            com.facebook.drawee.generic.RoundingParams r8 = r5.mRoundingParams
            float[] r9 = sComputedCornerRadii
            r0.cornerRadii(r9)
            float[] r9 = sComputedCornerRadii
            r10 = r9[r4]
            r11 = r9[r3]
            r7 = r9[r7]
            r12 = 3
            r9 = r9[r12]
            r8.setCornersRadii(r10, r11, r7, r9)
            com.facebook.drawee.drawable.RoundedColorDrawable r7 = r0.mBackgroundImageDrawable
            if (r7 == 0) goto L_0x01ae
            int r9 = r0.mBorderColor
            float r10 = r0.mBorderWidth
            r7.setBorder(r9, r10)
            com.facebook.drawee.drawable.RoundedColorDrawable r7 = r0.mBackgroundImageDrawable
            float[] r9 = r8.mCornersRadii
            r7.setRadii(r9)
            com.facebook.drawee.drawable.RoundedColorDrawable r7 = r0.mBackgroundImageDrawable
            r5.setChildDrawableAtIndex(r4, r7)
        L_0x01ae:
            r7 = 0
            if (r6 == 0) goto L_0x01c0
            float[] r9 = r8.mCornersRadii
            if (r9 != 0) goto L_0x01bb
            r9 = 8
            float[] r9 = new float[r9]
            r8.mCornersRadii = r9
        L_0x01bb:
            float[] r9 = r8.mCornersRadii
            java.util.Arrays.fill(r9, r7)
        L_0x01c0:
            int r9 = r0.mBorderColor
            float r10 = r0.mBorderWidth
            int r11 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r11 < 0) goto L_0x01ca
            r11 = 1
            goto L_0x01cb
        L_0x01ca:
            r11 = 0
        L_0x01cb:
            java.lang.String r12 = "the border width cannot be < 0"
            co.hyperverge.hypersnapsdk.c.k.checkArgument(r11, r12)
            r8.mBorderWidth = r10
            r8.mBorderColor = r9
            int r9 = r0.mOverlayColor
            if (r9 == 0) goto L_0x01df
            r8.mOverlayColor = r9
            com.facebook.drawee.generic.RoundingParams$RoundingMethod r9 = com.facebook.drawee.generic.RoundingParams.RoundingMethod.OVERLAY_COLOR
            r8.mRoundingMethod = r9
            goto L_0x01e3
        L_0x01df:
            com.facebook.drawee.generic.RoundingParams$RoundingMethod r9 = com.facebook.drawee.generic.RoundingParams.RoundingMethod.BITMAP_ONLY
            r8.mRoundingMethod = r9
        L_0x01e3:
            r5.mRoundingParams = r8
            com.facebook.drawee.generic.RootDrawable r9 = r5.mTopLevelDrawable
            com.facebook.drawee.generic.WrappingUtils.updateOverlayColorRounding(r9, r8)
            r8 = 0
        L_0x01eb:
            com.facebook.drawee.drawable.FadeDrawable r9 = r5.mFadeDrawable
            android.graphics.drawable.Drawable[] r9 = r9.mLayers
            int r9 = r9.length
            if (r8 >= r9) goto L_0x0249
            com.facebook.drawee.drawable.DrawableParent r9 = r5.getParentDrawableAtIndex(r8)
            com.facebook.drawee.generic.RoundingParams r10 = r5.mRoundingParams
            android.content.res.Resources r11 = r5.mResources
        L_0x01fa:
            android.graphics.drawable.Drawable r12 = r9.getDrawable()
            if (r12 == r9) goto L_0x0209
            boolean r13 = r12 instanceof com.facebook.drawee.drawable.DrawableParent
            if (r13 != 0) goto L_0x0205
            goto L_0x0209
        L_0x0205:
            r9 = r12
            com.facebook.drawee.drawable.DrawableParent r9 = (com.facebook.drawee.drawable.DrawableParent) r9
            goto L_0x01fa
        L_0x0209:
            android.graphics.drawable.Drawable r12 = r9.getDrawable()
            if (r10 == 0) goto L_0x022e
            com.facebook.drawee.generic.RoundingParams$RoundingMethod r13 = r10.mRoundingMethod
            com.facebook.drawee.generic.RoundingParams$RoundingMethod r14 = com.facebook.drawee.generic.RoundingParams.RoundingMethod.BITMAP_ONLY
            if (r13 != r14) goto L_0x022e
            boolean r13 = r12 instanceof com.facebook.drawee.drawable.Rounded
            if (r13 == 0) goto L_0x021f
            com.facebook.drawee.drawable.Rounded r12 = (com.facebook.drawee.drawable.Rounded) r12
            com.facebook.drawee.generic.WrappingUtils.applyRoundingParams(r12, r10)
            goto L_0x0246
        L_0x021f:
            if (r12 == 0) goto L_0x0246
            android.graphics.drawable.Drawable r13 = com.facebook.drawee.generic.WrappingUtils.sEmptyDrawable
            r9.setDrawable(r13)
            android.graphics.drawable.Drawable r10 = com.facebook.drawee.generic.WrappingUtils.applyLeafRounding(r12, r10, r11)
            r9.setDrawable(r10)
            goto L_0x0246
        L_0x022e:
            boolean r9 = r12 instanceof com.facebook.drawee.drawable.Rounded
            if (r9 == 0) goto L_0x0246
            com.facebook.drawee.drawable.Rounded r12 = (com.facebook.drawee.drawable.Rounded) r12
            r12.setCircle(r4)
            r12.setRadius(r7)
            r12.setBorder(r4, r7)
            r12.setPadding(r7)
            r12.setScaleDownInsideBorders(r4)
            r12.setPaintFilterBitmap(r4)
        L_0x0246:
            int r8 = r8 + 1
            goto L_0x01eb
        L_0x0249:
            int r7 = r0.mFadeDurationMs
            if (r7 < 0) goto L_0x024e
            goto L_0x025a
        L_0x024e:
            com.facebook.react.views.imagehelper.ImageSource r7 = r0.mImageSource
            boolean r7 = r7.isResource()
            if (r7 == 0) goto L_0x0258
            r7 = 0
            goto L_0x025a
        L_0x0258:
            r7 = 300(0x12c, float:4.2E-43)
        L_0x025a:
            com.facebook.drawee.drawable.FadeDrawable r5 = r5.mFadeDrawable
            r5.mDurationMs = r7
            int r7 = r5.mTransitionState
            if (r7 != r3) goto L_0x0264
            r5.mTransitionState = r4
        L_0x0264:
            java.util.LinkedList r5 = new java.util.LinkedList
            r5.<init>()
            if (r6 == 0) goto L_0x0270
            com.facebook.react.views.image.ReactImageView$RoundedCornerPostprocessor r6 = r0.mRoundedCornerPostprocessor
            r5.add(r6)
        L_0x0270:
            com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor r6 = r0.mIterativeBoxBlurPostProcessor
            if (r6 == 0) goto L_0x0277
            r5.add(r6)
        L_0x0277:
            boolean r6 = r20.isTiled()
            if (r6 == 0) goto L_0x0282
            com.facebook.react.views.image.ReactImageView$TilePostprocessor r6 = r0.mTilePostprocessor
            r5.add(r6)
        L_0x0282:
            int r6 = r5.size()
            if (r6 == 0) goto L_0x0298
            if (r6 == r3) goto L_0x0290
            com.facebook.react.views.image.MultiPostprocessor r6 = new com.facebook.react.views.image.MultiPostprocessor
            r6.<init>(r5)
            goto L_0x0299
        L_0x0290:
            java.lang.Object r5 = r5.get(r4)
            r6 = r5
            com.facebook.imagepipeline.request.Postprocessor r6 = (com.facebook.imagepipeline.request.Postprocessor) r6
            goto L_0x0299
        L_0x0298:
            r6 = r1
        L_0x0299:
            if (r2 == 0) goto L_0x02a8
            com.facebook.imagepipeline.common.ResizeOptions r1 = new com.facebook.imagepipeline.common.ResizeOptions
            int r2 = r20.getWidth()
            int r5 = r20.getHeight()
            r1.<init>(r2, r5)
        L_0x02a8:
            com.facebook.react.views.imagehelper.ImageSource r2 = r0.mImageSource
            android.net.Uri r2 = r2.getUri()
            com.facebook.imagepipeline.request.ImageRequestBuilder r2 = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(r2)
            com.facebook.imagepipeline.request.ImageRequestBuilder r2 = r2.setPostprocessor(r6)
            com.facebook.imagepipeline.request.ImageRequestBuilder r2 = r2.setResizeOptions(r1)
            com.facebook.imagepipeline.request.ImageRequestBuilder r2 = r2.setAutoRotateEnabled(r3)
            boolean r5 = r0.mProgressiveRenderingEnabled
            com.facebook.imagepipeline.request.ImageRequestBuilder r2 = r2.setProgressiveRenderingEnabled(r5)
            com.facebook.react.bridge.ReadableMap r5 = r0.mHeaders
            com.facebook.react.modules.fresco.ReactNetworkImageRequest r7 = new com.facebook.react.modules.fresco.ReactNetworkImageRequest
            r7.<init>(r2, r5)
            com.facebook.react.views.image.GlobalImageLoadListener r2 = r0.mGlobalImageLoadListener
            if (r2 == 0) goto L_0x02d8
            com.facebook.react.views.imagehelper.ImageSource r5 = r0.mImageSource
            android.net.Uri r5 = r5.getUri()
            r2.onLoadAttempt(r5)
        L_0x02d8:
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r2 = r0.mDraweeControllerBuilder
            r2.init()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r2 = r0.mDraweeControllerBuilder
            r2.mAutoPlayAnimations = r3
            java.lang.Object r5 = r0.mCallerContext
            r2.mCallerContext = r5
            com.facebook.drawee.interfaces.DraweeController r5 = r20.getController()
            r2.mOldController = r5
            r2.mImageRequest = r7
            com.facebook.react.views.imagehelper.ImageSource r2 = r0.mCachedImageSource
            if (r2 == 0) goto L_0x0313
            android.net.Uri r2 = r2.getUri()
            com.facebook.imagepipeline.request.ImageRequestBuilder r2 = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(r2)
            com.facebook.imagepipeline.request.ImageRequestBuilder r2 = r2.setPostprocessor(r6)
            com.facebook.imagepipeline.request.ImageRequestBuilder r1 = r2.setResizeOptions(r1)
            com.facebook.imagepipeline.request.ImageRequestBuilder r1 = r1.setAutoRotateEnabled(r3)
            boolean r2 = r0.mProgressiveRenderingEnabled
            com.facebook.imagepipeline.request.ImageRequestBuilder r1 = r1.setProgressiveRenderingEnabled(r2)
            com.facebook.imagepipeline.request.ImageRequest r1 = r1.build()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r2 = r0.mDraweeControllerBuilder
            r2.mLowResImageRequest = r1
        L_0x0313:
            com.facebook.drawee.controller.ControllerListener r1 = r0.mControllerListener
            if (r1 == 0) goto L_0x032f
            com.facebook.drawee.controller.ControllerListener r1 = r0.mControllerForTesting
            if (r1 == 0) goto L_0x032f
            com.facebook.drawee.controller.ForwardingControllerListener r1 = new com.facebook.drawee.controller.ForwardingControllerListener
            r1.<init>()
            com.facebook.drawee.controller.ControllerListener r2 = r0.mControllerListener
            r1.addListener(r2)
            com.facebook.drawee.controller.ControllerListener r2 = r0.mControllerForTesting
            r1.addListener(r2)
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r2 = r0.mDraweeControllerBuilder
            r2.mControllerListener = r1
            goto L_0x0340
        L_0x032f:
            com.facebook.drawee.controller.ControllerListener r1 = r0.mControllerForTesting
            if (r1 == 0) goto L_0x0338
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r2 = r0.mDraweeControllerBuilder
            r2.mControllerListener = r1
            goto L_0x0340
        L_0x0338:
            com.facebook.drawee.controller.ControllerListener r1 = r0.mControllerListener
            if (r1 == 0) goto L_0x0340
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r2 = r0.mDraweeControllerBuilder
            r2.mControllerListener = r1
        L_0x0340:
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r1 = r0.mDraweeControllerBuilder
            com.facebook.drawee.controller.AbstractDraweeController r1 = r1.build()
            r0.setController(r1)
            r0.mIsDirty = r4
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r1 = r0.mDraweeControllerBuilder
            r1.init()
            return
        L_0x0351:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ReactImageView.maybeUpdateView():void");
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mIsDirty = this.mIsDirty || hasMultipleSources() || isTiled();
            maybeUpdateView();
        }
    }

    public void setBackgroundColor(int i) {
        if (this.mBackgroundColor != i) {
            this.mBackgroundColor = i;
            this.mBackgroundImageDrawable = new RoundedColorDrawable(i);
            this.mIsDirty = true;
        }
    }

    public void setBlurRadius(float f2) {
        int pixelFromDIP = (int) ImageOriginUtils.toPixelFromDIP(f2);
        if (pixelFromDIP == 0) {
            this.mIterativeBoxBlurPostProcessor = null;
        } else {
            this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor(pixelFromDIP);
        }
        this.mIsDirty = true;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        this.mIsDirty = true;
    }

    public void setBorderRadius(float f2) {
        if (!ImageOriginUtils.floatsEqual(this.mBorderRadius, f2)) {
            this.mBorderRadius = f2;
            this.mIsDirty = true;
        }
    }

    public void setBorderWidth(float f2) {
        this.mBorderWidth = ImageOriginUtils.toPixelFromDIP(f2);
        this.mIsDirty = true;
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.mControllerForTesting = controllerListener;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    public void setDefaultSource(String str) {
        ResourceDrawableIdHelper instance = ResourceDrawableIdHelper.getInstance();
        Context context = getContext();
        int resourceDrawableId = instance.getResourceDrawableId(context, str);
        this.mDefaultImageDrawable = resourceDrawableId > 0 ? context.getResources().getDrawable(resourceDrawableId) : null;
        this.mIsDirty = true;
    }

    public void setFadeDuration(int i) {
        this.mFadeDurationMs = i;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    public void setLoadingIndicatorSource(String str) {
        ResourceDrawableIdHelper instance = ResourceDrawableIdHelper.getInstance();
        Context context = getContext();
        int resourceDrawableId = instance.getResourceDrawableId(context, str);
        AutoRotateDrawable autoRotateDrawable = null;
        Drawable drawable = resourceDrawableId > 0 ? context.getResources().getDrawable(resourceDrawableId) : null;
        if (drawable != null) {
            autoRotateDrawable = new AutoRotateDrawable(drawable, 1000);
        }
        this.mLoadingImageDrawable = autoRotateDrawable;
        this.mIsDirty = true;
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        this.mIsDirty = true;
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        this.mResizeMethod = imageResizeMethod;
        this.mIsDirty = true;
    }

    public void setScaleType(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.mScaleType = scalingUtils$ScaleType;
        this.mIsDirty = true;
    }

    public void setShouldNotifyLoadEvents(boolean z) {
        if (!z) {
            this.mControllerListener = null;
        } else {
            final EventDispatcher eventDispatcherForReactTag = ImageOriginUtils.getEventDispatcherForReactTag((ReactContext) getContext(), getId());
            this.mControllerListener = new BaseControllerListener<ImageInfo>() {
                public void onFailure(String str, Throwable th) {
                    eventDispatcherForReactTag.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 1, true, th.getMessage()));
                }

                public void onFinalImageSet(String str, Object obj, Animatable animatable) {
                    ImageInfo imageInfo = (ImageInfo) obj;
                    if (imageInfo != null) {
                        EventDispatcher eventDispatcher = eventDispatcherForReactTag;
                        ImageLoadEvent imageLoadEvent = new ImageLoadEvent(ReactImageView.this.getId(), 2, ReactImageView.this.mImageSource.getSource(), imageInfo.getWidth(), imageInfo.getHeight());
                        eventDispatcher.dispatchEvent(imageLoadEvent);
                        eventDispatcherForReactTag.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
                    }
                }

                public void onSubmit(String str, Object obj) {
                    eventDispatcherForReactTag.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 4));
                }
            };
        }
        this.mIsDirty = true;
    }

    public void setSource(ReadableArray readableArray) {
        this.mSources.clear();
        if (readableArray == null || readableArray.size() == 0) {
            this.mSources.add(new ImageSource(getContext(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII="));
        } else {
            if (readableArray.size() == 1) {
                ImageSource imageSource = new ImageSource(getContext(), readableArray.getMap(0).getString("uri"));
                this.mSources.add(imageSource);
                if (Uri.EMPTY.equals(imageSource.getUri())) {
                    warnImageSource();
                }
            } else {
                for (int i = 0; i < readableArray.size(); i++) {
                    ReadableMap map = readableArray.getMap(i);
                    ImageSource imageSource2 = new ImageSource(getContext(), map.getString("uri"), map.getDouble("width"), map.getDouble("height"));
                    this.mSources.add(imageSource2);
                    if (Uri.EMPTY.equals(imageSource2.getUri())) {
                        warnImageSource();
                    }
                }
            }
        }
        this.mIsDirty = true;
    }

    public void setTileMode(TileMode tileMode) {
        this.mTileMode = tileMode;
        this.mIsDirty = true;
    }

    public final void warnImageSource() {
    }
}
