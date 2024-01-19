package com.userexperior.services.recording;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager.LayoutParams;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final View f4135a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f4136b;

    /* renamed from: c  reason: collision with root package name */
    public final LayoutParams f4137c;

    public e(View view, Rect rect, LayoutParams layoutParams) {
        this.f4135a = view;
        this.f4136b = rect;
        this.f4137c = layoutParams;
    }

    public final boolean a() {
        return this.f4137c.type == 2;
    }
}
