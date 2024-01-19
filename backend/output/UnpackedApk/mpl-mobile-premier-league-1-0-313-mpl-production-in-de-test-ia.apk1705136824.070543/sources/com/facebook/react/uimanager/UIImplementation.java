package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.os.Trace;
import android.view.View.MeasureSpec;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import com.facebook.systrace.SystraceMessage.NoopBuilder;
import java.util.Arrays;

public class UIImplementation {
    public final EventDispatcher mEventDispatcher;
    public long mLastCalculateLayoutTime;
    public final int[] mMeasureBuffer;
    public final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
    public final UIViewOperationQueue mOperationsQueue;
    public final ReactApplicationContext mReactContext;
    public final ShadowNodeRegistry mShadowNodeRegistry;
    public final ViewManagerRegistry mViewManagers;
    public Object uiImplementationThreadLock = new Object();

    public UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i) {
        UIViewOperationQueue uIViewOperationQueue = new UIViewOperationQueue(reactApplicationContext, new NativeViewHierarchyManager(viewManagerRegistry), i);
        ShadowNodeRegistry shadowNodeRegistry = new ShadowNodeRegistry();
        this.mShadowNodeRegistry = shadowNodeRegistry;
        this.mMeasureBuffer = new int[4];
        this.mLastCalculateLayoutTime = 0;
        this.mReactContext = reactApplicationContext;
        this.mViewManagers = viewManagerRegistry;
        this.mOperationsQueue = uIViewOperationQueue;
        this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(uIViewOperationQueue, shadowNodeRegistry);
        this.mEventDispatcher = eventDispatcher;
    }

    public void applyUpdatesRecursive(ReactShadowNode reactShadowNode, float f2, float f3) {
        if (reactShadowNode.hasUpdates()) {
            Iterable<? extends ReactShadowNode> calculateLayoutOnChildren = reactShadowNode.calculateLayoutOnChildren();
            if (calculateLayoutOnChildren != null) {
                for (ReactShadowNode applyUpdatesRecursive : calculateLayoutOnChildren) {
                    applyUpdatesRecursive(applyUpdatesRecursive, reactShadowNode.getLayoutX() + f2, reactShadowNode.getLayoutY() + f3);
                }
            }
            int reactTag = reactShadowNode.getReactTag();
            if (!this.mShadowNodeRegistry.isRootNode(reactTag) && reactShadowNode.dispatchUpdates(f2, f3, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer) && reactShadowNode.shouldNotifyOnLayout()) {
                EventDispatcher eventDispatcher = this.mEventDispatcher;
                int screenX = reactShadowNode.getScreenX();
                int screenY = reactShadowNode.getScreenY();
                int screenWidth = reactShadowNode.getScreenWidth();
                int screenHeight = reactShadowNode.getScreenHeight();
                OnLayoutEvent onLayoutEvent = (OnLayoutEvent) OnLayoutEvent.EVENTS_POOL.acquire();
                if (onLayoutEvent == null) {
                    onLayoutEvent = new OnLayoutEvent();
                }
                onLayoutEvent.mViewTag = reactTag;
                onLayoutEvent.mTimestampMs = SystemClock.uptimeMillis();
                onLayoutEvent.mInitialized = true;
                onLayoutEvent.mX = screenX;
                onLayoutEvent.mY = screenY;
                onLayoutEvent.mWidth = screenWidth;
                onLayoutEvent.mHeight = screenHeight;
                eventDispatcher.dispatchEvent(onLayoutEvent);
            }
            reactShadowNode.markUpdateSeen();
        }
    }

    public final void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode reactShadowNode) {
        ViewManager viewManager = this.mViewManagers.get(reactShadowNode.getViewClass());
        ImageOriginUtils.assertNotNull(viewManager);
        ViewManager viewManager2 = viewManager;
        if (!(viewManager2 instanceof IViewManagerWithChildren)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Trying to use view ");
            outline73.append(reactShadowNode.getViewClass());
            outline73.append(" as a parent, but its Manager doesn't extends ViewGroupManager");
            throw new IllegalViewOperationException(outline73.toString());
        } else if (((IViewManagerWithChildren) viewManager2).needsCustomLayoutForChildren()) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (");
            outline732.append(reactShadowNode.getViewClass());
            outline732.append("). Use measure instead.");
            throw new IllegalViewOperationException(outline732.toString());
        }
    }

    public final void assertViewExists(int i, String str) {
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        if (shadowNodeRegistry.mTagsToCSSNodes.get(i) == null) {
            throw new IllegalViewOperationException("Unable to execute operation " + str + " on view with tag: " + i + ", since the view does not exists");
        }
    }

    public void calculateRootLayout(ReactShadowNode reactShadowNode) {
        float f2;
        Builder builder = SystraceMessage.NOOP_BUILDER;
        reactShadowNode.getReactTag();
        NoopBuilder noopBuilder = (NoopBuilder) builder;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            int intValue = reactShadowNode.getWidthMeasureSpec().intValue();
            int intValue2 = reactShadowNode.getHeightMeasureSpec().intValue();
            float f3 = Float.NaN;
            if (MeasureSpec.getMode(intValue) == 0) {
                f2 = Float.NaN;
            } else {
                f2 = (float) MeasureSpec.getSize(intValue);
            }
            if (MeasureSpec.getMode(intValue2) != 0) {
                f3 = (float) MeasureSpec.getSize(intValue2);
            }
            reactShadowNode.calculateLayout(f2, f3);
        } finally {
            Trace.endSection();
            this.mLastCalculateLayoutTime = SystemClock.uptimeMillis() - uptimeMillis;
        }
    }

    public void dispatchViewUpdates(int i) {
        NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            updateViewHierarchy();
            this.mNativeViewHierarchyOptimizer.mTagsWithLayoutVisited.clear();
            this.mOperationsQueue.dispatchViewUpdates(i, uptimeMillis, this.mLastCalculateLayoutTime);
        } finally {
            Trace.endSection();
        }
    }

    public void handleCreateView(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        if (!reactShadowNode.isVirtual()) {
            NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = this.mNativeViewHierarchyOptimizer;
            ThemedReactContext themedContext = reactShadowNode.getThemedContext();
            if (nativeViewHierarchyOptimizer != null) {
                reactShadowNode.setIsLayoutOnly(reactShadowNode.getViewClass().equals(ReactViewManager.REACT_CLASS) && NativeViewHierarchyOptimizer.isLayoutOnlyAndCollapsable(reactStylesDiffMap));
                if (reactShadowNode.getNativeKind() != NativeKind.NONE) {
                    nativeViewHierarchyOptimizer.mUIViewOperationQueue.enqueueCreateView(themedContext, reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        int i2;
        int i3;
        int i4;
        int i5 = i;
        ReadableArray readableArray6 = readableArray;
        ReadableArray readableArray7 = readableArray2;
        ReadableArray readableArray8 = readableArray3;
        ReadableArray readableArray9 = readableArray4;
        ReadableArray readableArray10 = readableArray5;
        synchronized (this.uiImplementationThreadLock) {
            try {
                ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
                shadowNodeRegistry.mThreadAsserter.assertNow();
                ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i5);
                if (readableArray6 == null) {
                    i2 = 0;
                } else {
                    i2 = readableArray.size();
                }
                if (readableArray8 == null) {
                    i3 = 0;
                } else {
                    i3 = readableArray3.size();
                }
                if (readableArray10 == null) {
                    i4 = 0;
                } else {
                    i4 = readableArray5.size();
                }
                if (i2 != 0) {
                    if (readableArray7 == null || i2 != readableArray2.size()) {
                        throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
                    }
                }
                if (i3 != 0) {
                    if (readableArray9 == null || i3 != readableArray4.size()) {
                        throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
                    }
                }
                int i6 = i2 + i3;
                ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[i6];
                int i7 = i2 + i4;
                int[] iArr = new int[i7];
                int[] iArr2 = new int[i7];
                int i8 = i6;
                int[] iArr3 = new int[i4];
                if (i2 > 0) {
                    ImageOriginUtils.assertNotNull(readableArray);
                    ImageOriginUtils.assertNotNull(readableArray2);
                    int i9 = 0;
                    while (i9 < i2) {
                        int i10 = i7;
                        int i11 = readableArray6.getInt(i9);
                        int reactTag = reactShadowNode.getChildAt(i11).getReactTag();
                        viewAtIndexArr[i9] = new ViewAtIndex(reactTag, readableArray7.getInt(i9));
                        iArr[i9] = i11;
                        iArr2[i9] = reactTag;
                        i9++;
                        readableArray6 = readableArray;
                        i7 = i10;
                        iArr3 = iArr3;
                        reactShadowNode = reactShadowNode;
                    }
                }
                ReactShadowNode reactShadowNode2 = reactShadowNode;
                int[] iArr4 = iArr3;
                int i12 = i7;
                if (i3 > 0) {
                    ImageOriginUtils.assertNotNull(readableArray3);
                    ImageOriginUtils.assertNotNull(readableArray4);
                    for (int i13 = 0; i13 < i3; i13++) {
                        viewAtIndexArr[i2 + i13] = new ViewAtIndex(readableArray8.getInt(i13), readableArray9.getInt(i13));
                    }
                }
                if (i4 > 0) {
                    ImageOriginUtils.assertNotNull(readableArray5);
                    int i14 = 0;
                    while (i14 < i4) {
                        int i15 = readableArray10.getInt(i14);
                        ReactShadowNode reactShadowNode3 = reactShadowNode2;
                        int reactTag2 = reactShadowNode3.getChildAt(i15).getReactTag();
                        int i16 = i2 + i14;
                        iArr[i16] = i15;
                        iArr2[i16] = reactTag2;
                        iArr4[i14] = reactTag2;
                        i14++;
                        reactShadowNode2 = reactShadowNode3;
                    }
                }
                ReactShadowNode reactShadowNode4 = reactShadowNode2;
                Arrays.sort(viewAtIndexArr, ViewAtIndex.COMPARATOR);
                Arrays.sort(iArr);
                int i17 = i12 - 1;
                int i18 = -1;
                while (i17 >= 0) {
                    if (iArr[i17] != i18) {
                        reactShadowNode4.removeChildAt(iArr[i17]);
                        i18 = iArr[i17];
                        i17--;
                    } else {
                        throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + i);
                    }
                }
                int i19 = 0;
                while (true) {
                    int i20 = i8;
                    if (i19 < i20) {
                        ViewAtIndex viewAtIndex = viewAtIndexArr[i19];
                        int[] iArr5 = iArr2;
                        ReactShadowNode node = this.mShadowNodeRegistry.getNode(viewAtIndex.mTag);
                        if (node != null) {
                            reactShadowNode4.addChildAt(node, viewAtIndex.mIndex);
                            i19++;
                            iArr2 = iArr5;
                            i8 = i20;
                        } else {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.mTag);
                        }
                    } else {
                        int[] iArr6 = iArr2;
                        int[] iArr7 = iArr4;
                        this.mNativeViewHierarchyOptimizer.handleManageChildren(reactShadowNode4, iArr6, viewAtIndexArr, iArr7);
                        for (int i21 = 0; i21 < i4; i21++) {
                            ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(iArr7[i21]);
                            removeShadowNodeRecursive(node2);
                            node2.dispose();
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final void measureLayout(int i, int i2, int[] iArr) {
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        ShadowNodeRegistry shadowNodeRegistry2 = this.mShadowNodeRegistry;
        shadowNodeRegistry2.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode2 = shadowNodeRegistry2.mTagsToCSSNodes.get(i2);
        if (reactShadowNode == null || reactShadowNode2 == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Tag ");
            if (reactShadowNode != null) {
                i = i2;
            }
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline57(outline73, i, " does not exist"));
        }
        if (reactShadowNode != reactShadowNode2) {
            ReactShadowNode parent = reactShadowNode.getParent();
            while (parent != reactShadowNode2) {
                if (parent != null) {
                    parent = parent.getParent();
                } else {
                    throw new IllegalViewOperationException(GeneratedOutlineSupport.outline43("Tag ", i2, " is not an ancestor of tag ", i));
                }
            }
        }
        measureLayoutRelativeToVerifiedAncestor(reactShadowNode, reactShadowNode2, iArr);
    }

    public final void measureLayoutRelativeToParent(int i, int[] iArr) {
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        if (reactShadowNode != null) {
            ReactShadowNode parent = reactShadowNode.getParent();
            if (parent != null) {
                measureLayoutRelativeToVerifiedAncestor(reactShadowNode, parent, iArr);
                return;
            }
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline42("View with tag ", i, " doesn't have a parent!"));
        }
        throw new IllegalViewOperationException(GeneratedOutlineSupport.outline42("No native view for tag ", i, " exists!"));
    }

    public final void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int[] iArr) {
        int i;
        int i2;
        if (reactShadowNode != reactShadowNode2) {
            i2 = Math.round(reactShadowNode.getLayoutX());
            i = Math.round(reactShadowNode.getLayoutY());
            for (ReactShadowNode parent = reactShadowNode.getParent(); parent != reactShadowNode2; parent = parent.getParent()) {
                ImageOriginUtils.assertNotNull(parent);
                assertNodeDoesNotNeedCustomLayoutForChildren(parent);
                i2 += Math.round(parent.getLayoutX());
                i += Math.round(parent.getLayoutY());
            }
            assertNodeDoesNotNeedCustomLayoutForChildren(reactShadowNode2);
        } else {
            i2 = 0;
            i = 0;
        }
        iArr[0] = i2;
        iArr[1] = i;
        iArr[2] = reactShadowNode.getScreenWidth();
        iArr[3] = reactShadowNode.getScreenHeight();
    }

    public final void notifyOnBeforeLayoutRecursive(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.hasUpdates()) {
            for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
                notifyOnBeforeLayoutRecursive(reactShadowNode.getChildAt(i));
            }
            reactShadowNode.onBeforeLayout(this.mNativeViewHierarchyOptimizer);
        }
    }

    public final void removeShadowNodeRecursive(ReactShadowNode reactShadowNode) {
        reactShadowNode.removeAllNativeChildren();
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        int reactTag = reactShadowNode.getReactTag();
        shadowNodeRegistry.mThreadAsserter.assertNow();
        if (!shadowNodeRegistry.mRootTags.get(reactTag)) {
            shadowNodeRegistry.mTagsToCSSNodes.remove(reactTag);
            int childCount = reactShadowNode.getChildCount();
            while (true) {
                childCount--;
                if (childCount >= 0) {
                    removeShadowNodeRecursive(reactShadowNode.getChildAt(childCount));
                } else {
                    reactShadowNode.removeAndDisposeAllChildren();
                    return;
                }
            }
        } else {
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline42("Trying to remove root node ", reactTag, " without using removeRootNode!"));
        }
    }

    public final ReactShadowNode resolveShadowNode(int i) {
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        return shadowNodeRegistry.mTagsToCSSNodes.get(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateViewHierarchy() {
        /*
            r3 = this;
            java.lang.String r0 = "UIImplementation.updateViewHierarchy"
            android.os.Trace.beginSection(r0)
            r0 = 0
        L_0x0006:
            com.facebook.react.uimanager.ShadowNodeRegistry r1 = r3.mShadowNodeRegistry     // Catch:{ all -> 0x0053 }
            com.facebook.react.common.SingleThreadAsserter r2 = r1.mThreadAsserter     // Catch:{ all -> 0x0053 }
            r2.assertNow()     // Catch:{ all -> 0x0053 }
            android.util.SparseBooleanArray r1 = r1.mRootTags     // Catch:{ all -> 0x0053 }
            int r1 = r1.size()     // Catch:{ all -> 0x0053 }
            if (r0 >= r1) goto L_0x0062
            com.facebook.react.uimanager.ShadowNodeRegistry r1 = r3.mShadowNodeRegistry     // Catch:{ all -> 0x0053 }
            com.facebook.react.common.SingleThreadAsserter r2 = r1.mThreadAsserter     // Catch:{ all -> 0x0053 }
            r2.assertNow()     // Catch:{ all -> 0x0053 }
            android.util.SparseBooleanArray r1 = r1.mRootTags     // Catch:{ all -> 0x0053 }
            int r1 = r1.keyAt(r0)     // Catch:{ all -> 0x0053 }
            com.facebook.react.uimanager.ShadowNodeRegistry r2 = r3.mShadowNodeRegistry     // Catch:{ all -> 0x0053 }
            com.facebook.react.uimanager.ReactShadowNode r1 = r2.getNode(r1)     // Catch:{ all -> 0x0053 }
            java.lang.Integer r2 = r1.getWidthMeasureSpec()     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x005f
            java.lang.Integer r2 = r1.getHeightMeasureSpec()     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x005f
            com.facebook.systrace.SystraceMessage$Builder r2 = com.facebook.systrace.SystraceMessage.NOOP_BUILDER     // Catch:{ all -> 0x0053 }
            r1.getReactTag()     // Catch:{ all -> 0x0053 }
            com.facebook.systrace.SystraceMessage$NoopBuilder r2 = (com.facebook.systrace.SystraceMessage.NoopBuilder) r2     // Catch:{ all -> 0x0053 }
            r3.notifyOnBeforeLayoutRecursive(r1)     // Catch:{ all -> 0x005a }
            android.os.Trace.endSection()     // Catch:{ all -> 0x0053 }
            r3.calculateRootLayout(r1)     // Catch:{ all -> 0x0053 }
            com.facebook.systrace.SystraceMessage$Builder r2 = com.facebook.systrace.SystraceMessage.NOOP_BUILDER     // Catch:{ all -> 0x0053 }
            r1.getReactTag()     // Catch:{ all -> 0x0053 }
            com.facebook.systrace.SystraceMessage$NoopBuilder r2 = (com.facebook.systrace.SystraceMessage.NoopBuilder) r2     // Catch:{ all -> 0x0053 }
            r2 = 0
            r3.applyUpdatesRecursive(r1, r2, r2)     // Catch:{ all -> 0x0055 }
            android.os.Trace.endSection()     // Catch:{ all -> 0x0053 }
            goto L_0x005f
        L_0x0053:
            r0 = move-exception
            goto L_0x0066
        L_0x0055:
            r0 = move-exception
            android.os.Trace.endSection()     // Catch:{ all -> 0x0053 }
            throw r0     // Catch:{ all -> 0x0053 }
        L_0x005a:
            r0 = move-exception
            android.os.Trace.endSection()     // Catch:{ all -> 0x0053 }
            throw r0     // Catch:{ all -> 0x0053 }
        L_0x005f:
            int r0 = r0 + 1
            goto L_0x0006
        L_0x0062:
            android.os.Trace.endSection()
            return
        L_0x0066:
            android.os.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIImplementation.updateViewHierarchy():void");
    }
}
