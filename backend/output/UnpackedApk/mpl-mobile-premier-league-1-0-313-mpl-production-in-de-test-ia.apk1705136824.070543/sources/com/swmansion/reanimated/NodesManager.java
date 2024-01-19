package com.swmansion.reanimated;

import android.util.SparseArray;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.swmansion.reanimated.nodes.EventNode;
import com.swmansion.reanimated.nodes.Node;
import com.swmansion.reanimated.nodes.NoopNode;
import com.swmansion.reanimated.nodes.ValueNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class NodesManager implements EventDispatcherListener {
    public static final Double ZERO = Double.valueOf(0.0d);
    public double currentFrameTimeMs;
    public final SparseArray<Node> mAnimatedNodes = new SparseArray<>();
    public final AtomicBoolean mCallbackPosted = new AtomicBoolean();
    public final GuardedFrameCallback mChoreographerCallback;
    public final ReactContext mContext;
    public final CustomEventNamesResolver mCustomEventNamesResolver;
    public final RCTDeviceEventEmitter mEventEmitter;
    public final Map<String, EventNode> mEventMapping = new HashMap();
    public ConcurrentLinkedQueue<Event> mEventQueue = new ConcurrentLinkedQueue<>();
    public List<OnAnimationFrame> mFrameCallbacks = new ArrayList();
    public final NoopNode mNoopNode;
    public Queue<NativeUpdateOperation> mOperationsInBatch = new LinkedList();
    public final ReactChoreographer mReactChoreographer;
    public final UIImplementation mUIImplementation;
    public final UIManagerModule mUIManager;
    public boolean mWantRunUpdates;
    public Set<String> nativeProps = Collections.emptySet();
    public Set<String> uiProps = Collections.emptySet();
    public final UpdateContext updateContext;

    public final class NativeUpdateOperation {
        public WritableMap mNativeProps;
        public int mViewTag;

        public NativeUpdateOperation(NodesManager nodesManager, int i, WritableMap writableMap) {
            this.mViewTag = i;
            this.mNativeProps = writableMap;
        }
    }

    public interface OnAnimationFrame {
        void onAnimationFrame();
    }

    public NodesManager(ReactContext reactContext) {
        this.mContext = reactContext;
        this.mUIManager = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.updateContext = new UpdateContext();
        this.mUIImplementation = this.mUIManager.getUIImplementation();
        this.mCustomEventNamesResolver = this.mUIManager.getDirectEventNamesResolver();
        this.mUIManager.getEventDispatcher().mListeners.add(this);
        this.mEventEmitter = (RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class);
        this.mReactChoreographer = ReactChoreographer.getInstance();
        this.mChoreographerCallback = new GuardedFrameCallback(reactContext) {
            public void doFrameGuarded(long j) {
                NodesManager nodesManager = NodesManager.this;
                nodesManager.currentFrameTimeMs = ((double) j) / 1000000.0d;
                while (!nodesManager.mEventQueue.isEmpty()) {
                    nodesManager.handleEvent(nodesManager.mEventQueue.poll());
                }
                if (!nodesManager.mFrameCallbacks.isEmpty()) {
                    List<OnAnimationFrame> list = nodesManager.mFrameCallbacks;
                    nodesManager.mFrameCallbacks = new ArrayList(list.size());
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).onAnimationFrame();
                    }
                }
                if (nodesManager.mWantRunUpdates) {
                    Node.runUpdates(nodesManager.updateContext);
                }
                if (!nodesManager.mOperationsInBatch.isEmpty()) {
                    Queue<NativeUpdateOperation> queue = nodesManager.mOperationsInBatch;
                    nodesManager.mOperationsInBatch = new LinkedList();
                    ReactContext reactContext = nodesManager.mContext;
                    reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext, queue) {
                        public final /* synthetic */ Queue val$copiedOperationsQueue;

                        {
                            this.val$copiedOperationsQueue = r3;
                        }

                        public void runGuarded() {
                            boolean isEmpty = NodesManager.this.mUIImplementation.mOperationsQueue.isEmpty();
                            while (!this.val$copiedOperationsQueue.isEmpty()) {
                                NativeUpdateOperation nativeUpdateOperation = (NativeUpdateOperation) this.val$copiedOperationsQueue.remove();
                                ReactShadowNode resolveShadowNode = NodesManager.this.mUIImplementation.resolveShadowNode(nativeUpdateOperation.mViewTag);
                                if (resolveShadowNode != null) {
                                    NodesManager.this.mUIManager.updateView(nativeUpdateOperation.mViewTag, resolveShadowNode.getViewClass(), nativeUpdateOperation.mNativeProps);
                                }
                            }
                            if (isEmpty) {
                                NodesManager.this.mUIImplementation.dispatchViewUpdates(-1);
                            }
                        }
                    });
                }
                nodesManager.mCallbackPosted.set(false);
                nodesManager.mWantRunUpdates = false;
                if (!nodesManager.mFrameCallbacks.isEmpty() || !nodesManager.mEventQueue.isEmpty()) {
                    nodesManager.startUpdatingOnAnimationFrame();
                }
            }
        };
        this.mNoopNode = new NoopNode(this);
    }

    public void detachEvent(int i, String str) {
        this.mEventMapping.remove(i + str);
    }

    public <T extends Node> T findNodeById(int i, Class<T> cls) {
        T t = (Node) this.mAnimatedNodes.get(i);
        if (t == null) {
            if (cls == Node.class || cls == ValueNode.class) {
                return this.mNoopNode;
            }
            throw new IllegalArgumentException("Requested node with id " + i + " of type " + cls + " cannot be found");
        } else if (cls.isInstance(t)) {
            return t;
        } else {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("Node with id ", i, " is of incompatible type ");
            outline74.append(t.getClass());
            outline74.append(", requested type was ");
            outline74.append(cls);
            throw new IllegalArgumentException(outline74.toString());
        }
    }

    public Object getNodeValue(int i) {
        Node node = this.mAnimatedNodes.get(i);
        if (node != null) {
            return node.value();
        }
        return ZERO;
    }

    public final void handleEvent(Event event) {
        if (!this.mEventMapping.isEmpty()) {
            String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.getEventName());
            int i = event.mViewTag;
            EventNode eventNode = this.mEventMapping.get(i + resolveCustomEventName);
            if (eventNode != null) {
                event.dispatch(eventNode);
            }
        }
    }

    public void onEventDispatch(Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
            return;
        }
        this.mEventQueue.offer(event);
        startUpdatingOnAnimationFrame();
    }

    public final void startUpdatingOnAnimationFrame() {
        if (!this.mCallbackPosted.getAndSet(true)) {
            this.mReactChoreographer.postFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }
}
