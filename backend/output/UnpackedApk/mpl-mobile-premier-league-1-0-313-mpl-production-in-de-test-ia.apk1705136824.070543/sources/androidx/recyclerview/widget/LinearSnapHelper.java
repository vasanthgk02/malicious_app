package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;

public class LinearSnapHelper extends SnapHelper {
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

    public final int distanceToCenter(View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view)) - ((orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding());
    }

    public final int estimateNextPositionDiffForFling(LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        this.mGravityScroller.fling(0, 0, i, i2, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
        int[] iArr = {this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
        int childCount = layoutManager.getChildCount();
        float f2 = 1.0f;
        if (childCount != 0) {
            View view = null;
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            int i4 = LinearLayoutManager.INVALID_OFFSET;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = layoutManager.getChildAt(i5);
                int position = layoutManager.getPosition(childAt);
                if (position != -1) {
                    if (position < i3) {
                        view = childAt;
                        i3 = position;
                    }
                    if (position > i4) {
                        view2 = childAt;
                        i4 = position;
                    }
                }
            }
            if (!(view == null || view2 == null)) {
                int max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
                if (max != 0) {
                    f2 = (((float) max) * 1.0f) / ((float) ((i4 - i3) + 1));
                }
            }
        }
        if (f2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(iArr[0]) > Math.abs(iArr[1]) ? iArr[0] : iArr[1])) / f2);
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
        int i3;
        int i4;
        if (!(layoutManager instanceof ScrollVectorProvider)) {
            return -1;
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View findSnapView = findSnapView(layoutManager);
        if (findSnapView == null) {
            return -1;
        }
        int position = layoutManager.getPosition(findSnapView);
        if (position == -1) {
            return -1;
        }
        int i5 = itemCount - 1;
        PointF computeScrollVectorForPosition = ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i5);
        if (computeScrollVectorForPosition == null) {
            return -1;
        }
        int i6 = 0;
        if (layoutManager.canScrollHorizontally()) {
            i3 = estimateNextPositionDiffForFling(layoutManager, getHorizontalHelper(layoutManager), i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i3 = -i3;
            }
        } else {
            i3 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = estimateNextPositionDiffForFling(layoutManager, getVerticalHelper(layoutManager), 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i3 = i4;
        }
        if (i3 == 0) {
            return -1;
        }
        int i7 = position + i3;
        if (i7 >= 0) {
            i6 = i7;
        }
        if (i6 < itemCount) {
            i5 = i6;
        }
        return i5;
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
