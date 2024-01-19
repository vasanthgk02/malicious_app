package sfs2x.client.bitswarm;

import com.smartfoxserver.v2.exceptions.SFSException;
import sfs2x.client.SmartFox;
import sfs2x.client.util.ByteArray;

public interface IUDPManager {
    void disconnect();

    long getNextUdpPacketId();

    void initialize(String str, int i) throws SFSException;

    boolean isInited();

    void reset();

    void send(ByteArray byteArray);

    void setSfs(SmartFox smartFox);
}
