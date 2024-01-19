package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;

public class o extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("_id", "INTEGER", false, 8, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef("name", "TEXT", false, 8));
        arrayList.add(new ColDef("timezone", "TEXT", false, 8));
        arrayList.add(new ColDef("days_bh", "TEXT", false, 8));
        arrayList.add(new ColDef("days_working", "TEXT", false, 8));
        ColDef colDef2 = new ColDef(RNGestureHandlerModule.KEY_ENABLED, "INTEGER", true, 8, " DEFAULT 0");
        arrayList.add(colDef2);
        ColDef colDef3 = new ColDef("default_bh", "INTEGER", true, 8, " DEFAULT 0");
        arrayList.add(colDef3);
        arrayList.add(new ColDef("bh_type", "TEXT", true, 8));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return "business_hours";
    }
}
