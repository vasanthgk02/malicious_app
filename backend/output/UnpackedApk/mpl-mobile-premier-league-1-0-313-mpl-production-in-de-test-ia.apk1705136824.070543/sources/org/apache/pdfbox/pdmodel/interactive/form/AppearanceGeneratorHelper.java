package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter.Builder;

public class AppearanceGeneratorHelper {
    public static final float GLYPH_TO_PDF_SCALE = 1000.0f;
    public final PDAcroForm acroForm;
    public final DefaultAppearanceHandler defaultAppearanceHandler;
    public final PDVariableText parent;
    public String value;
    public List<COSObjectable> widgets = new ArrayList();

    public AppearanceGeneratorHelper(PDAcroForm pDAcroForm, PDVariableText pDVariableText) throws IOException {
        this.acroForm = pDAcroForm;
        this.parent = pDVariableText;
        List<COSObjectable> kids = pDVariableText.getKids();
        this.widgets = kids;
        if (kids == null) {
            ArrayList arrayList = new ArrayList();
            this.widgets = arrayList;
            arrayList.add(pDVariableText.getWidget());
        }
        this.defaultAppearanceHandler = new DefaultAppearanceHandler(getDefaultAppearance());
    }

    private PDRectangle applyPadding(PDRectangle pDRectangle, float f2) {
        float lowerLeftX = pDRectangle.getLowerLeftX() + f2;
        float lowerLeftY = pDRectangle.getLowerLeftY() + f2;
        float f3 = f2 * 2.0f;
        return new PDRectangle(lowerLeftX, lowerLeftY, pDRectangle.getWidth() - f3, pDRectangle.getHeight() - f3);
    }

    private float calculateFontSize(PDFont pDFont, PDRectangle pDRectangle) throws IOException {
        float fontSize = !this.defaultAppearanceHandler.getTokens().isEmpty() ? this.defaultAppearanceHandler.getFontSize() : 12.0f;
        if (fontSize == 0.0f && !isMultiLine()) {
            fontSize = Math.min(pDRectangle.getHeight() / (pDFont.getFontDescriptor().getFontBoundingBox().getHeight() / 1000.0f), pDRectangle.getWidth() / (pDFont.getStringWidth(this.value) / 1000.0f));
        }
        if (fontSize == 0.0f) {
            return 12.0f;
        }
        return fontSize;
    }

    private float calculateHorizontalOffset(PDRectangle pDRectangle, PDFont pDFont, float f2) throws IOException {
        float stringWidth = (pDFont.getStringWidth(this.value) / 1000.0f) * f2;
        int q = this.parent.getQ();
        if (q == 0 || stringWidth > pDRectangle.getWidth()) {
            return pDRectangle.getLowerLeftX();
        }
        if (q == 1) {
            return ((pDRectangle.getWidth() - stringWidth) / 2.0f) + pDRectangle.getLowerLeftX();
        } else if (q != 2) {
            return pDRectangle.getLowerLeftX();
        } else {
            return (pDRectangle.getWidth() + pDRectangle.getLowerLeftX()) - stringWidth;
        }
    }

    private float calculateVerticalOffset(PDRectangle pDRectangle, PDRectangle pDRectangle2, PDFont pDFont, float f2) throws IOException {
        float capHeight = getCapHeight(pDFont, f2);
        float height = (pDFont.getBoundingBox().getHeight() / 1000.0f) * f2;
        PDVariableText pDVariableText = this.parent;
        if ((pDVariableText instanceof PDTextField) && ((PDTextField) pDVariableText).isMultiline()) {
            return pDRectangle2.getUpperRightY() + height;
        }
        if (capHeight > pDRectangle.getHeight()) {
            return pDRectangle.getLowerLeftX() - ((pDFont.getFontDescriptor().getDescent() / 1000.0f) * f2);
        }
        return pDRectangle.getLowerLeftX() + ((pDRectangle.getHeight() - capHeight) / 2.0f);
    }

    private boolean containsMarkedContent(List<Object> list) {
        return list.contains(Operator.getOperator("BMC"));
    }

    private void createAppearanceContent(List<Object> list, PDAnnotationWidget pDAnnotationWidget, PDFont pDFont, PDAppearanceStream pDAppearanceStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ContentStreamWriter(byteArrayOutputStream).writeTokens(list);
        byteArrayOutputStream.write("/Tx BMC\n".getBytes("ISO-8859-1"));
        insertGeneratedAppearance(resolveBoundingBox(pDAnnotationWidget, pDAppearanceStream), byteArrayOutputStream, pDFont, list);
        byteArrayOutputStream.write("EMC".getBytes("ISO-8859-1"));
        byteArrayOutputStream.close();
        writeToStream(byteArrayOutputStream.toByteArray(), pDAppearanceStream);
    }

