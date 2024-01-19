package sfs2x.client.core.sockets;

import sfs2x.client.core.IDispatchable;

public interface ISocketLayer extends IDispatchable {
    void connect(String str, int i);

    void disconnect();

    void disconnect(String str);

    boolean isConnected();

    void kill();

    boolean requiresConnection();

    void write(byte[] bArr);
}
