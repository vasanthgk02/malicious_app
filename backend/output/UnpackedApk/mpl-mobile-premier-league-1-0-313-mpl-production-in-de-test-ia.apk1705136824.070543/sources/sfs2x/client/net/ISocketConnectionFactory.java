package sfs2x.client.net;

public interface ISocketConnectionFactory {
    ISocketConnection newConnection();

    void releaseResources();
}
