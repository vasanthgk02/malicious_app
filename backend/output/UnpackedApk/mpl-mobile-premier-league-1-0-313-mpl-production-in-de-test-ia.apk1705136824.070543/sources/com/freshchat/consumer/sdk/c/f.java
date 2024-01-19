package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.UnknownFragment;
import com.freshchat.consumer.sdk.c.a.i;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f extends b {
    public static final String[] eh = new i().cR();

    public static class a {
        public MessageFragment ei;
        public String ej;
        public int position;

        public a(MessageFragment messageFragment, String str, int i) {
            this.ei = messageFragment;
            this.ej = str;
            this.position = i;
        }
    }

    public f(Context context) {
        super(context);
    }

    private ContentValues c(MessageFragment messageFragment, String str, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("position", Integer.valueOf(i));
        contentValues.put("uploaded", Integer.valueOf(i2));
        String aH = as.aH(messageFragment.getContent());
        String aH2 = as.aH(messageFragment.getContentType());
        contentValues.put("content", aH);
        contentValues.put("content_type", aH2);
        contentValues.put("frag_type", Integer.valueOf(messageFragment.getFragmentType()));
        try {
            JSONObject jSONObject = new JSONObject(ab.io().toJson(messageFragment, new m(this).getType()));
            jSONObject.remove("content");
            jSONObject.remove("contentType");
            jSONObject.remove("fragmentType");
            contentValues.put("extras_json", jSONObject.toString());
        } catch (Exception e2) {
            q.a(e2);
        }
        return contentValues;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00bf A[Catch:{ Exception -> 0x00f1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.freshchat.consumer.sdk.c.f.a e(android.database.Cursor r11, java.util.Map<java.lang.String, java.lang.Integer> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "content"
            r1 = 0
            boolean r2 = com.freshchat.consumer.sdk.c.b.d(r11)     // Catch:{ Exception -> 0x00f1 }
            if (r2 == 0) goto L_0x00f5
            java.lang.String r2 = "_id"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ Exception -> 0x00f1 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x00f1 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r2 = r11.getString(r2)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r3 = "position"
            java.lang.Object r3 = r12.get(r3)     // Catch:{ Exception -> 0x00f1 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x00f1 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00f1 }
            int r3 = r11.getInt(r3)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r4 = "frag_type"
            java.lang.Object r4 = r12.get(r4)     // Catch:{ Exception -> 0x00f1 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x00f1 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x00f1 }
            int r4 = r11.getInt(r4)     // Catch:{ Exception -> 0x00f1 }
            java.lang.Object r5 = r12.get(r0)     // Catch:{ Exception -> 0x00f1 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x00f1 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r5 = r11.getString(r5)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r6 = "content_type"
            java.lang.Object r6 = r12.get(r6)     // Catch:{ Exception -> 0x00f1 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x00f1 }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r6 = r11.getString(r6)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = "extras_json"
            java.lang.Object r12 = r12.get(r7)     // Catch:{ Exception -> 0x00f1 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x00f1 }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r11 = r11.getString(r12)     // Catch:{ Exception -> 0x00f1 }
            com.freshchat.consumer.sdk.beans.fragment.FragmentType r12 = com.freshchat.consumer.sdk.beans.fragment.FragmentType.fromInt(r4)     // Catch:{ Exception -> 0x00f1 }
            if (r12 == 0) goto L_0x00bc
            com.freshchat.consumer.sdk.beans.fragment.FragmentType r7 = com.freshchat.consumer.sdk.beans.fragment.FragmentType.TEMPLATE     // Catch:{ Exception -> 0x00f1 }
            if (r12 != r7) goto L_0x00ad
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x0091 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = "templateType"
            java.lang.String r12 = r12.getString(r7)     // Catch:{ Exception -> 0x0091 }
            com.freshchat.consumer.sdk.beans.fragment.TemplateType r12 = com.freshchat.consumer.sdk.beans.fragment.TemplateType.get(r12)     // Catch:{ Exception -> 0x0091 }
            if (r12 == 0) goto L_0x00bc
            com.freshchat.consumer.sdk.j.ab r7 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0091 }
            java.lang.Class r12 = r12.getClz()     // Catch:{ Exception -> 0x0091 }
            java.lang.Object r12 = r7.fromJson(r11, r12)     // Catch:{ Exception -> 0x0091 }
            com.freshchat.consumer.sdk.beans.fragment.MessageFragment r12 = (com.freshchat.consumer.sdk.beans.fragment.MessageFragment) r12     // Catch:{ Exception -> 0x0091 }
            goto L_0x00bd
        L_0x0091:
            r12 = move-exception
            java.lang.String r7 = "FRESHCHAT"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1 }
            r8.<init>()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r9 = "Failed to parse TemplateFragment. "
            r8.append(r9)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00f1 }
            r8.append(r12)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r12 = r8.toString()     // Catch:{ Exception -> 0x00f1 }
            com.freshchat.consumer.sdk.j.ai.e(r7, r12)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00bc
        L_0x00ad:
            com.freshchat.consumer.sdk.j.ab r7 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x00f1 }
            java.lang.Class r12 = r12.getClz()     // Catch:{ Exception -> 0x00f1 }
            java.lang.Object r12 = r7.fromJson(r11, r12)     // Catch:{ Exception -> 0x00f1 }
            com.freshchat.consumer.sdk.beans.fragment.MessageFragment r12 = (com.freshchat.consumer.sdk.beans.fragment.MessageFragment) r12     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00bd
        L_0x00bc:
            r12 = r1
        L_0x00bd:
            if (r12 != 0) goto L_0x00e4
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            r12.<init>()     // Catch:{ Exception -> 0x00f1 }
            boolean r7 = com.freshchat.consumer.sdk.j.as.a(r11)     // Catch:{ Exception -> 0x00f1 }
            if (r7 == 0) goto L_0x00cf
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00f1 }
        L_0x00cf:
            r12.put(r0, r5)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r11 = "contentType"
            r12.put(r11, r6)     // Catch:{ Exception -> 0x00f1 }
            com.freshchat.consumer.sdk.beans.fragment.UnknownFragment r11 = new com.freshchat.consumer.sdk.beans.fragment.UnknownFragment     // Catch:{ Exception -> 0x00f1 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00f1 }
            r11.setRawJsonOfUnsupportedType(r12)     // Catch:{ Exception -> 0x00f1 }
            r12 = r11
        L_0x00e4:
            com.freshchat.consumer.sdk.beans.fragment.MessageFragment r11 = r12.setContent(r5)     // Catch:{ Exception -> 0x00f1 }
            r11.setContentType(r6)     // Catch:{ Exception -> 0x00f1 }
            com.freshchat.consumer.sdk.c.f$a r11 = new com.freshchat.consumer.sdk.c.f$a     // Catch:{ Exception -> 0x00f1 }
            r11.<init>(r12, r2, r3)     // Catch:{ Exception -> 0x00f1 }
            return r11
        L_0x00f1:
            r11 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r11)
        L_0x00f5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.f.e(android.database.Cursor, java.util.Map):com.freshchat.consumer.sdk.c.f$a");
    }

    public List<MessageFragment> W(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("fragments", eh, "_id = ?", new String[]{str}, null, null, "position");
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    a e2 = e(cursor, a2);
                    if (e2 != null) {
                        arrayList.add(e2.ei);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e3) {
            q.a(e3);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Boolean> a(SQLiteDatabase sQLiteDatabase, List<MessageFragment> list, String str, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            int b2 = k.b((Collection<?>) list);
            for (int i2 = 0; i2 < b2; i2++) {
                arrayList.add(Boolean.valueOf(a(sQLiteDatabase, list.get(i2), str, i2, i)));
            }
        } catch (Exception e2) {
            arrayList.add(Boolean.FALSE);
            q.a(e2);
            throw e2;
        } catch (Exception e3) {
            q.a(e3);
        }
        return arrayList;
    }

    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("uploaded", GeneratedOutlineSupport.outline26(hashMap, "extras_json", GeneratedOutlineSupport.outline26(hashMap, "content", GeneratedOutlineSupport.outline26(hashMap, "content_type", GeneratedOutlineSupport.outline26(hashMap, "frag_type", GeneratedOutlineSupport.outline26(hashMap, "position", Integer.valueOf(cursor.getColumnIndex("position")), cursor, "frag_type"), cursor, "content_type"), cursor, "content"), cursor, "extras_json"), cursor, "uploaded"));
        }
        return hashMap;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("fragments", eh, "extras_json LIKE ?", new String[]{"%rawJsonOfUnsupportedType%"}, null, null, null);
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                Integer num = a2.get("extras_json");
                if (num == null) {
                    b.c(cursor);
                    return;
                }
                Integer num2 = a2.get("uploaded");
                if (num2 == null) {
                    b.c(cursor);
                    return;
                }
                do {
                    String string = cursor.getString(num.intValue());
                    if (!as.isEmpty(string) && string.contains("rawJsonOfUnsupportedType")) {
                        try {
                            a e2 = e(cursor, a2);
                            if (e2 != null && (e2.ei instanceof UnknownFragment)) {
                                ((UnknownFragment) e2.ei).setRawJsonOfUnsupportedType(new JSONObject(((UnknownFragment) e2.ei).getRawJsonOfUnsupportedType()).getString("rawJsonOfUnsupportedType"));
                                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                                a(sQLiteDatabase2, e2.ei, e2.ej, e2.position, cursor.getInt(num2.intValue()));
                            }
                        } catch (Exception e3) {
                            q.a(e3);
                        }
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e4) {
            q.a(e4);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, MessageFragment messageFragment, String str, int i, int i2) {
        boolean z = false;
        try {
            if (sQLiteDatabase.replace("fragments", null, c(messageFragment, str, i, i2)) != -1) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            q.a(e2);
            return false;
        }
    }

    public boolean b(MessageFragment messageFragment, String str, int i, int i2) {
        try {
            ContentValues c2 = c(messageFragment, str, i, i2);
            cs().update("fragments", c2, "_id=? AND position=?", new String[]{str, String.valueOf(i)});
            return true;
        } catch (Exception e2) {
            q.a(e2);
            return false;
        }
    }

    public Map<String, List<MessageFragment>> h(long j) {
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery("SELECT fragments.* FROM fragments JOIN message ON message._id = fragments._id WHERE display!=-1 AND channel_id=? ORDER BY _id,position", new String[]{Long.toString(j)});
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    a e2 = e(cursor, a2);
                    if (e2 != null) {
                        if (!hashMap.containsKey(e2.ej)) {
                            hashMap.put(e2.ej, new ArrayList());
                        }
                        List list = (List) hashMap.get(e2.ej);
                        list.add(e2.position, e2.ei);
                        hashMap.put(e2.ej, list);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e3) {
            q.a(e3);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashMap;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r13v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v7
      assigns: [java.lang.String, ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
      uses: [android.database.Cursor, java.lang.String]
      mth insns count: 69
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String z(long r13) {
        /*
            r12 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a3 }
            r1.<init>()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "SELECT fragments.* FROM fragments JOIN message ON message._id = fragments._id WHERE display!=-1 AND frag_type="
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            com.freshchat.consumer.sdk.beans.fragment.FragmentType r2 = com.freshchat.consumer.sdk.beans.fragment.FragmentType.CALENDAR_EVENT     // Catch:{ Exception -> 0x00a3 }
            int r2 = r2.asInt()     // Catch:{ Exception -> 0x00a3 }
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = " AND "
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "channel_id"
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "=? ORDER BY "
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "_id"
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = ","
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = "position"
            r1.append(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00a3 }
            android.database.sqlite.SQLiteDatabase r2 = r12.cs()     // Catch:{ Exception -> 0x00a3 }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x00a3 }
            r4 = 0
            java.lang.String r13 = java.lang.Long.toString(r13)     // Catch:{ Exception -> 0x00a3 }
            r3[r4] = r13     // Catch:{ Exception -> 0x00a3 }
            android.database.Cursor r13 = r2.rawQuery(r1, r3)     // Catch:{ Exception -> 0x00a3 }
            boolean r14 = com.freshchat.consumer.sdk.c.b.b(r13)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r14 == 0) goto L_0x0095
            java.util.Map r14 = r12.a(r13)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            long r1 = com.freshchat.consumer.sdk.j.n.fP()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r3 = 0
            r5 = r3
        L_0x0059:
            com.freshchat.consumer.sdk.c.f$a r7 = r12.e(r13, r14)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r7 == 0) goto L_0x008f
            com.freshchat.consumer.sdk.beans.fragment.MessageFragment r8 = r7.ei     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            boolean r8 = r8 instanceof com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r8 != 0) goto L_0x0068
            goto L_0x008f
        L_0x0068:
            com.freshchat.consumer.sdk.beans.fragment.MessageFragment r8 = r7.ei     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment r8 = (com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment) r8     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            boolean r9 = com.freshchat.consumer.sdk.j.cm.a(r8)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r9 != 0) goto L_0x0075
            goto L_0x008f
        L_0x0075:
            long r8 = r8.getStartMillis()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x008f
            int r10 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x0082
            goto L_0x008f
        L_0x0082:
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 == 0) goto L_0x008a
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 >= 0) goto L_0x008f
        L_0x008a:
            java.lang.String r0 = r7.ej     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r5 = r8
        L_0x008f:
            boolean r7 = r13.moveToNext()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r7 != 0) goto L_0x0059
        L_0x0095:
            com.freshchat.consumer.sdk.c.b.c(r13)
            goto L_0x00ac
        L_0x0099:
            r14 = move-exception
            r0 = r13
            goto L_0x00ad
        L_0x009c:
            r14 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
            goto L_0x00a5
        L_0x00a1:
            r14 = move-exception
            goto L_0x00ad
        L_0x00a3:
            r14 = move-exception
            r13 = r0
        L_0x00a5:
            com.freshchat.consumer.sdk.j.q.a(r14)     // Catch:{ all -> 0x00a1 }
            com.freshchat.consumer.sdk.c.b.c(r0)
            r0 = r13
        L_0x00ac:
            return r0
        L_0x00ad:
            com.freshchat.consumer.sdk.c.b.c(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.f.z(long):java.lang.String");
    }
}
