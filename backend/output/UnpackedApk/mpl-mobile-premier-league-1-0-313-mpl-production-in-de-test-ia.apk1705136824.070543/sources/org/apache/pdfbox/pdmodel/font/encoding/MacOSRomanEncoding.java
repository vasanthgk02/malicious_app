package org.apache.pdfbox.pdmodel.font.encoding;

import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import org.apache.pdfbox.cos.COSBase;
import org.jboss.netty.util.internal.jzlib.Deflate;
import sfs2x.client.entities.invitation.InvitationReply;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.LoginRequest;

public class MacOSRomanEncoding extends MacRomanEncoding {
    public static final MacOSRomanEncoding INSTANCE = new MacOSRomanEncoding();

    public MacOSRomanEncoding() {
        add(InvitationReply.EXPIRED, "notequal");
        add(260, "infinity");
        add(Deflate.MIN_LOOKAHEAD, "lessequal");
        add(263, "greaterequal");
        add(266, "partialdiff");
        add(267, "summation");
        add(270, "product");
        add(271, LoginRequest.KEY_PRIVILEGE_ID);
        add(272, "integral");
        add(275, "Omega");
        add(BaseRequest.QuickJoinGame, "radical");
        add(305, "approxequal");
        add(306, "Delta");
        add(327, "lozenge");
        add(333, "Euro");
        add(JpegTranscoderUtils.FULL_ROUND, "apple");
    }

    public COSBase getCOSObject() {
        return null;
    }
}
