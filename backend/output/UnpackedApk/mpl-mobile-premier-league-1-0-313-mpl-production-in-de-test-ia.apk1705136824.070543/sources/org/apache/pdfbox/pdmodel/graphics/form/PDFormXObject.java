package org.apache.pdfbox.pdmodel.graphics.form;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.awt.AffineTransform;

public class PDFormXObject extends PDXObject implements PDContentStream {
    public PDGroup group;
    public String name;

    public PDFormXObject(PDStream pDStream) {
        super(pDStream, COSName.FORM);
    }

    public PDRectangle getBBox() {
        COSArray cOSArray = (COSArray) getCOSStream().getDictionaryObject(COSName.BBOX);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public COSStream getContentStream() {
        return getCOSStream();
    }

    public int getFormType() {
        return getCOSStream().getInt(COSName.FORMTYPE, 1);
    }

    public PDGroup getGroup() {
        if (this.group == null) {
            COSDictionary cOSDictionary = (COSDictionary) getCOSStream().getDictionaryObject(COSName.GROUP);
            if (cOSDictionary != null) {
                this.group = new PDGroup(cOSDictionary);
            }
        }
        return this.group;
    }

    public Matrix getMatrix() {
        COSArray cOSArray = (COSArray) getCOSStream().getDictionaryObject(COSName.MATRIX);
        if (cOSArray != null) {
            return new Matrix(cOSArray);
        }
        return new Matrix();
    }

    public PDResources getResources() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSStream().getDictionaryObject(COSName.RESOURCES);
        if (cOSDictionary != null) {
            return new PDResources(cOSDictionary);
        }
        return null;
    }

    public int getStructParents() {
        return getCOSStream().getInt(COSName.STRUCT_PARENTS, 0);
    }

    public void setBBox(PDRectangle pDRectangle) {
        if (pDRectangle == null) {
            getCOSStream().removeItem(COSName.BBOX);
        } else {
            getCOSStream().setItem(COSName.BBOX, (COSBase) pDRectangle.getCOSArray());
        }
    }

    public void setFormType(int i) {
        getCOSStream().setInt(COSName.FORMTYPE, i);
    }

    public void setMatrix(AffineTransform affineTransform) {
        COSArray cOSArray = new COSArray();
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        for (int i = 0; i < 6; i++) {
            cOSArray.add((COSBase) new COSFloat((float) dArr[i]));
        }
        getCOSStream().setItem(COSName.MATRIX, (COSBase) cOSArray);
    }

    public void setResources(PDResources pDResources) {
        getCOSStream().setItem(COSName.RESOURCES, (COSObjectable) pDResources);
    }

    public void setStructParents(int i) {
        getCOSStream().setInt(COSName.STRUCT_PARENTS, i);
    }

    public PDFormXObject(PDStream pDStream, String str) {
        super(pDStream, COSName.FORM);
        this.name = str;
    }

    public PDFormXObject(PDDocument pDDocument) {
        super(pDDocument, COSName.FORM);
    }
}
