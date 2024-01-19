package com.userexperior.services.recording;

import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.userexperior.UserExperior;
import com.userexperior.models.recording.c;
import com.userexperior.utilities.b;
import java.util.logging.Level;

public class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4252a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final ScreenShotService f4253b;

    public j(ScreenShotService screenShotService) {
        this.f4253b = screenShotService;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 45855) {
            Object obj = message.obj;
            String string = obj != null ? ((Bundle) obj).getString("user_device_id") : "";
            Editor edit = this.f4253b.getBaseContext().getSharedPreferences(UserExperior.TAG, 0).edit();
            edit.putString("userDeviceIdOnUEProcess", string.toString());
            edit.apply();
        } else if (i == 124249) {
            com.userexperior.utilities.j.a(this.f4253b.getBaseContext(), (long) message.arg1);
        } else if (i == 234567) {
            c cVar = new c((Bitmap) message.obj, message.arg1);
            ScreenShotService screenShotService = this.f4253b;
            if (!screenShotService.f4102a.isShutdown()) {
                try {
                    screenShotService.f4102a.execute(new h(cVar, screenShotService.getBaseContext()));
                } catch (Exception e2) {
                    Level level = Level.SEVERE;
                    b.a(level, "Ex : SSService - save() : " + e2.getMessage());
                    e2.getMessage();
                }
            }
        }
    }
}
