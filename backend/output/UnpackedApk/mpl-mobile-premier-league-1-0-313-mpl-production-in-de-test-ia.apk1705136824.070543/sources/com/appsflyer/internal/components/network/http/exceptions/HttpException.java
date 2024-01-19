package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.bk;
import java.io.IOException;

public class HttpException extends IOException {
    public final bk valueOf;

    public HttpException(Throwable th, bk bkVar) {
        super(th.getMessage(), th);
        this.valueOf = bkVar;
    }

    public bk getMetrics() {
        return this.valueOf;
    }
}
