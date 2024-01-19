package io.hansel.userjourney.prompts;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public int f5557a;

    /* renamed from: b  reason: collision with root package name */
    public int f5558b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5559c;

    /* renamed from: d  reason: collision with root package name */
    public int f5560d;

    /* renamed from: e  reason: collision with root package name */
    public int f5561e;

    public static ViewGroup b(Activity activity) {
        return (ViewGroup) ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0);
    }

    public int a() {
        return this.f5558b;
    }

    public int a(Activity activity) {
        return ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public int b() {
        return this.f5557a;
    }

    public int c() {
        return this.f5561e;
    }

    public j0 c(Activity activity) {
        ViewGroup b2 = b(activity);
        int width = b2.getWidth();
        int height = b2.getHeight();
        int a2 = a(activity);
        this.f5557a = width;
        this.f5558b = height;
        this.f5559c = true;
        if (a2 == 1 || a2 == 3) {
            this.f5559c = false;
        }
        View decorView = activity.getWindow().getDecorView();
        this.f5560d = decorView.getWidth();
        int height2 = decorView.getHeight();
        this.f5561e = height2;
        if (this.f5560d == 0 || height2 == 0) {
            decorView.measure(0, 0);
            if (this.f5560d == 0) {
                this.f5560d = decorView.getMeasuredWidth();
            }
            if (this.f5561e == 0) {
                this.f5561e = decorView.getMeasuredHeight();
            }
        }
        return this;
    }

    public int d() {
        return this.f5560d;
    }

    public boolean e() {
        return this.f5559c;
    }
}
