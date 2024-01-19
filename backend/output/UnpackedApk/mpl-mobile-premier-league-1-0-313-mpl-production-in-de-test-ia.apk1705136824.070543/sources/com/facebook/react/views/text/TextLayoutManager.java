package com.facebook.react.views.text;

import android.text.Spannable;
import android.text.TextPaint;
import android.util.LruCache;

public class TextLayoutManager {
    public static LruCache<String, Spannable> sSpannableCache = new LruCache<>(100);
    public static final Object sSpannableCacheLock = new Object();
    public static final TextPaint sTextPaintInstance = new TextPaint(1);

    public static class SetSpanOperation {
        public int end;
        public int start;
        public ReactSpan what;

        public SetSpanOperation(int i, int i2, ReactSpan reactSpan) {
            this.start = i;
            this.end = i2;
            this.what = reactSpan;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r8 = r4.getMap(r7);
        r9 = r2.length();
        r10 = new com.facebook.react.views.text.TextAttributeProps(new com.facebook.react.uimanager.ReactStylesDiffMap(r8.getMap("textAttributes")));
        r2.append(com.facebook.react.views.text.TextTransform.apply(r8.getString(com.facebook.react.modules.network.NetworkingModule.REQUEST_BODY_KEY_STRING), r10.mTextTransform));
        r11 = r2.length();
        r12 = r8.getInt("reactTag");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0067, code lost:
        if (r8.hasKey("isAttachment") == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
        if (r8.getBoolean("isAttachment") == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r2.length() - 1, r2.length(), new com.facebook.react.views.text.TextInlineViewPlaceholderSpan(r12, (int) com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromSP((float) r8.getDouble("width")), (int) com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromSP((float) r8.getDouble("height")))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009f, code lost:
        if (r11 < r9) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a3, code lost:
        if (r10.mIsColorSet == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a5, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactForegroundColorSpan(r10.mColor)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b6, code lost:
        if (r10.mIsBackgroundColorSet == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b8, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactBackgroundColorSpan(r10.mBackgroundColor)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cf, code lost:
        if (java.lang.Float.isNaN(r10.getLetterSpacing()) != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d1, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.CustomLetterSpacingSpan(r10.getLetterSpacing())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e2, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactAbsoluteSizeSpan(r10.mFontSize)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f3, code lost:
        if (r10.mFontStyle != -1) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f7, code lost:
        if (r10.mFontWeight != -1) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fb, code lost:
        if (r10.mFontFamily == null) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fe, code lost:
        r19 = r4;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0103, code lost:
        r14 = r10.mFontStyle;
        r13 = r10.mFontWeight;
        r6 = r10.mFontFeatureSettings;
        r19 = r4;
        r20 = r5;
        r5 = r13;
        r13 = new com.facebook.react.views.text.CustomStyleSpan(r14, r13, r6, r10.mFontFamily, r21.getAssets());
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x012c, code lost:
        if (r10.mIsUnderlineTextDecorationSet == false) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x012e, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactUnderlineSpan()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x013d, code lost:
        if (r10.mIsLineThroughTextDecorationSet == false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x013f, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactStrikethroughSpan()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0151, code lost:
        if (r10.mTextShadowOffsetDx != 0.0f) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0157, code lost:
        if (r10.mTextShadowOffsetDy == 0.0f) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0159, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ShadowStyleSpan(r10.mTextShadowOffsetDx, r10.mTextShadowOffsetDy, r10.mTextShadowRadius, r10.mTextShadowColor)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0176, code lost:
        if (java.lang.Float.isNaN(r10.getEffectiveLineHeight()) != false) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0178, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.CustomLineHeightSpan(r10.getEffectiveLineHeight())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0189, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactTagSpan(r12)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0197, code lost:
        r19 = r4;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x019b, code lost:
        r7 = r7 + 1;
        r4 = r19;
        r5 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01a3, code lost:
        r3 = r3.iterator();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ac, code lost:
        if (r3.hasNext() == false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ae, code lost:
        r4 = (com.facebook.react.views.text.TextLayoutManager.SetSpanOperation) r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b6, code lost:
        if (r4.start != 0) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b8, code lost:
        r5 = 18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01bb, code lost:
        r5 = 34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01bd, code lost:
        r2.setSpan(r4.what, r4.start, r4.end, (r5 & -16711681) | ((r6 << 16) & 16711680));
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01d3, code lost:
        if (r0 == null) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d5, code lost:
        r0.onPostProcessSpannable(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d8, code lost:
        r3 = sSpannableCacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01da, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        sSpannableCache.put(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e0, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e1, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r2 = new android.text.SpannableStringBuilder();
        r3 = new java.util.ArrayList();
        r4 = r22.getArray("fragments");
        r5 = r4.size();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r7 >= r5) goto L_0x01a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.text.Spannable getOrCreateSpannableForText(android.content.Context r21, com.facebook.react.bridge.ReadableMap r22, com.facebook.react.views.text.ReactTextViewManagerCallback r23) {
        /*
            r0 = r23
            java.lang.String r1 = r22.toString()
            java.lang.Object r2 = sSpannableCacheLock
            monitor-enter(r2)
            android.util.LruCache<java.lang.String, android.text.Spannable> r3 = sSpannableCache     // Catch:{ all -> 0x01e5 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x01e5 }
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ all -> 0x01e5 }
            if (r3 == 0) goto L_0x0015
            monitor-exit(r2)     // Catch:{ all -> 0x01e5 }
            return r3
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x01e5 }
            android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "fragments"
            r5 = r22
            com.facebook.react.bridge.ReadableArray r4 = r5.getArray(r4)
            int r5 = r4.size()
            r7 = 0
        L_0x002d:
            if (r7 >= r5) goto L_0x01a3
            com.facebook.react.bridge.ReadableMap r8 = r4.getMap(r7)
            int r9 = r2.length()
            com.facebook.react.views.text.TextAttributeProps r10 = new com.facebook.react.views.text.TextAttributeProps
            com.facebook.react.uimanager.ReactStylesDiffMap r11 = new com.facebook.react.uimanager.ReactStylesDiffMap
            java.lang.String r12 = "textAttributes"
            com.facebook.react.bridge.ReadableMap r12 = r8.getMap(r12)
            r11.<init>(r12)
            r10.<init>(r11)
            java.lang.String r11 = "string"
            java.lang.String r11 = r8.getString(r11)
            com.facebook.react.views.text.TextTransform r12 = r10.mTextTransform
            java.lang.String r11 = com.facebook.react.views.text.TextTransform.apply(r11, r12)
            r2.append(r11)
            int r11 = r2.length()
            java.lang.String r12 = "reactTag"
            int r12 = r8.getInt(r12)
            java.lang.String r13 = "isAttachment"
            boolean r14 = r8.hasKey(r13)
            r15 = -1
            if (r14 == 0) goto L_0x009f
            boolean r13 = r8.getBoolean(r13)
            if (r13 == 0) goto L_0x009f
            java.lang.String r9 = "width"
            double r9 = r8.getDouble(r9)
            float r9 = (float) r9
            float r9 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromSP(r9)
            java.lang.String r10 = "height"
            double r10 = r8.getDouble(r10)
            float r8 = (float) r10
            float r8 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromSP(r8)
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r10 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            int r11 = r2.length()
            int r11 = r11 + r15
            int r13 = r2.length()
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan r14 = new com.facebook.react.views.text.TextInlineViewPlaceholderSpan
            int r9 = (int) r9
            int r8 = (int) r8
            r14.<init>(r12, r9, r8)
            r10.<init>(r11, r13, r14)
            r3.add(r10)
            goto L_0x0197
        L_0x009f:
            if (r11 < r9) goto L_0x0197
            boolean r8 = r10.mIsColorSet
            if (r8 == 0) goto L_0x00b4
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r8 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.ReactForegroundColorSpan r13 = new com.facebook.react.views.text.ReactForegroundColorSpan
            int r14 = r10.mColor
            r13.<init>(r14)
            r8.<init>(r9, r11, r13)
            r3.add(r8)
        L_0x00b4:
            boolean r8 = r10.mIsBackgroundColorSet
            if (r8 == 0) goto L_0x00c7
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r8 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.ReactBackgroundColorSpan r13 = new com.facebook.react.views.text.ReactBackgroundColorSpan
            int r14 = r10.mBackgroundColor
            r13.<init>(r14)
            r8.<init>(r9, r11, r13)
            r3.add(r8)
        L_0x00c7:
            float r8 = r10.getLetterSpacing()
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 != 0) goto L_0x00e2
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r8 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.CustomLetterSpacingSpan r13 = new com.facebook.react.views.text.CustomLetterSpacingSpan
            float r14 = r10.getLetterSpacing()
            r13.<init>(r14)
            r8.<init>(r9, r11, r13)
            r3.add(r8)
        L_0x00e2:
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r8 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.ReactAbsoluteSizeSpan r13 = new com.facebook.react.views.text.ReactAbsoluteSizeSpan
            int r14 = r10.mFontSize
            r13.<init>(r14)
            r8.<init>(r9, r11, r13)
            r3.add(r8)
            int r8 = r10.mFontStyle
            if (r8 != r15) goto L_0x0103
            int r8 = r10.mFontWeight
            if (r8 != r15) goto L_0x0103
            java.lang.String r8 = r10.mFontFamily
            if (r8 == 0) goto L_0x00fe
            goto L_0x0103
        L_0x00fe:
            r19 = r4
            r20 = r5
            goto L_0x012a
        L_0x0103:
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r8 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.CustomStyleSpan r15 = new com.facebook.react.views.text.CustomStyleSpan
            int r14 = r10.mFontStyle
            int r13 = r10.mFontWeight
            java.lang.String r6 = r10.mFontFeatureSettings
            r19 = r4
            java.lang.String r4 = r10.mFontFamily
            android.content.res.AssetManager r18 = r21.getAssets()
            r16 = r13
            r13 = r15
            r20 = r5
            r5 = r15
            r15 = r16
            r16 = r6
            r17 = r4
            r13.<init>(r14, r15, r16, r17, r18)
            r8.<init>(r9, r11, r5)
            r3.add(r8)
        L_0x012a:
            boolean r4 = r10.mIsUnderlineTextDecorationSet
            if (r4 == 0) goto L_0x013b
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r4 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.ReactUnderlineSpan r5 = new com.facebook.react.views.text.ReactUnderlineSpan
            r5.<init>()
            r4.<init>(r9, r11, r5)
            r3.add(r4)
        L_0x013b:
            boolean r4 = r10.mIsLineThroughTextDecorationSet
            if (r4 == 0) goto L_0x014c
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r4 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.ReactStrikethroughSpan r5 = new com.facebook.react.views.text.ReactStrikethroughSpan
            r5.<init>()
            r4.<init>(r9, r11, r5)
            r3.add(r4)
        L_0x014c:
            float r4 = r10.mTextShadowOffsetDx
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0159
            float r4 = r10.mTextShadowOffsetDy
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x016e
        L_0x0159:
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r4 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.ShadowStyleSpan r5 = new com.facebook.react.views.text.ShadowStyleSpan
            float r6 = r10.mTextShadowOffsetDx
            float r8 = r10.mTextShadowOffsetDy
            float r13 = r10.mTextShadowRadius
            int r14 = r10.mTextShadowColor
            r5.<init>(r6, r8, r13, r14)
            r4.<init>(r9, r11, r5)
            r3.add(r4)
        L_0x016e:
            float r4 = r10.getEffectiveLineHeight()
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L_0x0189
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r4 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.CustomLineHeightSpan r5 = new com.facebook.react.views.text.CustomLineHeightSpan
            float r6 = r10.getEffectiveLineHeight()
            r5.<init>(r6)
            r4.<init>(r9, r11, r5)
            r3.add(r4)
        L_0x0189:
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r4 = new com.facebook.react.views.text.TextLayoutManager$SetSpanOperation
            com.facebook.react.views.text.ReactTagSpan r5 = new com.facebook.react.views.text.ReactTagSpan
            r5.<init>(r12)
            r4.<init>(r9, r11, r5)
            r3.add(r4)
            goto L_0x019b
        L_0x0197:
            r19 = r4
            r20 = r5
        L_0x019b:
            int r7 = r7 + 1
            r4 = r19
            r5 = r20
            goto L_0x002d
        L_0x01a3:
            java.util.Iterator r3 = r3.iterator()
            r6 = 0
        L_0x01a8:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01d3
            java.lang.Object r4 = r3.next()
            com.facebook.react.views.text.TextLayoutManager$SetSpanOperation r4 = (com.facebook.react.views.text.TextLayoutManager.SetSpanOperation) r4
            int r5 = r4.start
            if (r5 != 0) goto L_0x01bb
            r5 = 18
            goto L_0x01bd
        L_0x01bb:
            r5 = 34
        L_0x01bd:
            r7 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
            r5 = r5 & r7
            int r7 = r6 << 16
            r8 = 16711680(0xff0000, float:2.3418052E-38)
            r7 = r7 & r8
            r5 = r5 | r7
            com.facebook.react.views.text.ReactSpan r7 = r4.what
            int r8 = r4.start
            int r4 = r4.end
            r2.setSpan(r7, r8, r4, r5)
            int r6 = r6 + 1
            goto L_0x01a8
        L_0x01d3:
            if (r0 == 0) goto L_0x01d8
            r0.onPostProcessSpannable(r2)
        L_0x01d8:
            java.lang.Object r3 = sSpannableCacheLock
            monitor-enter(r3)
            android.util.LruCache<java.lang.String, android.text.Spannable> r0 = sSpannableCache     // Catch:{ all -> 0x01e2 }
            r0.put(r1, r2)     // Catch:{ all -> 0x01e2 }
            monitor-exit(r3)     // Catch:{ all -> 0x01e2 }
            return r2
        L_0x01e2:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x01e2 }
            throw r0
        L_0x01e5:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x01e5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.getOrCreateSpannableForText(android.content.Context, com.facebook.react.bridge.ReadableMap, com.facebook.react.views.text.ReactTextViewManagerCallback):android.text.Spannable");
    }
}
