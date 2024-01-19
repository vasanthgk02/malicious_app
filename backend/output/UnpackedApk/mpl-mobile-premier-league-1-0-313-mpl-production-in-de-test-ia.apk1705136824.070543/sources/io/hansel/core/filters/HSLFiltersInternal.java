package io.hansel.core.filters;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.paynimo.android.payment.UPIFragment;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.base.utils.HSLVersion;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HSLFiltersInternal {
    public static final String HANSEL_FILTERS_CONFIG_SP_NAME = "_HANSEL_CONFIG_FILTERS_SP";
    public static final String HANSEL_FILTERS_SP_NAME = "_HANSEL_FILTERS_SP";
    public static HSLFiltersInternal hanselFiltersInternal = new HSLFiltersInternal();
    public Context mContext;
    public IMessageBroker mMessageBroker;
    public HSLModuleInitializationData moduleInitializationData;

    private boolean contains(String str) {
        return getSharedPreferences().contains(str);
    }

    private synchronized CoreJSONObject get(String str) {
        CoreJSONObject coreJSONObject;
        coreJSONObject = null;
        if (this.mContext == null) {
            return null;
        }
        try {
            coreJSONObject = new CoreJSONObject(getSharedPreferences().getString(str, null));
        } catch (Exception e2) {
            HSLLogger.d("HSLFiltersInternal get " + e2.getMessage());
        }
        return coreJSONObject;
    }

    private SharedPreferences getConfigSharedPreferences() {
        return this.mContext.getSharedPreferences(HANSEL_FILTERS_CONFIG_SP_NAME, 0);
    }

    public static HSLFiltersInternal getInstance() {
        return hanselFiltersInternal;
    }

    private SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences(HANSEL_FILTERS_SP_NAME, 0);
    }

    private boolean isChanged(String str, double d2) {
        String string = getSharedPreferences().getString(str, null);
        if (string != null) {
            try {
                if (new CoreJSONObject(string).optDouble(HSLCriteriaBuilder.VALUE) == d2) {
                    return false;
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return true;
    }

    private boolean isChanged(String str, String str2) {
        String string = getSharedPreferences().getString(str, null);
        if (string == null) {
            return true;
        }
        try {
            return true ^ new CoreJSONObject(string).optString(HSLCriteriaBuilder.VALUE, "").equals(str2);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
            return true;
        }
    }

    private boolean isChanged(String str, boolean z) {
        String string = getSharedPreferences().getString(str, null);
        if (string != null) {
            try {
                if (new CoreJSONObject(string).optBoolean(HSLCriteriaBuilder.VALUE) == z) {
                    return false;
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return true;
    }

    public synchronized void clear() {
        if (this.mContext != null) {
            getSharedPreferences().edit().clear().apply();
            this.mMessageBroker.publishBlockingEvent(EventsConstants.FILTERS_CLEARED.name(), null);
        }
    }

    public HashMap<String, CoreJSONObject> getAll() {
        HashMap<String, CoreJSONObject> hashMap = new HashMap<>();
        if (this.mContext != null) {
            try {
                Map<String, ?> all = getSharedPreferences().getAll();
                if (all != null) {
                    ArrayList arrayList = new ArrayList(all.keySet());
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        String str = (String) arrayList.get(i);
                        hashMap.put(str, new CoreJSONObject(String.valueOf(all.get(str))));
                    }
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return hashMap;
    }

    public HashMap<String, Object> getAllFilters() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (this.mContext != null) {
            try {
                Map<String, ?> all = getSharedPreferences().getAll();
                if (all != null) {
                    ArrayList arrayList = new ArrayList(all.keySet());
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        String str = (String) arrayList.get(i);
                        hashMap.put(str, new CoreJSONObject(getSharedPreferences().getString(str, null)).optString(HSLCriteriaBuilder.VALUE));
                    }
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return hashMap;
    }

    public CoreJSONArray getAllForRequest(boolean z) {
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        if (this.mContext != null) {
            put((String) "os_version", VERSION.RELEASE);
            put((String) "device", Build.MODEL);
            put((String) "manufacturer", Build.MANUFACTURER);
            HashMap<String, CoreJSONObject> all = getAll();
            if (all != null && !all.isEmpty()) {
                ArrayList arrayList = new ArrayList(all.keySet());
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) arrayList.get(i);
                    if (str == null || !str.startsWith("#$")) {
                        CoreJSONObject coreJSONObject = all.get(str);
                        if (coreJSONObject != null) {
                            if (coreJSONObject.has(HSLCriteriaBuilder.VALUE)) {
                                coreJSONObject.remove(HSLCriteriaBuilder.VALUE);
                            }
                            if (coreJSONObject.has("meta") && !z) {
                                coreJSONObject.remove("meta");
                            }
                            coreJSONArray.put((Object) coreJSONObject);
                        }
                    }
                }
            }
        }
        return coreJSONArray;
    }

    public synchronized Boolean getBoolean(String str) {
        CoreJSONObject coreJSONObject = get(str);
        if (coreJSONObject == null) {
            return null;
        }
        return Boolean.valueOf(coreJSONObject.optBoolean(HSLCriteriaBuilder.VALUE));
    }

    public String getDeviceId() {
        return this.moduleInitializationData.sdkIdentifiers.deviceId;
    }

    public synchronized Double getDouble(String str) {
        CoreJSONObject coreJSONObject = get(str);
        if (coreJSONObject == null) {
            return null;
        }
        return Double.valueOf(coreJSONObject.optDouble(HSLCriteriaBuilder.VALUE));
    }

    public CoreJSONObject getFiltersForPromptCriteriaEval() {
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        HSLVersion hSLVersion = new HSLVersion();
        HSLInternalUtils.populateAppVersion(this.mContext, hSLVersion);
        try {
            coreJSONObject.putOpt("app_build_number", String.valueOf(hSLVersion.versionCode));
            coreJSONObject.putOpt("os", "android");
            coreJSONObject.putOpt(SMTPreferenceConstants.SMT_SDK_VERSION, HSLBuildConfig.SDK_VERSION);
            coreJSONObject.putOpt("app_version", hSLVersion.versionName);
            coreJSONObject.putOpt("os_version", VERSION.RELEASE);
            coreJSONObject.putOpt("device", Build.MODEL);
            coreJSONObject.putOpt("manufacturer", Build.MANUFACTURER);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
        return coreJSONObject;
    }

    public String getMurMurId(String str) {
        String uniqueId = getUniqueId();
        return !HSLInternalUtils.isEmpty(str) ? GeneratedOutlineSupport.outline50(uniqueId, str) : uniqueId;
    }

    public synchronized Object getObject(String str) {
        CoreJSONObject coreJSONObject = get(str);
        if (coreJSONObject == null) {
            return null;
        }
        return coreJSONObject.opt(HSLCriteriaBuilder.VALUE);
    }

    public synchronized String getString(String str) {
        try {
            CoreJSONObject coreJSONObject = get(str);
            if (coreJSONObject == null) {
                return null;
            }
            return coreJSONObject.optString(HSLCriteriaBuilder.VALUE);
        }
    }

    public String getUniqueId() {
        String string = getString("#$user_id");
        if (!HSLInternalUtils.isEmpty(string)) {
            return string;
        }
        HSLModuleInitializationData hSLModuleInitializationData = this.moduleInitializationData;
        if (hSLModuleInitializationData == null) {
            return string;
        }
        HSLSDKIdentifiers hSLSDKIdentifiers = hSLModuleInitializationData.sdkIdentifiers;
        String str = hSLSDKIdentifiers.guid;
        return str == null ? hSLSDKIdentifiers.deviceId : str;
    }

    public String getUserId() {
        return getString("#$user_id");
    }

    public void init(Context context, IMessageBroker iMessageBroker, HSLModuleInitializationData hSLModuleInitializationData) {
        this.mContext = context;
        this.mMessageBroker = iMessageBroker;
        this.moduleInitializationData = hSLModuleInitializationData;
        HSLVersion hSLVersion = new HSLVersion();
        HSLInternalUtils.populateAppVersion(context, hSLVersion);
        put((String) "app_version", hSLVersion.versionName);
        put((String) "os_version", VERSION.RELEASE);
        put((String) OneSingnalConstant.TAG_DEVICE_MODEL, Build.MODEL);
        put((String) "device_manufacturer", Build.MANUFACTURER);
    }

    public boolean isLoggedIn() {
        return !HSLInternalUtils.isEmpty(getString("#$user_id"));
    }

    public synchronized void put(String str, double d2) {
        put(str, d2, false);
    }

    public synchronized void put(String str, double d2, boolean z) {
        if (this.mContext != null) {
            CoreJSONObject coreJSONObject = new CoreJSONObject();
            Boolean bool = Boolean.FALSE;
            try {
                coreJSONObject.put((String) "id", (Object) str).put((String) HSLCriteriaBuilder.VALUE, d2).put((String) "type", (Object) UPIFragment.CONFIG_TYPE_NUMBER);
                if (z) {
                    coreJSONObject.putOpt("meta", new CoreJSONObject().putOpt("is_private", Boolean.TRUE));
                }
                if (isChanged(str, d2)) {
                    bool = Boolean.TRUE;
                }
                getSharedPreferences().edit().putString(str, coreJSONObject.toString()).apply();
                if (bool.booleanValue()) {
                    this.mMessageBroker.publishBlockingEvent(EventsConstants.FILTER_CHANGED.name(), str);
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            } catch (Throwable th) {
                HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to put the double attribute.");
            }
        }
    }

    public synchronized void put(String str, String str2) {
        put(str, str2, false);
    }

    public synchronized void put(String str, String str2, boolean z) {
        if (this.mContext != null) {
            Boolean bool = Boolean.FALSE;
            CoreJSONObject coreJSONObject = new CoreJSONObject();
            try {
                coreJSONObject.put((String) "id", (Object) str);
                if (str2 != null) {
                    coreJSONObject.put((String) HSLCriteriaBuilder.VALUE, (Object) str2);
                } else {
                    coreJSONObject.put((String) HSLCriteriaBuilder.VALUE, CoreJSONObject.NULL);
                }
                coreJSONObject.put((String) "type", (Object) NetworkingModule.REQUEST_BODY_KEY_STRING);
                if (z) {
                    coreJSONObject.putOpt("meta", new CoreJSONObject().putOpt("is_private", Boolean.TRUE));
                }
                if (isChanged(str, str2)) {
                    bool = Boolean.TRUE;
                }
                getSharedPreferences().edit().putString(str, coreJSONObject.toString()).apply();
                if (bool.booleanValue() && !"#$user_id".equals(str)) {
                    this.mMessageBroker.publishBlockingEvent(EventsConstants.FILTER_CHANGED.name(), str);
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            } catch (Throwable th) {
                HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to put the string attribute.");
            }
        }
    }

    public synchronized void put(String str, boolean z) {
        put(str, z, false);
    }

    public synchronized void put(String str, boolean z, boolean z2) {
        if (this.mContext != null) {
            CoreJSONObject coreJSONObject = new CoreJSONObject();
            Boolean bool = Boolean.FALSE;
            try {
                coreJSONObject.put((String) "id", (Object) str);
                coreJSONObject.put((String) HSLCriteriaBuilder.VALUE, z);
                coreJSONObject.put((String) "type", (Object) "boolean");
                if (z2) {
                    coreJSONObject.putOpt("meta", new CoreJSONObject().putOpt("is_private", Boolean.TRUE));
                }
                if (isChanged(str, z)) {
                    bool = Boolean.TRUE;
                }
                getSharedPreferences().edit().putString(str, coreJSONObject.toString()).apply();
                if (bool.booleanValue()) {
                    this.mMessageBroker.publishBlockingEvent(EventsConstants.FILTER_CHANGED.name(), str);
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            } catch (Throwable th) {
                HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to put the boolean attribute.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d4, code lost:
        if (isChanged(r2, (java.lang.String) r1) != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011b, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100 A[Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0012 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(java.util.Map<java.lang.String, ?> r9, boolean r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            android.content.Context r0 = r8.mContext     // Catch:{ all -> 0x011c }
            if (r0 == 0) goto L_0x011a
            if (r9 != 0) goto L_0x0009
            goto L_0x011a
        L_0x0009:
            r0 = 0
            java.util.Set r9 = r9.entrySet()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
        L_0x0012:
            boolean r1 = r9.hasNext()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r1 == 0) goto L_0x0118
            java.lang.Object r1 = r9.next()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.Object r2 = r1.getKey()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.Object r1 = r1.getValue()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            io.hansel.core.json.CoreJSONObject r3 = new io.hansel.core.json.CoreJSONObject     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r3.<init>()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r4 = "id"
            io.hansel.core.json.CoreJSONObject r4 = r3.put(r4, r2)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r5 = "value"
            r4.put(r5, r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            boolean r4 = r1 instanceof java.lang.Number     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r5 = 1
            if (r4 == 0) goto L_0x007c
            boolean r4 = r1 instanceof java.lang.Double     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r4 != 0) goto L_0x005b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r4.<init>()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r4.append(r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r1 = ""
            r4.append(r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r1 = r4.toString()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            double r6 = java.lang.Double.parseDouble(r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.Double r1 = java.lang.Double.valueOf(r6)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
        L_0x005b:
            java.lang.String r4 = "id"
            io.hansel.core.json.CoreJSONObject r4 = r3.put(r4, r2)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r6 = "value"
            r4.put(r6, r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r4 = "type"
            java.lang.String r6 = "number"
            r3.put(r4, r6)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            double r6 = r1.doubleValue()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            boolean r1 = r8.isChanged(r2, r6)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r1 == 0) goto L_0x00d7
            goto L_0x00d6
        L_0x007c:
            boolean r4 = r1 instanceof java.lang.Boolean     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r4 == 0) goto L_0x00b5
            java.lang.String r4 = "id"
            io.hansel.core.json.CoreJSONObject r4 = r3.put(r4, r2)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r6 = "value"
            r4.put(r6, r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r4 = "type"
            java.lang.String r6 = "boolean"
            r3.put(r4, r6)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            boolean r1 = r1.booleanValue()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            boolean r1 = r8.isChanged(r2, r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r1 == 0) goto L_0x00a1
            r0 = 1
        L_0x00a1:
            android.content.SharedPreferences r1 = r8.getSharedPreferences()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r4 = r3.toString()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r4)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r1.apply()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            goto L_0x00d7
        L_0x00b5:
            boolean r4 = r1 instanceof java.lang.String     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r4 == 0) goto L_0x00d7
            java.lang.String r4 = "id"
            io.hansel.core.json.CoreJSONObject r4 = r3.put(r4, r2)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r6 = "value"
            r4.put(r6, r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r4 = "type"
            java.lang.String r6 = "string"
            r3.put(r4, r6)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            boolean r1 = r8.isChanged(r2, r1)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r1 == 0) goto L_0x00d7
        L_0x00d6:
            r0 = 1
        L_0x00d7:
            if (r10 == 0) goto L_0x00eb
            java.lang.String r1 = "meta"
            io.hansel.core.json.CoreJSONObject r4 = new io.hansel.core.json.CoreJSONObject     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r4.<init>()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r5 = "is_private"
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            io.hansel.core.json.CoreJSONObject r4 = r4.putOpt(r5, r6)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r3.putOpt(r1, r4)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
        L_0x00eb:
            android.content.SharedPreferences r1 = r8.getSharedPreferences()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r3 = r3.toString()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r3)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r1.apply()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            if (r0 == 0) goto L_0x0012
            io.hansel.core.module.IMessageBroker r1 = r8.mMessageBroker     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            io.hansel.core.module.EventsConstants r3 = io.hansel.core.module.EventsConstants.FILTER_CHANGED     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            java.lang.String r3 = r3.name()     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            r1.publishBlockingEvent(r3, r2)     // Catch:{ CoreJSONException -> 0x0114, all -> 0x010d }
            goto L_0x0012
        L_0x010d:
            r9 = move-exception
            java.lang.String r10 = "Something went wrong. Hansel sdk is not able to put the double attribute."
            io.hansel.core.logger.HSLLogger.printStackTraceMin(r9, r10)     // Catch:{ all -> 0x011c }
            goto L_0x0118
        L_0x0114:
            r9 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r9)     // Catch:{ all -> 0x011c }
        L_0x0118:
            monitor-exit(r8)
            return
        L_0x011a:
            monitor-exit(r8)
            return
        L_0x011c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.filters.HSLFiltersInternal.put(java.util.Map, boolean):void");
    }

    public synchronized void remove(String str) {
        try {
            if (this.mContext != null) {
                getSharedPreferences().edit().remove(str).apply();
                this.mMessageBroker.publishBlockingEvent(EventsConstants.FILTER_CHANGED.name(), str);
            } else {
                return;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to remove the clear the " + str + " attribute.");
        }
        return;
    }
}
