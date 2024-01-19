package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.push.ad;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ai {

    /* renamed from: a  reason: collision with root package name */
    public static Object f4851a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, Queue<String>> f841a = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f4851a) {
            try {
                SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
                Queue queue = f841a.get(str);
                if (queue == 0) {
                    String[] split = sharedPreferences.getString(str, "").split(",");
                    LinkedList linkedList = new LinkedList();
                    for (String add : split) {
                        linkedList.add(add);
                    }
                    f841a.put(str, linkedList);
                    queue = linkedList;
                }
                if (queue.contains(str2)) {
                    return true;
                }
                queue.add(str2);
                if (queue.size() > 25) {
                    queue.poll();
                }
                String a2 = ad.a((Collection<?>) queue, (String) ",");
                Editor edit = sharedPreferences.edit();
                edit.putString(str, a2);
                edit.commit();
                return false;
            }
        }
    }
}
