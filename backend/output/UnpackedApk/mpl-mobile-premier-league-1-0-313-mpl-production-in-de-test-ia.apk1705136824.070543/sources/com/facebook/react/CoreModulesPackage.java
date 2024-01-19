package com.facebook.react;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.TimingModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.HashMap;
import java.util.Map;

public class CoreModulesPackage extends TurboReactPackage implements ReactPackageLogger {
    public final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
    public final boolean mLazyViewManagersEnabled;
    public final int mMinTimeLeftInFrameForNonBatchedOperationMs;
    public final ReactInstanceManager mReactInstanceManager;

    public CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, boolean z, int i) {
        this.mReactInstanceManager = reactInstanceManager;
        this.mHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        this.mLazyViewManagersEnabled = z;
        this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
    }

    public void endProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule(java.lang.String r3, com.facebook.react.bridge.ReactApplicationContext r4) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -2013505529: goto L_0x0065;
                case -1789797270: goto L_0x005b;
                case -1633589448: goto L_0x0051;
                case -1520650172: goto L_0x0046;
                case -1037217463: goto L_0x003c;
                case -790603268: goto L_0x0032;
                case 512434409: goto L_0x0028;
                case 881516744: goto L_0x001e;
                case 1256514152: goto L_0x0014;
                case 1861242489: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x006f
        L_0x0009:
            java.lang.String r0 = "UIManager"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 8
            goto L_0x0070
        L_0x0014:
            java.lang.String r0 = "HeadlessJsTaskSupport"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 5
            goto L_0x0070
        L_0x001e:
            java.lang.String r0 = "SourceCode"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 6
            goto L_0x0070
        L_0x0028:
            java.lang.String r0 = "ExceptionsManager"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 3
            goto L_0x0070
        L_0x0032:
            java.lang.String r0 = "PlatformConstants"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 0
            goto L_0x0070
        L_0x003c:
            java.lang.String r0 = "DeviceEventManager"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 1
            goto L_0x0070
        L_0x0046:
            java.lang.String r0 = "DeviceInfo"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 9
            goto L_0x0070
        L_0x0051:
            java.lang.String r0 = "DevSettings"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 2
            goto L_0x0070
        L_0x005b:
            java.lang.String r0 = "Timing"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 7
            goto L_0x0070
        L_0x0065:
            java.lang.String r0 = "LogBox"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006f
            r0 = 4
            goto L_0x0070
        L_0x006f:
            r0 = -1
        L_0x0070:
            switch(r0) {
                case 0: goto L_0x00fc;
                case 1: goto L_0x00f4;
                case 2: goto L_0x00ea;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00d6;
                case 5: goto L_0x00d0;
                case 6: goto L_0x00ca;
                case 7: goto L_0x00c0;
                case 8: goto L_0x0085;
                case 9: goto L_0x007f;
                default: goto L_0x0073;
            }
        L_0x0073:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "In CoreModulesPackage, could not find Native module for "
            java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r0, r3)
            r4.<init>(r3)
            throw r4
        L_0x007f:
            com.facebook.react.modules.deviceinfo.DeviceInfoModule r3 = new com.facebook.react.modules.deviceinfo.DeviceInfoModule
            r3.<init>(r4)
            return r3
        L_0x0085:
            com.facebook.react.bridge.ReactMarkerConstants r3 = com.facebook.react.bridge.ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START
            com.facebook.react.bridge.ReactMarker.logMarker(r3)
            java.lang.String r3 = "createUIManagerModule"
            android.os.Trace.beginSection(r3)
            boolean r3 = r2.mLazyViewManagersEnabled     // Catch:{ all -> 0x00b6 }
            if (r3 == 0) goto L_0x00a0
            com.facebook.react.CoreModulesPackage$2 r3 = new com.facebook.react.CoreModulesPackage$2     // Catch:{ all -> 0x00b6 }
            r3.<init>()     // Catch:{ all -> 0x00b6 }
            com.facebook.react.uimanager.UIManagerModule r0 = new com.facebook.react.uimanager.UIManagerModule     // Catch:{ all -> 0x00b6 }
            int r1 = r2.mMinTimeLeftInFrameForNonBatchedOperationMs     // Catch:{ all -> 0x00b6 }
            r0.<init>(r4, r3, r1)     // Catch:{ all -> 0x00b6 }
            goto L_0x00ad
        L_0x00a0:
            com.facebook.react.uimanager.UIManagerModule r0 = new com.facebook.react.uimanager.UIManagerModule     // Catch:{ all -> 0x00b6 }
            com.facebook.react.ReactInstanceManager r3 = r2.mReactInstanceManager     // Catch:{ all -> 0x00b6 }
            java.util.List r3 = r3.getOrCreateViewManagers(r4)     // Catch:{ all -> 0x00b6 }
            int r1 = r2.mMinTimeLeftInFrameForNonBatchedOperationMs     // Catch:{ all -> 0x00b6 }
            r0.<init>(r4, r3, r1)     // Catch:{ all -> 0x00b6 }
        L_0x00ad:
            android.os.Trace.endSection()
            com.facebook.react.bridge.ReactMarkerConstants r3 = com.facebook.react.bridge.ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END
            com.facebook.react.bridge.ReactMarker.logMarker(r3)
            return r0
        L_0x00b6:
            r3 = move-exception
            android.os.Trace.endSection()
            com.facebook.react.bridge.ReactMarkerConstants r4 = com.facebook.react.bridge.ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END
            com.facebook.react.bridge.ReactMarker.logMarker(r4)
            throw r3
        L_0x00c0:
            com.facebook.react.modules.core.TimingModule r3 = new com.facebook.react.modules.core.TimingModule
            com.facebook.react.ReactInstanceManager r0 = r2.mReactInstanceManager
            com.facebook.react.devsupport.interfaces.DevSupportManager r0 = r0.mDevSupportManager
            r3.<init>(r4, r0)
            return r3
        L_0x00ca:
            com.facebook.react.modules.debug.SourceCodeModule r3 = new com.facebook.react.modules.debug.SourceCodeModule
            r3.<init>(r4)
            return r3
        L_0x00d0:
            com.facebook.react.modules.core.HeadlessJsTaskSupportModule r3 = new com.facebook.react.modules.core.HeadlessJsTaskSupportModule
            r3.<init>(r4)
            return r3
        L_0x00d6:
            com.facebook.react.devsupport.LogBoxModule r3 = new com.facebook.react.devsupport.LogBoxModule
            com.facebook.react.ReactInstanceManager r0 = r2.mReactInstanceManager
            com.facebook.react.devsupport.interfaces.DevSupportManager r0 = r0.mDevSupportManager
            r3.<init>(r4, r0)
            return r3
        L_0x00e0:
            com.facebook.react.modules.core.ExceptionsManagerModule r3 = new com.facebook.react.modules.core.ExceptionsManagerModule
            com.facebook.react.ReactInstanceManager r4 = r2.mReactInstanceManager
            com.facebook.react.devsupport.interfaces.DevSupportManager r4 = r4.mDevSupportManager
            r3.<init>(r4)
            return r3
        L_0x00ea:
            com.facebook.react.modules.debug.DevSettingsModule r3 = new com.facebook.react.modules.debug.DevSettingsModule
            com.facebook.react.ReactInstanceManager r0 = r2.mReactInstanceManager
            com.facebook.react.devsupport.interfaces.DevSupportManager r0 = r0.mDevSupportManager
            r3.<init>(r4, r0)
            return r3
        L_0x00f4:
            com.facebook.react.modules.core.DeviceEventManagerModule r3 = new com.facebook.react.modules.core.DeviceEventManagerModule
            com.facebook.react.modules.core.DefaultHardwareBackBtnHandler r0 = r2.mHardwareBackBtnHandler
            r3.<init>(r4, r0)
            return r3
        L_0x00fc:
            com.facebook.react.modules.systeminfo.AndroidInfoModule r3 = new com.facebook.react.modules.systeminfo.AndroidInfoModule
            r3.<init>(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.CoreModulesPackage.getModule(java.lang.String, com.facebook.react.bridge.ReactApplicationContext):com.facebook.react.bridge.NativeModule");
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, LogBoxModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, TimingModule.class, UIManagerModule.class};
            final HashMap hashMap = new HashMap();
            for (int i = 0; i < 10; i++) {
                Class cls = clsArr[i];
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                String name = reactModule.name();
                ReactModuleInfo reactModuleInfo = new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls));
                hashMap.put(name, reactModuleInfo);
            }
            return new ReactModuleInfoProvider(this) {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e3);
        }
    }

    public void startProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }
}
