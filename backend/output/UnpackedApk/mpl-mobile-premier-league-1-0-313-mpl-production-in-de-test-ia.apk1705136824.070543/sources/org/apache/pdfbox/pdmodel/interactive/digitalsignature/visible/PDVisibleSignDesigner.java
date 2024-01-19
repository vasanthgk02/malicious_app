package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDVisibleSignDesigner {
    public byte[] AffineTransformParams = {1, 0, 0, 1, 0, 0};
    public byte[] formaterRectangleParams = {0, 0, 100, 50};
    public Float imageHeight;
    public float imageSizeInPercents;
    public Float imageWidth;
    public float pageHeight;
    public float pageWidth;
    public String signatureFieldName = "sig";
    public float xAxis;
    public float yAxis;

    private void calculatePageSize(PDDocument pDDocument, int i) {
        if (i >= 1) {
            PDRectangle mediaBox = pDDocument.getPage(i - 1).getMediaBox();
            pageHeight(mediaBox.getHeight());
            float width = mediaBox.getWidth();
            this.pageWidth = width;
            this.pageWidth = width + 0.0f;
            this.imageSizeInPercents = 100.0f - (0.0f / (width + 0.0f));
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("First page of pdf is 1, not ", i));
    }

    private PDVisibleSignDesigner pageHeight(float f2) {
        this.pageHeight = f2;
        return this;
    }

    public PDVisibleSignDesigner affineTransformParams(byte[] bArr) {
        this.AffineTransformParams = bArr;
        return this;
    }

    public PDVisibleSignDesigner coordinates(float f2, float f3) {
        xAxis(f2);
        yAxis(f3);
        return this;
    }

    public PDVisibleSignDesigner formaterRectangleParams(byte[] bArr) {
        this.formaterRectangleParams = bArr;
        return this;
    }

    public byte[] getAffineTransformParams() {
        return this.AffineTransformParams;
    }

    public byte[] getFormaterRectangleParams() {
        return this.formaterRectangleParams;
    }

    public float getHeight() {
        return this.imageHeight.floatValue();
    }

    public float getImageSizeInPercents() {
        return this.imageSizeInPercents;
    }

    public float getPageHeight() {
        return this.pageHeight;
    }

    public float getPageWidth() {
        return this.pageWidth;
    }

    public String getSignatureFieldName() {
        return this.signatureFieldName;
    }

    public String getSignatureText() {
        throw new UnsupportedOperationException("That method is not yet implemented");
    }

    public float getTemplateHeight() {
        return getPageHeight();
    }

    public float getWidth() {
        return this.imageWidth.floatValue();
    }

    public float getxAxis() {
        return this.xAxis;
    }

    public float getyAxis() {
        return this.yAxis;
    }

    public PDVisibleSignDesigner height(float f2) {
        this.imageHeight = Float.valueOf(f2);
        return this;
    }

    public void imageSizeInPercents(float f2) {
        this.imageSizeInPercents = f2;
    }

    public PDVisibleSignDesigner pageWidth(float f2) {
        this.pageWidth = f2;
        return this;
    }

    public PDVisibleSignDesigner signatureFieldName(String str) {
        this.signatureFieldName = str;
        return this;
    }

    public PDVisibleSignDesigner signatureText(String str) {
        throw new UnsupportedOperationException("That method is not yet implemented");
    }

    public PDVisibleSignDesigner width(float f2) {
        this.imageWidth = Float.valueOf(f2);
        return this;
    }

    public PDVisibleSignDesigner xAxis(float f2) {
        this.xAxis = f2;
        return this;
    }

    public PDVisibleSignDesigner yAxis(float f2) {
        this.yAxis = f2;
        return this;
    }

    public PDVisibleSignDesigner zoom(float f2) {
        this.imageHeight = Float.valueOf(((this.imageHeight.floatValue() * f2) / 100.0f) + this.imageHeight.floatValue());
        this.imageWidth = Float.valueOf(((this.imageWidth.floatValue() * f2) / 100.0f) + this.imageWidth.floatValue());
        return this;
    }
}
