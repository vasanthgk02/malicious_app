package com.swmansion.gesturehandler.react;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.soloader.SoLoader;
import com.google.android.material.resources.TextAppearanceConfig;
import com.paynimo.android.payment.PaymentActivity;
import com.swmansion.gesturehandler.ReanimatedEventDispatcher;
import com.swmansion.gesturehandler.core.FlingGestureHandler;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.LongPressGestureHandler;
import com.swmansion.gesturehandler.core.ManualGestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.gesturehandler.core.PinchGestureHandler;
import com.swmansion.gesturehandler.core.RotationGestureHandler;
import com.swmansion.gesturehandler.core.TapGestureHandler;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0007\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\nMNOPQRSTUVB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0007J0\u0010\u001e\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0007J\u0011\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J.\u0010)\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u000b\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u001f0 H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020.0-H\u0016J\b\u0010/\u001a\u00020\"H\u0016J\b\u00100\u001a\u00020\u0019H\u0007J\u0018\u00101\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0007J\b\u00104\u001a\u000203H\u0007J\b\u00105\u001a\u00020\u0019H\u0016J%\u00106\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010*\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u00107J5\u00108\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010*\u001a\u0002H\u001f2\u0006\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010;J%\u0010<\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010*\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u00107J\u000e\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0017J\u0018\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020BH\u0002J%\u0010C\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0D2\u0006\u0010E\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u00020\u00192\u0006\u0010E\u001a\u00020HH\u0002J%\u0010I\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0D2\u0006\u0010E\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u0010FJ\u0018\u0010J\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u001bH\u0016J\u000e\u0010K\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0017J(\u0010L\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0007R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/swmansion/common/GestureHandlerStateManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "eventListener", "com/swmansion/gesturehandler/react/RNGestureHandlerModule$eventListener$1", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$eventListener$1;", "handlerFactories", "", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "[Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "interactionManager", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager;", "reanimatedEventDispatcher", "Lcom/swmansion/gesturehandler/ReanimatedEventDispatcher;", "registry", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "getRegistry", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "roots", "", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "attachGestureHandler", "", "handlerTag", "", "viewTag", "actionType", "createGestureHandler", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handlerName", "", "config", "Lcom/facebook/react/bridge/ReadableMap;", "decorateRuntime", "jsiPtr", "", "dropGestureHandler", "findFactoryForHandler", "handler", "findRootHelperForViewAncestor", "getConstants", "", "", "getName", "handleClearJSResponder", "handleSetJSResponder", "blockNativeResponder", "", "install", "onCatalystInstanceDestroy", "onHandlerUpdate", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)V", "onStateChange", "newState", "oldState", "(Lcom/swmansion/gesturehandler/core/GestureHandler;II)V", "onTouchEvent", "registerRootHelper", "root", "sendEventForDeviceEvent", "eventName", "data", "Lcom/facebook/react/bridge/WritableMap;", "sendEventForDirectEvent", "Lcom/facebook/react/uimanager/events/Event;", "event", "(Lcom/facebook/react/uimanager/events/Event;)V", "sendEventForNativeAnimatedEvent", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEvent;", "sendEventForReanimated", "setGestureHandlerState", "unregisterRootHelper", "updateGestureHandler", "Companion", "FlingGestureHandlerFactory", "HandlerFactory", "LongPressGestureHandlerFactory", "ManualGestureHandlerFactory", "NativeViewGestureHandlerFactory", "PanGestureHandlerFactory", "PinchGestureHandlerFactory", "RotationGestureHandlerFactory", "TapGestureHandlerFactory", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "RNGestureHandlerModule")
/* compiled from: RNGestureHandlerModule.kt */
public final class RNGestureHandlerModule extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DIRECTION = "direction";
    public static final String KEY_ENABLED = "enabled";
    public static final String KEY_HIT_SLOP = "hitSlop";
    public static final String KEY_HIT_SLOP_BOTTOM = "bottom";
    public static final String KEY_HIT_SLOP_HEIGHT = "height";
    public static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
    public static final String KEY_HIT_SLOP_LEFT = "left";
    public static final String KEY_HIT_SLOP_RIGHT = "right";
    public static final String KEY_HIT_SLOP_TOP = "top";
    public static final String KEY_HIT_SLOP_VERTICAL = "vertical";
    public static final String KEY_HIT_SLOP_WIDTH = "width";
    public static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";
    public static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";
    public static final String KEY_MANUAL_ACTIVATION = "manualActivation";
    public static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";
    public static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
    public static final String KEY_NEEDS_POINTER_DATA = "needsPointerData";
    public static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
    public static final String KEY_PAN_ACTIVATE_AFTER_LONG_PRESS = "activateAfterLongPress";
    public static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
    public static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
    public static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
    public static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
    public static final String KEY_PAN_AVG_TOUCHES = "avgTouches";
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
    public static final String KEY_PAN_MAX_POINTERS = "maxPointers";
    public static final String KEY_PAN_MIN_DIST = "minDist";
    public static final String KEY_PAN_MIN_POINTERS = "minPointers";
    public static final String KEY_PAN_MIN_VELOCITY = "minVelocity";
    public static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";
    public static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";
    public static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
    public static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";
    public static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";
    public static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";
    public static final String KEY_TAP_MAX_DIST = "maxDist";
    public static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";
    public static final String KEY_TAP_MIN_POINTERS = "minPointers";
    public static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";
    public static final String MODULE_NAME = "RNGestureHandlerModule";
    public final RNGestureHandlerModule$eventListener$1 eventListener = new RNGestureHandlerModule$eventListener$1(this);
    public final HandlerFactory<?>[] handlerFactories = {new NativeViewGestureHandlerFactory(), new TapGestureHandlerFactory(), new LongPressGestureHandlerFactory(), new PanGestureHandlerFactory(), new PinchGestureHandlerFactory(), new RotationGestureHandlerFactory(), new FlingGestureHandlerFactory(), new ManualGestureHandlerFactory()};
    public final RNGestureHandlerInteractionManager interactionManager = new RNGestureHandlerInteractionManager();
    public final ReanimatedEventDispatcher reanimatedEventDispatcher = new ReanimatedEventDispatcher();
    public final RNGestureHandlerRegistry registry = new RNGestureHandlerRegistry();
    public final List<RNGestureHandlerRootHelper> roots = new ArrayList();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010/\u001a\u0002002\n\u00101\u001a\u0006\u0012\u0002\b\u0003022\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$Companion;", "", "()V", "KEY_DIRECTION", "", "KEY_ENABLED", "KEY_HIT_SLOP", "KEY_HIT_SLOP_BOTTOM", "KEY_HIT_SLOP_HEIGHT", "KEY_HIT_SLOP_HORIZONTAL", "KEY_HIT_SLOP_LEFT", "KEY_HIT_SLOP_RIGHT", "KEY_HIT_SLOP_TOP", "KEY_HIT_SLOP_VERTICAL", "KEY_HIT_SLOP_WIDTH", "KEY_LONG_PRESS_MAX_DIST", "KEY_LONG_PRESS_MIN_DURATION_MS", "KEY_MANUAL_ACTIVATION", "KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION", "KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START", "KEY_NEEDS_POINTER_DATA", "KEY_NUMBER_OF_POINTERS", "KEY_PAN_ACTIVATE_AFTER_LONG_PRESS", "KEY_PAN_ACTIVE_OFFSET_X_END", "KEY_PAN_ACTIVE_OFFSET_X_START", "KEY_PAN_ACTIVE_OFFSET_Y_END", "KEY_PAN_ACTIVE_OFFSET_Y_START", "KEY_PAN_AVG_TOUCHES", "KEY_PAN_FAIL_OFFSET_RANGE_X_END", "KEY_PAN_FAIL_OFFSET_RANGE_X_START", "KEY_PAN_FAIL_OFFSET_RANGE_Y_END", "KEY_PAN_FAIL_OFFSET_RANGE_Y_START", "KEY_PAN_MAX_POINTERS", "KEY_PAN_MIN_DIST", "KEY_PAN_MIN_POINTERS", "KEY_PAN_MIN_VELOCITY", "KEY_PAN_MIN_VELOCITY_X", "KEY_PAN_MIN_VELOCITY_Y", "KEY_SHOULD_CANCEL_WHEN_OUTSIDE", "KEY_TAP_MAX_DELAY_MS", "KEY_TAP_MAX_DELTA_X", "KEY_TAP_MAX_DELTA_Y", "KEY_TAP_MAX_DIST", "KEY_TAP_MAX_DURATION_MS", "KEY_TAP_MIN_POINTERS", "KEY_TAP_NUMBER_OF_TAPS", "MODULE_NAME", "handleHitSlopProperty", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$FlingGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/FlingGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class FlingGestureHandlerFactory extends HandlerFactory<FlingGestureHandler> {
        public final String name = "FlingGestureHandler";
        public final Class<FlingGestureHandler> type = FlingGestureHandler.class;

        public void configure(GestureHandler gestureHandler, ReadableMap readableMap) {
            FlingGestureHandler flingGestureHandler = (FlingGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(flingGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(flingGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                flingGestureHandler.numberOfPointersRequired = readableMap.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                flingGestureHandler.direction = readableMap.getInt(RNGestureHandlerModule.KEY_DIRECTION);
            }
        }

        public GestureHandler create(Context context) {
            return new FlingGestureHandler();
        }

        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            FlingGestureHandler flingGestureHandler = (FlingGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(flingGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(flingGestureHandler, writableMap);
            writableMap.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel(flingGestureHandler.lastAbsolutePositionX));
            writableMap.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel(flingGestureHandler.lastAbsolutePositionY));
            writableMap.putDouble("absoluteX", (double) ImageOriginUtils.toDIPFromPixel(flingGestureHandler.getLastPositionInWindowX()));
            writableMap.putDouble("absoluteY", (double) ImageOriginUtils.toDIPFromPixel(flingGestureHandler.getLastPositionInWindowY()));
        }

        public String getName() {
            return this.name;
        }

        public Class<FlingGestureHandler> getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/facebook/react/bridge/ReadableMap;)V", "create", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/swmansion/gesturehandler/core/GestureHandler;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/facebook/react/bridge/WritableMap;)V", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static abstract class HandlerFactory<T extends GestureHandler<T>> implements RNGestureHandlerEventDataExtractor<T> {
        public void configure(T t, ReadableMap readableMap) {
            float f2;
            float f3;
            float f4;
            float f5;
            Intrinsics.checkNotNullParameter(t, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            t.resetConfig();
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                t.shouldCancelWhenOutside = readableMap.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_ENABLED)) {
                boolean z = readableMap.getBoolean(RNGestureHandlerModule.KEY_ENABLED);
                if (!(t.view == null || t.isEnabled == z)) {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public final void run() {
                            GestureHandler.m52setEnabled$lambda3$lambda2(GestureHandler.this);
                        }
                    });
                }
                t.isEnabled = z;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                if (RNGestureHandlerModule.Companion == null) {
                    throw null;
                } else if (readableMap.getType(RNGestureHandlerModule.KEY_HIT_SLOP) == ReadableType.Number) {
                    float pixelFromDIP = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP));
                    t.setHitSlop(pixelFromDIP, pixelFromDIP, pixelFromDIP, pixelFromDIP, Float.NaN, Float.NaN);
                } else {
                    ReadableMap map = readableMap.getMap(RNGestureHandlerModule.KEY_HIT_SLOP);
                    Intrinsics.checkNotNull(map);
                    Intrinsics.checkNotNullExpressionValue(map, "config.getMap(KEY_HIT_SLOP)!!");
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL)) {
                        f3 = ImageOriginUtils.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL));
                        f2 = f3;
                    } else {
                        f3 = Float.NaN;
                        f2 = Float.NaN;
                    }
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL)) {
                        f5 = ImageOriginUtils.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL));
                        f4 = f5;
                    } else {
                        f5 = Float.NaN;
                        f4 = Float.NaN;
                    }
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) {
                        f3 = ImageOriginUtils.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT));
                    }
                    float f6 = f3;
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_TOP)) {
                        f5 = ImageOriginUtils.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP));
                    }
                    float f7 = f5;
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) {
                        f2 = ImageOriginUtils.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT));
                    }
                    float f8 = f2;
                    if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM)) {
                        f4 = ImageOriginUtils.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM));
                    }
                    t.setHitSlop(f6, f7, f8, f4, map.hasKey("width") ? ImageOriginUtils.toPixelFromDIP(map.getDouble("width")) : Float.NaN, map.hasKey("height") ? ImageOriginUtils.toPixelFromDIP(map.getDouble("height")) : Float.NaN);
                }
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA)) {
                t.needsPointerData = readableMap.getBoolean(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION)) {
                t.manualActivation = readableMap.getBoolean(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION);
            }
        }

        public abstract T create(Context context);

        public void extractEventData(T t, WritableMap writableMap) {
            Intrinsics.checkNotNullParameter(t, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) t.numberOfPointers);
        }

        public abstract String getName();

        public abstract Class<T> getType();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$LongPressGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/LongPressGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class LongPressGestureHandlerFactory extends HandlerFactory<LongPressGestureHandler> {
        public final String name = "LongPressGestureHandler";
        public final Class<LongPressGestureHandler> type = LongPressGestureHandler.class;

        public void configure(GestureHandler gestureHandler, ReadableMap readableMap) {
            LongPressGestureHandler longPressGestureHandler = (LongPressGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(longPressGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(longPressGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                longPressGestureHandler.minDurationMs = (long) readableMap.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS);
            }
            if (readableMap.hasKey("maxDist")) {
                float pixelFromDIP = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble("maxDist"));
                longPressGestureHandler.maxDistSq = pixelFromDIP * pixelFromDIP;
            }
        }

        public GestureHandler create(Context context) {
            Intrinsics.checkNotNull(context);
            return new LongPressGestureHandler(context);
        }

        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            LongPressGestureHandler longPressGestureHandler = (LongPressGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(longPressGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(longPressGestureHandler, writableMap);
            writableMap.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel(longPressGestureHandler.lastAbsolutePositionX));
            writableMap.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel(longPressGestureHandler.lastAbsolutePositionY));
            writableMap.putDouble("absoluteX", (double) ImageOriginUtils.toDIPFromPixel(longPressGestureHandler.getLastPositionInWindowX()));
            writableMap.putDouble("absoluteY", (double) ImageOriginUtils.toDIPFromPixel(longPressGestureHandler.getLastPositionInWindowY()));
            writableMap.putInt(InlineAnimation.DURATION, (int) (longPressGestureHandler.previousTime - longPressGestureHandler.startTime));
        }

        public String getName() {
            return this.name;
        }

        public Class<LongPressGestureHandler> getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$ManualGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/ManualGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class ManualGestureHandlerFactory extends HandlerFactory<ManualGestureHandler> {
        public final String name = "ManualGestureHandler";
        public final Class<ManualGestureHandler> type = ManualGestureHandler.class;

        public GestureHandler create(Context context) {
            return new ManualGestureHandler();
        }

        public String getName() {
            return this.name;
        }

        public Class<ManualGestureHandler> getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$NativeViewGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class NativeViewGestureHandlerFactory extends HandlerFactory<NativeViewGestureHandler> {
        public final String name = "NativeViewGestureHandler";
        public final Class<NativeViewGestureHandler> type = NativeViewGestureHandler.class;

        public void configure(GestureHandler gestureHandler, ReadableMap readableMap) {
            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(nativeViewGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(nativeViewGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                nativeViewGestureHandler.shouldActivateOnStart = readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                nativeViewGestureHandler.disallowInterruption = readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION);
            }
        }

        public GestureHandler create(Context context) {
            return new NativeViewGestureHandler();
        }

        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(nativeViewGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(nativeViewGestureHandler, writableMap);
            writableMap.putBoolean("pointerInside", nativeViewGestureHandler.isWithinBounds);
        }

        public String getName() {
            return this.name;
        }

        public Class<NativeViewGestureHandler> getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$PanGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/PanGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class PanGestureHandlerFactory extends HandlerFactory<PanGestureHandler> {
        public final String name = "PanGestureHandler";
        public final Class<PanGestureHandler> type = PanGestureHandler.class;

        public void configure(GestureHandler gestureHandler, ReadableMap readableMap) {
            boolean z;
            PanGestureHandler panGestureHandler = (PanGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(panGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(panGestureHandler, readableMap);
            boolean z2 = true;
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                panGestureHandler.activeOffsetXStart = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START));
                z = true;
            } else {
                z = false;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                panGestureHandler.activeOffsetXEnd = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                panGestureHandler.failOffsetXStart = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                panGestureHandler.failOffsetXEnd = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                panGestureHandler.activeOffsetYStart = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                panGestureHandler.activeOffsetYEnd = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                panGestureHandler.failOffsetYStart = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                panGestureHandler.failOffsetYEnd = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                float pixelFromDIP = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY));
                panGestureHandler.minVelocitySq = pixelFromDIP * pixelFromDIP;
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                panGestureHandler.minVelocityX = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                panGestureHandler.minVelocityY = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y));
            } else {
                z2 = z;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                float pixelFromDIP2 = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST));
                panGestureHandler.minDistSq = pixelFromDIP2 * pixelFromDIP2;
            } else if (z2) {
                panGestureHandler.minDistSq = Float.POSITIVE_INFINITY;
            }
            if (readableMap.hasKey("minPointers")) {
                panGestureHandler.minPointers = readableMap.getInt("minPointers");
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                panGestureHandler.maxPointers = readableMap.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                panGestureHandler.averageTouches = readableMap.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS)) {
                panGestureHandler.activateAfterLongPress = (long) readableMap.getInt(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS);
            }
        }

        public GestureHandler create(Context context) {
            return new PanGestureHandler(context);
        }

        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            PanGestureHandler panGestureHandler = (PanGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(panGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(panGestureHandler, writableMap);
            writableMap.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel(panGestureHandler.lastAbsolutePositionX));
            writableMap.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel(panGestureHandler.lastAbsolutePositionY));
            writableMap.putDouble("absoluteX", (double) ImageOriginUtils.toDIPFromPixel(panGestureHandler.getLastPositionInWindowX()));
            writableMap.putDouble("absoluteY", (double) ImageOriginUtils.toDIPFromPixel(panGestureHandler.getLastPositionInWindowY()));
            writableMap.putDouble("translationX", (double) ImageOriginUtils.toDIPFromPixel((panGestureHandler.lastX - panGestureHandler.startX) + panGestureHandler.offsetX));
            writableMap.putDouble("translationY", (double) ImageOriginUtils.toDIPFromPixel((panGestureHandler.lastY - panGestureHandler.startY) + panGestureHandler.offsetY));
            writableMap.putDouble("velocityX", (double) ImageOriginUtils.toDIPFromPixel(panGestureHandler.velocityX));
            writableMap.putDouble("velocityY", (double) ImageOriginUtils.toDIPFromPixel(panGestureHandler.velocityY));
        }

        public String getName() {
            return this.name;
        }

        public Class<PanGestureHandler> getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$PinchGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/PinchGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "extractEventData", "", "handler", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class PinchGestureHandlerFactory extends HandlerFactory<PinchGestureHandler> {
        public final String name = "PinchGestureHandler";
        public final Class<PinchGestureHandler> type = PinchGestureHandler.class;

        public GestureHandler create(Context context) {
            return new PinchGestureHandler();
        }

        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            PinchGestureHandler pinchGestureHandler = (PinchGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(pinchGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(pinchGestureHandler, writableMap);
            writableMap.putDouble("scale", pinchGestureHandler.scale);
            writableMap.putDouble("focalX", (double) ImageOriginUtils.toDIPFromPixel(pinchGestureHandler.focalPointX));
            writableMap.putDouble("focalY", (double) ImageOriginUtils.toDIPFromPixel(pinchGestureHandler.focalPointY));
            writableMap.putDouble("velocity", pinchGestureHandler.velocity);
        }

        public String getName() {
            return this.name;
        }

        public Class<PinchGestureHandler> getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$RotationGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/RotationGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "extractEventData", "", "handler", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class RotationGestureHandlerFactory extends HandlerFactory<RotationGestureHandler> {
        public final String name = "RotationGestureHandler";
        public final Class<RotationGestureHandler> type = RotationGestureHandler.class;

        public GestureHandler create(Context context) {
            return new RotationGestureHandler();
        }

        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            RotationGestureHandler rotationGestureHandler = (RotationGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(rotationGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(rotationGestureHandler, writableMap);
            writableMap.putDouble("rotation", rotationGestureHandler.rotation);
            writableMap.putDouble("anchorX", (double) ImageOriginUtils.toDIPFromPixel(rotationGestureHandler.anchorX));
            writableMap.putDouble("anchorY", (double) ImageOriginUtils.toDIPFromPixel(rotationGestureHandler.anchorY));
            writableMap.putDouble("velocity", rotationGestureHandler.velocity);
        }

        public String getName() {
            return this.name;
        }

        public Class<RotationGestureHandler> getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$TapGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/TapGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "extractEventData", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerModule.kt */
    public static final class TapGestureHandlerFactory extends HandlerFactory<TapGestureHandler> {
        public final String name = "TapGestureHandler";
        public final Class<TapGestureHandler> type = TapGestureHandler.class;

        public void configure(GestureHandler gestureHandler, ReadableMap readableMap) {
            TapGestureHandler tapGestureHandler = (TapGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(tapGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(readableMap, "config");
            super.configure(tapGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                tapGestureHandler.numberOfTaps = readableMap.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                tapGestureHandler.maxDurationMs = (long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                tapGestureHandler.maxDelayMs = (long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                tapGestureHandler.maxDeltaX = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                tapGestureHandler.maxDeltaY = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y));
            }
            if (readableMap.hasKey("maxDist")) {
                float pixelFromDIP = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble("maxDist"));
                tapGestureHandler.maxDistSq = pixelFromDIP * pixelFromDIP;
            }
            if (readableMap.hasKey("minPointers")) {
                tapGestureHandler.minNumberOfPointers = readableMap.getInt("minPointers");
            }
        }

        public GestureHandler create(Context context) {
            return new TapGestureHandler();
        }

        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            TapGestureHandler tapGestureHandler = (TapGestureHandler) gestureHandler;
            Intrinsics.checkNotNullParameter(tapGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(writableMap, "eventData");
            super.extractEventData(tapGestureHandler, writableMap);
            writableMap.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel(tapGestureHandler.lastAbsolutePositionX));
            writableMap.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel(tapGestureHandler.lastAbsolutePositionY));
            writableMap.putDouble("absoluteX", (double) ImageOriginUtils.toDIPFromPixel(tapGestureHandler.getLastPositionInWindowX()));
            writableMap.putDouble("absoluteY", (double) ImageOriginUtils.toDIPFromPixel(tapGestureHandler.getLastPositionInWindowY()));
        }

        public String getName() {
            return this.name;
        }

        public Class<TapGestureHandler> getType() {
            return this.type;
        }
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private final native void decorateRuntime(long j);

    private final <T extends GestureHandler<T>> HandlerFactory<T> findFactoryForHandler(GestureHandler<T> gestureHandler) {
        HandlerFactory<?>[] handlerFactoryArr = this.handlerFactories;
        int length = handlerFactoryArr.length;
        int i = 0;
        while (i < length) {
            HandlerFactory<?> handlerFactory = handlerFactoryArr[i];
            i++;
            if (Intrinsics.areEqual(handlerFactory.getType(), gestureHandler.getClass())) {
                return handlerFactory;
            }
        }
        return null;
    }

    private final RNGestureHandlerRootHelper findRootHelperForViewAncestor(int i) {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper;
        boolean z;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "<this>");
        NativeModule nativeModule = reactApplicationContext.getNativeModule(UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        int resolveRootTagFromReactTag = ((UIManagerModule) nativeModule).resolveRootTagFromReactTag(i);
        T t = null;
        if (resolveRootTagFromReactTag < 1) {
            return null;
        }
        synchronized (this.roots) {
            Iterator<T> it = this.roots.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper2 = (RNGestureHandlerRootHelper) next;
                if (!(rNGestureHandlerRootHelper2.rootView instanceof ReactRootView) || ((ReactRootView) rNGestureHandlerRootHelper2.rootView).getRootViewTag() != resolveRootTagFromReactTag) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            rNGestureHandlerRootHelper = (RNGestureHandlerRootHelper) t;
        }
        return rNGestureHandlerRootHelper;
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onHandlerUpdate(T t) {
        if (t.tag >= 0 && t.state == 4) {
            HandlerFactory findFactoryForHandler = findFactoryForHandler(t);
            int i = t.actionType;
            if (i == 1) {
                sendEventForReanimated(RNGestureHandlerEvent.Companion.obtain(t, findFactoryForHandler, false));
            } else if (i == 2) {
                sendEventForNativeAnimatedEvent(RNGestureHandlerEvent.Companion.obtain(t, findFactoryForHandler, false));
            } else if (i == 3) {
                sendEventForDirectEvent(RNGestureHandlerEvent.Companion.obtain(t, findFactoryForHandler, false));
            } else if (i == 4) {
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerEvent.Companion.createEventData(t, findFactoryForHandler));
            }
        }
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onStateChange(T t, int i, int i2) {
        if (t.tag >= 0) {
            HandlerFactory findFactoryForHandler = findFactoryForHandler(t);
            int i3 = t.actionType;
            if (i3 == 1) {
                RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent = RNGestureHandlerStateChangeEvent.Companion;
                sendEventForReanimated(RNGestureHandlerStateChangeEvent.obtain(t, i, i2, findFactoryForHandler));
            } else if (i3 == 2 || i3 == 3) {
                RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent2 = RNGestureHandlerStateChangeEvent.Companion;
                sendEventForDirectEvent(RNGestureHandlerStateChangeEvent.obtain(t, i, i2, findFactoryForHandler));
            } else if (i3 == 4) {
                RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent3 = RNGestureHandlerStateChangeEvent.Companion;
                sendEventForDeviceEvent("onGestureHandlerStateChange", RNGestureHandlerStateChangeEvent.createEventData(t, findFactoryForHandler, i, i2));
            }
        }
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onTouchEvent(T t) {
        if (t.tag >= 0) {
            int i = t.state;
            if (i == 2 || i == 4 || i == 0 || t.view != null) {
                int i2 = t.actionType;
                if (i2 == 1) {
                    RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent = RNGestureHandlerTouchEvent.Companion;
                    Intrinsics.checkNotNullParameter(t, "handler");
                    RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent2 = (RNGestureHandlerTouchEvent) RNGestureHandlerTouchEvent.EVENTS_POOL.acquire();
                    if (rNGestureHandlerTouchEvent2 == null) {
                        rNGestureHandlerTouchEvent2 = new RNGestureHandlerTouchEvent(null);
                    }
                    RNGestureHandlerTouchEvent.access$init(rNGestureHandlerTouchEvent2, t);
                    sendEventForReanimated(rNGestureHandlerTouchEvent2);
                } else if (i2 == 4) {
                    RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent3 = RNGestureHandlerTouchEvent.Companion;
                    sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerTouchEvent.createEventData(t));
                }
            }
        }
    }

    private final void sendEventForDeviceEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "<this>");
        JavaScriptModule jSModule = reactApplicationContext.getJSModule(RCTDeviceEventEmitter.class);
        Intrinsics.checkNotNullExpressionValue(jSModule, "this.getJSModule(DeviceE…EventEmitter::class.java)");
        ((RCTDeviceEventEmitter) jSModule).emit(str, writableMap);
    }

    private final <T extends Event<T>> void sendEventForDirectEvent(T t) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
        TextAppearanceConfig.dispatchEvent(reactApplicationContext, t);
    }

    private final void sendEventForNativeAnimatedEvent(RNGestureHandlerEvent rNGestureHandlerEvent) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
        TextAppearanceConfig.dispatchEvent(reactApplicationContext, rNGestureHandlerEvent);
    }

    private final <T extends Event<T>> void sendEventForReanimated(T t) {
        sendEventForDirectEvent(t);
    }

    @ReactMethod
    public final void attachGestureHandler(int i, int i2, int i3) {
        if (!this.registry.attachHandlerToView(i, i2, i3)) {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("Handler with tag ", i, " does not exists"));
        }
    }

    @ReactMethod
    public final <T extends GestureHandler<T>> void createGestureHandler(String str, int i, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(str, "handlerName");
        Intrinsics.checkNotNullParameter(readableMap, "config");
        HandlerFactory<?>[] handlerFactoryArr = this.handlerFactories;
        int length = handlerFactoryArr.length;
        int i2 = 0;
        while (i2 < length) {
            HandlerFactory<?> handlerFactory = handlerFactoryArr[i2];
            i2++;
            if (Intrinsics.areEqual(handlerFactory.getName(), str)) {
                GestureHandler create = handlerFactory.create(getReactApplicationContext());
                create.tag = i;
                create.onTouchEventListener = this.eventListener;
                this.registry.registerHandler(create);
                this.interactionManager.configureInteractions(create, readableMap);
                handlerFactory.configure(create, readableMap);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException(Intrinsics.stringPlus("Invalid handler name ", str));
    }

    @ReactMethod
    public final void dropGestureHandler(int i) {
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.interactionManager;
        rNGestureHandlerInteractionManager.waitForRelations.remove(i);
        rNGestureHandlerInteractionManager.simultaneousRelations.remove(i);
        this.registry.dropHandler(i);
    }

    public Map<String, Object> getConstants() {
        Integer valueOf = Integer.valueOf(2);
        return ArraysKt___ArraysJvmKt.mapOf(new Pair("State", ArraysKt___ArraysJvmKt.mapOf(new Pair("UNDETERMINED", Integer.valueOf(0)), new Pair("BEGAN", valueOf), new Pair("ACTIVE", Integer.valueOf(4)), new Pair("CANCELLED", Integer.valueOf(3)), new Pair("FAILED", Integer.valueOf(1)), new Pair("END", Integer.valueOf(5)))), new Pair("Direction", ArraysKt___ArraysJvmKt.mapOf(new Pair("RIGHT", Integer.valueOf(1)), new Pair("LEFT", valueOf), new Pair(PaymentActivity.CARD_I_AUTHORITY_UP, Integer.valueOf(4)), new Pair("DOWN", Integer.valueOf(8)))));
    }

    public String getName() {
        return MODULE_NAME;
    }

    public final RNGestureHandlerRegistry getRegistry() {
        return this.registry;
    }

    @ReactMethod
    public final void handleClearJSResponder() {
    }

    @ReactMethod
    public final void handleSetJSResponder(int i, boolean z) {
        RNGestureHandlerRootHelper findRootHelperForViewAncestor = findRootHelperForViewAncestor(i);
        if (findRootHelperForViewAncestor != null && z) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public final void run() {
                    RNGestureHandlerRootHelper.m59handleSetJSResponder$lambda6(RNGestureHandlerRootHelper.this);
                }
            });
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean install() {
        try {
            SoLoader.loadLibrary("gesturehandler");
            decorateRuntime(getReactApplicationContext().getJavaScriptContextHolder().get());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void onCatalystInstanceDestroy() {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = this.registry;
        synchronized (rNGestureHandlerRegistry) {
            rNGestureHandlerRegistry.handlers.clear();
            rNGestureHandlerRegistry.attachedTo.clear();
            rNGestureHandlerRegistry.handlersForView.clear();
        }
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.interactionManager;
        rNGestureHandlerInteractionManager.waitForRelations.clear();
        rNGestureHandlerInteractionManager.simultaneousRelations.clear();
        synchronized (this.roots) {
            while (!this.roots.isEmpty()) {
                int size = this.roots.size();
                this.roots.get(0).tearDown();
                if (this.roots.size() >= size) {
                    throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                }
            }
        }
        super.onCatalystInstanceDestroy();
    }

    public final void registerRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
        Intrinsics.checkNotNullParameter(rNGestureHandlerRootHelper, "root");
        synchronized (this.roots) {
            if (!this.roots.contains(rNGestureHandlerRootHelper)) {
                this.roots.add(rNGestureHandlerRootHelper);
            } else {
                throw new IllegalStateException("Root helper" + rNGestureHandlerRootHelper + " already registered");
            }
        }
    }

    public void setGestureHandlerState(int i, int i2) {
        GestureHandler gestureHandler;
        RNGestureHandlerRegistry rNGestureHandlerRegistry = this.registry;
        synchronized (rNGestureHandlerRegistry) {
            gestureHandler = rNGestureHandlerRegistry.handlers.get(i);
        }
        if (gestureHandler != null) {
            if (i2 == 1) {
                gestureHandler.fail();
            } else if (i2 == 2) {
                gestureHandler.begin();
            } else if (i2 == 3) {
                gestureHandler.cancel();
            } else if (i2 == 4) {
                gestureHandler.activate(true);
            } else if (i2 == 5) {
                gestureHandler.end();
            }
        }
    }

    public final void unregisterRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
        Intrinsics.checkNotNullParameter(rNGestureHandlerRootHelper, "root");
        synchronized (this.roots) {
            this.roots.remove(rNGestureHandlerRootHelper);
        }
    }

    @ReactMethod
    public final <T extends GestureHandler<T>> void updateGestureHandler(int i, ReadableMap readableMap) {
        GestureHandler gestureHandler;
        Intrinsics.checkNotNullParameter(readableMap, "config");
        RNGestureHandlerRegistry rNGestureHandlerRegistry = this.registry;
        synchronized (rNGestureHandlerRegistry) {
            gestureHandler = rNGestureHandlerRegistry.handlers.get(i);
        }
        if (gestureHandler != null) {
            HandlerFactory findFactoryForHandler = findFactoryForHandler(gestureHandler);
            if (findFactoryForHandler != null) {
                RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.interactionManager;
                rNGestureHandlerInteractionManager.waitForRelations.remove(i);
                rNGestureHandlerInteractionManager.simultaneousRelations.remove(i);
                this.interactionManager.configureInteractions(gestureHandler, readableMap);
                findFactoryForHandler.configure(gestureHandler, readableMap);
            }
        }
    }
}
