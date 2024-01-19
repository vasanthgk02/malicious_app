package org.apache.pdfbox.pdmodel.graphics.state;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;

public class PDGraphicsState implements Cloneable {
    public double alphaConstant;
    public boolean alphaSource;
    public BlendMode blendMode;
    public Region clippingPath;
    public Matrix currentTransformationMatrix = new Matrix();
    public double flatness;
    public boolean isClippingPathDirty;
    public Cap lineCap;
    public PDLineDashPattern lineDashPattern;
    public Join lineJoin;
    public float lineWidth;
    public float miterLimit;
    public double nonStrokingAlphaConstant;
    public PDColor nonStrokingColor = PDDeviceGray.INSTANCE.getInitialColor();
    public PDColorSpace nonStrokingColorSpace;
    public boolean overprint;
    public double overprintMode;
    public RenderingIntent renderingIntent;
    public double smoothness;
    public PDSoftMask softMask;
    public boolean strokeAdjustment;
    public PDColor strokingColor = PDDeviceGray.INSTANCE.getInitialColor();
    public PDColorSpace strokingColorSpace;
    public PDTextState textState;

    public PDGraphicsState(PDRectangle pDRectangle) {
        PDDeviceGray pDDeviceGray = PDDeviceGray.INSTANCE;
        this.strokingColorSpace = pDDeviceGray;
        this.nonStrokingColorSpace = pDDeviceGray;
        this.textState = new PDTextState();
        this.lineWidth = 1.0f;
        this.miterLimit = 10.0f;
        this.lineDashPattern = new PDLineDashPattern();
        this.strokeAdjustment = false;
        this.blendMode = BlendMode.COMPATIBLE;
        this.alphaConstant = 1.0d;
        this.nonStrokingAlphaConstant = 1.0d;
        this.alphaSource = false;
        this.overprint = false;
        this.overprintMode = 0.0d;
        this.flatness = 1.0d;
        this.smoothness = 0.0d;
        RectF rectF = new RectF();
        pDRectangle.toGeneralPath().computeBounds(rectF, true);
        this.clippingPath = new Region();
        Rect rect = new Rect();
        rectF.round(rect);
        this.clippingPath.setPath(pDRectangle.toGeneralPath(), new Region(rect));
    }

    public double getAlphaConstant() {
        return this.alphaConstant;
    }

    public BlendMode getBlendMode() {
        return this.blendMode;
    }

    public Region getCurrentClippingPath() {
        return this.clippingPath;
    }

    public Matrix getCurrentTransformationMatrix() {
        return this.currentTransformationMatrix;
    }

    public double getFlatness() {
        return this.flatness;
    }

    public Cap getLineCap() {
        return this.lineCap;
    }

    public PDLineDashPattern getLineDashPattern() {
        return this.lineDashPattern;
    }

    public Join getLineJoin() {
        return this.lineJoin;
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }

    public double getNonStrokeAlphaConstant() {
        return this.nonStrokingAlphaConstant;
    }

    public PDColor getNonStrokingColor() {
        return this.nonStrokingColor;
    }

    public PDColorSpace getNonStrokingColorSpace() {
        return this.nonStrokingColorSpace;
    }

    public double getOverprintMode() {
        return this.overprintMode;
    }

    public RenderingIntent getRenderingIntent() {
        return this.renderingIntent;
    }

    public double getSmoothness() {
        return this.smoothness;
    }

    public PDSoftMask getSoftMask() {
        return this.softMask;
    }

    public PDColor getStrokingColor() {
        return this.strokingColor;
    }

    public PDColorSpace getStrokingColorSpace() {
        return this.strokingColorSpace;
    }

    public PDTextState getTextState() {
        return this.textState;
    }

    public void intersectClippingPath(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        Region region = new Region();
        Rect rect = new Rect();
        rectF.round(rect);
        region.setPath(path, new Region(rect));
        intersectClippingPath(region);
    }

    public boolean isAlphaSource() {
        return this.alphaSource;
    }

    public boolean isOverprint() {
        return this.overprint;
    }

    public boolean isStrokeAdjustment() {
        return this.strokeAdjustment;
    }

    public void setAlphaConstant(double d2) {
        this.alphaConstant = d2;
    }

    public void setAlphaSource(boolean z) {
        this.alphaSource = z;
    }

    public void setBlendMode(BlendMode blendMode2) {
        this.blendMode = blendMode2;
    }

    public void setCurrentTransformationMatrix(Matrix matrix) {
        this.currentTransformationMatrix = matrix;
    }

    public void setFlatness(double d2) {
        this.flatness = d2;
    }

    public void setLineCap(Cap cap) {
        this.lineCap = cap;
    }

    public void setLineDashPattern(PDLineDashPattern pDLineDashPattern) {
        this.lineDashPattern = pDLineDashPattern;
    }

    public void setLineJoin(Join join) {
        this.lineJoin = join;
    }

    public void setLineWidth(float f2) {
        this.lineWidth = f2;
    }

    public void setMiterLimit(float f2) {
        this.miterLimit = f2;
    }

    public void setNonStrokeAlphaConstant(double d2) {
        this.nonStrokingAlphaConstant = d2;
    }

    public void setNonStrokingColor(PDColor pDColor) {
        this.nonStrokingColor = pDColor;
    }

    public void setNonStrokingColorSpace(PDColorSpace pDColorSpace) {
        this.nonStrokingColorSpace = pDColorSpace;
    }

    public void setOverprint(boolean z) {
        this.overprint = z;
    }

    public void setOverprintMode(double d2) {
        this.overprintMode = d2;
    }

    public void setRenderingIntent(RenderingIntent renderingIntent2) {
        this.renderingIntent = renderingIntent2;
    }

    public void setSmoothness(double d2) {
        this.smoothness = d2;
    }

    public void setSoftMask(PDSoftMask pDSoftMask) {
        this.softMask = pDSoftMask;
    }

    public void setStrokeAdjustment(boolean z) {
        this.strokeAdjustment = z;
    }

    public void setStrokingColor(PDColor pDColor) {
        this.strokingColor = pDColor;
    }

    public void setStrokingColorSpace(PDColorSpace pDColorSpace) {
        this.strokingColorSpace = pDColorSpace;
    }

    public void setTextState(PDTextState pDTextState) {
        this.textState = pDTextState;
    }

    public PDGraphicsState clone() {
        try {
            PDGraphicsState pDGraphicsState = (PDGraphicsState) super.clone();
            pDGraphicsState.textState = this.textState.clone();
            pDGraphicsState.currentTransformationMatrix = this.currentTransformationMatrix.clone();
            pDGraphicsState.strokingColor = this.strokingColor;
            pDGraphicsState.nonStrokingColor = this.nonStrokingColor;
            pDGraphicsState.lineDashPattern = this.lineDashPattern;
            pDGraphicsState.clippingPath = this.clippingPath;
            pDGraphicsState.isClippingPathDirty = false;
            return pDGraphicsState;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void intersectClippingPath(Region region) {
        if (!this.isClippingPathDirty) {
            this.clippingPath = new Region(region);
            this.isClippingPathDirty = true;
        }
        this.clippingPath.op(region, Op.INTERSECT);
    }
}
