package com.facebook.react.animated;

import android.util.SparseArray;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.animated.NativeAnimatedModule.AnonymousClass5;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NativeAnimatedNodesManager implements EventDispatcherListener {
    public final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    public int mAnimatedGraphBFSColor = 0;
    public final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    public final CustomEventNamesResolver mCustomEventNamesResolver;
    public final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
    public final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    public final UIManagerModule mUIManagerModule;
    public final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();

    public NativeAnimatedNodesManager(UIManagerModule uIManagerModule) {
        this.mUIManagerModule = uIManagerModule;
        uIManagerModule.getEventDispatcher().mListeners.add(this);
        this.mCustomEventNamesResolver = uIManagerModule.getDirectEventNamesResolver();
    }

    public AnimatedNode getNodeById(int i) {
        return this.mAnimatedNodes.get(i);
    }

    public final void handleEvent(Event event) {
        if (!this.mEventDrivers.isEmpty()) {
            String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.getEventName());
            Map<String, List<EventAnimationDriver>> map = this.mEventDrivers;
            List<EventAnimationDriver> list = map.get(event.mViewTag + resolveCustomEventName);
            if (list != null) {
                for (EventAnimationDriver eventAnimationDriver : list) {
                    stopAnimationsForNode(eventAnimationDriver.mValueNode);
                    event.dispatch(eventAnimationDriver);
                    this.mRunUpdateNodeList.add(eventAnimationDriver.mValueNode);
                }
                updateNodes(this.mRunUpdateNodeList);
                this.mRunUpdateNodeList.clear();
            }
        }
    }

    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    public void runUpdates(long j) {
        UiThreadUtil.assertOnUiThread();
        for (int i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        boolean z = false;
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            valueAt.runAnimationStep(j);
            this.mRunUpdateNodeList.add(valueAt.mAnimatedValue);
            if (valueAt.mHasFinished) {
                z = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z) {
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver valueAt2 = this.mActiveAnimations.valueAt(size);
                if (valueAt2.mHasFinished) {
                    if (valueAt2.mEndCallback != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.mEndCallback.invoke(createMap);
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
        }
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimationDriver animationDriver;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i2, " does not exists"));
        } else if (animatedNode instanceof ValueAnimatedNode) {
            AnimationDriver animationDriver2 = this.mActiveAnimations.get(i);
            if (animationDriver2 != null) {
                animationDriver2.resetConfig(readableMap);
                return;
            }
            String string = readableMap.getString("type");
            if ("frames".equals(string)) {
                animationDriver = new FrameBasedAnimationDriver(readableMap);
            } else if ("spring".equals(string)) {
                animationDriver = new SpringAnimation(readableMap);
            } else if ("decay".equals(string)) {
                animationDriver = new DecayAnimation(readableMap);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Unsupported animation type: ", string));
            }
            animationDriver.mId = i;
            animationDriver.mEndCallback = callback;
            animationDriver.mAnimatedValue = (ValueAnimatedNode) animatedNode;
            this.mActiveAnimations.put(i, animationDriver);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline35(ValueAnimatedNode.class, GeneratedOutlineSupport.outline73("Animated node should be of type ")));
        }
    }

    public final void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(valueAt.mAnimatedValue)) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
    }

    public final void updateNodes(List<AnimatedNode> list) {
        int i = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i;
        if (i == 0) {
            this.mAnimatedGraphBFSColor = i + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i2 = 0;
        for (AnimatedNode next : list) {
            int i3 = next.mBFSColor;
            int i4 = this.mAnimatedGraphBFSColor;
            if (i3 != i4) {
                next.mBFSColor = i4;
                i2++;
                arrayDeque.add(next);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode = (AnimatedNode) arrayDeque.poll();
            if (animatedNode.mChildren != null) {
                for (int i5 = 0; i5 < animatedNode.mChildren.size(); i5++) {
                    AnimatedNode animatedNode2 = animatedNode.mChildren.get(i5);
                    animatedNode2.mActiveIncomingNodes++;
                    int i6 = animatedNode2.mBFSColor;
                    int i7 = this.mAnimatedGraphBFSColor;
                    if (i6 != i7) {
                        animatedNode2.mBFSColor = i7;
                        i2++;
                        arrayDeque.add(animatedNode2);
                    }
                }
            }
        }
        int i8 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i8;
        if (i8 == 0) {
            this.mAnimatedGraphBFSColor = i8 + 1;
        }
        int i9 = 0;
        for (AnimatedNode next2 : list) {
            if (next2.mActiveIncomingNodes == 0) {
                int i10 = next2.mBFSColor;
                int i11 = this.mAnimatedGraphBFSColor;
                if (i10 != i11) {
                    next2.mBFSColor = i11;
                    i9++;
                    arrayDeque.add(next2);
                }
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode3 = (AnimatedNode) arrayDeque.poll();
            animatedNode3.update();
            if (animatedNode3 instanceof PropsAnimatedNode) {
                try {
                    ((PropsAnimatedNode) animatedNode3).updateView();
                } catch (IllegalViewOperationException e2) {
                    FLog.e((String) "ReactNative", (String) "Native animation workaround, frame lost as result of race condition", (Throwable) e2);
                }
            }
            if (animatedNode3 instanceof ValueAnimatedNode) {
                ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNode3;
                AnimatedNodeValueListener animatedNodeValueListener = valueAnimatedNode.mValueListener;
                if (animatedNodeValueListener != null) {
                    double value = valueAnimatedNode.getValue();
                    AnonymousClass5 r4 = (AnonymousClass5) animatedNodeValueListener;
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt(InlineAnimation.TAG, i);
                    createMap.putDouble(HSLCriteriaBuilder.VALUE, value);
                    ReactApplicationContext access$300 = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
                    if (access$300 != null) {
                        ((RCTDeviceEventEmitter) access$300.getJSModule(RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", createMap);
                    }
                }
            }
            if (animatedNode3.mChildren != null) {
                for (int i12 = 0; i12 < animatedNode3.mChildren.size(); i12++) {
                    AnimatedNode animatedNode4 = animatedNode3.mChildren.get(i12);
                    int i13 = animatedNode4.mActiveIncomingNodes - 1;
                    animatedNode4.mActiveIncomingNodes = i13;
                    int i14 = animatedNode4.mBFSColor;
                    int i15 = this.mAnimatedGraphBFSColor;
                    if (i14 != i15 && i13 == 0) {
                        animatedNode4.mBFSColor = i15;
                        i9++;
                        arrayDeque.add(animatedNode4);
                    }
                }
            }
        }
        if (i2 != i9) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline43("Looks like animated nodes graph has cycles, there are ", i2, " but toposort visited only ", i9));
        }
    }
}
