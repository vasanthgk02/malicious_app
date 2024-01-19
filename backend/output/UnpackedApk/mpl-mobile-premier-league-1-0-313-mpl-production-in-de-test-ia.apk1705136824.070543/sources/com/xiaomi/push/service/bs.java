package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.o.a;

public final class bs extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4924a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f899a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f900a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f4925b;

    public bs(int i, String str, Context context, String str2, Notification notification) {
        this.f4924a = i;
        this.f901a = str;
        this.f900a = context;
        this.f4925b = str2;
        this.f899a = notification;
    }

    public String a() {
        return br.b(this.f4924a, this.f901a);
    }

    @TargetApi(19)
    public void run() {
        br.c(this.f900a, this.f4925b, this.f4924a, this.f901a, this.f899a);
    }
}
