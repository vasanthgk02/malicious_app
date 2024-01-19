package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.FlowBusinessHourType;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.QuickActions;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.beans.Tag.TaggedType;
import com.freshchat.consumer.sdk.c.a.e;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.d.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

public class c extends b {
    public static final String[] ee = new e().cR();
    public final Context context;

    public c(Context context2) {
        super(context2);
        this.context = context2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ec A[Catch:{ Exception -> 0x0100 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.ContentValues b(com.freshchat.consumer.sdk.beans.Channel r6) {
        /*
            r5 = this;
            java.lang.String r0 = "[]"
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            long r2 = r6.getId()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "_id"
            r1.put(r3, r2)
            java.lang.String r2 = r6.getName()
            java.lang.String r3 = "name"
            r1.put(r3, r2)
            java.lang.String r2 = r6.getIconUrl()
            java.lang.String r3 = "icon"
            r1.put(r3, r2)
            int r2 = r6.getPosition()
            java.lang.String r2 = java.lang.Integer.toString(r2)
            java.lang.String r3 = "position"
            r1.put(r3, r2)
            boolean r2 = r6.isHidden()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "hidden"
            r1.put(r3, r2)
            java.lang.String r2 = r6.getChannelType()
            java.lang.String r3 = "type"
            r1.put(r3, r2)
            boolean r2 = r6.isDefault()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "is_default"
            r1.put(r3, r2)
            boolean r2 = r6.isRestricted()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "restricted"
            r1.put(r3, r2)
            long r2 = r6.getUpdatedAt()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "updated_at"
            r1.put(r3, r2)
            java.lang.String r2 = r6.getChannelAlias()
            java.lang.String r3 = "channel_alias"
            r1.put(r3, r2)
            long r2 = r6.getOperatingHoursId()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "operating_hours_id"
            r1.put(r3, r2)
            java.lang.String r2 = r6.getFlowId()
            java.lang.String r3 = "flow_id"
            r1.put(r3, r2)
            java.lang.String r2 = r6.getFlowVersionId()
            java.lang.String r3 = "flow_version_id"
            r1.put(r3, r2)
            long r2 = r6.getServiceAccountId()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "service_account_id"
            r1.put(r3, r2)
            com.freshchat.consumer.sdk.beans.FlowBusinessHourType r2 = r6.getFlowBusinessHourType()
            if (r2 == 0) goto L_0x00b4
            com.freshchat.consumer.sdk.beans.FlowBusinessHourType r2 = r6.getFlowBusinessHourType()
            java.lang.String r2 = r2.name()
            goto L_0x00b5
        L_0x00b4:
            r2 = 0
        L_0x00b5:
            java.lang.String r3 = "flow_business_hours_type"
            r1.put(r3, r2)
            java.lang.String r2 = r6.getFlowMessagesJson()
            java.lang.String r3 = "flow_messages_json"
            r1.put(r3, r2)
            com.freshchat.consumer.sdk.c.t r2 = new com.freshchat.consumer.sdk.c.t     // Catch:{ Exception -> 0x0102 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0102 }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x0102 }
            com.freshchat.consumer.sdk.beans.QuickActions r3 = r6.getQuickActions()     // Catch:{ Exception -> 0x0102 }
            if (r3 == 0) goto L_0x00e5
            com.freshchat.consumer.sdk.beans.QuickActions r3 = r6.getQuickActions()     // Catch:{ Exception -> 0x0102 }
            java.util.List r3 = r3.getMenu()     // Catch:{ Exception -> 0x0102 }
            if (r3 == 0) goto L_0x00e5
            com.freshchat.consumer.sdk.j.ab r4 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r4.toJson(r3, r2)     // Catch:{ Exception -> 0x0102 }
            goto L_0x00e6
        L_0x00e5:
            r3 = r0
        L_0x00e6:
            com.freshchat.consumer.sdk.beans.QuickActions r4 = r6.getQuickActions()     // Catch:{ Exception -> 0x0100 }
            if (r4 == 0) goto L_0x0107
            com.freshchat.consumer.sdk.beans.QuickActions r6 = r6.getQuickActions()     // Catch:{ Exception -> 0x0100 }
            java.util.List r6 = r6.getSlashCommand()     // Catch:{ Exception -> 0x0100 }
            if (r6 == 0) goto L_0x0107
            com.freshchat.consumer.sdk.j.ab r4 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r6 = r4.toJson(r6, r2)     // Catch:{ Exception -> 0x0100 }
            r0 = r6
            goto L_0x0107
        L_0x0100:
            r6 = move-exception
            goto L_0x0104
        L_0x0102:
            r6 = move-exception
            r3 = r0
        L_0x0104:
            com.freshchat.consumer.sdk.j.q.a(r6)
        L_0x0107:
            java.lang.String r6 = "quick_actions_menu_json"
            r1.put(r6, r3)
            java.lang.String r6 = "quick_actions_slash_command_json"
            r1.put(r6, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.c.b(com.freshchat.consumer.sdk.beans.Channel):android.content.ContentValues");
    }

    private Channel b(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        boolean z = false;
        Channel channel = new Channel().setId(cursor.getLong(map.get("_id").intValue())).setName(cursor.getString(map.get("name").intValue())).setIconUrl(cursor.getString(map.get("icon").intValue())).setHidden(cursor.getInt(map.get("hidden").intValue()) == 1).setPosition(cursor.getInt(map.get("position").intValue())).setChannelType(cursor.getString(map.get("type").intValue())).setDefault(cursor.getInt(map.get("is_default").intValue()) == 1);
        if (cursor.getInt(map.get("restricted").intValue()) == 1) {
            z = true;
        }
        Channel flowMessagesJson = channel.setRestricted(z).setUpdatedAt(cursor.getLong(map.get("updated_at").intValue())).setChannelAlias(cursor.getString(map.get("channel_alias").intValue())).setOperatingHoursId(cursor.getLong(map.get("operating_hours_id").intValue())).setFlowId(cursor.getString(map.get("flow_id").intValue())).setFlowVersionId(cursor.getString(map.get("flow_version_id").intValue())).setServiceAccountId(cursor.getLong(map.get("service_account_id").intValue())).setFlowMessagesJson(cursor.getString(map.get("flow_messages_json").intValue()));
        flowMessagesJson.setFlowBusinessHourType(FlowBusinessHourType.get(cursor.getString(map.get("flow_business_hours_type").intValue())));
        QuickActions quickActions = new QuickActions();
        String string = cursor.getString(map.get("quick_actions_menu_json").intValue());
        List arrayList = new ArrayList();
        if (as.a(string) && as.p(string, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            try {
                arrayList = (List) ab.in().fromJson(string, new r(this).getType());
            } catch (Exception e2) {
                q.a(e2);
            }
        }
        quickActions.setMenu(arrayList);
        String string2 = cursor.getString(map.get("quick_actions_slash_command_json").intValue());
        List arrayList2 = new ArrayList();
        if (as.a(string2) && as.p(string2, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            try {
                arrayList2 = (List) ab.in().fromJson(string2, new s(this).getType());
            } catch (Exception e3) {
                q.a(e3);
            }
        }
        quickActions.setSlashCommand(arrayList2);
        flowMessagesJson.setQuickActions(quickActions);
        return flowMessagesJson;
    }

    public List<Channel> a(List<String> list, boolean z) {
        List<Channel> d2 = d(list);
        g gVar = new g(this.context);
        g gVar2 = new g(new e(this.context), gVar);
        for (Channel next : d2) {
            Message message = null;
            try {
                if (next.getFlowBusinessHourType() != null && gVar2.a(this.context, next)) {
                    ArrayList arrayList = (ArrayList) ab.in().fromJson(next.getFlowMessagesJson(), new q(this).getType());
                    if (k.a(arrayList)) {
                        message = (Message) arrayList.get(k.b((Collection<?>) arrayList) - 1);
                    }
                }
            } catch (Exception e2) {
                q.a(e2);
            }
            Message l = gVar.l(next.getId());
            if (message == null) {
                message = l;
            } else if (l.getCreatedMillis() != 0) {
                message.setCreatedMillis(l.getCreatedMillis() + 1);
            }
            if (message != null) {
                next.setLatestOrWelcomeMessage(message);
            }
        }
        if (z && k.isEmpty(d2)) {
            Channel cw = cw();
            if (cw != null) {
                d2.add(cw);
            }
        }
        return d2;
    }

    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("quick_actions_slash_command_json", GeneratedOutlineSupport.outline26(hashMap, "quick_actions_menu_json", GeneratedOutlineSupport.outline26(hashMap, "flow_messages_json", GeneratedOutlineSupport.outline26(hashMap, "flow_business_hours_type", GeneratedOutlineSupport.outline26(hashMap, "service_account_id", GeneratedOutlineSupport.outline26(hashMap, "flow_version_id", GeneratedOutlineSupport.outline26(hashMap, "flow_id", GeneratedOutlineSupport.outline26(hashMap, "operating_hours_id", GeneratedOutlineSupport.outline26(hashMap, "channel_alias", GeneratedOutlineSupport.outline26(hashMap, "updated_at", GeneratedOutlineSupport.outline26(hashMap, "restricted", GeneratedOutlineSupport.outline26(hashMap, "is_default", GeneratedOutlineSupport.outline26(hashMap, "type", GeneratedOutlineSupport.outline26(hashMap, "position", GeneratedOutlineSupport.outline26(hashMap, "hidden", GeneratedOutlineSupport.outline26(hashMap, "icon", GeneratedOutlineSupport.outline26(hashMap, "name", Integer.valueOf(cursor.getColumnIndex("name")), cursor, "icon"), cursor, "hidden"), cursor, "position"), cursor, "type"), cursor, "is_default"), cursor, "restricted"), cursor, "updated_at"), cursor, "channel_alias"), cursor, "operating_hours_id"), cursor, "flow_id"), cursor, "flow_version_id"), cursor, "service_account_id"), cursor, "flow_business_hours_type"), cursor, "flow_messages_json"), cursor, "quick_actions_menu_json"), cursor, "quick_actions_slash_command_json"));
        }
        return hashMap;
    }

    public void a(List<Channel> list, List<Tag> list2) {
        SQLiteDatabase cs = cs();
        cs.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hidden", Integer.valueOf(1));
            cs.update("channels", contentValues, null, null);
            ArrayList arrayList = new ArrayList();
            for (Channel next : list) {
                if (next.getLatestOrWelcomeMessage() != null) {
                    arrayList.add(next.getLatestOrWelcomeMessage());
                }
                cs.replace("channels", null, b(next));
            }
            if (k.a(arrayList)) {
                g gVar = new g(this.context);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    gVar.a(cs(), (Message) it.next(), false);
                }
            }
            if (k.a(list2)) {
                new j(this.context).f(list2);
            }
            cs.setTransactionSuccessful();
        } catch (Exception unused) {
            ai.e("FRESHCHAT_WARNING", com.freshchat.consumer.sdk.b.c.CHANNEL_UPDATE_FAILED.toString());
        } catch (Throwable th) {
            cs.endTransaction();
            throw th;
        }
        cs.endTransaction();
    }

    public List<Channel> cv() {
        return a((List<String>) null, true);
    }

    public Channel cw() {
        Cursor cursor;
        Channel channel = null;
        try {
            cursor = cs().query("channels", ee, "is_default = '1'", null, null, null, "CAST(_id as int)");
            try {
                if (b.b(cursor)) {
                    channel = b(cursor, a(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return channel;
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
            return channel;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            cursor = null;
            th = th3;
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return channel;
    }

    public List<Channel> d(List<String> list) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            if (k.a(list)) {
                cursor = cs().rawQuery(" SELECT DISTINCT channels.*  FROM channels, (SELECT *  FROM tags WHERE " + j.a(k.b((Collection<?>) list), TaggedType.CHANNEL) + ")  AS matching_tags  WHERE ( matching_tags." + "tagged_id" + " = " + "_id" + ") AND " + "hidden" + "= 0  ORDER BY " + "position", (String[]) list.toArray(new String[0]));
            } else {
                cursor = cs().query("channels", ee, "hidden = 0 AND restricted = 0", null, null, null, "position");
            }
            cursor2 = cursor;
            if (b.b(cursor2)) {
                Map<String, Integer> a2 = a(cursor2);
                do {
                    Channel b2 = b(cursor2, a2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                } while (cursor2.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor2);
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.freshchat.consumer.sdk.beans.Channel] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r11v8, types: [com.freshchat.consumer.sdk.beans.Channel] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
      assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [com.freshchat.consumer.sdk.beans.Channel, android.database.Cursor]
      mth insns count: 29
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.Channel e(long r10) {
        /*
            r9 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.cs()     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r2 = "channels"
            java.lang.String[] r3 = ee     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r4 = "_id=?"
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
            com.freshchat.consumer.sdk.beans.Channel r11 = r9.b(r10, r11)     // Catch:{ Exception -> 0x002c }
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
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.c.e(long):com.freshchat.consumer.sdk.beans.Channel");
    }

    public List<Channel> gn() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("channels", null, null, null, null, null, null, null);
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    Channel b2 = b(cursor, a2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                } while (cursor.moveToNext());
            }
            g gVar = new g(this.context);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Channel channel = (Channel) it.next();
                Message X = gVar.X(channel.getId() + "_welcome_message");
                if (X != null) {
                    channel.setLatestOrWelcomeMessage(X);
                }
            }
        } catch (Exception e2) {
            ai.e("FRESHCHAT", "Exception fetching channels ", e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }
}
