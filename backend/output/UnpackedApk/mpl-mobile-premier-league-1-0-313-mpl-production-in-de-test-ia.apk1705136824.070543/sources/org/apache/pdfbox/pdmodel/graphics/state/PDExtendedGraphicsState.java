package org.apache.pdfbox.pdmodel.graphics.state;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.PDFontSetting;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;

public class PDExtendedGraphicsState implements COSObjectable {
    public final COSDictionary dict;

    public PDExtendedGraphicsState() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dict = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.EXT_G_STATE);
    }

    private Float getFloatItem(COSName cOSName) {
        COSNumber cOSNumber = (COSNumber) this.dict.getDictionaryObject(cOSName);
        if (cOSNumber != null) {
            return Float.valueOf(cOSNumber.floatValue());
        }
        return null;
    }

    private void setFloatItem(COSName cOSName, Float f2) {
        if (f2 == null) {
            this.dict.removeItem(cOSName);
        } else {
            this.dict.setItem(cOSName, (COSBase) new COSFloat(f2.floatValue()));
        }
    }

    public void copyIntoGraphicsState(PDGraphicsState pDGraphicsState) throws IOException {
        for (COSName next : this.dict.keySet()) {
            if (next.equals(COSName.LW)) {
                pDGraphicsState.setLineWidth(getLineWidth().floatValue());
            } else if (next.equals(COSName.LC)) {
                pDGraphicsState.setLineCap(getLineCapStyle());
            } else if (next.equals(COSName.LJ)) {
                pDGraphicsState.setLineJoin(getLineJoinStyle());
            } else if (next.equals(COSName.ML)) {
                pDGraphicsState.setMiterLimit(getMiterLimit().floatValue());
            } else if (next.equals(COSName.D)) {
                pDGraphicsState.setLineDashPattern(getLineDashPattern());
            } else if (next.equals(COSName.RI)) {
                pDGraphicsState.setRenderingIntent(getRenderingIntent());
            } else if (next.equals(COSName.OPM)) {
                pDGraphicsState.setOverprintMode(getOverprintMode().doubleValue());
            } else if (next.equals(COSName.FONT)) {
                PDFontSetting fontSetting = getFontSetting();
                if (fontSetting != null) {
                    pDGraphicsState.getTextState().setFont(fontSetting.getFont());
                    pDGraphicsState.getTextState().setFontSize(fontSetting.getFontSize());
                }
            } else if (next.equals(COSName.FL)) {
                pDGraphicsState.setFlatness((double) getFlatnessTolerance().floatValue());
            } else if (next.equals(COSName.SM)) {
                pDGraphicsState.setSmoothness((double) getSmoothnessTolerance().floatValue());
            } else if (next.equals(COSName.SA)) {
                pDGraphicsState.setStrokeAdjustment(getAutomaticStrokeAdjustment());
            } else if (next.equals(COSName.CA)) {
                pDGraphicsState.setAlphaConstant((double) getStrokingAlphaConstant().floatValue());
            } else if (next.equals(COSName.CA_NS)) {
                pDGraphicsState.setNonStrokeAlphaConstant((double) getNonStrokingAlphaConstant().floatValue());
            } else if (next.equals(COSName.AIS)) {
                pDGraphicsState.setAlphaSource(getAlphaSourceFlag());
            } else if (next.equals(COSName.TK)) {
                pDGraphicsState.getTextState().setKnockoutFlag(getTextKnockoutFlag());
            } else if (next.equals(COSName.SMASK)) {
                pDGraphicsState.setSoftMask(getSoftMask());
            } else if (next.equals(COSName.BM)) {
                pDGraphicsState.setBlendMode(getBlendMode());
            }
        }
    }

    public boolean getAlphaSourceFlag() {
        return this.dict.getBoolean(COSName.AIS, false);
    }

    public boolean getAutomaticStrokeAdjustment() {
        return this.dict.getBoolean(COSName.SA, false);
    }

    public BlendMode getBlendMode() {
        return BlendMode.getInstance(this.dict.getDictionaryObject(COSName.BM));
    }

    public COSDictionary getCOSDictionary() {
        return this.dict;
    }

    public COSBase getCOSObject() {
        return this.dict;
    }

    public Float getFlatnessTolerance() {
        return getFloatItem(COSName.FL);
    }

    public PDFontSetting getFontSetting() {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.FONT);
        if (dictionaryObject instanceof COSArray) {
            return new PDFontSetting((COSArray) dictionaryObject);
        }
        return null;
    }

    public Cap getLineCapStyle() {
        int i = this.dict.getInt(COSName.LC);
        if (i == 0) {
            return Cap.BUTT;
        }
        if (i == 1) {
            return Cap.ROUND;
        }
        if (i != 2) {
            return null;
        }
        return Cap.SQUARE;
    }

    public PDLineDashPattern getLineDashPattern() {
        COSArray cOSArray = (COSArray) this.dict.getDictionaryObject(COSName.D);
        if (cOSArray == null) {
            return null;
        }
        COSArray cOSArray2 = new COSArray();
        cOSArray.addAll(cOSArray);
        cOSArray.remove(cOSArray.size() - 1);
        return new PDLineDashPattern(cOSArray2, cOSArray.getInt(cOSArray.size() - 1));
    }

    public Join getLineJoinStyle() {
        int i = this.dict.getInt(COSName.LJ);
        if (i == 0) {
            return Join.MITER;
        }
        if (i == 1) {
            return Join.ROUND;
        }
        if (i != 2) {
            return null;
        }
        return Join.BEVEL;
    }

    public Float getLineWidth() {
        return getFloatItem(COSName.LW);
    }

    public Float getMiterLimit() {
        return getFloatItem(COSName.ML);
    }

    public Float getNonStrokingAlphaConstant() {
        return getFloatItem(COSName.CA_NS);
    }

    public boolean getNonStrokingOverprintControl() {
        return this.dict.getBoolean(COSName.OP_NS, getStrokingOverprintControl());
    }

    public Float getOverprintMode() {
        return getFloatItem(COSName.OPM);
    }

    public RenderingIntent getRenderingIntent() {
        String nameAsString = this.dict.getNameAsString((String) "RI");
        if (nameAsString != null) {
            return RenderingIntent.fromString(nameAsString);
        }
        return null;
    }

    public Float getSmoothnessTolerance() {
        return getFloatItem(COSName.SM);
    }

    public PDSoftMask getSoftMask() {
        return PDSoftMask.create(this.dict.getDictionaryObject(COSName.SMASK));
    }

    public Float getStrokingAlphaConstant() {
        return getFloatItem(COSName.CA);
    }

    public boolean getStrokingOverprintControl() {
        return this.dict.getBoolean(COSName.OP, false);
    }

    public boolean getTextKnockoutFlag() {
        return this.dict.getBoolean(COSName.TK, true);
    }

    public void setAlphaSourceFlag(boolean z) {
        this.dict.setBoolean(COSName.AIS, z);
    }

    public void setAutomaticStrokeAdjustment(boolean z) {
        this.dict.setBoolean(COSName.SA, z);
    }

    public void setFlatnessTolerance(Float f2) {
        setFloatItem(COSName.FL, f2);
    }

    public void setFontSetting(PDFontSetting pDFontSetting) {
        this.dict.setItem(COSName.FONT, (COSObjectable) pDFontSetting);
    }

    public void setLineCapStyle(int i) {
        this.dict.setInt(COSName.LC, i);
    }

    public void setLineDashPattern(PDLineDashPattern pDLineDashPattern) {
        this.dict.setItem(COSName.D, pDLineDashPattern.getCOSObject());
    }

    public void setLineJoinStyle(int i) {
        this.dict.setInt(COSName.LJ, i);
    }

    public void setLineWidth(Float f2) {
        setFloatItem(COSName.LW, f2);
    }

    public void setMiterLimit(Float f2) {
        setFloatItem(COSName.ML, f2);
    }

    public void setNonStrokingAlphaConstant(Float f2) {
        setFloatItem(COSName.CA_NS, f2);
    }

    public void setNonStrokingOverprintControl(boolean z) {
        this.dict.setBoolean(COSName.OP_NS, z);
    }

    public void setOverprintMode(Float f2) {
        setFloatItem(COSName.OPM, f2);
    }

    public void setRenderingIntent(String str) {
        this.dict.setName((String) "RI", str);
    }

    public void setSmoothnessTolerance(Float f2) {
        setFloatItem(COSName.SM, f2);
    }

    public void setStrokingAlphaConstant(Float f2) {
        setFloatItem(COSName.CA, f2);
    }

    public void setStrokingOverprintControl(boolean z) {
        this.dict.setBoolean(COSName.OP, z);
    }

    public void setTextKnockoutFlag(boolean z) {
        this.dict.setBoolean(COSName.TK, z);
    }

    public PDExtendedGraphicsState(COSDictionary cOSDictionary) {
        this.dict = cOSDictionary;
    }
}
