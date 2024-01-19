package com.xiaomi.clientreport.processor;

import com.xiaomi.clientreport.data.a;
import java.util.HashMap;

public interface IPerfProcessor {
    void setPerfMap(HashMap<String, HashMap<String, a>> hashMap);
}
