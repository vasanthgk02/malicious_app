package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper.UpdateOp;
import androidx.recyclerview.widget.ChildHelper.Bucket;
import androidx.recyclerview.widget.DefaultItemAnimator.ChangeInfo;
import androidx.recyclerview.widget.DefaultItemAnimator.MoveInfo;
import androidx.recyclerview.widget.GapWorker.LayoutPrefetchRegistryImpl;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate.ItemDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck.Callback;
import androidx.recyclerview.widget.ViewInfoStore.InfoRecord;
import androidx.recyclerview.widget.ViewInfoStore.ProcessCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMap;

public class RecyclerView extends ViewGroup implements NestedScrollingChild {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (VERSION.SDK_INT >= 23);
    public static final boolean ALLOW_THREAD_GAP_WORK = true;
    public static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    public static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    public static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final boolean POST_UPDATES_ON_ANIMATION = true;
    public static final Interpolator sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    public RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    public final AccessibilityManager mAccessibilityManager;
    public Adapter mAdapter;
    public AdapterHelper mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    public EdgeEffect mBottomGlow;
    public ChildDrawingOrderCallback mChildDrawingOrderCallback;
    public ChildHelper mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    public int mDispatchScrollCounter;
    public int mEatenAccessibilityChangeFlags;
    public EdgeEffectFactory mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public GapWorker mGapWorker;
    public boolean mHasFixedSize;
    public boolean mIgnoreMotionEventTillDown;
    public int mInitialTouchX;
    public int mInitialTouchY;
    public int mInterceptRequestLayoutDepth;
    public OnItemTouchListener mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public ItemAnimator mItemAnimator;
    public ItemAnimatorListener mItemAnimatorListener;
    public Runnable mItemAnimatorRunner;
    public final ArrayList<ItemDecoration> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    public int mLastAutoMeasureNonExactMeasuredHeight;
    public int mLastAutoMeasureNonExactMeasuredWidth;
    public boolean mLastAutoMeasureSkippedDueToExact;
    public int mLastTouchX;
    public int mLastTouchY;
    public LayoutManager mLayout;
    public int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    public EdgeEffect mLeftGlow;
    public final int mMaxFlingVelocity;
    public final int mMinFlingVelocity;
    public final int[] mMinMaxLayoutPositions;
    public final int[] mNestedOffsets;
    public final RecyclerViewDataObserver mObserver;
    public List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    public OnFlingListener mOnFlingListener;
    public final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    public final List<ViewHolder> mPendingAccessibilityImportanceChange;
    public SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public LayoutPrefetchRegistryImpl mPrefetchRegistry;
    public boolean mPreserveFocusAfterLayout;
    public final Recycler mRecycler;
    public RecyclerListener mRecyclerListener;
    public final List<RecyclerListener> mRecyclerListeners;
    public final int[] mReusableIntPair;
    public EdgeEffect mRightGlow;
    public float mScaledHorizontalScrollFactor;
    public float mScaledVerticalScrollFactor;
    public OnScrollListener mScrollListener;
    public List<OnScrollListener> mScrollListeners;
    public final int[] mScrollOffset;
    public int mScrollPointerId;
    public int mScrollState;
    public NestedScrollingChildHelper mScrollingChildHelper;
    public final State mState;
    public final Rect mTempRect;
    public final Rect mTempRect2;
    public final RectF mTempRectF;
    public EdgeEffect mTopGlow;
    public int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    public VelocityTracker mVelocityTracker;
    public final ViewFlinger mViewFlinger;
    public final ProcessCallback mViewInfoProcessCallback;
    public final ViewInfoStore mViewInfoStore;

