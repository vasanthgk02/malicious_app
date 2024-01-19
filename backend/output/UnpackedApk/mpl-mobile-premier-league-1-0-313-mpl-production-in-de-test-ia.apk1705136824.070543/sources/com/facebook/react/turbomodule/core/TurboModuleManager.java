package com.facebook.react.turbomodule.core;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TurboModuleManager implements JSIModule, TurboModuleRegistry {
    public static volatile boolean sIsSoLibraryLoaded;
    public final TurboModuleProvider mCxxModuleProvider;
    public final List<String> mEagerInitModuleNames;
    @DoNotStrip
    public final HybridData mHybridData;
    public final TurboModuleProvider mJavaModuleProvider;
    public final Object mTurboModuleCleanupLock = new Object();
    public boolean mTurboModuleCleanupStarted = false;
    public final Map<String, TurboModuleHolder> mTurboModuleHolders = new HashMap();

    public static class TurboModuleHolder {
        public volatile boolean mIsDoneCreatingModule;
        public volatile boolean mIsTryingToCreate;
        public volatile TurboModule mModule;

        public TurboModuleHolder() {
            this.mModule = null;
            this.mIsTryingToCreate = false;
            this.mIsDoneCreatingModule = false;
        }

        public void endCreatingModule() {
            this.mIsTryingToCreate = false;
            this.mIsDoneCreatingModule = true;
        }

        public TurboModule getModule() {
            return this.mModule;
        }

        public boolean isCreatingModule() {
            return this.mIsTryingToCreate;
        }

        public boolean isDoneCreatingModule() {
            return this.mIsDoneCreatingModule;
        }

        public void setModule(TurboModule turboModule) {
            this.mModule = turboModule;
        }

        public void startCreatingModule() {
            this.mIsTryingToCreate = true;
        }
    }

    public interface TurboModuleProvider {
        TurboModule getModule(String str);
    }

    public TurboModuleManager(JavaScriptContextHolder javaScriptContextHolder, final TurboModuleManagerDelegate turboModuleManagerDelegate, CallInvokerHolder callInvokerHolder, CallInvokerHolder callInvokerHolder2) {
        List<String> list;
        maybeLoadSoLibrary();
        this.mHybridData = initHybrid(javaScriptContextHolder.get(), (CallInvokerHolderImpl) callInvokerHolder, (CallInvokerHolderImpl) callInvokerHolder2, turboModuleManagerDelegate);
        installJSIBindings();
        if (turboModuleManagerDelegate == null) {
            list = new ArrayList<>();
        } else {
            list = turboModuleManagerDelegate.getEagerInitModuleNames();
        }
        this.mEagerInitModuleNames = list;
        this.mJavaModuleProvider = new TurboModuleProvider() {
            public TurboModule getModule(String str) {
                TurboModuleManagerDelegate turboModuleManagerDelegate = turboModuleManagerDelegate;
                if (turboModuleManagerDelegate == null) {
                    return null;
                }
                return turboModuleManagerDelegate.getModule(str);
            }
        };
        this.mCxxModuleProvider = new TurboModuleProvider() {
            public TurboModule getModule(String str) {
                TurboModuleManagerDelegate turboModuleManagerDelegate = turboModuleManagerDelegate;
                if (turboModuleManagerDelegate == null) {
                    return null;
                }
                CxxModuleWrapper legacyCxxModule = turboModuleManagerDelegate.getLegacyCxxModule(str);
                if (legacyCxxModule == null) {
                    return null;
                }
                ImageOriginUtils.assertCondition(legacyCxxModule instanceof TurboModule, "CxxModuleWrapper \"" + str + "\" is not a TurboModule");
                return (TurboModule) legacyCxxModule;
            }
        };
    }

    @DoNotStrip
    private TurboModule getJavaModule(String str) {
        TurboModule module = getModule(str);
        if (module instanceof CxxModuleWrapper) {
            return null;
        }
        return module;
    }

    @DoNotStrip
    private CxxModuleWrapper getLegacyCxxModule(String str) {
        TurboModule module = getModule(str);
        if (!(module instanceof CxxModuleWrapper)) {
            return null;
        }
        return (CxxModuleWrapper) module;
    }

    private TurboModuleHolder getOrMaybeCreateTurboModuleHolder(String str) {
        synchronized (this.mTurboModuleCleanupLock) {
            if (this.mTurboModuleCleanupStarted) {
                return null;
            }
            if (!this.mTurboModuleHolders.containsKey(str)) {
                this.mTurboModuleHolders.put(str, new TurboModuleHolder());
            }
            TurboModuleHolder turboModuleHolder = this.mTurboModuleHolders.get(str);
            return turboModuleHolder;
        }
    }

    private native HybridData initHybrid(long j, CallInvokerHolderImpl callInvokerHolderImpl, CallInvokerHolderImpl callInvokerHolderImpl2, TurboModuleManagerDelegate turboModuleManagerDelegate);

    private native void installJSIBindings();

    public static synchronized void maybeLoadSoLibrary() {
        synchronized (TurboModuleManager.class) {
            if (!sIsSoLibraryLoaded) {
                SoLoader.loadLibrary("turbomodulejsijni");
                sIsSoLibraryLoaded = true;
            }
        }
    }

    public List<String> getEagerInitModuleNames() {
        return this.mEagerInitModuleNames;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        if (r1 == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        r1 = r4.mJavaModuleProvider.getModule(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (r1 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r1 = r4.mCxxModuleProvider.getModule(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r1 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.setModule(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        ((com.facebook.react.bridge.NativeModule) r1).initialize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r0.endCreatingModule();
        r0.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004c, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0051, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0056, code lost:
        if (r0.isCreatingModule() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r0.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x005c, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x005e, code lost:
        if (r3 == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0067, code lost:
        r5 = r0.getModule();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006b, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006c, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.turbomodule.core.interfaces.TurboModule getModule(java.lang.String r5) {
        /*
            r4 = this;
            com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder r0 = r4.getOrMaybeCreateTurboModuleHolder(r5)
            if (r0 != 0) goto L_0x0008
            r5 = 0
            return r5
        L_0x0008:
            monitor-enter(r0)
            boolean r1 = r0.isDoneCreatingModule()     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0015
            com.facebook.react.turbomodule.core.interfaces.TurboModule r5 = r0.getModule()     // Catch:{ all -> 0x0070 }
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            return r5
        L_0x0015:
            boolean r1 = r0.isCreatingModule()     // Catch:{ all -> 0x0070 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0022
            r0.startCreatingModule()     // Catch:{ all -> 0x0070 }
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0051
            com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleProvider r1 = r4.mJavaModuleProvider
            com.facebook.react.turbomodule.core.interfaces.TurboModule r1 = r1.getModule(r5)
            if (r1 != 0) goto L_0x0034
            com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleProvider r1 = r4.mCxxModuleProvider
            com.facebook.react.turbomodule.core.interfaces.TurboModule r1 = r1.getModule(r5)
        L_0x0034:
            if (r1 == 0) goto L_0x0045
            monitor-enter(r0)
            r0.setModule(r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            r5 = r1
            com.facebook.react.bridge.NativeModule r5 = (com.facebook.react.bridge.NativeModule) r5
            r5.initialize()
            goto L_0x0045
        L_0x0042:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r5
        L_0x0045:
            monitor-enter(r0)
            r0.endCreatingModule()     // Catch:{ all -> 0x004e }
            r0.notifyAll()     // Catch:{ all -> 0x004e }
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r1
        L_0x004e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r5
        L_0x0051:
            monitor-enter(r0)
        L_0x0052:
            boolean r5 = r0.isCreatingModule()     // Catch:{ all -> 0x006d }
            if (r5 == 0) goto L_0x005e
            r0.wait()     // Catch:{ InterruptedException -> 0x005c }
            goto L_0x0052
        L_0x005c:
            r3 = 1
            goto L_0x0052
        L_0x005e:
            if (r3 == 0) goto L_0x0067
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x006d }
            r5.interrupt()     // Catch:{ all -> 0x006d }
        L_0x0067:
            com.facebook.react.turbomodule.core.interfaces.TurboModule r5 = r0.getModule()     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r5
        L_0x006d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r5
        L_0x0070:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.turbomodule.core.TurboModuleManager.getModule(java.lang.String):com.facebook.react.turbomodule.core.interfaces.TurboModule");
    }

    public Collection<TurboModule> getModules() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mTurboModuleCleanupLock) {
            arrayList.addAll(this.mTurboModuleHolders.values());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TurboModuleHolder turboModuleHolder = (TurboModuleHolder) it.next();
            synchronized (turboModuleHolder) {
                if (turboModuleHolder.getModule() != null) {
                    arrayList2.add(turboModuleHolder.getModule());
                }
            }
        }
        return arrayList2;
    }

    public boolean hasModule(String str) {
        TurboModuleHolder turboModuleHolder;
        synchronized (this.mTurboModuleCleanupLock) {
            turboModuleHolder = this.mTurboModuleHolders.get(str);
        }
        if (turboModuleHolder != null) {
            synchronized (turboModuleHolder) {
                if (turboModuleHolder.getModule() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void initialize() {
    }

    public void onCatalystInstanceDestroy() {
        synchronized (this.mTurboModuleCleanupLock) {
            this.mTurboModuleCleanupStarted = true;
        }
        Iterator it = new HashSet(this.mTurboModuleHolders.keySet()).iterator();
        while (it.hasNext()) {
            TurboModule module = getModule((String) it.next());
            if (module != null) {
                ((NativeModule) module).onCatalystInstanceDestroy();
            }
        }
        this.mTurboModuleHolders.clear();
        this.mHybridData.resetNative();
    }
}
