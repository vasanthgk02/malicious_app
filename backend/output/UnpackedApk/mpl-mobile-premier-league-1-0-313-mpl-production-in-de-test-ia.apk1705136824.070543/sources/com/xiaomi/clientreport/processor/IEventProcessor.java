package com.xiaomi.clientreport.processor;

import com.xiaomi.clientreport.data.a;
import java.util.ArrayList;
import java.util.HashMap;

public interface IEventProcessor {
    String bytesToString(byte[] bArr);

    void setEventMap(HashMap<String, ArrayList<a>> hashMap);

    byte[] stringToBytes(String str);
}
