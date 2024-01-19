package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import java.util.ArrayList;

public class f extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("_id", "TEXT", false, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef(Constants.CHANNEL_ID, "TEXT", false, 1));
        ColDef colDef2 = new ColDef("has_pending_csat", "INTEGER", false, 1, " DEFAULT 0");
        arrayList.add(colDef2);
        ColDef colDef3 = new ColDef("status", "INTEGER", false, 8, " DEFAULT 0");
        arrayList.add(colDef3);
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "conversations";
    }
}
