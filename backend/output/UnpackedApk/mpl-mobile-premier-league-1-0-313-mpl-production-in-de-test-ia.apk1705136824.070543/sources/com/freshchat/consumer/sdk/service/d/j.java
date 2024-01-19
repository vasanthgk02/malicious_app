package com.freshchat.consumer.sdk.service.d;

import androidx.core.app.NotificationCompatJellybean;
import com.freshchat.consumer.sdk.beans.QuickActions;
import com.freshchat.consumer.sdk.j.ab;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class j {

    public enum a {
        MENU("Menu"),
        SLASH_COMMAND("SlashCommand"),
        BUTTON("Button");
        
        public String type;

        /* access modifiers changed from: public */
        a(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    public static List<String> N(List<Map<String, String>> list) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : list) {
            arrayList.add(map.get(NotificationCompatJellybean.KEY_LABEL));
        }
        return arrayList;
    }

    public static QuickActions d(JSONObject jSONObject) {
        return (QuickActions) new ab().fromJson(jSONObject.toString(), QuickActions.class);
    }
}
