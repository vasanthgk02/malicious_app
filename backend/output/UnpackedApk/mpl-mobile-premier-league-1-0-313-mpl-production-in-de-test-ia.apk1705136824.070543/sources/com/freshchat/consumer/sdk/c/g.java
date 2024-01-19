package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Csat.CSatStatus;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Message.MessageType;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.c.a.j;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import in.juspay.hypersdk.core.InflateView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

public class g extends b {
    public static final String TAG = "com.freshchat.consumer.sdk.c.g";
    public static final String[] el = new j().cR();
    public static final String kP;
    public Context context;
    public f ek;

    static {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SELECT CONV._id, CONV.channel_id,initiated_time FROM conversations AS CONV  JOIN custsat AS CSAT  ON (CONV._id=CSAT.conv_id AND CSAT._status=");
        outline73.append(CSatStatus.NOT_RATED.asInt());
        outline73.append(")");
        kP = outline73.toString();
    }

    public g(Context context2) {
        super(context2);
        this.context = context2.getApplicationContext();
    }

    private void a(Cursor cursor, List<Message> list) {
        if (b.b(cursor)) {
            Map<String, Integer> a2 = a(cursor);
            do {
                Message f2 = f(cursor, a2);
                if (f2 != null) {
                    f2.setMessageFragments(cy().W(f2.getAlias()));
                    list.add(f2);
                }
            } while (cursor.moveToNext());
        }
    }

    public static ContentValues c(Message message) {
        if (message.getAlias() == null) {
            message.setAlias(String.valueOf(System.nanoTime()));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("created_at", Long.valueOf(message.getCreatedMillis()));
        contentValues.put("_id", message.getAlias());
        contentValues.put(Constants.CHANNEL_ID, Long.valueOf(message.getChannelId()));
        contentValues.put(PushMessageHelper.MESSAGE_TYPE, Integer.valueOf(message.getMessageType()));
        contentValues.put("marketing_id", Long.valueOf(message.getMarketingId()));
        contentValues.put("conv_id", Long.valueOf(message.getConversationId()));
        contentValues.put("read", Integer.valueOf(message.isRead() ? 1 : 0));
        contentValues.put("user_id", message.getMessageUserAlias());
        contentValues.put("user_type", Integer.valueOf(message.getMessageUserType()));
        int i = 1;
        if (message.getUploadState() != 1) {
            i = 0;
        }
        contentValues.put("uploaded", Integer.valueOf(i));
        contentValues.put("should_translate", Integer.valueOf(message.getShouldTranslate()));
        contentValues.put("flow_step_id", message.getFlowStepId());
        contentValues.put("user_name", message.getMessageUserName());
        contentValues.put("user_profile_pic", message.getMessageUserProfilePic());
        contentValues.put("should_delete", Integer.valueOf(0));
        String str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        try {
            List<MessageFragment> replyFragments = message.getReplyFragments();
            if (k.a(replyFragments)) {
                str = ab.in().toJson(replyFragments, new l().getType());
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        contentValues.put("reply_fragments", str);
        String str2 = "{}";
        try {
            if (message.getInternalMeta() != null) {
                str2 = ab.in().toJson(message.getInternalMeta());
            }
        } catch (Exception e3) {
            q.a(e3);
        }
        contentValues.put("internal_meta", str2);
        contentValues.put("responded", Integer.valueOf(message.isResponded() ? 1 : 0));
        try {
            JSONObject jSONObject = new JSONObject();
            if (message.getId() > 0) {
                jSONObject.put("id", message.getId());
            }
            if (message.getReplyTo() != null) {
                jSONObject.put("replyTo", new JSONObject(ab.in().toJson(message.getReplyTo())));
            }
            contentValues.put("extras_json", jSONObject.toString());
        } catch (Exception e4) {
            q.a(e4);
        }
        return contentValues;
    }

    private Set<String> cA() {
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            cursor = cB();
            if (b.b(cursor)) {
                int columnIndex = cursor.getColumnIndex("_id");
                do {
                    hashSet.add(cursor.getString(columnIndex));
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashSet;
    }

    private Cursor cB() {
        return cs().query("message", el, null, null, null, null, "created_at");
    }

    private List<Long> cG() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery(kP, null);
            RemoteConfig bD = ap.bD(this.context);
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("CONV.channel_id");
                int columnIndex2 = cursor.getColumnIndex("initiated_time");
                do {
                    boolean z = false;
                    if (au.a(bD)) {
                        z = au.a(bD, cursor.getLong(columnIndex2));
                    }
                    if (!z) {
                        arrayList.add(Long.valueOf(cursor.getLong(columnIndex)));
                    }
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

    private f cy() {
        if (this.ek == null) {
            this.ek = new f(this.context);
        }
        return this.ek;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x021e A[Catch:{ Exception -> 0x025a }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.freshchat.consumer.sdk.beans.Message f(android.database.Cursor r28, java.util.Map<java.lang.String, java.lang.Integer> r29) {
        /*
            r27 = this;
            r1 = r28
            r2 = r29
            java.lang.String r3 = "replyTo"
            java.lang.String r4 = "id"
            boolean r0 = com.freshchat.consumer.sdk.c.b.d(r28)
            if (r0 == 0) goto L_0x025f
            java.lang.String r0 = "_id"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.String r5 = r1.getString(r0)
            java.lang.String r0 = "channel_id"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            long r6 = r1.getLong(r0)
            java.lang.String r0 = "conv_id"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.String r8 = r1.getString(r0)
            java.lang.String r0 = "message_type"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r9 = r1.getInt(r0)
            java.lang.String r0 = "marketing_id"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            long r10 = r1.getLong(r0)
            java.lang.String r0 = "created_at"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            long r12 = r1.getLong(r0)
            java.lang.String r0 = "user_id"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.String r14 = r1.getString(r0)
            java.lang.String r0 = "user_type"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r15 = r1.getInt(r0)
            java.lang.String r0 = "uploaded"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r16 = r3
            int r3 = r1.getInt(r0)
            java.lang.String r0 = "read"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r1.getInt(r0)
            r17 = 0
            r18 = r4
            r4 = 1
            if (r0 != r4) goto L_0x00ba
            r19 = 1
            goto L_0x00bc
        L_0x00ba:
            r19 = 0
        L_0x00bc:
            java.lang.String r0 = "reply_fragments"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r4 = "responded"
            java.lang.Object r4 = r2.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = r1.getInt(r4)
            r21 = r3
            r3 = 1
            if (r4 != r3) goto L_0x00e2
            goto L_0x00e3
        L_0x00e2:
            r3 = 0
        L_0x00e3:
            java.lang.String r4 = "should_translate"
            java.lang.Object r4 = r2.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = r1.getInt(r4)
            r17 = r4
            java.lang.String r4 = "flow_step_id"
            java.lang.Object r4 = r2.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.String r4 = r1.getString(r4)
            r20 = r4
            java.lang.String r4 = "user_name"
            java.lang.Object r4 = r2.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.String r4 = r1.getString(r4)
            r22 = r4
            java.lang.String r4 = "user_profile_pic"
            java.lang.Object r4 = r2.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.String r4 = r1.getString(r4)
            java.util.ArrayList r23 = new java.util.ArrayList
            r23.<init>()
            boolean r24 = com.freshchat.consumer.sdk.j.as.a(r0)
            if (r24 == 0) goto L_0x0163
            r24 = r4
            java.lang.String r4 = "[]"
            boolean r4 = com.freshchat.consumer.sdk.j.as.p(r0, r4)
            if (r4 == 0) goto L_0x0160
            com.freshchat.consumer.sdk.c.n r4 = new com.freshchat.consumer.sdk.c.n     // Catch:{ Exception -> 0x0159 }
            r25 = r3
            r3 = r27
            r4.<init>(r3)     // Catch:{ Exception -> 0x0157 }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ Exception -> 0x0157 }
            com.freshchat.consumer.sdk.j.ab r3 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r0 = r3.fromJson(r0, r4)     // Catch:{ Exception -> 0x0157 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x0157 }
            r3 = r0
            goto L_0x0169
        L_0x0157:
            r0 = move-exception
            goto L_0x015c
        L_0x0159:
            r0 = move-exception
            r25 = r3
        L_0x015c:
            com.freshchat.consumer.sdk.j.q.a(r0)
            goto L_0x0167
        L_0x0160:
            r25 = r3
            goto L_0x0167
        L_0x0163:
            r25 = r3
            r24 = r4
        L_0x0167:
            r3 = r23
        L_0x0169:
            java.lang.String r0 = "internal_meta"
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.String r0 = r1.getString(r0)
            com.freshchat.consumer.sdk.beans.MessageInternalMeta r4 = new com.freshchat.consumer.sdk.beans.MessageInternalMeta
            r4.<init>()
            boolean r23 = com.freshchat.consumer.sdk.j.as.a(r0)
            r26 = r4
            java.lang.String r4 = "{}"
            if (r23 == 0) goto L_0x01a3
            boolean r23 = com.freshchat.consumer.sdk.j.as.p(r0, r4)
            if (r23 == 0) goto L_0x01a3
            r23 = r4
            com.freshchat.consumer.sdk.j.ab r4 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x019e }
            java.lang.Class<com.freshchat.consumer.sdk.beans.MessageInternalMeta> r1 = com.freshchat.consumer.sdk.beans.MessageInternalMeta.class
            java.lang.Object r0 = r4.fromJson(r0, r1)     // Catch:{ Exception -> 0x019e }
            com.freshchat.consumer.sdk.beans.MessageInternalMeta r0 = (com.freshchat.consumer.sdk.beans.MessageInternalMeta) r0     // Catch:{ Exception -> 0x019e }
            r4 = r0
            goto L_0x01a7
        L_0x019e:
            r0 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r0)
            goto L_0x01a5
        L_0x01a3:
            r23 = r4
        L_0x01a5:
            r4 = r26
        L_0x01a7:
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = new com.freshchat.consumer.sdk.beans.Message$Builder
            r0.<init>()
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.alias(r5)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.createdMillis(r12)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.channelId(r6)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.messageType(r9)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.marketingId(r10)
            long r5 = java.lang.Long.parseLong(r8)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.hostConversationId(r5)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.messageUserAlias(r14)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.messageUserType(r15)
            r1 = r19
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.read(r1)
            r1 = r21
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.uploadState(r1)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.replyFragments(r3)
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.internalMeta(r4)
            r3 = r25
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.isResponded(r3)
            r1 = r17
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.setShouldTranslate(r1)
            r1 = r20
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.setFlowStepId(r1)
            r1 = r22
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.setMessageUserName(r1)
            r1 = r24
            com.freshchat.consumer.sdk.beans.Message$Builder r0 = r0.setMessageUserProfilePic(r1)
            com.freshchat.consumer.sdk.beans.Message r1 = r0.build()
            java.lang.String r0 = "extras_json"
            java.lang.Object r0 = r2.get(r0)     // Catch:{ Exception -> 0x025a }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x025a }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x025a }
            r2 = r28
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x025a }
            boolean r2 = com.freshchat.consumer.sdk.j.as.a(r0)     // Catch:{ Exception -> 0x025a }
            if (r2 == 0) goto L_0x0260
            r2 = r23
            boolean r2 = com.freshchat.consumer.sdk.j.as.p(r0, r2)     // Catch:{ Exception -> 0x025a }
            if (r2 == 0) goto L_0x0260
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x025a }
            r2.<init>(r0)     // Catch:{ Exception -> 0x025a }
            r3 = r18
            boolean r0 = r2.has(r3)     // Catch:{ Exception -> 0x025a }
            if (r0 == 0) goto L_0x023a
            long r3 = r2.getLong(r3)     // Catch:{ Exception -> 0x025a }
            r1.setId(r3)     // Catch:{ Exception -> 0x025a }
        L_0x023a:
            r3 = r16
            boolean r0 = r2.has(r3)     // Catch:{ Exception -> 0x025a }
            if (r0 == 0) goto L_0x0260
            com.freshchat.consumer.sdk.j.ab r0 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x025a }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x025a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x025a }
            java.lang.Class<com.freshchat.consumer.sdk.beans.Message$ReplyTo> r3 = com.freshchat.consumer.sdk.beans.Message.ReplyTo.class
            java.lang.Object r0 = r0.fromJson(r2, r3)     // Catch:{ Exception -> 0x025a }
            com.freshchat.consumer.sdk.beans.Message$ReplyTo r0 = (com.freshchat.consumer.sdk.beans.Message.ReplyTo) r0     // Catch:{ Exception -> 0x025a }
            r1.setReplyTo(r0)     // Catch:{ Exception -> 0x025a }
            goto L_0x0260
        L_0x025a:
            r0 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r0)
            goto L_0x0260
        L_0x025f:
            r1 = 0
        L_0x0260:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.g.f(android.database.Cursor, java.util.Map):com.freshchat.consumer.sdk.beans.Message");
    }

    private boolean n(long j) {
        boolean z = false;
        if (j <= 0) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"created_at"}, "marketing_id =0  AND uploaded=1 AND user_type=0 AND channel_id = ?", new String[]{Long.toString(j)}, null, null, null);
            if (b.b(cursor) && cursor.getCount() > 0) {
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

    private long o(long j) {
        long j2 = 0;
        if (j <= 0) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"created_at"}, "marketing_id =0 AND channel_id = ?", new String[]{Long.toString(j)}, null, null, "created_at DESC ", "1");
            if (b.b(cursor)) {
                j2 = cursor.getLong(0);
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return j2;
    }

    public List<Message> A(long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("message", el, "message_type IN (" + MessageType.MESSAGE_TYPE_CALENDER_INVITE_SENT_BY_AGENT.getIntValue() + ") AND " + "responded" + "!=" + 1 + " AND " + Constants.CHANNEL_ID + "=?", new String[]{Long.toString(j)}, null, null, null);
            a(cursor, (List<Message>) arrayList);
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public Message B(long j) {
        String z = cy().z(j);
        if (as.isEmpty(z)) {
            return null;
        }
        return X(z);
    }

    public boolean E(long j) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = cs().query("message", el, "display!=-1 AND uploaded=0 AND user_type=0 AND channel_id=" + j, null, null, null, null);
            if (cursor.getCount() > 0) {
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

    public void F(long j) {
        try {
            cs().delete("message", "channel_id=" + j + " AND " + "should_delete" + InflateView.SETTER_EQUALS + 1, new String[0]);
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to delete marked messages. ");
            outline73.append(e2.toString());
            ai.e("FRESHCHAT", outline73.toString());
        }
    }

    public void J(List<String> list) {
        if (!k.isEmpty(list)) {
            cs().beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("should_delete", Integer.valueOf(1));
                cs().update("message", contentValues, "_id IN (" + as.a(ColorPropConverter.PREFIX_ATTR, ",", k.b((Collection<?>) list)) + ")", (String[]) list.toArray(new String[0]));
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

    public Message X(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = cs().query("message", el, "_id=?", new String[]{str}, null, null, null);
            try {
                int count = cursor.getCount();
                ai.d(TAG, "Message by alias " + str + " count " + count);
                if (b.b(cursor)) {
                    Message f2 = f(cursor, a(cursor));
                    if (f2 != null) {
                        f2.setMessageFragments(cy().W(f2.getAlias()));
                    }
                    ai.d(TAG, "Message by alias " + str + " message " + f2);
                    b.c(cursor);
                    return f2;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    b.c(cursor2);
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
            b.c(cursor2);
            throw th;
        }
        b.c(cursor);
        return null;
    }

    public List<Boolean> a(List<Message> list, long j) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        Set<String> cA = cA();
        Set<Long> cz = cz();
        try {
            cs().beginTransaction();
            for (Message next : list) {
                try {
                    String alias = next.getAlias();
                    long marketingId = next.getMarketingId();
                    if (cA.contains(alias)) {
                        str = TAG;
                        str2 = "Ignoring duplicate message " + alias;
                    } else if (marketingId <= 0 || !cz.contains(Long.valueOf(marketingId))) {
                        next.setChannelId(j);
                        arrayList.add(Boolean.valueOf(a(cs(), next)));
                    } else {
                        str = TAG;
                        str2 = "Ignoring duplicate marketing message " + marketingId;
                    }
                    ai.d(str, str2);
                } catch (Exception e2) {
                    arrayList.add(Boolean.FALSE);
                    q.a(e2);
                }
            }
            cs().setTransactionSuccessful();
        } catch (Exception e3) {
            q.a(e3);
        } catch (Throwable th) {
            cs().endTransaction();
            throw th;
        }
        cs().endTransaction();
        return arrayList;
    }

    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("conv_id", Integer.valueOf(cursor.getColumnIndex("conv_id")));
            hashMap.put("should_delete", GeneratedOutlineSupport.outline26(hashMap, "user_profile_pic", GeneratedOutlineSupport.outline26(hashMap, "user_name", GeneratedOutlineSupport.outline26(hashMap, "flow_step_id", GeneratedOutlineSupport.outline26(hashMap, "should_translate", GeneratedOutlineSupport.outline26(hashMap, "responded", GeneratedOutlineSupport.outline26(hashMap, "extras_json", GeneratedOutlineSupport.outline26(hashMap, "internal_meta", GeneratedOutlineSupport.outline26(hashMap, "reply_fragments", GeneratedOutlineSupport.outline26(hashMap, "uploaded", GeneratedOutlineSupport.outline26(hashMap, "read", GeneratedOutlineSupport.outline26(hashMap, "created_at", GeneratedOutlineSupport.outline26(hashMap, "user_type", GeneratedOutlineSupport.outline26(hashMap, "user_id", GeneratedOutlineSupport.outline26(hashMap, PushMessageHelper.MESSAGE_TYPE, GeneratedOutlineSupport.outline26(hashMap, "marketing_id", GeneratedOutlineSupport.outline26(hashMap, "_id", GeneratedOutlineSupport.outline26(hashMap, Constants.CHANNEL_ID, Integer.valueOf(cursor.getColumnIndex(Constants.CHANNEL_ID)), cursor, "_id"), cursor, "marketing_id"), cursor, PushMessageHelper.MESSAGE_TYPE), cursor, "user_id"), cursor, "user_type"), cursor, "created_at"), cursor, "read"), cursor, "uploaded"), cursor, "reply_fragments"), cursor, "internal_meta"), cursor, "extras_json"), cursor, "responded"), cursor, "should_translate"), cursor, "flow_step_id"), cursor, "user_name"), cursor, "user_profile_pic"), cursor, "should_delete"));
        }
        return hashMap;
    }

    public boolean a(long j, long j2) {
        long o = o(j);
        return n(j) && ((o > 0 ? 1 : (o == 0 ? 0 : -1)) > 0 && ((System.currentTimeMillis() - o) > j2 ? 1 : ((System.currentTimeMillis() - o) == j2 ? 0 : -1)) < 0);
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, Message message) {
        return a(sQLiteDatabase, message, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        if (r9 == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        r7.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r9 == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.database.sqlite.SQLiteDatabase r7, com.freshchat.consumer.sdk.beans.Message r8, boolean r9) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            boolean r2 = r8.isUserMessage()     // Catch:{ Exception -> 0x007f }
            if (r2 == 0) goto L_0x0013
            boolean r2 = r8.isUploaded()     // Catch:{ Exception -> 0x007f }
            if (r2 != 0) goto L_0x0013
            android.content.Context r2 = r6.context     // Catch:{ Exception -> 0x007f }
            com.freshchat.consumer.sdk.j.bc.e(r2, r8)     // Catch:{ Exception -> 0x007f }
        L_0x0013:
            boolean r2 = r8.isUserMessage()     // Catch:{ Exception -> 0x007f }
            if (r2 != 0) goto L_0x0025
            boolean r2 = com.freshchat.consumer.sdk.j.aj.D(r8)     // Catch:{ Exception -> 0x007f }
            if (r2 == 0) goto L_0x0025
            if (r9 == 0) goto L_0x0024
            r7.endTransaction()
        L_0x0024:
            return r1
        L_0x0025:
            if (r9 == 0) goto L_0x002a
            r7.beginTransaction()     // Catch:{ Exception -> 0x007f }
        L_0x002a:
            android.content.ContentValues r2 = c(r8)     // Catch:{ Exception -> 0x007f }
            com.freshchat.consumer.sdk.c.f r3 = r6.cy()     // Catch:{ Exception -> 0x007f }
            java.util.List r4 = r8.getMessageFragments()     // Catch:{ Exception -> 0x007f }
            java.lang.String r5 = r8.getAlias()     // Catch:{ Exception -> 0x007f }
            int r8 = r8.getUploadState()     // Catch:{ Exception -> 0x007f }
            java.util.List r8 = r3.a(r7, r4, r5, r8)     // Catch:{ Exception -> 0x007f }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x007f }
            boolean r8 = r8.contains(r3)     // Catch:{ Exception -> 0x007f }
            r8 = r8 ^ r0
            if (r8 == 0) goto L_0x0076
            java.lang.String r8 = "message"
            r3 = 0
            long r2 = r7.replace(r8, r3, r2)     // Catch:{ Exception -> 0x007f }
            java.lang.String r8 = TAG     // Catch:{ Exception -> 0x007f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f }
            r4.<init>()     // Catch:{ Exception -> 0x007f }
            java.lang.String r5 = "Inserted message into DB with ID "
            r4.append(r5)     // Catch:{ Exception -> 0x007f }
            r4.append(r2)     // Catch:{ Exception -> 0x007f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007f }
            com.freshchat.consumer.sdk.j.ai.d(r8, r4)     // Catch:{ Exception -> 0x007f }
            r4 = -1
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0076
            if (r9 == 0) goto L_0x0077
            r7.setTransactionSuccessful()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0077
        L_0x0074:
            r8 = move-exception
            goto L_0x0081
        L_0x0076:
            r0 = 0
        L_0x0077:
            if (r9 == 0) goto L_0x0087
        L_0x0079:
            r7.endTransaction()
            goto L_0x0087
        L_0x007d:
            r8 = move-exception
            goto L_0x0088
        L_0x007f:
            r8 = move-exception
            r0 = 0
        L_0x0081:
            com.freshchat.consumer.sdk.j.q.a(r8)     // Catch:{ all -> 0x007d }
            if (r9 == 0) goto L_0x0087
            goto L_0x0079
        L_0x0087:
            return r0
        L_0x0088:
            if (r9 == 0) goto L_0x008d
            r7.endTransaction()
        L_0x008d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.g.a(android.database.sqlite.SQLiteDatabase, com.freshchat.consumer.sdk.beans.Message, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[Catch:{ Exception -> 0x006c, all -> 0x006a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.database.sqlite.SQLiteDatabase r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.String r3 = "SELECT _id FROM message EXCEPT SELECT DISTINCT fragments._id FROM fragments"
            android.database.Cursor r0 = r9.rawQuery(r3, r0)     // Catch:{ Exception -> 0x006c }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x006c }
            r3.<init>()     // Catch:{ Exception -> 0x006c }
            boolean r4 = com.freshchat.consumer.sdk.c.b.b(r0)     // Catch:{ Exception -> 0x006c }
            if (r4 == 0) goto L_0x002d
            boolean r4 = com.freshchat.consumer.sdk.c.b.d(r0)     // Catch:{ Exception -> 0x006c }
            if (r4 == 0) goto L_0x002d
            java.lang.String r4 = "_id"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x006c }
        L_0x0020:
            java.lang.String r5 = r0.getString(r4)     // Catch:{ Exception -> 0x006c }
            r3.add(r5)     // Catch:{ Exception -> 0x006c }
            boolean r5 = r0.moveToNext()     // Catch:{ Exception -> 0x006c }
            if (r5 != 0) goto L_0x0020
        L_0x002d:
            boolean r4 = com.freshchat.consumer.sdk.j.k.a(r3)     // Catch:{ Exception -> 0x006c }
            if (r4 == 0) goto L_0x0062
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006c }
            r4.<init>()     // Catch:{ Exception -> 0x006c }
            java.lang.String r5 = "_id IN ("
            r4.append(r5)     // Catch:{ Exception -> 0x006c }
            java.lang.String r5 = "?"
            java.lang.String r6 = ","
            int r7 = com.freshchat.consumer.sdk.j.k.b(r3)     // Catch:{ Exception -> 0x006c }
            java.lang.String r5 = com.freshchat.consumer.sdk.j.as.a(r5, r6, r7)     // Catch:{ Exception -> 0x006c }
            r4.append(r5)     // Catch:{ Exception -> 0x006c }
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x006c }
            java.lang.String r5 = "message"
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x006c }
            java.lang.Object[] r3 = r3.toArray(r6)     // Catch:{ Exception -> 0x006c }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ Exception -> 0x006c }
            r9.delete(r5, r4, r3)     // Catch:{ Exception -> 0x006c }
        L_0x0062:
            java.io.Closeable[] r9 = new java.io.Closeable[r1]
            r9[r2] = r0
            com.freshchat.consumer.sdk.j.ad.a(r9)
            goto L_0x008e
        L_0x006a:
            r9 = move-exception
            goto L_0x008f
        L_0x006c:
            r9 = move-exception
            java.lang.String r3 = "FRESHCHAT"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r4.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "Failed to clean up empty messages. "
            r4.append(r5)     // Catch:{ all -> 0x006a }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x006a }
            r4.append(r9)     // Catch:{ all -> 0x006a }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x006a }
            com.freshchat.consumer.sdk.j.ai.e(r3, r9)     // Catch:{ all -> 0x006a }
            java.io.Closeable[] r9 = new java.io.Closeable[r1]
            r9[r2] = r0
            com.freshchat.consumer.sdk.j.ad.a(r9)
        L_0x008e:
            return
        L_0x008f:
            java.io.Closeable[] r1 = new java.io.Closeable[r1]
            r1[r2] = r0
            com.freshchat.consumer.sdk.j.ad.a(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.g.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public boolean b(Message message) {
        return a(cs(), message, true);
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("message", el, "reply_fragments LIKE ?", new String[]{"%rawJsonOfUnsupportedType%"}, null, null, null);
            if (cursor == null) {
                b.c(cursor);
                return;
            }
            Map<String, Integer> a2 = a(cursor);
            Integer num = a2.get("reply_fragments");
            if (num == null) {
                b.c(cursor);
                return;
            }
            if (b.b(cursor)) {
                do {
                    try {
                        JSONArray jSONArray = new JSONArray(cursor.getString(num.intValue()));
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                            if (jSONObject.has("rawJsonOfUnsupportedType")) {
                                jSONArray.put(i, new JSONObject(jSONObject.getString("rawJsonOfUnsupportedType")));
                            }
                        }
                        Message f2 = f(cursor, a2);
                        if (f2 != null) {
                            f2.setReplyFragments((List) ab.io().fromJson(jSONArray.toString(), new o(this).getType()));
                            a(sQLiteDatabase, f2);
                        }
                    } catch (Exception e2) {
                        q.a(e2);
                    }
                } while (cursor.moveToNext());
            }
            b.c(cursor);
        } catch (Exception e3) {
            q.a(e3);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
    }

    public List<Message> cC() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("message", el, "display!=-1 AND uploaded=0 AND user_type=0", null, null, null, null);
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    Message f2 = f(cursor, a2);
                    f2.setMessageFragments(cy().W(f2.getAlias()));
                    arrayList.add(f2);
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

    public long cD() {
        long j = 0;
        Cursor cursor = null;
        try {
            String valueOf = String.valueOf(0);
            cursor = cs().rawQuery("SELECT MAX(created_at) as MAX_TIME FROM message WHERE user_type !=? ", new String[]{valueOf});
            if (cursor.moveToNext()) {
                j = cursor.getLong(0);
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return j;
    }

    public Map<Long, Integer> cF() {
        Long valueOf;
        Integer valueOf2;
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{Constants.CHANNEL_ID, "COUNT(1)"}, "display!=-1 AND read=0", null, Constants.CHANNEL_ID, null, null);
            while (cursor.moveToNext()) {
                hashMap.put(Long.valueOf(cursor.getLong(0)), Integer.valueOf(cursor.getInt(1)));
            }
            for (Long longValue : cG()) {
                long longValue2 = longValue.longValue();
                if (hashMap.containsKey(Long.valueOf(longValue2))) {
                    valueOf = Long.valueOf(longValue2);
                    valueOf2 = Integer.valueOf(((Integer) hashMap.get(Long.valueOf(longValue2))).intValue() + 1);
                } else {
                    valueOf = Long.valueOf(longValue2);
                    valueOf2 = Integer.valueOf(1);
                }
                hashMap.put(valueOf, valueOf2);
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashMap;
    }

    public Set<Long> cz() {
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            cursor = cB();
            if (b.b(cursor)) {
                int columnIndex = cursor.getColumnIndex("marketing_id");
                do {
                    hashSet.add(Long.valueOf(cursor.getLong(columnIndex)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        String str = TAG;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Returning marketing IDs of size ");
        outline73.append(hashSet.size());
        ai.d(str, outline73.toString());
        return hashSet;
    }

    /* JADX INFO: finally extract failed */
    public int gr() {
        try {
            Cursor query = cs().query("message", new String[]{"_id"}, "user_type!= 0", null, null, null, null);
            int count = query.getCount();
            b.c(query);
            return count;
        } catch (Exception e2) {
            q.a(e2);
            b.c(null);
            return 0;
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
    }

    public Set<Long> i(long j) {
        HashSet hashSet = new HashSet();
        if (j <= 0) {
            return hashSet;
        }
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"marketing_id"}, "marketing_id > 0 AND read=0 AND channel_id = ?", new String[]{Long.toString(j)}, null, null, null);
            if (b.b(cursor)) {
                int columnIndex = cursor.getColumnIndex("marketing_id");
                do {
                    hashSet.add(Long.valueOf(cursor.getLong(columnIndex)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashSet;
    }

    public boolean j(long j) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = cs().query("message", el, "marketing_id=?", new String[]{String.valueOf(j)}, null, null, null);
            int count = cursor.getCount();
            String str = TAG;
            ai.d(str, "Message by marketing ID " + j);
            if (count > 0) {
                z = true;
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return z;
    }

    public List<String> jN() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query(true, "message", new String[]{"user_id"}, "uploaded=1 AND user_type=0", null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("user_id")));
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

    public List<Message> k(long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Map<String, List<MessageFragment>> h = cy().h(j);
            cursor = cs().query("message", el, "display!=-1 AND channel_id=?", new String[]{Long.toString(j)}, null, null, "created_at");
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    Message f2 = f(cursor, a2);
                    f2.setMessageFragments(h.get(f2.getAlias()));
                    arrayList.add(f2);
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

    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.Message l(long r12) {
        /*
            r11 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.cs()     // Catch:{ Exception -> 0x004a }
            java.lang.String r2 = "message"
            java.lang.String[] r3 = el     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "channel_id=? AND display != -1"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x004a }
            r6 = 0
            java.lang.String r12 = java.lang.Long.toString(r12)     // Catch:{ Exception -> 0x004a }
            r5[r6] = r12     // Catch:{ Exception -> 0x004a }
            r6 = 0
            r7 = 0
            java.lang.String r8 = "created_at DESC"
            java.lang.String r9 = "1"
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x004a }
            boolean r13 = com.freshchat.consumer.sdk.c.b.b(r12)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            if (r13 == 0) goto L_0x003c
            java.util.Map r13 = r11.a(r12)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            com.freshchat.consumer.sdk.beans.Message r0 = r11.f(r12, r13)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            com.freshchat.consumer.sdk.c.f r13 = r11.cy()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.lang.String r1 = r0.getAlias()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.util.List r13 = r13.W(r1)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            r0.setMessageFragments(r13)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
        L_0x003c:
            com.freshchat.consumer.sdk.c.b.c(r12)
            goto L_0x0053
        L_0x0040:
            r13 = move-exception
            r0 = r12
            goto L_0x0054
        L_0x0043:
            r13 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x004c
        L_0x0048:
            r13 = move-exception
            goto L_0x0054
        L_0x004a:
            r13 = move-exception
            r12 = r0
        L_0x004c:
            com.freshchat.consumer.sdk.j.q.a(r13)     // Catch:{ all -> 0x0048 }
            com.freshchat.consumer.sdk.c.b.c(r0)
            r0 = r12
        L_0x0053:
            return r0
        L_0x0054:
            com.freshchat.consumer.sdk.c.b.c(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.g.l(long):com.freshchat.consumer.sdk.beans.Message");
    }

    public int m(long j) {
        cs().beginTransaction();
        int i = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("read", Integer.valueOf(1));
            i = cs().update("message", contentValues, "read=0 AND channel_id=?", new String[]{Long.toString(j)});
            cs().setTransactionSuccessful();
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            cs().endTransaction();
            throw th;
        }
        cs().endTransaction();
        return i;
    }

    public boolean p(long j) {
        for (Channel id : new c(this.context).cv()) {
            if (a(id.getId(), j)) {
                return true;
            }
        }
        return false;
    }
}
