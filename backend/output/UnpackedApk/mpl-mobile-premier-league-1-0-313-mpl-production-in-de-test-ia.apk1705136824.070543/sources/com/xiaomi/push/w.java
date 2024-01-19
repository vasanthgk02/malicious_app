package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public int f4991a;

    /* renamed from: a  reason: collision with other field name */
    public String f950a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f951a = new HashMap();

    public String a() {
        return this.f950a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", new Object[]{Integer.valueOf(this.f4991a), this.f951a.toString(), this.f950a});
    }
}
