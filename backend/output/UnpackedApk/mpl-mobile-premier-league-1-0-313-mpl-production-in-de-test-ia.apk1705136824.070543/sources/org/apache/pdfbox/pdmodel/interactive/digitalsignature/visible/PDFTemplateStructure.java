package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTreeNode;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.util.awt.AffineTransform;

public class PDFTemplateStructure {
    public PDAcroForm acroForm;
    public COSDictionary acroFormDictionary;
    public List<PDFieldTreeNode> acroFormFields;
    public AffineTransform affineTransform;
    public PDAppearanceDictionary appearanceDictionary;
    public PDRectangle formaterRectangle;
    public PDFormXObject holderForm;
    public PDResources holderFormResources;
    public PDStream holderFormStream;
    public PDImageXObject image;
    public PDFormXObject imageForm;
    public COSName imageFormName;
    public PDResources imageFormResources;
    public PDStream imageFormStream;
    public COSName imageName;
    public PDFormXObject innerForm;
    public COSName innerFormName;
    public PDResources innerFormResources;
    public PDStream innterFormStream;
    public PDPage page;
    public PDSignature pdSignature;
    public COSArray procSet;
    public PDSignatureField signatureField;
    public PDRectangle singatureRectangle;
    public PDDocument template;
    public COSDocument visualSignature;
    public COSDictionary widgetDictionary;

    public PDAcroForm getAcroForm() {
        return this.acroForm;
    }

    public COSDictionary getAcroFormDictionary() {
        return this.acroFormDictionary;
    }

    public List<PDFieldTreeNode> getAcroFormFields() {
        return this.acroFormFields;
    }

    public AffineTransform getAffineTransform() {
        return this.affineTransform;
    }

    public PDAppearanceDictionary getAppearanceDictionary() {
        return this.appearanceDictionary;
    }

    public PDRectangle getFormaterRectangle() {
        return this.formaterRectangle;
    }

    public PDFormXObject getHolderForm() {
        return this.holderForm;
    }

    public PDResources getHolderFormResources() {
        return this.holderFormResources;
    }

    public PDStream getHolderFormStream() {
        return this.holderFormStream;
    }

    public PDImageXObject getImage() {
        return this.image;
    }

    public PDFormXObject getImageForm() {
        return this.imageForm;
    }

    public COSName getImageFormName() {
        return this.imageFormName;
    }

    public PDResources getImageFormResources() {
        return this.imageFormResources;
    }

    public PDStream getImageFormStream() {
        return this.imageFormStream;
    }

    public COSName getImageName() {
        return this.imageName;
    }

    public PDFormXObject getInnerForm() {
        return this.innerForm;
    }

    public COSName getInnerFormName() {
        return this.innerFormName;
    }

    public PDResources getInnerFormResources() {
        return this.innerFormResources;
    }

    public PDStream getInnterFormStream() {
        return this.innterFormStream;
    }

    public PDPage getPage() {
        return this.page;
    }

    public PDSignature getPdSignature() {
        return this.pdSignature;
    }

    public COSArray getProcSet() {
        return this.procSet;
    }

    public PDSignatureField getSignatureField() {
        return this.signatureField;
    }

    public PDRectangle getSingatureRectangle() {
        return this.singatureRectangle;
    }

    public PDDocument getTemplate() {
        return this.template;
    }

    public ByteArrayInputStream getTemplateAppearanceStream() throws IOException {
        COSDocument visualSignature2 = getVisualSignature();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new COSWriter(byteArrayOutputStream).write(visualSignature2);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        getTemplate().close();
        return byteArrayInputStream;
    }

    public COSDocument getVisualSignature() {
        return this.visualSignature;
    }

    public COSDictionary getWidgetDictionary() {
        return this.widgetDictionary;
    }

    public void setAcroForm(PDAcroForm pDAcroForm) {
        this.acroForm = pDAcroForm;
    }

    public void setAcroFormDictionary(COSDictionary cOSDictionary) {
        this.acroFormDictionary = cOSDictionary;
    }

    public void setAcroFormFields(List<PDFieldTreeNode> list) {
        this.acroFormFields = list;
    }

    public void setAffineTransform(AffineTransform affineTransform2) {
        this.affineTransform = affineTransform2;
    }

    public void setAppearanceDictionary(PDAppearanceDictionary pDAppearanceDictionary) {
        this.appearanceDictionary = pDAppearanceDictionary;
    }

    public void setFormaterRectangle(PDRectangle pDRectangle) {
        this.formaterRectangle = pDRectangle;
    }

    public void setHolderForm(PDFormXObject pDFormXObject) {
        this.holderForm = pDFormXObject;
    }

    public void setHolderFormResources(PDResources pDResources) {
        this.holderFormResources = pDResources;
    }

    public void setHolderFormStream(PDStream pDStream) {
        this.holderFormStream = pDStream;
    }

    public void setImage(PDImageXObject pDImageXObject) {
        this.image = pDImageXObject;
    }

    public void setImageForm(PDFormXObject pDFormXObject) {
        this.imageForm = pDFormXObject;
    }

    public void setImageFormName(COSName cOSName) {
        this.imageFormName = cOSName;
    }

    public void setImageFormResources(PDResources pDResources) {
        this.imageFormResources = pDResources;
    }

    public void setImageFormStream(PDStream pDStream) {
        this.imageFormStream = pDStream;
    }

    public void setImageName(COSName cOSName) {
        this.imageName = cOSName;
    }

    public void setInnerForm(PDFormXObject pDFormXObject) {
        this.innerForm = pDFormXObject;
    }

    public void setInnerFormName(COSName cOSName) {
        this.innerFormName = cOSName;
    }

    public void setInnerFormResources(PDResources pDResources) {
        this.innerFormResources = pDResources;
    }

    public void setInnterFormStream(PDStream pDStream) {
        this.innterFormStream = pDStream;
    }

    public void setPage(PDPage pDPage) {
        this.page = pDPage;
    }

    public void setPdSignature(PDSignature pDSignature) {
        this.pdSignature = pDSignature;
    }

    public void setProcSet(COSArray cOSArray) {
        this.procSet = cOSArray;
    }

    public void setSignatureField(PDSignatureField pDSignatureField) {
        this.signatureField = pDSignatureField;
    }

    public void setSignatureRectangle(PDRectangle pDRectangle) {
        this.singatureRectangle = pDRectangle;
    }

    public void setTemplate(PDDocument pDDocument) {
        this.template = pDDocument;
    }

    public void setVisualSignature(COSDocument cOSDocument) {
        this.visualSignature = cOSDocument;
    }

    public void setWidgetDictionary(COSDictionary cOSDictionary) {
        this.widgetDictionary = cOSDictionary;
    }
}
