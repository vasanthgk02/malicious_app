package io.hansel.core.base.task;

import android.content.Context;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;

public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f5115a;

    /* renamed from: b  reason: collision with root package name */
    public HSLSDKIdentifiers f5116b;

    /* renamed from: c  reason: collision with root package name */
    public HSLTaskHandler f5117c;

    public b(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler) {
        this.f5115a = context;
        this.f5116b = hSLSDKIdentifiers;
        this.f5117c = hSLTaskHandler;
    }

    public abstract void a();

    public Context b() {
        return this.f5115a;
    }

    public HSLSDKIdentifiers c() {
        return this.f5116b;
    }

    public HSLTaskHandler d() {
        if (this.f5117c == null) {
            this.f5117c = new HSLTaskHandler();
        }
        return this.f5117c;
    }

    public final void e() {
        d().schedule(this);
    }

    public void run() {
        try {
            a();
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
    }
}
