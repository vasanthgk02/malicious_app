package sfs2x.client.bitswarm;

import com.smartfoxserver.v2.entities.data.ISFSObject;

public interface IMessage {
    ISFSObject getContent();

    int getId();

    long getPacketId();

    int getTargetController();

    boolean isEncrypted();

    boolean isUDP();

    void setContent(ISFSObject iSFSObject);

    void setEncrypted(boolean z);

    void setId(int i);

    void setPacketId(long j);

    void setTargetController(int i);

    void setUDP(boolean z);
}
