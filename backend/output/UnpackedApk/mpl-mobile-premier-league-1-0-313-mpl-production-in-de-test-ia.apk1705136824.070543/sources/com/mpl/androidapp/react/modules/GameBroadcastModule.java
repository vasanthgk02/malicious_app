package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.mpl.androidapp.utils.MLogger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u0006H\u0016J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J0\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/mpl/androidapp/react/modules/GameBroadcastModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "broadcastIdKey", "", "entryPointKey", "gameBroadcastRc", "", "notSet", "sessionIdKey", "timeStampKey", "getName", "openBroadcastFragment", "", "broadcastId", "launchTime", "", "entryPoint", "sessionId", "openPlayer", "map", "Lcom/facebook/react/bridge/ReadableMap;", "sendBroadcastTileClickedEvent", "context", "Landroid/content/Context;", "timestamp", "", "status", "sendEvent", "eventName", "data", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "GameBroadcastModule")
/* compiled from: GameBroadcastModule.kt */
public final class GameBroadcastModule extends ReactContextBaseJavaModule {
    public final String broadcastIdKey = "broadcastId";
    public final String entryPointKey = "entrypoint";
    public final int gameBroadcastRc = 8406;
    public final String notSet = "NOT SET";
    public final String sessionIdKey = "sessionId";
    public final String timeStampKey = "timestamp";

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GameBroadcastModule(ReactApplicationContext reactApplicationContext) {
        // Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        super(reactApplicationContext);
    }

    private final void openBroadcastFragment(String str, long j, String str2, String str3) {
    }

    private final void sendBroadcastTileClickedEvent(Context context, double d2, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("sendBroadcastTileClickedEvent -> [TimeStamp : ");
        sb.append(d2);
        sb.append(", EntryPoint : ");
        sb.append(str);
        GeneratedOutlineSupport.outline103(sb, ", SessionId: ", str2, ", Status : ", str3);
        sb.append(']');
        MLogger.d(GameBroadcastModuleKt.TAG, sb.toString());
        HashMap hashMap = new HashMap();
        if (d2 > 0.0d) {
            d2 = ((double) System.currentTimeMillis()) - d2;
        }
        hashMap.put("Timetaken", Double.valueOf(d2));
        hashMap.put("Status", str3);
    }

    private final void sendEvent(String str, String str2) {
        MLogger.d(GameBroadcastModuleKt.TAG, "sendEvent -> [EventName : " + str + ", Data : " + str2 + ']');
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit(str, str2);
    }

    public String getName() {
        return GameBroadcastModuleKt.TAG;
    }

    @ReactMethod
    public final void openPlayer(ReadableMap readableMap) {
        String str;
        Intrinsics.checkNotNullParameter(readableMap, "map");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            HashMap<String, Object> hashMap = readableMap.toHashMap();
            Intrinsics.checkNotNullExpressionValue(hashMap, "map.toHashMap()");
            boolean z = true;
            MLogger.d(GameBroadcastModuleKt.TAG, Intrinsics.stringPlus("openPlayer : ", readableMap.toHashMap()));
            Object obj = hashMap.get(this.entryPointKey);
            if (obj == null) {
                obj = this.notSet;
            }
            String str2 = (String) obj;
            Object obj2 = hashMap.get(this.sessionIdKey);
            if (obj2 == null) {
                obj2 = this.notSet;
            }
            String str3 = (String) obj2;
            Object obj3 = hashMap.get(this.timeStampKey);
            if (obj3 == null) {
                obj3 = Integer.valueOf(-1);
            }
            double doubleValue = ((Double) obj3).doubleValue();
            MLogger.d(GameBroadcastModuleKt.TAG, Intrinsics.stringPlus("TimeStamp: ", Double.valueOf(doubleValue)));
            Object obj4 = hashMap.get(this.broadcastIdKey);
            if (obj4 == null) {
                str = null;
            } else {
                String str4 = (String) obj4;
                if (((CharSequence) obj4).length() <= 0) {
                    z = false;
                }
                if (z) {
                    openBroadcastFragment(str4, System.currentTimeMillis(), str2, str3);
                    str = "Success";
                } else {
                    str = "Error Code | Broadcast Id is empty";
                }
            }
            if (str == null) {
                str = "Error Code | Broadcast Id is null";
            }
            sendBroadcastTileClickedEvent(currentActivity, doubleValue, str2, str3, str);
        }
    }
}
