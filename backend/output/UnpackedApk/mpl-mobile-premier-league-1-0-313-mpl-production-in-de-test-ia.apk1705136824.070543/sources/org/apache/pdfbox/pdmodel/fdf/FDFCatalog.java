package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import java.io.Writer;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.w3c.dom.Element;

public class FDFCatalog implements COSObjectable {
    public COSDictionary catalog;

    public FDFCatalog() {
        this.catalog = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.catalog;
    }

    public COSBase getCOSObject() {
        return this.catalog;
    }

    public FDFDictionary getFDF() {
        COSDictionary cOSDictionary = (COSDictionary) this.catalog.getDictionaryObject(COSName.FDF);
        if (cOSDictionary != null) {
            return new FDFDictionary(cOSDictionary);
        }
        FDFDictionary fDFDictionary = new FDFDictionary();
        setFDF(fDFDictionary);
        return fDFDictionary;
    }

    public PDSignature getSignature() {
        COSDictionary cOSDictionary = (COSDictionary) this.catalog.getDictionaryObject(COSName.SIG);
        if (cOSDictionary != null) {
            return new PDSignature(cOSDictionary);
        }
        return null;
    }

    public String getVersion() {
        return this.catalog.getNameAsString(COSName.VERSION);
    }

    public void setFDF(FDFDictionary fDFDictionary) {
        this.catalog.setItem(COSName.FDF, (COSObjectable) fDFDictionary);
    }

    public void setSignature(PDSignature pDSignature) {
        this.catalog.setItem(COSName.SIG, (COSObjectable) pDSignature);
    }

    public void setVersion(String str) {
        this.catalog.setName(COSName.VERSION, str);
    }

    public void writeXML(Writer writer) throws IOException {
        getFDF().writeXML(writer);
    }

    public FDFCatalog(COSDictionary cOSDictionary) {
        this.catalog = cOSDictionary;
    }

    public FDFCatalog(Element element) throws IOException {
        this();
        setFDF(new FDFDictionary(element));
    }
}
