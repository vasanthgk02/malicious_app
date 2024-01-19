package com.freshchat.consumer.sdk.c.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.ColDef;
import com.freshchat.consumer.sdk.beans.Message.MessageType;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;

public class j extends c {
    public static final String TAG = "com.freshchat.consumer.sdk.c.a.j";

    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("_id", "TEXT", false, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef(Constants.CHANNEL_ID, "TEXT", true, 1));
        arrayList.add(new ColDef("conv_id", "TEXT", true, 1));
        arrayList.add(new ColDef("marketing_id", "INTEGER", true, 1));
        arrayList.add(new ColDef("user_id", "TEXT", true, 1));
        ColDef colDef2 = new ColDef("user_type", "INTEGER", false, 1, " DEFAULT 0");
        arrayList.add(colDef2);
        arrayList.add(new ColDef("read", "INTEGER", true, 1));
        arrayList.add(new ColDef("created_at", "INTEGER", true, 1));
        ColDef colDef3 = new ColDef("uploaded", "INTEGER", true, 1, " DEFAULT 0");
        arrayList.add(colDef3);
        ColDef colDef4 = new ColDef("display", "INTEGER", true, 1, " DEFAULT 0");
        arrayList.add(colDef4);
        arrayList.add(new ColDef("reply_fragments", "TEXT", true, 4));
        arrayList.add(new ColDef("extras_json", "TEXT", true, 5));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" DEFAULT ");
        outline73.append(MessageType.MESSAGE_TYPE_NORMAL.getIntValue());
        ColDef colDef5 = new ColDef(PushMessageHelper.MESSAGE_TYPE, "INTEGER", true, 6, outline73.toString());
        arrayList.add(colDef5);
        arrayList.add(new ColDef("internal_meta", "TEXT", true, 6));
        ColDef colDef6 = new ColDef("responded", "INTEGER", true, 6, " DEFAULT 0");
        arrayList.add(colDef6);
        ColDef colDef7 = new ColDef("should_translate", "INTEGER", true, 7, " DEFAULT 0");
        arrayList.add(colDef7);
        arrayList.add(new ColDef("flow_step_id", "TEXT", true, 8));
        arrayList.add(new ColDef("user_name", "TEXT", true, 8));
        arrayList.add(new ColDef("user_profile_pic", "TEXT", true, 8));
        ColDef colDef8 = new ColDef("should_delete", "INTEGER", true, 8, " DEFAULT 0");
        arrayList.add(colDef8);
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "message";
    }
}
