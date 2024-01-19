package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class g extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("conv_id", "INTEGER", false, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef("csat_id", "INTEGER", false, 1));
        arrayList.add(new ColDef("question", "TEXT", false, 1));
        arrayList.add(new ColDef("comments_allowed", "INTEGER", false, 1));
        arrayList.add(new ColDef("mandatory", "INTEGER", false, 1));
        arrayList.add(new ColDef("_status", "INTEGER", false, 1));
        ColDef colDef2 = new ColDef("initiated_time", "INTEGER", false, 2, " DEFAULT 0");
        arrayList.add(colDef2);
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "custsat";
    }
}
