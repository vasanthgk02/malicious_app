package com.userexperior.models.recording;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public View f4090a;

    /* renamed from: b  reason: collision with root package name */
    public int f4091b;

    /* renamed from: c  reason: collision with root package name */
    public int f4092c;

    /* renamed from: d  reason: collision with root package name */
    public int f4093d;

    /* renamed from: e  reason: collision with root package name */
    public float f4094e;

    /* renamed from: f  reason: collision with root package name */
    public final Options f4095f;

    public g(View view, Bitmap bitmap, int i, int i2, int i3, float f2) {
        Options options = new Options();
        this.f4095f = options;
        this.f4090a = view;
        options.inBitmap = bitmap;
        this.f4091b = i;
        this.f4092c = i2;
        this.f4093d = i3;
        this.f4094e = f2;
    }
}
