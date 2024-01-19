package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    public ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    public int[] mAlignedDimensions = null;
    public ArrayList<WidgetsList> mChainList = new ArrayList<>();
    public ConstraintWidget[] mDisplayedWidgets;
    public int mDisplayedWidgetsCount = 0;
    public float mFirstHorizontalBias = 0.5f;
    public int mFirstHorizontalStyle = -1;
    public float mFirstVerticalBias = 0.5f;
    public int mFirstVerticalStyle = -1;
    public int mHorizontalAlign = 2;
    public float mHorizontalBias = 0.5f;
    public int mHorizontalGap = 0;
    public int mHorizontalStyle = -1;
    public float mLastHorizontalBias = 0.5f;
    public int mLastHorizontalStyle = -1;
    public float mLastVerticalBias = 0.5f;
    public int mLastVerticalStyle = -1;
    public int mMaxElementsWrap = -1;
    public int mOrientation = 0;
    public int mVerticalAlign = 2;
    public float mVerticalBias = 0.5f;
    public int mVerticalGap = 0;
    public int mVerticalStyle = -1;
    public int mWrapMode = 0;

    public class WidgetsList {
        public ConstraintWidget biggest = null;
        public int biggestDimension = 0;
        public ConstraintAnchor mBottom;
        public int mCount = 0;
        public int mHeight = 0;
        public ConstraintAnchor mLeft;
        public int mMax = 0;
        public int mNbMatchConstraintsWidgets = 0;
        public int mOrientation = 0;
        public int mPaddingBottom = 0;
        public int mPaddingLeft = 0;
        public int mPaddingRight = 0;
        public int mPaddingTop = 0;
        public ConstraintAnchor mRight;
        public int mStartIndex = 0;
        public ConstraintAnchor mTop;
        public int mWidth = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.mResolvedPaddingLeft;
            this.mPaddingTop = Flow.this.mPaddingTop;
            this.mPaddingRight = Flow.this.mResolvedPaddingRight;
            this.mPaddingBottom = Flow.this.mPaddingBottom;
            this.mMax = i2;
        }

        public void add(ConstraintWidget constraintWidget) {
            int i = 0;
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                int i2 = Flow.this.mHorizontalGap;
                if (constraintWidget.mVisibility != 8) {
                    i = i2;
                }
                this.mWidth = widgetWidth + i + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                int i3 = Flow.this.mVerticalGap;
                if (constraintWidget.mVisibility != 8) {
                    i = i3;
                }
                this.mHeight = widgetHeight2 + i + this.mHeight;
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createConstraints(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.mCount
                r2 = 0
                r3 = 0
            L_0x0006:
                if (r3 >= r1) goto L_0x001e
                int r4 = r0.mStartIndex
                int r4 = r4 + r3
                androidx.constraintlayout.core.widgets.Flow r5 = androidx.constraintlayout.core.widgets.Flow.this
                int r6 = r5.mDisplayedWidgetsCount
                if (r4 < r6) goto L_0x0012
                goto L_0x001e
            L_0x0012:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r5.mDisplayedWidgets
                r4 = r5[r4]
                if (r4 == 0) goto L_0x001b
                r4.resetAnchors()
            L_0x001b:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x001e:
                if (r1 == 0) goto L_0x02f4
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.biggest
                if (r3 != 0) goto L_0x0026
                goto L_0x02f4
            L_0x0026:
                if (r19 == 0) goto L_0x002c
                if (r18 != 0) goto L_0x002c
                r4 = 1
                goto L_0x002d
            L_0x002c:
                r4 = 0
            L_0x002d:
                r5 = -1
                r6 = 0
                r7 = -1
                r8 = -1
            L_0x0031:
                if (r6 >= r1) goto L_0x0053
                if (r17 == 0) goto L_0x0039
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x003a
            L_0x0039:
                r9 = r6
            L_0x003a:
                int r10 = r0.mStartIndex
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.Flow r9 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r9.mDisplayedWidgetsCount
                if (r10 < r11) goto L_0x0044
                goto L_0x0053
            L_0x0044:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r9.mDisplayedWidgets
                r9 = r9[r10]
                int r9 = r9.mVisibility
                if (r9 != 0) goto L_0x0050
                if (r7 != r5) goto L_0x004f
                r7 = r6
            L_0x004f:
                r8 = r6
            L_0x0050:
                int r6 = r6 + 1
                goto L_0x0031
            L_0x0053:
                int r6 = r0.mOrientation
                r9 = 0
                if (r6 != 0) goto L_0x01ae
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.biggest
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r10.mVerticalStyle
                r6.mVerticalChainStyle = r11
                int r11 = r0.mPaddingTop
                if (r18 <= 0) goto L_0x0067
                int r10 = r10.mVerticalGap
                int r11 = r11 + r10
            L_0x0067:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r6.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.mTop
                r10.connect(r12, r11)
                if (r19 == 0) goto L_0x0079
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r6.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.mBottom
                int r12 = r0.mPaddingBottom
                r10.connect(r11, r12)
            L_0x0079:
                if (r18 <= 0) goto L_0x0086
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mTop
                androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.mTop
                r10.connect(r11, r2)
            L_0x0086:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.mVerticalAlign
                r11 = 3
                if (r10 != r11) goto L_0x00b1
                boolean r10 = r6.hasBaseline
                if (r10 != 0) goto L_0x00b1
                r10 = 0
            L_0x0092:
                if (r10 >= r1) goto L_0x00b1
                if (r17 == 0) goto L_0x009a
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x009b
            L_0x009a:
                r12 = r10
            L_0x009b:
                int r13 = r0.mStartIndex
                int r13 = r13 + r12
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                int r14 = r12.mDisplayedWidgetsCount
                if (r13 < r14) goto L_0x00a5
                goto L_0x00b1
            L_0x00a5:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r12 = r12.mDisplayedWidgets
                r12 = r12[r13]
                boolean r13 = r12.hasBaseline
                if (r13 == 0) goto L_0x00ae
                goto L_0x00b2
            L_0x00ae:
                int r10 = r10 + 1
                goto L_0x0092
            L_0x00b1:
                r12 = r6
            L_0x00b2:
                r10 = 0
            L_0x00b3:
                if (r10 >= r1) goto L_0x02f4
                if (r17 == 0) goto L_0x00bb
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00bc
            L_0x00bb:
                r13 = r10
            L_0x00bc:
                int r14 = r0.mStartIndex
                int r14 = r14 + r13
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r15.mDisplayedWidgetsCount
                if (r14 < r11) goto L_0x00c7
                goto L_0x02f4
            L_0x00c7:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r15.mDisplayedWidgets
                r11 = r11[r14]
                if (r10 != 0) goto L_0x00d6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r0.mLeft
                int r3 = r0.mPaddingLeft
                r11.connect(r14, r15, r3)
            L_0x00d6:
                if (r13 != 0) goto L_0x0113
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r3.mHorizontalStyle
                r14 = 1065353216(0x3f800000, float:1.0)
                if (r17 == 0) goto L_0x00e5
                float r3 = r3.mHorizontalBias
                float r3 = r14 - r3
                goto L_0x00e7
            L_0x00e5:
                float r3 = r3.mHorizontalBias
            L_0x00e7:
                int r15 = r0.mStartIndex
                if (r15 != 0) goto L_0x00fc
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r2 = r15.mFirstHorizontalStyle
                if (r2 == r5) goto L_0x00fc
                if (r17 == 0) goto L_0x00f8
                float r3 = r15.mFirstHorizontalBias
                float r14 = r14 - r3
                r3 = r14
                goto L_0x00fa
            L_0x00f8:
                float r3 = r15.mFirstHorizontalBias
            L_0x00fa:
                r13 = r2
                goto L_0x010f
            L_0x00fc:
                if (r19 == 0) goto L_0x010f
                androidx.constraintlayout.core.widgets.Flow r2 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r2.mLastHorizontalStyle
                if (r15 == r5) goto L_0x010f
                if (r17 == 0) goto L_0x010b
                float r2 = r2.mLastHorizontalBias
                float r14 = r14 - r2
                r3 = r14
                goto L_0x010e
            L_0x010b:
                float r2 = r2.mLastHorizontalBias
                r3 = r2
            L_0x010e:
                r13 = r15
            L_0x010f:
                r11.mHorizontalChainStyle = r13
                r11.mHorizontalBiasPercent = r3
            L_0x0113:
                int r2 = r1 + -1
                if (r10 != r2) goto L_0x0120
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.mRight
                int r13 = r0.mPaddingRight
                r11.connect(r2, r3, r13)
            L_0x0120:
                if (r9 == 0) goto L_0x014a
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.mRight
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.mHorizontalGap
                r2.connect(r3, r13)
                if (r10 != r7) goto L_0x0136
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mLeft
                int r3 = r0.mPaddingLeft
                r2.setGoneMargin(r3)
            L_0x0136:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r9.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r11.mLeft
                r13 = 0
                r2.connect(r3, r13)
                r2 = 1
                int r3 = r8 + 1
                if (r10 != r3) goto L_0x014a
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r9.mRight
                int r3 = r0.mPaddingRight
                r2.setGoneMargin(r3)
            L_0x014a:
                if (r11 == r6) goto L_0x01a6
                androidx.constraintlayout.core.widgets.Flow r2 = androidx.constraintlayout.core.widgets.Flow.this
                int r2 = r2.mVerticalAlign
                r3 = 3
                if (r2 != r3) goto L_0x0166
                boolean r2 = r12.hasBaseline
                if (r2 == 0) goto L_0x0166
                if (r11 == r12) goto L_0x0166
                boolean r2 = r11.hasBaseline
                if (r2 == 0) goto L_0x0166
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mBaseline
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r12.mBaseline
                r13 = 0
                r2.connect(r9, r13)
                goto L_0x01a7
            L_0x0166:
                androidx.constraintlayout.core.widgets.Flow r2 = androidx.constraintlayout.core.widgets.Flow.this
                int r2 = r2.mVerticalAlign
                if (r2 == 0) goto L_0x019d
                r9 = 1
                if (r2 == r9) goto L_0x0194
                if (r4 == 0) goto L_0x0184
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.mTop
                int r13 = r0.mPaddingTop
                r2.connect(r9, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.mBottom
                int r13 = r0.mPaddingBottom
                r2.connect(r9, r13)
                goto L_0x01a7
            L_0x0184:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r6.mTop
                r13 = 0
                r2.connect(r9, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r6.mBottom
                r2.connect(r9, r13)
                goto L_0x01a7
            L_0x0194:
                r13 = 0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r6.mBottom
                r2.connect(r9, r13)
                goto L_0x01a7
            L_0x019d:
                r13 = 0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r11.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r6.mTop
                r2.connect(r9, r13)
                goto L_0x01a7
            L_0x01a6:
                r3 = 3
            L_0x01a7:
                int r10 = r10 + 1
                r9 = r11
                r2 = 0
                r11 = 3
                goto L_0x00b3
            L_0x01ae:
                androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.biggest
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r6 = r3.mHorizontalStyle
                r2.mHorizontalChainStyle = r6
                int r6 = r0.mPaddingLeft
                if (r18 <= 0) goto L_0x01bd
                int r3 = r3.mHorizontalGap
                int r6 = r6 + r3
            L_0x01bd:
                if (r17 == 0) goto L_0x01e0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mRight
                r3.connect(r10, r6)
                if (r19 == 0) goto L_0x01d1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.mLeft
                int r10 = r0.mPaddingRight
                r3.connect(r6, r10)
            L_0x01d1:
                if (r18 <= 0) goto L_0x0200
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.mRight
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r2.mRight
                r10 = 0
                r3.connect(r6, r10)
                goto L_0x0200
            L_0x01e0:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mLeft
                r3.connect(r10, r6)
                if (r19 == 0) goto L_0x01f2
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.mRight
                int r10 = r0.mPaddingRight
                r3.connect(r6, r10)
            L_0x01f2:
                if (r18 <= 0) goto L_0x0200
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.mLeft
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r2.mLeft
                r10 = 0
                r3.connect(r6, r10)
            L_0x0200:
                r13 = 0
            L_0x0201:
                if (r13 >= r1) goto L_0x02f4
                int r3 = r0.mStartIndex
                int r3 = r3 + r13
                androidx.constraintlayout.core.widgets.Flow r6 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r6.mDisplayedWidgetsCount
                if (r3 < r10) goto L_0x020e
                goto L_0x02f4
            L_0x020e:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r6 = r6.mDisplayedWidgets
                r3 = r6[r3]
                if (r13 != 0) goto L_0x023f
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mTop
                int r11 = r0.mPaddingTop
                r3.connect(r6, r10, r11)
                androidx.constraintlayout.core.widgets.Flow r6 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r6.mVerticalStyle
                float r11 = r6.mVerticalBias
                int r12 = r0.mStartIndex
                if (r12 != 0) goto L_0x0230
                int r12 = r6.mFirstVerticalStyle
                if (r12 == r5) goto L_0x0230
                float r6 = r6.mFirstVerticalBias
            L_0x022d:
                r11 = r6
                r10 = r12
                goto L_0x023b
            L_0x0230:
                if (r19 == 0) goto L_0x023b
                androidx.constraintlayout.core.widgets.Flow r6 = androidx.constraintlayout.core.widgets.Flow.this
                int r12 = r6.mLastVerticalStyle
                if (r12 == r5) goto L_0x023b
                float r6 = r6.mLastVerticalBias
                goto L_0x022d
            L_0x023b:
                r3.mVerticalChainStyle = r10
                r3.mVerticalBiasPercent = r11
            L_0x023f:
                int r6 = r1 + -1
                if (r13 != r6) goto L_0x024c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.mBottom
                int r11 = r0.mPaddingBottom
                r3.connect(r6, r10, r11)
            L_0x024c:
                if (r9 == 0) goto L_0x0276
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mTop
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r9.mBottom
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.mVerticalGap
                r6.connect(r10, r11)
                if (r13 != r7) goto L_0x0262
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mTop
                int r10 = r0.mPaddingTop
                r6.setGoneMargin(r10)
            L_0x0262:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r9.mBottom
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mTop
                r11 = 0
                r6.connect(r10, r11)
                r6 = 1
                int r10 = r8 + 1
                if (r13 != r10) goto L_0x0276
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r9.mBottom
                int r9 = r0.mPaddingBottom
                r6.setGoneMargin(r9)
            L_0x0276:
                if (r3 == r2) goto L_0x02ed
                r6 = 2
                if (r17 == 0) goto L_0x02a9
                androidx.constraintlayout.core.widgets.Flow r9 = androidx.constraintlayout.core.widgets.Flow.this
                int r9 = r9.mHorizontalAlign
                if (r9 == 0) goto L_0x02a0
                r10 = 1
                if (r9 == r10) goto L_0x0297
                if (r9 == r6) goto L_0x0287
                goto L_0x02ed
            L_0x0287:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mLeft
                r10 = 0
                r6.connect(r9, r10)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mRight
                r6.connect(r9, r10)
                goto L_0x02ed
            L_0x0297:
                r10 = 0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mLeft
                r6.connect(r9, r10)
                goto L_0x02ed
            L_0x02a0:
                r10 = 0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mRight
                r6.connect(r9, r10)
                goto L_0x02ed
            L_0x02a9:
                androidx.constraintlayout.core.widgets.Flow r9 = androidx.constraintlayout.core.widgets.Flow.this
                int r9 = r9.mHorizontalAlign
                if (r9 == 0) goto L_0x02e3
                r10 = 1
                if (r9 == r10) goto L_0x02da
                if (r9 == r6) goto L_0x02b5
                goto L_0x02ee
            L_0x02b5:
                if (r4 == 0) goto L_0x02ca
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.mLeft
                int r11 = r0.mPaddingLeft
                r6.connect(r9, r11)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.mRight
                int r11 = r0.mPaddingRight
                r6.connect(r9, r11)
                goto L_0x02ee
            L_0x02ca:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mLeft
                r11 = 0
                r6.connect(r9, r11)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mRight
                r6.connect(r9, r11)
                goto L_0x02ef
            L_0x02da:
                r11 = 0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mRight
                r6.connect(r9, r11)
                goto L_0x02ef
            L_0x02e3:
                r10 = 1
                r11 = 0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.mLeft
                r6.connect(r9, r11)
                goto L_0x02ef
            L_0x02ed:
                r10 = 1
            L_0x02ee:
                r11 = 0
            L_0x02ef:
                int r13 = r13 + 1
                r9 = r3
                goto L_0x0201
            L_0x02f4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.WidgetsList.createConstraints(boolean, int, boolean):void");
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public void measureMatchConstraints(int i) {
            int i2 = this.mNbMatchConstraintsWidgets;
            if (i2 != 0) {
                int i3 = this.mCount;
                int i4 = i / i2;
                for (int i5 = 0; i5 < i3; i5++) {
                    int i6 = this.mStartIndex;
                    int i7 = i6 + i5;
                    Flow flow = Flow.this;
                    if (i7 >= flow.mDisplayedWidgetsCount) {
                        break;
                    }
                    ConstraintWidget constraintWidget = flow.mDisplayedWidgets[i6 + i5];
                    if (this.mOrientation == 0) {
                        if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            Flow.this.measure(constraintWidget, DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                        }
                    } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), DimensionBehaviour.FIXED, i4);
                    }
                }
                this.mWidth = 0;
                this.mHeight = 0;
                this.biggest = null;
                this.biggestDimension = 0;
                int i8 = this.mCount;
                for (int i9 = 0; i9 < i8; i9++) {
                    int i10 = this.mStartIndex + i9;
                    Flow flow2 = Flow.this;
                    if (i10 >= flow2.mDisplayedWidgetsCount) {
                        break;
                    }
                    ConstraintWidget constraintWidget2 = flow2.mDisplayedWidgets[i10];
                    if (this.mOrientation == 0) {
                        int width = constraintWidget2.getWidth();
                        int i11 = Flow.this.mHorizontalGap;
                        if (constraintWidget2.mVisibility == 8) {
                            i11 = 0;
                        }
                        this.mWidth = width + i11 + this.mWidth;
                        int widgetHeight = Flow.this.getWidgetHeight(constraintWidget2, this.mMax);
                        if (this.biggest == null || this.biggestDimension < widgetHeight) {
                            this.biggest = constraintWidget2;
                            this.biggestDimension = widgetHeight;
                            this.mHeight = widgetHeight;
                        }
                    } else {
                        int widgetWidth = flow2.getWidgetWidth(constraintWidget2, this.mMax);
                        int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget2, this.mMax);
                        int i12 = Flow.this.mVerticalGap;
                        if (constraintWidget2.mVisibility == 8) {
                            i12 = 0;
                        }
                        this.mHeight = widgetHeight2 + i12 + this.mHeight;
                        if (this.biggest == null || this.biggestDimension < widgetWidth) {
                            this.biggest = constraintWidget2;
                            this.biggestDimension = widgetWidth;
                            this.mWidth = widgetWidth;
                        }
                    }
                }
            }
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
            this.mMax = i6;
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean z) {
        float f2;
        int i;
        super.addToSolver(linearSystem, z);
        ConstraintWidget constraintWidget = this.mParent;
        boolean z2 = constraintWidget != null && ((ConstraintWidgetContainer) constraintWidget).mIsRtl;
        int i2 = this.mWrapMode;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = this.mChainList.size();
                int i3 = 0;
                while (i3 < size) {
                    this.mChainList.get(i3).createConstraints(z2, i3, i3 == size + -1);
                    i3++;
                }
            } else if (!(i2 != 2 || this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null)) {
                for (int i4 = 0; i4 < this.mDisplayedWidgetsCount; i4++) {
                    this.mDisplayedWidgets[i4].resetAnchors();
                }
                int[] iArr = this.mAlignedDimensions;
                int i5 = iArr[0];
                int i6 = iArr[1];
                ConstraintWidget constraintWidget2 = null;
                float f3 = this.mHorizontalBias;
                int i7 = 0;
                while (i7 < i5) {
                    if (z2) {
                        i = (i5 - i7) - 1;
                        f2 = 1.0f - this.mHorizontalBias;
                    } else {
                        f2 = f3;
                        i = i7;
                    }
                    ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i];
                    if (!(constraintWidget3 == null || constraintWidget3.mVisibility == 8)) {
                        if (i7 == 0) {
                            constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, this.mResolvedPaddingLeft);
                            constraintWidget3.mHorizontalChainStyle = this.mHorizontalStyle;
                            constraintWidget3.mHorizontalBiasPercent = f2;
                        }
                        if (i7 == i5 - 1) {
                            constraintWidget3.connect(constraintWidget3.mRight, this.mRight, this.mResolvedPaddingRight);
                        }
                        if (i7 > 0 && constraintWidget2 != null) {
                            constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                            constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                        }
                        constraintWidget2 = constraintWidget3;
                    }
                    i7++;
                    f3 = f2;
                }
                for (int i8 = 0; i8 < i6; i8++) {
                    ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i8];
                    if (!(constraintWidget4 == null || constraintWidget4.mVisibility == 8)) {
                        if (i8 == 0) {
                            constraintWidget4.connect(constraintWidget4.mTop, this.mTop, this.mPaddingTop);
                            constraintWidget4.mVerticalChainStyle = this.mVerticalStyle;
                            constraintWidget4.mVerticalBiasPercent = this.mVerticalBias;
                        }
                        if (i8 == i6 - 1) {
                            constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (i8 > 0 && constraintWidget2 != null) {
                            constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                            constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                        }
                        constraintWidget2 = constraintWidget4;
                    }
                }
                for (int i9 = 0; i9 < i5; i9++) {
                    for (int i10 = 0; i10 < i6; i10++) {
                        int i11 = (i10 * i5) + i9;
                        if (this.mOrientation == 1) {
                            i11 = (i9 * i6) + i10;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                        if (i11 < constraintWidgetArr.length) {
                            ConstraintWidget constraintWidget5 = constraintWidgetArr[i11];
                            if (!(constraintWidget5 == null || constraintWidget5.mVisibility == 8)) {
                                ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInCols[i9];
                                ConstraintWidget constraintWidget7 = this.mAlignedBiggestElementsInRows[i10];
                                if (constraintWidget5 != constraintWidget6) {
                                    constraintWidget5.connect(constraintWidget5.mLeft, constraintWidget6.mLeft, 0);
                                    constraintWidget5.connect(constraintWidget5.mRight, constraintWidget6.mRight, 0);
                                }
                                if (constraintWidget5 != constraintWidget7) {
                                    constraintWidget5.connect(constraintWidget5.mTop, constraintWidget7.mTop, 0);
                                    constraintWidget5.connect(constraintWidget5.mBottom, constraintWidget7.mBottom, 0);
                                }
                            }
                        }
                    }
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z2, 0, true);
        }
        this.mNeedsCallFromSolver = false;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * ((float) i));
                if (i3 != constraintWidget.getHeight()) {
                    constraintWidget.mMeasureRequested = true;
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), DimensionBehaviour.FIXED, i3);
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getHeight();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * ((float) i));
                if (i3 != constraintWidget.getWidth()) {
                    constraintWidget.mMeasureRequested = true;
                    measure(constraintWidget, DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getWidth();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x029b A[SYNTHETIC] */
    public void measure(int r34, int r35, int r36, int r37) {
        /*
            r33 = this;
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            int r0 = r8.mWidgetsCount
            r13 = 1
            r14 = 0
            if (r0 <= 0) goto L_0x0096
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mParent
            if (r0 == 0) goto L_0x0019
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r0.mMeasurer
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            if (r0 != 0) goto L_0x001f
            r0 = 0
            goto L_0x008d
        L_0x001f:
            r2 = 0
        L_0x0020:
            int r3 = r8.mWidgetsCount
            if (r2 >= r3) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r8.mWidgets
            r3 = r3[r2]
            if (r3 != 0) goto L_0x002b
            goto L_0x0089
        L_0x002b:
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r4 == 0) goto L_0x0030
            goto L_0x0089
        L_0x0030:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r3.getDimensionBehaviour(r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = r3.getDimensionBehaviour(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x0048
            int r7 = r3.mMatchConstraintDefaultWidth
            if (r7 == r13) goto L_0x0048
            if (r5 != r6) goto L_0x0048
            int r6 = r3.mMatchConstraintDefaultHeight
            if (r6 == r13) goto L_0x0048
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            if (r6 == 0) goto L_0x004c
            goto L_0x0089
        L_0x004c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x0052
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x0052:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0058
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x0058:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r6 = r8.mMeasure
            r6.horizontalBehavior = r4
            r6.verticalBehavior = r5
            int r4 = r3.getWidth()
            r6.horizontalDimension = r4
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r8.mMeasure
            int r5 = r3.getHeight()
            r4.verticalDimension = r5
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r8.mMeasure
            r5 = r0
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r5 = (androidx.constraintlayout.widget.ConstraintLayout.Measurer) r5
            r5.measure(r3, r4)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r8.mMeasure
            int r4 = r4.measuredWidth
            r3.setWidth(r4)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r8.mMeasure
            int r4 = r4.measuredHeight
            r3.setHeight(r4)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r8.mMeasure
            int r4 = r4.measuredBaseline
            r3.setBaselineDistance(r4)
        L_0x0089:
            int r2 = r2 + 1
            goto L_0x0020
        L_0x008c:
            r0 = 1
        L_0x008d:
            if (r0 != 0) goto L_0x0096
            r8.mMeasuredWidth = r14
            r8.mMeasuredHeight = r14
            r8.mNeedsCallFromSolver = r14
            return
        L_0x0096:
            int r15 = r8.mResolvedPaddingLeft
            int r7 = r8.mResolvedPaddingRight
            int r6 = r8.mPaddingTop
            int r5 = r8.mPaddingBottom
            r0 = 2
            int[] r4 = new int[r0]
            int r2 = r10 - r15
            int r2 = r2 - r7
            int r3 = r8.mOrientation
            if (r3 != r13) goto L_0x00ab
            int r2 = r12 - r6
            int r2 = r2 - r5
        L_0x00ab:
            r3 = r2
            int r2 = r8.mOrientation
            r1 = -1
            if (r2 != 0) goto L_0x00be
            int r2 = r8.mHorizontalStyle
            if (r2 != r1) goto L_0x00b7
            r8.mHorizontalStyle = r14
        L_0x00b7:
            int r2 = r8.mVerticalStyle
            if (r2 != r1) goto L_0x00ca
            r8.mVerticalStyle = r14
            goto L_0x00ca
        L_0x00be:
            int r2 = r8.mHorizontalStyle
            if (r2 != r1) goto L_0x00c4
            r8.mHorizontalStyle = r14
        L_0x00c4:
            int r2 = r8.mVerticalStyle
            if (r2 != r1) goto L_0x00ca
            r8.mVerticalStyle = r14
        L_0x00ca:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r8.mWidgets
            r2 = 0
            r17 = 0
        L_0x00cf:
            int r14 = r8.mWidgetsCount
            r0 = 8
            if (r2 >= r14) goto L_0x00e3
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r8.mWidgets
            r14 = r14[r2]
            int r14 = r14.mVisibility
            if (r14 != r0) goto L_0x00df
            int r17 = r17 + 1
        L_0x00df:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x00cf
        L_0x00e3:
            if (r17 <= 0) goto L_0x0106
            int r14 = r14 - r17
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r14]
            r2 = 0
            r14 = 0
        L_0x00eb:
            int r13 = r8.mWidgetsCount
            if (r2 >= r13) goto L_0x0106
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r8.mWidgets
            r13 = r13[r2]
            int r0 = r13.mVisibility
            r19 = r4
            r4 = 8
            if (r0 == r4) goto L_0x00ff
            r1[r14] = r13
            int r14 = r14 + 1
        L_0x00ff:
            int r2 = r2 + 1
            r4 = r19
            r0 = 8
            goto L_0x00eb
        L_0x0106:
            r19 = r4
            r13 = r1
            r8.mDisplayedWidgets = r13
            r8.mDisplayedWidgetsCount = r14
            int r0 = r8.mWrapMode
            if (r0 == 0) goto L_0x04ec
            r1 = 1
            if (r0 == r1) goto L_0x02b3
            r1 = 2
            if (r0 == r1) goto L_0x0125
            r29 = r5
            r30 = r6
            r32 = r7
            r27 = r15
            r28 = r19
        L_0x0121:
            r1 = 0
            r2 = 1
            goto L_0x0577
        L_0x0125:
            int r0 = r8.mOrientation
            if (r0 != 0) goto L_0x0155
            int r1 = r8.mMaxElementsWrap
            if (r1 > 0) goto L_0x0150
            r1 = 0
            r2 = 0
            r4 = 0
        L_0x0130:
            r17 = r5
            if (r1 >= r14) goto L_0x014e
            if (r1 <= 0) goto L_0x0139
            int r5 = r8.mHorizontalGap
            int r2 = r2 + r5
        L_0x0139:
            r5 = r13[r1]
            if (r5 != 0) goto L_0x013e
            goto L_0x0149
        L_0x013e:
            int r5 = r8.getWidgetWidth(r5, r3)
            int r5 = r5 + r2
            if (r5 <= r3) goto L_0x0146
            goto L_0x014e
        L_0x0146:
            int r4 = r4 + 1
            r2 = r5
        L_0x0149:
            int r1 = r1 + 1
            r5 = r17
            goto L_0x0130
        L_0x014e:
            r1 = r4
            goto L_0x0152
        L_0x0150:
            r17 = r5
        L_0x0152:
            r2 = r1
            r1 = 0
            goto L_0x017a
        L_0x0155:
            r17 = r5
            int r1 = r8.mMaxElementsWrap
            if (r1 > 0) goto L_0x0179
            r1 = 0
            r2 = 0
            r4 = 0
        L_0x015e:
            if (r1 >= r14) goto L_0x0178
            if (r1 <= 0) goto L_0x0165
            int r5 = r8.mVerticalGap
            int r2 = r2 + r5
        L_0x0165:
            r5 = r13[r1]
            if (r5 != 0) goto L_0x016a
            goto L_0x0175
        L_0x016a:
            int r5 = r8.getWidgetHeight(r5, r3)
            int r5 = r5 + r2
            if (r5 <= r3) goto L_0x0172
            goto L_0x0178
        L_0x0172:
            int r4 = r4 + 1
            r2 = r5
        L_0x0175:
            int r1 = r1 + 1
            goto L_0x015e
        L_0x0178:
            r1 = r4
        L_0x0179:
            r2 = 0
        L_0x017a:
            int[] r4 = r8.mAlignedDimensions
            if (r4 != 0) goto L_0x0183
            r4 = 2
            int[] r4 = new int[r4]
            r8.mAlignedDimensions = r4
        L_0x0183:
            if (r1 != 0) goto L_0x0188
            r4 = 1
            if (r0 == r4) goto L_0x018c
        L_0x0188:
            if (r2 != 0) goto L_0x0196
            if (r0 != 0) goto L_0x0196
        L_0x018c:
            r22 = r6
            r21 = r7
            r5 = r8
            r18 = r19
            r4 = 1
            goto L_0x0295
        L_0x0196:
            r5 = r8
            r18 = r19
            r4 = 0
        L_0x019a:
            if (r4 != 0) goto L_0x029b
            if (r0 != 0) goto L_0x01ae
            float r1 = (float) r14
            r20 = r4
            float r4 = (float) r2
            float r1 = r1 / r4
            r22 = r6
            r21 = r7
            double r6 = (double) r1
            double r6 = java.lang.Math.ceil(r6)
            int r1 = (int) r6
            goto L_0x01bd
        L_0x01ae:
            r20 = r4
            r22 = r6
            r21 = r7
            float r2 = (float) r14
            float r4 = (float) r1
            float r2 = r2 / r4
            double r6 = (double) r2
            double r6 = java.lang.Math.ceil(r6)
            int r2 = (int) r6
        L_0x01bd:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r5.mAlignedBiggestElementsInCols
            if (r4 == 0) goto L_0x01ca
            int r6 = r4.length
            if (r6 >= r2) goto L_0x01c5
            goto L_0x01ca
        L_0x01c5:
            r6 = 0
            java.util.Arrays.fill(r4, r6)
            goto L_0x01cf
        L_0x01ca:
            r6 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r2]
            r5.mAlignedBiggestElementsInCols = r4
        L_0x01cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r5.mAlignedBiggestElementsInRows
            if (r4 == 0) goto L_0x01db
            int r7 = r4.length
            if (r7 >= r1) goto L_0x01d7
            goto L_0x01db
        L_0x01d7:
            java.util.Arrays.fill(r4, r6)
            goto L_0x01df
        L_0x01db:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r1]
            r5.mAlignedBiggestElementsInRows = r4
        L_0x01df:
            r4 = 0
        L_0x01e0:
            if (r4 >= r2) goto L_0x023c
            r6 = 0
        L_0x01e3:
            if (r6 >= r1) goto L_0x0235
            int r7 = r6 * r2
            int r7 = r7 + r4
            r23 = r7
            r7 = 1
            if (r0 != r7) goto L_0x01f1
            int r7 = r4 * r1
            int r7 = r7 + r6
            goto L_0x01f3
        L_0x01f1:
            r7 = r23
        L_0x01f3:
            r23 = r14
            int r14 = r13.length
            if (r7 < r14) goto L_0x01fb
        L_0x01f8:
            r24 = r13
            goto L_0x022e
        L_0x01fb:
            r7 = r13[r7]
            if (r7 != 0) goto L_0x0200
            goto L_0x01f8
        L_0x0200:
            int r14 = r5.getWidgetWidth(r7, r3)
            r24 = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r5.mAlignedBiggestElementsInCols
            r25 = r13[r4]
            if (r25 == 0) goto L_0x0214
            r13 = r13[r4]
            int r13 = r13.getWidth()
            if (r13 >= r14) goto L_0x0218
        L_0x0214:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r5.mAlignedBiggestElementsInCols
            r13[r4] = r7
        L_0x0218:
            int r13 = r5.getWidgetHeight(r7, r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r5.mAlignedBiggestElementsInRows
            r25 = r14[r6]
            if (r25 == 0) goto L_0x022a
            r14 = r14[r6]
            int r14 = r14.getHeight()
            if (r14 >= r13) goto L_0x022e
        L_0x022a:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r5.mAlignedBiggestElementsInRows
            r13[r6] = r7
        L_0x022e:
            int r6 = r6 + 1
            r14 = r23
            r13 = r24
            goto L_0x01e3
        L_0x0235:
            r24 = r13
            r23 = r14
            int r4 = r4 + 1
            goto L_0x01e0
        L_0x023c:
            r24 = r13
            r23 = r14
            r4 = 0
            r6 = 0
        L_0x0242:
            if (r4 >= r2) goto L_0x0258
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r5.mAlignedBiggestElementsInCols
            r7 = r7[r4]
            if (r7 == 0) goto L_0x0255
            if (r4 <= 0) goto L_0x024f
            int r13 = r5.mHorizontalGap
            int r6 = r6 + r13
        L_0x024f:
            int r7 = r5.getWidgetWidth(r7, r3)
            int r7 = r7 + r6
            r6 = r7
        L_0x0255:
            int r4 = r4 + 1
            goto L_0x0242
        L_0x0258:
            r4 = 0
            r7 = 0
        L_0x025a:
            if (r4 >= r1) goto L_0x0270
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r5.mAlignedBiggestElementsInRows
            r13 = r13[r4]
            if (r13 == 0) goto L_0x026d
            if (r4 <= 0) goto L_0x0267
            int r14 = r5.mVerticalGap
            int r7 = r7 + r14
        L_0x0267:
            int r13 = r5.getWidgetHeight(r13, r3)
            int r13 = r13 + r7
            r7 = r13
        L_0x026d:
            int r4 = r4 + 1
            goto L_0x025a
        L_0x0270:
            r4 = 0
            r18[r4] = r6
            r4 = 1
            r18[r4] = r7
            if (r0 != 0) goto L_0x027f
            if (r6 <= r3) goto L_0x0291
            if (r2 <= r4) goto L_0x0291
            int r2 = r2 + -1
            goto L_0x0285
        L_0x027f:
            if (r7 <= r3) goto L_0x0291
            if (r1 <= r4) goto L_0x0291
            int r1 = r1 + -1
        L_0x0285:
            r4 = r20
            r7 = r21
            r6 = r22
            r14 = r23
            r13 = r24
            goto L_0x019a
        L_0x0291:
            r14 = r23
            r13 = r24
        L_0x0295:
            r7 = r21
            r6 = r22
            goto L_0x019a
        L_0x029b:
            r22 = r6
            r21 = r7
            r4 = 1
            int[] r0 = r5.mAlignedDimensions
            r3 = 0
            r0[r3] = r2
            r0[r4] = r1
        L_0x02a7:
            r27 = r15
            r29 = r17
            r28 = r19
            r32 = r21
            r30 = r22
            goto L_0x0121
        L_0x02b3:
            r17 = r5
            r22 = r6
            r21 = r7
            int r7 = r8.mOrientation
            if (r14 != 0) goto L_0x02be
            goto L_0x02a7
        L_0x02be:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r0 = r8.mChainList
            r0.clear()
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r6 = new androidx.constraintlayout.core.widgets.Flow$WidgetsList
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r8.mBottom
            r0 = r6
            r16 = r1
            r1 = r33
            r18 = r2
            r2 = r7
            r27 = r3
            r3 = r4
            r28 = r19
            r4 = r5
            r29 = r17
            r5 = r18
            r12 = r6
            r30 = r22
            r6 = r16
            r31 = r7
            r32 = r21
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r0 = r8.mChainList
            r0.add(r12)
            if (r31 != 0) goto L_0x0370
            r6 = r12
            r0 = 0
            r1 = 0
            r12 = 0
        L_0x02f8:
            if (r12 >= r14) goto L_0x03dd
            r7 = r13[r12]
            r5 = r27
            int r16 = r8.getWidgetWidth(r7, r5)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r7.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x030c
            int r0 = r0 + 1
        L_0x030c:
            r17 = r0
            if (r1 == r5) goto L_0x0317
            int r0 = r8.mHorizontalGap
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r5) goto L_0x031d
        L_0x0317:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r6.biggest
            if (r0 == 0) goto L_0x031d
            r0 = 1
            goto L_0x031e
        L_0x031d:
            r0 = 0
        L_0x031e:
            if (r0 != 0) goto L_0x032b
            if (r12 <= 0) goto L_0x032b
            int r2 = r8.mMaxElementsWrap
            if (r2 <= 0) goto L_0x032b
            int r2 = r12 % r2
            if (r2 != 0) goto L_0x032b
            r0 = 1
        L_0x032b:
            if (r0 == 0) goto L_0x0356
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r6 = new androidx.constraintlayout.core.widgets.Flow$WidgetsList
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r8.mBottom
            r0 = r6
            r18 = r1
            r1 = r33
            r19 = r2
            r2 = r31
            r27 = r5
            r5 = r19
            r11 = r6
            r6 = r18
            r10 = r7
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r11.mStartIndex = r12
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r0 = r8.mChainList
            r0.add(r11)
            r6 = r11
            goto L_0x0362
        L_0x0356:
            r27 = r5
            r10 = r7
            if (r12 <= 0) goto L_0x0362
            int r0 = r8.mHorizontalGap
            int r0 = r0 + r16
            int r0 = r0 + r1
            r1 = r0
            goto L_0x0364
        L_0x0362:
            r1 = r16
        L_0x0364:
            r6.add(r10)
            int r12 = r12 + 1
            r10 = r35
            r11 = r36
            r0 = r17
            goto L_0x02f8
        L_0x0370:
            r6 = r12
            r0 = 0
            r1 = 0
            r10 = 0
        L_0x0374:
            if (r10 >= r14) goto L_0x03dd
            r11 = r13[r10]
            r12 = r27
            int r16 = r8.getWidgetHeight(r11, r12)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r11.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x0388
            int r0 = r0 + 1
        L_0x0388:
            r17 = r0
            if (r1 == r12) goto L_0x0393
            int r0 = r8.mVerticalGap
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r12) goto L_0x0399
        L_0x0393:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r6.biggest
            if (r0 == 0) goto L_0x0399
            r0 = 1
            goto L_0x039a
        L_0x0399:
            r0 = 0
        L_0x039a:
            if (r0 != 0) goto L_0x03a7
            if (r10 <= 0) goto L_0x03a7
            int r2 = r8.mMaxElementsWrap
            if (r2 <= 0) goto L_0x03a7
            int r2 = r10 % r2
            if (r2 != 0) goto L_0x03a7
            r0 = 1
        L_0x03a7:
            if (r0 == 0) goto L_0x03c6
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r7 = new androidx.constraintlayout.core.widgets.Flow$WidgetsList
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.mBottom
            r0 = r7
            r1 = r33
            r2 = r31
            r9 = r7
            r7 = r12
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r9.mStartIndex = r10
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r0 = r8.mChainList
            r0.add(r9)
            r6 = r9
            goto L_0x03cf
        L_0x03c6:
            if (r10 <= 0) goto L_0x03cf
            int r0 = r8.mVerticalGap
            int r0 = r0 + r16
            int r0 = r0 + r1
            r1 = r0
            goto L_0x03d1
        L_0x03cf:
            r1 = r16
        L_0x03d1:
            r6.add(r11)
            int r10 = r10 + 1
            r9 = r34
            r27 = r12
            r0 = r17
            goto L_0x0374
        L_0x03dd:
            r12 = r27
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r1 = r8.mChainList
            int r1 = r1.size()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.mBottom
            int r6 = r8.mResolvedPaddingLeft
            int r7 = r8.mPaddingTop
            int r9 = r8.mResolvedPaddingRight
            int r10 = r8.mPaddingBottom
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r33.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 == r13) goto L_0x0408
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r33.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r13) goto L_0x0406
            goto L_0x0408
        L_0x0406:
            r11 = 0
            goto L_0x0409
        L_0x0408:
            r11 = 1
        L_0x0409:
            if (r0 <= 0) goto L_0x0430
            if (r11 == 0) goto L_0x0430
            r0 = 0
        L_0x040e:
            if (r0 >= r1) goto L_0x0430
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r11 = r8.mChainList
            java.lang.Object r11 = r11.get(r0)
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r11 = (androidx.constraintlayout.core.widgets.Flow.WidgetsList) r11
            if (r31 != 0) goto L_0x0424
            int r13 = r11.getWidth()
            int r13 = r12 - r13
            r11.measureMatchConstraints(r13)
            goto L_0x042d
        L_0x0424:
            int r13 = r11.getHeight()
            int r13 = r12 - r13
            r11.measureMatchConstraints(r13)
        L_0x042d:
            int r0 = r0 + 1
            goto L_0x040e
        L_0x0430:
            r0 = 0
            r11 = 0
            r13 = 0
        L_0x0433:
            if (r0 >= r1) goto L_0x04e2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r14 = r8.mChainList
            java.lang.Object r14 = r14.get(r0)
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r14 = (androidx.constraintlayout.core.widgets.Flow.WidgetsList) r14
            if (r31 != 0) goto L_0x048f
            int r5 = r1 + -1
            if (r0 >= r5) goto L_0x0455
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r5 = r8.mChainList
            int r10 = r0 + 1
            java.lang.Object r5 = r5.get(r10)
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r5 = (androidx.constraintlayout.core.widgets.Flow.WidgetsList) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.biggest
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTop
            r27 = r15
            r10 = 0
            goto L_0x045b
        L_0x0455:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.mBottom
            int r10 = r8.mPaddingBottom
            r27 = r15
        L_0x045b:
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = r14.biggest
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r15.mBottom
            r16 = r14
            r17 = r31
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r9
            r25 = r10
            r26 = r12
            r16.setup(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r3 = r14.getWidth()
            int r3 = java.lang.Math.max(r13, r3)
            int r7 = r14.getHeight()
            int r7 = r7 + r11
            if (r0 <= 0) goto L_0x048a
            int r11 = r8.mVerticalGap
            int r7 = r7 + r11
        L_0x048a:
            r13 = r3
            r11 = r7
            r3 = r15
            r7 = 0
            goto L_0x04dc
        L_0x048f:
            r27 = r15
            int r4 = r1 + -1
            if (r0 >= r4) goto L_0x04a5
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r4 = r8.mChainList
            int r9 = r0 + 1
            java.lang.Object r4 = r4.get(r9)
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r4 = (androidx.constraintlayout.core.widgets.Flow.WidgetsList) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.biggest
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mLeft
            r9 = 0
            goto L_0x04a9
        L_0x04a5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.mRight
            int r9 = r8.mResolvedPaddingRight
        L_0x04a9:
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = r14.biggest
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r15.mRight
            r16 = r14
            r17 = r31
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r9
            r25 = r10
            r26 = r12
            r16.setup(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r2 = r14.getWidth()
            int r2 = r2 + r13
            int r6 = r14.getHeight()
            int r6 = java.lang.Math.max(r11, r6)
            if (r0 <= 0) goto L_0x04d8
            int r11 = r8.mHorizontalGap
            int r2 = r2 + r11
        L_0x04d8:
            r13 = r2
            r11 = r6
            r2 = r15
            r6 = 0
        L_0x04dc:
            int r0 = r0 + 1
            r15 = r27
            goto L_0x0433
        L_0x04e2:
            r27 = r15
            r0 = 0
            r28[r0] = r13
            r0 = 1
            r28[r0] = r11
            goto L_0x0121
        L_0x04ec:
            r12 = r3
            r29 = r5
            r30 = r6
            r32 = r7
            r27 = r15
            r28 = r19
            int r2 = r8.mOrientation
            if (r14 != 0) goto L_0x04fd
            goto L_0x0121
        L_0x04fd:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r0 = r8.mChainList
            int r0 = r0.size()
            if (r0 != 0) goto L_0x051c
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r9 = new androidx.constraintlayout.core.widgets.Flow$WidgetsList
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.mBottom
            r0 = r9
            r1 = r33
            r7 = r12
            r0.<init>(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r0 = r8.mChainList
            r0.add(r9)
            goto L_0x055e
        L_0x051c:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.Flow$WidgetsList> r0 = r8.mChainList
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r9 = r0
            androidx.constraintlayout.core.widgets.Flow$WidgetsList r9 = (androidx.constraintlayout.core.widgets.Flow.WidgetsList) r9
            r9.biggestDimension = r1
            r0 = 0
            r9.biggest = r0
            r9.mWidth = r1
            r9.mHeight = r1
            r9.mStartIndex = r1
            r9.mCount = r1
            r9.mNbMatchConstraintsWidgets = r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r8.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r8.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.mBottom
            int r5 = r8.mResolvedPaddingLeft
            int r6 = r8.mPaddingTop
            int r7 = r8.mResolvedPaddingRight
            int r10 = r8.mPaddingBottom
            r16 = r9
            r17 = r2
            r18 = r0
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r10
            r26 = r12
            r16.setup(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x055e:
            r4 = 0
        L_0x055f:
            if (r4 >= r14) goto L_0x0569
            r0 = r13[r4]
            r9.add(r0)
            int r4 = r4 + 1
            goto L_0x055f
        L_0x0569:
            int r0 = r9.getWidth()
            r1 = 0
            r28[r1] = r0
            int r0 = r9.getHeight()
            r2 = 1
            r28[r2] = r0
        L_0x0577:
            r0 = r28[r1]
            int r0 = r0 + r27
            int r0 = r0 + r32
            r3 = r28[r2]
            int r3 = r3 + r30
            int r3 = r3 + r29
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = r34
            if (r6 != r5) goto L_0x0590
            r0 = r35
        L_0x058d:
            r6 = r36
            goto L_0x059f
        L_0x0590:
            if (r6 != r4) goto L_0x0599
            r7 = r35
            int r0 = java.lang.Math.min(r0, r7)
            goto L_0x058d
        L_0x0599:
            if (r6 != 0) goto L_0x059c
            goto L_0x058d
        L_0x059c:
            r6 = r36
            r0 = 0
        L_0x059f:
            if (r6 != r5) goto L_0x05a4
            r3 = r37
            goto L_0x05b1
        L_0x05a4:
            if (r6 != r4) goto L_0x05ad
            r4 = r37
            int r3 = java.lang.Math.min(r3, r4)
            goto L_0x05b1
        L_0x05ad:
            if (r6 != 0) goto L_0x05b0
            goto L_0x05b1
        L_0x05b0:
            r3 = 0
        L_0x05b1:
            r8.mMeasuredWidth = r0
            r8.mMeasuredHeight = r3
            r8.setWidth(r0)
            r8.setHeight(r3)
            int r0 = r8.mWidgetsCount
            if (r0 <= 0) goto L_0x05c1
            r13 = 1
            goto L_0x05c2
        L_0x05c1:
            r13 = 0
        L_0x05c2:
            r8.mNeedsCallFromSolver = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measure(int, int, int, int):void");
    }
}
