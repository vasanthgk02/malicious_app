package org.apache.fontbox.ttf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GlyfCompositeDescript extends GlyfDescript {
    public boolean beingResolved = false;
    public final List<GlyfCompositeComp> components = new ArrayList();
    public GlyphTable glyphTable = null;
    public boolean resolved = false;

    public GlyfCompositeDescript(TTFDataStream tTFDataStream, GlyphTable glyphTable2) throws IOException {
        GlyfCompositeComp glyfCompositeComp;
        super(-1, tTFDataStream);
        this.glyphTable = glyphTable2;
        do {
            glyfCompositeComp = new GlyfCompositeComp(tTFDataStream);
            this.components.add(glyfCompositeComp);
        } while ((glyfCompositeComp.getFlags() & 32) != 0);
        if ((glyfCompositeComp.getFlags() & 256) != 0) {
            readInstructions(tTFDataStream, tTFDataStream.readUnsignedShort());
        }
    }

    private GlyfCompositeComp getCompositeComp(int i) {
        for (GlyfCompositeComp next : this.components) {
            GlyphDescription glypDescription = getGlypDescription(next.getGlyphIndex());
            if (next.getFirstIndex() <= i) {
                if (i < glypDescription.getPointCount() + next.getFirstIndex()) {
                    return next;
                }
            }
        }
        return null;
    }

    private GlyfCompositeComp getCompositeCompEndPt(int i) {
        for (GlyfCompositeComp next : this.components) {
            GlyphDescription glypDescription = getGlypDescription(next.getGlyphIndex());
            if (next.getFirstContour() <= i) {
                if (i < glypDescription.getContourCount() + next.getFirstContour()) {
                    return next;
                }
            }
        }
        return null;
    }

    private GlyphDescription getGlypDescription(int i) {
        try {
            GlyphData glyph = this.glyphTable.getGlyph(i);
            if (glyph != null) {
                return glyph.getDescription();
            }
            return null;
        } catch (IOException e2) {
            e2.getMessage();
            return null;
        }
    }

    public int getComponentCount() {
        return this.components.size();
    }

    public int getContourCount() {
        GlyfCompositeComp glyfCompositeComp = (GlyfCompositeComp) GeneratedOutlineSupport.outline29(this.components, -1);
        return getGlypDescription(glyfCompositeComp.getGlyphIndex()).getContourCount() + glyfCompositeComp.getFirstContour();
    }

    public int getEndPtOfContours(int i) {
        GlyfCompositeComp compositeCompEndPt = getCompositeCompEndPt(i);
        if (compositeCompEndPt == null) {
            return 0;
        }
        return compositeCompEndPt.getFirstIndex() + getGlypDescription(compositeCompEndPt.getGlyphIndex()).getEndPtOfContours(i - compositeCompEndPt.getFirstContour());
    }

    public byte getFlags(int i) {
        GlyfCompositeComp compositeComp = getCompositeComp(i);
        if (compositeComp != null) {
            return getGlypDescription(compositeComp.getGlyphIndex()).getFlags(i - compositeComp.getFirstIndex());
        }
        return 0;
    }

    public int getPointCount() {
        GlyfCompositeComp glyfCompositeComp = (GlyfCompositeComp) GeneratedOutlineSupport.outline29(this.components, -1);
        GlyphDescription glypDescription = getGlypDescription(glyfCompositeComp.getGlyphIndex());
        if (glypDescription == null) {
            glyfCompositeComp.getGlyphIndex();
            return 0;
        }
        return glypDescription.getPointCount() + glyfCompositeComp.getFirstIndex();
    }

    public short getXCoordinate(int i) {
        GlyfCompositeComp compositeComp = getCompositeComp(i);
        if (compositeComp == null) {
            return 0;
        }
        GlyphDescription glypDescription = getGlypDescription(compositeComp.getGlyphIndex());
        int firstIndex = i - compositeComp.getFirstIndex();
        return (short) (compositeComp.getXTranslate() + ((short) compositeComp.scaleX(glypDescription.getXCoordinate(firstIndex), glypDescription.getYCoordinate(firstIndex))));
    }

    public short getYCoordinate(int i) {
        GlyfCompositeComp compositeComp = getCompositeComp(i);
        if (compositeComp == null) {
            return 0;
        }
        GlyphDescription glypDescription = getGlypDescription(compositeComp.getGlyphIndex());
        int firstIndex = i - compositeComp.getFirstIndex();
        return (short) (compositeComp.getYTranslate() + ((short) compositeComp.scaleY(glypDescription.getXCoordinate(firstIndex), glypDescription.getYCoordinate(firstIndex))));
    }

    public boolean isComposite() {
        return true;
    }

    public void resolve() {
        if (!this.resolved && !this.beingResolved) {
            this.beingResolved = true;
            int i = 0;
            int i2 = 0;
            for (GlyfCompositeComp next : this.components) {
                next.setFirstIndex(i);
                next.setFirstContour(i2);
                GlyphDescription glypDescription = getGlypDescription(next.getGlyphIndex());
                if (glypDescription != null) {
                    glypDescription.resolve();
                    i += glypDescription.getPointCount();
                    i2 += glypDescription.getContourCount();
                }
            }
            this.resolved = true;
            this.beingResolved = false;
        }
    }
}
