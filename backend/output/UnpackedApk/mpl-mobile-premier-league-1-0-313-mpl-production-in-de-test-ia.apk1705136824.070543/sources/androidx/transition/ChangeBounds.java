package androidx.transition;

import a.a.a.a.d.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

public class ChangeBounds extends Transition {
    public static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") {
        public Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    public static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") {
        public Object get(Object obj) {
            ViewBounds viewBounds = (ViewBounds) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            ViewBounds viewBounds = (ViewBounds) obj;
            PointF pointF = (PointF) obj2;
            if (viewBounds != null) {
                viewBounds.mRight = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                viewBounds.mBottom = round;
                int i = viewBounds.mBottomRightCalls + 1;
                viewBounds.mBottomRightCalls = i;
                if (viewBounds.mTopLeftCalls == i) {
                    ViewUtils.setLeftTopRightBottom(viewBounds.mView, viewBounds.mLeft, viewBounds.mTop, viewBounds.mRight, round);
                    viewBounds.mTopLeftCalls = 0;
                    viewBounds.mBottomRightCalls = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    };
    public static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        public Rect mBounds = new Rect();

        public Object get(Object obj) {
            ((Drawable) obj).copyBounds(this.mBounds);
            Rect rect = this.mBounds;
            return new PointF((float) rect.left, (float) rect.top);
        }

        public void set(Object obj, Object obj2) {
            Drawable drawable = (Drawable) obj;
            PointF pointF = (PointF) obj2;
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }
    };
    public static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, "position") {
        public Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    public static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") {
        public Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    public static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") {
        public Object get(Object obj) {
            ViewBounds viewBounds = (ViewBounds) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            ViewBounds viewBounds = (ViewBounds) obj;
            PointF pointF = (PointF) obj2;
            if (viewBounds != null) {
                viewBounds.mLeft = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                viewBounds.mTop = round;
                int i = viewBounds.mTopLeftCalls + 1;
                viewBounds.mTopLeftCalls = i;
                if (i == viewBounds.mBottomRightCalls) {
                    ViewUtils.setLeftTopRightBottom(viewBounds.mView, viewBounds.mLeft, round, viewBounds.mRight, viewBounds.mBottom);
                    viewBounds.mTopLeftCalls = 0;
                    viewBounds.mBottomRightCalls = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    };
    public static RectEvaluator sRectEvaluator = new RectEvaluator();
    public static final String[] sTransitionProperties = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public boolean mReparent = false;
    public boolean mResizeClip = false;
    public int[] mTempLocation = new int[2];

    public static class ViewBounds {
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }
    }

    public ChangeBounds() {
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put("android:changeBounds:parent", transitionValues.view.getParent());
            if (this.mReparent) {
                transitionValues.view.getLocationInWindow(this.mTempLocation);
                transitionValues.values.put("android:changeBounds:windowX", Integer.valueOf(this.mTempLocation[0]));
                transitionValues.values.put("android:changeBounds:windowY", Integer.valueOf(this.mTempLocation[1]));
            }
            if (this.mResizeClip) {
                transitionValues.values.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(android.view.ViewGroup r19, androidx.transition.TransitionValues r20, androidx.transition.TransitionValues r21) {
        /*
            r18 = this;
            r8 = r18
            r0 = r20
            r1 = r21
            if (r0 == 0) goto L_0x0267
            if (r1 != 0) goto L_0x000c
            goto L_0x0267
        L_0x000c:
            java.util.Map<java.lang.String, java.lang.Object> r3 = r0.values
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.values
            java.lang.String r5 = "android:changeBounds:parent"
            java.lang.Object r3 = r3.get(r5)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            java.lang.Object r4 = r4.get(r5)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            if (r3 == 0) goto L_0x0265
            if (r4 != 0) goto L_0x0024
            goto L_0x0265
        L_0x0024:
            android.view.View r9 = r1.view
            boolean r5 = r8.mReparent
            r10 = 1
            if (r5 == 0) goto L_0x003b
            androidx.transition.TransitionValues r5 = r8.getMatchedTransitionValues(r3, r10)
            if (r5 != 0) goto L_0x0034
            if (r3 != r4) goto L_0x0039
            goto L_0x003b
        L_0x0034:
            android.view.View r3 = r5.view
            if (r4 != r3) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r3 = 0
            goto L_0x003c
        L_0x003b:
            r3 = 1
        L_0x003c:
            if (r3 == 0) goto L_0x01bd
            java.util.Map<java.lang.String, java.lang.Object> r3 = r0.values
            java.lang.String r4 = "android:changeBounds:bounds"
            java.lang.Object r3 = r3.get(r4)
            android.graphics.Rect r3 = (android.graphics.Rect) r3
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.values
            java.lang.Object r4 = r5.get(r4)
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r5 = r3.left
            int r7 = r4.left
            int r11 = r3.top
            int r12 = r4.top
            int r13 = r3.right
            int r14 = r4.right
            int r3 = r3.bottom
            int r15 = r4.bottom
            int r4 = r13 - r5
            int r2 = r3 - r11
            int r10 = r14 - r7
            int r6 = r15 - r12
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.values
            r16 = r9
            java.lang.String r9 = "android:changeBounds:clip"
            java.lang.Object r0 = r0.get(r9)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.values
            java.lang.Object r1 = r1.get(r9)
            r9 = r1
            android.graphics.Rect r9 = (android.graphics.Rect) r9
            if (r4 == 0) goto L_0x0081
            if (r2 != 0) goto L_0x0085
        L_0x0081:
            if (r10 == 0) goto L_0x0094
            if (r6 == 0) goto L_0x0094
        L_0x0085:
            if (r5 != r7) goto L_0x008c
            if (r11 == r12) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r1 = 0
            goto L_0x008d
        L_0x008c:
            r1 = 1
        L_0x008d:
            if (r13 != r14) goto L_0x0091
            if (r3 == r15) goto L_0x0095
        L_0x0091:
            int r1 = r1 + 1
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            if (r0 == 0) goto L_0x009d
            boolean r17 = r0.equals(r9)
            if (r17 == 0) goto L_0x00a1
        L_0x009d:
            if (r0 != 0) goto L_0x00a3
            if (r9 == 0) goto L_0x00a3
        L_0x00a1:
            int r1 = r1 + 1
        L_0x00a3:
            if (r1 <= 0) goto L_0x01f6
            r19 = r9
            boolean r9 = r8.mResizeClip
            r20 = r0
            r0 = 2
            if (r9 != 0) goto L_0x0134
            r9 = r16
            androidx.transition.ViewUtils.setLeftTopRightBottom(r9, r5, r11, r13, r3)
            if (r1 != r0) goto L_0x010b
            if (r4 != r10) goto L_0x00cb
            if (r2 != r6) goto L_0x00cb
            androidx.transition.PathMotion r0 = r8.mPathMotion
            float r1 = (float) r5
            float r2 = (float) r11
            float r3 = (float) r7
            float r4 = (float) r12
            android.graphics.Path r0 = r0.getPath(r1, r2, r3, r4)
            android.util.Property<android.view.View, android.graphics.PointF> r1 = POSITION_PROPERTY
            android.animation.ObjectAnimator r0 = androidx.core.widget.CompoundButtonCompat.ofPointF(r9, r1, r0)
            goto L_0x01a2
        L_0x00cb:
            androidx.transition.ChangeBounds$ViewBounds r1 = new androidx.transition.ChangeBounds$ViewBounds
            r1.<init>(r9)
            androidx.transition.PathMotion r2 = r8.mPathMotion
            float r4 = (float) r5
            float r5 = (float) r11
            float r6 = (float) r7
            float r7 = (float) r12
            android.graphics.Path r2 = r2.getPath(r4, r5, r6, r7)
            android.util.Property<androidx.transition.ChangeBounds$ViewBounds, android.graphics.PointF> r4 = TOP_LEFT_PROPERTY
            android.animation.ObjectAnimator r2 = androidx.core.widget.CompoundButtonCompat.ofPointF(r1, r4, r2)
            androidx.transition.PathMotion r4 = r8.mPathMotion
            float r5 = (float) r13
            float r3 = (float) r3
            float r6 = (float) r14
            float r7 = (float) r15
            android.graphics.Path r3 = r4.getPath(r5, r3, r6, r7)
            android.util.Property<androidx.transition.ChangeBounds$ViewBounds, android.graphics.PointF> r4 = BOTTOM_RIGHT_PROPERTY
            android.animation.ObjectAnimator r3 = androidx.core.widget.CompoundButtonCompat.ofPointF(r1, r4, r3)
            android.animation.AnimatorSet r4 = new android.animation.AnimatorSet
            r4.<init>()
            android.animation.Animator[] r0 = new android.animation.Animator[r0]
            r5 = 0
            r0[r5] = r2
            r2 = 1
            r0[r2] = r3
            r4.playTogether(r0)
            androidx.transition.ChangeBounds$7 r0 = new androidx.transition.ChangeBounds$7
            r0.<init>(r1)
            r4.addListener(r0)
            r0 = r4
            goto L_0x01a2
        L_0x010b:
            if (r5 != r7) goto L_0x0122
            if (r11 == r12) goto L_0x0110
            goto L_0x0122
        L_0x0110:
            androidx.transition.PathMotion r0 = r8.mPathMotion
            float r1 = (float) r13
            float r2 = (float) r3
            float r3 = (float) r14
            float r4 = (float) r15
            android.graphics.Path r0 = r0.getPath(r1, r2, r3, r4)
            android.util.Property<android.view.View, android.graphics.PointF> r1 = BOTTOM_RIGHT_ONLY_PROPERTY
            android.animation.ObjectAnimator r0 = androidx.core.widget.CompoundButtonCompat.ofPointF(r9, r1, r0)
            goto L_0x01a2
        L_0x0122:
            androidx.transition.PathMotion r0 = r8.mPathMotion
            float r1 = (float) r5
            float r2 = (float) r11
            float r3 = (float) r7
            float r4 = (float) r12
            android.graphics.Path r0 = r0.getPath(r1, r2, r3, r4)
            android.util.Property<android.view.View, android.graphics.PointF> r1 = TOP_LEFT_ONLY_PROPERTY
            android.animation.ObjectAnimator r0 = androidx.core.widget.CompoundButtonCompat.ofPointF(r9, r1, r0)
            goto L_0x01a2
        L_0x0134:
            r9 = r16
            int r1 = java.lang.Math.max(r4, r10)
            int r3 = java.lang.Math.max(r2, r6)
            int r1 = r1 + r5
            int r3 = r3 + r11
            androidx.transition.ViewUtils.setLeftTopRightBottom(r9, r5, r11, r1, r3)
            if (r5 != r7) goto L_0x014a
            if (r11 == r12) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r11 = 0
            goto L_0x015b
        L_0x014a:
            androidx.transition.PathMotion r1 = r8.mPathMotion
            float r3 = (float) r5
            float r5 = (float) r11
            float r11 = (float) r7
            float r13 = (float) r12
            android.graphics.Path r1 = r1.getPath(r3, r5, r11, r13)
            android.util.Property<android.view.View, android.graphics.PointF> r3 = POSITION_PROPERTY
            android.animation.ObjectAnimator r1 = androidx.core.widget.CompoundButtonCompat.ofPointF(r9, r3, r1)
            r11 = r1
        L_0x015b:
            if (r20 != 0) goto L_0x0164
            android.graphics.Rect r1 = new android.graphics.Rect
            r3 = 0
            r1.<init>(r3, r3, r4, r2)
            goto L_0x0167
        L_0x0164:
            r3 = 0
            r1 = r20
        L_0x0167:
            if (r19 != 0) goto L_0x016f
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>(r3, r3, r10, r6)
            goto L_0x0171
        L_0x016f:
            r2 = r19
        L_0x0171:
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L_0x019d
            androidx.core.view.ViewCompat.setClipBounds(r9, r1)
            androidx.transition.RectEvaluator r4 = sRectEvaluator
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r3] = r1
            r1 = 1
            r0[r1] = r2
            java.lang.String r1 = "clipBounds"
            android.animation.ObjectAnimator r10 = android.animation.ObjectAnimator.ofObject(r9, r1, r4, r0)
            androidx.transition.ChangeBounds$8 r13 = new androidx.transition.ChangeBounds$8
            r0 = r13
            r1 = r18
            r2 = r9
            r3 = r19
            r4 = r7
            r5 = r12
            r6 = r14
            r7 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r10.addListener(r13)
            r2 = r10
            goto L_0x019e
        L_0x019d:
            r2 = 0
        L_0x019e:
            android.animation.Animator r0 = androidx.transition.TransitionUtils.mergeAnimators(r11, r2)
        L_0x01a2:
            android.view.ViewParent r1 = r9.getParent()
            boolean r1 = r1 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x01bc
            android.view.ViewParent r1 = r9.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r2 = 1
            androidx.transition.ViewGroupUtils.suppressLayout(r1, r2)
            androidx.transition.ChangeBounds$9 r2 = new androidx.transition.ChangeBounds$9
            r2.<init>(r1)
            r8.addListener(r2)
        L_0x01bc:
            return r0
        L_0x01bd:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r0.values
            java.lang.String r3 = "android:changeBounds:windowX"
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.values
            java.lang.String r4 = "android:changeBounds:windowY"
            java.lang.Object r0 = r0.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.values
            java.lang.Object r3 = r5.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.values
            java.lang.Object r1 = r1.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r2 != r3) goto L_0x01f8
            if (r0 == r1) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r0 = 0
            return r0
        L_0x01f8:
            int[] r4 = r8.mTempLocation
            r5 = r19
            r5.getLocationInWindow(r4)
            int r4 = r9.getWidth()
            int r6 = r9.getHeight()
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r6, r7)
            android.graphics.Canvas r6 = new android.graphics.Canvas
            r6.<init>(r4)
            r9.draw(r6)
            android.graphics.drawable.BitmapDrawable r6 = new android.graphics.drawable.BitmapDrawable
            r6.<init>(r4)
            float r7 = androidx.transition.ViewUtils.getTransitionAlpha(r9)
            r4 = 0
            androidx.transition.ViewUtilsBase r10 = androidx.transition.ViewUtils.IMPL
            r10.setTransitionAlpha(r9, r4)
            android.view.ViewOverlay r4 = r19.getOverlay()
            r4.add(r6)
            androidx.transition.PathMotion r4 = r8.mPathMotion
            int[] r10 = r8.mTempLocation
            r11 = 0
            r12 = r10[r11]
            int r2 = r2 - r12
            float r2 = (float) r2
            r12 = 1
            r13 = r10[r12]
            int r0 = r0 - r13
            float r0 = (float) r0
            r13 = r10[r11]
            int r3 = r3 - r13
            float r3 = (float) r3
            r10 = r10[r12]
            int r1 = r1 - r10
            float r1 = (float) r1
            android.graphics.Path r0 = r4.getPath(r2, r0, r3, r1)
            android.util.Property<android.graphics.drawable.Drawable, android.graphics.PointF> r1 = DRAWABLE_ORIGIN_PROPERTY
            r2 = 0
            android.animation.PropertyValuesHolder r0 = android.animation.PropertyValuesHolder.ofObject(r1, r2, r0)
            android.animation.PropertyValuesHolder[] r1 = new android.animation.PropertyValuesHolder[r12]
            r1[r11] = r0
            android.animation.ObjectAnimator r10 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r6, r1)
            androidx.transition.ChangeBounds$10 r11 = new androidx.transition.ChangeBounds$10
            r0 = r11
            r1 = r18
            r2 = r19
            r3 = r6
            r4 = r9
            r5 = r7
            r0.<init>(r2, r3, r4, r5)
            r10.addListener(r11)
            return r10
        L_0x0265:
            r0 = 0
            return r0
        L_0x0267:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeBounds.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = b.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.mResizeClip = namedBoolean;
    }
}
