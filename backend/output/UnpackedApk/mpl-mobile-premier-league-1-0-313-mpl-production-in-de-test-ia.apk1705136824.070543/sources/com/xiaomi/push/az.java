package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.ag;
import java.util.Map;

public class az extends ba {

    /* renamed from: a  reason: collision with root package name */
    public int f4470a = 16777216;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f328a;

    /* renamed from: b  reason: collision with root package name */
    public int f4471b = 16777216;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f329b;

    /* renamed from: c  reason: collision with root package name */
    public int f4472c = 16777216;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f330c;

    public az(Context context, int i, String str) {
        super(context, i, str);
    }

    private Drawable a(int i, int i2, int i3, float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a2 = a(6.0f);
        remoteViews.setViewPadding(i, a2, 0, a2, 0);
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    public az a(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                b.a((String) "colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f329b = bitmap;
            }
        }
        return this;
    }

    public az a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f330c = charSequence;
            this.f328a = pendingIntent;
        }
        return this;
    }

    public az a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f4471b = Color.parseColor(str);
            } catch (Exception unused) {
                b.a((String) "parse colorful notification button bg color error");
            }
        }
        return this;
    }

    public String a() {
        return "notification_colorful";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m488a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        boolean z;
        RemoteViews a2;
        Drawable drawable;
        RemoteViews remoteViews2;
        if (b()) {
            super.a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a3 = a(resources, "icon", "id", packageName);
            if (this.f333a == null) {
                a(a3);
            } else {
                a().setImageViewBitmap(a3, this.f333a);
            }
            int a4 = a(resources, "title", "id", packageName);
            int a5 = a(resources, "content", "id", packageName);
            a().setTextViewText(a4, this.f335a);
            a().setTextViewText(a5, this.f340b);
            if (!TextUtils.isEmpty(this.f330c)) {
                int a6 = a(resources, "buttonContainer", "id", packageName);
                int a7 = a(resources, "button", "id", packageName);
                int a8 = a(resources, "buttonBg", "id", packageName);
                a().setViewVisibility(a6, 0);
                a().setTextViewText(a7, this.f330c);
                a().setOnClickPendingIntent(a6, this.f328a);
                if (this.f4471b != 16777216) {
                    int a9 = a(70.0f);
                    int a10 = a(29.0f);
                    a().setImageViewBitmap(a8, ag.a(a(this.f4471b, a9, a10, ((float) a10) / 2.0f)));
                    a().setTextColor(a7, a(this.f4471b) ? -1 : -16777216);
                }
            }
            int a11 = a(resources, "bg", "id", packageName);
            int a12 = a(resources, "container", "id", packageName);
            if (this.f4470a != 16777216) {
                if (f.a(a()) >= 10) {
                    remoteViews2 = a();
                    drawable = a(this.f4470a, 984, 192, 30.0f);
                } else {
                    remoteViews2 = a();
                    drawable = a(this.f4470a, 984, 192, 0.0f);
                }
                remoteViews2.setImageViewBitmap(a11, ag.a(drawable));
                a2 = a();
                z = a(this.f4470a);
            } else if (this.f329b != null) {
                if (f.a(a()) >= 10) {
                    remoteViews = a();
                    bitmap = a(this.f329b, 30.0f);
                } else {
                    remoteViews = a();
                    bitmap = this.f329b;
                }
                remoteViews.setImageViewBitmap(a11, bitmap);
                Map<String, String> map = this.f338a;
                if (map != null && this.f4472c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i = this.f4472c;
                z = i == 16777216 || !a(i);
                a2 = a();
            } else {
                if (VERSION.SDK_INT >= 24) {
                    a().setViewVisibility(a3, 8);
                    a().setViewVisibility(a11, 8);
                    try {
                        z.a((Object) this, (String) "setStyle", j.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        b.a((String) "load class DecoratedCustomViewStyle failed");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(a());
                return;
            }
            a(a2, a12, a4, a5, z);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("miui.customHeight", true);
            addExtras(bundle2);
            setCustomContentView(a());
            return;
        }
        b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m489a() {
        boolean z = false;
        if (!f.a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(resources, "icon", "id", packageName);
        int a3 = a(resources, "title", "id", packageName);
        int a4 = a(resources, "content", "id", packageName);
        if (!(a2 == 0 || a3 == 0 || a4 == 0)) {
            z = true;
        }
        return z;
    }

    public az b(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f4470a = Color.parseColor(str);
            } catch (Exception unused) {
                b.a((String) "parse colorful notification bg color error");
            }
        }
        return this;
    }

    public String b() {
        return "notification_colorful_copy";
    }

    public az c(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f4472c = Color.parseColor(str);
            } catch (Exception unused) {
                b.a((String) "parse colorful notification image text color error");
            }
        }
        return this;
    }
}
