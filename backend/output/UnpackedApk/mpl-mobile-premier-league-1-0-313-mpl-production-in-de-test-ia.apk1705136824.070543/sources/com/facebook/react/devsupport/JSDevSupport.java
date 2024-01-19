package com.facebook.react.devsupport;

import android.view.View;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeJSDevSupportSpec;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture.CaptureException;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "JSDevSupport")
public class JSDevSupport extends NativeJSDevSupportSpec {
    public static final int ERROR_CODE_EXCEPTION = 0;
    public static final int ERROR_CODE_VIEW_NOT_FOUND = 1;
    public static final String MODULE_NAME = "JSDevSupport";
    public volatile DevSupportCallback mCurrentCallback = null;

    public interface DevSupportCallback {
        void onFailure(int i, Exception exc);

        void onSuccess(String str);
    }

    public interface JSDevSupportModule extends JavaScriptModule {
        void getJSHierarchy(int i);
    }

    public JSDevSupport(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public synchronized void computeDeepestJSHierarchy(View view, DevSupportCallback devSupportCallback) {
        getJSHierarchy(Integer.valueOf(((View) ImageOriginUtils.getDeepestLeaf(view).first).getId()).intValue(), devSupportCallback);
    }

    public synchronized void getJSHierarchy(int i, DevSupportCallback devSupportCallback) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        JSDevSupportModule jSDevSupportModule = null;
        if (reactApplicationContextIfActiveOrWarn != null) {
            jSDevSupportModule = (JSDevSupportModule) reactApplicationContextIfActiveOrWarn.getJSModule(JSDevSupportModule.class);
        }
        if (jSDevSupportModule == null) {
            devSupportCallback.onFailure(0, new CaptureException("JSDevSupport module not registered."));
            return;
        }
        this.mCurrentCallback = devSupportCallback;
        jSDevSupportModule.getJSHierarchy(i);
    }

    public String getName() {
        return MODULE_NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("ERROR_CODE_EXCEPTION", Integer.valueOf(0));
        hashMap.put("ERROR_CODE_VIEW_NOT_FOUND", Integer.valueOf(1));
        return hashMap;
    }

    public synchronized void onFailure(double d2, String str) {
        int i = (int) d2;
        if (this.mCurrentCallback != null) {
            this.mCurrentCallback.onFailure(i, new RuntimeException(str));
        }
    }

    public synchronized void onSuccess(String str) {
        if (this.mCurrentCallback != null) {
            this.mCurrentCallback.onSuccess(str);
        }
    }
}
