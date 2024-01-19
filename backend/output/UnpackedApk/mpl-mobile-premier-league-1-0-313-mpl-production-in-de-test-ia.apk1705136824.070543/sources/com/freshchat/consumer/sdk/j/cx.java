package com.freshchat.consumer.sdk.j;

import java.util.HashSet;
import java.util.Set;

public class cx {
    public static final Set<String> jT;

    static {
        HashSet hashSet = new HashSet();
        jT = hashSet;
        hashSet.add("Monday");
        jT.add("Tuesday");
        jT.add("Wednesday");
        jT.add("Thursday");
        jT.add("Friday");
        jT.add("Saturday");
        jT.add("Sunday");
    }

    public static Set<String> gA() {
        return jT;
    }
}
