package org.apache.fontbox.ttf;

import java.io.IOException;

public class MaximumProfileTable extends TTFTable {
    public static final String TAG = "maxp";
    public int maxComponentDepth;
    public int maxComponentElements;
    public int maxCompositeContours;
    public int maxCompositePoints;
    public int maxContours;
    public int maxFunctionDefs;
    public int maxInstructionDefs;
    public int maxPoints;
    public int maxSizeOfInstructions;
    public int maxStackElements;
    public int maxStorage;
    public int maxTwilightPoints;
    public int maxZones;
    public int numGlyphs;
    public float version;

    public int getMaxComponentDepth() {
        return this.maxComponentDepth;
    }

    public int getMaxComponentElements() {
        return this.maxComponentElements;
    }

    public int getMaxCompositeContours() {
        return this.maxCompositeContours;
    }

    public int getMaxCompositePoints() {
        return this.maxCompositePoints;
    }

    public int getMaxContours() {
        return this.maxContours;
    }

    public int getMaxFunctionDefs() {
        return this.maxFunctionDefs;
    }

    public int getMaxInstructionDefs() {
        return this.maxInstructionDefs;
    }

    public int getMaxPoints() {
        return this.maxPoints;
    }

    public int getMaxSizeOfInstructions() {
        return this.maxSizeOfInstructions;
    }

    public int getMaxStackElements() {
        return this.maxStackElements;
    }

    public int getMaxStorage() {
        return this.maxStorage;
    }

    public int getMaxTwilightPoints() {
        return this.maxTwilightPoints;
    }

    public int getMaxZones() {
        return this.maxZones;
    }

    public int getNumGlyphs() {
        return this.numGlyphs;
    }

    public float getVersion() {
        return this.version;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.read32Fixed();
        this.numGlyphs = tTFDataStream.readUnsignedShort();
        this.maxPoints = tTFDataStream.readUnsignedShort();
        this.maxContours = tTFDataStream.readUnsignedShort();
        this.maxCompositePoints = tTFDataStream.readUnsignedShort();
        this.maxCompositeContours = tTFDataStream.readUnsignedShort();
        this.maxZones = tTFDataStream.readUnsignedShort();
        this.maxTwilightPoints = tTFDataStream.readUnsignedShort();
        this.maxStorage = tTFDataStream.readUnsignedShort();
        this.maxFunctionDefs = tTFDataStream.readUnsignedShort();
        this.maxInstructionDefs = tTFDataStream.readUnsignedShort();
        this.maxStackElements = tTFDataStream.readUnsignedShort();
        this.maxSizeOfInstructions = tTFDataStream.readUnsignedShort();
        this.maxComponentElements = tTFDataStream.readUnsignedShort();
        this.maxComponentDepth = tTFDataStream.readUnsignedShort();
        this.initialized = true;
    }

    public void setMaxComponentDepth(int i) {
        this.maxComponentDepth = i;
    }

    public void setMaxComponentElements(int i) {
        this.maxComponentElements = i;
    }

    public void setMaxCompositeContours(int i) {
        this.maxCompositeContours = i;
    }

    public void setMaxCompositePoints(int i) {
        this.maxCompositePoints = i;
    }

    public void setMaxContours(int i) {
        this.maxContours = i;
    }

    public void setMaxFunctionDefs(int i) {
        this.maxFunctionDefs = i;
    }

    public void setMaxInstructionDefs(int i) {
        this.maxInstructionDefs = i;
    }

    public void setMaxPoints(int i) {
        this.maxPoints = i;
    }

    public void setMaxSizeOfInstructions(int i) {
        this.maxSizeOfInstructions = i;
    }

    public void setMaxStackElements(int i) {
        this.maxStackElements = i;
    }

    public void setMaxStorage(int i) {
        this.maxStorage = i;
    }

    public void setMaxTwilightPoints(int i) {
        this.maxTwilightPoints = i;
    }

    public void setMaxZones(int i) {
        this.maxZones = i;
    }

    public void setNumGlyphs(int i) {
        this.numGlyphs = i;
    }

    public void setVersion(float f2) {
        this.version = f2;
    }
}
