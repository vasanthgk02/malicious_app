package org.apache.pdfbox.contentstream.operator.color;

import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;

public class SetNonStrokingColor extends SetColor {
    public PDColor getColor() {
        return this.context.getGraphicsState().getNonStrokingColor();
    }

    public PDColorSpace getColorSpace() {
        return this.context.getGraphicsState().getNonStrokingColorSpace();
    }

    public String getName() {
        return "sc";
    }

    public void setColor(PDColor pDColor) {
        this.context.getGraphicsState().setNonStrokingColor(pDColor);
    }
}
