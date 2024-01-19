package com.userexperior.utilities;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.logging.Level;

public final class h extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<f> f4280a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f4281b;

    public h(f fVar, f fVar2) {
        this.f4281b = fVar;
        this.f4280a = new WeakReference<>(fVar2);
        f.g = false;
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        StringBuilder sb;
        Level level;
        String str2;
        try {
            PendingResult goAsync = goAsync();
            String str3 = null;
            if (intent != null) {
                str3 = intent.getAction();
                str2 = intent.getStringExtra("reason");
            } else {
                str2 = null;
            }
            new g((f) this.f4280a.get(), this.f4281b.f4273e, goAsync).execute(new String[]{str3, str2});
        } catch (Exception e2) {
            level = Level.INFO;
            sb = new StringBuilder("issue at hd: ");
            str = e2.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        } catch (InternalError e3) {
            level = Level.INFO;
            sb = new StringBuilder("issue at hd: ");
            str = e3.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        } catch (OutOfMemoryError e4) {
            level = Level.INFO;
            sb = new StringBuilder("issue at hd: ");
            str = e4.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        }
    }
}
