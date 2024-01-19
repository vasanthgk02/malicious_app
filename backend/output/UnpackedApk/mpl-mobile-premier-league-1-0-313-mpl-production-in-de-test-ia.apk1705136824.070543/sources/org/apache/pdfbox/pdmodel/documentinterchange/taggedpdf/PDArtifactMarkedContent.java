package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;

public class PDArtifactMarkedContent extends PDMarkedContent {
    public PDArtifactMarkedContent(COSDictionary cOSDictionary) {
        super(COSName.ARTIFACT, cOSDictionary);
    }

    private boolean isAttached(String str) {
        COSArray cOSArray = (COSArray) getProperties().getDictionaryObject(COSName.ATTACHED);
        if (cOSArray != null) {
            for (int i = 0; i < cOSArray.size(); i++) {
                if (str.equals(cOSArray.getName(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public PDRectangle getBBox() {
        COSArray cOSArray = (COSArray) getProperties().getDictionaryObject(COSName.BBOX);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public String getSubtype() {
        return getProperties().getNameAsString(COSName.SUBTYPE);
    }

    public String getType() {
        return getProperties().getNameAsString(COSName.TYPE);
    }

    public boolean isBottomAttached() {
        return isAttached("Bottom");
    }

    public boolean isLeftAttached() {
        return isAttached("Left");
    }

    public boolean isRightAttached() {
        return isAttached("Right");
    }

    public boolean isTopAttached() {
        return isAttached("Top");
    }
}
