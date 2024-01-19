package io.hansel.core.d;

import io.hansel.core.module.IMessageBroker;
import io.hansel.core.module.b;
import io.hansel.core.security.ICrypto;

public class a implements IMessageBroker, ICrypto {

    /* renamed from: a  reason: collision with root package name */
    public final b f5161a = new b();

    public String aesDecrypt(String str) {
        return io.hansel.core.security.b.a("AES/GCM/NoPadding").a().b(str);
    }

    public String aesEncrypt(String str) {
        return io.hansel.core.security.b.a("AES/GCM/NoPadding").a().a(str);
    }

    public void enqueue(Runnable runnable) {
        this.f5161a.a(runnable);
    }

    public void publishBlockingEvent(String str, Object obj) {
        this.f5161a.a(str, obj);
    }

    public void publishEvent(String str, Object obj) {
        this.f5161a.c(str, obj);
    }

    public Object returnEventData(String str, Object obj) {
        return this.f5161a.b(str, obj);
    }

    public void setSubscriber(String str, io.hansel.core.module.a aVar) {
        this.f5161a.a(str, aVar);
    }
}
