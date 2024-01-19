package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x027b, code lost:
        if (r6 != false) goto L_0x0298;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflateHierarchy(android.content.Context r22, android.util.AttributeSet r23) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r0 = r23
            boolean r3 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = "GenericDraweeView#inflateHierarchy"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r3)
        L_0x0011:
            boolean r3 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r3 == 0) goto L_0x001c
            java.lang.String r3 = "GenericDraweeHierarchyBuilder#inflateBuilder"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r3)
        L_0x001c:
            android.content.res.Resources r3 = r22.getResources()
            com.facebook.drawee.generic.GenericDraweeHierarchyBuilder r4 = new com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
            r4.<init>(r3)
            if (r0 == 0) goto L_0x02bc
            int[] r7 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy
            android.content.res.TypedArray r7 = r2.obtainStyledAttributes(r0, r7)
            int r0 = r7.getIndexCount()     // Catch:{ all -> 0x02ac }
            r8 = 0
            r9 = 1
            r10 = 1
            r11 = 0
            r12 = 1
            r13 = 1
            r14 = 1
            r15 = 1
            r16 = 1
            r17 = 1
            r18 = 0
        L_0x003f:
            if (r8 >= r0) goto L_0x024a
            int r3 = r7.getIndex(r8)     // Catch:{ all -> 0x02ac }
            int r5 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_actualImageScaleType     // Catch:{ all -> 0x02ac }
            if (r3 != r5) goto L_0x0050
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getScaleTypeFromXml(r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mActualImageScaleType = r3     // Catch:{ all -> 0x02ac }
            goto L_0x0068
        L_0x0050:
            int r5 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_placeholderImage     // Catch:{ all -> 0x02ac }
            if (r3 != r5) goto L_0x005b
            android.graphics.drawable.Drawable r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable(r2, r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mPlaceholderImage = r3     // Catch:{ all -> 0x02ac }
            goto L_0x0068
        L_0x005b:
            int r5 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_pressedStateOverlayImage     // Catch:{ all -> 0x02ac }
            r6 = 0
            if (r3 != r5) goto L_0x0085
            android.graphics.drawable.Drawable r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable(r2, r7, r3)     // Catch:{ all -> 0x02ac }
            if (r3 != 0) goto L_0x006e
            r4.mPressedStateOverlay = r6     // Catch:{ all -> 0x02ac }
        L_0x0068:
            r23 = r0
        L_0x006a:
            r5 = r18
            goto L_0x0138
        L_0x006e:
            android.graphics.drawable.StateListDrawable r5 = new android.graphics.drawable.StateListDrawable     // Catch:{ all -> 0x02ac }
            r5.<init>()     // Catch:{ all -> 0x02ac }
            r23 = r0
            r6 = 1
            int[] r0 = new int[r6]     // Catch:{ all -> 0x02ac }
            r6 = 16842919(0x10100a7, float:2.3694026E-38)
            r19 = 0
            r0[r19] = r6     // Catch:{ all -> 0x02ac }
            r5.addState(r0, r3)     // Catch:{ all -> 0x02ac }
            r4.mPressedStateOverlay = r5     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x0085:
            r23 = r0
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_progressBarImage     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x0092
            android.graphics.drawable.Drawable r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable(r2, r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mProgressBarImage = r0     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x0092:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_fadeDuration     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x009e
            r0 = 0
            int r3 = r7.getInt(r3, r0)     // Catch:{ all -> 0x02ac }
            r4.mFadeDuration = r3     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x009e:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_viewAspectRatio     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00aa
            r0 = 0
            float r3 = r7.getFloat(r3, r0)     // Catch:{ all -> 0x02ac }
            r4.mDesiredAspectRatio = r3     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x00aa:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_placeholderImageScaleType     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00b5
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getScaleTypeFromXml(r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mPlaceholderImageScaleType = r0     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x00b5:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_retryImage     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00c0
            android.graphics.drawable.Drawable r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable(r2, r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mRetryImage = r0     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x00c0:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_retryImageScaleType     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00cb
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getScaleTypeFromXml(r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mRetryImageScaleType = r0     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x00cb:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_failureImage     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00d6
            android.graphics.drawable.Drawable r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable(r2, r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mFailureImage = r0     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x00d6:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_failureImageScaleType     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00e1
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getScaleTypeFromXml(r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mFailureImageScaleType = r0     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x00e1:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_progressBarImageScaleType     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00ed
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getScaleTypeFromXml(r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mProgressBarImageScaleType = r0     // Catch:{ all -> 0x02ac }
            goto L_0x006a
        L_0x00ed:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x00f9
            r5 = r18
            int r18 = r7.getInteger(r3, r5)     // Catch:{ all -> 0x02ac }
            goto L_0x0242
        L_0x00f9:
            r5 = r18
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_backgroundImage     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x0106
            android.graphics.drawable.Drawable r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable(r2, r7, r3)     // Catch:{ all -> 0x02ac }
            r4.mBackground = r0     // Catch:{ all -> 0x02ac }
            goto L_0x0138
        L_0x0106:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_overlayImage     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x0120
            android.graphics.drawable.Drawable r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable(r2, r7, r3)     // Catch:{ all -> 0x02ac }
            if (r0 != 0) goto L_0x0113
            r4.mOverlays = r6     // Catch:{ all -> 0x02ac }
            goto L_0x0138
        L_0x0113:
            r3 = 1
            android.graphics.drawable.Drawable[] r6 = new android.graphics.drawable.Drawable[r3]     // Catch:{ all -> 0x02ac }
            r3 = 0
            r6[r3] = r0     // Catch:{ all -> 0x02ac }
            java.util.List r0 = java.util.Arrays.asList(r6)     // Catch:{ all -> 0x02ac }
            r4.mOverlays = r0     // Catch:{ all -> 0x02ac }
            goto L_0x0138
        L_0x0120:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundAsCircle     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x0140
            com.facebook.drawee.generic.RoundingParams r0 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            if (r0 != 0) goto L_0x012f
            com.facebook.drawee.generic.RoundingParams r0 = new com.facebook.drawee.generic.RoundingParams     // Catch:{ all -> 0x02ac }
            r0.<init>()     // Catch:{ all -> 0x02ac }
            r4.mRoundingParams = r0     // Catch:{ all -> 0x02ac }
        L_0x012f:
            com.facebook.drawee.generic.RoundingParams r0 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            r6 = 0
            boolean r3 = r7.getBoolean(r3, r6)     // Catch:{ all -> 0x02ac }
            r0.mRoundAsCircle = r3     // Catch:{ all -> 0x02ac }
        L_0x0138:
            r0 = r16
            r6 = r17
            r17 = r5
            goto L_0x01c3
        L_0x0140:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundedCornerRadius     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x014c
            int r11 = r7.getDimensionPixelSize(r3, r11)     // Catch:{ all -> 0x02ac }
            r18 = r5
            goto L_0x0242
        L_0x014c:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundTopLeft     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x0155
            boolean r12 = r7.getBoolean(r3, r12)     // Catch:{ all -> 0x02ac }
            goto L_0x019b
        L_0x0155:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundTopRight     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x015e
            boolean r15 = r7.getBoolean(r3, r15)     // Catch:{ all -> 0x02ac }
            goto L_0x019b
        L_0x015e:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundBottomLeft     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x0167
            boolean r10 = r7.getBoolean(r3, r10)     // Catch:{ all -> 0x02ac }
            goto L_0x019b
        L_0x0167:
            int r0 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundBottomRight     // Catch:{ all -> 0x02ac }
            if (r3 != r0) goto L_0x0172
            r0 = r16
            boolean r16 = r7.getBoolean(r3, r0)     // Catch:{ all -> 0x02ac }
            goto L_0x019b
        L_0x0172:
            r0 = r16
            int r6 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundTopStart     // Catch:{ all -> 0x02ac }
            if (r3 != r6) goto L_0x017d
            boolean r13 = r7.getBoolean(r3, r13)     // Catch:{ all -> 0x02ac }
            goto L_0x0199
        L_0x017d:
            int r6 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundTopEnd     // Catch:{ all -> 0x02ac }
            if (r3 != r6) goto L_0x0186
            boolean r14 = r7.getBoolean(r3, r14)     // Catch:{ all -> 0x02ac }
            goto L_0x0199
        L_0x0186:
            int r6 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundBottomStart     // Catch:{ all -> 0x02ac }
            if (r3 != r6) goto L_0x018f
            boolean r9 = r7.getBoolean(r3, r9)     // Catch:{ all -> 0x02ac }
            goto L_0x0199
        L_0x018f:
            int r6 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundBottomEnd     // Catch:{ all -> 0x02ac }
            if (r3 != r6) goto L_0x01a3
            r6 = r17
            boolean r17 = r7.getBoolean(r3, r6)     // Catch:{ all -> 0x02ac }
        L_0x0199:
            r16 = r0
        L_0x019b:
            r18 = r11
            r6 = r17
            r17 = r5
            goto L_0x023c
        L_0x01a3:
            r6 = r17
            int r2 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundWithOverlayColor     // Catch:{ all -> 0x02ac }
            if (r3 != r2) goto L_0x01c7
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            if (r2 != 0) goto L_0x01b4
            com.facebook.drawee.generic.RoundingParams r2 = new com.facebook.drawee.generic.RoundingParams     // Catch:{ all -> 0x02ac }
            r2.<init>()     // Catch:{ all -> 0x02ac }
            r4.mRoundingParams = r2     // Catch:{ all -> 0x02ac }
        L_0x01b4:
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            r17 = r5
            r5 = 0
            int r3 = r7.getColor(r3, r5)     // Catch:{ all -> 0x02ac }
            r2.mOverlayColor = r3     // Catch:{ all -> 0x02ac }
            com.facebook.drawee.generic.RoundingParams$RoundingMethod r3 = com.facebook.drawee.generic.RoundingParams.RoundingMethod.OVERLAY_COLOR     // Catch:{ all -> 0x02ac }
            r2.mRoundingMethod = r3     // Catch:{ all -> 0x02ac }
        L_0x01c3:
            r18 = r11
            goto L_0x023a
        L_0x01c7:
            r17 = r5
            int r2 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundingBorderWidth     // Catch:{ all -> 0x02ac }
            if (r3 != r2) goto L_0x01f6
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            if (r2 != 0) goto L_0x01d8
            com.facebook.drawee.generic.RoundingParams r2 = new com.facebook.drawee.generic.RoundingParams     // Catch:{ all -> 0x02ac }
            r2.<init>()     // Catch:{ all -> 0x02ac }
            r4.mRoundingParams = r2     // Catch:{ all -> 0x02ac }
        L_0x01d8:
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            r5 = 0
            int r3 = r7.getDimensionPixelSize(r3, r5)     // Catch:{ all -> 0x02ac }
            float r3 = (float) r3     // Catch:{ all -> 0x02ac }
            if (r2 == 0) goto L_0x01f4
            r5 = 0
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r18 = r11
            if (r16 < 0) goto L_0x01eb
            r5 = 1
            goto L_0x01ec
        L_0x01eb:
            r5 = 0
        L_0x01ec:
            java.lang.String r11 = "the border width cannot be < 0"
            co.hyperverge.hypersnapsdk.c.k.checkArgument(r5, r11)     // Catch:{ all -> 0x02ac }
            r2.mBorderWidth = r3     // Catch:{ all -> 0x02ac }
            goto L_0x023a
        L_0x01f4:
            r0 = 0
            throw r0     // Catch:{ all -> 0x02ac }
        L_0x01f6:
            r18 = r11
            int r2 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundingBorderColor     // Catch:{ all -> 0x02ac }
            if (r3 != r2) goto L_0x0211
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            if (r2 != 0) goto L_0x0207
            com.facebook.drawee.generic.RoundingParams r2 = new com.facebook.drawee.generic.RoundingParams     // Catch:{ all -> 0x02ac }
            r2.<init>()     // Catch:{ all -> 0x02ac }
            r4.mRoundingParams = r2     // Catch:{ all -> 0x02ac }
        L_0x0207:
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            r5 = 0
            int r3 = r7.getColor(r3, r5)     // Catch:{ all -> 0x02ac }
            r2.mBorderColor = r3     // Catch:{ all -> 0x02ac }
            goto L_0x023a
        L_0x0211:
            int r2 = com.facebook.drawee.R$styleable.GenericDraweeHierarchy_roundingBorderPadding     // Catch:{ all -> 0x02ac }
            if (r3 != r2) goto L_0x023a
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            if (r2 != 0) goto L_0x0220
            com.facebook.drawee.generic.RoundingParams r2 = new com.facebook.drawee.generic.RoundingParams     // Catch:{ all -> 0x02ac }
            r2.<init>()     // Catch:{ all -> 0x02ac }
            r4.mRoundingParams = r2     // Catch:{ all -> 0x02ac }
        L_0x0220:
            com.facebook.drawee.generic.RoundingParams r2 = r4.mRoundingParams     // Catch:{ all -> 0x02ac }
            r5 = 0
            int r3 = r7.getDimensionPixelSize(r3, r5)     // Catch:{ all -> 0x02ac }
            float r3 = (float) r3     // Catch:{ all -> 0x02ac }
            if (r2 == 0) goto L_0x0238
            r11 = 0
            int r16 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r16 < 0) goto L_0x0230
            r5 = 1
        L_0x0230:
            java.lang.String r11 = "the padding cannot be < 0"
            co.hyperverge.hypersnapsdk.c.k.checkArgument(r5, r11)     // Catch:{ all -> 0x02ac }
            r2.mPadding = r3     // Catch:{ all -> 0x02ac }
            goto L_0x023a
        L_0x0238:
            r0 = 0
            throw r0     // Catch:{ all -> 0x02ac }
        L_0x023a:
            r16 = r0
        L_0x023c:
            r11 = r18
            r18 = r17
            r17 = r6
        L_0x0242:
            int r8 = r8 + 1
            r2 = r22
            r0 = r23
            goto L_0x003f
        L_0x024a:
            r0 = r16
            r6 = r17
            r17 = r18
            r18 = r11
            r7.recycle()
            android.content.res.Resources r2 = r22.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.getLayoutDirection()
            r3 = 1
            if (r2 != r3) goto L_0x027e
            if (r12 == 0) goto L_0x026a
            if (r14 == 0) goto L_0x026a
            r2 = 1
            goto L_0x026b
        L_0x026a:
            r2 = 0
        L_0x026b:
            if (r15 == 0) goto L_0x0271
            if (r13 == 0) goto L_0x0271
            r5 = 1
            goto L_0x0272
        L_0x0271:
            r5 = 0
        L_0x0272:
            if (r0 == 0) goto L_0x0278
            if (r9 == 0) goto L_0x0278
            r0 = 1
            goto L_0x0279
        L_0x0278:
            r0 = 0
        L_0x0279:
            if (r10 == 0) goto L_0x029d
            if (r6 == 0) goto L_0x029d
            goto L_0x0298
        L_0x027e:
            if (r12 == 0) goto L_0x0284
            if (r13 == 0) goto L_0x0284
            r2 = 1
            goto L_0x0285
        L_0x0284:
            r2 = 0
        L_0x0285:
            if (r15 == 0) goto L_0x028b
            if (r14 == 0) goto L_0x028b
            r5 = 1
            goto L_0x028c
        L_0x028b:
            r5 = 0
        L_0x028c:
            if (r0 == 0) goto L_0x0292
            if (r6 == 0) goto L_0x0292
            r6 = 1
            goto L_0x0293
        L_0x0292:
            r6 = 0
        L_0x0293:
            if (r10 == 0) goto L_0x029c
            if (r9 == 0) goto L_0x029c
            r0 = r6
        L_0x0298:
            r6 = r0
            r0 = r5
            r5 = 1
            goto L_0x02a0
        L_0x029c:
            r0 = r6
        L_0x029d:
            r6 = r0
            r0 = r5
            r5 = 0
        L_0x02a0:
            r3 = r0
            r7 = r5
            r5 = r17
            r0 = r18
            r20 = r6
            r6 = r2
            r2 = r20
            goto L_0x02c2
        L_0x02ac:
            r0 = move-exception
            r7.recycle()
            android.content.res.Resources r2 = r22.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            r2.getLayoutDirection()
            throw r0
        L_0x02bc:
            r3 = 1
            r0 = 0
            r2 = 1
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x02c2:
            android.graphics.drawable.Drawable r8 = r4.mProgressBarImage
            if (r8 == 0) goto L_0x02d1
            if (r5 <= 0) goto L_0x02d1
            com.facebook.drawee.drawable.AutoRotateDrawable r8 = new com.facebook.drawee.drawable.AutoRotateDrawable
            android.graphics.drawable.Drawable r9 = r4.mProgressBarImage
            r8.<init>(r9, r5)
            r4.mProgressBarImage = r8
        L_0x02d1:
            if (r0 <= 0) goto L_0x02f7
            com.facebook.drawee.generic.RoundingParams r5 = r4.mRoundingParams
            if (r5 != 0) goto L_0x02de
            com.facebook.drawee.generic.RoundingParams r5 = new com.facebook.drawee.generic.RoundingParams
            r5.<init>()
            r4.mRoundingParams = r5
        L_0x02de:
            com.facebook.drawee.generic.RoundingParams r5 = r4.mRoundingParams
            if (r6 == 0) goto L_0x02e4
            float r6 = (float) r0
            goto L_0x02e5
        L_0x02e4:
            r6 = 0
        L_0x02e5:
            if (r3 == 0) goto L_0x02e9
            float r3 = (float) r0
            goto L_0x02ea
        L_0x02e9:
            r3 = 0
        L_0x02ea:
            if (r2 == 0) goto L_0x02ee
            float r2 = (float) r0
            goto L_0x02ef
        L_0x02ee:
            r2 = 0
        L_0x02ef:
            if (r7 == 0) goto L_0x02f3
            float r0 = (float) r0
            goto L_0x02f4
        L_0x02f3:
            r0 = 0
        L_0x02f4:
            r5.setCornersRadii(r6, r3, r2, r0)
        L_0x02f7:
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0300
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0300:
            float r0 = r4.mDesiredAspectRatio
            r1.setAspectRatio(r0)
            com.facebook.drawee.generic.GenericDraweeHierarchy r0 = r4.build()
            r1.setHierarchy(r0)
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0315
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0315:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.view.GenericDraweeView.inflateHierarchy(android.content.Context, android.util.AttributeSet):void");
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }
}
