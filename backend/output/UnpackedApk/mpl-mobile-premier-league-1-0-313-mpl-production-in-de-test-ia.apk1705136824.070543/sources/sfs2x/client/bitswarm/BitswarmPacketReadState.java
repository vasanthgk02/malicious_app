package sfs2x.client.bitswarm;

public class BitswarmPacketReadState {
    public static final int INVALID_DATA = 4;
    public static final int WAIT_DATA = 3;
    public static final int WAIT_DATA_SIZE = 1;
    public static final int WAIT_DATA_SIZE_FRAGMENT = 2;
    public static final int WAIT_NEW_PACKET = 0;
}
