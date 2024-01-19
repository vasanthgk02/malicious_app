package com.freshchat.consumer.sdk.service.d;

import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.beans.Tag.TaggedType;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class f {
    public static List<Tag> a(String str, JSONArray jSONArray, TaggedType taggedType) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        if (jSONArray == null) {
            return null;
        }
        try {
            arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        arrayList.add(new Tag(jSONArray.get(i).toString(), str, taggedType));
                    } catch (JSONException e2) {
                        ai.e("FRESHCHAT", "Exception occured", e2);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                arrayList2 = arrayList;
            }
        } catch (Exception e4) {
            e = e4;
            q.a(e);
            arrayList = arrayList2;
            return arrayList;
        }
        return arrayList;
    }
}
