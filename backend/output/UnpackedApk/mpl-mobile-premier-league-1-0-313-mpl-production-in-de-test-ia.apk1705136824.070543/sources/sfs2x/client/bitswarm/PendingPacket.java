package sfs2x.client.bitswarm;

import com.smartfoxserver.v2.protocol.binary.PacketHeader;
import sfs2x.client.util.ByteArray;

public class PendingPacket {
    public ByteArray buffer;
    public PacketHeader header;

    public PendingPacket(PacketHeader packetHeader) {
        this.header = packetHeader;
        ByteArray byteArray = new ByteArray();
        this.buffer = byteArray;
        byteArray.setCompressed(packetHeader.isCompressed());
    }

    public ByteArray getBuffer() {
        return this.buffer;
    }

    public PacketHeader getHeader() {
        return this.header;
    }

    public void setBuffer(ByteArray byteArray) {
        this.buffer = byteArray;
    }
}
