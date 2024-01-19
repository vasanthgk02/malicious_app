package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.GapWorker.LayoutPrefetchRegistryImpl;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView.LayoutManager.Properties;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView.State;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends LayoutManager implements ScrollVectorProvider {
    public final AnchorInfo mAnchorInfo;
    public final Runnable mCheckForGapsRunnable;
    public int mFullSizeSpec;
    public int mGapStrategy;
    public boolean mLaidOutInvalidFullSpan;
    public boolean mLastLayoutFromEnd;
    public boolean mLastLayoutRTL;
    public final LayoutState mLayoutState;
    public LazySpanLookup mLazySpanLookup;
    public int mOrientation;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    public int[] mPrefetchDistances;
    public OrientationHelper mPrimaryOrientation;
    public BitSet mRemainingSpans;
    public boolean mReverseLayout;
    public OrientationHelper mSecondaryOrientation;
    public boolean mShouldReverseLayout;
    public int mSizePerSpan;
    public boolean mSmoothScrollbarEnabled;
    public int mSpanCount = -1;
    public Span[] mSpans;
    public final Rect mTmpRect;

    public class AnchorInfo {
        public boolean mInvalidateOffsets;
        public boolean mLayoutFromEnd;
        public int mOffset;
        public int mPosition;
        public int[] mSpanReferenceLines;
        public boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public void assignCoordinateFromPadding() {
            int i;
            if (this.mLayoutFromEnd) {
                i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            }
            this.mOffset = i;
        }

        public void reset() {
            this.mPosition = -1;
            this.mOffset = LinearLayoutManager.INVALID_OFFSET;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class LayoutParams extends androidx.recyclerview.widget.RecyclerView.LayoutParams {
        public boolean mFullSpan;
        public Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class LazySpanLookup {
        public int[] mData;
        public List<FullSpanItem> mFullSpanItems;

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new Creator<FullSpanItem>() {
                public Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            public int mGapDir;
            public int[] mGapPerSpan;
            public boolean mHasUnwantedGapAfter;
            public int mPosition;

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("FullSpanItem{mPosition=");
                outline73.append(this.mPosition);
                outline73.append(", mGapDir=");
                outline73.append(this.mGapDir);
                outline73.append(", mHasUnwantedGapAfter=");
                outline73.append(this.mHasUnwantedGapAfter);
                outline73.append(", mGapPerSpan=");
                outline73.append(Arrays.toString(this.mGapPerSpan));
                outline73.append('}');
                return outline73.toString();
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            public FullSpanItem() {
            }
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        public void clear() {
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mFullSpanItems = null;
        }

        public void ensureSize(int i) {
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.mData = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int forceInvalidateAfter(int i) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.mFullSpanItems.get(size).mPosition >= i) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(i4);
                int i5 = fullSpanItem.mPosition;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int invalidateAfter(int r5) {
            /*
                r4 = this;
                int[] r0 = r4.mData
                r1 = -1
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                int r0 = r0.length
                if (r5 < r0) goto L_0x000a
                return r1
            L_0x000a:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.mFullSpanItems
                if (r0 != 0) goto L_0x0010
            L_0x000e:
                r0 = -1
                goto L_0x0046
            L_0x0010:
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = r4.getFullSpanItem(r5)
                if (r0 == 0) goto L_0x001b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r2 = r4.mFullSpanItems
                r2.remove(r0)
            L_0x001b:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.mFullSpanItems
                int r0 = r0.size()
                r2 = 0
            L_0x0022:
                if (r2 >= r0) goto L_0x0034
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r4.mFullSpanItems
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r3
                int r3 = r3.mPosition
                if (r3 < r5) goto L_0x0031
                goto L_0x0035
            L_0x0031:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0034:
                r2 = -1
            L_0x0035:
                if (r2 == r1) goto L_0x000e
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.mFullSpanItems
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r4.mFullSpanItems
                r3.remove(r2)
                int r0 = r0.mPosition
            L_0x0046:
                if (r0 != r1) goto L_0x0052
                int[] r0 = r4.mData
                int r2 = r0.length
                java.util.Arrays.fill(r0, r5, r2, r1)
                int[] r5 = r4.mData
                int r5 = r5.length
                return r5
            L_0x0052:
                int r0 = r0 + 1
                int[] r2 = r4.mData
                int r2 = r2.length
                int r0 = java.lang.Math.min(r0, r2)
                int[] r2 = r4.mData
                java.util.Arrays.fill(r2, r5, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.invalidateAfter(int):int");
        }

        public void offsetForAddition(int i, int i2) {
            int[] iArr = this.mData;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.mData, i, i3, -1);
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                        int i4 = fullSpanItem.mPosition;
                        if (i4 >= i) {
                            fullSpanItem.mPosition = i4 + i2;
                        }
                    }
                }
            }
        }

        public void offsetForRemoval(int i, int i2) {
            int[] iArr = this.mData;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.mData;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                        int i4 = fullSpanItem.mPosition;
                        if (i4 >= i) {
                            if (i4 < i3) {
                                this.mFullSpanItems.remove(size);
                            } else {
                                fullSpanItem.mPosition = i4 - i2;
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorPosition;
        public List<FullSpanItem> mFullSpanItems;
        public boolean mLastLayoutRTL;
        public boolean mReverseLayout;
        public int[] mSpanLookup;
        public int mSpanLookupSize;
        public int[] mSpanOffsets;
        public int mSpanOffsetsSize;
        public int mVisibleAnchorPosition;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1 ? true : z;
            this.mFullSpanItems = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    public class Span {
        public int mCachedEnd = LinearLayoutManager.INVALID_OFFSET;
        public int mCachedStart = LinearLayoutManager.INVALID_OFFSET;
        public int mDeletedSize = 0;
        public final int mIndex;
        public ArrayList<View> mViews = new ArrayList<>();

        public Span(int i) {
            this.mIndex = i;
        }

        public void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = LinearLayoutManager.INVALID_OFFSET;
            if (this.mViews.size() == 1) {
                this.mCachedStart = LinearLayoutManager.INVALID_OFFSET;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
            }
        }

        public void calculateCachedEnd() {
            ArrayList<View> arrayList = this.mViews;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan) {
                FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
                if (fullSpanItem != null && fullSpanItem.mGapDir == 1) {
                    int i = this.mCachedEnd;
                    int i2 = this.mIndex;
                    int[] iArr = fullSpanItem.mGapPerSpan;
                    this.mCachedEnd = i + (iArr == null ? 0 : iArr[i2]);
                }
            }
        }

        public void calculateCachedStart() {
            int i = 0;
            View view = this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan) {
                FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
                if (fullSpanItem != null && fullSpanItem.mGapDir == -1) {
                    int i2 = this.mCachedStart;
                    int i3 = this.mIndex;
                    int[] iArr = fullSpanItem.mGapPerSpan;
                    if (iArr != null) {
                        i = iArr[i3];
                    }
                    this.mCachedStart = i2 - i;
                }
            }
        }

        public void clear() {
            this.mViews.clear();
            this.mCachedStart = LinearLayoutManager.INVALID_OFFSET;
            this.mCachedEnd = LinearLayoutManager.INVALID_OFFSET;
            this.mDeletedSize = 0;
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
            }
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findOnePartiallyOrCompletelyVisibleChild(int i, int i2, boolean z, boolean z2, boolean z3) {
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.mViews.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? decoratedStart < endAfterPadding : decoratedStart <= endAfterPadding;
                if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public int findOnePartiallyVisibleChild(int i, int i2, boolean z) {
            return findOnePartiallyOrCompletelyVisibleChild(i, i2, false, false, z);
        }

        public int getEndLine(int i) {
            int i2 = this.mCachedEnd;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.mViews.size() - 1;
                while (size >= 0) {
                    View view2 = this.mViews.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.mViews.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.mViews.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public int getStartLine(int i) {
            int i2 = this.mCachedStart;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        public void popEnd() {
            int size;
            View remove = this.mViews.remove(this.mViews.size() - 1);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.mCachedStart = LinearLayoutManager.INVALID_OFFSET;
            }
            this.mCachedEnd = LinearLayoutManager.INVALID_OFFSET;
        }

        public void popStart() {
            View remove = this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = LinearLayoutManager.INVALID_OFFSET;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            this.mCachedStart = LinearLayoutManager.INVALID_OFFSET;
        }

        public void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = LinearLayoutManager.INVALID_OFFSET;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = LinearLayoutManager.INVALID_OFFSET;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = LinearLayoutManager.INVALID_OFFSET;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo();
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable() {
            public void run() {
                StaggeredGridLayoutManager.this.checkForGaps();
            }
        };
        Properties properties = LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 == 0 || i3 == 1) {
            assertNotInLayoutOrScroll(null);
            if (i3 != this.mOrientation) {
                this.mOrientation = i3;
                OrientationHelper orientationHelper = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = orientationHelper;
                requestLayout();
            }
            int i4 = properties.spanCount;
            assertNotInLayoutOrScroll(null);
            if (i4 != this.mSpanCount) {
                this.mLazySpanLookup.clear();
                requestLayout();
                this.mSpanCount = i4;
                this.mRemainingSpans = new BitSet(this.mSpanCount);
                this.mSpans = new Span[this.mSpanCount];
                for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                    this.mSpans[i5] = new Span(i5);
                }
                requestLayout();
            }
            boolean z = properties.reverseLayout;
            assertNotInLayoutOrScroll(null);
            SavedState savedState = this.mPendingSavedState;
            if (!(savedState == null || savedState.mReverseLayout == z)) {
                savedState.mReverseLayout = z;
            }
            this.mReverseLayout = z;
            requestLayout();
            this.mLayoutState = new LayoutState();
            this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
            this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public final int calculateScrollDirectionForPosition(int i) {
        int i2 = -1;
        if (getChildCount() == 0) {
            if (this.mShouldReverseLayout) {
                i2 = 1;
            }
            return i2;
        }
        if ((i < getFirstChildPosition()) == this.mShouldReverseLayout) {
            i2 = 1;
        }
        return i2;
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean checkForGaps() {
        int i;
        int i2;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            i2 = getLastChildPosition();
            i = getFirstChildPosition();
        } else {
            i2 = getFirstChildPosition();
            i = getLastChildPosition();
        }
        if (i2 == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.mLaidOutInvalidFullSpan) {
            return false;
        } else {
            int i3 = this.mShouldReverseLayout ? -1 : 1;
            int i4 = i + 1;
            FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(i2, i4, i3, true);
            if (firstFullSpanItemInRange == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.mLazySpanLookup.forceInvalidateAfter(i4);
                return false;
            }
            FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(i2, firstFullSpanItemInRange.mPosition, i3 * -1, true);
            if (firstFullSpanItemInRange2 == null) {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
            } else {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        int i4;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            prepareLayoutStateForDelta(i, state);
            int[] iArr = this.mPrefetchDistances;
            if (iArr == null || iArr.length < this.mSpanCount) {
                this.mPrefetchDistances = new int[this.mSpanCount];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.mSpanCount; i6++) {
                LayoutState layoutState = this.mLayoutState;
                if (layoutState.mItemDirection == -1) {
                    i4 = layoutState.mStartLine;
                    i3 = this.mSpans[i6].getStartLine(i4);
                } else {
                    i4 = this.mSpans[i6].getEndLine(layoutState.mEndLine);
                    i3 = this.mLayoutState.mEndLine;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.mPrefetchDistances[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.mPrefetchDistances, 0, i5);
            int i8 = 0;
            while (i8 < i5) {
                int i9 = this.mLayoutState.mCurrentPosition;
                if (i9 >= 0 && i9 < state.getItemCount()) {
                    ((LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i8]);
                    LayoutState layoutState2 = this.mLayoutState;
                    layoutState2.mCurrentPosition += layoutState2.mItemDirection;
                    i8++;
                } else {
                    return;
                }
            }
        }
    }

    public int computeHorizontalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return CompoundButtonCompat.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    public final int computeScrollOffset(State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return CompoundButtonCompat.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int computeScrollRange(State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return CompoundButtonCompat.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) calculateScrollDirectionForPosition;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(State state) {
        return computeScrollRange(state);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v1, types: [boolean]
      assigns: []
      uses: [boolean, ?[int, short, byte, char]]
      mth insns count: 400
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0372  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int fill(androidx.recyclerview.widget.RecyclerView.Recycler r19, androidx.recyclerview.widget.LayoutState r20, androidx.recyclerview.widget.RecyclerView.State r21) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            java.util.BitSet r0 = r6.mRemainingSpans
            int r1 = r6.mSpanCount
            r9 = 0
            r10 = 1
            r0.set(r9, r1, r10)
            androidx.recyclerview.widget.LayoutState r0 = r6.mLayoutState
            boolean r0 = r0.mInfinite
            if (r0 == 0) goto L_0x0020
            int r0 = r8.mLayoutDirection
            if (r0 != r10) goto L_0x001d
            r13 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0030
        L_0x001d:
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0030
        L_0x0020:
            int r0 = r8.mLayoutDirection
            if (r0 != r10) goto L_0x002a
            int r0 = r8.mEndLine
            int r1 = r8.mAvailable
            int r0 = r0 + r1
            goto L_0x002f
        L_0x002a:
            int r0 = r8.mStartLine
            int r1 = r8.mAvailable
            int r0 = r0 - r1
        L_0x002f:
            r13 = r0
        L_0x0030:
            int r0 = r8.mLayoutDirection
            r6.updateAllRemainingSpans(r0, r13)
            boolean r0 = r6.mShouldReverseLayout
            if (r0 == 0) goto L_0x0040
            androidx.recyclerview.widget.OrientationHelper r0 = r6.mPrimaryOrientation
            int r0 = r0.getEndAfterPadding()
            goto L_0x0046
        L_0x0040:
            androidx.recyclerview.widget.OrientationHelper r0 = r6.mPrimaryOrientation
            int r0 = r0.getStartAfterPadding()
        L_0x0046:
            r14 = r0
            r0 = 0
        L_0x0048:
            int r1 = r8.mCurrentPosition
            if (r1 < 0) goto L_0x0054
            int r2 = r21.getItemCount()
            if (r1 >= r2) goto L_0x0054
            r1 = 1
            goto L_0x0055
        L_0x0054:
            r1 = 0
        L_0x0055:
            r2 = -1
            if (r1 == 0) goto L_0x0381
            androidx.recyclerview.widget.LayoutState r1 = r6.mLayoutState
            boolean r1 = r1.mInfinite
            if (r1 != 0) goto L_0x0066
            java.util.BitSet r1 = r6.mRemainingSpans
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0381
        L_0x0066:
            int r0 = r8.mCurrentPosition
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r7.tryGetViewHolderForPositionByDeadline(r0, r9, r3)
            android.view.View r15 = r0.itemView
            int r0 = r8.mCurrentPosition
            int r1 = r8.mItemDirection
            int r0 = r0 + r1
            r8.mCurrentPosition = r0
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            r5 = r0
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r5
            int r0 = r5.getViewLayoutPosition()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r6.mLazySpanLookup
            int[] r1 = r1.mData
            if (r1 == 0) goto L_0x0092
            int r3 = r1.length
            if (r0 < r3) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            r1 = r1[r0]
            goto L_0x0093
        L_0x0092:
            r1 = -1
        L_0x0093:
            if (r1 != r2) goto L_0x0097
            r3 = 1
            goto L_0x0098
        L_0x0097:
            r3 = 0
        L_0x0098:
            if (r3 == 0) goto L_0x0103
            boolean r1 = r5.mFullSpan
            if (r1 == 0) goto L_0x00a3
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r6.mSpans
            r1 = r1[r9]
            goto L_0x00f7
        L_0x00a3:
            int r1 = r8.mLayoutDirection
            boolean r1 = r6.preferLastSpan(r1)
            if (r1 == 0) goto L_0x00b2
            int r1 = r6.mSpanCount
            int r1 = r1 - r10
            r4 = -1
            r16 = -1
            goto L_0x00b8
        L_0x00b2:
            int r1 = r6.mSpanCount
            r4 = r1
            r1 = 0
            r16 = 1
        L_0x00b8:
            int r11 = r8.mLayoutDirection
            r17 = 0
            if (r11 != r10) goto L_0x00db
            androidx.recyclerview.widget.OrientationHelper r11 = r6.mPrimaryOrientation
            int r11 = r11.getStartAfterPadding()
            r12 = 2147483647(0x7fffffff, float:NaN)
        L_0x00c7:
            if (r1 == r4) goto L_0x00f5
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r2 = r6.mSpans
            r2 = r2[r1]
            int r9 = r2.getEndLine(r11)
            if (r9 >= r12) goto L_0x00d6
            r17 = r2
            r12 = r9
        L_0x00d6:
            int r1 = r1 + r16
            r2 = -1
            r9 = 0
            goto L_0x00c7
        L_0x00db:
            androidx.recyclerview.widget.OrientationHelper r2 = r6.mPrimaryOrientation
            int r2 = r2.getEndAfterPadding()
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00e3:
            if (r1 == r4) goto L_0x00f5
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r11 = r6.mSpans
            r11 = r11[r1]
            int r12 = r11.getStartLine(r2)
            if (r12 <= r9) goto L_0x00f2
            r17 = r11
            r9 = r12
        L_0x00f2:
            int r1 = r1 + r16
            goto L_0x00e3
        L_0x00f5:
            r1 = r17
        L_0x00f7:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r2 = r6.mLazySpanLookup
            r2.ensureSize(r0)
            int[] r2 = r2.mData
            int r4 = r1.mIndex
            r2[r0] = r4
            goto L_0x0107
        L_0x0103:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r2 = r6.mSpans
            r1 = r2[r1]
        L_0x0107:
            r9 = r1
            r5.mSpan = r9
            int r1 = r8.mLayoutDirection
            if (r1 != r10) goto L_0x0112
            r6.addView(r15)
            goto L_0x0116
        L_0x0112:
            r1 = 0
            r6.addView(r15, r1)
        L_0x0116:
            boolean r1 = r5.mFullSpan
            if (r1 == 0) goto L_0x015a
            int r1 = r6.mOrientation
            if (r1 != r10) goto L_0x013c
            int r1 = r6.mFullSizeSpec
            int r2 = r18.getHeight()
            int r4 = r18.getHeightMode()
            int r11 = r18.getPaddingTop()
            int r12 = r18.getPaddingBottom()
            int r12 = r12 + r11
            int r11 = r5.height
            int r2 = androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(r2, r4, r12, r11, r10)
            r4 = 0
            r6.measureChildWithDecorationsAndMargin(r15, r1, r2, r4)
            goto L_0x01ae
        L_0x013c:
            r4 = 0
            int r1 = r18.getWidth()
            int r2 = r18.getWidthMode()
            int r11 = r18.getPaddingLeft()
            int r12 = r18.getPaddingRight()
            int r12 = r12 + r11
            int r11 = r5.width
            int r1 = androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(r1, r2, r12, r11, r10)
            int r2 = r6.mFullSizeSpec
            r6.measureChildWithDecorationsAndMargin(r15, r1, r2, r4)
            goto L_0x01ae
        L_0x015a:
            r4 = 0
            int r1 = r6.mOrientation
            if (r1 != r10) goto L_0x0187
            int r1 = r6.mSizePerSpan
            int r2 = r18.getWidthMode()
            int r11 = r5.width
            int r1 = androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(r1, r2, r4, r11, r4)
            int r2 = r18.getHeight()
            int r11 = r18.getHeightMode()
            int r12 = r18.getPaddingTop()
            int r16 = r18.getPaddingBottom()
            int r12 = r16 + r12
            int r7 = r5.height
            int r2 = androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(r2, r11, r12, r7, r10)
            r6.measureChildWithDecorationsAndMargin(r15, r1, r2, r4)
            goto L_0x01ae
        L_0x0187:
            int r1 = r18.getWidth()
            int r2 = r18.getWidthMode()
            int r4 = r18.getPaddingLeft()
            int r7 = r18.getPaddingRight()
            int r7 = r7 + r4
            int r4 = r5.width
            int r1 = androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(r1, r2, r7, r4, r10)
            int r2 = r6.mSizePerSpan
            int r4 = r18.getHeightMode()
            int r7 = r5.height
            r11 = 0
            int r2 = androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(r2, r4, r11, r7, r11)
            r6.measureChildWithDecorationsAndMargin(r15, r1, r2, r11)
        L_0x01ae:
            int r1 = r8.mLayoutDirection
            if (r1 != r10) goto L_0x01fa
            boolean r1 = r5.mFullSpan
            if (r1 == 0) goto L_0x01bb
            int r1 = r6.getMaxEnd(r14)
            goto L_0x01bf
        L_0x01bb:
            int r1 = r9.getEndLine(r14)
        L_0x01bf:
            androidx.recyclerview.widget.OrientationHelper r2 = r6.mPrimaryOrientation
            int r2 = r2.getDecoratedMeasurement(r15)
            int r2 = r2 + r1
            if (r3 == 0) goto L_0x01f7
            boolean r4 = r5.mFullSpan
            if (r4 == 0) goto L_0x01f7
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r4 = new androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
            r4.<init>()
            int r7 = r6.mSpanCount
            int[] r7 = new int[r7]
            r4.mGapPerSpan = r7
            r7 = 0
        L_0x01d8:
            int r11 = r6.mSpanCount
            if (r7 >= r11) goto L_0x01ed
            int[] r11 = r4.mGapPerSpan
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r12 = r6.mSpans
            r12 = r12[r7]
            int r12 = r12.getEndLine(r1)
            int r12 = r1 - r12
            r11[r7] = r12
            int r7 = r7 + 1
            goto L_0x01d8
        L_0x01ed:
            r7 = -1
            r4.mGapDir = r7
            r4.mPosition = r0
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.mLazySpanLookup
            r7.addFullSpanItem(r4)
        L_0x01f7:
            r4 = r1
            r7 = r2
            goto L_0x0240
        L_0x01fa:
            boolean r1 = r5.mFullSpan
            if (r1 == 0) goto L_0x0203
            int r1 = r6.getMinStart(r14)
            goto L_0x0207
        L_0x0203:
            int r1 = r9.getStartLine(r14)
        L_0x0207:
            androidx.recyclerview.widget.OrientationHelper r2 = r6.mPrimaryOrientation
            int r2 = r2.getDecoratedMeasurement(r15)
            int r2 = r1 - r2
            if (r3 == 0) goto L_0x023e
            boolean r4 = r5.mFullSpan
            if (r4 == 0) goto L_0x023e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r4 = new androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
            r4.<init>()
            int r7 = r6.mSpanCount
            int[] r7 = new int[r7]
            r4.mGapPerSpan = r7
            r7 = 0
        L_0x0221:
            int r11 = r6.mSpanCount
            if (r7 >= r11) goto L_0x0235
            int[] r11 = r4.mGapPerSpan
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r12 = r6.mSpans
            r12 = r12[r7]
            int r12 = r12.getStartLine(r1)
            int r12 = r12 - r1
            r11[r7] = r12
            int r7 = r7 + 1
            goto L_0x0221
        L_0x0235:
            r4.mGapDir = r10
            r4.mPosition = r0
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.mLazySpanLookup
            r7.addFullSpanItem(r4)
        L_0x023e:
            r7 = r1
            r4 = r2
        L_0x0240:
            boolean r1 = r5.mFullSpan
            if (r1 == 0) goto L_0x02a0
            int r1 = r8.mItemDirection
            r2 = -1
            if (r1 != r2) goto L_0x02a0
            if (r3 == 0) goto L_0x024e
            r6.mLaidOutInvalidFullSpan = r10
            goto L_0x02a0
        L_0x024e:
            int r1 = r8.mLayoutDirection
            if (r1 != r10) goto L_0x0270
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r6.mSpans
            r2 = 0
            r1 = r1[r2]
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1.getEndLine(r11)
            r2 = 1
        L_0x025e:
            int r3 = r6.mSpanCount
            if (r2 >= r3) goto L_0x028f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r3 = r6.mSpans
            r3 = r3[r2]
            int r3 = r3.getEndLine(r11)
            if (r3 == r1) goto L_0x026d
            goto L_0x028a
        L_0x026d:
            int r2 = r2 + 1
            goto L_0x025e
        L_0x0270:
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r6.mSpans
            r2 = 0
            r1 = r1[r2]
            int r1 = r1.getStartLine(r11)
            r2 = 1
        L_0x027c:
            int r3 = r6.mSpanCount
            if (r2 >= r3) goto L_0x028f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r3 = r6.mSpans
            r3 = r3[r2]
            int r3 = r3.getStartLine(r11)
            if (r3 == r1) goto L_0x028c
        L_0x028a:
            r1 = 0
            goto L_0x0290
        L_0x028c:
            int r2 = r2 + 1
            goto L_0x027c
        L_0x028f:
            r1 = 1
        L_0x0290:
            r1 = r1 ^ r10
            if (r1 == 0) goto L_0x02a2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r6.mLazySpanLookup
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = r1.getFullSpanItem(r0)
            if (r0 == 0) goto L_0x029d
            r0.mHasUnwantedGapAfter = r10
        L_0x029d:
            r6.mLaidOutInvalidFullSpan = r10
            goto L_0x02a2
        L_0x02a0:
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x02a2:
            int r0 = r8.mLayoutDirection
            if (r0 != r10) goto L_0x02be
            boolean r0 = r5.mFullSpan
            if (r0 == 0) goto L_0x02b8
            int r0 = r6.mSpanCount
        L_0x02ac:
            r1 = -1
            int r0 = r0 + r1
            if (r0 < 0) goto L_0x02d5
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r6.mSpans
            r1 = r1[r0]
            r1.appendToSpan(r15)
            goto L_0x02ac
        L_0x02b8:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r0 = r5.mSpan
            r0.appendToSpan(r15)
            goto L_0x02d5
        L_0x02be:
            boolean r0 = r5.mFullSpan
            if (r0 == 0) goto L_0x02d0
            int r0 = r6.mSpanCount
        L_0x02c4:
            r1 = -1
            int r0 = r0 + r1
            if (r0 < 0) goto L_0x02d5
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r6.mSpans
            r1 = r1[r0]
            r1.prependToSpan(r15)
            goto L_0x02c4
        L_0x02d0:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r0 = r5.mSpan
            r0.prependToSpan(r15)
        L_0x02d5:
            boolean r0 = r18.isLayoutRTL()
            if (r0 == 0) goto L_0x0306
            int r0 = r6.mOrientation
            if (r0 != r10) goto L_0x0306
            boolean r0 = r5.mFullSpan
            if (r0 == 0) goto L_0x02ea
            androidx.recyclerview.widget.OrientationHelper r0 = r6.mSecondaryOrientation
            int r0 = r0.getEndAfterPadding()
            goto L_0x02fb
        L_0x02ea:
            androidx.recyclerview.widget.OrientationHelper r0 = r6.mSecondaryOrientation
            int r0 = r0.getEndAfterPadding()
            int r1 = r6.mSpanCount
            int r1 = r1 - r10
            int r2 = r9.mIndex
            int r1 = r1 - r2
            int r2 = r6.mSizePerSpan
            int r1 = r1 * r2
            int r0 = r0 - r1
        L_0x02fb:
            androidx.recyclerview.widget.OrientationHelper r1 = r6.mSecondaryOrientation
            int r1 = r1.getDecoratedMeasurement(r15)
            int r1 = r0 - r1
            r12 = r0
            r3 = r1
            goto L_0x0327
        L_0x0306:
            boolean r0 = r5.mFullSpan
            if (r0 == 0) goto L_0x0311
            androidx.recyclerview.widget.OrientationHelper r0 = r6.mSecondaryOrientation
            int r0 = r0.getStartAfterPadding()
            goto L_0x031e
        L_0x0311:
            int r0 = r9.mIndex
            int r1 = r6.mSizePerSpan
            int r0 = r0 * r1
            androidx.recyclerview.widget.OrientationHelper r1 = r6.mSecondaryOrientation
            int r1 = r1.getStartAfterPadding()
            int r0 = r0 + r1
        L_0x031e:
            androidx.recyclerview.widget.OrientationHelper r1 = r6.mSecondaryOrientation
            int r1 = r1.getDecoratedMeasurement(r15)
            int r1 = r1 + r0
            r3 = r0
            r12 = r1
        L_0x0327:
            int r0 = r6.mOrientation
            if (r0 != r10) goto L_0x0338
            r0 = r18
            r1 = r15
            r2 = r3
            r3 = r4
            r4 = r12
            r12 = r5
            r5 = r7
            r0.layoutDecoratedWithMargins(r1, r2, r3, r4, r5)
            r7 = r12
            goto L_0x0342
        L_0x0338:
            r0 = r18
            r1 = r15
            r2 = r4
            r4 = r7
            r7 = r5
            r5 = r12
            r0.layoutDecoratedWithMargins(r1, r2, r3, r4, r5)
        L_0x0342:
            boolean r0 = r7.mFullSpan
            if (r0 == 0) goto L_0x034e
            androidx.recyclerview.widget.LayoutState r0 = r6.mLayoutState
            int r0 = r0.mLayoutDirection
            r6.updateAllRemainingSpans(r0, r13)
            goto L_0x0355
        L_0x034e:
            androidx.recyclerview.widget.LayoutState r0 = r6.mLayoutState
            int r0 = r0.mLayoutDirection
            r6.updateRemainingSpans(r9, r0, r13)
        L_0x0355:
            androidx.recyclerview.widget.LayoutState r0 = r6.mLayoutState
            r1 = r19
            r6.recycle(r1, r0)
            androidx.recyclerview.widget.LayoutState r0 = r6.mLayoutState
            boolean r0 = r0.mStopInFocusable
            if (r0 == 0) goto L_0x037b
            boolean r0 = r15.hasFocusable()
            if (r0 == 0) goto L_0x037b
            boolean r0 = r7.mFullSpan
            if (r0 == 0) goto L_0x0372
            java.util.BitSet r0 = r6.mRemainingSpans
            r0.clear()
            goto L_0x037b
        L_0x0372:
            java.util.BitSet r0 = r6.mRemainingSpans
            int r2 = r9.mIndex
            r3 = 0
            r0.set(r2, r3)
            goto L_0x037c
        L_0x037b:
            r3 = 0
        L_0x037c:
            r7 = r1
            r0 = 1
            r9 = 0
            goto L_0x0048
        L_0x0381:
            r1 = r7
            r3 = 0
            if (r0 != 0) goto L_0x038a
            androidx.recyclerview.widget.LayoutState r0 = r6.mLayoutState
            r6.recycle(r1, r0)
        L_0x038a:
            androidx.recyclerview.widget.LayoutState r0 = r6.mLayoutState
            int r0 = r0.mLayoutDirection
            r1 = -1
            if (r0 != r1) goto L_0x03a3
            androidx.recyclerview.widget.OrientationHelper r0 = r6.mPrimaryOrientation
            int r0 = r0.getStartAfterPadding()
            int r0 = r6.getMinStart(r0)
            androidx.recyclerview.widget.OrientationHelper r1 = r6.mPrimaryOrientation
            int r1 = r1.getStartAfterPadding()
            int r1 = r1 - r0
            goto L_0x03b5
        L_0x03a3:
            androidx.recyclerview.widget.OrientationHelper r0 = r6.mPrimaryOrientation
            int r0 = r0.getEndAfterPadding()
            int r0 = r6.getMaxEnd(r0)
            androidx.recyclerview.widget.OrientationHelper r1 = r6.mPrimaryOrientation
            int r1 = r1.getEndAfterPadding()
            int r1 = r0 - r1
        L_0x03b5:
            if (r1 <= 0) goto L_0x03be
            int r0 = r8.mAvailable
            int r9 = java.lang.Math.min(r0, r1)
            goto L_0x03bf
        L_0x03be:
            r9 = 0
        L_0x03bf:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.fill(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.LayoutState, androidx.recyclerview.widget.RecyclerView$State):int");
    }

    public View findFirstVisibleItemClosestToEnd(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View findFirstVisibleItemClosestToStart(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        int i;
        int[] iArr2 = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            Span span = this.mSpans[i2];
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                i = span.findOnePartiallyOrCompletelyVisibleChild(span.mViews.size() - 1, -1, false, true, false);
            } else {
                i = span.findOnePartiallyOrCompletelyVisibleChild(0, span.mViews.size(), false, true, false);
            }
            iArr2[i2] = i;
        }
        return iArr2;
    }

    public final void fixEndGap(Recycler recycler, State state, boolean z) {
        int maxEnd = getMaxEnd(LinearLayoutManager.INVALID_OFFSET);
        if (maxEnd != Integer.MIN_VALUE) {
            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd;
            if (endAfterPadding > 0) {
                int i = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
                if (z && i > 0) {
                    this.mPrimaryOrientation.offsetChildren(i);
                }
            }
        }
    }

    public final void fixStartGap(Recycler recycler, State state, boolean z) {
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE) {
            int startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding();
            if (startAfterPadding > 0) {
                int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
                if (z && scrollBy > 0) {
                    this.mPrimaryOrientation.offsetChildren(-scrollBy);
                }
            }
        }
    }

    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int getMaxEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    public final int getMinStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleUpdate(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.mShouldReverseLayout
            if (r0 == 0) goto L_0x0009
            int r0 = r6.getLastChildPosition()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.getFirstChildPosition()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.mLazySpanLookup
            r4.invalidateAfter(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.mLazySpanLookup
            r7.offsetForAddition(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForAddition(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.mShouldReverseLayout
            if (r7 == 0) goto L_0x004d
            int r7 = r6.getFirstChildPosition()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.getLastChildPosition()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.handleUpdate(int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        if (r11 == r12) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        if (r11 == r12) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r11 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View hasGapsToFix() {
        /*
            r13 = this;
            int r0 = r13.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r13.mSpanCount
            r2.<init>(r3)
            int r3 = r13.mSpanCount
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r13.mOrientation
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r13.isLayoutRTL()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r13.mShouldReverseLayout
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002f
            r7 = 1
            goto L_0x0030
        L_0x002f:
            r7 = -1
        L_0x0030:
            if (r0 == r6) goto L_0x00f9
            android.view.View r8 = r13.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r10 = r9.mSpan
            int r10 = r10.mIndex
            boolean r10 = r2.get(r10)
            if (r10 == 0) goto L_0x00a1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r10 = r9.mSpan
            boolean r11 = r13.mShouldReverseLayout
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x0074
            int r11 = r10.mCachedEnd
            if (r11 == r12) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            r10.calculateCachedEnd()
            int r11 = r10.mCachedEnd
        L_0x0058:
            androidx.recyclerview.widget.OrientationHelper r12 = r13.mPrimaryOrientation
            int r12 = r12.getEndAfterPadding()
            if (r11 >= r12) goto L_0x0096
            java.util.ArrayList<android.view.View> r11 = r10.mViews
            int r12 = r11.size()
            int r12 = r12 + r5
            java.lang.Object r11 = r11.get(r12)
            android.view.View r11 = (android.view.View) r11
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r10 = r10.getLayoutParams(r11)
            boolean r10 = r10.mFullSpan
            goto L_0x0094
        L_0x0074:
            int r11 = r10.mCachedStart
            if (r11 == r12) goto L_0x0079
            goto L_0x007e
        L_0x0079:
            r10.calculateCachedStart()
            int r11 = r10.mCachedStart
        L_0x007e:
            androidx.recyclerview.widget.OrientationHelper r12 = r13.mPrimaryOrientation
            int r12 = r12.getStartAfterPadding()
            if (r11 <= r12) goto L_0x0096
            java.util.ArrayList<android.view.View> r11 = r10.mViews
            java.lang.Object r11 = r11.get(r4)
            android.view.View r11 = (android.view.View) r11
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r10 = r10.getLayoutParams(r11)
            boolean r10 = r10.mFullSpan
        L_0x0094:
            r10 = r10 ^ r1
            goto L_0x0097
        L_0x0096:
            r10 = 0
        L_0x0097:
            if (r10 == 0) goto L_0x009a
            return r8
        L_0x009a:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r10 = r9.mSpan
            int r10 = r10.mIndex
            r2.clear(r10)
        L_0x00a1:
            boolean r10 = r9.mFullSpan
            if (r10 == 0) goto L_0x00a6
            goto L_0x00f6
        L_0x00a6:
            int r10 = r0 + r7
            if (r10 == r6) goto L_0x00f6
            android.view.View r10 = r13.getChildAt(r10)
            boolean r11 = r13.mShouldReverseLayout
            if (r11 == 0) goto L_0x00c4
            androidx.recyclerview.widget.OrientationHelper r11 = r13.mPrimaryOrientation
            int r11 = r11.getDecoratedEnd(r8)
            androidx.recyclerview.widget.OrientationHelper r12 = r13.mPrimaryOrientation
            int r12 = r12.getDecoratedEnd(r10)
            if (r11 >= r12) goto L_0x00c1
            return r8
        L_0x00c1:
            if (r11 != r12) goto L_0x00d7
            goto L_0x00d5
        L_0x00c4:
            androidx.recyclerview.widget.OrientationHelper r11 = r13.mPrimaryOrientation
            int r11 = r11.getDecoratedStart(r8)
            androidx.recyclerview.widget.OrientationHelper r12 = r13.mPrimaryOrientation
            int r12 = r12.getDecoratedStart(r10)
            if (r11 <= r12) goto L_0x00d3
            return r8
        L_0x00d3:
            if (r11 != r12) goto L_0x00d7
        L_0x00d5:
            r11 = 1
            goto L_0x00d8
        L_0x00d7:
            r11 = 0
        L_0x00d8:
            if (r11 == 0) goto L_0x00f6
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r10 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r10
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.mSpan
            int r9 = r9.mIndex
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r10 = r10.mSpan
            int r10 = r10.mIndex
            int r9 = r9 - r10
            if (r9 >= 0) goto L_0x00ed
            r9 = 1
            goto L_0x00ee
        L_0x00ed:
            r9 = 0
        L_0x00ee:
            if (r3 >= 0) goto L_0x00f2
            r10 = 1
            goto L_0x00f3
        L_0x00f2:
            r10 = 0
        L_0x00f3:
            if (r9 == r10) goto L_0x00f6
            return r8
        L_0x00f6:
            int r0 = r0 + r7
            goto L_0x0030
        L_0x00f9:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.hasGapsToFix():android.view.View");
    }

    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public final void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        boolean z2;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin;
        Rect rect = this.mTmpRect;
        int updateSpecWithExtra = updateSpecWithExtra(i, i3 + rect.left, layoutParams.rightMargin + rect.right);
        int i4 = layoutParams.topMargin;
        Rect rect2 = this.mTmpRect;
        int updateSpecWithExtra2 = updateSpecWithExtra(i2, i4 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z) {
            z2 = shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        } else {
            z2 = shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (z2) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            Span span = this.mSpans[i2];
            int i3 = span.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                span.mCachedStart = i3 + i;
            }
            int i4 = span.mCachedEnd;
            if (i4 != Integer.MIN_VALUE) {
                span.mCachedEnd = i4 + i;
            }
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            Span span = this.mSpans[i2];
            int i3 = span.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                span.mCachedStart = i3 + i;
            }
            int i4 = span.mCachedEnd;
            if (i4 != Integer.MIN_VALUE) {
                span.mCachedEnd = i4 + i;
            }
        }
    }

    public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        this.mLazySpanLookup.clear();
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        if (r9.mOrientation == 1) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        if (r9.mOrientation == 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (isLayoutRTL() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0058, code lost:
        if (isLayoutRTL() == false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r10, int r11, androidx.recyclerview.widget.RecyclerView.Recycler r12, androidx.recyclerview.widget.RecyclerView.State r13) {
        /*
            r9 = this;
            int r0 = r9.getChildCount()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.view.View r10 = r9.findContainingItemView(r10)
            if (r10 != 0) goto L_0x000f
            return r1
        L_0x000f:
            r9.resolveShouldLayoutReverse()
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            if (r11 == r3) goto L_0x004f
            r4 = 2
            if (r11 == r4) goto L_0x0043
            r4 = 17
            if (r11 == r4) goto L_0x003b
            r4 = 33
            if (r11 == r4) goto L_0x0036
            r4 = 66
            if (r11 == r4) goto L_0x0031
            r4 = 130(0x82, float:1.82E-43)
            if (r11 == r4) goto L_0x002c
            goto L_0x0040
        L_0x002c:
            int r11 = r9.mOrientation
            if (r11 != r3) goto L_0x0040
            goto L_0x005a
        L_0x0031:
            int r11 = r9.mOrientation
            if (r11 != 0) goto L_0x0040
            goto L_0x005a
        L_0x0036:
            int r11 = r9.mOrientation
            if (r11 != r3) goto L_0x0040
            goto L_0x005c
        L_0x003b:
            int r11 = r9.mOrientation
            if (r11 != 0) goto L_0x0040
            goto L_0x005c
        L_0x0040:
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x005d
        L_0x0043:
            int r11 = r9.mOrientation
            if (r11 != r3) goto L_0x0048
            goto L_0x005a
        L_0x0048:
            boolean r11 = r9.isLayoutRTL()
            if (r11 == 0) goto L_0x005a
            goto L_0x005c
        L_0x004f:
            int r11 = r9.mOrientation
            if (r11 != r3) goto L_0x0054
            goto L_0x005c
        L_0x0054:
            boolean r11 = r9.isLayoutRTL()
            if (r11 == 0) goto L_0x005c
        L_0x005a:
            r11 = 1
            goto L_0x005d
        L_0x005c:
            r11 = -1
        L_0x005d:
            if (r11 != r0) goto L_0x0060
            return r1
        L_0x0060:
            android.view.ViewGroup$LayoutParams r0 = r10.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r0
            boolean r4 = r0.mFullSpan
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r0 = r0.mSpan
            if (r11 != r3) goto L_0x0071
            int r5 = r9.getLastChildPosition()
            goto L_0x0075
        L_0x0071:
            int r5 = r9.getFirstChildPosition()
        L_0x0075:
            r9.updateLayoutState(r5, r13)
            r9.setLayoutStateDirection(r11)
            androidx.recyclerview.widget.LayoutState r6 = r9.mLayoutState
            int r7 = r6.mItemDirection
            int r7 = r7 + r5
            r6.mCurrentPosition = r7
            r7 = 1051372203(0x3eaaaaab, float:0.33333334)
            androidx.recyclerview.widget.OrientationHelper r8 = r9.mPrimaryOrientation
            int r8 = r8.getTotalSpace()
            float r8 = (float) r8
            float r8 = r8 * r7
            int r7 = (int) r8
            r6.mAvailable = r7
            androidx.recyclerview.widget.LayoutState r6 = r9.mLayoutState
            r6.mStopInFocusable = r3
            r7 = 0
            r6.mRecycle = r7
            r9.fill(r12, r6, r13)
            boolean r12 = r9.mShouldReverseLayout
            r9.mLastLayoutFromEnd = r12
            if (r4 != 0) goto L_0x00aa
            android.view.View r12 = r0.getFocusableViewAfter(r5, r11)
            if (r12 == 0) goto L_0x00aa
            if (r12 == r10) goto L_0x00aa
            return r12
        L_0x00aa:
            boolean r12 = r9.preferLastSpan(r11)
            if (r12 == 0) goto L_0x00c5
            int r12 = r9.mSpanCount
            int r12 = r12 - r3
        L_0x00b3:
            if (r12 < 0) goto L_0x00da
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r13 = r9.mSpans
            r13 = r13[r12]
            android.view.View r13 = r13.getFocusableViewAfter(r5, r11)
            if (r13 == 0) goto L_0x00c2
            if (r13 == r10) goto L_0x00c2
            return r13
        L_0x00c2:
            int r12 = r12 + -1
            goto L_0x00b3
        L_0x00c5:
            r12 = 0
        L_0x00c6:
            int r13 = r9.mSpanCount
            if (r12 >= r13) goto L_0x00da
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r13 = r9.mSpans
            r13 = r13[r12]
            android.view.View r13 = r13.getFocusableViewAfter(r5, r11)
            if (r13 == 0) goto L_0x00d7
            if (r13 == r10) goto L_0x00d7
            return r13
        L_0x00d7:
            int r12 = r12 + 1
            goto L_0x00c6
        L_0x00da:
            boolean r12 = r9.mReverseLayout
            r12 = r12 ^ r3
            if (r11 != r2) goto L_0x00e1
            r13 = 1
            goto L_0x00e2
        L_0x00e1:
            r13 = 0
        L_0x00e2:
            if (r12 != r13) goto L_0x00e6
            r12 = 1
            goto L_0x00e7
        L_0x00e6:
            r12 = 0
        L_0x00e7:
            if (r4 != 0) goto L_0x00fd
            if (r12 == 0) goto L_0x00f0
            int r13 = r0.findFirstPartiallyVisibleItemPosition()
            goto L_0x00f4
        L_0x00f0:
            int r13 = r0.findLastPartiallyVisibleItemPosition()
        L_0x00f4:
            android.view.View r13 = r9.findViewByPosition(r13)
            if (r13 == 0) goto L_0x00fd
            if (r13 == r10) goto L_0x00fd
            return r13
        L_0x00fd:
            boolean r11 = r9.preferLastSpan(r11)
            if (r11 == 0) goto L_0x012c
            int r11 = r9.mSpanCount
            int r11 = r11 - r3
        L_0x0106:
            if (r11 < 0) goto L_0x014f
            int r13 = r0.mIndex
            if (r11 != r13) goto L_0x010d
            goto L_0x0129
        L_0x010d:
            if (r12 == 0) goto L_0x0118
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r13 = r9.mSpans
            r13 = r13[r11]
            int r13 = r13.findFirstPartiallyVisibleItemPosition()
            goto L_0x0120
        L_0x0118:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r13 = r9.mSpans
            r13 = r13[r11]
            int r13 = r13.findLastPartiallyVisibleItemPosition()
        L_0x0120:
            android.view.View r13 = r9.findViewByPosition(r13)
            if (r13 == 0) goto L_0x0129
            if (r13 == r10) goto L_0x0129
            return r13
        L_0x0129:
            int r11 = r11 + -1
            goto L_0x0106
        L_0x012c:
            int r11 = r9.mSpanCount
            if (r7 >= r11) goto L_0x014f
            if (r12 == 0) goto L_0x013b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r11 = r9.mSpans
            r11 = r11[r7]
            int r11 = r11.findFirstPartiallyVisibleItemPosition()
            goto L_0x0143
        L_0x013b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r11 = r9.mSpans
            r11 = r11[r7]
            int r11 = r11.findLastPartiallyVisibleItemPosition()
        L_0x0143:
            android.view.View r11 = r9.findViewByPosition(r11)
            if (r11 == 0) goto L_0x014c
            if (r11 == r10) goto L_0x014c
            return r11
        L_0x014c:
            int r7 = r7 + 1
            goto L_0x012c
        L_0x014f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        onLayoutChildren(recycler, state, true);
    }

    public void onLayoutCompleted(State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = LinearLayoutManager.INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.mSpanOffsets = null;
                savedState.mSpanOffsetsSize = 0;
                savedState.mAnchorPosition = -1;
                savedState.mVisibleAnchorPosition = -1;
                savedState.mSpanOffsets = null;
                savedState.mSpanOffsetsSize = 0;
                savedState.mSpanLookupSize = 0;
                savedState.mSpanLookup = null;
                savedState.mFullSpanItems = null;
            }
            requestLayout();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Parcelable onSaveInstanceState() {
        /*
            r5 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r0 = r5.mPendingSavedState
            if (r0 == 0) goto L_0x000a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = new androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState
            r1.<init>(r0)
            return r1
        L_0x000a:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r0 = new androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState
            r0.<init>()
            boolean r1 = r5.mReverseLayout
            r0.mReverseLayout = r1
            boolean r1 = r5.mLastLayoutFromEnd
            r0.mAnchorLayoutFromEnd = r1
            boolean r1 = r5.mLastLayoutRTL
            r0.mLastLayoutRTL = r1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r5.mLazySpanLookup
            r2 = 0
            if (r1 == 0) goto L_0x002e
            int[] r3 = r1.mData
            if (r3 == 0) goto L_0x002e
            r0.mSpanLookup = r3
            int r3 = r3.length
            r0.mSpanLookupSize = r3
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r1 = r1.mFullSpanItems
            r0.mFullSpanItems = r1
            goto L_0x0030
        L_0x002e:
            r0.mSpanLookupSize = r2
        L_0x0030:
            int r1 = r5.getChildCount()
            r3 = -1
            if (r1 <= 0) goto L_0x0098
            boolean r1 = r5.mLastLayoutFromEnd
            if (r1 == 0) goto L_0x0040
            int r1 = r5.getLastChildPosition()
            goto L_0x0044
        L_0x0040:
            int r1 = r5.getFirstChildPosition()
        L_0x0044:
            r0.mAnchorPosition = r1
            boolean r1 = r5.mShouldReverseLayout
            r4 = 1
            if (r1 == 0) goto L_0x0050
            android.view.View r1 = r5.findFirstVisibleItemClosestToEnd(r4)
            goto L_0x0054
        L_0x0050:
            android.view.View r1 = r5.findFirstVisibleItemClosestToStart(r4)
        L_0x0054:
            if (r1 != 0) goto L_0x0057
            goto L_0x005b
        L_0x0057:
            int r3 = r5.getPosition(r1)
        L_0x005b:
            r0.mVisibleAnchorPosition = r3
            int r1 = r5.mSpanCount
            r0.mSpanOffsetsSize = r1
            int[] r1 = new int[r1]
            r0.mSpanOffsets = r1
        L_0x0065:
            int r1 = r5.mSpanCount
            if (r2 >= r1) goto L_0x009e
            boolean r1 = r5.mLastLayoutFromEnd
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == 0) goto L_0x0080
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r5.mSpans
            r1 = r1[r2]
            int r1 = r1.getEndLine(r3)
            if (r1 == r3) goto L_0x0091
            androidx.recyclerview.widget.OrientationHelper r3 = r5.mPrimaryOrientation
            int r3 = r3.getEndAfterPadding()
            goto L_0x0090
        L_0x0080:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r5.mSpans
            r1 = r1[r2]
            int r1 = r1.getStartLine(r3)
            if (r1 == r3) goto L_0x0091
            androidx.recyclerview.widget.OrientationHelper r3 = r5.mPrimaryOrientation
            int r3 = r3.getStartAfterPadding()
        L_0x0090:
            int r1 = r1 - r3
        L_0x0091:
            int[] r3 = r0.mSpanOffsets
            r3[r2] = r1
            int r2 = r2 + 1
            goto L_0x0065
        L_0x0098:
            r0.mAnchorPosition = r3
            r0.mVisibleAnchorPosition = r3
            r0.mSpanOffsetsSize = r2
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onSaveInstanceState():android.os.Parcelable");
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    public final boolean preferLastSpan(int i) {
        boolean z = true;
        if (this.mOrientation == 0) {
            if ((i == -1) == this.mShouldReverseLayout) {
                z = false;
            }
            return z;
        }
        if (((i == -1) == this.mShouldReverseLayout) != isLayoutRTL()) {
            z = false;
        }
        return z;
    }

    public void prepareLayoutStateForDelta(int i, State state) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = getLastChildPosition();
            i2 = 1;
        } else {
            i3 = getFirstChildPosition();
            i2 = -1;
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(i3, state);
        setLayoutStateDirection(i2);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = i3 + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i);
    }

    public final void recycle(Recycler recycler, LayoutState layoutState) {
        int i;
        int i2;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable != 0) {
                int i3 = 1;
                if (layoutState.mLayoutDirection == -1) {
                    int i4 = layoutState.mStartLine;
                    int startLine = this.mSpans[0].getStartLine(i4);
                    while (i3 < this.mSpanCount) {
                        int startLine2 = this.mSpans[i3].getStartLine(i4);
                        if (startLine2 > startLine) {
                            startLine = startLine2;
                        }
                        i3++;
                    }
                    int i5 = i4 - startLine;
                    if (i5 < 0) {
                        i2 = layoutState.mEndLine;
                    } else {
                        i2 = layoutState.mEndLine - Math.min(i5, layoutState.mAvailable);
                    }
                    recycleFromEnd(recycler, i2);
                    return;
                }
                int i6 = layoutState.mEndLine;
                int endLine = this.mSpans[0].getEndLine(i6);
                while (i3 < this.mSpanCount) {
                    int endLine2 = this.mSpans[i3].getEndLine(i6);
                    if (endLine2 < endLine) {
                        endLine = endLine2;
                    }
                    i3++;
                }
                int i7 = endLine - layoutState.mEndLine;
                if (i7 < 0) {
                    i = layoutState.mStartLine;
                } else {
                    i = Math.min(i7, layoutState.mAvailable) + layoutState.mStartLine;
                }
                recycleFromStart(recycler, i);
            } else if (layoutState.mLayoutDirection == -1) {
                recycleFromEnd(recycler, layoutState.mEndLine);
            } else {
                recycleFromStart(recycler, layoutState.mStartLine);
            }
        }
    }

    public final void recycleFromEnd(Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) < i || this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) < i) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.mFullSpan) {
                int i2 = 0;
                while (i2 < this.mSpanCount) {
                    if (this.mSpans[i2].mViews.size() != 1) {
                        i2++;
                    } else {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.mSpans[i3].popEnd();
                }
            } else if (layoutParams.mSpan.mViews.size() != 1) {
                layoutParams.mSpan.popEnd();
            } else {
                return;
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    public final void recycleFromStart(Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > i || this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) > i) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.mFullSpan) {
                int i2 = 0;
                while (i2 < this.mSpanCount) {
                    if (this.mSpans[i2].mViews.size() != 1) {
                        i2++;
                    } else {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.mSpans[i3].popStart();
                }
            } else if (layoutParams.mSpan.mViews.size() != 1) {
                layoutParams.mSpan.popStart();
            } else {
                return;
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    public final void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public int scrollBy(int i, Recycler recycler, State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i, state);
        int fill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.mAvailable >= fill) {
            i = i < 0 ? -fill : fill;
        }
        this.mPrimaryOrientation.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return i;
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        return scrollBy(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mAnchorPosition == i)) {
            savedState.mSpanOffsets = null;
            savedState.mSpanOffsetsSize = 0;
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = LinearLayoutManager.INVALID_OFFSET;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        return scrollBy(i, recycler, state);
    }

    public final void setLayoutStateDirection(int i) {
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i;
        int i2 = 1;
        if (this.mShouldReverseLayout != (i == -1)) {
            i2 = -1;
        }
        layoutState.mItemDirection = i2;
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            i4 = LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            i3 = LayoutManager.chooseSize(i, (this.mSizePerSpan * this.mSpanCount) + paddingRight, getMinimumWidth());
        } else {
            i3 = LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            i4 = LayoutManager.chooseSize(i2, (this.mSizePerSpan * this.mSpanCount) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public final void updateAllRemainingSpans(int i, int i2) {
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateLayoutState(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.LayoutState r0 = r4.mLayoutState
            r1 = 0
            r0.mAvailable = r1
            r0.mCurrentPosition = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L_0x002c
            int r6 = r6.mTargetPosition
            r0 = -1
            if (r6 == r0) goto L_0x002c
            boolean r0 = r4.mShouldReverseLayout
            if (r6 >= r5) goto L_0x0019
            r5 = 1
            goto L_0x001a
        L_0x0019:
            r5 = 0
        L_0x001a:
            if (r0 != r5) goto L_0x0023
            androidx.recyclerview.widget.OrientationHelper r5 = r4.mPrimaryOrientation
            int r5 = r5.getTotalSpace()
            goto L_0x002d
        L_0x0023:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.mPrimaryOrientation
            int r5 = r5.getTotalSpace()
            r6 = r5
            r5 = 0
            goto L_0x002e
        L_0x002c:
            r5 = 0
        L_0x002d:
            r6 = 0
        L_0x002e:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L_0x004b
            androidx.recyclerview.widget.LayoutState r0 = r4.mLayoutState
            androidx.recyclerview.widget.OrientationHelper r3 = r4.mPrimaryOrientation
            int r3 = r3.getStartAfterPadding()
            int r3 = r3 - r6
            r0.mStartLine = r3
            androidx.recyclerview.widget.LayoutState r6 = r4.mLayoutState
            androidx.recyclerview.widget.OrientationHelper r0 = r4.mPrimaryOrientation
            int r0 = r0.getEndAfterPadding()
            int r0 = r0 + r5
            r6.mEndLine = r0
            goto L_0x005b
        L_0x004b:
            androidx.recyclerview.widget.LayoutState r0 = r4.mLayoutState
            androidx.recyclerview.widget.OrientationHelper r3 = r4.mPrimaryOrientation
            int r3 = r3.getEnd()
            int r3 = r3 + r5
            r0.mEndLine = r3
            androidx.recyclerview.widget.LayoutState r5 = r4.mLayoutState
            int r6 = -r6
            r5.mStartLine = r6
        L_0x005b:
            androidx.recyclerview.widget.LayoutState r5 = r4.mLayoutState
            r5.mStopInFocusable = r1
            r5.mRecycle = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.mPrimaryOrientation
            int r6 = r6.getMode()
            if (r6 != 0) goto L_0x0072
            androidx.recyclerview.widget.OrientationHelper r6 = r4.mPrimaryOrientation
            int r6 = r6.getEnd()
            if (r6 != 0) goto L_0x0072
            r1 = 1
        L_0x0072:
            r5.mInfinite = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.updateLayoutState(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public final void updateRemainingSpans(Span span, int i, int i2) {
        int i3 = span.mDeletedSize;
        if (i == -1) {
            int i4 = span.mCachedStart;
            if (i4 == Integer.MIN_VALUE) {
                span.calculateCachedStart();
                i4 = span.mCachedStart;
            }
            if (i4 + i3 <= i2) {
                this.mRemainingSpans.set(span.mIndex, false);
                return;
            }
            return;
        }
        int i5 = span.mCachedEnd;
        if (i5 == Integer.MIN_VALUE) {
            span.calculateCachedEnd();
            i5 = span.mCachedEnd;
        }
        if (i5 - i3 >= i2) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    public final int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:239:0x041d, code lost:
        if (checkForGaps() != false) goto L_0x0421;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r13, androidx.recyclerview.widget.RecyclerView.State r14, boolean r15) {
        /*
            r12 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r12.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r12.mPendingSavedState
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r12.mPendingScrollPosition
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r14.getItemCount()
            if (r1 != 0) goto L_0x0018
            r12.removeAndRecycleAllViews(r13)
            r0.reset()
            return
        L_0x0018:
            boolean r1 = r0.mValid
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0029
            int r1 = r12.mPendingScrollPosition
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r12.mPendingSavedState
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == 0) goto L_0x01fa
            r0.reset()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.mPendingSavedState
            if (r7 == 0) goto L_0x00bc
            int r8 = r7.mSpanOffsetsSize
            if (r8 <= 0) goto L_0x007d
            int r9 = r12.mSpanCount
            if (r8 != r9) goto L_0x006f
            r7 = 0
        L_0x003f:
            int r8 = r12.mSpanCount
            if (r7 >= r8) goto L_0x007d
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r8 = r12.mSpans
            r8 = r8[r7]
            r8.clear()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r8 = r12.mPendingSavedState
            int[] r9 = r8.mSpanOffsets
            r9 = r9[r7]
            if (r9 == r6) goto L_0x0064
            boolean r8 = r8.mAnchorLayoutFromEnd
            if (r8 == 0) goto L_0x005d
            androidx.recyclerview.widget.OrientationHelper r8 = r12.mPrimaryOrientation
            int r8 = r8.getEndAfterPadding()
            goto L_0x0063
        L_0x005d:
            androidx.recyclerview.widget.OrientationHelper r8 = r12.mPrimaryOrientation
            int r8 = r8.getStartAfterPadding()
        L_0x0063:
            int r9 = r9 + r8
        L_0x0064:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r8 = r12.mSpans
            r8 = r8[r7]
            r8.mCachedStart = r9
            r8.mCachedEnd = r9
            int r7 = r7 + 1
            goto L_0x003f
        L_0x006f:
            r7.mSpanOffsets = r5
            r7.mSpanOffsetsSize = r4
            r7.mSpanLookupSize = r4
            r7.mSpanLookup = r5
            r7.mFullSpanItems = r5
            int r8 = r7.mVisibleAnchorPosition
            r7.mAnchorPosition = r8
        L_0x007d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.mPendingSavedState
            boolean r8 = r7.mLastLayoutRTL
            r12.mLastLayoutRTL = r8
            boolean r7 = r7.mReverseLayout
            r12.assertNotInLayoutOrScroll(r5)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r8 = r12.mPendingSavedState
            if (r8 == 0) goto L_0x0092
            boolean r9 = r8.mReverseLayout
            if (r9 == r7) goto L_0x0092
            r8.mReverseLayout = r7
        L_0x0092:
            r12.mReverseLayout = r7
            r12.requestLayout()
            r12.resolveShouldLayoutReverse()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.mPendingSavedState
            int r8 = r7.mAnchorPosition
            if (r8 == r2) goto L_0x00a7
            r12.mPendingScrollPosition = r8
            boolean r7 = r7.mAnchorLayoutFromEnd
            r0.mLayoutFromEnd = r7
            goto L_0x00ab
        L_0x00a7:
            boolean r7 = r12.mShouldReverseLayout
            r0.mLayoutFromEnd = r7
        L_0x00ab:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.mPendingSavedState
            int r8 = r7.mSpanLookupSize
            if (r8 <= r3) goto L_0x00c3
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r12.mLazySpanLookup
            int[] r9 = r7.mSpanLookup
            r8.mData = r9
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r7 = r7.mFullSpanItems
            r8.mFullSpanItems = r7
            goto L_0x00c3
        L_0x00bc:
            r12.resolveShouldLayoutReverse()
            boolean r7 = r12.mShouldReverseLayout
            r0.mLayoutFromEnd = r7
        L_0x00c3:
            boolean r7 = r14.mInPreLayout
            if (r7 != 0) goto L_0x01b7
            int r7 = r12.mPendingScrollPosition
            if (r7 != r2) goto L_0x00cd
            goto L_0x01b7
        L_0x00cd:
            if (r7 < 0) goto L_0x01b3
            int r8 = r14.getItemCount()
            if (r7 < r8) goto L_0x00d7
            goto L_0x01b3
        L_0x00d7:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.mPendingSavedState
            if (r7 == 0) goto L_0x00ec
            int r8 = r7.mAnchorPosition
            if (r8 == r2) goto L_0x00ec
            int r7 = r7.mSpanOffsetsSize
            if (r7 >= r3) goto L_0x00e4
            goto L_0x00ec
        L_0x00e4:
            r0.mOffset = r6
            int r7 = r12.mPendingScrollPosition
            r0.mPosition = r7
            goto L_0x01b1
        L_0x00ec:
            int r7 = r12.mPendingScrollPosition
            android.view.View r7 = r12.findViewByPosition(r7)
            if (r7 == 0) goto L_0x017d
            boolean r8 = r12.mShouldReverseLayout
            if (r8 == 0) goto L_0x00fd
            int r8 = r12.getLastChildPosition()
            goto L_0x0101
        L_0x00fd:
            int r8 = r12.getFirstChildPosition()
        L_0x0101:
            r0.mPosition = r8
            int r8 = r12.mPendingScrollPositionOffset
            if (r8 == r6) goto L_0x0133
            boolean r8 = r0.mLayoutFromEnd
            if (r8 == 0) goto L_0x011f
            androidx.recyclerview.widget.OrientationHelper r8 = r12.mPrimaryOrientation
            int r8 = r8.getEndAfterPadding()
            int r9 = r12.mPendingScrollPositionOffset
            int r8 = r8 - r9
            androidx.recyclerview.widget.OrientationHelper r9 = r12.mPrimaryOrientation
            int r7 = r9.getDecoratedEnd(r7)
            int r8 = r8 - r7
            r0.mOffset = r8
            goto L_0x01b1
        L_0x011f:
            androidx.recyclerview.widget.OrientationHelper r8 = r12.mPrimaryOrientation
            int r8 = r8.getStartAfterPadding()
            int r9 = r12.mPendingScrollPositionOffset
            int r8 = r8 + r9
            androidx.recyclerview.widget.OrientationHelper r9 = r12.mPrimaryOrientation
            int r7 = r9.getDecoratedStart(r7)
            int r8 = r8 - r7
            r0.mOffset = r8
            goto L_0x01b1
        L_0x0133:
            androidx.recyclerview.widget.OrientationHelper r8 = r12.mPrimaryOrientation
            int r8 = r8.getDecoratedMeasurement(r7)
            androidx.recyclerview.widget.OrientationHelper r9 = r12.mPrimaryOrientation
            int r9 = r9.getTotalSpace()
            if (r8 <= r9) goto L_0x0155
            boolean r7 = r0.mLayoutFromEnd
            if (r7 == 0) goto L_0x014c
            androidx.recyclerview.widget.OrientationHelper r7 = r12.mPrimaryOrientation
            int r7 = r7.getEndAfterPadding()
            goto L_0x0152
        L_0x014c:
            androidx.recyclerview.widget.OrientationHelper r7 = r12.mPrimaryOrientation
            int r7 = r7.getStartAfterPadding()
        L_0x0152:
            r0.mOffset = r7
            goto L_0x01b1
        L_0x0155:
            androidx.recyclerview.widget.OrientationHelper r8 = r12.mPrimaryOrientation
            int r8 = r8.getDecoratedStart(r7)
            androidx.recyclerview.widget.OrientationHelper r9 = r12.mPrimaryOrientation
            int r9 = r9.getStartAfterPadding()
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x0168
            int r7 = -r8
            r0.mOffset = r7
            goto L_0x01b1
        L_0x0168:
            androidx.recyclerview.widget.OrientationHelper r8 = r12.mPrimaryOrientation
            int r8 = r8.getEndAfterPadding()
            androidx.recyclerview.widget.OrientationHelper r9 = r12.mPrimaryOrientation
            int r7 = r9.getDecoratedEnd(r7)
            int r8 = r8 - r7
            if (r8 >= 0) goto L_0x017a
            r0.mOffset = r8
            goto L_0x01b1
        L_0x017a:
            r0.mOffset = r6
            goto L_0x01b1
        L_0x017d:
            int r7 = r12.mPendingScrollPosition
            r0.mPosition = r7
            int r8 = r12.mPendingScrollPositionOffset
            if (r8 != r6) goto L_0x0194
            int r7 = r12.calculateScrollDirectionForPosition(r7)
            if (r7 != r3) goto L_0x018d
            r7 = 1
            goto L_0x018e
        L_0x018d:
            r7 = 0
        L_0x018e:
            r0.mLayoutFromEnd = r7
            r0.assignCoordinateFromPadding()
            goto L_0x01af
        L_0x0194:
            boolean r7 = r0.mLayoutFromEnd
            if (r7 == 0) goto L_0x01a4
            androidx.recyclerview.widget.StaggeredGridLayoutManager r7 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.OrientationHelper r7 = r7.mPrimaryOrientation
            int r7 = r7.getEndAfterPadding()
            int r7 = r7 - r8
            r0.mOffset = r7
            goto L_0x01af
        L_0x01a4:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r7 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.OrientationHelper r7 = r7.mPrimaryOrientation
            int r7 = r7.getStartAfterPadding()
            int r7 = r7 + r8
            r0.mOffset = r7
        L_0x01af:
            r0.mInvalidateOffsets = r3
        L_0x01b1:
            r7 = 1
            goto L_0x01b8
        L_0x01b3:
            r12.mPendingScrollPosition = r2
            r12.mPendingScrollPositionOffset = r6
        L_0x01b7:
            r7 = 0
        L_0x01b8:
            if (r7 == 0) goto L_0x01bb
            goto L_0x01f8
        L_0x01bb:
            boolean r7 = r12.mLastLayoutFromEnd
            if (r7 == 0) goto L_0x01d7
            int r7 = r14.getItemCount()
            int r8 = r12.getChildCount()
        L_0x01c7:
            int r8 = r8 + r2
            if (r8 < 0) goto L_0x01f3
            android.view.View r9 = r12.getChildAt(r8)
            int r9 = r12.getPosition(r9)
            if (r9 < 0) goto L_0x01c7
            if (r9 >= r7) goto L_0x01c7
            goto L_0x01f4
        L_0x01d7:
            int r7 = r14.getItemCount()
            int r8 = r12.getChildCount()
            r9 = 0
        L_0x01e0:
            if (r9 >= r8) goto L_0x01f3
            android.view.View r10 = r12.getChildAt(r9)
            int r10 = r12.getPosition(r10)
            if (r10 < 0) goto L_0x01f0
            if (r10 >= r7) goto L_0x01f0
            r9 = r10
            goto L_0x01f4
        L_0x01f0:
            int r9 = r9 + 1
            goto L_0x01e0
        L_0x01f3:
            r9 = 0
        L_0x01f4:
            r0.mPosition = r9
            r0.mOffset = r6
        L_0x01f8:
            r0.mValid = r3
        L_0x01fa:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.mPendingSavedState
            if (r7 != 0) goto L_0x0217
            int r7 = r12.mPendingScrollPosition
            if (r7 != r2) goto L_0x0217
            boolean r7 = r0.mLayoutFromEnd
            boolean r8 = r12.mLastLayoutFromEnd
            if (r7 != r8) goto L_0x0210
            boolean r7 = r12.isLayoutRTL()
            boolean r8 = r12.mLastLayoutRTL
            if (r7 == r8) goto L_0x0217
        L_0x0210:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r12.mLazySpanLookup
            r7.clear()
            r0.mInvalidateOffsets = r3
        L_0x0217:
            int r7 = r12.getChildCount()
            if (r7 <= 0) goto L_0x02cf
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.mPendingSavedState
            if (r7 == 0) goto L_0x0225
            int r7 = r7.mSpanOffsetsSize
            if (r7 >= r3) goto L_0x02cf
        L_0x0225:
            boolean r7 = r0.mInvalidateOffsets
            if (r7 == 0) goto L_0x0244
            r1 = 0
        L_0x022a:
            int r7 = r12.mSpanCount
            if (r1 >= r7) goto L_0x02cf
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r7 = r12.mSpans
            r7 = r7[r1]
            r7.clear()
            int r7 = r0.mOffset
            if (r7 == r6) goto L_0x0241
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r8 = r12.mSpans
            r8 = r8[r1]
            r8.mCachedStart = r7
            r8.mCachedEnd = r7
        L_0x0241:
            int r1 = r1 + 1
            goto L_0x022a
        L_0x0244:
            if (r1 != 0) goto L_0x0266
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r12.mAnchorInfo
            int[] r1 = r1.mSpanReferenceLines
            if (r1 != 0) goto L_0x024d
            goto L_0x0266
        L_0x024d:
            r1 = 0
        L_0x024e:
            int r7 = r12.mSpanCount
            if (r1 >= r7) goto L_0x02cf
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r7 = r12.mSpans
            r7 = r7[r1]
            r7.clear()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r8 = r12.mAnchorInfo
            int[] r8 = r8.mSpanReferenceLines
            r8 = r8[r1]
            r7.mCachedStart = r8
            r7.mCachedEnd = r8
            int r1 = r1 + 1
            goto L_0x024e
        L_0x0266:
            r1 = 0
        L_0x0267:
            int r7 = r12.mSpanCount
            if (r1 >= r7) goto L_0x02a7
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r7 = r12.mSpans
            r7 = r7[r1]
            boolean r8 = r12.mShouldReverseLayout
            int r9 = r0.mOffset
            if (r8 == 0) goto L_0x027a
            int r10 = r7.getEndLine(r6)
            goto L_0x027e
        L_0x027a:
            int r10 = r7.getStartLine(r6)
        L_0x027e:
            r7.clear()
            if (r10 != r6) goto L_0x0284
            goto L_0x02a4
        L_0x0284:
            if (r8 == 0) goto L_0x0290
            androidx.recyclerview.widget.StaggeredGridLayoutManager r11 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.OrientationHelper r11 = r11.mPrimaryOrientation
            int r11 = r11.getEndAfterPadding()
            if (r10 < r11) goto L_0x02a4
        L_0x0290:
            if (r8 != 0) goto L_0x029d
            androidx.recyclerview.widget.StaggeredGridLayoutManager r8 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.OrientationHelper r8 = r8.mPrimaryOrientation
            int r8 = r8.getStartAfterPadding()
            if (r10 <= r8) goto L_0x029d
            goto L_0x02a4
        L_0x029d:
            if (r9 == r6) goto L_0x02a0
            int r10 = r10 + r9
        L_0x02a0:
            r7.mCachedEnd = r10
            r7.mCachedStart = r10
        L_0x02a4:
            int r1 = r1 + 1
            goto L_0x0267
        L_0x02a7:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r12.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r7 = r12.mSpans
            if (r1 == 0) goto L_0x02ce
            int r8 = r7.length
            int[] r9 = r1.mSpanReferenceLines
            if (r9 == 0) goto L_0x02b5
            int r9 = r9.length
            if (r9 >= r8) goto L_0x02be
        L_0x02b5:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r9 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r9 = r9.mSpans
            int r9 = r9.length
            int[] r9 = new int[r9]
            r1.mSpanReferenceLines = r9
        L_0x02be:
            r9 = 0
        L_0x02bf:
            if (r9 >= r8) goto L_0x02cf
            int[] r10 = r1.mSpanReferenceLines
            r11 = r7[r9]
            int r11 = r11.getStartLine(r6)
            r10[r9] = r11
            int r9 = r9 + 1
            goto L_0x02bf
        L_0x02ce:
            throw r5
        L_0x02cf:
            r12.detachAndScrapAttachedViews(r13)
            androidx.recyclerview.widget.LayoutState r1 = r12.mLayoutState
            r1.mRecycle = r4
            r12.mLaidOutInvalidFullSpan = r4
            androidx.recyclerview.widget.OrientationHelper r1 = r12.mSecondaryOrientation
            int r1 = r1.getTotalSpace()
            int r7 = r12.mSpanCount
            int r7 = r1 / r7
            r12.mSizePerSpan = r7
            androidx.recyclerview.widget.OrientationHelper r7 = r12.mSecondaryOrientation
            int r7 = r7.getMode()
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r7)
            r12.mFullSizeSpec = r1
            int r1 = r0.mPosition
            r12.updateLayoutState(r1, r14)
            boolean r1 = r0.mLayoutFromEnd
            if (r1 == 0) goto L_0x0311
            r12.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.LayoutState r1 = r12.mLayoutState
            r12.fill(r13, r1, r14)
            r12.setLayoutStateDirection(r3)
            androidx.recyclerview.widget.LayoutState r1 = r12.mLayoutState
            int r2 = r0.mPosition
            int r7 = r1.mItemDirection
            int r2 = r2 + r7
            r1.mCurrentPosition = r2
            r12.fill(r13, r1, r14)
            goto L_0x0328
        L_0x0311:
            r12.setLayoutStateDirection(r3)
            androidx.recyclerview.widget.LayoutState r1 = r12.mLayoutState
            r12.fill(r13, r1, r14)
            r12.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.LayoutState r1 = r12.mLayoutState
            int r2 = r0.mPosition
            int r7 = r1.mItemDirection
            int r2 = r2 + r7
            r1.mCurrentPosition = r2
            r12.fill(r13, r1, r14)
        L_0x0328:
            androidx.recyclerview.widget.OrientationHelper r1 = r12.mSecondaryOrientation
            int r1 = r1.getMode()
            r2 = 1073741824(0x40000000, float:2.0)
            if (r1 != r2) goto L_0x0334
            goto L_0x03de
        L_0x0334:
            r1 = 0
            int r2 = r12.getChildCount()
            r7 = 0
        L_0x033a:
            if (r7 >= r2) goto L_0x035c
            android.view.View r8 = r12.getChildAt(r7)
            androidx.recyclerview.widget.OrientationHelper r9 = r12.mSecondaryOrientation
            int r9 = r9.getDecoratedMeasurement(r8)
            float r9 = (float) r9
            int r10 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x034c
            goto L_0x0358
        L_0x034c:
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            if (r8 == 0) goto L_0x035b
            float r1 = java.lang.Math.max(r1, r9)
        L_0x0358:
            int r7 = r7 + 1
            goto L_0x033a
        L_0x035b:
            throw r5
        L_0x035c:
            int r5 = r12.mSizePerSpan
            int r7 = r12.mSpanCount
            float r7 = (float) r7
            float r1 = r1 * r7
            int r1 = java.lang.Math.round(r1)
            androidx.recyclerview.widget.OrientationHelper r7 = r12.mSecondaryOrientation
            int r7 = r7.getMode()
            if (r7 != r6) goto L_0x0379
            androidx.recyclerview.widget.OrientationHelper r6 = r12.mSecondaryOrientation
            int r6 = r6.getTotalSpace()
            int r1 = java.lang.Math.min(r1, r6)
        L_0x0379:
            int r6 = r12.mSpanCount
            int r6 = r1 / r6
            r12.mSizePerSpan = r6
            androidx.recyclerview.widget.OrientationHelper r6 = r12.mSecondaryOrientation
            int r6 = r6.getMode()
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r6)
            r12.mFullSizeSpec = r1
            int r1 = r12.mSizePerSpan
            if (r1 != r5) goto L_0x0390
            goto L_0x03de
        L_0x0390:
            r1 = 0
        L_0x0391:
            if (r1 >= r2) goto L_0x03de
            android.view.View r6 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r7 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r7
            boolean r8 = r7.mFullSpan
            if (r8 == 0) goto L_0x03a2
            goto L_0x03db
        L_0x03a2:
            boolean r8 = r12.isLayoutRTL()
            if (r8 == 0) goto L_0x03c4
            int r8 = r12.mOrientation
            if (r8 != r3) goto L_0x03c4
            int r8 = r12.mSpanCount
            int r9 = r8 + -1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r7 = r7.mSpan
            int r7 = r7.mIndex
            int r9 = r9 - r7
            int r9 = -r9
            int r10 = r12.mSizePerSpan
            int r9 = r9 * r10
            int r8 = r8 - r3
            int r8 = r8 - r7
            int r7 = -r8
            int r7 = r7 * r5
            int r9 = r9 - r7
            r6.offsetLeftAndRight(r9)
            goto L_0x03db
        L_0x03c4:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r7 = r7.mSpan
            int r7 = r7.mIndex
            int r8 = r12.mSizePerSpan
            int r8 = r8 * r7
            int r7 = r7 * r5
            int r9 = r12.mOrientation
            if (r9 != r3) goto L_0x03d7
            int r8 = r8 - r7
            r6.offsetLeftAndRight(r8)
            goto L_0x03db
        L_0x03d7:
            int r8 = r8 - r7
            r6.offsetTopAndBottom(r8)
        L_0x03db:
            int r1 = r1 + 1
            goto L_0x0391
        L_0x03de:
            int r1 = r12.getChildCount()
            if (r1 <= 0) goto L_0x03f5
            boolean r1 = r12.mShouldReverseLayout
            if (r1 == 0) goto L_0x03ef
            r12.fixEndGap(r13, r14, r3)
            r12.fixStartGap(r13, r14, r4)
            goto L_0x03f5
        L_0x03ef:
            r12.fixStartGap(r13, r14, r3)
            r12.fixEndGap(r13, r14, r4)
        L_0x03f5:
            if (r15 == 0) goto L_0x0420
            boolean r15 = r14.mInPreLayout
            if (r15 != 0) goto L_0x0420
            int r15 = r12.mGapStrategy
            if (r15 == 0) goto L_0x0411
            int r15 = r12.getChildCount()
            if (r15 <= 0) goto L_0x0411
            boolean r15 = r12.mLaidOutInvalidFullSpan
            if (r15 != 0) goto L_0x040f
            android.view.View r15 = r12.hasGapsToFix()
            if (r15 == 0) goto L_0x0411
        L_0x040f:
            r15 = 1
            goto L_0x0412
        L_0x0411:
            r15 = 0
        L_0x0412:
            if (r15 == 0) goto L_0x0420
            java.lang.Runnable r15 = r12.mCheckForGapsRunnable
            r12.removeCallbacks(r15)
            boolean r15 = r12.checkForGaps()
            if (r15 == 0) goto L_0x0420
            goto L_0x0421
        L_0x0420:
            r3 = 0
        L_0x0421:
            boolean r15 = r14.mInPreLayout
            if (r15 == 0) goto L_0x042a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r15 = r12.mAnchorInfo
            r15.reset()
        L_0x042a:
            boolean r15 = r0.mLayoutFromEnd
            r12.mLastLayoutFromEnd = r15
            boolean r15 = r12.isLayoutRTL()
            r12.mLastLayoutRTL = r15
            if (r3 == 0) goto L_0x043e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r15 = r12.mAnchorInfo
            r15.reset()
            r12.onLayoutChildren(r13, r14, r4)
        L_0x043e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }
}
