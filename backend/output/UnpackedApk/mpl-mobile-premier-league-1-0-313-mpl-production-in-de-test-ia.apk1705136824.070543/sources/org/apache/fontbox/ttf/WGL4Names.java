package org.apache.fontbox.ttf;

import com.netcore.android.utility.f;
import com.paynimo.android.payment.util.Constant;
import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import com.userexperior.e.h;
import com.userexperior.utilities.k;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.encoding.Encoding;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import sfs2x.client.requests.CreateRoomRequest;
import sfs2x.client.requests.LoginRequest;
import sfs2x.client.requests.buddylist.GoOnlineRequest;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public final class WGL4Names {
    public static final String[] MAC_GLYPH_NAMES = {Encoding.NOTDEF, ".null", "nonmarkingreturn", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quotesingle", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", ChannelPipelineCoverage.ONE, "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", "A", "B", "C", "D", Constant.PAYMENT_METHOD_TYPE_EMI, PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, "G", StandardStructureTypes.H, "I", "J", "K", "L", "M", "N", PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, "P", "Q", "R", "S", "T", PDBorderStyleDictionary.STYLE_UNDERLINE, DefaultSFSDataSerializer.FIELD_VALUE_KEY, "W", "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "grave", "a", "b", "c", "d", "e", f.f1288a, "g", h.f3998a, "i", "j", k.f4287a, "l", "m", "n", GoOnlineRequest.KEY_ONLINE, "p", SetUserPositionRequest.KEY_PLUS_ITEM_LIST, "r", "s", "t", "u", "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "Adieresis", "Aring", "Ccedilla", "Eacute", "Ntilde", "Odieresis", "Udieresis", "aacute", "agrave", "acircumflex", "adieresis", "atilde", "aring", "ccedilla", "eacute", "egrave", "ecircumflex", "edieresis", "iacute", "igrave", "icircumflex", "idieresis", "ntilde", "oacute", "ograve", "ocircumflex", "odieresis", "otilde", "uacute", "ugrave", "ucircumflex", "udieresis", "dagger", "degree", "cent", "sterling", "section", "bullet", "paragraph", "germandbls", "registered", "copyright", "trademark", "acute", "dieresis", "notequal", "AE", "Oslash", "infinity", "plusminus", "lessequal", "greaterequal", "yen", CreateRoomRequest.KEY_MAXUSERS, "partialdiff", "summation", "product", LoginRequest.KEY_PRIVILEGE_ID, "integral", "ordfeminine", "ordmasculine", "Omega", "ae", "oslash", "questiondown", "exclamdown", "logicalnot", "radical", "florin", "approxequal", "Delta", "guillemotleft", "guillemotright", "ellipsis", "nonbreakingspace", "Agrave", "Atilde", "Otilde", "OE", "oe", "endash", "emdash", "quotedblleft", "quotedblright", "quoteleft", "quoteright", "divide", "lozenge", "ydieresis", "Ydieresis", "fraction", "currency", "guilsinglleft", "guilsinglright", "fi", "fl", "daggerdbl", "periodcentered", "quotesinglbase", "quotedblbase", "perthousand", "Acircumflex", "Ecircumflex", "Aacute", "Edieresis", "Egrave", "Iacute", "Icircumflex", "Idieresis", "Igrave", "Oacute", "Ocircumflex", "apple", "Ograve", "Uacute", "Ucircumflex", "Ugrave", "dotlessi", "circumflex", "tilde", "macron", "breve", "dotaccent", "ring", "cedilla", "hungarumlaut", "ogonek", "caron", "Lslash", "lslash", "Scaron", "scaron", "Zcaron", "zcaron", "brokenbar", "Eth", "eth", "Yacute", "yacute", "Thorn", "thorn", "minus", "multiply", "onesuperior", "twosuperior", "threesuperior", "onehalf", "onequarter", "threequarters", "franc", "Gbreve", "gbreve", "Idotaccent", "Scedilla", "scedilla", "Cacute", "cacute", "Ccaron", "ccaron", "dcroat"};
    public static final Map<String, Integer> MAC_GLYPH_NAMES_INDICES = new HashMap();
    public static final int NUMBER_OF_MAC_GLYPHS = 258;

    static {
        for (int i = 0; i < 258; i++) {
            MAC_GLYPH_NAMES_INDICES.put(MAC_GLYPH_NAMES[i], Integer.valueOf(i));
        }
    }
}
