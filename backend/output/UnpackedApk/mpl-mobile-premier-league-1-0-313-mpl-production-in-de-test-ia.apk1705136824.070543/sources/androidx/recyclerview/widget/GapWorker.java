package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class GapWorker implements Runnable {
    public static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    public static Comparator<Task> sTaskComparator = new Comparator<Task>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r6.view == null) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r0 != false) goto L_0x0024;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(java.lang.Object r6, java.lang.Object r7) {
            /*
                r5 = this;
                androidx.recyclerview.widget.GapWorker$Task r6 = (androidx.recyclerview.widget.GapWorker.Task) r6
                androidx.recyclerview.widget.GapWorker$Task r7 = (androidx.recyclerview.widget.GapWorker.Task) r7
                androidx.recyclerview.widget.RecyclerView r0 = r6.view
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x000c
                r0 = 1
                goto L_0x000d
            L_0x000c:
                r0 = 0
            L_0x000d:
                androidx.recyclerview.widget.RecyclerView r3 = r7.view
                if (r3 != 0) goto L_0x0013
                r3 = 1
                goto L_0x0014
            L_0x0013:
                r3 = 0
            L_0x0014:
                r4 = -1
                if (r0 == r3) goto L_0x001c
                androidx.recyclerview.widget.RecyclerView r6 = r6.view
                if (r6 != 0) goto L_0x0024
                goto L_0x0025
            L_0x001c:
                boolean r0 = r6.immediate
                boolean r3 = r7.immediate
                if (r0 == r3) goto L_0x0027
                if (r0 == 0) goto L_0x0025
            L_0x0024:
                r1 = -1
            L_0x0025:
                r2 = r1
                goto L_0x0038
            L_0x0027:
                int r0 = r7.viewVelocity
                int r1 = r6.viewVelocity
                int r0 = r0 - r1
                if (r0 == 0) goto L_0x0030
                r2 = r0
                goto L_0x0038
            L_0x0030:
                int r6 = r6.distanceToItem
                int r7 = r7.distanceToItem
                int r6 = r6 - r7
                if (r6 == 0) goto L_0x0038
                r2 = r6
            L_0x0038:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GapWorker.AnonymousClass1.compare(java.lang.Object, java.lang.Object):int");
        }
    };
    public long mFrameIntervalNs;
    public long mPostTimeNs;
    public ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    public ArrayList<Task> mTasks = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    public static class LayoutPrefetchRegistryImpl implements LayoutPrefetchRegistry {
        public int mCount;
        public int[] mPrefetchArray;
        public int mPrefetchDx;
        public int mPrefetchDy;

        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.mCount * 2;
                int[] iArr = this.mPrefetchArray;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.mPrefetchArray = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.mPrefetchArray = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.mPrefetchArray;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.mCount++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                int i = this.mCount;
                if (i > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public boolean lastPrefetchIncludedPosition(int i) {
            if (this.mPrefetchArray != null) {
                int i2 = this.mCount * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.mPrefetchArray[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;
    }

    public void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.mPrefetchDx = i;
        layoutPrefetchRegistryImpl.mPrefetchDy = i2;
    }

    public void prefetch(long j) {
        Task task;
        int size = this.mRecyclerViews.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.mCount;
            }
        }
        this.mTasks.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx);
                for (int i5 = 0; i5 < layoutPrefetchRegistryImpl.mCount * 2; i5 += 2) {
                    if (i3 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i3);
                    }
                    int i6 = layoutPrefetchRegistryImpl.mPrefetchArray[i5 + 1];
                    task.immediate = i6 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i6;
                    task.view = recyclerView2;
                    task.position = layoutPrefetchRegistryImpl.mPrefetchArray[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
        int i7 = 0;
        while (i7 < this.mTasks.size()) {
            Task task2 = this.mTasks.get(i7);
            if (task2.view != null) {
                ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task2.view, task2.position, task2.immediate ? Long.MAX_VALUE : j);
                if (prefetchPositionWithDeadline != null && prefetchPositionWithDeadline.mNestedRecyclerView != null && prefetchPositionWithDeadline.isBound() && !prefetchPositionWithDeadline.isInvalid()) {
                    RecyclerView recyclerView3 = (RecyclerView) prefetchPositionWithDeadline.mNestedRecyclerView.get();
                    if (recyclerView3 != null) {
                        if (recyclerView3.mDataSetHasChangedAfterLayout && recyclerView3.mChildHelper.getUnfilteredChildCount() != 0) {
                            recyclerView3.removeAndRecycleViews();
                        }
                        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl2 = recyclerView3.mPrefetchRegistry;
                        layoutPrefetchRegistryImpl2.collectPrefetchPositionsFromView(recyclerView3, true);
                        if (layoutPrefetchRegistryImpl2.mCount != 0) {
                            try {
                                TraceCompat.beginSection("RV Nested Prefetch");
                                State state = recyclerView3.mState;
                                Adapter adapter = recyclerView3.mAdapter;
                                state.mLayoutStep = 1;
                                state.mItemCount = adapter.getItemCount();
                                state.mInPreLayout = false;
                                state.mTrackOldChangeHolders = false;
                                state.mIsMeasuring = false;
                                for (int i8 = 0; i8 < layoutPrefetchRegistryImpl2.mCount * 2; i8 += 2) {
                                    prefetchPositionWithDeadline(recyclerView3, layoutPrefetchRegistryImpl2.mPrefetchArray[i8], j);
                                }
                                Trace.endSection();
                            } catch (Throwable th) {
                                TraceCompat.endSection();
                                throw th;
                            }
                        }
                    }
                }
                task2.immediate = false;
                task2.viewVelocity = 0;
                task2.distanceToItem = 0;
                task2.view = null;
                task2.position = 0;
                i7++;
            } else {
                return;
            }
        }
    }

    public final ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= unfilteredChildCount) {
                z = false;
                break;
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i, false, j);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (!tryGetViewHolderForPositionByDeadline.isBound() || tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                } else {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                }
            }
            return tryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (this.mRecyclerViews.isEmpty()) {
                this.mPostTimeNs = 0;
                Trace.endSection();
                return;
            }
            int size = this.mRecyclerViews.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.mRecyclerViews.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.mPostTimeNs = 0;
                Trace.endSection();
                return;
            }
            prefetch(TimeUnit.MILLISECONDS.toNanos(j) + this.mFrameIntervalNs);
            this.mPostTimeNs = 0;
            Trace.endSection();
        } catch (Throwable th) {
            this.mPostTimeNs = 0;
            TraceCompat.endSection();
            throw th;
        }
    }
}
