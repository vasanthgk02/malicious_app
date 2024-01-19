package org.apache.pdfbox.pdmodel;

import android.graphics.Path.FillType;
import com.netcore.android.utility.f;
import com.userexperior.e.h;
import com.userexperior.utilities.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.common.COSStreamArray;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.util.Charsets;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.awt.AWTColor;
import org.apache.pdfbox.util.awt.AffineTransform;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public final class PDPageContentStream implements Closeable {
    public final PDDocument document;
    public final Stack<PDFont> fontStack;
    public final NumberFormat formatDecimal;
    public boolean inTextMode;
    public final Stack<PDColorSpace> nonStrokingColorSpaceStack;
    public OutputStream output;
    public PDResources resources;
    public Stack<PDColorSpace> strokingColorSpaceStack;

    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage) throws IOException {
        this(pDDocument, pDPage, false, true);
    }

    private COSName getName(PDColorSpace pDColorSpace) throws IOException {
        if ((pDColorSpace instanceof PDDeviceGray) || (pDColorSpace instanceof PDDeviceRGB)) {
            return COSName.getPDFName(pDColorSpace.getName());
        }
        return this.resources.add(pDColorSpace);
    }

    private void write(String str) throws IOException {
        this.output.write(str.getBytes(Charsets.US_ASCII));
    }

    private void writeAffineTransform(AffineTransform affineTransform) throws IOException {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        for (int i = 0; i < 6; i++) {
            writeOperand((float) dArr[i]);
        }
    }

    private void writeBytes(byte[] bArr) throws IOException {
        this.output.write(bArr);
    }

    private void writeLine() throws IOException {
        this.output.write(10);
    }

    private void writeOperand(float f2) throws IOException {
        writeOperator(this.formatDecimal.format((double) f2));
        this.output.write(32);
    }

    private void writeOperator(String str) throws IOException {
        this.output.write(str.getBytes(Charsets.US_ASCII));
        this.output.write(10);
    }

    @Deprecated
    public void addBezier31(float f2, float f3, float f4, float f5) throws IOException {
        curveTo1(f2, f3, f4, f5);
    }

    @Deprecated
    public void addBezier312(float f2, float f3, float f4, float f5, float f6, float f7) throws IOException {
        curveTo(f2, f3, f4, f5, f6, f7);
    }

    @Deprecated
    public void addBezier32(float f2, float f3, float f4, float f5) throws IOException {
        curveTo2(f2, f3, f4, f5);
    }

    @Deprecated
    public void addLine(float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            moveTo(f2, f3);
            lineTo(f4, f5);
            return;
        }
        throw new IOException("Error: addLine is not allowed within a text block.");
    }

    @Deprecated
    public void addPolygon(float[] fArr, float[] fArr2) throws IOException {
        if (this.inTextMode) {
            throw new IOException("Error: addPolygon is not allowed within a text block.");
        } else if (fArr.length == fArr2.length) {
            for (int i = 0; i < fArr.length; i++) {
                if (i == 0) {
                    moveTo(fArr[i], fArr2[i]);
                } else {
                    lineTo(fArr[i], fArr2[i]);
                }
            }
            closeSubPath();
        } else {
            throw new IOException("Error: some points are missing coordinate");
        }
    }

    public void addRect(float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperand(f5);
            writeOperator("re");
            return;
        }
        throw new IOException("Error: addRect is not allowed within a text block.");
    }

    @Deprecated
    public void appendCOSName(COSName cOSName) throws IOException {
        cOSName.writePDF(this.output);
    }

    @Deprecated
    public void appendRawCommands(String str) throws IOException {
        this.output.write(str.getBytes(Charsets.US_ASCII));
    }

    public void beginMarkedContent(COSName cOSName) throws IOException {
        writeOperand(cOSName);
        writeOperator("BMC");
    }

    @Deprecated
    public void beginMarkedContentSequence(COSName cOSName) throws IOException {
        beginMarkedContent(cOSName);
    }

    public void beginText() throws IOException {
        if (!this.inTextMode) {
            writeOperator("BT");
            this.inTextMode = true;
            return;
        }
        throw new IOException("Error: Nested beginText() calls are not allowed.");
    }

    public void clip() throws IOException {
        if (!this.inTextMode) {
            writeOperator("W");
            writeOperator("n");
            return;
        }
        throw new IOException("Error: clip is not allowed within a text block.");
    }

    public void clipEvenOdd() throws IOException {
        if (!this.inTextMode) {
            writeOperator("W*");
            writeOperator("n");
            return;
        }
        throw new IOException("Error: clipEvenOdd is not allowed within a text block.");
    }

    @Deprecated
    public void clipPath(FillType fillType) throws IOException {
        if (!this.inTextMode) {
            if (fillType == FillType.WINDING) {
                writeOperator("W");
            } else if (fillType == FillType.EVEN_ODD) {
                writeOperator("W");
            } else {
                throw new IOException("Error: unknown value for winding rule");
            }
            writeOperator("n");
            return;
        }
        throw new IOException("Error: clipPath is not allowed within a text block.");
    }

    public void close() throws IOException {
        this.output.close();
    }

    public void closeAndStroke() throws IOException {
        if (!this.inTextMode) {
            writeOperator("s");
            return;
        }
        throw new IOException("Error: closeAndStroke is not allowed within a text block.");
    }

    public void closePath() throws IOException {
        if (!this.inTextMode) {
            writeOperator(h.f3998a);
            return;
        }
        throw new IOException("Error: closePath is not allowed within a text block.");
    }

    @Deprecated
    public void closeSubPath() throws IOException {
        closePath();
    }

    @Deprecated
    public void concatenate2CTM(double d2, double d3, double d4, double d5, double d6, double d7) throws IOException {
        Matrix matrix = new Matrix((float) d2, (float) d3, (float) d4, (float) d5, (float) d6, (float) d7);
        transform(matrix);
    }

    public void curveTo(float f2, float f3, float f4, float f5, float f6, float f7) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperand(f5);
            writeOperand(f6);
            writeOperand(f7);
            writeOperator("c");
            return;
        }
        throw new IOException("Error: curveTo is not allowed within a text block.");
    }

    public void curveTo1(float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperand(f5);
            writeOperator("y");
            return;
        }
        throw new IOException("Error: curveTo1 is not allowed within a text block.");
    }

    public void curveTo2(float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperand(f5);
            writeOperator("v");
            return;
        }
        throw new IOException("Error: curveTo2 is not allowed within a text block.");
    }

    public void drawForm(PDFormXObject pDFormXObject) throws IOException {
        if (!this.inTextMode) {
            writeOperand(this.resources.add(pDFormXObject));
            writeOperator("Do");
            return;
        }
        throw new IOException("Error: drawForm is not allowed within a text block.");
    }

    public void drawImage(PDImageXObject pDImageXObject, float f2, float f3) throws IOException {
        drawImage(pDImageXObject, f2, f3, (float) pDImageXObject.getWidth(), (float) pDImageXObject.getHeight());
    }

    @Deprecated
    public void drawLine(float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            moveTo(f2, f3);
            lineTo(f4, f5);
            stroke();
            return;
        }
        throw new IOException("Error: drawLine is not allowed within a text block.");
    }

    @Deprecated
    public void drawPolygon(float[] fArr, float[] fArr2) throws IOException {
        if (!this.inTextMode) {
            addPolygon(fArr, fArr2);
            stroke();
            return;
        }
        throw new IOException("Error: drawPolygon is not allowed within a text block.");
    }

    @Deprecated
    public void drawString(String str) throws IOException {
        showText(str);
    }

    @Deprecated
    public void drawXObject(PDXObject pDXObject, float f2, float f3, float f4, float f5) throws IOException {
        AffineTransform affineTransform = new AffineTransform((double) f4, 0.0d, 0.0d, (double) f5, (double) f2, (double) f3);
        PDXObject pDXObject2 = pDXObject;
        drawXObject(pDXObject, affineTransform);
    }

    public void endMarkedContent() throws IOException {
        writeOperator("EMC");
    }

    @Deprecated
    public void endMarkedContentSequence() throws IOException {
        endMarkedContent();
    }

    public void endText() throws IOException {
        if (this.inTextMode) {
            writeOperator("ET");
            this.inTextMode = false;
            return;
        }
        throw new IOException("Error: You must call beginText() before calling endText.");
    }

    @Deprecated
    public void fill(FillType fillType) throws IOException {
        if (fillType == FillType.WINDING) {
            fill();
        } else if (fillType == FillType.EVEN_ODD) {
            fillEvenOdd();
        } else {
            throw new IOException("Error: unknown value for winding rule");
        }
    }

    public void fillEvenOdd() throws IOException {
        if (!this.inTextMode) {
            writeOperator("f*");
            return;
        }
        throw new IOException("Error: fill is not allowed within a text block.");
    }

    @Deprecated
    public void fillPolygon(float[] fArr, float[] fArr2) throws IOException {
        if (!this.inTextMode) {
            addPolygon(fArr, fArr2);
            fill();
            return;
        }
        throw new IOException("Error: fillPolygon is not allowed within a text block.");
    }

    @Deprecated
    public void fillRect(float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            addRect(f2, f3, f4, f5);
            fill();
            return;
        }
        throw new IOException("Error: fillRect is not allowed within a text block.");
    }

    public void lineTo(float f2, float f3) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperator("l");
            return;
        }
        throw new IOException("Error: lineTo is not allowed within a text block.");
    }

    @Deprecated
    public void moveTextPositionByAmount(float f2, float f3) throws IOException {
        newLineAtOffset(f2, f3);
    }

    public void moveTo(float f2, float f3) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperator("m");
            return;
        }
        throw new IOException("Error: moveTo is not allowed within a text block.");
    }

    public void newLine() throws IOException {
        if (this.inTextMode) {
            writeOperator("T*");
            return;
        }
        throw new IllegalStateException("Must call beginText() before newLine()");
    }

    public void newLineAtOffset(float f2, float f3) throws IOException {
        if (this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperator("Td");
            return;
        }
        throw new IOException("Error: must call beginText() before newLineAtOffset()");
    }

    public void restoreGraphicsState() throws IOException {
        if (!this.fontStack.isEmpty()) {
            this.fontStack.pop();
        }
        writeOperator("Q");
    }

    public void saveGraphicsState() throws IOException {
        if (!this.fontStack.isEmpty()) {
            Stack<PDFont> stack = this.fontStack;
            stack.push(stack.peek());
        }
        writeOperator(SetUserPositionRequest.KEY_PLUS_ITEM_LIST);
    }

    public void setFont(PDFont pDFont, float f2) throws IOException {
        if (this.fontStack.isEmpty()) {
            this.fontStack.add(pDFont);
        } else {
            Stack<PDFont> stack = this.fontStack;
            stack.setElementAt(pDFont, stack.size() - 1);
        }
        if (pDFont.willBeSubset() && !this.document.getFontsToSubset().contains(pDFont)) {
            this.document.getFontsToSubset().add(pDFont);
        }
        writeOperand(this.resources.add(pDFont));
        writeOperand(f2);
        writeOperator("Tf");
    }

    public void setLeading(double d2) throws IOException {
        writeOperand((float) d2);
        writeOperator("TL");
    }

    public void setLineCapStyle(int i) throws IOException {
        if (this.inTextMode) {
            throw new IOException("Error: setLineCapStyle is not allowed within a text block.");
        } else if (i < 0 || i > 2) {
            throw new IOException("Error: unknown value for line cap style");
        } else {
            writeOperand(i);
            writeOperator("J");
        }
    }

    public void setLineDashPattern(float[] fArr, float f2) throws IOException {
        if (!this.inTextMode) {
            write("[");
            for (float writeOperand : fArr) {
                writeOperand(writeOperand);
            }
            write("] ");
            writeOperand(f2);
            writeOperator("d");
            return;
        }
        throw new IOException("Error: setLineDashPattern is not allowed within a text block.");
    }

    public void setLineJoinStyle(int i) throws IOException {
        if (this.inTextMode) {
            throw new IOException("Error: setLineJoinStyle is not allowed within a text block.");
        } else if (i < 0 || i > 2) {
            throw new IOException("Error: unknown value for line join style");
        } else {
            writeOperand(i);
            writeOperator("j");
        }
    }

    public void setLineWidth(float f2) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperator("w");
            return;
        }
        throw new IOException("Error: setLineWidth is not allowed within a text block.");
    }

    public void setNonStrokingColor(PDColor pDColor) throws IOException {
        if (this.nonStrokingColorSpaceStack.isEmpty() || this.nonStrokingColorSpaceStack.peek() != pDColor.getColorSpace()) {
            writeOperand(getName(pDColor.getColorSpace()));
            writeOperator("cs");
            if (this.nonStrokingColorSpaceStack.isEmpty()) {
                this.nonStrokingColorSpaceStack.add(pDColor.getColorSpace());
            } else {
                this.nonStrokingColorSpaceStack.setElementAt(pDColor.getColorSpace(), this.nonStrokingColorSpaceStack.size() - 1);
            }
        }
        for (float writeOperand : pDColor.getComponents()) {
            writeOperand(writeOperand);
        }
        writeOperator("sc");
    }

    @Deprecated
    public void setNonStrokingColorSpace(PDColorSpace pDColorSpace) throws IOException {
        if (this.nonStrokingColorSpaceStack.isEmpty()) {
            this.nonStrokingColorSpaceStack.add(pDColorSpace);
        } else {
            Stack<PDColorSpace> stack = this.nonStrokingColorSpaceStack;
            stack.setElementAt(pDColorSpace, stack.size() - 1);
        }
        writeOperand(getName(pDColorSpace));
        writeOperator("cs");
    }

    public void setStrokingColor(PDColor pDColor) throws IOException {
        if (this.strokingColorSpaceStack.isEmpty() || this.strokingColorSpaceStack.peek() != pDColor.getColorSpace()) {
            writeOperand(getName(pDColor.getColorSpace()));
            writeOperator("CS");
            if (this.strokingColorSpaceStack.isEmpty()) {
                this.strokingColorSpaceStack.add(pDColor.getColorSpace());
            } else {
                this.strokingColorSpaceStack.setElementAt(pDColor.getColorSpace(), this.nonStrokingColorSpaceStack.size() - 1);
            }
        }
        for (float writeOperand : pDColor.getComponents()) {
            writeOperand(writeOperand);
        }
        writeOperator("SC");
    }

    @Deprecated
    public void setStrokingColorSpace(PDColorSpace pDColorSpace) throws IOException {
        if (this.strokingColorSpaceStack.isEmpty()) {
            this.strokingColorSpaceStack.add(pDColorSpace);
        } else {
            this.strokingColorSpaceStack.setElementAt(pDColorSpace, this.nonStrokingColorSpaceStack.size() - 1);
        }
        writeOperand(getName(pDColorSpace));
        writeOperator("CS");
    }

    @Deprecated
    public void setTextMatrix(double d2, double d3, double d4, double d5, double d6, double d7) throws IOException {
        Matrix matrix = new Matrix((float) d2, (float) d3, (float) d4, (float) d5, (float) d6, (float) d7);
        setTextMatrix(matrix);
    }

    @Deprecated
    public void setTextRotation(double d2, double d3, double d4) throws IOException {
        setTextMatrix(Matrix.getRotateInstance(d2, (float) d3, (float) d4));
    }

    @Deprecated
    public void setTextScaling(double d2, double d3, double d4, double d5) throws IOException {
        Matrix matrix = new Matrix((float) d2, 0.0f, 0.0f, (float) d3, (float) d4, (float) d5);
        setTextMatrix(matrix);
    }

    @Deprecated
    public void setTextTranslation(double d2, double d3) throws IOException {
        setTextMatrix(Matrix.getTranslateInstance((float) d2, (float) d3));
    }

    public void shadingFill(PDShading pDShading) throws IOException {
        if (!this.inTextMode) {
            writeOperand(this.resources.add(pDShading));
            writeOperator("sh");
            return;
        }
        throw new IOException("Error: shadingFill is not allowed within a text block.");
    }

    public void showText(String str) throws IOException {
        if (!this.inTextMode) {
            throw new IllegalStateException("Must call beginText() before showText()");
        } else if (!this.fontStack.isEmpty()) {
            PDFont peek = this.fontStack.peek();
            if (peek.willBeSubset()) {
                int i = 0;
                while (i < str.length()) {
                    int codePointAt = str.codePointAt(i);
                    peek.addToSubset(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
            COSWriter.writeString(peek.encode(str), this.output);
            write(CMap.SPACE);
            writeOperator("Tj");
        } else {
            throw new IllegalStateException("Must call setFont() before showText()");
        }
    }

    public void stroke() throws IOException {
        if (!this.inTextMode) {
            writeOperator("S");
            return;
        }
        throw new IOException("Error: stroke is not allowed within a text block.");
    }

    public void transform(Matrix matrix) throws IOException {
        writeAffineTransform(matrix.createAffineTransform());
        writeOperator("cm");
    }

    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage, boolean z, boolean z2) throws IOException {
        this(pDDocument, pDPage, z, z2, false);
    }

    @Deprecated
    public void appendRawCommands(byte[] bArr) throws IOException {
        this.output.write(bArr);
    }

    @Deprecated
    public void beginMarkedContentSequence(COSName cOSName, COSName cOSName2) throws IOException {
        writeOperand(cOSName);
        writeOperand(cOSName2);
        writeOperator("BDC");
    }

    @Deprecated
    public void concatenate2CTM(AffineTransform affineTransform) throws IOException {
        transform(new Matrix(affineTransform));
    }

    public void drawImage(PDImageXObject pDImageXObject, float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            saveGraphicsState();
            AffineTransform affineTransform = new AffineTransform((double) f4, 0.0d, 0.0d, (double) f5, (double) f2, (double) f3);
            transform(new Matrix(affineTransform));
            writeOperand(this.resources.add(pDImageXObject));
            writeOperator("Do");
            restoreGraphicsState();
            return;
        }
        throw new IOException("Error: drawImage is not allowed within a text block.");
    }

    @Deprecated
    public void setTextMatrix(AffineTransform affineTransform) throws IOException {
        setTextMatrix(new Matrix(affineTransform));
    }

    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage, boolean z, boolean z2, boolean z3) throws IOException {
        COSStreamArray cOSStreamArray;
        this.inTextMode = false;
        this.fontStack = new Stack<>();
        this.nonStrokingColorSpaceStack = new Stack<>();
        this.strokingColorSpaceStack = new Stack<>();
        this.formatDecimal = NumberFormat.getNumberInstance(Locale.US);
        this.document = pDDocument;
        PDStream stream = pDPage.getStream();
        boolean z4 = stream != null;
        if (!z || !z4) {
            PDStream pDStream = new PDStream(pDDocument);
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(COSName.FLATE_DECODE);
                pDStream.setFilters(arrayList);
            }
            pDPage.setContents(pDStream);
            this.output = pDStream.createOutputStream();
        } else {
            PDStream pDStream2 = new PDStream(pDDocument);
            if (stream.getStream() instanceof COSStreamArray) {
                cOSStreamArray = (COSStreamArray) stream.getStream();
                cOSStreamArray.appendStream(pDStream2.getStream());
            } else {
                COSArray cOSArray = new COSArray();
                cOSArray.add(stream.getCOSObject());
                cOSArray.add(pDStream2.getCOSObject());
                cOSStreamArray = new COSStreamArray(cOSArray);
            }
            if (z2) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(COSName.FLATE_DECODE);
                pDStream2.setFilters(arrayList2);
            }
            if (z3) {
                PDStream pDStream3 = new PDStream(pDDocument);
                this.output = pDStream3.createOutputStream();
                saveGraphicsState();
                close();
                if (z2) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(COSName.FLATE_DECODE);
                    pDStream3.setFilters(arrayList3);
                }
                cOSStreamArray.insertCOSStream(pDStream3);
            }
            pDPage.setContents(new PDStream((COSStream) cOSStreamArray));
            this.output = pDStream2.createOutputStream();
            if (z3) {
                restoreGraphicsState();
            }
        }
        this.formatDecimal.setMaximumFractionDigits(10);
        this.formatDecimal.setGroupingUsed(false);
        PDResources resources2 = pDPage.getResources();
        this.resources = resources2;
        if (resources2 == null) {
            PDResources pDResources = new PDResources();
            this.resources = pDResources;
            pDPage.setResources(pDResources);
        }
    }

    private void writeOperand(int i) throws IOException {
        writeOperator(this.formatDecimal.format((long) i));
        this.output.write(32);
    }

    @Deprecated
    public void appendRawCommands(int i) throws IOException {
        this.output.write(i);
    }

    public void beginMarkedContent(COSName cOSName, PDPropertyList pDPropertyList) throws IOException {
        writeOperand(cOSName);
        writeOperand(this.resources.add(pDPropertyList));
        writeOperator("BDC");
    }

    @Deprecated
    public void drawXObject(PDXObject pDXObject, AffineTransform affineTransform) throws IOException {
        if (!this.inTextMode) {
            COSName add = this.resources.add(pDXObject, pDXObject instanceof PDImageXObject ? "Im" : StandardStructureTypes.FORM);
            saveGraphicsState();
            transform(new Matrix(affineTransform));
            writeOperand(add);
            writeOperator("Do");
            restoreGraphicsState();
            return;
        }
        throw new IOException("Error: drawXObject is not allowed within a text block.");
    }

    public void setTextMatrix(Matrix matrix) throws IOException {
        if (this.inTextMode) {
            writeAffineTransform(matrix.createAffineTransform());
            writeOperator("Tm");
            return;
        }
        throw new IOException("Error: must call beginText() before setTextMatrix");
    }

    @Deprecated
    public void appendRawCommands(double d2) throws IOException {
        this.output.write(this.formatDecimal.format(d2).getBytes(Charsets.US_ASCII));
    }

    private void writeOperand(COSName cOSName) throws IOException {
        cOSName.writePDF(this.output);
        this.output.write(32);
    }

    @Deprecated
    public void appendRawCommands(float f2) throws IOException {
        this.output.write(this.formatDecimal.format((double) f2).getBytes(Charsets.US_ASCII));
    }

    public void fill() throws IOException {
        if (!this.inTextMode) {
            writeOperator(f.f1288a);
            return;
        }
        throw new IOException("Error: fill is not allowed within a text block.");
    }

    public void setNonStrokingColor(AWTColor aWTColor) throws IOException {
        setNonStrokingColor(new PDColor(new float[]{((float) aWTColor.getRed()) / 255.0f, ((float) aWTColor.getGreen()) / 255.0f, ((float) aWTColor.getBlue()) / 255.0f}, (PDColorSpace) PDDeviceRGB.INSTANCE));
    }

    public void setStrokingColor(AWTColor aWTColor) throws IOException {
        setStrokingColor(new PDColor(new float[]{((float) aWTColor.getRed()) / 255.0f, ((float) aWTColor.getGreen()) / 255.0f, ((float) aWTColor.getBlue()) / 255.0f}, (PDColorSpace) PDDeviceRGB.INSTANCE));
    }

    @Deprecated
    public void setNonStrokingColor(float[] fArr) throws IOException {
        if (!this.nonStrokingColorSpaceStack.isEmpty()) {
            PDColorSpace peek = this.nonStrokingColorSpaceStack.peek();
            writeOperator("sc");
            return;
        }
        throw new IllegalStateException("The color space must be set before setting a color");
    }

    @Deprecated
    public void setStrokingColor(float[] fArr) throws IOException {
        if (!this.strokingColorSpaceStack.isEmpty()) {
            for (float writeOperand : fArr) {
                writeOperand(writeOperand);
            }
            PDColorSpace peek = this.strokingColorSpaceStack.peek();
            writeOperator("SC");
            return;
        }
        throw new IllegalStateException("The color space must be set before setting a color");
    }

    public void setNonStrokingColor(int i, int i2, int i3) throws IOException {
        writeOperand(((float) i) / 255.0f);
        writeOperand(((float) i2) / 255.0f);
        writeOperand(((float) i3) / 255.0f);
        writeOperator("rg");
    }

    public void setStrokingColor(int i, int i2, int i3) throws IOException {
        writeOperand(((float) i) / 255.0f);
        writeOperand(((float) i2) / 255.0f);
        writeOperand(((float) i3) / 255.0f);
        writeOperator("RG");
    }

    public void setNonStrokingColor(int i, int i2, int i3, int i4) throws IOException {
        setNonStrokingColor((double) (((float) i) / 255.0f), (double) (((float) i2) / 255.0f), (double) (((float) i3) / 255.0f), (double) (((float) i4) / 255.0f));
    }

    public void setNonStrokingColor(double d2, double d3, double d4, double d5) throws IOException {
        writeOperand((float) d2);
        writeOperand((float) d3);
        writeOperand((float) d4);
        writeOperand((float) d5);
        writeOperator(k.f4287a);
    }

    @Deprecated
    public void setStrokingColor(int i, int i2, int i3, int i4) throws IOException {
        setStrokingColor(((float) i) / 255.0f, ((float) i2) / 255.0f, ((float) i3) / 255.0f, ((float) i4) / 255.0f);
    }

    public void setStrokingColor(float f2, float f3, float f4, float f5) throws IOException {
        writeOperand(f2);
        writeOperand(f3);
        writeOperand(f4);
        writeOperand(f5);
        writeOperator("K");
    }

    public void setNonStrokingColor(int i) throws IOException {
        setNonStrokingColor((double) (((float) i) / 255.0f));
    }

    public void setNonStrokingColor(double d2) throws IOException {
        writeOperand((float) d2);
        writeOperator("g");
    }

    @Deprecated
    public void setStrokingColor(int i) throws IOException {
        setStrokingColor((double) (((float) i) / 255.0f));
    }

    public void setStrokingColor(double d2) throws IOException {
        writeOperand((float) d2);
        writeOperator("G");
    }
}
