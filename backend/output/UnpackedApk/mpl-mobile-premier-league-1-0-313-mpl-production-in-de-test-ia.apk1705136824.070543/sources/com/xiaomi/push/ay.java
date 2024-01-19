package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

@SuppressLint({"NewApi"})
public class ay extends Builder {

    /* renamed from: a  reason: collision with root package name */
    public Context f4469a;

    public ay(Context context) {
        super(context);
        this.f4469a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return 0;
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    public Context a() {
        return this.f4469a;
    }

    /* renamed from: a */
    public ay addExtras(Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    /* renamed from: a */
    public ay setCustomContentView(RemoteViews remoteViews) {
        if (VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ay m486a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                z.a((Object) this, (String) "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e2) {
                b.d("fail to set color. " + e2);
            }
        }
        return this;
    }

    public ay a(Map<String, String> map) {
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m487a() {
    }

    public Notification build() {
        a();
        return super.build();
    }
}
