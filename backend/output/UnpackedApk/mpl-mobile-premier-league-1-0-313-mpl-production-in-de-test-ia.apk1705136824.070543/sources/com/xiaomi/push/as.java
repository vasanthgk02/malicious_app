package com.xiaomi.push;

import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Date;

public class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ar f4418a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f267a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f268a;

    public as(ar arVar, String str, Throwable th) {
        this.f4418a = arVar;
        this.f267a = str;
        this.f268a = th;
    }

    public void run() {
        ar.a().add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{ar.a().format(new Date()), ar.a(this.f4418a), this.f267a}), this.f268a));
        if (ar.a().size() > 20000) {
            int size = (ar.a().size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    if (ar.a().size() > 0) {
                        ar.a().remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            ar.a().add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{ar.a().format(new Date()), ar.a(this.f4418a), GeneratedOutlineSupport.outline42("flush ", size, " lines logs.")}), null));
        }
        try {
            if (!i.d()) {
                ar.a(this.f4418a);
            } else {
                ar.a(this.f4418a);
            }
        } catch (Exception unused2) {
            ar.a(this.f4418a);
        }
    }
}
