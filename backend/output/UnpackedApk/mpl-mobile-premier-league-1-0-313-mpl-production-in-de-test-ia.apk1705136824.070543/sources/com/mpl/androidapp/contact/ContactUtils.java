package com.mpl.androidapp.contact;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.database.dao.ContactDao;
import com.mpl.androidapp.database.entity.Contact;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkCallParams.Builder;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.json.JSONArray;
import org.json.JSONObject;

public class ContactUtils {
    public static final String[] CONTACT_ID_PROJECTION = {"_id", "display_name", "has_phone_number", "contact_last_updated_timestamp"};
    public static final String[] CONTACT_PHONE_NUMBER_PROJECTION = {"contact_id", "data1", "photo_thumb_uri"};
    public static final String TAG = "ContactUtils";

    public static String formatNumber(String str, PhoneNumberUtil phoneNumberUtil) {
        String str2 = "";
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str) && str.length() > 6 && str.matches(".*\\d.*")) {
                    str2 = phoneNumberUtil.format(phoneNumberUtil.parse(str, MBuildConfigUtils.getCountryCode().toUpperCase()), PhoneNumberFormat.E164);
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "formatNumber:", e2);
            }
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static Cursor getListOfContactNames(Context context, ContentResolver contentResolver, String str) {
        return contentResolver.query(Contacts.CONTENT_URI, new String[]{"_id", "lookup", "has_phone_number", "display_name"}, "display_name LIKE ?", new String[]{GeneratedOutlineSupport.outline52("%", str, "%")}, null);
    }

    public static Contact getNameFromLocalDb(String str) {
        try {
            ContactDao contactDao = MPLApplication.getDatabaseClient().getAppDatabase().contactDao();
            int i = PhoneNumberUtil.getInstance().parse(str, MBuildConfigUtils.getCountryCode()).countryCode_;
            List<Contact> contactsSearchBasedOnNumber = contactDao.getContactsSearchBasedOnNumber(str, str.replace(MqttTopic.SINGLE_LEVEL_WILDCARD + i, ""));
            if (contactsSearchBasedOnNumber == null || contactsSearchBasedOnNumber.isEmpty() || contactsSearchBasedOnNumber.size() == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                contactsSearchBasedOnNumber = contactDao.getContactsNameFromLocal(arrayList);
            }
            if (contactsSearchBasedOnNumber != null && !contactsSearchBasedOnNumber.isEmpty() && contactsSearchBasedOnNumber.size() > 0) {
                return contactsSearchBasedOnNumber.get(0);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getNameFromLocalDb: ", e2);
        }
        return null;
    }

    public static String getNameFromLocalDbFromUserId(String str) {
        try {
            Contact contactBasedOnMplId = MPLApplication.getDatabaseClient().getAppDatabase().contactDao().getContactBasedOnMplId(str);
            if (contactBasedOnMplId != null && !TextUtils.isEmpty(contactBasedOnMplId.getContactDisplayName())) {
                return contactBasedOnMplId.getContactDisplayName();
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getNameFromLocalDb: ", e2);
        }
        return "";
    }

    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v11, types: [boolean] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v32 */
    /* JADX WARNING: type inference failed for: r5v35 */
    /* JADX WARNING: type inference failed for: r5v97 */
    /* JADX WARNING: type inference failed for: r5v98 */
    /* JADX WARNING: type inference failed for: r5v99 */
    /* JADX WARNING: type inference failed for: r5v100 */
    /* JADX WARNING: type inference failed for: r5v101 */
    /* JADX WARNING: type inference failed for: r5v102 */
    /* JADX WARNING: type inference failed for: r5v103 */
    /* JADX WARNING: type inference failed for: r5v104 */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02d7, code lost:
        r1 = r37;
        r2 = r38;
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02dd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02de, code lost:
        r1 = r37;
        r2 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x053e, code lost:
        if (r0 == false) goto L_0x0600;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x05fa, code lost:
        if (r36 == false) goto L_0x0600;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x05fc, code lost:
        syncAllContactsWithServer(r1, r3, r2);
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0600, code lost:
        sendResponseToReact(r1, r3, r2, r5, r4);
        r5 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v10
      assigns: []
      uses: []
      mth insns count: 683
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d6 A[ExcHandler: all (r0v115 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r25 r26 r36 
      PHI: (r25v11 java.util.ArrayList) = (r25v12 java.util.ArrayList), (r25v13 java.util.ArrayList), (r25v13 java.util.ArrayList), (r25v13 java.util.ArrayList), (r25v13 java.util.ArrayList) binds: [B:114:0x02cc, B:86:0x01d0, B:87:?, B:89:0x0218, B:99:0x0245] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r26v11 java.util.ArrayList) = (r26v12 java.util.ArrayList), (r26v13 java.util.ArrayList), (r26v13 java.util.ArrayList), (r26v13 java.util.ArrayList), (r26v13 java.util.ArrayList) binds: [B:114:0x02cc, B:86:0x01d0, B:87:?, B:89:0x0218, B:99:0x0245] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r36v32 boolean) = (r36v33 boolean), (r36v34 boolean), (r36v34 boolean), (r36v34 boolean), (r36v34 boolean) binds: [B:114:0x02cc, B:86:0x01d0, B:87:?, B:89:0x0218, B:99:0x0245] A[DONT_GENERATE, DONT_INLINE], Splitter:B:86:0x01d0] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04ba  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0633  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x06a1  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x06a5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017b A[Catch:{ Exception -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void populateContacts(android.content.Context r37, java.lang.String r38) {
        /*
            r1 = r37
            r2 = r38
            java.lang.String r3 = "INSERT"
            java.lang.String r4 = "UPDATE"
            java.lang.String r5 = "updateType"
            java.lang.String r6 = "insertedContacts"
            java.lang.String r7 = "deletedContacts"
            java.lang.String r8 = "contact.new.sync.enabled"
            java.lang.String r9 = "populateContacts: "
            java.lang.String r10 = "Success"
            r11 = 1
            java.lang.Object[] r0 = new java.lang.Object[r11]
            java.lang.String r12 = "populateContacts:[START] "
            r13 = 0
            r0[r13] = r12
            java.lang.String r12 = "ContactUtils"
            com.mpl.androidapp.utils.MLogger.d(r12, r0)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            long r18 = java.lang.System.currentTimeMillis()
            com.mpl.androidapp.database.DatabaseClient r0 = com.mpl.androidapp.MPLApplication.getDatabaseClient()
            com.mpl.androidapp.database.AppDatabase r0 = r0.getAppDatabase()
            r20 = r3
            com.mpl.androidapp.database.dao.ContactDao r3 = r0.contactDao()
            r21 = r4
            com.google.i18n.phonenumbers.PhoneNumberUtil r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance()
            r22 = r9
            r23 = 0
            int r0 = r3.getAllContactsCount()     // Catch:{ Exception -> 0x055e, all -> 0x0551 }
            if (r0 != 0) goto L_0x005a
            r24 = 1
            goto L_0x005c
        L_0x005a:
            r24 = 0
        L_0x005c:
            android.content.ContentResolver r31 = r37.getContentResolver()     // Catch:{ Exception -> 0x054a, all -> 0x0542 }
            android.net.Uri r26 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch:{ Exception -> 0x054a, all -> 0x0542 }
            java.lang.String[] r27 = CONTACT_ID_PROJECTION     // Catch:{ Exception -> 0x054a, all -> 0x0542 }
            java.lang.String r28 = "has_phone_number = ?"
            java.lang.String r0 = "1"
            java.lang.String[] r29 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x054a, all -> 0x0542 }
            r30 = 0
            r25 = r31
            android.database.Cursor r9 = r25.query(r26, r27, r28, r29, r30)     // Catch:{ Exception -> 0x054a, all -> 0x0542 }
            if (r9 == 0) goto L_0x049d
            boolean r0 = r9.moveToFirst()     // Catch:{ Exception -> 0x048a, all -> 0x0476 }
            if (r0 == 0) goto L_0x049d
            r32 = r5
            r5 = 2
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0474, all -> 0x0472 }
            java.lang.String r5 = "populateContacts:1 "
            r17 = 0
            r0[r17] = r5     // Catch:{ Exception -> 0x0474, all -> 0x0472 }
            int r5 = r9.getCount()     // Catch:{ Exception -> 0x0474, all -> 0x0472 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0474, all -> 0x0472 }
            r16 = 1
            r0[r16] = r5     // Catch:{ Exception -> 0x0474, all -> 0x0472 }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x0474, all -> 0x0472 }
            r5 = 0
        L_0x0097:
            boolean r0 = r9.isAfterLast()     // Catch:{ Exception -> 0x0464, all -> 0x0455 }
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = "_id"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ Exception -> 0x03a1, all -> 0x0391 }
            r33 = r6
            java.lang.String r6 = r9.getString(r0)     // Catch:{ Exception -> 0x037f, all -> 0x036d }
            java.lang.String r0 = "display_name"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ Exception -> 0x037f, all -> 0x036d }
            r34 = r7
            java.lang.String r7 = r9.getString(r0)     // Catch:{ Exception -> 0x0359, all -> 0x0345 }
            java.lang.String r0 = "contact_last_updated_timestamp"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ Exception -> 0x0359, all -> 0x0345 }
            java.lang.String r1 = r9.getString(r0)     // Catch:{ Exception -> 0x0359, all -> 0x0345 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0359, all -> 0x0345 }
            if (r0 != 0) goto L_0x00d7
            r14.add(r6)     // Catch:{ Exception -> 0x00d0, all -> 0x00c9 }
            goto L_0x00d7
        L_0x00c9:
            r0 = move-exception
            r1 = r37
        L_0x00cc:
            r36 = r5
            goto L_0x034c
        L_0x00d0:
            r0 = move-exception
            r1 = r37
        L_0x00d3:
            r36 = r5
            goto L_0x0360
        L_0x00d7:
            java.util.List r0 = r3.getSingleContactBasedOnId(r6)     // Catch:{ Exception -> 0x0359, all -> 0x0345 }
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0120
            int r23 = r0.size()     // Catch:{ Exception -> 0x011a, all -> 0x0114 }
            if (r23 != 0) goto L_0x0120
            r35 = r10
            r10 = 2
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x010b, all -> 0x0102 }
            java.lang.String r10 = "populateContacts: this is new number"
            r17 = 0
            r0[r17] = r10     // Catch:{ Exception -> 0x010b, all -> 0x0102 }
            if (r7 == 0) goto L_0x00f4
            r10 = r7
            goto L_0x00f5
        L_0x00f4:
            r10 = r2
        L_0x00f5:
            r16 = 1
            r0[r16] = r10     // Catch:{ Exception -> 0x010b, all -> 0x0102 }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x010b, all -> 0x0102 }
            r36 = r5
            r23 = 1
            goto L_0x0164
        L_0x0102:
            r0 = move-exception
            r1 = r37
            r2 = r38
            r36 = r5
            goto L_0x032a
        L_0x010b:
            r0 = move-exception
            r1 = r37
            r2 = r38
            r36 = r5
            goto L_0x033f
        L_0x0114:
            r0 = move-exception
            r1 = r37
            r2 = r38
            goto L_0x00cc
        L_0x011a:
            r0 = move-exception
            r1 = r37
            r2 = r38
            goto L_0x00d3
        L_0x0120:
            r35 = r10
            r10 = 0
            r23 = 1
        L_0x0125:
            boolean r25 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0338, all -> 0x0323 }
            if (r25 != 0) goto L_0x0162
            if (r0 == 0) goto L_0x0162
            r36 = r5
            int r5 = r0.size()     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            if (r10 >= r5) goto L_0x0164
            java.lang.Object r5 = r0.get(r10)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            com.mpl.androidapp.database.entity.Contact r5 = (com.mpl.androidapp.database.entity.Contact) r5     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r5 = r5.getLastUpdateTimeStamp()     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            boolean r5 = r1.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            if (r5 == 0) goto L_0x0148
            r23 = 0
            goto L_0x015d
        L_0x0148:
            java.lang.Object r5 = r0.get(r10)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            com.mpl.androidapp.database.entity.Contact r5 = (com.mpl.androidapp.database.entity.Contact) r5     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r5 = r5.getPhoneNumber()     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r5 = formatNumber(r5, r4)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            r15.add(r5)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
        L_0x015d:
            int r10 = r10 + 1
            r5 = r36
            goto L_0x0125
        L_0x0162:
            r36 = r5
        L_0x0164:
            r5 = 3
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r5 = "populateContacts:2 "
            r10 = 0
            r0[r10] = r5     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r23)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            r10 = 1
            r0[r10] = r5     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            r5 = 2
            r0[r5] = r7     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            if (r23 == 0) goto L_0x02e3
            android.net.Uri r26 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String[] r27 = CONTACT_PHONE_NUMBER_PROJECTION     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r28 = "contact_id = ?"
            r5 = 1
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            r5 = 0
            r0[r5] = r6     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            r30 = 0
            r25 = r31
            r29 = r0
            android.database.Cursor r5 = r25.query(r26, r27, r28, r29, r30)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            if (r5 == 0) goto L_0x02c4
            boolean r0 = r5.moveToFirst()     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            if (r0 == 0) goto L_0x02c4
            r10 = 2
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r10 = "populateContacts:3 "
            r17 = 0
            r0[r17] = r10     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            int r10 = r5.getCount()     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            r16 = 1
            r0[r16] = r10     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
        L_0x01b1:
            boolean r0 = r5.isAfterLast()     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            if (r0 != 0) goto L_0x02c4
            java.lang.String r0 = "data1"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r10 = "photo_thumb_uri"
            int r10 = r5.getColumnIndex(r10)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            java.lang.String r10 = r5.getString(r10)     // Catch:{ Exception -> 0x0321, all -> 0x031f }
            r26 = r11
            r25 = r15
            r15 = 3
            java.lang.Object[] r11 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r15 = "populateContacts:4 "
            r17 = 0
            r11[r17] = r15     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r15.<init>()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r27 = r14
            java.lang.String r14 = "phoneNumber: "
            r15.append(r14)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r15.append(r0)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r14 = r15.toString()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r15 = 1
            r11[r15] = r14     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r14.<init>()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r15 = "thumbNailUri: "
            r14.append(r15)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r14.append(r10)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r15 = 2
            r11[r15] = r14     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            com.mpl.androidapp.utils.MLogger.d(r12, r11)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            com.mpl.androidapp.database.entity.Contact r11 = new com.mpl.androidapp.database.entity.Contact     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r11.<init>()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r11.setContactId(r6)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r11.setContactDisplayName(r7)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r11.setContactName(r7)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r11.setPhoneNumber(r0)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            if (r0 == 0) goto L_0x0253
            boolean r14 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            if (r14 != 0) goto L_0x0253
            int r14 = r0.length()     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            r15 = 6
            if (r14 <= r15) goto L_0x0253
            java.lang.String r14 = ".*\\d.*"
            boolean r14 = r0.matches(r14)     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            if (r14 == 0) goto L_0x0253
            java.lang.String r14 = com.mpl.androidapp.utils.MBuildConfigUtils.getCountryCode()     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            java.lang.String r14 = r14.toUpperCase()     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r0 = r4.parse(r0, r14)     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r14 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            java.lang.String r0 = r4.format(r0, r14)     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            r11.setContactLookupKey(r0)     // Catch:{ Exception -> 0x0243, all -> 0x02d6 }
            goto L_0x0253
        L_0x0243:
            r0 = move-exception
            r14 = 2
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r14 = "populateContacts:5 "
            r17 = 0
            r15[r17] = r14     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r14 = 1
            r15[r14] = r0     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            com.mpl.androidapp.utils.MLogger.e(r12, r15)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
        L_0x0253:
            if (r10 == 0) goto L_0x0259
            r11.setPhotoThumbUri(r10)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            goto L_0x025c
        L_0x0259:
            r11.setPhotoThumbUri(r2)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
        L_0x025c:
            r11.setLastUpdateTimeStamp(r1)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r0 = "0"
            r11.setMplId(r0)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r10 = 2
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r10 = "populateContacts:6 "
            r14 = 0
            r0[r14] = r10     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            org.json.JSONObject r10 = r11.toJson()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r14 = 1
            r0[r14] = r10     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r3.insert(r11)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r0 = r11.getPhoneNumber()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            java.lang.String r0 = formatNumber(r0, r4)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r13.add(r0)     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            r5.moveToNext()     // Catch:{ Exception -> 0x02ad, all -> 0x0295 }
            r15 = r25
            r11 = r26
            r14 = r27
            r36 = 1
            goto L_0x01b1
        L_0x0295:
            r0 = move-exception
            r1 = r37
            r2 = r38
            r11 = r0
            r23 = r9
            r6 = r25
            r5 = r26
            r10 = r32
            r9 = r33
            r7 = r34
            r4 = r35
            r36 = 1
            goto L_0x0622
        L_0x02ad:
            r0 = move-exception
            r1 = r37
            r2 = r38
            r23 = r9
            r6 = r25
            r5 = r26
            r10 = r32
            r9 = r33
            r7 = r34
            r4 = r35
            r36 = 1
            goto L_0x0568
        L_0x02c4:
            r26 = r11
            r27 = r14
            r25 = r15
            if (r5 == 0) goto L_0x02e9
            boolean r0 = r5.isClosed()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            if (r0 != 0) goto L_0x02e9
            r5.close()     // Catch:{ Exception -> 0x02dd, all -> 0x02d6 }
            goto L_0x02e9
        L_0x02d6:
            r0 = move-exception
            r1 = r37
            r2 = r38
            r11 = r0
            goto L_0x0308
        L_0x02dd:
            r0 = move-exception
            r1 = r37
            r2 = r38
            goto L_0x0317
        L_0x02e3:
            r26 = r11
            r27 = r14
            r25 = r15
        L_0x02e9:
            r5 = r36
            r9.moveToNext()     // Catch:{ Exception -> 0x0310, all -> 0x0300 }
            r1 = r37
            r2 = r38
            r15 = r25
            r11 = r26
            r14 = r27
            r6 = r33
            r7 = r34
            r10 = r35
            goto L_0x0097
        L_0x0300:
            r0 = move-exception
            r1 = r37
            r2 = r38
            r11 = r0
            r36 = r5
        L_0x0308:
            r23 = r9
            r6 = r25
            r5 = r26
            goto L_0x0436
        L_0x0310:
            r0 = move-exception
            r1 = r37
            r2 = r38
            r36 = r5
        L_0x0317:
            r23 = r9
            r6 = r25
            r5 = r26
            goto L_0x044b
        L_0x031f:
            r0 = move-exception
            goto L_0x0326
        L_0x0321:
            r0 = move-exception
            goto L_0x033b
        L_0x0323:
            r0 = move-exception
            r36 = r5
        L_0x0326:
            r1 = r37
            r2 = r38
        L_0x032a:
            r23 = r9
            r5 = r11
            r6 = r15
            r10 = r32
            r9 = r33
            r7 = r34
            r4 = r35
            goto L_0x0621
        L_0x0338:
            r0 = move-exception
            r36 = r5
        L_0x033b:
            r1 = r37
            r2 = r38
        L_0x033f:
            r23 = r9
            r5 = r11
            r6 = r15
            goto L_0x044b
        L_0x0345:
            r0 = move-exception
            r36 = r5
            r1 = r37
            r2 = r38
        L_0x034c:
            r23 = r9
            r4 = r10
            r5 = r11
            r6 = r15
            r10 = r32
            r9 = r33
            r7 = r34
            goto L_0x0621
        L_0x0359:
            r0 = move-exception
            r36 = r5
            r1 = r37
            r2 = r38
        L_0x0360:
            r23 = r9
            r4 = r10
            r5 = r11
            r6 = r15
            r10 = r32
            r9 = r33
            r7 = r34
            goto L_0x0568
        L_0x036d:
            r0 = move-exception
            r36 = r5
            r1 = r37
            r2 = r38
            r23 = r9
            r4 = r10
            r5 = r11
            r6 = r15
            r10 = r32
            r9 = r33
            goto L_0x0621
        L_0x037f:
            r0 = move-exception
            r36 = r5
            r1 = r37
            r2 = r38
            r23 = r9
            r4 = r10
            r5 = r11
            r6 = r15
            r10 = r32
            r9 = r33
            goto L_0x0568
        L_0x0391:
            r0 = move-exception
            r36 = r5
            r1 = r37
            r2 = r38
            r23 = r9
            r4 = r10
            r5 = r11
            r10 = r32
            r11 = r0
            goto L_0x0486
        L_0x03a1:
            r0 = move-exception
            r36 = r5
            r1 = r37
            r2 = r38
            r23 = r9
            r4 = r10
            r5 = r11
            goto L_0x046f
        L_0x03ae:
            r36 = r5
            r33 = r6
            r34 = r7
            r35 = r10
            r26 = r11
            r27 = r14
            r25 = r15
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            if (r0 == 0) goto L_0x0401
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            r1 = 0
            boolean r0 = r0.optBoolean(r8, r1)     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            if (r0 == 0) goto L_0x0401
            r1 = r27
            java.util.List r0 = r3.getDeletedContactsBasedOnContactIds(r1)     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            if (r0 == 0) goto L_0x03fe
            int r1 = r0.size()     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            if (r1 <= 0) goto L_0x03fe
            r1 = 0
        L_0x03dc:
            int r2 = r0.size()     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            if (r1 >= r2) goto L_0x03fe
            java.lang.Object r2 = r0.get(r1)     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            com.mpl.androidapp.database.entity.Contact r2 = (com.mpl.androidapp.database.entity.Contact) r2     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            java.lang.String r2 = r2.getPhoneNumber()     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            java.lang.String r2 = formatNumber(r2, r4)     // Catch:{ Exception -> 0x0440, all -> 0x042a }
            r5 = r26
            r5.add(r2)     // Catch:{ Exception -> 0x0428, all -> 0x0426 }
            int r1 = r1 + 1
            r26 = r5
            goto L_0x03dc
        L_0x03fe:
            r5 = r26
            goto L_0x0422
        L_0x0401:
            r5 = r26
            r1 = r27
            int r0 = r3.deleteByContactId(r1)     // Catch:{ Exception -> 0x0428, all -> 0x0426 }
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0428, all -> 0x0426 }
            java.lang.String r1 = "populateContacts delete contacts count "
            r4 = 0
            r2[r4] = r1     // Catch:{ Exception -> 0x0428, all -> 0x0426 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0428, all -> 0x0426 }
            r4 = 1
            r2[r4] = r1     // Catch:{ Exception -> 0x0428, all -> 0x0426 }
            com.mpl.androidapp.utils.MLogger.d(r12, r2)     // Catch:{ Exception -> 0x0428, all -> 0x0426 }
            if (r36 != 0) goto L_0x0422
            if (r0 <= 0) goto L_0x04a8
            r0 = 1
            goto L_0x04a9
        L_0x0422:
            r0 = r36
            goto L_0x04a9
        L_0x0426:
            r0 = move-exception
            goto L_0x042d
        L_0x0428:
            r0 = move-exception
            goto L_0x0443
        L_0x042a:
            r0 = move-exception
            r5 = r26
        L_0x042d:
            r1 = r37
            r2 = r38
            r11 = r0
            r23 = r9
            r6 = r25
        L_0x0436:
            r10 = r32
            r9 = r33
            r7 = r34
            r4 = r35
            goto L_0x0622
        L_0x0440:
            r0 = move-exception
            r5 = r26
        L_0x0443:
            r1 = r37
            r2 = r38
            r23 = r9
            r6 = r25
        L_0x044b:
            r10 = r32
            r9 = r33
            r7 = r34
            r4 = r35
            goto L_0x0568
        L_0x0455:
            r0 = move-exception
            r36 = r5
            r5 = r11
            r1 = r37
            r2 = r38
            r11 = r0
            r23 = r9
            r4 = r10
            r10 = r32
            goto L_0x0486
        L_0x0464:
            r0 = move-exception
            r36 = r5
            r5 = r11
            r1 = r37
            r2 = r38
            r23 = r9
            r4 = r10
        L_0x046f:
            r10 = r32
            goto L_0x0499
        L_0x0472:
            r0 = move-exception
            goto L_0x0479
        L_0x0474:
            r0 = move-exception
            goto L_0x048d
        L_0x0476:
            r0 = move-exception
            r32 = r5
        L_0x0479:
            r5 = r11
            r1 = r37
            r2 = r38
            r11 = r0
            r23 = r9
            r4 = r10
            r10 = r32
            r36 = 0
        L_0x0486:
            r9 = r6
            r6 = r15
            goto L_0x0622
        L_0x048a:
            r0 = move-exception
            r32 = r5
        L_0x048d:
            r5 = r11
            r1 = r37
            r2 = r38
            r23 = r9
            r4 = r10
            r10 = r32
            r36 = 0
        L_0x0499:
            r9 = r6
            r6 = r15
            goto L_0x0568
        L_0x049d:
            r32 = r5
            r33 = r6
            r34 = r7
            r35 = r10
            r5 = r11
            r25 = r15
        L_0x04a8:
            r0 = 0
        L_0x04a9:
            if (r9 == 0) goto L_0x04b4
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto L_0x04b4
            r9.close()
        L_0x04b4:
            org.json.JSONObject r1 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()
            if (r1 == 0) goto L_0x0537
            org.json.JSONObject r1 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()
            r2 = 0
            boolean r1 = r1.optBoolean(r8, r2)
            if (r1 == 0) goto L_0x0537
            int r0 = r25.size()
            if (r0 > 0) goto L_0x04e4
            int r0 = r13.size()
            if (r0 > 0) goto L_0x04e4
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x04d8
            goto L_0x04e4
        L_0x04d8:
            r1 = r37
            r2 = r38
            r4 = r35
            r6 = 1
            sendResponseToReact(r1, r3, r2, r6, r4)
            goto L_0x05ad
        L_0x04e4:
            r1 = r37
            r2 = r38
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            int r0 = r25.size()     // Catch:{ Exception -> 0x0528 }
            if (r0 <= 0) goto L_0x04f8
            r6 = r25
            r13.addAll(r6)     // Catch:{ Exception -> 0x0528 }
        L_0x04f8:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0528 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0528 }
            r7 = r34
            r4.put(r7, r0)     // Catch:{ Exception -> 0x0528 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0528 }
            r0.<init>(r13)     // Catch:{ Exception -> 0x0528 }
            r9 = r33
            r4.put(r9, r0)     // Catch:{ Exception -> 0x0528 }
            if (r24 == 0) goto L_0x0511
            r0 = r20
            goto L_0x0513
        L_0x0511:
            r0 = r21
        L_0x0513:
            r10 = r32
            r4.put(r10, r0)     // Catch:{ Exception -> 0x0528 }
            r5 = 2
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0526 }
            r5 = 0
            r0[r5] = r22     // Catch:{ Exception -> 0x0528 }
            r5 = 1
            r0[r5] = r4     // Catch:{ Exception -> 0x0528 }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x0528 }
            goto L_0x05e4
        L_0x0526:
            r0 = move-exception
            goto L_0x052a
        L_0x0528:
            r0 = move-exception
            r5 = 2
        L_0x052a:
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r5 = 0
            r6[r5] = r22
            r5 = 1
            r6[r5] = r0
            com.mpl.androidapp.utils.MLogger.e(r12, r6)
            goto L_0x05f5
        L_0x0537:
            r1 = r37
            r2 = r38
            r4 = r35
            r5 = 1
            if (r0 == 0) goto L_0x0600
            goto L_0x05fc
        L_0x0542:
            r0 = move-exception
            r9 = r6
            r4 = r10
            r6 = r15
            r10 = r5
            r5 = r11
            r11 = r0
            goto L_0x055a
        L_0x054a:
            r0 = move-exception
            r9 = r6
            r4 = r10
            r6 = r15
            r10 = r5
            r5 = r11
            goto L_0x0566
        L_0x0551:
            r0 = move-exception
            r9 = r6
            r4 = r10
            r6 = r15
            r10 = r5
            r5 = r11
            r11 = r0
            r24 = 0
        L_0x055a:
            r36 = 0
            goto L_0x0622
        L_0x055e:
            r0 = move-exception
            r9 = r6
            r4 = r10
            r6 = r15
            r10 = r5
            r5 = r11
            r24 = 0
        L_0x0566:
            r36 = 0
        L_0x0568:
            r11 = 2
            java.lang.Object[] r14 = new java.lang.Object[r11]     // Catch:{ all -> 0x0620 }
            java.lang.String r11 = "populateContacts:7 "
            r15 = 0
            r14[r15] = r11     // Catch:{ all -> 0x0620 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0620 }
            r11 = 1
            r14[r11] = r0     // Catch:{ all -> 0x0620 }
            com.mpl.androidapp.utils.MLogger.e(r12, r14)     // Catch:{ all -> 0x0620 }
            if (r23 == 0) goto L_0x0585
            boolean r0 = r23.isClosed()
            if (r0 != 0) goto L_0x0585
            r23.close()
        L_0x0585:
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()
            if (r0 == 0) goto L_0x05f9
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()
            r11 = 0
            boolean r0 = r0.optBoolean(r8, r11)
            if (r0 == 0) goto L_0x05f9
            int r0 = r6.size()
            if (r0 > 0) goto L_0x05b0
            int r0 = r13.size()
            if (r0 > 0) goto L_0x05b0
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x05a9
            goto L_0x05b0
        L_0x05a9:
            r8 = 1
            sendResponseToReact(r1, r3, r2, r8, r4)
        L_0x05ad:
            r1 = 3
            r5 = 1
            goto L_0x0604
        L_0x05b0:
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            int r0 = r6.size()     // Catch:{ Exception -> 0x05e8 }
            if (r0 <= 0) goto L_0x05be
            r13.addAll(r6)     // Catch:{ Exception -> 0x05e8 }
        L_0x05be:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x05e8 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x05e8 }
            r4.put(r7, r0)     // Catch:{ Exception -> 0x05e8 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x05e8 }
            r0.<init>(r13)     // Catch:{ Exception -> 0x05e8 }
            r4.put(r9, r0)     // Catch:{ Exception -> 0x05e8 }
            if (r24 == 0) goto L_0x05d3
            r0 = r20
            goto L_0x05d5
        L_0x05d3:
            r0 = r21
        L_0x05d5:
            r4.put(r10, r0)     // Catch:{ Exception -> 0x05e8 }
            r5 = 2
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05e6 }
            r5 = 0
            r0[r5] = r22     // Catch:{ Exception -> 0x05e8 }
            r5 = 1
            r0[r5] = r4     // Catch:{ Exception -> 0x05e8 }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x05e8 }
        L_0x05e4:
            r5 = 1
            goto L_0x05f5
        L_0x05e6:
            r0 = move-exception
            goto L_0x05ea
        L_0x05e8:
            r0 = move-exception
            r5 = 2
        L_0x05ea:
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r5 = 0
            r6[r5] = r22
            r5 = 1
            r6[r5] = r0
            com.mpl.androidapp.utils.MLogger.e(r12, r6)
        L_0x05f5:
            syncAllContactsWithServerNew(r1, r3, r2, r4)
            goto L_0x0603
        L_0x05f9:
            r5 = 1
            if (r36 == 0) goto L_0x0600
        L_0x05fc:
            syncAllContactsWithServer(r1, r3, r2)
            goto L_0x0603
        L_0x0600:
            sendResponseToReact(r1, r3, r2, r5, r4)
        L_0x0603:
            r1 = 3
        L_0x0604:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "populateContacts:9 [END] "
            r2 = 0
            r0[r2] = r1
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r18
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0[r5] = r1
            java.lang.String r1 = "millisecond"
            r2 = 2
            r0[r2] = r1
            com.mpl.androidapp.utils.MLogger.d(r12, r0)
            return
        L_0x0620:
            r0 = move-exception
        L_0x0621:
            r11 = r0
        L_0x0622:
            if (r23 == 0) goto L_0x062d
            boolean r0 = r23.isClosed()
            if (r0 != 0) goto L_0x062d
            r23.close()
        L_0x062d:
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()
            if (r0 == 0) goto L_0x069e
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()
            r14 = 0
            boolean r0 = r0.optBoolean(r8, r14)
            if (r0 == 0) goto L_0x069e
            int r0 = r6.size()
            if (r0 > 0) goto L_0x0656
            int r0 = r13.size()
            if (r0 > 0) goto L_0x0656
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x0651
            goto L_0x0656
        L_0x0651:
            r8 = 1
            sendResponseToReact(r1, r3, r2, r8, r4)
            goto L_0x06a8
        L_0x0656:
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            int r0 = r6.size()     // Catch:{ Exception -> 0x068d }
            if (r0 <= 0) goto L_0x0664
            r13.addAll(r6)     // Catch:{ Exception -> 0x068d }
        L_0x0664:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x068d }
            r0.<init>(r5)     // Catch:{ Exception -> 0x068d }
            r4.put(r7, r0)     // Catch:{ Exception -> 0x068d }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x068d }
            r0.<init>(r13)     // Catch:{ Exception -> 0x068d }
            r4.put(r9, r0)     // Catch:{ Exception -> 0x068d }
            if (r24 == 0) goto L_0x0679
            r0 = r20
            goto L_0x067b
        L_0x0679:
            r0 = r21
        L_0x067b:
            r4.put(r10, r0)     // Catch:{ Exception -> 0x068d }
            r5 = 2
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x068b }
            r5 = 0
            r0[r5] = r22     // Catch:{ Exception -> 0x068d }
            r5 = 1
            r0[r5] = r4     // Catch:{ Exception -> 0x068d }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x068d }
            goto L_0x069a
        L_0x068b:
            r0 = move-exception
            goto L_0x068f
        L_0x068d:
            r0 = move-exception
            r5 = 2
        L_0x068f:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r22
            r6 = 1
            r5[r6] = r0
            com.mpl.androidapp.utils.MLogger.e(r12, r5)
        L_0x069a:
            syncAllContactsWithServerNew(r1, r3, r2, r4)
            goto L_0x06a8
        L_0x069e:
            r6 = 1
            if (r36 == 0) goto L_0x06a5
            syncAllContactsWithServer(r1, r3, r2)
            goto L_0x06a8
        L_0x06a5:
            sendResponseToReact(r1, r3, r2, r6, r4)
        L_0x06a8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.contact.ContactUtils.populateContacts(android.content.Context, java.lang.String):void");
    }

    public static void populateContactsOnSeparateThread(Context context, String str) {
        String stringInNormalPref = MSharedPreferencesUtils.getStringInNormalPref(context, Constant.LAST_CONTACT_SYNC_TIME, "");
        if (stringInNormalPref == null || TextUtils.isEmpty(stringInNormalPref) || ConfigManager.getNormalConfig() == null || !ConfigManager.getNormalConfig().has("contact.sync.diff.duration")) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(context, str) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ String f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    ContactUtils.populateContacts(this.f$0, this.f$1);
                }
            });
            return;
        }
        int optInt = ConfigManager.getNormalConfig().optInt("contact.sync.diff.duration", 0);
        long j = new Duration(DateTime.parse(stringInNormalPref), new DateTime()).iMillis / 60000;
        if (optInt == 0 || j <= 0 || j >= ((long) optInt)) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(context, str) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ String f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    ContactUtils.populateContacts(this.f$0, this.f$1);
                }
            });
            return;
        }
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(context, MPLApplication.getDatabaseClient().getAppDatabase().contactDao(), str) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ ContactDao f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                ContactUtils.sendResponseToReact(this.f$0, this.f$1, this.f$2, true, "Success");
            }
        });
    }

    public static void populateSearchContactList(Context context, List<Contact> list) {
        try {
            MLogger.d(TAG, "searchContactFromLocalDb: ", Integer.valueOf(list.size()));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            PhoneNumberUtil instance = PhoneNumberUtil.getInstance();
            for (Contact next : list) {
                String phoneNumber = next.getPhoneNumber();
                MLogger.d(TAG, "syncAllContactsWithServer:1 ", phoneNumber);
                if (phoneNumber != null && !TextUtils.isEmpty(phoneNumber) && phoneNumber.length() > 6 && phoneNumber.matches(".*\\d.*")) {
                    String format = instance.format(instance.parse(phoneNumber, MBuildConfigUtils.getCountryCode().toUpperCase()), PhoneNumberFormat.E164);
                    MLogger.d(TAG, "syncAllContactsWithServer:2 ", format);
                    next.setPhoneNumber(format);
                    jSONArray.put(next.toJson());
                }
            }
            jSONObject.put("contacts", jSONArray);
            Intent intent = new Intent(Constant.INTENT_ACTION_CONTACT_SYNC);
            intent.putExtra("contactsValue", jSONObject.toString());
            context.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    public static void searchContact(Context context, String str) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_CONTACTS") == 0) {
            searchContactFromContactDb(context, str);
        } else {
            searchContactFromLocalDb(context, str);
        }
    }

    public static void searchContactFromContactDb(Context context, String str) {
        Context context2 = context;
        String str2 = str;
        Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI, str2);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor listOfContactNames = getListOfContactNames(context2, contentResolver, str2);
        ArrayList arrayList = new ArrayList();
        if (listOfContactNames != null && listOfContactNames.moveToFirst()) {
            MLogger.d(TAG, "searchContactFromContactDb:1 ", Integer.valueOf(listOfContactNames.getCount()));
            while (!listOfContactNames.isAfterLast()) {
                String string = listOfContactNames.getString(listOfContactNames.getColumnIndex("_id"));
                listOfContactNames.getString(listOfContactNames.getColumnIndex("lookup"));
                String string2 = listOfContactNames.getString(listOfContactNames.getColumnIndex("display_name"));
                StringBuilder outline82 = GeneratedOutlineSupport.outline82("search: ", string, " key: ", str2, " name: ");
                outline82.append(string2);
                MLogger.d(TAG, outline82.toString());
                String str3 = string2;
                Cursor query = contentResolver.query(Phone.CONTENT_URI, CONTACT_PHONE_NUMBER_PROJECTION, "contact_id = ?", new String[]{string}, null);
                if (query != null && query.moveToFirst()) {
                    MLogger.d(TAG, "searchContactFromContactDb:2 ", Integer.valueOf(query.getCount()));
                    while (!query.isAfterLast()) {
                        String string3 = query.getString(query.getColumnIndex("data1"));
                        String string4 = query.getString(query.getColumnIndex("photo_thumb_uri"));
                        MLogger.d(TAG, "searchContactFromContactDb: ", GeneratedOutlineSupport.outline50("phoneNumber: ", string3), GeneratedOutlineSupport.outline50("thumbNailUri: ", string4));
                        Contact contact = new Contact();
                        contact.setContactId(string);
                        String str4 = str3;
                        contact.setContactDisplayName(str4);
                        contact.setPhoneNumber(string3);
                        if (string4 != null) {
                            contact.setPhotoThumbUri(string4);
                        } else {
                            contact.setPhotoThumbUri("");
                        }
                        contact.setMplId("0");
                        arrayList.add(contact);
                        query.moveToNext();
                        str3 = str4;
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                listOfContactNames.moveToNext();
            }
            listOfContactNames.close();
        }
        populateSearchContactList(context2, arrayList);
    }

    public static void searchContactFromLocalDb(Context context, String str) {
        populateSearchContactList(context, MPLApplication.getDatabaseClient().getAppDatabase().contactDao().getContactsSearchBasedOnName(str));
    }

    public static void searchContactsOnSeparateThread(Context context, String str) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(context, str) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                ContactUtils.searchContact(this.f$0, this.f$1);
            }
        });
    }

    public static void sendResponseToReact(Context context, ContactDao contactDao, String str, boolean z, String str2) {
        List<Contact> list;
        MLogger.d(TAG, "sendResponseToReact:started ");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        char c2 = 65535;
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1039864516) {
                if (hashCode == 108329) {
                    if (str.equals("mpl")) {
                        c2 = 0;
                    }
                }
            } else if (str.equals("nonmpl")) {
                c2 = 1;
            }
            if (c2 == 0) {
                list = contactDao.getAllMPLContacts();
            } else if (c2 != 1) {
                list = contactDao.getContactsForReactSync();
            } else {
                list = contactDao.getAllNoNMPLContacts();
            }
            int challengeContactSyncLimit = MSharedPreferencesUtils.challengeContactSyncLimit();
            int i = 0;
            while (i < list.size() && i < challengeContactSyncLimit) {
                Contact contact = list.get(i);
                if (contact != null && !TextUtils.isEmpty(contact.getContactLookupKey()) && contact.getContactLookupKey().length() > 9) {
                    jSONArray.put(contact.toJson());
                }
                i++;
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "sendResponseToReact: ", e2);
            MLogger.d(TAG, "sendResponseToReact started but failed due to parsing ");
        }
        try {
            jSONObject.put("contacts", jSONArray);
            jSONObject.put("isSyncSuccess", z);
            jSONObject.put("failReason", str2);
            jSONObject.put("contactSize", jSONArray.length());
            Intent intent = new Intent(Constant.INTENT_ACTION_CONTACT_SYNC);
            intent.putExtra("contactsValue", jSONObject.toString());
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            MLogger.d(TAG, "sendResponseToReact: sent data to react", Integer.valueOf(jSONArray.length()));
        } catch (Exception e3) {
            MLogger.e(TAG, "sendResponseToReact: ", e3);
        }
    }

    public static void syncAllContactsWithServer(Context context, ContactDao contactDao, String str) {
        boolean[] zArr = {true};
        String[] strArr = {"Sync Success"};
        try {
            List<Contact> contactsForSyncServer = contactDao.getContactsForSyncServer();
            MLogger.d(TAG, "syncAllContactsWithServer: ", Integer.valueOf(contactsForSyncServer.size()));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            PhoneNumberUtil instance = PhoneNumberUtil.getInstance();
            for (Contact phoneNumber : contactsForSyncServer) {
                String phoneNumber2 = phoneNumber.getPhoneNumber();
                MLogger.d(TAG, "syncAllContactsWithServer:1 ", phoneNumber2);
                if (phoneNumber2 != null) {
                    try {
                        if (!TextUtils.isEmpty(phoneNumber2) && phoneNumber2.length() > 6 && phoneNumber2.matches(".*\\d.*")) {
                            String format = instance.format(instance.parse(phoneNumber2, MBuildConfigUtils.getCountryCode().toUpperCase()), PhoneNumberFormat.E164);
                            MLogger.d(TAG, "syncAllContactsWithServer:2 ", format);
                            jSONArray.put(format);
                        }
                    } catch (Exception e2) {
                        MLogger.e(TAG, "syncAllContactsWithServer:parsing error ", e2);
                    }
                }
            }
            jSONObject.put("mobileNum", jSONArray);
            MLogger.d(TAG, "syncAllContactsWithServer:3 ", jSONObject.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            NetworkCallParams build = new Builder().setUrl(MBuildConfigUtils.getMainUrl() + ApiEndPoints.UPLOAD_CONTACTS_TO_SERVER).setMRequestBody(jSONObject.toString()).setMHeaders(arrayList).build();
            MLogger.d(TAG, "syncAllContactsWithServer:started ");
            final ContactDao contactDao2 = contactDao;
            final Context context2 = context;
            final boolean[] zArr2 = zArr;
            final String str2 = str;
            final String[] strArr2 = strArr;
            AnonymousClass2 r4 = new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.d(IResponseListener.TAG, "syncAllContactsWithServer:failed ");
                    MLogger.e(IResponseListener.TAG, "syncAllContactsWithServer:onResponseFail: ", exc);
                    boolean[] zArr = zArr2;
                    zArr[0] = false;
                    String[] strArr = strArr2;
                    strArr[0] = "Network Call Fail";
                    ContactUtils.sendResponseToReact(context2, ContactDao.this, str2, zArr[0], strArr[0]);
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "syncAllContactsWithServer:finished ");
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("payload")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("payload");
                            if (optJSONObject != null && optJSONObject.has("users")) {
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("users");
                                if (optJSONObject2 != null) {
                                    Iterator<String> keys = optJSONObject2.keys();
                                    ArrayList arrayList = new ArrayList();
                                    ArrayList arrayList2 = new ArrayList();
                                    while (keys.hasNext()) {
                                        arrayList2.clear();
                                        String next = keys.next();
                                        String valueOf = String.valueOf(optJSONObject2.optInt(next, 0));
                                        arrayList2.add(next);
                                        ContactDao.this.updateMplIds(valueOf, arrayList2);
                                        arrayList.add(MSharedPreferencesUtils.getMQTTClientPrefix() + valueOf);
                                    }
                                    if (!arrayList.isEmpty() && MSharedPreferencesUtils.isMQTTSubscribeToContactRequired()) {
                                        EventPublishHelper.subscribeToMqttChannel(context2, (String[]) arrayList.toArray(new String[0]), true);
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                        MLogger.d(IResponseListener.TAG, "syncAllContactsWithServer:finished but parsing failed ");
                        zArr2[0] = false;
                    }
                    MSharedPreferencesUtils.saveStringInNormalPref(context2, Constant.LAST_CONTACT_SYNC_TIME, new DateTime().toString());
                    ContactUtils.sendResponseToReact(context2, ContactDao.this, str2, zArr2[0], strArr2[0]);
                }
            };
            NetworkUtils.doPostRequest(build, r4, "upload_contacts");
        } catch (Exception e3) {
            MLogger.e(TAG, "syncAllContactsWithServer: ", e3);
            zArr[0] = false;
            if (e3.getMessage() != null) {
                strArr[0] = e3.getMessage();
            } else {
                strArr[0] = "Parse Exception";
            }
        }
    }

    public static void syncAllContactsWithServerNew(Context context, ContactDao contactDao, String str, JSONObject jSONObject) {
        boolean[] zArr = {true};
        String[] strArr = {"Sync Success"};
        String str2 = ApiEndPoints.UPLOAD_CONTACTS_TO_SERVER;
        try {
            if (ConfigManager.getPlatformConfig() != null && ConfigManager.getPlatformConfig().optBoolean("contact.new.sync.enabled", false) && ConfigManager.getNormalConfig() != null && ConfigManager.getNormalConfig().has("contact.new.sync.url")) {
                str2 = ConfigManager.getNormalConfig().optString("contact.new.sync.url", str2);
            }
            String str3 = MBuildConfigUtils.getMainUrl() + str2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            NetworkCallParams build = new Builder().setUrl(str3).setMRequestBody(jSONObject.toString()).setMHeaders(arrayList).build();
            MLogger.d(TAG, "syncAllContactsWithServerNew:started ");
            final ContactDao contactDao2 = contactDao;
            final Context context2 = context;
            final boolean[] zArr2 = zArr;
            final String str4 = str;
            final String[] strArr2 = strArr;
            final JSONObject jSONObject2 = jSONObject;
            AnonymousClass1 r3 = new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.d(IResponseListener.TAG, "syncAllContactsWithServer:failed ");
                    MLogger.e(IResponseListener.TAG, "syncAllContactsWithServer:onResponseFail: ", exc);
                    if (jSONObject2.has("updateType") && jSONObject2.optString("updateType", "") != null && jSONObject2.optString("updateType").equalsIgnoreCase("INSERT")) {
                        ContactDao.this.deleteAllContact();
                    }
                    boolean[] zArr = zArr2;
                    zArr[0] = false;
                    String[] strArr = strArr2;
                    strArr[0] = "Network Call Fail";
                    ContactUtils.sendResponseToReact(context2, ContactDao.this, str4, zArr[0], strArr[0]);
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "syncAllContactsWithServer:finished ");
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("payload")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("payload");
                            if (optJSONObject != null && optJSONObject.has("users")) {
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("users");
                                if (optJSONObject2 != null) {
                                    Iterator<String> keys = optJSONObject2.keys();
                                    ArrayList arrayList = new ArrayList();
                                    ArrayList arrayList2 = new ArrayList();
                                    while (keys.hasNext()) {
                                        arrayList2.clear();
                                        String next = keys.next();
                                        String valueOf = String.valueOf(optJSONObject2.optInt(next, 0));
                                        arrayList2.add(next);
                                        ContactDao.this.updateMplIds(valueOf, arrayList2);
                                        arrayList.add(MSharedPreferencesUtils.getMQTTClientPrefix() + valueOf);
                                    }
                                    if (!arrayList.isEmpty() && MSharedPreferencesUtils.isMQTTSubscribeToContactRequired()) {
                                        EventPublishHelper.subscribeToMqttChannel(context2, (String[]) arrayList.toArray(new String[0]), true);
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                        MLogger.d(IResponseListener.TAG, "syncAllContactsWithServerNew:finished but parsing failed ");
                        zArr2[0] = false;
                    }
                    MSharedPreferencesUtils.saveStringInNormalPref(context2, Constant.LAST_CONTACT_SYNC_TIME, new DateTime().toString());
                    ContactUtils.sendResponseToReact(context2, ContactDao.this, str4, zArr2[0], strArr2[0]);
                }
            };
            NetworkUtils.doPostRequest(build, r3, "upload_contacts");
        } catch (Exception e2) {
            MLogger.e(TAG, "syncAllContactsWithServer: ", e2);
            zArr[0] = false;
            if (e2.getMessage() != null) {
                strArr[0] = e2.getMessage();
            } else {
                strArr[0] = "Parse Exception";
            }
        }
    }
}
