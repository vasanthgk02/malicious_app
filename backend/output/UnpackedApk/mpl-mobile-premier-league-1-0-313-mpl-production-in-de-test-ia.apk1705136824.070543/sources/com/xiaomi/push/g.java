package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;
import java.util.HashMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, String> f4787a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f4787a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        f4787a.put("89504E47", "png");
        f4787a.put("47494638", "gif");
        f4787a.put("474946", "gif");
        f4787a.put("424D", "bmp");
    }

    public static long a(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? a(listFiles[i]) : listFiles[i].length();
            }
        } catch (Exception e2) {
            b.a((Throwable) e2);
        }
        return j;
    }
}
