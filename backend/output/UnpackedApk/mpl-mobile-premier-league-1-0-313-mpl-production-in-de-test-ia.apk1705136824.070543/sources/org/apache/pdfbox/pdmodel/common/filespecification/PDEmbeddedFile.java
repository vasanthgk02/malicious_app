package org.apache.pdfbox.pdmodel.common.filespecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;

public class PDEmbeddedFile extends PDStream {
    public PDEmbeddedFile(PDDocument pDDocument) {
        super(pDDocument);
        getStream().setName(COSName.TYPE, (String) "EmbeddedFile");
    }

    public String getCheckSum() {
        return getStream().getEmbeddedString((String) "Params", (String) "CheckSum");
    }

    public Calendar getCreationDate() throws IOException {
        return getStream().getEmbeddedDate((String) "Params", (String) "CreationDate");
    }

    public String getMacCreator() {
        COSDictionary cOSDictionary = (COSDictionary) getStream().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary != null) {
            return cOSDictionary.getEmbeddedString((String) "Mac", (String) "Creator");
        }
        return null;
    }

    public String getMacResFork() {
        COSDictionary cOSDictionary = (COSDictionary) getStream().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary != null) {
            return cOSDictionary.getEmbeddedString((String) "Mac", (String) "ResFork");
        }
        return null;
    }

    public String getMacSubtype() {
        COSDictionary cOSDictionary = (COSDictionary) getStream().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary != null) {
            return cOSDictionary.getEmbeddedString((String) "Mac", (String) "Subtype");
        }
        return null;
    }

    public Calendar getModDate() throws IOException {
        return getStream().getEmbeddedDate((String) "Params", (String) "ModDate");
    }

    public int getSize() {
        return getStream().getEmbeddedInt((String) "Params", (String) "Size");
    }

    public String getSubtype() {
        return getStream().getNameAsString(COSName.SUBTYPE);
    }

    public void setCheckSum(String str) {
        getStream().setEmbeddedString((String) "Params", (String) "CheckSum", str);
    }

    public void setCreationDate(Calendar calendar) {
        getStream().setEmbeddedDate((String) "Params", (String) "CreationDate", calendar);
    }

    public void setMacCreator(String str) {
        COSDictionary cOSDictionary = (COSDictionary) getStream().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary == null && str != null) {
            cOSDictionary = new COSDictionary();
            getStream().setItem(COSName.PARAMS, (COSBase) cOSDictionary);
        }
        if (cOSDictionary != null) {
            cOSDictionary.setEmbeddedString((String) "Mac", (String) "Creator", str);
        }
    }

    public void setMacResFork(String str) {
        COSDictionary cOSDictionary = (COSDictionary) getStream().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary == null && str != null) {
            cOSDictionary = new COSDictionary();
            getStream().setItem(COSName.PARAMS, (COSBase) cOSDictionary);
        }
        if (cOSDictionary != null) {
            cOSDictionary.setEmbeddedString((String) "Mac", (String) "ResFork", str);
        }
    }

    public void setMacSubtype(String str) {
        COSDictionary cOSDictionary = (COSDictionary) getStream().getDictionaryObject(COSName.PARAMS);
        if (cOSDictionary == null && str != null) {
            cOSDictionary = new COSDictionary();
            getStream().setItem(COSName.PARAMS, (COSBase) cOSDictionary);
        }
        if (cOSDictionary != null) {
            cOSDictionary.setEmbeddedString((String) "Mac", (String) "Subtype", str);
        }
    }

    public void setModDate(Calendar calendar) {
        getStream().setEmbeddedDate((String) "Params", (String) "ModDate", calendar);
    }

    public void setSize(int i) {
        getStream().setEmbeddedInt((String) "Params", (String) "Size", i);
    }

    public void setSubtype(String str) {
        getStream().setName(COSName.SUBTYPE, str);
    }

    public PDEmbeddedFile(COSStream cOSStream) {
        super(cOSStream);
    }

    public PDEmbeddedFile(PDDocument pDDocument, InputStream inputStream) throws IOException {
        super(pDDocument, inputStream);
        getStream().setName(COSName.TYPE, (String) "EmbeddedFile");
    }

    public PDEmbeddedFile(PDDocument pDDocument, InputStream inputStream, boolean z) throws IOException {
        super(pDDocument, inputStream, z);
        getStream().setName(COSName.TYPE, (String) "EmbeddedFile");
    }
}
