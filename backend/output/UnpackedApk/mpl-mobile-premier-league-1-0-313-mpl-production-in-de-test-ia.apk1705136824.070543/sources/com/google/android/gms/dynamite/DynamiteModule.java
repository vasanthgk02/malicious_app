package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class DynamiteModule {
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static Boolean zzb = null;
    public static String zzc = null;
    public static boolean zzd = false;
    public static int zze = -1;
    public static Boolean zzf;
    public static final ThreadLocal zzg = new ThreadLocal();
    public static final ThreadLocal zzh = new zzd();
    public static final IVersions zzi = new zze();
    public static zzq zzk;
    public static zzr zzl;
    public final Context zzj;

    @DynamiteApi
    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface VersionPolicy {

        @KeepForSdk
        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        @KeepForSdk
        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public static class SelectionResult {
            @KeepForSdk
            public int localVersion = 0;
            @KeepForSdk
            public int remoteVersion = 0;
            @KeepForSdk
            public int selection = 0;
        }

        @KeepForSdk
        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    public DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String.valueOf(declaredField.get(null));
            return 0;
        } catch (ClassNotFoundException unused) {
            return 0;
        } catch (Exception e2) {
            "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage()));
            return 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:116|117|118|119|120|121) */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0208, code lost:
        if (r1 != null) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r1 != null) goto L_0x020a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:119:0x01ba */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r17, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r18, java.lang.String r19) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r17
            r2 = r18
            r3 = r19
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            java.lang.ThreadLocal r0 = zzg
            java.lang.Object r0 = r0.get()
            r5 = r0
            com.google.android.gms.dynamite.zzn r5 = (com.google.android.gms.dynamite.zzn) r5
            com.google.android.gms.dynamite.zzn r6 = new com.google.android.gms.dynamite.zzn
            r0 = 0
            r6.<init>(r0)
            java.lang.ThreadLocal r7 = zzg
            r7.set(r6)
            java.lang.ThreadLocal r7 = zzh
            java.lang.Object r7 = r7.get()
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            r9 = 0
            java.lang.ThreadLocal r11 = zzh     // Catch:{ all -> 0x0262 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0262 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0262 }
            r11.set(r12)     // Catch:{ all -> 0x0262 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r11 = zzi     // Catch:{ all -> 0x0262 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r11 = r2.selectModule(r1, r3, r11)     // Catch:{ all -> 0x0262 }
            int r12 = r11.localVersion     // Catch:{ all -> 0x0262 }
            int r12 = r11.selection     // Catch:{ all -> 0x0262 }
            if (r12 == 0) goto L_0x0232
            r13 = -1
            if (r12 != r13) goto L_0x004b
            int r12 = r11.localVersion     // Catch:{ all -> 0x0262 }
            if (r12 == 0) goto L_0x0232
            r12 = -1
        L_0x004b:
            r14 = 1
            if (r12 != r14) goto L_0x0052
            int r15 = r11.remoteVersion     // Catch:{ all -> 0x0262 }
            if (r15 == 0) goto L_0x0232
        L_0x0052:
            if (r12 != r13) goto L_0x007b
            java.lang.String r0 = "Selected local version of "
            r0.concat(r3)     // Catch:{ all -> 0x0262 }
            com.google.android.gms.dynamite.DynamiteModule r0 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ all -> 0x0262 }
            android.content.Context r1 = r17.getApplicationContext()     // Catch:{ all -> 0x0262 }
            r0.<init>(r1)     // Catch:{ all -> 0x0262 }
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x006c
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x0075
        L_0x006c:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r1.set(r2)
        L_0x0075:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x020d
            goto L_0x020a
        L_0x007b:
            if (r12 != r14) goto L_0x021b
            int r12 = r11.remoteVersion     // Catch:{ LoadingException -> 0x01cd }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            boolean r15 = zzf(r17)     // Catch:{ all -> 0x01b0 }
            if (r15 == 0) goto L_0x01a8
            java.lang.Boolean r15 = zzb     // Catch:{ all -> 0x01b0 }
            monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
            if (r15 == 0) goto L_0x01a0
            boolean r15 = r15.booleanValue()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r14 = 2
            if (r15 == 0) goto L_0x0110
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamite.zzr r15 = zzl     // Catch:{ all -> 0x010d }
            monitor-exit(r4)     // Catch:{ all -> 0x010d }
            if (r15 == 0) goto L_0x0105
            java.lang.ThreadLocal r16 = zzg     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.Object r16 = r16.get()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r13 = r16
            com.google.android.gms.dynamite.zzn r13 = (com.google.android.gms.dynamite.zzn) r13     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            if (r13 == 0) goto L_0x00fd
            android.database.Cursor r9 = r13.zza     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            if (r9 == 0) goto L_0x00fd
            android.content.Context r9 = r17.getApplicationContext()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            android.database.Cursor r10 = r13.zza     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.ObjectWrapper r13 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r13.<init>(r0)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            int r0 = zze     // Catch:{ all -> 0x00fa }
            if (r0 < r14) goto L_0x00ba
            r14 = 1
            goto L_0x00bb
        L_0x00ba:
            r14 = 0
        L_0x00bb:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x00fa }
            monitor-exit(r4)     // Catch:{ all -> 0x00fa }
            boolean r0 = r0.booleanValue()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            if (r0 == 0) goto L_0x00d5
            com.google.android.gms.dynamic.ObjectWrapper r0 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r0.<init>(r9)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.ObjectWrapper r4 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4.<init>(r10)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r15.zzf(r0, r3, r12, r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            goto L_0x00e3
        L_0x00d5:
            com.google.android.gms.dynamic.ObjectWrapper r0 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r0.<init>(r9)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.ObjectWrapper r4 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4.<init>(r10)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r15.zze(r0, r3, r12, r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x00e3:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            if (r0 == 0) goto L_0x00f2
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            goto L_0x016e
        L_0x00f2:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.String r4 = "Failed to get module context"
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x00fa:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x00fd:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.String r4 = "No result cursor"
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x0105:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.String r4 = "DynamiteLoaderV2 was not cached."
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x010d:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x010d }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x0110:
            com.google.android.gms.dynamite.zzq r0 = zzg(r17)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            if (r0 == 0) goto L_0x0198
            android.os.Parcel r4 = r0.zza()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r9 = 6
            android.os.Parcel r4 = r0.zzB(r9, r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            int r9 = r4.readInt()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4.recycle()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4 = 3
            if (r9 < r4) goto L_0x014c
            java.lang.ThreadLocal r4 = zzg     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.Object r4 = r4.get()     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamite.zzn r4 = (com.google.android.gms.dynamite.zzn) r4     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            if (r4 == 0) goto L_0x0144
            com.google.android.gms.dynamic.ObjectWrapper r9 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r9.<init>(r1)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            android.database.Cursor r4 = r4.zza     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.ObjectWrapper r10 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r10.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzi(r9, r3, r12, r10)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            goto L_0x0161
        L_0x0144:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.String r4 = "No cached result cursor holder"
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x014c:
            if (r9 != r14) goto L_0x0158
            com.google.android.gms.dynamic.ObjectWrapper r4 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4.<init>(r1)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzj(r4, r3, r12)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            goto L_0x0161
        L_0x0158:
            com.google.android.gms.dynamic.ObjectWrapper r4 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4.<init>(r1)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzh(r4, r3, r12)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x0161:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            if (r0 == 0) goto L_0x0190
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x016e:
            r1 = 0
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x017a
            java.lang.ThreadLocal r0 = zzh
            r0.remove()
            goto L_0x0183
        L_0x017a:
            java.lang.ThreadLocal r0 = zzh
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0.set(r1)
        L_0x0183:
            android.database.Cursor r0 = r6.zza
            if (r0 == 0) goto L_0x018a
            r0.close()
        L_0x018a:
            java.lang.ThreadLocal r0 = zzg
            r0.set(r5)
            return r4
        L_0x0190:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.String r4 = "Failed to load remote module."
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x0198:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.String r4 = "Failed to create IDynamiteLoader."
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x01a0:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            java.lang.String r4 = "Failed to determine which loading route to use."
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x01a8:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x01b0 }
            java.lang.String r9 = "Remote loading disabled"
            r0.<init>(r9)     // Catch:{ all -> 0x01b0 }
            throw r0     // Catch:{ all -> 0x01b0 }
        L_0x01b0:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
            throw r0     // Catch:{ RemoteException -> 0x01c4, LoadingException -> 0x01c2, all -> 0x01b3 }
        L_0x01b3:
            r0 = move-exception
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r17)     // Catch:{ Exception -> 0x01ba }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ Exception -> 0x01ba }
        L_0x01ba:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x01cd }
            java.lang.String r9 = "Failed to load remote module."
            r4.<init>(r9, r0)     // Catch:{ LoadingException -> 0x01cd }
            throw r4     // Catch:{ LoadingException -> 0x01cd }
        L_0x01c2:
            r0 = move-exception
            throw r0     // Catch:{ LoadingException -> 0x01cd }
        L_0x01c4:
            r0 = move-exception
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x01cd }
            java.lang.String r9 = "Failed to load remote module."
            r4.<init>(r9, r0)     // Catch:{ LoadingException -> 0x01cd }
            throw r4     // Catch:{ LoadingException -> 0x01cd }
        L_0x01cd:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x0262 }
            int r4 = r11.localVersion     // Catch:{ all -> 0x0262 }
            if (r4 == 0) goto L_0x0213
            com.google.android.gms.dynamite.zzo r9 = new com.google.android.gms.dynamite.zzo     // Catch:{ all -> 0x0262 }
            r9.<init>(r4)     // Catch:{ all -> 0x0262 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r2 = r2.selectModule(r1, r3, r9)     // Catch:{ all -> 0x0262 }
            int r2 = r2.selection     // Catch:{ all -> 0x0262 }
            r4 = -1
            if (r2 != r4) goto L_0x0213
            java.lang.String r0 = "Selected local version of "
            r0.concat(r3)     // Catch:{ all -> 0x0262 }
            com.google.android.gms.dynamite.DynamiteModule r0 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ all -> 0x0262 }
            android.content.Context r1 = r17.getApplicationContext()     // Catch:{ all -> 0x0262 }
            r0.<init>(r1)     // Catch:{ all -> 0x0262 }
            r1 = 0
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x01fd
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x0206
        L_0x01fd:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r1.set(r2)
        L_0x0206:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x020d
        L_0x020a:
            r1.close()
        L_0x020d:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r5)
            return r0
        L_0x0213:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0262 }
            throw r1     // Catch:{ all -> 0x0262 }
        L_0x021b:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0262 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r1.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = "VersionPolicy returned invalid code:"
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            r1.append(r12)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0262 }
            r0.<init>(r1)     // Catch:{ all -> 0x0262 }
            throw r0     // Catch:{ all -> 0x0262 }
        L_0x0232:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0262 }
            int r1 = r11.localVersion     // Catch:{ all -> 0x0262 }
            int r2 = r11.remoteVersion     // Catch:{ all -> 0x0262 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r4.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r9 = "No acceptable module "
            r4.append(r9)     // Catch:{ all -> 0x0262 }
            r4.append(r3)     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{ all -> 0x0262 }
            r4.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{ all -> 0x0262 }
            r4.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0262 }
            r0.<init>(r1)     // Catch:{ all -> 0x0262 }
            throw r0     // Catch:{ all -> 0x0262 }
        L_0x0262:
            r0 = move-exception
            r1 = 0
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x026f
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x0278
        L_0x026f:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r1.set(r2)
        L_0x0278:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x027f
            r1.close()
        L_0x027f:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:55|56|58|59|67|68|69|70|(3:72|73|74)(3:79|(4:81|82|(5:84|(2:86|(1:88))|89|(3:91|92|(1:94)(3:95|(1:99)|(2:101|102)))|(1:108))(2:109|(2:111|112)(1:113))|114)|124)) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0137, code lost:
        if (r2 != null) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x013d, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x013e, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0140, code lost:
        r12 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0141, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0143, code lost:
        if (r11 != null) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0145, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x014a, code lost:
        if (r1 == 2) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r0 = new com.google.android.gms.dynamic.ObjectWrapper(r10);
        r1 = r4.zza();
        com.google.android.gms.internal.common.zzc.zzf(r1, r0);
        r1.writeString(r11);
        com.google.android.gms.internal.common.zzc.zzc(r1, r12);
        r11 = r4.zzB(5, r1);
        r12 = r11.readInt();
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x016b, code lost:
        r1 = new com.google.android.gms.dynamic.ObjectWrapper(r10);
        r5 = r4.zza();
        com.google.android.gms.internal.common.zzc.zzf(r5, r1);
        r5.writeString(r11);
        com.google.android.gms.internal.common.zzc.zzc(r5, r12);
        r11 = r4.zzB(3, r5);
        r12 = r11.readInt();
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0188, code lost:
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x018a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x018b, code lost:
        r12 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x018d, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x018e, code lost:
        r12 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        r12.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0192, code lost:
        if (r2 != null) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0197, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0198, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0199, code lost:
        if (r2 != null) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x019b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x019e, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r1.set(null, java.lang.ClassLoader.getSystemClassLoader());
        r1 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00ce, code lost:
        return zzb(r10, r11, r12, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00d4, code lost:
        r4 = zzg(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00d8, code lost:
        if (r4 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r0 = r4.zzB(6, r4.zza());
        r1 = r0.readInt();
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00ed, code lost:
        if (r1 >= 3) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00ef, code lost:
        r0 = (com.google.android.gms.dynamite.zzn) zzg.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00f7, code lost:
        if (r0 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00f9, code lost:
        r0 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00fb, code lost:
        if (r0 != null) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00fd, code lost:
        r3 = r0.getInt(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0103, code lost:
        r11 = (android.database.Cursor) com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4.zzk(new com.google.android.gms.dynamic.ObjectWrapper(r10), r11, r12, ((java.lang.Long) zzh.get()).longValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0120, code lost:
        if (r11 != null) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0126, code lost:
        if (r11.moveToFirst() == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0129, code lost:
        r12 = r11.getInt(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0136, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x009f */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0194 A[SYNTHETIC, Splitter:B:122:0x0194] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x019b A[Catch:{ LoadingException -> 0x00cf, all -> 0x01a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ca A[SYNTHETIC, Splitter:B:72:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d4 A[Catch:{ LoadingException -> 0x00cf, all -> 0x01a2 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:17:0x003b=Splitter:B:17:0x003b, B:50:0x009c=Splitter:B:50:0x009c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01a2 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x019f }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00c3
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x019f }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x00a9
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x00b4 }
            if (r5 == 0) goto L_0x0055
            goto L_0x00a9
        L_0x0055:
            r5 = 1
            int r5 = zzb(r10, r11, r12, r5)     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x009c
            boolean r6 = r6.isEmpty()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x0065
            goto L_0x009c
        L_0x0065:
            java.lang.ClassLoader r6 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009f }
            r7 = 29
            if (r6 < r7) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r6 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.zzc r6 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
        L_0x008f:
            zzd(r6)     // Catch:{ LoadingException -> 0x009f }
            r1.set(r2, r6)     // Catch:{ LoadingException -> 0x009f }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x009f }
            zzb = r6     // Catch:{ LoadingException -> 0x009f }
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x019f }
            return r5
        L_0x009c:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x019f }
            return r5
        L_0x009f:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x00a9:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            goto L_0x00c1
        L_0x00b4:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
        L_0x00b7:
            r1 = move-exception
            goto L_0x00bc
        L_0x00b9:
            r1 = move-exception
            goto L_0x00bc
        L_0x00bb:
            r1 = move-exception
        L_0x00bc:
            r1.toString()     // Catch:{ all -> 0x019f }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x019f }
        L_0x00c1:
            zzb = r1     // Catch:{ all -> 0x019f }
        L_0x00c3:
            monitor-exit(r0)     // Catch:{ all -> 0x019f }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01a2 }
            if (r0 == 0) goto L_0x00d4
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00cf }
            return r10
        L_0x00cf:
            r11 = move-exception
            r11.getMessage()     // Catch:{ all -> 0x01a2 }
            return r3
        L_0x00d4:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01a2 }
            if (r4 != 0) goto L_0x00dc
            goto L_0x0197
        L_0x00dc:
            android.os.Parcel r0 = r4.zza()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r1 = 6
            android.os.Parcel r0 = r4.zzB(r1, r0)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            int r1 = r0.readInt()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r0.recycle()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r0 = 3
            if (r1 < r0) goto L_0x0149
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            if (r0 == 0) goto L_0x0103
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            if (r0 == 0) goto L_0x0103
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            goto L_0x0197
        L_0x0103:
            com.google.android.gms.dynamic.ObjectWrapper r5 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r5.<init>(r10)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            if (r11 == 0) goto L_0x0143
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x0140, all -> 0x013d }
            if (r12 != 0) goto L_0x0129
            goto L_0x0143
        L_0x0129:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x0140, all -> 0x013d }
            if (r12 <= 0) goto L_0x0136
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x0140, all -> 0x013d }
            if (r0 == 0) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r2 = r11
        L_0x0137:
            if (r2 == 0) goto L_0x0188
            r2.close()     // Catch:{ all -> 0x01a2 }
            goto L_0x0188
        L_0x013d:
            r12 = move-exception
            r2 = r11
            goto L_0x0199
        L_0x0140:
            r12 = move-exception
            r2 = r11
            goto L_0x018f
        L_0x0143:
            if (r11 == 0) goto L_0x0197
            r11.close()     // Catch:{ all -> 0x01a2 }
            goto L_0x0197
        L_0x0149:
            r5 = 2
            if (r1 != r5) goto L_0x016b
            com.google.android.gms.dynamic.ObjectWrapper r0 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r0.<init>(r10)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            android.os.Parcel r1 = r4.zza()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            com.google.android.gms.internal.common.zzc.zzf(r1, r0)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r1.writeString(r11)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            com.google.android.gms.internal.common.zzc.zzc(r1, r12)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r11 = 5
            android.os.Parcel r11 = r4.zzB(r11, r1)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            int r12 = r11.readInt()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r11.recycle()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            goto L_0x0188
        L_0x016b:
            com.google.android.gms.dynamic.ObjectWrapper r1 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r1.<init>(r10)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            android.os.Parcel r5 = r4.zza()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            com.google.android.gms.internal.common.zzc.zzf(r5, r1)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r5.writeString(r11)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            com.google.android.gms.internal.common.zzc.zzc(r5, r12)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            android.os.Parcel r11 = r4.zzB(r0, r5)     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            int r12 = r11.readInt()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
            r11.recycle()     // Catch:{ RemoteException -> 0x018d, all -> 0x018a }
        L_0x0188:
            r3 = r12
            goto L_0x0197
        L_0x018a:
            r11 = move-exception
            r12 = r11
            goto L_0x0199
        L_0x018d:
            r11 = move-exception
            r12 = r11
        L_0x018f:
            r12.getMessage()     // Catch:{ all -> 0x0198 }
            if (r2 == 0) goto L_0x0197
            r2.close()     // Catch:{ all -> 0x01a2 }
        L_0x0197:
            return r3
        L_0x0198:
            r12 = move-exception
        L_0x0199:
            if (r2 == 0) goto L_0x019e
            r2.close()     // Catch:{ all -> 0x01a2 }
        L_0x019e:
            throw r12     // Catch:{ all -> 0x01a2 }
        L_0x019f:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x019f }
            throw r11     // Catch:{ all -> 0x01a2 }
        L_0x01a2:
            r11 = move-exception
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ Exception -> 0x01a9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ Exception -> 0x01a9 }
        L_0x01a9:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        if (zze(r10) != false) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x009d }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x009d }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x009d }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x009d }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x009d }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x009d }
            r12.<init>()     // Catch:{ Exception -> 0x009d }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x009d }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x009d }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x009d }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x009d }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x009d }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x009d }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x009d }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x009d }
            if (r10 == 0) goto L_0x00a9
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
            if (r11 == 0) goto L_0x00a9
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
            if (r12 <= 0) goto L_0x008d
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008a }
            zzc = r2     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008a }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008a }
            zze = r2     // Catch:{ all -> 0x008a }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008a }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008a }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008a }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
            if (r1 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008a:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008a }
            throw r11     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
        L_0x008d:
            r0 = r10
        L_0x008e:
            if (r13 == 0) goto L_0x009f
            if (r11 != 0) goto L_0x0093
            goto L_0x009f
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009d }
            java.lang.String r11 = "forcing fallback to container DynamiteLoader impl"
            r10.<init>(r11)     // Catch:{ Exception -> 0x009d }
            throw r10     // Catch:{ Exception -> 0x009d }
        L_0x009b:
            r10 = move-exception
            goto L_0x00c4
        L_0x009d:
            r10 = move-exception
            goto L_0x00b6
        L_0x009f:
            if (r0 == 0) goto L_0x00a4
            r0.close()
        L_0x00a4:
            return r12
        L_0x00a5:
            r11 = move-exception
            goto L_0x00b1
        L_0x00a7:
            r11 = move-exception
            goto L_0x00b4
        L_0x00a9:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12)     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
            throw r11     // Catch:{ Exception -> 0x00a7, all -> 0x00a5 }
        L_0x00b1:
            r0 = r10
            r10 = r11
            goto L_0x00c4
        L_0x00b4:
            r0 = r10
            r10 = r11
        L_0x00b6:
            boolean r11 = r10 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x009b }
            if (r11 == 0) goto L_0x00bc
            throw r10     // Catch:{ all -> 0x009b }
        L_0x00bc:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x009b }
            java.lang.String r12 = "V2 version check failed"
            r11.<init>(r12, r10)     // Catch:{ all -> 0x009b }
            throw r11     // Catch:{ all -> 0x009b }
        L_0x00c4:
            if (r0 == 0) goto L_0x00c9
            r0.close()
        L_0x00c9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2);
        }
    }

    public static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    public static boolean zzf(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider != null) {
                ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
                if (applicationInfo != null && (applicationInfo.flags & 129) == 0) {
                    zzd = true;
                }
            }
        }
        return z;
    }

    public static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return null;
    }

    @KeepForSdk
    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("Failed to instantiate module class: ".concat(str), e2);
        }
    }
}
