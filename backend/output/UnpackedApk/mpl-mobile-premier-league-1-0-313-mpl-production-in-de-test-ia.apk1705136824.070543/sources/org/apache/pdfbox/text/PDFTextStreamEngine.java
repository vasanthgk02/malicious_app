package org.apache.pdfbox.text;

import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.contentstream.operator.state.Concatenate;
import org.apache.pdfbox.contentstream.operator.state.Restore;
import org.apache.pdfbox.contentstream.operator.state.Save;
import org.apache.pdfbox.contentstream.operator.state.SetGraphicsStateParameters;
import org.apache.pdfbox.contentstream.operator.state.SetMatrix;
import org.apache.pdfbox.contentstream.operator.text.BeginText;
import org.apache.pdfbox.contentstream.operator.text.EndText;
import org.apache.pdfbox.contentstream.operator.text.MoveText;
import org.apache.pdfbox.contentstream.operator.text.MoveTextSetLeading;
import org.apache.pdfbox.contentstream.operator.text.NextLine;
import org.apache.pdfbox.contentstream.operator.text.SetCharSpacing;
import org.apache.pdfbox.contentstream.operator.text.SetFontAndSize;
import org.apache.pdfbox.contentstream.operator.text.SetTextHorizontalScaling;
import org.apache.pdfbox.contentstream.operator.text.SetTextLeading;
import org.apache.pdfbox.contentstream.operator.text.SetTextRenderingMode;
import org.apache.pdfbox.contentstream.operator.text.SetTextRise;
import org.apache.pdfbox.contentstream.operator.text.SetWordSpacing;
import org.apache.pdfbox.contentstream.operator.text.ShowText;
import org.apache.pdfbox.contentstream.operator.text.ShowTextAdjusted;
import org.apache.pdfbox.contentstream.operator.text.ShowTextLine;
import org.apache.pdfbox.contentstream.operator.text.ShowTextLineAndSpace;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.PDFBoxResourceLoader;
import org.apache.pdfbox.util.Vector;

public class PDFTextStreamEngine extends PDFStreamEngine {
    public final GlyphList glyphList;
    public Matrix legacyCTM;
    public int pageRotation;
    public PDRectangle pageSize;

    public PDFTextStreamEngine() throws IOException {
        InputStream inputStream;
        Class<GlyphList> cls = GlyphList.class;
        addOperator(new BeginText());
        addOperator(new Concatenate());
        addOperator(new DrawObject());
        addOperator(new EndText());
        addOperator(new SetGraphicsStateParameters());
        addOperator(new Save());
        addOperator(new Restore());
        addOperator(new NextLine());
        addOperator(new SetCharSpacing());
        addOperator(new MoveText());
        addOperator(new MoveTextSetLeading());
        addOperator(new SetFontAndSize());
        addOperator(new ShowText());
        addOperator(new ShowTextAdjusted());
        addOperator(new SetTextLeading());
        addOperator(new SetMatrix());
        addOperator(new SetTextRenderingMode());
        addOperator(new SetTextRise());
        addOperator(new SetWordSpacing());
        addOperator(new SetTextHorizontalScaling());
        addOperator(new ShowTextLine());
        addOperator(new ShowTextLineAndSpace());
        if (PDFBoxResourceLoader.isReady()) {
            inputStream = cls.getClassLoader().getResourceAsStream("org/apache/pdfbox/resources/glyphlist/additional.txt");
        } else {
            inputStream = cls.getClassLoader().getResourceAsStream("org/apache/pdfbox/resources/glyphlist/additional.txt");
        }
        this.glyphList = new GlyphList(GlyphList.getAdobeGlyphList(), inputStream);
    }

    public void processPage(PDPage pDPage) throws IOException {
        this.pageRotation = pDPage.getRotation();
        this.pageSize = pDPage.getCropBox();
        super.processPage(pDPage);
    }

    public void processTextPosition(TextPosition textPosition) {
    }

    public void showGlyph(Matrix matrix, PDFont pDFont, int i, String str, Vector vector) throws IOException {
        float f2;
        String str2;
        PDFont pDFont2 = pDFont;
        int i2 = i;
        PDGraphicsState graphicsState = getGraphicsState();
        Matrix matrix2 = this.legacyCTM;
        float fontSize = graphicsState.getTextState().getFontSize();
        Matrix textMatrix = getTextMatrix();
        float f3 = pDFont.getFontMatrix().transformPoint(0.0d, (double) (pDFont.getBoundingBox().getHeight() / 2.0f)).y;
        Matrix multiply = Matrix.getTranslateInstance(vector.getX() * fontSize * (graphicsState.getTextState().getHorizontalScaling() / 100.0f), 0.0f).multiply(textMatrix).multiply(matrix2);
        float translateX = multiply.getTranslateX();
        float translateY = multiply.getTranslateY();
        float translateX2 = translateX - matrix.getTranslateX();
        float scalingFactorY = matrix.getScalingFactorY() * f3;
        float fontSize2 = getGraphicsState().getTextState().getFontSize();
        float horizontalScaling = getGraphicsState().getTextState().getHorizontalScaling() / 100.0f;
        float f4 = 1.0f;
        float scaleX = pDFont2 instanceof PDType3Font ? 1.0f / pDFont.getFontMatrix().getScaleX() : 0.001f;
        try {
            f2 = pDFont.getSpaceWidth() * scaleX;
        } catch (Throwable th) {
            th.getMessage();
            f2 = 0.0f;
        }
        if (f2 == 0.0f) {
            f2 = pDFont.getAverageFontWidth() * scaleX * 0.8f;
        }
        if (f2 != 0.0f) {
            f4 = f2;
        }
        float scalingFactorX = matrix.getScalingFactorX() * f4 * fontSize2 * horizontalScaling * matrix2.getScalingFactorX();
        String unicode = pDFont2.toUnicode(i2, this.glyphList);
        if (unicode != null) {
            str2 = unicode;
        } else if (pDFont2 instanceof PDSimpleFont) {
            str2 = new String(new char[]{(char) i2});
        } else {
            return;
        }
        float f5 = translateY;
        float f6 = scalingFactorY;
        float f7 = scalingFactorX;
        TextPosition textPosition = r2;
        TextPosition textPosition2 = new TextPosition(this.pageRotation, this.pageSize.getWidth(), this.pageSize.getHeight(), matrix, translateX, f5, f6, translateX2, f7, str2, new int[]{i2}, pDFont, fontSize, (int) (matrix.getScalingFactorX() * fontSize));
        processTextPosition(textPosition);
    }

    public void showText(byte[] bArr) throws IOException {
        this.legacyCTM = getGraphicsState().getCurrentTransformationMatrix().clone();
        super.showText(bArr);
    }
}
