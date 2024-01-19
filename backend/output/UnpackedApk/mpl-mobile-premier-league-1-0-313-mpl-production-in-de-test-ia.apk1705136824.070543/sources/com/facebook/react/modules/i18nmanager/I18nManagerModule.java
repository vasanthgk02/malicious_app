package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = "I18nManager")
public class I18nManagerModule extends ContextBaseJavaModule {
    public static final String NAME = "I18nManager";
    public final I18nUtil sharedI18nUtilInstance = I18nUtil.getInstance();

    public I18nManagerModule(Context context) {
        super(context);
    }

    @ReactMethod
    public void allowRTL(boolean z) {
        this.sharedI18nUtilInstance.setPref(getContext(), "RCTI18nUtil_allowRTL", z);
    }

    @ReactMethod
    public void forceRTL(boolean z) {
        this.sharedI18nUtilInstance.setPref(getContext(), "RCTI18nUtil_forceRTL", z);
    }

    public Map<String, Object> getConstants() {
        Context context = getContext();
        Locale locale = context.getResources().getConfiguration().locale;
        HashMap hashMap = new HashMap();
        hashMap.put("isRTL", Boolean.valueOf(this.sharedI18nUtilInstance.isRTL(context)));
        hashMap.put("doLeftAndRightSwapInRTL", Boolean.valueOf(this.sharedI18nUtilInstance.doLeftAndRightSwapInRTL(context)));
        hashMap.put("localeIdentifier", locale.toString());
        return hashMap;
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void swapLeftAndRightInRTL(boolean z) {
        this.sharedI18nUtilInstance.setPref(getContext(), "RCTI18nUtil_makeRTLFlipLeftAndRightStyles", z);
    }
}
