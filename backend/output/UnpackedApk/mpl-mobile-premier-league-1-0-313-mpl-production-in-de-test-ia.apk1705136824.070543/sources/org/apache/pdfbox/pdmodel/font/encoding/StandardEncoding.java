package org.apache.pdfbox.pdmodel.font.encoding;

import com.facebook.imagepipeline.common.RotationOptions;
import com.netcore.android.utility.f;
import com.paynimo.android.payment.util.Constant;
import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import com.userexperior.e.h;
import com.userexperior.utilities.k;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.buddylist.GoOnlineRequest;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public class StandardEncoding extends Encoding {
    public static final StandardEncoding INSTANCE = new StandardEncoding();

    public StandardEncoding() {
        add(65, "A");
        add(FTPReply.DATA_CONNECTION_OPEN, "AE");
        add(66, "B");
        add(67, "C");
        add(68, "D");
        add(69, Constant.PAYMENT_METHOD_TYPE_EMI);
        add(70, PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        add(71, "G");
        add(72, StandardStructureTypes.H);
        add(73, "I");
        add(74, "J");
        add(75, "K");
        add(76, "L");
        add(232, "Lslash");
        add(77, "M");
        add(78, "N");
        add(79, PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
        add(FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE, "OE");
        add(233, "Oslash");
        add(80, "P");
        add(81, "Q");
        add(82, "R");
        add(83, "S");
        add(84, "T");
        add(85, PDBorderStyleDictionary.STYLE_UNDERLINE);
        add(86, DefaultSFSDataSerializer.FIELD_VALUE_KEY);
        add(87, "W");
        add(88, "X");
        add(89, "Y");
        add(90, "Z");
        add(97, "a");
        add(194, "acute");
        add(241, "ae");
        add(38, "ampersand");
        add(94, "asciicircum");
        add(126, "asciitilde");
        add(42, "asterisk");
        add(64, "at");
        add(98, "b");
        add(92, "backslash");
        add(124, "bar");
        add(123, "braceleft");
        add(125, "braceright");
        add(91, "bracketleft");
        add(93, "bracketright");
        add(198, "breve");
        add(183, "bullet");
        add(99, "c");
        add(207, "caron");
        add(BaseRequest.RemoveBuddy, "cedilla");
        add(162, "cent");
        add(195, "circumflex");
        add(58, "colon");
        add(44, "comma");
        add(168, "currency");
        add(100, "d");
        add(178, "dagger");
        add(179, "daggerdbl");
        add(200, "dieresis");
        add(36, "dollar");
        add(199, "dotaccent");
        add(245, "dotlessi");
        add(101, "e");
        add(56, "eight");
        add(188, "ellipsis");
        add(208, "emdash");
        add(177, "endash");
        add(61, "equal");
        add(33, "exclam");
        add(161, "exclamdown");
        add(102, f.f1288a);
        add(174, "fi");
        add(53, "five");
        add(175, "fl");
        add(166, "florin");
        add(52, "four");
        add(164, "fraction");
        add(103, "g");
        add(251, "germandbls");
        add(193, "grave");
        add(62, "greater");
        add(171, "guillemotleft");
        add(187, "guillemotright");
        add(172, "guilsinglleft");
        add(173, "guilsinglright");
        add(104, h.f3998a);
        add(BaseRequest.GoOnline, "hungarumlaut");
        add(45, "hyphen");
        add(105, "i");
        add(106, "j");
        add(107, k.f4287a);
        add(108, "l");
        add(60, "less");
        add(248, "lslash");
        add(109, "m");
        add(197, "macron");
        add(110, "n");
        add(57, "nine");
        add(35, "numbersign");
        add(111, GoOnlineRequest.KEY_ONLINE);
        add(250, "oe");
        add(206, "ogonek");
        add(49, ChannelPipelineCoverage.ONE);
        add(FTPReply.ENTERING_PASSIVE_MODE, "ordfeminine");
        add(FTPReply.SECURITY_DATA_EXCHANGE_SUCCESSFULLY, "ordmasculine");
        add(249, "oslash");
        add(112, "p");
        add(182, "paragraph");
        add(40, "parenleft");
        add(41, "parenright");
        add(37, "percent");
        add(46, "period");
        add(RotationOptions.ROTATE_180, "periodcentered");
        add(189, "perthousand");
        add(43, "plus");
        add(113, SetUserPositionRequest.KEY_PLUS_ITEM_LIST);
        add(63, "question");
        add(191, "questiondown");
        add(34, "quotedbl");
        add(185, "quotedblbase");
        add(170, "quotedblleft");
        add(186, "quotedblright");
        add(96, "quoteleft");
        add(39, "quoteright");
        add(184, "quotesinglbase");
        add(169, "quotesingle");
        add(114, "r");
        add(202, "ring");
        add(115, "s");
        add(167, "section");
        add(59, "semicolon");
        add(55, "seven");
        add(54, "six");
        add(47, "slash");
        add(32, "space");
        add(163, "sterling");
        add(116, "t");
        add(51, "three");
        add(196, "tilde");
        add(50, "two");
        add(117, "u");
        add(95, "underscore");
        add(118, "v");
        add(119, "w");
        add(120, "x");
        add(121, "y");
        add(165, "yen");
        add(122, "z");
        add(48, "zero");
    }

    public COSBase getCOSObject() {
        return COSName.STANDARD_ENCODING;
    }
}