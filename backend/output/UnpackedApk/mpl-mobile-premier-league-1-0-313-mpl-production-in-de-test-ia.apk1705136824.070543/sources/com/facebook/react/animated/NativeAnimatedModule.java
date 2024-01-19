package com.facebook.react.animated;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@ReactModule(name = "NativeAnimatedModule")
public class NativeAnimatedModule extends NativeAnimatedModuleSpec implements LifecycleEventListener, UIManagerModuleListener {
    public static final String NAME = "NativeAnimatedModule";
    public final GuardedFrameCallback mAnimatedFrameCallback;
    public NativeAnimatedNodesManager mNodesManager;
    public ArrayList<UIThreadOperation> mOperations = new ArrayList<>();
    public ArrayList<UIThreadOperation> mPreOperations = new ArrayList<>();
    public final ReactChoreographer mReactChoreographer = ReactChoreographer.getInstance();

    public interface UIThreadOperation {
        void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager);
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAnimatedFrameCallback = new GuardedFrameCallback(reactApplicationContext) {
            /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[Catch:{ Exception -> 0x0036 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void doFrameGuarded(long r3) {
                /*
                    r2 = this;
                    com.facebook.react.animated.NativeAnimatedModule r0 = com.facebook.react.animated.NativeAnimatedModule.this     // Catch:{ Exception -> 0x0036 }
                    com.facebook.react.animated.NativeAnimatedNodesManager r0 = r0.getNodesManager()     // Catch:{ Exception -> 0x0036 }
                    android.util.SparseArray<com.facebook.react.animated.AnimationDriver> r1 = r0.mActiveAnimations     // Catch:{ Exception -> 0x0036 }
                    int r1 = r1.size()     // Catch:{ Exception -> 0x0036 }
                    if (r1 > 0) goto L_0x0019
                    android.util.SparseArray<com.facebook.react.animated.AnimatedNode> r1 = r0.mUpdatedNodes     // Catch:{ Exception -> 0x0036 }
                    int r1 = r1.size()     // Catch:{ Exception -> 0x0036 }
                    if (r1 <= 0) goto L_0x0017
                    goto L_0x0019
                L_0x0017:
                    r1 = 0
                    goto L_0x001a
                L_0x0019:
                    r1 = 1
                L_0x001a:
                    if (r1 == 0) goto L_0x001f
                    r0.runUpdates(r3)     // Catch:{ Exception -> 0x0036 }
                L_0x001f:
                    com.facebook.react.animated.NativeAnimatedModule r3 = com.facebook.react.animated.NativeAnimatedModule.this     // Catch:{ Exception -> 0x0036 }
                    com.facebook.react.modules.core.ReactChoreographer r3 = r3.mReactChoreographer     // Catch:{ Exception -> 0x0036 }
                    com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r3)     // Catch:{ Exception -> 0x0036 }
                    com.facebook.react.modules.core.ReactChoreographer r3 = (com.facebook.react.modules.core.ReactChoreographer) r3     // Catch:{ Exception -> 0x0036 }
                    com.facebook.react.modules.core.ReactChoreographer$CallbackType r4 = com.facebook.react.modules.core.ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE     // Catch:{ Exception -> 0x0036 }
                    com.facebook.react.animated.NativeAnimatedModule r0 = com.facebook.react.animated.NativeAnimatedModule.this     // Catch:{ Exception -> 0x0036 }
                    com.facebook.react.uimanager.GuardedFrameCallback r0 = r0.mAnimatedFrameCallback     // Catch:{ Exception -> 0x0036 }
                    r3.postFrameCallback(r4, r0)     // Catch:{ Exception -> 0x0036 }
                    return
                L_0x0036:
                    r3 = move-exception
                    java.lang.String r4 = "ReactNative"
                    java.lang.String r0 = "Exception while executing animated frame callback."
                    com.facebook.common.logging.FLog.e(r4, r0, r3)
                    java.lang.RuntimeException r4 = new java.lang.RuntimeException
                    r4.<init>(r3)
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.NativeAnimatedModule.AnonymousClass1.doFrameGuarded(long):void");
            }
        };
    }

    private void clearFrameCallback() {
        ReactChoreographer reactChoreographer = this.mReactChoreographer;
        ImageOriginUtils.assertNotNull(reactChoreographer);
        reactChoreographer.removeFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    private void enqueueFrameCallback() {
        ReactChoreographer reactChoreographer = this.mReactChoreographer;
        ImageOriginUtils.assertNotNull(reactChoreographer);
        reactChoreographer.postFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    /* access modifiers changed from: private */
    public NativeAnimatedNodesManager getNodesManager() {
        if (this.mNodesManager == null) {
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                this.mNodesManager = new NativeAnimatedNodesManager((UIManagerModule) reactApplicationContextIfActiveOrWarn.getNativeModule(UIManagerModule.class));
            }
        }
        return this.mNodesManager;
    }

    public void addAnimatedEventToView(double d2, final String str, final ReadableMap readableMap) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                String str = str;
                ReadableMap readableMap = readableMap;
                if (nativeAnimatedNodesManager != null) {
                    int i2 = readableMap.getInt("animatedValueTag");
                    AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i2);
                    if (animatedNode == null) {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i2, " does not exists"));
                    } else if (animatedNode instanceof ValueAnimatedNode) {
                        ReadableArray array = readableMap.getArray("nativeEventPath");
                        ArrayList arrayList = new ArrayList(array.size());
                        for (int i3 = 0; i3 < array.size(); i3++) {
                            arrayList.add(array.getString(i3));
                        }
                        EventAnimationDriver eventAnimationDriver = new EventAnimationDriver(arrayList, (ValueAnimatedNode) animatedNode);
                        String str2 = i + str;
                        if (nativeAnimatedNodesManager.mEventDrivers.containsKey(str2)) {
                            nativeAnimatedNodesManager.mEventDrivers.get(str2).add(eventAnimationDriver);
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(eventAnimationDriver);
                        nativeAnimatedNodesManager.mEventDrivers.put(str2, arrayList2);
                    } else {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline35(ValueAnimatedNode.class, GeneratedOutlineSupport.outline73("Animated node connected to event should beof type ")));
                    }
                } else {
                    throw null;
                }
            }
        });
    }

    public void addListener(String str) {
    }

    public void connectAnimatedNodeToView(double d2, double d3) {
        final int i = (int) d2;
        final int i2 = (int) d3;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists"));
                } else if (animatedNode instanceof PropsAnimatedNode) {
                    PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode;
                    if (propsAnimatedNode.mConnectedViewTag == -1) {
                        propsAnimatedNode.mConnectedViewTag = i2;
                        nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("Animated node "), propsAnimatedNode.mTag, " is already attached to a view"));
                } else {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline35(PropsAnimatedNode.class, GeneratedOutlineSupport.outline73("Animated node connected to view should beof type ")));
                }
            }
        });
    }

    public void connectAnimatedNodes(double d2, double d3) {
        final int i = (int) d2;
        final int i2 = (int) d3;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode != null) {
                    AnimatedNode animatedNode2 = nativeAnimatedNodesManager.mAnimatedNodes.get(i2);
                    if (animatedNode2 != null) {
                        if (animatedNode.mChildren == null) {
                            animatedNode.mChildren = new ArrayList(1);
                        }
                        List<AnimatedNode> list = animatedNode.mChildren;
                        ImageOriginUtils.assertNotNull(list);
                        list.add(animatedNode2);
                        animatedNode2.onAttachedToNode(animatedNode);
                        nativeAnimatedNodesManager.mUpdatedNodes.put(i2, animatedNode2);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i2, " does not exists"));
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists"));
            }
        });
    }

    public void createAnimatedNode(double d2, final ReadableMap readableMap) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                AnimatedNode animatedNode;
                int i = i;
                ReadableMap readableMap = readableMap;
                if (nativeAnimatedNodesManager.mAnimatedNodes.get(i) == null) {
                    String string = readableMap.getString("type");
                    if ("style".equals(string)) {
                        animatedNode = new StyleAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if (HSLCriteriaBuilder.VALUE.equals(string)) {
                        animatedNode = new ValueAnimatedNode(readableMap);
                    } else if ("props".equals(string)) {
                        animatedNode = new PropsAnimatedNode(readableMap, nativeAnimatedNodesManager, nativeAnimatedNodesManager.mUIManagerModule);
                    } else if ("interpolation".equals(string)) {
                        animatedNode = new InterpolationAnimatedNode(readableMap);
                    } else if ("addition".equals(string)) {
                        animatedNode = new AdditionAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("subtraction".equals(string)) {
                        animatedNode = new SubtractionAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("division".equals(string)) {
                        animatedNode = new DivisionAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("multiplication".equals(string)) {
                        animatedNode = new MultiplicationAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("modulus".equals(string)) {
                        animatedNode = new ModulusAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("diffclamp".equals(string)) {
                        animatedNode = new DiffClampAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("transform".equals(string)) {
                        animatedNode = new TransformAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("tracking".equals(string)) {
                        animatedNode = new TrackingAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Unsupported node type: ", string));
                    }
                    animatedNode.mTag = i;
                    nativeAnimatedNodesManager.mAnimatedNodes.put(i, animatedNode);
                    nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
                    return;
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " already exists"));
            }
        });
    }

    public void disconnectAnimatedNodeFromView(double d2, double d3) {
        final int i = (int) d2;
        final int i2 = (int) d3;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists"));
                } else if (animatedNode instanceof PropsAnimatedNode) {
                    PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode;
                    if (propsAnimatedNode.mConnectedViewTag == i2) {
                        propsAnimatedNode.mConnectedViewTag = -1;
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node");
                } else {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline35(PropsAnimatedNode.class, GeneratedOutlineSupport.outline73("Animated node connected to view should beof type ")));
                }
            }
        });
    }

    public void disconnectAnimatedNodes(double d2, double d3) {
        final int i = (int) d2;
        final int i2 = (int) d3;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode != null) {
                    AnimatedNode animatedNode2 = nativeAnimatedNodesManager.mAnimatedNodes.get(i2);
                    if (animatedNode2 != null) {
                        if (animatedNode.mChildren != null) {
                            animatedNode2.onDetachedFromNode(animatedNode);
                            animatedNode.mChildren.remove(animatedNode2);
                        }
                        nativeAnimatedNodesManager.mUpdatedNodes.put(i2, animatedNode2);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i2, " does not exists"));
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists"));
            }
        });
    }

    public void dropAnimatedNode(double d2) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                nativeAnimatedNodesManager.mAnimatedNodes.remove(i);
                nativeAnimatedNodesManager.mUpdatedNodes.remove(i);
            }
        });
    }

    public void extractAnimatedNodeOffset(double d2) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNode;
                valueAnimatedNode.mOffset += valueAnimatedNode.mValue;
                valueAnimatedNode.mValue = 0.0d;
            }
        });
    }

    public void flattenAnimatedNodeOffset(double d2) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNode;
                valueAnimatedNode.mValue += valueAnimatedNode.mOffset;
                valueAnimatedNode.mOffset = 0.0d;
            }
        });
    }

    public String getName() {
        return NAME;
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null && !reactApplicationContextIfActiveOrWarn.isBridgeless()) {
            reactApplicationContextIfActiveOrWarn.addLifecycleEventListener(this);
            ((UIManagerModule) reactApplicationContextIfActiveOrWarn.getNativeModule(UIManagerModule.class)).addUIManagerListener(this);
        }
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        clearFrameCallback();
    }

    public void onHostResume() {
        enqueueFrameCallback();
    }

    public void removeAnimatedEventFromView(double d2, final String str, double d3) {
        final int i = (int) d2;
        final int i2 = (int) d3;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                String str = str;
                int i2 = i2;
                if (nativeAnimatedNodesManager != null) {
                    String str2 = i + str;
                    if (nativeAnimatedNodesManager.mEventDrivers.containsKey(str2)) {
                        List list = nativeAnimatedNodesManager.mEventDrivers.get(str2);
                        if (list.size() == 1) {
                            nativeAnimatedNodesManager.mEventDrivers.remove(i + str);
                            return;
                        }
                        ListIterator listIterator = list.listIterator();
                        while (listIterator.hasNext()) {
                            if (((EventAnimationDriver) listIterator.next()).mValueNode.mTag == i2) {
                                listIterator.remove();
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                throw null;
            }
        });
    }

    public void removeListeners(double d2) {
    }

    public void restoreDefaultValues(double d2) {
        final int i = (int) d2;
        this.mPreOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode != null) {
                    if (animatedNode instanceof PropsAnimatedNode) {
                        PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode;
                        ReadableMapKeySetIterator keySetIterator = propsAnimatedNode.mPropMap.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            propsAnimatedNode.mPropMap.putNull(keySetIterator.nextKey());
                        }
                        propsAnimatedNode.mUIManager.synchronouslyUpdateViewOnUIThread(propsAnimatedNode.mConnectedViewTag, propsAnimatedNode.mPropMap);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline35(PropsAnimatedNode.class, GeneratedOutlineSupport.outline73("Animated node connected to view should beof type ")));
                }
            }
        });
    }

    public void setAnimatedNodeOffset(double d2, final double d3) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                double d2 = d3;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ((ValueAnimatedNode) animatedNode).mOffset = d2;
                nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
            }
        });
    }

    public void setAnimatedNodeValue(double d2, final double d3) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                double d2 = d3;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                nativeAnimatedNodesManager.stopAnimationsForNode(animatedNode);
                ((ValueAnimatedNode) animatedNode).mValue = d2;
                nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
            }
        });
    }

    public void setNodesManager(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNodesManager = nativeAnimatedNodesManager;
    }

    public void startAnimatingNode(double d2, double d3, ReadableMap readableMap, Callback callback) {
        final int i = (int) d2;
        final int i2 = (int) d3;
        ArrayList<UIThreadOperation> arrayList = this.mOperations;
        final ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        AnonymousClass13 r0 = new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startAnimatingNode(i, i2, readableMap2, callback2);
            }
        };
        arrayList.add(r0);
    }

    public void startListeningToAnimatedNodeValue(double d2) {
        final int i = (int) d2;
        final AnonymousClass5 r4 = new AnimatedNodeValueListener() {
        };
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNodeValueListener animatedNodeValueListener = r4;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ((ValueAnimatedNode) animatedNode).mValueListener = animatedNodeValueListener;
            }
        });
    }

    public void stopAnimation(double d2) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                for (int i2 = 0; i2 < nativeAnimatedNodesManager.mActiveAnimations.size(); i2++) {
                    AnimationDriver valueAt = nativeAnimatedNodesManager.mActiveAnimations.valueAt(i2);
                    if (valueAt.mId == i) {
                        if (valueAt.mEndCallback != null) {
                            WritableMap createMap = Arguments.createMap();
                            createMap.putBoolean("finished", false);
                            valueAt.mEndCallback.invoke(createMap);
                        }
                        nativeAnimatedNodesManager.mActiveAnimations.removeAt(i2);
                        return;
                    }
                }
            }
        });
    }

    public void stopListeningToAnimatedNodeValue(double d2) {
        final int i = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ((ValueAnimatedNode) animatedNode).mValueListener = null;
            }
        });
    }

    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty() || !this.mPreOperations.isEmpty()) {
            final ArrayList<UIThreadOperation> arrayList = this.mPreOperations;
            final ArrayList<UIThreadOperation> arrayList2 = this.mOperations;
            this.mPreOperations = new ArrayList<>();
            this.mOperations = new ArrayList<>();
            uIManagerModule.prependUIBlock(new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedNodesManager access$000 = NativeAnimatedModule.this.getNodesManager();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(access$000);
                    }
                }
            });
            uIManagerModule.addUIBlock(new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedNodesManager access$000 = NativeAnimatedModule.this.getNodesManager();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(access$000);
                    }
                }
            });
        }
    }
}
