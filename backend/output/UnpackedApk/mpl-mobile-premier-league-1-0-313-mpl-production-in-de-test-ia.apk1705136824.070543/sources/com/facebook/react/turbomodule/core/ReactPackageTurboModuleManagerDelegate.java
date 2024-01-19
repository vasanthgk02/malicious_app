package com.facebook.react.turbomodule.core;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.ReactPackage;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ReactPackageTurboModuleManagerDelegate extends TurboModuleManagerDelegate {
    public final Map<String, TurboModule> mModules = new HashMap();
    public final List<TurboReactPackage> mPackages = new ArrayList();
    public final ReactApplicationContext mReactApplicationContext;

    public static abstract class Builder {
        public ReactApplicationContext mContext;
        public List<ReactPackage> mPackages;

        public ReactPackageTurboModuleManagerDelegate build() {
            ImageOriginUtils.assertNotNull(this.mContext, "The ReactApplicationContext must be provided to create ReactPackageTurboModuleManagerDelegate");
            ImageOriginUtils.assertNotNull(this.mPackages, "A set of ReactPackages must be provided to create ReactPackageTurboModuleManagerDelegate");
            return build(this.mContext, this.mPackages);
        }

        public abstract ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<ReactPackage> list);

        public Builder setPackages(List<ReactPackage> list) {
            this.mPackages = new ArrayList(list);
            return this;
        }

        public Builder setReactApplicationContext(ReactApplicationContext reactApplicationContext) {
            this.mContext = reactApplicationContext;
            return this;
        }
    }

    public ReactPackageTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
        this.mReactApplicationContext = reactApplicationContext;
        for (ReactPackage next : list) {
            if (next instanceof TurboReactPackage) {
                this.mPackages.add((TurboReactPackage) next);
            }
        }
    }

    private TurboModule resolveModule(String str) {
        if (this.mModules.containsKey(str)) {
            return this.mModules.get(str);
        }
        NativeModule nativeModule = null;
        for (TurboReactPackage module : this.mPackages) {
            try {
                NativeModule module2 = module.getModule(str, this.mReactApplicationContext);
                if (nativeModule == null || (module2 != null && module2.canOverrideExistingModule())) {
                    nativeModule = module2;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (nativeModule instanceof TurboModule) {
            this.mModules.put(str, (TurboModule) nativeModule);
        } else {
            this.mModules.put(str, null);
        }
        return this.mModules.get(str);
    }

    public List<String> getEagerInitModuleNames() {
        ArrayList arrayList = new ArrayList();
        for (TurboReactPackage reactModuleInfoProvider : this.mPackages) {
            for (ReactModuleInfo next : reactModuleInfoProvider.getReactModuleInfoProvider().getReactModuleInfos().values()) {
                if (next.mIsTurboModule && next.mNeedsEagerInit) {
                    arrayList.add(next.mName);
                }
            }
        }
        return arrayList;
    }

    @DoNotStrip
    public CxxModuleWrapper getLegacyCxxModule(String str) {
        TurboModule resolveModule = resolveModule(str);
        if (resolveModule != null && (resolveModule instanceof CxxModuleWrapper)) {
            return (CxxModuleWrapper) resolveModule;
        }
        return null;
    }

    public TurboModule getModule(String str) {
        TurboModule resolveModule = resolveModule(str);
        if (resolveModule != null && !(resolveModule instanceof CxxModuleWrapper)) {
            return resolveModule;
        }
        return null;
    }
}
