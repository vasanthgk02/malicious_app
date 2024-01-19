package org.apache.fontbox.ttf;

import android.graphics.Path;
import java.io.IOException;
import org.apache.fontbox.util.BoundingBox;

public class GlyphData {
    public BoundingBox boundingBox = null;
    public GlyfDescript glyphDescription = null;
    public short numberOfContours;
    public short xMax;
    public short xMin;
    public short yMax;
    public short yMin;

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public GlyphDescription getDescription() {
        return this.glyphDescription;
    }

    public short getNumberOfContours() {
        return this.numberOfContours;
    }

    public Path getPath() {
        return new GlyphRenderer(this.glyphDescription).getPath();
    }

    public short getXMaximum() {
        return this.xMax;
    }

    public short getXMinimum() {
        return this.xMin;
    }

    public short getYMaximum() {
        return this.yMax;
    }

    public short getYMinimum() {
        return this.yMin;
    }

    public void initData(GlyphTable glyphTable, TTFDataStream tTFDataStream) throws IOException {
        this.numberOfContours = tTFDataStream.readSignedShort();
        this.xMin = tTFDataStream.readSignedShort();
        this.yMin = tTFDataStream.readSignedShort();
        this.xMax = tTFDataStream.readSignedShort();
        short readSignedShort = tTFDataStream.readSignedShort();
        this.yMax = readSignedShort;
        this.boundingBox = new BoundingBox((float) this.xMin, (float) this.yMin, (float) this.xMax, (float) readSignedShort);
        short s = this.numberOfContours;
        if (s >= 0) {
            this.glyphDescription = new GlyfSimpleDescript(s, tTFDataStream);
        } else {
            this.glyphDescription = new GlyfCompositeDescript(tTFDataStream, glyphTable);
        }
    }

    public void setBoundingBox(BoundingBox boundingBox2) {
        this.boundingBox = boundingBox2;
    }

    public void setNumberOfContours(short s) {
        this.numberOfContours = s;
    }
}
