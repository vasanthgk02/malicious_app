package org.apache.fontbox.ttf;

import java.io.IOException;

public class HorizontalHeaderTable extends TTFTable {
    public static final String TAG = "hhea";
    public int advanceWidthMax;
    public short ascender;
    public short caretSlopeRise;
    public short caretSlopeRun;
    public short descender;
    public short lineGap;
    public short metricDataFormat;
    public short minLeftSideBearing;
    public short minRightSideBearing;
    public int numberOfHMetrics;
    public short reserved1;
    public short reserved2;
    public short reserved3;
    public short reserved4;
    public short reserved5;
    public float version;
    public short xMaxExtent;

    public int getAdvanceWidthMax() {
        return this.advanceWidthMax;
    }

    public short getAscender() {
        return this.ascender;
    }

    public short getCaretSlopeRise() {
        return this.caretSlopeRise;
    }

    public short getCaretSlopeRun() {
        return this.caretSlopeRun;
    }

    public short getDescender() {
        return this.descender;
    }

    public short getLineGap() {
        return this.lineGap;
    }

    public short getMetricDataFormat() {
        return this.metricDataFormat;
    }

    public short getMinLeftSideBearing() {
        return this.minLeftSideBearing;
    }

    public short getMinRightSideBearing() {
        return this.minRightSideBearing;
    }

    public int getNumberOfHMetrics() {
        return this.numberOfHMetrics;
    }

    public short getReserved1() {
        return this.reserved1;
    }

    public short getReserved2() {
        return this.reserved2;
    }

    public short getReserved3() {
        return this.reserved3;
    }

    public short getReserved4() {
        return this.reserved4;
    }

    public short getReserved5() {
        return this.reserved5;
    }

    public float getVersion() {
        return this.version;
    }

    public short getXMaxExtent() {
        return this.xMaxExtent;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.read32Fixed();
        this.ascender = tTFDataStream.readSignedShort();
        this.descender = tTFDataStream.readSignedShort();
        this.lineGap = tTFDataStream.readSignedShort();
        this.advanceWidthMax = tTFDataStream.readUnsignedShort();
        this.minLeftSideBearing = tTFDataStream.readSignedShort();
        this.minRightSideBearing = tTFDataStream.readSignedShort();
        this.xMaxExtent = tTFDataStream.readSignedShort();
        this.caretSlopeRise = tTFDataStream.readSignedShort();
        this.caretSlopeRun = tTFDataStream.readSignedShort();
        this.reserved1 = tTFDataStream.readSignedShort();
        this.reserved2 = tTFDataStream.readSignedShort();
        this.reserved3 = tTFDataStream.readSignedShort();
        this.reserved4 = tTFDataStream.readSignedShort();
        this.reserved5 = tTFDataStream.readSignedShort();
        this.metricDataFormat = tTFDataStream.readSignedShort();
        this.numberOfHMetrics = tTFDataStream.readUnsignedShort();
        this.initialized = true;
    }

    public void setAdvanceWidthMax(int i) {
        this.advanceWidthMax = i;
    }

    public void setAscender(short s) {
        this.ascender = s;
    }

    public void setCaretSlopeRise(short s) {
        this.caretSlopeRise = s;
    }

    public void setCaretSlopeRun(short s) {
        this.caretSlopeRun = s;
    }

    public void setDescender(short s) {
        this.descender = s;
    }

    public void setLineGap(short s) {
        this.lineGap = s;
    }

    public void setMetricDataFormat(short s) {
        this.metricDataFormat = s;
    }

    public void setMinLeftSideBearing(short s) {
        this.minLeftSideBearing = s;
    }

    public void setMinRightSideBearing(short s) {
        this.minRightSideBearing = s;
    }

    public void setNumberOfHMetrics(int i) {
        this.numberOfHMetrics = i;
    }

    public void setReserved1(short s) {
        this.reserved1 = s;
    }

    public void setReserved2(short s) {
        this.reserved2 = s;
    }

    public void setReserved3(short s) {
        this.reserved3 = s;
    }

    public void setReserved4(short s) {
        this.reserved4 = s;
    }

    public void setReserved5(short s) {
        this.reserved5 = s;
    }

    public void setVersion(float f2) {
        this.version = f2;
    }

    public void setXMaxExtent(short s) {
        this.xMaxExtent = s;
    }
}
