package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView.State;

public class PagerSnapHelper extends SnapHelper {
    public OrientationHelper mHorizontalHelper;
    public OrientationHelper mVerticalHelper;

    public int[] calculateDistanceToFinalSnap(LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public SmoothScroller createScroller(LayoutManager layoutManager) {
        if (!(layoutManager instanceof ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.mRecyclerView.getContext()) {
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            public int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }

            public void onTargetFound(View view, State state, Action action) {
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.mRecyclerView.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    public final int distanceToCenter(View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view)) - ((orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding());
    }

    public final View findCenterView(LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int totalSpace = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - totalSpace);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    public View findSnapView(LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    public int findTargetSnapPosition(LayoutManager layoutManager, int i, int i2) {
        OrientationHelper orientationHelper;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollVertically()) {
            orientationHelper = getVerticalHelper(layoutManager);
        } else {
            orientationHelper = layoutManager.canScrollHorizontally() ? getHorizontalHelper(layoutManager) : null;
        }
        if (orientationHelper == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        boolean z = false;
        View view2 = null;
        int i3 = LinearLayoutManager.INVALID_OFFSET;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int distanceToCenter = distanceToCenter(childAt, orientationHelper);
                if (distanceToCenter <= 0 && distanceToCenter > i3) {
                    view2 = childAt;
                    i3 = distanceToCenter;
                }
                if (distanceToCenter >= 0 && distanceToCenter < i4) {
                    view = childAt;
                    i4 = distanceToCenter;
                }
            }
        }
        int i6 = 1;
        boolean z2 = !layoutManager.canScrollHorizontally() ? i2 > 0 : i > 0;
        if (z2 && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!z2 && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (z2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view);
        int itemCount2 = layoutManager.getItemCount();
        if (layoutManager instanceof ScrollVectorProvider) {
            PointF computeScrollVectorForPosition = ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount2 - 1);
            if (computeScrollVectorForPosition != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
                z = true;
            }
        }
        if (z == z2) {
            i6 = -1;
        }
        int i7 = position + i6;
        if (i7 < 0 || i7 >= itemCount) {
            return -1;
        }
        return i7;
    }

    public final OrientationHelper getHorizontalHelper(LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = new OrientationHelper(layoutManager) {
                public int getDecoratedEnd(View view) {
                    return this.mLayoutManager.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
                }

                public int getDecoratedMeasurement(View view) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
                }

                public int getDecoratedMeasurementInOther(View view) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
                }

                public int getDecoratedStart(View view) {
                    return this.mLayoutManager.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
                }

                public int getEnd() {
                    return this.mLayoutManager.getWidth();
                }

                public int getEndAfterPadding() {
                    return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
                }

                public int getEndPadding() {
                    return this.mLayoutManager.getPaddingRight();
                }

                public int getMode() {
                    return this.mLayoutManager.getWidthMode();
                }

                public int getModeInOther() {
                    return this.mLayoutManager.getHeightMode();
                }

                public int getStartAfterPadding() {
                    return this.mLayoutManager.getPaddingLeft();
                }

                public int getTotalSpace() {
                    return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
                }

                public int getTransformedEndWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.right;
                }

                public int getTransformedStartWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.left;
                }

                public void offsetChildren(int i) {
                    this.mLayoutManager.offsetChildrenHorizontal(i);
                }
            };
        }
        return this.mHorizontalHelper;
    }

    public final OrientationHelper getVerticalHelper(LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mVerticalHelper = new OrientationHelper(layoutManager) {
                public int getDecoratedEnd(View view) {
                    return this.mLayoutManager.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
                }

                public int getDecoratedMeasurement(View view) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
                }

                public int getDecoratedMeasurementInOther(View view) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
                }

                public int getDecoratedStart(View view) {
                    return this.mLayoutManager.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
                }

                public int getEnd() {
                    return this.mLayoutManager.getHeight();
                }

                public int getEndAfterPadding() {
                    return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
                }

                public int getEndPadding() {
                    return this.mLayoutManager.getPaddingBottom();
                }

                public int getMode() {
                    return this.mLayoutManager.getHeightMode();
                }

                public int getModeInOther() {
                    return this.mLayoutManager.getWidthMode();
                }

                public int getStartAfterPadding() {
                    return this.mLayoutManager.getPaddingTop();
                }

                public int getTotalSpace() {
                    return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
                }

                public int getTransformedEndWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.bottom;
                }

                public int getTransformedStartWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.top;
                }

                public void offsetChildren(int i) {
                    this.mLayoutManager.offsetChildrenVertical(i);
                }
            };
        }
        return this.mVerticalHelper;
    }
}
