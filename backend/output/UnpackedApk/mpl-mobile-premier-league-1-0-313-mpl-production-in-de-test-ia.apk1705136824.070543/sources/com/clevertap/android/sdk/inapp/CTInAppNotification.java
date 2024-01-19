package com.clevertap.android.sdk.inapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.LruCache;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.utils.ImageCache;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class CTInAppNotification implements Parcelable {
    public static final Creator<CTInAppNotification> CREATOR = new Creator<CTInAppNotification>() {
        public Object createFromParcel(Parcel parcel) {
            return new CTInAppNotification(parcel, null);
        }

        public Object[] newArray(int i) {
            return new CTInAppNotification[i];
        }
    };
    public String _landscapeImageCacheKey;
    public JSONObject actionExtras;
    public String backgroundColor;
    public int buttonCount;
    public ArrayList<CTInAppNotificationButton> buttons = new ArrayList<>();
    public String campaignId;
    public JSONObject customExtras;
    public String customInAppUrl;
    public boolean darkenScreen;
    public String error;
    public boolean excludeFromCaps;
    public int height;
    public int heightPercentage;
    public boolean hideCloseButton;
    public String html;
    public String id;
    public CTInAppType inAppType;
    public boolean isLandscape;
    public boolean isPortrait;
    public boolean isTablet;
    public boolean jsEnabled;
    public JSONObject jsonDescription;
    public String landscapeImageUrl;
    public CTInAppNotificationListener listener;
    public int maxPerSession;
    public ArrayList<CTInAppNotificationMedia> mediaList = new ArrayList<>();
    public String message;
    public String messageColor;
    public char position;
    public boolean showClose;
    public long timeToLive;
    public String title;
    public String titleColor;
    public int totalDailyCount;
    public int totalLifetimeCount;
    public String type;
    public boolean videoSupported;
    public int width;
    public int widthPercentage;

    public interface CTInAppNotificationListener {
        void notificationReady(CTInAppNotification cTInAppNotification);
    }

    public static class GifCache {
        public static final int cacheSize;
        public static LruCache<String, byte[]> mMemoryCache;
        public static final int maxMemory;

        static {
            int maxMemory2 = ((int) Runtime.getRuntime().maxMemory()) / 1024;
            maxMemory = maxMemory2;
            cacheSize = Math.max(maxMemory2 / 32, 5120);
        }

        public static int getAvailableMemory() {
            int size;
            synchronized (GifCache.class) {
                size = mMemoryCache == null ? 0 : cacheSize - mMemoryCache.size();
            }
            return size;
        }

        public static byte[] getByteArray(String str) {
            byte[] bArr;
            synchronized (GifCache.class) {
                bArr = mMemoryCache == null ? null : mMemoryCache.get(str);
            }
            return bArr;
        }

        public static void init() {
            synchronized (GifCache.class) {
                if (mMemoryCache == null) {
                    Logger.v("CTInAppNotification.GifCache: init with max device memory: " + maxMemory + "KB and allocated cache size: " + cacheSize + "KB");
                    try {
                        mMemoryCache = new LruCache<String, byte[]>(cacheSize) {
                            public int sizeOf(Object obj, Object obj2) {
                                int length = ((byte[]) obj2).length / 1024;
                                Logger.v("CTInAppNotification.GifCache: have gif of size: " + length + "KB for key: " + ((String) obj));
                                return length;
                            }
                        };
                    } catch (Throwable th) {
                        Logger.v((String) "CTInAppNotification.GifCache: unable to initialize cache: ", th.getCause());
                    }
                }
            }
        }

        public static void removeByteArray(String str) {
            boolean z;
            Class<GifCache> cls = GifCache.class;
            synchronized (cls) {
                if (mMemoryCache != null) {
                    mMemoryCache.remove(str);
                    Logger.v("CTInAppNotification.GifCache: removed gif for key: " + str);
                    synchronized (cls) {
                        synchronized (cls) {
                            z = mMemoryCache.size() <= 0;
                        }
                    }
                    if (z) {
                        Logger.v("CTInAppNotification.GifCache: cache is empty, removing it");
                        mMemoryCache = null;
                    }
                }
            }
        }
    }

    public CTInAppNotification() {
    }

    public static Bundle getBundleFromJsonObject(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    bundle.putString(next, (String) obj);
                } else if (obj instanceof Character) {
                    bundle.putChar(next, ((Character) obj).charValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    bundle.putFloat(next, ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    bundle.putBundle(next, getBundleFromJsonObject((JSONObject) obj));
                }
            } catch (JSONException unused) {
                Logger.v("Key had unknown object. Discarding");
            }
        }
        return bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x018f A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0194 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0197 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01c4 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01c6 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0202 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f2 A[SYNTHETIC, Splitter:B:58:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0115 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011a A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011d A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014e A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0153 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0156 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x016e A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0173 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0176 A[Catch:{ JSONException -> 0x022e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configureWithJson(org.json.JSONObject r21) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "buttons"
            java.lang.String r3 = "mediaLandscape"
            java.lang.String r4 = "media"
            java.lang.String r5 = "close"
            java.lang.String r6 = "message"
            java.lang.String r7 = "title"
            java.lang.String r8 = "wzrk_ttl"
            java.lang.String r9 = "hasLandscape"
            java.lang.String r10 = "hasPortrait"
            java.lang.String r11 = "bg"
            java.lang.String r12 = "tablet"
            java.lang.String r13 = "tdc"
            java.lang.String r14 = "tlc"
            java.lang.String r15 = "efc"
            r16 = r2
            java.lang.String r2 = "wzrk_id"
            r17 = r3
            java.lang.String r3 = "ti"
            boolean r18 = r0.has(r3)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r19 = ""
            if (r18 == 0) goto L_0x0035
            java.lang.String r3 = r0.getString(r3)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0037
        L_0x0035:
            r3 = r19
        L_0x0037:
            r1.id = r3     // Catch:{ JSONException -> 0x022e }
            boolean r3 = r0.has(r2)     // Catch:{ JSONException -> 0x022e }
            if (r3 == 0) goto L_0x0044
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0046
        L_0x0044:
            r2 = r19
        L_0x0046:
            r1.campaignId = r2     // Catch:{ JSONException -> 0x022e }
            java.lang.String r2 = "type"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x022e }
            r1.type = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r15)     // Catch:{ JSONException -> 0x022e }
            r3 = 1
            if (r2 == 0) goto L_0x005f
            int r2 = r0.getInt(r15)     // Catch:{ JSONException -> 0x022e }
            if (r2 != r3) goto L_0x005f
            r2 = 1
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            r1.excludeFromCaps = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r14)     // Catch:{ JSONException -> 0x022e }
            r15 = -1
            if (r2 == 0) goto L_0x006e
            int r2 = r0.getInt(r14)     // Catch:{ JSONException -> 0x022e }
            goto L_0x006f
        L_0x006e:
            r2 = -1
        L_0x006f:
            r1.totalLifetimeCount = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r13)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x007b
            int r15 = r0.getInt(r13)     // Catch:{ JSONException -> 0x022e }
        L_0x007b:
            r1.totalDailyCount = r15     // Catch:{ JSONException -> 0x022e }
            java.lang.String r2 = r1.type     // Catch:{ JSONException -> 0x022e }
            com.clevertap.android.sdk.inapp.CTInAppType r2 = com.clevertap.android.sdk.inapp.CTInAppType.fromString(r2)     // Catch:{ JSONException -> 0x022e }
            r1.inAppType = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r12)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0093
            boolean r2 = r0.getBoolean(r12)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0093
            r2 = 1
            goto L_0x0094
        L_0x0093:
            r2 = 0
        L_0x0094:
            r1.isTablet = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r11)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x00a1
            java.lang.String r2 = r0.getString(r11)     // Catch:{ JSONException -> 0x022e }
            goto L_0x00a3
        L_0x00a1:
            java.lang.String r2 = "#FFFFFF"
        L_0x00a3:
            r1.backgroundColor = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r10)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x00b4
            boolean r2 = r0.getBoolean(r10)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r2 = 0
            goto L_0x00b5
        L_0x00b4:
            r2 = 1
        L_0x00b5:
            r1.isPortrait = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r9)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x00c5
            boolean r2 = r0.getBoolean(r9)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x00c5
            r2 = 1
            goto L_0x00c6
        L_0x00c5:
            r2 = 0
        L_0x00c6:
            r1.isLandscape = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r8)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x00d3
            long r8 = r0.getLong(r8)     // Catch:{ JSONException -> 0x022e }
            goto L_0x00db
        L_0x00d3:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x022e }
            r10 = 172800000(0xa4cb800, double:8.53745436E-316)
            long r8 = r8 + r10
        L_0x00db:
            r1.timeToLive = r8     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r7)     // Catch:{ JSONException -> 0x022e }
            r8 = 0
            if (r2 == 0) goto L_0x00e9
            org.json.JSONObject r2 = r0.getJSONObject(r7)     // Catch:{ JSONException -> 0x022e }
            goto L_0x00ea
        L_0x00e9:
            r2 = r8
        L_0x00ea:
            java.lang.String r7 = "#000000"
            java.lang.String r9 = "color"
            java.lang.String r10 = "text"
            if (r2 == 0) goto L_0x010f
            boolean r11 = r2.has(r10)     // Catch:{ JSONException -> 0x022e }
            if (r11 == 0) goto L_0x00fd
            java.lang.String r11 = r2.getString(r10)     // Catch:{ JSONException -> 0x022e }
            goto L_0x00ff
        L_0x00fd:
            r11 = r19
        L_0x00ff:
            r1.title = r11     // Catch:{ JSONException -> 0x022e }
            boolean r11 = r2.has(r9)     // Catch:{ JSONException -> 0x022e }
            if (r11 == 0) goto L_0x010c
            java.lang.String r2 = r2.getString(r9)     // Catch:{ JSONException -> 0x022e }
            goto L_0x010d
        L_0x010c:
            r2 = r7
        L_0x010d:
            r1.titleColor = r2     // Catch:{ JSONException -> 0x022e }
        L_0x010f:
            boolean r2 = r0.has(r6)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x011a
            org.json.JSONObject r2 = r0.getJSONObject(r6)     // Catch:{ JSONException -> 0x022e }
            goto L_0x011b
        L_0x011a:
            r2 = r8
        L_0x011b:
            if (r2 == 0) goto L_0x0137
            boolean r6 = r2.has(r10)     // Catch:{ JSONException -> 0x022e }
            if (r6 == 0) goto L_0x0127
            java.lang.String r19 = r2.getString(r10)     // Catch:{ JSONException -> 0x022e }
        L_0x0127:
            r6 = r19
            r1.message = r6     // Catch:{ JSONException -> 0x022e }
            boolean r6 = r2.has(r9)     // Catch:{ JSONException -> 0x022e }
            if (r6 == 0) goto L_0x0135
            java.lang.String r7 = r2.getString(r9)     // Catch:{ JSONException -> 0x022e }
        L_0x0135:
            r1.messageColor = r7     // Catch:{ JSONException -> 0x022e }
        L_0x0137:
            boolean r2 = r0.has(r5)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0145
            boolean r2 = r0.getBoolean(r5)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0145
            r2 = 1
            goto L_0x0146
        L_0x0145:
            r2 = 0
        L_0x0146:
            r1.hideCloseButton = r2     // Catch:{ JSONException -> 0x022e }
            boolean r2 = r0.has(r4)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0153
            org.json.JSONObject r2 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0154
        L_0x0153:
            r2 = r8
        L_0x0154:
            if (r2 == 0) goto L_0x0166
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r4 = new com.clevertap.android.sdk.inapp.CTInAppNotificationMedia     // Catch:{ JSONException -> 0x022e }
            r4.<init>()     // Catch:{ JSONException -> 0x022e }
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = r4.initWithJSON(r2, r3)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0166
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r4 = r1.mediaList     // Catch:{ JSONException -> 0x022e }
            r4.add(r2)     // Catch:{ JSONException -> 0x022e }
        L_0x0166:
            r2 = r17
            boolean r4 = r0.has(r2)     // Catch:{ JSONException -> 0x022e }
            if (r4 == 0) goto L_0x0173
            org.json.JSONObject r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0174
        L_0x0173:
            r2 = r8
        L_0x0174:
            if (r2 == 0) goto L_0x0187
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r4 = new com.clevertap.android.sdk.inapp.CTInAppNotificationMedia     // Catch:{ JSONException -> 0x022e }
            r4.<init>()     // Catch:{ JSONException -> 0x022e }
            r5 = 2
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = r4.initWithJSON(r2, r5)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0187
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r4 = r1.mediaList     // Catch:{ JSONException -> 0x022e }
            r4.add(r2)     // Catch:{ JSONException -> 0x022e }
        L_0x0187:
            r2 = r16
            boolean r4 = r0.has(r2)     // Catch:{ JSONException -> 0x022e }
            if (r4 == 0) goto L_0x0194
            org.json.JSONArray r0 = r0.getJSONArray(r2)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0195
        L_0x0194:
            r0 = r8
        L_0x0195:
            if (r0 == 0) goto L_0x01bb
            r2 = 0
        L_0x0198:
            int r4 = r0.length()     // Catch:{ JSONException -> 0x022e }
            if (r2 >= r4) goto L_0x01bb
            com.clevertap.android.sdk.inapp.CTInAppNotificationButton r4 = new com.clevertap.android.sdk.inapp.CTInAppNotificationButton     // Catch:{ JSONException -> 0x022e }
            r4.<init>()     // Catch:{ JSONException -> 0x022e }
            org.json.JSONObject r5 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x022e }
            r4.initWithJSON(r5)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r5 = r4.error     // Catch:{ JSONException -> 0x022e }
            if (r5 != 0) goto L_0x01b8
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationButton> r5 = r1.buttons     // Catch:{ JSONException -> 0x022e }
            r5.add(r4)     // Catch:{ JSONException -> 0x022e }
            int r4 = r1.buttonCount     // Catch:{ JSONException -> 0x022e }
            int r4 = r4 + r3
            r1.buttonCount = r4     // Catch:{ JSONException -> 0x022e }
        L_0x01b8:
            int r2 = r2 + 1
            goto L_0x0198
        L_0x01bb:
            com.clevertap.android.sdk.inapp.CTInAppType r0 = r1.inAppType     // Catch:{ JSONException -> 0x022e }
            int r0 = r0.ordinal()     // Catch:{ JSONException -> 0x022e }
            switch(r0) {
                case 6: goto L_0x0202;
                case 7: goto L_0x01c4;
                case 8: goto L_0x0202;
                case 9: goto L_0x0202;
                case 10: goto L_0x0202;
                case 11: goto L_0x01c4;
                case 12: goto L_0x01c6;
                case 13: goto L_0x01c6;
                case 14: goto L_0x01c6;
                default: goto L_0x01c4;
            }     // Catch:{ JSONException -> 0x022e }
        L_0x01c4:
            goto L_0x0242
        L_0x01c6:
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r0 = r1.mediaList     // Catch:{ JSONException -> 0x022e }
            boolean r0 = r0.isEmpty()     // Catch:{ JSONException -> 0x022e }
            if (r0 != 0) goto L_0x01fd
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r0 = r1.mediaList     // Catch:{ JSONException -> 0x022e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x022e }
        L_0x01d4:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0242
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x022e }
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = (com.clevertap.android.sdk.inapp.CTInAppNotificationMedia) r2     // Catch:{ JSONException -> 0x022e }
            boolean r3 = r2.isGIF()     // Catch:{ JSONException -> 0x022e }
            if (r3 != 0) goto L_0x01f8
            boolean r3 = r2.isAudio()     // Catch:{ JSONException -> 0x022e }
            if (r3 != 0) goto L_0x01f8
            boolean r3 = r2.isVideo()     // Catch:{ JSONException -> 0x022e }
            if (r3 != 0) goto L_0x01f8
            boolean r2 = r2.isImage()     // Catch:{ JSONException -> 0x022e }
            if (r2 != 0) goto L_0x01d4
        L_0x01f8:
            java.lang.String r2 = "Wrong media type for template"
            r1.error = r2     // Catch:{ JSONException -> 0x022e }
            goto L_0x01d4
        L_0x01fd:
            java.lang.String r0 = "No media type for template"
            r1.error = r0     // Catch:{ JSONException -> 0x022e }
            goto L_0x0242
        L_0x0202:
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r0 = r1.mediaList     // Catch:{ JSONException -> 0x022e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x022e }
        L_0x0208:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0242
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x022e }
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = (com.clevertap.android.sdk.inapp.CTInAppNotificationMedia) r2     // Catch:{ JSONException -> 0x022e }
            boolean r3 = r2.isGIF()     // Catch:{ JSONException -> 0x022e }
            if (r3 != 0) goto L_0x0226
            boolean r3 = r2.isAudio()     // Catch:{ JSONException -> 0x022e }
            if (r3 != 0) goto L_0x0226
            boolean r3 = r2.isVideo()     // Catch:{ JSONException -> 0x022e }
            if (r3 == 0) goto L_0x0208
        L_0x0226:
            r2.mediaUrl = r8     // Catch:{ JSONException -> 0x022e }
            java.lang.String r2 = "Unable to download to media. Wrong media type for template"
            com.clevertap.android.sdk.Logger.d(r2)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0208
        L_0x022e:
            r0 = move-exception
            java.lang.String r2 = "Invalid JSON"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.error = r0
        L_0x0242:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotification.configureWithJson(org.json.JSONObject):void");
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getGifByteArray(CTInAppNotificationMedia cTInAppNotificationMedia) {
        return GifCache.getByteArray(cTInAppNotificationMedia.cacheKey);
    }

    public Bitmap getImage(CTInAppNotificationMedia cTInAppNotificationMedia) {
        return ImageCache.getBitmap(cTInAppNotificationMedia.cacheKey);
    }

    public CTInAppNotificationMedia getInAppMediaForOrientation(int i) {
        Iterator<CTInAppNotificationMedia> it = this.mediaList.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (i == next.orientation) {
                return next;
            }
        }
        return null;
    }

    public final boolean isKeyValid(Bundle bundle, String str, Class<?> cls) {
        return bundle.containsKey(str) && bundle.get(str).getClass().equals(cls);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fd A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0102 A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010d A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0112 A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012f A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0134 A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014a A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x014f A[Catch:{ JSONException -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0152 A[Catch:{ JSONException -> 0x0251 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void legacyConfigureWithJson(org.json.JSONObject r28) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            java.lang.String r3 = "mdc"
            java.lang.String r4 = "kv"
            java.lang.String r5 = "url"
            java.lang.String r6 = "wzrk_ttl"
            java.lang.String r7 = "isJsEnabled"
            java.lang.String r8 = "tdc"
            java.lang.String r9 = "tlc"
            java.lang.String r10 = "efc"
            java.lang.String r11 = "wzrk_id"
            java.lang.String r12 = "ti"
            java.lang.String r13 = "html"
            java.lang.String r14 = "sc"
            java.lang.String r15 = "dk"
            r16 = r3
            java.lang.String r3 = "w"
            r17 = r4
            java.lang.String r4 = "pos"
            r18 = r5
            java.lang.String r5 = "yp"
            r19 = r6
            java.lang.String r6 = "xp"
            r20 = r7
            java.lang.String r7 = "ydp"
            r21 = r8
            java.lang.String r8 = "xdp"
            r22 = r9
            java.lang.String r9 = "d"
            android.os.Bundle r0 = getBundleFromJsonObject(r28)
            r23 = r10
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r24 = r11
            java.lang.Class<java.lang.Boolean> r11 = java.lang.Boolean.class
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            r25 = r12
            android.os.Bundle r12 = r0.getBundle(r3)     // Catch:{ all -> 0x00ac }
            android.os.Bundle r0 = r0.getBundle(r9)     // Catch:{ all -> 0x00ac }
            if (r12 == 0) goto L_0x00b2
            if (r0 != 0) goto L_0x0057
            goto L_0x00b2
        L_0x0057:
            boolean r26 = r1.isKeyValid(r12, r8, r2)     // Catch:{ all -> 0x00ac }
            if (r26 != 0) goto L_0x0064
            boolean r26 = r1.isKeyValid(r12, r6, r2)     // Catch:{ all -> 0x00ac }
            if (r26 != 0) goto L_0x0064
            goto L_0x00b2
        L_0x0064:
            boolean r26 = r1.isKeyValid(r12, r7, r2)     // Catch:{ all -> 0x00ac }
            if (r26 != 0) goto L_0x0071
            boolean r2 = r1.isKeyValid(r12, r5, r2)     // Catch:{ all -> 0x00ac }
            if (r2 != 0) goto L_0x0071
            goto L_0x00b2
        L_0x0071:
            boolean r2 = r1.isKeyValid(r12, r15, r11)     // Catch:{ all -> 0x00ac }
            if (r2 != 0) goto L_0x0078
            goto L_0x00b2
        L_0x0078:
            boolean r2 = r1.isKeyValid(r12, r14, r11)     // Catch:{ all -> 0x00ac }
            if (r2 != 0) goto L_0x007f
            goto L_0x00b2
        L_0x007f:
            boolean r0 = r1.isKeyValid(r0, r13, r10)     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x0086
            goto L_0x00b2
        L_0x0086:
            boolean r0 = r1.isKeyValid(r12, r4, r10)     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x00b2
            java.lang.String r0 = r12.getString(r4)     // Catch:{ all -> 0x00ac }
            r2 = 0
            char r0 = r0.charAt(r2)     // Catch:{ all -> 0x00ac }
            r2 = 98
            if (r0 == r2) goto L_0x00aa
            r2 = 99
            if (r0 == r2) goto L_0x00aa
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 == r2) goto L_0x00aa
            r2 = 114(0x72, float:1.6E-43)
            if (r0 == r2) goto L_0x00aa
            r2 = 116(0x74, float:1.63E-43)
            if (r0 == r2) goto L_0x00aa
            goto L_0x00b2
        L_0x00aa:
            r2 = 1
            goto L_0x00b3
        L_0x00ac:
            r0 = move-exception
            java.lang.String r2 = "Failed to parse in-app notification!"
            com.clevertap.android.sdk.Logger.v(r2, r0)
        L_0x00b2:
            r2 = 0
        L_0x00b3:
            java.lang.String r0 = "Invalid JSON"
            if (r2 != 0) goto L_0x00ba
            r1.error = r0
            return
        L_0x00ba:
            r2 = r28
            r10 = r25
            boolean r11 = r2.has(r10)     // Catch:{ JSONException -> 0x0251 }
            java.lang.String r12 = ""
            if (r11 == 0) goto L_0x00cb
            java.lang.String r10 = r2.getString(r10)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x00cc
        L_0x00cb:
            r10 = r12
        L_0x00cc:
            r1.id = r10     // Catch:{ JSONException -> 0x0251 }
            r10 = r24
            boolean r11 = r2.has(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r11 == 0) goto L_0x00db
            java.lang.String r10 = r2.getString(r10)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x00dc
        L_0x00db:
            r10 = r12
        L_0x00dc:
            r1.campaignId = r10     // Catch:{ JSONException -> 0x0251 }
            r10 = r23
            boolean r11 = r2.has(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r11 == 0) goto L_0x00ef
            int r10 = r2.getInt(r10)     // Catch:{ JSONException -> 0x0251 }
            r11 = 1
            if (r10 != r11) goto L_0x00f0
            r10 = 1
            goto L_0x00f1
        L_0x00ef:
            r11 = 1
        L_0x00f0:
            r10 = 0
        L_0x00f1:
            r1.excludeFromCaps = r10     // Catch:{ JSONException -> 0x0251 }
            r10 = r22
            boolean r22 = r2.has(r10)     // Catch:{ JSONException -> 0x0251 }
            r23 = -1
            if (r22 == 0) goto L_0x0102
            int r10 = r2.getInt(r10)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0103
        L_0x0102:
            r10 = -1
        L_0x0103:
            r1.totalLifetimeCount = r10     // Catch:{ JSONException -> 0x0251 }
            r10 = r21
            boolean r21 = r2.has(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r21 == 0) goto L_0x0112
            int r10 = r2.getInt(r10)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0113
        L_0x0112:
            r10 = -1
        L_0x0113:
            r1.totalDailyCount = r10     // Catch:{ JSONException -> 0x0251 }
            r10 = r20
            boolean r20 = r2.has(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r20 == 0) goto L_0x0124
            boolean r10 = r2.getBoolean(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r10 == 0) goto L_0x0124
            goto L_0x0125
        L_0x0124:
            r11 = 0
        L_0x0125:
            r1.jsEnabled = r11     // Catch:{ JSONException -> 0x0251 }
            r10 = r19
            boolean r11 = r2.has(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r11 == 0) goto L_0x0134
            long r10 = r2.getLong(r10)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0141
        L_0x0134:
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0251 }
            r19 = 172800000(0xa4cb800, double:8.53745436E-316)
            long r10 = r10 + r19
            r19 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 / r19
        L_0x0141:
            r1.timeToLive = r10     // Catch:{ JSONException -> 0x0251 }
            boolean r10 = r2.has(r9)     // Catch:{ JSONException -> 0x0251 }
            r11 = 0
            if (r10 == 0) goto L_0x014f
            org.json.JSONObject r9 = r2.getJSONObject(r9)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0150
        L_0x014f:
            r9 = r11
        L_0x0150:
            if (r9 == 0) goto L_0x0253
            java.lang.String r10 = r9.getString(r13)     // Catch:{ JSONException -> 0x0251 }
            r1.html = r10     // Catch:{ JSONException -> 0x0251 }
            r10 = r18
            boolean r13 = r9.has(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r13 == 0) goto L_0x0164
            java.lang.String r12 = r9.getString(r10)     // Catch:{ JSONException -> 0x0251 }
        L_0x0164:
            r1.customInAppUrl = r12     // Catch:{ JSONException -> 0x0251 }
            r10 = r17
            boolean r12 = r9.has(r10)     // Catch:{ JSONException -> 0x0251 }
            if (r12 == 0) goto L_0x0172
            org.json.JSONObject r11 = r9.getJSONObject(r10)     // Catch:{ JSONException -> 0x0251 }
        L_0x0172:
            r1.customExtras = r11     // Catch:{ JSONException -> 0x0251 }
            if (r11 != 0) goto L_0x017d
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0251 }
            r9.<init>()     // Catch:{ JSONException -> 0x0251 }
            r1.customExtras = r9     // Catch:{ JSONException -> 0x0251 }
        L_0x017d:
            org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch:{ JSONException -> 0x0251 }
            if (r2 == 0) goto L_0x01e4
            boolean r3 = r2.getBoolean(r15)     // Catch:{ JSONException -> 0x0251 }
            r1.darkenScreen = r3     // Catch:{ JSONException -> 0x0251 }
            boolean r3 = r2.getBoolean(r14)     // Catch:{ JSONException -> 0x0251 }
            r1.showClose = r3     // Catch:{ JSONException -> 0x0251 }
            java.lang.String r3 = r2.getString(r4)     // Catch:{ JSONException -> 0x0251 }
            r4 = 0
            char r3 = r3.charAt(r4)     // Catch:{ JSONException -> 0x0251 }
            r1.position = r3     // Catch:{ JSONException -> 0x0251 }
            boolean r3 = r2.has(r8)     // Catch:{ JSONException -> 0x0251 }
            if (r3 == 0) goto L_0x01a5
            int r3 = r2.getInt(r8)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x01a6
        L_0x01a5:
            r3 = 0
        L_0x01a6:
            r1.width = r3     // Catch:{ JSONException -> 0x0251 }
            boolean r3 = r2.has(r6)     // Catch:{ JSONException -> 0x0251 }
            if (r3 == 0) goto L_0x01b3
            int r3 = r2.getInt(r6)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x01b4
        L_0x01b3:
            r3 = 0
        L_0x01b4:
            r1.widthPercentage = r3     // Catch:{ JSONException -> 0x0251 }
            boolean r3 = r2.has(r7)     // Catch:{ JSONException -> 0x0251 }
            if (r3 == 0) goto L_0x01c1
            int r3 = r2.getInt(r7)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            r1.height = r3     // Catch:{ JSONException -> 0x0251 }
            boolean r3 = r2.has(r5)     // Catch:{ JSONException -> 0x0251 }
            if (r3 == 0) goto L_0x01cf
            int r12 = r2.getInt(r5)     // Catch:{ JSONException -> 0x0251 }
            goto L_0x01d0
        L_0x01cf:
            r12 = 0
        L_0x01d0:
            r1.heightPercentage = r12     // Catch:{ JSONException -> 0x0251 }
            r3 = r16
            boolean r4 = r2.has(r3)     // Catch:{ JSONException -> 0x0251 }
            if (r4 == 0) goto L_0x01e1
            int r23 = r2.getInt(r3)     // Catch:{ JSONException -> 0x0251 }
            r2 = r23
            goto L_0x01e2
        L_0x01e1:
            r2 = -1
        L_0x01e2:
            r1.maxPerSession = r2     // Catch:{ JSONException -> 0x0251 }
        L_0x01e4:
            java.lang.String r2 = r1.html     // Catch:{ JSONException -> 0x0251 }
            if (r2 == 0) goto L_0x0253
            char r2 = r1.position     // Catch:{ JSONException -> 0x0251 }
            r3 = 100
            r4 = 30
            r5 = 116(0x74, float:1.63E-43)
            if (r2 != r5) goto L_0x01ff
            int r2 = r1.widthPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 != r3) goto L_0x01ff
            int r2 = r1.heightPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 > r4) goto L_0x01ff
            com.clevertap.android.sdk.inapp.CTInAppType r2 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHeaderHTML     // Catch:{ JSONException -> 0x0251 }
            r1.inAppType = r2     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0253
        L_0x01ff:
            char r2 = r1.position     // Catch:{ JSONException -> 0x0251 }
            r5 = 98
            if (r2 != r5) goto L_0x0212
            int r2 = r1.widthPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 != r3) goto L_0x0212
            int r2 = r1.heightPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 > r4) goto L_0x0212
            com.clevertap.android.sdk.inapp.CTInAppType r2 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeFooterHTML     // Catch:{ JSONException -> 0x0251 }
            r1.inAppType = r2     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0253
        L_0x0212:
            char r2 = r1.position     // Catch:{ JSONException -> 0x0251 }
            r4 = 90
            r5 = 99
            if (r2 != r5) goto L_0x0229
            int r2 = r1.widthPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 != r4) goto L_0x0229
            int r2 = r1.heightPercentage     // Catch:{ JSONException -> 0x0251 }
            r5 = 85
            if (r2 != r5) goto L_0x0229
            com.clevertap.android.sdk.inapp.CTInAppType r2 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitialHTML     // Catch:{ JSONException -> 0x0251 }
            r1.inAppType = r2     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0253
        L_0x0229:
            char r2 = r1.position     // Catch:{ JSONException -> 0x0251 }
            r5 = 99
            if (r2 != r5) goto L_0x023c
            int r2 = r1.widthPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 != r3) goto L_0x023c
            int r2 = r1.heightPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 != r3) goto L_0x023c
            com.clevertap.android.sdk.inapp.CTInAppType r2 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCoverHTML     // Catch:{ JSONException -> 0x0251 }
            r1.inAppType = r2     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0253
        L_0x023c:
            char r2 = r1.position     // Catch:{ JSONException -> 0x0251 }
            r3 = 99
            if (r2 != r3) goto L_0x0253
            int r2 = r1.widthPercentage     // Catch:{ JSONException -> 0x0251 }
            if (r2 != r4) goto L_0x0253
            int r2 = r1.heightPercentage     // Catch:{ JSONException -> 0x0251 }
            r3 = 50
            if (r2 != r3) goto L_0x0253
            com.clevertap.android.sdk.inapp.CTInAppType r2 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitialHTML     // Catch:{ JSONException -> 0x0251 }
            r1.inAppType = r2     // Catch:{ JSONException -> 0x0251 }
            goto L_0x0253
        L_0x0251:
            r1.error = r0
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotification.legacyConfigureWithJson(org.json.JSONObject):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.campaignId);
        parcel.writeValue(this.inAppType);
        parcel.writeString(this.html);
        parcel.writeByte(this.excludeFromCaps ? (byte) 1 : 0);
        parcel.writeByte(this.showClose ? (byte) 1 : 0);
        parcel.writeByte(this.darkenScreen ? (byte) 1 : 0);
        parcel.writeInt(this.maxPerSession);
        parcel.writeInt(this.totalLifetimeCount);
        parcel.writeInt(this.totalDailyCount);
        parcel.writeValue(Character.valueOf(this.position));
        parcel.writeInt(this.height);
        parcel.writeInt(this.heightPercentage);
        parcel.writeInt(this.width);
        parcel.writeInt(this.widthPercentage);
        if (this.jsonDescription == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.jsonDescription.toString());
        }
        parcel.writeString(this.error);
        if (this.customExtras == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.customExtras.toString());
        }
        if (this.actionExtras == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.actionExtras.toString());
        }
        parcel.writeString(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.titleColor);
        parcel.writeString(this.backgroundColor);
        parcel.writeString(this.message);
        parcel.writeString(this.messageColor);
        parcel.writeTypedList(this.buttons);
        parcel.writeTypedList(this.mediaList);
        parcel.writeByte(this.hideCloseButton ? (byte) 1 : 0);
        parcel.writeInt(this.buttonCount);
        parcel.writeByte(this.isTablet ? (byte) 1 : 0);
        parcel.writeString(this.customInAppUrl);
        parcel.writeByte(this.jsEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.isPortrait ? (byte) 1 : 0);
        parcel.writeByte(this.isLandscape ? (byte) 1 : 0);
        parcel.writeString(this.landscapeImageUrl);
        parcel.writeString(this._landscapeImageCacheKey);
        parcel.writeLong(this.timeToLive);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(31:1|2|(1:4)(1:5)|6|(1:8)(1:9)|10|(1:12)(1:13)|14|(1:16)(1:17)|18|(1:20)(1:21)|22|(1:24)(1:25)|26|27|28|29|30|31|32|(1:34)(1:35)|36|(1:38)(1:39)|40|(1:42)(1:43)|44|(1:46)(1:47)|48|(1:50)|51|53) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00fb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0103 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0109 A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010b A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011a A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011c A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012b A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012d A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0136 A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0138 A[Catch:{ JSONException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0141 A[Catch:{ JSONException -> 0x0156 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CTInAppNotification(android.os.Parcel r5, com.clevertap.android.sdk.inapp.CTInAppNotification.AnonymousClass1 r6) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.buttons = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.mediaList = r6
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.id = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.campaignId = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.Class<com.clevertap.android.sdk.inapp.CTInAppType> r6 = com.clevertap.android.sdk.inapp.CTInAppType.class
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ JSONException -> 0x0156 }
            java.lang.Object r6 = r5.readValue(r6)     // Catch:{ JSONException -> 0x0156 }
            com.clevertap.android.sdk.inapp.CTInAppType r6 = (com.clevertap.android.sdk.inapp.CTInAppType) r6     // Catch:{ JSONException -> 0x0156 }
            r4.inAppType = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.html = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r4.excludeFromCaps = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 == 0) goto L_0x0046
            r6 = 1
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            r4.showClose = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 == 0) goto L_0x0051
            r6 = 1
            goto L_0x0052
        L_0x0051:
            r6 = 0
        L_0x0052:
            r4.darkenScreen = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.maxPerSession = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.totalLifetimeCount = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.totalDailyCount = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.Class r6 = java.lang.Character.TYPE     // Catch:{ JSONException -> 0x0156 }
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ JSONException -> 0x0156 }
            java.lang.Object r6 = r5.readValue(r6)     // Catch:{ JSONException -> 0x0156 }
            java.lang.Character r6 = (java.lang.Character) r6     // Catch:{ JSONException -> 0x0156 }
            char r6 = r6.charValue()     // Catch:{ JSONException -> 0x0156 }
            r4.position = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.height = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.heightPercentage = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.width = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.widthPercentage = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            r2 = 0
            if (r6 != 0) goto L_0x0099
            r6 = r2
            goto L_0x00a2
        L_0x0099:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r3 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r6.<init>(r3)     // Catch:{ JSONException -> 0x0156 }
        L_0x00a2:
            r4.jsonDescription = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.error = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 != 0) goto L_0x00b2
            r6 = r2
            goto L_0x00bb
        L_0x00b2:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r3 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r6.<init>(r3)     // Catch:{ JSONException -> 0x0156 }
        L_0x00bb:
            r4.customExtras = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 != 0) goto L_0x00c4
            goto L_0x00cd
        L_0x00c4:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r2.<init>(r6)     // Catch:{ JSONException -> 0x0156 }
        L_0x00cd:
            r4.actionExtras = r2     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.type = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.title = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.titleColor = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.backgroundColor = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.message = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.messageColor = r6     // Catch:{ JSONException -> 0x0156 }
            android.os.Parcelable$Creator<com.clevertap.android.sdk.inapp.CTInAppNotificationButton> r6 = com.clevertap.android.sdk.inapp.CTInAppNotificationButton.CREATOR     // Catch:{ all -> 0x00fb }
            java.util.ArrayList r6 = r5.createTypedArrayList(r6)     // Catch:{ all -> 0x00fb }
            r4.buttons = r6     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            android.os.Parcelable$Creator<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r6 = com.clevertap.android.sdk.inapp.CTInAppNotificationMedia.CREATOR     // Catch:{ all -> 0x0103 }
            java.util.ArrayList r6 = r5.createTypedArrayList(r6)     // Catch:{ all -> 0x0103 }
            r4.mediaList = r6     // Catch:{ all -> 0x0103 }
        L_0x0103:
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 == 0) goto L_0x010b
            r6 = 1
            goto L_0x010c
        L_0x010b:
            r6 = 0
        L_0x010c:
            r4.hideCloseButton = r6     // Catch:{ JSONException -> 0x0156 }
            int r6 = r5.readInt()     // Catch:{ JSONException -> 0x0156 }
            r4.buttonCount = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 == 0) goto L_0x011c
            r6 = 1
            goto L_0x011d
        L_0x011c:
            r6 = 0
        L_0x011d:
            r4.isTablet = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.customInAppUrl = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 == 0) goto L_0x012d
            r6 = 1
            goto L_0x012e
        L_0x012d:
            r6 = 0
        L_0x012e:
            r4.jsEnabled = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 == 0) goto L_0x0138
            r6 = 1
            goto L_0x0139
        L_0x0138:
            r6 = 0
        L_0x0139:
            r4.isPortrait = r6     // Catch:{ JSONException -> 0x0156 }
            byte r6 = r5.readByte()     // Catch:{ JSONException -> 0x0156 }
            if (r6 == 0) goto L_0x0142
            r0 = 1
        L_0x0142:
            r4.isLandscape = r0     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4.landscapeImageUrl = r6     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r6 = r5.readString()     // Catch:{ JSONException -> 0x0156 }
            r4._landscapeImageCacheKey = r6     // Catch:{ JSONException -> 0x0156 }
            long r5 = r5.readLong()     // Catch:{ JSONException -> 0x0156 }
            r4.timeToLive = r5     // Catch:{ JSONException -> 0x0156 }
        L_0x0156:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotification.<init>(android.os.Parcel, com.clevertap.android.sdk.inapp.CTInAppNotification$1):void");
    }
}
