package com.smartfoxserver.v2.protocol.binary;

public class PendingPacket {
    public Object buffer;
    public PacketHeader header;

    public PendingPacket(PacketHeader packetHeader) {
        this.header = packetHeader;
    }

    public Object getBuffer() {
        return this.buffer;
    }

    public PacketHeader getHeader() {
        return this.header;
    }

    public void setBuffer(Object obj) {
        this.buffer = obj;
    }

    public String toString() {
        return String.valueOf(this.header.toString()) + this.buffer.toString();
    }
}
