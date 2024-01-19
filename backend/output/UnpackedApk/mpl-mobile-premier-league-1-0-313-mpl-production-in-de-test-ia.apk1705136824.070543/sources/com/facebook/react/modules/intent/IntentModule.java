package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.fbreact.specs.NativeLinkingSpec;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

@ReactModule(name = "IntentAndroid")
public class IntentModule extends NativeLinkingSpec {
    public static final String NAME = "IntentAndroid";

    public IntentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void addListener(String str) {
    }

    public void canOpenURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid URL: ", str)));
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            promise.resolve(Boolean.valueOf(intent.resolveActivity(getReactApplicationContext().getPackageManager()) != null));
        } catch (Exception e2) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline80("Could not check if URL '", str, "' can be opened: "))));
        }
    }

    public void getInitialURL(Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            String str = null;
            if (currentActivity != null) {
                Intent intent = currentActivity.getIntent();
                String action = intent.getAction();
                Uri data = intent.getData();
                if (data != null && ("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action))) {
                    str = data.toString();
                }
            }
            promise.resolve(str);
        } catch (Exception e2) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Could not get the initial URL : "))));
        }
    }

    public String getName() {
        return NAME;
    }

    public void openSettings(Promise promise) {
        try {
            Intent intent = new Intent();
            Activity currentActivity = getCurrentActivity();
            String packageName = getReactApplicationContext().getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + packageName));
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.addFlags(1073741824);
            intent.addFlags(PDTextField.FLAG_DO_NOT_SCROLL);
            currentActivity.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Could not open the Settings: "))));
        }
    }

    public void openURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid URL: ", str)));
            return;
        }
        try {
            Activity currentActivity = getCurrentActivity();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).normalizeScheme());
            String packageName = getReactApplicationContext().getPackageName();
            ComponentName resolveActivity = intent.resolveActivity(getReactApplicationContext().getPackageManager());
            String packageName2 = resolveActivity != null ? resolveActivity.getPackageName() : "";
            if (currentActivity == null || !packageName.equals(packageName2)) {
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            }
            if (currentActivity != null) {
                currentActivity.startActivity(intent);
            } else {
                getReactApplicationContext().startActivity(intent);
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline80("Could not open URL '", str, "': "))));
        }
    }

    public void removeListeners(double d2) {
    }

    public void sendIntent(String str, ReadableArray readableArray, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline52("Invalid Action: ", str, ".")));
            return;
        }
        Intent intent = new Intent(str);
        if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) == null) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline52("Could not launch Intent with action ", str, ".")));
            return;
        }
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                String nextKey = map.keySetIterator().nextKey();
                int ordinal = map.getType(nextKey).ordinal();
                if (ordinal == 1) {
                    intent.putExtra(nextKey, map.getBoolean(nextKey));
                } else if (ordinal == 2) {
                    intent.putExtra(nextKey, Double.valueOf(map.getDouble(nextKey)));
                } else if (ordinal != 3) {
                    promise.reject((Throwable) new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline52("Extra type for ", nextKey, " not supported.")));
                    return;
                } else {
                    intent.putExtra(nextKey, map.getString(nextKey));
                }
            }
        }
        getReactApplicationContext().startActivity(intent);
    }
}
