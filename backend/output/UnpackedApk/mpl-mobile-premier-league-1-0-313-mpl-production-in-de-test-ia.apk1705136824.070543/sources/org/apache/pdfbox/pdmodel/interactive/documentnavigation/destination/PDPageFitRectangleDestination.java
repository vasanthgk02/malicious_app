package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;

public class PDPageFitRectangleDestination extends PDPageDestination {
    public static final String TYPE = "FitR";

    public PDPageFitRectangleDestination() {
        this.array.growToSize(6);
        this.array.setName(1, TYPE);
    }

    public int getBottom() {
        return this.array.getInt(3);
    }

    public int getLeft() {
        return this.array.getInt(2);
    }

    public int getRight() {
        return this.array.getInt(4);
    }

    public int getTop() {
        return this.array.getInt(5);
    }

    public void setBottom(int i) {
        this.array.growToSize(6);
        if (i == -1) {
            this.array.set(3, (COSBase) null);
        } else {
            this.array.setInt(3, i);
        }
    }

    public void setLeft(int i) {
        this.array.growToSize(3);
        if (i == -1) {
            this.array.set(2, (COSBase) null);
        } else {
            this.array.setInt(2, i);
        }
    }

    public void setRight(int i) {
        this.array.growToSize(6);
        if (i == -1) {
            this.array.set(4, (COSBase) null);
        } else {
            this.array.setInt(4, i);
        }
    }

    public void setTop(int i) {
        this.array.growToSize(6);
        if (i == -1) {
            this.array.set(5, (COSBase) null);
        } else {
            this.array.setInt(5, i);
        }
    }

    public PDPageFitRectangleDestination(COSArray cOSArray) {
        super(cOSArray);
    }
}
