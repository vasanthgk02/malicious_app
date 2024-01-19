package com.facebook.react;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import com.facebook.systrace.SystraceMessage.NoopBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class LazyReactPackage implements ReactPackage {
    public static ReactModuleInfoProvider getReactModuleInfoProviderViaReflection(LazyReactPackage lazyReactPackage) {
        try {
            try {
                return (ReactModuleInfoProvider) Class.forName(lazyReactPackage.getClass().getCanonicalName() + "$$ReactModuleInfoProvider").newInstance();
            } catch (InstantiationException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to instantiate ReactModuleInfoProvider for ");
                outline73.append(lazyReactPackage.getClass());
                throw new RuntimeException(outline73.toString(), e2);
            } catch (IllegalAccessException e3) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Unable to instantiate ReactModuleInfoProvider for ");
                outline732.append(lazyReactPackage.getClass());
                throw new RuntimeException(outline732.toString(), e3);
            }
        } catch (ClassNotFoundException unused) {
            return new ReactModuleInfoProvider() {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return Collections.emptyMap();
                }
            };
        }
    }

    /* JADX INFO: finally extract failed */
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        for (ModuleSpec next : getNativeModules(reactApplicationContext)) {
            Builder builder = SystraceMessage.NOOP_BUILDER;
            next.getType();
            NoopBuilder noopBuilder = (NoopBuilder) builder;
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, next.getName());
            try {
                NativeModule nativeModule = (NativeModule) next.getProvider().get();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                arrayList.add(nativeModule);
            } catch (Throwable th) {
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                throw th;
            }
        }
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ModuleSpec> viewManagers = getViewManagers(reactApplicationContext);
        if (viewManagers == null || viewManagers.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ModuleSpec provider : viewManagers) {
            arrayList.add((ViewManager) provider.getProvider().get());
        }
        return arrayList;
    }

    public Iterable<ModuleHolder> getNativeModuleIterator(ReactApplicationContext reactApplicationContext) {
        final Map<String, ReactModuleInfo> reactModuleInfos = getReactModuleInfoProvider().getReactModuleInfos();
        final List<ModuleSpec> nativeModules = getNativeModules(reactApplicationContext);
        return new Iterable<ModuleHolder>(this) {
            public Iterator<ModuleHolder> iterator() {
                return new Iterator<ModuleHolder>() {
                    public int position = 0;

                    public boolean hasNext() {
                        return this.position < nativeModules.size();
                    }

                    /* JADX INFO: finally extract failed */
                    public Object next() {
                        List list = nativeModules;
                        int i = this.position;
                        this.position = i + 1;
                        ModuleSpec moduleSpec = (ModuleSpec) list.get(i);
                        String name = moduleSpec.getName();
                        ReactModuleInfo reactModuleInfo = (ReactModuleInfo) reactModuleInfos.get(name);
                        if (reactModuleInfo != null) {
                            return new ModuleHolder(reactModuleInfo, moduleSpec.getProvider());
                        }
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, name);
                        try {
                            NativeModule nativeModule = (NativeModule) moduleSpec.getProvider().get();
                            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                            return new ModuleHolder(nativeModule);
                        } catch (Throwable th) {
                            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                            throw th;
                        }
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("Cannot remove native modules from the list");
                    }
                };
            }
        };
    }

    public abstract List<ModuleSpec> getNativeModules(ReactApplicationContext reactApplicationContext);

    public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

    public List<ModuleSpec> getViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
