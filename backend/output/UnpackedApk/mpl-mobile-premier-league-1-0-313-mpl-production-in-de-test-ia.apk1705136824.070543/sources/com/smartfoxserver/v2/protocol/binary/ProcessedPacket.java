package com.smartfoxserver.v2.protocol.binary;

public class ProcessedPacket {
    public byte[] data;
    public PacketReadState state;

    public ProcessedPacket(PacketReadState packetReadState, byte[] bArr) {
        this.state = packetReadState;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public PacketReadState getState() {
        return this.state;
    }
}
