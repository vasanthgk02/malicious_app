package sfs2x.client.bitswarm;

import com.smartfoxserver.v2.exceptions.SFSException;
import sfs2x.client.util.ByteArray;

public interface IOHandler {
    IProtocolCodec getCodec();

    void onDataRead(ByteArray byteArray) throws SFSException;

    void onDataWrite(IMessage iMessage) throws SFSException;
}
