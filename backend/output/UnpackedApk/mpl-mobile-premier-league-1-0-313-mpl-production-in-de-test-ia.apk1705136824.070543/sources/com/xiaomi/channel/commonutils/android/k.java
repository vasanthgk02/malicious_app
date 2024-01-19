package com.xiaomi.channel.commonutils.android;

import android.text.TextUtils;
import java.util.Collection;

public class k {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4316a;

        /* renamed from: a  reason: collision with other field name */
        public final StringBuilder f178a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4317b;

        public a() {
            this(":", ",");
        }

        public a(String str, String str2) {
            this.f178a = new StringBuilder();
            this.f4316a = str;
            this.f4317b = str2;
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f178a.length() > 0) {
                    this.f178a.append(this.f4317b);
                }
                StringBuilder sb = this.f178a;
                sb.append(str);
                sb.append(this.f4316a);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f178a.toString();
        }
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int b(String str, int i) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i : i;
    }
}
