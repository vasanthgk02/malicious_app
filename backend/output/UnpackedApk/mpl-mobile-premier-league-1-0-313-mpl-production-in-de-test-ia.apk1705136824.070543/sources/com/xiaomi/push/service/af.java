package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.az.b.a;
import com.xiaomi.push.service.az.c;

public final class af implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4845a;

    public af(XMPushService xMPushService) {
        this.f4845a = xMPushService;
    }

    public void a(c cVar, c cVar2, int i) {
        if (cVar2 == c.binded) {
            u.a(this.f4845a);
            u.b(this.f4845a);
        } else if (cVar2 == c.unbind) {
            b.a((String) "onChange unbind");
            u.a(this.f4845a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
