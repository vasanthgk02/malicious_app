package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.soloader.nativeloader.NativeLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SoLoader {
    public static final boolean SYSTRACE_LIBRARY_LOADING = true;
    public static boolean isSystemApp;
    public static ApplicationSoSource sApplicationSoSource;
    public static UnpackingSoSource[] sBackupSoSources;
    public static int sFlags;
    public static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    public static SoFileLoader sSoFileLoader;
    public static SoSource[] sSoSources = null;
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    public static volatile int sSoSourcesVersion = 0;
    public static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    @DoNotOptimize
    @TargetApi(14)
    public static class Api14Utils {
        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e2);
                }
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("ClassLoader ");
                outline73.append(classLoader.getClass().getName());
                outline73.append(" should be of type BaseDexClassLoader");
                throw new IllegalStateException(outline73.toString());
            }
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public WrongAbiError(Throwable th, String str) {
            // StringBuilder outline73 = GeneratedOutlineSupport.outline73("APK was built for a different platform. Supported ABIs: ");
            // outline73.append(Arrays.toString(ImageOriginUtils.getSupportedAbis()));
            // outline73.append(" error: ");
            // outline73.append(str);
            super(outline73.toString());
            initCause(th);
        }
    }

    public static void assertInitialized() {
        sSoSourcesLock.readLock().lock();
        try {
            if (!(sSoSources != null)) {
                throw new RuntimeException("SoLoader.init() not yet called");
            }
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r5 = sBackupSoSources;
        r6 = r5.length;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r7 >= r6) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r8 = r5[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r9 = r8.getLibraryLock(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r8.mCorruptedLib = r11;
        r8.prepare(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0061, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        r8 = r8.loadLibrary(r11, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0067, code lost:
        if (r8 != 1) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doLoadLibraryBySoName(java.lang.String r11, int r12, android.os.StrictMode.ThreadPolicy r13) throws java.lang.UnsatisfiedLinkError {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            com.facebook.soloader.SoSource[] r0 = sSoSources     // Catch:{ all -> 0x015d }
            if (r0 == 0) goto L_0x0146
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            r0 = 1
            r1 = 0
            if (r13 != 0) goto L_0x0020
            android.os.StrictMode$ThreadPolicy r13 = android.os.StrictMode.allowThreadDiskReads()
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            boolean r3 = SYSTRACE_LIBRARY_LOADING
            if (r3 == 0) goto L_0x002c
            java.lang.String r3 = "SoLoader.loadLibrary["
            java.lang.String r4 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r3, r11, r4)
        L_0x002c:
            r3 = 3
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = sSoSourcesLock     // Catch:{ all -> 0x0105 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r4.readLock()     // Catch:{ all -> 0x0105 }
            r4.lock()     // Catch:{ all -> 0x0105 }
            r4 = 0
            r5 = 0
        L_0x0038:
            if (r4 != 0) goto L_0x0083
            com.facebook.soloader.SoSource[] r6 = sSoSources     // Catch:{ all -> 0x0077 }
            int r6 = r6.length     // Catch:{ all -> 0x0077 }
            if (r5 >= r6) goto L_0x0083
            com.facebook.soloader.SoSource[] r6 = sSoSources     // Catch:{ all -> 0x0077 }
            r6 = r6[r5]     // Catch:{ all -> 0x0077 }
            int r4 = r6.loadLibrary(r11, r12, r13)     // Catch:{ all -> 0x0077 }
            if (r4 != r3) goto L_0x0074
            com.facebook.soloader.UnpackingSoSource[] r6 = sBackupSoSources     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x0074
            com.facebook.soloader.UnpackingSoSource[] r5 = sBackupSoSources     // Catch:{ all -> 0x0077 }
            int r6 = r5.length     // Catch:{ all -> 0x0077 }
            r7 = 0
        L_0x0051:
            if (r7 >= r6) goto L_0x0083
            r8 = r5[r7]     // Catch:{ all -> 0x0077 }
            monitor-enter(r8)     // Catch:{ all -> 0x0077 }
            java.lang.Object r9 = r8.getLibraryLock(r11)     // Catch:{ all -> 0x0071 }
            monitor-enter(r9)     // Catch:{ all -> 0x0071 }
            r8.mCorruptedLib = r11     // Catch:{ all -> 0x006e }
            r10 = 2
            r8.prepare(r10)     // Catch:{ all -> 0x006e }
            monitor-exit(r9)     // Catch:{ all -> 0x006e }
            monitor-exit(r8)     // Catch:{ all -> 0x0077 }
            int r8 = r8.loadLibrary(r11, r12, r13)     // Catch:{ all -> 0x0077 }
            if (r8 != r0) goto L_0x006b
            r4 = r8
            goto L_0x0083
        L_0x006b:
            int r7 = r7 + 1
            goto L_0x0051
        L_0x006e:
            r12 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x006e }
            throw r12     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r12 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0077 }
            throw r12     // Catch:{ all -> 0x0077 }
        L_0x0074:
            int r5 = r5 + 1
            goto L_0x0038
        L_0x0077:
            r12 = move-exception
            r1 = r4
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock     // Catch:{ all -> 0x0105 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()     // Catch:{ all -> 0x0105 }
            r0.unlock()     // Catch:{ all -> 0x0105 }
            throw r12     // Catch:{ all -> 0x0105 }
        L_0x0083:
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock     // Catch:{ all -> 0x0103 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()     // Catch:{ all -> 0x0103 }
            r12.unlock()     // Catch:{ all -> 0x0103 }
            boolean r12 = SYSTRACE_LIBRARY_LOADING
            if (r12 == 0) goto L_0x0093
            android.os.Trace.endSection()
        L_0x0093:
            if (r2 == 0) goto L_0x0098
            android.os.StrictMode.setThreadPolicy(r13)
        L_0x0098:
            if (r4 == 0) goto L_0x009c
            if (r4 != r3) goto L_0x0118
        L_0x009c:
            java.lang.String r12 = "couldn't find DSO to load: "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r12, r11)
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.lock()
        L_0x00ab:
            com.facebook.soloader.SoSource[] r12 = sSoSources
            int r12 = r12.length
            if (r1 >= r12) goto L_0x00cb
            java.lang.String r12 = "\n\tSoSource "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r12 = ": "
            r11.append(r12)
            com.facebook.soloader.SoSource[] r12 = sSoSources
            r12 = r12[r1]
            java.lang.String r12 = r12.toString()
            r11.append(r12)
            int r1 = r1 + 1
            goto L_0x00ab
        L_0x00cb:
            com.facebook.soloader.ApplicationSoSource r12 = sApplicationSoSource
            if (r12 == 0) goto L_0x00e8
            android.content.Context r12 = r12.getUpdatedContext()
            java.io.File r12 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r12)
            java.lang.String r13 = "\n\tNative lib dir: "
            r11.append(r13)
            java.lang.String r12 = r12.getAbsolutePath()
            r11.append(r12)
            java.lang.String r12 = "\n"
            r11.append(r12)
        L_0x00e8:
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.unlock()
            java.lang.String r12 = " result: "
            r11.append(r12)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            java.lang.UnsatisfiedLinkError r12 = new java.lang.UnsatisfiedLinkError
            r12.<init>(r11)
            throw r12
        L_0x0103:
            r12 = move-exception
            goto L_0x0107
        L_0x0105:
            r12 = move-exception
            r4 = r1
        L_0x0107:
            boolean r0 = SYSTRACE_LIBRARY_LOADING
            if (r0 == 0) goto L_0x010e
            android.os.Trace.endSection()
        L_0x010e:
            if (r2 == 0) goto L_0x0113
            android.os.StrictMode.setThreadPolicy(r13)
        L_0x0113:
            if (r4 == 0) goto L_0x0119
            if (r4 != r3) goto L_0x0118
            goto L_0x0119
        L_0x0118:
            return
        L_0x0119:
            java.lang.String r13 = "couldn't find DSO to load: "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r13, r11)
            java.lang.String r13 = r12.getMessage()
            if (r13 != 0) goto L_0x0129
            java.lang.String r13 = r12.toString()
        L_0x0129:
            java.lang.String r0 = " caused by: "
            r11.append(r0)
            r11.append(r13)
            r12.printStackTrace()
            java.lang.String r12 = " result: "
            r11.append(r12)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            java.lang.UnsatisfiedLinkError r12 = new java.lang.UnsatisfiedLinkError
            r12.<init>(r11)
            throw r12
        L_0x0146:
            java.lang.UnsatisfiedLinkError r12 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x015d }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x015d }
            r13.<init>()     // Catch:{ all -> 0x015d }
            java.lang.String r0 = "couldn't find DSO to load: "
            r13.append(r0)     // Catch:{ all -> 0x015d }
            r13.append(r11)     // Catch:{ all -> 0x015d }
            java.lang.String r11 = r13.toString()     // Catch:{ all -> 0x015d }
            r12.<init>(r11)     // Catch:{ all -> 0x015d }
            throw r12     // Catch:{ all -> 0x015d }
        L_0x015d:
            r11 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    public static void init(Context context, int i) throws IOException {
        ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        boolean z = false;
        if ((i & 32) == 0 && context != null) {
            try {
                if ((context.getApplicationInfo().flags & 129) != 0) {
                    z = true;
                }
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        }
        isSystemApp = z;
        initSoLoader(null);
        initSoSources(context, i);
        if (!NativeLoader.isInitialized()) {
            NativeLoader.init(new NativeLoaderToSoLoaderDelegate());
        }
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A[SYNTHETIC, Splitter:B:22:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void initSoLoader(com.facebook.soloader.SoFileLoader r11) {
        /*
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            monitor-enter(r0)
            if (r11 == 0) goto L_0x0009
            sSoFileLoader = r11     // Catch:{ all -> 0x0078 }
            monitor-exit(r0)
            return
        L_0x0009:
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0078 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0078 }
            r2 = 23
            r3 = 1
            r4 = 0
            r6 = 0
            if (r1 < r2) goto L_0x0035
            r2 = 27
            if (r1 <= r2) goto L_0x001d
            goto L_0x0035
        L_0x001d:
            java.lang.Class<java.lang.Runtime> r1 = java.lang.Runtime.class
            java.lang.String r2 = "nativeLoad"
            r7 = 3
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            r7[r4] = r11     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            java.lang.Class<java.lang.ClassLoader> r8 = java.lang.ClassLoader.class
            r7[r3] = r8     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            r8 = 2
            r7[r8] = r11     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            java.lang.reflect.Method r11 = r1.getDeclaredMethod(r2, r7)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            r11.setAccessible(r3)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            goto L_0x0036
        L_0x0035:
            r11 = r6
        L_0x0036:
            if (r11 == 0) goto L_0x003a
            r2 = 1
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            if (r2 == 0) goto L_0x0043
            java.lang.String r1 = com.facebook.soloader.SoLoader.Api14Utils.getClassLoaderLdLoadLibrary()     // Catch:{ all -> 0x0078 }
            r3 = r1
            goto L_0x0044
        L_0x0043:
            r3 = r6
        L_0x0044:
            if (r3 != 0) goto L_0x0048
            r4 = r6
            goto L_0x006d
        L_0x0048:
            java.lang.String r1 = ":"
            java.lang.String[] r6 = r3.split(r1)     // Catch:{ all -> 0x0078 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0078 }
            int r8 = r6.length     // Catch:{ all -> 0x0078 }
            r7.<init>(r8)     // Catch:{ all -> 0x0078 }
            int r8 = r6.length     // Catch:{ all -> 0x0078 }
        L_0x0055:
            if (r4 >= r8) goto L_0x0068
            r9 = r6[r4]     // Catch:{ all -> 0x0078 }
            java.lang.String r10 = "!"
            boolean r10 = r9.contains(r10)     // Catch:{ all -> 0x0078 }
            if (r10 == 0) goto L_0x0062
            goto L_0x0065
        L_0x0062:
            r7.add(r9)     // Catch:{ all -> 0x0078 }
        L_0x0065:
            int r4 = r4 + 1
            goto L_0x0055
        L_0x0068:
            java.lang.String r1 = android.text.TextUtils.join(r1, r7)     // Catch:{ all -> 0x0078 }
            r4 = r1
        L_0x006d:
            com.facebook.soloader.SoLoader$1 r7 = new com.facebook.soloader.SoLoader$1     // Catch:{ all -> 0x0078 }
            r1 = r7
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0078 }
            sSoFileLoader = r7     // Catch:{ all -> 0x0078 }
            monitor-exit(r0)
            return
        L_0x0078:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.initSoLoader(com.facebook.soloader.SoFileLoader):void");
    }

    public static void initSoSources(Context context, int i) throws IOException {
        int i2;
        boolean z;
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                int i3 = 0;
                if (str == null) {
                    if (VERSION.SDK_INT >= 23) {
                        z = SysUtil$MarshmallowSysdeps.is64Bit();
                    } else {
                        z = SysUtil$LollipopSysdeps.is64Bit();
                    }
                    str = z ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String file : str.split(":")) {
                    arrayList.add(new DirectorySoSource(new File(file), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        arrayList.add(0, new ExoSoSource(context, "lib-main"));
                    } else {
                        if (isSystemApp) {
                            i2 = 0;
                        } else {
                            ApplicationSoSource applicationSoSource = new ApplicationSoSource(context, 0);
                            sApplicationSoSource = applicationSoSource;
                            applicationSoSource.toString();
                            arrayList.add(0, sApplicationSoSource);
                            i2 = 1;
                        }
                        if ((sFlags & 8) != 0) {
                            sBackupSoSources = null;
                        } else {
                            File file2 = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context, file2, "lib-main", i2);
                            arrayList2.add(apkSoSource);
                            apkSoSource.toString();
                            if (context.getApplicationInfo().splitSourceDirs != null) {
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, new File(strArr[i4]), "lib-" + i5, i2);
                                    apkSoSource2.toString();
                                    arrayList2.add(apkSoSource2);
                                    i4++;
                                    i5++;
                                }
                            }
                            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                sSoSourcesLock.writeLock().lock();
                if ((sFlags & 2) != 0) {
                    i3 = 1;
                }
                sSoSourcesLock.writeLock().unlock();
                int length2 = soSourceArr.length;
                while (true) {
                    int i6 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    "Preparing SO source: " + soSourceArr[i6];
                    soSourceArr[i6].prepare(i3);
                    length2 = i6;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
                int length3 = sSoSources.length;
            }
        } catch (Exception e2) {
            String.format("Could not read /proc/self/exe. Err msg: %s", new Object[]{e2.getMessage()});
            z = false;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
        sSoSourcesLock.writeLock().unlock();
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r1 != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (sLoadedLibraries.contains(r6) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r8 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004e, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0050, code lost:
        if (r1 != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        doLoadLibraryBySoName(r6, r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        sLoadedLibraries.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005b, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x005f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0061, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0062, code lost:
        r7 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0066, code lost:
        if (r7 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007f, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r6, r7.substring(r7.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0080, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0086, code lost:
        if ((r9 & 16) != 0) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008c, code lost:
        if (android.text.TextUtils.isEmpty(r7) != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0094, code lost:
        if (sLoadedAndMergedLibraries.contains(r7) == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0096, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0097, code lost:
        if (r8 == null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0099, code lost:
        if (r2 != false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x009d, code lost:
        if (SYSTRACE_LIBRARY_LOADING == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x009f, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r7, org.apache.fontbox.cmap.CMapParser.MARK_END_OF_ARRAY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.invokeJniOnload(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00aa, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00ab, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00cf, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r7 + "', which has been merged into '" + r6 + "'.  See comment for details.", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00d0, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00d3, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00d5, code lost:
        android.os.Trace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00d8, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00d9, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00dc, code lost:
        return !r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean loadLibraryBySoNameImpl(java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, android.os.StrictMode.ThreadPolicy r10) {
        /*
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            r2 = 0
            if (r1 != 0) goto L_0x0012
            java.util.Set<java.lang.String> r1 = sLoadedAndMergedLibraries
            boolean r1 = r1.contains(r7)
            if (r1 == 0) goto L_0x0012
            return r2
        L_0x0012:
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r1 = sLoadedLibraries     // Catch:{ all -> 0x00e0 }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x00e0 }
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r8 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x00e0 }
            return r2
        L_0x0020:
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            java.util.Map<java.lang.String, java.lang.Object> r4 = sLoadingLibraries     // Catch:{ all -> 0x00e0 }
            boolean r4 = r4.containsKey(r6)     // Catch:{ all -> 0x00e0 }
            if (r4 == 0) goto L_0x0032
            java.util.Map<java.lang.String, java.lang.Object> r4 = sLoadingLibraries     // Catch:{ all -> 0x00e0 }
            java.lang.Object r4 = r4.get(r6)     // Catch:{ all -> 0x00e0 }
            goto L_0x003c
        L_0x0032:
            java.lang.Object r4 = new java.lang.Object     // Catch:{ all -> 0x00e0 }
            r4.<init>()     // Catch:{ all -> 0x00e0 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = sLoadingLibraries     // Catch:{ all -> 0x00e0 }
            r5.put(r6, r4)     // Catch:{ all -> 0x00e0 }
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x00e0 }
            monitor-enter(r4)
            if (r1 != 0) goto L_0x0084
            monitor-enter(r0)     // Catch:{ all -> 0x00dd }
            java.util.HashSet<java.lang.String> r5 = sLoadedLibraries     // Catch:{ all -> 0x0081 }
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x004f
            if (r8 != 0) goto L_0x004e
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            monitor-exit(r4)     // Catch:{ all -> 0x00dd }
            return r2
        L_0x004e:
            r1 = 1
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0084
            doLoadLibraryBySoName(r6, r9, r10)     // Catch:{ UnsatisfiedLinkError -> 0x0061 }
            monitor-enter(r0)     // Catch:{ all -> 0x00dd }
            java.util.HashSet<java.lang.String> r10 = sLoadedLibraries     // Catch:{ all -> 0x005f }
            r10.add(r6)     // Catch:{ all -> 0x005f }
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            goto L_0x0084
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            throw r6     // Catch:{ all -> 0x00dd }
        L_0x005f:
            r6 = move-exception
            goto L_0x005d
        L_0x0061:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()     // Catch:{ all -> 0x00dd }
            if (r7 == 0) goto L_0x0080
            java.lang.String r8 = "unexpected e_machine:"
            boolean r8 = r7.contains(r8)     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x0080
            java.lang.String r8 = "unexpected e_machine:"
            int r8 = r7.lastIndexOf(r8)     // Catch:{ all -> 0x00dd }
            java.lang.String r7 = r7.substring(r8)     // Catch:{ all -> 0x00dd }
            com.facebook.soloader.SoLoader$WrongAbiError r8 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x00dd }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x00dd }
            throw r8     // Catch:{ all -> 0x00dd }
        L_0x0080:
            throw r6     // Catch:{ all -> 0x00dd }
        L_0x0081:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            throw r6     // Catch:{ all -> 0x00dd }
        L_0x0084:
            r9 = r9 & 16
            if (r9 != 0) goto L_0x00d9
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00dd }
            if (r9 != 0) goto L_0x0097
            java.util.Set<java.lang.String> r9 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x00dd }
            boolean r9 = r9.contains(r7)     // Catch:{ all -> 0x00dd }
            if (r9 == 0) goto L_0x0097
            r2 = 1
        L_0x0097:
            if (r8 == 0) goto L_0x00d9
            if (r2 != 0) goto L_0x00d9
            boolean r8 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x00a6
            java.lang.String r8 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r9 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r8, r7, r9)     // Catch:{ all -> 0x00dd }
        L_0x00a6:
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.invokeJniOnload(r7)     // Catch:{ UnsatisfiedLinkError -> 0x00ab }
            r6 = 0
            throw r6
        L_0x00ab:
            r8 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ all -> 0x00d0 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r10.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r0 = "Failed to call JNI_OnLoad from '"
            r10.append(r0)     // Catch:{ all -> 0x00d0 }
            r10.append(r7)     // Catch:{ all -> 0x00d0 }
            java.lang.String r7 = "', which has been merged into '"
            r10.append(r7)     // Catch:{ all -> 0x00d0 }
            r10.append(r6)     // Catch:{ all -> 0x00d0 }
            java.lang.String r6 = "'.  See comment for details."
            r10.append(r6)     // Catch:{ all -> 0x00d0 }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x00d0 }
            r9.<init>(r6, r8)     // Catch:{ all -> 0x00d0 }
            throw r9     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r6 = move-exception
            boolean r7 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00dd }
            if (r7 == 0) goto L_0x00d8
            android.os.Trace.endSection()     // Catch:{ all -> 0x00dd }
        L_0x00d8:
            throw r6     // Catch:{ all -> 0x00dd }
        L_0x00d9:
            monitor-exit(r4)     // Catch:{ all -> 0x00dd }
            r6 = r1 ^ 1
            return r6
        L_0x00dd:
            r6 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00dd }
            throw r6
        L_0x00e0:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e0 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoNameImpl(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource unpackLibrary : sSoSources) {
                File unpackLibrary2 = unpackLibrary.unpackLibrary(str);
                if (unpackLibrary2 != null) {
                    return unpackLibrary2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        boolean z;
        boolean z2;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        z2 = !sLoadedLibraries.contains(str);
                        if (z2) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    sSoSourcesLock.readLock().unlock();
                    return z2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            if (isSystemApp) {
                SystemLoadLibraryWrapper systemLoadLibraryWrapper = sSystemLoadLibraryWrapper;
                if (systemLoadLibraryWrapper != null) {
                    systemLoadLibraryWrapper.loadLibrary(str);
                    return true;
                }
            }
            String mapLibraryName = System.mapLibraryName(str);
            boolean z3 = false;
            do {
                try {
                    z3 = loadLibraryBySoNameImpl(mapLibraryName, str, null, i, null);
                    z = false;
                    continue;
                } catch (UnsatisfiedLinkError e2) {
                    int i2 = sSoSourcesVersion;
                    sSoSourcesLock.writeLock().lock();
                    try {
                        if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                            z = false;
                        } else {
                            sSoSourcesVersion++;
                            z = true;
                        }
                        sSoSourcesLock.writeLock().unlock();
                        if (sSoSourcesVersion == i2) {
                            throw e2;
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(e3);
                    } catch (Throwable th) {
                        sSoSourcesLock.writeLock().unlock();
                        throw th;
                    }
                }
            } while (z);
            return z3;
        } catch (Throwable th2) {
            sSoSourcesLock.readLock().unlock();
            throw th2;
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
