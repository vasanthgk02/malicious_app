package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;

public class LinearLayoutCompat extends ViewGroup {
    public boolean mBaselineAligned;
    public int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i = this.mBaselineAlignedChildIndex;
        if (childCount > i) {
            View childAt = getChildAt(i);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i2 = this.mBaselineChildTop;
                if (this.mOrientation == 1) {
                    int i3 = this.mGravity & 112;
                    if (i3 != 48) {
                        if (i3 == 16) {
                            i2 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                        } else if (i3 == 80) {
                            i2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                        }
                    }
                }
                return i2 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount() {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset() {
        return 0;
    }

    public int getNextLocationOffset() {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public boolean hasDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            if ((this.mShowDividers & 1) != 0) {
                z = true;
            }
            return z;
        } else if (i == getChildCount()) {
            if ((this.mShowDividers & 4) != 0) {
                z = true;
            }
            return z;
        } else {
            if ((this.mShowDividers & 2) != 0) {
                int i2 = i - 1;
                while (true) {
                    if (i2 < 0) {
                        break;
                    } else if (getChildAt(i2).getVisibility() != 8) {
                        z = true;
                        break;
                    } else {
                        i2--;
                    }
                }
            }
            return z;
        }
    }

    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public int measureNullChild() {
        return 0;
    }

    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.mDivider != null) {
            int i6 = 0;
            if (this.mOrientation == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i6 < virtualChildCount) {
                    View childAt = getChildAt(i6);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i6))) {
                        drawHorizontalDivider(canvas, (childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin) - this.mDividerHeight);
                    }
                    i6++;
                }
                if (hasDividerBeforeChildAt(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        i5 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
                    } else {
                        i5 = childAt2.getBottom() + ((LayoutParams) childAt2.getLayoutParams()).bottomMargin;
                    }
                    drawHorizontalDivider(canvas, i5);
                }
            } else {
                int virtualChildCount2 = getVirtualChildCount();
                boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                while (i6 < virtualChildCount2) {
                    View childAt3 = getChildAt(i6);
                    if (!(childAt3 == null || childAt3.getVisibility() == 8 || !hasDividerBeforeChildAt(i6))) {
                        LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                        if (isLayoutRtl) {
                            i4 = childAt3.getRight() + layoutParams.rightMargin;
                        } else {
                            i4 = (childAt3.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                        }
                        drawVerticalDivider(canvas, i4);
                    }
                    i6++;
                }
                if (hasDividerBeforeChildAt(virtualChildCount2)) {
                    View childAt4 = getChildAt(virtualChildCount2 - 1);
                    if (childAt4 != null) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                        if (isLayoutRtl) {
                            i3 = childAt4.getLeft() - layoutParams2.leftMargin;
                            i2 = this.mDividerWidth;
                        } else {
                            i = childAt4.getRight() + layoutParams2.rightMargin;
                            drawVerticalDivider(canvas, i);
                        }
                    } else if (isLayoutRtl) {
                        i = getPaddingLeft();
                        drawVerticalDivider(canvas, i);
                    } else {
                        i3 = getWidth() - getPaddingRight();
                        i2 = this.mDividerWidth;
                    }
                    i = i3 - i2;
                    drawVerticalDivider(canvas, i);
                }
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.mOrientation
            r2 = 80
            r3 = 16
            r4 = 8
            r5 = 5
            r6 = 8388615(0x800007, float:1.1754953E-38)
            r7 = 1
            if (r1 != r7) goto L_0x00c3
            int r1 = r17.getPaddingLeft()
            int r8 = r21 - r19
            int r9 = r17.getPaddingRight()
            int r9 = r8 - r9
            int r8 = r8 - r1
            int r10 = r17.getPaddingRight()
            int r8 = r8 - r10
            int r10 = r17.getVirtualChildCount()
            int r11 = r0.mGravity
            r12 = r11 & 112(0x70, float:1.57E-43)
            r6 = r6 & r11
            if (r12 == r3) goto L_0x0041
            if (r12 == r2) goto L_0x0035
            int r2 = r17.getPaddingTop()
            goto L_0x004d
        L_0x0035:
            int r2 = r17.getPaddingTop()
            int r2 = r2 + r22
            int r2 = r2 - r20
            int r3 = r0.mTotalLength
            int r2 = r2 - r3
            goto L_0x004d
        L_0x0041:
            int r2 = r17.getPaddingTop()
            int r3 = r22 - r20
            int r11 = r0.mTotalLength
            int r3 = r3 - r11
            int r3 = r3 / 2
            int r2 = r2 + r3
        L_0x004d:
            r3 = 0
        L_0x004e:
            if (r3 >= r10) goto L_0x01e3
            android.view.View r11 = r0.getChildAt(r3)
            if (r11 != 0) goto L_0x005c
            int r4 = r17.measureNullChild()
            int r4 = r4 + r2
            goto L_0x00bd
        L_0x005c:
            int r12 = r11.getVisibility()
            if (r12 == r4) goto L_0x00be
            int r4 = r11.getMeasuredWidth()
            int r12 = r11.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r13 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r13
            int r14 = r13.gravity
            if (r14 >= 0) goto L_0x0075
            r14 = r6
        L_0x0075:
            int r15 = androidx.core.view.ViewCompat.getLayoutDirection(r17)
            int r14 = android.view.Gravity.getAbsoluteGravity(r14, r15)
            r14 = r14 & 7
            if (r14 == r7) goto L_0x008c
            if (r14 == r5) goto L_0x0087
            int r5 = r13.leftMargin
            int r5 = r5 + r1
            goto L_0x0097
        L_0x0087:
            int r5 = r9 - r4
            int r14 = r13.rightMargin
            goto L_0x0096
        L_0x008c:
            int r5 = r8 - r4
            int r5 = r5 / 2
            int r5 = r5 + r1
            int r14 = r13.leftMargin
            int r5 = r5 + r14
            int r14 = r13.rightMargin
        L_0x0096:
            int r5 = r5 - r14
        L_0x0097:
            boolean r14 = r0.hasDividerBeforeChildAt(r3)
            if (r14 == 0) goto L_0x00a0
            int r14 = r0.mDividerHeight
            int r2 = r2 + r14
        L_0x00a0:
            int r14 = r13.topMargin
            int r2 = r2 + r14
            int r14 = r17.getLocationOffset()
            int r14 = r14 + r2
            int r4 = r4 + r5
            int r15 = r12 + r14
            r11.layout(r5, r14, r4, r15)
            int r4 = r13.bottomMargin
            int r12 = r12 + r4
            int r4 = r17.getNextLocationOffset()
            int r4 = r4 + r12
            int r4 = r4 + r2
            int r2 = r17.getChildrenSkipCount()
            int r2 = r2 + r3
            r3 = r2
        L_0x00bd:
            r2 = r4
        L_0x00be:
            int r3 = r3 + r7
            r4 = 8
            r5 = 5
            goto L_0x004e
        L_0x00c3:
            boolean r1 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r17)
            int r2 = r17.getPaddingTop()
            int r3 = r22 - r20
            int r4 = r17.getPaddingBottom()
            int r4 = r3 - r4
            int r3 = r3 - r2
            int r5 = r17.getPaddingBottom()
            int r3 = r3 - r5
            int r5 = r17.getVirtualChildCount()
            int r8 = r0.mGravity
            r6 = r6 & r8
            r8 = r8 & 112(0x70, float:1.57E-43)
            boolean r9 = r0.mBaselineAligned
            int[] r10 = r0.mMaxAscent
            int[] r11 = r0.mMaxDescent
            int r12 = r17.getLayoutDirection()
            int r6 = android.view.Gravity.getAbsoluteGravity(r6, r12)
            if (r6 == r7) goto L_0x0106
            r7 = 5
            if (r6 == r7) goto L_0x00fa
            int r6 = r17.getPaddingLeft()
            goto L_0x0112
        L_0x00fa:
            int r6 = r17.getPaddingLeft()
            int r6 = r6 + r21
            int r6 = r6 - r19
            int r7 = r0.mTotalLength
            int r6 = r6 - r7
            goto L_0x0112
        L_0x0106:
            int r6 = r17.getPaddingLeft()
            int r7 = r21 - r19
            int r12 = r0.mTotalLength
            int r7 = r7 - r12
            int r7 = r7 / 2
            int r6 = r6 + r7
        L_0x0112:
            if (r1 == 0) goto L_0x0119
            int r1 = r5 + -1
            r7 = 0
            r12 = -1
            goto L_0x011c
        L_0x0119:
            r7 = 0
            r12 = 1
            r1 = 0
        L_0x011c:
            if (r7 >= r5) goto L_0x01e3
            int r13 = r12 * r7
            int r13 = r13 + r1
            android.view.View r14 = r0.getChildAt(r13)
            if (r14 != 0) goto L_0x0130
            int r13 = r17.measureNullChild()
            int r6 = r6 + r13
            r18 = r1
            goto L_0x01cd
        L_0x0130:
            int r15 = r14.getVisibility()
            r18 = r1
            r1 = 8
            if (r15 == r1) goto L_0x01cd
            int r1 = r14.getMeasuredWidth()
            int r15 = r14.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r16 = r14.getLayoutParams()
            r20 = r5
            r5 = r16
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            if (r9 == 0) goto L_0x015c
            r22 = r8
            int r8 = r5.height
            r16 = r9
            r9 = -1
            if (r8 == r9) goto L_0x0160
            int r8 = r14.getBaseline()
            goto L_0x0161
        L_0x015c:
            r22 = r8
            r16 = r9
        L_0x0160:
            r8 = -1
        L_0x0161:
            int r9 = r5.gravity
            if (r9 >= 0) goto L_0x0167
            r9 = r22
        L_0x0167:
            r9 = r9 & 112(0x70, float:1.57E-43)
            r19 = r12
            r12 = 16
            if (r9 == r12) goto L_0x019a
            r12 = 48
            if (r9 == r12) goto L_0x018c
            r12 = 80
            if (r9 == r12) goto L_0x0179
            r9 = r2
            goto L_0x01a6
        L_0x0179:
            int r9 = r4 - r15
            int r12 = r5.bottomMargin
            int r9 = r9 - r12
            r12 = -1
            if (r8 == r12) goto L_0x01a6
            int r12 = r14.getMeasuredHeight()
            int r12 = r12 - r8
            r8 = 2
            r8 = r11[r8]
            int r8 = r8 - r12
            int r9 = r9 - r8
            goto L_0x01a6
        L_0x018c:
            r9 = -1
            int r12 = r5.topMargin
            int r12 = r12 + r2
            if (r8 == r9) goto L_0x0198
            r9 = 1
            r9 = r10[r9]
            int r9 = r9 - r8
            int r9 = r9 + r12
            goto L_0x01a6
        L_0x0198:
            r9 = r12
            goto L_0x01a6
        L_0x019a:
            int r8 = r3 - r15
            int r8 = r8 / 2
            int r8 = r8 + r2
            int r9 = r5.topMargin
            int r8 = r8 + r9
            int r9 = r5.bottomMargin
            int r9 = r8 - r9
        L_0x01a6:
            boolean r8 = r0.hasDividerBeforeChildAt(r13)
            if (r8 == 0) goto L_0x01af
            int r8 = r0.mDividerWidth
            int r6 = r6 + r8
        L_0x01af:
            int r8 = r5.leftMargin
            int r6 = r6 + r8
            int r8 = r17.getLocationOffset()
            int r8 = r8 + r6
            int r12 = r1 + r8
            int r15 = r15 + r9
            r14.layout(r8, r9, r12, r15)
            int r5 = r5.rightMargin
            int r1 = r1 + r5
            int r5 = r17.getNextLocationOffset()
            int r5 = r5 + r1
            int r5 = r5 + r6
            int r1 = r17.getChildrenSkipCount()
            int r7 = r7 + r1
            r6 = r5
            goto L_0x01d5
        L_0x01cd:
            r20 = r5
            r22 = r8
            r16 = r9
            r19 = r12
        L_0x01d5:
            int r7 = r7 + 1
            r1 = r18
            r12 = r19
            r5 = r20
            r8 = r22
            r9 = r16
            goto L_0x011c
        L_0x01e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0508  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0547  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x057d  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x058c  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0597  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x06fc  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0719  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0803  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x08ce  */
    /* JADX WARNING: Removed duplicated region for block: B:428:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r39, int r40) {
        /*
            r38 = this;
            r6 = r38
            r7 = r39
            r8 = r40
            int r0 = r6.mOrientation
            r10 = -2
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = 8
            r13 = 0
            r15 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            r4 = 0
            if (r0 != r5) goto L_0x03b2
            r6.mTotalLength = r4
            int r3 = r38.getVirtualChildCount()
            int r2 = android.view.View.MeasureSpec.getMode(r39)
            int r1 = android.view.View.MeasureSpec.getMode(r40)
            int r0 = r6.mBaselineAlignedChildIndex
            boolean r9 = r6.mUseLargestChild
            r14 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1
            r24 = 0
            r25 = 0
        L_0x0039:
            if (r14 >= r3) goto L_0x018b
            android.view.View r26 = r6.getChildAt(r14)
            if (r26 != 0) goto L_0x004c
            int r4 = r6.mTotalLength
            int r26 = r38.measureNullChild()
            int r4 = r26 + r4
            r6.mTotalLength = r4
            goto L_0x0057
        L_0x004c:
            int r4 = r26.getVisibility()
            if (r4 != r12) goto L_0x0063
            int r4 = r38.getChildrenSkipCount()
            int r14 = r14 + r4
        L_0x0057:
            r10 = r0
            r29 = r1
            r0 = r2
            r31 = r3
            r4 = r20
            r27 = 1
            goto L_0x0175
        L_0x0063:
            boolean r4 = r6.hasDividerBeforeChildAt(r14)
            if (r4 == 0) goto L_0x0070
            int r4 = r6.mTotalLength
            int r5 = r6.mDividerHeight
            int r4 = r4 + r5
            r6.mTotalLength = r4
        L_0x0070:
            android.view.ViewGroup$LayoutParams r4 = r26.getLayoutParams()
            r5 = r4
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            float r4 = r5.weight
            float r21 = r21 + r4
            if (r1 != r15) goto L_0x009f
            int r12 = r5.height
            if (r12 != 0) goto L_0x009f
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x009f
            int r4 = r6.mTotalLength
            int r12 = r5.topMargin
            int r12 = r12 + r4
            int r15 = r5.bottomMargin
            int r12 = r12 + r15
            int r4 = java.lang.Math.max(r4, r12)
            r6.mTotalLength = r4
            r10 = r0
            r29 = r1
            r30 = r2
            r31 = r3
            r13 = r5
            r5 = 1
            r27 = 1
            goto L_0x00fa
        L_0x009f:
            int r4 = r5.height
            if (r4 != 0) goto L_0x00ad
            float r4 = r5.weight
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x00ad
            r5.height = r10
            r12 = 0
            goto L_0x00af
        L_0x00ad:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00af:
            r4 = 0
            int r15 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x00b8
            int r15 = r6.mTotalLength
            r10 = r0
            goto L_0x00ba
        L_0x00b8:
            r10 = r0
            r15 = 0
        L_0x00ba:
            r0 = r38
            r29 = r1
            r1 = r26
            r30 = r2
            r2 = r39
            r31 = r3
            r3 = r4
            r4 = r40
            r13 = r5
            r27 = 1
            r5 = r15
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5)
            if (r12 == r11) goto L_0x00d4
            r13.height = r12
        L_0x00d4:
            int r0 = r26.getMeasuredHeight()
            int r1 = r6.mTotalLength
            int r2 = r1 + r0
            int r3 = r13.topMargin
            int r2 = r2 + r3
            int r3 = r13.bottomMargin
            int r2 = r2 + r3
            int r3 = r38.getNextLocationOffset()
            int r3 = r3 + r2
            int r1 = java.lang.Math.max(r1, r3)
            r6.mTotalLength = r1
            if (r9 == 0) goto L_0x00f6
            r4 = r18
            int r18 = java.lang.Math.max(r0, r4)
            goto L_0x00f8
        L_0x00f6:
            r4 = r18
        L_0x00f8:
            r5 = r22
        L_0x00fa:
            if (r10 < 0) goto L_0x0104
            int r0 = r14 + 1
            if (r10 != r0) goto L_0x0104
            int r0 = r6.mTotalLength
            r6.mBaselineChildTop = r0
        L_0x0104:
            if (r14 >= r10) goto L_0x0116
            float r0 = r13.weight
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x010e
            goto L_0x0116
        L_0x010e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x0116:
            r0 = r30
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x0125
            int r1 = r13.width
            r2 = -1
            if (r1 != r2) goto L_0x0125
            r1 = 1
            r24 = 1
            goto L_0x0126
        L_0x0125:
            r1 = 0
        L_0x0126:
            int r2 = r13.leftMargin
            int r3 = r13.rightMargin
            int r2 = r2 + r3
            int r3 = r26.getMeasuredWidth()
            int r3 = r3 + r2
            r12 = r20
            int r4 = java.lang.Math.max(r12, r3)
            int r12 = r26.getMeasuredState()
            r15 = r25
            int r12 = android.view.View.combineMeasuredStates(r15, r12)
            if (r23 == 0) goto L_0x0149
            int r15 = r13.width
            r11 = -1
            if (r15 != r11) goto L_0x0149
            r11 = 1
            goto L_0x014a
        L_0x0149:
            r11 = 0
        L_0x014a:
            float r13 = r13.weight
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 <= 0) goto L_0x015c
            if (r1 == 0) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r2 = r3
        L_0x0155:
            r13 = r17
            int r17 = java.lang.Math.max(r13, r2)
            goto L_0x016a
        L_0x015c:
            r13 = r17
            if (r1 == 0) goto L_0x0161
            goto L_0x0162
        L_0x0161:
            r2 = r3
        L_0x0162:
            r1 = r19
            int r19 = java.lang.Math.max(r1, r2)
            r17 = r13
        L_0x016a:
            int r1 = r38.getChildrenSkipCount()
            int r14 = r14 + r1
            r22 = r5
            r23 = r11
            r25 = r12
        L_0x0175:
            int r14 = r14 + 1
            r2 = r0
            r20 = r4
            r0 = r10
            r1 = r29
            r3 = r31
            r4 = 0
            r5 = 1
            r10 = -2
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = 8
            r13 = 0
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x0039
        L_0x018b:
            r29 = r1
            r0 = r2
            r31 = r3
            r13 = r17
            r4 = r18
            r1 = r19
            r12 = r20
            r15 = r25
            r27 = 1
            int r2 = r6.mTotalLength
            r10 = r31
            if (r2 <= 0) goto L_0x01af
            boolean r2 = r6.hasDividerBeforeChildAt(r10)
            if (r2 == 0) goto L_0x01af
            int r2 = r6.mTotalLength
            int r3 = r6.mDividerHeight
            int r2 = r2 + r3
            r6.mTotalLength = r2
        L_0x01af:
            r2 = r29
            if (r9 == 0) goto L_0x01ff
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r3) goto L_0x01b9
            if (r2 != 0) goto L_0x01ff
        L_0x01b9:
            r11 = 0
            r6.mTotalLength = r11
            r3 = 0
        L_0x01bd:
            if (r3 >= r10) goto L_0x01ff
            android.view.View r5 = r6.getChildAt(r3)
            if (r5 != 0) goto L_0x01cf
            int r5 = r6.mTotalLength
            int r14 = r38.measureNullChild()
            int r14 = r14 + r5
            r6.mTotalLength = r14
            goto L_0x01fb
        L_0x01cf:
            int r14 = r5.getVisibility()
            r11 = 8
            if (r14 != r11) goto L_0x01dd
            int r5 = r38.getChildrenSkipCount()
            int r3 = r3 + r5
            goto L_0x01fb
        L_0x01dd:
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r11 = r6.mTotalLength
            int r18 = r11 + r4
            int r14 = r5.topMargin
            int r18 = r18 + r14
            int r5 = r5.bottomMargin
            int r18 = r18 + r5
            int r5 = r38.getNextLocationOffset()
            int r5 = r5 + r18
            int r5 = java.lang.Math.max(r11, r5)
            r6.mTotalLength = r5
        L_0x01fb:
            int r3 = r3 + 1
            r11 = 0
            goto L_0x01bd
        L_0x01ff:
            int r3 = r6.mTotalLength
            int r5 = r38.getPaddingTop()
            int r11 = r38.getPaddingBottom()
            int r11 = r11 + r5
            int r11 = r11 + r3
            r6.mTotalLength = r11
            int r3 = r38.getSuggestedMinimumHeight()
            int r3 = java.lang.Math.max(r11, r3)
            r5 = 0
            int r3 = android.view.View.resolveSizeAndState(r3, r8, r5)
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r5 = r5 & r3
            int r11 = r6.mTotalLength
            int r5 = r5 - r11
            if (r22 != 0) goto L_0x026c
            if (r5 == 0) goto L_0x022b
            r11 = 0
            int r14 = (r21 > r11 ? 1 : (r21 == r11 ? 0 : -1))
            if (r14 <= 0) goto L_0x022b
            goto L_0x026c
        L_0x022b:
            int r1 = java.lang.Math.max(r1, r13)
            if (r9 == 0) goto L_0x0268
            r5 = 1073741824(0x40000000, float:2.0)
            if (r2 == r5) goto L_0x0268
            r2 = 0
        L_0x0236:
            if (r2 >= r10) goto L_0x0268
            android.view.View r5 = r6.getChildAt(r2)
            if (r5 == 0) goto L_0x0265
            int r9 = r5.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x0247
            goto L_0x0265
        L_0x0247:
            android.view.ViewGroup$LayoutParams r9 = r5.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r9 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r9
            float r9 = r9.weight
            r11 = 0
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x0265
            int r9 = r5.getMeasuredWidth()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r11)
            r5.measure(r9, r13)
        L_0x0265:
            int r2 = r2 + 1
            goto L_0x0236
        L_0x0268:
            r20 = r12
            goto L_0x0352
        L_0x026c:
            float r4 = r6.mWeightSum
            r9 = 0
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0275
            r21 = r4
        L_0x0275:
            r4 = 0
            r6.mTotalLength = r4
            r4 = 0
        L_0x0279:
            if (r4 >= r10) goto L_0x0342
            android.view.View r9 = r6.getChildAt(r4)
            int r11 = r9.getVisibility()
            r13 = 8
            if (r11 != r13) goto L_0x028b
            r29 = r2
            goto L_0x033c
        L_0x028b:
            android.view.ViewGroup$LayoutParams r11 = r9.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            float r13 = r11.weight
            r14 = 0
            int r16 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x02ee
            float r14 = (float) r5
            float r14 = r14 * r13
            float r14 = r14 / r21
            int r14 = (int) r14
            float r21 = r21 - r13
            int r5 = r5 - r14
            int r13 = r38.getPaddingLeft()
            int r16 = r38.getPaddingRight()
            int r16 = r16 + r13
            int r13 = r11.leftMargin
            int r16 = r16 + r13
            int r13 = r11.rightMargin
            int r13 = r16 + r13
            r16 = r5
            int r5 = r11.width
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r7, r13, r5)
            int r13 = r11.height
            if (r13 != 0) goto L_0x02d0
            r13 = 1073741824(0x40000000, float:2.0)
            if (r2 == r13) goto L_0x02c4
            goto L_0x02d2
        L_0x02c4:
            if (r14 <= 0) goto L_0x02c7
            goto L_0x02c8
        L_0x02c7:
            r14 = 0
        L_0x02c8:
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r9.measure(r5, r14)
            goto L_0x02e2
        L_0x02d0:
            r13 = 1073741824(0x40000000, float:2.0)
        L_0x02d2:
            int r17 = r9.getMeasuredHeight()
            int r14 = r17 + r14
            if (r14 >= 0) goto L_0x02db
            r14 = 0
        L_0x02db:
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r9.measure(r5, r14)
        L_0x02e2:
            int r5 = r9.getMeasuredState()
            r5 = r5 & -256(0xffffffffffffff00, float:NaN)
            int r15 = android.view.View.combineMeasuredStates(r15, r5)
            r5 = r16
        L_0x02ee:
            int r13 = r11.leftMargin
            int r14 = r11.rightMargin
            int r13 = r13 + r14
            int r14 = r9.getMeasuredWidth()
            int r14 = r14 + r13
            int r12 = java.lang.Math.max(r12, r14)
            r29 = r2
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x030b
            int r2 = r11.width
            r16 = r5
            r5 = -1
            if (r2 != r5) goto L_0x030e
            r2 = 1
            goto L_0x030f
        L_0x030b:
            r16 = r5
            r5 = -1
        L_0x030e:
            r2 = 0
        L_0x030f:
            if (r2 == 0) goto L_0x0312
            goto L_0x0313
        L_0x0312:
            r13 = r14
        L_0x0313:
            int r1 = java.lang.Math.max(r1, r13)
            if (r23 == 0) goto L_0x031f
            int r2 = r11.width
            if (r2 != r5) goto L_0x031f
            r5 = 1
            goto L_0x0320
        L_0x031f:
            r5 = 0
        L_0x0320:
            int r2 = r6.mTotalLength
            int r9 = r9.getMeasuredHeight()
            int r9 = r9 + r2
            int r13 = r11.topMargin
            int r9 = r9 + r13
            int r11 = r11.bottomMargin
            int r9 = r9 + r11
            int r11 = r38.getNextLocationOffset()
            int r11 = r11 + r9
            int r2 = java.lang.Math.max(r2, r11)
            r6.mTotalLength = r2
            r23 = r5
            r5 = r16
        L_0x033c:
            int r4 = r4 + 1
            r2 = r29
            goto L_0x0279
        L_0x0342:
            int r2 = r6.mTotalLength
            int r4 = r38.getPaddingTop()
            int r5 = r38.getPaddingBottom()
            int r5 = r5 + r4
            int r5 = r5 + r2
            r6.mTotalLength = r5
            goto L_0x0268
        L_0x0352:
            if (r23 != 0) goto L_0x0359
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x0359
            goto L_0x035b
        L_0x0359:
            r1 = r20
        L_0x035b:
            int r0 = r38.getPaddingLeft()
            int r2 = r38.getPaddingRight()
            int r2 = r2 + r0
            int r2 = r2 + r1
            int r0 = r38.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r2, r0)
            int r0 = android.view.View.resolveSizeAndState(r0, r7, r15)
            r6.setMeasuredDimension(r0, r3)
            if (r24 == 0) goto L_0x090e
            int r0 = r38.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r9 = 0
        L_0x0381:
            if (r9 >= r10) goto L_0x090e
            android.view.View r1 = r6.getChildAt(r9)
            int r0 = r1.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x03af
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            r11 = r0
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r0 = r11.width
            r2 = -1
            if (r0 != r2) goto L_0x03af
            int r12 = r11.height
            int r0 = r1.getMeasuredHeight()
            r11.height = r0
            r3 = 0
            r5 = 0
            r0 = r38
            r2 = r7
            r4 = r40
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            r11.height = r12
        L_0x03af:
            int r9 = r9 + 1
            goto L_0x0381
        L_0x03b2:
            r27 = 1
            r0 = 0
            r6.mTotalLength = r0
            int r9 = r38.getVirtualChildCount()
            int r10 = android.view.View.MeasureSpec.getMode(r39)
            int r11 = android.view.View.MeasureSpec.getMode(r40)
            int[] r0 = r6.mMaxAscent
            r12 = 4
            if (r0 == 0) goto L_0x03cc
            int[] r0 = r6.mMaxDescent
            if (r0 != 0) goto L_0x03d4
        L_0x03cc:
            int[] r0 = new int[r12]
            r6.mMaxAscent = r0
            int[] r0 = new int[r12]
            r6.mMaxDescent = r0
        L_0x03d4:
            int[] r13 = r6.mMaxAscent
            int[] r14 = r6.mMaxDescent
            r15 = 3
            r0 = -1
            r13[r15] = r0
            r17 = 2
            r13[r17] = r0
            r13[r27] = r0
            r1 = 0
            r13[r1] = r0
            r14[r15] = r0
            r14[r17] = r0
            r14[r27] = r0
            r14[r1] = r0
            boolean r5 = r6.mBaselineAligned
            boolean r4 = r6.mUseLargestChild
            r0 = 1073741824(0x40000000, float:2.0)
            if (r10 != r0) goto L_0x03f8
            r18 = 1
            goto L_0x03fa
        L_0x03f8:
            r18 = 0
        L_0x03fa:
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r8 = 0
            r12 = 0
            r15 = 0
            r22 = 0
            r23 = 1
            r24 = 0
        L_0x0407:
            if (r3 >= r9) goto L_0x05c0
            android.view.View r7 = r6.getChildAt(r3)
            if (r7 != 0) goto L_0x041e
            int r7 = r6.mTotalLength
            int r25 = r38.measureNullChild()
            int r7 = r25 + r7
            r6.mTotalLength = r7
            r25 = r0
            r26 = r2
            goto L_0x042f
        L_0x041e:
            r25 = r0
            int r0 = r7.getVisibility()
            r26 = r2
            r2 = 8
            if (r0 != r2) goto L_0x0439
            int r0 = r38.getChildrenSkipCount()
            int r3 = r3 + r0
        L_0x042f:
            r30 = r5
            r0 = r25
            r2 = r26
            r26 = r4
            goto L_0x05b6
        L_0x0439:
            boolean r0 = r6.hasDividerBeforeChildAt(r3)
            if (r0 == 0) goto L_0x0446
            int r0 = r6.mTotalLength
            int r2 = r6.mDividerWidth
            int r0 = r0 + r2
            r6.mTotalLength = r0
        L_0x0446:
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            r2 = r0
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r2 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r2
            float r0 = r2.weight
            float r29 = r1 + r0
            r1 = 1073741824(0x40000000, float:2.0)
            if (r10 != r1) goto L_0x04a4
            int r1 = r2.width
            if (r1 != 0) goto L_0x04a4
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x04a4
            if (r18 == 0) goto L_0x046d
            int r0 = r6.mTotalLength
            int r1 = r2.leftMargin
            r30 = r3
            int r3 = r2.rightMargin
            int r1 = r1 + r3
            int r1 = r1 + r0
            r6.mTotalLength = r1
            goto L_0x047d
        L_0x046d:
            r30 = r3
            int r0 = r6.mTotalLength
            int r1 = r2.leftMargin
            int r1 = r1 + r0
            int r3 = r2.rightMargin
            int r1 = r1 + r3
            int r0 = java.lang.Math.max(r0, r1)
            r6.mTotalLength = r0
        L_0x047d:
            if (r5 == 0) goto L_0x0494
            r0 = 0
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r7.measure(r1, r1)
            r1 = r2
            r33 = r25
            r34 = r26
            r25 = r30
            r26 = r4
            r30 = r5
            goto L_0x0523
        L_0x0494:
            r1 = r2
            r33 = r25
            r34 = r26
            r25 = r30
            r0 = 1073741824(0x40000000, float:2.0)
            r26 = r4
            r30 = r5
            r5 = 1
            goto L_0x0527
        L_0x04a4:
            r30 = r3
            int r0 = r2.width
            if (r0 != 0) goto L_0x04b6
            float r0 = r2.weight
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x04b7
            r0 = -2
            r2.width = r0
            r3 = 0
            goto L_0x04b9
        L_0x04b6:
            r1 = 0
        L_0x04b7:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x04b9:
            int r0 = (r29 > r1 ? 1 : (r29 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x04c2
            int r0 = r6.mTotalLength
            r31 = r0
            goto L_0x04c4
        L_0x04c2:
            r31 = 0
        L_0x04c4:
            r32 = 0
            r1 = r25
            r0 = r38
            r33 = r1
            r1 = r7
            r35 = r2
            r34 = r26
            r2 = r39
            r36 = r3
            r25 = r30
            r3 = r31
            r26 = r4
            r4 = r40
            r30 = r5
            r5 = r32
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5)
            r0 = r36
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x04ef
            r1 = r35
            r1.width = r0
            goto L_0x04f1
        L_0x04ef:
            r1 = r35
        L_0x04f1:
            int r0 = r7.getMeasuredWidth()
            if (r18 == 0) goto L_0x0508
            int r2 = r6.mTotalLength
            int r3 = r1.leftMargin
            int r3 = r3 + r0
            int r4 = r1.rightMargin
            int r3 = r3 + r4
            int r4 = r38.getNextLocationOffset()
            int r4 = r4 + r3
            int r4 = r4 + r2
            r6.mTotalLength = r4
            goto L_0x051d
        L_0x0508:
            int r2 = r6.mTotalLength
            int r3 = r2 + r0
            int r4 = r1.leftMargin
            int r3 = r3 + r4
            int r4 = r1.rightMargin
            int r3 = r3 + r4
            int r4 = r38.getNextLocationOffset()
            int r4 = r4 + r3
            int r2 = java.lang.Math.max(r2, r4)
            r6.mTotalLength = r2
        L_0x051d:
            if (r26 == 0) goto L_0x0523
            int r8 = java.lang.Math.max(r0, r8)
        L_0x0523:
            r5 = r22
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x0527:
            if (r11 == r0) goto L_0x0532
            int r0 = r1.height
            r2 = -1
            if (r0 != r2) goto L_0x0532
            r0 = 1
            r24 = 1
            goto L_0x0533
        L_0x0532:
            r0 = 0
        L_0x0533:
            int r2 = r1.topMargin
            int r3 = r1.bottomMargin
            int r2 = r2 + r3
            int r3 = r7.getMeasuredHeight()
            int r3 = r3 + r2
            int r4 = r7.getMeasuredState()
            int r4 = android.view.View.combineMeasuredStates(r12, r4)
            if (r30 == 0) goto L_0x0575
            int r7 = r7.getBaseline()
            r12 = -1
            if (r7 == r12) goto L_0x0575
            int r12 = r1.gravity
            if (r12 >= 0) goto L_0x0554
            int r12 = r6.mGravity
        L_0x0554:
            r12 = r12 & 112(0x70, float:1.57E-43)
            r21 = 4
            int r12 = r12 >> 4
            r22 = -2
            r12 = r12 & -2
            int r12 = r12 >> 1
            r22 = r2
            r2 = r13[r12]
            int r2 = java.lang.Math.max(r2, r7)
            r13[r12] = r2
            r2 = r14[r12]
            int r7 = r3 - r7
            int r2 = java.lang.Math.max(r2, r7)
            r14[r12] = r2
            goto L_0x0577
        L_0x0575:
            r22 = r2
        L_0x0577:
            int r2 = java.lang.Math.max(r15, r3)
            if (r23 == 0) goto L_0x0584
            int r7 = r1.height
            r12 = -1
            if (r7 != r12) goto L_0x0584
            r7 = 1
            goto L_0x0585
        L_0x0584:
            r7 = 0
        L_0x0585:
            float r1 = r1.weight
            r12 = 0
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 <= 0) goto L_0x0597
            if (r0 == 0) goto L_0x0590
            r3 = r22
        L_0x0590:
            r1 = r33
            int r0 = java.lang.Math.max(r1, r3)
            goto L_0x05a6
        L_0x0597:
            r1 = r33
            if (r0 == 0) goto L_0x059d
            r3 = r22
        L_0x059d:
            r0 = r34
            int r0 = java.lang.Math.max(r0, r3)
            r34 = r0
            r0 = r1
        L_0x05a6:
            int r1 = r38.getChildrenSkipCount()
            int r3 = r1 + r25
            r15 = r2
            r12 = r4
            r22 = r5
            r23 = r7
            r1 = r29
            r2 = r34
        L_0x05b6:
            int r3 = r3 + 1
            r7 = r39
            r4 = r26
            r5 = r30
            goto L_0x0407
        L_0x05c0:
            r26 = r4
            r30 = r5
            r37 = r2
            r2 = r0
            r0 = r37
            int r3 = r6.mTotalLength
            if (r3 <= 0) goto L_0x05da
            boolean r3 = r6.hasDividerBeforeChildAt(r9)
            if (r3 == 0) goto L_0x05da
            int r3 = r6.mTotalLength
            int r4 = r6.mDividerWidth
            int r3 = r3 + r4
            r6.mTotalLength = r3
        L_0x05da:
            r3 = r13[r27]
            r4 = -1
            if (r3 != r4) goto L_0x05f1
            r3 = 0
            r5 = r13[r3]
            if (r5 != r4) goto L_0x05f1
            r3 = r13[r17]
            if (r3 != r4) goto L_0x05f1
            r3 = 3
            r5 = r13[r3]
            if (r5 == r4) goto L_0x05ee
            goto L_0x05f2
        L_0x05ee:
            r25 = r12
            goto L_0x0624
        L_0x05f1:
            r3 = 3
        L_0x05f2:
            r4 = r13[r3]
            r5 = 0
            r7 = r13[r5]
            r5 = r13[r27]
            r3 = r13[r17]
            int r3 = java.lang.Math.max(r5, r3)
            int r3 = java.lang.Math.max(r7, r3)
            int r3 = java.lang.Math.max(r4, r3)
            r4 = 3
            r5 = r14[r4]
            r4 = 0
            r7 = r14[r4]
            r4 = r14[r27]
            r25 = r12
            r12 = r14[r17]
            int r4 = java.lang.Math.max(r4, r12)
            int r4 = java.lang.Math.max(r7, r4)
            int r4 = java.lang.Math.max(r5, r4)
            int r4 = r4 + r3
            int r15 = java.lang.Math.max(r15, r4)
        L_0x0624:
            if (r26 == 0) goto L_0x0681
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == r3) goto L_0x062c
            if (r10 != 0) goto L_0x0681
        L_0x062c:
            r3 = 0
            r6.mTotalLength = r3
            r4 = 0
        L_0x0630:
            if (r4 >= r9) goto L_0x0681
            android.view.View r3 = r6.getChildAt(r4)
            if (r3 != 0) goto L_0x0642
            int r3 = r6.mTotalLength
            int r5 = r38.measureNullChild()
            int r5 = r5 + r3
            r6.mTotalLength = r5
            goto L_0x067e
        L_0x0642:
            int r5 = r3.getVisibility()
            r7 = 8
            if (r5 != r7) goto L_0x0650
            int r3 = r38.getChildrenSkipCount()
            int r4 = r4 + r3
            goto L_0x067e
        L_0x0650:
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r3 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r3
            if (r18 == 0) goto L_0x0669
            int r5 = r6.mTotalLength
            int r7 = r3.leftMargin
            int r7 = r7 + r8
            int r3 = r3.rightMargin
            int r7 = r7 + r3
            int r3 = r38.getNextLocationOffset()
            int r3 = r3 + r7
            int r3 = r3 + r5
            r6.mTotalLength = r3
            goto L_0x067e
        L_0x0669:
            int r5 = r6.mTotalLength
            int r7 = r5 + r8
            int r12 = r3.leftMargin
            int r7 = r7 + r12
            int r3 = r3.rightMargin
            int r7 = r7 + r3
            int r3 = r38.getNextLocationOffset()
            int r3 = r3 + r7
            int r3 = java.lang.Math.max(r5, r3)
            r6.mTotalLength = r3
        L_0x067e:
            int r4 = r4 + 1
            goto L_0x0630
        L_0x0681:
            int r3 = r6.mTotalLength
            int r4 = r38.getPaddingLeft()
            int r5 = r38.getPaddingRight()
            int r5 = r5 + r4
            int r5 = r5 + r3
            r6.mTotalLength = r5
            int r3 = r38.getSuggestedMinimumWidth()
            int r3 = java.lang.Math.max(r5, r3)
            r7 = r39
            r4 = 0
            int r3 = android.view.View.resolveSizeAndState(r3, r7, r4)
            r4 = 16777215(0xffffff, float:2.3509886E-38)
            r4 = r4 & r3
            int r5 = r6.mTotalLength
            int r4 = r4 - r5
            if (r22 != 0) goto L_0x06f5
            if (r4 == 0) goto L_0x06af
            r12 = 0
            int r16 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r16 <= 0) goto L_0x06af
            goto L_0x06f5
        L_0x06af:
            int r0 = java.lang.Math.max(r0, r2)
            if (r26 == 0) goto L_0x06ec
            r1 = 1073741824(0x40000000, float:2.0)
            if (r10 == r1) goto L_0x06ec
            r4 = 0
        L_0x06ba:
            if (r4 >= r9) goto L_0x06ec
            android.view.View r1 = r6.getChildAt(r4)
            if (r1 == 0) goto L_0x06e9
            int r2 = r1.getVisibility()
            r10 = 8
            if (r2 != r10) goto L_0x06cb
            goto L_0x06e9
        L_0x06cb:
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r2 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r2
            float r2 = r2.weight
            r10 = 0
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x06e9
            r2 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r2)
            int r12 = r1.getMeasuredHeight()
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r2)
            r1.measure(r10, r12)
        L_0x06e9:
            int r4 = r4 + 1
            goto L_0x06ba
        L_0x06ec:
            r8 = r40
            r22 = r9
            r12 = r25
        L_0x06f2:
            r5 = 0
            goto L_0x08a5
        L_0x06f5:
            float r2 = r6.mWeightSum
            r8 = 0
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x06fd
            r1 = r2
        L_0x06fd:
            r2 = 3
            r8 = -1
            r13[r2] = r8
            r13[r17] = r8
            r13[r27] = r8
            r12 = 0
            r13[r12] = r8
            r14[r2] = r8
            r14[r17] = r8
            r14[r27] = r8
            r14[r12] = r8
            r6.mTotalLength = r12
            r8 = r4
            r12 = r25
            r2 = -1
            r4 = 0
        L_0x0717:
            if (r4 >= r9) goto L_0x084c
            android.view.View r15 = r6.getChildAt(r4)
            if (r15 == 0) goto L_0x0838
            int r5 = r15.getVisibility()
            r7 = 8
            if (r5 != r7) goto L_0x0729
            goto L_0x0838
        L_0x0729:
            android.view.ViewGroup$LayoutParams r5 = r15.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            float r7 = r5.weight
            r20 = 0
            int r22 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r22 <= 0) goto L_0x0795
            r22 = r9
            float r9 = (float) r8
            float r9 = r9 * r7
            float r9 = r9 / r1
            int r9 = (int) r9
            float r1 = r1 - r7
            int r8 = r8 - r9
            int r7 = r38.getPaddingTop()
            int r25 = r38.getPaddingBottom()
            int r25 = r25 + r7
            int r7 = r5.topMargin
            int r25 = r25 + r7
            int r7 = r5.bottomMargin
            int r7 = r25 + r7
            r25 = r1
            int r1 = r5.height
            r26 = r8
            r8 = r40
            int r1 = android.view.ViewGroup.getChildMeasureSpec(r8, r7, r1)
            int r7 = r5.width
            if (r7 != 0) goto L_0x0773
            r7 = 1073741824(0x40000000, float:2.0)
            if (r10 == r7) goto L_0x0767
            goto L_0x0775
        L_0x0767:
            if (r9 <= 0) goto L_0x076a
            goto L_0x076b
        L_0x076a:
            r9 = 0
        L_0x076b:
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r7)
            r15.measure(r9, r1)
            goto L_0x0785
        L_0x0773:
            r7 = 1073741824(0x40000000, float:2.0)
        L_0x0775:
            int r28 = r15.getMeasuredWidth()
            int r9 = r28 + r9
            if (r9 >= 0) goto L_0x077e
            r9 = 0
        L_0x077e:
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r7)
            r15.measure(r9, r1)
        L_0x0785:
            int r1 = r15.getMeasuredState()
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r7
            int r12 = android.view.View.combineMeasuredStates(r12, r1)
            r1 = r25
            r7 = r26
            goto L_0x079a
        L_0x0795:
            r7 = r8
            r22 = r9
            r8 = r40
        L_0x079a:
            if (r18 == 0) goto L_0x07b8
            int r9 = r6.mTotalLength
            int r25 = r15.getMeasuredWidth()
            r26 = r1
            int r1 = r5.leftMargin
            int r25 = r25 + r1
            int r1 = r5.rightMargin
            int r25 = r25 + r1
            int r1 = r38.getNextLocationOffset()
            int r1 = r1 + r25
            int r1 = r1 + r9
            r6.mTotalLength = r1
            r25 = r7
            goto L_0x07d4
        L_0x07b8:
            r26 = r1
            int r1 = r6.mTotalLength
            int r9 = r15.getMeasuredWidth()
            int r9 = r9 + r1
            r25 = r7
            int r7 = r5.leftMargin
            int r9 = r9 + r7
            int r7 = r5.rightMargin
            int r9 = r9 + r7
            int r7 = r38.getNextLocationOffset()
            int r7 = r7 + r9
            int r1 = java.lang.Math.max(r1, r7)
            r6.mTotalLength = r1
        L_0x07d4:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r11 == r1) goto L_0x07df
            int r1 = r5.height
            r7 = -1
            if (r1 != r7) goto L_0x07df
            r1 = 1
            goto L_0x07e0
        L_0x07df:
            r1 = 0
        L_0x07e0:
            int r7 = r5.topMargin
            int r9 = r5.bottomMargin
            int r7 = r7 + r9
            int r9 = r15.getMeasuredHeight()
            int r9 = r9 + r7
            int r2 = java.lang.Math.max(r2, r9)
            if (r1 == 0) goto L_0x07f1
            goto L_0x07f2
        L_0x07f1:
            r7 = r9
        L_0x07f2:
            int r0 = java.lang.Math.max(r0, r7)
            if (r23 == 0) goto L_0x07ff
            int r1 = r5.height
            r7 = -1
            if (r1 != r7) goto L_0x0800
            r1 = 1
            goto L_0x0801
        L_0x07ff:
            r7 = -1
        L_0x0800:
            r1 = 0
        L_0x0801:
            if (r30 == 0) goto L_0x082d
            int r15 = r15.getBaseline()
            if (r15 == r7) goto L_0x082d
            int r5 = r5.gravity
            if (r5 >= 0) goto L_0x080f
            int r5 = r6.mGravity
        L_0x080f:
            r5 = r5 & 112(0x70, float:1.57E-43)
            r21 = 4
            int r5 = r5 >> 4
            r28 = -2
            r5 = r5 & -2
            int r5 = r5 >> 1
            r7 = r13[r5]
            int r7 = java.lang.Math.max(r7, r15)
            r13[r5] = r7
            r7 = r14[r5]
            int r9 = r9 - r15
            int r7 = java.lang.Math.max(r7, r9)
            r14[r5] = r7
            goto L_0x0831
        L_0x082d:
            r21 = 4
            r28 = -2
        L_0x0831:
            r23 = r1
            r7 = r25
            r1 = r26
            goto L_0x0843
        L_0x0838:
            r7 = r8
            r22 = r9
            r20 = 0
            r21 = 4
            r28 = -2
            r8 = r40
        L_0x0843:
            int r4 = r4 + 1
            r8 = r7
            r9 = r22
            r7 = r39
            goto L_0x0717
        L_0x084c:
            r8 = r40
            r22 = r9
            int r1 = r6.mTotalLength
            int r4 = r38.getPaddingLeft()
            int r5 = r38.getPaddingRight()
            int r5 = r5 + r4
            int r5 = r5 + r1
            r6.mTotalLength = r5
            r1 = r13[r27]
            r4 = -1
            if (r1 != r4) goto L_0x0875
            r1 = 0
            r5 = r13[r1]
            if (r5 != r4) goto L_0x0875
            r1 = r13[r17]
            if (r1 != r4) goto L_0x0875
            r1 = 3
            r5 = r13[r1]
            if (r5 == r4) goto L_0x0872
            goto L_0x0876
        L_0x0872:
            r15 = r2
            goto L_0x06f2
        L_0x0875:
            r1 = 3
        L_0x0876:
            r4 = r13[r1]
            r5 = 0
            r7 = r13[r5]
            r9 = r13[r27]
            r10 = r13[r17]
            int r9 = java.lang.Math.max(r9, r10)
            int r7 = java.lang.Math.max(r7, r9)
            int r4 = java.lang.Math.max(r4, r7)
            r1 = r14[r1]
            r7 = r14[r5]
            r9 = r14[r27]
            r10 = r14[r17]
            int r9 = java.lang.Math.max(r9, r10)
            int r7 = java.lang.Math.max(r7, r9)
            int r1 = java.lang.Math.max(r1, r7)
            int r1 = r1 + r4
            int r1 = java.lang.Math.max(r2, r1)
            r15 = r1
        L_0x08a5:
            if (r23 != 0) goto L_0x08ac
            r1 = 1073741824(0x40000000, float:2.0)
            if (r11 == r1) goto L_0x08ac
            goto L_0x08ad
        L_0x08ac:
            r0 = r15
        L_0x08ad:
            int r1 = r38.getPaddingTop()
            int r2 = r38.getPaddingBottom()
            int r2 = r2 + r1
            int r2 = r2 + r0
            int r0 = r38.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r2, r0)
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r12
            r1 = r1 | r3
            int r2 = r12 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r8, r2)
            r6.setMeasuredDimension(r1, r0)
            if (r24 == 0) goto L_0x090e
            int r0 = r38.getMeasuredHeight()
            r1 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r9 = r22
            r8 = 0
        L_0x08db:
            if (r8 >= r9) goto L_0x090e
            android.view.View r1 = r6.getChildAt(r8)
            int r0 = r1.getVisibility()
            r10 = 8
            if (r0 == r10) goto L_0x090a
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            r11 = r0
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r0 = r11.height
            r12 = -1
            if (r0 != r12) goto L_0x090b
            int r13 = r11.width
            int r0 = r1.getMeasuredWidth()
            r11.width = r0
            r3 = 0
            r5 = 0
            r0 = r38
            r2 = r39
            r4 = r7
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            r11.width = r13
            goto L_0x090b
        L_0x090a:
            r12 = -1
        L_0x090b:
            int r8 = r8 + 1
            goto L_0x08db
        L_0x090e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("base aligned child index out of range (0, ");
            outline73.append(getChildCount());
            outline73.append(")");
            throw new IllegalArgumentException(outline73.toString());
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | (-8388616 & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.mWeightSum = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable;
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.LinearLayoutCompat, attributeSet, obtainStyledAttributes, i, 0);
        int i2 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        int i4 = R$styleable.LinearLayoutCompat_divider;
        if (obtainStyledAttributes.hasValue(i4)) {
            int resourceId = obtainStyledAttributes.getResourceId(i4, 0);
            if (resourceId != 0) {
                drawable = AppCompatResources.getDrawable(context, resourceId);
                setDividerDrawable(drawable);
                this.mShowDividers = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_showDividers, 0);
                this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LinearLayoutCompat_dividerPadding, 0);
                obtainStyledAttributes.recycle();
            }
        }
        drawable = obtainStyledAttributes.getDrawable(i4);
        setDividerDrawable(drawable);
        this.mShowDividers = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
