package com.swmansion.reanimated;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.nodes.AlwaysNode;
import com.swmansion.reanimated.nodes.BezierNode;
import com.swmansion.reanimated.nodes.BlockNode;
import com.swmansion.reanimated.nodes.CallFuncNode;
import com.swmansion.reanimated.nodes.ClockNode;
import com.swmansion.reanimated.nodes.ClockOpNode.ClockStartNode;
import com.swmansion.reanimated.nodes.ClockOpNode.ClockStopNode;
import com.swmansion.reanimated.nodes.ClockOpNode.ClockTestNode;
import com.swmansion.reanimated.nodes.ConcatNode;
import com.swmansion.reanimated.nodes.CondNode;
import com.swmansion.reanimated.nodes.DebugNode;
import com.swmansion.reanimated.nodes.EventNode;
import com.swmansion.reanimated.nodes.FunctionNode;
import com.swmansion.reanimated.nodes.JSCallNode;
import com.swmansion.reanimated.nodes.Node;
import com.swmansion.reanimated.nodes.OperatorNode;
import com.swmansion.reanimated.nodes.ParamNode;
import com.swmansion.reanimated.nodes.PropsNode;
import com.swmansion.reanimated.nodes.SetNode;
import com.swmansion.reanimated.nodes.StyleNode;
import com.swmansion.reanimated.nodes.TransformNode;
import com.swmansion.reanimated.nodes.ValueNode;
import com.swmansion.reanimated.transitions.TransitionModule;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

@ReactModule(name = "ReanimatedModule")
public class ReanimatedModule extends ReactContextBaseJavaModule implements LifecycleEventListener, UIManagerModuleListener {
    public static final String NAME = "ReanimatedModule";
    public NodesManager mNodesManager;
    public ArrayList<UIThreadOperation> mOperations = new ArrayList<>();
    public TransitionModule mTransitionManager;

    public interface UIThreadOperation {
        void execute(NodesManager nodesManager);
    }

    public ReanimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public NodesManager getNodesManager() {
        if (this.mNodesManager == null) {
            this.mNodesManager = new NodesManager(getReactApplicationContext());
        }
        return this.mNodesManager;
    }

