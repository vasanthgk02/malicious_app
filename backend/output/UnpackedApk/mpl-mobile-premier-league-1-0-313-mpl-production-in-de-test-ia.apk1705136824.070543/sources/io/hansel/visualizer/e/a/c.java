package io.hansel.visualizer.e.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.visualizer.e.a.g.a;
import io.hansel.visualizer.e.a.j.f;
import io.hansel.visualizer.e.a.j.h;
import io.hansel.visualizer.e.a.k.e;
import io.hansel.visualizer.e.a.k.i;
import java.net.InetSocketAddress;

public abstract class c implements e {
    public i a(b bVar, a aVar, io.hansel.visualizer.e.a.k.a aVar2) {
        return new e();
    }

    public String a(b bVar) {
        InetSocketAddress a2 = bVar.a();
        if (a2 != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
            outline73.append(a2.getPort());
            outline73.append("\" /></cross-domain-policy>\u0000");
            return outline73.toString();
        }
        throw new io.hansel.visualizer.e.a.h.e("socket not bound");
    }

    public void a(b bVar, f fVar) {
        bVar.a(new io.hansel.visualizer.e.a.j.i((h) fVar));
    }

    public void a(b bVar, io.hansel.visualizer.e.a.k.a aVar) {
    }

    public void a(b bVar, io.hansel.visualizer.e.a.k.a aVar, io.hansel.visualizer.e.a.k.h hVar) {
    }

    public void c(b bVar, f fVar) {
    }
}
