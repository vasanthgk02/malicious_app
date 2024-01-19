package org.apache.fontbox.ttf;

import java.io.IOException;

public class GlyfCompositeComp {
    public static final short ARGS_ARE_XY_VALUES = 2;
    public static final short ARG_1_AND_2_ARE_WORDS = 1;
    public static final short MORE_COMPONENTS = 32;
    public static final short ROUND_XY_TO_GRID = 4;
    public static final short USE_MY_METRICS = 512;
    public static final short WE_HAVE_AN_X_AND_Y_SCALE = 64;
    public static final short WE_HAVE_A_SCALE = 8;
    public static final short WE_HAVE_A_TWO_BY_TWO = 128;
    public static final short WE_HAVE_INSTRUCTIONS = 256;
    public final short argument1;
    public final short argument2;
    public int firstContour;
    public int firstIndex;
    public final short flags;
    public final int glyphIndex;
    public int point1 = 0;
    public int point2 = 0;
    public double scale01 = 0.0d;
    public double scale10 = 0.0d;
    public double xscale = 1.0d;
    public int xtranslate = 0;
    public double yscale = 1.0d;
    public int ytranslate = 0;

    public GlyfCompositeComp(TTFDataStream tTFDataStream) throws IOException {
        this.flags = tTFDataStream.readSignedShort();
        this.glyphIndex = tTFDataStream.readUnsignedShort();
        if ((this.flags & 1) != 0) {
            this.argument1 = tTFDataStream.readSignedShort();
            this.argument2 = tTFDataStream.readSignedShort();
        } else {
            this.argument1 = (short) tTFDataStream.readSignedByte();
            this.argument2 = (short) tTFDataStream.readSignedByte();
        }
        if ((this.flags & 2) != 0) {
            this.xtranslate = this.argument1;
            this.ytranslate = this.argument2;
        } else {
            this.point1 = this.argument1;
            this.point2 = this.argument2;
        }
        short s = this.flags;
        if ((s & 8) != 0) {
            double readSignedShort = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.yscale = readSignedShort;
            this.xscale = readSignedShort;
        } else if ((s & 64) != 0) {
            this.xscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.yscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
        } else if ((s & 128) != 0) {
            this.xscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.scale01 = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.scale10 = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.yscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
        }
    }

    public short getArgument1() {
        return this.argument1;
    }

    public short getArgument2() {
        return this.argument2;
    }

    public int getFirstContour() {
        return this.firstContour;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public short getFlags() {
        return this.flags;
    }

    public int getGlyphIndex() {
        return this.glyphIndex;
    }

    public double getScale01() {
        return this.scale01;
    }

    public double getScale10() {
        return this.scale10;
    }

    public double getXScale() {
        return this.xscale;
    }

    public int getXTranslate() {
        return this.xtranslate;
    }

    public double getYScale() {
        return this.yscale;
    }

    public int getYTranslate() {
        return this.ytranslate;
    }

    public int scaleX(int i, int i2) {
        return Math.round((float) ((((double) i2) * this.scale10) + (((double) i) * this.xscale)));
    }

    public int scaleY(int i, int i2) {
        return Math.round((float) ((((double) i2) * this.yscale) + (((double) i) * this.scale01)));
    }

    public void setFirstContour(int i) {
        this.firstContour = i;
    }

    public void setFirstIndex(int i) {
        this.firstIndex = i;
    }
}
