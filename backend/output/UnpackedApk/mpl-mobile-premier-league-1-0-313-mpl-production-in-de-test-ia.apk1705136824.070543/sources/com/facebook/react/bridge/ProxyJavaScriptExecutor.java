package com.facebook.react.bridge;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class ProxyJavaScriptExecutor extends JavaScriptExecutor {
    public JavaJSExecutor mJavaJSExecutor;

    public static class Factory implements JavaScriptExecutorFactory {
        public final com.facebook.react.bridge.JavaJSExecutor.Factory mJavaJSExecutorFactory;

        public Factory(com.facebook.react.bridge.JavaJSExecutor.Factory factory) {
            this.mJavaJSExecutorFactory = factory;
        }

        public JavaScriptExecutor create() throws Exception {
            return new ProxyJavaScriptExecutor(this.mJavaJSExecutorFactory.create());
        }

        public void startSamplingProfiler() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Starting sampling profiler not supported on ");
            outline73.append(toString());
            throw new UnsupportedOperationException(outline73.toString());
        }

        public void stopSamplingProfiler(String str) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Stopping sampling profiler not supported on ");
            outline73.append(toString());
            throw new UnsupportedOperationException(outline73.toString());
        }
    }

    static {
        ReactBridge.staticInit();
    }

    public ProxyJavaScriptExecutor(JavaJSExecutor javaJSExecutor) {
        super(initHybrid(javaJSExecutor));
        this.mJavaJSExecutor = javaJSExecutor;
    }

    public static native HybridData initHybrid(JavaJSExecutor javaJSExecutor);

    public void close() {
        JavaJSExecutor javaJSExecutor = this.mJavaJSExecutor;
        if (javaJSExecutor != null) {
            javaJSExecutor.close();
            this.mJavaJSExecutor = null;
        }
    }

    public String getName() {
        return "ProxyJavaScriptExecutor";
    }
}
