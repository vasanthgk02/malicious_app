package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public final class PDDocumentOutline extends PDOutlineNode {
    public PDDocumentOutline() {
        getCOSDictionary().setName(COSName.TYPE, COSName.OUTLINES.getName());
    }

    public void closeNode() {
    }

    public boolean isNodeOpen() {
        return true;
    }

    public void openNode() {
    }

    public PDDocumentOutline(COSDictionary cOSDictionary) {
        super(cOSDictionary);
        getCOSDictionary().setName(COSName.TYPE, COSName.OUTLINES.getName());
    }
}
