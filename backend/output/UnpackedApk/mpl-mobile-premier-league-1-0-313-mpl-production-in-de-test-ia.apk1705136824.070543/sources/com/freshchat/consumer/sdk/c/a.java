package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freshchat.consumer.sdk.beans.MarketingMessageStatus;
import com.freshchat.consumer.sdk.c.a.b;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import sfs2x.client.requests.buddylist.InitBuddyListRequest;

public class a extends b {
    public static final String TAG = "com.freshchat.consumer.sdk.c.a";
    public Context context;

    public a(Context context2) {
        super(context2);
        this.context = context2.getApplicationContext();
    }

    private com.freshchat.consumer.sdk.service.a.a R(String str) {
        Cursor cursor;
        try {
            cursor = cs().query(InitBuddyListRequest.KEY_BLIST, new b().cR(), "_id= ?", new String[]{str}, null, null, "priority,created_m");
            try {
                if (b.b(cursor)) {
                    com.freshchat.consumer.sdk.service.a.a a2 = a(cursor, a(cursor));
                    b.c(cursor);
                    return a2;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return null;
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
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return null;
    }

    private com.freshchat.consumer.sdk.service.a.a a(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        String string = cursor.getString(map.get("json").intValue());
        ai.d(TAG, "******************************");
        String str = TAG;
        ai.d(str, "Backlog json is " + string);
        ai.d(TAG, "******************************");
        return (com.freshchat.consumer.sdk.service.a.a) new ab().fromJson(string, com.freshchat.consumer.sdk.service.a.a.class);
    }

    private void a(MarketingMessageStatus marketingMessageStatus, MarketingMessageStatus marketingMessageStatus2) {
        if (marketingMessageStatus.getClicked() == 1) {
            marketingMessageStatus2.setClicked(1);
        }
        if (marketingMessageStatus.getDelivered() == 1) {
            marketingMessageStatus2.setDelivered(1);
        }
        if (marketingMessageStatus.getSeen() == 1) {
            marketingMessageStatus2.setSeen(1);
        }
    }

    private Cursor cq() {
        return cs().query(InitBuddyListRequest.KEY_BLIST, new b().cR(), null, null, null, null, "priority,created_m");
    }

    private void e(com.freshchat.consumer.sdk.service.a.a aVar) {
        try {
            String json = new ab().toJson(aVar);
            ContentValues contentValues = new ContentValues();
            contentValues.put("json", json);
            int update = cs().update(InitBuddyListRequest.KEY_BLIST, contentValues, "_id = ?", new String[]{aVar.dr()});
            String str = TAG;
            ai.d(str, "updated backlog " + aVar + " with result " + update);
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    private boolean g(com.freshchat.consumer.sdk.service.a.a aVar) {
        if (aVar.getType() != 0) {
            try {
                ContentValues contentValues = new ContentValues();
                String json = new ab().toJson(aVar);
                String str = TAG;
                ai.d(str, "json for holder is " + aVar);
                contentValues.put("json", json);
                contentValues.put("_id", aVar.dr());
                contentValues.put("priority", Integer.valueOf(aVar.getPriority()));
                contentValues.put("type", Integer.valueOf(aVar.getType()));
                contentValues.put("created_m", Long.valueOf(System.currentTimeMillis()));
                long insert = cs().insert(InitBuddyListRequest.KEY_BLIST, null, contentValues);
                ai.d(TAG, "*********************************************");
                String str2 = TAG;
                ai.d(str2, "Backlog saved - " + insert);
                ai.d(TAG, "*********************************************");
                return true;
            } catch (Exception e2) {
                q.a(e2);
                return false;
            }
        } else {
            throw new RuntimeException("Type cannot be undefined");
        }
    }

    public com.freshchat.consumer.sdk.service.a.a C(int i) {
        Cursor cursor;
        try {
            cursor = cs().query(InitBuddyListRequest.KEY_BLIST, new b().cR(), "type= ?", new String[]{String.valueOf(i)}, null, null, "priority,created_m");
            try {
                if (b.b(cursor)) {
                    com.freshchat.consumer.sdk.service.a.a a2 = a(cursor, a(cursor));
                    b.c(cursor);
                    return a2;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return null;
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
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return null;
    }

    public boolean S(String str) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = cs().query(InitBuddyListRequest.KEY_BLIST, new String[]{"_id"}, "_id = ?", new String[]{str}, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            q.a(e2);
            return false;
        } finally {
            b.c(cursor);
        }
    }

    public boolean T(String str) {
        try {
            int delete = cs().delete(InitBuddyListRequest.KEY_BLIST, "_id = ?", new String[]{str});
            String str2 = TAG;
            ai.d(str2, "Delete backlog " + str + CMap.SPACE + delete);
        } catch (Exception e2) {
            q.a(e2);
        }
        return false;
    }

    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("json", Integer.valueOf(cursor.getColumnIndex("json")));
        }
        return hashMap;
    }

    public boolean a(com.freshchat.consumer.sdk.service.a.a aVar) {
        int type = aVar.getType();
        if (!l(type)) {
            return g(aVar);
        }
        String str = TAG;
        ai.d(str, "Backlog of type " + type + " already exists");
        return false;
    }

    public void b(com.freshchat.consumer.sdk.service.a.a aVar) {
        if (aVar != null) {
            if (S(aVar.dr())) {
                e(aVar);
            } else {
                g(aVar);
            }
        }
    }

    public List<com.freshchat.consumer.sdk.service.a.a> cp() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cq();
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    arrayList.add(a(cursor, a2));
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public void d(com.freshchat.consumer.sdk.service.a.a aVar) {
        Class cls = MarketingMessageStatus.class;
        synchronized (a.class) {
            String dr = aVar.dr();
            String str = TAG;
            ai.d(str, "Searching for backlog by ID " + dr);
            com.freshchat.consumer.sdk.service.a.a R = R(dr);
            if (R != null) {
                String str2 = TAG;
                ai.d(str2, "Marketing backlog already exists " + R);
                Map<String, String> meta = R.getMeta();
                ab abVar = new ab();
                MarketingMessageStatus marketingMessageStatus = (MarketingMessageStatus) abVar.fromJson(meta.get("fc_marketing_metrics"), cls);
                String str3 = TAG;
                ai.d(str3, "Status in DB is " + marketingMessageStatus);
                String str4 = TAG;
                ai.d(str4, "Status from source is " + marketingMessageStatus);
                a((MarketingMessageStatus) abVar.fromJson(aVar.getMeta().get("fc_marketing_metrics"), cls), marketingMessageStatus);
                String str5 = TAG;
                ai.d(str5, "Updated status is " + marketingMessageStatus);
                String json = abVar.toJson(marketingMessageStatus);
                String str6 = TAG;
                ai.d(str6, "Updated json is " + json);
                meta.put("fc_marketing_metrics", json);
                e(R);
            } else {
                String str7 = TAG;
                ai.d(str7, "Marketing backlog does not exist " + dr);
                g(aVar);
            }
        }
    }

    public boolean f(com.freshchat.consumer.sdk.service.a.a aVar) {
        if (!S(aVar.dr())) {
            return g(aVar);
        }
        String str = TAG;
        ai.d(str, "Ignoring duplicate backlog " + aVar);
        return false;
    }

    public boolean l(int i) {
        String str = TAG;
        ai.d(str, "Does backlog exists by type " + i);
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = cs().query(InitBuddyListRequest.KEY_BLIST, new String[]{"_id"}, "type = ?", new String[]{String.valueOf(i)}, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            q.a(e2);
            return false;
        } finally {
            b.c(cursor);
        }
    }
}
