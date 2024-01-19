package org.apache.pdfbox.pdmodel.graphics.state;

public enum RenderingMode {
    FILL(0),
    STROKE(1),
    FILL_STROKE(2),
    NEITHER(3),
    FILL_CLIP(4),
    STROKE_CLIP(5),
    FILL_STROKE_CLIP(6),
    NEITHER_CLIP(7);
    
    public static final RenderingMode[] VALUES = null;
    public final int value;

    /* access modifiers changed from: public */
    static {
        VALUES = values();
    }

    /* access modifiers changed from: public */
    RenderingMode(int i) {
        this.value = i;
    }

    public static RenderingMode fromInt(int i) {
        return VALUES[i];
    }

    public int intValue() {
        return this.value;
    }

    public boolean isClip() {
        return this == FILL_CLIP || this == STROKE_CLIP || this == FILL_STROKE_CLIP || this == NEITHER_CLIP;
    }

    public boolean isFill() {
        return this == FILL || this == FILL_STROKE || this == FILL_CLIP || this == FILL_STROKE_CLIP;
    }

    public boolean isStroke() {
        RenderingMode renderingMode = STROKE;
        return this == renderingMode || this == FILL_STROKE || this == renderingMode || this == FILL_STROKE_CLIP;
    }
}
