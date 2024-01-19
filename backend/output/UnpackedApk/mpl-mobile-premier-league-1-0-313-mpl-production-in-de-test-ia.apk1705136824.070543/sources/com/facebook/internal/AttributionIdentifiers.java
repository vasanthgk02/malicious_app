package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers;", "", "()V", "androidAdvertiserId", "", "getAndroidAdvertiserId", "()Ljava/lang/String;", "androidAdvertiserIdValue", "<set-?>", "androidInstallerPackage", "getAndroidInstallerPackage", "attributionId", "getAttributionId", "fetchTime", "", "", "isTrackingLimited", "()Z", "Companion", "GoogleAdInfo", "GoogleAdServiceConnection", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AttributionIdentifiers.kt */
public final class AttributionIdentifiers {
    public static AttributionIdentifiers cachedIdentifiers;
    public String androidAdvertiserIdValue;
    public String androidInstallerPackage;
    public String attributionId;
    public long fetchTime;
    public boolean isTrackingLimited;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$Companion;", "", "()V", "ANDROID_ID_COLUMN_NAME", "", "ATTRIBUTION_ID_COLUMN_NAME", "ATTRIBUTION_ID_CONTENT_PROVIDER", "getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations", "ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI", "CONNECTION_RESULT_SUCCESS", "", "IDENTIFIER_REFRESH_INTERVAL_MILLIS", "", "LIMIT_TRACKING_COLUMN_NAME", "TAG", "kotlin.jvm.PlatformType", "cachedIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "getCachedIdentifiers$facebook_core_release$annotations", "cacheAndReturnIdentifiers", "identifiers", "getAndroidId", "context", "Landroid/content/Context;", "getAndroidIdViaReflection", "getAndroidIdViaService", "getAttributionIdentifiers", "getInstallerPackageName", "isGooglePlayServicesAvailable", "", "isTrackingLimited", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AttributionIdentifiers.kt */
    public static final class Companion {
        public static final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            attributionIdentifiers.fetchTime = System.currentTimeMillis();
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
            return attributionIdentifiers;
        }