    public static abstract class Adapter<VH extends ViewHolder> {
        public boolean mHasStableIds = false;
        public final AdapterDataObservable mObservable = new AdapterDataObservable();
        public StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh, int i) {
            boolean z = vh.mBindingAdapter == null;
            if (z) {
                vh.mPosition = i;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i);
                }
                vh.setFlags(1, GL20.GL_ALWAYS);
                TraceCompat.beginSection("RV OnBindView");
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            if (z) {
                vh.clearPayload();
                android.view.ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                TraceCompat.endSection();
            }
        }

        public boolean canRestoreState() {
            int ordinal = this.mStateRestorationPolicy.ordinal();
            boolean z = false;
            if (ordinal != 1) {
                return ordinal != 2;
            }
            if (getItemCount() > 0) {
                z = true;
            }
            return z;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    Trace.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                TraceCompat.endSection();
                throw th;
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=androidx.recyclerview.widget.RecyclerView$Adapter<? extends androidx.recyclerview.widget.RecyclerView$ViewHolder>, code=androidx.recyclerview.widget.RecyclerView$Adapter, for r1v0, types: [androidx.recyclerview.widget.RecyclerView$Adapter<? extends androidx.recyclerview.widget.RecyclerView$ViewHolder>, androidx.recyclerview.widget.RecyclerView$Adapter] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int findRelativeAdapterPositionIn(androidx.recyclerview.widget.RecyclerView.Adapter r1, androidx.recyclerview.widget.RecyclerView.ViewHolder r2, int r3) {
            /*
                r0 = this;
                if (r1 != r0) goto L_0x0003
                return r3
            L_0x0003:
                r1 = -1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Adapter.findRelativeAdapterPositionIn(androidx.recyclerview.widget.RecyclerView$Adapter, androidx.recyclerview.widget.RecyclerView$ViewHolder, int):int");
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.notifyItemRangeChanged(i, 1, null);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.notifyItemRangeChanged(i, i2, null);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.notifyItemRangeRemoved(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.notifyItemRangeRemoved(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, i2, obj);
        }
    }

    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public void notifyItemRangeChanged(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void notifyStateRestorationPolicyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onStateRestorationPolicyChanged() {
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    public static class EdgeEffectFactory {
        public EdgeEffect createEdgeEffect(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public long mAddDuration = 120;
        public long mChangeDuration = 250;
        public ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        public ItemAnimatorListener mListener = null;
        public long mMoveDuration = 250;
        public long mRemoveDuration = 120;

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public interface ItemAnimatorListener {
        }

        public static class ItemHolderInfo {
            public int left;
            public int top;
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                if (!(oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition)) {
                    i |= 2048;
                }
            }
            return i;
        }

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
            return !((SimpleItemAnimator) this).mSupportsChangeAnimations || viewHolder.isInvalid();
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                ItemAnimatorRestoreListener itemAnimatorRestoreListener = (ItemAnimatorRestoreListener) itemAnimatorListener;
                if (itemAnimatorRestoreListener != null) {
                    boolean z = true;
                    viewHolder.setIsRecyclable(true);
                    if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                        viewHolder.mShadowedHolder = null;
                    }
                    viewHolder.mShadowingHolder = null;
                    if (!viewHolder.shouldBeKeptAsChild()) {
                        RecyclerView recyclerView = RecyclerView.this;
                        View view = viewHolder.itemView;
                        recyclerView.startInterceptRequestLayout();
                        ChildHelper childHelper = recyclerView.mChildHelper;
                        int indexOfChild = RecyclerView.this.indexOfChild(view);
                        if (indexOfChild == -1) {
                            childHelper.unhideViewInternal(view);
                        } else if (childHelper.mBucket.get(indexOfChild)) {
                            childHelper.mBucket.remove(indexOfChild);
                            childHelper.unhideViewInternal(view);
                            ((AnonymousClass5) childHelper.mCallback).removeViewAt(indexOfChild);
                        } else {
                            z = false;
                        }
                        if (z) {
                            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                            recyclerView.mRecycler.unscrapView(childViewHolderInt);
                            recyclerView.mRecycler.recycleViewHolderInternal(childViewHolderInt);
                        }
                        recyclerView.stopInterceptRequestLayout(!z);
                        if (!z && viewHolder.isTmpDetached()) {
                            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw null;
            }
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public ItemHolderInfo recordPreLayoutInformation(ViewHolder viewHolder) {
            ItemHolderInfo itemHolderInfo = new ItemHolderInfo();
            View view = viewHolder.itemView;
            itemHolderInfo.left = view.getLeft();
            itemHolderInfo.top = view.getTop();
            view.getRight();
            view.getBottom();
            return itemHolderInfo;
        }
    }

    public class ItemAnimatorRestoreListener implements ItemAnimatorListener {
        public ItemAnimatorRestoreListener() {
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    public static abstract class LayoutManager {
        public boolean mAutoMeasure = false;
        public ChildHelper mChildHelper;
        public int mHeight;
        public int mHeightMode;
        public ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
        public final Callback mHorizontalBoundCheckCallback = new Callback() {
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int getParentEnd() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            public int getParentStart() {
                return LayoutManager.this.getPaddingLeft();
            }
        };
        public boolean mIsAttachedToWindow = false;
        public boolean mItemPrefetchEnabled = true;
        public boolean mMeasurementCacheEnabled = true;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public boolean mRequestedSimpleAnimations = false;
        public SmoothScroller mSmoothScroller;
        public ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
        public final Callback mVerticalBoundCheckCallback = new Callback() {
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int getParentEnd() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            public int getParentStart() {
                return LayoutManager.this.getPaddingTop();
            }
        };
        public int mWidth;
        public int mWidthMode;

        public interface LayoutPrefetchRegistry {
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        private void addViewInt(View view, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int indexOfChild = this.mChildHelper.indexOfChild(view);
                if (i == -1) {
                    i = this.mChildHelper.getChildCount();
                }
                if (indexOfChild == -1) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    outline73.append(this.mRecyclerView.indexOfChild(view));
                    throw new IllegalStateException(GeneratedOutlineSupport.outline33(this.mRecyclerView, outline73));
                } else if (indexOfChild != i) {
                    this.mRecyclerView.mLayout.moveView(indexOfChild, i);
                }
            } else {
                this.mChildHelper.addView(view, i, false);
                layoutParams.mInsetsDirty = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(size, Math.max(i2, i3));
            }
            if (mode != 1073741824) {
                size = Math.max(i2, i3);
            }
            return size;
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.detachViewFromParent(i);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r3 = 0
                goto L_0x0021
            L_0x000f:
                if (r3 < 0) goto L_0x0014
            L_0x0011:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0021
            L_0x0014:
                r4 = -1
                if (r3 != r4) goto L_0x001b
                r2 = 1073741824(0x40000000, float:2.0)
            L_0x0019:
                r3 = r1
                goto L_0x0021
            L_0x001b:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0019
            L_0x0021:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i >= width || rect.right - i <= paddingLeft || rect.top - i2 >= height || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            boolean z = false;
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                if (size >= i) {
                    z = true;
                }
                return z;
            } else if (mode == 0) {
                return true;
            } else {
                if (mode != 1073741824) {
                    return false;
                }
                if (size == i) {
                    z = true;
                }
                return z;
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i);
                    recycler.scrapView(view);
                    this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
                } else {
                    removeViewAt(i);
                    recycler.recycleViewHolderInternal(childViewHolderInt);
                }
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && !recyclerView.isComputingLayout()) {
                if (str == null) {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline33(recyclerView, GeneratedOutlineSupport.outline73("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
                }
                throw new IllegalStateException(GeneratedOutlineSupport.outline33(recyclerView, GeneratedOutlineSupport.outline73(str)));
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler) {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void detachView(View view) {
            int indexOfChild = this.mChildHelper.indexOfChild(view);
            if (indexOfChild >= 0) {
                detachViewInternal(indexOfChild, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return null;
            }
            View findContainingItemView = recyclerView.findContainingItemView(view);
            if (findContainingItemView != null && !this.mChildHelper.mHiddenViews.contains(findContainingItemView)) {
                return findContainingItemView;
            }
            return null;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.mInPreLayout || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int i) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper == null) {
                return null;
            }
            return ((AnonymousClass5) childHelper.mCallback).getChildAt(childHelper.getOffset(i));
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return null;
            }
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null || this.mChildHelper.mHiddenViews.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null) {
                Matrix matrix = view.getMatrix();
                if (matrix != null && !matrix.isIdentity()) {
                    RectF rectF = this.mRecyclerView.mTempRectF;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(this.mRecyclerView, GeneratedOutlineSupport.outline73("View should be fully attached to be ignored")));
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i + rect.left + layoutParams.leftMargin, i2 + rect.top + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i4, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin + i4, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                int childCount = recyclerView.mChildHelper.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.mChildHelper.getChildAt(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                int childCount = recyclerView.mChildHelper.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.mChildHelper.getChildAt(i2).offsetTopAndBottom(i);
                }
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(Recycler recycler, State state) {
        }

        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(Recycler recycler, State state, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleScrapInt(Recycler recycler) {
            int size = recycler.mAttachedScrap.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = recycler.mAttachedScrap.get(i).itemView;
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    recycler.recycleViewHolderInternal(childViewHolderInt2);
                }
            }
            recycler.mAttachedScrap.clear();
            ArrayList<ViewHolder> arrayList = recycler.mChangedScrap;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            ChildHelper childHelper = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (childHelper.mBucket.remove(indexOfChild)) {
                    childHelper.unhideViewInternal(view);
                }
                ((AnonymousClass5) childHelper.mCallback).removeViewAt(indexOfChild);
            }
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.removeViewAt(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = MeasureSpec.getSize(i2);
            int mode2 = MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = LinearLayoutManager.INVALID_OFFSET;
            int i4 = LinearLayoutManager.INVALID_OFFSET;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i2, layoutParams.height);
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i2, layoutParams.height);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                Adapter adapter = this.mRecyclerView.mAdapter;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.mInfo.addAction(8192);
                accessibilityNodeInfoCompat.mInfo.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.mInfo.addAction(4096);
                accessibilityNodeInfoCompat.mInfo.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.Recycler r8, androidx.recyclerview.widget.RecyclerView.State r9, int r10, android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.mRecyclerView
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.148E-41)
                if (r10 == r11) goto L_0x0012
                r2 = 0
                r3 = 0
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.getHeight()
                int r11 = r7.getPaddingTop()
                int r8 = r8 - r11
                int r11 = r7.getPaddingBottom()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.mRecyclerView
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.getHeight()
                int r10 = r7.getPaddingTop()
                int r8 = r8 - r10
                int r10 = r7.getPaddingBottom()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.mRecyclerView
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = 0
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.mRecyclerView
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.smoothScrollBy(r2, r3, r4, r5, r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2, null, LinearLayoutManager.INVALID_OFFSET, false);
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public final Rect mDecorInsets = new Rect();
        public boolean mInsetsDirty = true;
        public boolean mPendingInvalidate = false;
        public ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
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

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    public static abstract class OnFlingListener {
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class RecycledViewPool {
        public int mAttachCount = 0;
        public SparseArray<ScrapData> mScrap = new SparseArray<>();

        public static class ScrapData {
            public long mBindRunningAverageNs = 0;
            public long mCreateRunningAverageNs = 0;
            public int mMaxScrap = 5;
            public final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();
        }

        public final ScrapData getScrapDataForType(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.mScrap.put(i, scrapData2);
            return scrapData2;
        }

        public long runningAverage(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    public final class Recycler {
        public final ArrayList<ViewHolder> mAttachedScrap = new ArrayList<>();
        public final ArrayList<ViewHolder> mCachedViews = new ArrayList<>();
        public ArrayList<ViewHolder> mChangedScrap = null;
        public RecycledViewPool mRecyclerPool;
        public int mRequestedCacheMax = 2;
        public final List<ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
        public int mViewCacheMax = 2;

        public Recycler() {
        }

        public void addViewHolderToRecycledViewPool(ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                ItemDelegate itemDelegate = recyclerViewAccessibilityDelegate.mItemDelegate;
                ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof ItemDelegate ? itemDelegate.mOriginalItemDelegates.remove(view) : null);
            }
            if (z) {
                RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled(viewHolder);
                }
                int size = RecyclerView.this.mRecyclerListeners.size();
                for (int i = 0; i < size; i++) {
                    RecyclerView.this.mRecyclerListeners.get(i).onViewRecycled(viewHolder);
                }
                Adapter adapter = RecyclerView.this.mAdapter;
                if (adapter != null) {
                    adapter.onViewRecycled(viewHolder);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
                }
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            RecycledViewPool recycledViewPool = getRecycledViewPool();
            if (recycledViewPool != null) {
                int itemViewType = viewHolder.getItemViewType();
                ArrayList<ViewHolder> arrayList = recycledViewPool.getScrapDataForType(itemViewType).mScrapHeap;
                if (recycledViewPool.mScrap.get(itemViewType).mMaxScrap > arrayList.size()) {
                    viewHolder.resetInternal();
                    arrayList.add(viewHolder);
                    return;
                }
                return;
            }
            throw null;
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.getItemCount()) {
                StringBuilder outline74 = GeneratedOutlineSupport.outline74("invalid position ", i, ". State item count is ");
                outline74.append(RecyclerView.this.mState.getItemCount());
                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline33(RecyclerView.this, outline74));
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mState.mInPreLayout) {
                return i;
            }
            return recyclerView.mAdapterHelper.findPositionOffset(i, 0);
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        public void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                layoutPrefetchRegistryImpl.mCount = 0;
            }
        }

        public void recycleCachedViewAt(int i) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(i), true);
            this.mCachedViews.remove(i);
        }

        public void recycleView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        public void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z = false;
            boolean z2 = true;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Scrapped or attached views may not be recycled. isScrap:");
                outline73.append(viewHolder.isScrap());
                outline73.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z = true;
                }
                outline73.append(z);
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(RecyclerView.this, outline73));
            } else if (viewHolder.isTmpDetached()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(viewHolder);
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(RecyclerView.this, sb));
            } else if (!viewHolder.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                Adapter adapter = RecyclerView.this.mAdapter;
                if ((adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                    if (this.mViewCacheMax <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.mCachedViews.size();
                        if (size >= this.mViewCacheMax && size > 0) {
                            recycleCachedViewAt(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                            do {
                                size--;
                                if (size < 0) {
                                    break;
                                }
                            } while (RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(size).mPosition));
                            size++;
                        }
                        this.mCachedViews.add(size, viewHolder);
                        z = true;
                    }
                    if (!z) {
                        addViewHolderToRecycledViewPool(viewHolder, true);
                        RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                        if (!z && !z2 && doesTransientStatePreventRecycling) {
                            viewHolder.mBindingAdapter = null;
                            viewHolder.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                }
                z2 = false;
                RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                if (!z) {
                }
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(RecyclerView.this, GeneratedOutlineSupport.outline73("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        public void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated()) {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (!(itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(childViewHolderInt, childViewHolderInt.getUnmodifiedPayloads()))) {
                    if (this.mChangedScrap == null) {
                        this.mChangedScrap = new ArrayList<>();
                    }
                    childViewHolderInt.setScrapContainer(this, true);
                    this.mChangedScrap.add(childViewHolderInt);
                    return;
                }
            }
            if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.mAttachedScrap.add(childViewHolderInt);
                return;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(RecyclerView.this, GeneratedOutlineSupport.outline73("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0318, code lost:
            r7 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0323, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x046a, code lost:
            if ((r5 == 0 || r5 + r10 < r21) == false) goto L_0x046c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x025d  */
        /* JADX WARNING: Removed duplicated region for block: B:207:0x03ff  */
        /* JADX WARNING: Removed duplicated region for block: B:221:0x0453  */
        /* JADX WARNING: Removed duplicated region for block: B:236:0x04a1  */
        /* JADX WARNING: Removed duplicated region for block: B:252:0x04d2  */
        /* JADX WARNING: Removed duplicated region for block: B:255:0x04db  */
        /* JADX WARNING: Removed duplicated region for block: B:259:0x04e6  */
        /* JADX WARNING: Removed duplicated region for block: B:260:0x04f4  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int r19, boolean r20, long r21) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                if (r1 < 0) goto L_0x0517
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.getItemCount()
                if (r1 >= r2) goto L_0x0517
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                boolean r2 = r2.mInPreLayout
                r3 = 32
                r4 = 0
                r5 = 0
                if (r2 == 0) goto L_0x0091
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r2 = r0.mChangedScrap
                if (r2 == 0) goto L_0x008c
                int r2 = r2.size()
                if (r2 != 0) goto L_0x0027
                goto L_0x008c
            L_0x0027:
                r6 = 0
            L_0x0028:
                if (r6 >= r2) goto L_0x0045
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r0.mChangedScrap
                java.lang.Object r7 = r7.get(r6)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r7 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r7
                boolean r8 = r7.wasReturnedFromScrap()
                if (r8 != 0) goto L_0x0042
                int r8 = r7.getLayoutPosition()
                if (r8 != r1) goto L_0x0042
                r7.addFlags(r3)
                goto L_0x008d
            L_0x0042:
                int r6 = r6 + 1
                goto L_0x0028
            L_0x0045:
                androidx.recyclerview.widget.RecyclerView r6 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r6 = r6.mAdapter
                boolean r6 = r6.hasStableIds()
                if (r6 == 0) goto L_0x008c
                androidx.recyclerview.widget.RecyclerView r6 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r6 = r6.mAdapterHelper
                int r6 = r6.findPositionOffset(r1, r5)
                if (r6 <= 0) goto L_0x008c
                androidx.recyclerview.widget.RecyclerView r7 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r7 = r7.mAdapter
                int r7 = r7.getItemCount()
                if (r6 >= r7) goto L_0x008c
                androidx.recyclerview.widget.RecyclerView r7 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r7 = r7.mAdapter
                long r6 = r7.getItemId(r6)
                r8 = 0
            L_0x006c:
                if (r8 >= r2) goto L_0x008c
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r9 = r0.mChangedScrap
                java.lang.Object r9 = r9.get(r8)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r9
                boolean r10 = r9.wasReturnedFromScrap()
                if (r10 != 0) goto L_0x0089
                long r10 = r9.getItemId()
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r12 != 0) goto L_0x0089
                r9.addFlags(r3)
                r7 = r9
                goto L_0x008d
            L_0x0089:
                int r8 = r8 + 1
                goto L_0x006c
            L_0x008c:
                r7 = r4
            L_0x008d:
                if (r7 == 0) goto L_0x0092
                r2 = 1
                goto L_0x0093
            L_0x0091:
                r7 = r4
            L_0x0092:
                r2 = 0
            L_0x0093:
                r6 = -1
                if (r7 != 0) goto L_0x0256
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r0.mAttachedScrap
                int r7 = r7.size()
                r8 = 0
            L_0x009d:
                if (r8 >= r7) goto L_0x00cf
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r9 = r0.mAttachedScrap
                java.lang.Object r9 = r9.get(r8)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r9
                boolean r10 = r9.wasReturnedFromScrap()
                if (r10 != 0) goto L_0x00cc
                int r10 = r9.getLayoutPosition()
                if (r10 != r1) goto L_0x00cc
                boolean r10 = r9.isInvalid()
                if (r10 != 0) goto L_0x00cc
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r10 = r10.mState
                boolean r10 = r10.mInPreLayout
                if (r10 != 0) goto L_0x00c7
                boolean r10 = r9.isRemoved()
                if (r10 != 0) goto L_0x00cc
            L_0x00c7:
                r9.addFlags(r3)
                goto L_0x01ba
            L_0x00cc:
                int r8 = r8 + 1
                goto L_0x009d
            L_0x00cf:
                if (r20 != 0) goto L_0x0190
                androidx.recyclerview.widget.RecyclerView r7 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.ChildHelper r7 = r7.mChildHelper
                java.util.List<android.view.View> r8 = r7.mHiddenViews
                int r8 = r8.size()
                r9 = 0
            L_0x00dc:
                if (r9 >= r8) goto L_0x0107
                java.util.List<android.view.View> r10 = r7.mHiddenViews
                java.lang.Object r10 = r10.get(r9)
                android.view.View r10 = (android.view.View) r10
                androidx.recyclerview.widget.ChildHelper$Callback r11 = r7.mCallback
                androidx.recyclerview.widget.RecyclerView$5 r11 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass5) r11
                if (r11 == 0) goto L_0x0106
                androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r10)
                int r12 = r11.getLayoutPosition()
                if (r12 != r1) goto L_0x0103
                boolean r12 = r11.isInvalid()
                if (r12 != 0) goto L_0x0103
                boolean r11 = r11.isRemoved()
                if (r11 != 0) goto L_0x0103
                goto L_0x0108
            L_0x0103:
                int r9 = r9 + 1
                goto L_0x00dc
            L_0x0106:
                throw r4
            L_0x0107:
                r10 = r4
            L_0x0108:
                if (r10 == 0) goto L_0x0190
                androidx.recyclerview.widget.RecyclerView$ViewHolder r7 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r10)
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.ChildHelper r8 = r8.mChildHelper
                androidx.recyclerview.widget.ChildHelper$Callback r9 = r8.mCallback
                androidx.recyclerview.widget.RecyclerView$5 r9 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass5) r9
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                int r9 = r9.indexOfChild(r10)
                if (r9 < 0) goto L_0x0179
                androidx.recyclerview.widget.ChildHelper$Bucket r11 = r8.mBucket
                boolean r11 = r11.get(r9)
                if (r11 == 0) goto L_0x0162
                androidx.recyclerview.widget.ChildHelper$Bucket r11 = r8.mBucket
                r11.clear(r9)
                r8.unhideViewInternal(r10)
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.ChildHelper r8 = r8.mChildHelper
                int r8 = r8.indexOfChild(r10)
                if (r8 == r6) goto L_0x0149
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.ChildHelper r9 = r9.mChildHelper
                r9.detachViewFromParent(r8)
                r0.scrapView(r10)
                r8 = 8224(0x2020, float:1.1524E-41)
                r7.addFlags(r8)
                goto L_0x01c0
            L_0x0149:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "layout index should not be -1 after unhiding a view:"
                r2.append(r3)
                r2.append(r7)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline33(r3, r2)
                r1.<init>(r2)
                throw r1
            L_0x0162:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "trying to unhide a view that was not hidden"
                r2.append(r3)
                r2.append(r10)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0179:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "view is not a child, cannot hide "
                r2.append(r3)
                r2.append(r10)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0190:
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r0.mCachedViews
                int r7 = r7.size()
                r8 = 0
            L_0x0197:
                if (r8 >= r7) goto L_0x01bf
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r9 = r0.mCachedViews
                java.lang.Object r9 = r9.get(r8)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r9
                boolean r10 = r9.isInvalid()
                if (r10 != 0) goto L_0x01bc
                int r10 = r9.getLayoutPosition()
                if (r10 != r1) goto L_0x01bc
                boolean r10 = r9.isAttachedToTransitionOverlay()
                if (r10 != 0) goto L_0x01bc
                if (r20 != 0) goto L_0x01ba
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r0.mCachedViews
                r7.remove(r8)
            L_0x01ba:
                r7 = r9
                goto L_0x01c0
            L_0x01bc:
                int r8 = r8 + 1
                goto L_0x0197
            L_0x01bf:
                r7 = r4
            L_0x01c0:
                if (r7 == 0) goto L_0x0256
                boolean r8 = r7.isRemoved()
                if (r8 == 0) goto L_0x01cf
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r8 = r8.mState
                boolean r8 = r8.mInPreLayout
                goto L_0x0214
            L_0x01cf:
                int r8 = r7.mPosition
                if (r8 < 0) goto L_0x023d
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemCount()
                if (r8 >= r9) goto L_0x023d
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r9 = r8.mState
                boolean r9 = r9.mInPreLayout
                if (r9 != 0) goto L_0x01f4
                androidx.recyclerview.widget.RecyclerView$Adapter r8 = r8.mAdapter
                int r9 = r7.mPosition
                int r8 = r8.getItemViewType(r9)
                int r9 = r7.getItemViewType()
                if (r8 == r9) goto L_0x01f4
                goto L_0x0211
            L_0x01f4:
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r8 = r8.mAdapter
                boolean r8 = r8.hasStableIds()
                if (r8 == 0) goto L_0x0213
                long r8 = r7.getItemId()
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.mAdapter
                int r11 = r7.mPosition
                long r10 = r10.getItemId(r11)
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 != 0) goto L_0x0211
                goto L_0x0213
            L_0x0211:
                r8 = 0
                goto L_0x0214
            L_0x0213:
                r8 = 1
            L_0x0214:
                if (r8 != 0) goto L_0x023b
                if (r20 != 0) goto L_0x0239
                r8 = 4
                r7.addFlags(r8)
                boolean r8 = r7.isScrap()
                if (r8 == 0) goto L_0x022d
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r7.itemView
                r8.removeDetachedView(r9, r5)
                r7.unScrap()
                goto L_0x0236
            L_0x022d:
                boolean r8 = r7.wasReturnedFromScrap()
                if (r8 == 0) goto L_0x0236
                r7.clearReturnedFromScrapFlag()
            L_0x0236:
                r0.recycleViewHolderInternal(r7)
            L_0x0239:
                r7 = r4
                goto L_0x0256
            L_0x023b:
                r2 = 1
                goto L_0x0256
            L_0x023d:
                java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Inconsistency detected. Invalid view holder adapter position"
                r2.append(r3)
                r2.append(r7)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline33(r3, r2)
                r1.<init>(r2)
                throw r1
            L_0x0256:
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                if (r7 != 0) goto L_0x03e2
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r10 = r10.mAdapterHelper
                int r10 = r10.findPositionOffset(r1, r5)
                if (r10 < 0) goto L_0x03c1
                androidx.recyclerview.widget.RecyclerView r11 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r11 = r11.mAdapter
                int r11 = r11.getItemCount()
                if (r10 >= r11) goto L_0x03c1
                androidx.recyclerview.widget.RecyclerView r11 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r11 = r11.mAdapter
                int r11 = r11.getItemViewType(r10)
                androidx.recyclerview.widget.RecyclerView r12 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r12 = r12.mAdapter
                boolean r12 = r12.hasStableIds()
                if (r12 == 0) goto L_0x0329
                androidx.recyclerview.widget.RecyclerView r7 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r7 = r7.mAdapter
                long r12 = r7.getItemId(r10)
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r0.mAttachedScrap
                int r7 = r7.size()
                int r7 = r7 + r6
            L_0x0292:
                if (r7 < 0) goto L_0x02eb
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r14 = r0.mAttachedScrap
                java.lang.Object r14 = r14.get(r7)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r14 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r14
                long r15 = r14.getItemId()
                int r17 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
                if (r17 != 0) goto L_0x02e6
                boolean r15 = r14.wasReturnedFromScrap()
                if (r15 != 0) goto L_0x02e6
                int r15 = r14.getItemViewType()
                if (r11 != r15) goto L_0x02c8
                r14.addFlags(r3)
                boolean r3 = r14.isRemoved()
                if (r3 == 0) goto L_0x0318
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                boolean r3 = r3.mInPreLayout
                if (r3 != 0) goto L_0x0318
                r3 = 2
                r7 = 14
                r14.setFlags(r3, r7)
                goto L_0x0318
            L_0x02c8:
                if (r20 != 0) goto L_0x02e6
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r15 = r0.mAttachedScrap
                r15.remove(r7)
                androidx.recyclerview.widget.RecyclerView r15 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r3 = r14.itemView
                r15.removeDetachedView(r3, r5)
                android.view.View r3 = r14.itemView
                androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r3)
                r3.mScrapContainer = r4
                r3.mInChangeScrap = r5
                r3.clearReturnedFromScrapFlag()
                r0.recycleViewHolderInternal(r3)
            L_0x02e6:
                int r7 = r7 + -1
                r3 = 32
                goto L_0x0292
            L_0x02eb:
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r3 = r0.mCachedViews
                int r3 = r3.size()
                int r3 = r3 + r6
            L_0x02f2:
                if (r3 < 0) goto L_0x0323
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r0.mCachedViews
                java.lang.Object r7 = r7.get(r3)
                r14 = r7
                androidx.recyclerview.widget.RecyclerView$ViewHolder r14 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r14
                long r15 = r14.getItemId()
                int r7 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
                if (r7 != 0) goto L_0x0320
                boolean r7 = r14.isAttachedToTransitionOverlay()
                if (r7 != 0) goto L_0x0320
                int r7 = r14.getItemViewType()
                if (r11 != r7) goto L_0x031a
                if (r20 != 0) goto L_0x0318
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r0.mCachedViews
                r7.remove(r3)
            L_0x0318:
                r7 = r14
                goto L_0x0324
            L_0x031a:
                if (r20 != 0) goto L_0x0320
                r0.recycleCachedViewAt(r3)
                goto L_0x0323
            L_0x0320:
                int r3 = r3 + -1
                goto L_0x02f2
            L_0x0323:
                r7 = r4
            L_0x0324:
                if (r7 == 0) goto L_0x0329
                r7.mPosition = r10
                r2 = 1
            L_0x0329:
                if (r7 != 0) goto L_0x0369
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r3 = r18.getRecycledViewPool()
                android.util.SparseArray<androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData> r3 = r3.mScrap
                java.lang.Object r3 = r3.get(r11)
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData r3 = (androidx.recyclerview.widget.RecyclerView.RecycledViewPool.ScrapData) r3
                if (r3 == 0) goto L_0x0360
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r7 = r3.mScrapHeap
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x0360
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r3 = r3.mScrapHeap
                int r7 = r3.size()
                int r7 = r7 + r6
            L_0x0348:
                if (r7 < 0) goto L_0x0360
                java.lang.Object r6 = r3.get(r7)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r6
                boolean r6 = r6.isAttachedToTransitionOverlay()
                if (r6 != 0) goto L_0x035d
                java.lang.Object r3 = r3.remove(r7)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r3
                goto L_0x0361
            L_0x035d:
                int r7 = r7 + -1
                goto L_0x0348
            L_0x0360:
                r3 = r4
            L_0x0361:
                if (r3 == 0) goto L_0x0368
                r3.resetInternal()
                boolean r6 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
            L_0x0368:
                r7 = r3
            L_0x0369:
                if (r7 != 0) goto L_0x03e2
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                long r6 = r3.getNanoTime()
                int r3 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
                if (r3 == 0) goto L_0x038f
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r3 = r0.mRecyclerPool
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData r3 = r3.getScrapDataForType(r11)
                long r12 = r3.mCreateRunningAverageNs
                r14 = 0
                int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r3 == 0) goto L_0x038b
                long r12 = r12 + r6
                int r3 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
                if (r3 >= 0) goto L_0x0389
                goto L_0x038b
            L_0x0389:
                r3 = 0
                goto L_0x038c
            L_0x038b:
                r3 = 1
            L_0x038c:
                if (r3 != 0) goto L_0x038f
                return r4
            L_0x038f:
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r3.mAdapter
                androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r10.createViewHolder(r3, r11)
                boolean r10 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r10 == 0) goto L_0x03aa
                android.view.View r10 = r3.itemView
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r10)
                if (r10 == 0) goto L_0x03aa
                java.lang.ref.WeakReference r12 = new java.lang.ref.WeakReference
                r12.<init>(r10)
                r3.mNestedRecyclerView = r12
            L_0x03aa:
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                long r12 = r10.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r10 = r0.mRecyclerPool
                long r12 = r12 - r6
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData r6 = r10.getScrapDataForType(r11)
                long r14 = r6.mCreateRunningAverageNs
                long r10 = r10.runningAverage(r14, r12)
                r6.mCreateRunningAverageNs = r10
                r7 = r3
                goto L_0x03e2
            L_0x03c1:
                java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException
                java.lang.String r3 = "Inconsistency detected. Invalid item position "
                java.lang.String r4 = "(offset:"
                java.lang.String r5 = ").state:"
                java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline75(r3, r1, r4, r10, r5)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                int r3 = r3.getItemCount()
                r1.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline33(r3, r1)
                r2.<init>(r1)
                throw r2
            L_0x03e2:
                if (r2 == 0) goto L_0x0414
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                boolean r3 = r3.mInPreLayout
                if (r3 != 0) goto L_0x0414
                r3 = 8192(0x2000, float:1.148E-41)
                boolean r6 = r7.hasAnyOfTheFlags(r3)
                if (r6 == 0) goto L_0x0414
                r7.setFlags(r5, r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                boolean r3 = r3.mRunSimpleAnimations
                if (r3 == 0) goto L_0x0414
                androidx.recyclerview.widget.RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(r7)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ItemAnimator r6 = r3.mItemAnimator
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                r7.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r3 = r6.recordPreLayoutInformation(r7)
                androidx.recyclerview.widget.RecyclerView r6 = androidx.recyclerview.widget.RecyclerView.this
                r6.recordAnimationInfoIfBouncedHiddenView(r7, r3)
            L_0x0414:
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                boolean r3 = r3.mInPreLayout
                if (r3 == 0) goto L_0x0425
                boolean r3 = r7.isBound()
                if (r3 == 0) goto L_0x0425
                r7.mPreLayoutPosition = r1
                goto L_0x046c
            L_0x0425:
                boolean r3 = r7.isBound()
                if (r3 == 0) goto L_0x0437
                boolean r3 = r7.needsUpdate()
                if (r3 != 0) goto L_0x0437
                boolean r3 = r7.isInvalid()
                if (r3 == 0) goto L_0x046c
            L_0x0437:
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r3 = r3.mAdapterHelper
                int r3 = r3.findPositionOffset(r1, r5)
                r7.mBindingAdapter = r4
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                r7.mOwnerRecyclerView = r5
                int r5 = r7.getItemViewType()
                androidx.recyclerview.widget.RecyclerView r6 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r6.getNanoTime()
                int r6 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
                if (r6 == 0) goto L_0x0470
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r6 = r0.mRecyclerPool
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData r5 = r6.getScrapDataForType(r5)
                long r5 = r5.mBindRunningAverageNs
                r8 = 0
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L_0x0469
                long r5 = r5 + r10
                int r8 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
                if (r8 >= 0) goto L_0x0467
                goto L_0x0469
            L_0x0467:
                r5 = 0
                goto L_0x046a
            L_0x0469:
                r5 = 1
            L_0x046a:
                if (r5 != 0) goto L_0x0470
            L_0x046c:
                r1 = 0
                r3 = 1
                goto L_0x04de
            L_0x0470:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r5 = r5.mAdapter
                r5.bindViewHolder(r7, r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                long r5 = r3.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r3 = r0.mRecyclerPool
                int r8 = r7.getItemViewType()
                long r5 = r5 - r10
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData r8 = r3.getScrapDataForType(r8)
                long r9 = r8.mBindRunningAverageNs
                long r5 = r3.runningAverage(r9, r5)
                r8.mBindRunningAverageNs = r5
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                android.view.accessibility.AccessibilityManager r3 = r3.mAccessibilityManager
                if (r3 == 0) goto L_0x049e
                boolean r3 = r3.isEnabled()
                if (r3 == 0) goto L_0x049e
                r3 = 1
                goto L_0x049f
            L_0x049e:
                r3 = 0
            L_0x049f:
                if (r3 == 0) goto L_0x04d2
                android.view.View r3 = r7.itemView
                int r5 = androidx.core.view.ViewCompat.getImportantForAccessibility(r3)
                if (r5 != 0) goto L_0x04ae
                r5 = 1
                r3.setImportantForAccessibility(r5)
                goto L_0x04af
            L_0x04ae:
                r5 = 1
            L_0x04af:
                androidx.recyclerview.widget.RecyclerView r6 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate r6 = r6.mAccessibilityDelegate
                if (r6 != 0) goto L_0x04b6
                goto L_0x04d0
            L_0x04b6:
                androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate$ItemDelegate r6 = r6.mItemDelegate
                boolean r8 = r6 instanceof androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate.ItemDelegate
                if (r8 == 0) goto L_0x04cd
                if (r6 == 0) goto L_0x04cc
                androidx.core.view.AccessibilityDelegateCompat r4 = androidx.core.view.ViewCompat.getAccessibilityDelegate(r3)
                if (r4 == 0) goto L_0x04cd
                if (r4 == r6) goto L_0x04cd
                java.util.Map<android.view.View, androidx.core.view.AccessibilityDelegateCompat> r8 = r6.mOriginalItemDelegates
                r8.put(r3, r4)
                goto L_0x04cd
            L_0x04cc:
                throw r4
            L_0x04cd:
                androidx.core.view.ViewCompat.setAccessibilityDelegate(r3, r6)
            L_0x04d0:
                r3 = r5
                goto L_0x04d3
            L_0x04d2:
                r3 = 1
            L_0x04d3:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r4 = r4.mState
                boolean r4 = r4.mInPreLayout
                if (r4 == 0) goto L_0x04dd
                r7.mPreLayoutPosition = r1
            L_0x04dd:
                r1 = 1
            L_0x04de:
                android.view.View r4 = r7.itemView
                android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                if (r4 != 0) goto L_0x04f4
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r4 = r4.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r4 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r4
                android.view.View r5 = r7.itemView
                r5.setLayoutParams(r4)
                goto L_0x050c
            L_0x04f4:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                boolean r5 = r5.checkLayoutParams(r4)
                if (r5 != 0) goto L_0x050a
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r4 = r5.generateLayoutParams(r4)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r4 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r4
                android.view.View r5 = r7.itemView
                r5.setLayoutParams(r4)
                goto L_0x050c
            L_0x050a:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r4 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r4
            L_0x050c:
                r4.mViewHolder = r7
                if (r2 == 0) goto L_0x0513
                if (r1 == 0) goto L_0x0513
                goto L_0x0514
            L_0x0513:
                r3 = 0
            L_0x0514:
                r4.mPendingInvalidate = r3
                return r7
            L_0x0517:
                java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException
                java.lang.String r3 = "Invalid item position "
                java.lang.String r4 = "("
                java.lang.String r5 = "). Item count:"
                java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline75(r3, r1, r4, r1, r5)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                int r3 = r3.getItemCount()
                r1.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline33(r3, r1)
                r2.<init>(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.tryGetViewHolderForPositionByDeadline(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        public void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        public void updateViewCacheSize() {
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            this.mViewCacheMax = this.mRequestedCacheMax + (layoutManager != null ? layoutManager.mPrefetchMaxCountObserved : 0);
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    public class RecyclerViewDataObserver extends AdapterDataObserver {
        public RecyclerViewDataObserver() {
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.mStructureChanged = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = RecyclerView.this.mAdapterHelper;
            if (adapterHelper != null) {
                boolean z = false;
                if (i2 >= 1) {
                    adapterHelper.mPendingUpdates.add(adapterHelper.obtainUpdateOp(4, i, i2, obj));
                    adapterHelper.mExistingUpdateTypes |= 4;
                    if (adapterHelper.mPendingUpdates.size() == 1) {
                        z = true;
                    }
                }
                if (z) {
                    triggerUpdateProcessor();
                    return;
                }
                return;
            }
            throw null;
        }

        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = RecyclerView.this.mAdapterHelper;
            if (adapterHelper != null) {
                boolean z = false;
                if (i2 >= 1) {
                    adapterHelper.mPendingUpdates.add(adapterHelper.obtainUpdateOp(1, i, i2, null));
                    adapterHelper.mExistingUpdateTypes |= 1;
                    if (adapterHelper.mPendingUpdates.size() == 1) {
                        z = true;
                    }
                }
                if (z) {
                    triggerUpdateProcessor();
                    return;
                }
                return;
            }
            throw null;
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = RecyclerView.this.mAdapterHelper;
            if (adapterHelper != null) {
                boolean z = false;
                if (i != i2) {
                    if (i3 == 1) {
                        adapterHelper.mPendingUpdates.add(adapterHelper.obtainUpdateOp(8, i, i2, null));
                        adapterHelper.mExistingUpdateTypes |= 8;
                        if (adapterHelper.mPendingUpdates.size() == 1) {
                            z = true;
                        }
                    } else {
                        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
                    }
                }
                if (z) {
                    triggerUpdateProcessor();
                    return;
                }
                return;
            }
            throw null;
        }

        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = RecyclerView.this.mAdapterHelper;
            if (adapterHelper != null) {
                boolean z = false;
                if (i2 >= 1) {
                    adapterHelper.mPendingUpdates.add(adapterHelper.obtainUpdateOp(2, i, i2, null));
                    adapterHelper.mExistingUpdateTypes |= 2;
                    if (adapterHelper.mPendingUpdates.size() == 1) {
                        z = true;
                    }
                }
                if (z) {
                    triggerUpdateProcessor();
                    return;
                }
                return;
            }
            throw null;
        }

        public void onStateRestorationPolicyChanged() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null) {
                Adapter adapter = recyclerView.mAdapter;
                if (adapter != null && adapter.canRestoreState()) {
                    RecyclerView.this.requestLayout();
                }
            }
        }

        public void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public Parcelable mLayoutState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static abstract class SmoothScroller {
        public LayoutManager mLayoutManager;
        public boolean mPendingInitialRun;
        public RecyclerView mRecyclerView;
        public final Action mRecyclingAction = new Action(0, 0);
        public boolean mRunning;
        public boolean mStarted;
        public int mTargetPosition = -1;
        public View mTargetView;

        public static class Action {
            public boolean mChanged = false;
            public int mConsecutiveUpdates = 0;
            public int mDuration;
            public int mDx;
            public int mDy;
            public Interpolator mInterpolator;
            public int mJumpToPosition = -1;

            public Action(int i, int i2) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = LinearLayoutManager.INVALID_OFFSET;
                this.mInterpolator = null;
            }

            public void runIfNecessary(RecyclerView recyclerView) {
                int i = this.mJumpToPosition;
                if (i >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.mChanged = false;
                    return;
                }
                if (!this.mChanged) {
                    this.mConsecutiveUpdates = 0;
                } else if (this.mInterpolator == null || this.mDuration >= 1) {
                    int i2 = this.mDuration;
                    if (i2 >= 1) {
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, i2, this.mInterpolator);
                        this.mConsecutiveUpdates++;
                        this.mChanged = false;
                    } else {
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                } else {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }
        }

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            if (this.mRecyclerView != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    return childViewHolderInt.getLayoutPosition();
                }
                return -1;
            }
            throw null;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onAnimation(int i, int i2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null) {
                PointF computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition);
                if (!(computeScrollVectorForPosition == null || (computeScrollVectorForPosition.x == 0.0f && computeScrollVectorForPosition.y == 0.0f))) {
                    recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
            }
            boolean z = false;
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                if (this.mRecyclingAction.mJumpToPosition >= 0) {
                    z = true;
                }
                this.mRecyclingAction.runIfNecessary(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        public abstract void onSeekTargetStep(int i, int i2, State state, Action action);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, State state, Action action);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.stop();
            if (this.mStarted) {
                getClass().getSimpleName();
                getClass().getSimpleName();
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i = this.mTargetPosition;
            if (i != -1) {
                recyclerView.mState.mTargetPosition = i;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.postOnAnimation();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.mTargetPosition = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    public static class State {
        public int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        public long mFocusedItemId;
        public int mFocusedItemPosition;
        public int mFocusedSubChildId;
        public boolean mInPreLayout = false;
        public boolean mIsMeasuring = false;
        public int mItemCount = 0;
        public int mLayoutStep = 1;
        public int mPreviousLayoutItemCount = 0;
        public int mRemainingScrollHorizontal;
        public boolean mRunPredictiveAnimations = false;
        public boolean mRunSimpleAnimations = false;
        public boolean mStructureChanged = false;
        public int mTargetPosition = -1;
        public boolean mTrackOldChangeHolders = false;

        public void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) == 0) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Layout state should be one of ");
                outline73.append(Integer.toBinaryString(i));
                outline73.append(" but it is ");
                outline73.append(Integer.toBinaryString(this.mLayoutStep));
                throw new IllegalStateException(outline73.toString());
            }
        }

        public int getItemCount() {
            if (this.mInPreLayout) {
                return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
            }
            return this.mItemCount;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("State{mTargetPosition=");
            outline73.append(this.mTargetPosition);
            outline73.append(", mData=");
            outline73.append(null);
            outline73.append(", mItemCount=");
            outline73.append(this.mItemCount);
            outline73.append(", mIsMeasuring=");
            outline73.append(this.mIsMeasuring);
            outline73.append(", mPreviousLayoutItemCount=");
            outline73.append(this.mPreviousLayoutItemCount);
            outline73.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            outline73.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
            outline73.append(", mStructureChanged=");
            outline73.append(this.mStructureChanged);
            outline73.append(", mInPreLayout=");
            outline73.append(this.mInPreLayout);
            outline73.append(", mRunSimpleAnimations=");
            outline73.append(this.mRunSimpleAnimations);
            outline73.append(", mRunPredictiveAnimations=");
            return GeneratedOutlineSupport.outline65(outline73, this.mRunPredictiveAnimations, '}');
        }
    }

    public static abstract class ViewCacheExtension {
    }

    public class ViewFlinger implements Runnable {
        public boolean mEatRunOnAnimationRequest = false;
        public Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
        public int mLastFlingX;
        public int mLastFlingY;
        public OverScroller mOverScroller;
        public boolean mReSchedulePostAnimationCallback = false;

        public ViewFlinger() {
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.mLastFlingX;
                int i4 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i = iArr4[0];
                    i2 = iArr4[1];
                    i3 -= i;
                    i4 -= i2;
                    SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i, i2);
                        } else {
                            smoothScroller.onAnimation(i, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i, i2, i3, i4, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.mReusableIntPair;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (!(i == 0 && i2 == 0)) {
                    RecyclerView.this.dispatchOnScrolled(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) || !z) {
                    postOnAnimation();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView6.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView6, i, i2);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView recyclerView7 = RecyclerView.this;
                        if (recyclerView7 != null) {
                            if (i7 < 0) {
                                recyclerView7.ensureLeftGlow();
                                if (recyclerView7.mLeftGlow.isFinished()) {
                                    recyclerView7.mLeftGlow.onAbsorb(-i7);
                                }
                            } else if (i7 > 0) {
                                recyclerView7.ensureRightGlow();
                                if (recyclerView7.mRightGlow.isFinished()) {
                                    recyclerView7.mRightGlow.onAbsorb(i7);
                                }
                            }
                            if (currVelocity < 0) {
                                recyclerView7.ensureTopGlow();
                                if (recyclerView7.mTopGlow.isFinished()) {
                                    recyclerView7.mTopGlow.onAbsorb(-currVelocity);
                                }
                            } else if (currVelocity > 0) {
                                recyclerView7.ensureBottomGlow();
                                if (recyclerView7.mBottomGlow.isFinished()) {
                                    recyclerView7.mBottomGlow.onAbsorb(currVelocity);
                                }
                            }
                            if (!(i7 == 0 && currVelocity == 0)) {
                                ViewCompat.postInvalidateOnAnimation(recyclerView7);
                            }
                        } else {
                            throw null;
                        }
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                        int[] iArr7 = layoutPrefetchRegistryImpl.mPrefetchArray;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        layoutPrefetchRegistryImpl.mCount = 0;
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.postOnAnimation(RecyclerView.this, this);
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                boolean z = abs > abs2;
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z) {
                    abs = abs2;
                }
                i3 = Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), 2000);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i, i2, i4);
            if (VERSION.SDK_INT < 23) {
                this.mOverScroller.computeScrollOffset();
            }
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    public static abstract class ViewHolder {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        public static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        public Adapter<? extends ViewHolder> mBindingAdapter;
        public int mFlags;
        public boolean mInChangeScrap = false;
        public int mIsRecyclableCount = 0;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public int mOldPosition = -1;
        public RecyclerView mOwnerRecyclerView;
        public List<Object> mPayloads = null;
        public int mPendingAccessibilityState = -1;
        public int mPosition = -1;
        public int mPreLayoutPosition = -1;
        public Recycler mScrapContainer = null;
        public ViewHolder mShadowedHolder = null;
        public ViewHolder mShadowingHolder = null;
        public List<Object> mUnmodifiedPayloads = null;
        public int mWasImportantForAccessibilityBeforeHidden = 0;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            if (this.mBindingAdapter == null) {
                return -1;
            }
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                return -1;
            }
            int adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
            if (adapterPositionInRecyclerView == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this;
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            outline78.append(Integer.toHexString(hashCode()));
            outline78.append(" position=");
            outline78.append(this.mPosition);
            outline78.append(" id=");
            outline78.append(this.mItemId);
            outline78.append(", oldPos=");
            outline78.append(this.mOldPosition);
            outline78.append(", pLpos:");
            outline78.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(outline78.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73(" not recyclable(");
                outline73.append(this.mIsRecyclableCount);
                outline73.append(")");
                sb.append(outline73.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    static {
        Class cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    public static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view != viewHolder.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    public final void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.addView(view, -1, true);
        } else {
            ChildHelper childHelper = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                childHelper.mBucket.set(indexOfChild);
                childHelper.hideViewInternal(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        this.mItemDecorations.add(itemDecoration);
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(GeneratedOutlineSupport.outline33(this, GeneratedOutlineSupport.outline73("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            new IllegalStateException(GeneratedOutlineSupport.outline33(this, GeneratedOutlineSupport.outline73("")));
        }
    }

    public final void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        Recycler recycler = this.mRecycler;
        int size = recycler.mCachedViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            recycler.mCachedViews.get(i2).clearOldPosition();
        }
        int size2 = recycler.mAttachedScrap.size();
        for (int i3 = 0; i3 < size2; i3++) {
            recycler.mAttachedScrap.get(i3).clearOldPosition();
        }
        ArrayList<ViewHolder> arrayList = recycler.mChangedScrap;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i4 = 0; i4 < size3; i4++) {
                recycler.mChangedScrap.get(i4).clearOldPosition();
            }
        }
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        int i = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager.canScrollHorizontally()) {
            i = this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return i;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        int i = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager.canScrollHorizontally()) {
            i = this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return i;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        int i = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager.canScrollHorizontally()) {
            i = this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        int i = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager.canScrollVertically()) {
            i = this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        int i = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager.canScrollVertically()) {
            i = this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        int i = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager.canScrollVertically()) {
            i = this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return i;
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection("RV FullInvalidate");
            dispatchLayout();
            Trace.endSection();
        } else if (this.mAdapterHelper.hasPendingUpdates()) {
            boolean z = false;
            if ((this.mAdapterHelper.mExistingUpdateTypes & 4) != 0) {
                if (!((this.mAdapterHelper.mExistingUpdateTypes & 11) != 0)) {
                    TraceCompat.beginSection("RV PartialInvalidate");
                    startInterceptRequestLayout();
                    onEnterLayoutOrScroll();
                    this.mAdapterHelper.preProcess();
                    if (!this.mLayoutWasDefered) {
                        int childCount = this.mChildHelper.getChildCount();
                        int i = 0;
                        while (true) {
                            if (i >= childCount) {
                                break;
                            }
                            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                        if (z) {
                            dispatchLayout();
                        } else {
                            this.mAdapterHelper.consumePostponedUpdates();
                        }
                    }
                    stopInterceptRequestLayout(true);
                    onExitLayoutOrScroll(true);
                    Trace.endSection();
                }
            }
            if (this.mAdapterHelper.hasPendingUpdates()) {
                TraceCompat.beginSection("RV FullInvalidate");
                dispatchLayout();
                Trace.endSection();
            }
        }
    }

    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingRight() + getPaddingLeft(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow();
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:157:0x036d, code lost:
        if (r0.mChildHelper.isHidden(r1) == false) goto L_0x0443;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0407, code lost:
        r5 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchLayout() {
        /*
            r18 = this;
            r0 = r18
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r0.mAdapter
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            if (r1 != 0) goto L_0x000c
            return
        L_0x000c:
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            r2 = 0
            r1.mIsMeasuring = r2
            boolean r1 = r0.mLastAutoMeasureSkippedDueToExact
            r3 = 1
            if (r1 == 0) goto L_0x0028
            int r1 = r0.mLastAutoMeasureNonExactMeasuredWidth
            int r4 = r18.getWidth()
            if (r1 != r4) goto L_0x0026
            int r1 = r0.mLastAutoMeasureNonExactMeasuredHeight
            int r4 = r18.getHeight()
            if (r1 == r4) goto L_0x0028
        L_0x0026:
            r1 = 1
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            r0.mLastAutoMeasureNonExactMeasuredWidth = r2
            r0.mLastAutoMeasureNonExactMeasuredHeight = r2
            r0.mLastAutoMeasureSkippedDueToExact = r2
            androidx.recyclerview.widget.RecyclerView$State r4 = r0.mState
            int r4 = r4.mLayoutStep
            if (r4 != r3) goto L_0x0041
            r18.dispatchLayoutStep1()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            r1.setExactMeasureSpecsFrom(r0)
            r18.dispatchLayoutStep2()
            goto L_0x0081
        L_0x0041:
            androidx.recyclerview.widget.AdapterHelper r4 = r0.mAdapterHelper
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r5 = r4.mPostponedList
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0055
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r4 = r4.mPendingUpdates
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0055
            r4 = 1
            goto L_0x0056
        L_0x0055:
            r4 = 0
        L_0x0056:
            if (r4 != 0) goto L_0x0079
            if (r1 != 0) goto L_0x0079
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            int r1 = r1.getWidth()
            int r4 = r18.getWidth()
            if (r1 != r4) goto L_0x0079
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            int r1 = r1.getHeight()
            int r4 = r18.getHeight()
            if (r1 == r4) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            r1.setExactMeasureSpecsFrom(r0)
            goto L_0x0081
        L_0x0079:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            r1.setExactMeasureSpecsFrom(r0)
            r18.dispatchLayoutStep2()
        L_0x0081:
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            r4 = 4
            r1.assertLayoutStep(r4)
            r18.startInterceptRequestLayout()
            r18.onEnterLayoutOrScroll()
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            r1.mLayoutStep = r3
            boolean r1 = r1.mRunSimpleAnimations
            r5 = 0
            r6 = -1
            if (r1 == 0) goto L_0x02b4
            androidx.recyclerview.widget.ChildHelper r1 = r0.mChildHelper
            int r1 = r1.getChildCount()
            int r1 = r1 - r3
        L_0x009e:
            if (r1 < 0) goto L_0x01cc
            androidx.recyclerview.widget.ChildHelper r7 = r0.mChildHelper
            android.view.View r7 = r7.getChildAt(r1)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r7 = getChildViewHolderInt(r7)
            boolean r8 = r7.shouldIgnore()
            if (r8 == 0) goto L_0x00b2
            goto L_0x01c7
        L_0x00b2:
            long r8 = r0.getChangedHolderKey(r7)
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r10 = r0.mItemAnimator
            if (r10 == 0) goto L_0x01cb
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r10 = new androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
            r10.<init>()
            android.view.View r11 = r7.itemView
            int r12 = r11.getLeft()
            r10.left = r12
            int r12 = r11.getTop()
            r10.top = r12
            r11.getRight()
            r11.getBottom()
            androidx.recyclerview.widget.ViewInfoStore r11 = r0.mViewInfoStore
            androidx.collection.LongSparseArray<androidx.recyclerview.widget.RecyclerView$ViewHolder> r11 = r11.mOldChangedHolders
            java.lang.Object r11 = r11.get(r8, r5)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r11
            if (r11 == 0) goto L_0x01c2
            boolean r12 = r11.shouldIgnore()
            if (r12 != 0) goto L_0x01c2
            androidx.recyclerview.widget.ViewInfoStore r12 = r0.mViewInfoStore
            boolean r12 = r12.isDisappearing(r11)
            androidx.recyclerview.widget.ViewInfoStore r13 = r0.mViewInfoStore
            boolean r13 = r13.isDisappearing(r7)
            if (r12 == 0) goto L_0x00fc
            if (r11 != r7) goto L_0x00fc
            androidx.recyclerview.widget.ViewInfoStore r8 = r0.mViewInfoStore
            r8.addToPostLayout(r7, r10)
            goto L_0x01c7
        L_0x00fc:
            androidx.recyclerview.widget.ViewInfoStore r14 = r0.mViewInfoStore
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r14 = r14.popFromLayoutStep(r11, r4)
            androidx.recyclerview.widget.ViewInfoStore r15 = r0.mViewInfoStore
            r15.addToPostLayout(r7, r10)
            androidx.recyclerview.widget.ViewInfoStore r10 = r0.mViewInfoStore
            r15 = 8
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r10 = r10.popFromLayoutStep(r7, r15)
            if (r14 != 0) goto L_0x0198
            androidx.recyclerview.widget.ChildHelper r10 = r0.mChildHelper
            int r10 = r10.getChildCount()
            r12 = 0
        L_0x0118:
            if (r12 >= r10) goto L_0x0178
            androidx.recyclerview.widget.ChildHelper r13 = r0.mChildHelper
            android.view.View r13 = r13.getChildAt(r12)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r13 = getChildViewHolderInt(r13)
            if (r13 != r7) goto L_0x0127
            goto L_0x0175
        L_0x0127:
            long r14 = r0.getChangedHolderKey(r13)
            int r16 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r16 != 0) goto L_0x0175
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r0.mAdapter
            java.lang.String r2 = " \n View Holder 2:"
            if (r1 == 0) goto L_0x0158
            boolean r1 = r1.hasStableIds()
            if (r1 == 0) goto L_0x0158
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:"
            r3.append(r4)
            r3.append(r13)
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline33(r0, r3)
            r1.<init>(r2)
            throw r1
        L_0x0158:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:"
            r3.append(r4)
            r3.append(r13)
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline33(r0, r3)
            r1.<init>(r2)
            throw r1
        L_0x0175:
            int r12 = r12 + 1
            goto L_0x0118
        L_0x0178:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Problem while matching changed view holders with the newones. The pre-layout information for the change holder "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r9 = " cannot be found but it is necessary for "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r18.exceptionLabel()
            r8.append(r7)
            r8.toString()
            goto L_0x01c7
        L_0x0198:
            r11.setIsRecyclable(r2)
            if (r12 == 0) goto L_0x01a0
            r0.addAnimatingView(r11)
        L_0x01a0:
            if (r11 == r7) goto L_0x01b6
            if (r13 == 0) goto L_0x01a7
            r0.addAnimatingView(r7)
        L_0x01a7:
            r11.mShadowedHolder = r7
            r0.addAnimatingView(r11)
            androidx.recyclerview.widget.RecyclerView$Recycler r8 = r0.mRecycler
            r8.unscrapView(r11)
            r7.setIsRecyclable(r2)
            r7.mShadowingHolder = r11
        L_0x01b6:
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r8 = r0.mItemAnimator
            boolean r7 = r8.animateChange(r11, r7, r14, r10)
            if (r7 == 0) goto L_0x01c7
            r18.postAnimationRunner()
            goto L_0x01c7
        L_0x01c2:
            androidx.recyclerview.widget.ViewInfoStore r8 = r0.mViewInfoStore
            r8.addToPostLayout(r7, r10)
        L_0x01c7:
            int r1 = r1 + -1
            goto L_0x009e
        L_0x01cb:
            throw r5
        L_0x01cc:
            androidx.recyclerview.widget.ViewInfoStore r1 = r0.mViewInfoStore
            androidx.recyclerview.widget.ViewInfoStore$ProcessCallback r4 = r0.mViewInfoProcessCallback
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r7 = r1.mLayoutHolderMap
            int r7 = r7.mSize
            int r7 = r7 + r6
        L_0x01d5:
            if (r7 < 0) goto L_0x02b4
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r8 = r1.mLayoutHolderMap
            java.lang.Object r8 = r8.keyAt(r7)
            r10 = r8
            androidx.recyclerview.widget.RecyclerView$ViewHolder r10 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r10
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r8 = r1.mLayoutHolderMap
            java.lang.Object r8 = r8.removeAt(r7)
            androidx.recyclerview.widget.ViewInfoStore$InfoRecord r8 = (androidx.recyclerview.widget.ViewInfoStore.InfoRecord) r8
            int r9 = r8.flags
            r11 = r9 & 3
            r12 = 3
            if (r11 != r12) goto L_0x01ff
            r9 = r4
            androidx.recyclerview.widget.RecyclerView$4 r9 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass4) r9
            androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
            androidx.recyclerview.widget.RecyclerView$LayoutManager r11 = r9.mLayout
            android.view.View r10 = r10.itemView
            androidx.recyclerview.widget.RecyclerView$Recycler r9 = r9.mRecycler
            r11.removeAndRecycleView(r10, r9)
            goto L_0x02ad
        L_0x01ff:
            r11 = r9 & 1
            if (r11 == 0) goto L_0x0221
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r9 = r8.preInfo
            if (r9 != 0) goto L_0x0217
            r9 = r4
            androidx.recyclerview.widget.RecyclerView$4 r9 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass4) r9
            androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
            androidx.recyclerview.widget.RecyclerView$LayoutManager r11 = r9.mLayout
            android.view.View r10 = r10.itemView
            androidx.recyclerview.widget.RecyclerView$Recycler r9 = r9.mRecycler
            r11.removeAndRecycleView(r10, r9)
            goto L_0x02ad
        L_0x0217:
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r11 = r8.postInfo
            r12 = r4
            androidx.recyclerview.widget.RecyclerView$4 r12 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass4) r12
            r12.processDisappeared(r10, r9, r11)
            goto L_0x02ad
        L_0x0221:
            r11 = r9 & 14
            r12 = 14
            if (r11 != r12) goto L_0x0233
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r9 = r8.preInfo
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r11 = r8.postInfo
            r12 = r4
            androidx.recyclerview.widget.RecyclerView$4 r12 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass4) r12
            r12.processAppeared(r10, r9, r11)
            goto L_0x02ad
        L_0x0233:
            r11 = r9 & 12
            r12 = 12
            if (r11 != r12) goto L_0x0292
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r9 = r8.preInfo
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r11 = r8.postInfo
            r15 = r4
            androidx.recyclerview.widget.RecyclerView$4 r15 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass4) r15
            if (r15 == 0) goto L_0x0291
            r10.setIsRecyclable(r2)
            androidx.recyclerview.widget.RecyclerView r12 = androidx.recyclerview.widget.RecyclerView.this
            boolean r13 = r12.mDataSetHasChangedAfterLayout
            if (r13 == 0) goto L_0x0259
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r12 = r12.mItemAnimator
            boolean r9 = r12.animateChange(r10, r10, r9, r11)
            if (r9 == 0) goto L_0x02ad
            androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
            r9.postAnimationRunner()
            goto L_0x02ad
        L_0x0259:
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r12 = r12.mItemAnimator
            androidx.recyclerview.widget.SimpleItemAnimator r12 = (androidx.recyclerview.widget.SimpleItemAnimator) r12
            if (r12 == 0) goto L_0x0290
            int r13 = r9.left
            int r14 = r11.left
            if (r13 != r14) goto L_0x0271
            int r13 = r9.top
            int r14 = r11.top
            if (r13 == r14) goto L_0x026c
            goto L_0x0271
        L_0x026c:
            r12.dispatchAnimationFinished(r10)
            r9 = 0
            goto L_0x0288
        L_0x0271:
            int r13 = r9.left
            int r14 = r9.top
            int r9 = r11.left
            int r11 = r11.top
            r16 = r9
            r9 = r12
            r17 = r11
            r11 = r13
            r12 = r14
            r13 = r16
            r14 = r17
            boolean r9 = r9.animateMove(r10, r11, r12, r13, r14)
        L_0x0288:
            if (r9 == 0) goto L_0x02ad
            androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
            r9.postAnimationRunner()
            goto L_0x02ad
        L_0x0290:
            throw r5
        L_0x0291:
            throw r5
        L_0x0292:
            r11 = r9 & 4
            if (r11 == 0) goto L_0x029f
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r9 = r8.preInfo
            r11 = r4
            androidx.recyclerview.widget.RecyclerView$4 r11 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass4) r11
            r11.processDisappeared(r10, r9, r5)
            goto L_0x02ad
        L_0x029f:
            r9 = r9 & 8
            if (r9 == 0) goto L_0x02ad
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r9 = r8.preInfo
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r11 = r8.postInfo
            r12 = r4
            androidx.recyclerview.widget.RecyclerView$4 r12 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass4) r12
            r12.processAppeared(r10, r9, r11)
        L_0x02ad:
            androidx.recyclerview.widget.ViewInfoStore.InfoRecord.recycle(r8)
            int r7 = r7 + -1
            goto L_0x01d5
        L_0x02b4:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            androidx.recyclerview.widget.RecyclerView$Recycler r4 = r0.mRecycler
            r1.removeAndRecycleScrapInt(r4)
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            int r4 = r1.mItemCount
            r1.mPreviousLayoutItemCount = r4
            r0.mDataSetHasChangedAfterLayout = r2
            r0.mDispatchItemsChangedEvent = r2
            r1.mRunSimpleAnimations = r2
            r1.mRunPredictiveAnimations = r2
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            r1.mRequestedSimpleAnimations = r2
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r0.mRecycler
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r1 = r1.mChangedScrap
            if (r1 == 0) goto L_0x02d6
            r1.clear()
        L_0x02d6:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            boolean r4 = r1.mPrefetchMaxObservedInInitialPrefetch
            if (r4 == 0) goto L_0x02e5
            r1.mPrefetchMaxCountObserved = r2
            r1.mPrefetchMaxObservedInInitialPrefetch = r2
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r0.mRecycler
            r1.updateViewCacheSize()
        L_0x02e5:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            androidx.recyclerview.widget.RecyclerView$State r4 = r0.mState
            r1.onLayoutCompleted(r4)
            r0.onExitLayoutOrScroll(r3)
            r0.stopInterceptRequestLayout(r2)
            androidx.recyclerview.widget.ViewInfoStore r1 = r0.mViewInfoStore
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r4 = r1.mLayoutHolderMap
            r4.clear()
            androidx.collection.LongSparseArray<androidx.recyclerview.widget.RecyclerView$ViewHolder> r1 = r1.mOldChangedHolders
            r1.clear()
            int[] r1 = r0.mMinMaxLayoutPositions
            r4 = r1[r2]
            r7 = r1[r3]
            r0.findMinMaxChildLayoutPositions(r1)
            int[] r1 = r0.mMinMaxLayoutPositions
            r8 = r1[r2]
            if (r8 != r4) goto L_0x0313
            r1 = r1[r3]
            if (r1 == r7) goto L_0x0312
            goto L_0x0313
        L_0x0312:
            r3 = 0
        L_0x0313:
            if (r3 == 0) goto L_0x0318
            r0.dispatchOnScrolled(r2, r2)
        L_0x0318:
            boolean r1 = r0.mPreserveFocusAfterLayout
            r3 = -1
            if (r1 == 0) goto L_0x0443
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r0.mAdapter
            if (r1 == 0) goto L_0x0443
            boolean r1 = r18.hasFocus()
            if (r1 == 0) goto L_0x0443
            int r1 = r18.getDescendantFocusability()
            r7 = 393216(0x60000, float:5.51013E-40)
            if (r1 == r7) goto L_0x0443
            int r1 = r18.getDescendantFocusability()
            r7 = 131072(0x20000, float:1.83671E-40)
            if (r1 != r7) goto L_0x0340
            boolean r1 = r18.isFocused()
            if (r1 == 0) goto L_0x0340
            goto L_0x0443
        L_0x0340:
            boolean r1 = r18.isFocused()
            if (r1 != 0) goto L_0x0371
            android.view.View r1 = r18.getFocusedChild()
            boolean r7 = IGNORE_DETACHED_FOCUSED_CHILD
            if (r7 == 0) goto L_0x0367
            android.view.ViewParent r7 = r1.getParent()
            if (r7 == 0) goto L_0x035a
            boolean r7 = r1.hasFocus()
            if (r7 != 0) goto L_0x0367
        L_0x035a:
            androidx.recyclerview.widget.ChildHelper r1 = r0.mChildHelper
            int r1 = r1.getChildCount()
            if (r1 != 0) goto L_0x0371
            r18.requestFocus()
            goto L_0x0443
        L_0x0367:
            androidx.recyclerview.widget.ChildHelper r7 = r0.mChildHelper
            boolean r1 = r7.isHidden(r1)
            if (r1 != 0) goto L_0x0371
            goto L_0x0443
        L_0x0371:
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            long r7 = r1.mFocusedItemId
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x03c5
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r0.mAdapter
            boolean r1 = r1.hasStableIds()
            if (r1 == 0) goto L_0x03c5
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            long r7 = r1.mFocusedItemId
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r0.mAdapter
            if (r1 == 0) goto L_0x03c2
            boolean r1 = r1.hasStableIds()
            if (r1 != 0) goto L_0x0390
            goto L_0x03c2
        L_0x0390:
            androidx.recyclerview.widget.ChildHelper r1 = r0.mChildHelper
            int r1 = r1.getUnfilteredChildCount()
            r9 = 0
            r10 = r5
        L_0x0398:
            if (r9 >= r1) goto L_0x03c3
            androidx.recyclerview.widget.ChildHelper r11 = r0.mChildHelper
            android.view.View r11 = r11.getUnfilteredChildAt(r9)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = getChildViewHolderInt(r11)
            if (r11 == 0) goto L_0x03bf
            boolean r12 = r11.isRemoved()
            if (r12 != 0) goto L_0x03bf
            long r12 = r11.getItemId()
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L_0x03bf
            androidx.recyclerview.widget.ChildHelper r10 = r0.mChildHelper
            android.view.View r12 = r11.itemView
            boolean r10 = r10.isHidden(r12)
            if (r10 == 0) goto L_0x03c6
            r10 = r11
        L_0x03bf:
            int r9 = r9 + 1
            goto L_0x0398
        L_0x03c2:
            r10 = r5
        L_0x03c3:
            r11 = r10
            goto L_0x03c6
        L_0x03c5:
            r11 = r5
        L_0x03c6:
            if (r11 == 0) goto L_0x03de
            androidx.recyclerview.widget.ChildHelper r1 = r0.mChildHelper
            android.view.View r7 = r11.itemView
            boolean r1 = r1.isHidden(r7)
            if (r1 != 0) goto L_0x03de
            android.view.View r1 = r11.itemView
            boolean r1 = r1.hasFocusable()
            if (r1 != 0) goto L_0x03db
            goto L_0x03de
        L_0x03db:
            android.view.View r5 = r11.itemView
            goto L_0x0428
        L_0x03de:
            androidx.recyclerview.widget.ChildHelper r1 = r0.mChildHelper
            int r1 = r1.getChildCount()
            if (r1 <= 0) goto L_0x0428
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            int r1 = r1.mFocusedItemPosition
            if (r1 == r6) goto L_0x03ed
            r2 = r1
        L_0x03ed:
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            int r1 = r1.getItemCount()
            r7 = r2
        L_0x03f4:
            if (r7 >= r1) goto L_0x040c
            androidx.recyclerview.widget.RecyclerView$ViewHolder r8 = r0.findViewHolderForAdapterPosition(r7)
            if (r8 != 0) goto L_0x03fd
            goto L_0x040c
        L_0x03fd:
            android.view.View r9 = r8.itemView
            boolean r9 = r9.hasFocusable()
            if (r9 == 0) goto L_0x0409
            android.view.View r1 = r8.itemView
        L_0x0407:
            r5 = r1
            goto L_0x0428
        L_0x0409:
            int r7 = r7 + 1
            goto L_0x03f4
        L_0x040c:
            int r1 = java.lang.Math.min(r1, r2)
            int r1 = r1 + r6
        L_0x0411:
            if (r1 < 0) goto L_0x0428
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r0.findViewHolderForAdapterPosition(r1)
            if (r2 != 0) goto L_0x041a
            goto L_0x0428
        L_0x041a:
            android.view.View r7 = r2.itemView
            boolean r7 = r7.hasFocusable()
            if (r7 == 0) goto L_0x0425
            android.view.View r1 = r2.itemView
            goto L_0x0407
        L_0x0425:
            int r1 = r1 + -1
            goto L_0x0411
        L_0x0428:
            if (r5 == 0) goto L_0x0443
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            int r1 = r1.mFocusedSubChildId
            long r7 = (long) r1
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0440
            android.view.View r1 = r5.findViewById(r1)
            if (r1 == 0) goto L_0x0440
            boolean r2 = r1.isFocusable()
            if (r2 == 0) goto L_0x0440
            r5 = r1
        L_0x0440:
            r5.requestFocus()
        L_0x0443:
            androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
            r1.mFocusedItemId = r3
            r1.mFocusedItemPosition = r6
            r1.mFocusedSubChildId = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.dispatchLayout():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchLayoutStep1() {
        /*
            r9 = this;
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            r1 = 1
            r0.assertLayoutStep(r1)
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            r9.fillRemainingScrollValues(r0)
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            r2 = 0
            r0.mIsMeasuring = r2
            r9.startInterceptRequestLayout()
            androidx.recyclerview.widget.ViewInfoStore r0 = r9.mViewInfoStore
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r3 = r0.mLayoutHolderMap
            r3.clear()
            androidx.collection.LongSparseArray<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r0.mOldChangedHolders
            r0.clear()
            r9.onEnterLayoutOrScroll()
            r9.processAdapterUpdatesAndSetAnimationFlags()
            boolean r0 = r9.mPreserveFocusAfterLayout
            r3 = 0
            if (r0 == 0) goto L_0x0039
            boolean r0 = r9.hasFocus()
            if (r0 == 0) goto L_0x0039
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r9.mAdapter
            if (r0 == 0) goto L_0x0039
            android.view.View r0 = r9.getFocusedChild()
            goto L_0x003a
        L_0x0039:
            r0 = r3
        L_0x003a:
            if (r0 != 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            android.view.View r0 = r9.findContainingItemView(r0)
            if (r0 != 0) goto L_0x0045
        L_0x0043:
            r0 = r3
            goto L_0x0049
        L_0x0045:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r9.getChildViewHolder(r0)
        L_0x0049:
            r4 = -1
            r6 = -1
            if (r0 != 0) goto L_0x0057
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            r0.mFocusedItemId = r4
            r0.mFocusedItemPosition = r6
            r0.mFocusedSubChildId = r6
            goto L_0x00a9
        L_0x0057:
            androidx.recyclerview.widget.RecyclerView$State r7 = r9.mState
            androidx.recyclerview.widget.RecyclerView$Adapter r8 = r9.mAdapter
            boolean r8 = r8.hasStableIds()
            if (r8 == 0) goto L_0x0065
            long r4 = r0.getItemId()
        L_0x0065:
            r7.mFocusedItemId = r4
            androidx.recyclerview.widget.RecyclerView$State r4 = r9.mState
            boolean r5 = r9.mDataSetHasChangedAfterLayout
            if (r5 == 0) goto L_0x006f
            r5 = -1
            goto L_0x007c
        L_0x006f:
            boolean r5 = r0.isRemoved()
            if (r5 == 0) goto L_0x0078
            int r5 = r0.mOldPosition
            goto L_0x007c
        L_0x0078:
            int r5 = r0.getAbsoluteAdapterPosition()
        L_0x007c:
            r4.mFocusedItemPosition = r5
            androidx.recyclerview.widget.RecyclerView$State r4 = r9.mState
            android.view.View r0 = r0.itemView
            int r5 = r0.getId()
        L_0x0086:
            boolean r7 = r0.isFocused()
            if (r7 != 0) goto L_0x00a7
            boolean r7 = r0 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x00a7
            boolean r7 = r0.hasFocus()
            if (r7 == 0) goto L_0x00a7
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r0.getFocusedChild()
            int r7 = r0.getId()
            if (r7 == r6) goto L_0x0086
            int r5 = r0.getId()
            goto L_0x0086
        L_0x00a7:
            r4.mFocusedSubChildId = r5
        L_0x00a9:
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            boolean r4 = r0.mRunSimpleAnimations
            if (r4 == 0) goto L_0x00b5
            boolean r4 = r9.mItemsChanged
            if (r4 == 0) goto L_0x00b5
            r4 = 1
            goto L_0x00b6
        L_0x00b5:
            r4 = 0
        L_0x00b6:
            r0.mTrackOldChangeHolders = r4
            r9.mItemsChanged = r2
            r9.mItemsAddedOrRemoved = r2
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            boolean r4 = r0.mRunPredictiveAnimations
            r0.mInPreLayout = r4
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r9.mAdapter
            int r4 = r4.getItemCount()
            r0.mItemCount = r4
            int[] r0 = r9.mMinMaxLayoutPositions
            r9.findMinMaxChildLayoutPositions(r0)
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            boolean r0 = r0.mRunSimpleAnimations
            if (r0 == 0) goto L_0x013a
            androidx.recyclerview.widget.ChildHelper r0 = r9.mChildHelper
            int r0 = r0.getChildCount()
            r4 = 0
        L_0x00dc:
            if (r4 >= r0) goto L_0x013a
            androidx.recyclerview.widget.ChildHelper r5 = r9.mChildHelper
            android.view.View r5 = r5.getChildAt(r4)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r5 = getChildViewHolderInt(r5)
            boolean r6 = r5.shouldIgnore()
            if (r6 != 0) goto L_0x0137
            boolean r6 = r5.isInvalid()
            if (r6 == 0) goto L_0x00fd
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = r9.mAdapter
            boolean r6 = r6.hasStableIds()
            if (r6 != 0) goto L_0x00fd
            goto L_0x0137
        L_0x00fd:
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r6 = r9.mItemAnimator
            androidx.recyclerview.widget.RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(r5)
            r5.getUnmodifiedPayloads()
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r6 = r6.recordPreLayoutInformation(r5)
            androidx.recyclerview.widget.ViewInfoStore r7 = r9.mViewInfoStore
            r7.addToPreLayout(r5, r6)
            androidx.recyclerview.widget.RecyclerView$State r6 = r9.mState
            boolean r6 = r6.mTrackOldChangeHolders
            if (r6 == 0) goto L_0x0137
            boolean r6 = r5.isUpdated()
            if (r6 == 0) goto L_0x0137
            boolean r6 = r5.isRemoved()
            if (r6 != 0) goto L_0x0137
            boolean r6 = r5.shouldIgnore()
            if (r6 != 0) goto L_0x0137
            boolean r6 = r5.isInvalid()
            if (r6 != 0) goto L_0x0137
            long r6 = r9.getChangedHolderKey(r5)
            androidx.recyclerview.widget.ViewInfoStore r8 = r9.mViewInfoStore
            androidx.collection.LongSparseArray<androidx.recyclerview.widget.RecyclerView$ViewHolder> r8 = r8.mOldChangedHolders
            r8.put(r6, r5)
        L_0x0137:
            int r4 = r4 + 1
            goto L_0x00dc
        L_0x013a:
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            boolean r0 = r0.mRunPredictiveAnimations
            r4 = 2
            if (r0 == 0) goto L_0x01dd
            androidx.recyclerview.widget.ChildHelper r0 = r9.mChildHelper
            int r0 = r0.getUnfilteredChildCount()
            r5 = 0
        L_0x0148:
            if (r5 >= r0) goto L_0x0160
            androidx.recyclerview.widget.ChildHelper r6 = r9.mChildHelper
            android.view.View r6 = r6.getUnfilteredChildAt(r5)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = getChildViewHolderInt(r6)
            boolean r7 = r6.shouldIgnore()
            if (r7 != 0) goto L_0x015d
            r6.saveOldPosition()
        L_0x015d:
            int r5 = r5 + 1
            goto L_0x0148
        L_0x0160:
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            boolean r5 = r0.mStructureChanged
            r0.mStructureChanged = r2
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = r9.mLayout
            androidx.recyclerview.widget.RecyclerView$Recycler r7 = r9.mRecycler
            r6.onLayoutChildren(r7, r0)
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            r0.mStructureChanged = r5
            r0 = 0
        L_0x0172:
            androidx.recyclerview.widget.ChildHelper r5 = r9.mChildHelper
            int r5 = r5.getChildCount()
            if (r0 >= r5) goto L_0x01d9
            androidx.recyclerview.widget.ChildHelper r5 = r9.mChildHelper
            android.view.View r5 = r5.getChildAt(r0)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r5 = getChildViewHolderInt(r5)
            boolean r6 = r5.shouldIgnore()
            if (r6 == 0) goto L_0x018b
            goto L_0x01d6
        L_0x018b:
            androidx.recyclerview.widget.ViewInfoStore r6 = r9.mViewInfoStore
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r6 = r6.mLayoutHolderMap
            java.lang.Object r6 = r6.getOrDefault(r5, r3)
            androidx.recyclerview.widget.ViewInfoStore$InfoRecord r6 = (androidx.recyclerview.widget.ViewInfoStore.InfoRecord) r6
            if (r6 == 0) goto L_0x019f
            int r6 = r6.flags
            r6 = r6 & 4
            if (r6 == 0) goto L_0x019f
            r6 = 1
            goto L_0x01a0
        L_0x019f:
            r6 = 0
        L_0x01a0:
            if (r6 != 0) goto L_0x01d6
            androidx.recyclerview.widget.RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(r5)
            r6 = 8192(0x2000, float:1.148E-41)
            boolean r6 = r5.hasAnyOfTheFlags(r6)
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r7 = r9.mItemAnimator
            r5.getUnmodifiedPayloads()
            androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r7 = r7.recordPreLayoutInformation(r5)
            if (r6 == 0) goto L_0x01ba
            r9.recordAnimationInfoIfBouncedHiddenView(r5, r7)
            goto L_0x01d6
        L_0x01ba:
            androidx.recyclerview.widget.ViewInfoStore r6 = r9.mViewInfoStore
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r8 = r6.mLayoutHolderMap
            java.lang.Object r8 = r8.getOrDefault(r5, r3)
            androidx.recyclerview.widget.ViewInfoStore$InfoRecord r8 = (androidx.recyclerview.widget.ViewInfoStore.InfoRecord) r8
            if (r8 != 0) goto L_0x01cf
            androidx.recyclerview.widget.ViewInfoStore$InfoRecord r8 = androidx.recyclerview.widget.ViewInfoStore.InfoRecord.obtain()
            androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.ViewInfoStore$InfoRecord> r6 = r6.mLayoutHolderMap
            r6.put(r5, r8)
        L_0x01cf:
            int r5 = r8.flags
            r5 = r5 | r4
            r8.flags = r5
            r8.preInfo = r7
        L_0x01d6:
            int r0 = r0 + 1
            goto L_0x0172
        L_0x01d9:
            r9.clearOldPositions()
            goto L_0x01e0
        L_0x01dd:
            r9.clearOldPositions()
        L_0x01e0:
            r9.onExitLayoutOrScroll(r1)
            r9.stopInterceptRequestLayout(r2)
            androidx.recyclerview.widget.RecyclerView$State r0 = r9.mState
            r0.mLayoutStep = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.dispatchLayoutStep1():void");
    }

    public final void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        State state = this.mState;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        state2.mRunSimpleAnimations = state2.mRunSimpleAnimations && this.mItemAnimator != null;
        this.mState.mLayoutStep = 4;
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().dispatchNestedPreFling(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled();
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z3 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) (getPaddingRight() + (-getWidth())), (float) (getPaddingBottom() + (-getHeight())));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z3 = z;
        }
        if (z3) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mBottomGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mLeftGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mRightGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this);
            this.mTopGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String exceptionLabel() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(CMap.SPACE);
        outline73.append(super.toString());
        outline73.append(", adapter:");
        outline73.append(this.mAdapter);
        outline73.append(", layout:");
        outline73.append(this.mLayout);
        outline73.append(", context:");
        outline73.append(getContext());
        return outline73.toString();
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        state.mRemainingScrollHorizontal = 0;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (!onItemTouchListener.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    public final void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i) {
                if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:121:0x019f, code lost:
        if (r3 > 0) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01b9, code lost:
        if (r8 > 0) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01bc, code lost:
        if (r3 < 0) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01bf, code lost:
        if (r8 < 0) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01c8, code lost:
        if ((r8 * r1) <= 0) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01d1, code lost:
        if ((r8 * r1) >= 0) goto L_0x01d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View focusSearch(android.view.View r14, int r15) {
        /*
            r13 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            android.view.View r0 = r0.onInterceptFocusSearch(r14, r15)
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r13.mAdapter
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001f
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            if (r0 == 0) goto L_0x001f
            boolean r0 = r13.isComputingLayout()
            if (r0 != 0) goto L_0x001f
            boolean r0 = r13.mLayoutSuppressed
            if (r0 != 0) goto L_0x001f
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            r4 = 130(0x82, float:1.82E-43)
            r5 = 66
            r6 = 33
            r7 = 17
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L_0x00a3
            if (r15 == r9) goto L_0x0034
            if (r15 != r2) goto L_0x00a3
        L_0x0034:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L_0x0052
            if (r15 != r9) goto L_0x0041
            r0 = 130(0x82, float:1.82E-43)
            goto L_0x0043
        L_0x0041:
            r0 = 33
        L_0x0043:
            android.view.View r10 = r3.findNextFocus(r13, r14, r0)
            if (r10 != 0) goto L_0x004b
            r10 = 1
            goto L_0x004c
        L_0x004b:
            r10 = 0
        L_0x004c:
            boolean r11 = FORCE_ABS_FOCUS_SEARCH_DIRECTION
            if (r11 == 0) goto L_0x0053
            r15 = r0
            goto L_0x0053
        L_0x0052:
            r10 = 0
        L_0x0053:
            if (r10 != 0) goto L_0x0083
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            boolean r0 = r0.canScrollHorizontally()
            if (r0 == 0) goto L_0x0083
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            int r0 = r0.getLayoutDirection()
            if (r0 != r2) goto L_0x0067
            r0 = 1
            goto L_0x0068
        L_0x0067:
            r0 = 0
        L_0x0068:
            if (r15 != r9) goto L_0x006c
            r10 = 1
            goto L_0x006d
        L_0x006c:
            r10 = 0
        L_0x006d:
            r0 = r0 ^ r10
            if (r0 == 0) goto L_0x0073
            r0 = 66
            goto L_0x0075
        L_0x0073:
            r0 = 17
        L_0x0075:
            android.view.View r10 = r3.findNextFocus(r13, r14, r0)
            if (r10 != 0) goto L_0x007d
            r10 = 1
            goto L_0x007e
        L_0x007d:
            r10 = 0
        L_0x007e:
            boolean r11 = FORCE_ABS_FOCUS_SEARCH_DIRECTION
            if (r11 == 0) goto L_0x0083
            r15 = r0
        L_0x0083:
            if (r10 == 0) goto L_0x009e
            r13.consumePendingUpdateOperations()
            android.view.View r0 = r13.findContainingItemView(r14)
            if (r0 != 0) goto L_0x008f
            return r8
        L_0x008f:
            r13.startInterceptRequestLayout()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            androidx.recyclerview.widget.RecyclerView$Recycler r10 = r13.mRecycler
            androidx.recyclerview.widget.RecyclerView$State r11 = r13.mState
            r0.onFocusSearchFailed(r14, r15, r10, r11)
            r13.stopInterceptRequestLayout(r1)
        L_0x009e:
            android.view.View r0 = r3.findNextFocus(r13, r14, r15)
            goto L_0x00c7
        L_0x00a3:
            android.view.View r3 = r3.findNextFocus(r13, r14, r15)
            if (r3 != 0) goto L_0x00c6
            if (r0 == 0) goto L_0x00c6
            r13.consumePendingUpdateOperations()
            android.view.View r0 = r13.findContainingItemView(r14)
            if (r0 != 0) goto L_0x00b5
            return r8
        L_0x00b5:
            r13.startInterceptRequestLayout()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            androidx.recyclerview.widget.RecyclerView$Recycler r3 = r13.mRecycler
            androidx.recyclerview.widget.RecyclerView$State r10 = r13.mState
            android.view.View r0 = r0.onFocusSearchFailed(r14, r15, r3, r10)
            r13.stopInterceptRequestLayout(r1)
            goto L_0x00c7
        L_0x00c6:
            r0 = r3
        L_0x00c7:
            if (r0 == 0) goto L_0x00de
            boolean r3 = r0.hasFocusable()
            if (r3 != 0) goto L_0x00de
            android.view.View r1 = r13.getFocusedChild()
            if (r1 != 0) goto L_0x00da
            android.view.View r14 = super.focusSearch(r14, r15)
            return r14
        L_0x00da:
            r13.requestChildOnScreen(r0, r8)
            return r14
        L_0x00de:
            if (r0 == 0) goto L_0x01d5
            if (r0 == r13) goto L_0x01d5
            if (r0 != r14) goto L_0x00e6
            goto L_0x01d5
        L_0x00e6:
            android.view.View r3 = r13.findContainingItemView(r0)
            if (r3 != 0) goto L_0x00ee
            goto L_0x01d6
        L_0x00ee:
            if (r14 != 0) goto L_0x00f2
            goto L_0x01d3
        L_0x00f2:
            android.view.View r3 = r13.findContainingItemView(r14)
            if (r3 != 0) goto L_0x00fa
            goto L_0x01d3
        L_0x00fa:
            android.graphics.Rect r3 = r13.mTempRect
            int r8 = r14.getWidth()
            int r10 = r14.getHeight()
            r3.set(r1, r1, r8, r10)
            android.graphics.Rect r3 = r13.mTempRect2
            int r8 = r0.getWidth()
            int r10 = r0.getHeight()
            r3.set(r1, r1, r8, r10)
            android.graphics.Rect r1 = r13.mTempRect
            r13.offsetDescendantRectToMyCoords(r14, r1)
            android.graphics.Rect r1 = r13.mTempRect2
            r13.offsetDescendantRectToMyCoords(r0, r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r13.mLayout
            int r1 = r1.getLayoutDirection()
            r3 = -1
            if (r1 != r2) goto L_0x0129
            r1 = -1
            goto L_0x012a
        L_0x0129:
            r1 = 1
        L_0x012a:
            android.graphics.Rect r8 = r13.mTempRect
            int r10 = r8.left
            android.graphics.Rect r11 = r13.mTempRect2
            int r11 = r11.left
            if (r10 < r11) goto L_0x0138
            int r8 = r8.right
            if (r8 > r11) goto L_0x0144
        L_0x0138:
            android.graphics.Rect r8 = r13.mTempRect
            int r8 = r8.right
            android.graphics.Rect r10 = r13.mTempRect2
            int r10 = r10.right
            if (r8 >= r10) goto L_0x0144
            r8 = 1
            goto L_0x015f
        L_0x0144:
            android.graphics.Rect r8 = r13.mTempRect
            int r10 = r8.right
            android.graphics.Rect r11 = r13.mTempRect2
            int r11 = r11.right
            if (r10 > r11) goto L_0x0152
            int r8 = r8.left
            if (r8 < r11) goto L_0x015e
        L_0x0152:
            android.graphics.Rect r8 = r13.mTempRect
            int r8 = r8.left
            android.graphics.Rect r10 = r13.mTempRect2
            int r10 = r10.left
            if (r8 <= r10) goto L_0x015e
            r8 = -1
            goto L_0x015f
        L_0x015e:
            r8 = 0
        L_0x015f:
            android.graphics.Rect r10 = r13.mTempRect
            int r11 = r10.top
            android.graphics.Rect r12 = r13.mTempRect2
            int r12 = r12.top
            if (r11 < r12) goto L_0x016d
            int r10 = r10.bottom
            if (r10 > r12) goto L_0x0179
        L_0x016d:
            android.graphics.Rect r10 = r13.mTempRect
            int r10 = r10.bottom
            android.graphics.Rect r11 = r13.mTempRect2
            int r11 = r11.bottom
            if (r10 >= r11) goto L_0x0179
            r3 = 1
            goto L_0x0193
        L_0x0179:
            android.graphics.Rect r10 = r13.mTempRect
            int r11 = r10.bottom
            android.graphics.Rect r12 = r13.mTempRect2
            int r12 = r12.bottom
            if (r11 > r12) goto L_0x0187
            int r10 = r10.top
            if (r10 < r12) goto L_0x0192
        L_0x0187:
            android.graphics.Rect r10 = r13.mTempRect
            int r10 = r10.top
            android.graphics.Rect r11 = r13.mTempRect2
            int r11 = r11.top
            if (r10 <= r11) goto L_0x0192
            goto L_0x0193
        L_0x0192:
            r3 = 0
        L_0x0193:
            if (r15 == r2) goto L_0x01cb
            if (r15 == r9) goto L_0x01c2
            if (r15 == r7) goto L_0x01bf
            if (r15 == r6) goto L_0x01bc
            if (r15 == r5) goto L_0x01b9
            if (r15 != r4) goto L_0x01a2
            if (r3 <= 0) goto L_0x01d5
            goto L_0x01d3
        L_0x01a2:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid direction: "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = com.android.tools.r8.GeneratedOutlineSupport.outline33(r13, r0)
            r14.<init>(r15)
            throw r14
        L_0x01b9:
            if (r8 <= 0) goto L_0x01d5
            goto L_0x01d3
        L_0x01bc:
            if (r3 >= 0) goto L_0x01d5
            goto L_0x01d3
        L_0x01bf:
            if (r8 >= 0) goto L_0x01d5
            goto L_0x01d3
        L_0x01c2:
            if (r3 > 0) goto L_0x01d3
            if (r3 != 0) goto L_0x01d5
            int r8 = r8 * r1
            if (r8 <= 0) goto L_0x01d5
            goto L_0x01d3
        L_0x01cb:
            if (r3 < 0) goto L_0x01d3
            if (r3 != 0) goto L_0x01d5
            int r8 = r8 * r1
            if (r8 >= 0) goto L_0x01d5
        L_0x01d3:
            r1 = 1
            goto L_0x01d6
        L_0x01d5:
            r1 = 0
        L_0x01d6:
            if (r1 == 0) goto L_0x01d9
            goto L_0x01dd
        L_0x01d9:
            android.view.View r0 = super.focusSearch(r14, r15)
        L_0x01dd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline33(this, GeneratedOutlineSupport.outline73("RecyclerView has no LayoutManager")));
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline33(this, GeneratedOutlineSupport.outline73("RecyclerView has no LayoutManager")));
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (!viewHolder.hasAnyOfTheFlags(524) && viewHolder.isBound()) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            int i = viewHolder.mPosition;
            int size = adapterHelper.mPendingUpdates.size();
            for (int i2 = 0; i2 < size; i2++) {
                UpdateOp updateOp = adapterHelper.mPendingUpdates.get(i2);
                int i3 = updateOp.cmd;
                if (i3 != 1) {
                    if (i3 == 2) {
                        int i4 = updateOp.positionStart;
                        if (i4 <= i) {
                            int i5 = updateOp.itemCount;
                            if (i4 + i5 <= i) {
                                i -= i5;
                            }
                        } else {
                            continue;
                        }
                    } else if (i3 == 8) {
                        int i6 = updateOp.positionStart;
                        if (i6 == i) {
                            i = updateOp.itemCount;
                        } else {
                            if (i6 < i) {
                                i--;
                            }
                            if (updateOp.itemCount <= i) {
                                i++;
                            }
                        }
                    }
                } else if (updateOp.positionStart <= i) {
                    i += updateOp.itemCount;
                }
            }
            return i;
        }
        return -1;
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.hasStableIds() ? viewHolder.getItemId() : (long) viewHolder.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.mInPreLayout && (layoutParams.isItemChanged() || layoutParams.mViewHolder.isInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i2 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().mIsNestedScrollingEnabled;
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        Recycler recycler = this.mRecycler;
        int size = recycler.mCachedViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutParams layoutParams = (LayoutParams) recycler.mCachedViews.get(i2).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i5 = childViewHolderInt.mPosition;
                if (i5 >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.mStructureChanged = true;
                } else if (i5 >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        Recycler recycler = this.mRecycler;
        int size = recycler.mCachedViews.size();
        while (true) {
            size--;
            if (size >= 0) {
                ViewHolder viewHolder = recycler.mCachedViews.get(size);
                if (viewHolder != null) {
                    int i6 = viewHolder.mPosition;
                    if (i6 >= i3) {
                        viewHolder.offsetPosition(-i2, z);
                    } else if (i6 >= i) {
                        viewHolder.addFlags(8);
                        recycler.recycleCachedViewAt(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z = false;
        }
        this.mFirstLayoutComplete = z;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            GapWorker gapWorker = GapWorker.sGapWorker.get();
            this.mGapWorker = gapWorker;
            if (gapWorker == null) {
                this.mGapWorker = new GapWorker();
                Display display = ViewCompat.getDisplay(this);
                float f2 = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                GapWorker gapWorker2 = this.mGapWorker;
                gapWorker2.mFrameIntervalNs = (long) (1.0E9f / f2);
                GapWorker.sGapWorker.set(gapWorker2);
            }
            this.mGapWorker.mRecyclerViews.add(this);
        }
    }

    public void onChildAttachedToWindow() {
    }

    public void onChildDetachedFromWindow() {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        if (this.mViewInfoStore != null) {
            do {
            } while (InfoRecord.sPool.acquire() != null);
            if (ALLOW_THREAD_GAP_WORK) {
                GapWorker gapWorker = this.mGapWorker;
                if (gapWorker != null) {
                    gapWorker.mRecyclerViews.remove(this);
                    this.mGapWorker = null;
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll(boolean z) {
        boolean z2 = true;
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                int i2 = this.mEatenAccessibilityChangeFlags;
                this.mEatenAccessibilityChangeFlags = 0;
                if (i2 != 0) {
                    AccessibilityManager accessibilityManager = this.mAccessibilityManager;
                    if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                        z2 = false;
                    }
                    if (z2) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain();
                        obtain.setEventType(2048);
                        obtain.setContentChangeTypes(i2);
                        sendAccessibilityEventUnchecked(obtain);
                    }
                }
                for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
                    ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
                    if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore()) {
                        int i3 = viewHolder.mPendingAccessibilityState;
                        if (i3 != -1) {
                            ViewCompat.setImportantForAccessibility(viewHolder.itemView, i3);
                            viewHolder.mPendingAccessibilityState = -1;
                        }
                    }
                }
                this.mPendingAccessibilityImportanceChange.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r13.mLayoutSuppressed
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            int r0 = r14.getAction()
            r2 = 8
            if (r0 != r2) goto L_0x00d8
            int r0 = r14.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L_0x003c
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L_0x002c
            r0 = 9
            float r0 = r14.getAxisValue(r0)
            float r0 = -r0
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r13.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L_0x0061
            r3 = 10
            float r3 = r14.getAxisValue(r3)
            goto L_0x0062
        L_0x003c:
            int r0 = r14.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0060
            r0 = 26
            float r0 = r14.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r13.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L_0x0055
            float r0 = -r0
            goto L_0x0061
        L_0x0055:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r13.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L_0x0060
            r3 = r0
            r0 = 0
            goto L_0x0062
        L_0x0060:
            r0 = 0
        L_0x0061:
            r3 = 0
        L_0x0062:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x006a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00d8
        L_0x006a:
            float r2 = r13.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r13.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r13.mLayout
            if (r3 != 0) goto L_0x007a
            goto L_0x00d8
        L_0x007a:
            boolean r4 = r13.mLayoutSuppressed
            if (r4 == 0) goto L_0x007f
            goto L_0x00d8
        L_0x007f:
            int[] r4 = r13.mReusableIntPair
            r4[r1] = r1
            r5 = 1
            r4[r5] = r1
            boolean r3 = r3.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r13.mLayout
            boolean r4 = r4.canScrollVertically()
            if (r4 == 0) goto L_0x0095
            r6 = r3 | 2
            goto L_0x0096
        L_0x0095:
            r6 = r3
        L_0x0096:
            r13.startNestedScroll(r6, r5)
            if (r3 == 0) goto L_0x009d
            r8 = r2
            goto L_0x009e
        L_0x009d:
            r8 = 0
        L_0x009e:
            if (r4 == 0) goto L_0x00a2
            r9 = r0
            goto L_0x00a3
        L_0x00a2:
            r9 = 0
        L_0x00a3:
            int[] r10 = r13.mReusableIntPair
            int[] r11 = r13.mScrollOffset
            r12 = 1
            r7 = r13
            boolean r6 = r7.dispatchNestedPreScroll(r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x00b7
            int[] r6 = r13.mReusableIntPair
            r7 = r6[r1]
            int r2 = r2 - r7
            r6 = r6[r5]
            int r0 = r0 - r6
        L_0x00b7:
            if (r3 == 0) goto L_0x00bb
            r3 = r2
            goto L_0x00bc
        L_0x00bb:
            r3 = 0
        L_0x00bc:
            if (r4 == 0) goto L_0x00c0
            r4 = r0
            goto L_0x00c1
        L_0x00c0:
            r4 = 0
        L_0x00c1:
            r13.scrollByInternal(r3, r4, r14, r5)
            androidx.recyclerview.widget.GapWorker r14 = r13.mGapWorker
            if (r14 == 0) goto L_0x00d1
            if (r2 != 0) goto L_0x00cc
            if (r0 == 0) goto L_0x00d1
        L_0x00cc:
            androidx.recyclerview.widget.GapWorker r14 = r13.mGapWorker
            r14.postFromTraversal(r13, r2, r0)
        L_0x00d1:
            androidx.core.view.NestedScrollingChildHelper r14 = r13.getScrollingChildHelper()
            r14.stopNestedScroll(r5)
        L_0x00d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = canScrollHorizontally ? 1 : 0;
            if (canScrollVertically) {
                i |= 2;
            }
            startNestedScroll(i, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x2 - this.mInitialTouchX;
                int i3 = y2 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            z2 = true;
        }
        return z2;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection("RV OnLayout");
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z;
            if (!z && this.mAdapter != null) {
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i, i2);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll(true);
                State state = this.mState;
                if (state.mRunPredictiveAnimations) {
                    state.mInPreLayout = true;
                } else {
                    this.mAdapterHelper.consumeUpdatesInOnePass();
                    this.mState.mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.mRunPredictiveAnimations) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.mItemCount = adapter.getItemCount();
            } else {
                this.mState.mItemCount = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.mInPreLayout = false;
        }
    }

    public final void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.mSuperState);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.mLayoutState = savedState2.mLayoutState;
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.mLayoutState = layoutManager.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged() {
    }

    public void onScrolled() {
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0238, code lost:
        if (r5 == false) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0292, code lost:
        if (r0 != false) goto L_0x0297;
     */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r23) {
        /*
            r22 = this;
            r6 = r22
            r7 = r23
            boolean r0 = r6.mLayoutSuppressed
            r8 = 0
            if (r0 != 0) goto L_0x02cd
            boolean r0 = r6.mIgnoreMotionEventTillDown
            if (r0 == 0) goto L_0x000f
            goto L_0x02cd
        L_0x000f:
            androidx.recyclerview.widget.RecyclerView$OnItemTouchListener r0 = r6.mInterceptingOnItemTouchListener
            r1 = 3
            r9 = 1
            if (r0 != 0) goto L_0x0022
            int r0 = r23.getAction()
            if (r0 != 0) goto L_0x001d
            r0 = 0
            goto L_0x0031
        L_0x001d:
            boolean r0 = r22.findInterceptingOnItemTouchListener(r23)
            goto L_0x0031
        L_0x0022:
            r0.onTouchEvent(r6, r7)
            int r0 = r23.getAction()
            if (r0 == r1) goto L_0x002d
            if (r0 != r9) goto L_0x0030
        L_0x002d:
            r0 = 0
            r6.mInterceptingOnItemTouchListener = r0
        L_0x0030:
            r0 = 1
        L_0x0031:
            if (r0 == 0) goto L_0x0037
            r22.cancelScroll()
            return r9
        L_0x0037:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            if (r0 != 0) goto L_0x003c
            return r8
        L_0x003c:
            boolean r10 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            boolean r11 = r0.canScrollVertically()
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x0050
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x0050:
            int r0 = r23.getActionMasked()
            int r2 = r23.getActionIndex()
            if (r0 != 0) goto L_0x0060
            int[] r3 = r6.mNestedOffsets
            r3[r9] = r8
            r3[r8] = r8
        L_0x0060:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r23)
            int[] r3 = r6.mNestedOffsets
            r4 = r3[r8]
            float r4 = (float) r4
            r3 = r3[r9]
            float r3 = (float) r3
            r12.offsetLocation(r4, r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x029c
            r4 = 2
            if (r0 == r9) goto L_0x0175
            if (r0 == r4) goto L_0x00a8
            if (r0 == r1) goto L_0x00a3
            r1 = 5
            if (r0 == r1) goto L_0x0087
            r1 = 6
            if (r0 == r1) goto L_0x0082
            goto L_0x02c2
        L_0x0082:
            r22.onPointerUp(r23)
            goto L_0x02c2
        L_0x0087:
            int r0 = r7.getPointerId(r2)
            r6.mScrollPointerId = r0
            float r0 = r7.getX(r2)
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r7.getY(r2)
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            goto L_0x02c2
        L_0x00a3:
            r22.cancelScroll()
            goto L_0x02c2
        L_0x00a8:
            int r0 = r6.mScrollPointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b1
            return r8
        L_0x00b1:
            float r1 = r7.getX(r0)
            float r1 = r1 + r3
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r3
            int r14 = (int) r0
            int r0 = r6.mLastTouchX
            int r0 = r0 - r13
            int r1 = r6.mLastTouchY
            int r1 = r1 - r14
            int r2 = r6.mScrollState
            if (r2 == r9) goto L_0x00fa
            if (r10 == 0) goto L_0x00de
            if (r0 <= 0) goto L_0x00d3
            int r2 = r6.mTouchSlop
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00da
        L_0x00d3:
            int r2 = r6.mTouchSlop
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00da:
            if (r0 == 0) goto L_0x00de
            r2 = 1
            goto L_0x00df
        L_0x00de:
            r2 = 0
        L_0x00df:
            if (r11 == 0) goto L_0x00f5
            if (r1 <= 0) goto L_0x00eb
            int r3 = r6.mTouchSlop
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00f2
        L_0x00eb:
            int r3 = r6.mTouchSlop
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00f2:
            if (r1 == 0) goto L_0x00f5
            r2 = 1
        L_0x00f5:
            if (r2 == 0) goto L_0x00fa
            r6.setScrollState(r9)
        L_0x00fa:
            r15 = r0
            r16 = r1
            int r0 = r6.mScrollState
            if (r0 != r9) goto L_0x02c2
            int[] r0 = r6.mReusableIntPair
            r0[r8] = r8
            r0[r9] = r8
            if (r10 == 0) goto L_0x010b
            r1 = r15
            goto L_0x010c
        L_0x010b:
            r1 = 0
        L_0x010c:
            if (r11 == 0) goto L_0x0111
            r2 = r16
            goto L_0x0112
        L_0x0111:
            r2 = 0
        L_0x0112:
            int[] r3 = r6.mReusableIntPair
            int[] r4 = r6.mScrollOffset
            r5 = 0
            r0 = r22
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0141
            int[] r0 = r6.mReusableIntPair
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.mNestedOffsets
            r1 = r0[r8]
            int[] r2 = r6.mScrollOffset
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r22.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x0141:
            r0 = r16
            int[] r1 = r6.mScrollOffset
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.mLastTouchX = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.mLastTouchY = r14
            if (r10 == 0) goto L_0x0153
            r1 = r15
            goto L_0x0154
        L_0x0153:
            r1 = 0
        L_0x0154:
            if (r11 == 0) goto L_0x0158
            r2 = r0
            goto L_0x0159
        L_0x0158:
            r2 = 0
        L_0x0159:
            boolean r1 = r6.scrollByInternal(r1, r2, r7, r8)
            if (r1 == 0) goto L_0x0166
            android.view.ViewParent r1 = r22.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0166:
            androidx.recyclerview.widget.GapWorker r1 = r6.mGapWorker
            if (r1 == 0) goto L_0x02c2
            if (r15 != 0) goto L_0x016e
            if (r0 == 0) goto L_0x02c2
        L_0x016e:
            androidx.recyclerview.widget.GapWorker r1 = r6.mGapWorker
            r1.postFromTraversal(r6, r15, r0)
            goto L_0x02c2
        L_0x0175:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.mMaxFlingVelocity
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0191
            android.view.VelocityTracker r1 = r6.mVelocityTracker
            int r2 = r6.mScrollPointerId
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x0192
        L_0x0191:
            r1 = 0
        L_0x0192:
            if (r11 == 0) goto L_0x019e
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            int r3 = r6.mScrollPointerId
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x019f
        L_0x019e:
            r2 = 0
        L_0x019f:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01a7
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0294
        L_0x01a7:
            int r0 = (int) r1
            int r1 = (int) r2
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r6.mLayout
            if (r2 != 0) goto L_0x01b0
        L_0x01ad:
            r0 = 0
            goto L_0x0292
        L_0x01b0:
            boolean r3 = r6.mLayoutSuppressed
            if (r3 == 0) goto L_0x01b5
            goto L_0x01ad
        L_0x01b5:
            boolean r2 = r2.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r6.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r2 == 0) goto L_0x01c9
            int r5 = java.lang.Math.abs(r0)
            int r7 = r6.mMinFlingVelocity
            if (r5 >= r7) goto L_0x01ca
        L_0x01c9:
            r0 = 0
        L_0x01ca:
            if (r3 == 0) goto L_0x01d4
            int r5 = java.lang.Math.abs(r1)
            int r7 = r6.mMinFlingVelocity
            if (r5 >= r7) goto L_0x01d5
        L_0x01d4:
            r1 = 0
        L_0x01d5:
            if (r0 != 0) goto L_0x01da
            if (r1 != 0) goto L_0x01da
            goto L_0x01ad
        L_0x01da:
            float r5 = (float) r0
            float r7 = (float) r1
            boolean r10 = r6.dispatchNestedPreFling(r5, r7)
            if (r10 != 0) goto L_0x01ad
            if (r2 != 0) goto L_0x01e9
            if (r3 == 0) goto L_0x01e7
            goto L_0x01e9
        L_0x01e7:
            r10 = 0
            goto L_0x01ea
        L_0x01e9:
            r10 = 1
        L_0x01ea:
            r6.dispatchNestedFling(r5, r7, r10)
            androidx.recyclerview.widget.RecyclerView$OnFlingListener r5 = r6.mOnFlingListener
            if (r5 == 0) goto L_0x023c
            androidx.recyclerview.widget.SnapHelper r5 = (androidx.recyclerview.widget.SnapHelper) r5
            androidx.recyclerview.widget.RecyclerView r7 = r5.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = r7.getLayoutManager()
            if (r7 != 0) goto L_0x01fc
            goto L_0x0237
        L_0x01fc:
            androidx.recyclerview.widget.RecyclerView r11 = r5.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$Adapter r11 = r11.getAdapter()
            if (r11 != 0) goto L_0x0205
            goto L_0x0237
        L_0x0205:
            androidx.recyclerview.widget.RecyclerView r11 = r5.mRecyclerView
            int r11 = r11.getMinFlingVelocity()
            int r13 = java.lang.Math.abs(r1)
            if (r13 > r11) goto L_0x0217
            int r13 = java.lang.Math.abs(r0)
            if (r13 <= r11) goto L_0x0237
        L_0x0217:
            boolean r11 = r7 instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
            if (r11 != 0) goto L_0x021c
            goto L_0x022a
        L_0x021c:
            androidx.recyclerview.widget.RecyclerView$SmoothScroller r11 = r5.createScroller(r7)
            if (r11 != 0) goto L_0x0223
            goto L_0x022a
        L_0x0223:
            int r5 = r5.findTargetSnapPosition(r7, r0, r1)
            r13 = -1
            if (r5 != r13) goto L_0x022c
        L_0x022a:
            r5 = 0
            goto L_0x0233
        L_0x022c:
            r11.setTargetPosition(r5)
            r7.startSmoothScroll(r11)
            r5 = 1
        L_0x0233:
            if (r5 == 0) goto L_0x0237
            r5 = 1
            goto L_0x0238
        L_0x0237:
            r5 = 0
        L_0x0238:
            if (r5 == 0) goto L_0x023c
        L_0x023a:
            r0 = 1
            goto L_0x0292
        L_0x023c:
            if (r10 == 0) goto L_0x01ad
            if (r3 == 0) goto L_0x0242
            r2 = r2 | 2
        L_0x0242:
            r6.startNestedScroll(r2, r9)
            int r2 = r6.mMaxFlingVelocity
            int r3 = -r2
            int r0 = java.lang.Math.min(r0, r2)
            int r16 = java.lang.Math.max(r3, r0)
            int r0 = r6.mMaxFlingVelocity
            int r2 = -r0
            int r0 = java.lang.Math.min(r1, r0)
            int r17 = java.lang.Math.max(r2, r0)
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r0 = r6.mViewFlinger
            androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
            r1.setScrollState(r4)
            r0.mLastFlingY = r8
            r0.mLastFlingX = r8
            android.view.animation.Interpolator r1 = r0.mInterpolator
            android.view.animation.Interpolator r2 = sQuinticInterpolator
            if (r1 == r2) goto L_0x027d
            r0.mInterpolator = r2
            android.widget.OverScroller r1 = new android.widget.OverScroller
            androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
            android.content.Context r2 = r2.getContext()
            android.view.animation.Interpolator r3 = sQuinticInterpolator
            r1.<init>(r2, r3)
            r0.mOverScroller = r1
        L_0x027d:
            android.widget.OverScroller r13 = r0.mOverScroller
            r14 = 0
            r15 = 0
            r18 = -2147483648(0xffffffff80000000, float:-0.0)
            r19 = 2147483647(0x7fffffff, float:NaN)
            r20 = -2147483648(0xffffffff80000000, float:-0.0)
            r21 = 2147483647(0x7fffffff, float:NaN)
            r13.fling(r14, r15, r16, r17, r18, r19, r20, r21)
            r0.postOnAnimation()
            goto L_0x023a
        L_0x0292:
            if (r0 != 0) goto L_0x0297
        L_0x0294:
            r6.setScrollState(r8)
        L_0x0297:
            r22.resetScroll()
            r8 = 1
            goto L_0x02c2
        L_0x029c:
            int r0 = r7.getPointerId(r8)
            r6.mScrollPointerId = r0
            float r0 = r23.getX()
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r23.getY()
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            if (r10 == 0) goto L_0x02ba
            r0 = 1
            goto L_0x02bb
        L_0x02ba:
            r0 = 0
        L_0x02bb:
            if (r11 == 0) goto L_0x02bf
            r0 = r0 | 2
        L_0x02bf:
            r6.startNestedScroll(r0, r8)
        L_0x02c2:
            if (r8 != 0) goto L_0x02c9
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
        L_0x02c9:
            r12.recycle()
            return r9
        L_0x02cd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    public final void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z = false;
        if (this.mDataSetHasChangedAfterLayout) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
            adapterHelper.mExistingUpdateTypes = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.mRunSimpleAnimations = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        State state = this.mState;
        if (state.mRunSimpleAnimations && z2 && !this.mDataSetHasChangedAfterLayout) {
            if (this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
                z = true;
            }
        }
        state.mRunPredictiveAnimations = z;
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        Recycler recycler = this.mRecycler;
        int size = recycler.mCachedViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewHolder viewHolder = recycler.mCachedViews.get(i2);
            if (viewHolder != null) {
                viewHolder.addFlags(6);
                viewHolder.addChangePayload(null);
            }
        }
        Adapter adapter = RecyclerView.this.mAdapter;
        if (adapter == null || !adapter.hasStableIds()) {
            recycler.recycleAndClearCachedViews();
        }
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.mOldChangedHolders.put(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.clear();
    }

    public void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(this, sb));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public final void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public final void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && !this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scrollByInternal(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
            r17 = this;
            r8 = r17
            r9 = r18
            r10 = r19
            r17.consumePendingUpdateOperations()
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r8.mAdapter
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L_0x0028
            int[] r0 = r8.mReusableIntPair
            r0[r12] = r12
            r0[r11] = r12
            r8.scrollStep(r9, r10, r0)
            int[] r0 = r8.mReusableIntPair
            r1 = r0[r12]
            r0 = r0[r11]
            int r2 = r9 - r1
            int r3 = r10 - r0
            r13 = r0
            r14 = r1
            r15 = r2
            r16 = r3
            goto L_0x002d
        L_0x0028:
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x002d:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ItemDecoration> r0 = r8.mItemDecorations
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0038
            r17.invalidate()
        L_0x0038:
            int[] r7 = r8.mReusableIntPair
            r7[r12] = r12
            r7[r11] = r12
            int[] r5 = r8.mScrollOffset
            r0 = r17
            r1 = r14
            r2 = r13
            r3 = r15
            r4 = r16
            r6 = r21
            r0.dispatchNestedScroll(r1, r2, r3, r4, r5, r6, r7)
            int[] r0 = r8.mReusableIntPair
            r1 = r0[r12]
            int r15 = r15 - r1
            r1 = r0[r11]
            int r1 = r16 - r1
            r2 = r0[r12]
            if (r2 != 0) goto L_0x0060
            r0 = r0[r11]
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r0 = 0
            goto L_0x0061
        L_0x0060:
            r0 = 1
        L_0x0061:
            int r2 = r8.mLastTouchX
            int[] r3 = r8.mScrollOffset
            r4 = r3[r12]
            int r2 = r2 - r4
            r8.mLastTouchX = r2
            int r2 = r8.mLastTouchY
            r4 = r3[r11]
            int r2 = r2 - r4
            r8.mLastTouchY = r2
            int[] r2 = r8.mNestedOffsets
            r4 = r2[r12]
            r5 = r3[r12]
            int r4 = r4 + r5
            r2[r12] = r4
            r4 = r2[r11]
            r3 = r3[r11]
            int r4 = r4 + r3
            r2[r11] = r4
            int r2 = r17.getOverScrollMode()
            r3 = 2
            if (r2 == r3) goto L_0x0122
            if (r20 == 0) goto L_0x011f
            r2 = 8194(0x2002, float:1.1482E-41)
            int r3 = r20.getSource()
            r3 = r3 & r2
            if (r3 != r2) goto L_0x0095
            r2 = 1
            goto L_0x0096
        L_0x0095:
            r2 = 0
        L_0x0096:
            if (r2 != 0) goto L_0x011f
            float r2 = r20.getX()
            float r3 = (float) r15
            float r4 = r20.getY()
            float r1 = (float) r1
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x00c1
            r17.ensureLeftGlow()
            android.widget.EdgeEffect r7 = r8.mLeftGlow
            float r15 = -r3
            int r11 = r17.getWidth()
            float r11 = (float) r11
            float r15 = r15 / r11
            int r11 = r17.getHeight()
            float r11 = (float) r11
            float r4 = r4 / r11
            float r4 = r5 - r4
            r7.onPull(r15, r4)
            goto L_0x00da
        L_0x00c1:
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x00dc
            r17.ensureRightGlow()
            android.widget.EdgeEffect r7 = r8.mRightGlow
            int r11 = r17.getWidth()
            float r11 = (float) r11
            float r11 = r3 / r11
            int r15 = r17.getHeight()
            float r15 = (float) r15
            float r4 = r4 / r15
            r7.onPull(r11, r4)
        L_0x00da:
            r4 = 1
            goto L_0x00dd
        L_0x00dc:
            r4 = 0
        L_0x00dd:
            int r7 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f7
            r17.ensureTopGlow()
            android.widget.EdgeEffect r4 = r8.mTopGlow
            float r5 = -r1
            int r7 = r17.getHeight()
            float r7 = (float) r7
            float r5 = r5 / r7
            int r7 = r17.getWidth()
            float r7 = (float) r7
            float r2 = r2 / r7
            r4.onPull(r5, r2)
            goto L_0x0111
        L_0x00f7:
            int r7 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x0112
            r17.ensureBottomGlow()
            android.widget.EdgeEffect r4 = r8.mBottomGlow
            int r7 = r17.getHeight()
            float r7 = (float) r7
            float r7 = r1 / r7
            int r11 = r17.getWidth()
            float r11 = (float) r11
            float r2 = r2 / r11
            float r5 = r5 - r2
            r4.onPull(r7, r5)
        L_0x0111:
            r4 = 1
        L_0x0112:
            if (r4 != 0) goto L_0x011c
            int r2 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x011c
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x011f
        L_0x011c:
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r17)
        L_0x011f:
            r17.considerReleasingGlowsOnScroll(r18, r19)
        L_0x0122:
            if (r14 != 0) goto L_0x0126
            if (r13 == 0) goto L_0x0129
        L_0x0126:
            r8.dispatchOnScrolled(r14, r13)
        L_0x0129:
            boolean r1 = r17.awakenScrollBars()
            if (r1 != 0) goto L_0x0132
            r17.invalidate()
        L_0x0132:
            if (r0 != 0) goto L_0x013b
            if (r14 != 0) goto L_0x013b
            if (r13 == 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r11 = 0
            goto L_0x013c
        L_0x013b:
            r11 = 1
        L_0x013c:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.scrollByInternal(int, int, android.view.MotionEvent, int):boolean");
    }

    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection("RV Scroll");
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        Trace.endSection();
        int childCount = this.mChildHelper.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mChildHelper.getChildAt(i3);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null) {
                ViewHolder viewHolder = childViewHolder.mShadowingHolder;
                if (viewHolder != null) {
                    View view = viewHolder.itemView;
                    int left = childAt.getLeft();
                    int top = childAt.getTop();
                    if (left != view.getLeft() || top != view.getTop()) {
                        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                    }
                }
            }
        }
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.scrollToPosition(i);
                awakenScrollBars();
            }
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (isComputingLayout()) {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            if (contentChangeTypes != 0) {
                i = contentChangeTypes;
            }
            this.mEatenAccessibilityChangeFlags |= i;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        removeAndRecycleViews();
        AdapterHelper adapterHelper = this.mAdapterHelper;
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
        adapterHelper.mExistingUpdateTypes = 0;
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        Recycler recycler = this.mRecycler;
        Adapter adapter4 = this.mAdapter;
        recycler.clear();
        RecycledViewPool recycledViewPool = recycler.getRecycledViewPool();
        if (recycledViewPool != null) {
            if (adapter3 != null) {
                recycledViewPool.mAttachCount--;
            }
            if (recycledViewPool.mAttachCount == 0) {
                for (int i = 0; i < recycledViewPool.mScrap.size(); i++) {
                    recycledViewPool.mScrap.valueAt(i).mScrapHeap.clear();
                }
            }
            if (adapter4 != null) {
                recycledViewPool.mAttachCount++;
            }
            this.mState.mStructureChanged = true;
            processDataSetCompletelyChanged(false);
            requestLayout();
            return;
        }
        throw null;
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
        }
    }

    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
        return true;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        if (edgeEffectFactory != null) {
            this.mEdgeEffectFactory = edgeEffectFactory;
            invalidateGlows();
            return;
        }
        throw null;
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.mListener = null;
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.mListener = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i) {
        Recycler recycler = this.mRecycler;
        recycler.mRequestedCacheMax = i;
        recycler.updateViewCacheSize();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                ItemAnimator itemAnimator = this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.endAnimations();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.clear();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
                this.mLayout = null;
            } else {
                this.mRecycler.clear();
            }
            ChildHelper childHelper = this.mChildHelper;
            Bucket bucket = childHelper.mBucket;
            bucket.mData = 0;
            Bucket bucket2 = bucket.mNext;
            if (bucket2 != null) {
                bucket2.reset();
            }
            int size = childHelper.mHiddenViews.size();
            while (true) {
                size--;
                if (size >= 0) {
                    ChildHelper.Callback callback = childHelper.mCallback;
                    View view = childHelper.mHiddenViews.get(size);
                    AnonymousClass5 r3 = (AnonymousClass5) callback;
                    if (r3 != null) {
                        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
                        if (childViewHolderInt != null) {
                            childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                        }
                        childHelper.mHiddenViews.remove(size);
                    } else {
                        throw null;
                    }
                } else {
                    AnonymousClass5 r0 = (AnonymousClass5) childHelper.mCallback;
                    int childCount = r0.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = r0.getChildAt(i);
                        RecyclerView.this.dispatchChildDetached(childAt);
                        childAt.clearAnimation();
                    }
                    RecyclerView.this.removeAllViews();
                    this.mLayout = layoutManager;
                    if (layoutManager != null) {
                        if (layoutManager.mRecyclerView == null) {
                            layoutManager.setRecyclerView(this);
                            if (this.mIsAttached) {
                                this.mLayout.dispatchAttachedToWindow(this);
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("LayoutManager ");
                            sb.append(layoutManager);
                            sb.append(" is already attached to a RecyclerView:");
                            throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(layoutManager.mRecyclerView, sb));
                        }
                    }
                    this.mRecycler.updateViewCacheSize();
                    requestLayout();
                    return;
                }
            }
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(scrollingChildHelper.mView);
        }
        scrollingChildHelper.mIsNestedScrollingEnabled = z;
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        Recycler recycler = this.mRecycler;
        if (recycler.mRecyclerPool != null) {
            r1.mAttachCount--;
        }
        recycler.mRecyclerPool = recycledViewPool;
        if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
            recycler.mRecyclerPool.mAttachCount++;
        }
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                this.mViewFlinger.stop();
                LayoutManager layoutManager = this.mLayout;
                if (layoutManager != null) {
                    layoutManager.stopSmoothScroller();
                }
            }
            LayoutManager layoutManager2 = this.mLayout;
            if (layoutManager2 != null) {
                layoutManager2.onScrollStateChanged(i);
            }
            onScrollStateChanged();
            OnScrollListener onScrollListener = this.mScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i);
            }
            List<OnScrollListener> list = this.mScrollListeners;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    this.mScrollListeners.get(size).onScrollStateChanged(this, i);
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 1) {
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else {
            this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && !this.mLayoutSuppressed) {
            int i4 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (!(i == 0 && i2 == 0)) {
                if (i3 == Integer.MIN_VALUE || i3 > 0) {
                    if (z) {
                        if (i != 0) {
                            i4 = 1;
                        }
                        if (i2 != 0) {
                            i4 |= 2;
                        }
                        startNestedScroll(i4, 1);
                    }
                    this.mViewFlinger.smoothScrollBy(i, i2, i3, interpolator);
                } else {
                    scrollBy(i, i2);
                }
            }
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.smoothScrollToPosition(this, this.mState, i);
            }
        }
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i, 0);
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll(0);
    }

    public void stopScroll() {
        setScrollState(0);
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        float f2;
        TypedArray typedArray;
        char c2;
        ClassLoader classLoader;
        Object[] objArr;
        Constructor<? extends U> constructor;
        NoSuchMethodException noSuchMethodException;
        // Context context2 = context;
        // AttributeSet attributeSet2 = attributeSet;
        // int i2 = i;
        super(context, attributeSet, i);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() {
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    if (!recyclerView2.mIsAttached) {
                        recyclerView2.requestLayout();
                    } else if (recyclerView2.mLayoutSuppressed) {
                        recyclerView2.mLayoutWasDefered = true;
                    } else {
                        recyclerView2.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (itemAnimator != null) {
                    DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
                    boolean z = !defaultItemAnimator.mPendingRemovals.isEmpty();
                    boolean z2 = !defaultItemAnimator.mPendingMoves.isEmpty();
                    boolean z3 = !defaultItemAnimator.mPendingChanges.isEmpty();
                    boolean z4 = !defaultItemAnimator.mPendingAdditions.isEmpty();
                    if (z || z2 || z4 || z3) {
                        Iterator<ViewHolder> it = defaultItemAnimator.mPendingRemovals.iterator();
                        while (it.hasNext()) {
                            ViewHolder next = it.next();
                            View view = next.itemView;
                            ViewPropertyAnimator animate = view.animate();
                            defaultItemAnimator.mRemoveAnimations.add(next);
                            animate.setDuration(defaultItemAnimator.mRemoveDuration).alpha(0.0f).setListener(new AnimatorListenerAdapter(next, animate, view) {
                                public final /* synthetic */ ViewPropertyAnimator val$animation;
                                public final /* synthetic */ ViewHolder val$holder;
                                public final /* synthetic */ View val$view;

                                {
                                    this.val$holder = r2;
                                    this.val$animation = r3;
                                    this.val$view = r4;
                                }

                                public void onAnimationEnd(Animator animator) {
                                    this.val$animation.setListener(null);
                                    this.val$view.setAlpha(1.0f);
                                    DefaultItemAnimator.this.dispatchAnimationFinished(this.val$holder);
                                    DefaultItemAnimator.this.mRemoveAnimations.remove(this.val$holder);
                                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                                }

                                public void onAnimationStart(Animator animator) {
                                    if (DefaultItemAnimator.this == null) {
                                        throw null;
                                    }
                                }
                            }).start();
                        }
                        defaultItemAnimator.mPendingRemovals.clear();
                        if (z2) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(defaultItemAnimator.mPendingMoves);
                            defaultItemAnimator.mMovesList.add(arrayList);
                            defaultItemAnimator.mPendingMoves.clear();
                            androidx.recyclerview.widget.DefaultItemAnimator.AnonymousClass1 r7 = new Runnable(arrayList) {
                                public final /* synthetic */ ArrayList val$moves;

                                {
                                    this.val$moves = r2;
                                }

                                public void run() {
                                    Iterator it = this.val$moves.iterator();
                                    while (it.hasNext()) {
                                        MoveInfo moveInfo = (MoveInfo) it.next();
                                        DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                                        ViewHolder viewHolder = moveInfo.holder;
                                        int i = moveInfo.fromX;
                                        int i2 = moveInfo.fromY;
                                        int i3 = moveInfo.toX;
                                        int i4 = moveInfo.toY;
                                        if (defaultItemAnimator != null) {
                                            View view = viewHolder.itemView;
                                            int i5 = i3 - i;
                                            int i6 = i4 - i2;
                                            if (i5 != 0) {
                                                view.animate().translationX(0.0f);
                                            }
                                            if (i6 != 0) {
                                                view.animate().translationY(0.0f);
                                            }
                                            ViewPropertyAnimator animate = view.animate();
                                            defaultItemAnimator.mMoveAnimations.add(viewHolder);
                                            ViewPropertyAnimator duration = animate.setDuration(defaultItemAnimator.mMoveDuration);
                                            AnonymousClass6 r2 = new AnimatorListenerAdapter(viewHolder, i5, view, i6, animate) {
                                                public final /* synthetic */ ViewPropertyAnimator val$animation;
                                                public final /* synthetic */ int val$deltaX;
                                                public final /* synthetic */ int val$deltaY;
                                                public final /* synthetic */ ViewHolder val$holder;
                                                public final /* synthetic */ View val$view;

                                                {
                                                    this.val$holder = r2;
                                                    this.val$deltaX = r3;
                                                    this.val$view = r4;
                                                    this.val$deltaY = r5;
                                                    this.val$animation = r6;
                                                }

                                                public void onAnimationCancel(Animator animator) {
                                                    if (this.val$deltaX != 0) {
                                                        this.val$view.setTranslationX(0.0f);
                                                    }
                                                    if (this.val$deltaY != 0) {
                                                        this.val$view.setTranslationY(0.0f);
                                                    }
                                                }

                                                public void onAnimationEnd(Animator animator) {
                                                    this.val$animation.setListener(null);
                                                    DefaultItemAnimator.this.dispatchAnimationFinished(this.val$holder);
                                                    DefaultItemAnimator.this.mMoveAnimations.remove(this.val$holder);
                                                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                                                }

                                                public void onAnimationStart(Animator animator) {
                                                    if (DefaultItemAnimator.this == null) {
                                                        throw null;
                                                    }
                                                }
                                            };
                                            duration.setListener(r2).start();
                                        } else {
                                            throw null;
                                        }
                                    }
                                    this.val$moves.clear();
                                    DefaultItemAnimator.this.mMovesList.remove(this.val$moves);
                                }
                            };
                            if (z) {
                                ViewCompat.postOnAnimationDelayed(((MoveInfo) arrayList.get(0)).holder.itemView, r7, defaultItemAnimator.mRemoveDuration);
                            } else {
                                r7.run();
                            }
                        }
                        if (z3) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(defaultItemAnimator.mPendingChanges);
                            defaultItemAnimator.mChangesList.add(arrayList2);
                            defaultItemAnimator.mPendingChanges.clear();
                            androidx.recyclerview.widget.DefaultItemAnimator.AnonymousClass2 r72 = new Runnable(arrayList2) {
                                public final /* synthetic */ ArrayList val$changes;

                                {
                                    this.val$changes = r2;
                                }

                                public void run() {
                                    View view;
                                    Iterator it = this.val$changes.iterator();
                                    while (it.hasNext()) {
                                        ChangeInfo changeInfo = (ChangeInfo) it.next();
                                        DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                                        View view2 = null;
                                        if (defaultItemAnimator != null) {
                                            ViewHolder viewHolder = changeInfo.oldHolder;
                                            if (viewHolder == null) {
                                                view = null;
                                            } else {
                                                view = viewHolder.itemView;
                                            }
                                            ViewHolder viewHolder2 = changeInfo.newHolder;
                                            if (viewHolder2 != null) {
                                                view2 = viewHolder2.itemView;
                                            }
                                            if (view != null) {
                                                ViewPropertyAnimator duration = view.animate().setDuration(defaultItemAnimator.mChangeDuration);
                                                defaultItemAnimator.mChangeAnimations.add(changeInfo.oldHolder);
                                                duration.translationX((float) (changeInfo.toX - changeInfo.fromX));
                                                duration.translationY((float) (changeInfo.toY - changeInfo.fromY));
                                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(changeInfo, duration, view) {
                                                    public final /* synthetic */ ChangeInfo val$changeInfo;
                                                    public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                                                    public final /* synthetic */ View val$view;

                                                    {
                                                        this.val$changeInfo = r2;
                                                        this.val$oldViewAnim = r3;
                                                        this.val$view = r4;
                                                    }

                                                    public void onAnimationEnd(Animator animator) {
                                                        this.val$oldViewAnim.setListener(null);
                                                        this.val$view.setAlpha(1.0f);
                                                        this.val$view.setTranslationX(0.0f);
                                                        this.val$view.setTranslationY(0.0f);
                                                        DefaultItemAnimator.this.dispatchAnimationFinished(this.val$changeInfo.oldHolder);
                                                        DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.oldHolder);
                                                        DefaultItemAnimator.this.dispatchFinishedWhenDone();
                                                    }

                                                    public void onAnimationStart(Animator animator) {
                                                        DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                                                        ViewHolder viewHolder = this.val$changeInfo.oldHolder;
                                                        if (defaultItemAnimator == null) {
                                                            throw null;
                                                        }
                                                    }
                                                }).start();
                                            }
                                            if (view2 != null) {
                                                ViewPropertyAnimator animate = view2.animate();
                                                defaultItemAnimator.mChangeAnimations.add(changeInfo.newHolder);
                                                animate.translationX(0.0f).translationY(0.0f).setDuration(defaultItemAnimator.mChangeDuration).alpha(1.0f).setListener(new AnimatorListenerAdapter(changeInfo, animate, view2) {
                                                    public final /* synthetic */ ChangeInfo val$changeInfo;
                                                    public final /* synthetic */ View val$newView;
                                                    public final /* synthetic */ ViewPropertyAnimator val$newViewAnimation;

                                                    {
                                                        this.val$changeInfo = r2;
                                                        this.val$newViewAnimation = r3;
                                                        this.val$newView = r4;
                                                    }

                                                    public void onAnimationEnd(Animator animator) {
                                                        this.val$newViewAnimation.setListener(null);
                                                        this.val$newView.setAlpha(1.0f);
                                                        this.val$newView.setTranslationX(0.0f);
                                                        this.val$newView.setTranslationY(0.0f);
                                                        DefaultItemAnimator.this.dispatchAnimationFinished(this.val$changeInfo.newHolder);
                                                        DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.newHolder);
                                                        DefaultItemAnimator.this.dispatchFinishedWhenDone();
                                                    }

                                                    public void onAnimationStart(Animator animator) {
                                                        DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                                                        ViewHolder viewHolder = this.val$changeInfo.newHolder;
                                                        if (defaultItemAnimator == null) {
                                                            throw null;
                                                        }
                                                    }
                                                }).start();
                                            }
                                        } else {
                                            throw null;
                                        }
                                    }
                                    this.val$changes.clear();
                                    DefaultItemAnimator.this.mChangesList.remove(this.val$changes);
                                }
                            };
                            if (z) {
                                ViewCompat.postOnAnimationDelayed(((ChangeInfo) arrayList2.get(0)).oldHolder.itemView, r72, defaultItemAnimator.mRemoveDuration);
                            } else {
                                r72.run();
                            }
                        }
                        if (z4) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.addAll(defaultItemAnimator.mPendingAdditions);
                            defaultItemAnimator.mAdditionsList.add(arrayList3);
                            defaultItemAnimator.mPendingAdditions.clear();
                            androidx.recyclerview.widget.DefaultItemAnimator.AnonymousClass3 r6 = new Runnable(arrayList3) {
                                public final /* synthetic */ ArrayList val$additions;

                                {
                                    this.val$additions = r2;
                                }

                                public void run() {
                                    Iterator it = this.val$additions.iterator();
                                    while (it.hasNext()) {
                                        ViewHolder viewHolder = (ViewHolder) it.next();
                                        DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                                        if (defaultItemAnimator != null) {
                                            View view = viewHolder.itemView;
                                            ViewPropertyAnimator animate = view.animate();
                                            defaultItemAnimator.mAddAnimations.add(viewHolder);
                                            animate.alpha(1.0f).setDuration(defaultItemAnimator.mAddDuration).setListener(new AnimatorListenerAdapter(viewHolder, view, animate) {
                                                public final /* synthetic */ ViewPropertyAnimator val$animation;
                                                public final /* synthetic */ ViewHolder val$holder;
                                                public final /* synthetic */ View val$view;

                                                {
                                                    this.val$holder = r2;
                                                    this.val$view = r3;
                                                    this.val$animation = r4;
                                                }

                                                public void onAnimationCancel(Animator animator) {
                                                    this.val$view.setAlpha(1.0f);
                                                }

                                                public void onAnimationEnd(Animator animator) {
                                                    this.val$animation.setListener(null);
                                                    DefaultItemAnimator.this.dispatchAnimationFinished(this.val$holder);
                                                    DefaultItemAnimator.this.mAddAnimations.remove(this.val$holder);
                                                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                                                }

                                                public void onAnimationStart(Animator animator) {
                                                    if (DefaultItemAnimator.this == null) {
                                                        throw null;
                                                    }
                                                }
                                            }).start();
                                        } else {
                                            throw null;
                                        }
                                    }
                                    this.val$additions.clear();
                                    DefaultItemAnimator.this.mAdditionsList.remove(this.val$additions);
                                }
                            };
                            if (z || z2 || z3) {
                                long j = 0;
                                long j2 = z ? defaultItemAnimator.mRemoveDuration : 0;
                                long j3 = z2 ? defaultItemAnimator.mMoveDuration : 0;
                                if (z3) {
                                    j = defaultItemAnimator.mChangeDuration;
                                }
                                ViewCompat.postOnAnimationDelayed(((ViewHolder) arrayList3.get(0)).itemView, r6, Math.max(j3, j) + j2);
                            } else {
                                r6.run();
                            }
                        }
                    }
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new ProcessCallback() {
            public void processAppeared(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
                boolean z;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView != null) {
                    viewHolder.setIsRecyclable(false);
                    SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView.mItemAnimator;
                    if (simpleItemAnimator != null) {
                        if (itemHolderInfo == null || (itemHolderInfo.left == itemHolderInfo2.left && itemHolderInfo.top == itemHolderInfo2.top)) {
                            DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) simpleItemAnimator;
                            defaultItemAnimator.resetAnimation(viewHolder);
                            viewHolder.itemView.setAlpha(0.0f);
                            defaultItemAnimator.mPendingAdditions.add(viewHolder);
                            z = true;
                        } else {
                            z = simpleItemAnimator.animateMove(viewHolder, itemHolderInfo.left, itemHolderInfo.top, itemHolderInfo2.left, itemHolderInfo2.top);
                        }
                        if (z) {
                            recyclerView.postAnimationRunner();
                            return;
                        }
                        return;
                    }
                    throw null;
                }
                throw null;
            }

            public void processDisappeared(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
                boolean z;
                RecyclerView.this.mRecycler.unscrapView(viewHolder);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.addAnimatingView(viewHolder);
                viewHolder.setIsRecyclable(false);
                SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView.mItemAnimator;
                if (simpleItemAnimator != null) {
                    int i = itemHolderInfo.left;
                    int i2 = itemHolderInfo.top;
                    View view = viewHolder.itemView;
                    int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.left;
                    int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.top;
                    if (viewHolder.isRemoved() || (i == left && i2 == top)) {
                        DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) simpleItemAnimator;
                        defaultItemAnimator.resetAnimation(viewHolder);
                        defaultItemAnimator.mPendingRemovals.add(viewHolder);
                        z = true;
                    } else {
                        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                        z = simpleItemAnimator.animateMove(viewHolder, i, i2, left, top);
                    }
                    if (z) {
                        recyclerView.postAnimationRunner();
                        return;
                    }
                    return;
                }
                throw null;
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context2);
        if (VERSION.SDK_INT >= 26) {
            f2 = viewConfiguration.getScaledVerticalScrollFactor();
        } else {
            f2 = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context2);
        }
        this.mScaledVerticalScrollFactor = f2;
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.mListener = this.mItemAnimatorListener;
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {
            public void dispatchUpdate(UpdateOp updateOp) {
                int i = updateOp.cmd;
                if (i == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
                } else if (i == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.mLayout.onItemsRemoved(recyclerView2, updateOp.positionStart, updateOp.itemCount);
                } else if (i == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.mLayout.onItemsUpdated(recyclerView3, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                } else if (i == 8) {
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.mLayout.onItemsMoved(recyclerView4, updateOp.positionStart, updateOp.itemCount, 1);
                }
            }

            public ViewHolder findViewHolder(int i) {
                RecyclerView recyclerView = RecyclerView.this;
                int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
                int i2 = 0;
                ViewHolder viewHolder = null;
                while (true) {
                    if (i2 >= unfilteredChildCount) {
                        break;
                    }
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
                    if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.mPosition == i) {
                        if (!recyclerView.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                            viewHolder = childViewHolderInt;
                            break;
                        }
                        viewHolder = childViewHolderInt;
                    }
                    i2++;
                }
                if (viewHolder != null && !RecyclerView.this.mChildHelper.isHidden(viewHolder.itemView)) {
                    return viewHolder;
                }
                return null;
            }

            public void markViewHoldersUpdated(int i, int i2, Object obj) {
                RecyclerView recyclerView = RecyclerView.this;
                int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
                int i3 = i2 + i;
                for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
                    View unfilteredChildAt = recyclerView.mChildHelper.getUnfilteredChildAt(i4);
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(unfilteredChildAt);
                    if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                        int i5 = childViewHolderInt.mPosition;
                        if (i5 >= i && i5 < i3) {
                            childViewHolderInt.addFlags(2);
                            childViewHolderInt.addChangePayload(obj);
                            ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
                        }
                    }
                }
                Recycler recycler = recyclerView.mRecycler;
                int size = recycler.mCachedViews.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        ViewHolder viewHolder = recycler.mCachedViews.get(size);
                        if (viewHolder != null) {
                            int i6 = viewHolder.mPosition;
                            if (i6 >= i && i6 < i3) {
                                viewHolder.addFlags(2);
                                recycler.recycleCachedViewAt(size);
                            }
                        }
                    } else {
                        RecyclerView.this.mItemsChanged = true;
                        return;
                    }
                }
            }

            public void offsetPositionsForAdd(int i, int i2) {
                RecyclerView recyclerView = RecyclerView.this;
                int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
                for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i3));
                    if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                        childViewHolderInt.offsetPosition(i2, false);
                        recyclerView.mState.mStructureChanged = true;
                    }
                }
                Recycler recycler = recyclerView.mRecycler;
                int size = recycler.mCachedViews.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ViewHolder viewHolder = recycler.mCachedViews.get(i4);
                    if (viewHolder != null && viewHolder.mPosition >= i) {
                        viewHolder.offsetPosition(i2, false);
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForMove(int i, int i2) {
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                RecyclerView recyclerView = RecyclerView.this;
                int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
                int i8 = -1;
                if (i < i2) {
                    i5 = i;
                    i4 = i2;
                    i3 = -1;
                } else {
                    i4 = i;
                    i5 = i2;
                    i3 = 1;
                }
                for (int i9 = 0; i9 < unfilteredChildCount; i9++) {
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i9));
                    if (childViewHolderInt != null) {
                        int i10 = childViewHolderInt.mPosition;
                        if (i10 >= i5 && i10 <= i4) {
                            if (i10 == i) {
                                childViewHolderInt.offsetPosition(i2 - i, false);
                            } else {
                                childViewHolderInt.offsetPosition(i3, false);
                            }
                            recyclerView.mState.mStructureChanged = true;
                        }
                    }
                }
                Recycler recycler = recyclerView.mRecycler;
                if (i < i2) {
                    i7 = i;
                    i6 = i2;
                } else {
                    i6 = i;
                    i7 = i2;
                    i8 = 1;
                }
                int size = recycler.mCachedViews.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ViewHolder viewHolder = recycler.mCachedViews.get(i11);
                    if (viewHolder != null) {
                        int i12 = viewHolder.mPosition;
                        if (i12 >= i7 && i12 <= i6) {
                            if (i12 == i) {
                                viewHolder.offsetPosition(i2 - i, false);
                            } else {
                                viewHolder.offsetPosition(i8, false);
                            }
                        }
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() {
            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }
        });
        if (ViewCompat.getImportantForAutofill(this) == 0 && VERSION.SDK_INT >= 26) {
            setImportantForAutofill(8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, R$styleable.RecyclerView, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.RecyclerView, attributeSet, obtainStyledAttributes, i, 0);
        String string = obtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z;
        if (z) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(this, GeneratedOutlineSupport.outline73("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c2 = 2;
            typedArray = obtainStyledAttributes;
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
        } else {
            typedArray = obtainStyledAttributes;
            c2 = 2;
        }
        typedArray.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                String str = trim;
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(str, false, classLoader).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[4];
                        objArr[0] = context2;
                        objArr[1] = attributeSet2;
                        objArr[c2] = Integer.valueOf(i);
                        objArr[3] = Integer.valueOf(0);
                    } catch (NoSuchMethodException e2) {
                        noSuchMethodException = e2;
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(noSuchMethodException);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e8);
                }
            }
        }
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet2, NESTED_SCROLLING_ATTRS, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i, 0);
        boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline33(this, GeneratedOutlineSupport.outline73("RecyclerView has no LayoutManager")));
    }
}
