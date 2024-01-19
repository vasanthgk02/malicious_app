package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.core.app.NotificationManagerCompat;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.events.EventDetail;
import com.mpl.androidapp.utils.Constant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalDataStore {
    public static long EXECUTOR_THREAD_ID;
    public final HashMap<String, Integer> PROFILE_EXPIRY_MAP = new HashMap<>();
    public final HashMap<String, Object> PROFILE_FIELDS_IN_THIS_SESSION = new HashMap<>();
    public final CleverTapInstanceConfig config;
    public final Context context;
    public DBAdapter dbAdapter;
    public final ExecutorService es;

    public LocalDataStore(final Context context2, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.es = Executors.newFixedThreadPool(1);
        final String str = this.config.accountId;
        postAsyncSafely("LocalDataStore#inflateLocalProfileAsync", new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|(5:16|17|(2:19|33)(2:20|(2:22|34)(2:23|35))|32|13)|24|25|26|27|28) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x008a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    com.clevertap.android.sdk.LocalDataStore r0 = com.clevertap.android.sdk.LocalDataStore.this
                    com.clevertap.android.sdk.db.DBAdapter r1 = r0.dbAdapter
                    if (r1 != 0) goto L_0x0013
                    com.clevertap.android.sdk.db.DBAdapter r1 = new com.clevertap.android.sdk.db.DBAdapter
                    android.content.Context r2 = r2
                    com.clevertap.android.sdk.LocalDataStore r3 = com.clevertap.android.sdk.LocalDataStore.this
                    com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r3.config
                    r1.<init>(r2, r3)
                    r0.dbAdapter = r1
                L_0x0013:
                    com.clevertap.android.sdk.LocalDataStore r0 = com.clevertap.android.sdk.LocalDataStore.this
                    java.util.HashMap<java.lang.String, java.lang.Object> r0 = r0.PROFILE_FIELDS_IN_THIS_SESSION
                    monitor-enter(r0)
                    com.clevertap.android.sdk.LocalDataStore r1 = com.clevertap.android.sdk.LocalDataStore.this     // Catch:{ all -> 0x008a }
                    com.clevertap.android.sdk.db.DBAdapter r1 = r1.dbAdapter     // Catch:{ all -> 0x008a }
                    java.lang.String r2 = r3     // Catch:{ all -> 0x008a }
                    org.json.JSONObject r1 = r1.fetchUserProfileById(r2)     // Catch:{ all -> 0x008a }
                    if (r1 != 0) goto L_0x0026
                    monitor-exit(r0)     // Catch:{ all -> 0x008c }
                    return
                L_0x0026:
                    java.util.Iterator r2 = r1.keys()     // Catch:{ all -> 0x008a }
                L_0x002a:
                    boolean r3 = r2.hasNext()     // Catch:{ all -> 0x008a }
                    if (r3 == 0) goto L_0x0062
                    java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x002a }
                    java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x002a }
                    java.lang.Object r4 = r1.get(r3)     // Catch:{ JSONException -> 0x002a }
                    boolean r5 = r4 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x002a }
                    if (r5 == 0) goto L_0x004a
                    org.json.JSONObject r4 = r1.getJSONObject(r3)     // Catch:{ JSONException -> 0x002a }
                    com.clevertap.android.sdk.LocalDataStore r5 = com.clevertap.android.sdk.LocalDataStore.this     // Catch:{ JSONException -> 0x002a }
                    java.util.HashMap<java.lang.String, java.lang.Object> r5 = r5.PROFILE_FIELDS_IN_THIS_SESSION     // Catch:{ JSONException -> 0x002a }
                    r5.put(r3, r4)     // Catch:{ JSONException -> 0x002a }
                    goto L_0x002a
                L_0x004a:
                    boolean r5 = r4 instanceof org.json.JSONArray     // Catch:{ JSONException -> 0x002a }
                    if (r5 == 0) goto L_0x005a
                    org.json.JSONArray r4 = r1.getJSONArray(r3)     // Catch:{ JSONException -> 0x002a }
                    com.clevertap.android.sdk.LocalDataStore r5 = com.clevertap.android.sdk.LocalDataStore.this     // Catch:{ JSONException -> 0x002a }
                    java.util.HashMap<java.lang.String, java.lang.Object> r5 = r5.PROFILE_FIELDS_IN_THIS_SESSION     // Catch:{ JSONException -> 0x002a }
                    r5.put(r3, r4)     // Catch:{ JSONException -> 0x002a }
                    goto L_0x002a
                L_0x005a:
                    com.clevertap.android.sdk.LocalDataStore r5 = com.clevertap.android.sdk.LocalDataStore.this     // Catch:{ JSONException -> 0x002a }
                    java.util.HashMap<java.lang.String, java.lang.Object> r5 = r5.PROFILE_FIELDS_IN_THIS_SESSION     // Catch:{ JSONException -> 0x002a }
                    r5.put(r3, r4)     // Catch:{ JSONException -> 0x002a }
                    goto L_0x002a
                L_0x0062:
                    com.clevertap.android.sdk.LocalDataStore r1 = com.clevertap.android.sdk.LocalDataStore.this     // Catch:{ all -> 0x008a }
                    com.clevertap.android.sdk.Logger r1 = r1.getConfigLogger()     // Catch:{ all -> 0x008a }
                    com.clevertap.android.sdk.LocalDataStore r2 = com.clevertap.android.sdk.LocalDataStore.this     // Catch:{ all -> 0x008a }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r2.config     // Catch:{ all -> 0x008a }
                    java.lang.String r2 = r2.accountId     // Catch:{ all -> 0x008a }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
                    r3.<init>()     // Catch:{ all -> 0x008a }
                    java.lang.String r4 = "Local Data Store - Inflated local profile "
                    r3.append(r4)     // Catch:{ all -> 0x008a }
                    com.clevertap.android.sdk.LocalDataStore r4 = com.clevertap.android.sdk.LocalDataStore.this     // Catch:{ all -> 0x008a }
                    java.util.HashMap<java.lang.String, java.lang.Object> r4 = r4.PROFILE_FIELDS_IN_THIS_SESSION     // Catch:{ all -> 0x008a }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008a }
                    r3.append(r4)     // Catch:{ all -> 0x008a }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008a }
                    r1.verbose(r2, r3)     // Catch:{ all -> 0x008a }
                L_0x008a:
                    monitor-exit(r0)     // Catch:{ all -> 0x008c }
                    return
                L_0x008c:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x008c }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.LocalDataStore.AnonymousClass1.run():void");
            }
        });
    }

    public final void _removeProfileField(String str) {
        synchronized (this.PROFILE_FIELDS_IN_THIS_SESSION) {
            try {
                this.PROFILE_FIELDS_IN_THIS_SESSION.remove(str);
            } catch (Throwable th) {
                Logger configLogger = getConfigLogger();
                String str2 = this.config.accountId;
                configLogger.verbose(str2, "Failed to remove local profile value for key " + str, th);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:14|15|16|17|19|20|21|22|23|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void changeUser() {
        /*
            r7 = this;
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r7.PROFILE_EXPIRY_MAP
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r7.PROFILE_EXPIRY_MAP     // Catch:{ all -> 0x006c }
            r1.clear()     // Catch:{ all -> 0x006c }
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r7.PROFILE_FIELDS_IN_THIS_SESSION
            monitor-enter(r1)
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r7.PROFILE_FIELDS_IN_THIS_SESSION     // Catch:{ all -> 0x0069 }
            r0.clear()     // Catch:{ all -> 0x0069 }
            monitor-exit(r1)     // Catch:{ all -> 0x0069 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r7.config
            java.lang.String r0 = r0.accountId
            com.clevertap.android.sdk.db.DBAdapter r1 = r7.dbAdapter
            monitor-enter(r1)
            if (r0 != 0) goto L_0x001d
            monitor-exit(r1)
            goto L_0x005f
        L_0x001d:
            com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.USER_PROFILES     // Catch:{ all -> 0x0066 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0066 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r3 = r1.dbHelper     // Catch:{ SQLiteException -> 0x0037 }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String r4 = "_id = ?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0037 }
            r6 = 0
            r5[r6] = r0     // Catch:{ SQLiteException -> 0x0037 }
            r3.delete(r2, r4, r5)     // Catch:{ SQLiteException -> 0x0037 }
            goto L_0x0059
        L_0x0035:
            r0 = move-exception
            goto L_0x0060
        L_0x0037:
            com.clevertap.android.sdk.Logger r0 = r1.getConfigLogger()     // Catch:{ all -> 0x0035 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r4 = "Error removing user profile from "
            r3.append(r4)     // Catch:{ all -> 0x0035 }
            r3.append(r2)     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = " Recreating DB"
            r3.append(r2)     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0035 }
            r0.verbose(r2)     // Catch:{ all -> 0x0035 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r1.dbHelper     // Catch:{ all -> 0x0035 }
            r0.deleteDatabase()     // Catch:{ all -> 0x0035 }
        L_0x0059:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r1.dbHelper     // Catch:{ all -> 0x0066 }
            r0.close()     // Catch:{ all -> 0x0066 }
            monitor-exit(r1)
        L_0x005f:
            return
        L_0x0060:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r1.dbHelper     // Catch:{ all -> 0x0066 }
            r2.close()     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0069:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0069 }
            throw r0
        L_0x006c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.LocalDataStore.changeUser():void");
    }

    public final EventDetail decodeEventDetails(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String[] split = str2.split("\\|");
        return new EventDetail(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), str);
    }

    public final String encodeEventDetails(int i, int i2, int i3) {
        return i3 + "|" + i + "|" + i2;
    }

    public final Logger getConfigLogger() {
        return this.config.getLogger();
    }

    public EventDetail getEventDetail(String str) {
        String str2;
        try {
            if (!this.config.personalization) {
                return null;
            }
            if (!this.config.isDefaultInstance) {
                str2 = "local_events:" + this.config.accountId;
            } else {
                str2 = "local_events";
            }
            return decodeEventDetails(str, getStringFromPrefs(str, null, str2));
        } catch (Throwable th) {
            getConfigLogger().verbose(this.config.accountId, "Failed to retrieve local event detail", th);
            return null;
        }
    }

    public final int getIntFromPrefs(String str, int i) {
        if (!this.config.isDefaultInstance) {
            return k.getInt(this.context, storageKeyWithSuffix(str), i);
        }
        int i2 = k.getInt(this.context, storageKeyWithSuffix(str), NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        if (i2 == -1000) {
            i2 = k.getInt(this.context, str, i);
        }
        return i2;
    }

    public Object getProfileValueForKey(String str) {
        Object obj = null;
        if (str != null) {
            synchronized (this.PROFILE_FIELDS_IN_THIS_SESSION) {
                try {
                    obj = this.PROFILE_FIELDS_IN_THIS_SESSION.get(str);
                } catch (Throwable th) {
                    getConfigLogger().verbose(this.config.accountId, "Failed to retrieve local profile property", th);
                }
            }
        }
        return obj;
    }

    public final String getStringFromPrefs(String str, String str2, String str3) {
        if (!this.config.isDefaultInstance) {
            return k.getString(this.context, str3, storageKeyWithSuffix(str), str2);
        }
        String string = k.getString(this.context, str3, storageKeyWithSuffix(str), str2);
        if (string == null) {
            string = k.getString(this.context, str3, str, str2);
        }
        return string;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void persistEvent(Context context2, JSONObject jSONObject) {
        String str;
        try {
            String string = jSONObject.getString("evtName");
            if (string != null) {
                if (!this.config.isDefaultInstance) {
                    str = "local_events:" + this.config.accountId;
                } else {
                    str = "local_events";
                }
                SharedPreferences preferences = k.getPreferences(context2, str);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                EventDetail decodeEventDetails = decodeEventDetails(string, getStringFromPrefs(string, encodeEventDetails(currentTimeMillis, currentTimeMillis, 0), str));
                String encodeEventDetails = encodeEventDetails(decodeEventDetails.getFirstTime(), currentTimeMillis, decodeEventDetails.getCount() + 1);
                Editor edit = preferences.edit();
                edit.putString(storageKeyWithSuffix(string), encodeEventDetails);
                k.persist(edit);
            }
        } catch (Throwable th) {
            getConfigLogger().verbose(this.config.accountId, "Failed to persist event locally", th);
        }
    }

    public final void persistLocalProfileAsync() {
        final String str = this.config.accountId;
        postAsyncSafely("LocalDataStore#persistLocalProfileAsync", new Runnable() {
            public void run() {
                synchronized (LocalDataStore.this.PROFILE_FIELDS_IN_THIS_SESSION) {
                    long storeUserProfile = LocalDataStore.this.dbAdapter.storeUserProfile(str, new JSONObject(LocalDataStore.this.PROFILE_FIELDS_IN_THIS_SESSION));
                    Logger configLogger = LocalDataStore.this.getConfigLogger();
                    String str = LocalDataStore.this.config.accountId;
                    configLogger.verbose(str, "Persist Local Profile complete with status " + storeUserProfile + " for id " + str);
                }
            }
        });
    }

    public final void postAsyncSafely(final String str, final Runnable runnable) {
        try {
            if (Thread.currentThread().getId() == EXECUTOR_THREAD_ID) {
                runnable.run();
            } else {
                this.es.submit(new Runnable() {
                    public void run() {
                        LocalDataStore.EXECUTOR_THREAD_ID = Thread.currentThread().getId();
                        try {
                            Logger configLogger = LocalDataStore.this.getConfigLogger();
                            String str = LocalDataStore.this.config.accountId;
                            configLogger.verbose(str, "Local Data Store Executor service: Starting task - " + str);
                            runnable.run();
                        } catch (Throwable th) {
                            LocalDataStore.this.getConfigLogger().verbose(LocalDataStore.this.config.accountId, "Executor service: Failed to complete the scheduled task", th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            getConfigLogger().verbose(this.config.accountId, "Failed to submit task to the executor service", th);
        }
    }

    public final void removeProfileField(String str, Boolean bool, boolean z) {
        if (str != null) {
            try {
                _removeProfileField(str);
                if (!bool.booleanValue()) {
                    updateLocalProfileKeyExpiryTime(str);
                }
            } catch (Throwable unused) {
            }
            if (z) {
                persistLocalProfileAsync();
            }
        }
    }

    public void setDataSyncFlag(JSONObject jSONObject) {
        try {
            if (!this.config.personalization) {
                jSONObject.put("dsync", false);
                return;
            }
            String string = jSONObject.getString("type");
            if ("event".equals(string) && "App Launched".equals(jSONObject.getString("evtName"))) {
                getConfigLogger().verbose(this.config.accountId, (String) "Local cache needs to be updated (triggered by App Launched)");
                jSONObject.put("dsync", true);
            } else if (Constant.PROFILE.equals(string)) {
                jSONObject.put("dsync", true);
                getConfigLogger().verbose(this.config.accountId, (String) "Local cache needs to be updated (profile event)");
            } else {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (getIntFromPrefs("local_cache_last_update", currentTimeMillis) + getIntFromPrefs("local_cache_expires_in", 1200) < currentTimeMillis) {
                    jSONObject.put("dsync", true);
                    getConfigLogger().verbose(this.config.accountId, (String) "Local cache needs to be updated");
                } else {
                    jSONObject.put("dsync", false);
                    getConfigLogger().verbose(this.config.accountId, (String) "Local cache doesn't need to be updated");
                }
            }
        } catch (Throwable th) {
            getConfigLogger().verbose(this.config.accountId, "Failed to sync with upstream", th);
        }
    }

    public final void setProfileField(String str, Object obj, Boolean bool, boolean z) {
        if (str != null && obj != null) {
            try {
                synchronized (this.PROFILE_FIELDS_IN_THIS_SESSION) {
                    this.PROFILE_FIELDS_IN_THIS_SESSION.put(str, obj);
                }
                if (!bool.booleanValue()) {
                    updateLocalProfileKeyExpiryTime(str);
                }
            } catch (Throwable unused) {
            }
            if (z) {
                persistLocalProfileAsync();
            }
        }
    }

    public final void setProfileFields(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    setProfileField(obj, jSONObject.get(obj), bool, false);
                }
                persistLocalProfileAsync();
            } catch (Throwable th) {
                getConfigLogger().verbose(this.config.accountId, "Failed to set profile fields", th);
            }
        }
    }

    public final String storageKeyWithSuffix(String str) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, ":");
        outline78.append(this.config.accountId);
        return outline78.toString();
    }

    public final JSONObject syncEventsFromUpstream(Context context2, JSONObject jSONObject) {
        String str;
        String str2;
        try {
            if (!this.config.isDefaultInstance) {
                str = "local_events:" + this.config.accountId;
            } else {
                str = "local_events";
            }
            String str3 = str;
            SharedPreferences preferences = k.getPreferences(context2, str3);
            Iterator<String> keys = jSONObject.keys();
            Editor edit = preferences.edit();
            JSONObject jSONObject2 = null;
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                EventDetail decodeEventDetails = decodeEventDetails(obj, getStringFromPrefs(obj, encodeEventDetails(0, 0, 0), str3));
                JSONArray jSONArray = jSONObject.getJSONArray(obj);
                if (jSONArray == null || jSONArray.length() < 3) {
                    str2 = str3;
                    getConfigLogger().verbose(this.config.accountId, (String) "Corrupted upstream event detail");
                } else {
                    try {
                        int i = jSONArray.getInt(0);
                        int i2 = jSONArray.getInt(1);
                        int i3 = jSONArray.getInt(2);
                        if (i > decodeEventDetails.getCount()) {
                            edit.putString(storageKeyWithSuffix(obj), encodeEventDetails(i2, i3, i));
                            Logger configLogger = getConfigLogger();
                            String str4 = this.config.accountId;
                            StringBuilder sb = new StringBuilder();
                            str2 = str3;
                            sb.append("Accepted update for event ");
                            sb.append(obj);
                            sb.append(" from upstream");
                            configLogger.verbose(str4, sb.toString());
                            if (jSONObject2 == null) {
                                jSONObject2 = new JSONObject();
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("oldValue", decodeEventDetails.getCount());
                            jSONObject4.put("newValue", i);
                            jSONObject3.put("count", jSONObject4);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("oldValue", decodeEventDetails.getFirstTime());
                            jSONObject5.put("newValue", jSONArray.getInt(1));
                            jSONObject3.put("firstTime", jSONObject5);
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("oldValue", decodeEventDetails.getLastTime());
                            jSONObject6.put("newValue", jSONArray.getInt(2));
                            jSONObject3.put("lastTime", jSONObject6);
                            jSONObject2.put(obj, jSONObject3);
                        } else {
                            str2 = str3;
                            getConfigLogger().verbose(this.config.accountId, "Rejected update for event " + obj + " from upstream");
                        }
                    } catch (Throwable unused) {
                        str2 = str3;
                        getConfigLogger().verbose(this.config.accountId, "Failed to parse upstream event message: " + jSONArray.toString());
                    }
                }
                str3 = str2;
            }
            k.persist(edit);
            return jSONObject2;
        } catch (Throwable th) {
            getConfigLogger().verbose(this.config.accountId, "Couldn't sync events from upstream", th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[Catch:{ all -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083 A[Catch:{ all -> 0x0127 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject syncProfile(org.json.JSONObject r15) {
        /*
            r14 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            int r1 = r15.length()
            if (r1 > 0) goto L_0x000c
            return r0
        L_0x000c:
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0143 }
            r2.<init>()     // Catch:{ all -> 0x0143 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0143 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            int r4 = (int) r3     // Catch:{ all -> 0x0143 }
            java.util.Iterator r3 = r15.keys()     // Catch:{ all -> 0x0143 }
        L_0x001e:
            boolean r7 = r3.hasNext()     // Catch:{ all -> 0x0143 }
            if (r7 == 0) goto L_0x0137
            java.lang.Object r7 = r3.next()     // Catch:{ all -> 0x0127 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0127 }
            if (r4 > 0) goto L_0x0035
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0127 }
            long r8 = r8 / r5
            int r9 = (int) r8     // Catch:{ all -> 0x0127 }
            goto L_0x0036
        L_0x0035:
            r9 = r4
        L_0x0036:
            r8 = 0
            if (r7 != 0) goto L_0x003e
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0127 }
            goto L_0x004b
        L_0x003e:
            java.util.HashMap<java.lang.String, java.lang.Integer> r10 = r14.PROFILE_EXPIRY_MAP     // Catch:{ all -> 0x0127 }
            monitor-enter(r10)     // Catch:{ all -> 0x0127 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r11 = r14.PROFILE_EXPIRY_MAP     // Catch:{ all -> 0x0124 }
            java.lang.Object r11 = r11.get(r7)     // Catch:{ all -> 0x0124 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ all -> 0x0124 }
            monitor-exit(r10)     // Catch:{ all -> 0x0124 }
            r10 = r11
        L_0x004b:
            r11 = 1
            if (r10 == 0) goto L_0x0056
            int r10 = r10.intValue()     // Catch:{ all -> 0x0127 }
            if (r10 <= r9) goto L_0x0056
            r9 = 1
            goto L_0x0057
        L_0x0056:
            r9 = 0
        L_0x0057:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0127 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0127 }
            if (r9 == 0) goto L_0x0083
            com.clevertap.android.sdk.Logger r8 = r14.getConfigLogger()     // Catch:{ all -> 0x0127 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r14.config     // Catch:{ all -> 0x0127 }
            java.lang.String r9 = r9.accountId     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r10.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r11 = "Rejecting upstream value for key "
            r10.append(r11)     // Catch:{ all -> 0x0127 }
            r10.append(r7)     // Catch:{ all -> 0x0127 }
            java.lang.String r7 = " because our local cache prohibits it"
            r10.append(r7)     // Catch:{ all -> 0x0127 }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x0127 }
            r8.verbose(r9, r7)     // Catch:{ all -> 0x0127 }
            goto L_0x001e
        L_0x0083:
            java.lang.Object r9 = r14.getProfileValueForKey(r7)     // Catch:{ all -> 0x0127 }
            java.lang.Object r10 = r15.get(r7)     // Catch:{ all -> 0x0127 }
            if (r10 != 0) goto L_0x008f
            r12 = 1
            goto L_0x00b2
        L_0x008f:
            boolean r12 = r10 instanceof java.lang.String     // Catch:{ all -> 0x0127 }
            if (r12 == 0) goto L_0x00a2
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0127 }
            java.lang.String r12 = r12.trim()     // Catch:{ all -> 0x0127 }
            int r12 = r12.length()     // Catch:{ all -> 0x0127 }
            if (r12 != 0) goto L_0x00a2
            r12 = 1
            goto L_0x00a3
        L_0x00a2:
            r12 = 0
        L_0x00a3:
            boolean r13 = r10 instanceof org.json.JSONArray     // Catch:{ all -> 0x0127 }
            if (r13 == 0) goto L_0x00b2
            r12 = r10
            org.json.JSONArray r12 = (org.json.JSONArray) r12     // Catch:{ all -> 0x0127 }
            int r12 = r12.length()     // Catch:{ all -> 0x0127 }
            if (r12 > 0) goto L_0x00b1
            r8 = 1
        L_0x00b1:
            r12 = r8
        L_0x00b2:
            if (r12 == 0) goto L_0x00b5
            r10 = r1
        L_0x00b5:
            java.lang.String r8 = ""
            if (r10 != 0) goto L_0x00bb
            r12 = r8
            goto L_0x00bf
        L_0x00bb:
            java.lang.String r12 = r10.toString()     // Catch:{ all -> 0x0127 }
        L_0x00bf:
            if (r9 != 0) goto L_0x00c2
            goto L_0x00c6
        L_0x00c2:
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0127 }
        L_0x00c6:
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x0127 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0127 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0127 }
            if (r8 != 0) goto L_0x001e
            if (r10 == 0) goto L_0x00da
            r2.put(r7, r10)     // Catch:{ all -> 0x0114 }
            goto L_0x00df
        L_0x00da:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0114 }
            r14.removeProfileField(r7, r8, r11)     // Catch:{ all -> 0x0114 }
        L_0x00df:
            if (r9 != 0) goto L_0x00e4
            if (r10 != 0) goto L_0x00e4
            goto L_0x010c
        L_0x00e4:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0114 }
            r8.<init>()     // Catch:{ all -> 0x0114 }
            if (r10 == 0) goto L_0x00ec
            goto L_0x00f1
        L_0x00ec:
            r10 = -1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x00fe }
        L_0x00f1:
            java.lang.String r11 = "newValue"
            r8.put(r11, r10)     // Catch:{ all -> 0x00fe }
            if (r9 == 0) goto L_0x010d
            java.lang.String r10 = "oldValue"
            r8.put(r10, r9)     // Catch:{ all -> 0x00fe }
            goto L_0x010d
        L_0x00fe:
            r8 = move-exception
            com.clevertap.android.sdk.Logger r9 = r14.getConfigLogger()     // Catch:{ all -> 0x0114 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r10 = r14.config     // Catch:{ all -> 0x0114 }
            java.lang.String r10 = r10.accountId     // Catch:{ all -> 0x0114 }
            java.lang.String r11 = "Failed to create profile changed values object"
            r9.verbose(r10, r11, r8)     // Catch:{ all -> 0x0114 }
        L_0x010c:
            r8 = r1
        L_0x010d:
            if (r8 == 0) goto L_0x001e
            r0.put(r7, r8)     // Catch:{ all -> 0x0114 }
            goto L_0x001e
        L_0x0114:
            r7 = move-exception
            com.clevertap.android.sdk.Logger r8 = r14.getConfigLogger()     // Catch:{ all -> 0x0127 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r14.config     // Catch:{ all -> 0x0127 }
            java.lang.String r9 = r9.accountId     // Catch:{ all -> 0x0127 }
            java.lang.String r10 = "Failed to set profile updates"
            r8.verbose(r9, r10, r7)     // Catch:{ all -> 0x0127 }
            goto L_0x001e
        L_0x0124:
            r7 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0124 }
            throw r7     // Catch:{ all -> 0x0127 }
        L_0x0127:
            r7 = move-exception
            com.clevertap.android.sdk.Logger r8 = r14.getConfigLogger()     // Catch:{ all -> 0x0143 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r14.config     // Catch:{ all -> 0x0143 }
            java.lang.String r9 = r9.accountId     // Catch:{ all -> 0x0143 }
            java.lang.String r10 = "Failed to update profile field"
            r8.verbose(r9, r10, r7)     // Catch:{ all -> 0x0143 }
            goto L_0x001e
        L_0x0137:
            int r15 = r2.length()     // Catch:{ all -> 0x0143 }
            if (r15 <= 0) goto L_0x0142
            java.lang.Boolean r15 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0143 }
            r14.setProfileFields(r2, r15)     // Catch:{ all -> 0x0143 }
        L_0x0142:
            return r0
        L_0x0143:
            r15 = move-exception
            com.clevertap.android.sdk.Logger r0 = r14.getConfigLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r14.config
            java.lang.String r2 = r2.accountId
            java.lang.String r3 = "Failed to sync remote profile"
            r0.verbose(r2, r3, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.LocalDataStore.syncProfile(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r8 = r6.get(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r8 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void syncWithUpstream(android.content.Context r11, org.json.JSONObject r12) {
        /*
            r10 = this;
            java.lang.String r0 = "expires_in"
            java.lang.String r1 = "evpr"
            java.lang.String r2 = "_custom"
            java.lang.String r3 = "events"
            java.lang.String r4 = "profile"
            boolean r5 = r12.has(r1)     // Catch:{ all -> 0x00f0 }
            if (r5 != 0) goto L_0x0011
            return
        L_0x0011:
            org.json.JSONObject r12 = r12.getJSONObject(r1)     // Catch:{ all -> 0x00f0 }
            boolean r1 = r12.has(r4)     // Catch:{ all -> 0x00f0 }
            r5 = 0
            if (r1 == 0) goto L_0x0055
            org.json.JSONObject r1 = r12.getJSONObject(r4)     // Catch:{ all -> 0x00f0 }
            boolean r6 = r1.has(r2)     // Catch:{ all -> 0x00f0 }
            if (r6 == 0) goto L_0x0050
            org.json.JSONObject r6 = r1.getJSONObject(r2)     // Catch:{ all -> 0x00f0 }
            r1.remove(r2)     // Catch:{ all -> 0x00f0 }
            java.util.Iterator r2 = r6.keys()     // Catch:{ all -> 0x00f0 }
        L_0x0031:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x00f0 }
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f0 }
            org.json.JSONArray r8 = r6.getJSONArray(r7)     // Catch:{ all -> 0x0044 }
            goto L_0x004a
        L_0x0044:
            java.lang.Object r8 = r6.get(r7)     // Catch:{ JSONException -> 0x0049 }
            goto L_0x004a
        L_0x0049:
            r8 = r5
        L_0x004a:
            if (r8 == 0) goto L_0x0031
            r1.put(r7, r8)     // Catch:{ all -> 0x00f0 }
            goto L_0x0031
        L_0x0050:
            org.json.JSONObject r1 = r10.syncProfile(r1)     // Catch:{ all -> 0x00f0 }
            goto L_0x0056
        L_0x0055:
            r1 = r5
        L_0x0056:
            boolean r2 = r12.has(r3)     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x0065
            org.json.JSONObject r2 = r12.getJSONObject(r3)     // Catch:{ all -> 0x00f0 }
            org.json.JSONObject r2 = r10.syncEventsFromUpstream(r11, r2)     // Catch:{ all -> 0x00f0 }
            goto L_0x0066
        L_0x0065:
            r2 = r5
        L_0x0066:
            boolean r6 = r12.has(r0)     // Catch:{ all -> 0x00f0 }
            if (r6 == 0) goto L_0x0079
            int r12 = r12.getInt(r0)     // Catch:{ all -> 0x00f0 }
            java.lang.String r0 = "local_cache_expires_in"
            java.lang.String r0 = r10.storageKeyWithSuffix(r0)     // Catch:{ all -> 0x00f0 }
            co.hyperverge.hypersnapsdk.c.k.putInt(r11, r0, r12)     // Catch:{ all -> 0x00f0 }
        L_0x0079:
            java.lang.String r12 = "local_cache_last_update"
            java.lang.String r12 = r10.storageKeyWithSuffix(r12)     // Catch:{ all -> 0x00f0 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f0 }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            int r0 = (int) r6     // Catch:{ all -> 0x00f0 }
            co.hyperverge.hypersnapsdk.c.k.putInt(r11, r12, r0)     // Catch:{ all -> 0x00f0 }
            r12 = 0
            r0 = 1
            if (r1 == 0) goto L_0x0096
            int r6 = r1.length()     // Catch:{ all -> 0x00f0 }
            if (r6 <= 0) goto L_0x0096
            r6 = 1
            goto L_0x0097
        L_0x0096:
            r6 = 0
        L_0x0097:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x00a4
            int r7 = r2.length()     // Catch:{ all -> 0x00f0 }
            if (r7 <= 0) goto L_0x00a4
            r12 = 1
        L_0x00a4:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x00f0 }
            boolean r0 = r6.booleanValue()     // Catch:{ all -> 0x00f0 }
            if (r0 != 0) goto L_0x00b4
            boolean r0 = r12.booleanValue()     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00fe
        L_0x00b4:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00f0 }
            r0.<init>()     // Catch:{ all -> 0x00f0 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00f0 }
            if (r6 == 0) goto L_0x00c2
            r0.put(r4, r1)     // Catch:{ all -> 0x00f0 }
        L_0x00c2:
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x00f0 }
            if (r12 == 0) goto L_0x00cb
            r0.put(r3, r2)     // Catch:{ all -> 0x00f0 }
        L_0x00cb:
            com.clevertap.android.sdk.CleverTapAPI r11 = com.clevertap.android.sdk.CleverTapAPI.getDefaultInstance(r11)     // Catch:{ all -> 0x00da }
            if (r11 == 0) goto L_0x00db
            com.clevertap.android.sdk.CoreState r11 = r11.coreState     // Catch:{ all -> 0x00da }
            com.clevertap.android.sdk.BaseCallbackManager r11 = r11.callbackManager     // Catch:{ all -> 0x00da }
            com.clevertap.android.sdk.CallbackManager r11 = (com.clevertap.android.sdk.CallbackManager) r11     // Catch:{ all -> 0x00da }
            com.clevertap.android.sdk.SyncListener r5 = r11.syncListener     // Catch:{ all -> 0x00da }
            goto L_0x00db
        L_0x00da:
        L_0x00db:
            if (r5 == 0) goto L_0x00fe
            r5.profileDataUpdated(r0)     // Catch:{ all -> 0x00e1 }
            goto L_0x00fe
        L_0x00e1:
            r11 = move-exception
            com.clevertap.android.sdk.Logger r12 = r10.getConfigLogger()     // Catch:{ all -> 0x00f0 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r10.config     // Catch:{ all -> 0x00f0 }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x00f0 }
            java.lang.String r1 = "Execution of sync listener failed"
            r12.verbose(r0, r1, r11)     // Catch:{ all -> 0x00f0 }
            goto L_0x00fe
        L_0x00f0:
            r11 = move-exception
            com.clevertap.android.sdk.Logger r12 = r10.getConfigLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r10.config
            java.lang.String r0 = r0.accountId
            java.lang.String r1 = "Failed to sync with upstream"
            r12.verbose(r0, r1, r11)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.LocalDataStore.syncWithUpstream(android.content.Context, org.json.JSONObject):void");
    }

    public final void updateLocalProfileKeyExpiryTime(String str) {
        synchronized (this.PROFILE_EXPIRY_MAP) {
            this.PROFILE_EXPIRY_MAP.put(str, Integer.valueOf(((int) (System.currentTimeMillis() / 1000)) + getIntFromPrefs("local_cache_expires_in", 0)));
        }
    }
}
