package io.hansel.visualizer.e.a.j;

import io.hansel.visualizer.e.a.j.f.a;

public abstract class d extends g {
    public d(a aVar) {
        super(aVar);
    }

    public void g() {
        if (!f()) {
            throw new io.hansel.visualizer.e.a.h.d("Control frame cant have fin==false set");
        } else if (d()) {
            throw new io.hansel.visualizer.e.a.h.d("Control frame cant have rsv1==true set");
        } else if (b()) {
            throw new io.hansel.visualizer.e.a.h.d("Control frame cant have rsv2==true set");
        } else if (e()) {
            throw new io.hansel.visualizer.e.a.h.d("Control frame cant have rsv3==true set");
        }
    }
}
