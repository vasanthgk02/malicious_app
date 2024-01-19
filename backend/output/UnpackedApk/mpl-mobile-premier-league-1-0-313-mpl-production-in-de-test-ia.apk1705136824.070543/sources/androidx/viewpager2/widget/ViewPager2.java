package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.ScrollEventAdapter.ScrollEventValues;
import java.util.ArrayList;

public final class ViewPager2 extends ViewGroup {
    public AccessibilityProvider mAccessibilityProvider;
    public int mCurrentItem;
    public AdapterDataObserver mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() {
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.mCurrentItemDirty = true;
            viewPager2.mScrollEventAdapter.mDataSetChangeHappened = true;
        }
    };
    public boolean mCurrentItemDirty = false;
    public CompositeOnPageChangeCallback mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
    public FakeDrag mFakeDragger;
    public LinearLayoutManager mLayoutManager;
    public int mOffscreenPageLimit = -1;
    public CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    public PageTransformerAdapter mPageTransformerAdapter;
    public PagerSnapHelper mPagerSnapHelper;
    public Parcelable mPendingAdapterState;
    public int mPendingCurrentItem = -1;
    public RecyclerView mRecyclerView;
    public ItemAnimator mSavedItemAnimator = null;
    public boolean mSavedItemAnimatorPresent = false;
    public ScrollEventAdapter mScrollEventAdapter;
    public final Rect mTmpChildRect = new Rect();
    public final Rect mTmpContainerRect = new Rect();
    public boolean mUserInputEnabled = true;

    public abstract class AccessibilityProvider {
        public AccessibilityProvider(AnonymousClass1 r2) {
        }

        public abstract boolean handlesGetAccessibilityClassName();

        public boolean handlesLmPerformAccessibilityAction(int i) {
            return false;
        }

        public abstract boolean handlesPerformAccessibilityAction(int i, Bundle bundle);

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public abstract void onAttachAdapter(Adapter<?> adapter);

        public abstract void onDetachAdapter(Adapter<?> adapter);

        public abstract String onGetAccessibilityClassName();

        public abstract void onInitialize(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView);

        public abstract void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo);

        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean onLmPerformAccessibilityAction(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        public abstract boolean onPerformAccessibilityAction(int i, Bundle bundle);

        public abstract void onRestorePendingState();

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public abstract void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        public abstract void onSetLayoutDirection();

        public abstract void onSetNewCurrentItem();

        public abstract void onSetOrientation();

        public abstract void onSetUserInputEnabled();
    }

    public static abstract class DataSetChangeObserver extends AdapterDataObserver {
        public DataSetChangeObserver(AnonymousClass1 r1) {
        }

        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        public void calculateExtraLayoutSpace(State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int i, Bundle bundle) {
            if (ViewPager2.this.mAccessibilityProvider.handlesLmPerformAccessibilityAction(i)) {
                return ViewPager2.this.mAccessibilityProvider.onLmPerformAccessibilityAction(i);
            }
            return super.performAccessibilityAction(recycler, state, i, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f2, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    public class PageAwareAccessibilityProvider extends AccessibilityProvider {
        public final AccessibilityViewCommand mActionPageBackward = new AccessibilityViewCommand() {
            public boolean perform(View view, CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };
        public final AccessibilityViewCommand mActionPageForward = new AccessibilityViewCommand() {
            public boolean perform(View view, CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };
        public AdapterDataObserver mAdapterDataObserver;

        public PageAwareAccessibilityProvider() {
            super(null);
        }

        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        public boolean handlesPerformAccessibilityAction(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        public void onAttachAdapter(Adapter<?> adapter) {
            updatePageAccessibilityActions();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        public void onDetachAdapter(Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        public String onGetAccessibilityClassName() {
            return "androidx.viewpager.widget.ViewPager";
        }

        public void onInitialize(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
            ViewCompat.setImportantForAccessibility(recyclerView, 2);
            this.mAdapterDataObserver = new DataSetChangeObserver() {
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.updatePageAccessibilityActions();
                }
            };
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo r5) {
            /*
                r4 = this;
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x002a
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                int r0 = r0.getOrientation()
                if (r0 != r1) goto L_0x001d
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                int r0 = r0.getItemCount()
                goto L_0x002b
            L_0x001d:
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                int r0 = r0.getItemCount()
                r3 = r0
                r0 = 0
                goto L_0x002c
            L_0x002a:
                r0 = 0
            L_0x002b:
                r3 = 0
            L_0x002c:
                androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat r0 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r0, r3, r2, r2)
                java.lang.Object r0 = r0.mInfo
                android.view.accessibility.AccessibilityNodeInfo$CollectionInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) r0
                r5.setCollectionInfo(r0)
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                if (r0 != 0) goto L_0x0040
                goto L_0x0065
            L_0x0040:
                int r0 = r0.getItemCount()
                if (r0 == 0) goto L_0x0065
                androidx.viewpager2.widget.ViewPager2 r2 = androidx.viewpager2.widget.ViewPager2.this
                boolean r3 = r2.mUserInputEnabled
                if (r3 != 0) goto L_0x004d
                goto L_0x0065
            L_0x004d:
                int r2 = r2.mCurrentItem
                if (r2 <= 0) goto L_0x0056
                r2 = 8192(0x2000, float:1.148E-41)
                r5.addAction(r2)
            L_0x0056:
                androidx.viewpager2.widget.ViewPager2 r2 = androidx.viewpager2.widget.ViewPager2.this
                int r2 = r2.mCurrentItem
                int r0 = r0 - r1
                if (r2 >= r0) goto L_0x0062
                r0 = 4096(0x1000, float:5.74E-42)
                r5.addAction(r0)
            L_0x0062:
                r5.setScrollable(r1)
            L_0x0065:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo):void");
        }

        public boolean onPerformAccessibilityAction(int i, Bundle bundle) {
            int i2;
            if (i == 8192 || i == 4096) {
                if (i == 8192) {
                    i2 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i2 = ViewPager2.this.getCurrentItem() + 1;
                }
                setCurrentItemFromAccessibilityCommand(i2);
                return true;
            }
            throw new IllegalStateException();
        }

        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        public void onSetLayoutDirection() {
            updatePageAccessibilityActions();
        }

        public void onSetNewCurrentItem() {
            updatePageAccessibilityActions();
        }

        public void onSetOrientation() {
            updatePageAccessibilityActions();
        }

        public void onSetUserInputEnabled() {
            updatePageAccessibilityActions();
        }

        public void setCurrentItemFromAccessibilityCommand(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.mUserInputEnabled) {
                viewPager2.setCurrentItemInternal(i, true);
            }
        }

        public void updatePageAccessibilityActions() {
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = 16908360;
            ViewCompat.removeAccessibilityAction(viewPager2, 16908360);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908361);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908358);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null) {
                int itemCount = ViewPager2.this.getAdapter().getItemCount();
                if (itemCount != 0) {
                    ViewPager2 viewPager22 = ViewPager2.this;
                    if (viewPager22.mUserInputEnabled) {
                        if (viewPager22.getOrientation() == 0) {
                            boolean isRtl = ViewPager2.this.isRtl();
                            int i2 = isRtl ? 16908360 : 16908361;
                            if (isRtl) {
                                i = 16908361;
                            }
                            if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityActionCompat(i2, null), null, this.mActionPageForward);
                            }
                            if (ViewPager2.this.mCurrentItem > 0) {
                                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityActionCompat(i, null), null, this.mActionPageBackward);
                            }
                        } else {
                            if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityActionCompat(16908359, null), null, this.mActionPageForward);
                            }
                            if (ViewPager2.this.mCurrentItem > 0) {
                                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityActionCompat(16908358, null), null, this.mActionPageBackward);
                            }
                        }
                    }
                }
            }
        }
    }

    public interface PageTransformer {
        void transformPage(View view, float f2);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        public View findSnapView(LayoutManager layoutManager) {
            if (ViewPager2.this.mFakeDragger.mScrollEventAdapter.mFakeDragging) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context, null);
        }

        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.mAccessibilityProvider.handlesRvGetAccessibilityClassName()) {
                return ViewPager2.this.mAccessibilityProvider.onRvGetAccessibilityClassName();
            }
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(ViewPager2.this.mCurrentItem);
            ViewPager2.this.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.mUserInputEnabled && super.onInterceptTouchEvent(motionEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.mUserInputEnabled && super.onTouchEvent(motionEvent);
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public Object createFromParcel(Parcel parcel) {
                return VERSION.SDK_INT >= 24 ? new SavedState(parcel, null) : new SavedState(parcel);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }
        };
        public Parcelable mAdapterState;
        public int mCurrentItem;
        public int mRecyclerViewId;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class SmoothScrollToPosition implements Runnable {
        public final int mPosition;
        public final RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int i, RecyclerView recyclerView) {
            this.mPosition = i;
            this.mRecyclerView = recyclerView;
        }

        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet);
    }

    public boolean canScrollHorizontally(int i) {
        return this.mRecyclerView.canScrollHorizontally(i);
    }

    public boolean canScrollVertically(int i) {
        return this.mRecyclerView.canScrollVertically(i);
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.handlesGetAccessibilityClassName()) {
            return this.mAccessibilityProvider.onGetAccessibilityClassName();
        }
        return super.getAccessibilityClassName();
    }

    public Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    public int getPageSize() {
        int i;
        int i2;
        RecyclerView recyclerView = this.mRecyclerView;
        if (getOrientation() == 0) {
            i = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i2 = recyclerView.getPaddingRight();
        } else {
            i = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i2 = recyclerView.getPaddingBottom();
        }
        return i - i2;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.mScrollState;
    }

    /* JADX INFO: finally extract failed */
    public final void initialize(Context context, AttributeSet attributeSet) {
        this.mAccessibilityProvider = new PageAwareAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.mLayoutManager = linearLayoutManagerImpl;
        this.mRecyclerView.setLayoutManager(linearLayoutManagerImpl);
        this.mRecyclerView.setScrollingTouchSlop(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewPager2);
        if (VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R$styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R$styleable.ViewPager2_android_orientation, 0));
            obtainStyledAttributes.recycle();
            this.mRecyclerView.setLayoutParams(new LayoutParams(-1, -1));
            RecyclerView recyclerView = this.mRecyclerView;
            AnonymousClass4 r0 = new OnChildAttachStateChangeListener() {
                public void onChildViewAttachedToWindow(View view) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    if (layoutParams.width != -1 || layoutParams.height != -1) {
                        throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                    }
                }

                public void onChildViewDetachedFromWindow(View view) {
                }
            };
            if (recyclerView.mOnChildAttachStateListeners == null) {
                recyclerView.mOnChildAttachStateListeners = new ArrayList();
            }
            recyclerView.mOnChildAttachStateListeners.add(r0);
            ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
            this.mScrollEventAdapter = scrollEventAdapter;
            this.mFakeDragger = new FakeDrag(this, scrollEventAdapter, this.mRecyclerView);
            PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
            this.mPagerSnapHelper = pagerSnapHelperImpl;
            pagerSnapHelperImpl.attachToRecyclerView(this.mRecyclerView);
            this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
            CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
            this.mPageChangeEventDispatcher = compositeOnPageChangeCallback;
            this.mScrollEventAdapter.mCallback = compositeOnPageChangeCallback;
            AnonymousClass2 r9 = new OnPageChangeCallback() {
                public void onPageScrollStateChanged(int i) {
                    if (i == 0) {
                        ViewPager2.this.updateCurrentItem();
                    }
                }

                public void onPageSelected(int i) {
                    ViewPager2 viewPager2 = ViewPager2.this;
                    if (viewPager2.mCurrentItem != i) {
                        viewPager2.mCurrentItem = i;
                        viewPager2.mAccessibilityProvider.onSetNewCurrentItem();
                    }
                }
            };
            AnonymousClass3 r02 = new OnPageChangeCallback() {
                public void onPageSelected(int i) {
                    ViewPager2.this.clearFocus();
                    if (ViewPager2.this.hasFocus()) {
                        ViewPager2.this.mRecyclerView.requestFocus(2);
                    }
                }
            };
            this.mPageChangeEventDispatcher.mCallbacks.add(r9);
            this.mPageChangeEventDispatcher.mCallbacks.add(r02);
            this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
            CompositeOnPageChangeCallback compositeOnPageChangeCallback2 = this.mPageChangeEventDispatcher;
            compositeOnPageChangeCallback2.mCallbacks.add(this.mExternalPageChangeCallbacks);
            PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.mLayoutManager);
            this.mPageTransformerAdapter = pageTransformerAdapter;
            this.mPageChangeEventDispatcher.mCallbacks.add(pageTransformerAdapter);
            RecyclerView recyclerView2 = this.mRecyclerView;
            attachViewToParent(recyclerView2, 0, recyclerView2.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public boolean isRtl() {
        return this.mLayoutManager.getLayoutDirection() == 1;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = getPaddingLeft();
        this.mTmpContainerRect.right = (i3 - i) - getPaddingRight();
        this.mTmpContainerRect.top = getPaddingTop();
        this.mTmpContainerRect.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mTmpChildRect;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    public void onMeasure(int i, int i2) {
        measureChild(this.mRecyclerView, i, i2);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), ViewGroup.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPendingCurrentItem = savedState.mCurrentItem;
        this.mPendingAdapterState = savedState.mAdapterState;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.mRecyclerView.getId();
        int i = this.mPendingCurrentItem;
        if (i == -1) {
            i = this.mCurrentItem;
        }
        savedState.mCurrentItem = i;
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            Adapter adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.mAdapterState = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(i, bundle)) {
            return this.mAccessibilityProvider.onPerformAccessibilityAction(i, bundle);
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public final void restorePendingState() {
        if (this.mPendingCurrentItem != -1) {
            Adapter adapter = getAdapter();
            if (adapter != null) {
                Parcelable parcelable = this.mPendingAdapterState;
                if (parcelable != null) {
                    if (adapter instanceof StatefulAdapter) {
                        ((StatefulAdapter) adapter).restoreState(parcelable);
                    }
                    this.mPendingAdapterState = null;
                }
                int max = Math.max(0, Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
                this.mCurrentItem = max;
                this.mPendingCurrentItem = -1;
                this.mRecyclerView.scrollToPosition(max);
                this.mAccessibilityProvider.onRestorePendingState();
            }
        }
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(adapter2);
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
        this.mRecyclerView.setAdapter(adapter);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void setCurrentItem(int i) {
        if (!this.mFakeDragger.mScrollEventAdapter.mFakeDragging) {
            setCurrentItemInternal(i, true);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setCurrentItemInternal(int i, boolean z) {
        Adapter adapter = getAdapter();
        boolean z2 = false;
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(i, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
            if (min == this.mCurrentItem) {
                if (this.mScrollEventAdapter.mScrollState == 0) {
                    return;
                }
            }
            if (min != this.mCurrentItem || !z) {
                double d2 = (double) this.mCurrentItem;
                this.mCurrentItem = min;
                this.mAccessibilityProvider.onSetNewCurrentItem();
                if (!(this.mScrollEventAdapter.mScrollState == 0)) {
                    ScrollEventAdapter scrollEventAdapter = this.mScrollEventAdapter;
                    scrollEventAdapter.updateScrollEventValues();
                    ScrollEventValues scrollEventValues = scrollEventAdapter.mScrollValues;
                    d2 = ((double) scrollEventValues.mPosition) + ((double) scrollEventValues.mOffset);
                }
                ScrollEventAdapter scrollEventAdapter2 = this.mScrollEventAdapter;
                scrollEventAdapter2.mAdapterState = z ? 2 : 3;
                scrollEventAdapter2.mFakeDragging = false;
                if (scrollEventAdapter2.mTarget != min) {
                    z2 = true;
                }
                scrollEventAdapter2.mTarget = min;
                scrollEventAdapter2.dispatchStateChanged(2);
                if (z2) {
                    OnPageChangeCallback onPageChangeCallback = scrollEventAdapter2.mCallback;
                    if (onPageChangeCallback != null) {
                        onPageChangeCallback.onPageSelected(min);
                    }
                }
                if (!z) {
                    this.mRecyclerView.scrollToPosition(min);
                    return;
                }
                double d3 = (double) min;
                if (Math.abs(d3 - d2) > 3.0d) {
                    this.mRecyclerView.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
                    RecyclerView recyclerView = this.mRecyclerView;
                    recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                } else {
                    this.mRecyclerView.smoothScrollToPosition(min);
                }
            }
        }
    }

    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int i) {
        if (i >= 1 || i == -1) {
            this.mOffscreenPageLimit = i;
            this.mRecyclerView.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i) {
        this.mLayoutManager.setOrientation(i);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator(null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        PageTransformerAdapter pageTransformerAdapter = this.mPageTransformerAdapter;
        if (pageTransformer != pageTransformerAdapter.mPageTransformer) {
            pageTransformerAdapter.mPageTransformer = pageTransformer;
            if (pageTransformer != null) {
                ScrollEventAdapter scrollEventAdapter = this.mScrollEventAdapter;
                scrollEventAdapter.updateScrollEventValues();
                ScrollEventValues scrollEventValues = scrollEventAdapter.mScrollValues;
                double d2 = ((double) scrollEventValues.mPosition) + ((double) scrollEventValues.mOffset);
                int i = (int) d2;
                float f2 = (float) (d2 - ((double) i));
                this.mPageTransformerAdapter.onPageScrolled(i, f2, Math.round(((float) getPageSize()) * f2));
            }
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.mUserInputEnabled = z;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void updateCurrentItem() {
        PagerSnapHelper pagerSnapHelper = this.mPagerSnapHelper;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.mLayoutManager);
            if (findSnapView != null) {
                int position = this.mLayoutManager.getPosition(findSnapView);
                if (position != this.mCurrentItem && getScrollState() == 0) {
                    this.mPageChangeEventDispatcher.onPageSelected(position);
                }
                this.mCurrentItemDirty = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet);
    }
}
