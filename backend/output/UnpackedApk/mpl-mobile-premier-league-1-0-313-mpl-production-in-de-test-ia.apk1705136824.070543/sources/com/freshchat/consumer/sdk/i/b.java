package com.freshchat.consumer.sdk.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b {
    public static final String TAG = "com.freshchat.consumer.sdk.i.b";
    public static final BlockingQueue<Runnable> gV = new ArrayBlockingQueue(5);
    public static final ThreadPoolExecutor gW;
    public static final Map<String, Integer> gX = new HashMap();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 30, TimeUnit.SECONDS, gV);
        gW = threadPoolExecutor;
    }

    public static int aq(String str) {
        Integer num = gX.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
