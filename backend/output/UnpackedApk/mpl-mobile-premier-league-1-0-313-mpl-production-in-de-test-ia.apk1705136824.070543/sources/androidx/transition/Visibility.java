package androidx.transition;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition.TransitionListener;

public abstract class Visibility extends Transition {
    public static final String[] sTransitionProperties = {"android:visibility:visibility", "android:visibility:parent"};
    public int mMode = 3;

    public static class DisappearListener extends AnimatorListenerAdapter implements TransitionListener {
        public boolean mCanceled = false;
        public final int mFinalVisibility;
        public boolean mLayoutSuppressed;
        public final ViewGroup mParent;
        public final boolean mSuppressLayout;
        public final View mView;

        public DisappearListener(View view, int i, boolean z) {
            this.mView = view;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        public final void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mView, this.mFinalVisibility);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            hideViewWhenNotCanceled();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mView, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            hideViewWhenNotCanceled();
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            suppressLayout(false);
        }

        public void onTransitionResume(Transition transition) {
            suppressLayout(true);
        }

        public void onTransitionStart(Transition transition) {
        }

        public final void suppressLayout(boolean z) {
            if (this.mSuppressLayout && this.mLayoutSuppressed != z) {
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    this.mLayoutSuppressed = z;
                    ViewGroupUtils.suppressLayout(viewGroup, z);
                }
            }
        }
    }

    public static class VisibilityInfo {
        public ViewGroup mEndParent;
        public int mEndVisibility;
        public boolean mFadeIn;
        public ViewGroup mStartParent;
        public int mStartVisibility;
        public boolean mVisibilityChange;
    }

    public Visibility() {
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put("android:visibility:visibility", Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put("android:visibility:parent", transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:visibility:screenLocation", iArr);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange || (visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null)) {
            return null;
        }
        if (visibilityChangeInfo.mFadeIn) {
            return onAppear(viewGroup, transitionValues, transitionValues2);
        }
        return onDisappear(viewGroup, transitionValues, transitionValues2, visibilityChangeInfo.mEndVisibility);
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public final VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues == null || !transitionValues.values.containsKey("android:visibility:visibility")) {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        } else {
            visibilityInfo.mStartVisibility = ((Integer) transitionValues.values.get("android:visibility:visibility")).intValue();
            visibilityInfo.mStartParent = (ViewGroup) transitionValues.values.get("android:visibility:parent");
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey("android:visibility:visibility")) {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        } else {
            visibilityInfo.mEndVisibility = ((Integer) transitionValues2.values.get("android:visibility:visibility")).intValue();
            visibilityInfo.mEndParent = (ViewGroup) transitionValues2.values.get("android:visibility:parent");
        }
        if (transitionValues == null || transitionValues2 == null) {
            if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == 0) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
            return visibilityInfo;
        } else {
            int i = visibilityInfo.mStartVisibility;
            int i2 = visibilityInfo.mEndVisibility;
            if (i != i2) {
                if (i == 0) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else if (i2 == 0) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            } else if (visibilityInfo.mStartParent == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            }
        }
        return visibilityInfo;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z = false;
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey("android:visibility:visibility") != transitionValues.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.mVisibilityChange && (visibilityChangeInfo.mStartVisibility == 0 || visibilityChangeInfo.mEndVisibility == 0)) {
            z = true;
        }
        return z;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).mVisibilityChange) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007f, code lost:
        if (r11.mCanRemoveViews != false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(final android.view.ViewGroup r12, androidx.transition.TransitionValues r13, androidx.transition.TransitionValues r14, int r15) {
        /*
            r11 = this;
            int r0 = r11.mMode
            r1 = 2
            r0 = r0 & r1
            r2 = 0
            if (r0 == r1) goto L_0x0008
            return r2
        L_0x0008:
            if (r13 != 0) goto L_0x000b
            return r2
        L_0x000b:
            android.view.View r0 = r13.view
            if (r14 == 0) goto L_0x0012
            android.view.View r3 = r14.view
            goto L_0x0013
        L_0x0012:
            r3 = r2
        L_0x0013:
            int r4 = androidx.transition.R$id.save_overlay_view
            java.lang.Object r4 = r0.getTag(r4)
            android.view.View r4 = (android.view.View) r4
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0023
            r3 = r2
            r7 = 1
            goto L_0x0089
        L_0x0023:
            if (r3 == 0) goto L_0x0036
            android.view.ViewParent r4 = r3.getParent()
            if (r4 != 0) goto L_0x002c
            goto L_0x0036
        L_0x002c:
            r4 = 4
            if (r15 != r4) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            if (r0 != r3) goto L_0x003b
        L_0x0032:
            r4 = r3
            r7 = 0
            r3 = r2
            goto L_0x003e
        L_0x0036:
            if (r3 == 0) goto L_0x003b
            r4 = r2
            r7 = 0
            goto L_0x003e
        L_0x003b:
            r3 = r2
            r4 = r3
            r7 = 1
        L_0x003e:
            if (r7 == 0) goto L_0x0085
            android.view.ViewParent r7 = r0.getParent()
            if (r7 != 0) goto L_0x0047
            goto L_0x0081
        L_0x0047:
            android.view.ViewParent r7 = r0.getParent()
            boolean r7 = r7 instanceof android.view.View
            if (r7 == 0) goto L_0x0085
            android.view.ViewParent r7 = r0.getParent()
            android.view.View r7 = (android.view.View) r7
            androidx.transition.TransitionValues r8 = r11.getTransitionValues(r7, r6)
            androidx.transition.TransitionValues r9 = r11.getMatchedTransitionValues(r7, r6)
            androidx.transition.Visibility$VisibilityInfo r8 = r11.getVisibilityChangeInfo(r8, r9)
            boolean r8 = r8.mVisibilityChange
            if (r8 != 0) goto L_0x006a
            android.view.View r3 = androidx.transition.TransitionUtils.copyViewImage(r12, r0, r7)
            goto L_0x0085
        L_0x006a:
            int r8 = r7.getId()
            android.view.ViewParent r7 = r7.getParent()
            if (r7 != 0) goto L_0x0085
            r7 = -1
            if (r8 == r7) goto L_0x0085
            android.view.View r7 = r12.findViewById(r8)
            if (r7 == 0) goto L_0x0085
            boolean r7 = r11.mCanRemoveViews
            if (r7 == 0) goto L_0x0085
        L_0x0081:
            r3 = r4
            r7 = 0
            r4 = r0
            goto L_0x0089
        L_0x0085:
            r7 = 0
            r10 = r4
            r4 = r3
            r3 = r10
        L_0x0089:
            if (r4 == 0) goto L_0x00db
            if (r7 != 0) goto L_0x00bd
            java.util.Map<java.lang.String, java.lang.Object> r15 = r13.values
            java.lang.String r2 = "android:visibility:screenLocation"
            java.lang.Object r15 = r15.get(r2)
            int[] r15 = (int[]) r15
            r2 = r15[r5]
            r15 = r15[r6]
            int[] r1 = new int[r1]
            r12.getLocationOnScreen(r1)
            r3 = r1[r5]
            int r2 = r2 - r3
            int r3 = r4.getLeft()
            int r2 = r2 - r3
            r4.offsetLeftAndRight(r2)
            r1 = r1[r6]
            int r15 = r15 - r1
            int r1 = r4.getTop()
            int r15 = r15 - r1
            r4.offsetTopAndBottom(r15)
            android.view.ViewGroupOverlay r15 = r12.getOverlay()
            r15.add(r4)
        L_0x00bd:
            android.animation.Animator r13 = r11.onDisappear(r12, r4, r13, r14)
            if (r7 != 0) goto L_0x00da
            if (r13 != 0) goto L_0x00cd
            android.view.ViewGroupOverlay r12 = r12.getOverlay()
            r12.remove(r4)
            goto L_0x00da
        L_0x00cd:
            int r14 = androidx.transition.R$id.save_overlay_view
            r0.setTag(r14, r4)
            androidx.transition.Visibility$1 r14 = new androidx.transition.Visibility$1
            r14.<init>(r12, r4, r0)
            r11.addListener(r14)
        L_0x00da:
            return r13
        L_0x00db:
            if (r3 == 0) goto L_0x0101
            int r0 = r3.getVisibility()
            androidx.transition.ViewUtilsBase r1 = androidx.transition.ViewUtils.IMPL
            r1.setTransitionVisibility(r3, r5)
            android.animation.Animator r12 = r11.onDisappear(r12, r3, r13, r14)
            if (r12 == 0) goto L_0x00fb
            androidx.transition.Visibility$DisappearListener r13 = new androidx.transition.Visibility$DisappearListener
            r13.<init>(r3, r15, r6)
            r12.addListener(r13)
            r12.addPauseListener(r13)
            r11.addListener(r13)
            goto L_0x0100
        L_0x00fb:
            androidx.transition.ViewUtilsBase r13 = androidx.transition.ViewUtils.IMPL
            r13.setTransitionVisibility(r3, r0)
        L_0x0100:
            return r12
        L_0x0101:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void setMode(int i) {
        if ((i & -4) == 0) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        int namedInt = b.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }
}
