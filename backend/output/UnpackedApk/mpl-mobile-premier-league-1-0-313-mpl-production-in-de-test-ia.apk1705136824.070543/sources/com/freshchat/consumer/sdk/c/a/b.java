package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;
import sfs2x.client.requests.buddylist.InitBuddyListRequest;

public class b extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("_id", "TEXT", false, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef("created_m", "INTEGER", false, 1));
        arrayList.add(new ColDef("priority", "INTEGER", false, 1));
        arrayList.add(new ColDef("type", "INTEGER", false, 1));
        arrayList.add(new ColDef("json", "TEXT", false, 1));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return InitBuddyListRequest.KEY_BLIST;
    }
}
