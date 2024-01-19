package org.apache.pdfbox.contentstream;

import android.graphics.PointF;
import android.graphics.RectF;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.contentstream.operator.state.EmptyGraphicsStackException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.filter.MissingImageReaderException;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.MissingResourceException;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;

public class PDFStreamEngine {
    public PDPage currentPage;
    public Stack<PDGraphicsState> graphicsStack = new Stack<>();
    public Matrix initialMatrix;
    public boolean isProcessingPage;
    public final Map<String, OperatorProcessor> operators = new HashMap();
    public PDResources resources;
    public Matrix textLineMatrix;
    public Matrix textMatrix;

    private void clipToRect(PDRectangle pDRectangle) {
        if (pDRectangle != null) {
            getGraphicsState().intersectClippingPath(pDRectangle.transform(getGraphicsState().getCurrentTransformationMatrix()));
        }
    }

    private void initPage(PDPage pDPage) {
        if (pDPage != null) {
            this.currentPage = pDPage;
            this.graphicsStack.clear();
            this.graphicsStack.push(new PDGraphicsState(pDPage.getCropBox()));
            this.textMatrix = null;
            this.textLineMatrix = null;
            this.resources = null;
            this.initialMatrix = pDPage.getMatrix();
            return;
        }
        throw new IllegalArgumentException("Page cannot be null");
    }

    private void popResources(PDResources pDResources) {
        this.resources = pDResources;
    }

    private void processStream(PDContentStream pDContentStream) throws IOException {
        PDResources pushResources = pushResources(pDContentStream);
        Stack<PDGraphicsState> saveGraphicsStack = saveGraphicsStack();
        Matrix matrix = this.initialMatrix;
        getGraphicsState().getCurrentTransformationMatrix().concatenate(pDContentStream.getMatrix());
        this.initialMatrix = getGraphicsState().getCurrentTransformationMatrix().clone();
        clipToRect(pDContentStream.getBBox());
        processStreamOperators(pDContentStream);
        this.initialMatrix = matrix;
        restoreGraphicsStack(saveGraphicsStack);
        popResources(pushResources);
    }

    private void processStreamOperators(PDContentStream pDContentStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        PDFStreamParser pDFStreamParser = new PDFStreamParser(pDContentStream.getContentStream());
        try {
            Iterator<Object> tokenIterator = pDFStreamParser.getTokenIterator();
            while (tokenIterator.hasNext()) {
                Object next = tokenIterator.next();
                if (next instanceof COSObject) {
                    arrayList.add(((COSObject) next).getObject());
                } else if (next instanceof Operator) {
                    processOperator((Operator) next, (List<COSBase>) arrayList);
                    arrayList = new ArrayList();
                } else {
                    arrayList.add((COSBase) next);
                }
            }
        } finally {
            pDFStreamParser.close();
        }
    }

    private PDResources pushResources(PDContentStream pDContentStream) {
        PDResources pDResources = this.resources;
        PDResources resources2 = pDContentStream.getResources();
        if (resources2 != null) {
            this.resources = resources2;
        } else if (this.resources == null) {
            this.resources = this.currentPage.getResources();
        }
        if (this.resources == null) {
            this.resources = new PDResources();
        }
        return pDResources;
    }

    public final void addOperator(OperatorProcessor operatorProcessor) {
        operatorProcessor.setContext(this);
        this.operators.put(operatorProcessor.getName(), operatorProcessor);
    }

    public void applyTextAdjustment(float f2, float f3) throws IOException {
        this.textMatrix.concatenate(Matrix.getTranslateInstance(f2, f3));
    }

    public void beginText() throws IOException {
    }

    public void endText() throws IOException {
    }

    public PDAppearanceStream getAppearance(PDAnnotation pDAnnotation) {
        return pDAnnotation.getNormalAppearanceStream();
    }

    public PDPage getCurrentPage() {
        return this.currentPage;
    }

    public int getGraphicsStackSize() {
        return this.graphicsStack.size();
    }

    public PDGraphicsState getGraphicsState() {
        return this.graphicsStack.peek();
    }

    public Matrix getInitialMatrix() {
        return this.initialMatrix;
    }

    public PDResources getResources() {
        return this.resources;
    }

    public Matrix getTextLineMatrix() {
        return this.textLineMatrix;
    }

    public Matrix getTextMatrix() {
        return this.textMatrix;
    }

