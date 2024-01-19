package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.os.Trace;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.NativeViewHierarchyManager.PopupMenuCallbackHandler;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationType;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.NoopBuilder;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class UIViewOperationQueue {
    public final boolean mAllowViewCommandsQueue;
    public long mCreateViewCount;
    public final Object mDispatchRunnablesLock = new Object();
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    public ArrayList<Runnable> mDispatchUIRunnables = new ArrayList<>();
    public boolean mIsDispatchUIFrameCallbackEnqueued = false;
    public boolean mIsInIllegalUIState = false;
    public boolean mIsProfilingNextBatch = false;
    public final int[] mMeasureBuffer = new int[4];
    public final NativeViewHierarchyManager mNativeViewHierarchyManager;
    public long mNonBatchedExecutionTotalTime;
    public ArrayDeque<UIOperation> mNonBatchedOperations = new ArrayDeque<>();
    public final Object mNonBatchedOperationsLock = new Object();
    public ArrayList<UIOperation> mOperations = new ArrayList<>();
    public long mProfiledBatchBatchedExecutionTime;
    public long mProfiledBatchCommitEndTime;
    public long mProfiledBatchCommitStartTime;
    public long mProfiledBatchDispatchViewUpdatesTime;
    public long mProfiledBatchLayoutTime;
    public long mProfiledBatchNonBatchedExecutionTime;
    public long mProfiledBatchRunEndTime;
    public long mProfiledBatchRunStartTime;
    public final ReactApplicationContext mReactApplicationContext;
    public long mThreadCpuTime;
    public long mUpdatePropertiesOperationCount;
    public ArrayList<DispatchCommandViewOperation> mViewCommandOperations = new ArrayList<>();
    public NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;

    public final class ChangeJSResponderOperation extends ViewOperation {
        public final boolean mBlockNativeResponder;
        public final boolean mClearResponder;
        public final int mInitialTag;

        public ChangeJSResponderOperation(int i, int i2, boolean z, boolean z2) {
            super(UIViewOperationQueue.this, i);
            this.mInitialTag = i2;
            this.mClearResponder = z;
            this.mBlockNativeResponder = z2;
        }

        public void execute() {
            if (!this.mClearResponder) {
                NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
                int i = this.mTag;
                int i2 = this.mInitialTag;
                boolean z = this.mBlockNativeResponder;
                synchronized (nativeViewHierarchyManager) {
                    if (!z) {
                        nativeViewHierarchyManager.mJSResponderHandler.setJSResponder(i2, null);
                        return;
                    }
                    View view = nativeViewHierarchyManager.mTagsToViews.get(i);
                    if (i2 == i || !(view instanceof ViewParent)) {
                        if (nativeViewHierarchyManager.mRootTags.get(i)) {
                            SoftAssertions.assertUnreachable("Cannot block native responder on " + i + " that is a root view");
                        }
                        nativeViewHierarchyManager.mJSResponderHandler.setJSResponder(i2, view.getParent());
                        return;
                    }
                    nativeViewHierarchyManager.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
                    return;
                }
            }
            JSResponderHandler jSResponderHandler = UIViewOperationQueue.this.mNativeViewHierarchyManager.mJSResponderHandler;
            jSResponderHandler.mCurrentJSResponder = -1;
            ViewParent viewParent = jSResponderHandler.mViewParentBlockingNativeResponder;
            if (viewParent != null) {
                viewParent.requestDisallowInterceptTouchEvent(false);
                jSResponderHandler.mViewParentBlockingNativeResponder = null;
            }
        }
    }

    public class ConfigureLayoutAnimationOperation implements UIOperation {
        public final Callback mAnimationComplete;
        public final ReadableMap mConfig;

        public ConfigureLayoutAnimationOperation(ReadableMap readableMap, Callback callback, AnonymousClass1 r4) {
            this.mConfig = readableMap;
            this.mAnimationComplete = callback;
        }

        public void execute() {
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            ReadableMap readableMap = this.mConfig;
            Callback callback = this.mAnimationComplete;
            LayoutAnimationController layoutAnimationController = nativeViewHierarchyManager.mLayoutAnimator;
            if (readableMap == null) {
                layoutAnimationController.reset();
                return;
            }
            int i = 0;
            layoutAnimationController.mShouldAnimateLayout = false;
            if (readableMap.hasKey(InlineAnimation.DURATION)) {
                i = readableMap.getInt(InlineAnimation.DURATION);
            }
            if (readableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.CREATE))) {
                layoutAnimationController.mLayoutCreateAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.CREATE)), i);
                layoutAnimationController.mShouldAnimateLayout = true;
            }
            if (readableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.UPDATE))) {
                layoutAnimationController.mLayoutUpdateAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.UPDATE)), i);
                layoutAnimationController.mShouldAnimateLayout = true;
            }
            if (readableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.DELETE))) {
                layoutAnimationController.mLayoutDeleteAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.DELETE)), i);
                layoutAnimationController.mShouldAnimateLayout = true;
            }
            if (layoutAnimationController.mShouldAnimateLayout && callback != null) {
                layoutAnimationController.mCompletionRunnable = new Runnable(layoutAnimationController, callback) {
                    public final /* synthetic */ Callback val$completionCallback;

                    {
                        this.val$completionCallback = r2;
                    }

                    public void run() {
                        this.val$completionCallback.invoke(Boolean.TRUE);
                    }
                };
            }
        }
    }

    public final class CreateViewOperation extends ViewOperation {
        public final String mClassName;
        public final ReactStylesDiffMap mInitialProps;
        public final ThemedReactContext mThemedContext;

        public CreateViewOperation(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
            super(UIViewOperationQueue.this, i);
            this.mThemedContext = themedReactContext;
            this.mClassName = str;
            this.mInitialProps = reactStylesDiffMap;
        }

        public void execute() {
            int i = this.mTag;
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            ThemedReactContext themedReactContext = this.mThemedContext;
            String str = this.mClassName;
            ReactStylesDiffMap reactStylesDiffMap = this.mInitialProps;
            synchronized (nativeViewHierarchyManager) {
                UiThreadUtil.assertOnUiThread();
                NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
                try {
                    ViewManager viewManager = nativeViewHierarchyManager.mViewManagers.get(str);
                    View createView = viewManager.createView(themedReactContext, null, null, nativeViewHierarchyManager.mJSResponderHandler);
                    nativeViewHierarchyManager.mTagsToViews.put(i, createView);
                    nativeViewHierarchyManager.mTagsToViewManagers.put(i, viewManager);
                    createView.setId(i);
                    if (reactStylesDiffMap != null) {
                        viewManager.updateProperties(createView, reactStylesDiffMap);
                    }
                } finally {
                    Trace.endSection();
                }
            }
        }
    }

    public final class DismissPopupMenuOperation implements UIOperation {
        public DismissPopupMenuOperation(AnonymousClass1 r2) {
        }

        public void execute() {
            PopupMenu popupMenu = UIViewOperationQueue.this.mNativeViewHierarchyManager.mPopupMenu;
            if (popupMenu != null) {
                popupMenu.dismiss();
            }
        }
    }

    @Deprecated
    public final class DispatchCommandOperation extends ViewOperation implements DispatchCommandViewOperation {
        public final ReadableArray mArgs;
        public final int mCommand;
        public int numRetries = 0;

        public DispatchCommandOperation(int i, int i2, ReadableArray readableArray) {
            super(UIViewOperationQueue.this, i);
            this.mCommand = i2;
            this.mArgs = readableArray;
        }

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
            } catch (Throwable th) {
                ReactSoftException.logSoftException("UIViewOperationQueue", new RuntimeException("Error dispatching View Command", th));
            }
        }

        public void executeWithExceptions() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }

        public int getRetries() {
            return this.numRetries;
        }

        public void incrementRetries() {
            this.numRetries++;
        }
    }

    public interface DispatchCommandViewOperation {
        void executeWithExceptions();

        int getRetries();

        void incrementRetries();
    }

    public final class DispatchStringCommandOperation extends ViewOperation implements DispatchCommandViewOperation {
        public final ReadableArray mArgs;
        public final String mCommand;
        public int numRetries = 0;

        public DispatchStringCommandOperation(int i, String str, ReadableArray readableArray) {
            super(UIViewOperationQueue.this, i);
            this.mCommand = str;
            this.mArgs = readableArray;
        }

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
            } catch (Throwable th) {
                ReactSoftException.logSoftException("UIViewOperationQueue", new RuntimeException("Error dispatching View Command", th));
            }
        }

        public void executeWithExceptions() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }

        public int getRetries() {
            return this.numRetries;
        }

        public void incrementRetries() {
            this.numRetries++;
        }
    }

    public class DispatchUIFrameCallback extends GuardedFrameCallback {
        public final int mMinTimeLeftInFrameForNonBatchedOperationMs;

        public DispatchUIFrameCallback(ReactContext reactContext, int i, AnonymousClass1 r4) {
            super(reactContext);
            this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = android.os.SystemClock.uptimeMillis();
            r1.execute();
            r8.this$0.mNonBatchedExecutionTotalTime = (android.os.SystemClock.uptimeMillis() - r2) + r8.this$0.mNonBatchedExecutionTotalTime;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
            r8.this$0.mIsInIllegalUIState = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
            throw r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dispatchPendingNonBatchedOperations(long r9) {
            /*
                r8 = this;
            L_0x0000:
                r0 = 16
                long r2 = java.lang.System.nanoTime()
                long r2 = r2 - r9
                r4 = 1000000(0xf4240, double:4.940656E-318)
                long r2 = r2 / r4
                long r0 = r0 - r2
                int r2 = r8.mMinTimeLeftInFrameForNonBatchedOperationMs
                long r2 = (long) r2
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x0014
                goto L_0x0024
            L_0x0014:
                com.facebook.react.uimanager.UIViewOperationQueue r0 = com.facebook.react.uimanager.UIViewOperationQueue.this
                java.lang.Object r0 = r0.mNonBatchedOperationsLock
                monitor-enter(r0)
                com.facebook.react.uimanager.UIViewOperationQueue r1 = com.facebook.react.uimanager.UIViewOperationQueue.this     // Catch:{ all -> 0x004d }
                java.util.ArrayDeque<com.facebook.react.uimanager.UIViewOperationQueue$UIOperation> r1 = r1.mNonBatchedOperations     // Catch:{ all -> 0x004d }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x004d }
                if (r1 == 0) goto L_0x0025
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
            L_0x0024:
                return
            L_0x0025:
                com.facebook.react.uimanager.UIViewOperationQueue r1 = com.facebook.react.uimanager.UIViewOperationQueue.this     // Catch:{ all -> 0x004d }
                java.util.ArrayDeque<com.facebook.react.uimanager.UIViewOperationQueue$UIOperation> r1 = r1.mNonBatchedOperations     // Catch:{ all -> 0x004d }
                java.lang.Object r1 = r1.pollFirst()     // Catch:{ all -> 0x004d }
                com.facebook.react.uimanager.UIViewOperationQueue$UIOperation r1 = (com.facebook.react.uimanager.UIViewOperationQueue.UIOperation) r1     // Catch:{ all -> 0x004d }
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
                long r2 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0046 }
                r1.execute()     // Catch:{ Exception -> 0x0046 }
                com.facebook.react.uimanager.UIViewOperationQueue r0 = com.facebook.react.uimanager.UIViewOperationQueue.this     // Catch:{ Exception -> 0x0046 }
                com.facebook.react.uimanager.UIViewOperationQueue r1 = com.facebook.react.uimanager.UIViewOperationQueue.this     // Catch:{ Exception -> 0x0046 }
                long r4 = r1.mNonBatchedExecutionTotalTime     // Catch:{ Exception -> 0x0046 }
                long r6 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0046 }
                long r6 = r6 - r2
                long r6 = r6 + r4
                r0.mNonBatchedExecutionTotalTime = r6     // Catch:{ Exception -> 0x0046 }
                goto L_0x0000
            L_0x0046:
                r9 = move-exception
                com.facebook.react.uimanager.UIViewOperationQueue r10 = com.facebook.react.uimanager.UIViewOperationQueue.this
                r0 = 1
                r10.mIsInIllegalUIState = r0
                throw r9
            L_0x004d:
                r9 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.DispatchUIFrameCallback.dispatchPendingNonBatchedOperations(long):void");
        }

        /* JADX INFO: finally extract failed */
        public void doFrameGuarded(long j) {
            if (UIViewOperationQueue.this.mIsInIllegalUIState) {
                FLog.w((String) "ReactNative", (String) "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            Trace.beginSection("dispatchNonBatchedUIOperations");
            try {
                dispatchPendingNonBatchedOperations(j);
                Trace.endSection();
                UIViewOperationQueue.this.flushPendingBatches();
                ReactChoreographer.getInstance().postFrameCallback(CallbackType.DISPATCH_UI, this);
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    public final class FindTargetForTouchOperation implements UIOperation {
        public final Callback mCallback;
        public final int mReactTag;
        public final float mTargetX;
        public final float mTargetY;

        public FindTargetForTouchOperation(int i, float f2, float f3, Callback callback, AnonymousClass1 r6) {
            this.mReactTag = i;
            this.mTargetX = f2;
            this.mTargetY = f3;
            this.mCallback = callback;
        }

        public void execute() {
            int findTargetTagAndCoordinatesForTouch;
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
                int[] iArr = uIViewOperationQueue.mMeasureBuffer;
                float f2 = (float) iArr[0];
                float f3 = (float) iArr[1];
                NativeViewHierarchyManager nativeViewHierarchyManager = uIViewOperationQueue.mNativeViewHierarchyManager;
                int i = this.mReactTag;
                float f4 = this.mTargetX;
                float f5 = this.mTargetY;
                synchronized (nativeViewHierarchyManager) {
                    UiThreadUtil.assertOnUiThread();
                    View view = nativeViewHierarchyManager.mTagsToViews.get(i);
                    if (view != null) {
                        findTargetTagAndCoordinatesForTouch = TouchTargetHelper.findTargetTagAndCoordinatesForTouch(f4, f5, (ViewGroup) view, TouchTargetHelper.mEventCoords, null);
                    } else {
                        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
                    }
                }
                try {
                    UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(findTargetTagAndCoordinatesForTouch, UIViewOperationQueue.this.mMeasureBuffer);
                    float dIPFromPixel = ImageOriginUtils.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[0]) - f2);
                    float dIPFromPixel2 = ImageOriginUtils.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[1]) - f3);
                    float dIPFromPixel3 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                    float dIPFromPixel4 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                    this.mCallback.invoke(Integer.valueOf(findTargetTagAndCoordinatesForTouch), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
                } catch (IllegalViewOperationException unused) {
                    this.mCallback.invoke(new Object[0]);
                }
            } catch (IllegalViewOperationException unused2) {
                this.mCallback.invoke(new Object[0]);
            }
        }
    }

    public final class ManageChildrenOperation extends ViewOperation {
        public final int[] mIndicesToRemove;
        public final int[] mTagsToDelete;
        public final ViewAtIndex[] mViewsToAdd;

        public ManageChildrenOperation(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
            super(UIViewOperationQueue.this, i);
            this.mIndicesToRemove = iArr;
            this.mViewsToAdd = viewAtIndexArr;
            this.mTagsToDelete = iArr2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r20 = this;
                r1 = r20
                com.facebook.react.uimanager.UIViewOperationQueue r0 = com.facebook.react.uimanager.UIViewOperationQueue.this
                com.facebook.react.uimanager.NativeViewHierarchyManager r9 = r0.mNativeViewHierarchyManager
                int r0 = r1.mTag
                int[] r10 = r1.mIndicesToRemove
                com.facebook.react.uimanager.ViewAtIndex[] r11 = r1.mViewsToAdd
                int[] r12 = r1.mTagsToDelete
                monitor-enter(r9)
                com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()     // Catch:{ all -> 0x0224 }
                java.util.Set r13 = r9.getPendingDeletionsForTag(r0)     // Catch:{ all -> 0x0224 }
                android.util.SparseArray<android.view.View> r2 = r9.mTagsToViews     // Catch:{ all -> 0x0224 }
                java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0224 }
                r14 = r2
                android.view.ViewGroup r14 = (android.view.ViewGroup) r14     // Catch:{ all -> 0x0224 }
                com.facebook.react.uimanager.ViewManager r2 = r9.resolveViewManager(r0)     // Catch:{ all -> 0x0224 }
                r15 = r2
                com.facebook.react.uimanager.ViewGroupManager r15 = (com.facebook.react.uimanager.ViewGroupManager) r15     // Catch:{ all -> 0x0224 }
                if (r14 == 0) goto L_0x01ff
                int r2 = r15.getChildCount(r14)     // Catch:{ all -> 0x0224 }
                r16 = 0
                if (r10 == 0) goto L_0x0102
                int r3 = r10.length     // Catch:{ all -> 0x0224 }
                r4 = 1
                int r3 = r3 - r4
            L_0x0033:
                if (r3 < 0) goto L_0x0102
                r5 = r10[r3]     // Catch:{ all -> 0x0224 }
                if (r5 < 0) goto L_0x00d7
                int r6 = r15.getChildCount(r14)     // Catch:{ all -> 0x0224 }
                if (r5 < r6) goto L_0x007b
                android.util.SparseBooleanArray r2 = r9.mRootTags     // Catch:{ all -> 0x0224 }
                boolean r2 = r2.get(r0)     // Catch:{ all -> 0x0224 }
                if (r2 == 0) goto L_0x0050
                int r2 = r15.getChildCount(r14)     // Catch:{ all -> 0x0224 }
                if (r2 != 0) goto L_0x0050
                monitor-exit(r9)
                goto L_0x01fe
            L_0x0050:
                com.facebook.react.uimanager.IllegalViewOperationException r2 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0224 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
                r3.<init>()     // Catch:{ all -> 0x0224 }
                java.lang.String r4 = "Trying to remove a view index above child count "
                r3.append(r4)     // Catch:{ all -> 0x0224 }
                r3.append(r5)     // Catch:{ all -> 0x0224 }
                java.lang.String r4 = " view tag: "
                r3.append(r4)     // Catch:{ all -> 0x0224 }
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = "\n detail: "
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = com.facebook.react.uimanager.NativeViewHierarchyManager.constructManageChildrenErrorMessage(r14, r15, r10, r11, r12)     // Catch:{ all -> 0x0224 }
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0224 }
                r2.<init>(r0)     // Catch:{ all -> 0x0224 }
                throw r2     // Catch:{ all -> 0x0224 }
            L_0x007b:
                if (r5 >= r2) goto L_0x00ac
                android.view.View r2 = r15.getChildAt(r14, r5)     // Catch:{ all -> 0x0224 }
                boolean r6 = r9.mLayoutAnimationEnabled     // Catch:{ all -> 0x0224 }
                if (r6 == 0) goto L_0x00a5
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationController r6 = r9.mLayoutAnimator     // Catch:{ all -> 0x0224 }
                boolean r6 = r6.shouldAnimateLayout(r2)     // Catch:{ all -> 0x0224 }
                if (r6 == 0) goto L_0x00a5
                int r2 = r2.getId()     // Catch:{ all -> 0x0224 }
                if (r12 != 0) goto L_0x0094
                goto L_0x00a1
            L_0x0094:
                int r6 = r12.length     // Catch:{ all -> 0x0224 }
                r7 = 0
            L_0x0096:
                if (r7 >= r6) goto L_0x00a1
                r8 = r12[r7]     // Catch:{ all -> 0x0224 }
                if (r8 != r2) goto L_0x009e
                r2 = 1
                goto L_0x00a2
            L_0x009e:
                int r7 = r7 + 1
                goto L_0x0096
            L_0x00a1:
                r2 = 0
            L_0x00a2:
                if (r2 == 0) goto L_0x00a5
                goto L_0x00a8
            L_0x00a5:
                r15.removeViewAt(r14, r5)     // Catch:{ all -> 0x0224 }
            L_0x00a8:
                int r3 = r3 + -1
                r2 = r5
                goto L_0x0033
            L_0x00ac:
                com.facebook.react.uimanager.IllegalViewOperationException r2 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0224 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
                r3.<init>()     // Catch:{ all -> 0x0224 }
                java.lang.String r4 = "Trying to remove an out of order view index:"
                r3.append(r4)     // Catch:{ all -> 0x0224 }
                r3.append(r5)     // Catch:{ all -> 0x0224 }
                java.lang.String r4 = " view tag: "
                r3.append(r4)     // Catch:{ all -> 0x0224 }
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = "\n detail: "
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = com.facebook.react.uimanager.NativeViewHierarchyManager.constructManageChildrenErrorMessage(r14, r15, r10, r11, r12)     // Catch:{ all -> 0x0224 }
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0224 }
                r2.<init>(r0)     // Catch:{ all -> 0x0224 }
                throw r2     // Catch:{ all -> 0x0224 }
            L_0x00d7:
                com.facebook.react.uimanager.IllegalViewOperationException r2 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0224 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
                r3.<init>()     // Catch:{ all -> 0x0224 }
                java.lang.String r4 = "Trying to remove a negative view index:"
                r3.append(r4)     // Catch:{ all -> 0x0224 }
                r3.append(r5)     // Catch:{ all -> 0x0224 }
                java.lang.String r4 = " view tag: "
                r3.append(r4)     // Catch:{ all -> 0x0224 }
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = "\n detail: "
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = com.facebook.react.uimanager.NativeViewHierarchyManager.constructManageChildrenErrorMessage(r14, r15, r10, r11, r12)     // Catch:{ all -> 0x0224 }
                r3.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0224 }
                r2.<init>(r0)     // Catch:{ all -> 0x0224 }
                throw r2     // Catch:{ all -> 0x0224 }
            L_0x0102:
                if (r12 == 0) goto L_0x0181
                r8 = 0
            L_0x0105:
                int r2 = r12.length     // Catch:{ all -> 0x0224 }
                if (r8 >= r2) goto L_0x0181
                r2 = r12[r8]     // Catch:{ all -> 0x0224 }
                android.util.SparseArray<android.view.View> r3 = r9.mTagsToViews     // Catch:{ all -> 0x0224 }
                java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0224 }
                r7 = r3
                android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0224 }
                if (r7 == 0) goto L_0x0156
                boolean r3 = r9.mLayoutAnimationEnabled     // Catch:{ all -> 0x0224 }
                if (r3 == 0) goto L_0x0143
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationController r3 = r9.mLayoutAnimator     // Catch:{ all -> 0x0224 }
                boolean r3 = r3.shouldAnimateLayout(r7)     // Catch:{ all -> 0x0224 }
                if (r3 == 0) goto L_0x0143
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0224 }
                r13.add(r2)     // Catch:{ all -> 0x0224 }
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationController r6 = r9.mLayoutAnimator     // Catch:{ all -> 0x0224 }
                com.facebook.react.uimanager.NativeViewHierarchyManager$1 r5 = new com.facebook.react.uimanager.NativeViewHierarchyManager$1     // Catch:{ all -> 0x0224 }
                r2 = r5
                r3 = r9
                r4 = r15
                r1 = r5
                r5 = r14
                r17 = r10
                r10 = r6
                r6 = r7
                r18 = r11
                r11 = r7
                r7 = r13
                r19 = r8
                r8 = r0
                r2.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0224 }
                r10.deleteView(r11, r1)     // Catch:{ all -> 0x0224 }
                goto L_0x014d
            L_0x0143:
                r19 = r8
                r17 = r10
                r18 = r11
                r11 = r7
                r9.dropView(r11)     // Catch:{ all -> 0x0224 }
            L_0x014d:
                int r8 = r19 + 1
                r1 = r20
                r10 = r17
                r11 = r18
                goto L_0x0105
            L_0x0156:
                r17 = r10
                r18 = r11
                com.facebook.react.uimanager.IllegalViewOperationException r0 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0224 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
                r1.<init>()     // Catch:{ all -> 0x0224 }
                java.lang.String r3 = "Trying to destroy unknown view tag: "
                r1.append(r3)     // Catch:{ all -> 0x0224 }
                r1.append(r2)     // Catch:{ all -> 0x0224 }
                java.lang.String r2 = "\n detail: "
                r1.append(r2)     // Catch:{ all -> 0x0224 }
                r2 = r17
                r3 = r18
                java.lang.String r2 = com.facebook.react.uimanager.NativeViewHierarchyManager.constructManageChildrenErrorMessage(r14, r15, r2, r3, r12)     // Catch:{ all -> 0x0224 }
                r1.append(r2)     // Catch:{ all -> 0x0224 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0224 }
                r0.<init>(r1)     // Catch:{ all -> 0x0224 }
                throw r0     // Catch:{ all -> 0x0224 }
            L_0x0181:
                r2 = r10
                r3 = r11
                if (r3 == 0) goto L_0x01ee
                r1 = 0
            L_0x0186:
                int r4 = r3.length     // Catch:{ all -> 0x0224 }
                if (r1 >= r4) goto L_0x01ee
                r4 = r3[r1]     // Catch:{ all -> 0x0224 }
                android.util.SparseArray<android.view.View> r5 = r9.mTagsToViews     // Catch:{ all -> 0x0224 }
                int r6 = r4.mTag     // Catch:{ all -> 0x0224 }
                java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x0224 }
                android.view.View r5 = (android.view.View) r5     // Catch:{ all -> 0x0224 }
                if (r5 == 0) goto L_0x01c9
                int r6 = r4.mIndex     // Catch:{ all -> 0x0224 }
                boolean r7 = r13.isEmpty()     // Catch:{ all -> 0x0224 }
                if (r7 != 0) goto L_0x01c3
                r6 = 0
                r7 = 0
            L_0x01a1:
                int r8 = r14.getChildCount()     // Catch:{ all -> 0x0224 }
                if (r6 >= r8) goto L_0x01c3
                int r8 = r4.mIndex     // Catch:{ all -> 0x0224 }
                if (r7 != r8) goto L_0x01ac
                goto L_0x01c3
            L_0x01ac:
                android.view.View r8 = r14.getChildAt(r6)     // Catch:{ all -> 0x0224 }
                int r8 = r8.getId()     // Catch:{ all -> 0x0224 }
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0224 }
                boolean r8 = r13.contains(r8)     // Catch:{ all -> 0x0224 }
                if (r8 != 0) goto L_0x01c0
                int r7 = r7 + 1
            L_0x01c0:
                int r6 = r6 + 1
                goto L_0x01a1
            L_0x01c3:
                r15.addView(r14, r5, r6)     // Catch:{ all -> 0x0224 }
                int r1 = r1 + 1
                goto L_0x0186
            L_0x01c9:
                com.facebook.react.uimanager.IllegalViewOperationException r0 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0224 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
                r1.<init>()     // Catch:{ all -> 0x0224 }
                java.lang.String r5 = "Trying to add unknown view tag: "
                r1.append(r5)     // Catch:{ all -> 0x0224 }
                int r4 = r4.mTag     // Catch:{ all -> 0x0224 }
                r1.append(r4)     // Catch:{ all -> 0x0224 }
                java.lang.String r4 = "\n detail: "
                r1.append(r4)     // Catch:{ all -> 0x0224 }
                java.lang.String r2 = com.facebook.react.uimanager.NativeViewHierarchyManager.constructManageChildrenErrorMessage(r14, r15, r2, r3, r12)     // Catch:{ all -> 0x0224 }
                r1.append(r2)     // Catch:{ all -> 0x0224 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0224 }
                r0.<init>(r1)     // Catch:{ all -> 0x0224 }
                throw r0     // Catch:{ all -> 0x0224 }
            L_0x01ee:
                boolean r1 = r13.isEmpty()     // Catch:{ all -> 0x0224 }
                if (r1 == 0) goto L_0x01fd
                java.util.HashMap<java.lang.Integer, java.util.Set<java.lang.Integer>> r1 = r9.mPendingDeletionsForTag     // Catch:{ all -> 0x0224 }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0224 }
                r1.remove(r0)     // Catch:{ all -> 0x0224 }
            L_0x01fd:
                monitor-exit(r9)
            L_0x01fe:
                return
            L_0x01ff:
                r2 = r10
                r3 = r11
                com.facebook.react.uimanager.IllegalViewOperationException r1 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0224 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
                r4.<init>()     // Catch:{ all -> 0x0224 }
                java.lang.String r5 = "Trying to manageChildren view with tag "
                r4.append(r5)     // Catch:{ all -> 0x0224 }
                r4.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = " which doesn't exist\n detail: "
                r4.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = com.facebook.react.uimanager.NativeViewHierarchyManager.constructManageChildrenErrorMessage(r14, r15, r2, r3, r12)     // Catch:{ all -> 0x0224 }
                r4.append(r0)     // Catch:{ all -> 0x0224 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0224 }
                r1.<init>(r0)     // Catch:{ all -> 0x0224 }
                throw r1     // Catch:{ all -> 0x0224 }
            L_0x0224:
                r0 = move-exception
                monitor-exit(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.ManageChildrenOperation.execute():void");
        }
    }

    public final class MeasureInWindowOperation implements UIOperation {
        public final Callback mCallback;
        public final int mReactTag;

        public MeasureInWindowOperation(int i, Callback callback, AnonymousClass1 r4) {
            this.mReactTag = i;
            this.mCallback = callback;
        }

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measureInWindow(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float dIPFromPixel = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                float dIPFromPixel2 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                float dIPFromPixel3 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                float dIPFromPixel4 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                this.mCallback.invoke(Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
            } catch (NoSuchNativeViewException unused) {
                this.mCallback.invoke(new Object[0]);
            }
        }
    }

    public final class MeasureOperation implements UIOperation {
        public final Callback mCallback;
        public final int mReactTag;

        public MeasureOperation(int i, Callback callback, AnonymousClass1 r4) {
            this.mReactTag = i;
            this.mCallback = callback;
        }

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float dIPFromPixel = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                float dIPFromPixel2 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                float dIPFromPixel3 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                float dIPFromPixel4 = ImageOriginUtils.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                this.mCallback.invoke(Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2));
            } catch (NoSuchNativeViewException unused) {
                this.mCallback.invoke(new Object[0]);
            }
        }
    }

    public final class RemoveRootViewOperation extends ViewOperation {
        public RemoveRootViewOperation(int i) {
            super(UIViewOperationQueue.this, i);
        }

        public void execute() {
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            int i = this.mTag;
            synchronized (nativeViewHierarchyManager) {
                UiThreadUtil.assertOnUiThread();
                if (!nativeViewHierarchyManager.mRootTags.get(i)) {
                    SoftAssertions.assertUnreachable("View with tag " + i + " is not registered as a root view");
                }
                nativeViewHierarchyManager.dropView(nativeViewHierarchyManager.mTagsToViews.get(i));
                nativeViewHierarchyManager.mRootTags.delete(i);
            }
        }
    }

    public final class SendAccessibilityEvent extends ViewOperation {
        public final int mEventType;

        public SendAccessibilityEvent(int i, int i2, AnonymousClass1 r4) {
            super(UIViewOperationQueue.this, i);
            this.mEventType = i2;
        }

        public void execute() {
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            int i = this.mTag;
            int i2 = this.mEventType;
            View view = nativeViewHierarchyManager.mTagsToViews.get(i);
            if (view != null) {
                view.sendAccessibilityEvent(i2);
                return;
            }
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline41("Could not find view with tag ", i));
        }
    }

    public class SetLayoutAnimationEnabledOperation implements UIOperation {
        public final boolean mEnabled;

        public SetLayoutAnimationEnabledOperation(boolean z, AnonymousClass1 r3) {
            this.mEnabled = z;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.mLayoutAnimationEnabled = this.mEnabled;
        }
    }

    public final class ShowPopupMenuOperation extends ViewOperation {
        public final Callback mError;
        public final ReadableArray mItems;
        public final Callback mSuccess;

        public ShowPopupMenuOperation(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
            super(UIViewOperationQueue.this, i);
            this.mItems = readableArray;
            this.mError = callback;
            this.mSuccess = callback2;
        }

        public void execute() {
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            int i = this.mTag;
            ReadableArray readableArray = this.mItems;
            Callback callback = this.mSuccess;
            Callback callback2 = this.mError;
            synchronized (nativeViewHierarchyManager) {
                UiThreadUtil.assertOnUiThread();
                View view = nativeViewHierarchyManager.mTagsToViews.get(i);
                if (view == null) {
                    callback2.invoke("Can't display popup. Could not find view with tag " + i);
                    return;
                }
                View view2 = nativeViewHierarchyManager.mTagsToViews.get(i);
                if (view2 != null) {
                    PopupMenu popupMenu = new PopupMenu((ThemedReactContext) view2.getContext(), view);
                    nativeViewHierarchyManager.mPopupMenu = popupMenu;
                    Menu menu = popupMenu.getMenu();
                    for (int i2 = 0; i2 < readableArray.size(); i2++) {
                        menu.add(0, 0, i2, readableArray.getString(i2));
                    }
                    PopupMenuCallbackHandler popupMenuCallbackHandler = new PopupMenuCallbackHandler(callback, null);
                    nativeViewHierarchyManager.mPopupMenu.setOnMenuItemClickListener(popupMenuCallbackHandler);
                    nativeViewHierarchyManager.mPopupMenu.setOnDismissListener(popupMenuCallbackHandler);
                    nativeViewHierarchyManager.mPopupMenu.show();
                    return;
                }
                throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
            }
        }
    }

    public class UIBlockOperation implements UIOperation {
        public final UIBlock mBlock;

        public UIBlockOperation(UIBlock uIBlock) {
            this.mBlock = uIBlock;
        }

        public void execute() {
            this.mBlock.execute(UIViewOperationQueue.this.mNativeViewHierarchyManager);
        }
    }

    public interface UIOperation {
        void execute();
    }

    public final class UpdateLayoutOperation extends ViewOperation {
        public final int mHeight;
        public final int mParentTag;
        public final int mWidth;
        public final int mX;
        public final int mY;

        public UpdateLayoutOperation(int i, int i2, int i3, int i4, int i5, int i6) {
            super(UIViewOperationQueue.this, i2);
            this.mParentTag = i;
            this.mX = i3;
            this.mY = i4;
            this.mWidth = i5;
            this.mHeight = i6;
        }

        public void execute() {
            int i = this.mTag;
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            int i2 = this.mParentTag;
            int i3 = this.mX;
            int i4 = this.mY;
            int i5 = this.mWidth;
            int i6 = this.mHeight;
            synchronized (nativeViewHierarchyManager) {
                UiThreadUtil.assertOnUiThread();
                NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
                try {
                    View resolveView = nativeViewHierarchyManager.resolveView(i);
                    resolveView.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    ViewParent parent = resolveView.getParent();
                    if (parent instanceof RootView) {
                        parent.requestLayout();
                    }
                    if (!nativeViewHierarchyManager.mRootTags.get(i2)) {
                        ViewManager viewManager = nativeViewHierarchyManager.mTagsToViewManagers.get(i2);
                        if (viewManager instanceof IViewManagerWithChildren) {
                            IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) viewManager;
                            if (iViewManagerWithChildren != null && !iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                                nativeViewHierarchyManager.updateLayout(resolveView, i3, i4, i5, i6);
                            }
                        } else {
                            throw new IllegalViewOperationException("Trying to use view with tag " + i2 + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
                        }
                    } else {
                        nativeViewHierarchyManager.updateLayout(resolveView, i3, i4, i5, i6);
                    }
                } finally {
                    Trace.endSection();
                }
            }
        }
    }

    public final class UpdatePropertiesOperation extends ViewOperation {
        public final ReactStylesDiffMap mProps;

        public UpdatePropertiesOperation(int i, ReactStylesDiffMap reactStylesDiffMap, AnonymousClass1 r4) {
            super(UIViewOperationQueue.this, i);
            this.mProps = reactStylesDiffMap;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
        }
    }

    public final class UpdateViewExtraData extends ViewOperation {
        public final Object mExtraData;

        public UpdateViewExtraData(int i, Object obj) {
            super(UIViewOperationQueue.this, i);
            this.mExtraData = obj;
        }

        public void execute() {
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            int i = this.mTag;
            Object obj = this.mExtraData;
            synchronized (nativeViewHierarchyManager) {
                UiThreadUtil.assertOnUiThread();
                nativeViewHierarchyManager.resolveViewManager(i).updateExtraData(nativeViewHierarchyManager.resolveView(i), obj);
            }
        }
    }

    public abstract class ViewOperation implements UIOperation {
        public int mTag;

        public ViewOperation(UIViewOperationQueue uIViewOperationQueue, int i) {
            this.mTag = i;
        }
    }

    public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager, int i) {
        this.mNativeViewHierarchyManager = nativeViewHierarchyManager;
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext, i == -1 ? 8 : i, null);
        this.mReactApplicationContext = reactApplicationContext;
        this.mAllowViewCommandsQueue = false;
    }

    public void dispatchViewUpdates(int i, long j, long j2) {
        final ArrayList arrayList;
        final ArrayList arrayList2;
        final ArrayDeque arrayDeque;
        NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
        try {
            final long uptimeMillis = SystemClock.uptimeMillis();
            final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            if (!this.mViewCommandOperations.isEmpty()) {
                ArrayList<DispatchCommandViewOperation> arrayList3 = this.mViewCommandOperations;
                this.mViewCommandOperations = new ArrayList<>();
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            if (!this.mOperations.isEmpty()) {
                ArrayList<UIOperation> arrayList4 = this.mOperations;
                this.mOperations = new ArrayList<>();
                arrayList2 = arrayList4;
            } else {
                arrayList2 = null;
            }
            synchronized (this.mNonBatchedOperationsLock) {
                if (!this.mNonBatchedOperations.isEmpty()) {
                    ArrayDeque<UIOperation> arrayDeque2 = this.mNonBatchedOperations;
                    this.mNonBatchedOperations = new ArrayDeque<>();
                    arrayDeque = arrayDeque2;
                } else {
                    arrayDeque = null;
                }
            }
            if (this.mViewHierarchyUpdateDebugListener != null) {
                this.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateEnqueued();
            }
            final int i2 = i;
            final long j3 = j;
            final long j4 = j2;
            AnonymousClass1 r1 = new Runnable() {
                public void run() {
                    NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
                    try {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (arrayList != null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                DispatchCommandViewOperation dispatchCommandViewOperation = (DispatchCommandViewOperation) it.next();
                                try {
                                    dispatchCommandViewOperation.executeWithExceptions();
                                } catch (RetryableMountingLayerException e2) {
                                    if (dispatchCommandViewOperation.getRetries() == 0) {
                                        dispatchCommandViewOperation.incrementRetries();
                                        UIViewOperationQueue.this.mViewCommandOperations.add(dispatchCommandViewOperation);
                                    } else {
                                        ReactSoftException.logSoftException("UIViewOperationQueue", new ReactNoCrashSoftException((Throwable) e2));
                                    }
                                } catch (Throwable th) {
                                    ReactSoftException.logSoftException("UIViewOperationQueue", th);
                                }
                            }
                        }
                        if (arrayDeque != null) {
                            Iterator it2 = arrayDeque.iterator();
                            while (it2.hasNext()) {
                                ((UIOperation) it2.next()).execute();
                            }
                        }
                        if (arrayList2 != null) {
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                ((UIOperation) it3.next()).execute();
                            }
                        }
                        if (UIViewOperationQueue.this.mIsProfilingNextBatch && UIViewOperationQueue.this.mProfiledBatchCommitStartTime == 0) {
                            UIViewOperationQueue.this.mProfiledBatchCommitStartTime = j3;
                            UIViewOperationQueue.this.mProfiledBatchCommitEndTime = SystemClock.uptimeMillis();
                            UIViewOperationQueue.this.mProfiledBatchLayoutTime = j4;
                            UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime = uptimeMillis;
                            UIViewOperationQueue.this.mProfiledBatchRunStartTime = uptimeMillis;
                            UIViewOperationQueue.this.mProfiledBatchRunEndTime = UIViewOperationQueue.this.mProfiledBatchCommitEndTime;
                            UIViewOperationQueue.this.mThreadCpuTime = currentThreadTimeMillis;
                            long j = UIViewOperationQueue.this.mProfiledBatchCommitStartTime;
                            long j2 = UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime;
                            long j3 = UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime;
                            long j4 = UIViewOperationQueue.this.mProfiledBatchRunStartTime;
                        }
                        UIViewOperationQueue.this.mNativeViewHierarchyManager.mLayoutAnimator.reset();
                        if (UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener != null) {
                            UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateFinished();
                        }
                        Trace.endSection();
                    } catch (Exception e3) {
                        UIViewOperationQueue.this.mIsInIllegalUIState = true;
                        throw e3;
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
            };
            NoopBuilder noopBuilder2 = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
            synchronized (this.mDispatchRunnablesLock) {
                Trace.endSection();
                this.mDispatchUIRunnables.add(r1);
            }
            if (!this.mIsDispatchUIFrameCallbackEnqueued) {
                UiThreadUtil.runOnUiThread(new GuardedRunnable(this.mReactApplicationContext) {
                    public void runGuarded() {
                        UIViewOperationQueue.this.flushPendingBatches();
                    }
                });
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public void enqueueCreateView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        synchronized (this.mNonBatchedOperationsLock) {
            this.mCreateViewCount++;
            ArrayDeque<UIOperation> arrayDeque = this.mNonBatchedOperations;
            CreateViewOperation createViewOperation = new CreateViewOperation(themedReactContext, i, str, reactStylesDiffMap);
            arrayDeque.addLast(createViewOperation);
        }
    }

    public void enqueueManageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        ArrayList<UIOperation> arrayList = this.mOperations;
        ManageChildrenOperation manageChildrenOperation = new ManageChildrenOperation(i, iArr, viewAtIndexArr, iArr2);
        arrayList.add(manageChildrenOperation);
    }

    public void enqueueUpdateExtraData(int i, Object obj) {
        this.mOperations.add(new UpdateViewExtraData(i, obj));
    }

    public void enqueueUpdateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        ArrayList<UIOperation> arrayList = this.mOperations;
        UpdateLayoutOperation updateLayoutOperation = new UpdateLayoutOperation(i, i2, i3, i4, i5, i6);
        arrayList.add(updateLayoutOperation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r2 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r0.hasNext() == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r0.next().run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r4.mIsProfilingNextBatch == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r4.mProfiledBatchBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r2;
        r4.mProfiledBatchNonBatchedExecutionTime = r4.mNonBatchedExecutionTotalTime;
        r4.mIsProfilingNextBatch = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r4.mNonBatchedExecutionTotalTime = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void flushPendingBatches() {
        /*
            r4 = this;
            boolean r0 = r4.mIsInIllegalUIState
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ReactNative"
            java.lang.String r1 = "Not flushing pending UI operations because of previously thrown Exception"
            com.facebook.common.logging.FLog.w(r0, r1)
            return
        L_0x000c:
            java.lang.Object r0 = r4.mDispatchRunnablesLock
            monitor-enter(r0)
            java.util.ArrayList<java.lang.Runnable> r1 = r4.mDispatchUIRunnables     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x0050
            java.util.ArrayList<java.lang.Runnable> r1 = r4.mDispatchUIRunnables     // Catch:{ all -> 0x0052 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            r4.mDispatchUIRunnables = r2     // Catch:{ all -> 0x0052 }
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            long r2 = android.os.SystemClock.uptimeMillis()
            java.util.Iterator r0 = r1.iterator()
        L_0x0029:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0029
        L_0x0039:
            boolean r0 = r4.mIsProfilingNextBatch
            if (r0 == 0) goto L_0x004b
            long r0 = android.os.SystemClock.uptimeMillis()
            long r0 = r0 - r2
            r4.mProfiledBatchBatchedExecutionTime = r0
            long r0 = r4.mNonBatchedExecutionTotalTime
            r4.mProfiledBatchNonBatchedExecutionTime = r0
            r0 = 0
            r4.mIsProfilingNextBatch = r0
        L_0x004b:
            r0 = 0
            r4.mNonBatchedExecutionTotalTime = r0
            return
        L_0x0050:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            return
        L_0x0052:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.flushPendingBatches():void");
    }

    public boolean isEmpty() {
        return this.mOperations.isEmpty() && this.mViewCommandOperations.isEmpty();
    }
}
