package org.apache.fontbox.ttf;

public interface GlyphDescription {
    int getContourCount();

    int getEndPtOfContours(int i);

    byte getFlags(int i);

    int getPointCount();

    short getXCoordinate(int i);

    short getYCoordinate(int i);

    boolean isComposite();

    void resolve();
}
