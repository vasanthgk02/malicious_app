package io.hansel.visualizer.e.a;

import io.hansel.visualizer.e.a.j.f;
import java.net.InetSocketAddress;

public interface b {

    public enum a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* renamed from: io.hansel.visualizer.e.a.b$b  reason: collision with other inner class name */
    public enum C0091b {
        CLIENT,
        SERVER
    }

    InetSocketAddress a();

    void a(f fVar);
}