        /* JADX WARNING: Removed duplicated region for block: B:119:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x0224  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0195 A[Catch:{ Exception -> 0x0207, all -> 0x0204 }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0197 A[Catch:{ Exception -> 0x0207, all -> 0x0204 }] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01a1 A[Catch:{ Exception -> 0x0207, all -> 0x0204 }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x01a5 A[Catch:{ Exception -> 0x0207, all -> 0x0204 }] */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01a9 A[Catch:{ Exception -> 0x0207, all -> 0x0204 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r15) {
            /*
                java.lang.String r0 = "limit_tracking"
                java.lang.String r1 = "androidid"
                java.lang.String r2 = "aid"
                java.lang.String r3 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r3)
                java.lang.String r3 = "android_id"
                r4 = 1
                r5 = 0
                r6 = 0
                boolean r7 = isGooglePlayServicesAvailable(r15)     // Catch:{ Exception -> 0x0073 }
                if (r7 != 0) goto L_0x0017
                goto L_0x0077
            L_0x0017:
                java.lang.String r7 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
                java.lang.String r8 = "getAdvertisingIdInfo"
                java.lang.Class[] r9 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0073 }
                java.lang.Class<android.content.Context> r10 = android.content.Context.class
                r9[r5] = r10     // Catch:{ Exception -> 0x0073 }
                java.lang.reflect.Method r7 = com.facebook.internal.Utility.getMethodQuietly(r7, r8, (java.lang.Class<?>[]) r9)     // Catch:{ Exception -> 0x0073 }
                if (r7 != 0) goto L_0x0028
                goto L_0x0077
            L_0x0028:
                java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0073 }
                r8[r5] = r15     // Catch:{ Exception -> 0x0073 }
                java.lang.Object r7 = com.facebook.internal.Utility.invokeMethodQuietly(r6, r7, r8)     // Catch:{ Exception -> 0x0073 }
                if (r7 != 0) goto L_0x0033
                goto L_0x0077
            L_0x0033:
                java.lang.Class r8 = r7.getClass()     // Catch:{ Exception -> 0x0073 }
                java.lang.String r9 = "getId"
                java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0073 }
                java.lang.reflect.Method r8 = com.facebook.internal.Utility.getMethodQuietly(r8, r9, (java.lang.Class<?>[]) r10)     // Catch:{ Exception -> 0x0073 }
                java.lang.Class r9 = r7.getClass()     // Catch:{ Exception -> 0x0073 }
                java.lang.String r10 = "isLimitAdTrackingEnabled"
                java.lang.Class[] r11 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0073 }
                java.lang.reflect.Method r9 = com.facebook.internal.Utility.getMethodQuietly(r9, r10, (java.lang.Class<?>[]) r11)     // Catch:{ Exception -> 0x0073 }
                if (r8 == 0) goto L_0x0077
                if (r9 != 0) goto L_0x0050
                goto L_0x0077
            L_0x0050:
                com.facebook.internal.AttributionIdentifiers r10 = new com.facebook.internal.AttributionIdentifiers     // Catch:{ Exception -> 0x0073 }
                r10.<init>()     // Catch:{ Exception -> 0x0073 }
                java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0073 }
                java.lang.Object r8 = com.facebook.internal.Utility.invokeMethodQuietly(r7, r8, r11)     // Catch:{ Exception -> 0x0073 }
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0073 }
                r10.androidAdvertiserIdValue = r8     // Catch:{ Exception -> 0x0073 }
                java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0073 }
                java.lang.Object r7 = com.facebook.internal.Utility.invokeMethodQuietly(r7, r9, r8)     // Catch:{ Exception -> 0x0073 }
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x0073 }
                if (r7 != 0) goto L_0x006b
                r7 = 0
                goto L_0x006f
            L_0x006b:
                boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x0073 }
            L_0x006f:
                r10.isTrackingLimited = r7     // Catch:{ Exception -> 0x0073 }
                r6 = r10
                goto L_0x0077
            L_0x0073:
                r7 = move-exception
                com.facebook.internal.Utility.logd(r3, r7)
            L_0x0077:
                if (r6 != 0) goto L_0x0124
                java.lang.String r6 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                java.lang.String r7 = "obtain()"
                boolean r8 = isGooglePlayServicesAvailable(r15)
                if (r8 != 0) goto L_0x0085
                goto L_0x011b
            L_0x0085:
                com.facebook.internal.AttributionIdentifiers$GoogleAdServiceConnection r8 = new com.facebook.internal.AttributionIdentifiers$GoogleAdServiceConnection
                r8.<init>()
                android.content.Intent r9 = new android.content.Intent
                java.lang.String r10 = "com.google.android.gms.ads.identifier.service.START"
                r9.<init>(r10)
                java.lang.String r10 = "com.google.android.gms"
                r9.setPackage(r10)
                boolean r9 = r15.bindService(r9, r8, r4)     // Catch:{ SecurityException -> 0x011b }
                if (r9 == 0) goto L_0x011b
                android.os.IBinder r9 = r8.getBinder()     // Catch:{ Exception -> 0x010f }
                java.lang.String r10 = "binder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)     // Catch:{ Exception -> 0x010f }
                com.facebook.internal.AttributionIdentifiers r10 = new com.facebook.internal.AttributionIdentifiers     // Catch:{ Exception -> 0x010f }
                r10.<init>()     // Catch:{ Exception -> 0x010f }
                android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x010f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)     // Catch:{ Exception -> 0x010f }
                android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x010f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)     // Catch:{ Exception -> 0x010f }
                r11.writeInterfaceToken(r6)     // Catch:{ all -> 0x0105 }
                r9.transact(r4, r11, r12, r5)     // Catch:{ all -> 0x0105 }
                r12.readException()     // Catch:{ all -> 0x0105 }
                java.lang.String r13 = r12.readString()     // Catch:{ all -> 0x0105 }
                r12.recycle()     // Catch:{ Exception -> 0x010f }
                r11.recycle()     // Catch:{ Exception -> 0x010f }
                r10.androidAdvertiserIdValue = r13     // Catch:{ Exception -> 0x010f }
                android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x010f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)     // Catch:{ Exception -> 0x010f }
                android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x010f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)     // Catch:{ Exception -> 0x010f }
                r11.writeInterfaceToken(r6)     // Catch:{ all -> 0x00fd }
                r11.writeInt(r4)     // Catch:{ all -> 0x00fd }
                r6 = 2
                r9.transact(r6, r11, r12, r5)     // Catch:{ all -> 0x00fd }
                r12.readException()     // Catch:{ all -> 0x00fd }
                int r6 = r12.readInt()     // Catch:{ all -> 0x00fd }
                if (r6 == 0) goto L_0x00ef
                goto L_0x00f0
            L_0x00ef:
                r4 = 0
            L_0x00f0:
                r12.recycle()     // Catch:{ Exception -> 0x010f }
                r11.recycle()     // Catch:{ Exception -> 0x010f }
                r10.isTrackingLimited = r4     // Catch:{ Exception -> 0x010f }
                r15.unbindService(r8)
                r6 = r10
                goto L_0x011d
            L_0x00fd:
                r4 = move-exception
                r12.recycle()     // Catch:{ Exception -> 0x010f }
                r11.recycle()     // Catch:{ Exception -> 0x010f }
                throw r4     // Catch:{ Exception -> 0x010f }
            L_0x0105:
                r4 = move-exception
                r12.recycle()     // Catch:{ Exception -> 0x010f }
                r11.recycle()     // Catch:{ Exception -> 0x010f }
                throw r4     // Catch:{ Exception -> 0x010f }
            L_0x010d:
                r0 = move-exception
                goto L_0x0117
            L_0x010f:
                r4 = move-exception
                com.facebook.internal.Utility.logd(r3, r4)     // Catch:{ all -> 0x010d }
                r15.unbindService(r8)
                goto L_0x011b
            L_0x0117:
                r15.unbindService(r8)
                throw r0
            L_0x011b:
                r3 = 0
                r6 = r3
            L_0x011d:
                if (r6 != 0) goto L_0x0124
                com.facebook.internal.AttributionIdentifiers r6 = new com.facebook.internal.AttributionIdentifiers
                r6.<init>()
            L_0x0124:
                android.os.Looper r3 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                if (r3 != 0) goto L_0x01fc
                com.facebook.internal.AttributionIdentifiers r3 = com.facebook.internal.AttributionIdentifiers.cachedIdentifiers     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                if (r3 == 0) goto L_0x0145
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                long r9 = r3.fetchTime     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                long r7 = r7 - r9
                r9 = 3600000(0x36ee80, double:1.7786363E-317)
                int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r4 >= 0) goto L_0x0145
                return r3
            L_0x0145:
                java.lang.String[] r9 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                android.content.pm.PackageManager r3 = r15.getPackageManager()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r4 = "com.facebook.katana.provider.AttributionIdProvider"
                android.content.pm.ProviderInfo r3 = r3.resolveContentProvider(r4, r5)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                android.content.pm.PackageManager r4 = r15.getPackageManager()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r7 = "com.facebook.wakizashi.provider.AttributionIdProvider"
                android.content.pm.ProviderInfo r4 = r4.resolveContentProvider(r7, r5)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                if (r3 == 0) goto L_0x0175
                com.facebook.internal.FacebookSignatureValidator r5 = com.facebook.internal.FacebookSignatureValidator.INSTANCE     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r5 = "contentProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                boolean r3 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r15, r3)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                if (r3 == 0) goto L_0x0175
                java.lang.String r3 = "content://com.facebook.katana.provider.AttributionIdProvider"
                android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                goto L_0x018e
            L_0x0175:
                if (r4 == 0) goto L_0x018d
                com.facebook.internal.FacebookSignatureValidator r3 = com.facebook.internal.FacebookSignatureValidator.INSTANCE     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r3 = r4.packageName     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r4 = "wakizashiProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                boolean r3 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r15, r3)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                if (r3 == 0) goto L_0x018d
                java.lang.String r3 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
                android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                goto L_0x018e
            L_0x018d:
                r3 = 0
            L_0x018e:
                r8 = r3
                android.content.pm.PackageManager r3 = r15.getPackageManager()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                if (r3 != 0) goto L_0x0197
                r3 = 0
                goto L_0x019f
            L_0x0197:
                java.lang.String r4 = r15.getPackageName()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r3 = r3.getInstallerPackageName(r4)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
            L_0x019f:
                if (r3 == 0) goto L_0x01a3
                r6.androidInstallerPackage = r3     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
            L_0x01a3:
                if (r8 != 0) goto L_0x01a9
                cacheAndReturnIdentifiers(r6)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                return r6
            L_0x01a9:
                android.content.ContentResolver r7 = r15.getContentResolver()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                r10 = 0
                r11 = 0
                r12 = 0
                android.database.Cursor r15 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                if (r15 == 0) goto L_0x01f0
                boolean r3 = r15.moveToFirst()     // Catch:{ Exception -> 0x01fa }
                if (r3 != 0) goto L_0x01bd
                goto L_0x01f0
            L_0x01bd:
                int r2 = r15.getColumnIndex(r2)     // Catch:{ Exception -> 0x01fa }
                int r1 = r15.getColumnIndex(r1)     // Catch:{ Exception -> 0x01fa }
                int r0 = r15.getColumnIndex(r0)     // Catch:{ Exception -> 0x01fa }
                java.lang.String r2 = r15.getString(r2)     // Catch:{ Exception -> 0x01fa }
                r6.attributionId = r2     // Catch:{ Exception -> 0x01fa }
                if (r1 <= 0) goto L_0x01e9
                if (r0 <= 0) goto L_0x01e9
                java.lang.String r2 = r6.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x01fa }
                if (r2 != 0) goto L_0x01e9
                java.lang.String r1 = r15.getString(r1)     // Catch:{ Exception -> 0x01fa }
                r6.androidAdvertiserIdValue = r1     // Catch:{ Exception -> 0x01fa }
                java.lang.String r0 = r15.getString(r0)     // Catch:{ Exception -> 0x01fa }
                boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x01fa }
                r6.isTrackingLimited = r0     // Catch:{ Exception -> 0x01fa }
            L_0x01e9:
                r15.close()
                cacheAndReturnIdentifiers(r6)
                return r6
            L_0x01f0:
                cacheAndReturnIdentifiers(r6)     // Catch:{ Exception -> 0x01fa }
                if (r15 != 0) goto L_0x01f6
                goto L_0x01f9
            L_0x01f6:
                r15.close()
            L_0x01f9:
                return r6
            L_0x01fa:
                r0 = move-exception
                goto L_0x020c
            L_0x01fc:
                com.facebook.FacebookException r15 = new com.facebook.FacebookException     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                java.lang.String r0 = "getAttributionIdentifiers cannot be called on the main thread."
                r15.<init>(r0)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
                throw r15     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
            L_0x0204:
                r15 = move-exception
                r0 = 0
                goto L_0x0221
            L_0x0207:
                r15 = move-exception
                r0 = 0
                r14 = r0
                r0 = r15
                r15 = r14
            L_0x020c:
                java.lang.String r1 = "Caught unexpected exception in getAttributionId(): "
                kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)     // Catch:{ all -> 0x021d }
                com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x021d }
                boolean r0 = com.facebook.FacebookSdk.isDebugEnabledField     // Catch:{ all -> 0x021d }
                if (r15 != 0) goto L_0x0218
                goto L_0x021b
            L_0x0218:
                r15.close()
            L_0x021b:
                r15 = 0
                return r15
            L_0x021d:
                r0 = move-exception
                r14 = r0
                r0 = r15
                r15 = r14
            L_0x0221:
                if (r0 != 0) goto L_0x0224
                goto L_0x0227
            L_0x0224:
                r0.close()
            L_0x0227:
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
        }

        public static final boolean isGooglePlayServicesAvailable(Context context) {
            boolean z = true;
            Method methodQuietly = Utility.getMethodQuietly((String) "com.google.android.gms.common.GooglePlayServicesUtil", (String) "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return false;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (!(invokeMethodQuietly instanceof Integer) || !Intrinsics.areEqual(invokeMethodQuietly, Integer.valueOf(0))) {
                z = false;
            }
            return z;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "binder", "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "consumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "queue", "Ljava/util/concurrent/BlockingQueue;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "onServiceDisconnected", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AttributionIdentifiers.kt */
    public static final class GoogleAdServiceConnection implements ServiceConnection {
        public final AtomicBoolean consumed = new AtomicBoolean(false);
        public final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        public final IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                IBinder take = this.queue.take();
                Intrinsics.checkNotNullExpressionValue(take, "queue.take()");
                return take;
            }
            throw new IllegalStateException("Binder already consumed".toString());
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final String getAndroidAdvertiserId() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isInitialized()) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
            if (UserSettingsManager.getAdvertiserIDCollectionEnabled()) {
                return this.androidAdvertiserIdValue;
            }
        }
        return null;
    }
}