    public void operatorException(Operator operator, List<COSBase> list, IOException iOException) throws IOException {
        if ((iOException instanceof MissingOperandException) || (iOException instanceof MissingResourceException) || (iOException instanceof MissingImageReaderException)) {
            iOException.getMessage();
        } else if (iOException instanceof EmptyGraphicsStackException) {
            iOException.getMessage();
        } else if (operator.getName().equals("Do")) {
            iOException.getMessage();
        } else {
            throw iOException;
        }
    }

    public void processAnnotation(PDAnnotation pDAnnotation, PDAppearanceStream pDAppearanceStream) throws IOException {
        PDResources pushResources = pushResources(pDAppearanceStream);
        saveGraphicsState();
        PDRectangle bBox = pDAppearanceStream.getBBox();
        PDRectangle rectangle = pDAnnotation.getRectangle();
        Matrix matrix = pDAppearanceStream.getMatrix();
        if (rectangle.getWidth() > 0.0f && rectangle.getHeight() > 0.0f) {
            RectF rectF = new RectF();
            bBox.transform(matrix).computeBounds(rectF, true);
            Matrix translateInstance = Matrix.getTranslateInstance(rectangle.getLowerLeftX(), rectangle.getLowerLeftY());
            translateInstance.concatenate(Matrix.getScaleInstance(rectangle.getWidth() / rectF.width(), rectangle.getHeight() / rectF.height()));
            translateInstance.concatenate(Matrix.getTranslateInstance(-rectF.left, -rectF.top));
            getGraphicsState().setCurrentTransformationMatrix(Matrix.concatenate(matrix, translateInstance));
            clipToRect(bBox);
            processStreamOperators(pDAppearanceStream);
        }
        restoreGraphicsState();
        popResources(pushResources);
    }

    public void processChildStream(PDContentStream pDContentStream, PDPage pDPage) throws IOException {
        if (!this.isProcessingPage) {
            initPage(pDPage);
            processStream(pDContentStream);
            this.currentPage = null;
            return;
        }
        throw new IllegalStateException("Current page has already been set via  #processPage(PDPage) call #processChildStream(PDContentStream) instead");
    }

    public void processOperator(String str, List<COSBase> list) throws IOException {
        processOperator(Operator.getOperator(str), list);
    }

    public void processPage(PDPage pDPage) throws IOException {
        initPage(pDPage);
        if (pDPage.getStream() != null) {
            this.isProcessingPage = true;
            processStream(pDPage);
            this.isProcessingPage = false;
        }
    }

    public void processSoftMask(PDFormXObject pDFormXObject) throws IOException {
        Stack<PDGraphicsState> saveGraphicsStack = saveGraphicsStack();
        getGraphicsState().setSoftMask(null);
        processTransparencyGroup(pDFormXObject);
        restoreGraphicsStack(saveGraphicsStack);
    }

    public final void processTilingPattern(PDTilingPattern pDTilingPattern, PDColor pDColor, PDColorSpace pDColorSpace) throws IOException {
        processTilingPattern(pDTilingPattern, pDColor, pDColorSpace, pDTilingPattern.getMatrix());
    }

    public void processTransparencyGroup(PDFormXObject pDFormXObject) throws IOException {
        if (this.currentPage != null) {
            PDResources pushResources = pushResources(pDFormXObject);
            Stack<PDGraphicsState> saveGraphicsStack = saveGraphicsStack();
            getGraphicsState().getCurrentTransformationMatrix().concatenate(pDFormXObject.getMatrix());
            processStreamOperators(pDFormXObject);
            restoreGraphicsStack(saveGraphicsStack);
            popResources(pushResources);
            return;
        }
        throw new IllegalStateException("No current page, call #processChildStream(PDContentStream, PDPage) instead");
    }

    public void processType3Stream(PDType3CharProc pDType3CharProc, Matrix matrix) throws IOException {
        if (this.currentPage != null) {
            PDResources pushResources = pushResources(pDType3CharProc);
            saveGraphicsState();
            getGraphicsState().setCurrentTransformationMatrix(matrix);
            getGraphicsState().getCurrentTransformationMatrix().concatenate(pDType3CharProc.getMatrix());
            Matrix matrix2 = this.textMatrix;
            this.textMatrix = new Matrix();
            Matrix matrix3 = this.textLineMatrix;
            this.textLineMatrix = new Matrix();
            processStreamOperators(pDType3CharProc);
            this.textMatrix = matrix2;
            this.textLineMatrix = matrix3;
            restoreGraphicsState();
            popResources(pushResources);
            return;
        }
        throw new IllegalStateException("No current page, call #processChildStream(PDContentStream, PDPage) instead");
    }

