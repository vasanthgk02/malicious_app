package sfs2x.client.core.sockets;

import java.util.Timer;
import java.util.TimerTask;
import org.jboss.netty.bootstrap.ClientBootstrap;

public final class NettyTerminator extends TimerTask {
    public ClientBootstrap cb;
    public final Timer timer;

    public NettyTerminator(ClientBootstrap clientBootstrap) {
        this.cb = clientBootstrap;
        Timer timer2 = new Timer(false);
        this.timer = timer2;
        timer2.schedule(this, 2500);
    }

    public void run() {
        this.cb.releaseExternalResources();
        this.timer.cancel();
    }
}
