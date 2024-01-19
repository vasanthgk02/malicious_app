package com.clevertap.android.sdk.inbox;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CTMessageDAO {
    public String campaignId;
    public long date;
    public long expires;
    public String id;
    public JSONObject jsonData;
    public boolean read;
    public List<String> tags = new ArrayList();
    public String userId;
    public JSONObject wzrkParams;

    public CTMessageDAO() {
    }

    public static CTMessageDAO initWithJSON(JSONObject jSONObject, String str) {
        long j;
        JSONObject jSONObject2 = jSONObject;
        CTMessageDAO cTMessageDAO = null;
        try {
            String string = jSONObject2.has("_id") ? jSONObject2.getString("_id") : null;
            long j2 = jSONObject2.has(DatePickerDialogModule.ARG_DATE) ? (long) jSONObject2.getInt(DatePickerDialogModule.ARG_DATE) : System.currentTimeMillis() / 1000;
            if (jSONObject2.has("wzrk_ttl")) {
                j = (long) jSONObject2.getInt("wzrk_ttl");
            } else {
                j = (System.currentTimeMillis() + 86400000) / 1000;
            }
            long j3 = j;
            JSONObject jSONObject3 = jSONObject2.has("msg") ? jSONObject2.getJSONObject("msg") : null;
            ArrayList arrayList = new ArrayList();
            if (jSONObject3 != null) {
                JSONArray jSONArray = jSONObject3.has("tags") ? jSONObject3.getJSONArray("tags") : null;
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                }
            }
            String string2 = jSONObject2.has("wzrk_id") ? jSONObject2.getString("wzrk_id") : "0_0";
            if (string2.equalsIgnoreCase("0_0")) {
                jSONObject2.put("wzrk_id", string2);
            }
            JSONObject jSONObject4 = new JSONObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    jSONObject4.put(next, jSONObject2.get(next));
                }
            }
            if (string != null) {
                CTMessageDAO cTMessageDAO2 = new CTMessageDAO(string, jSONObject3, false, j2, j3, str, arrayList, string2, jSONObject4);
                cTMessageDAO = cTMessageDAO2;
            }
            return cTMessageDAO;
        } catch (JSONException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to parse Notification inbox message to CTMessageDao - ");
            outline73.append(e2.getLocalizedMessage());
            Logger.d(outline73.toString());
            return null;
        }
    }

    public boolean containsVideoOrAudio() {
        Logger.d("CTMessageDAO:containsVideoOrAudio() called");
        CTInboxMessageContent cTInboxMessageContent = new CTInboxMessage(toJSON()).inboxMessageContents.get(0);
        if (cTInboxMessageContent.mediaIsVideo() || cTInboxMessageContent.mediaIsAudio()) {
            return true;
        }
        return false;
    }

    public void setTags(String str) {
        this.tags.addAll(Arrays.asList(str.split(",")));
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("msg", this.jsonData);
            jSONObject.put("isRead", this.read);
            jSONObject.put(DatePickerDialogModule.ARG_DATE, this.date);
            jSONObject.put("wzrk_ttl", this.expires);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.tags.size(); i++) {
                jSONArray.put(this.tags.get(i));
            }
            jSONObject.put("tags", jSONArray);
            jSONObject.put("wzrk_id", this.campaignId);
            jSONObject.put("wzrkParams", this.wzrkParams);
            return jSONObject;
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to convert CTMessageDao to JSON - "));
            return jSONObject;
        }
    }

    public CTMessageDAO(String str, JSONObject jSONObject, boolean z, long j, long j2, String str2, List<String> list, String str3, JSONObject jSONObject2) {
        this.id = str;
        this.jsonData = jSONObject;
        this.read = z;
        this.date = j;
        this.expires = j2;
        this.userId = str2;
        this.tags = list;
        this.campaignId = str3;
        this.wzrkParams = jSONObject2;
    }
}
