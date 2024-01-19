package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.fbreact.specs.NativeToastAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "ToastAndroid")
public class ToastModule extends NativeToastAndroidSpec {
    public static final String DURATION_LONG_KEY = "LONG";
    public static final String DURATION_SHORT_KEY = "SHORT";
    public static final String GRAVITY_BOTTOM_KEY = "BOTTOM";
    public static final String GRAVITY_CENTER = "CENTER";
    public static final String GRAVITY_TOP_KEY = "TOP";
    public static final String NAME = "ToastAndroid";

    public ToastModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(DURATION_SHORT_KEY, Integer.valueOf(0));
        hashMap.put(DURATION_LONG_KEY, Integer.valueOf(1));
        hashMap.put(GRAVITY_TOP_KEY, Integer.valueOf(49));
        hashMap.put(GRAVITY_BOTTOM_KEY, Integer.valueOf(81));
        hashMap.put(GRAVITY_CENTER, Integer.valueOf(17));
        return hashMap;
    }

    public void show(final String str, double d2) {
        final int i = (int) d2;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(ToastModule.this.getReactApplicationContext(), str, i).show();
            }
        });
    }

    public void showWithGravity(final String str, double d2, double d3) {
        final int i = (int) d2;
        final int i2 = (int) d3;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), str, i);
                makeText.setGravity(i2, 0, 0);
                makeText.show();
            }
        });
    }

    public void showWithGravityAndOffset(String str, double d2, double d3, double d4, double d5) {
        int i = (int) d3;
        final int i2 = (int) d4;
        final int i3 = (int) d5;
        final String str2 = str;
        final int i4 = (int) d2;
        final int i5 = i;
        AnonymousClass3 r4 = new Runnable() {
            public void run() {
                Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), str2, i4);
                makeText.setGravity(i5, i2, i3);
                makeText.show();
            }
        };
        UiThreadUtil.runOnUiThread(r4);
    }
}
