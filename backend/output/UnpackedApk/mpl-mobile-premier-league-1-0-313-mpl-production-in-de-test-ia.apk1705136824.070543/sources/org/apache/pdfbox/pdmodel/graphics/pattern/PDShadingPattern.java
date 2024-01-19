package org.apache.pdfbox.pdmodel.graphics.pattern;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;

public class PDShadingPattern extends PDAbstractPattern {
    public PDExtendedGraphicsState extendedGraphicsState;
    public PDShading shading;

    public PDShadingPattern() {
        getCOSDictionary().setInt(COSName.PATTERN_TYPE, 2);
    }

    public PDExtendedGraphicsState getExtendedGraphicsState() {
        if (this.extendedGraphicsState == null) {
            COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.EXT_G_STATE);
            if (cOSDictionary != null) {
                this.extendedGraphicsState = new PDExtendedGraphicsState(cOSDictionary);
            }
        }
        return this.extendedGraphicsState;
    }

    public int getPatternType() {
        return 2;
    }

    public PDShading getShading() throws IOException {
        if (this.shading == null) {
            COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.SHADING);
            if (cOSDictionary != null) {
                this.shading = PDShading.create(cOSDictionary);
            }
        }
        return this.shading;
    }

    public void setExternalGraphicsState(PDExtendedGraphicsState pDExtendedGraphicsState) {
        this.extendedGraphicsState = pDExtendedGraphicsState;
        if (pDExtendedGraphicsState != null) {
            getCOSDictionary().setItem(COSName.EXT_G_STATE, (COSObjectable) pDExtendedGraphicsState);
        } else {
            getCOSDictionary().removeItem(COSName.EXT_G_STATE);
        }
    }

    public void setShading(PDShading pDShading) {
        this.shading = pDShading;
        if (pDShading != null) {
            getCOSDictionary().setItem(COSName.SHADING, (COSObjectable) pDShading);
        } else {
            getCOSDictionary().removeItem(COSName.SHADING);
        }
    }

    public PDShadingPattern(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
