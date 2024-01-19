package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class i extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("_id", "TEXT", false, 1));
        arrayList.add(new ColDef("frag_type", "INTEGER", false, 1));
        arrayList.add(new ColDef("content", "TEXT", false, 1));
        arrayList.add(new ColDef("content_type", "TEXT", false, 1));
        arrayList.add(new ColDef("position", "INTEGER", false, 1));
        arrayList.add(new ColDef("extras_json", "TEXT", false, 1));
        ColDef colDef = new ColDef("uploaded", "INTEGER", true, 1, " DEFAULT 0");
        arrayList.add(colDef);
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "fragments";
    }

    public String cU() {
        return " PRIMARY KEY (_id,position)";
    }
}