    @ReactMethod
    public void animateNextTransition(int i, ReadableMap readableMap) {
        TransitionModule transitionModule = this.mTransitionManager;
        transitionModule.mUIManager.prependUIBlock(new UIBlock(transitionModule, i, readableMap) {
            public final /* synthetic */ ReadableMap val$config;
            public final /* synthetic */ int val$rootTag;

            {
                this.val$rootTag = r2;
                this.val$config = r3;
            }

            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    View resolveView = nativeViewHierarchyManager.resolveView(this.val$rootTag);
                    if (resolveView instanceof ViewGroup) {
                        ReadableArray array = this.val$config.getArray("transitions");
                        int size = array.size();
                        for (int i = 0; i < size; i++) {
                            TransitionManager.beginDelayedTransition((ViewGroup) resolveView, TextAppearanceConfig.inflate(array.getMap(i)));
                        }
                    }
                } catch (IllegalViewOperationException unused) {
                }
            }
        });
    }

    @ReactMethod
    public void attachEvent(final int i, final String str, final int i2) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                int i = i;
                String str = str;
                int i2 = i2;
                if (nodesManager != null) {
                    String str2 = i + str;
                    EventNode eventNode = (EventNode) nodesManager.mAnimatedNodes.get(i2);
                    if (eventNode == null) {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Event node ", i2, " does not exists"));
                    } else if (!nodesManager.mEventMapping.containsKey(str2)) {
                        nodesManager.mEventMapping.put(str2, eventNode);
                    } else {
                        throw new JSApplicationIllegalArgumentException("Event handler already set for the given view and event type");
                    }
                } else {
                    throw null;
                }
            }
        });
    }

    @ReactMethod
    public void configureProps(ReadableArray readableArray, ReadableArray readableArray2) {
        int size = readableArray.size();
        final HashSet hashSet = new HashSet(size);
        for (int i = 0; i < size; i++) {
            hashSet.add(readableArray.getString(i));
        }
        int size2 = readableArray2.size();
        final HashSet hashSet2 = new HashSet(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            hashSet2.add(readableArray2.getString(i2));
        }
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                Set<String> set = hashSet;
                Set<String> set2 = hashSet2;
                nodesManager.nativeProps = set;
                nodesManager.uiProps = set2;
            }
        });
    }

    @ReactMethod
    public void connectNodeToView(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                int i = i;
                int i2 = i2;
                Node node = nodesManager.mAnimatedNodes.get(i);
                if (node == null) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with ID ", i, " does not exists"));
                } else if (node instanceof PropsNode) {
                    PropsNode propsNode = (PropsNode) node;
                    propsNode.mConnectedViewTag = i2;
                    propsNode.dangerouslyRescheduleEvaluate();
                } else {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline35(PropsNode.class, GeneratedOutlineSupport.outline73("Animated node connected to view should beof type ")));
                }
            }
        });
    }

    @ReactMethod
    public void connectNodes(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                int i = i;
                int i2 = i2;
                Node node = nodesManager.mAnimatedNodes.get(i);
                Node node2 = nodesManager.mAnimatedNodes.get(i2);
                if (node2 != null) {
                    node.addChild(node2);
                    return;
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with ID ", i2, " does not exists"));
            }
        });
    }

    @ReactMethod
    public void createNode(final int i, final ReadableMap readableMap) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                Object obj;
                int i = i;
                ReadableMap readableMap = readableMap;
                if (nodesManager.mAnimatedNodes.get(i) == null) {
                    String string = readableMap.getString("type");
                    if ("props".equals(string)) {
                        obj = new PropsNode(i, readableMap, nodesManager, nodesManager.mUIImplementation);
                    } else if ("style".equals(string)) {
                        obj = new StyleNode(i, readableMap, nodesManager);
                    } else if ("transform".equals(string)) {
                        obj = new TransformNode(i, readableMap, nodesManager);
                    } else if (HSLCriteriaBuilder.VALUE.equals(string)) {
                        obj = new ValueNode(i, readableMap, nodesManager);
                    } else if ("block".equals(string)) {
                        obj = new BlockNode(i, readableMap, nodesManager);
                    } else if ("cond".equals(string)) {
                        obj = new CondNode(i, readableMap, nodesManager);
                    } else if (JoinRoomInvitationRequest.KEY_OPTIONAL_PARAMS.equals(string)) {
                        obj = new OperatorNode(i, readableMap, nodesManager);
                    } else if ("set".equals(string)) {
                        obj = new SetNode(i, readableMap, nodesManager);
                    } else if ("debug".equals(string)) {
                        obj = new DebugNode(i, readableMap, nodesManager);
                    } else if (Values.CLOCK.equals(string)) {
                        obj = new ClockNode(i, readableMap, nodesManager);
                    } else if ("clockStart".equals(string)) {
                        obj = new ClockStartNode(i, readableMap, nodesManager);
                    } else if ("clockStop".equals(string)) {
                        obj = new ClockStopNode(i, readableMap, nodesManager);
                    } else if ("clockTest".equals(string)) {
                        obj = new ClockTestNode(i, readableMap, nodesManager);
                    } else if ("call".equals(string)) {
                        obj = new JSCallNode(i, readableMap, nodesManager);
                    } else if ("bezier".equals(string)) {
                        obj = new BezierNode(i, readableMap, nodesManager);
                    } else if ("event".equals(string)) {
                        obj = new EventNode(i, readableMap, nodesManager);
                    } else if ("always".equals(string)) {
                        obj = new AlwaysNode(i, readableMap, nodesManager);
                    } else if ("concat".equals(string)) {
                        obj = new ConcatNode(i, readableMap, nodesManager);
                    } else if ("param".equals(string)) {
                        obj = new ParamNode(i, readableMap, nodesManager);
                    } else if ("func".equals(string)) {
                        obj = new FunctionNode(i, readableMap, nodesManager);
                    } else if ("callfunc".equals(string)) {
                        obj = new CallFuncNode(i, readableMap, nodesManager);
                    } else {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Unsupported node type: ", string));
                    }
                    nodesManager.mAnimatedNodes.put(i, obj);
                    return;
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with ID ", i, " already exists"));
            }
        });
    }

    @ReactMethod
    public void detachEvent(final int i, final String str, final int i2) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                nodesManager.detachEvent(i, str);
            }
        });
    }

    @ReactMethod
    public void disconnectNodeFromView(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                int i = i;
                Node node = nodesManager.mAnimatedNodes.get(i);
                if (node == null) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with ID ", i, " does not exists"));
                } else if (node instanceof PropsNode) {
                    ((PropsNode) node).mConnectedViewTag = -1;
                } else {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline35(PropsNode.class, GeneratedOutlineSupport.outline73("Animated node connected to view should beof type ")));
                }
            }
        });
    }

    @ReactMethod
    public void disconnectNodes(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                int i = i;
                int i2 = i2;
                Node node = nodesManager.mAnimatedNodes.get(i);
                Node node2 = nodesManager.mAnimatedNodes.get(i2);
                if (node2 != null) {
                    node.removeChild(node2);
                    return;
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with ID ", i2, " does not exists"));
            }
        });
    }

    @ReactMethod
    public void dropNode(final int i) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                nodesManager.mAnimatedNodes.remove(i);
            }
        });
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getValue(final int i, final Callback callback) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                int i = i;
                callback.invoke(nodesManager.mAnimatedNodes.get(i).value());
            }
        });
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        UIManagerModule uIManagerModule = (UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class);
        reactApplicationContext.addLifecycleEventListener(this);
        uIManagerModule.addUIManagerListener(this);
        this.mTransitionManager = new TransitionModule(uIManagerModule);
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null && nodesManager.mCallbackPosted.get()) {
            if (nodesManager.mCallbackPosted.getAndSet(false)) {
                nodesManager.mReactChoreographer.removeFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, nodesManager.mChoreographerCallback);
            }
            nodesManager.mCallbackPosted.set(true);
        }
    }

    public void onHostResume() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null && nodesManager.mCallbackPosted.getAndSet(false)) {
            nodesManager.startUpdatingOnAnimationFrame();
        }
    }

    @ReactMethod
    public void setValue(final int i, final Double d2) {
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NodesManager nodesManager) {
                int i = i;
                Double d2 = d2;
                Node node = nodesManager.mAnimatedNodes.get(i);
                if (node != null) {
                    ((ValueNode) node).setValue(d2);
                }
            }
        });
    }

    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty()) {
            final ArrayList<UIThreadOperation> arrayList = this.mOperations;
            this.mOperations = new ArrayList<>();
            uIManagerModule.addUIBlock(new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NodesManager access$000 = ReanimatedModule.this.getNodesManager();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(access$000);
                    }
                }
            });
        }
    }
}
