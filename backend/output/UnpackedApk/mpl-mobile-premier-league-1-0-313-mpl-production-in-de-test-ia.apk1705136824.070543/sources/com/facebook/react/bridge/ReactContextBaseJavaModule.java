package com.facebook.react.bridge;

import android.app.Activity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    public final ReactApplicationContext mReactApplicationContext;

    public ReactContextBaseJavaModule() {
        this.mReactApplicationContext = null;
    }

    public final Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }

    public final ReactApplicationContext getReactApplicationContext() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        ImageOriginUtils.assertNotNull(reactApplicationContext, "Tried to get ReactApplicationContext even though NativeModule wasn't instantiated with one");
        return reactApplicationContext;
    }

    public final ReactApplicationContext getReactApplicationContextIfActiveOrWarn() {
        if (this.mReactApplicationContext.hasActiveCatalystInstance() || this.mReactApplicationContext.isBridgeless()) {
            return this.mReactApplicationContext;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Catalyst Instance has already disappeared: requested by ");
        outline73.append(getName());
        ReactSoftException.logSoftException("ReactContextBaseJavaModule", new RuntimeException(outline73.toString()));
        return null;
    }

    public ReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }
}
