package androidx.coordinatorlayout.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sfs2x.client.entities.invitation.InvitationReply;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static final Class<?>[] CONSTRUCTOR_PARAMS = {Context.class, AttributeSet.class};
    public static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = new ThreadLocal<>();
    public static final Pools$Pool<Rect> sRectPool = new Pools$SynchronizedPool(12);
    public OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    public final int[] mBehaviorConsumed;
    public View mBehaviorTouchView;
    public final DirectedAcyclicGraph<View> mChildDag;
    public final List<View> mDependencySortedChildren;
    public boolean mDisallowInterceptReset;
    public boolean mDrawStatusBarBackground;
    public boolean mIsAttachedToWindow;
    public int[] mKeylines;
    public WindowInsetsCompat mLastInsets;
    public boolean mNeedsPreDrawListener;
    public final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public View mNestedScrollingTarget;
    public final int[] mNestedScrollingV2ConsumedCompat;
    public OnHierarchyChangeListener mOnHierarchyChangeListener;
    public OnPreDrawListener mOnPreDrawListener;
    public Paint mScrimPaint;
    public Drawable mStatusBarBackground;
    public final List<View> mTempDependenciesList;
    public final List<View> mTempList1;

    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor() {
            return -16777216;
        }

        public float getScrimOpacity() {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public WindowInsetsCompat onApplyWindowInsets(WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onAttachedToLayoutParams(LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling() {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll() {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll();
            }
        }

        @Deprecated
        public void onNestedScroll() {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            if (i5 == 0) {
                onNestedScroll();
            }
        }

        @Deprecated
        public void onNestedScrollAccepted() {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll() {
            return false;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll();
            }
            return false;
        }

        @Deprecated
        public void onStopNestedScroll() {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll();
            }
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    public class HierarchyChangeListener implements OnHierarchyChangeListener {
        public HierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int anchorGravity = 0;
        public int dodgeInsetEdges = 0;
        public int gravity = 0;
        public int insetEdge = 0;
        public int keyline = -1;
        public View mAnchorDirectChild;
        public int mAnchorId = -1;
        public View mAnchorView;
        public Behavior mBehavior;
        public boolean mBehaviorResolved = false;
        public boolean mDidAcceptNestedScrollNonTouch;
        public boolean mDidAcceptNestedScrollTouch;
        public boolean mDidBlockInteraction;
        public boolean mDidChangeAfterNestedScroll;
        public int mInsetOffsetX;
        public int mInsetOffsetY;
        public final Rect mLastChildRect = new Rect();

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public boolean isNestedScrollAccepted(int i) {
            if (i == 0) {
                return this.mDidAcceptNestedScrollTouch;
            }
            if (i != 1) {
                return false;
            }
            return this.mDidAcceptNestedScrollNonTouch;
        }

        public void setBehavior(Behavior behavior) {
            Behavior behavior2 = this.mBehavior;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.mBehavior = behavior;
                this.mBehaviorResolved = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        public void setNestedScrollAccepted(int i, boolean z) {
            if (i == 0) {
                this.mDidAcceptNestedScrollTouch = z;
            } else if (i == 1) {
                this.mDidAcceptNestedScrollNonTouch = z;
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class OnPreDrawListener implements android.view.ViewTreeObserver.OnPreDrawListener {
        public OnPreDrawListener() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
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
        public SparseArray<Parcelable> behaviorStates;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.behaviorStates.append(iArr[i], readParcelableArray[i]);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.behaviorStates.keyAt(i2);
                parcelableArr[i2] = this.behaviorStates.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class ViewElevationComparator implements Comparator<View> {
        public int compare(Object obj, Object obj2) {
            float z = ViewCompat.getZ((View) obj);
            float z2 = ((View) obj2).getZ();
            if (z > z2) {
                return -1;
            }
            return z < z2 ? 1 : 0;
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = packageR != null ? packageR.getName() : null;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    public static Rect acquireTempRect() {
        Rect rect = (Rect) sRectPool.acquire();
        return rect == null ? new Rect() : rect;
    }

    public static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + '.' + str;
        }
        try {
            Map map = sConstructors.get();
            if (map == null) {
                map = new HashMap();
                sConstructors.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            throw new RuntimeException(GeneratedOutlineSupport.outline50("Could not inflate Behavior subclass ", str), e2);
        }
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public final void constrainChildRect(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - layoutParams.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    public void dispatchDependentViewsChanged(View view) {
        List list = (List) this.mChildDag.mGraph.getOrDefault(view, null);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                Behavior behavior = ((LayoutParams) view2.getLayoutParams()).mBehavior;
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.mBehavior;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity();
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor());
                Paint paint = this.mScrimPaint;
                int round = Math.round(scrimOpacity * 255.0f);
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = InvitationReply.EXPIRED;
                }
                paint.setAlpha(round);
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
            return;
        }
        if (z) {
            ViewGroupUtils.getDescendantRect(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> getDependencies(View view) {
        DirectedAcyclicGraph<View> directedAcyclicGraph = this.mChildDag;
        int i = directedAcyclicGraph.mGraph.mSize;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) directedAcyclicGraph.mGraph.valueAt(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(directedAcyclicGraph.mGraph.keyAt(i2));
            }
        }
        this.mTempDependenciesList.clear();
        if (arrayList != null) {
            this.mTempDependenciesList.addAll(arrayList);
        }
        return this.mTempDependenciesList;
    }

    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List<View> getDependents(View view) {
        List list = (List) this.mChildDag.mGraph.getOrDefault(view, null);
        this.mTempDependenciesList.clear();
        if (list != null) {
            this.mTempDependenciesList.addAll(list);
        }
        return this.mTempDependenciesList;
    }

    public final void getDesiredAnchoredChildRectWithoutConstraints(int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int i4;
        int i5;
        int i6 = layoutParams.gravity;
        if (i6 == 0) {
            i6 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, i);
        int i7 = layoutParams.anchorGravity;
        if ((i7 & 7) == 0) {
            i7 |= 8388611;
        }
        if ((i7 & 112) == 0) {
            i7 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i7, i);
        int i8 = absoluteGravity & 7;
        int i9 = absoluteGravity & 112;
        int i10 = absoluteGravity2 & 7;
        int i11 = absoluteGravity2 & 112;
        if (i10 == 1) {
            i4 = rect.left + (rect.width() / 2);
        } else if (i10 != 5) {
            i4 = rect.left;
        } else {
            i4 = rect.right;
        }
        if (i11 == 16) {
            i5 = rect.top + (rect.height() / 2);
        } else if (i11 != 80) {
            i5 = rect.top;
        } else {
            i5 = rect.bottom;
        }
        if (i8 == 1) {
            i4 -= i2 / 2;
        } else if (i8 != 5) {
            i4 -= i2;
        }
        if (i9 == 16) {
            i5 -= i3 / 2;
        } else if (i9 != 80) {
            i5 -= i3;
        }
        rect2.set(i4, i5, i2 + i4, i3 + i5);
    }

    public final int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            "No keylines defined for " + this + " - attempted index lookup " + i;
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            "Keyline index " + i + " out of range for " + this;
            return 0;
        }
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            if (view instanceof AttachedBehavior) {
                layoutParams.setBehavior(((AttachedBehavior) view).getBehavior());
                layoutParams.mBehaviorResolved = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.setBehavior((Behavior) defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        defaultBehavior.value().getName();
                    }
                }
                layoutParams.mBehaviorResolved = true;
            }
        }
        return layoutParams;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        ViewGroupUtils.getDescendantRect(this, view, acquireTempRect);
        try {
            boolean contains = acquireTempRect.contains(i, i2);
            return contains;
        } finally {
            acquireTempRect.setEmpty();
            sRectPool.release(acquireTempRect);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
            requestApplyInsets();
        }
        this.mIsAttachedToWindow = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0260  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChildViewsChanged(int r25) {
        /*
            r24 = this;
            r7 = r24
            r8 = r25
            int r9 = androidx.core.view.ViewCompat.getLayoutDirection(r24)
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            int r10 = r0.size()
            android.graphics.Rect r11 = acquireTempRect()
            android.graphics.Rect r12 = acquireTempRect()
            android.graphics.Rect r13 = acquireTempRect()
            r0 = 0
            r14 = 0
        L_0x001c:
            if (r14 >= r10) goto L_0x02d4
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            java.lang.Object r0 = r0.get(r14)
            r15 = r0
            android.view.View r15 = (android.view.View) r15
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            r6 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            if (r8 != 0) goto L_0x003e
            int r0 = r15.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x003e
            r1 = r10
            r2 = r13
            r19 = r14
            goto L_0x02ce
        L_0x003e:
            r0 = 0
            r5 = 0
        L_0x0040:
            if (r5 >= r14) goto L_0x00fb
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            java.lang.Object r0 = r0.get(r5)
            android.view.View r0 = (android.view.View) r0
            android.view.View r1 = r6.mAnchorDirectChild
            if (r1 != r0) goto L_0x00e7
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            r4 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r4
            android.view.View r0 = r4.mAnchorView
            if (r0 == 0) goto L_0x00e7
            android.graphics.Rect r3 = acquireTempRect()
            android.graphics.Rect r2 = acquireTempRect()
            android.graphics.Rect r1 = acquireTempRect()
            android.view.View r0 = r4.mAnchorView
            androidx.coordinatorlayout.widget.ViewGroupUtils.getDescendantRect(r7, r0, r3)
            r0 = 0
            r7.getChildRect(r15, r0, r2)
            int r0 = r15.getMeasuredWidth()
            r16 = r10
            int r10 = r15.getMeasuredHeight()
            r17 = r0
            r0 = r24
            r18 = r1
            r1 = r9
            r19 = r14
            r14 = r2
            r2 = r3
            r20 = r3
            r3 = r18
            r21 = r4
            r22 = r5
            r5 = r17
            r23 = r13
            r13 = r6
            r6 = r10
            r0.getDesiredAnchoredChildRectWithoutConstraints(r1, r2, r3, r4, r5, r6)
            r0 = r18
            int r1 = r0.left
            int r2 = r14.left
            if (r1 != r2) goto L_0x00a5
            int r1 = r0.top
            int r2 = r14.top
            if (r1 == r2) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r1 = 0
            goto L_0x00a6
        L_0x00a5:
            r1 = 1
        L_0x00a6:
            r3 = r17
            r2 = r21
            r7.constrainChildRect(r2, r0, r3, r10)
            int r3 = r0.left
            int r4 = r14.left
            int r3 = r3 - r4
            int r4 = r0.top
            int r5 = r14.top
            int r4 = r4 - r5
            if (r3 == 0) goto L_0x00bc
            androidx.core.view.ViewCompat.offsetLeftAndRight(r15, r3)
        L_0x00bc:
            if (r4 == 0) goto L_0x00c1
            androidx.core.view.ViewCompat.offsetTopAndBottom(r15, r4)
        L_0x00c1:
            if (r1 == 0) goto L_0x00cc
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r1 = r2.mBehavior
            if (r1 == 0) goto L_0x00cc
            android.view.View r2 = r2.mAnchorView
            r1.onDependentViewChanged(r7, r15, r2)
        L_0x00cc:
            r20.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r1 = sRectPool
            r2 = r20
            r1.release(r2)
            r14.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r1 = sRectPool
            r1.release(r14)
            r0.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r1 = sRectPool
            r1.release(r0)
            goto L_0x00f0
        L_0x00e7:
            r22 = r5
            r16 = r10
            r23 = r13
            r19 = r14
            r13 = r6
        L_0x00f0:
            int r5 = r22 + 1
            r6 = r13
            r10 = r16
            r14 = r19
            r13 = r23
            goto L_0x0040
        L_0x00fb:
            r16 = r10
            r23 = r13
            r19 = r14
            r13 = r6
            r0 = 1
            r7.getChildRect(r15, r0, r12)
            int r0 = r13.insetEdge
            r1 = 48
            r2 = 80
            r3 = 3
            r4 = 5
            if (r0 == 0) goto L_0x015e
            boolean r0 = r12.isEmpty()
            if (r0 != 0) goto L_0x015e
            int r0 = r13.insetEdge
            int r0 = android.view.Gravity.getAbsoluteGravity(r0, r9)
            r5 = r0 & 112(0x70, float:1.57E-43)
            if (r5 == r1) goto L_0x0133
            if (r5 == r2) goto L_0x0123
            goto L_0x013d
        L_0x0123:
            int r5 = r11.bottom
            int r6 = r24.getHeight()
            int r10 = r12.top
            int r6 = r6 - r10
            int r5 = java.lang.Math.max(r5, r6)
            r11.bottom = r5
            goto L_0x013d
        L_0x0133:
            int r5 = r11.top
            int r6 = r12.bottom
            int r5 = java.lang.Math.max(r5, r6)
            r11.top = r5
        L_0x013d:
            r0 = r0 & 7
            if (r0 == r3) goto L_0x0154
            if (r0 == r4) goto L_0x0144
            goto L_0x015e
        L_0x0144:
            int r0 = r11.right
            int r3 = r24.getWidth()
            int r4 = r12.left
            int r3 = r3 - r4
            int r0 = java.lang.Math.max(r0, r3)
            r11.right = r0
            goto L_0x015e
        L_0x0154:
            int r0 = r11.left
            int r3 = r12.right
            int r0 = java.lang.Math.max(r0, r3)
            r11.left = r0
        L_0x015e:
            int r0 = r13.dodgeInsetEdges
            if (r0 == 0) goto L_0x026c
            int r0 = r15.getVisibility()
            if (r0 != 0) goto L_0x026c
            boolean r0 = r15.isLaidOut()
            if (r0 != 0) goto L_0x0170
            goto L_0x026c
        L_0x0170:
            int r0 = r15.getWidth()
            if (r0 <= 0) goto L_0x026c
            int r0 = r15.getHeight()
            if (r0 > 0) goto L_0x017e
            goto L_0x026c
        L_0x017e:
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r3 = r0.mBehavior
            android.graphics.Rect r4 = acquireTempRect()
            android.graphics.Rect r5 = acquireTempRect()
            int r6 = r15.getLeft()
            int r10 = r15.getTop()
            int r13 = r15.getRight()
            int r14 = r15.getBottom()
            r5.set(r6, r10, r13, r14)
            if (r3 == 0) goto L_0x01d3
            boolean r3 = r3.getInsetDodgeRect(r7, r15, r4)
            if (r3 == 0) goto L_0x01d3
            boolean r3 = r5.contains(r4)
            if (r3 == 0) goto L_0x01b0
            goto L_0x01d6
        L_0x01b0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Rect should be within the child's bounds. Rect:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = r4.toShortString()
            r1.append(r2)
            java.lang.String r2 = " | Bounds:"
            r1.append(r2)
            java.lang.String r2 = r5.toShortString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01d3:
            r4.set(r5)
        L_0x01d6:
            r5.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r3 = sRectPool
            r3.release(r5)
            boolean r3 = r4.isEmpty()
            if (r3 == 0) goto L_0x01ee
            r4.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r0 = sRectPool
            r0.release(r4)
            goto L_0x026c
        L_0x01ee:
            int r3 = r0.dodgeInsetEdges
            int r3 = android.view.Gravity.getAbsoluteGravity(r3, r9)
            r5 = r3 & 48
            if (r5 != r1) goto L_0x020a
            int r1 = r4.top
            int r5 = r0.topMargin
            int r1 = r1 - r5
            int r5 = r0.mInsetOffsetY
            int r1 = r1 - r5
            int r5 = r11.top
            if (r1 >= r5) goto L_0x020a
            int r5 = r5 - r1
            r7.setInsetOffsetY(r15, r5)
            r1 = 1
            goto L_0x020b
        L_0x020a:
            r1 = 0
        L_0x020b:
            r5 = r3 & 80
            if (r5 != r2) goto L_0x0225
            int r2 = r24.getHeight()
            int r5 = r4.bottom
            int r2 = r2 - r5
            int r5 = r0.bottomMargin
            int r2 = r2 - r5
            int r5 = r0.mInsetOffsetY
            int r2 = r2 + r5
            int r5 = r11.bottom
            if (r2 >= r5) goto L_0x0225
            int r2 = r2 - r5
            r7.setInsetOffsetY(r15, r2)
            r1 = 1
        L_0x0225:
            if (r1 != 0) goto L_0x022b
            r1 = 0
            r7.setInsetOffsetY(r15, r1)
        L_0x022b:
            r1 = r3 & 3
            r2 = 3
            if (r1 != r2) goto L_0x0242
            int r1 = r4.left
            int r2 = r0.leftMargin
            int r1 = r1 - r2
            int r2 = r0.mInsetOffsetX
            int r1 = r1 - r2
            int r2 = r11.left
            if (r1 >= r2) goto L_0x0242
            int r2 = r2 - r1
            r7.setInsetOffsetX(r15, r2)
            r1 = 1
            goto L_0x0243
        L_0x0242:
            r1 = 0
        L_0x0243:
            r2 = r3 & 5
            r3 = 5
            if (r2 != r3) goto L_0x025e
            int r2 = r24.getWidth()
            int r3 = r4.right
            int r2 = r2 - r3
            int r3 = r0.rightMargin
            int r2 = r2 - r3
            int r0 = r0.mInsetOffsetX
            int r2 = r2 + r0
            int r0 = r11.right
            if (r2 >= r0) goto L_0x025e
            int r2 = r2 - r0
            r7.setInsetOffsetX(r15, r2)
            r1 = 1
        L_0x025e:
            if (r1 != 0) goto L_0x0264
            r0 = 0
            r7.setInsetOffsetX(r15, r0)
        L_0x0264:
            r4.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r0 = sRectPool
            r0.release(r4)
        L_0x026c:
            r0 = 2
            if (r8 == r0) goto L_0x0291
            android.view.ViewGroup$LayoutParams r1 = r15.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            android.graphics.Rect r1 = r1.mLastChildRect
            r2 = r23
            r2.set(r1)
            boolean r1 = r2.equals(r12)
            if (r1 == 0) goto L_0x0285
            r1 = r16
            goto L_0x02ce
        L_0x0285:
            android.view.ViewGroup$LayoutParams r1 = r15.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            android.graphics.Rect r1 = r1.mLastChildRect
            r1.set(r12)
            goto L_0x0293
        L_0x0291:
            r2 = r23
        L_0x0293:
            int r14 = r19 + 1
            r1 = r16
        L_0x0297:
            if (r14 >= r1) goto L_0x02ce
            java.util.List<android.view.View> r3 = r7.mDependencySortedChildren
            java.lang.Object r3 = r3.get(r14)
            android.view.View r3 = (android.view.View) r3
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r4
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r5 = r4.mBehavior
            if (r5 == 0) goto L_0x02cb
            boolean r6 = r5.layoutDependsOn(r7, r3, r15)
            if (r6 == 0) goto L_0x02cb
            if (r8 != 0) goto L_0x02bb
            boolean r6 = r4.mDidChangeAfterNestedScroll
            if (r6 == 0) goto L_0x02bb
            r3 = 0
            r4.mDidChangeAfterNestedScroll = r3
            goto L_0x02cb
        L_0x02bb:
            if (r8 == r0) goto L_0x02c2
            boolean r3 = r5.onDependentViewChanged(r7, r3, r15)
            goto L_0x02c6
        L_0x02c2:
            r5.onDependentViewRemoved(r7, r3, r15)
            r3 = 1
        L_0x02c6:
            r5 = 1
            if (r8 != r5) goto L_0x02cb
            r4.mDidChangeAfterNestedScroll = r3
        L_0x02cb:
            int r14 = r14 + 1
            goto L_0x0297
        L_0x02ce:
            int r14 = r19 + 1
            r10 = r1
            r13 = r2
            goto L_0x001c
        L_0x02d4:
            r2 = r13
            r11.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r0 = sRectPool
            r0.release(r11)
            r12.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r0 = sRectPool
            r0.release(r12)
            r2.setEmpty()
            androidx.core.util.Pools$Pool<android.graphics.Rect> r0 = sRectPool
            r0.release(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onChildViewsChanged(int):void");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8) {
                Behavior behavior = ((LayoutParams) view.getLayoutParams()).mBehavior;
                if (behavior == null || !behavior.onLayoutChild(this, view, layoutDirection)) {
                    onLayoutChild(view, layoutDirection);
                }
            }
        }
    }

    public void onLayoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = 0;
        if (!(layoutParams.mAnchorView == null && layoutParams.mAnchorId != -1)) {
            View view2 = layoutParams.mAnchorView;
            if (view2 != null) {
                Rect acquireTempRect = acquireTempRect();
                Rect acquireTempRect2 = acquireTempRect();
                try {
                    ViewGroupUtils.getDescendantRect(this, view2, acquireTempRect);
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    getDesiredAnchoredChildRectWithoutConstraints(i, acquireTempRect, acquireTempRect2, layoutParams2, measuredWidth, measuredHeight);
                    constrainChildRect(layoutParams2, acquireTempRect2, measuredWidth, measuredHeight);
                    view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
                } finally {
                    acquireTempRect.setEmpty();
                    sRectPool.release(acquireTempRect);
                    acquireTempRect2.setEmpty();
                    sRectPool.release(acquireTempRect2);
                }
            } else {
                int i3 = layoutParams.keyline;
                if (i3 >= 0) {
                    LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                    int i4 = layoutParams3.gravity;
                    if (i4 == 0) {
                        i4 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
                    int i5 = absoluteGravity & 7;
                    int i6 = absoluteGravity & 112;
                    int width = getWidth();
                    int height = getHeight();
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    if (i == 1) {
                        i3 = width - i3;
                    }
                    int keyline = getKeyline(i3) - measuredWidth2;
                    if (i5 == 1) {
                        keyline += measuredWidth2 / 2;
                    } else if (i5 == 5) {
                        keyline += measuredWidth2;
                    }
                    if (i6 == 16) {
                        i2 = 0 + (measuredHeight2 / 2);
                    } else if (i6 == 80) {
                        i2 = measuredHeight2 + 0;
                    }
                    int max = Math.max(getPaddingLeft() + layoutParams3.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth2) - layoutParams3.rightMargin));
                    int max2 = Math.max(getPaddingTop() + layoutParams3.topMargin, Math.min(i2, ((height - getPaddingBottom()) - measuredHeight2) - layoutParams3.bottomMargin));
                    view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                    return;
                }
                LayoutParams layoutParams4 = (LayoutParams) view.getLayoutParams();
                Rect acquireTempRect3 = acquireTempRect();
                acquireTempRect3.set(getPaddingLeft() + layoutParams4.leftMargin, getPaddingTop() + layoutParams4.topMargin, (getWidth() - getPaddingRight()) - layoutParams4.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams4.bottomMargin);
                if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !view.getFitsSystemWindows()) {
                    acquireTempRect3.left = this.mLastInsets.getSystemWindowInsetLeft() + acquireTempRect3.left;
                    acquireTempRect3.top = this.mLastInsets.getSystemWindowInsetTop() + acquireTempRect3.top;
                    acquireTempRect3.right -= this.mLastInsets.getSystemWindowInsetRight();
                    acquireTempRect3.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
                }
                Rect acquireTempRect4 = acquireTempRect();
                int i7 = layoutParams4.gravity;
                if ((i7 & 7) == 0) {
                    i7 |= 8388611;
                }
                if ((i7 & 112) == 0) {
                    i7 |= 48;
                }
                Gravity.apply(i7, view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect3, acquireTempRect4, i);
                view.layout(acquireTempRect4.left, acquireTempRect4.top, acquireTempRect4.right, acquireTempRect4.bottom);
                acquireTempRect3.setEmpty();
                sRectPool.release(acquireTempRect3);
                acquireTempRect4.setEmpty();
                sRectPool.release(acquireTempRect4);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017e, code lost:
        if (r0.onMeasureChild(r30, r20, r8, r21, r23, 0) == false) goto L_0x018e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.prepareChildren()
            int r0 = r30.getChildCount()
            r8 = 0
            r1 = 0
        L_0x000b:
            r2 = 1
            if (r1 >= r0) goto L_0x0038
            android.view.View r3 = r7.getChildAt(r1)
            androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r4 = r7.mChildDag
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r5 = r4.mGraph
            int r5 = r5.mSize
            r6 = 0
        L_0x0019:
            if (r6 >= r5) goto L_0x0030
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r9 = r4.mGraph
            java.lang.Object r9 = r9.valueAt(r6)
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            if (r9 == 0) goto L_0x002d
            boolean r9 = r9.contains(r3)
            if (r9 == 0) goto L_0x002d
            r3 = 1
            goto L_0x0031
        L_0x002d:
            int r6 = r6 + 1
            goto L_0x0019
        L_0x0030:
            r3 = 0
        L_0x0031:
            if (r3 == 0) goto L_0x0035
            r0 = 1
            goto L_0x0039
        L_0x0035:
            int r1 = r1 + 1
            goto L_0x000b
        L_0x0038:
            r0 = 0
        L_0x0039:
            boolean r1 = r7.mNeedsPreDrawListener
            if (r0 == r1) goto L_0x006d
            if (r0 == 0) goto L_0x005a
            boolean r0 = r7.mIsAttachedToWindow
            if (r0 == 0) goto L_0x0057
            androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener r0 = r7.mOnPreDrawListener
            if (r0 != 0) goto L_0x004e
            androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener
            r0.<init>()
            r7.mOnPreDrawListener = r0
        L_0x004e:
            android.view.ViewTreeObserver r0 = r30.getViewTreeObserver()
            androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener r1 = r7.mOnPreDrawListener
            r0.addOnPreDrawListener(r1)
        L_0x0057:
            r7.mNeedsPreDrawListener = r2
            goto L_0x006d
        L_0x005a:
            boolean r0 = r7.mIsAttachedToWindow
            if (r0 == 0) goto L_0x006b
            androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener r0 = r7.mOnPreDrawListener
            if (r0 == 0) goto L_0x006b
            android.view.ViewTreeObserver r0 = r30.getViewTreeObserver()
            androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener r1 = r7.mOnPreDrawListener
            r0.removeOnPreDrawListener(r1)
        L_0x006b:
            r7.mNeedsPreDrawListener = r8
        L_0x006d:
            int r9 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r10 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r11 = androidx.core.view.ViewCompat.getLayoutDirection(r30)
            if (r11 != r2) goto L_0x0085
            r12 = 1
            goto L_0x0086
        L_0x0085:
            r12 = 0
        L_0x0086:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r9 + r10
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.view.WindowInsetsCompat r3 = r7.mLastInsets
            if (r3 == 0) goto L_0x00af
            boolean r3 = r30.getFitsSystemWindows()
            if (r3 == 0) goto L_0x00af
            r19 = 1
            goto L_0x00b1
        L_0x00af:
            r19 = 0
        L_0x00b1:
            java.util.List<android.view.View> r2 = r7.mDependencySortedChildren
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x00bb:
            if (r3 >= r6) goto L_0x01d4
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x00d7
            r22 = r3
            r29 = r6
            r28 = r9
            goto L_0x01cb
        L_0x00d7:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            int r0 = r1.keyline
            if (r0 < 0) goto L_0x0121
            if (r13 == 0) goto L_0x0121
            int r0 = r7.getKeyline(r0)
            int r8 = r1.gravity
            if (r8 != 0) goto L_0x00ef
            r8 = 8388661(0x800035, float:1.1755018E-38)
        L_0x00ef:
            int r8 = android.view.Gravity.getAbsoluteGravity(r8, r11)
            r8 = r8 & 7
            r22 = r2
            r2 = 3
            if (r8 != r2) goto L_0x00fc
            if (r12 == 0) goto L_0x0101
        L_0x00fc:
            r2 = 5
            if (r8 != r2) goto L_0x010d
            if (r12 == 0) goto L_0x010d
        L_0x0101:
            int r2 = r14 - r10
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r8 = 0
            goto L_0x0125
        L_0x010d:
            if (r8 != r2) goto L_0x0111
            if (r12 == 0) goto L_0x0116
        L_0x0111:
            r2 = 3
            if (r8 != r2) goto L_0x011f
            if (r12 == 0) goto L_0x011f
        L_0x0116:
            int r0 = r0 - r9
            r8 = 0
            int r0 = java.lang.Math.max(r8, r0)
            r21 = r0
            goto L_0x0125
        L_0x011f:
            r8 = 0
            goto L_0x0123
        L_0x0121:
            r22 = r2
        L_0x0123:
            r21 = 0
        L_0x0125:
            if (r19 == 0) goto L_0x0157
            boolean r0 = r20.getFitsSystemWindows()
            if (r0 != 0) goto L_0x0157
            androidx.core.view.WindowInsetsCompat r0 = r7.mLastInsets
            int r0 = r0.getSystemWindowInsetLeft()
            androidx.core.view.WindowInsetsCompat r2 = r7.mLastInsets
            int r2 = r2.getSystemWindowInsetRight()
            int r2 = r2 + r0
            androidx.core.view.WindowInsetsCompat r0 = r7.mLastInsets
            int r0 = r0.getSystemWindowInsetTop()
            androidx.core.view.WindowInsetsCompat r8 = r7.mLastInsets
            int r8 = r8.getSystemWindowInsetBottom()
            int r8 = r8 + r0
            int r0 = r14 - r2
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r8
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r8 = r0
            r23 = r2
            goto L_0x015b
        L_0x0157:
            r8 = r31
            r23 = r32
        L_0x015b:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.mBehavior
            if (r0 == 0) goto L_0x0181
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r8
            r27 = r4
            r4 = r21
            r28 = r9
            r9 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.onMeasureChild(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x019b
            goto L_0x018e
        L_0x0181:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r9
            r25 = r22
            r22 = r3
            r9 = r5
        L_0x018e:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r8
            r3 = r21
            r4 = r23
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
        L_0x019b:
            int r0 = r20.getMeasuredWidth()
            int r0 = r0 + r17
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r9, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r2 + r18
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r8 = r25
            int r2 = android.view.View.combineMeasuredStates(r8, r2)
            r5 = r0
            r4 = r1
        L_0x01cb:
            int r3 = r22 + 1
            r9 = r28
            r6 = r29
            r8 = 0
            goto L_0x00bb
        L_0x01d4:
            r8 = r2
            r1 = r4
            r9 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r8
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r9, r2, r0)
            int r2 = r8 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0)) {
                    Behavior behavior = layoutParams.mBehavior;
                    if (behavior != null) {
                        z2 |= behavior.onNestedFling();
                    }
                }
            }
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0)) {
                    Behavior behavior = layoutParams.mBehavior;
                    if (behavior != null) {
                        z |= behavior.onNestedPreFling(this, childAt, view, f2, f3);
                    }
                }
            }
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).mBehavior;
            if (!(id == -1 || behavior == null)) {
                Parcelable parcelable2 = sparseArray.get(id);
                if (parcelable2 != null) {
                    behavior.onRestoreInstanceState(this, childAt, parcelable2);
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).mBehavior;
            if (!(id == -1 || behavior == null)) {
                Parcelable onSaveInstanceState = behavior.onSaveInstanceState(this, childAt);
                if (onSaveInstanceState != null) {
                    sparseArray.append(id, onSaveInstanceState);
                }
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.mBehavior
            if (r6 == 0) goto L_0x0029
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L_0x0035
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x0048
        L_0x0035:
            if (r3 == 0) goto L_0x0048
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x0048:
            if (r8 == 0) goto L_0x004d
            r8.recycle()
        L_0x004d:
            if (r2 == r4) goto L_0x0052
            r1 = 3
            if (r2 != r1) goto L_0x0055
        L_0x0052:
            r0.resetTouchBehaviors(r5)
        L_0x0055:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean performIntercept(MotionEvent motionEvent, int i) {
        boolean z;
        MotionEvent motionEvent2 = motionEvent;
        int i2 = i;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.mBehavior;
            if ((!z2 && !z3) || actionMasked == 0) {
                if (!z2 && behavior != null) {
                    if (i2 == 0) {
                        z2 = behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    } else if (i2 == 1) {
                        z2 = behavior.onTouchEvent(this, view, motionEvent2);
                    }
                    if (z2) {
                        this.mBehaviorTouchView = view;
                    }
                }
                if (layoutParams.mBehavior == null) {
                    layoutParams.mDidBlockInteraction = false;
                }
                boolean z4 = layoutParams.mDidBlockInteraction;
                if (z4) {
                    z = true;
                } else {
                    Behavior behavior2 = layoutParams.mBehavior;
                    z = (behavior2 != null && behavior2.getScrimOpacity() > 0.0f) | z4;
                    layoutParams.mDidBlockInteraction = z;
                }
                z3 = z && !z4;
                if (z && !z3) {
                    break;
                }
            } else if (behavior != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    behavior.onInterceptTouchEvent(this, view, motionEvent3);
                } else if (i2 == 1) {
                    behavior.onTouchEvent(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r5 != false) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0168 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void prepareChildren() {
        /*
            r11 = this;
            java.util.List<android.view.View> r0 = r11.mDependencySortedChildren
            r0.clear()
            androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r0 = r11.mChildDag
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r1 = r0.mGraph
            int r1 = r1.mSize
            r2 = 0
            r3 = 0
        L_0x000d:
            if (r3 >= r1) goto L_0x0024
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r4 = r0.mGraph
            java.lang.Object r4 = r4.valueAt(r3)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 == 0) goto L_0x0021
            r4.clear()
            androidx.core.util.Pools$Pool<java.util.ArrayList<T>> r5 = r0.mListPool
            r5.release(r4)
        L_0x0021:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0024:
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r0 = r0.mGraph
            r0.clear()
            int r0 = r11.getChildCount()
            r1 = 0
        L_0x002e:
            if (r1 >= r0) goto L_0x0195
            android.view.View r3 = r11.getChildAt(r1)
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r4 = r11.getResolvedLayoutParams(r3)
            int r5 = r4.mAnchorId
            r6 = -1
            r7 = 0
            if (r5 != r6) goto L_0x0044
            r4.mAnchorDirectChild = r7
            r4.mAnchorView = r7
            goto L_0x00ca
        L_0x0044:
            android.view.View r5 = r4.mAnchorView
            if (r5 == 0) goto L_0x0075
            int r5 = r5.getId()
            int r6 = r4.mAnchorId
            if (r5 == r6) goto L_0x0051
            goto L_0x006e
        L_0x0051:
            android.view.View r5 = r4.mAnchorView
            android.view.ViewParent r6 = r5.getParent()
        L_0x0057:
            if (r6 == r11) goto L_0x0070
            if (r6 == 0) goto L_0x006a
            if (r6 != r3) goto L_0x005e
            goto L_0x006a
        L_0x005e:
            boolean r8 = r6 instanceof android.view.View
            if (r8 == 0) goto L_0x0065
            r5 = r6
            android.view.View r5 = (android.view.View) r5
        L_0x0065:
            android.view.ViewParent r6 = r6.getParent()
            goto L_0x0057
        L_0x006a:
            r4.mAnchorDirectChild = r7
            r4.mAnchorView = r7
        L_0x006e:
            r5 = 0
            goto L_0x0073
        L_0x0070:
            r4.mAnchorDirectChild = r5
            r5 = 1
        L_0x0073:
            if (r5 != 0) goto L_0x00ca
        L_0x0075:
            int r5 = r4.mAnchorId
            android.view.View r5 = r11.findViewById(r5)
            r4.mAnchorView = r5
            if (r5 == 0) goto L_0x00c0
            if (r5 != r11) goto L_0x0094
            boolean r5 = r11.isInEditMode()
            if (r5 == 0) goto L_0x008c
            r4.mAnchorDirectChild = r7
            r4.mAnchorView = r7
            goto L_0x00ca
        L_0x008c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "View can not be anchored to the the parent CoordinatorLayout"
            r0.<init>(r1)
            throw r0
        L_0x0094:
            android.view.ViewParent r6 = r5.getParent()
        L_0x0098:
            if (r6 == r11) goto L_0x00bd
            if (r6 == 0) goto L_0x00bd
            if (r6 != r3) goto L_0x00b1
            boolean r5 = r11.isInEditMode()
            if (r5 == 0) goto L_0x00a9
            r4.mAnchorDirectChild = r7
            r4.mAnchorView = r7
            goto L_0x00ca
        L_0x00a9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Anchor must not be a descendant of the anchored view"
            r0.<init>(r1)
            throw r0
        L_0x00b1:
            boolean r8 = r6 instanceof android.view.View
            if (r8 == 0) goto L_0x00b8
            r5 = r6
            android.view.View r5 = (android.view.View) r5
        L_0x00b8:
            android.view.ViewParent r6 = r6.getParent()
            goto L_0x0098
        L_0x00bd:
            r4.mAnchorDirectChild = r5
            goto L_0x00ca
        L_0x00c0:
            boolean r5 = r11.isInEditMode()
            if (r5 == 0) goto L_0x0170
            r4.mAnchorDirectChild = r7
            r4.mAnchorView = r7
        L_0x00ca:
            androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r5 = r11.mChildDag
            r5.addNode(r3)
            r5 = 0
        L_0x00d0:
            if (r5 >= r0) goto L_0x016c
            if (r5 != r1) goto L_0x00d6
            goto L_0x0168
        L_0x00d6:
            android.view.View r6 = r11.getChildAt(r5)
            android.view.View r8 = r4.mAnchorDirectChild
            if (r6 == r8) goto L_0x010b
            int r8 = androidx.core.view.ViewCompat.getLayoutDirection(r11)
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r9
            int r9 = r9.insetEdge
            int r9 = android.view.Gravity.getAbsoluteGravity(r9, r8)
            if (r9 == 0) goto L_0x00fb
            int r10 = r4.dodgeInsetEdges
            int r8 = android.view.Gravity.getAbsoluteGravity(r10, r8)
            r8 = r8 & r9
            if (r8 != r9) goto L_0x00fb
            r8 = 1
            goto L_0x00fc
        L_0x00fb:
            r8 = 0
        L_0x00fc:
            if (r8 != 0) goto L_0x010b
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r8 = r4.mBehavior
            if (r8 == 0) goto L_0x0109
            boolean r8 = r8.layoutDependsOn(r11, r3, r6)
            if (r8 == 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            r8 = 0
            goto L_0x010c
        L_0x010b:
            r8 = 1
        L_0x010c:
            if (r8 == 0) goto L_0x0168
            androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r8 = r11.mChildDag
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r8 = r8.mGraph
            int r8 = r8.indexOfKey(r6)
            if (r8 < 0) goto L_0x011a
            r8 = 1
            goto L_0x011b
        L_0x011a:
            r8 = 0
        L_0x011b:
            if (r8 != 0) goto L_0x0122
            androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r8 = r11.mChildDag
            r8.addNode(r6)
        L_0x0122:
            androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r8 = r11.mChildDag
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r9 = r8.mGraph
            int r9 = r9.indexOfKey(r6)
            if (r9 < 0) goto L_0x012e
            r9 = 1
            goto L_0x012f
        L_0x012e:
            r9 = 0
        L_0x012f:
            if (r9 == 0) goto L_0x0160
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r9 = r8.mGraph
            int r9 = r9.indexOfKey(r3)
            if (r9 < 0) goto L_0x013b
            r9 = 1
            goto L_0x013c
        L_0x013b:
            r9 = 0
        L_0x013c:
            if (r9 == 0) goto L_0x0160
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r9 = r8.mGraph
            java.lang.Object r9 = r9.getOrDefault(r6, r7)
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            if (r9 != 0) goto L_0x015c
            androidx.core.util.Pools$Pool<java.util.ArrayList<T>> r9 = r8.mListPool
            java.lang.Object r9 = r9.acquire()
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            if (r9 != 0) goto L_0x0157
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x0157:
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r8 = r8.mGraph
            r8.put(r6, r9)
        L_0x015c:
            r9.add(r3)
            goto L_0x0168
        L_0x0160:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "All nodes must be present in the graph before being added as an edge"
            r0.<init>(r1)
            throw r0
        L_0x0168:
            int r5 = r5 + 1
            goto L_0x00d0
        L_0x016c:
            int r1 = r1 + 1
            goto L_0x002e
        L_0x0170:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Could not find CoordinatorLayout descendant view with id "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            android.content.res.Resources r2 = r11.getResources()
            int r4 = r4.mAnchorId
            java.lang.String r2 = r2.getResourceName(r4)
            r1.append(r2)
            java.lang.String r2 = " to anchor view "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0195:
            java.util.List<android.view.View> r0 = r11.mDependencySortedChildren
            androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r1 = r11.mChildDag
            java.util.ArrayList<T> r3 = r1.mSortResult
            r3.clear()
            java.util.HashSet<T> r3 = r1.mSortTmpMarked
            r3.clear()
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r3 = r1.mGraph
            int r3 = r3.mSize
        L_0x01a7:
            if (r2 >= r3) goto L_0x01b9
            androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r4 = r1.mGraph
            java.lang.Object r4 = r4.keyAt(r2)
            java.util.ArrayList<T> r5 = r1.mSortResult
            java.util.HashSet<T> r6 = r1.mSortTmpMarked
            r1.dfs(r4, r5, r6)
            int r2 = r2 + 1
            goto L_0x01a7
        L_0x01b9:
            java.util.ArrayList<T> r1 = r1.mSortResult
            r0.addAll(r1)
            java.util.List<android.view.View> r0 = r11.mDependencySortedChildren
            java.util.Collections.reverse(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.prepareChildren():void");
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).mBehavior;
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    public final void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).mBehavior;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((LayoutParams) getChildAt(i2).getLayoutParams()).mDidBlockInteraction = false;
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    public final void setInsetOffsetX(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = layoutParams.mInsetOffsetX;
        if (i2 != i) {
            ViewCompat.offsetLeftAndRight(view, i - i2);
            layoutParams.mInsetOffsetX = i;
        }
    }

    public final void setInsetOffsetY(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = layoutParams.mInsetOffsetY;
        if (i2 != i) {
            ViewCompat.offsetTopAndBottom(view, i - i2);
            layoutParams.mInsetOffsetY = i;
        }
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                b.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public final void setupForInsets() {
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
                        if (!Objects.equals(coordinatorLayout.mLastInsets, windowInsetsCompat)) {
                            coordinatorLayout.mLastInsets = windowInsetsCompat;
                            boolean z = true;
                            boolean z2 = windowInsetsCompat.getSystemWindowInsetTop() > 0;
                            coordinatorLayout.mDrawStatusBarBackground = z2;
                            if (z2 || coordinatorLayout.getBackground() != null) {
                                z = false;
                            }
                            coordinatorLayout.setWillNotDraw(z);
                            if (!windowInsetsCompat.isConsumed()) {
                                int childCount = coordinatorLayout.getChildCount();
                                for (int i = 0; i < childCount; i++) {
                                    View childAt = coordinatorLayout.getChildAt(i);
                                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                                        Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).mBehavior;
                                        if (behavior != null) {
                                            windowInsetsCompat = behavior.onApplyWindowInsets(windowInsetsCompat);
                                            if (windowInsetsCompat.isConsumed()) {
                                                break;
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                            coordinatorLayout.requestLayout();
                        }
                        return windowInsetsCompat;
                    }
                };
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(GL20.GL_INVALID_ENUM);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArray;
        super(context, attributeSet, i);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper();
        if (i == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i, 0);
        }
        if (VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArray, 0, R$style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArray, i, 0);
            }
        }
        int resourceId = typedArray.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.mKeylines;
                iArr[i2] = (int) (((float) iArr[i2]) * f2);
            }
        }
        this.mStatusBarBackground = typedArray.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        int i5;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 8) {
                int i9 = i3;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i3)) {
                    Behavior behavior = layoutParams.mBehavior;
                    if (behavior != null) {
                        int[] iArr2 = this.mBehaviorConsumed;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                        behavior.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                        int[] iArr3 = this.mBehaviorConsumed;
                        if (i > 0) {
                            i4 = Math.max(i6, iArr3[0]);
                        } else {
                            i4 = Math.min(i6, iArr3[0]);
                        }
                        i6 = i4;
                        int[] iArr4 = this.mBehaviorConsumed;
                        if (i2 > 0) {
                            i5 = Math.max(i7, iArr4[1]);
                        } else {
                            i5 = Math.min(i7, iArr4[1]);
                        }
                        i7 = i5;
                        z = true;
                    }
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        if (i2 == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = i;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = i;
        }
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i2)) {
                Behavior behavior = layoutParams.mBehavior;
                if (behavior != null && i2 == 0) {
                    behavior.onNestedScrollAccepted();
                }
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.mBehavior;
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    z |= onStartNestedScroll;
                    layoutParams.setNestedScrollAccepted(i3, onStartNestedScroll);
                } else {
                    layoutParams.setNestedScrollAccepted(i3, false);
                }
            }
        }
        return z;
    }

    public void onStopNestedScroll(View view, int i) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        if (i == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = 0;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i)) {
                Behavior behavior = layoutParams.mBehavior;
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i);
                }
                layoutParams.setNestedScrollAccepted(i, false);
                layoutParams.mDidChangeAfterNestedScroll = false;
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        int i7;
        int childCount = getChildCount();
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i5)) {
                    Behavior behavior = layoutParams.mBehavior;
                    if (behavior != null) {
                        int[] iArr2 = this.mBehaviorConsumed;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                        behavior.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                        int[] iArr3 = this.mBehaviorConsumed;
                        if (i3 > 0) {
                            i6 = Math.max(i8, iArr3[0]);
                        } else {
                            i6 = Math.min(i8, iArr3[0]);
                        }
                        i8 = i6;
                        if (i4 > 0) {
                            i7 = Math.max(i9, this.mBehaviorConsumed[1]);
                        } else {
                            i7 = Math.min(i9, this.mBehaviorConsumed[1]);
                        }
                        i9 = i7;
                        z = true;
                    }
                }
            }
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (z) {
            onChildViewsChanged(1);
        }
    }
}
