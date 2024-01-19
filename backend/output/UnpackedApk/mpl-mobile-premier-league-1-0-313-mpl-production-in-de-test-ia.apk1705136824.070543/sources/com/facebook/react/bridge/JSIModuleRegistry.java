package com.facebook.react.bridge;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JSIModuleRegistry {
    public final Map<JSIModuleType, JSIModuleHolder> mModules = new HashMap();

    public JSIModule getModule(JSIModuleType jSIModuleType) {
        JSIModuleHolder jSIModuleHolder = this.mModules.get(jSIModuleType);
        if (jSIModuleHolder != null) {
            JSIModule jSIModule = jSIModuleHolder.getJSIModule();
            ImageOriginUtils.assertNotNull(jSIModule);
            return jSIModule;
        }
        throw new IllegalArgumentException("Unable to find JSIModule for class " + jSIModuleType);
    }

    public void notifyJSInstanceDestroy() {
        for (Entry next : this.mModules.entrySet()) {
            if (((JSIModuleType) next.getKey()) != JSIModuleType.TurboModuleManager) {
                ((JSIModuleHolder) next.getValue()).notifyJSInstanceDestroy();
            }
        }
    }

    public void registerModules(List<JSIModuleSpec> list) {
        for (JSIModuleSpec next : list) {
            this.mModules.put(next.getJSIModuleType(), new JSIModuleHolder(next));
        }
    }
}