    private float getCapHeight(PDFont pDFont, float f2) throws IOException {
        float height;
        PDFontDescriptor fontDescriptor = pDFont.getFontDescriptor();
        if (fontDescriptor == null || fontDescriptor.getCapHeight() == 0.0f) {
            height = (pDFont.getBoundingBox().getHeight() / 1000.0f) * f2;
            f2 = 0.7f;
        } else {
            height = pDFont.getFontDescriptor().getCapHeight() / 1000.0f;
        }
        return height * f2;
    }

    private String getDefaultAppearance() {
        return this.parent.getDefaultAppearance();
    }

    private PDFont getFontAndUpdateResources(PDAppearanceStream pDAppearanceStream) throws IOException {
        PDResources resources = pDAppearanceStream.getResources();
        PDResources defaultResources = this.acroForm.getDefaultResources();
        if (resources == null && defaultResources == null) {
            throw new IOException("Unable to generate field appearance - missing required resources");
        }
        COSName fontName = this.defaultAppearanceHandler.getFontName();
        if (resources != null) {
            PDFont font = resources.getFont(fontName);
            if (font != null) {
                return font;
            }
        } else {
            resources = new PDResources();
            pDAppearanceStream.setResources(resources);
        }
        if (defaultResources != null) {
            PDFont font2 = defaultResources.getFont(fontName);
            if (font2 != null) {
                resources.put(fontName, font2);
                return font2;
            }
        }
        PDFont resolveFont = resolveFont(resources, defaultResources, fontName);
        if (resolveFont != null) {
            resources.put(fontName, resolveFont);
            return resolveFont;
        }
        throw new IOException("Unable to generate field appearance - missing required font resources: " + fontName);
    }

    private float getLineWidth(List<Object> list) {
        if (list != null) {
            int indexOf = list.indexOf(Operator.getOperator("BT"));
            int indexOf2 = list.indexOf(Operator.getOperator("w"));
            if (indexOf2 > 0 && (indexOf2 < indexOf || indexOf == -1)) {
                return ((COSNumber) list.get(indexOf2 - 1)).floatValue();
            }
        }
        return 0.0f;
    }

    private List<Object> getStreamTokens(PDAppearanceStream pDAppearanceStream) throws IOException {
        return pDAppearanceStream != null ? getStreamTokens(pDAppearanceStream.getCOSStream()) : new ArrayList();
    }

    private void insertGeneratedAppearance(PDRectangle pDRectangle, OutputStream outputStream, PDFont pDFont, List<Object> list) throws IOException {
        AppearancePrimitivesComposer appearancePrimitivesComposer = new AppearancePrimitivesComposer(outputStream);
        float lineWidth = getLineWidth(list);
        PDRectangle applyPadding = applyPadding(pDRectangle, Math.max(1.0f, lineWidth));
        PDRectangle applyPadding2 = applyPadding(applyPadding, Math.max(1.0f, lineWidth));
        appearancePrimitivesComposer.addRect(applyPadding);
        appearancePrimitivesComposer.clip();
        appearancePrimitivesComposer.beginText();
        float calculateFontSize = calculateFontSize(pDFont, applyPadding2);
        if (!this.defaultAppearanceHandler.getTokens().isEmpty()) {
            this.defaultAppearanceHandler.setFontSize(calculateFontSize);
            new ContentStreamWriter(outputStream).writeTokens(this.defaultAppearanceHandler.getTokens());
        }
        float calculateVerticalOffset = calculateVerticalOffset(applyPadding, applyPadding2, pDFont, calculateFontSize);
        if (!isMultiLine()) {
            appearancePrimitivesComposer.newLineAtOffset(calculateHorizontalOffset(applyPadding2, pDFont, calculateFontSize), calculateVerticalOffset);
            appearancePrimitivesComposer.showText(this.value, pDFont);
        } else {
            float lowerLeftX = applyPadding2.getLowerLeftX();
            PlainText plainText = new PlainText(this.value);
            AppearanceStyle appearanceStyle = new AppearanceStyle();
            appearanceStyle.setFont(pDFont);
            appearanceStyle.setFontSize(calculateFontSize);
            appearanceStyle.setLeading((pDFont.getBoundingBox().getHeight() / 1000.0f) * calculateFontSize);
            new Builder(appearancePrimitivesComposer).style(appearanceStyle).text(plainText).width(applyPadding2.getWidth()).wrapLines(true).initialOffset(lowerLeftX, calculateVerticalOffset).textAlign(this.parent.getQ()).build().format();
        }
        appearancePrimitivesComposer.endText();
    }

    private boolean isMultiLine() {
        PDVariableText pDVariableText = this.parent;
        return (pDVariableText instanceof PDTextField) && ((PDTextField) pDVariableText).isMultiline();
    }

