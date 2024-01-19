package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "ChatBotModule")
public class ChatBotModule extends ReactContextBaseJavaModule {
    public static final String TAG = "ChatBotModule";

    public ChatBotModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void openChatBot(ReadableMap readableMap) {
    }
}
