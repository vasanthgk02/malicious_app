package sfs2x.client.net;

public interface IConnectionEventHandler {
    void onConnect(Exception exc);

    void onData(Object obj);

    void onDisconnect();

    void onError(Throwable th);
}
