package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.beans.BHWeekDays;
import com.freshchat.consumer.sdk.beans.BHWorkingDays;
import com.freshchat.consumer.sdk.beans.BusinessHours;
import com.freshchat.consumer.sdk.beans.OperatingHoursResponse;
import com.freshchat.consumer.sdk.c.a.o;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.HashMap;
import java.util.Map;

public class p extends b {
    public static final String[] jJ = new o().cR();

    public p(Context context) {
        super(context);
    }

    private ContentValues a(BusinessHours businessHours) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(businessHours.getOperatingHoursId()));
        contentValues.put("name", businessHours.getName());
        contentValues.put("timezone", businessHours.getTimezone());
        if (businessHours.getWeekDaysBH() != null) {
            contentValues.put("days_bh", ab.in().toJson(businessHours.getWeekDaysBH()));
        }
        if (businessHours.getWorkingDays() != null) {
            contentValues.put("days_working", ab.in().toJson(businessHours.getWorkingDays()));
        }
        contentValues.put(RNGestureHandlerModule.KEY_ENABLED, Integer.valueOf(businessHours.isEnabled() ? 1 : 0));
        contentValues.put("default_bh", Integer.valueOf(businessHours.isDefaultBhr() ? 1 : 0));
        contentValues.put("bh_type", businessHours.getOperatingHoursType());
        return contentValues;
    }

    private BusinessHours m(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        BusinessHours businessHours = new BusinessHours();
        businessHours.setOperatingHoursId(cursor.getLong(map.get("_id").intValue()));
        businessHours.setName(cursor.getString(map.get("name").intValue()));
        businessHours.setTimezone(cursor.getString(map.get("timezone").intValue()));
        businessHours.setWeekDaysBH((BHWeekDays) ab.in().fromJson(cursor.getString(map.get("days_bh").intValue()), BHWeekDays.class));
        businessHours.setWorkingDays((BHWorkingDays) ab.in().fromJson(cursor.getString(map.get("days_working").intValue()), BHWorkingDays.class));
        boolean z = false;
        businessHours.setEnabled(cursor.getInt(map.get(RNGestureHandlerModule.KEY_ENABLED).intValue()) == 1);
        if (cursor.getInt(map.get("default_bh").intValue()) == 1) {
            z = true;
        }
        businessHours.setDefaultBhr(z);
        businessHours.setOperatingHoursType(cursor.getString(map.get("bh_type").intValue()));
        return businessHours;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.freshchat.consumer.sdk.beans.BusinessHours] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r11v8, types: [com.freshchat.consumer.sdk.beans.BusinessHours] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
      assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [com.freshchat.consumer.sdk.beans.BusinessHours, android.database.Cursor]
      mth insns count: 29
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.BusinessHours D(long r10) {
        /*
            r9 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.cs()     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r2 = "business_hours"
            java.lang.String[] r3 = jJ     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r4 = "_id=? AND enabled=1"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            r6 = 0
            java.lang.String r10 = java.lang.Long.toString(r10)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            r5[r6] = r10     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            boolean r11 = com.freshchat.consumer.sdk.c.b.b(r10)     // Catch:{ Exception -> 0x002c }
            if (r11 == 0) goto L_0x0035
            java.util.Map r11 = r9.a(r10)     // Catch:{ Exception -> 0x002c }
            com.freshchat.consumer.sdk.beans.BusinessHours r11 = r9.m(r10, r11)     // Catch:{ Exception -> 0x002c }
            r0 = r11
            goto L_0x0035
        L_0x002c:
            r11 = move-exception
            goto L_0x0032
        L_0x002e:
            r11 = move-exception
            goto L_0x003b
        L_0x0030:
            r11 = move-exception
            r10 = r0
        L_0x0032:
            com.freshchat.consumer.sdk.j.q.a(r11)     // Catch:{ all -> 0x0039 }
        L_0x0035:
            com.freshchat.consumer.sdk.c.b.c(r10)
            return r0
        L_0x0039:
            r11 = move-exception
            r0 = r10
        L_0x003b:
            com.freshchat.consumer.sdk.c.b.c(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.p.D(long):com.freshchat.consumer.sdk.beans.BusinessHours");
    }

    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("bh_type", GeneratedOutlineSupport.outline26(hashMap, "default_bh", GeneratedOutlineSupport.outline26(hashMap, RNGestureHandlerModule.KEY_ENABLED, GeneratedOutlineSupport.outline26(hashMap, "days_working", GeneratedOutlineSupport.outline26(hashMap, "days_bh", GeneratedOutlineSupport.outline26(hashMap, "timezone", GeneratedOutlineSupport.outline26(hashMap, "name", Integer.valueOf(cursor.getColumnIndex("name")), cursor, "timezone"), cursor, "days_bh"), cursor, "days_working"), cursor, RNGestureHandlerModule.KEY_ENABLED), cursor, "default_bh"), cursor, "bh_type"));
        }
        return hashMap;
    }

    public void a(OperatingHoursResponse operatingHoursResponse) {
        SQLiteDatabase cs = cs();
        cs.beginTransaction();
        try {
            cs.delete("business_hours", null, null);
            if (k.a(operatingHoursResponse.getOperatingHours())) {
                for (BusinessHours a2 : operatingHoursResponse.getOperatingHours()) {
                    cs.insert("business_hours", null, a(a2));
                }
            }
            cs.setTransactionSuccessful();
        } catch (Exception unused) {
            ai.e("FRESHCHAT_WARNING", c.BUSINESS_HOURS_UPDATE_FAILED.toString());
        } catch (Throwable th) {
            cs.endTransaction();
            throw th;
        }
        cs.endTransaction();
    }

    public BusinessHours fm() {
        Cursor cursor;
        BusinessHours businessHours = null;
        try {
            cursor = cs().query("business_hours", jJ, "default_bh=1 AND enabled=1", null, null, null, null);
            try {
                if (b.b(cursor)) {
                    businessHours = m(cursor, a(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return businessHours;
                } catch (Throwable th) {
                    th = th;
                    b.c(cursor);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.a(e);
            b.c(cursor);
            return businessHours;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            cursor = null;
            th = th3;
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return businessHours;
    }
}
