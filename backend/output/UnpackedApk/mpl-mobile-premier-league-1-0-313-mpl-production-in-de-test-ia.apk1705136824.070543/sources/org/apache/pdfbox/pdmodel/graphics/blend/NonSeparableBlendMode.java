package org.apache.pdfbox.pdmodel.graphics.blend;

public abstract class NonSeparableBlendMode extends BlendMode {
    public abstract void blend(float[] fArr, float[] fArr2, float[] fArr3);
}
