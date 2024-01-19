package com.freshchat.consumer.sdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.List;

public class FlowLayout extends ViewGroup {
    public static final String md = FlowLayout.class.getSimpleName();
    public boolean me;
    public int mf;
    public int mg;
    public int mh;
    public float mi;
    public float mj;
    public boolean mk;
    public int ml;
    public int mm;
    public int mn;
    public int mo;
    public List<Float> mp;
    public List<Integer> mq;
    public List<Integer> mr;
    public List<Integer> ms;

    public FlowLayout(Context context) {
        this(context, null);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x009d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x005a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0070 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowLayout(android.content.Context r9, android.util.AttributeSet r10) {
        /*
            r8 = this;
            r8.<init>(r9, r10)
            r0 = 1
            r8.me = r0
            r1 = 0
            r8.mf = r1
            r8.mg = r1
            r2 = -65538(0xfffffffffffefffe, float:NaN)
            r8.mh = r2
            r3 = 0
            r8.mi = r3
            r8.mj = r3
            r8.mk = r1
            r4 = 2147483647(0x7fffffff, float:NaN)
            r8.ml = r4
            r5 = -1
            r8.mm = r5
            r6 = -65536(0xffffffffffff0000, float:NaN)
            r8.mn = r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.mp = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.mq = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.mr = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.ms = r7
            android.content.res.Resources$Theme r9 = r9.getTheme()
            int[] r7 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout
            android.content.res.TypedArray r9 = r9.obtainStyledAttributes(r10, r7, r1, r1)
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlFlow     // Catch:{ all -> 0x00cd }
            boolean r10 = r9.getBoolean(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.me = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlChildSpacing     // Catch:{ NumberFormatException -> 0x005a }
            int r10 = r9.getInt(r10, r1)     // Catch:{ NumberFormatException -> 0x005a }
            r8.mf = r10     // Catch:{ NumberFormatException -> 0x005a }
            goto L_0x0067
        L_0x005a:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlChildSpacing     // Catch:{ all -> 0x00cd }
            float r0 = r8.a(r3)     // Catch:{ all -> 0x00cd }
            int r0 = (int) r0     // Catch:{ all -> 0x00cd }
            int r10 = r9.getDimensionPixelSize(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mf = r10     // Catch:{ all -> 0x00cd }
        L_0x0067:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlMinChildSpacing     // Catch:{ NumberFormatException -> 0x0070 }
            int r10 = r9.getInt(r10, r1)     // Catch:{ NumberFormatException -> 0x0070 }
            r8.mg = r10     // Catch:{ NumberFormatException -> 0x0070 }
            goto L_0x007d
        L_0x0070:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlMinChildSpacing     // Catch:{ all -> 0x00cd }
            float r0 = r8.a(r3)     // Catch:{ all -> 0x00cd }
            int r0 = (int) r0     // Catch:{ all -> 0x00cd }
            int r10 = r9.getDimensionPixelSize(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mg = r10     // Catch:{ all -> 0x00cd }
        L_0x007d:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlChildSpacingForLastRow     // Catch:{ NumberFormatException -> 0x0086 }
            int r10 = r9.getInt(r10, r2)     // Catch:{ NumberFormatException -> 0x0086 }
            r8.mh = r10     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0093
        L_0x0086:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlChildSpacingForLastRow     // Catch:{ all -> 0x00cd }
            float r0 = r8.a(r3)     // Catch:{ all -> 0x00cd }
            int r0 = (int) r0     // Catch:{ all -> 0x00cd }
            int r10 = r9.getDimensionPixelSize(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mh = r10     // Catch:{ all -> 0x00cd }
        L_0x0093:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlRowSpacing     // Catch:{ NumberFormatException -> 0x009d }
            int r10 = r9.getInt(r10, r1)     // Catch:{ NumberFormatException -> 0x009d }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x009d }
            r8.mi = r10     // Catch:{ NumberFormatException -> 0x009d }
            goto L_0x00a9
        L_0x009d:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlRowSpacing     // Catch:{ all -> 0x00cd }
            float r0 = r8.a(r3)     // Catch:{ all -> 0x00cd }
            float r10 = r9.getDimension(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mi = r10     // Catch:{ all -> 0x00cd }
        L_0x00a9:
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlMaxRows     // Catch:{ all -> 0x00cd }
            int r10 = r9.getInt(r10, r4)     // Catch:{ all -> 0x00cd }
            r8.ml = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlRtl     // Catch:{ all -> 0x00cd }
            boolean r10 = r9.getBoolean(r10, r1)     // Catch:{ all -> 0x00cd }
            r8.mk = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_android_gravity     // Catch:{ all -> 0x00cd }
            int r10 = r9.getInt(r10, r5)     // Catch:{ all -> 0x00cd }
            r8.mm = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.freshchat.consumer.sdk.R.styleable.freshchatFlowLayout_freshchatFlRowVerticalGravity     // Catch:{ all -> 0x00cd }
            int r10 = r9.getInt(r10, r6)     // Catch:{ all -> 0x00cd }
            r8.mn = r10     // Catch:{ all -> 0x00cd }
            r9.recycle()
            return
        L_0x00cd:
            r10 = move-exception
            r9.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.ui.FlowLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private int a(int i, int i2, int i3, int i4) {
        if (this.mf == -65536 || i4 >= this.mr.size() || i4 >= this.ms.size() || this.ms.get(i4).intValue() <= 0) {
            return 0;
        }
        if (i == 1) {
            return ((i2 - i3) - this.mr.get(i4).intValue()) / 2;
        }
        if (i != 5) {
            return 0;
        }
        return (i2 - i3) - this.mr.get(i4).intValue();
    }

    private float b(int i, int i2, int i3, int i4) {
        if (i != -65536) {
            return (float) i;
        }
        if (i4 > 1) {
            return (float) ((i2 - i3) / (i4 - 1));
        }
        return 0.0f;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.mf;
    }

    public int getChildSpacingForLastRow() {
        return this.mh;
    }

    public int getMaxRows() {
        return this.ml;
    }

    public int getMinChildSpacing() {
        return this.mg;
    }

    public float getRowSpacing() {
        return this.mi;
    }

    public int getRowsCount() {
        return this.ms.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r0 = r22
            int r1 = r22.getPaddingLeft()
            int r2 = r22.getPaddingRight()
            int r3 = r22.getPaddingTop()
            int r4 = r22.getPaddingBottom()
            boolean r5 = r0.mk
            if (r5 == 0) goto L_0x001c
            int r5 = r22.getWidth()
            int r5 = r5 - r2
            goto L_0x001d
        L_0x001c:
            r5 = r1
        L_0x001d:
            int r6 = r0.mm
            r7 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 & 7
            r8 = 80
            r9 = 16
            if (r7 == r9) goto L_0x0034
            if (r7 == r8) goto L_0x002c
            goto L_0x003e
        L_0x002c:
            int r7 = r27 - r25
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.mo
            int r7 = r7 - r4
            goto L_0x003d
        L_0x0034:
            int r7 = r27 - r25
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.mo
            int r7 = r7 - r4
            int r7 = r7 / 2
        L_0x003d:
            int r3 = r3 + r7
        L_0x003e:
            int r4 = r1 + r2
            int r7 = r26 - r24
            r8 = 0
            int r8 = r0.a(r6, r7, r4, r8)
            int r5 = r5 + r8
            int r8 = r0.mn
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.util.List<java.lang.Integer> r9 = r0.ms
            int r9 = r9.size()
            r10 = 0
            r11 = 0
        L_0x0054:
            if (r10 >= r9) goto L_0x0167
            java.util.List<java.lang.Integer> r12 = r0.ms
            java.lang.Object r12 = r12.get(r10)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            java.util.List<java.lang.Integer> r13 = r0.mq
            java.lang.Object r13 = r13.get(r10)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            java.util.List<java.lang.Float> r14 = r0.mp
            java.lang.Object r14 = r14.get(r10)
            java.lang.Float r14 = (java.lang.Float) r14
            float r14 = r14.floatValue()
            r15 = 0
        L_0x007b:
            r23 = r1
            if (r15 >= r12) goto L_0x0136
            int r1 = r22.getChildCount()
            if (r11 >= r1) goto L_0x0136
            int r1 = r11 + 1
            android.view.View r11 = r0.getChildAt(r11)
            r24 = r1
            int r1 = r11.getVisibility()
            r25 = r9
            r9 = 8
            if (r1 != r9) goto L_0x009e
            r1 = r23
            r11 = r24
            r9 = r25
            goto L_0x007b
        L_0x009e:
            int r15 = r15 + 1
            android.view.ViewGroup$LayoutParams r1 = r11.getLayoutParams()
            boolean r9 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r9 == 0) goto L_0x00c5
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r9 = r1.leftMargin
            r26 = r9
            int r9 = r1.rightMargin
            r27 = r9
            int r9 = r1.topMargin
            int r1 = r1.bottomMargin
            r16 = r4
            r20 = r12
            r12 = r26
            r26 = r20
            r21 = r15
            r15 = r27
            r27 = r21
            goto L_0x00d3
        L_0x00c5:
            r1 = 0
            r9 = 0
            r16 = 0
            r17 = 0
            r16 = r4
            r26 = r12
            r27 = r15
            r12 = 0
            r15 = 0
        L_0x00d3:
            int r4 = r11.getMeasuredWidth()
            int r17 = r11.getMeasuredHeight()
            int r18 = r3 + r9
            r19 = r6
            r6 = 80
            if (r8 != r6) goto L_0x00e9
            int r6 = r3 + r13
            int r6 = r6 - r1
            int r6 = r6 - r17
            goto L_0x00f8
        L_0x00e9:
            r6 = 16
            if (r8 != r6) goto L_0x00f6
            int r6 = r13 - r9
            int r6 = r6 - r1
            int r6 = r6 - r17
            int r6 = r6 / 2
            int r18 = r6 + r18
        L_0x00f6:
            r6 = r18
        L_0x00f8:
            int r1 = r6 + r17
            boolean r9 = r0.mk
            if (r9 == 0) goto L_0x0111
            int r9 = r5 - r15
            r17 = r8
            int r8 = r9 - r4
            r11.layout(r8, r6, r9, r1)
            float r1 = (float) r5
            float r4 = (float) r4
            float r4 = r4 + r14
            float r5 = (float) r12
            float r4 = r4 + r5
            float r5 = (float) r15
            float r4 = r4 + r5
            float r1 = r1 - r4
            int r1 = (int) r1
            goto L_0x0123
        L_0x0111:
            r17 = r8
            int r8 = r5 + r12
            int r9 = r8 + r4
            r11.layout(r8, r6, r9, r1)
            float r1 = (float) r5
            float r4 = (float) r4
            float r4 = r4 + r14
            float r5 = (float) r12
            float r4 = r4 + r5
            float r5 = (float) r15
            float r4 = r4 + r5
            float r4 = r4 + r1
            int r1 = (int) r4
        L_0x0123:
            r5 = r1
            r1 = r23
            r11 = r24
            r9 = r25
            r12 = r26
            r15 = r27
            r4 = r16
            r8 = r17
            r6 = r19
            goto L_0x007b
        L_0x0136:
            r16 = r4
            r19 = r6
            r17 = r8
            r25 = r9
            boolean r1 = r0.mk
            if (r1 == 0) goto L_0x0148
            int r1 = r22.getWidth()
            int r1 = r1 - r2
            goto L_0x014a
        L_0x0148:
            r1 = r23
        L_0x014a:
            int r10 = r10 + 1
            r5 = r16
            r4 = r19
            int r6 = r0.a(r4, r7, r5, r10)
            int r1 = r1 + r6
            float r3 = (float) r3
            float r6 = (float) r13
            float r8 = r0.mj
            float r6 = r6 + r8
            float r6 = r6 + r3
            int r3 = (int) r6
            r9 = r25
            r6 = r4
            r4 = r5
            r8 = r17
            r5 = r1
            r1 = r23
            goto L_0x0054
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.ui.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x021d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0263  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r27, int r28) {
        /*
            r26 = this;
            r6 = r26
            super.onMeasure(r27, r28)
            int r7 = android.view.View.MeasureSpec.getSize(r27)
            int r8 = android.view.View.MeasureSpec.getMode(r27)
            int r9 = android.view.View.MeasureSpec.getSize(r28)
            int r10 = android.view.View.MeasureSpec.getMode(r28)
            java.util.List<java.lang.Float> r0 = r6.mp
            r0.clear()
            java.util.List<java.lang.Integer> r0 = r6.mq
            r0.clear()
            java.util.List<java.lang.Integer> r0 = r6.mr
            r0.clear()
            java.util.List<java.lang.Integer> r0 = r6.ms
            r0.clear()
            int r11 = r26.getChildCount()
            int r0 = r26.getPaddingLeft()
            int r0 = r7 - r0
            int r1 = r26.getPaddingRight()
            int r12 = r0 - r1
            if (r8 == 0) goto L_0x0041
            boolean r0 = r6.me
            if (r0 == 0) goto L_0x0041
            r15 = 1
            goto L_0x0042
        L_0x0041:
            r15 = 0
        L_0x0042:
            int r0 = r6.mf
            r5 = -65536(0xffffffffffff0000, float:NaN)
            if (r0 != r5) goto L_0x004c
            if (r8 != 0) goto L_0x004c
            r4 = 0
            goto L_0x004f
        L_0x004c:
            int r0 = r6.mf
            r4 = r0
        L_0x004f:
            if (r4 != r5) goto L_0x0055
            int r0 = r6.mg
            float r0 = (float) r0
            goto L_0x0056
        L_0x0055:
            float r0 = (float) r4
        L_0x0056:
            r3 = r0
            r0 = 0
            r1 = 0
            r2 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
        L_0x0060:
            if (r2 >= r11) goto L_0x016a
            r18 = r3
            android.view.View r3 = r6.getChildAt(r2)
            int r5 = r3.getVisibility()
            r20 = r0
            r0 = 8
            if (r5 != r0) goto L_0x008c
            r0 = r27
            r23 = r2
            r5 = r4
            r21 = r8
            r24 = r10
            r22 = r11
            r10 = r18
            r8 = -65536(0xffffffffffff0000, float:NaN)
            r2 = r1
            r18 = r7
            r7 = r20
            r1 = r28
            r20 = r9
            goto L_0x0155
        L_0x008c:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            boolean r0 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto L_0x00d1
            r21 = 0
            r22 = r11
            r11 = r20
            r0 = r26
            r20 = r9
            r9 = r1
            r1 = r3
            r23 = r2
            r2 = r27
            r24 = r10
            r10 = r18
            r18 = r7
            r7 = r3
            r3 = r21
            r25 = r4
            r4 = r28
            r19 = r5
            r21 = r8
            r8 = -65536(0xffffffffffff0000, float:NaN)
            r5 = r16
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            r5 = r19
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            int r0 = r5.leftMargin
            int r1 = r5.rightMargin
            int r0 = r0 + r1
            int r1 = r5.topMargin
            int r2 = r5.bottomMargin
            int r1 = r1 + r2
            r2 = r0
            r3 = r1
            r0 = r27
            r1 = r28
            goto L_0x00f0
        L_0x00d1:
            r0 = r27
            r23 = r2
            r25 = r4
            r21 = r8
            r24 = r10
            r22 = r11
            r10 = r18
            r11 = r20
            r8 = -65536(0xffffffffffff0000, float:NaN)
            r18 = r7
            r20 = r9
            r9 = r1
            r7 = r3
            r1 = r28
            r6.measureChild(r7, r0, r1)
            r2 = 0
            r3 = 0
        L_0x00f0:
            int r4 = r7.getMeasuredWidth()
            int r2 = r2 + r4
            int r4 = r7.getMeasuredHeight()
            int r4 = r4 + r3
            if (r15 == 0) goto L_0x0145
            int r3 = r14 + r2
            if (r3 <= r12) goto L_0x0145
            java.util.List<java.lang.Float> r3 = r6.mp
            r5 = r25
            float r7 = r6.b(r5, r12, r9, r11)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            r3.add(r7)
            java.util.List<java.lang.Integer> r3 = r6.ms
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            r3.add(r7)
            java.util.List<java.lang.Integer> r3 = r6.mq
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)
            r3.add(r7)
            java.util.List<java.lang.Integer> r3 = r6.mr
            int r7 = (int) r10
            int r9 = r14 - r7
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r3.add(r9)
            java.util.List<java.lang.Float> r3 = r6.mp
            int r3 = r3.size()
            int r9 = r6.ml
            if (r3 > r9) goto L_0x013b
            r3 = r17
            int r16 = r16 + r3
        L_0x013b:
            int r13 = java.lang.Math.max(r13, r14)
            int r14 = r2 + r7
            r17 = r4
            r7 = 1
            goto L_0x0155
        L_0x0145:
            r3 = r17
            r5 = r25
            int r7 = r11 + 1
            float r11 = (float) r14
            float r14 = (float) r2
            float r14 = r14 + r10
            float r14 = r14 + r11
            int r14 = (int) r14
            int r2 = r2 + r9
            int r17 = java.lang.Math.max(r3, r4)
        L_0x0155:
            int r3 = r23 + 1
            r1 = r2
            r2 = r3
            r4 = r5
            r0 = r7
            r3 = r10
            r7 = r18
            r9 = r20
            r8 = r21
            r11 = r22
            r10 = r24
            r5 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x0060
        L_0x016a:
            r11 = r0
            r5 = r4
            r18 = r7
            r21 = r8
            r20 = r9
            r24 = r10
            r8 = -65536(0xffffffffffff0000, float:NaN)
            r9 = r1
            r10 = r3
            r3 = r17
            int r0 = r6.mh
            r1 = -65537(0xfffffffffffeffff, float:NaN)
            if (r0 != r1) goto L_0x0196
            java.util.List<java.lang.Float> r0 = r6.mp
            int r0 = r0.size()
            r1 = 1
            if (r0 < r1) goto L_0x01a9
            java.util.List<java.lang.Float> r0 = r6.mp
            int r2 = r0.size()
            int r2 = r2 - r1
            java.lang.Object r1 = r0.get(r2)
            goto L_0x01b3
        L_0x0196:
            r1 = -65538(0xfffffffffffefffe, float:NaN)
            if (r0 == r1) goto L_0x01a9
            java.util.List<java.lang.Float> r1 = r6.mp
            float r0 = r6.b(r0, r12, r9, r11)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r1.add(r0)
            goto L_0x01b6
        L_0x01a9:
            java.util.List<java.lang.Float> r0 = r6.mp
            float r1 = r6.b(r5, r12, r9, r11)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
        L_0x01b3:
            r0.add(r1)
        L_0x01b6:
            java.util.List<java.lang.Integer> r0 = r6.ms
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            r0.add(r1)
            java.util.List<java.lang.Integer> r0 = r6.mq
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.add(r1)
            java.util.List<java.lang.Integer> r0 = r6.mr
            int r1 = (int) r10
            int r1 = r14 - r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            java.util.List<java.lang.Float> r0 = r6.mp
            int r0 = r0.size()
            int r1 = r6.ml
            if (r0 > r1) goto L_0x01e0
            int r16 = r16 + r3
        L_0x01e0:
            int r0 = java.lang.Math.max(r13, r14)
            if (r5 != r8) goto L_0x01ea
            r0 = r18
            r1 = r0
            goto L_0x01fd
        L_0x01ea:
            int r1 = r26.getPaddingLeft()
            int r1 = r1 + r0
            int r0 = r26.getPaddingRight()
            int r0 = r0 + r1
            r1 = r18
            if (r21 != 0) goto L_0x01f9
            goto L_0x01fd
        L_0x01f9:
            int r0 = java.lang.Math.min(r0, r1)
        L_0x01fd:
            int r2 = r26.getPaddingTop()
            int r3 = r26.getPaddingBottom()
            int r3 = r3 + r2
            int r3 = r3 + r16
            java.util.List<java.lang.Float> r2 = r6.mp
            int r2 = r2.size()
            int r4 = r6.ml
            int r2 = java.lang.Math.min(r2, r4)
            float r4 = r6.mi
            r5 = 0
            r7 = -947912704(0xffffffffc7800000, float:-65536.0)
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x0221
            if (r24 != 0) goto L_0x0221
            r4 = 0
            goto L_0x0223
        L_0x0221:
            float r4 = r6.mi
        L_0x0223:
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0238
            r7 = 1
            if (r2 <= r7) goto L_0x0232
            int r9 = r20 - r3
            int r2 = r2 - r7
            int r9 = r9 / r2
            float r2 = (float) r9
            r6.mj = r2
            goto L_0x0234
        L_0x0232:
            r6.mj = r5
        L_0x0234:
            r3 = r20
            r4 = r3
            goto L_0x0252
        L_0x0238:
            r7 = 1
            r6.mj = r4
            if (r2 <= r7) goto L_0x0250
            float r3 = (float) r3
            int r2 = r2 - r7
            float r2 = (float) r2
            float r4 = r4 * r2
            float r4 = r4 + r3
            int r2 = (int) r4
            if (r24 != 0) goto L_0x0248
            r3 = r2
            goto L_0x0250
        L_0x0248:
            r4 = r20
            int r2 = java.lang.Math.min(r2, r4)
            r3 = r2
            goto L_0x0252
        L_0x0250:
            r4 = r20
        L_0x0252:
            r6.mo = r3
            r2 = 1073741824(0x40000000, float:2.0)
            r5 = r21
            if (r5 != r2) goto L_0x025c
            r7 = r1
            goto L_0x025d
        L_0x025c:
            r7 = r0
        L_0x025d:
            r0 = r24
            if (r0 != r2) goto L_0x0263
            r9 = r4
            goto L_0x0264
        L_0x0263:
            r9 = r3
        L_0x0264:
            r6.setMeasuredDimension(r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.ui.FlowLayout.onMeasure(int, int):void");
    }

    public void setChildSpacing(int i) {
        this.mf = i;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i) {
        this.mh = i;
        requestLayout();
    }

    public void setFlow(boolean z) {
        this.me = z;
        requestLayout();
    }

    public void setGravity(int i) {
        if (this.mm != i) {
            this.mm = i;
            requestLayout();
        }
    }

    public void setMaxRows(int i) {
        this.ml = i;
        requestLayout();
    }

    public void setMinChildSpacing(int i) {
        this.mg = i;
        requestLayout();
    }

    public void setRowSpacing(float f2) {
        this.mi = f2;
        requestLayout();
    }

    public void setRowVerticalGravity(int i) {
        if (this.mn != i) {
            this.mn = i;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.mk = z;
        requestLayout();
    }
}
