package org.apache.fontbox.cff;

import android.support.v4.media.session.MediaSessionCompat;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.fontbox.encoding.Encoding;
import org.jboss.netty.util.internal.jzlib.Deflate;
import sfs2x.client.entities.invitation.InvitationReply;
import sfs2x.client.requests.BaseRequest;

public final class CFFExpertSubsetCharset extends CFFCharset {
    public static final CFFExpertSubsetCharset INSTANCE;

    static {
        CFFExpertSubsetCharset cFFExpertSubsetCharset = new CFFExpertSubsetCharset();
        INSTANCE = cFFExpertSubsetCharset;
        cFFExpertSubsetCharset.addSID(0, 0, Encoding.NOTDEF);
        INSTANCE.addSID(1, 1, "space");
        INSTANCE.addSID(2, 231, "dollaroldstyle");
        INSTANCE.addSID(3, 232, "dollarsuperior");
        INSTANCE.addSID(4, FTPReply.SECURITY_DATA_EXCHANGE_SUCCESSFULLY, "parenleftsuperior");
        INSTANCE.addSID(5, 236, "parenrightsuperior");
        INSTANCE.addSID(6, 237, "twodotenleader");
        INSTANCE.addSID(7, 238, "onedotenleader");
        INSTANCE.addSID(8, 13, "comma");
        INSTANCE.addSID(9, 14, "hyphen");
        INSTANCE.addSID(10, 15, "period");
        INSTANCE.addSID(11, 99, "fraction");
        INSTANCE.addSID(12, 239, "zerooldstyle");
        INSTANCE.addSID(13, 240, "oneoldstyle");
        INSTANCE.addSID(14, 241, "twooldstyle");
        INSTANCE.addSID(15, 242, "threeoldstyle");
        INSTANCE.addSID(16, 243, "fouroldstyle");
        INSTANCE.addSID(17, 244, "fiveoldstyle");
        INSTANCE.addSID(18, 245, "sixoldstyle");
        INSTANCE.addSID(19, 246, "sevenoldstyle");
        INSTANCE.addSID(20, 247, "eightoldstyle");
        INSTANCE.addSID(21, 248, "nineoldstyle");
        INSTANCE.addSID(22, 27, "colon");
        INSTANCE.addSID(23, 28, "semicolon");
        INSTANCE.addSID(24, 249, "commasuperior");
        INSTANCE.addSID(25, 250, "threequartersemdash");
        INSTANCE.addSID(26, 251, "periodsuperior");
        INSTANCE.addSID(27, 253, "asuperior");
        INSTANCE.addSID(28, 254, "bsuperior");
        INSTANCE.addSID(29, InvitationReply.EXPIRED, "centsuperior");
        INSTANCE.addSID(30, 256, "dsuperior");
        INSTANCE.addSID(31, FTPReply.PATHNAME_CREATED, "esuperior");
        INSTANCE.addSID(32, 258, "isuperior");
        INSTANCE.addSID(33, 259, "lsuperior");
        INSTANCE.addSID(34, 260, "msuperior");
        INSTANCE.addSID(35, 261, "nsuperior");
        INSTANCE.addSID(36, Deflate.MIN_LOOKAHEAD, "osuperior");
        INSTANCE.addSID(37, 263, "rsuperior");
        INSTANCE.addSID(38, 264, "ssuperior");
        INSTANCE.addSID(39, 265, "tsuperior");
        INSTANCE.addSID(40, 266, "ff");
        INSTANCE.addSID(41, 109, "fi");
        INSTANCE.addSID(42, 110, "fl");
        INSTANCE.addSID(43, 267, "ffi");
        INSTANCE.addSID(44, 268, "ffl");
        INSTANCE.addSID(45, 269, "parenleftinferior");
        INSTANCE.addSID(46, 270, "parenrightinferior");
        INSTANCE.addSID(47, 272, "hyphensuperior");
        INSTANCE.addSID(48, 300, "colonmonetary");
        INSTANCE.addSID(49, BaseRequest.InvitationReply, "onefitted");
        INSTANCE.addSID(50, BaseRequest.CreateSFSGame, "rupiah");
        INSTANCE.addSID(51, 305, "centoldstyle");
        INSTANCE.addSID(52, 314, "figuredash");
        INSTANCE.addSID(53, 315, "hypheninferior");
        INSTANCE.addSID(54, 158, "onequarter");
        INSTANCE.addSID(55, 155, "onehalf");
        INSTANCE.addSID(56, 163, "threequarters");
        INSTANCE.addSID(57, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, "oneeighth");
        INSTANCE.addSID(58, 321, "threeeighths");
        INSTANCE.addSID(59, 322, "fiveeighths");
        INSTANCE.addSID(60, 323, "seveneighths");
        INSTANCE.addSID(61, 324, "onethird");
        INSTANCE.addSID(62, 325, "twothirds");
        INSTANCE.addSID(63, 326, "zerosuperior");
        INSTANCE.addSID(64, FTPReply.FILE_STATUS_OK, "onesuperior");
        INSTANCE.addSID(65, 164, "twosuperior");
        INSTANCE.addSID(66, 169, "threesuperior");
        INSTANCE.addSID(67, 327, "foursuperior");
        INSTANCE.addSID(68, 328, "fivesuperior");
        INSTANCE.addSID(69, 329, "sixsuperior");
        INSTANCE.addSID(70, 330, "sevensuperior");
        INSTANCE.addSID(71, FTPReply.NEED_PASSWORD, "eightsuperior");
        INSTANCE.addSID(72, FTPReply.NEED_ACCOUNT, "ninesuperior");
        INSTANCE.addSID(73, 333, "zeroinferior");
        INSTANCE.addSID(74, FTPReply.SECURITY_MECHANISM_IS_OK, "oneinferior");
        INSTANCE.addSID(75, FTPReply.SECURITY_DATA_IS_ACCEPTABLE, "twoinferior");
        INSTANCE.addSID(76, 336, "threeinferior");
        INSTANCE.addSID(77, 337, "fourinferior");
        INSTANCE.addSID(78, 338, "fiveinferior");
        INSTANCE.addSID(79, 339, "sixinferior");
        INSTANCE.addSID(80, 340, "seveninferior");
        INSTANCE.addSID(81, 341, "eightinferior");
        INSTANCE.addSID(82, 342, "nineinferior");
        INSTANCE.addSID(83, 343, "centinferior");
        INSTANCE.addSID(84, 344, "dollarinferior");
        INSTANCE.addSID(85, 345, "periodinferior");
        INSTANCE.addSID(86, 346, "commainferior");
    }

    public CFFExpertSubsetCharset() {
        super(false);
    }

    public static CFFExpertSubsetCharset getInstance() {
        return INSTANCE;
    }
}
