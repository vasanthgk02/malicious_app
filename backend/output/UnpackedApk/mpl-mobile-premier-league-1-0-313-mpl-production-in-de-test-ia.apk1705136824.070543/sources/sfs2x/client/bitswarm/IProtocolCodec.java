package sfs2x.client.bitswarm;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import sfs2x.client.util.ByteArray;

public interface IProtocolCodec {
    IOHandler getIOHandler();

    void onPacketRead(ISFSObject iSFSObject) throws SFSException;

    void onPacketRead(ByteArray byteArray) throws SFSException;

    void onPacketWrite(IMessage iMessage) throws SFSException;

    void setIOHandler(IOHandler iOHandler) throws SFSException;
}
