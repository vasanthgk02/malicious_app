package com.facebook.react.bridge;

public class JSIModuleHolder {
    public JSIModule mModule;
    public final JSIModuleSpec mSpec;

    public JSIModuleHolder(JSIModuleSpec jSIModuleSpec) {
        this.mSpec = jSIModuleSpec;
    }

    public JSIModule getJSIModule() {
        if (this.mModule == null) {
            synchronized (this) {
                try {
                    if (this.mModule != null) {
                        JSIModule jSIModule = this.mModule;
                        return jSIModule;
                    }
                    JSIModule jSIModule2 = this.mSpec.getJSIModuleProvider().get();
                    this.mModule = jSIModule2;
                    jSIModule2.initialize();
                }
            }
        }
        return this.mModule;
    }

    public void notifyJSInstanceDestroy() {
        JSIModule jSIModule = this.mModule;
        if (jSIModule != null) {
            jSIModule.onCatalystInstanceDestroy();
        }
    }
}
