package com.facebook.react.bridge;

import android.os.Trace;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeModule.NativeMethod;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.NoopBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@DoNotStrip
public class JavaModuleWrapper {
    public final ArrayList<MethodDescriptor> mDescs = new ArrayList<>();
    public final JSInstance mJSInstance;
    public final ArrayList<NativeMethod> mMethods = new ArrayList<>();
    public final ModuleHolder mModuleHolder;

    @DoNotStrip
    public class MethodDescriptor {
        @DoNotStrip
        public Method method;
        @DoNotStrip
        public String name;
        @DoNotStrip
        public String signature;
        @DoNotStrip
        public String type;

        public MethodDescriptor() {
        }
    }

    public JavaModuleWrapper(JSInstance jSInstance, ModuleHolder moduleHolder) {
        this.mJSInstance = jSInstance;
        this.mModuleHolder = moduleHolder;
    }

    @DoNotStrip
    private void findMethods() {
        Trace.beginSection("findMethods");
        HashSet hashSet = new HashSet();
        Class cls = this.mModuleHolder.getModule().getClass();
        Class superclass = cls.getSuperclass();
        if (ReactModuleWithSpec.class.isAssignableFrom(superclass)) {
            cls = superclass;
        }
        for (Method method : cls.getDeclaredMethods()) {
            ReactMethod reactMethod = (ReactMethod) method.getAnnotation(ReactMethod.class);
            if (reactMethod != null) {
                String name = method.getName();
                if (!hashSet.contains(name)) {
                    MethodDescriptor methodDescriptor = new MethodDescriptor();
                    JavaMethodWrapper javaMethodWrapper = new JavaMethodWrapper(this, method, reactMethod.isBlockingSynchronousMethod());
                    methodDescriptor.name = name;
                    String type = javaMethodWrapper.getType();
                    methodDescriptor.type = type;
                    if (type == BaseJavaModule.METHOD_TYPE_SYNC) {
                        methodDescriptor.signature = javaMethodWrapper.getSignature();
                        methodDescriptor.method = method;
                    }
                    this.mMethods.add(javaMethodWrapper);
                    this.mDescs.add(methodDescriptor);
                } else {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Java Module ");
                    outline73.append(getName());
                    outline73.append(" method name already registered: ");
                    outline73.append(name);
                    throw new IllegalArgumentException(outline73.toString());
                }
            }
        }
        Trace.endSection();
    }

    @DoNotStrip
    public NativeMap getConstants() {
        if (!this.mModuleHolder.getHasConstants()) {
            return null;
        }
        String name = getName();
        NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
        ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_START, name);
        BaseJavaModule module = getModule();
        Trace.beginSection("module.getConstants");
        Map<String, Object> constants = module.getConstants();
        Trace.endSection();
        Trace.beginSection("create WritableNativeMap");
        ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_START, name);
        try {
            return Arguments.makeNativeMap(constants);
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_END, name);
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_END, name);
        }
    }

    @DoNotStrip
    public List<MethodDescriptor> getMethodDescriptors() {
        if (this.mDescs.isEmpty()) {
            findMethods();
        }
        return this.mDescs;
    }

    @DoNotStrip
    public BaseJavaModule getModule() {
        return (BaseJavaModule) this.mModuleHolder.getModule();
    }

    @DoNotStrip
    public String getName() {
        return this.mModuleHolder.getName();
    }

    @DoNotStrip
    public void invoke(int i, ReadableNativeArray readableNativeArray) {
        ArrayList<NativeMethod> arrayList = this.mMethods;
        if (arrayList != null && i < arrayList.size()) {
            this.mMethods.get(i).invoke(this.mJSInstance, readableNativeArray);
        }
    }
}
