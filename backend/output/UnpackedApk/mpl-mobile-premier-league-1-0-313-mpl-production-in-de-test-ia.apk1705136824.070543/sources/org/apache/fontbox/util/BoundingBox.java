package org.apache.fontbox.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class BoundingBox {
    public float lowerLeftX;
    public float lowerLeftY;
    public float upperRightX;
    public float upperRightY;

    public BoundingBox() {
    }

    public boolean contains(float f2, float f3) {
        return f2 >= this.lowerLeftX && f2 <= this.upperRightX && f3 >= this.lowerLeftY && f3 <= this.upperRightY;
    }

    public float getHeight() {
        return getUpperRightY() - getLowerLeftY();
    }

    public float getLowerLeftX() {
        return this.lowerLeftX;
    }

    public float getLowerLeftY() {
        return this.lowerLeftY;
    }

    public float getUpperRightX() {
        return this.upperRightX;
    }

    public float getUpperRightY() {
        return this.upperRightY;
    }

    public float getWidth() {
        return getUpperRightX() - getLowerLeftX();
    }

    public void setLowerLeftX(float f2) {
        this.lowerLeftX = f2;
    }

    public void setLowerLeftY(float f2) {
        this.lowerLeftY = f2;
    }

    public void setUpperRightX(float f2) {
        this.upperRightX = f2;
    }

    public void setUpperRightY(float f2) {
        this.upperRightY = f2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(getLowerLeftX());
        outline73.append(",");
        outline73.append(getLowerLeftY());
        outline73.append(",");
        outline73.append(getUpperRightX());
        outline73.append(",");
        outline73.append(getUpperRightY());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public BoundingBox(float f2, float f3, float f4, float f5) {
        this.lowerLeftX = f2;
        this.lowerLeftY = f3;
        this.upperRightX = f4;
        this.upperRightY = f5;
    }

    public BoundingBox(List<Number> list) {
        this.lowerLeftX = list.get(0).floatValue();
        this.lowerLeftY = list.get(1).floatValue();
        this.upperRightX = list.get(2).floatValue();
        this.upperRightY = list.get(3).floatValue();
    }
}
