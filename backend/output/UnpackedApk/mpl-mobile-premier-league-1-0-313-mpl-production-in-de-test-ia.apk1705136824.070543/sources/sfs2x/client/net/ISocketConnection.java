package sfs2x.client.net;

import java.net.SocketAddress;

public interface ISocketConnection {
    void connect(String str, int i);

    void disconnect();

    IConnectionEventHandler getEventHandler();

    int getId();

    SocketAddress getRemoteAddress();

    boolean isConnected();

    void setEventHandler(IConnectionEventHandler iConnectionEventHandler);

    void write(Object obj);
}
