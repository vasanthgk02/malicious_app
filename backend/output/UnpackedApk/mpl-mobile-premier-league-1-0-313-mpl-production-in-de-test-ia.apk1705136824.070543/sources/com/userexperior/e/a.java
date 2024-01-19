package com.userexperior.e;

import android.content.Intent;

public final class a extends y {

    /* renamed from: c  reason: collision with root package name */
    public Intent f3923c;

    public a() {
    }

    public a(m mVar) {
        super(mVar);
    }

    public final String getMessage() {
        return this.f3923c != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
