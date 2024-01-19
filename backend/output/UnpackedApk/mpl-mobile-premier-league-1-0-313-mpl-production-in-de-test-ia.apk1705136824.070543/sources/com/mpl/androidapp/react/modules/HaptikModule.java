package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\u0013\u001a\u00020\u00102\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010\u0014\u001a\u00020\u0010H\u0007J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\"\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u001a\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¨\u0006\u001d"}, d2 = {"Lcom/mpl/androidapp/react/modules/HaptikModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "convertArrayToJson", "Lorg/json/JSONArray;", "readableArray", "Lcom/facebook/react/bridge/ReadableArray;", "convertMapToJson", "Lorg/json/JSONObject;", "readableMap", "Lcom/facebook/react/bridge/ReadableMap;", "getName", "", "initHaptikSdk", "", "promise", "Lcom/facebook/react/bridge/Promise;", "launchCustomSignUpConversation", "launchGuestConversation", "logOutHaptikSdk", "postError", "errorCallback", "module", "errorMessage", "setLaunchMessage", "launchMsg", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "HaptikSdkIntegration")
/* compiled from: HaptikModule.kt */
public final class HaptikModule extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "HaptikSdkIntegration";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/react/modules/HaptikModule$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HaptikModule.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HaptikModule.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            ReadableType readableType = ReadableType.Null;
            iArr[0] = 1;
            ReadableType readableType2 = ReadableType.Boolean;
            iArr[1] = 2;
            ReadableType readableType3 = ReadableType.Number;
            iArr[2] = 3;
            ReadableType readableType4 = ReadableType.String;
            iArr[3] = 4;
            ReadableType readableType5 = ReadableType.Map;
            iArr[4] = 5;
            ReadableType readableType6 = ReadableType.Array;
            iArr[5] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public HaptikModule(ReactApplicationContext reactApplicationContext) {
        // Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        super(reactApplicationContext);
    }

    private final JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNull(readableArray);
        int size = readableArray.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int ordinal = readableArray.getType(i).ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    jSONArray.put(readableArray.getBoolean(i));
                } else if (ordinal == 2) {
                    jSONArray.put(readableArray.getDouble(i));
                } else if (ordinal == 3) {
                    jSONArray.put(readableArray.getString(i));
                } else if (ordinal == 4) {
                    jSONArray.put(convertMapToJson(readableArray.getMap(i)));
                } else if (ordinal == 5) {
                    jSONArray.put(convertArrayToJson(readableArray.getArray(i)));
                }
            }
            i = i2;
        }
        return jSONArray;
    }

    private final JSONObject convertMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Intrinsics.checkNotNull(readableMap);
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Intrinsics.checkNotNullExpressionValue(keySetIterator, "readableMap!!.keySetIterator()");
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            int ordinal = readableMap.getType(nextKey).ordinal();
            if (ordinal == 0) {
                jSONObject.put(nextKey, JSONObject.NULL);
            } else if (ordinal == 1) {
                jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
            } else if (ordinal == 2) {
                jSONObject.put(nextKey, readableMap.getDouble(nextKey));
            } else if (ordinal == 3) {
                jSONObject.put(nextKey, readableMap.getString(nextKey));
            } else if (ordinal == 4) {
                jSONObject.put(nextKey, convertMapToJson(readableMap.getMap(nextKey)));
            } else if (ordinal == 5) {
                jSONObject.put(nextKey, convertArrayToJson(readableMap.getArray(nextKey)));
            }
        }
        return jSONObject;
    }

    private final void postError(Promise promise, String str, String str2) {
        if (promise != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("module", str);
            writableNativeMap.putString("errorMessage", str2);
            promise.resolve(writableNativeMap);
        }
    }

    public String getName() {
        return "HaptikSdkIntegration";
    }

    @ReactMethod
    public final void initHaptikSdk(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
    }

    @ReactMethod
    public final void launchCustomSignUpConversation(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
    }

    @ReactMethod
    public final void launchGuestConversation() {
    }

    @ReactMethod
    public final void logOutHaptikSdk(Promise promise) {
    }

    @ReactMethod
    public final void setLaunchMessage(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "launchMsg");
    }
}
