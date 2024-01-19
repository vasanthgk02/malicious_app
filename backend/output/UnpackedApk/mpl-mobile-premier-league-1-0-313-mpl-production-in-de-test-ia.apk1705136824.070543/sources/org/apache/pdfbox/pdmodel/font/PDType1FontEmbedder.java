package org.apache.pdfbox.pdmodel.font;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.fontbox.afm.AFMParser;
import org.apache.fontbox.afm.CharMetric;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.pfb.PfbParser;
import org.apache.fontbox.type1.Type1Font;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.encoding.DictionaryEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import sfs2x.client.entities.invitation.InvitationReply;

public class PDType1FontEmbedder {
    public final Encoding fontEncoding;
    public final FontMetrics metrics;
    public final Type1Font type1;

    public PDType1FontEmbedder(PDDocument pDDocument, COSDictionary cOSDictionary, InputStream inputStream, InputStream inputStream2) throws IOException {
        cOSDictionary.setItem(COSName.SUBTYPE, (COSBase) COSName.TYPE1);
        FontMetrics parse = new AFMParser(inputStream).parse();
        this.metrics = parse;
        this.fontEncoding = encodingFromAFM(parse);
        PDFontDescriptor buildFontDescriptor = buildFontDescriptor(this.metrics);
        byte[] byteArray = IOUtils.toByteArray(inputStream2);
        PfbParser pfbParser = new PfbParser((InputStream) new ByteArrayInputStream(byteArray));
        this.type1 = Type1Font.createWithPFB((InputStream) new ByteArrayInputStream(byteArray));
        PDStream pDStream = new PDStream(pDDocument, pfbParser.getInputStream(), false);
        pDStream.getStream().setInt((String) "Length", pfbParser.size());
        int i = 0;
        while (i < pfbParser.getLengths().length) {
            COSStream stream = pDStream.getStream();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Length");
            int i2 = i + 1;
            outline73.append(i2);
            stream.setInt(outline73.toString(), pfbParser.getLengths()[i]);
            i = i2;
        }
        pDStream.addCompression();
        buildFontDescriptor.setFontFile(pDStream);
        cOSDictionary.setItem(COSName.FONT_DESC, (COSObjectable) buildFontDescriptor);
        cOSDictionary.setName(COSName.BASE_FONT, this.metrics.getFontName());
        List<CharMetric> charMetrics = this.metrics.getCharMetrics();
        getFontEncoding();
        ArrayList arrayList = new ArrayList(256);
        for (int i3 = 0; i3 < 256; i3++) {
            arrayList.add(Integer.valueOf(250));
        }
        int i4 = InvitationReply.EXPIRED;
        int i5 = 0;
        for (CharMetric next : charMetrics) {
            int characterCode = next.getCharacterCode();
            if (characterCode > 0) {
                i4 = Math.min(i4, characterCode);
                i5 = Math.max(i5, characterCode);
                if (next.getWx() > 0.0f) {
                    arrayList.set(characterCode, Integer.valueOf(Math.round(next.getWx())));
                }
            }
        }
        cOSDictionary.setInt(COSName.FIRST_CHAR, 0);
        cOSDictionary.setInt(COSName.LAST_CHAR, (int) InvitationReply.EXPIRED);
        cOSDictionary.setItem(COSName.WIDTHS, (COSBase) COSArrayList.converterToCOSArray(arrayList));
    }

    public static PDFontDescriptor buildFontDescriptor(FontMetrics fontMetrics) {
        boolean equals = fontMetrics.getEncodingScheme().equals("FontSpecific");
        PDFontDescriptor pDFontDescriptor = new PDFontDescriptor();
        pDFontDescriptor.setFontName(fontMetrics.getFontName());
        pDFontDescriptor.setFontFamily(fontMetrics.getFamilyName());
        pDFontDescriptor.setNonSymbolic(!equals);
        pDFontDescriptor.setSymbolic(equals);
        pDFontDescriptor.setFontBoundingBox(new PDRectangle(fontMetrics.getFontBBox()));
        pDFontDescriptor.setItalicAngle(fontMetrics.getItalicAngle());
        pDFontDescriptor.setAscent(fontMetrics.getAscender());
        pDFontDescriptor.setDescent(fontMetrics.getDescender());
        pDFontDescriptor.setCapHeight(fontMetrics.getCapHeight());
        pDFontDescriptor.setXHeight(fontMetrics.getXHeight());
        pDFontDescriptor.setAverageWidth(fontMetrics.getAverageCharacterWidth());
        pDFontDescriptor.setCharacterSet(fontMetrics.getCharacterSet());
        pDFontDescriptor.setStemV(0.0f);
        return pDFontDescriptor;
    }

    private DictionaryEncoding encodingFromAFM(FontMetrics fontMetrics) throws IOException {
        Type1Encoding type1Encoding = new Type1Encoding(fontMetrics);
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) COSInteger.ZERO);
        for (int i = 0; i < 256; i++) {
            cOSArray.add((COSBase) COSName.getPDFName(type1Encoding.getName(i)));
        }
        cOSArray.set(224, (COSBase) COSName.getPDFName("germandbls"));
        cOSArray.set((int) FTPReply.ENTERING_EPSV_MODE, (COSBase) COSName.getPDFName("adieresis"));
        cOSArray.set(247, (COSBase) COSName.getPDFName("odieresis"));
        cOSArray.set(253, (COSBase) COSName.getPDFName("udieresis"));
        cOSArray.set(197, (COSBase) COSName.getPDFName("Adieresis"));
        cOSArray.set((int) FTPReply.NAME_SYSTEM_TYPE, (COSBase) COSName.getPDFName("Odieresis"));
        cOSArray.set((int) FTPReply.SERVICE_CLOSING_CONTROL_CONNECTION, (COSBase) COSName.getPDFName("Udieresis"));
        return new DictionaryEncoding(COSName.STANDARD_ENCODING, cOSArray);
    }

    public Encoding getFontEncoding() {
        return this.fontEncoding;
    }

    public FontMetrics getFontMetrics() {
        return this.metrics;
    }

    public Type1Font getType1Font() {
        return this.type1;
    }
}
