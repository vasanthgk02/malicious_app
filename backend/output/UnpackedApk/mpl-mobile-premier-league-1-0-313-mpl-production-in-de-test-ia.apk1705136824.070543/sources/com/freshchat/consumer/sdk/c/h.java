package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.core.app.NotificationCompat.CarExtender;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.c.a.k;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h extends b {
    public static final String[] em = new k().cR();
    public final Context context;

    public h(Context context2) {
        super(context2);
        this.context = context2;
    }

    public static ContentValues a(Participant participant) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("alias", participant.getAlias());
        contentValues.put("first_name", participant.getFirstName());
        contentValues.put("last_name", participant.getLastName());
        contentValues.put("profile_pic_url", participant.getProfilePicUrl());
        return contentValues;
    }

    private Cursor cI() {
        return cs().query(CarExtender.KEY_PARTICIPANTS, em, null, null, null, null, null);
    }

    private Participant g(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        String string = cursor.getString(map.get("alias").intValue());
        String string2 = cursor.getString(map.get("first_name").intValue());
        String string3 = cursor.getString(map.get("last_name").intValue());
        String string4 = cursor.getString(map.get("profile_pic_url").intValue());
        Participant participant = new Participant();
        participant.setAlias(string);
        participant.setFirstName(string2);
        participant.setLastName(string3);
        participant.setProfilePicUrl(string4);
        return participant;
    }

    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("alias", Integer.valueOf(cursor.getColumnIndex("alias")));
            hashMap.put("profile_pic_url", GeneratedOutlineSupport.outline26(hashMap, "last_name", GeneratedOutlineSupport.outline26(hashMap, "first_name", Integer.valueOf(cursor.getColumnIndex("first_name")), cursor, "last_name"), cursor, "profile_pic_url"));
        }
        return hashMap;
    }

    public List<Participant> cH() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cI();
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    Participant g = g(cursor, a2);
                    if (g != null) {
                        arrayList.add(g);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Boolean> g(List<Participant> list) {
        ArrayList arrayList = new ArrayList();
        if (com.freshchat.consumer.sdk.j.k.a(list)) {
            for (Participant a2 : list) {
                arrayList.add(Boolean.valueOf(cs().replace(CarExtender.KEY_PARTICIPANTS, null, a(a2)) != -1));
            }
        }
        return arrayList;
    }
}
