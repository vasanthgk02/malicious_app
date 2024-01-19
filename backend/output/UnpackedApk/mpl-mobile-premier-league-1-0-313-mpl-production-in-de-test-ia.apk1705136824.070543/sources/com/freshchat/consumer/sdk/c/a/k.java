package com.freshchat.consumer.sdk.c.a;

import androidx.core.app.NotificationCompat.CarExtender;
import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class k extends c {
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        ColDef colDef = new ColDef("alias", "TEXT", true, 1, " PRIMARY KEY ");
        arrayList.add(colDef);
        arrayList.add(new ColDef("first_name", "TEXT", true, 1));
        arrayList.add(new ColDef("last_name", "TEXT", true, 1));
        arrayList.add(new ColDef("profile_pic_url", "TEXT", true, 1));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    public String cP() {
        return CarExtender.KEY_PARTICIPANTS;
    }
}
