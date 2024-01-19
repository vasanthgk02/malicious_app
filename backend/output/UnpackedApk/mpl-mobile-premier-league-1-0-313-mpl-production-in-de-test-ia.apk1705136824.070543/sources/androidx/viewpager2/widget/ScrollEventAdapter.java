package androidx.viewpager2.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

public final class ScrollEventAdapter extends OnScrollListener {
    public int mAdapterState;
    public OnPageChangeCallback mCallback;
    public boolean mDataSetChangeHappened;
    public boolean mDispatchSelected;
    public int mDragStartPosition;
    public boolean mFakeDragging;
    public final LinearLayoutManager mLayoutManager;
    public final RecyclerView mRecyclerView;
    public boolean mScrollHappened;
    public int mScrollState;
    public ScrollEventValues mScrollValues = new ScrollEventValues();
    public int mTarget;
    public final ViewPager2 mViewPager;

    public static final class ScrollEventValues {
        public float mOffset;
        public int mOffsetPx;
        public int mPosition;

        public void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        resetState();
    }

    public final void dispatchSelected(int i) {
        OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    public final void dispatchStateChanged(int i) {
        if ((this.mAdapterState != 3 || this.mScrollState != 0) && this.mScrollState != i) {
            this.mScrollState = i;
            OnPageChangeCallback onPageChangeCallback = this.mCallback;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i);
            }
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.mAdapterState == 1 && this.mScrollState == 1) && i == 1) {
            this.mFakeDragging = false;
            this.mAdapterState = 1;
            int i2 = this.mTarget;
            if (i2 != -1) {
                this.mDragStartPosition = i2;
                this.mTarget = -1;
            } else if (this.mDragStartPosition == -1) {
                this.mDragStartPosition = this.mLayoutManager.findFirstVisibleItemPosition();
            }
            dispatchStateChanged(1);
            return;
        }
        int i3 = this.mAdapterState;
        if (!(i3 == 1 || i3 == 4) || i != 2) {
            int i4 = this.mAdapterState;
            if ((i4 == 1 || i4 == 4) && i == 0) {
                updateScrollEventValues();
                if (!this.mScrollHappened) {
                    int i5 = this.mScrollValues.mPosition;
                    if (i5 != -1) {
                        OnPageChangeCallback onPageChangeCallback = this.mCallback;
                        if (onPageChangeCallback != null) {
                            onPageChangeCallback.onPageScrolled(i5, 0.0f, 0);
                        }
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.mScrollValues;
                    if (scrollEventValues.mOffsetPx == 0) {
                        int i6 = this.mDragStartPosition;
                        int i7 = scrollEventValues.mPosition;
                        if (i6 != i7) {
                            dispatchSelected(i7);
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    dispatchStateChanged(0);
                    resetState();
                }
            }
            if (this.mAdapterState == 2 && i == 0 && this.mDataSetChangeHappened) {
                updateScrollEventValues();
                ScrollEventValues scrollEventValues2 = this.mScrollValues;
                if (scrollEventValues2.mOffsetPx == 0) {
                    int i8 = this.mTarget;
                    int i9 = scrollEventValues2.mPosition;
                    if (i8 != i9) {
                        if (i9 == -1) {
                            i9 = 0;
                        }
                        dispatchSelected(i9);
                    }
                    dispatchStateChanged(0);
                    resetState();
                }
            }
            return;
        }
        if (this.mScrollHappened) {
            dispatchStateChanged(2);
            this.mDispatchSelected = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r6 < 0) == r4.mViewPager.isRtl()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
        /*
            r4 = this;
            r5 = 1
            r4.mScrollHappened = r5
            r4.updateScrollEventValues()
            boolean r0 = r4.mDispatchSelected
            r1 = 0
            r2 = -1
            if (r0 == 0) goto L_0x003d
            r4.mDispatchSelected = r1
            if (r7 > 0) goto L_0x0022
            if (r7 != 0) goto L_0x0020
            if (r6 >= 0) goto L_0x0016
            r6 = 1
            goto L_0x0017
        L_0x0016:
            r6 = 0
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r7 = r4.mViewPager
            boolean r7 = r7.isRtl()
            if (r6 != r7) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r6 = 0
            goto L_0x0023
        L_0x0022:
            r6 = 1
        L_0x0023:
            if (r6 == 0) goto L_0x002f
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.mScrollValues
            int r7 = r6.mOffsetPx
            if (r7 == 0) goto L_0x002f
            int r6 = r6.mPosition
            int r6 = r6 + r5
            goto L_0x0033
        L_0x002f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.mScrollValues
            int r6 = r6.mPosition
        L_0x0033:
            r4.mTarget = r6
            int r7 = r4.mDragStartPosition
            if (r7 == r6) goto L_0x004b
            r4.dispatchSelected(r6)
            goto L_0x004b
        L_0x003d:
            int r6 = r4.mAdapterState
            if (r6 != 0) goto L_0x004b
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.mScrollValues
            int r6 = r6.mPosition
            if (r6 != r2) goto L_0x0048
            r6 = 0
        L_0x0048:
            r4.dispatchSelected(r6)
        L_0x004b:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.mScrollValues
            int r6 = r6.mPosition
            if (r6 != r2) goto L_0x0052
            r6 = 0
        L_0x0052:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r7 = r4.mScrollValues
            float r0 = r7.mOffset
            int r7 = r7.mOffsetPx
            androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback r3 = r4.mCallback
            if (r3 == 0) goto L_0x005f
            r3.onPageScrolled(r6, r0, r7)
        L_0x005f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.mScrollValues
            int r6 = r6.mPosition
            int r7 = r4.mTarget
            if (r6 == r7) goto L_0x0069
            if (r7 != r2) goto L_0x0079
        L_0x0069:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.mScrollValues
            int r6 = r6.mOffsetPx
            if (r6 != 0) goto L_0x0079
            int r6 = r4.mScrollState
            if (r6 == r5) goto L_0x0079
            r4.dispatchStateChanged(r1)
            r4.resetState()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0133, code lost:
        if (r4[r2 - 1][1] >= r3) goto L_0x0136;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x015d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateScrollEventValues() {
        /*
            r13 = this;
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r0 = r13.mScrollValues
            androidx.recyclerview.widget.LinearLayoutManager r1 = r13.mLayoutManager
            int r1 = r1.findFirstVisibleItemPosition()
            r0.mPosition = r1
            r2 = -1
            if (r1 != r2) goto L_0x0011
            r0.reset()
            return
        L_0x0011:
            androidx.recyclerview.widget.LinearLayoutManager r2 = r13.mLayoutManager
            android.view.View r1 = r2.findViewByPosition(r1)
            if (r1 != 0) goto L_0x001d
            r0.reset()
            return
        L_0x001d:
            androidx.recyclerview.widget.LinearLayoutManager r2 = r13.mLayoutManager
            int r2 = r2.getLeftDecorationWidth(r1)
            androidx.recyclerview.widget.LinearLayoutManager r3 = r13.mLayoutManager
            int r3 = r3.getRightDecorationWidth(r1)
            androidx.recyclerview.widget.LinearLayoutManager r4 = r13.mLayoutManager
            int r4 = r4.getTopDecorationHeight(r1)
            androidx.recyclerview.widget.LinearLayoutManager r5 = r13.mLayoutManager
            int r5 = r5.getBottomDecorationHeight(r1)
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            boolean r7 = r6 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r7 == 0) goto L_0x004b
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r7 = r6.leftMargin
            int r2 = r2 + r7
            int r7 = r6.rightMargin
            int r3 = r3 + r7
            int r7 = r6.topMargin
            int r4 = r4 + r7
            int r6 = r6.bottomMargin
            int r5 = r5 + r6
        L_0x004b:
            int r6 = r1.getHeight()
            int r6 = r6 + r4
            int r6 = r6 + r5
            int r5 = r1.getWidth()
            int r5 = r5 + r2
            int r5 = r5 + r3
            androidx.recyclerview.widget.LinearLayoutManager r3 = r13.mLayoutManager
            int r3 = r3.getOrientation()
            r7 = 0
            r8 = 1
            if (r3 != 0) goto L_0x0063
            r3 = 1
            goto L_0x0064
        L_0x0063:
            r3 = 0
        L_0x0064:
            if (r3 == 0) goto L_0x007d
            int r1 = r1.getLeft()
            int r1 = r1 - r2
            androidx.recyclerview.widget.RecyclerView r2 = r13.mRecyclerView
            int r2 = r2.getPaddingLeft()
            int r1 = r1 - r2
            androidx.viewpager2.widget.ViewPager2 r2 = r13.mViewPager
            boolean r2 = r2.isRtl()
            if (r2 == 0) goto L_0x007b
            int r1 = -r1
        L_0x007b:
            r6 = r5
            goto L_0x0089
        L_0x007d:
            int r1 = r1.getTop()
            int r1 = r1 - r4
            androidx.recyclerview.widget.RecyclerView r2 = r13.mRecyclerView
            int r2 = r2.getPaddingTop()
            int r1 = r1 - r2
        L_0x0089:
            int r1 = -r1
            r0.mOffsetPx = r1
            if (r1 >= 0) goto L_0x0185
            androidx.viewpager2.widget.AnimateLayoutChangeDetector r1 = new androidx.viewpager2.widget.AnimateLayoutChangeDetector
            androidx.recyclerview.widget.LinearLayoutManager r2 = r13.mLayoutManager
            r1.<init>(r2)
            androidx.recyclerview.widget.LinearLayoutManager r2 = r1.mLayoutManager
            int r2 = r2.getChildCount()
            if (r2 != 0) goto L_0x009f
            goto L_0x0136
        L_0x009f:
            androidx.recyclerview.widget.LinearLayoutManager r3 = r1.mLayoutManager
            int r3 = r3.getOrientation()
            if (r3 != 0) goto L_0x00a9
            r3 = 1
            goto L_0x00aa
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            r4 = 2
            int[] r5 = new int[r4]
            r5[r8] = r4
            r5[r7] = r2
            java.lang.Class<int> r4 = int.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r4, r5)
            int[][] r4 = (int[][]) r4
            r5 = 0
        L_0x00ba:
            if (r5 >= r2) goto L_0x0104
            androidx.recyclerview.widget.LinearLayoutManager r6 = r1.mLayoutManager
            android.view.View r6 = r6.getChildAt(r5)
            if (r6 == 0) goto L_0x00fc
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            boolean r10 = r9 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x00cf
            android.view.ViewGroup$MarginLayoutParams r9 = (android.view.ViewGroup.MarginLayoutParams) r9
            goto L_0x00d1
        L_0x00cf:
            android.view.ViewGroup$MarginLayoutParams r9 = androidx.viewpager2.widget.AnimateLayoutChangeDetector.ZERO_MARGIN_LAYOUT_PARAMS
        L_0x00d1:
            r10 = r4[r5]
            if (r3 == 0) goto L_0x00dc
            int r11 = r6.getLeft()
            int r12 = r9.leftMargin
            goto L_0x00e2
        L_0x00dc:
            int r11 = r6.getTop()
            int r12 = r9.topMargin
        L_0x00e2:
            int r11 = r11 - r12
            r10[r7] = r11
            r10 = r4[r5]
            if (r3 == 0) goto L_0x00f0
            int r6 = r6.getRight()
            int r9 = r9.rightMargin
            goto L_0x00f6
        L_0x00f0:
            int r6 = r6.getBottom()
            int r9 = r9.bottomMargin
        L_0x00f6:
            int r6 = r6 + r9
            r10[r8] = r6
            int r5 = r5 + 1
            goto L_0x00ba
        L_0x00fc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "null view contained in the view hierarchy"
            r0.<init>(r1)
            throw r0
        L_0x0104:
            androidx.viewpager2.widget.AnimateLayoutChangeDetector$1 r3 = new androidx.viewpager2.widget.AnimateLayoutChangeDetector$1
            r3.<init>(r1)
            java.util.Arrays.sort(r4, r3)
            r3 = 1
        L_0x010d:
            if (r3 >= r2) goto L_0x011f
            int r5 = r3 + -1
            r5 = r4[r5]
            r5 = r5[r8]
            r6 = r4[r3]
            r6 = r6[r7]
            if (r5 == r6) goto L_0x011c
            goto L_0x0138
        L_0x011c:
            int r3 = r3 + 1
            goto L_0x010d
        L_0x011f:
            r3 = r4[r7]
            r3 = r3[r8]
            r5 = r4[r7]
            r5 = r5[r7]
            int r3 = r3 - r5
            r5 = r4[r7]
            r5 = r5[r7]
            if (r5 > 0) goto L_0x0138
            int r2 = r2 - r8
            r2 = r4[r2]
            r2 = r2[r8]
            if (r2 >= r3) goto L_0x0136
            goto L_0x0138
        L_0x0136:
            r2 = 1
            goto L_0x0139
        L_0x0138:
            r2 = 0
        L_0x0139:
            if (r2 == 0) goto L_0x0143
            androidx.recyclerview.widget.LinearLayoutManager r2 = r1.mLayoutManager
            int r2 = r2.getChildCount()
            if (r2 > r8) goto L_0x0162
        L_0x0143:
            androidx.recyclerview.widget.LinearLayoutManager r2 = r1.mLayoutManager
            int r2 = r2.getChildCount()
            r3 = 0
        L_0x014a:
            if (r3 >= r2) goto L_0x015d
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.mLayoutManager
            android.view.View r4 = r4.getChildAt(r3)
            boolean r4 = androidx.viewpager2.widget.AnimateLayoutChangeDetector.hasRunningChangingLayoutTransition(r4)
            if (r4 == 0) goto L_0x015a
            r1 = 1
            goto L_0x015e
        L_0x015a:
            int r3 = r3 + 1
            goto L_0x014a
        L_0x015d:
            r1 = 0
        L_0x015e:
            if (r1 == 0) goto L_0x0162
            r1 = 1
            goto L_0x0163
        L_0x0162:
            r1 = 0
        L_0x0163:
            if (r1 == 0) goto L_0x016d
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started."
            r0.<init>(r1)
            throw r0
        L_0x016d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.util.Locale r2 = java.util.Locale.US
            java.lang.Object[] r3 = new java.lang.Object[r8]
            int r0 = r0.mOffsetPx
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r7] = r0
            java.lang.String r0 = "Page can only be offset by a positive amount, not by %d"
            java.lang.String r0 = java.lang.String.format(r2, r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x0185:
            if (r6 != 0) goto L_0x0189
            r1 = 0
            goto L_0x018c
        L_0x0189:
            float r1 = (float) r1
            float r2 = (float) r6
            float r1 = r1 / r2
        L_0x018c:
            r0.mOffset = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.updateScrollEventValues():void");
    }
}
