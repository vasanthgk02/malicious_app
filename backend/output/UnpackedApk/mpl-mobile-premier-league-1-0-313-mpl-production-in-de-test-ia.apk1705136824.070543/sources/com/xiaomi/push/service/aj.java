package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.h;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class aj {

    /* renamed from: a  reason: collision with root package name */
    public static long f4852a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f842a;

    /* renamed from: a  reason: collision with other field name */
    public static final Pattern f843a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());
        f842a = threadPoolExecutor;
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append("\n");
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        h.a((Closeable) bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                h.a((Closeable) bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                h.a((Closeable) bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
            h.a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            h.a((Closeable) bufferedReader);
            throw th;
        }
    }

    @Deprecated
    public static void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f842a.getActiveCount() <= 0 || currentTimeMillis - f4852a < DefaultRemoteConfig.SESSION_TIMEOUT_DURATION) {
        }
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("dump tcp for uid = ");
            outline73.append(Process.myUid());
            b.a(outline73.toString());
            b.a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a3)) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("dump tcp6 for uid = ");
            outline732.append(Process.myUid());
            b.a(outline732.toString());
            b.a(a3);
        }
    }
}
