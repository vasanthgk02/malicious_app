package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);
    public static final FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat>() {
        public void obtainBounds(Object obj, Rect rect) {
            ((AccessibilityNodeInfoCompat) obj).mInfo.getBoundsInParent(rect);
        }
    };
    public static final FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
    };
    public int mAccessibilityFocusedVirtualViewId = LinearLayoutManager.INVALID_OFFSET;
    public final View mHost;
    public int mHoveredVirtualViewId = LinearLayoutManager.INVALID_OFFSET;
    public int mKeyboardFocusedVirtualViewId = LinearLayoutManager.INVALID_OFFSET;
    public final AccessibilityManager mManager;
    public MyNodeProvider mNodeProvider;
    public final int[] mTempGlobalRect = new int[2];
    public final Rect mTempParentRect = new Rect();
    public final Rect mTempScreenRect = new Rect();
    public final Rect mTempVisibleRect = new Rect();

    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        public MyNodeProvider() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i).mInfo));
        }

        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i2).mInfo));
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            if (i == -1) {
                return ViewCompat.performAccessibilityAction(exploreByTouchHelper.mHost, i2, bundle);
            }
            boolean z = true;
            if (i2 == 1) {
                return exploreByTouchHelper.requestKeyboardFocusForVirtualView(i);
            }
            if (i2 == 2) {
                return exploreByTouchHelper.clearKeyboardFocusForVirtualView(i);
            }
            if (i2 == 64) {
                if (exploreByTouchHelper.mManager.isEnabled() && exploreByTouchHelper.mManager.isTouchExplorationEnabled()) {
                    int i3 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId;
                    if (i3 != i) {
                        if (i3 != Integer.MIN_VALUE) {
                            exploreByTouchHelper.clearAccessibilityFocus(i3);
                        }
                        exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = i;
                        exploreByTouchHelper.mHost.invalidate();
                        exploreByTouchHelper.sendEventForVirtualView(i, 32768);
                        return z;
                    }
                }
                z = false;
                return z;
            } else if (i2 != 128) {
                return exploreByTouchHelper.onPerformActionForVirtualView(i, i2, bundle);
            } else {
                return exploreByTouchHelper.clearAccessibilityFocus(i);
            }
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                view.setImportantForAccessibility(1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public final boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = LinearLayoutManager.INVALID_OFFSET;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = LinearLayoutManager.INVALID_OFFSET;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final AccessibilityEvent createEvent(int i, int i2) {
        if (i != -1) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
            obtain.getText().add(obtainAccessibilityNodeInfo.getText());
            obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(obtainAccessibilityNodeInfo.mInfo.isScrollable());
            obtain.setPassword(obtainAccessibilityNodeInfo.mInfo.isPassword());
            obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
            obtain.setChecked(obtainAccessibilityNodeInfo.mInfo.isChecked());
            if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
                obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
                obtain.setSource(this.mHost, i);
                obtain.setPackageName(this.mHost.getContext().getPackageName());
                return obtain;
            }
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain(i2);
        this.mHost.onInitializeAccessibilityEvent(obtain2);
        return obtain2;
    }

    public final AccessibilityNodeInfoCompat createNodeForChild(int i) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
        accessibilityNodeInfoCompat.mInfo.setEnabled(true);
        accessibilityNodeInfoCompat.mInfo.setFocusable(true);
        accessibilityNodeInfoCompat.mInfo.setClassName("android.view.View");
        accessibilityNodeInfoCompat.mInfo.setBoundsInParent(INVALID_PARENT_BOUNDS);
        accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        accessibilityNodeInfoCompat.setParent(this.mHost);
        onPopulateNodeForVirtualView(i, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat.getText() == null && accessibilityNodeInfoCompat.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoCompat.mInfo.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            int actions = accessibilityNodeInfoCompat.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                accessibilityNodeInfoCompat.mInfo.setPackageName(this.mHost.getContext().getPackageName());
                View view = this.mHost;
                accessibilityNodeInfoCompat.mVirtualDescendantId = i;
                accessibilityNodeInfoCompat.mInfo.setSource(view, i);
                boolean z = false;
                if (this.mAccessibilityFocusedVirtualViewId == i) {
                    accessibilityNodeInfoCompat.mInfo.setAccessibilityFocused(true);
                    accessibilityNodeInfoCompat.mInfo.addAction(128);
                } else {
                    accessibilityNodeInfoCompat.mInfo.setAccessibilityFocused(false);
                    accessibilityNodeInfoCompat.mInfo.addAction(64);
                }
                boolean z2 = this.mKeyboardFocusedVirtualViewId == i;
                if (z2) {
                    accessibilityNodeInfoCompat.mInfo.addAction(2);
                } else if (accessibilityNodeInfoCompat.isFocusable()) {
                    accessibilityNodeInfoCompat.mInfo.addAction(1);
                }
                accessibilityNodeInfoCompat.mInfo.setFocused(z2);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                accessibilityNodeInfoCompat.mInfo.getBoundsInScreen(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                    accessibilityNodeInfoCompat.mInfo.getBoundsInParent(this.mTempScreenRect);
                    if (accessibilityNodeInfoCompat.mParentVirtualDescendantId != -1) {
                        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                        for (int i2 = accessibilityNodeInfoCompat.mParentVirtualDescendantId; i2 != -1; i2 = accessibilityNodeInfoCompat2.mParentVirtualDescendantId) {
                            View view2 = this.mHost;
                            accessibilityNodeInfoCompat2.mParentVirtualDescendantId = -1;
                            accessibilityNodeInfoCompat2.mInfo.setParent(view2, -1);
                            accessibilityNodeInfoCompat2.mInfo.setBoundsInParent(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i2, accessibilityNodeInfoCompat2);
                            accessibilityNodeInfoCompat2.mInfo.getBoundsInParent(this.mTempParentRect);
                            Rect rect = this.mTempScreenRect;
                            Rect rect2 = this.mTempParentRect;
                            rect.offset(rect2.left, rect2.top);
                        }
                        accessibilityNodeInfoCompat2.mInfo.recycle();
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(this.mTempScreenRect);
                        Rect rect3 = this.mTempScreenRect;
                        if (rect3 != null && !rect3.isEmpty() && this.mHost.getWindowVisibility() == 0) {
                            ViewParent parent = this.mHost.getParent();
                            while (true) {
                                if (parent instanceof View) {
                                    View view3 = (View) parent;
                                    if (view3.getAlpha() <= 0.0f || view3.getVisibility() != 0) {
                                        break;
                                    }
                                    parent = view3.getParent();
                                } else if (parent != null) {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            accessibilityNodeInfoCompat.mInfo.setVisibleToUser(true);
                        }
                    }
                }
                return accessibilityNodeInfoCompat;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r8 != Integer.MIN_VALUE) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            android.view.accessibility.AccessibilityManager r0 = r7.mManager
            boolean r0 = r0.isEnabled()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0056
            android.view.accessibility.AccessibilityManager r0 = r7.mManager
            boolean r0 = r0.isTouchExplorationEnabled()
            if (r0 != 0) goto L_0x0013
            goto L_0x0056
        L_0x0013:
            int r0 = r8.getAction()
            r3 = 7
            r4 = 256(0x100, float:3.59E-43)
            r5 = 128(0x80, float:1.8E-43)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r3) goto L_0x003a
            r3 = 9
            if (r0 == r3) goto L_0x003a
            r8 = 10
            if (r0 == r8) goto L_0x0029
            return r2
        L_0x0029:
            int r8 = r7.mHoveredVirtualViewId
            if (r8 == r6) goto L_0x0039
            if (r8 != r6) goto L_0x0030
            goto L_0x0038
        L_0x0030:
            r7.mHoveredVirtualViewId = r6
            r7.sendEventForVirtualView(r6, r5)
            r7.sendEventForVirtualView(r8, r4)
        L_0x0038:
            return r1
        L_0x0039:
            return r2
        L_0x003a:
            float r0 = r8.getX()
            float r8 = r8.getY()
            int r8 = r7.getVirtualViewAt(r0, r8)
            int r0 = r7.mHoveredVirtualViewId
            if (r0 != r8) goto L_0x004b
            goto L_0x0053
        L_0x004b:
            r7.mHoveredVirtualViewId = r8
            r7.sendEventForVirtualView(r8, r5)
            r7.sendEventForVirtualView(r0, r4)
        L_0x0053:
            if (r8 == r6) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public abstract int getVirtualViewAt(float f2, float f3);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateVirtualView(int i) {
        if (i != Integer.MIN_VALUE && this.mManager.isEnabled()) {
            ViewParent parent = this.mHost.getParent();
            if (parent != null) {
                AccessibilityEvent createEvent = createEvent(i, 2048);
                createEvent.setContentChangeTypes(0);
                parent.requestSendAccessibilityEvent(this.mHost, createEvent);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0149, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L_0x014b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0155 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean moveFocus(int r20, android.graphics.Rect r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r0.getVisibleVirtualViews(r3)
            androidx.collection.SparseArrayCompat r4 = new androidx.collection.SparseArrayCompat
            r4.<init>()
            r5 = 0
            r6 = 0
        L_0x0015:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0039
            java.lang.Object r7 = r3.get(r6)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r7 = r0.createNodeForChild(r7)
            java.lang.Object r8 = r3.get(r6)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r4.put(r8, r7)
            int r6 = r6 + 1
            goto L_0x0015
        L_0x0039:
            int r3 = r0.mKeyboardFocusedVirtualViewId
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 != r7) goto L_0x0041
            r3 = 0
            goto L_0x0047
        L_0x0041:
            java.lang.Object r3 = r4.get(r3)
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r3 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat) r3
        L_0x0047:
            r8 = 2
            r9 = -1
            r10 = 1
            if (r1 == r10) goto L_0x015a
            if (r1 == r8) goto L_0x015a
            r8 = 130(0x82, float:1.82E-43)
            r11 = 66
            r12 = 33
            r13 = 17
            if (r1 == r13) goto L_0x0067
            if (r1 == r12) goto L_0x0067
            if (r1 == r11) goto L_0x0067
            if (r1 != r8) goto L_0x005f
            goto L_0x0067
        L_0x005f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1.<init>(r2)
            throw r1
        L_0x0067:
            android.graphics.Rect r14 = new android.graphics.Rect
            r14.<init>()
            int r15 = r0.mKeyboardFocusedVirtualViewId
            java.lang.String r6 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            if (r15 == r7) goto L_0x007c
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r2 = r0.obtainAccessibilityNodeInfo(r15)
            android.view.accessibility.AccessibilityNodeInfo r2 = r2.mInfo
            r2.getBoundsInParent(r14)
            goto L_0x00a9
        L_0x007c:
            if (r2 == 0) goto L_0x0082
            r14.set(r2)
            goto L_0x00a9
        L_0x0082:
            android.view.View r2 = r0.mHost
            int r15 = r2.getWidth()
            int r2 = r2.getHeight()
            if (r1 == r13) goto L_0x00a6
            if (r1 == r12) goto L_0x00a2
            if (r1 == r11) goto L_0x009e
            if (r1 != r8) goto L_0x0098
            r14.set(r5, r9, r15, r9)
            goto L_0x00a9
        L_0x0098:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r6)
            throw r1
        L_0x009e:
            r14.set(r9, r5, r9, r2)
            goto L_0x00a9
        L_0x00a2:
            r14.set(r5, r2, r15, r2)
            goto L_0x00a9
        L_0x00a6:
            r14.set(r15, r5, r15, r2)
        L_0x00a9:
            androidx.customview.widget.FocusStrategy$CollectionAdapter<androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat>, androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r2 = SPARSE_VALUES_ADAPTER
            androidx.customview.widget.FocusStrategy$BoundsAdapter<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r15 = NODE_ADAPTER
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>(r14)
            if (r1 == r13) goto L_0x00dd
            if (r1 == r12) goto L_0x00d4
            if (r1 == r11) goto L_0x00ca
            if (r1 != r8) goto L_0x00c4
            int r6 = r14.height()
            int r6 = r6 + r10
            int r6 = -r6
            r7.offset(r5, r6)
            goto L_0x00e5
        L_0x00c4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r6)
            throw r1
        L_0x00ca:
            int r6 = r14.width()
            int r6 = r6 + r10
            int r6 = -r6
            r7.offset(r6, r5)
            goto L_0x00e5
        L_0x00d4:
            int r6 = r14.height()
            int r6 = r6 + r10
            r7.offset(r5, r6)
            goto L_0x00e5
        L_0x00dd:
            int r6 = r14.width()
            int r6 = r6 + r10
            r7.offset(r6, r5)
        L_0x00e5:
            androidx.customview.widget.ExploreByTouchHelper$2 r2 = (androidx.customview.widget.ExploreByTouchHelper.AnonymousClass2) r2
            if (r2 == 0) goto L_0x0158
            int r2 = r4.size()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            r8 = 0
            r16 = 0
        L_0x00f5:
            if (r8 >= r2) goto L_0x01cc
            boolean r11 = r4.mGarbage
            if (r11 == 0) goto L_0x00fe
            r4.gc()
        L_0x00fe:
            java.lang.Object[] r11 = r4.mValues
            r11 = r11[r8]
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r11 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat) r11
            if (r11 != r3) goto L_0x0107
            goto L_0x0155
        L_0x0107:
            r12 = r15
            androidx.customview.widget.ExploreByTouchHelper$1 r12 = (androidx.customview.widget.ExploreByTouchHelper.AnonymousClass1) r12
            r12.obtainBounds(r11, r6)
            boolean r12 = androidx.core.widget.CompoundButtonCompat.isCandidate(r14, r6, r1)
            if (r12 != 0) goto L_0x0114
            goto L_0x014d
        L_0x0114:
            boolean r12 = androidx.core.widget.CompoundButtonCompat.isCandidate(r14, r7, r1)
            if (r12 != 0) goto L_0x011b
            goto L_0x014b
        L_0x011b:
            boolean r12 = androidx.core.widget.CompoundButtonCompat.beamBeats(r1, r14, r6, r7)
            if (r12 == 0) goto L_0x0122
            goto L_0x014b
        L_0x0122:
            boolean r12 = androidx.core.widget.CompoundButtonCompat.beamBeats(r1, r14, r7, r6)
            if (r12 == 0) goto L_0x0129
            goto L_0x014d
        L_0x0129:
            int r12 = androidx.core.widget.CompoundButtonCompat.majorAxisDistance(r1, r14, r6)
            int r13 = androidx.core.widget.CompoundButtonCompat.minorAxisDistance(r1, r14, r6)
            int r17 = r12 * 13
            int r17 = r17 * r12
            int r13 = r13 * r13
            int r13 = r13 + r17
            int r12 = androidx.core.widget.CompoundButtonCompat.majorAxisDistance(r1, r14, r7)
            int r17 = androidx.core.widget.CompoundButtonCompat.minorAxisDistance(r1, r14, r7)
            int r18 = r12 * 13
            int r18 = r18 * r12
            int r17 = r17 * r17
            int r12 = r17 + r18
            if (r13 >= r12) goto L_0x014d
        L_0x014b:
            r12 = 1
            goto L_0x014e
        L_0x014d:
            r12 = 0
        L_0x014e:
            if (r12 == 0) goto L_0x0155
            r7.set(r6)
            r16 = r11
        L_0x0155:
            int r8 = r8 + 1
            goto L_0x00f5
        L_0x0158:
            r1 = 0
            throw r1
        L_0x015a:
            android.view.View r2 = r0.mHost
            int r2 = androidx.core.view.ViewCompat.getLayoutDirection(r2)
            if (r2 != r10) goto L_0x0164
            r2 = 1
            goto L_0x0165
        L_0x0164:
            r2 = 0
        L_0x0165:
            androidx.customview.widget.FocusStrategy$CollectionAdapter<androidx.collection.SparseArrayCompat<androidx.core.view.accessibility.AccessibilityNodeInfoCompat>, androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r6 = SPARSE_VALUES_ADAPTER
            androidx.customview.widget.FocusStrategy$BoundsAdapter<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> r7 = NODE_ADAPTER
            androidx.customview.widget.ExploreByTouchHelper$2 r6 = (androidx.customview.widget.ExploreByTouchHelper.AnonymousClass2) r6
            if (r6 == 0) goto L_0x01f2
            int r6 = r4.size()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r6)
            r12 = 0
        L_0x0177:
            if (r12 >= r6) goto L_0x018c
            boolean r13 = r4.mGarbage
            if (r13 == 0) goto L_0x0180
            r4.gc()
        L_0x0180:
            java.lang.Object[] r13 = r4.mValues
            r13 = r13[r12]
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r13 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat) r13
            r11.add(r13)
            int r12 = r12 + 1
            goto L_0x0177
        L_0x018c:
            androidx.customview.widget.FocusStrategy$SequentialComparator r6 = new androidx.customview.widget.FocusStrategy$SequentialComparator
            r6.<init>(r2, r7)
            java.util.Collections.sort(r11, r6)
            if (r1 == r10) goto L_0x01b6
            if (r1 != r8) goto L_0x01ae
            int r1 = r11.size()
            if (r3 != 0) goto L_0x01a0
            r2 = -1
            goto L_0x01a4
        L_0x01a0:
            int r2 = r11.lastIndexOf(r3)
        L_0x01a4:
            int r2 = r2 + r10
            if (r2 >= r1) goto L_0x01ac
            java.lang.Object r6 = r11.get(r2)
            goto L_0x01c8
        L_0x01ac:
            r6 = 0
            goto L_0x01c8
        L_0x01ae:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}."
            r1.<init>(r2)
            throw r1
        L_0x01b6:
            int r1 = r11.size()
            if (r3 != 0) goto L_0x01bd
            goto L_0x01c1
        L_0x01bd:
            int r1 = r11.indexOf(r3)
        L_0x01c1:
            int r1 = r1 + r9
            if (r1 < 0) goto L_0x01ac
            java.lang.Object r6 = r11.get(r1)
        L_0x01c8:
            r16 = r6
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r16 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat) r16
        L_0x01cc:
            r1 = r16
            if (r1 != 0) goto L_0x01d3
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x01ed
        L_0x01d3:
            boolean r2 = r4.mGarbage
            if (r2 == 0) goto L_0x01da
            r4.gc()
        L_0x01da:
            int r2 = r4.mSize
            if (r5 >= r2) goto L_0x01e9
            java.lang.Object[] r2 = r4.mValues
            r2 = r2[r5]
            if (r2 != r1) goto L_0x01e6
            r9 = r5
            goto L_0x01e9
        L_0x01e6:
            int r5 = r5 + 1
            goto L_0x01da
        L_0x01e9:
            int r7 = r4.keyAt(r9)
        L_0x01ed:
            boolean r1 = r0.requestKeyboardFocusForVirtualView(r7)
            return r1
        L_0x01f2:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.moveFocus(int, android.graphics.Rect):boolean");
    }

    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i != -1) {
            return createNodeForChild(i);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(this.mHost));
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, accessibilityNodeInfoCompat);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (accessibilityNodeInfoCompat.mInfo.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                accessibilityNodeInfoCompat.mInfo.addChild(this.mHost, ((Integer) arrayList.get(i2)).intValue());
            }
            return accessibilityNodeInfoCompat;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        if (!this.mHost.isFocused() && !this.mHost.requestFocus()) {
            return false;
        }
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled()) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        if (parent == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i, i2));
    }

    public final void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 != i) {
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }
}
