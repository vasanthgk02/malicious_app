package com.mpl.androidapp.react.modules;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.contact.ContactUtils;
import com.mpl.androidapp.database.dao.ContactDao;
import com.mpl.androidapp.database.entity.Contact;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@ReactModule(name = "ContactModule")
public class ContactModule extends ReactContextBaseJavaModule {
    public static final String TAG = "ContactModule";
    public boolean isRegistered = false;
    public BroadcastReceiver mContactSyncReceiver = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|(1:15)) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
            if (com.mpl.androidapp.react.modules.ContactModule.access$300(r7.this$0) != null) goto L_0x0050;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
            com.mpl.androidapp.react.modules.ContactModule.access$300(r7.this$0).reject((java.lang.String) "fail", (java.lang.String) "Unable to fetch contact");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            com.mpl.androidapp.utils.MLogger.e(com.mpl.androidapp.react.modules.ContactModule.TAG, "onReceive: ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
            com.mpl.androidapp.react.modules.ContactModule.access$200(r7.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
            throw r8;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r8, android.content.Intent r9) {
            /*
                r7 = this;
                java.lang.String r8 = "Unable to fetch contact"
                java.lang.String r0 = "fail"
                java.lang.String r1 = "contactsValue"
                r2 = 1
                java.lang.Object[] r3 = new java.lang.Object[r2]
                r4 = 0
                java.lang.String r5 = "onReceive: "
                r3[r4] = r5
                java.lang.String r6 = "ContactModule"
                com.mpl.androidapp.utils.MLogger.d(r6, r3)
                com.mpl.androidapp.react.modules.ContactModule r3 = com.mpl.androidapp.react.modules.ContactModule.this     // Catch:{ Exception -> 0x0048 }
                com.facebook.react.bridge.Promise r3 = r3.mPromise     // Catch:{ Exception -> 0x0048 }
                if (r3 == 0) goto L_0x0040
                if (r9 == 0) goto L_0x0031
                boolean r3 = r9.hasExtra(r1)     // Catch:{ Exception -> 0x0048 }
                if (r3 == 0) goto L_0x0031
                java.lang.String r9 = r9.getStringExtra(r1)     // Catch:{ Exception -> 0x0048 }
                com.mpl.androidapp.react.modules.ContactModule r1 = com.mpl.androidapp.react.modules.ContactModule.this     // Catch:{ Exception -> 0x0048 }
                com.facebook.react.bridge.Promise r1 = r1.mPromise     // Catch:{ Exception -> 0x0048 }
                r1.resolve(r9)     // Catch:{ Exception -> 0x0048 }
                goto L_0x003a
            L_0x0031:
                com.mpl.androidapp.react.modules.ContactModule r9 = com.mpl.androidapp.react.modules.ContactModule.this     // Catch:{ Exception -> 0x0048 }
                com.facebook.react.bridge.Promise r9 = r9.mPromise     // Catch:{ Exception -> 0x0048 }
                r9.reject(r0, r8)     // Catch:{ Exception -> 0x0048 }
            L_0x003a:
                com.mpl.androidapp.react.modules.ContactModule r9 = com.mpl.androidapp.react.modules.ContactModule.this     // Catch:{ Exception -> 0x0048 }
                r1 = 0
                r9.mPromise = r1     // Catch:{ Exception -> 0x0048 }
            L_0x0040:
                com.mpl.androidapp.react.modules.ContactModule r8 = com.mpl.androidapp.react.modules.ContactModule.this
                r8.unRegisterContactSyncReceiver()
                goto L_0x0062
            L_0x0046:
                r8 = move-exception
                goto L_0x0063
            L_0x0048:
                com.mpl.androidapp.react.modules.ContactModule r9 = com.mpl.androidapp.react.modules.ContactModule.this     // Catch:{ Exception -> 0x005a }
                com.facebook.react.bridge.Promise r9 = r9.mPromise     // Catch:{ Exception -> 0x005a }
                if (r9 == 0) goto L_0x0040
                com.mpl.androidapp.react.modules.ContactModule r9 = com.mpl.androidapp.react.modules.ContactModule.this     // Catch:{ Exception -> 0x005a }
                com.facebook.react.bridge.Promise r9 = r9.mPromise     // Catch:{ Exception -> 0x005a }
                r9.reject(r0, r8)     // Catch:{ Exception -> 0x005a }
                goto L_0x0040
            L_0x005a:
                java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
                r8[r4] = r5     // Catch:{ all -> 0x0046 }
                com.mpl.androidapp.utils.MLogger.e(r6, r8)     // Catch:{ all -> 0x0046 }
                goto L_0x0040
            L_0x0062:
                return
            L_0x0063:
                com.mpl.androidapp.react.modules.ContactModule r9 = com.mpl.androidapp.react.modules.ContactModule.this
                r9.unRegisterContactSyncReceiver()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.ContactModule.AnonymousClass2.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    public Context mContext;
    public Promise mPromise;

    public ContactModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostDestroy() {
                MLogger.d(ContactModule.TAG, "onHostDestroy: ", Boolean.valueOf(ContactModule.this.isRegistered));
                ContactModule.this.unRegisterContactSyncReceiver();
            }

            public void onHostPause() {
            }

            public void onHostResume() {
                MLogger.d(ContactModule.TAG, "onHostResume: ", Boolean.valueOf(ContactModule.this.isRegistered));
                ContactModule.this.registerContactSyncReceiver();
            }
        });
    }

    /* access modifiers changed from: private */
    public void registerContactSyncReceiver() {
        try {
            if (!this.isRegistered) {
                LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mContactSyncReceiver, new IntentFilter(Constant.INTENT_ACTION_CONTACT_SYNC));
                this.isRegistered = true;
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "registerNotificationReceiver", e2);
        }
    }

    /* access modifiers changed from: private */
    public void unRegisterContactSyncReceiver() {
        try {
            if (this.isRegistered) {
                LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.mContactSyncReceiver);
                this.isRegistered = false;
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "unRegisterNotificationReceiver", e2);
        }
    }

    @ReactMethod
    public void getContacts(String str, Promise promise) {
        try {
            MLogger.d(TAG, "getContacts: ");
            if (MSharedPreferencesUtils.isChallengeContactSyncRequired()) {
                registerContactSyncReceiver();
                this.mPromise = promise;
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(DefaultSettingsSpiCall.SOURCE_PARAM)) {
                    ContactUtils.populateContactsOnSeparateThread(this.mContext, jSONObject.optString(DefaultSettingsSpiCall.SOURCE_PARAM));
                } else if (TextUtils.isEmpty(str) || jSONObject.toString().equalsIgnoreCase("{}") || jSONObject.length() == 0) {
                    ContactUtils.populateContactsOnSeparateThread(this.mContext, "");
                }
            } else {
                promise.reject((String) "fail", (String) "Contact sync is off from config");
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getContacts: ", e2);
        }
    }

    @ReactMethod
    public void getContactsForId(String str, Promise promise) {
        try {
            ContactDao contactDao = MPLApplication.getDatabaseClient().getAppDatabase().contactDao();
            if (contactDao != null) {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 1) {
                    arrayList.add(contactDao.getContactBasedOnMplId(jSONArray.optString(0)));
                } else if (jSONArray.length() > 1) {
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.optString(i);
                    }
                    List<Contact> contactsBasedOnMplId = contactDao.getContactsBasedOnMplId(strArr);
                    if (contactsBasedOnMplId != null && contactsBasedOnMplId.size() > 0) {
                        arrayList.addAll(contactsBasedOnMplId);
                    }
                }
                if (arrayList.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(((Contact) it.next()).toJson());
                    }
                    jSONObject.put("contacts", jSONArray2);
                    promise.resolve(jSONObject.toString());
                    return;
                }
                promise.reject((String) "fail", (String) "Unable to fetch contact");
                return;
            }
            promise.reject((String) "fail", (String) "Unable to fetch contact");
        } catch (Exception e2) {
            MLogger.e(TAG, "getContacts: ", e2);
            promise.reject((String) "fail", (String) "Unable to fetch contact");
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void searchContacts(String str, Promise promise) {
        try {
            registerContactSyncReceiver();
            ContactUtils.searchContact(this.mContext, str);
            this.mPromise = promise;
        } catch (Exception unused) {
        }
    }
}
