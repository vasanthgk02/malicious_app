package com.userexperior.d.a;

public final class c extends Throwable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3901a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public c(b bVar, c cVar) {
        // this.f3901a = bVar;
        super(bVar.f3899a, cVar);
    }

    public /* synthetic */ c(b bVar, c cVar, byte b2) {
        this(bVar, cVar);
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(this.f3901a.f3900b);
        return this;
    }
}
