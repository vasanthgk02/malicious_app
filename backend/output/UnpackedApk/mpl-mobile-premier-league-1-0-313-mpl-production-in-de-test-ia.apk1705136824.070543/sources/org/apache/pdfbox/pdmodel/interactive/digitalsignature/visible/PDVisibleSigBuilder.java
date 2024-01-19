package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.ui.ScreenshotShareReferral;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTreeNode;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.util.awt.AffineTransform;

public class PDVisibleSigBuilder implements PDFTemplateBuilder {
    public PDFTemplateStructure pdfStructure = new PDFTemplateStructure();

    public void appendRawCommands(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes("UTF-8"));
        outputStream.close();
    }

    public void closeTemplate(PDDocument pDDocument) throws IOException {
        pDDocument.close();
        this.pdfStructure.getTemplate().close();
    }

    public void createAcroForm(PDDocument pDDocument) {
        PDAcroForm pDAcroForm = new PDAcroForm(pDDocument);
        pDDocument.getDocumentCatalog().setAcroForm(pDAcroForm);
        this.pdfStructure.setAcroForm(pDAcroForm);
    }

    public void createAcroFormDictionary(PDAcroForm pDAcroForm, PDSignatureField pDSignatureField) throws IOException {
        List<PDFieldTreeNode> fields = pDAcroForm.getFields();
        COSDictionary dictionary = pDAcroForm.getDictionary();
        pDAcroForm.setSignaturesExist(true);
        pDAcroForm.setAppendOnly(true);
        dictionary.setDirect(true);
        fields.add(pDSignatureField);
        pDAcroForm.setDefaultAppearance("/sylfaen 0 Tf 0 g");
        this.pdfStructure.setAcroFormFields(fields);
        this.pdfStructure.setAcroFormDictionary(dictionary);
    }

    public void createAffineTransform(byte[] bArr) {
        AffineTransform affineTransform = new AffineTransform((double) bArr[0], (double) bArr[1], (double) bArr[2], (double) bArr[3], (double) bArr[4], (double) bArr[5]);
        this.pdfStructure.setAffineTransform(affineTransform);
    }

    public void createAppearanceDictionary(PDFormXObject pDFormXObject, PDSignatureField pDSignatureField) throws IOException {
        PDAppearanceDictionary pDAppearanceDictionary = new PDAppearanceDictionary();
        pDAppearanceDictionary.getCOSObject().setDirect(true);
        pDAppearanceDictionary.setNormalAppearance(new PDAppearanceStream(pDFormXObject.getCOSStream()));
        pDSignatureField.getWidget().setAppearance(pDAppearanceDictionary);
        this.pdfStructure.setAppearanceDictionary(pDAppearanceDictionary);
    }

    public void createFormaterRectangle(byte[] bArr) {
        PDRectangle pDRectangle = new PDRectangle();
        pDRectangle.setUpperRightX((float) bArr[0]);
        pDRectangle.setUpperRightY((float) bArr[1]);
        pDRectangle.setLowerLeftX((float) bArr[2]);
        pDRectangle.setLowerLeftY((float) bArr[3]);
        this.pdfStructure.setFormaterRectangle(pDRectangle);
    }

    public void createHolderForm(PDResources pDResources, PDStream pDStream, PDRectangle pDRectangle) {
        PDFormXObject pDFormXObject = new PDFormXObject(pDStream);
        pDFormXObject.setResources(pDResources);
        pDFormXObject.setBBox(pDRectangle);
        pDFormXObject.setFormType(1);
        this.pdfStructure.setHolderForm(pDFormXObject);
    }

    public void createHolderFormResources() {
        this.pdfStructure.setHolderFormResources(new PDResources());
    }

    public void createHolderFormStream(PDDocument pDDocument) {
        this.pdfStructure.setHolderFormStream(new PDStream(pDDocument));
    }

    public void createImageForm(PDResources pDResources, PDResources pDResources2, PDStream pDStream, PDRectangle pDRectangle, AffineTransform affineTransform, PDImageXObject pDImageXObject) throws IOException {
        PDFormXObject pDFormXObject = new PDFormXObject(pDStream);
        pDFormXObject.setBBox(pDRectangle);
        pDFormXObject.setMatrix(affineTransform);
        pDFormXObject.setResources(pDResources);
        pDFormXObject.setFormType(1);
        pDResources.getCOSObject().setDirect(true);
        COSName add = pDResources2.add(pDFormXObject, "n");
        COSName add2 = pDResources.add(pDImageXObject, ScreenshotShareReferral.IMAGE_ADDRESS);
        this.pdfStructure.setImageForm(pDFormXObject);
        this.pdfStructure.setImageFormName(add);
        this.pdfStructure.setImageName(add2);
    }

    public void createImageFormResources() {
        this.pdfStructure.setImageFormResources(new PDResources());
    }

    public void createImageFormStream(PDDocument pDDocument) {
        this.pdfStructure.setImageFormStream(new PDStream(pDDocument));
    }

    public void createInnerForm(PDResources pDResources, PDStream pDStream, PDRectangle pDRectangle) {
        PDFormXObject pDFormXObject = new PDFormXObject(pDStream);
        pDFormXObject.setResources(pDResources);
        pDFormXObject.setBBox(pDRectangle);
        pDFormXObject.setFormType(1);
        this.pdfStructure.setInnerForm(pDFormXObject);
    }

    public void createInnerFormResource() {
        this.pdfStructure.setInnerFormResources(new PDResources());
    }

    public void createInnerFormStream(PDDocument pDDocument) {
        this.pdfStructure.setInnterFormStream(new PDStream(pDDocument));
    }

    public void createPage(PDVisibleSignDesigner pDVisibleSignDesigner) {
        this.pdfStructure.setPage(new PDPage(new PDRectangle(pDVisibleSignDesigner.getPageWidth(), pDVisibleSignDesigner.getPageHeight())));
    }

    public void createProcSetArray() {
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) COSName.getPDFName("PDF"));
        cOSArray.add((COSBase) COSName.getPDFName("Text"));
        cOSArray.add((COSBase) COSName.getPDFName("ImageB"));
        cOSArray.add((COSBase) COSName.getPDFName("ImageC"));
        cOSArray.add((COSBase) COSName.getPDFName("ImageI"));
        this.pdfStructure.setProcSet(cOSArray);
    }

    public void createSignature(PDSignatureField pDSignatureField, PDPage pDPage, String str) throws IOException {
        PDSignature pDSignature = new PDSignature();
        pDSignatureField.setSignature(pDSignature);
        pDSignatureField.getWidget().setPage(pDPage);
        pDPage.getAnnotations().add(pDSignatureField.getWidget());
        pDSignature.setName(str);
        pDSignature.setByteRange(new int[]{0, 0, 0, 0});
        pDSignature.setContents(new byte[4096]);
        this.pdfStructure.setPdSignature(pDSignature);
    }

    public void createSignatureField(PDAcroForm pDAcroForm) throws IOException {
        this.pdfStructure.setSignatureField(new PDSignatureField(pDAcroForm));
    }

    public void createSignatureRectangle(PDSignatureField pDSignatureField, PDVisibleSignDesigner pDVisibleSignDesigner) throws IOException {
        PDRectangle pDRectangle = new PDRectangle();
        pDRectangle.setUpperRightX(pDVisibleSignDesigner.getWidth() + pDVisibleSignDesigner.getxAxis());
        pDRectangle.setUpperRightY(pDVisibleSignDesigner.getTemplateHeight() - pDVisibleSignDesigner.getyAxis());
        pDRectangle.setLowerLeftY((pDVisibleSignDesigner.getTemplateHeight() - pDVisibleSignDesigner.getyAxis()) - pDVisibleSignDesigner.getHeight());
        pDRectangle.setLowerLeftX(pDVisibleSignDesigner.getxAxis());
        pDSignatureField.getWidget().setRectangle(pDRectangle);
        this.pdfStructure.setSignatureRectangle(pDRectangle);
    }

    public void createTemplate(PDPage pDPage) throws IOException {
        PDDocument pDDocument = new PDDocument();
        pDDocument.addPage(pDPage);
        this.pdfStructure.setTemplate(pDDocument);
    }

    public void createVisualSignature(PDDocument pDDocument) {
        this.pdfStructure.setVisualSignature(pDDocument.getDocument());
    }

    public void createWidgetDictionary(PDSignatureField pDSignatureField, PDResources pDResources) throws IOException {
        COSDictionary dictionary = pDSignatureField.getWidget().getDictionary();
        dictionary.setNeedToBeUpdated(true);
        dictionary.setItem(COSName.DR, (COSBase) pDResources.getCOSObject());
        this.pdfStructure.setWidgetDictionary(dictionary);
    }

    public PDFTemplateStructure getStructure() {
        return this.pdfStructure;
    }

    public void injectAppearanceStreams(PDStream pDStream, PDStream pDStream2, PDStream pDStream3, COSName cOSName, COSName cOSName2, COSName cOSName3, PDVisibleSignDesigner pDVisibleSignDesigner) throws IOException {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("q 100 0 0 50 0 0 cm /");
        outline73.append(cOSName2.getName());
        outline73.append(" Do Q\n");
        String sb = outline73.toString();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("q 1 0 0 1 0 0 cm /");
        outline732.append(cOSName3.getName());
        outline732.append(" Do Q \n");
        String sb2 = outline732.toString();
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("q 1 0 0 1 0 0 cm /");
        outline733.append(cOSName.getName());
        outline733.append(" Do Q\n");
        String sb3 = outline733.toString();
        appendRawCommands(this.pdfStructure.getHolderFormStream().createOutputStream(), sb2);
        appendRawCommands(this.pdfStructure.getInnterFormStream().createOutputStream(), sb3);
        appendRawCommands(this.pdfStructure.getImageFormStream().createOutputStream(), sb);
    }

    public void injectProcSetArray(PDFormXObject pDFormXObject, PDPage pDPage, PDResources pDResources, PDResources pDResources2, PDResources pDResources3, COSArray cOSArray) {
        pDFormXObject.getResources().getCOSObject().setItem(COSName.PROC_SET, (COSBase) cOSArray);
        pDPage.getCOSObject().setItem(COSName.PROC_SET, (COSBase) cOSArray);
        pDResources.getCOSObject().setItem(COSName.PROC_SET, (COSBase) cOSArray);
        pDResources2.getCOSObject().setItem(COSName.PROC_SET, (COSBase) cOSArray);
        pDResources3.getCOSObject().setItem(COSName.PROC_SET, (COSBase) cOSArray);
    }

    public void insertInnerFormToHolerResources(PDFormXObject pDFormXObject, PDResources pDResources) {
        this.pdfStructure.setInnerFormName(pDResources.add(pDFormXObject, "FRM"));
    }
}
