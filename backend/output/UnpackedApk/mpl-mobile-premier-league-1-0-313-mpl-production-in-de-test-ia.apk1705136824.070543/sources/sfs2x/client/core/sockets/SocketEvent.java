package sfs2x.client.core.sockets;

import sfs2x.client.core.BaseEvent;

public class SocketEvent extends BaseEvent {
    public static final String OnConnect = "OnConnect";
    public static final String OnData = "OnData";
    public static final String OnDisconnect = "OnDisconnect";
    public static final String OnError = "OnError";

    public SocketEvent(String str) {
        super(str);
    }
}
