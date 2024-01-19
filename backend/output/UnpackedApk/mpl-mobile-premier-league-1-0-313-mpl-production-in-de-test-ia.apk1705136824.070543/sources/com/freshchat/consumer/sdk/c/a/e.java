package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class e extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("_id", "INTEGER", false, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef("name", "TEXT", false, 1));
        arrayList.add(new ColDef("position", "TEXT", false, 1));
        arrayList.add(new ColDef("icon", "TEXT", false, 1));
        arrayList.add(new ColDef("hidden", "INTEGER", true, 1));
        arrayList.add(new ColDef("type", "TEXT", false, 1));
        ColDef colDef2 = new ColDef("is_default", "INTEGER", true, 1, " DEFAULT 0");
        arrayList.add(colDef2);
        ColDef colDef3 = new ColDef("restricted", "INTEGER", true, 1, " DEFAULT 0");
        arrayList.add(colDef3);
        ColDef colDef4 = new ColDef("updated_at", "INTEGER", true, 1, " DEFAULT 0");
        arrayList.add(colDef4);
        arrayList.add(new ColDef("channel_alias", "TEXT", true, 3));
        arrayList.add(new ColDef("operating_hours_id", "INTEGER", true, 8));
        arrayList.add(new ColDef("flow_id", "TEXT", true, 8));
        arrayList.add(new ColDef("flow_version_id", "TEXT", true, 8));
        arrayList.add(new ColDef("service_account_id", "INTEGER", true, 8));
        arrayList.add(new ColDef("flow_business_hours_type", "TEXT", true, 8));
        arrayList.add(new ColDef("flow_messages_json", "TEXT", true, 8));
        arrayList.add(new ColDef("quick_actions_menu_json", "TEXT", true, 9));
        arrayList.add(new ColDef("quick_actions_slash_command_json", "TEXT", true, 9));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "channels";
    }
}
