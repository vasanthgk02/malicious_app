package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

@SuppressLint({"ViewConstructor"})
public class GhostViewPort extends ViewGroup implements GhostView {
    public Matrix mMatrix;
    public final OnPreDrawListener mOnPreDrawListener = new OnPreDrawListener() {
        public boolean onPreDraw() {
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.mStartParent;
            if (viewGroup != null) {
                View view = ghostViewPort.mStartView;
                if (view != null) {
                    viewGroup.endViewTransition(view);
                    GhostViewPort.this.mStartParent.postInvalidateOnAnimation();
                    GhostViewPort ghostViewPort2 = GhostViewPort.this;
                    ghostViewPort2.mStartParent = null;
                    ghostViewPort2.mStartView = null;
                }
            }
            return true;
        }
    };
    public int mReferences;
    public ViewGroup mStartParent;
    public View mStartView;
    public final View mView;

    public GhostViewPort(View view) {
        super(view.getContext());
        this.mView = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0196, code lost:
        if (r1.size() == r11) goto L_0x019f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.transition.GhostViewPort addGhost(android.view.View r19, android.view.ViewGroup r20, android.graphics.Matrix r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            android.view.ViewParent r3 = r19.getParent()
            boolean r3 = r3 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x01d7
            androidx.transition.GhostViewHolder r3 = androidx.transition.GhostViewHolder.getHolder(r20)
            int r4 = androidx.transition.R$id.ghost_view
            java.lang.Object r4 = r0.getTag(r4)
            androidx.transition.GhostViewPort r4 = (androidx.transition.GhostViewPort) r4
            r5 = 0
            if (r4 == 0) goto L_0x002c
            android.view.ViewParent r6 = r4.getParent()
            androidx.transition.GhostViewHolder r6 = (androidx.transition.GhostViewHolder) r6
            if (r6 == r3) goto L_0x002c
            int r7 = r4.mReferences
            r6.removeView(r4)
            r4 = 0
            goto L_0x002d
        L_0x002c:
            r7 = 0
        L_0x002d:
            r6 = 1
            if (r4 != 0) goto L_0x01cc
            if (r2 != 0) goto L_0x0059
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            android.view.ViewParent r4 = r19.getParent()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r2.reset()
            androidx.transition.ViewUtilsBase r8 = androidx.transition.ViewUtils.IMPL
            r8.transformMatrixToGlobal(r4, r2)
            int r8 = r4.getScrollX()
            int r8 = -r8
            float r8 = (float) r8
            int r4 = r4.getScrollY()
            int r4 = -r4
            float r4 = (float) r4
            r2.preTranslate(r8, r4)
            androidx.transition.ViewUtilsBase r4 = androidx.transition.ViewUtils.IMPL
            r4.transformMatrixToLocal(r1, r2)
        L_0x0059:
            androidx.transition.GhostViewPort r4 = new androidx.transition.GhostViewPort
            r4.<init>(r0)
            r4.mMatrix = r2
            if (r3 != 0) goto L_0x0068
            androidx.transition.GhostViewHolder r3 = new androidx.transition.GhostViewHolder
            r3.<init>(r1)
            goto L_0x007e
        L_0x0068:
            boolean r0 = r3.mAttached
            if (r0 == 0) goto L_0x01c4
            android.view.ViewGroup r0 = r3.mParent
            android.view.ViewGroupOverlay r0 = r0.getOverlay()
            r0.remove(r3)
            android.view.ViewGroup r0 = r3.mParent
            android.view.ViewGroupOverlay r0 = r0.getOverlay()
            r0.add(r3)
        L_0x007e:
            copySize(r1, r3)
            copySize(r1, r4)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.view.View r1 = r4.mView
            androidx.transition.GhostViewHolder.getParents(r1, r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r3.getChildCount()
            int r2 = r2 - r6
            r8 = 0
        L_0x0099:
            if (r8 > r2) goto L_0x01b1
            int r9 = r8 + r2
            r10 = 2
            int r9 = r9 / r10
            android.view.View r11 = r3.getChildAt(r9)
            androidx.transition.GhostViewPort r11 = (androidx.transition.GhostViewPort) r11
            android.view.View r11 = r11.mView
            androidx.transition.GhostViewHolder.getParents(r11, r1)
            boolean r11 = r0.isEmpty()
            if (r11 != 0) goto L_0x019b
            boolean r11 = r1.isEmpty()
            if (r11 != 0) goto L_0x019b
            java.lang.Object r11 = r0.get(r5)
            java.lang.Object r12 = r1.get(r5)
            if (r11 == r12) goto L_0x00c2
            goto L_0x019b
        L_0x00c2:
            int r11 = r0.size()
            int r12 = r1.size()
            int r11 = java.lang.Math.min(r11, r12)
            r12 = 1
        L_0x00cf:
            if (r12 >= r11) goto L_0x018e
            java.lang.Object r13 = r0.get(r12)
            android.view.View r13 = (android.view.View) r13
            java.lang.Object r14 = r1.get(r12)
            android.view.View r14 = (android.view.View) r14
            if (r13 == r14) goto L_0x0182
            android.view.ViewParent r11 = r13.getParent()
            android.view.ViewGroup r11 = (android.view.ViewGroup) r11
            int r12 = r11.getChildCount()
            float r15 = r13.getZ()
            float r16 = r14.getZ()
            int r15 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
            if (r15 == 0) goto L_0x0109
            float r10 = r13.getZ()
            float r11 = r14.getZ()
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x0103
            goto L_0x019b
        L_0x0103:
            r19 = r0
            r17 = 0
            goto L_0x0199
        L_0x0109:
            r15 = 0
        L_0x010a:
            if (r15 >= r12) goto L_0x019b
            int r6 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r6 < r5) goto L_0x011d
            int r5 = r11.getChildDrawingOrder(r15)
            r19 = r0
            r0 = r5
            r5 = 2
            r17 = 0
            goto L_0x0170
        L_0x011d:
            boolean r5 = androidx.transition.ViewGroupUtils.sGetChildDrawingOrderMethodFetched
            if (r5 != 0) goto L_0x0144
            java.lang.Class<android.view.ViewGroup> r5 = android.view.ViewGroup.class
            java.lang.String r6 = "getChildDrawingOrder"
            r19 = r0
            java.lang.Class[] r0 = new java.lang.Class[r10]     // Catch:{ NoSuchMethodException -> 0x0140 }
            java.lang.Class r18 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0140 }
            r17 = 0
            r0[r17] = r18     // Catch:{ NoSuchMethodException -> 0x0140 }
            java.lang.Class r18 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0140 }
            r10 = 1
            r0[r10] = r18     // Catch:{ NoSuchMethodException -> 0x0140 }
            java.lang.reflect.Method r0 = r5.getDeclaredMethod(r6, r0)     // Catch:{ NoSuchMethodException -> 0x0140 }
            androidx.transition.ViewGroupUtils.sGetChildDrawingOrderMethod = r0     // Catch:{ NoSuchMethodException -> 0x0140 }
            r0.setAccessible(r10)     // Catch:{ NoSuchMethodException -> 0x0140 }
            goto L_0x0140
        L_0x013e:
            r19 = r0
        L_0x0140:
            r0 = 1
            androidx.transition.ViewGroupUtils.sGetChildDrawingOrderMethodFetched = r0
            goto L_0x0146
        L_0x0144:
            r19 = r0
        L_0x0146:
            java.lang.reflect.Method r0 = androidx.transition.ViewGroupUtils.sGetChildDrawingOrderMethod
            if (r0 == 0) goto L_0x016c
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016d }
            int r10 = r11.getChildCount()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016d }
            r17 = 0
            r6[r17] = r10     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r15)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016f }
            r16 = 1
            r6[r16] = r10     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016f }
            java.lang.Object r0 = r0.invoke(r11, r6)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016f }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016f }
            int r0 = r0.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x016f }
            goto L_0x0170
        L_0x016c:
            r5 = 2
        L_0x016d:
            r17 = 0
        L_0x016f:
            r0 = r15
        L_0x0170:
            android.view.View r0 = r11.getChildAt(r0)
            if (r0 != r13) goto L_0x0177
            goto L_0x0199
        L_0x0177:
            if (r0 != r14) goto L_0x017a
            goto L_0x019f
        L_0x017a:
            int r15 = r15 + 1
            r0 = r19
            r5 = 0
            r6 = 1
            r10 = 2
            goto L_0x010a
        L_0x0182:
            r19 = r0
            r5 = 2
            r17 = 0
            int r12 = r12 + 1
            r5 = 0
            r6 = 1
            r10 = 2
            goto L_0x00cf
        L_0x018e:
            r19 = r0
            r17 = 0
            int r0 = r1.size()
            if (r0 != r11) goto L_0x0199
            goto L_0x019f
        L_0x0199:
            r0 = 0
            goto L_0x01a0
        L_0x019b:
            r19 = r0
            r17 = 0
        L_0x019f:
            r0 = 1
        L_0x01a0:
            if (r0 == 0) goto L_0x01a5
            int r8 = r9 + 1
            goto L_0x01a8
        L_0x01a5:
            int r9 = r9 + -1
            r2 = r9
        L_0x01a8:
            r1.clear()
            r0 = r19
            r5 = 0
            r6 = 1
            goto L_0x0099
        L_0x01b1:
            if (r8 < 0) goto L_0x01be
            int r0 = r3.getChildCount()
            if (r8 < r0) goto L_0x01ba
            goto L_0x01be
        L_0x01ba:
            r3.addView(r4, r8)
            goto L_0x01c1
        L_0x01be:
            r3.addView(r4)
        L_0x01c1:
            r4.mReferences = r7
            goto L_0x01d0
        L_0x01c4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "This GhostViewHolder is detached!"
            r0.<init>(r1)
            throw r0
        L_0x01cc:
            if (r2 == 0) goto L_0x01d0
            r4.mMatrix = r2
        L_0x01d0:
            int r0 = r4.mReferences
            r1 = 1
            int r0 = r0 + r1
            r4.mReferences = r0
            return r4
        L_0x01d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Ghosted views must be parented by a ViewGroup"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.GhostViewPort.addGhost(android.view.View, android.view.ViewGroup, android.graphics.Matrix):androidx.transition.GhostViewPort");
    }

    public static void copySize(View view, View view2) {
        ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), view.getWidth() + view2.getLeft(), view.getHeight() + view2.getTop());
    }

    public static GhostViewPort getGhostView(View view) {
        return (GhostViewPort) view.getTag(R$id.ghost_view);
    }

    public static void removeGhost(View view) {
        GhostViewPort ghostViewPort = (GhostViewPort) view.getTag(R$id.ghost_view);
        if (ghostViewPort != null) {
            int i = ghostViewPort.mReferences - 1;
            ghostViewPort.mReferences = i;
            if (i <= 0) {
                ((GhostViewHolder) ghostViewPort.getParent()).removeView(ghostViewPort);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mView.setTag(R$id.ghost_view, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.IMPL.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() != null) {
            ((View) this.mView.getParent()).invalidate();
        }
    }

    public void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.IMPL.setTransitionVisibility(this.mView, 0);
        this.mView.setTag(R$id.ghost_view, null);
        if (this.mView.getParent() != null) {
            ((View) this.mView.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        CompoundButtonCompat.enableZ(canvas, true);
        canvas.setMatrix(this.mMatrix);
        ViewUtils.IMPL.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.IMPL.setTransitionVisibility(this.mView, 4);
        drawChild(canvas, this.mView, getDrawingTime());
        CompoundButtonCompat.enableZ(canvas, false);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.mStartParent = viewGroup;
        this.mStartView = view;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getGhostView(this.mView) == this) {
            ViewUtils.IMPL.setTransitionVisibility(this.mView, i == 0 ? 4 : 0);
        }
    }
}
