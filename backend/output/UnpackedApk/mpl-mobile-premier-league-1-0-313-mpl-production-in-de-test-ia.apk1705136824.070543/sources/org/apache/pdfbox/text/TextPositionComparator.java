package org.apache.pdfbox.text;

import java.util.Comparator;

public class TextPositionComparator implements Comparator<TextPosition> {
    public int compare(TextPosition textPosition, TextPosition textPosition2) {
        if (textPosition.getDir() < textPosition2.getDir()) {
            return -1;
        }
        if (textPosition.getDir() > textPosition2.getDir()) {
            return 1;
        }
        float xDirAdj = textPosition.getXDirAdj();
        float xDirAdj2 = textPosition2.getXDirAdj();
        float yDirAdj = textPosition.getYDirAdj();
        float yDirAdj2 = textPosition2.getYDirAdj();
        float heightDir = yDirAdj - textPosition.getHeightDir();
        float heightDir2 = yDirAdj2 - textPosition2.getHeightDir();
        if (((double) Math.abs(yDirAdj - yDirAdj2)) < 0.1d || ((yDirAdj2 >= heightDir && yDirAdj2 <= yDirAdj) || (yDirAdj >= heightDir2 && yDirAdj <= yDirAdj2))) {
            if (xDirAdj < xDirAdj2) {
                return -1;
            }
            if (xDirAdj > xDirAdj2) {
                return 1;
            }
            return 0;
        } else if (yDirAdj < yDirAdj2) {
            return -1;
        } else {
            return 1;
        }
    }
}
