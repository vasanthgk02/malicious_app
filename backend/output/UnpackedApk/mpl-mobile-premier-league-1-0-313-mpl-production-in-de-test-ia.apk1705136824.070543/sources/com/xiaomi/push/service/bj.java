package com.xiaomi.push.service;

import com.xiaomi.push.di;
import java.util.Map;

public class bj {
    public static di a(di diVar) {
        if (diVar != null) {
            Map<String, String> map = diVar.f497b;
            if (map != null) {
                map.remove("score_info");
            }
        }
        return diVar;
    }
}
