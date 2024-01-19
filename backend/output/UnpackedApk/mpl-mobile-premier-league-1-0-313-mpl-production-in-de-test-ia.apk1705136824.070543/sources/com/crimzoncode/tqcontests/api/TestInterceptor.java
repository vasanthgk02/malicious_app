package com.crimzoncode.tqcontests.api;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/crimzoncode/tqcontests/api/TestInterceptor;", "Lokhttp3/Interceptor;", "auth", "", "(Ljava/lang/String;)V", "getAuth", "()Ljava/lang/String;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TestInterceptor.kt */
public final class TestInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    public final String auth;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/crimzoncode/tqcontests/api/TestInterceptor$Companion;", "", "()V", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: TestInterceptor.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TestInterceptor(String str) {
        Intrinsics.checkParameterIsNotNull(str, "auth");
        this.auth = str;
    }

    public final String getAuth() {
        return this.auth;
    }

    public Response intercept(Chain chain) throws IOException {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        return chain.proceed(chain.request().newBuilder().addHeader("authorization", this.auth).build());
    }
}
