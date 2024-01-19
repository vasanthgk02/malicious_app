package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.c.a.m;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class k extends b {
    public static final String[] cR = new m().cR();
    public final Context context;

    public k(Context context2) {
        super(context2);
        this.context = context2;
    }

    private ContentValues b(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("meta_key", str);
        contentValues.put("meta_value", str2);
        contentValues.put("is_uploaded", Integer.valueOf(0));
        contentValues.put("meta_type", Integer.valueOf(z ? 2 : 1));
        return contentValues;
    }

    private void b(String str, String str2) {
        if (as.a(str2)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_uploaded", Integer.valueOf(1));
            cs().update("user_meta", contentValues, "meta_key = ?", new String[]{str});
        }
    }

    private void bu(String str) {
        try {
            cs().delete("user_meta", "meta_key = ? ", new String[]{str});
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d8, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d9, code lost:
        switch(r5) {
            case 0: goto L_0x00ff;
            case 1: goto L_0x00fb;
            case 2: goto L_0x00f7;
            case 3: goto L_0x00f3;
            case 4: goto L_0x00ef;
            case 5: goto L_0x00eb;
            case 6: goto L_0x00e7;
            case 7: goto L_0x00e3;
            case 8: goto L_0x00df;
            default: goto L_0x00dc;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00df, code lost:
        r0.setJwtIdToken(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e3, code lost:
        r0.setLocale(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        r0.setRestoreId(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00eb, code lost:
        r0.setExternalId(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ef, code lost:
        r0.setPhoneCountry(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f3, code lost:
        r0.setPhone(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        r0.setEmail(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fb, code lost:
        r0.setLastName(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ff, code lost:
        r0.setFirstName(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0103, code lost:
        com.freshchat.consumer.sdk.j.ai.i("FRESHCHAT", "Unknown key from the user meta table");
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ Exception -> 0x0014, all -> 0x0011 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.User a(boolean r12, boolean r13) {
        /*
            r11 = this;
            com.freshchat.consumer.sdk.beans.User r0 = new com.freshchat.consumer.sdk.beans.User
            r0.<init>()
            r1 = 0
            if (r12 == 0) goto L_0x000b
            if (r13 == 0) goto L_0x000b
            goto L_0x001c
        L_0x000b:
            if (r12 == 0) goto L_0x0017
            java.lang.String r12 = "is_uploaded = 1"
        L_0x000f:
            r5 = r12
            goto L_0x001d
        L_0x0011:
            r12 = move-exception
            goto L_0x0119
        L_0x0014:
            r12 = move-exception
            goto L_0x0112
        L_0x0017:
            if (r13 == 0) goto L_0x001c
            java.lang.String r12 = "is_uploaded = 0"
            goto L_0x000f
        L_0x001c:
            r5 = r1
        L_0x001d:
            android.database.sqlite.SQLiteDatabase r2 = r11.cs()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r3 = "user_meta"
            java.lang.String[] r4 = cR     // Catch:{ Exception -> 0x0014 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0014 }
            boolean r12 = com.freshchat.consumer.sdk.c.b.b(r1)     // Catch:{ Exception -> 0x0014 }
            if (r12 == 0) goto L_0x0115
            java.util.Map r12 = r11.a(r1)     // Catch:{ Exception -> 0x0014 }
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x0014 }
            r13.<init>()     // Catch:{ Exception -> 0x0014 }
        L_0x003d:
            java.lang.String r2 = "meta_key"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ Exception -> 0x0014 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0014 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r3 = "meta_value"
            java.lang.Object r3 = r12.get(r3)     // Catch:{ Exception -> 0x0014 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0014 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r4 = "meta_type"
            java.lang.Object r4 = r12.get(r4)     // Catch:{ Exception -> 0x0014 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0014 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0014 }
            int r4 = r1.getInt(r4)     // Catch:{ Exception -> 0x0014 }
            r5 = 2
            if (r4 != r5) goto L_0x0075
            r13.put(r2, r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x0075:
            r4 = -1
            int r6 = r2.hashCode()     // Catch:{ Exception -> 0x0014 }
            switch(r6) {
                case -1930861854: goto L_0x00ce;
                case -1926820033: goto L_0x00c3;
                case -1625524743: goto L_0x00b9;
                case -1253034262: goto L_0x00b0;
                case -1243010884: goto L_0x00a6;
                case 12946636: goto L_0x009c;
                case 371829523: goto L_0x0092;
                case 915726814: goto L_0x0088;
                case 2129560620: goto L_0x007e;
                default: goto L_0x007d;
            }     // Catch:{ Exception -> 0x0014 }
        L_0x007d:
            goto L_0x00d8
        L_0x007e:
            java.lang.String r5 = "fc_user_first_name"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 0
            goto L_0x00d9
        L_0x0088:
            java.lang.String r5 = "fc_user_restore_id"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 6
            goto L_0x00d9
        L_0x0092:
            java.lang.String r5 = "fc_user_phone_country"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 4
            goto L_0x00d9
        L_0x009c:
            java.lang.String r5 = "fc_user_locale"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 7
            goto L_0x00d9
        L_0x00a6:
            java.lang.String r5 = "fc_user_phone"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 3
            goto L_0x00d9
        L_0x00b0:
            java.lang.String r6 = "fc_user_email"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00b9:
            java.lang.String r5 = "fc_user_ext_identifier"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 5
            goto L_0x00d9
        L_0x00c3:
            java.lang.String r5 = "fc_user_jwt_id_token"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 8
            goto L_0x00d9
        L_0x00ce:
            java.lang.String r5 = "fc_user_last_name"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x00d8
            r5 = 1
            goto L_0x00d9
        L_0x00d8:
            r5 = -1
        L_0x00d9:
            switch(r5) {
                case 0: goto L_0x00ff;
                case 1: goto L_0x00fb;
                case 2: goto L_0x00f7;
                case 3: goto L_0x00f3;
                case 4: goto L_0x00ef;
                case 5: goto L_0x00eb;
                case 6: goto L_0x00e7;
                case 7: goto L_0x00e3;
                case 8: goto L_0x00df;
                default: goto L_0x00dc;
            }     // Catch:{ Exception -> 0x0014 }
        L_0x00dc:
            java.lang.String r2 = "FRESHCHAT"
            goto L_0x0103
        L_0x00df:
            r0.setJwtIdToken(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00e3:
            r0.setLocale(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00e7:
            r0.setRestoreId(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00eb:
            r0.setExternalId(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00ef:
            r0.setPhoneCountry(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00f3:
            r0.setPhone(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00f7:
            r0.setEmail(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00fb:
            r0.setLastName(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x00ff:
            r0.setFirstName(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0108
        L_0x0103:
            java.lang.String r3 = "Unknown key from the user meta table"
            com.freshchat.consumer.sdk.j.ai.i(r2, r3)     // Catch:{ Exception -> 0x0014 }
        L_0x0108:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0014 }
            if (r2 != 0) goto L_0x003d
            r0.setMeta(r13)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0115
        L_0x0112:
            com.freshchat.consumer.sdk.j.q.a(r12)     // Catch:{ all -> 0x0011 }
        L_0x0115:
            com.freshchat.consumer.sdk.c.b.c(r1)
            return r0
        L_0x0119:
            com.freshchat.consumer.sdk.c.b.c(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.k.a(boolean, boolean):com.freshchat.consumer.sdk.beans.User");
    }

    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("meta_key", Integer.valueOf(cursor.getColumnIndex("meta_key")));
            hashMap.put("meta_type", GeneratedOutlineSupport.outline26(hashMap, "meta_value", Integer.valueOf(cursor.getColumnIndex("meta_value")), cursor, "meta_type"));
        }
        return hashMap;
    }

    public void a(User user) {
        a("fc_user_first_name", user.getFirstName(), false);
        a("fc_user_last_name", user.getLastName(), false);
        a("fc_user_email", user.getEmail(), false);
        a("fc_user_phone", user.getPhone(), false);
        a("fc_user_phone_country", user.getPhoneCountry(), false);
        a("fc_user_ext_identifier", user.getExternalId(), false);
        a("fc_user_restore_id", user.getRestoreId(), false);
        a("fc_user_locale", user.getLocale(), false);
        a("fc_user_jwt_id_token", user.getJwtIdToken(), false);
        for (Entry next : user.getMeta().entrySet()) {
            a((String) next.getKey(), (String) next.getValue(), true);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (as.a(str2)) {
            ContentValues b2 = b(str, str2, z);
            if (cs().update("user_meta", b2, "meta_key= ? AND meta_value!= ?", new String[]{str, str2}) == 0) {
                Cursor query = cs().query("user_meta", null, "meta_key = ?", new String[]{str}, null, null, null);
                if (b.j(query)) {
                    cs().insert("user_meta", null, b2);
                }
                b.c(query);
            }
        }
    }

    public void b(User user) {
        for (Entry next : user.getMeta().entrySet()) {
            b((String) next.getKey(), (String) next.getValue());
        }
        b("fc_user_first_name", user.getFirstName());
        b("fc_user_last_name", user.getLastName());
        b("fc_user_email", user.getEmail());
        b("fc_user_phone", user.getPhone());
        b("fc_user_phone_country", user.getPhoneCountry());
        b("fc_user_ext_identifier", user.getExternalId());
        b("fc_user_restore_id", user.getRestoreId());
        b("fc_user_locale", user.getLocale());
        b("fc_user_jwt_id_token", user.getJwtIdToken());
    }

    public boolean bV() {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = cs().query("user_meta", cR, "is_uploaded = 0", null, null, null, null, null);
            if (cursor.getCount() == 0) {
                z = true;
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return z;
    }

    public void iu() {
        bu("fc_user_restore_id");
    }
}
