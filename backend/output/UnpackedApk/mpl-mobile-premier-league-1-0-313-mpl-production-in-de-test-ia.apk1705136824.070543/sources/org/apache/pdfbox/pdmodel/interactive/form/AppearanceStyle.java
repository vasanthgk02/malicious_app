package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.font.PDFont;

public class AppearanceStyle {
    public PDFont font;
    public float fontSize = 12.0f;
    public float leading = 14.4f;

    public PDFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getLeading() {
        return this.leading;
    }

    public void setFont(PDFont pDFont) {
        this.font = pDFont;
    }

    public void setFontSize(float f2) {
        this.fontSize = f2;
        this.leading = f2 * 1.2f;
    }

    public void setLeading(float f2) {
        this.leading = f2;
    }
}
