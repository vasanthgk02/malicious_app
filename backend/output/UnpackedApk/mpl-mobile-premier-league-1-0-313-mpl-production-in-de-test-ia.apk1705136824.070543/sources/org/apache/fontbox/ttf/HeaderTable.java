package org.apache.fontbox.ttf;

import java.io.IOException;
import java.util.Calendar;

public class HeaderTable extends TTFTable {
    public static final String TAG = "head";
    public long checkSumAdjustment;
    public Calendar created;
    public int flags;
    public short fontDirectionHint;
    public float fontRevision;
    public short glyphDataFormat;
    public short indexToLocFormat;
    public int lowestRecPPEM;
    public int macStyle;
    public long magicNumber;
    public Calendar modified;
    public int unitsPerEm;
    public float version;
    public short xMax;
    public short xMin;
    public short yMax;
    public short yMin;

    public long getCheckSumAdjustment() {
        return this.checkSumAdjustment;
    }

    public Calendar getCreated() {
        return this.created;
    }

    public int getFlags() {
        return this.flags;
    }

    public short getFontDirectionHint() {
        return this.fontDirectionHint;
    }

    public float getFontRevision() {
        return this.fontRevision;
    }

    public short getGlyphDataFormat() {
        return this.glyphDataFormat;
    }

    public short getIndexToLocFormat() {
        return this.indexToLocFormat;
    }

    public int getLowestRecPPEM() {
        return this.lowestRecPPEM;
    }

    public int getMacStyle() {
        return this.macStyle;
    }

    public long getMagicNumber() {
        return this.magicNumber;
    }

    public Calendar getModified() {
        return this.modified;
    }

    public int getUnitsPerEm() {
        return this.unitsPerEm;
    }

    public float getVersion() {
        return this.version;
    }

    public short getXMax() {
        return this.xMax;
    }

    public short getXMin() {
        return this.xMin;
    }

    public short getYMax() {
        return this.yMax;
    }

    public short getYMin() {
        return this.yMin;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.read32Fixed();
        this.fontRevision = tTFDataStream.read32Fixed();
        this.checkSumAdjustment = tTFDataStream.readUnsignedInt();
        this.magicNumber = tTFDataStream.readUnsignedInt();
        this.flags = tTFDataStream.readUnsignedShort();
        this.unitsPerEm = tTFDataStream.readUnsignedShort();
        this.created = tTFDataStream.readInternationalDate();
        this.modified = tTFDataStream.readInternationalDate();
        this.xMin = tTFDataStream.readSignedShort();
        this.yMin = tTFDataStream.readSignedShort();
        this.xMax = tTFDataStream.readSignedShort();
        this.yMax = tTFDataStream.readSignedShort();
        this.macStyle = tTFDataStream.readUnsignedShort();
        this.lowestRecPPEM = tTFDataStream.readUnsignedShort();
        this.fontDirectionHint = tTFDataStream.readSignedShort();
        this.indexToLocFormat = tTFDataStream.readSignedShort();
        this.glyphDataFormat = tTFDataStream.readSignedShort();
        this.initialized = true;
    }

    public void setCheckSumAdjustment(long j) {
        this.checkSumAdjustment = j;
    }

    public void setCreated(Calendar calendar) {
        this.created = calendar;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public void setFontDirectionHint(short s) {
        this.fontDirectionHint = s;
    }

    public void setFontRevision(float f2) {
        this.fontRevision = f2;
    }

    public void setGlyphDataFormat(short s) {
        this.glyphDataFormat = s;
    }

    public void setIndexToLocFormat(short s) {
        this.indexToLocFormat = s;
    }

    public void setLowestRecPPEM(int i) {
        this.lowestRecPPEM = i;
    }

    public void setMacStyle(int i) {
        this.macStyle = i;
    }

    public void setMagicNumber(long j) {
        this.magicNumber = j;
    }

    public void setModified(Calendar calendar) {
        this.modified = calendar;
    }

    public void setUnitsPerEm(int i) {
        this.unitsPerEm = i;
    }

    public void setVersion(float f2) {
        this.version = f2;
    }

    public void setXMax(short s) {
        this.xMax = s;
    }

    public void setXMin(short s) {
        this.xMin = s;
    }

    public void setYMax(short s) {
        this.yMax = s;
    }

    public void setYMin(short s) {
        this.yMin = s;
    }
}