    @Deprecated
    public void registerOperatorProcessor(String str, OperatorProcessor operatorProcessor) {
        operatorProcessor.setContext(this);
        this.operators.put(str, operatorProcessor);
    }

    public final void restoreGraphicsStack(Stack<PDGraphicsState> stack) {
        this.graphicsStack = stack;
    }

    public void restoreGraphicsState() {
        this.graphicsStack.pop();
    }

    public final Stack<PDGraphicsState> saveGraphicsStack() {
        Stack<PDGraphicsState> stack = this.graphicsStack;
        Stack<PDGraphicsState> stack2 = new Stack<>();
        this.graphicsStack = stack2;
        stack2.add(stack.peek().clone());
        return stack;
    }

    public void saveGraphicsState() {
        Stack<PDGraphicsState> stack = this.graphicsStack;
        stack.push(stack.peek().clone());
    }

    public void setLineDashPattern(COSArray cOSArray, int i) {
        if (i < 0) {
            i = 0;
        }
        getGraphicsState().setLineDashPattern(new PDLineDashPattern(cOSArray, i));
    }

    public void setTextLineMatrix(Matrix matrix) {
        this.textLineMatrix = matrix;
    }

    public void setTextMatrix(Matrix matrix) {
        this.textMatrix = matrix;
    }

    public void showAnnotation(PDAnnotation pDAnnotation) throws IOException {
        PDAppearanceStream appearance = getAppearance(pDAnnotation);
        if (appearance != null) {
            processAnnotation(pDAnnotation, appearance);
        }
    }

    public void showFontGlyph(Matrix matrix, PDFont pDFont, int i, String str, Vector vector) throws IOException {
    }

    public void showForm(PDFormXObject pDFormXObject) throws IOException {
        if (this.currentPage != null) {
            processStream(pDFormXObject);
            return;
        }
        throw new IllegalStateException("No current page, call #processChildStream(PDContentStream, PDPage) instead");
    }

    public void showGlyph(Matrix matrix, PDFont pDFont, int i, String str, Vector vector) throws IOException {
        if (pDFont instanceof PDType3Font) {
            showType3Glyph(matrix, (PDType3Font) pDFont, i, str, vector);
            return;
        }
        showFontGlyph(matrix, pDFont, i, str, vector);
    }

    public void showText(byte[] bArr) throws IOException {
        float f2;
        PDGraphicsState graphicsState = getGraphicsState();
        PDTextState textState = graphicsState.getTextState();
        PDFont font = textState.getFont();
        if (font == null) {
            font = PDFontFactory.createDefaultFont();
        }
        PDFont pDFont = font;
        float fontSize = textState.getFontSize();
        float horizontalScaling = textState.getHorizontalScaling() / 100.0f;
        float characterSpacing = textState.getCharacterSpacing();
        Matrix matrix = new Matrix(fontSize * horizontalScaling, 0.0f, 0.0f, fontSize, 0.0f, textState.getRise());
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (byteArrayInputStream.available() > 0) {
            int available = byteArrayInputStream.available();
            int readCode = pDFont.readCode(byteArrayInputStream);
            int available2 = available - byteArrayInputStream.available();
            String unicode = pDFont.toUnicode(readCode);
            float f3 = 0.0f;
            float wordSpacing = (available2 == 1 && readCode == 32) ? textState.getWordSpacing() + 0.0f : 0.0f;
            Matrix multiply = matrix.multiply(this.textMatrix).multiply(graphicsState.getCurrentTransformationMatrix());
            if (pDFont.isVertical()) {
                multiply.translate(pDFont.getPositionVector(readCode));
            }
            Vector displacement = pDFont.getDisplacement(readCode);
            saveGraphicsState();
            Matrix matrix2 = matrix;
            showGlyph(multiply, pDFont, readCode, unicode, displacement);
            restoreGraphicsState();
            if (pDFont.isVertical()) {
                f2 = (displacement.getY() * fontSize) + characterSpacing + wordSpacing;
            } else {
                f3 = ((displacement.getX() * fontSize) + characterSpacing + wordSpacing) * horizontalScaling;
                f2 = 0.0f;
            }
            this.textMatrix.concatenate(Matrix.getTranslateInstance(f3, f2));
            matrix = matrix2;
        }
    }

