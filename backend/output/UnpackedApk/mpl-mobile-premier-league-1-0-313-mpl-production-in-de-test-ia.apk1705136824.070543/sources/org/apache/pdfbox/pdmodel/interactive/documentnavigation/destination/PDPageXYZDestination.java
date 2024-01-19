package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;

public class PDPageXYZDestination extends PDPageDestination {
    public static final String TYPE = "XYZ";

    public PDPageXYZDestination() {
        this.array.growToSize(5);
        this.array.setName(1, TYPE);
    }

    public int getLeft() {
        return this.array.getInt(2);
    }

    public int getTop() {
        return this.array.getInt(3);
    }

    public int getZoom() {
        return this.array.getInt(4);
    }

    public void setLeft(int i) {
        this.array.growToSize(3);
        if (i == -1) {
            this.array.set(2, (COSBase) null);
        } else {
            this.array.setInt(2, i);
        }
    }

    public void setTop(int i) {
        this.array.growToSize(4);
        if (i == -1) {
            this.array.set(3, (COSBase) null);
        } else {
            this.array.setInt(3, i);
        }
    }

    public void setZoom(int i) {
        this.array.growToSize(5);
        if (i == -1) {
            this.array.set(4, (COSBase) null);
        } else {
            this.array.setInt(4, i);
        }
    }

    public PDPageXYZDestination(COSArray cOSArray) {
        super(cOSArray);
    }
}
