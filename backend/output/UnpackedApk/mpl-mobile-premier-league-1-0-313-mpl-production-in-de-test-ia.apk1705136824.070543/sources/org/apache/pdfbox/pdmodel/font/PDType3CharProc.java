package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;

public final class PDType3CharProc implements COSObjectable, PDContentStream {
    public final COSStream charStream;
    public final PDType3Font font;

    public PDType3CharProc(PDType3Font pDType3Font, COSStream cOSStream) {
        this.font = pDType3Font;
        this.charStream = cOSStream;
    }

    public PDRectangle getBBox() {
        return this.font.getFontBBox();
    }

    public COSStream getContentStream() {
        return this.charStream;
    }

    public PDType3Font getFont() {
        return this.font;
    }

    public Matrix getMatrix() {
        return this.font.getFontMatrix();
    }

    public PDResources getResources() {
        return this.font.getResources();
    }

    public COSStream getCOSObject() {
        return this.charStream;
    }
}
