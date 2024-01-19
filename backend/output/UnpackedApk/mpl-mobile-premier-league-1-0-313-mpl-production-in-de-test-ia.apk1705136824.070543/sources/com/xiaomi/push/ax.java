package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

public class ax extends ba {

    /* renamed from: a  reason: collision with root package name */
    public int f4466a = 16777216;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f4467b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f4468c;

    public ax(Context context, String str) {
        super(context, str);
    }

    /* renamed from: a */
    public ax setLargeIcon(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                b.a((String) "colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.f4467b = bitmap;
            }
        }
        return this;
    }

    public ax a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f4466a = Color.parseColor(str);
            } catch (Exception unused) {
                b.a((String) "parse banner notification image text color error");
            }
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ba m483a(Bitmap bitmap) {
        return this;
    }

    public String a() {
        return "notification_banner";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m484a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        if (!b() || this.f4467b == null) {
            b();
            return;
        }
        super.a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(resources, "bg", "id", packageName);
        if (f.a(a()) >= 10) {
            remoteViews = a();
            bitmap = a(this.f4467b, 30.0f);
        } else {
            remoteViews = a();
            bitmap = this.f4467b;
        }
        remoteViews.setImageViewBitmap(a2, bitmap);
        int a3 = a(resources, "icon", "id", packageName);
        if (this.f4468c != null) {
            a().setImageViewBitmap(a3, this.f4468c);
        } else {
            a(a3);
        }
        int a4 = a(resources, "title", "id", packageName);
        a().setTextViewText(a4, this.f335a);
        Map<String, String> map = this.f338a;
        if (map != null && this.f4466a == 16777216) {
            a(map.get("notification_image_text_color"));
        }
        RemoteViews a5 = a();
        int i = this.f4466a;
        a5.setTextColor(a4, (i == 16777216 || !a(i)) ? -1 : -16777216);
        setCustomContentView(a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a() {
        boolean z = false;
        if (!f.a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(a().getResources(), "bg", "id", a().getPackageName());
        int a3 = a(resources, "icon", "id", packageName);
        int a4 = a(resources, "title", "id", packageName);
        if (!(a2 == 0 || a3 == 0 || a4 == 0 || f.a(a()) < 9)) {
            z = true;
        }
        return z;
    }

    public ax b(Bitmap bitmap) {
        if (b() && bitmap != null) {
            this.f4468c = bitmap;
        }
        return this;
    }

    public String b() {
        return null;
    }
}
