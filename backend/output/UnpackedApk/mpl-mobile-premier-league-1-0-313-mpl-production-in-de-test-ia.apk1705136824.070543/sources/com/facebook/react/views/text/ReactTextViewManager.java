package com.facebook.react.views.text;

import android.text.Spannable;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.Map;

@ReactModule(name = "RCTText")
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, ReactTextShadowNode> implements IViewManagerWithChildren {
    public static final String REACT_CLASS = "RCTText";
    public ReactTextViewManagerCallback mReactTextViewManagerCallback;

    public Map getExportedCustomDirectEventTypeConstants() {
        return ImageOriginUtils.of("topTextLayout", ImageOriginUtils.of("registrationName", "onTextLayout"), "topInlineViewLayout", ImageOriginUtils.of("registrationName", "onInlineViewLayout"));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<ReactTextShadowNode> getShadowNodeClass() {
        return ReactTextShadowNode.class;
    }

    /* JADX WARNING: type inference failed for: r1v14, types: [android.text.BoringLayout] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long measure(android.content.Context r19, com.facebook.react.bridge.ReadableMap r20, com.facebook.react.bridge.ReadableMap r21, com.facebook.react.bridge.ReadableMap r22, float r23, com.facebook.yoga.YogaMeasureMode r24, float r25, com.facebook.yoga.YogaMeasureMode r26, int[] r27) {
        /*
            r18 = this;
            r0 = r21
            r1 = r23
            r2 = r18
            com.facebook.react.views.text.ReactTextViewManagerCallback r3 = r2.mReactTextViewManagerCallback
            android.text.TextPaint r6 = com.facebook.react.views.text.TextLayoutManager.sTextPaintInstance
            r4 = r19
            r5 = r20
            android.text.Spannable r3 = com.facebook.react.views.text.TextLayoutManager.getOrCreateSpannableForText(r4, r5, r3)
            java.lang.String r4 = "textBreakStrategy"
            java.lang.String r4 = r0.getString(r4)
            int r4 = com.facebook.react.views.text.TextAttributeProps.getTextBreakStrategy(r4)
            android.text.BoringLayout$Metrics r10 = android.text.BoringLayout.isBoring(r3, r6)
            if (r10 != 0) goto L_0x0027
            float r5 = android.text.Layout.getDesiredWidth(r3, r6)
            goto L_0x0029
        L_0x0027:
            r5 = 2143289344(0x7fc00000, float:NaN)
        L_0x0029:
            com.facebook.yoga.YogaMeasureMode r7 = com.facebook.yoga.YogaMeasureMode.UNDEFINED
            r8 = 0
            r12 = 1
            r13 = 0
            r9 = r24
            if (r9 == r7) goto L_0x0039
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r7 = 0
            goto L_0x003a
        L_0x0039:
            r7 = 1
        L_0x003a:
            int r14 = r3.length()
            r11 = 23
            if (r10 != 0) goto L_0x0089
            if (r7 != 0) goto L_0x004e
            boolean r15 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isUndefined(r5)
            if (r15 != 0) goto L_0x0089
            int r15 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r15 > 0) goto L_0x0089
        L_0x004e:
            double r8 = (double) r5
            double r7 = java.lang.Math.ceil(r8)
            int r7 = (int) r7
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 >= r11) goto L_0x0067
            android.text.StaticLayout r1 = new android.text.StaticLayout
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_NORMAL
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r11 = 1
            r4 = r1
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x00da
        L_0x0067:
            android.text.StaticLayout$Builder r1 = android.text.StaticLayout.Builder.obtain(r3, r13, r14, r6, r7)
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            android.text.StaticLayout$Builder r1 = r1.setAlignment(r5)
            r5 = 0
            r6 = 1065353216(0x3f800000, float:1.0)
            android.text.StaticLayout$Builder r1 = r1.setLineSpacing(r5, r6)
            android.text.StaticLayout$Builder r1 = r1.setIncludePad(r12)
            android.text.StaticLayout$Builder r1 = r1.setBreakStrategy(r4)
            android.text.StaticLayout$Builder r1 = r1.setHyphenationFrequency(r12)
            android.text.StaticLayout r1 = r1.build()
            goto L_0x00da
        L_0x0089:
            if (r10 == 0) goto L_0x00a4
            if (r7 != 0) goto L_0x0094
            int r5 = r10.width
            float r5 = (float) r5
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x00a4
        L_0x0094:
            int r1 = r10.width
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_NORMAL
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r11 = 1
            r4 = r3
            r5 = r6
            r6 = r1
            android.text.BoringLayout r1 = android.text.BoringLayout.make(r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x00da
        L_0x00a4:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 >= r11) goto L_0x00b8
            android.text.StaticLayout r15 = new android.text.StaticLayout
            int r7 = (int) r1
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_NORMAL
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r11 = 1
            r4 = r15
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r1 = r15
            goto L_0x00da
        L_0x00b8:
            int r1 = (int) r1
            android.text.StaticLayout$Builder r1 = android.text.StaticLayout.Builder.obtain(r3, r13, r14, r6, r1)
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            android.text.StaticLayout$Builder r1 = r1.setAlignment(r5)
            r5 = 0
            r6 = 1065353216(0x3f800000, float:1.0)
            android.text.StaticLayout$Builder r1 = r1.setLineSpacing(r5, r6)
            android.text.StaticLayout$Builder r1 = r1.setIncludePad(r12)
            android.text.StaticLayout$Builder r1 = r1.setBreakStrategy(r4)
            android.text.StaticLayout$Builder r1 = r1.setHyphenationFrequency(r12)
            android.text.StaticLayout r1 = r1.build()
        L_0x00da:
            java.lang.String r4 = "maximumNumberOfLines"
            boolean r5 = r0.hasKey(r4)
            r6 = -1
            if (r5 == 0) goto L_0x00e8
            int r0 = r0.getInt(r4)
            goto L_0x00e9
        L_0x00e8:
            r0 = -1
        L_0x00e9:
            int r4 = r1.getWidth()
            if (r0 == r6) goto L_0x00fd
            if (r0 == 0) goto L_0x00fd
            int r5 = r1.getLineCount()
            if (r0 >= r5) goto L_0x00fd
            int r0 = r0 - r12
            int r0 = r1.getLineBottom(r0)
            goto L_0x0101
        L_0x00fd:
            int r0 = r1.getHeight()
        L_0x0101:
            r5 = 0
            r7 = 0
        L_0x0103:
            if (r5 >= r14) goto L_0x01ba
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r8 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            int r8 = r3.nextSpanTransition(r5, r14, r8)
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r9 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            java.lang.Object[] r5 = r3.getSpans(r5, r8, r9)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r5 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r5
            int r9 = r5.length
            r10 = 0
        L_0x0115:
            if (r10 >= r9) goto L_0x01b5
            r11 = r5[r10]
            int r15 = r3.getSpanStart(r11)
            int r13 = r1.getLineForOffset(r15)
            int r16 = r1.getEllipsisCount(r13)
            if (r16 <= 0) goto L_0x012a
            r16 = 1
            goto L_0x012c
        L_0x012a:
            r16 = 0
        L_0x012c:
            if (r16 == 0) goto L_0x0146
            int r16 = r1.getLineStart(r13)
            int r17 = r1.getEllipsisStart(r13)
            int r12 = r17 + r16
            if (r15 < r12) goto L_0x0146
            int r12 = r1.getLineEnd(r13)
            if (r15 < r12) goto L_0x0141
            goto L_0x0146
        L_0x0141:
            r22 = r3
            r3 = 1
            goto L_0x01aa
        L_0x0146:
            int r12 = r11.mWidth
            int r11 = r11.mHeight
            boolean r2 = r1.isRtlCharAt(r15)
            r22 = r3
            int r3 = r1.getParagraphDirection(r13)
            if (r3 != r6) goto L_0x0158
            r3 = 1
            goto L_0x0159
        L_0x0158:
            r3 = 0
        L_0x0159:
            int r6 = r14 + -1
            if (r15 != r6) goto L_0x016d
            if (r3 == 0) goto L_0x0167
            float r2 = r1.getLineWidth(r13)
            int r2 = (int) r2
            int r2 = r4 - r2
            goto L_0x018f
        L_0x0167:
            float r2 = r1.getLineRight(r13)
            int r2 = (int) r2
            goto L_0x018c
        L_0x016d:
            if (r3 != r2) goto L_0x0171
            r6 = 1
            goto L_0x0172
        L_0x0171:
            r6 = 0
        L_0x0172:
            if (r6 == 0) goto L_0x0179
            float r6 = r1.getPrimaryHorizontal(r15)
            goto L_0x017d
        L_0x0179:
            float r6 = r1.getSecondaryHorizontal(r15)
        L_0x017d:
            int r6 = (int) r6
            if (r3 == 0) goto L_0x0189
            float r3 = r1.getLineRight(r13)
            int r3 = (int) r3
            int r3 = r3 - r6
            int r3 = r4 - r3
            r6 = r3
        L_0x0189:
            if (r2 == 0) goto L_0x018e
            r2 = r6
        L_0x018c:
            int r2 = r2 - r12
            goto L_0x018f
        L_0x018e:
            r2 = r6
        L_0x018f:
            int r3 = r1.getLineBaseline(r13)
            int r3 = r3 - r11
            int r6 = r7 * 2
            float r3 = (float) r3
            float r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toSPFromPixel(r3)
            int r3 = (int) r3
            r27[r6] = r3
            r3 = 1
            int r6 = r6 + r3
            float r2 = (float) r2
            float r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toSPFromPixel(r2)
            int r2 = (int) r2
            r27[r6] = r2
            int r7 = r7 + 1
        L_0x01aa:
            int r10 = r10 + 1
            r2 = r18
            r3 = r22
            r6 = -1
            r12 = 1
            r13 = 0
            goto L_0x0115
        L_0x01b5:
            r2 = r18
            r5 = r8
            goto L_0x0103
        L_0x01ba:
            float r1 = (float) r4
            float r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toSPFromPixel(r1)
            float r0 = (float) r0
            float r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toSPFromPixel(r0)
            long r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.make(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextViewManager.measure(android.content.Context, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode, int[]):long");
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public ReactTextShadowNode createShadowNodeInstance() {
        return new ReactTextShadowNode();
    }

    public ReactTextView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactTextView(themedReactContext);
    }

    public void onAfterUpdateTransaction(ReactTextView reactTextView) {
        super.onAfterUpdateTransaction(reactTextView);
        reactTextView.setEllipsize((reactTextView.mNumberOfLines == Integer.MAX_VALUE || reactTextView.mAdjustsFontSizeToFit) ? null : reactTextView.mEllipsizeLocation);
    }

    public void setPadding(ReactTextView reactTextView, int i, int i2, int i3, int i4) {
        reactTextView.setPadding(i, i2, i3, i4);
    }

    public void updateExtraData(ReactTextView reactTextView, Object obj) {
        ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
        if (reactTextUpdate.mContainsImages) {
            TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.mText, reactTextView);
        }
        reactTextView.setText(reactTextUpdate);
    }

    public Object updateState(ReactTextView reactTextView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        ReadableNativeMap state = stateWrapper.getState();
        ReadableNativeMap map = state.getMap((String) "attributedString");
        ReadableNativeMap map2 = state.getMap((String) "paragraphAttributes");
        Spannable orCreateSpannableForText = TextLayoutManager.getOrCreateSpannableForText(reactTextView.getContext(), map, this.mReactTextViewManagerCallback);
        reactTextView.setSpanned(orCreateSpannableForText);
        ReactTextUpdate reactTextUpdate = new ReactTextUpdate(orCreateSpannableForText, state.hasKey("mostRecentEventCount") ? state.getInt("mostRecentEventCount") : -1, false, TextAttributeProps.getTextAlignment(reactStylesDiffMap), TextAttributeProps.getTextBreakStrategy(map2.getString("textBreakStrategy")), TextAttributeProps.getJustificationMode(reactStylesDiffMap));
        return reactTextUpdate;
    }

    public ReactTextShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextShadowNode(reactTextViewManagerCallback);
    }
}
