package org.objectweb.asm;

public class Handler {

    /* renamed from: a  reason: collision with root package name */
    public Label f6220a;

    /* renamed from: b  reason: collision with root package name */
    public Label f6221b;

    /* renamed from: c  reason: collision with root package name */
    public Label f6222c;

    /* renamed from: d  reason: collision with root package name */
    public String f6223d;

    /* renamed from: e  reason: collision with root package name */
    public int f6224e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f6225f;

    public static Handler a(Handler handler, Label label, Label label2) {
        if (handler == null) {
            return null;
        }
        handler.f6225f = a(handler.f6225f, label, label2);
        int i = handler.f6220a.f6232c;
        int i2 = handler.f6221b.f6232c;
        int i3 = label.f6232c;
        int i4 = label2 == null ? Integer.MAX_VALUE : label2.f6232c;
        if (i3 < i2 && i4 > i) {
            if (i3 <= i) {
                if (i4 >= i2) {
                    handler = handler.f6225f;
                } else {
                    handler.f6220a = label2;
                }
            } else if (i4 >= i2) {
                handler.f6221b = label;
            } else {
                Handler handler2 = new Handler();
                handler2.f6220a = label2;
                handler2.f6221b = handler.f6221b;
                handler2.f6222c = handler.f6222c;
                handler2.f6223d = handler.f6223d;
                handler2.f6224e = handler.f6224e;
                handler2.f6225f = handler.f6225f;
                handler.f6221b = label;
                handler.f6225f = handler2;
            }
        }
        return handler;
    }
}
