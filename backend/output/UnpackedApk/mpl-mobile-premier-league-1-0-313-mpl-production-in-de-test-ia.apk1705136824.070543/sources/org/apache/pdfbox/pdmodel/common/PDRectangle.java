package org.apache.pdfbox.pdmodel.common;

import android.graphics.Path;
import android.graphics.PointF;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.util.Matrix;

public class PDRectangle implements COSObjectable {
    public static final PDRectangle A0 = new PDRectangle(2383.937f, 3370.3938f);
    public static final PDRectangle A1 = new PDRectangle(1683.7795f, 2383.937f);
    public static final PDRectangle A2 = new PDRectangle(1190.5513f, 1683.7795f);
    public static final PDRectangle A3 = new PDRectangle(841.8898f, 1190.5513f);
    public static final PDRectangle A4 = new PDRectangle(595.27563f, 841.8898f);
    public static final PDRectangle A5 = new PDRectangle(419.52756f, 595.27563f);
    public static final PDRectangle A6 = new PDRectangle(297.63782f, 419.52756f);
    public static final PDRectangle LEGAL = new PDRectangle(612.0f, 1008.0f);
    public static final PDRectangle LETTER = new PDRectangle(612.0f, 792.0f);
    public static final float MM_PER_INCH = 2.8346457f;
    public static final float POINTS_PER_INCH = 72.0f;
    public final COSArray rectArray;

    public PDRectangle() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public boolean contains(float f2, float f3) {
        return f2 >= getLowerLeftX() && f2 <= getUpperRightX() && f3 >= getLowerLeftY() && f3 <= getUpperRightY();
    }

    public PDRectangle createRetranslatedRectangle() {
        PDRectangle pDRectangle = new PDRectangle();
        pDRectangle.setUpperRightX(getWidth());
        pDRectangle.setUpperRightY(getHeight());
        return pDRectangle;
    }

    public COSArray getCOSArray() {
        return this.rectArray;
    }

    public COSBase getCOSObject() {
        return this.rectArray;
    }

    public float getHeight() {
        return getUpperRightY() - getLowerLeftY();
    }

    public float getLowerLeftX() {
        return ((COSNumber) this.rectArray.get(0)).floatValue();
    }

    public float getLowerLeftY() {
        return ((COSNumber) this.rectArray.get(1)).floatValue();
    }

    public float getUpperRightX() {
        return ((COSNumber) this.rectArray.get(2)).floatValue();
    }

    public float getUpperRightY() {
        return ((COSNumber) this.rectArray.get(3)).floatValue();
    }

    public float getWidth() {
        return getUpperRightX() - getLowerLeftX();
    }

    public void move(float f2, float f3) {
        setUpperRightX(getUpperRightX() + f2);
        setLowerLeftX(getLowerLeftX() + f2);
        setUpperRightY(getUpperRightY() + f3);
        setLowerLeftY(getLowerLeftY() + f3);
    }

    public void setLowerLeftX(float f2) {
        this.rectArray.set(0, (COSBase) new COSFloat(f2));
    }

    public void setLowerLeftY(float f2) {
        this.rectArray.set(1, (COSBase) new COSFloat(f2));
    }

    public void setUpperRightX(float f2) {
        this.rectArray.set(2, (COSBase) new COSFloat(f2));
    }

    public void setUpperRightY(float f2) {
        this.rectArray.set(3, (COSBase) new COSFloat(f2));
    }

    public Path toGeneralPath() {
        float lowerLeftX = getLowerLeftX();
        float lowerLeftY = getLowerLeftY();
        float upperRightX = getUpperRightX();
        float upperRightY = getUpperRightY();
        Path path = new Path();
        path.moveTo(lowerLeftX, lowerLeftY);
        path.lineTo(upperRightX, lowerLeftY);
        path.lineTo(upperRightX, upperRightY);
        path.lineTo(lowerLeftX, upperRightY);
        path.close();
        return path;
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

    public Path transform(Matrix matrix) {
        float lowerLeftX = getLowerLeftX();
        float lowerLeftY = getLowerLeftY();
        float upperRightX = getUpperRightX();
        float upperRightY = getUpperRightY();
        double d2 = (double) lowerLeftX;
        double d3 = (double) lowerLeftY;
        PointF transformPoint = matrix.transformPoint(d2, d3);
        double d4 = (double) upperRightX;
        PointF transformPoint2 = matrix.transformPoint(d4, d3);
        double d5 = (double) upperRightY;
        PointF transformPoint3 = matrix.transformPoint(d4, d5);
        PointF transformPoint4 = matrix.transformPoint(d2, d5);
        Path path = new Path();
        path.moveTo(transformPoint.x, transformPoint.y);
        path.lineTo(transformPoint2.x, transformPoint2.y);
        path.lineTo(transformPoint3.x, transformPoint3.y);
        path.lineTo(transformPoint4.x, transformPoint4.y);
        path.close();
        return path;
    }

    public PDRectangle(float f2, float f3) {
        this(0.0f, 0.0f, f2, f3);
    }

    public PDRectangle(float f2, float f3, float f4, float f5) {
        COSArray cOSArray = new COSArray();
        this.rectArray = cOSArray;
        GeneratedOutlineSupport.outline91(f2, cOSArray);
        GeneratedOutlineSupport.outline91(f3, this.rectArray);
        this.rectArray.add((COSBase) new COSFloat(f2 + f4));
        this.rectArray.add((COSBase) new COSFloat(f3 + f5));
    }

    public PDRectangle(BoundingBox boundingBox) {
        COSArray cOSArray = new COSArray();
        this.rectArray = cOSArray;
        cOSArray.add((COSBase) new COSFloat(boundingBox.getLowerLeftX()));
        this.rectArray.add((COSBase) new COSFloat(boundingBox.getLowerLeftY()));
        this.rectArray.add((COSBase) new COSFloat(boundingBox.getUpperRightX()));
        this.rectArray.add((COSBase) new COSFloat(boundingBox.getUpperRightY()));
    }

    public PDRectangle(COSArray cOSArray) {
        float[] floatArray = cOSArray.toFloatArray();
        COSArray cOSArray2 = new COSArray();
        this.rectArray = cOSArray2;
        cOSArray2.add((COSBase) new COSFloat(Math.min(floatArray[0], floatArray[2])));
        this.rectArray.add((COSBase) new COSFloat(Math.min(floatArray[1], floatArray[3])));
        this.rectArray.add((COSBase) new COSFloat(Math.max(floatArray[0], floatArray[2])));
        this.rectArray.add((COSBase) new COSFloat(Math.max(floatArray[1], floatArray[3])));
    }
}
