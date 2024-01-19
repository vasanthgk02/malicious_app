package com.google.zxing.oned;

import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import org.apache.commons.net.ftp.FTPReply;
import sfs2x.client.requests.BaseRequest;

public final class Code93Reader extends OneDReader {
    public static final int[] CHARACTER_ENCODINGS;

    static {
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, JpegTranscoderUtils.FULL_ROUND, 356, 354, 308, 282, 344, FTPReply.NEED_ACCOUNT, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, BaseRequest.CreateSFSGame, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, FTPReply.FILE_ACTION_PENDING};
        CHARACTER_ENCODINGS = iArr;
        int i = iArr[47];
    }
}
