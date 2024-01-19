package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.FlowBusinessHourType;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.beans.Tag.TaggedType;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.h;
import com.freshchat.consumer.sdk.c.j;
import com.freshchat.consumer.sdk.e.d;
import com.freshchat.consumer.sdk.e.f;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.rudderstack.android.sdk.core.EventsDbHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static boolean a(Context context, com.freshchat.consumer.sdk.b.a.a aVar) {
        boolean z;
        ArrayList arrayList;
        JSONArray jSONArray;
        int i;
        int i2;
        String str;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        long j;
        Channel updatedAt;
        Context context2 = context;
        String str2 = "channelId";
        if (aVar.isValid() && aVar.cn()) {
            JSONObject cm = aVar.cm();
            if (cm != null) {
                try {
                    c cVar = new c(context2);
                    JSONArray jSONArray2 = cm.getJSONArray("channels");
                    if (jSONArray2 != null) {
                        int length = jSONArray2.length();
                        c cVar2 = cVar;
                        ArrayList arrayList5 = new ArrayList();
                        try {
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = arrayList5;
                            ArrayList arrayList8 = new ArrayList();
                            int i3 = 0;
                            while (i3 < length) {
                                try {
                                    JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                                    i2 = length;
                                    i = i3;
                                    try {
                                        j = jSONObject.getLong(str2);
                                        jSONArray = jSONArray2;
                                    } catch (JSONException e2) {
                                        e = e2;
                                        arrayList4 = arrayList6;
                                        str = str2;
                                        jSONArray = jSONArray2;
                                        arrayList3 = arrayList7;
                                        arrayList2 = arrayList8;
                                        ai.e("FRESHCHAT", "Exception occurred", e);
                                        i3 = i + 1;
                                        arrayList7 = arrayList3;
                                        arrayList8 = arrayList2;
                                        str2 = str;
                                        length = i2;
                                        jSONArray2 = jSONArray;
                                        arrayList6 = arrayList;
                                    }
                                    try {
                                        String str3 = str2;
                                        try {
                                            long j2 = j;
                                            updatedAt = new Channel().setId(j).setName(jSONObject.getString("name")).setPosition(jSONObject.getInt("position")).setChannelType(jSONObject.getString("type")).setIconUrl(jSONObject.optString("iconUrl")).setDefault(jSONObject.getBoolean("defaultChannel")).setRestricted(jSONObject.optBoolean("restricted")).setHidden(jSONObject.optBoolean("hidden")).setUpdatedAt(jSONObject.getLong(EventsDbHelper.UPDATED));
                                            if (jSONObject.has("operatingHoursId")) {
                                                updatedAt.setOperatingHoursId(jSONObject.getLong("operatingHoursId"));
                                            }
                                            if (jSONObject.has("flowId")) {
                                                updatedAt.setFlowId(jSONObject.getString("flowId"));
                                            }
                                            if (jSONObject.has("flowVersionId")) {
                                                updatedAt.setFlowVersionId(jSONObject.getString("flowVersionId"));
                                            }
                                            if (jSONObject.has("serviceAccountId")) {
                                                updatedAt.setServiceAccountId(jSONObject.getLong("serviceAccountId"));
                                            }
                                            if (jSONObject.has("flowBusinessHourType")) {
                                                updatedAt.setFlowBusinessHourType(FlowBusinessHourType.get(jSONObject.getString("flowBusinessHourType")));
                                            }
                                            if (jSONObject.has("flowMessages")) {
                                                updatedAt.setFlowMessagesJson(jSONObject.getString("flowMessages"));
                                            }
                                            if (jSONObject.has("channelAlias")) {
                                                updatedAt.setChannelAlias(jSONObject.getString("channelAlias"));
                                            }
                                            if (jSONObject.has("serviceAccount")) {
                                                JSONObject jSONObject2 = jSONObject.getJSONObject("serviceAccount");
                                                Participant participant = new Participant();
                                                participant.setFirstName(jSONObject2.getString("firstName"));
                                                if (jSONObject2.has("name")) {
                                                    participant.setFirstName(jSONObject2.getString("name"));
                                                }
                                                participant.setAlias(jSONObject2.getString("id"));
                                                if (jSONObject2.has("profilePicUrl")) {
                                                    participant.setProfilePicUrl(jSONObject2.getString("profilePicUrl"));
                                                }
                                                arrayList6.add(participant);
                                            }
                                            JSONObject optJSONObject = jSONObject.optJSONObject("quick_actions");
                                            if (optJSONObject != null) {
                                                updatedAt.setQuickActions(j.d(optJSONObject));
                                            }
                                            JSONObject optJSONObject2 = jSONObject.optJSONObject("welcomeMessage");
                                            if (optJSONObject2 != null) {
                                                Message b2 = c.b(optJSONObject2);
                                                long j3 = j2;
                                                b2.setChannelId(j3);
                                                arrayList = arrayList6;
                                                try {
                                                    b2.setRead(true);
                                                    b2.setAlias(j3 + "_welcome_message");
                                                    b2.setMessageUserAlias("agent");
                                                    b2.setMessageUserType(2);
                                                    updatedAt.setLatestOrWelcomeMessage(b2);
                                                } catch (JSONException e3) {
                                                    e = e3;
                                                }
                                            } else {
                                                arrayList = arrayList6;
                                            }
                                            arrayList3 = arrayList7;
                                        } catch (JSONException e4) {
                                            e = e4;
                                            arrayList = arrayList6;
                                            arrayList3 = arrayList7;
                                            arrayList2 = arrayList8;
                                            str = str3;
                                            ai.e("FRESHCHAT", "Exception occurred", e);
                                            i3 = i + 1;
                                            arrayList7 = arrayList3;
                                            arrayList8 = arrayList2;
                                            str2 = str;
                                            length = i2;
                                            jSONArray2 = jSONArray;
                                            arrayList6 = arrayList;
                                        }
                                        try {
                                            arrayList3.add(updatedAt);
                                            str = str3;
                                        } catch (JSONException e5) {
                                            e = e5;
                                            arrayList2 = arrayList8;
                                            str = str3;
                                            ai.e("FRESHCHAT", "Exception occurred", e);
                                            i3 = i + 1;
                                            arrayList7 = arrayList3;
                                            arrayList8 = arrayList2;
                                            str2 = str;
                                            length = i2;
                                            jSONArray2 = jSONArray;
                                            arrayList6 = arrayList;
                                        }
                                        try {
                                            List<Tag> a2 = f.a(jSONObject.getString(str), jSONObject.optJSONArray("tags"), TaggedType.CHANNEL);
                                            if (k.a(a2)) {
                                                arrayList2 = arrayList8;
                                                try {
                                                    arrayList2.addAll(a2);
                                                } catch (JSONException e6) {
                                                    e = e6;
                                                }
                                            } else {
                                                arrayList2 = arrayList8;
                                            }
                                        } catch (JSONException e7) {
                                            e = e7;
                                            arrayList2 = arrayList8;
                                            ai.e("FRESHCHAT", "Exception occurred", e);
                                            i3 = i + 1;
                                            arrayList7 = arrayList3;
                                            arrayList8 = arrayList2;
                                            str2 = str;
                                            length = i2;
                                            jSONArray2 = jSONArray;
                                            arrayList6 = arrayList;
                                        }
                                    } catch (JSONException e8) {
                                        e = e8;
                                        arrayList4 = arrayList6;
                                        str = str2;
                                        arrayList3 = arrayList7;
                                        arrayList2 = arrayList8;
                                        ai.e("FRESHCHAT", "Exception occurred", e);
                                        i3 = i + 1;
                                        arrayList7 = arrayList3;
                                        arrayList8 = arrayList2;
                                        str2 = str;
                                        length = i2;
                                        jSONArray2 = jSONArray;
                                        arrayList6 = arrayList;
                                    }
                                } catch (JSONException e9) {
                                    e = e9;
                                    arrayList = arrayList6;
                                    i2 = length;
                                    i = i3;
                                    jSONArray = jSONArray2;
                                    arrayList3 = arrayList7;
                                    str = str2;
                                    arrayList2 = arrayList8;
                                    ai.e("FRESHCHAT", "Exception occurred", e);
                                    i3 = i + 1;
                                    arrayList7 = arrayList3;
                                    arrayList8 = arrayList2;
                                    str2 = str;
                                    length = i2;
                                    jSONArray2 = jSONArray;
                                    arrayList6 = arrayList;
                                }
                                i3 = i + 1;
                                arrayList7 = arrayList3;
                                arrayList8 = arrayList2;
                                str2 = str;
                                length = i2;
                                jSONArray2 = jSONArray;
                                arrayList6 = arrayList;
                            }
                            ArrayList arrayList9 = arrayList6;
                            ArrayList arrayList10 = arrayList7;
                            ArrayList arrayList11 = arrayList8;
                            Context context3 = context;
                            ArrayList arrayList12 = arrayList9;
                            try {
                                new j(context3).a(TaggedType.CHANNEL);
                                cVar2.a((List<Channel>) arrayList10, (List<Tag>) arrayList11);
                                if (k.a(arrayList12)) {
                                    new h(context3).g(arrayList12);
                                }
                                b(context, aVar);
                                z = k.a(arrayList10);
                            } catch (JSONException unused) {
                                ai.e("FRESHCHAT_WARNING", "Error processing channels");
                                z = false;
                                com.freshchat.consumer.sdk.b.a.g(context);
                                return z;
                            }
                        } catch (JSONException unused2) {
                            Context context4 = context;
                            ai.e("FRESHCHAT_WARNING", "Error processing channels");
                            z = false;
                            com.freshchat.consumer.sdk.b.a.g(context);
                            return z;
                        }
                        com.freshchat.consumer.sdk.b.a.g(context);
                        return z;
                    }
                } catch (JSONException unused3) {
                    Context context5 = context2;
                    ai.e("FRESHCHAT_WARNING", "Error processing channels");
                    z = false;
                    com.freshchat.consumer.sdk.b.a.g(context);
                    return z;
                }
            }
        }
        Context context6 = context2;
        z = false;
        com.freshchat.consumer.sdk.b.a.g(context);
        return z;
    }

    public static Map<String, String> b(e eVar) {
        String bB = eVar.bB();
        HashMap hashMap = new HashMap();
        if (as.a(bB)) {
            hashMap.put("If-Modified-Since", bB);
        }
        return hashMap;
    }

    public static void b(Context context, com.freshchat.consumer.sdk.b.a.a aVar) {
        e w = w(context);
        w.bH();
        w.bD();
        JSONObject cm = aVar.cm();
        if (cm.has("contentLocale")) {
            try {
                String string = cm.getString("contentLocale");
                if (as.a(string)) {
                    w.C(string);
                }
            } catch (JSONException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Channels content locale exception - ");
                outline73.append(e2.toString());
                ai.e("FRESHCHAT_WARNING", outline73.toString());
            }
        }
        if (aVar.cm().has("lastModifiedAt")) {
            try {
                w.B(cm.getString("lastModifiedAt"));
            } catch (JSONException e3) {
                ai.e("FRESHCHAT_WARNING", e3.toString());
            }
        }
        w.D(ah.bc(context));
    }

    public static boolean v(Context context) {
        aa.fF();
        try {
            d a2 = new com.freshchat.consumer.sdk.e.c(context).a(com.freshchat.consumer.sdk.j.a.A(context), b(e.i(context)));
            if (a2.getStatusCode() == 410) {
                f.o(context, com.freshchat.consumer.sdk.e.c.a(a2));
                return false;
            } else if (a2.getStatusCode() == 200) {
                return a(context, new com.freshchat.consumer.sdk.b.a.a(a2.getInputStream()));
            } else {
                if (a2.getStatusCode() != 304) {
                    return false;
                }
                e.i(context).bH();
                e.i(context).D(ah.bc(context));
                return false;
            }
        } catch (DeletedException | Exception e2) {
            q.a(e2);
            return false;
        }
    }

    public static e w(Context context) {
        return e.i(context);
    }
}
