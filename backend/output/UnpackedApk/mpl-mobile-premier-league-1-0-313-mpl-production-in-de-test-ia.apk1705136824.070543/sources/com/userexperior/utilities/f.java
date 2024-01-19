package com.userexperior.utilities;

import android.content.Context;
import android.content.IntentFilter;
import com.userexperior.interfaces.recording.c;

public final class f {
    public static boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final String f4269a = "reason";

    /* renamed from: b  reason: collision with root package name */
    public final String f4270b = "globalactions";

    /* renamed from: c  reason: collision with root package name */
    public Context f4271c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f4272d;

    /* renamed from: e  reason: collision with root package name */
    public c f4273e;

    /* renamed from: f  reason: collision with root package name */
    public h f4274f;

    public f(Context context) {
        this.f4271c = context;
        this.f4272d = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    }

    public static /* synthetic */ void a(f fVar) {
        h hVar = fVar.f4274f;
        if (hVar != null) {
            fVar.f4271c.unregisterReceiver(hVar);
        }
        fVar.f4274f = null;
    }

    public final void a() {
        this.f4273e = null;
        this.f4274f = null;
    }
}
