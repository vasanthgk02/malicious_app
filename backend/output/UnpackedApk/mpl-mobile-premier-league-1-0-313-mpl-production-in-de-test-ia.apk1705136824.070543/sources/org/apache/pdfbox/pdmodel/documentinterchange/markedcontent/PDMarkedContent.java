package org.apache.pdfbox.pdmodel.documentinterchange.markedcontent;

import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDArtifactMarkedContent;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.text.TextPosition;

public class PDMarkedContent {
    public final List<Object> contents;
    public final COSDictionary properties;
    public final String tag;

    public PDMarkedContent(COSName cOSName, COSDictionary cOSDictionary) {
        String str;
        if (cOSName == null) {
            str = null;
        } else {
            str = cOSName.getName();
        }
        this.tag = str;
        this.properties = cOSDictionary;
        this.contents = new ArrayList();
    }

    public static PDMarkedContent create(COSName cOSName, COSDictionary cOSDictionary) {
        if (COSName.ARTIFACT.equals(cOSName)) {
            return new PDArtifactMarkedContent(cOSDictionary);
        }
        return new PDMarkedContent(cOSName, cOSDictionary);
    }

    public void addMarkedContent(PDMarkedContent pDMarkedContent) {
        getContents().add(pDMarkedContent);
    }

    public void addText(TextPosition textPosition) {
        getContents().add(textPosition);
    }

    public void addXObject(PDXObject pDXObject) {
        getContents().add(pDXObject);
    }

    public String getActualText() {
        if (getProperties() == null) {
            return null;
        }
        return getProperties().getString(COSName.ACTUAL_TEXT);
    }

    public String getAlternateDescription() {
        if (getProperties() == null) {
            return null;
        }
        return getProperties().getString(COSName.ALT);
    }

    public List<Object> getContents() {
        return this.contents;
    }

    public String getExpandedForm() {
        if (getProperties() == null) {
            return null;
        }
        return getProperties().getString(COSName.E);
    }

    public String getLanguage() {
        if (getProperties() == null) {
            return null;
        }
        return getProperties().getNameAsString(COSName.LANG);
    }

    public int getMCID() {
        Integer num;
        if (getProperties() == null) {
            num = null;
        } else {
            num = Integer.valueOf(getProperties().getInt(COSName.MCID));
        }
        return num.intValue();
    }

    public COSDictionary getProperties() {
        return this.properties;
    }

    public String getTag() {
        return this.tag;
    }

    public String toString() {
        return "tag=" + this.tag + ", properties=" + this.properties + ", contents=" + this.contents;
    }
}
