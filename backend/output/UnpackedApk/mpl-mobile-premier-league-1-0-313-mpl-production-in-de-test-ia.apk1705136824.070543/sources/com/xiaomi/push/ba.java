package com.xiaomi.push;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.CarExtender;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.ar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class ba extends ay {

    /* renamed from: a  reason: collision with root package name */
    public int f4479a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f333a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f334a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f335a;

    /* renamed from: a  reason: collision with other field name */
    public String f336a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Action> f337a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f338a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f339a;

    /* renamed from: b  reason: collision with root package name */
    public int f4480b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f340b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f341b;

    public ba(Context context, int i, String str) {
        super(context);
        this.f337a = new ArrayList<>();
        this.f4480b = 0;
        this.f336a = str;
        this.f4479a = i;
        c();
    }

    public ba(Context context, String str) {
        this(context, 0, str);
    }

    private Bitmap a() {
        return ag.a(a.a(a(), this.f336a));
    }

    private String c() {
        boolean e2 = e();
        this.f341b = e2;
        return e2 ? b() : a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m503c() {
        int a2 = a(a().getResources(), c(), "layout", a().getPackageName());
        if (a2 != 0) {
            this.f334a = new RemoteViews(a().getPackageName(), a2);
            this.f339a = a();
            return;
        }
        b.a((String) "create RemoteViews failed, no such layout resource was found");
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m504c() {
        Map<String, String> map = this.f338a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f335a);
        super.setContentText(this.f340b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m505d() {
        return !TextUtils.isEmpty(b()) && !TextUtils.isEmpty(this.f336a);
    }

    private boolean e() {
        return d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> b2 = aq.a(a(), this.f336a).b();
        if (b2 != null && !b2.isEmpty()) {
            for (StatusBarNotification statusBarNotification : b2) {
                if (statusBarNotification.getId() == this.f4479a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    public int a(float f2) {
        return (int) ((f2 * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final RemoteViews m506a() {
        return this.f334a;
    }

    public ay a(Map<String, String> map) {
        this.f338a = map;
        return this;
    }

    /* renamed from: a */
    public ba addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Action(i, charSequence, pendingIntent));
        return this;
    }

    /* renamed from: a */
    public ba addAction(Action action) {
        if (action != null) {
            this.f337a.add(action);
        }
        int i = this.f4480b;
        this.f4480b = i + 1;
        a(i, action);
        return this;
    }

    /* renamed from: a */
    public ba setLargeIcon(Bitmap bitmap) {
        this.f333a = bitmap;
        return this;
    }

    /* renamed from: a */
    public ba setContentTitle(CharSequence charSequence) {
        this.f335a = charSequence;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m507a();

    /* renamed from: a  reason: collision with other method in class */
    public void m508a() {
        super.a();
        Bundle bundle = new Bundle();
        if (d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f341b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a((String) CarExtender.EXTRA_LARGE_ICON));
        if (this.f337a.size() > 0) {
            Action[] actionArr = new Action[this.f337a.size()];
            this.f337a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (c() || !ar.a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f335a);
            bundle.putCharSequence("mipush.customContent", this.f340b);
        }
        addExtras(bundle);
    }

    public void a(int i) {
        Bitmap a2 = a();
        if (a2 != null) {
            a().setImageViewBitmap(i, a2);
            return;
        }
        int b2 = a.b(a(), this.f336a);
        if (b2 != 0) {
            a().setImageViewResource(i, b2);
        }
    }

    public void a(int i, Action action) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m509a();

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m510a(int i) {
        return (((double) Color.blue(i)) * 0.114d) + ((((double) Color.green(i)) * 0.587d) + (((double) Color.red(i)) * 0.299d)) < 192.0d;
    }

    /* renamed from: b */
    public ba setContentText(CharSequence charSequence) {
        this.f340b = charSequence;
        return this;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public final void m511b() {
        super.setContentTitle(this.f335a);
        super.setContentText(this.f340b);
        Bitmap bitmap = this.f333a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m512b() {
        return this.f339a;
    }
}
