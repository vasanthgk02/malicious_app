package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class a extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("_id", "INTEGER", false, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        ColDef colDef2 = new ColDef("category_id", "INTEGER", false, 1, "REFERENCES categories");
        arrayList.add(colDef2);
        arrayList.add(new ColDef("title", "TEXT", false, 1));
        arrayList.add(new ColDef("content", "TEXT", false, 1));
        arrayList.add(new ColDef("position", "INTEGER", false, 1));
        arrayList.add(new ColDef("updated_at", "INTEGER", false, 1));
        arrayList.add(new ColDef("article_alias", "TEXT", true, 3));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "articles";
    }
}
