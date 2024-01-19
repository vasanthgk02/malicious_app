package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4367a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ c f225a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f226a;

    public h(String str, Context context, c cVar) {
        this.f226a = str;
        this.f4367a = context;
        this.f225a = cVar;
    }

    public void run() {
        String str;
        if (!TextUtils.isEmpty(this.f226a)) {
            String[] split = this.f226a.split(Constants.WAVE_SEPARATOR);
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = "";
                    break;
                }
                String str2 = split[i];
                if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                    str = str2.substring(str2.indexOf(":") + 1);
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                b.a((String) "ASSEMBLE_PUSH : receive correct token");
                g.d(this.f4367a, this.f225a, str);
                g.a(this.f4367a);
                return;
            }
            b.a((String) "ASSEMBLE_PUSH : receive incorrect token");
        }
    }
}
