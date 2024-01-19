package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class d extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("_id", "INTEGER", false, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef("title", "TEXT", false, 1));
        arrayList.add(new ColDef("description", "TEXT", false, 1));
        arrayList.add(new ColDef("icon_url", "TEXT", true, 1));
        arrayList.add(new ColDef("position", "INTEGER", false, 1));
        arrayList.add(new ColDef("updated_at", "INTEGER", false, 1));
        arrayList.add(new ColDef("category_alias", "TEXT", true, 3));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "categories";
    }
}
