package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.pdmodel.font.PDFont;

public class PDTextState implements Cloneable {
    public float characterSpacing = 0.0f;
    public PDFont font;
    public float fontSize;
    public float horizontalScaling = 100.0f;
    public boolean knockout = true;
    public float leading = 0.0f;
    public RenderingMode renderingMode = RenderingMode.FILL;
    public float rise = 0.0f;
    public float wordSpacing = 0.0f;

    public float getCharacterSpacing() {
        return this.characterSpacing;
    }

    public PDFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getHorizontalScaling() {
        return this.horizontalScaling;
    }

    public boolean getKnockoutFlag() {
        return this.knockout;
    }

    public float getLeading() {
        return this.leading;
    }

    public RenderingMode getRenderingMode() {
        return this.renderingMode;
    }

    public float getRise() {
        return this.rise;
    }

    public float getWordSpacing() {
        return this.wordSpacing;
    }

    public void setCharacterSpacing(float f2) {
        this.characterSpacing = f2;
    }

    public void setFont(PDFont pDFont) {
        this.font = pDFont;
    }

    public void setFontSize(float f2) {
        this.fontSize = f2;
    }

    public void setHorizontalScaling(float f2) {
        this.horizontalScaling = f2;
    }

    public void setKnockoutFlag(boolean z) {
        this.knockout = z;
    }

    public void setLeading(float f2) {
        this.leading = f2;
    }

    public void setRenderingMode(RenderingMode renderingMode2) {
        this.renderingMode = renderingMode2;
    }

    public void setRise(float f2) {
        this.rise = f2;
    }

    public void setWordSpacing(float f2) {
        this.wordSpacing = f2;
    }

    public PDTextState clone() {
        try {
            return (PDTextState) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
