package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;

public class DropDownListView extends ListView {
    public ViewPropertyAnimatorCompat mClickAnimation;
    public boolean mDrawsInPressedState;
    public boolean mHijackFocus;
    public Field mIsChildViewEnabled;
    public boolean mListSelectionHidden;
    public int mMotionPosition;
    public ResolveHoverRunnable mResolveHoverRunnable;
    public ListViewAutoScrollHelper mScrollHelper;
    public int mSelectionBottomPadding = 0;
    public int mSelectionLeftPadding = 0;
    public int mSelectionRightPadding = 0;
    public int mSelectionTopPadding = 0;
    public GateKeeperDrawable mSelector;
    public final Rect mSelectorRect = new Rect();

    public static class GateKeeperDrawable extends DrawableWrapper {
        public boolean mEnabled = true;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                this.mDrawable.draw(canvas);
            }
        }

        public void setHotspot(float f2, float f3) {
            if (this.mEnabled) {
                this.mDrawable.setHotspot(f2, f3);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.mEnabled) {
                this.mDrawable.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.mEnabled) {
                return this.mDrawable.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.mEnabled) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public class ResolveHoverRunnable implements Runnable {
        public ResolveHoverRunnable() {
        }

        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.drawableStateChanged();
        }
    }

    public DropDownListView(Context context, boolean z) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.mHijackFocus = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        GateKeeperDrawable gateKeeperDrawable = this.mSelector;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.mEnabled = z;
        }
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.mSelectorRect);
                selector.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged() {
        if (this.mResolveHoverRunnable == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            updateSelectorStateCompat();
        }
    }

    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3) {
        int i4;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i5 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            if (i9 > 0) {
                i4 = MeasureSpec.makeMeasureSpec(i9, 1073741824);
            } else {
                i4 = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, i4);
            view.forceLayout();
            if (i8 > 0) {
                i5 += dividerHeight;
            }
            i5 += view.getMeasuredHeight();
            if (i5 >= i2) {
                if (i3 >= 0 && i8 > i3 && i7 > 0 && i5 != i2) {
                    i2 = i7;
                }
                return i2;
            }
            if (i3 >= 0 && i8 >= i3) {
                i7 = i5;
            }
        }
        return i5;
    }

    public void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r3 != 3) goto L_0x0121;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onForwardedEvent(android.view.MotionEvent r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            int r3 = r17.getActionMasked()
            r4 = 0
            r5 = 1
            if (r3 == r5) goto L_0x0016
            r0 = 2
            if (r3 == r0) goto L_0x0014
            r0 = 3
            if (r3 == r0) goto L_0x001d
            goto L_0x0121
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            int r6 = r17.findPointerIndex(r18)
            if (r6 >= 0) goto L_0x0020
        L_0x001d:
            r0 = 0
            goto L_0x0122
        L_0x0020:
            float r7 = r2.getX(r6)
            int r7 = (int) r7
            float r6 = r2.getY(r6)
            int r6 = (int) r6
            int r8 = r1.pointToPosition(r7, r6)
            r9 = -1
            if (r8 != r9) goto L_0x0033
            goto L_0x0123
        L_0x0033:
            int r0 = r16.getFirstVisiblePosition()
            int r0 = r8 - r0
            android.view.View r10 = r1.getChildAt(r0)
            float r7 = (float) r7
            float r6 = (float) r6
            r1.mDrawsInPressedState = r5
            r1.drawableHotspotChanged(r7, r6)
            boolean r0 = r16.isPressed()
            if (r0 != 0) goto L_0x004d
            r1.setPressed(r5)
        L_0x004d:
            r16.layoutChildren()
            int r0 = r1.mMotionPosition
            if (r0 == r9) goto L_0x006a
            int r11 = r16.getFirstVisiblePosition()
            int r0 = r0 - r11
            android.view.View r0 = r1.getChildAt(r0)
            if (r0 == 0) goto L_0x006a
            if (r0 == r10) goto L_0x006a
            boolean r11 = r0.isPressed()
            if (r11 == 0) goto L_0x006a
            r0.setPressed(r4)
        L_0x006a:
            r1.mMotionPosition = r8
            int r0 = r10.getLeft()
            float r0 = (float) r0
            float r0 = r7 - r0
            int r11 = r10.getTop()
            float r11 = (float) r11
            float r11 = r6 - r11
            r10.drawableHotspotChanged(r0, r11)
            boolean r0 = r10.isPressed()
            if (r0 != 0) goto L_0x0086
            r10.setPressed(r5)
        L_0x0086:
            android.graphics.drawable.Drawable r11 = r16.getSelector()
            if (r11 == 0) goto L_0x0090
            if (r8 == r9) goto L_0x0090
            r12 = 1
            goto L_0x0091
        L_0x0090:
            r12 = 0
        L_0x0091:
            if (r12 == 0) goto L_0x0096
            r11.setVisible(r4, r4)
        L_0x0096:
            android.graphics.Rect r0 = r1.mSelectorRect
            int r13 = r10.getLeft()
            int r14 = r10.getTop()
            int r15 = r10.getRight()
            int r5 = r10.getBottom()
            r0.set(r13, r14, r15, r5)
            int r5 = r0.left
            int r13 = r1.mSelectionLeftPadding
            int r5 = r5 - r13
            r0.left = r5
            int r5 = r0.top
            int r13 = r1.mSelectionTopPadding
            int r5 = r5 - r13
            r0.top = r5
            int r5 = r0.right
            int r13 = r1.mSelectionRightPadding
            int r5 = r5 + r13
            r0.right = r5
            int r5 = r0.bottom
            int r13 = r1.mSelectionBottomPadding
            int r5 = r5 + r13
            r0.bottom = r5
            java.lang.reflect.Field r0 = r1.mIsChildViewEnabled     // Catch:{ IllegalAccessException -> 0x00e7 }
            boolean r0 = r0.getBoolean(r1)     // Catch:{ IllegalAccessException -> 0x00e7 }
            boolean r5 = r10.isEnabled()     // Catch:{ IllegalAccessException -> 0x00e7 }
            if (r5 == r0) goto L_0x00eb
            java.lang.reflect.Field r5 = r1.mIsChildViewEnabled     // Catch:{ IllegalAccessException -> 0x00e7 }
            if (r0 != 0) goto L_0x00d9
            r0 = 1
            goto L_0x00da
        L_0x00d9:
            r0 = 0
        L_0x00da:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ IllegalAccessException -> 0x00e7 }
            r5.set(r1, r0)     // Catch:{ IllegalAccessException -> 0x00e7 }
            if (r8 == r9) goto L_0x00eb
            r16.refreshDrawableState()     // Catch:{ IllegalAccessException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00eb:
            if (r12 == 0) goto L_0x0106
            android.graphics.Rect r0 = r1.mSelectorRect
            float r5 = r0.exactCenterX()
            float r0 = r0.exactCenterY()
            int r12 = r16.getVisibility()
            if (r12 != 0) goto L_0x00ff
            r12 = 1
            goto L_0x0100
        L_0x00ff:
            r12 = 0
        L_0x0100:
            r11.setVisible(r12, r4)
            r11.setHotspot(r5, r0)
        L_0x0106:
            android.graphics.drawable.Drawable r0 = r16.getSelector()
            if (r0 == 0) goto L_0x0111
            if (r8 == r9) goto L_0x0111
            r0.setHotspot(r7, r6)
        L_0x0111:
            r1.setSelectorEnabled(r4)
            r16.refreshDrawableState()
            r5 = 1
            if (r3 != r5) goto L_0x0121
            long r5 = r1.getItemIdAtPosition(r8)
            r1.performItemClick(r10, r8, r5)
        L_0x0121:
            r0 = 1
        L_0x0122:
            r5 = 0
        L_0x0123:
            if (r0 == 0) goto L_0x0127
            if (r5 == 0) goto L_0x0149
        L_0x0127:
            r1.mDrawsInPressedState = r4
            r1.setPressed(r4)
            r16.drawableStateChanged()
            int r3 = r1.mMotionPosition
            int r5 = r16.getFirstVisiblePosition()
            int r3 = r3 - r5
            android.view.View r3 = r1.getChildAt(r3)
            if (r3 == 0) goto L_0x013f
            r3.setPressed(r4)
        L_0x013f:
            androidx.core.view.ViewPropertyAnimatorCompat r3 = r1.mClickAnimation
            if (r3 == 0) goto L_0x0149
            r3.cancel()
            r3 = 0
            r1.mClickAnimation = r3
        L_0x0149:
            if (r0 == 0) goto L_0x0161
            androidx.core.widget.ListViewAutoScrollHelper r3 = r1.mScrollHelper
            if (r3 != 0) goto L_0x0156
            androidx.core.widget.ListViewAutoScrollHelper r3 = new androidx.core.widget.ListViewAutoScrollHelper
            r3.<init>(r1)
            r1.mScrollHelper = r3
        L_0x0156:
            androidx.core.widget.ListViewAutoScrollHelper r3 = r1.mScrollHelper
            boolean r4 = r3.mEnabled
            r5 = 1
            r3.mEnabled = r5
            r3.onTouch(r1, r2)
            goto L_0x016e
        L_0x0161:
            androidx.core.widget.ListViewAutoScrollHelper r2 = r1.mScrollHelper
            if (r2 == 0) goto L_0x016e
            boolean r3 = r2.mEnabled
            if (r3 == 0) goto L_0x016c
            r2.requestStop()
        L_0x016c:
            r2.mEnabled = r4
        L_0x016e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.mResolveHoverRunnable = resolveHoverRunnable;
            DropDownListView.this.post(resolveHoverRunnable);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                updateSelectorStateCompat();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.mResolveHoverRunnable;
        if (resolveHoverRunnable != null) {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.removeCallbacks(resolveHoverRunnable);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.mListSelectionHidden = z;
    }

    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable = drawable != null ? new GateKeeperDrawable(drawable) : null;
        this.mSelector = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }

    public final void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && this.mDrawsInPressedState && isPressed()) {
            selector.setState(getDrawableState());
        }
    }
}