    public void showTextString(byte[] bArr) throws IOException {
        showText(bArr);
    }

    public void showTextStrings(COSArray cOSArray) throws IOException {
        float f2;
        PDTextState textState = getGraphicsState().getTextState();
        float fontSize = textState.getFontSize();
        float horizontalScaling = textState.getHorizontalScaling() / 100.0f;
        boolean isVertical = textState.getFont().isVertical();
        Iterator<COSBase> it = cOSArray.iterator();
        while (it.hasNext()) {
            COSBase next = it.next();
            if (next instanceof COSNumber) {
                float floatValue = ((COSNumber) next).floatValue();
                float f3 = 0.0f;
                if (isVertical) {
                    f2 = ((-floatValue) / 1000.0f) * fontSize;
                } else {
                    f3 = ((-floatValue) / 1000.0f) * fontSize * horizontalScaling;
                    f2 = 0.0f;
                }
                applyTextAdjustment(f3, f2);
            } else if (next instanceof COSString) {
                showText(((COSString) next).getBytes());
            } else {
                throw new IOException("Unknown type in array for TJ operation:" + next);
            }
        }
    }

    public void showTransparencyGroup(PDFormXObject pDFormXObject) throws IOException {
        processTransparencyGroup(pDFormXObject);
    }

    public void showType3Glyph(Matrix matrix, PDType3Font pDType3Font, int i, String str, Vector vector) throws IOException {
        PDType3CharProc charProc = pDType3Font.getCharProc(i);
        if (charProc != null) {
            processType3Stream(charProc, matrix);
        }
    }

    public float transformWidth(float f2) {
        Matrix currentTransformationMatrix = getGraphicsState().getCurrentTransformationMatrix();
        float shearX = currentTransformationMatrix.getShearX() + currentTransformationMatrix.getScaleX();
        float shearY = currentTransformationMatrix.getShearY() + currentTransformationMatrix.getScaleY();
        return f2 * ((float) Math.sqrt(((double) ((shearY * shearY) + (shearX * shearX))) * 0.5d));
    }

    public PointF transformedPoint(float f2, float f3) {
        float[] fArr = {f2, f3};
        getGraphicsState().getCurrentTransformationMatrix().createAffineTransform().transform(fArr, 0, fArr, 0, 1);
        return new PointF(fArr[0], fArr[1]);
    }

    public void unsupportedOperator(Operator operator, List<COSBase> list) throws IOException {
    }

    public final void processTilingPattern(PDTilingPattern pDTilingPattern, PDColor pDColor, PDColorSpace pDColorSpace, Matrix matrix) throws IOException {
        PDResources pushResources = pushResources(pDTilingPattern);
        Matrix matrix2 = this.initialMatrix;
        this.initialMatrix = Matrix.concatenate(matrix2, matrix);
        Stack<PDGraphicsState> saveGraphicsStack = saveGraphicsStack();
        RectF rectF = new RectF();
        pDTilingPattern.getBBox().transform(matrix).computeBounds(rectF, true);
        this.graphicsStack.push(new PDGraphicsState(new PDRectangle(rectF.left, rectF.top, rectF.width(), rectF.height())));
        if (pDColorSpace != null) {
            PDColor pDColor2 = new PDColor(pDColor.getComponents(), pDColorSpace);
            getGraphicsState().setNonStrokingColorSpace(pDColorSpace);
            getGraphicsState().setNonStrokingColor(pDColor2);
            getGraphicsState().setStrokingColorSpace(pDColorSpace);
            getGraphicsState().setStrokingColor(pDColor2);
        }
        getGraphicsState().getCurrentTransformationMatrix().concatenate(matrix);
        clipToRect(pDTilingPattern.getBBox());
        processStreamOperators(pDTilingPattern);
        this.initialMatrix = matrix2;
        restoreGraphicsStack(saveGraphicsStack);
        popResources(pushResources);
    }

    public void processOperator(Operator operator, List<COSBase> list) throws IOException {
        OperatorProcessor operatorProcessor = this.operators.get(operator.getName());
        if (operatorProcessor != null) {
            operatorProcessor.setContext(this);
            try {
                operatorProcessor.process(operator, list);
            } catch (IOException e2) {
                operatorException(operator, list, e2);
            }
        } else {
            unsupportedOperator(operator, list);
        }
    }
}
