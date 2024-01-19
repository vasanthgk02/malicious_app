package androidx.core.view;

import a.a.a.a.d.b;
import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
    public boolean mIsNestedScrollingEnabled;
    public ViewParent mNestedScrollingParentNonTouch;
    public ViewParent mNestedScrollingParentTouch;
    public int[] mTempNestedScrollConsumed;
    public final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        if (this.mIsNestedScrollingEnabled) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(0);
            if (nestedScrollingParentForType != null) {
                return b.onNestedFling(nestedScrollingParentForType, this.mView, f2, f3, z);
            }
        }
        return false;
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        if (this.mIsNestedScrollingEnabled) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(0);
            if (nestedScrollingParentForType != null) {
                return b.onNestedPreFling(nestedScrollingParentForType, this.mView, f2, f3);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r13[1] == 0) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchNestedPreScroll(int r11, int r12, int[] r13, int[] r14, int r15) {
        /*
            r10 = this;
            boolean r0 = r10.mIsNestedScrollingEnabled
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005c
            android.view.ViewParent r3 = r10.getNestedScrollingParentForType(r15)
            if (r3 != 0) goto L_0x000d
            return r2
        L_0x000d:
            if (r11 != 0) goto L_0x0019
            if (r12 == 0) goto L_0x0012
            goto L_0x0019
        L_0x0012:
            if (r14 == 0) goto L_0x005c
            r14[r2] = r2
            r14[r1] = r2
            goto L_0x005c
        L_0x0019:
            if (r14 == 0) goto L_0x0026
            android.view.View r0 = r10.mView
            r0.getLocationInWindow(r14)
            r0 = r14[r2]
            r4 = r14[r1]
            r9 = r4
            goto L_0x0028
        L_0x0026:
            r0 = 0
            r9 = 0
        L_0x0028:
            if (r13 != 0) goto L_0x0035
            int[] r13 = r10.mTempNestedScrollConsumed
            if (r13 != 0) goto L_0x0033
            r13 = 2
            int[] r13 = new int[r13]
            r10.mTempNestedScrollConsumed = r13
        L_0x0033:
            int[] r13 = r10.mTempNestedScrollConsumed
        L_0x0035:
            r13[r2] = r2
            r13[r1] = r2
            android.view.View r4 = r10.mView
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r15
            a.a.a.a.d.b.onNestedPreScroll(r3, r4, r5, r6, r7, r8)
            if (r14 == 0) goto L_0x0053
            android.view.View r11 = r10.mView
            r11.getLocationInWindow(r14)
            r11 = r14[r2]
            int r11 = r11 - r0
            r14[r2] = r11
            r11 = r14[r1]
            int r11 = r11 - r9
            r14[r1] = r11
        L_0x0053:
            r11 = r13[r2]
            if (r11 != 0) goto L_0x005d
            r11 = r13[r1]
            if (r11 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r1 = 0
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.NestedScrollingChildHelper.dispatchNestedPreScroll(int, int, int[], int[], int):boolean");
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScrollInternal(i, i2, i3, i4, iArr, 0, null);
    }

    public final boolean dispatchNestedScrollInternal(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (this.mIsNestedScrollingEnabled) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i5);
            if (nestedScrollingParentForType == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                if (iArr4 != null) {
                    this.mView.getLocationInWindow(iArr4);
                    i7 = iArr4[0];
                    i6 = iArr4[1];
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                if (iArr2 == null) {
                    if (this.mTempNestedScrollConsumed == null) {
                        this.mTempNestedScrollConsumed = new int[2];
                    }
                    int[] iArr5 = this.mTempNestedScrollConsumed;
                    iArr5[0] = 0;
                    iArr5[1] = 0;
                    iArr3 = iArr5;
                } else {
                    iArr3 = iArr2;
                }
                b.onNestedScroll(nestedScrollingParentForType, this.mView, i, i2, i3, i4, i5, iArr3);
                if (iArr4 != null) {
                    this.mView.getLocationInWindow(iArr4);
                    iArr4[0] = iArr4[0] - i7;
                    iArr4[1] = iArr4[1] - i6;
                }
                return true;
            } else if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
        }
        return false;
    }

    public final ViewParent getNestedScrollingParentForType(int i) {
        if (i == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    public boolean hasNestedScrollingParent(int i) {
        return getNestedScrollingParentForType(i) != null;
    }

    public boolean startNestedScroll(int i, int i2) {
        boolean z;
        if (getNestedScrollingParentForType(i2) != null) {
            return true;
        }
        if (this.mIsNestedScrollingEnabled) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.mView;
                boolean z2 = parent instanceof NestedScrollingParent2;
                if (z2) {
                    z = ((NestedScrollingParent2) parent).onStartNestedScroll(view, view2, i, i2);
                } else {
                    if (i2 == 0) {
                        try {
                            z = parent.onStartNestedScroll(view, view2, i);
                        } catch (AbstractMethodError unused) {
                            "ViewParent " + parent + " does not implement interface method onStartNestedScroll";
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i2 == 0) {
                        this.mNestedScrollingParentTouch = parent;
                    } else if (i2 == 1) {
                        this.mNestedScrollingParentNonTouch = parent;
                    }
                    View view3 = this.mView;
                    if (z2) {
                        ((NestedScrollingParent2) parent).onNestedScrollAccepted(view, view3, i, i2);
                    } else if (i2 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i);
                        } catch (AbstractMethodError unused2) {
                            "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted";
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void stopNestedScroll(int i) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            View view = this.mView;
            if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onStopNestedScroll(view, i);
            } else if (i == 0) {
                try {
                    nestedScrollingParentForType.onStopNestedScroll(view);
                } catch (AbstractMethodError unused) {
                    "ViewParent " + nestedScrollingParentForType + " does not implement interface method onStopNestedScroll";
                }
            }
            if (i == 0) {
                this.mNestedScrollingParentTouch = null;
            } else if (i == 1) {
                this.mNestedScrollingParentNonTouch = null;
            }
        }
    }
}
