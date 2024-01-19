package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class m extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("meta_key", "TEXT", false, 1, " UNIQUE ");
        arrayList.add(colDef);
        arrayList.add(new ColDef("meta_value", "TEXT", false, 1));
        ColDef colDef2 = new ColDef("is_uploaded", "INTEGER", false, 1, " DEFAULT 0");
        arrayList.add(colDef2);
        ColDef colDef3 = new ColDef("meta_type", "INTEGER", false, 1, " DEFAULT 2");
        arrayList.add(colDef3);
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "user_meta";
    }
}
