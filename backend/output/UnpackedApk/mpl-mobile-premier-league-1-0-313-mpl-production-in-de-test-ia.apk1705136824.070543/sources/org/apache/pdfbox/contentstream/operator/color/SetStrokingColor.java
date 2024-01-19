package org.apache.pdfbox.contentstream.operator.color;

import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;

public class SetStrokingColor extends SetColor {
    public PDColor getColor() {
        return this.context.getGraphicsState().getStrokingColor();
    }

    public PDColorSpace getColorSpace() {
        return this.context.getGraphicsState().getStrokingColorSpace();
    }

    public String getName() {
        return "SC";
    }

    public void setColor(PDColor pDColor) {
        this.context.getGraphicsState().setStrokingColor(pDColor);
    }
}
