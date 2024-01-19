package com.google.zxing.oned;

import org.jboss.netty.util.internal.jzlib.Deflate;
import sfs2x.client.requests.BaseRequest;

public final class Code39Reader extends OneDReader {
    public static final int ASTERISK_ENCODING;
    public static final int[] CHARACTER_ENCODINGS;

    static {
        int[] iArr = {52, 289, 97, 352, 49, BaseRequest.JoinRoomInvite, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, Deflate.MIN_LOOKAHEAD, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[39];
    }
}
