package io.hansel.core.base.push;

import android.content.Context;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.base.task.b;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;

public class c extends b {
    public c(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler) {
        super(context, hSLSDKIdentifiers, hSLTaskHandler);
    }

    private void f() {
        d().schedule(new a(b(), c()));
    }

    public void a() {
        f();
    }
}
