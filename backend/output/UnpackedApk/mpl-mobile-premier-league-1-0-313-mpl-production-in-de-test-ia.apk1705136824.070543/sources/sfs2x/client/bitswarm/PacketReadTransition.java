package sfs2x.client.bitswarm;

public class PacketReadTransition {
    public static final int HeaderReceived = 0;
    public static final int IncompleteSize = 2;
    public static final int InvalidData = 5;
    public static final int InvalidDataFinished = 6;
    public static final int PacketFinished = 4;
    public static final int SizeReceived = 1;
    public static final int WholeSizeReceived = 3;
}