    private PDRectangle resolveBoundingBox(PDAnnotationWidget pDAnnotationWidget, PDAppearanceStream pDAppearanceStream) {
        PDRectangle bBox = pDAppearanceStream.getBBox();
        return bBox == null ? pDAnnotationWidget.getRectangle().createRetranslatedRectangle() : bBox;
    }

    private PDFont resolveFont(PDResources pDResources, PDResources pDResources2, COSName cOSName) throws IOException {
        if (pDResources != null) {
            for (COSName font : pDResources.getFontNames()) {
                PDFont font2 = pDResources.getFont(font);
                if (font2.getName().equals(cOSName.getName())) {
                    return font2;
                }
            }
        }
        if (pDResources2 != null) {
            for (COSName font3 : pDResources2.getFontNames()) {
                PDFont font4 = pDResources2.getFont(font3);
                if (font4.getName().equals(cOSName.getName())) {
                    return font4;
                }
            }
        }
        return null;
    }

    private void updateAppearanceContent(List<Object> list, PDAnnotationWidget pDAnnotationWidget, PDFont pDFont, PDAppearanceStream pDAppearanceStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ContentStreamWriter contentStreamWriter = new ContentStreamWriter(byteArrayOutputStream);
        PDRectangle resolveBoundingBox = resolveBoundingBox(pDAnnotationWidget, pDAppearanceStream);
        int indexOf = list.indexOf(Operator.getOperator("BMC"));
        int indexOf2 = list.indexOf(Operator.getOperator("EMC"));
        contentStreamWriter.writeTokens(list, 0, indexOf + 1);
        byteArrayOutputStream.write("\n".getBytes("ISO-8859-1"));
        insertGeneratedAppearance(resolveBoundingBox, byteArrayOutputStream, pDFont, list);
        if (indexOf2 != -1) {
            contentStreamWriter.writeTokens(list, indexOf2, list.size());
        }
        byteArrayOutputStream.close();
        writeToStream(byteArrayOutputStream.toByteArray(), pDAppearanceStream);
    }

    private void writeToStream(byte[] bArr, PDAppearanceStream pDAppearanceStream) throws IOException {
        OutputStream createUnfilteredStream = pDAppearanceStream.getCOSStream().createUnfilteredStream();
        createUnfilteredStream.write(bArr);
        createUnfilteredStream.flush();
    }

    public void setAppearanceValue(String str) throws IOException {
        PDAnnotationWidget pDAnnotationWidget;
        PDFieldTreeNode pDFieldTreeNode;
        this.value = str;
        for (COSObjectable next : this.widgets) {
            PDAppearanceStream pDAppearanceStream = null;
            if (next instanceof PDField) {
                pDFieldTreeNode = (PDField) next;
                pDAnnotationWidget = pDFieldTreeNode.getWidget();
            } else {
                pDAnnotationWidget = (PDAnnotationWidget) next;
                pDFieldTreeNode = null;
            }
            PDFormFieldAdditionalActions actions = pDFieldTreeNode != null ? pDFieldTreeNode.getActions() : null;
            if (actions == null || actions.getF() == null || pDAnnotationWidget.getDictionary().getDictionaryObject(COSName.AP) != null) {
                PDAppearanceDictionary appearance = pDAnnotationWidget.getAppearance();
                if (appearance == null) {
                    appearance = new PDAppearanceDictionary();
                    pDAnnotationWidget.setAppearance(appearance);
                }
                PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
                if (normalAppearance.isStream()) {
                    pDAppearanceStream = normalAppearance.getAppearanceStream();
                }
                if (pDAppearanceStream == null) {
                    PDAppearanceStream pDAppearanceStream2 = new PDAppearanceStream(this.acroForm.getDocument().getDocument().createCOSStream());
                    pDAppearanceStream2.setBBox(pDAnnotationWidget.getRectangle().createRetranslatedRectangle());
                    appearance.setNormalAppearance(pDAppearanceStream2);
                    pDAppearanceStream = pDAppearanceStream2;
                }
                List<Object> streamTokens = getStreamTokens(pDAppearanceStream);
                PDFont fontAndUpdateResources = getFontAndUpdateResources(pDAppearanceStream);
                if (!containsMarkedContent(streamTokens)) {
                    createAppearanceContent(streamTokens, pDAnnotationWidget, fontAndUpdateResources, pDAppearanceStream);
                } else {
                    updateAppearanceContent(streamTokens, pDAnnotationWidget, fontAndUpdateResources, pDAppearanceStream);
                }
            }
        }
    }

    private List<Object> getStreamTokens(COSStream cOSStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cOSStream == null) {
            return arrayList;
        }
        PDFStreamParser pDFStreamParser = new PDFStreamParser(cOSStream);
        pDFStreamParser.parse();
        List<Object> tokens = pDFStreamParser.getTokens();
        pDFStreamParser.close();
        return tokens;
    }
}
