package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.Csat.CSatStatus;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.c.a.f;
import com.freshchat.consumer.sdk.c.a.g;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e extends b {
    public static final String[] ef = new f().cR();
    public static final String[] eg = new g().cR();
    public final Context context;

    public e(Context context2) {
        super(context2);
        this.context = context2;
    }

    private Conversation c(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        long j = cursor.getLong(map.get("_id").intValue());
        Conversation conversation = new Conversation(j);
        conversation.setChannelId(cursor.getLong(map.get(Constants.CHANNEL_ID).intValue()));
        boolean z = true;
        if (cursor.getInt(map.get("has_pending_csat").intValue()) != 1) {
            z = false;
        }
        conversation.setHasPendingCsat(z);
        conversation.setStatus((long) cursor.getInt(map.get("status").intValue()));
        Csat g = g(j);
        if (g == null) {
            return conversation;
        }
        conversation.setCsat(g);
        return conversation;
    }

    private Csat d(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        Csat csat = new Csat();
        csat.setCsatId(cursor.getLong(map.get("csat_id").intValue()));
        csat.setQuestion(cursor.getString(map.get("question").intValue()));
        boolean z = false;
        csat.setMandatory(cursor.getInt(map.get("mandatory").intValue()) == 1);
        if (cursor.getInt(map.get("comments_allowed").intValue()) == 1) {
            z = true;
        }
        csat.setMobileUserCommentsAllowed(z);
        csat.setInitiatedTime(cursor.getLong(map.get("initiated_time").intValue()));
        csat.setStatus(CSatStatus.fromInt(cursor.getInt(map.get("_status").intValue())));
        return csat;
    }

    private Map<String, Integer> e(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put(Constants.CHANNEL_ID, Integer.valueOf(cursor.getColumnIndex(Constants.CHANNEL_ID)));
            hashMap.put("status", GeneratedOutlineSupport.outline26(hashMap, "has_pending_csat", GeneratedOutlineSupport.outline26(hashMap, "_id", Integer.valueOf(cursor.getColumnIndex("_id")), cursor, "has_pending_csat"), cursor, "status"));
        }
        return hashMap;
    }

    private Map<String, Integer> f(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("csat_id", Integer.valueOf(cursor.getColumnIndex("csat_id")));
            hashMap.put("initiated_time", GeneratedOutlineSupport.outline26(hashMap, "comments_allowed", GeneratedOutlineSupport.outline26(hashMap, "mandatory", GeneratedOutlineSupport.outline26(hashMap, "question", GeneratedOutlineSupport.outline26(hashMap, "_status", Integer.valueOf(cursor.getColumnIndex("_status")), cursor, "question"), cursor, "mandatory"), cursor, "comments_allowed"), cursor, "initiated_time"));
        }
        return hashMap;
    }

    public void U(String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_status", Integer.valueOf(CSatStatus.RATED_NOT_UPLOADED.asInt()));
            cs().update("custsat", contentValues, "conv_id=?", new String[]{str});
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public Map<String, Integer> a(Cursor cursor) {
        return null;
    }

    public void a(long j, Csat csat) {
        if (csat != null) {
            try {
                SQLiteStatement compileStatement = cs().compileStatement(new g().k(false));
                cs().beginTransaction();
                compileStatement.clearBindings();
                compileStatement.bindLong(1, j);
                compileStatement.bindLong(2, csat.getCsatId());
                compileStatement.bindString(3, csat.getQuestion());
                long j2 = 1;
                compileStatement.bindLong(4, csat.isMobileUserCommentsAllowed() ? 1 : 0);
                if (!csat.isMandatory()) {
                    j2 = 0;
                }
                compileStatement.bindLong(5, j2);
                compileStatement.bindLong(6, (long) csat.getStatus().asInt());
                compileStatement.bindLong(7, csat.getInitiatedTime());
                compileStatement.executeInsert();
                cs().setTransactionSuccessful();
            } catch (Exception e2) {
                q.a(e2);
            } catch (Throwable th) {
                cs().endTransaction();
                throw th;
            }
            cs().endTransaction();
        }
    }

    public void a(Conversation conversation) {
        if (conversation != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(conversation);
            f((List<Conversation>) arrayList);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.freshchat.consumer.sdk.beans.Conversation] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r11v8, types: [com.freshchat.consumer.sdk.beans.Conversation] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
      assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [com.freshchat.consumer.sdk.beans.Conversation, android.database.Cursor]
      mth insns count: 29
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.Conversation f(long r10) {
        /*
            r9 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.cs()     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r2 = "conversations"
            java.lang.String[] r3 = ef     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r4 = "channel_id=?"
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
            java.util.Map r11 = r9.e(r10)     // Catch:{ Exception -> 0x002c }
            com.freshchat.consumer.sdk.beans.Conversation r11 = r9.c(r10, r11)     // Catch:{ Exception -> 0x002c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.e.f(long):com.freshchat.consumer.sdk.beans.Conversation");
    }

    public void f(List<Conversation> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new f().cS());
        cs().beginTransaction();
        h hVar = new h(this.context);
        for (int i = 0; i < list.size(); i++) {
            Conversation conversation = list.get(i);
            long conversationId = conversation.getConversationId();
            long j = 0;
            if (conversationId != 0) {
                List<Participant> participants = conversation.getParticipants();
                if (k.a(participants)) {
                    hVar.g(participants);
                }
                compileStatement.clearBindings();
                compileStatement.bindString(1, Long.toString(conversationId));
                compileStatement.bindLong(2, conversation.getChannelId());
                if (conversation.hasPendingCsat()) {
                    j = 1;
                }
                compileStatement.bindLong(3, j);
                compileStatement.bindLong(4, conversation.getStatus());
                compileStatement.execute();
            }
        }
        cs().setTransactionSuccessful();
        cs().endTransaction();
    }

    public void fR() {
        RemoteConfig bD = ap.bD(this.context);
        if (au.a(bD)) {
            Cursor cursor = null;
            try {
                cs().beginTransaction();
                cursor = cs().rawQuery(g.kP, null);
                ArrayList arrayList = new ArrayList();
                if (cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("CONV._id");
                    int columnIndex2 = cursor.getColumnIndex("initiated_time");
                    do {
                        if (au.a(bD, cursor.getLong(columnIndex2))) {
                            arrayList.add(cursor.getString(columnIndex));
                        }
                    } while (cursor.moveToNext());
                    if (k.a(arrayList)) {
                        SQLiteDatabase cs = cs();
                        cs.delete("custsat", "conv_id=" + as.a(ColorPropConverter.PREFIX_ATTR, ",", k.b((Collection<?>) arrayList)), (String[]) arrayList.toArray(new String[0]));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("has_pending_csat", Integer.valueOf(0));
                        SQLiteDatabase cs2 = cs();
                        cs2.update("conversations", contentValues, "_id=" + as.a(ColorPropConverter.PREFIX_ATTR, ",", k.b((Collection<?>) arrayList)), (String[]) arrayList.toArray(new String[0]));
                    }
                }
                cs().setTransactionSuccessful();
            } catch (Exception e2) {
                q.a(e2);
            } catch (Throwable th) {
                b.c(null);
                cs().endTransaction();
                throw th;
            }
            b.c(cursor);
            cs().endTransaction();
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.freshchat.consumer.sdk.beans.Csat] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r11v10, types: [com.freshchat.consumer.sdk.beans.Csat] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
      assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [com.freshchat.consumer.sdk.beans.Csat, android.database.Cursor]
      mth insns count: 29
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.Csat g(long r10) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r10 = java.lang.Long.toString(r10)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            android.database.sqlite.SQLiteDatabase r1 = r9.cs()     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r2 = "custsat"
            java.lang.String[] r3 = eg     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r4 = "conv_id=?"
            r11 = 1
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            r11 = 0
            r5[r11] = r10     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            boolean r11 = com.freshchat.consumer.sdk.c.b.b(r10)     // Catch:{ Exception -> 0x002c }
            if (r11 == 0) goto L_0x0035
            java.util.Map r11 = r9.f(r10)     // Catch:{ Exception -> 0x002c }
            com.freshchat.consumer.sdk.beans.Csat r11 = r9.d(r10, r11)     // Catch:{ Exception -> 0x002c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.e.g(long):com.freshchat.consumer.sdk.beans.Csat");
    }

    public void t(long j) {
        try {
            cs().beginTransaction();
            String l = Long.toString(j);
            cs().delete("custsat", "conv_id=?", new String[]{l});
            ContentValues contentValues = new ContentValues();
            contentValues.put("has_pending_csat", Integer.valueOf(0));
            cs().update("conversations", contentValues, "_id=?", new String[]{l});
            cs().setTransactionSuccessful();
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            cs().endTransaction();
            throw th;
        }
        cs().endTransaction();
    }
}
