package io.hansel.core.base.b;

import io.hansel.core.logger.HSLLogger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f5097a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5098b;

    public a(int[] iArr) {
        int i;
        if (iArr == null || iArr.length != 2) {
            HSLLogger.d("Error initialising element coordinates. Setting coordinates to (-1,-1)");
            i = -1;
            this.f5097a = -1;
        } else {
            this.f5097a = iArr[0];
            i = iArr[1];
        }
        this.f5098b = i;
    }

    public int a() {
        return this.f5097a;
    }

    public int b() {
        return this.f5098b;
    }
}
